package com.contoso.jkserializer;

import com.contoso.jkserializer.model.EventGridEvent;
import com.contoso.jkserializer.model.MediaJobCompletedEventData;
import com.microsoft.azure.serializer.AzureJacksonAdapter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class EventGridSubscriber {
    public static EventGridEvent[] DeserializeEvents(String requestContent) throws IOException {

        // The serialize-deserialize adapter used by "Azure SDK for Java" internally
        //
        AzureJacksonAdapter jacksonAdapter = new AzureJacksonAdapter();
        EventGridEvent[] eventGridEvents = jacksonAdapter.<EventGridEvent[]>deserialize(requestContent, EventGridEvent[].class);        //
        //
        for (EventGridEvent receivedEvent : eventGridEvents) {
            String dataStr = jacksonAdapter.serializeRaw(receivedEvent.data());
            //
            // EventType to EventData mapping is not defined in swagger hence use the lookup map
            //
            if (EventMappings.EventTypeToEventDataMapping.containsKey(receivedEvent.eventType())) {
                MediaJobCompletedEventData eventData = jacksonAdapter.<MediaJobCompletedEventData>deserialize(dataStr,
                        EventMappings.EventTypeToEventDataMapping.get(receivedEvent.eventType()));
                receivedEvent.withData(eventData);
            } else {
                System.out.println("EventTypeToEventDataMapping not found for the eventType:" + receivedEvent.eventType());
            }
        }
        //
        return eventGridEvents;
    }
}

class EventMappings {
    public static HashMap<String, Type> EventTypeToEventDataMapping = new HashMap<>();
    static {
        EventTypeToEventDataMapping.put("Microsoft.Media.JobCompleted", MediaJobCompletedEventData.class);
    }
}

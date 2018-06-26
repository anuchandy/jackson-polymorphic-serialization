package com.contoso.jkserializer;

import com.contoso.jkserializer.model.EventGridEvent;
import com.contoso.jkserializer.model.JobOutput;
import com.contoso.jkserializer.model.JobOutputAsset;
import com.contoso.jkserializer.model.JobOutputHttp;
import com.contoso.jkserializer.model.MediaJobCompletedEventData;
import sun.misc.IOUtils;

import java.io.IOException;

public class Main {
    public static void main( String[] args ) throws IOException {
        (new Main()).experiment();
    }

    public void  experiment() throws IOException {
        String payload = getSamplePayloadFromFile("payload1.json");
        EventGridEvent[] events = EventGridSubscriber.DeserializeEvents(payload);
        for (EventGridEvent receivedEvent : events) {
            if (receivedEvent.data() instanceof MediaJobCompletedEventData) {
                System.out.println("Received MediaJobCompletedEvent:");
                MediaJobCompletedEventData mediaJobCompletedEventData = (MediaJobCompletedEventData)receivedEvent.data();
                for (JobOutput output : mediaJobCompletedEventData.outputs()) {
                    if (output instanceof JobOutputHttp) {
                        JobOutputHttp httpOutput = (JobOutputHttp)output;
                        System.out.println("HTTP output: " + httpOutput.url());
                    } else if (output instanceof JobOutputAsset) {
                        JobOutputAsset assetOutput = (JobOutputAsset)output;
                        System.out.println("Asset output: " + assetOutput.assetName());
                    }
                }
            }
        }
    }

    private String getSamplePayloadFromFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            byte[] bytes = IOUtils.readFully(classLoader.getResourceAsStream(fileName), -1, true);
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

package com.contoso.jkserializer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class EventGridEvent {
    @JsonProperty(value = "topic")
    private String topic;

    @JsonProperty(value = "subject")
    private String subject;

    @JsonProperty(value = "eventType")
    private String eventType;

    @JsonProperty(value = "eventTime")
    private DateTime eventTime;

    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "data")
    private Object data;

    public String topic() {
        return this.topic;
    }

    public EventGridEvent withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String subject() {
        return this.subject;
    }

    public EventGridEvent withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String eventType() {
        return this.eventType;
    }

    public EventGridEvent withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public DateTime eventTime() {
        return this.eventTime;
    }

    public EventGridEvent withEventTime(DateTime eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public String id() {
        return this.id;
    }

    public EventGridEvent withEventTime(String id) {
        this.id = id;
        return this;
    }

    public Object data() {
        return this.data;
    }

    public EventGridEvent withData(Object data) {
        this.data = data;
        return this;
    }
}

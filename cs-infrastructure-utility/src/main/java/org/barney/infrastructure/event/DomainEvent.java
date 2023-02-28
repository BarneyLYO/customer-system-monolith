package org.barney.infrastructure.event;

import org.barney.infrastructure.utils.DistributedIDUtil;

import java.util.Date;

public abstract class DomainEvent {
    private static final String generateEventId() {
        return "Event " + DistributedIDUtil.getUUID();
    }

    private String eventId;
    private Date eventTime;

    public DomainEvent() {
        this.eventTime = new Date();
        this.eventId = generateEventId();
    }

    public String getEventId() {
        return eventId;
    }

    public Date getEventTime() {
        return eventTime;
    }
}

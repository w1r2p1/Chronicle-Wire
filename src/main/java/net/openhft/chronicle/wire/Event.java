/*
 * Copyright (c) 2016-2019 Chronicle Software Ltd
 */

package net.openhft.chronicle.wire;

import net.openhft.chronicle.bytes.BytesStore;

public interface Event<E extends Event<E>> extends Marshallable {
    BytesStore eventId();

    /**
     * A system-assigned unique identifier for this event.
     * @param eventId unique id
     * @return this
     */
    E eventId(CharSequence eventId);

    /**
     * @return The time at which the event which triggered this was generated
     * (e.g. the time an event generated externally to the system first entered the system).
     */
    long eventTime();

    E eventTime(long eventTime);

    E eventTimeNow();

    /**
     * Uodate event with new event name, updating event time to now if required
     * @param eventName name
     */
    default void updateEvent(String eventName) {
    }
}

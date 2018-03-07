package com.facebook.confirmation.task;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.growth.model.Contactpoint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PendingContactpointDeserializer.class)
@Immutable
/* compiled from: instagram_photo */
public class PendingContactpoint {
    @JsonProperty("pending_contactpoint")
    public final Contactpoint pendingContactpoint;
    @JsonProperty("timestamp")
    public final long timestamp;

    public PendingContactpoint() {
        this.pendingContactpoint = null;
        this.timestamp = 0;
    }

    public PendingContactpoint(Contactpoint contactpoint, long j) {
        this.pendingContactpoint = contactpoint;
        this.timestamp = j;
    }
}

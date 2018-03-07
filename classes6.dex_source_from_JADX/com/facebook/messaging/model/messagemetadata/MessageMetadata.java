package com.facebook.messaging.model.messagemetadata;

import android.os.Parcelable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/* compiled from: use_device_location */
public interface MessageMetadata extends Parcelable {

    /* compiled from: use_device_location */
    public interface Creator<T extends MessageMetadata> extends android.os.Parcelable.Creator<T> {
        T mo152a(JsonNode jsonNode);
    }

    ObjectNode mo153a();
}

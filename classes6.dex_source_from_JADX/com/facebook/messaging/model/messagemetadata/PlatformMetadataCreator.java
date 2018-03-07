package com.facebook.messaging.model.messagemetadata;

import android.os.Parcelable.Creator;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: used_back_button */
public interface PlatformMetadataCreator<T extends PlatformMetadata> extends Creator<T> {
    T mo149a(JsonNode jsonNode);
}

package com.facebook.messaging.model.messagemetadata;

import android.os.Parcelable;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: use_optimistic_posting */
public abstract class PlatformMetadata implements Parcelable {
    public abstract PlatformMetadataType mo150a();

    public abstract JsonNode mo151b();

    public int describeContents() {
        return 0;
    }
}

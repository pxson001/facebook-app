package com.facebook.messaging.model.messagemetadata;

import android.os.Parcel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: use_prefixed_location */
public class IgnoreForWebhookPlatformMetadata extends PlatformMetadata {
    public static final PlatformMetadataCreator<IgnoreForWebhookPlatformMetadata> CREATOR = new C00841();
    public final boolean f1937a;

    /* compiled from: use_prefixed_location */
    final class C00841 implements PlatformMetadataCreator<IgnoreForWebhookPlatformMetadata> {
        C00841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new IgnoreForWebhookPlatformMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new IgnoreForWebhookPlatformMetadata[i];
        }

        public final PlatformMetadata mo149a(JsonNode jsonNode) {
            return new IgnoreForWebhookPlatformMetadata(jsonNode.F());
        }
    }

    public IgnoreForWebhookPlatformMetadata(boolean z) {
        this.f1937a = z;
    }

    protected IgnoreForWebhookPlatformMetadata(Parcel parcel) {
        this.f1937a = parcel.readByte() != (byte) 0;
    }

    public final PlatformMetadataType mo150a() {
        return PlatformMetadataType.IGNORE_FOR_WEBHOOK;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f1937a ? 1 : 0));
    }

    public final JsonNode mo151b() {
        return BooleanNode.b(this.f1937a);
    }
}

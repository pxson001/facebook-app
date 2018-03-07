package com.facebook.messaging.business.commerce.model.retail;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_size */
public class ShipmentTrackingEvent implements CommerceBubbleModel {
    public static final Creator<ShipmentTrackingEvent> CREATOR = new C00701();
    @Nullable
    public final String f687a;
    @Nullable
    public final String f688b;
    public final long f689c;
    @Nullable
    public final String f690d;
    @Nullable
    public final RetailAddress f691e;
    @Nullable
    public final Shipment f692f;
    private final CommerceBubbleModelType f693g;

    /* compiled from: video_size */
    final class C00701 implements Creator<ShipmentTrackingEvent> {
        C00701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ShipmentTrackingEvent(parcel);
        }

        public final Object[] newArray(int i) {
            return new ShipmentTrackingEvent[i];
        }
    }

    public ShipmentTrackingEvent(ShipmentTrackingEventBuilder shipmentTrackingEventBuilder) {
        this.f693g = shipmentTrackingEventBuilder.f694a;
        this.f687a = shipmentTrackingEventBuilder.f695b;
        this.f688b = shipmentTrackingEventBuilder.f696c;
        this.f689c = shipmentTrackingEventBuilder.f697d;
        this.f690d = shipmentTrackingEventBuilder.f698e;
        this.f691e = shipmentTrackingEventBuilder.f699f;
        this.f692f = shipmentTrackingEventBuilder.f700g;
    }

    public ShipmentTrackingEvent(Parcel parcel) {
        this.f693g = CommerceBubbleModelType.getModelType(parcel.readInt());
        this.f687a = parcel.readString();
        this.f688b = parcel.readString();
        this.f689c = parcel.readLong();
        this.f690d = parcel.readString();
        this.f691e = (RetailAddress) parcel.readParcelable(RetailAddress.class.getClassLoader());
        this.f692f = (Shipment) parcel.readParcelable(Shipment.class.getClassLoader());
    }

    public final CommerceBubbleModelType mo75b() {
        return this.f693g;
    }

    public final String mo74a() {
        return this.f687a;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return this.f692f != null ? this.f692f.f668p : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f693g.getValue());
        parcel.writeString(this.f687a);
        parcel.writeString(this.f688b);
        parcel.writeLong(this.f689c);
        parcel.writeString(this.f690d);
        parcel.writeParcelable(this.f691e, i);
        parcel.writeParcelable(this.f692f, i);
    }
}

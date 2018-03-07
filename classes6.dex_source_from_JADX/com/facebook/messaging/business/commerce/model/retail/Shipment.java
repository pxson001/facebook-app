package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_tagging_info */
public class Shipment implements CommerceBubbleModel {
    public static final Creator<Shipment> CREATOR = new C00691();
    public final String f653a;
    @Nullable
    public final String f654b;
    public final String f655c;
    public final RetailCarrier f656d;
    @Nullable
    public final Uri f657e;
    public final long f658f;
    @Nullable
    public final String f659g;
    @Nullable
    public final RetailAddress f660h;
    @Nullable
    public final RetailAddress f661i;
    public final long f662j;
    @Nullable
    public final String f663k;
    public final long f664l;
    @Nullable
    public final String f665m;
    public final String f666n;
    @Nullable
    public final LogoImage f667o;
    public final ImmutableList<PlatformGenericAttachmentItem> f668p;
    public final ImmutableList<ShipmentTrackingEvent> f669q;

    /* compiled from: video_tagging_info */
    final class C00691 implements Creator<Shipment> {
        C00691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Shipment(parcel);
        }

        public final Object[] newArray(int i) {
            return new Shipment[i];
        }
    }

    public Shipment(ShipmentBuilder shipmentBuilder) {
        this.f653a = (String) Preconditions.checkNotNull(shipmentBuilder.f670a);
        this.f654b = shipmentBuilder.f671b;
        this.f655c = (String) Preconditions.checkNotNull(shipmentBuilder.f672c);
        this.f656d = (RetailCarrier) Preconditions.checkNotNull(shipmentBuilder.f673d);
        this.f657e = shipmentBuilder.f674e;
        this.f658f = shipmentBuilder.f675f;
        this.f659g = shipmentBuilder.f676g;
        this.f660h = shipmentBuilder.f677h;
        this.f661i = shipmentBuilder.f678i;
        this.f662j = shipmentBuilder.f679j;
        this.f663k = shipmentBuilder.f680k;
        this.f664l = shipmentBuilder.f681l;
        this.f665m = shipmentBuilder.f682m;
        this.f666n = (String) Preconditions.checkNotNull(shipmentBuilder.f683n);
        this.f667o = shipmentBuilder.f684o;
        Collection collection = shipmentBuilder.f685p;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f668p = ImmutableList.copyOf(collection);
        collection = shipmentBuilder.f686q;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        this.f669q = ImmutableList.copyOf(collection);
    }

    public Shipment(Parcel parcel) {
        this.f653a = parcel.readString();
        this.f654b = parcel.readString();
        this.f655c = parcel.readString();
        this.f656d = (RetailCarrier) parcel.readParcelable(RetailCarrier.class.getClassLoader());
        this.f657e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f658f = parcel.readLong();
        this.f659g = parcel.readString();
        this.f660h = (RetailAddress) parcel.readParcelable(RetailAddress.class.getClassLoader());
        this.f661i = (RetailAddress) parcel.readParcelable(RetailAddress.class.getClassLoader());
        this.f662j = parcel.readLong();
        this.f663k = parcel.readString();
        this.f664l = parcel.readLong();
        this.f665m = parcel.readString();
        this.f666n = parcel.readString();
        this.f667o = (LogoImage) parcel.readParcelable(LogoImage.class.getClassLoader());
        Collection readArrayList = parcel.readArrayList(PlatformGenericAttachmentItem.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f668p = ImmutableList.copyOf(readArrayList);
        readArrayList = parcel.readArrayList(ShipmentTrackingEvent.class.getClassLoader());
        if (readArrayList == null) {
            readArrayList = Collections.EMPTY_LIST;
        }
        this.f669q = ImmutableList.copyOf(readArrayList);
    }

    public final CommerceBubbleModelType mo75b() {
        return CommerceBubbleModelType.SHIPMENT;
    }

    public final String mo74a() {
        return this.f653a;
    }

    public final ImmutableList<PlatformGenericAttachmentItem> mo76c() {
        return this.f668p;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f653a);
        parcel.writeString(this.f654b);
        parcel.writeString(this.f655c);
        parcel.writeParcelable(this.f656d, i);
        parcel.writeParcelable(this.f657e, i);
        parcel.writeLong(this.f658f);
        parcel.writeString(this.f659g);
        parcel.writeParcelable(this.f660h, i);
        parcel.writeParcelable(this.f661i, i);
        parcel.writeLong(this.f662j);
        parcel.writeString(this.f663k);
        parcel.writeLong(this.f664l);
        parcel.writeString(this.f665m);
        parcel.writeString(this.f666n);
        parcel.writeParcelable(this.f667o, i);
        parcel.writeList(this.f668p);
        parcel.writeList(this.f669q);
    }
}

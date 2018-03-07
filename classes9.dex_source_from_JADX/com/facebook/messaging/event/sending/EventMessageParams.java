package com.facebook.messaging.event.sending;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.android.maps.model.LatLng;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.location.sending.LocationType;
import com.facebook.messaging.location.sending.NearbyPlace;
import java.util.Calendar;
import javax.annotation.Nullable;

/* compiled from: mShippingOptions */
public class EventMessageParams implements Parcelable {
    public static final Creator<EventMessageParams> CREATOR = new C12331();
    public String f11081a;
    public boolean f11082b;
    public Calendar f11083c;
    public Calendar f11084d;
    @Nullable
    public LatLng f11085e;
    @Nullable
    public NearbyPlace f11086f;
    public LocationType f11087g = LocationType.UNSET;

    /* compiled from: mShippingOptions */
    final class C12331 implements Creator<EventMessageParams> {
        C12331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventMessageParams[i];
        }
    }

    public EventMessageParams(Parcel parcel) {
        this.f11081a = parcel.readString();
        this.f11082b = ParcelUtil.a(parcel);
        this.f11083c = (Calendar) parcel.readSerializable();
        this.f11084d = (Calendar) parcel.readSerializable();
        this.f11087g = (LocationType) ParcelUtil.c(parcel, LocationType.class);
        this.f11085e = (LatLng) ParcelUtil.b(parcel, LatLng.class);
        this.f11086f = (NearbyPlace) ParcelUtil.b(parcel, NearbyPlace.class);
    }

    public final void m11473a(LatLng latLng) {
        m11472h();
        this.f11085e = latLng;
        this.f11087g = LocationType.PINNED_LOCATION;
    }

    public final void m11474a(NearbyPlace nearbyPlace) {
        m11472h();
        this.f11086f = nearbyPlace;
        this.f11087g = LocationType.NEARBY_PLACE;
    }

    private void m11472h() {
        this.f11085e = null;
        this.f11086f = null;
        this.f11087g = LocationType.UNSET;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11081a);
        ParcelUtil.a(parcel, this.f11082b);
        parcel.writeSerializable(this.f11083c);
        parcel.writeSerializable(this.f11084d);
        ParcelUtil.a(parcel, this.f11087g);
        parcel.writeParcelable(this.f11085e, i);
        parcel.writeParcelable(this.f11086f, i);
    }
}

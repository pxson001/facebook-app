package com.facebook.messaging.model.attribution;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: user_mark_profile_visited */
public class AttributionVisibility implements Parcelable {
    public static final Creator<AttributionVisibility> CREATOR = new C00811();
    public static final AttributionVisibility f1902a = newBuilder().m3266f().m3267h();
    public static final AttributionVisibility f1903b;
    public final boolean f1904c;
    public final boolean f1905d;
    public final boolean f1906e;
    public final boolean f1907f;
    public final boolean f1908g;

    /* compiled from: user_mark_profile_visited */
    final class C00811 implements Creator<AttributionVisibility> {
        C00811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AttributionVisibility(parcel);
        }

        public final Object[] newArray(int i) {
            return new AttributionVisibility[i];
        }
    }

    static {
        AttributionVisibilityBuilder newBuilder = newBuilder();
        newBuilder.f1909a = true;
        newBuilder.f1910b = true;
        newBuilder.f1911c = true;
        newBuilder.f1912d = true;
        newBuilder.f1913e = true;
        f1903b = newBuilder.m3267h();
    }

    public static AttributionVisibilityBuilder newBuilder() {
        return new AttributionVisibilityBuilder();
    }

    AttributionVisibility(AttributionVisibilityBuilder attributionVisibilityBuilder) {
        this.f1904c = attributionVisibilityBuilder.f1909a;
        this.f1905d = attributionVisibilityBuilder.f1910b;
        this.f1906e = attributionVisibilityBuilder.f1911c;
        this.f1907f = attributionVisibilityBuilder.f1912d;
        this.f1908g = attributionVisibilityBuilder.f1913e;
    }

    public AttributionVisibility(Parcel parcel) {
        this.f1904c = ParcelUtil.a(parcel);
        this.f1905d = ParcelUtil.a(parcel);
        this.f1906e = ParcelUtil.a(parcel);
        this.f1907f = ParcelUtil.a(parcel);
        this.f1908g = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f1904c);
        ParcelUtil.a(parcel, this.f1905d);
        ParcelUtil.a(parcel, this.f1906e);
        ParcelUtil.a(parcel, this.f1907f);
        ParcelUtil.a(parcel, this.f1908g);
    }
}

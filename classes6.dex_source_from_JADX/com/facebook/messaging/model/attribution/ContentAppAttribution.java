package com.facebook.messaging.model.attribution;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: user_latitude */
public class ContentAppAttribution implements Parcelable {
    public static final Creator<ContentAppAttribution> CREATOR = new C00821();
    @Nullable
    public final String f1914a;
    public final String f1915b;
    @Nullable
    public final String f1916c;
    @Nullable
    public final String f1917d;
    @Nullable
    public final String f1918e;
    @Nullable
    public final String f1919f;
    public final ImmutableMap<String, String> f1920g;
    public final AttributionVisibility f1921h;

    /* compiled from: user_latitude */
    final class C00821 implements Creator<ContentAppAttribution> {
        C00821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContentAppAttribution(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContentAppAttribution[i];
        }
    }

    ContentAppAttribution(ContentAppAttributionBuilder contentAppAttributionBuilder) {
        String trim;
        this.f1914a = contentAppAttributionBuilder.f1922a;
        this.f1915b = (String) Preconditions.checkNotNull(contentAppAttributionBuilder.f1923b);
        this.f1916c = contentAppAttributionBuilder.f1924c;
        if (contentAppAttributionBuilder.f1925d != null) {
            trim = contentAppAttributionBuilder.f1925d.trim();
        } else {
            trim = null;
        }
        this.f1917d = trim;
        this.f1918e = contentAppAttributionBuilder.f1926e;
        this.f1919f = contentAppAttributionBuilder.f1927f;
        this.f1920g = (ImmutableMap) Preconditions.checkNotNull(contentAppAttributionBuilder.f1928g);
        this.f1921h = (AttributionVisibility) Preconditions.checkNotNull(contentAppAttributionBuilder.f1929h);
    }

    public ContentAppAttribution(Parcel parcel) {
        this.f1914a = parcel.readString();
        this.f1915b = parcel.readString();
        this.f1916c = parcel.readString();
        this.f1917d = parcel.readString();
        this.f1918e = parcel.readString();
        this.f1919f = parcel.readString();
        Map c = Maps.c();
        ParcelUtil.b(parcel, c);
        this.f1920g = ImmutableMap.copyOf(c);
        this.f1921h = (AttributionVisibility) parcel.readParcelable(AttributionVisibility.class.getClassLoader());
    }

    public static ContentAppAttributionBuilder newBuilder() {
        return new ContentAppAttributionBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1914a);
        parcel.writeString(this.f1915b);
        parcel.writeString(this.f1916c);
        parcel.writeString(this.f1917d);
        parcel.writeString(this.f1918e);
        parcel.writeString(this.f1919f);
        ParcelUtil.a(parcel, this.f1920g);
        parcel.writeParcelable(this.f1921h, i);
    }
}

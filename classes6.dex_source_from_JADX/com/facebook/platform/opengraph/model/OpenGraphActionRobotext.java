package com.facebook.platform.opengraph.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: storefront_banner */
public class OpenGraphActionRobotext implements Parcelable {
    public static final Creator<OpenGraphActionRobotext> CREATOR = new C02241();
    public String f4100a;
    public List<Span> f4101b;

    /* compiled from: storefront_banner */
    final class C02241 implements Creator<OpenGraphActionRobotext> {
        C02241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OpenGraphActionRobotext(parcel);
        }

        public final Object[] newArray(int i) {
            return new OpenGraphActionRobotext[i];
        }
    }

    @AutoGenJsonDeserializer
    /* compiled from: storefront_banner */
    public class Span implements Parcelable {
        public static final Creator<Span> CREATOR = new C02251();
        @JsonProperty("length")
        private final int mLength;
        @JsonProperty("offset")
        public final int mOffset;

        /* compiled from: storefront_banner */
        final class C02251 implements Creator<Span> {
            C02251() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Span(parcel);
            }

            public final Object[] newArray(int i) {
                return new Span[i];
            }
        }

        public Span() {
            this(0, 0);
        }

        public Span(int i, int i2) {
            this.mOffset = i;
            this.mLength = i2;
        }

        public Span(Parcel parcel) {
            this.mOffset = parcel.readInt();
            this.mLength = parcel.readInt();
        }

        public final int m6015b() {
            return this.mOffset + this.mLength;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mOffset);
            parcel.writeInt(this.mLength);
        }
    }

    public OpenGraphActionRobotext() {
        this(null, null);
    }

    public OpenGraphActionRobotext(String str, List<Span> list) {
        this.f4100a = str;
        this.f4101b = list;
    }

    public OpenGraphActionRobotext(Parcel parcel) {
        this.f4100a = parcel.readString();
        this.f4101b = Lists.a();
        parcel.readList(this.f4101b, Span.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4100a);
        parcel.writeList(this.f4101b);
    }
}

package com.facebook.goodwill.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

/* compiled from: yyyyMMdd */
public class GoodwillPublishLifeEventParam implements Parcelable {
    public static final Creator<GoodwillPublishLifeEventParam> CREATOR = new C00201();
    public final String f149a;
    public final String f150b;
    public List<GoodwillPublishPhoto> f151c;
    public final String f152d;
    public final String f153e;
    public final String f154f;

    /* compiled from: yyyyMMdd */
    final class C00201 implements Creator<GoodwillPublishLifeEventParam> {
        C00201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GoodwillPublishLifeEventParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new GoodwillPublishLifeEventParam[i];
        }
    }

    /* compiled from: yyyyMMdd */
    public class Builder {
        public String f143a;
        public String f144b;
        public String f145c;
        public List<GoodwillPublishPhoto> f146d;
        public String f147e;
        public String f148f;
    }

    public GoodwillPublishLifeEventParam(Builder builder) {
        this.f149a = builder.f143a;
        this.f150b = builder.f144b;
        this.f151c = builder.f146d;
        this.f152d = builder.f147e;
        this.f153e = builder.f148f;
        this.f154f = builder.f145c;
    }

    public GoodwillPublishLifeEventParam(Parcel parcel) {
        this.f149a = parcel.readString();
        this.f150b = parcel.readString();
        this.f151c = parcel.readArrayList(GoodwillPublishPhoto.class.getClassLoader());
        this.f152d = parcel.readString();
        this.f153e = parcel.readString();
        this.f154f = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f149a);
        parcel.writeString(this.f150b);
        parcel.writeList(this.f151c);
        parcel.writeString(this.f152d);
        parcel.writeString(this.f153e);
        parcel.writeString(this.f154f);
    }

    public int describeContents() {
        return 0;
    }
}

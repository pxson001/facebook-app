package com.facebook.fbreact.goodwill;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: extra_should_enable_related_pages_like_chaining */
public class GoodwillVideoState implements Parcelable {
    public static final Creator<GoodwillVideoState> CREATOR = new C09261();
    public final String f7330a;
    public final String f7331b;
    public final ImmutableList<PhotoData> f7332c;
    public final String f7333d;

    /* compiled from: extra_should_enable_related_pages_like_chaining */
    final class C09261 implements Creator<GoodwillVideoState> {
        C09261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GoodwillVideoState(parcel);
        }

        public final Object[] newArray(int i) {
            return new GoodwillVideoState[i];
        }
    }

    /* compiled from: extra_should_enable_related_pages_like_chaining */
    public class PhotoData implements Parcelable {
        public static final Creator<PhotoData> CREATOR = new C09271();
        public final String f7326a;
        public final String f7327b;
        public final int f7328c;
        public final int f7329d;

        /* compiled from: extra_should_enable_related_pages_like_chaining */
        final class C09271 implements Creator<PhotoData> {
            C09271() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new PhotoData(parcel);
            }

            public final Object[] newArray(int i) {
                return new PhotoData[i];
            }
        }

        public PhotoData(String str, String str2, int i, int i2) {
            this.f7326a = str;
            this.f7327b = str2;
            this.f7328c = i;
            this.f7329d = i2;
        }

        public PhotoData(Parcel parcel) {
            this.f7326a = parcel.readString();
            this.f7327b = parcel.readString();
            this.f7328c = parcel.readInt();
            this.f7329d = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f7326a);
            parcel.writeString(this.f7327b);
            parcel.writeInt(this.f7328c);
            parcel.writeInt(this.f7329d);
        }

        public int describeContents() {
            return 0;
        }
    }

    public GoodwillVideoState(String str, String str2, ImmutableList<PhotoData> immutableList, String str3) {
        this.f7330a = str;
        this.f7331b = str2;
        this.f7332c = immutableList;
        this.f7333d = str3;
    }

    public GoodwillVideoState(Parcel parcel) {
        ImmutableList immutableList;
        this.f7330a = parcel.readString();
        this.f7331b = parcel.readString();
        Collection readArrayList = parcel.readArrayList(PhotoData.class.getClassLoader());
        if (readArrayList == null) {
            immutableList = RegularImmutableList.a;
        } else {
            immutableList = ImmutableList.copyOf(readArrayList);
        }
        this.f7332c = immutableList;
        this.f7333d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7330a);
        parcel.writeString(this.f7331b);
        parcel.writeList(this.f7332c);
        parcel.writeString(this.f7333d);
    }

    public int describeContents() {
        return 0;
    }
}

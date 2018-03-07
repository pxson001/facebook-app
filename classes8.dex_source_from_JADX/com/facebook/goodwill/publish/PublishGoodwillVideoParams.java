package com.facebook.goodwill.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: wrap */
public class PublishGoodwillVideoParams implements Parcelable {
    public static final Creator<PublishGoodwillVideoParams> CREATOR = new C00261();
    public final String f187a;
    public final String f188b;
    public final String f189c;
    public final String f190d;
    public final String f191e;
    public final String f192f;
    public final String f193g;
    public final String f194h;
    public final List<Long> f195i;
    public final List<GoodwillPublishPhoto> f196j;
    public final String f197k;

    /* compiled from: wrap */
    final class C00261 implements Creator<PublishGoodwillVideoParams> {
        C00261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PublishGoodwillVideoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PublishGoodwillVideoParams[i];
        }
    }

    public PublishGoodwillVideoParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ImmutableList<Long> immutableList, ImmutableList<GoodwillPublishPhoto> immutableList2, String str9) {
        this.f187a = str;
        this.f188b = str2;
        this.f189c = str3;
        this.f190d = str6;
        this.f191e = str7;
        this.f192f = str8;
        this.f193g = str4;
        this.f194h = str5;
        this.f195i = immutableList;
        this.f196j = immutableList2;
        this.f197k = str9;
    }

    public PublishGoodwillVideoParams(Parcel parcel) {
        this.f187a = parcel.readString();
        this.f188b = parcel.readString();
        this.f189c = parcel.readString();
        this.f190d = parcel.readString();
        this.f191e = parcel.readString();
        this.f192f = parcel.readString();
        this.f193g = parcel.readString();
        this.f194h = parcel.readString();
        this.f195i = new ArrayList();
        parcel.readList(this.f195i, null);
        this.f196j = new ArrayList();
        parcel.readTypedList(this.f196j, GoodwillPublishPhoto.CREATOR);
        this.f197k = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f187a);
        parcel.writeString(this.f188b);
        parcel.writeString(this.f189c);
        parcel.writeString(this.f190d);
        parcel.writeString(this.f191e);
        parcel.writeString(this.f192f);
        parcel.writeString(this.f193g);
        parcel.writeString(this.f194h);
        parcel.writeList(this.f195i);
        parcel.writeTypedList(this.f196j);
        parcel.writeString(this.f197k);
    }

    public int describeContents() {
        return 0;
    }
}

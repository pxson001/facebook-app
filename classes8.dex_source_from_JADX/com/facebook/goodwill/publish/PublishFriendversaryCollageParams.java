package com.facebook.goodwill.publish;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.composer.publish.common.PublishPostParams;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: write_review_publish */
public class PublishFriendversaryCollageParams implements Parcelable {
    public static final Creator<PublishFriendversaryCollageParams> CREATOR = new C00251();
    public final String f183a;
    public final String f184b;
    public final List<GoodwillPublishPhoto> f185c;
    public PublishPostParams f186d;

    /* compiled from: write_review_publish */
    final class C00251 implements Creator<PublishFriendversaryCollageParams> {
        C00251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PublishFriendversaryCollageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PublishFriendversaryCollageParams[i];
        }
    }

    public PublishFriendversaryCollageParams(String str, String str2, PublishPostParams publishPostParams, ImmutableList<GoodwillPublishPhoto> immutableList) {
        this.f183a = str;
        this.f184b = str2;
        this.f186d = publishPostParams;
        this.f185c = immutableList;
    }

    public PublishFriendversaryCollageParams(Parcel parcel) {
        this.f183a = parcel.readString();
        this.f184b = parcel.readString();
        this.f186d = (PublishPostParams) parcel.readParcelable(PublishPostParams.class.getClassLoader());
        this.f185c = new ArrayList();
        parcel.readTypedList(this.f185c, GoodwillPublishPhoto.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f183a);
        parcel.writeString(this.f184b);
        parcel.writeParcelable(this.f186d, i);
        parcel.writeTypedList(this.f185c);
    }

    public int describeContents() {
        return 0;
    }
}

package com.facebook.orca.compose;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: orca_friend_msg */
public class ContentSearchParams implements Parcelable {
    public static final Creator<ContentSearchParams> CREATOR = new C07771();
    public final ContentSearchType f5497a;
    public final String f5498b;
    public final boolean f5499c;
    public final String f5500d;

    /* compiled from: orca_friend_msg */
    final class C07771 implements Creator<ContentSearchParams> {
        C07771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ContentSearchParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ContentSearchParams[i];
        }
    }

    public ContentSearchParams(ContentSearchType contentSearchType, String str, boolean z, String str2) {
        this.f5497a = contentSearchType;
        this.f5498b = str;
        this.f5499c = z;
        this.f5500d = str2;
    }

    public ContentSearchParams(Parcel parcel) {
        this.f5499c = ((Boolean) parcel.readValue(null)).booleanValue();
        this.f5500d = parcel.readString();
        this.f5497a = (ContentSearchType) ParcelUtil.c(parcel, ContentSearchType.class);
        this.f5498b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Boolean.valueOf(this.f5499c));
        parcel.writeString(this.f5500d);
        ParcelUtil.a(parcel, this.f5497a);
        parcel.writeString(this.f5498b);
    }
}

package com.facebook.places.suggestions.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.base.Preconditions;

/* compiled from: search_source_type */
public class SuggestProfilePicParams implements Parcelable {
    public static final Creator<SuggestProfilePicParams> CREATOR = new C04871();
    public final long f3796a;
    public final PhotoItem f3797b;
    public final String f3798c;
    public final CrowdEntryPoint f3799d;
    public final CrowdEndpoint f3800e;

    /* compiled from: search_source_type */
    final class C04871 implements Creator<SuggestProfilePicParams> {
        C04871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SuggestProfilePicParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SuggestProfilePicParams[i];
        }
    }

    public SuggestProfilePicParams(long j, PhotoItem photoItem, CrowdsourcingSource crowdsourcingSource, CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
        this.f3796a = j;
        this.f3797b = (PhotoItem) Preconditions.checkNotNull(photoItem);
        this.f3798c = crowdsourcingSource == null ? null : crowdsourcingSource.toString();
        this.f3799d = crowdEntryPoint;
        this.f3800e = crowdEndpoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3796a);
        parcel.writeParcelable(this.f3797b, i);
        parcel.writeString(this.f3798c);
        parcel.writeString(this.f3799d.toString());
        parcel.writeString(this.f3800e.toString());
    }

    public SuggestProfilePicParams(Parcel parcel) {
        this.f3796a = parcel.readLong();
        this.f3797b = (PhotoItem) parcel.readParcelable(PhotoItem.class.getClassLoader());
        this.f3798c = parcel.readString();
        this.f3799d = CrowdEntryPoint.valueOf(parcel.readString());
        this.f3800e = CrowdEndpoint.valueOf(parcel.readString());
    }
}

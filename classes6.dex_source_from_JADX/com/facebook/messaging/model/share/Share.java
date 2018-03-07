package com.facebook.messaging.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.momentsinvite.model.MomentsInviteData;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload-video-chunk-settings */
public class Share implements Parcelable {
    public static final Creator<Share> CREATOR = new C01081();
    public final String f2182a;
    public final String f2183b;
    public final String f2184c;
    public final String f2185d;
    public final String f2186e;
    public final String f2187f;
    public final ImmutableList<ShareMedia> f2188g;
    public final ImmutableList<ShareProperty> f2189h;
    public final OpenGraphActionRobotext f2190i;
    public final String f2191j;
    public final String f2192k;
    public final CommerceData f2193l;
    public final MomentsInviteData f2194m;

    /* compiled from: upload-video-chunk-settings */
    final class C01081 implements Creator<Share> {
        C01081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Share(parcel);
        }

        public final Object[] newArray(int i) {
            return new Share[i];
        }
    }

    Share(ShareBuilder shareBuilder) {
        this.f2182a = shareBuilder.f2195a;
        this.f2183b = shareBuilder.f2196b;
        this.f2184c = shareBuilder.f2197c;
        this.f2185d = shareBuilder.f2198d;
        this.f2186e = shareBuilder.f2199e;
        this.f2188g = ImmutableList.copyOf(shareBuilder.f2201g);
        this.f2187f = shareBuilder.f2200f;
        this.f2189h = ImmutableList.copyOf(shareBuilder.f2202h);
        this.f2190i = shareBuilder.f2203i;
        this.f2191j = shareBuilder.f2204j;
        this.f2192k = shareBuilder.f2205k;
        this.f2193l = shareBuilder.f2206l;
        this.f2194m = shareBuilder.f2207m;
    }

    public Share(Parcel parcel) {
        this.f2182a = parcel.readString();
        this.f2183b = parcel.readString();
        this.f2184c = parcel.readString();
        this.f2185d = parcel.readString();
        this.f2186e = parcel.readString();
        this.f2188g = ImmutableList.copyOf(parcel.readArrayList(ShareMedia.class.getClassLoader()));
        this.f2187f = parcel.readString();
        this.f2189h = ImmutableList.copyOf(parcel.readArrayList(ShareProperty.class.getClassLoader()));
        this.f2190i = (OpenGraphActionRobotext) parcel.readParcelable(OpenGraphActionRobotext.class.getClassLoader());
        this.f2191j = parcel.readString();
        this.f2192k = parcel.readString();
        this.f2193l = (CommerceData) parcel.readParcelable(CommerceData.class.getClassLoader());
        this.f2194m = (MomentsInviteData) parcel.readParcelable(MomentsInviteData.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2182a);
        parcel.writeString(this.f2183b);
        parcel.writeString(this.f2184c);
        parcel.writeString(this.f2185d);
        parcel.writeString(this.f2186e);
        parcel.writeList(this.f2188g);
        parcel.writeString(this.f2187f);
        parcel.writeList(this.f2189h);
        parcel.writeParcelable(this.f2190i, i);
        parcel.writeString(this.f2191j);
        parcel.writeString(this.f2192k);
        parcel.writeParcelable(this.f2193l, i);
        parcel.writeParcelable(this.f2194m, i);
    }
}

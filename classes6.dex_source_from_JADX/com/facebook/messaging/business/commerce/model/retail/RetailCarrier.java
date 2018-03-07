package com.facebook.messaging.business.commerce.model.retail;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.business.attachments.model.LogoImage;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_transcode */
public class RetailCarrier implements Parcelable {
    public static final Creator<RetailCarrier> CREATOR = new C00681();
    public final String f645a;
    @Nullable
    public final LogoImage f646b;
    @Nullable
    public final Uri f647c;
    @Nullable
    public final String f648d;

    /* compiled from: video_transcode */
    final class C00681 implements Creator<RetailCarrier> {
        C00681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RetailCarrier(parcel);
        }

        public final Object[] newArray(int i) {
            return new RetailCarrier[i];
        }
    }

    public RetailCarrier(RetailCarrierBuilder retailCarrierBuilder) {
        this.f645a = (String) Preconditions.checkNotNull(retailCarrierBuilder.f649a);
        this.f646b = retailCarrierBuilder.f650b;
        this.f647c = retailCarrierBuilder.f651c;
        this.f648d = retailCarrierBuilder.f652d;
    }

    public RetailCarrier(Parcel parcel) {
        this.f645a = parcel.readString();
        this.f646b = (LogoImage) parcel.readParcelable(LogoImage.class.getClassLoader());
        this.f647c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f648d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f645a);
        parcel.writeParcelable(this.f646b, i);
        parcel.writeParcelable(this.f647c, i);
        parcel.writeString(this.f648d);
    }
}

package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: oom_score_adj */
public final class SharePhoto extends ShareMedia {
    public static final Creator<SharePhoto> CREATOR = new C06241();
    public final Bitmap f4604a;
    public final Uri f4605b;
    public final boolean f4606c;
    public final String f4607d;

    /* compiled from: oom_score_adj */
    final class C06241 implements Creator<SharePhoto> {
        C06241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SharePhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new SharePhoto[i];
        }
    }

    /* compiled from: oom_score_adj */
    public final class Builder extends com.facebook.share.model.ShareMedia.Builder<SharePhoto, Builder> {
        public Bitmap f4600a;
        public Uri f4601b;
        public boolean f4602c;
        public String f4603d;

        private Builder m5830a(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                return this;
            }
            Builder builder = (Builder) super.mo117a(sharePhoto);
            builder.f4600a = sharePhoto.f4604a;
            builder = builder;
            builder.f4601b = sharePhoto.f4605b;
            builder = builder;
            builder.f4602c = sharePhoto.f4606c;
            builder = builder;
            builder.f4603d = sharePhoto.f4607d;
            return builder;
        }

        public final Builder m5832a(Parcel parcel) {
            return m5830a((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }
    }

    public SharePhoto(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        this.f4604a = builder.f4600a;
        this.f4605b = builder.f4601b;
        this.f4606c = builder.f4602c;
        this.f4607d = builder.f4603d;
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        this.f4604a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f4605b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4606c = parcel.readByte() != (byte) 0;
        this.f4607d = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4604a, 0);
        parcel.writeParcelable(this.f4605b, 0);
        if (this.f4606c) {
            i2 = 1;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f4607d);
    }
}

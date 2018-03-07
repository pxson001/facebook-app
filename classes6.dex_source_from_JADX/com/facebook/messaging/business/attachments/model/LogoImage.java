package com.facebook.messaging.business.attachments.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: viewer_invite_to_group */
public class LogoImage implements Parcelable {
    public static final Creator<LogoImage> CREATOR = new C00591();
    @Nullable
    public final Uri f431a;
    public final int f432b;
    public final int f433c;

    /* compiled from: viewer_invite_to_group */
    final class C00591 implements Creator<LogoImage> {
        C00591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LogoImage(parcel);
        }

        public final Object[] newArray(int i) {
            return new LogoImage[i];
        }
    }

    public LogoImage(LogoImageBuilder logoImageBuilder) {
        this.f431a = logoImageBuilder.f434a;
        this.f432b = logoImageBuilder.f435b;
        this.f433c = logoImageBuilder.f436c;
    }

    public LogoImage(Parcel parcel) {
        this.f431a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f432b = parcel.readInt();
        this.f433c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f431a, i);
        parcel.writeInt(this.f432b);
        parcel.writeInt(this.f433c);
    }
}

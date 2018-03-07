package com.facebook.messaging.model.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: user_retry */
public class ImageUrl implements Parcelable {
    public static final Creator<ImageUrl> CREATOR = new C00791();
    public int f1892a;
    public int f1893b;
    public String f1894c;

    /* compiled from: user_retry */
    final class C00791 implements Creator<ImageUrl> {
        C00791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ImageUrl(parcel);
        }

        public final Object[] newArray(int i) {
            return new ImageUrl[i];
        }
    }

    public ImageUrl(UrlBuilder urlBuilder) {
        this.f1892a = urlBuilder.f1869a;
        this.f1893b = urlBuilder.f1870b;
        this.f1894c = urlBuilder.f1871c;
    }

    public ImageUrl(Parcel parcel) {
        this.f1892a = parcel.readInt();
        this.f1893b = parcel.readInt();
        this.f1894c = parcel.readString();
    }

    public String toString() {
        return this.f1892a + "x" + this.f1893b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1892a);
        parcel.writeInt(this.f1893b);
        parcel.writeString(this.f1894c);
    }
}

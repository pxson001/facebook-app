package com.facebook.messaging.model.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: variant_labels */
public class Attachment implements Parcelable {
    public static final Creator<Attachment> CREATOR = new C00751();
    public final String f1859a;
    public final String f1860b;
    public final String f1861c;
    public final String f1862d;
    public final String f1863e;
    public final int f1864f;
    public final ImageData f1865g;
    public final VideoData f1866h;
    public final AudioData f1867i;
    public final String f1868j;

    /* compiled from: variant_labels */
    final class C00751 implements Creator<Attachment> {
        C00751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Attachment(parcel);
        }

        public final Object[] newArray(int i) {
            return new Attachment[i];
        }
    }

    Attachment(AttachmentBuilder attachmentBuilder) {
        this.f1859a = attachmentBuilder.f1872a;
        this.f1860b = attachmentBuilder.f1873b;
        this.f1861c = attachmentBuilder.f1874c;
        this.f1862d = attachmentBuilder.f1875d;
        this.f1863e = attachmentBuilder.f1876e;
        this.f1864f = attachmentBuilder.f1877f;
        this.f1865g = attachmentBuilder.f1878g;
        this.f1866h = attachmentBuilder.f1879h;
        this.f1867i = attachmentBuilder.f1880i;
        this.f1868j = attachmentBuilder.f1881j;
    }

    public Attachment(Parcel parcel) {
        this.f1859a = parcel.readString();
        this.f1860b = parcel.readString();
        this.f1861c = parcel.readString();
        this.f1862d = parcel.readString();
        this.f1863e = parcel.readString();
        this.f1864f = parcel.readInt();
        this.f1865g = (ImageData) parcel.readParcelable(ImageData.class.getClassLoader());
        this.f1866h = (VideoData) parcel.readParcelable(VideoData.class.getClassLoader());
        this.f1867i = (AudioData) parcel.readParcelable(AudioData.class.getClassLoader());
        this.f1868j = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1859a);
        parcel.writeString(this.f1860b);
        parcel.writeString(this.f1861c);
        parcel.writeString(this.f1862d);
        parcel.writeString(this.f1863e);
        parcel.writeInt(this.f1864f);
        parcel.writeParcelable(this.f1865g, i);
        parcel.writeParcelable(this.f1866h, i);
        parcel.writeParcelable(this.f1867i, i);
        parcel.writeString(this.f1868j);
    }
}

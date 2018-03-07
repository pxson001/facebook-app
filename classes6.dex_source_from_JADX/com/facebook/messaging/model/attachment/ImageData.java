package com.facebook.messaging.model.attachment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: user_selected_tags */
public class ImageData implements Parcelable {
    public static final Creator<ImageData> CREATOR = new C00781();
    public final int f1885a;
    public final int f1886b;
    public final AttachmentImageMap f1887c;
    public final AttachmentImageMap f1888d;
    public final Source f1889e;
    public final boolean f1890f;
    public final String f1891g;

    /* compiled from: user_selected_tags */
    final class C00781 implements Creator<ImageData> {
        C00781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ImageData[i];
        }
    }

    /* compiled from: user_selected_tags */
    public enum Source {
        NONQUICKCAM(1, "FILE_ATTACHMENT"),
        QUICKCAM(2, "MESSENGER_CAM");
        
        public final String apiStringValue;
        public final int intValue;

        private Source(int i, String str) {
            this.intValue = i;
            this.apiStringValue = str;
        }

        public static Source fromIntVal(int i) {
            if (i == QUICKCAM.intValue) {
                return QUICKCAM;
            }
            return NONQUICKCAM;
        }
    }

    public ImageData(int i, int i2, AttachmentImageMap attachmentImageMap, AttachmentImageMap attachmentImageMap2, Source source, boolean z, String str) {
        this.f1885a = i;
        this.f1886b = i2;
        this.f1887c = attachmentImageMap;
        this.f1888d = attachmentImageMap2;
        this.f1889e = source;
        this.f1890f = z;
        this.f1891g = str;
    }

    public ImageData(Parcel parcel) {
        this.f1885a = parcel.readInt();
        this.f1886b = parcel.readInt();
        this.f1887c = (AttachmentImageMap) parcel.readParcelable(AttachmentImageMap.class.getClassLoader());
        this.f1888d = (AttachmentImageMap) parcel.readParcelable(AttachmentImageMap.class.getClassLoader());
        this.f1889e = Source.valueOf(parcel.readString());
        this.f1890f = parcel.readInt() == 1;
        this.f1891g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1885a);
        parcel.writeInt(this.f1886b);
        parcel.writeParcelable(this.f1887c, i);
        parcel.writeParcelable(this.f1888d, i);
        parcel.writeString(this.f1889e.name());
        parcel.writeInt(this.f1890f ? 1 : 0);
        parcel.writeString(this.f1891g);
    }
}

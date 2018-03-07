package com.facebook.localcontent.menus;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaItem;

/* compiled from: ec_config_begin */
public class PhotoMenuUploadItemModel implements Parcelable {
    public static final Creator<PhotoMenuUploadItemModel> CREATOR = new C16361();
    public MediaItem f15038a;
    public int f15039b;
    public int f15040c;
    public String f15041d;

    /* compiled from: ec_config_begin */
    final class C16361 implements Creator<PhotoMenuUploadItemModel> {
        C16361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoMenuUploadItemModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoMenuUploadItemModel[i];
        }
    }

    public PhotoMenuUploadItemModel(MediaItem mediaItem) {
        this.f15038a = mediaItem;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.f15038a.e(), options);
        this.f15039b = options.outWidth;
        this.f15040c = options.outHeight;
    }

    protected PhotoMenuUploadItemModel(Parcel parcel) {
        this.f15038a = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        this.f15039b = parcel.readInt();
        this.f15040c = parcel.readInt();
        this.f15041d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15038a, i);
        parcel.writeInt(this.f15039b);
        parcel.writeInt(this.f15040c);
        parcel.writeString(this.f15041d);
    }
}

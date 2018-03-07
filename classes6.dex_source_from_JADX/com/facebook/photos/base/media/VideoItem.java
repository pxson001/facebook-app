package com.facebook.photos.base.media;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaItem;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: initial_sticker_data */
public class VideoItem extends MediaItem {
    public static final Creator<VideoItem> CREATOR = new C08031();
    private final String f12741c;
    public final long f12742d;

    /* compiled from: initial_sticker_data */
    final class C08031 implements Creator<VideoItem> {
        C08031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoItem[i];
        }
    }

    VideoItem(MediaItemFactory$VideoItemBuilder mediaItemFactory$VideoItemBuilder) {
        super(mediaItemFactory$VideoItemBuilder.f12729e, mediaItemFactory$VideoItemBuilder.f12725a, mediaItemFactory$VideoItemBuilder.f12726b, mediaItemFactory$VideoItemBuilder.f12730f);
        this.f12741c = mediaItemFactory$VideoItemBuilder.f12727c;
        this.f12742d = mediaItemFactory$VideoItemBuilder.f12728d;
    }

    public VideoItem(Parcel parcel) {
        super(parcel);
        this.f12741c = parcel.readString();
        this.f12742d = parcel.readLong();
    }

    public final long m20120r() {
        return this.f12742d;
    }

    @Nullable
    public final Uri m20121s() {
        if (Strings.isNullOrEmpty(this.f12741c)) {
            return null;
        }
        return Uri.parse(this.f12741c);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f12741c);
        parcel.writeLong(this.f12742d);
    }
}

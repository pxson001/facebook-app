package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;

/* compiled from: viewer_coordinates */
public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C00141();
    private static final ArrayMap<String, Integer> f246a;
    private final Bundle f247b;

    /* compiled from: viewer_coordinates */
    final class C00141 implements Creator<MediaMetadataCompat> {
        C00141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f246a = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f246a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f246a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f246a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f246a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f246a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f246a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f246a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f246a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f246a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f246a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f246a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f246a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f246a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f246a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f246a.put("android.media.metadata.ART", Integer.valueOf(2));
        f246a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f246a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f246a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f246a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f246a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f246a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f246a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f246a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f246a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f246a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f247b = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f247b);
    }
}

package com.facebook.ipc.media;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.google.common.base.Objects;
import java.util.Comparator;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: THIRD_PARTY_APP_VIA_FB_API */
public abstract class MediaItem implements Parcelable {
    @Deprecated
    public static final String f14082a = MimeType.f14117d.toString();
    public static final Comparator<MediaItem> f14083b = new DateCreatedComparator();
    public LocalMediaData f14084c;
    private final long f14085d;
    public long f14086e;
    @Nullable
    public String f14087f;

    /* compiled from: THIRD_PARTY_APP_VIA_FB_API */
    /* synthetic */ class C13501 {
        static final /* synthetic */ int[] f14081a = new int[Type.values().length];

        static {
            try {
                f14081a[Type.Photo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14081a[Type.Video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: THIRD_PARTY_APP_VIA_FB_API */
    class DateCreatedComparator implements Comparator<MediaItem> {
        public int compare(Object obj, Object obj2) {
            return Long.signum(((MediaItem) obj2).m23460j() - ((MediaItem) obj).m23460j());
        }
    }

    /* compiled from: THIRD_PARTY_APP_VIA_FB_API */
    public enum MediaType {
        PHOTO,
        VIDEO,
        UNKNOWN
    }

    protected MediaItem(LocalMediaData localMediaData, long j, long j2, String str) {
        this.f14084c = localMediaData;
        this.f14085d = j;
        this.f14086e = j2;
        this.f14087f = str;
    }

    public final LocalMediaData m23451a() {
        return this.f14084c;
    }

    @Deprecated
    public final long m23453c() {
        return this.f14084c.mMediaStoreId;
    }

    public final String m23458h() {
        return this.f14084c.mDisplayName;
    }

    public final long m23460j() {
        return this.f14084c.mDateTaken;
    }

    public final MediaData m23452b() {
        return this.f14084c.mo1281b();
    }

    @Deprecated
    public final MediaIdKey m23454d() {
        return new MediaIdKey(m23455e(), this.f14084c.mMediaStoreId);
    }

    @Nullable
    public final String m23455e() {
        Uri uri = m23452b().mUri;
        if (Uri.EMPTY.equals(uri)) {
            return null;
        }
        if (UriUtil.a(uri)) {
            return uri.toString();
        }
        return uri.getPath();
    }

    public final Uri m23456f() {
        return m23452b().mUri;
    }

    public final int m23457g() {
        return m23452b().mOrientation;
    }

    @Deprecated
    public final String m23459i() {
        return m23452b().mMimeType.toString();
    }

    public final float m23461k() {
        return m23452b().mAspectRatio;
    }

    @Deprecated
    public final MediaType m23462l() {
        return m23450b(m23452b().mMimeType.toString());
    }

    @Deprecated
    public final MediaType m23463m() {
        switch (C13501.f14081a[m23452b().mType.ordinal()]) {
            case 1:
                return MediaType.PHOTO;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return MediaType.VIDEO;
            default:
                BLog.b("MediaItem", "MediaItem.getType: unexpected source type %s", new Object[]{m23452b().mType});
                return MediaType.UNKNOWN;
        }
    }

    public final long m23464n() {
        return this.f14085d;
    }

    @Deprecated
    public final long m23465o() {
        return this.f14086e;
    }

    @Deprecated
    public final boolean m23466p() {
        return this.f14086e > 0;
    }

    public final String m23467q() {
        return this.f14087f;
    }

    public String toString() {
        return String.format(Locale.US, "MediaItem(%s)", new Object[]{this.f14084c.toString()});
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaItem) && Objects.equal(((MediaItem) obj).m23455e(), m23455e());
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{m23455e()});
    }

    @Deprecated
    public static MediaType m23450b(@Nullable String str) {
        if (str == null) {
            return MediaType.UNKNOWN;
        }
        if (MediaUtils.m19094a(str)) {
            return MediaType.PHOTO;
        }
        if (MediaUtils.m19095b(str)) {
            return MediaType.VIDEO;
        }
        BLog.b("MediaItem", "Unsupported mimeType %s", new Object[]{str});
        return MediaType.UNKNOWN;
    }

    public int describeContents() {
        return 0;
    }

    protected MediaItem(Parcel parcel) {
        this.f14084c = (LocalMediaData) parcel.readParcelable(LocalMediaData.class.getClassLoader());
        this.f14085d = parcel.readLong();
        this.f14086e = parcel.readLong();
        this.f14087f = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f14084c, i);
        parcel.writeLong(this.f14085d);
        parcel.writeLong(this.f14086e);
        parcel.writeString(this.f14087f);
    }
}

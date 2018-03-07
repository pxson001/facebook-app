package com.facebook.photos.base.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gif.abtest.ExperimentsForAnimatedGifAbTestModule;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.facebook.spherical.photo.utils.SphericalPhotoMetadataUtil;
import com.facebook.spherical.photo.utils.SphericalPhotoMetadataUtil.SphericalProps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.io.File;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: injected-cacheid- */
public class MediaItemCursorUtil {
    private static final String[] f12705a = new String[]{"_id", "_data", "mime_type", "_display_name", "width", "height", "datetaken", "latitude", "longitude", "mini_thumb_magic", "orientation"};
    private static final String[] f12706b = new String[]{"_id", "_data", "mime_type", "_display_name", "width", "height", "datetaken", "latitude", "longitude", "mini_thumb_magic", "duration"};
    private final ContentResolver f12707c;
    private final Lazy<FbErrorReporter> f12708d;
    private final QeAccessor f12709e;
    private final Photos360QEHelper f12710f;
    public final Lazy<BitmapUtils> f12711g;

    /* compiled from: injected-cacheid- */
    class MediaCorruptException extends RuntimeException {
        public MediaCorruptException(Throwable th) {
            super(th);
        }
    }

    /* compiled from: injected-cacheid- */
    class MediaItemCursorIterator extends UnmodifiableIterator<MediaItem> {
        final /* synthetic */ MediaItemCursorUtil f12702a;
        private final Cursor f12703b;
        private boolean f12704c = this.f12703b.moveToFirst();

        public MediaItemCursorIterator(MediaItemCursorUtil mediaItemCursorUtil, Cursor cursor) {
            this.f12702a = mediaItemCursorUtil;
            this.f12703b = cursor;
        }

        public boolean hasNext() {
            return this.f12704c;
        }

        @Nullable
        public Object next() {
            if (this.f12704c) {
                MediaItem b = this.f12702a.m20092b(this.f12703b);
                this.f12704c = this.f12703b.moveToNext();
                return b;
            }
            throw new NoSuchElementException("MediaItemCursorIterator");
        }
    }

    /* compiled from: injected-cacheid- */
    class MissingPathException extends RuntimeException {
    }

    public static MediaItemCursorUtil m20086b(InjectorLike injectorLike) {
        return new MediaItemCursorUtil(ContentResolverMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Photos360QEHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 406));
    }

    @Inject
    public MediaItemCursorUtil(ContentResolver contentResolver, Lazy<FbErrorReporter> lazy, QeAccessor qeAccessor, Photos360QEHelper photos360QEHelper, Lazy<BitmapUtils> lazy2) {
        this.f12707c = contentResolver;
        this.f12708d = lazy;
        this.f12709e = qeAccessor;
        this.f12710f = photos360QEHelper;
        this.f12711g = lazy2;
    }

    @Nullable
    public final Cursor m20089a(Uri uri, String str, String[] strArr) {
        try {
            return this.f12707c.query(uri, f12705a, str, strArr, "");
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f12708d.get()).a("MediaItemCursorUtil", "createImageCursor: error creating cursor", e);
            return null;
        }
    }

    @Nullable
    public final Cursor m20091b(Uri uri, String str, String[] strArr) {
        try {
            return this.f12707c.query(uri, f12706b, str, strArr, "");
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f12708d.get()).a("MediaItemCursorUtil", "createVideoCursor: error creating cursor", e);
            return null;
        }
    }

    public final UnmodifiableIterator<MediaItem> m20090a(Cursor cursor) {
        return new MediaItemCursorIterator(this, cursor);
    }

    @Nullable
    public final MediaItem m20092b(Cursor cursor) {
        MimeType a = MimeType.a(cursor.getString(cursor.getColumnIndex("mime_type")));
        if (MediaUtils.b(a.mRawType)) {
            return m20087b(a, cursor);
        }
        return m20081a(a, cursor);
    }

    @Nullable
    private MediaItem m20081a(MimeType mimeType, Cursor cursor) {
        try {
            LocalMediaData a = m20082a(cursor.getLong(0), mimeType, cursor);
            if (a.b().b() == Type.Video) {
                return new MediaItemFactory$VideoItemBuilder().m20104a(a).m20103a(cursor.getLong(9)).m20105a();
            }
            MediaItemFactory$PhotoItemBuilder a2 = new MediaItemFactory$PhotoItemBuilder().m20095a(a).m20094a(cursor.getLong(9));
            if (this.f12710f.i()) {
                SphericalProps a3 = SphericalPhotoMetadataUtil.m7707a(a.b().c().getPath());
                if (a3.m7705a()) {
                    a2.m20097a(true);
                    a2.m20096a(a3.m7706b());
                }
                a2.m20100b(true);
            }
            return a2.m20098a();
        } catch (Throwable e) {
            ((AbstractFbErrorReporter) this.f12708d.get()).a("MediaItemCursorUtil", "createAsPhotoItem", e);
            return null;
        } catch (Throwable e2) {
            ((AbstractFbErrorReporter) this.f12708d.get()).b("MediaItemCursorUtil", "createAsPhotoItem", e2);
            return null;
        }
    }

    private LocalMediaData m20082a(long j, MimeType mimeType, Cursor cursor) {
        Type type = (MimeType.d.equals(mimeType) && this.f12709e.a(ExperimentsForAnimatedGifAbTestModule.a, false)) ? Type.Video : Type.Photo;
        String string = cursor.getString(1);
        if (StringUtil.a(string)) {
            throw new MissingPathException();
        }
        int i = cursor.getInt(10);
        Dimension c = m20088c(cursor);
        if (c == null) {
            this.f12711g.get();
            c = BitmapUtils.a(string);
        }
        return m20083a(type, j, string, mimeType, i, c, cursor);
    }

    private static LocalMediaData m20083a(Type type, long j, String str, MimeType mimeType, int i, Dimension dimension, Cursor cursor) {
        Builder a = new Builder().a(new MediaIdKey(str, j).toString()).a(type).a(Uri.fromFile(new File(str))).a(mimeType);
        a.e = i;
        a = a;
        a.f = dimension.b;
        a = a;
        a.g = dimension.a;
        a = a;
        a.h = MediaAspectRatioUtil.m20078a(dimension.b, dimension.a, i);
        LocalMediaData.Builder a2 = new LocalMediaData.Builder().a(a.a(cursor.getDouble(7)).b(cursor.getDouble(8)).a());
        a2.b = cursor.getLong(6);
        a2 = a2;
        a2.d = j;
        a2 = a2;
        String string = cursor.getString(3);
        if (string != null) {
            a2.a(string);
        }
        return a2.a();
    }

    @Nullable
    private Dimension m20088c(Cursor cursor) {
        if (VERSION.SDK_INT >= 16) {
            try {
                int i = cursor.getInt(4);
                int i2 = cursor.getInt(5);
                return (i == 0 || i2 == 0) ? null : new Dimension(i, i2);
            } catch (Throwable th) {
                ((AbstractFbErrorReporter) this.f12708d.get()).a("MediaItemCursorUtil", "getDimensionsFromMediaStore failed", th);
            }
        }
        return null;
    }

    @Nullable
    private VideoItem m20087b(MimeType mimeType, Cursor cursor) {
        Throwable e;
        try {
            return new MediaItemFactory$VideoItemBuilder().m20104a(m20085b(cursor.getLong(0), mimeType, cursor)).m20103a(cursor.getLong(9)).m20106b(cursor.getLong(10)).m20105a();
        } catch (MediaCorruptException e2) {
            e = e2;
            BLog.b("MediaItemCursorUtil", "createAsVideoItem", e);
            return null;
        } catch (MissingPathException e3) {
            e = e3;
            BLog.b("MediaItemCursorUtil", "createAsVideoItem", e);
            return null;
        } catch (Throwable e4) {
            ((AbstractFbErrorReporter) this.f12708d.get()).b("MediaItemCursorUtil", "createAsVideoItem", e4);
            return null;
        }
    }

    private LocalMediaData m20085b(long j, MimeType mimeType, Cursor cursor) {
        String string = cursor.getString(1);
        if (StringUtil.a(string)) {
            throw new MissingPathException();
        }
        Dimension c = m20088c(cursor);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(string);
            int b = m20084b(mediaMetadataRetriever.extractMetadata(24));
            if (c == null) {
                c = m20080a(mediaMetadataRetriever);
            }
            mediaMetadataRetriever.release();
            return m20083a(Type.Video, j, string, mimeType, b, c, cursor);
        } catch (Throwable e) {
            throw new MediaCorruptException(e);
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
        }
    }

    private static Dimension m20080a(MediaMetadataRetriever mediaMetadataRetriever) {
        return new Dimension(m20084b(mediaMetadataRetriever.extractMetadata(18)), m20084b(mediaMetadataRetriever.extractMetadata(19)));
    }

    private static int m20084b(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        Integer a = Ints.a(str);
        if (a != null) {
            return a.intValue();
        }
        return 0;
    }
}

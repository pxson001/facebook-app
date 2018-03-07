package com.facebook.photos.base.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import com.facebook.proxygen.HTTPTransportCallback;
import java.io.File;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: moments/upsell */
public class MediaItemFactory {
    private static final String f13346a = MediaItemFactory.class.getSimpleName();
    private static final String[] f13347b = new String[]{"mediaprovider_uri"};
    private final Lazy<ContentResolver> f13348c;
    private final Lazy<BitmapUtils> f13349d;
    private final Lazy<MediaItemCursorUtil> f13350e;

    @javax.annotation.Nullable
    public final com.facebook.ipc.media.MediaItem m19673a(android.net.Uri r9, com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId r10, com.facebook.photos.base.media.MediaItemFactory.Storage r11) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = 1;
        r2 = 0;
        if (r9 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = com.facebook.common.util.UriUtil.m18789b(r9);
        if (r3 == 0) goto L_0x0036;
    L_0x000c:
        r0 = r9.getPath();
        r0 = r8.m19660a(r0, r11);
        r4 = r0;
    L_0x0015:
        if (r4 == 0) goto L_0x001d;
    L_0x0017:
        r0 = r4.moveToFirst();	 Catch:{ all -> 0x0071 }
        if (r0 != 0) goto L_0x0054;	 Catch:{ all -> 0x0071 }
    L_0x001d:
        r6 = r10.getValue();	 Catch:{ all -> 0x0071 }
        r3 = r8.m19662a(r9, r6);	 Catch:{ all -> 0x0071 }
        if (r4 == 0) goto L_0x0034;
    L_0x0027:
        r0 = r4.isClosed();
        if (r0 != 0) goto L_0x0052;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        com.google.common.base.Preconditions.checkState(r0);
        r4.close();
    L_0x0034:
        r0 = r3;
        goto L_0x0005;
    L_0x0036:
        r3 = com.facebook.common.util.UriUtil.m18790c(r9);
        if (r3 == 0) goto L_0x0042;
    L_0x003c:
        r0 = r8.m19669c(r9);
        r4 = r0;
        goto L_0x0015;
    L_0x0042:
        r1 = f13346a;
        r2 = "Unsupported URI scheme of %s. Supported schemes are 'file' and 'content'";
        r3 = r9.getScheme();
        r2 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r2, r3);
        com.facebook.debug.log.BLog.b(r1, r2);
        goto L_0x0005;
    L_0x0052:
        r0 = r2;
        goto L_0x002e;
    L_0x0054:
        r0 = r8.f13350e;	 Catch:{  }
        r0 = r0.get();	 Catch:{  }
        r0 = (com.facebook.photos.base.media.MediaItemCursorUtil) r0;	 Catch:{  }
        r0 = r0.b(r4);	 Catch:{  }
        if (r4 == 0) goto L_0x0005;
    L_0x0062:
        r3 = r4.isClosed();
        if (r3 != 0) goto L_0x006f;
    L_0x0068:
        com.google.common.base.Preconditions.checkState(r1);
        r4.close();
        goto L_0x0005;
    L_0x006f:
        r1 = r2;
        goto L_0x0068;
    L_0x0071:
        r0 = move-exception;
        if (r4 == 0) goto L_0x0080;
    L_0x0074:
        r3 = r4.isClosed();
        if (r3 != 0) goto L_0x0081;
    L_0x007a:
        com.google.common.base.Preconditions.checkState(r1);
        r4.close();
    L_0x0080:
        throw r0;
    L_0x0081:
        r1 = r2;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.base.media.MediaItemFactory.a(android.net.Uri, com.facebook.photos.base.media.MediaItemFactory$FallbackMediaId, com.facebook.photos.base.media.MediaItemFactory$Storage):com.facebook.ipc.media.MediaItem");
    }

    public static MediaItemFactory m19668b(InjectorLike injectorLike) {
        return new MediaItemFactory(IdBasedLazy.m1808a(injectorLike, 406), IdBasedLazy.m1808a(injectorLike.getApplicationInjector(), 22), IdBasedLazy.m1808a(injectorLike, 9264));
    }

    public static MediaItemFactory m19663a(InjectorLike injectorLike) {
        return m19668b(injectorLike);
    }

    @Inject
    public MediaItemFactory(Lazy<BitmapUtils> lazy, @NeedsApplicationInjector Lazy<ContentResolver> lazy2, Lazy<MediaItemCursorUtil> lazy3) {
        this.f13349d = lazy;
        this.f13348c = lazy2;
        this.f13350e = lazy3;
    }

    public static boolean m19664a(Uri uri) {
        return UriUtil.m18789b(uri) || UriUtil.m18790c(uri);
    }

    @Deprecated
    public static Uri m19667b(String str) {
        Uri parse = Uri.parse(str);
        return UriUtil.m18788a(parse) ? parse : Uri.fromFile(new File(str));
    }

    @Deprecated
    @Nullable
    public final MediaItem m19674b(Uri uri) {
        return m19672a(uri, FallbackMediaId.DEFAULT);
    }

    @Nullable
    public final MediaItem m19672a(Uri uri, FallbackMediaId fallbackMediaId) {
        return m19673a(uri, fallbackMediaId, Storage.EXTERNAL);
    }

    private Cursor m19660a(String str, Storage storage) {
        String c = MediaUtils.c(str);
        if (c == null) {
            Cursor b = m19665b(str, storage);
            if (b == null || !b.moveToFirst()) {
                return m19670c(str, storage);
            }
            return b;
        }
        switch (1.a[MediaItem.b(c).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m19665b(str, storage);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m19670c(str, storage);
            default:
                return null;
        }
    }

    private Cursor m19665b(String str, Storage storage) {
        return ((MediaItemCursorUtil) this.f13350e.get()).a(m19661a(storage), "_data = ?", new String[]{str});
    }

    private Cursor m19670c(String str, Storage storage) {
        return ((MediaItemCursorUtil) this.f13350e.get()).b(m19666b(storage), "_data = ?", new String[]{str});
    }

    private static Uri m19661a(Storage storage) {
        switch (1.b[storage.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Media.EXTERNAL_CONTENT_URI;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Media.INTERNAL_CONTENT_URI;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static Uri m19666b(Storage storage) {
        switch (1.b[storage.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Video.Media.EXTERNAL_CONTENT_URI;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return Video.Media.INTERNAL_CONTENT_URI;
            default:
                throw new IllegalArgumentException();
        }
    }

    private Cursor m19669c(Uri uri) {
        Uri d = m19671d(uri);
        if (d != null) {
            uri = d;
        }
        try {
            Cursor a = ((MediaItemCursorUtil) this.f13350e.get()).a(uri, null, null);
            if (a != null) {
                return a;
            }
        } catch (SQLiteException e) {
        }
        return ((MediaItemCursorUtil) this.f13350e.get()).b(uri, null, null);
    }

    @Nullable
    private Uri m19671d(Uri uri) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if ("downloads".equals(uri.getAuthority())) {
            try {
                Uri parse;
                Cursor query = ((ContentResolver) this.f13348c.get()).query(uri, f13347b, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(0);
                            if (string != null) {
                                parse = Uri.parse(string);
                                if (query != null) {
                                    return parse;
                                }
                                query.close();
                                return parse;
                            }
                        }
                    } catch (Exception e) {
                        cursor = query;
                        try {
                            BLog.b(f13346a, "Could not retrieve the media content uri from " + uri.toString());
                            if (cursor != null) {
                                cursor.close();
                                return null;
                            }
                            return null;
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                parse = null;
                if (query != null) {
                    return parse;
                }
                query.close();
                return parse;
            } catch (Exception e2) {
                cursor = null;
                BLog.b(f13346a, "Could not retrieve the media content uri from " + uri.toString());
                if (cursor != null) {
                    cursor.close();
                    return null;
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }
        return null;
    }

    @Nullable
    private MediaItem m19662a(Uri uri, long j) {
        String path = uri.getPath();
        MimeType a = MimeType.a(MediaUtils.c(path));
        if (MimeType.e.equals(a)) {
            return null;
        }
        Builder a2 = new Builder().a(new MediaIdKey(path, j).toString()).a(uri).a(a);
        LocalMediaData.Builder builder = new LocalMediaData.Builder();
        builder.d = j;
        builder = builder;
        switch (1.a[MediaItem.b(a.mRawType).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                a2.a(Type.Photo);
                this.f13349d.get();
                int b = BitmapUtils.b(path);
                if (b > 0) {
                    a2.e = b;
                }
                this.f13349d.get();
                Dimension a3 = BitmapUtils.a(path);
                if (a3.b > 0 && a3.a > 0) {
                    a2.f = a3.b;
                    Builder builder2 = a2;
                    builder2.g = a3.a;
                    builder2.h = MediaAspectRatioUtil.a(a3.b, a3.a, b);
                }
                builder.a(a2.a());
                PhotoItemBuilder photoItemBuilder = new PhotoItemBuilder();
                photoItemBuilder.f = builder.a();
                return photoItemBuilder.a();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a2.a(Type.Video);
                builder.a(a2.a());
                VideoItemBuilder videoItemBuilder = new VideoItemBuilder();
                videoItemBuilder.e = builder.a();
                return videoItemBuilder.a();
            default:
                BLog.b(f13346a, StringFormatUtil.formatStrLocaleSafe("Could not create fallback MediaItem for URI %s", uri.toString()));
                return null;
        }
    }
}

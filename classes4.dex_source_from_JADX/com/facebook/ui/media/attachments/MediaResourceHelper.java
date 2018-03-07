package com.facebook.ui.media.attachments;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.tempfile.BackingFileResolver.BackingFileResult;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.util.ExifOrientation;
import com.facebook.common.util.ExifOrientationUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.extract.DefaultVideoMetadataExtractor;
import com.facebook.videocodec.extract.VideoThumbnailExtractor;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mInMemoryWriteLock for writes to keep in sync with mBytesInMemory */
public class MediaResourceHelper {
    private static final Class<?> f8685a = MediaResourceHelper.class;
    private static volatile MediaResourceHelper f8686j;
    public final ContentResolver f8687b;
    private final VideoMetadataExtractor f8688c;
    private final VideoThumbnailExtractor f8689d;
    private final TempFileManager f8690e;
    private final BackingFileResolver f8691f;
    public final MediaMimeTypeMap f8692g;
    private final DefaultAndroidThreadUtil f8693h;
    private final AbstractFbErrorReporter f8694i;

    public static com.facebook.ui.media.attachments.MediaResourceHelper m8954a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8686j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.media.attachments.MediaResourceHelper.class;
        monitor-enter(r1);
        r0 = f8686j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8956b(r0);	 Catch:{ all -> 0x0035 }
        f8686j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8686j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.media.attachments.MediaResourceHelper.a(com.facebook.inject.InjectorLike):com.facebook.ui.media.attachments.MediaResourceHelper");
    }

    private static MediaResourceHelper m8956b(InjectorLike injectorLike) {
        return new MediaResourceHelper(ContentResolverMethodAutoProvider.b(injectorLike), DefaultVideoMetadataExtractor.m8969b(injectorLike), VideoThumbnailExtractor.m8976a(injectorLike), BackingFileResolver.m8895a(injectorLike), MediaMimeTypeMap.m8984a(injectorLike), TempFileManager.m8903a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MediaResourceHelper(ContentResolver contentResolver, VideoMetadataExtractor videoMetadataExtractor, VideoThumbnailExtractor videoThumbnailExtractor, BackingFileResolver backingFileResolver, MediaMimeTypeMap mediaMimeTypeMap, TempFileManager tempFileManager, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8687b = contentResolver;
        this.f8688c = videoMetadataExtractor;
        this.f8689d = videoThumbnailExtractor;
        this.f8691f = backingFileResolver;
        this.f8692g = mediaMimeTypeMap;
        this.f8690e = tempFileManager;
        this.f8693h = defaultAndroidThreadUtil;
        this.f8694i = abstractFbErrorReporter;
    }

    public static boolean m8955a(MediaResource mediaResource) {
        switch (3.a[mediaResource.d.ordinal()]) {
            case 1:
                if (mediaResource.j == 0 || mediaResource.k == 0 || mediaResource.l == ExifOrientation.UNDEFINED || mediaResource.o == null || mediaResource.p == 0) {
                    return false;
                }
                return true;
            case 2:
                if (mediaResource.j == 0 || mediaResource.k == 0 || mediaResource.i == 0 || mediaResource.o == null || mediaResource.p == 0 || mediaResource.f == null) {
                    return false;
                }
                return true;
            case 3:
                return mediaResource.i != 0;
            default:
                return true;
        }
    }

    public final List<MediaResource> m8967b(List<MediaResource> list) {
        return Lists.a(Iterables.a(list, new 2(this)));
    }

    public final MediaResource m8966b(MediaResource mediaResource) {
        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
        m8965a(a);
        return a.C();
    }

    public final void m8965a(MediaResourceBuilder mediaResourceBuilder) {
        this.f8693h.b();
        switch (3.a[mediaResourceBuilder.b.ordinal()]) {
            case 1:
                m8957b(mediaResourceBuilder);
                m8958c(mediaResourceBuilder);
                m8963g(mediaResourceBuilder);
                return;
            case 2:
                m8957b(mediaResourceBuilder);
                m8960d(mediaResourceBuilder);
                m8963g(mediaResourceBuilder);
                m8962f(mediaResourceBuilder);
                return;
            case 3:
                m8957b(mediaResourceBuilder);
                m8963g(mediaResourceBuilder);
                m8961e(mediaResourceBuilder);
                return;
            case 4:
                m8957b(mediaResourceBuilder);
                m8963g(mediaResourceBuilder);
                return;
            default:
                return;
        }
    }

    public final String m8964a(Uri uri) {
        String type = this.f8687b.getType(uri);
        if (type != null) {
            return type;
        }
        return this.f8692g.m8986b(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    }

    private void m8958c(MediaResourceBuilder mediaResourceBuilder) {
        if (mediaResourceBuilder.i() == 0 || mediaResourceBuilder.j() == 0 || mediaResourceBuilder.k() == ExifOrientation.UNDEFINED) {
            try {
                BackingFileResult a = this.f8691f.m8899a(mediaResourceBuilder.a(), Privacy.PREFER_SDCARD);
                try {
                    int attributeInt = new ExifInterface(a.a.getPath()).getAttributeInt("Orientation", 0);
                    mediaResourceBuilder.a(ExifOrientation.fromExifInterfaceOrientation(attributeInt));
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    FbBitmapFactory.m13881a(a.a.getPath(), options);
                    if (attributeInt == 0 || attributeInt == 1 || attributeInt == 3) {
                        mediaResourceBuilder.a(options.outWidth);
                        mediaResourceBuilder.b(options.outHeight);
                    } else {
                        mediaResourceBuilder.a(options.outHeight);
                        mediaResourceBuilder.b(options.outWidth);
                    }
                } finally {
                    a.a();
                }
            } catch (Exception e) {
            }
        }
    }

    private void m8960d(MediaResourceBuilder mediaResourceBuilder) {
        try {
            VideoMetadata a = this.f8688c.mo693a(mediaResourceBuilder.a());
            mediaResourceBuilder.a(ExifOrientationUtil.a(a.d));
            if (a.b > 0 && a.c > 0) {
                mediaResourceBuilder.a(a.b);
                mediaResourceBuilder.b(a.c);
            }
            mediaResourceBuilder.b(a.a);
        } catch (Exception e) {
        }
    }

    private static void m8961e(MediaResourceBuilder mediaResourceBuilder) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mediaResourceBuilder.a().getPath());
            mediaResourceBuilder.b((long) Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)));
            mediaMetadataRetriever.release();
        } catch (Exception e) {
        }
    }

    private void m8962f(MediaResourceBuilder mediaResourceBuilder) {
        if (mediaResourceBuilder.d() == null) {
            try {
                Bitmap b;
                Uri a = mediaResourceBuilder.a();
                if (mediaResourceBuilder.e()) {
                    b = this.f8689d.m8982b(a, 1);
                } else if (mediaResourceBuilder.q() > 0) {
                    b = this.f8689d.m8981a(a, 1, mediaResourceBuilder.q() * 1000);
                } else {
                    b = this.f8689d.m8980a(a, 1);
                }
                if (b != null) {
                    Bitmap bitmap;
                    if (mediaResourceBuilder.p() == null || mediaResourceBuilder.p() == MediaResource.b) {
                        bitmap = b;
                    } else {
                        Rect rect = new Rect((int) (mediaResourceBuilder.p().left * ((float) b.getWidth())), (int) (mediaResourceBuilder.p().top * ((float) b.getHeight())), (int) (mediaResourceBuilder.p().right * ((float) b.getWidth())), (int) (mediaResourceBuilder.p().bottom * ((float) b.getHeight())));
                        bitmap = Bitmap.createBitmap(rect.width(), rect.height(), b.getConfig());
                        Canvas canvas = new Canvas(bitmap);
                        if (mediaResourceBuilder.c() == Source.QUICKCAM_FRONT) {
                            Matrix matrix = new Matrix();
                            matrix.preScale(-1.0f, 1.0f, (float) (rect.width() / 2), 0.0f);
                            canvas.setMatrix(matrix);
                        }
                        canvas.drawBitmap(b, (float) (-rect.left), (float) (-rect.top), null);
                    }
                    File a2 = this.f8690e.m8907a("thumbnail", ".jpg", Privacy.PREFER_SDCARD);
                    OutputStream fileOutputStream = new FileOutputStream(a2);
                    try {
                        bitmap.compress(CompressFormat.JPEG, 85, fileOutputStream);
                        fileOutputStream.flush();
                        mediaResourceBuilder.b(Uri.fromFile(a2));
                    } finally {
                        fileOutputStream.close();
                    }
                } else {
                    this.f8694i.a("MediaResourceHelper_VideoThumbnailFailed", "Could not fetch thumbnail for video");
                }
            } catch (Throwable e) {
                this.f8694i.a("MediaResourceHelper_VideoThumbnailException", "Couldn't add video thumbnail", e);
            }
        }
    }

    private void m8957b(MediaResourceBuilder mediaResourceBuilder) {
        if (mediaResourceBuilder.m == null) {
            Uri uri = mediaResourceBuilder.a;
            String str = null;
            if ("content".equals(uri.getScheme())) {
                str = this.f8687b.getType(uri);
            } else if ("file".equals(uri.getScheme())) {
                String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
                if (fileExtensionFromUrl != null) {
                    str = this.f8692g.m8986b(fileExtensionFromUrl);
                }
            }
            mediaResourceBuilder.m = str;
        }
    }

    private void m8963g(MediaResourceBuilder mediaResourceBuilder) {
        if (mediaResourceBuilder.n == 0) {
            mediaResourceBuilder.n = this.f8691f.m8901b(mediaResourceBuilder.a);
        }
    }

    public static boolean m8959c(MediaResource mediaResource) {
        Object obj;
        Object obj2;
        if (mediaResource.s == -1 || mediaResource.s == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            obj = (mediaResource.t == -2 || ((long) mediaResource.t) == mediaResource.i) ? 1 : null;
            if (obj != null) {
                obj2 = null;
                if (obj2 == null) {
                    if ((MediaResource.b.equals(mediaResource.q) ? 1 : null) == null) {
                        return false;
                    }
                }
                return true;
            }
        }
        obj2 = 1;
        if (obj2 == null) {
            if (MediaResource.b.equals(mediaResource.q)) {
            }
            if ((MediaResource.b.equals(mediaResource.q) ? 1 : null) == null) {
                return false;
            }
        }
        return true;
    }
}

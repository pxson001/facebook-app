package com.facebook.bitmaps;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import com.facebook.debug.log.BLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: androidKeyHash */
public class ExifThumbnailUtil {
    private static final Class<?> f10363a = ExifThumbnailUtil.class;
    private static volatile ExifThumbnailUtil f10364b;

    public static com.facebook.bitmaps.ExifThumbnailUtil m18446a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f10364b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.bitmaps.ExifThumbnailUtil.class;
        monitor-enter(r1);
        r0 = f10364b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m18445a();	 Catch:{ all -> 0x0034 }
        f10364b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f10364b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bitmaps.ExifThumbnailUtil.a(com.facebook.inject.InjectorLike):com.facebook.bitmaps.ExifThumbnailUtil");
    }

    private static ExifThumbnailUtil m18445a() {
        return new ExifThumbnailUtil();
    }

    @Nullable
    public static Bitmap m18444a(String str, BitmapResizingParam bitmapResizingParam, NativeImageProcessor nativeImageProcessor) {
        Bitmap bitmap = null;
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            if (!exifInterface.hasThumbnail()) {
                return bitmap;
            }
            byte[] thumbnail = exifInterface.getThumbnail();
            if (thumbnail == null) {
                return bitmap;
            }
            if (bitmapResizingParam.f10355a == 0) {
                return FbBitmapFactory.a(thumbnail, 0, thumbnail.length);
            }
            InputStream byteArrayInputStream = new ByteArrayInputStream(thumbnail);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                nativeImageProcessor.m18474a(byteArrayInputStream, byteArrayOutputStream, bitmapResizingParam.f10355a);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return FbBitmapFactory.a(toByteArray, 0, toByteArray.length);
            } catch (Throwable e) {
                BLog.b(f10363a, "Error resizing the exif thumbnail: ", e);
                return bitmap;
            }
        } catch (Throwable e2) {
            BLog.b(f10363a, "Error getting the exif", e2);
            return bitmap;
        }
    }
}

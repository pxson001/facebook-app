package com.facebook.photos.sharing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.io.Closeables;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: intro_cards_suggested_bio_nux_dismissed */
public class TempBinaryFileManager {
    private static final Class<?> f10881a = TempBinaryFileManager.class;
    private static volatile TempBinaryFileManager f10882e;
    private final DefaultAndroidThreadUtil f10883b;
    private final TempFileManager f10884c;
    private final AbstractFbErrorReporter f10885d;

    public static com.facebook.photos.sharing.TempBinaryFileManager m12905a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10882e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.sharing.TempBinaryFileManager.class;
        monitor-enter(r1);
        r0 = f10882e;	 Catch:{ all -> 0x003a }
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
        r0 = m12907b(r0);	 Catch:{ all -> 0x0035 }
        f10882e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10882e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.sharing.TempBinaryFileManager.a(com.facebook.inject.InjectorLike):com.facebook.photos.sharing.TempBinaryFileManager");
    }

    private static TempBinaryFileManager m12907b(InjectorLike injectorLike) {
        return new TempBinaryFileManager(DefaultAndroidThreadUtil.b(injectorLike), TempFileManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public TempBinaryFileManager(DefaultAndroidThreadUtil defaultAndroidThreadUtil, TempFileManager tempFileManager, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10883b = defaultAndroidThreadUtil;
        this.f10884c = tempFileManager;
        this.f10885d = abstractFbErrorReporter;
    }

    public final Uri m12914a(BinaryResource binaryResource) {
        return Uri.fromFile(m12911d(binaryResource));
    }

    public final Uri m12912a(Bitmap bitmap) {
        return m12913a(bitmap, null);
    }

    public final Uri m12913a(Bitmap bitmap, File file) {
        Throwable th;
        Preconditions.checkArgument(!bitmap.isRecycled());
        if (file == null) {
            file = m12906a();
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                }
                return Uri.fromFile(file);
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    private static boolean m12910b(BinaryResource binaryResource) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            m12904a(binaryResource, options);
            if ("image/jpeg".equals(options.outMimeType)) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static Bitmap m12904a(BinaryResource binaryResource, Options options) {
        InputStream bufferedInputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            bufferedInputStream = new BufferedInputStream(binaryResource.a());
            try {
                bitmap = FbBitmapFactory.a(bufferedInputStream, null, options);
                Closeables.a(bufferedInputStream);
            } catch (IOException e) {
                Closeables.a(bufferedInputStream);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                Closeables.a(bufferedInputStream);
                throw th;
            }
        } catch (IOException e2) {
            bufferedInputStream = bitmap;
            Closeables.a(bufferedInputStream);
            return bitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = bitmap;
            th = th4;
            Closeables.a(bufferedInputStream);
            throw th;
        }
        return bitmap;
    }

    public final File m12917a(BinaryResource binaryResource, File file) {
        if (m12910b(binaryResource)) {
            Bitmap a = m12904a(binaryResource, null);
            if (a != null) {
                m12913a(a, file);
                a.recycle();
            }
        } else {
            m12908b(binaryResource, file);
        }
        return file;
    }

    private static void m12908b(BinaryResource binaryResource, File file) {
        InputStream inputStream = null;
        try {
            inputStream = binaryResource.a();
            m12909b(inputStream, file);
        } finally {
            Closeables.a(inputStream);
        }
    }

    private static void m12909b(InputStream inputStream, File file) {
        OutputStream outputStream = null;
        try {
            outputStream = Files.a(file, new FileWriteMode[0]).a();
            ByteStreams.a(inputStream, outputStream);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public final Uri m12916a(InputStream inputStream, File file) {
        if (file == null) {
            file = m12906a();
        }
        m12909b(inputStream, file);
        return Uri.fromFile(file);
    }

    public final Uri m12915a(InputStream inputStream) {
        return m12916a(inputStream, null);
    }

    private File m12906a() {
        File a = this.f10884c.a(".facebook_", ".jpg", Privacy.PREFER_SDCARD);
        if (a != null) {
            return a;
        }
        this.f10885d.a(f10881a.getSimpleName(), StringFormatUtil.a("Failed to create temp file: %s %s %s", new Object[]{".facebook_", ".jpg", Privacy.PREFER_SDCARD.toString()}));
        throw new IOException("Unable to create temporary file");
    }

    private File m12911d(BinaryResource binaryResource) {
        Preconditions.checkNotNull(binaryResource);
        return m12917a(binaryResource, m12906a());
    }
}

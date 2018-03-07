package com.facebook.ui.media.attachments;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.util.StreamUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: enter_channel */
public class MediaResourceUtil {
    private static volatile MediaResourceUtil f12902b;
    private final ContentResolver f12903a;

    public static com.facebook.ui.media.attachments.MediaResourceUtil m13776a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12902b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.media.attachments.MediaResourceUtil.class;
        monitor-enter(r1);
        r0 = f12902b;	 Catch:{ all -> 0x003a }
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
        r0 = m13778b(r0);	 Catch:{ all -> 0x0035 }
        f12902b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12902b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.media.attachments.MediaResourceUtil.a(com.facebook.inject.InjectorLike):com.facebook.ui.media.attachments.MediaResourceUtil");
    }

    private static MediaResourceUtil m13778b(InjectorLike injectorLike) {
        return new MediaResourceUtil(ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MediaResourceUtil(ContentResolver contentResolver) {
        this.f12903a = contentResolver;
    }

    public static boolean m13777a(@Nullable MediaResource mediaResource) {
        if (mediaResource == null || mediaResource.c == null) {
            return false;
        }
        try {
            MediaResourceScheme.from(mediaResource);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public final byte[] m13781a(Uri uri) {
        switch (1.a[MediaResourceScheme.from(uri).ordinal()]) {
            case 1:
                return Files.m11929b(new File(uri.getPath()));
            default:
                InputStream b = m13779b(uri);
                try {
                    byte[] a = StreamUtil.a(b);
                    return a;
                } finally {
                    Closeables.a(b);
                }
        }
    }

    private InputStream m13779b(Uri uri) {
        switch (1.a[MediaResourceScheme.from(uri).ordinal()]) {
            case 1:
                return new FileInputStream(uri.getPath());
            case 2:
                return this.f12903a.openInputStream(uri);
            default:
                throw new IllegalArgumentException("Unsupported scheme");
        }
    }

    public static boolean m13780b(MediaResource mediaResource) {
        return mediaResource.d == MediaResource$Type.PHOTO || mediaResource.d == MediaResource$Type.ENCRYPTED_PHOTO || mediaResource.d == MediaResource$Type.ENT_PHOTO;
    }
}

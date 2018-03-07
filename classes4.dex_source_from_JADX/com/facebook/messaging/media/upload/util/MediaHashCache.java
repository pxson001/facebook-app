package com.facebook.messaging.media.upload.util;

import android.net.Uri;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.config.MediaUploadXConfig;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.io.Files;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLayerState */
public class MediaHashCache {
    public static final Class<?> f8644a = MediaHashCache.class;
    private static volatile MediaHashCache f8645f;
    private final DefaultAndroidThreadUtil f8646b;
    private final BackingFileResolver f8647c;
    private final XConfigReader f8648d;
    private final LoadingCache<MediaUploadKey, String> f8649e = CacheBuilder.newBuilder().b(2073600000, TimeUnit.MILLISECONDS).a(new C04141(this));

    /* compiled from: mLayerState */
    class C04141 extends CacheLoader<MediaUploadKey, String> {
        final /* synthetic */ MediaHashCache f8673a;

        C04141(MediaHashCache mediaHashCache) {
            this.f8673a = mediaHashCache;
        }

        public final Object m8923a(Object obj) {
            return MediaHashCache.m8889a(this.f8673a, ((MediaUploadKey) obj).a);
        }
    }

    public static com.facebook.messaging.media.upload.util.MediaHashCache m8888a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8645f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.util.MediaHashCache.class;
        monitor-enter(r1);
        r0 = f8645f;	 Catch:{ all -> 0x003a }
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
        r0 = m8891b(r0);	 Catch:{ all -> 0x0035 }
        f8645f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8645f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.util.MediaHashCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.util.MediaHashCache");
    }

    private static MediaHashCache m8891b(InjectorLike injectorLike) {
        return new MediaHashCache(DefaultAndroidThreadUtil.b(injectorLike), BackingFileResolver.m8895a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public MediaHashCache(DefaultAndroidThreadUtil defaultAndroidThreadUtil, BackingFileResolver backingFileResolver, XConfigReader xConfigReader) {
        this.f8646b = defaultAndroidThreadUtil;
        this.f8647c = backingFileResolver;
        this.f8648d = xConfigReader;
    }

    public final String m8892a(MediaResource mediaResource) {
        return (String) this.f8649e.a(MediaUploadKey.a(mediaResource));
    }

    public final String m8893b(MediaResource mediaResource) {
        return m8890a(MediaUploadKey.a(mediaResource));
    }

    public final String m8894c(MediaResource mediaResource) {
        return m8890a(MediaUploadKey.b(mediaResource));
    }

    private String m8890a(MediaUploadKey mediaUploadKey) {
        this.f8646b.b();
        try {
            return (String) this.f8649e.c(mediaUploadKey);
        } catch (Throwable e) {
            BLog.a(f8644a, e, "Couldn't get sha256 hash for media resource: %s", new Object[]{mediaUploadKey.a});
            return null;
        }
    }

    public static String m8889a(MediaHashCache mediaHashCache, Uri uri) {
        File a = mediaHashCache.f8647c.m8900a(uri);
        if (a == null) {
            BLog.a(f8644a, "Couldn't resolve backing file for media resource: %s", new Object[]{uri});
            return "";
        }
        String a2 = mediaHashCache.f8648d.a(MediaUploadXConfig.f1817d, "FANeflaawkeANLGireg43");
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(a2.getBytes(), "HmacSHA256"));
            return (String) Files.m11919a(a, new 2(mediaHashCache, instance, a.length()));
        } catch (Throwable e) {
            BLog.a(f8644a, e, "Couldn't generate sha256 hash of file: %s with salt: %s", new Object[]{uri, a2});
            return "";
        }
    }
}

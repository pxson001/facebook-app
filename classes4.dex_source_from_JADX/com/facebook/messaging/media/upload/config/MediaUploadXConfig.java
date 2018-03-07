package com.facebook.messaging.media.upload.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: static_assets. */
public final class MediaUploadXConfig extends XConfig {
    public static final XConfigName f1816c = new XConfigName("messenger_media_upload");
    public static final XConfigSetting f1817d = new XConfigSetting(f1816c, "hash_secret_salt");
    public static final XConfigSetting f1818e = new XConfigSetting(f1816c, "max_video_size_bytes");
    public static final XConfigSetting f1819f = new XConfigSetting(f1816c, "video_resize_keyframe_interval_secs");
    public static final XConfigSetting f1820g = new XConfigSetting(f1816c, "video_resize_frame_rate");
    public static final XConfigSetting f1821h = new XConfigSetting(f1816c, "video_resize_longest_dimension");
    public static final XConfigSetting f1822i = new XConfigSetting(f1816c, "video_resize_bitrate_kbps");
    private static final ImmutableSet<XConfigSetting> f1823j = ImmutableSet.of(f1817d, f1818e, f1822i, f1820g, f1819f, f1821h, new XConfigSetting[0]);
    private static volatile MediaUploadXConfig f1824k;

    public static com.facebook.messaging.media.upload.config.MediaUploadXConfig m1947a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1824k;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.config.MediaUploadXConfig.class;
        monitor-enter(r1);
        r0 = f1824k;	 Catch:{ all -> 0x0039 }
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
        r0 = m1946a();	 Catch:{ all -> 0x0034 }
        f1824k = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1824k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.config.MediaUploadXConfig.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.config.MediaUploadXConfig");
    }

    private static MediaUploadXConfig m1946a() {
        return new MediaUploadXConfig();
    }

    @Inject
    public MediaUploadXConfig() {
        super(f1816c, f1823j);
    }
}

package com.facebook.videocodec.extract;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.google.common.base.Strings;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@TargetApi(10)
/* compiled from: retry_intent */
public class SystemVideoMetadataExtractor implements VideoMetadataExtractor {
    private static volatile SystemVideoMetadataExtractor f5530c;
    private final Context f5531a;
    private final BackingFileResolver f5532b;

    public static com.facebook.videocodec.extract.SystemVideoMetadataExtractor m8201a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5530c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.extract.SystemVideoMetadataExtractor.class;
        monitor-enter(r1);
        r0 = f5530c;	 Catch:{ all -> 0x003a }
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
        r0 = m8202b(r0);	 Catch:{ all -> 0x0035 }
        f5530c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5530c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.extract.SystemVideoMetadataExtractor.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.extract.SystemVideoMetadataExtractor");
    }

    private static SystemVideoMetadataExtractor m8202b(InjectorLike injectorLike) {
        return new SystemVideoMetadataExtractor((Context) injectorLike.getInstance(Context.class), BackingFileResolver.a(injectorLike));
    }

    @Inject
    public SystemVideoMetadataExtractor(Context context, BackingFileResolver backingFileResolver) {
        this.f5531a = context;
        this.f5532b = backingFileResolver;
    }

    public final VideoMetadata m8203a(Uri uri) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.f5531a, uri);
            int i = 0;
            int a = m8199a(mediaMetadataRetriever, 18, -1);
            int a2 = m8199a(mediaMetadataRetriever, 19, -1);
            int a3 = m8199a(mediaMetadataRetriever, 20, -1);
            if (VERSION.SDK_INT >= 17) {
                i = m8199a(mediaMetadataRetriever, 24, 0);
            }
            long a4 = m8200a(mediaMetadataRetriever, 9, 0);
            long j = -1;
            File a5 = this.f5532b.a(uri);
            if (a5 != null) {
                j = a5.length();
            }
            VideoMetadata videoMetadata = new VideoMetadata(a4, a, a2, i, a3, j, -1, null, mediaMetadataRetriever.extractMetadata(23), mediaMetadataRetriever.extractMetadata(5));
            return videoMetadata;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private static int m8199a(MediaMetadataRetriever mediaMetadataRetriever, int i, int i2) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (!Strings.isNullOrEmpty(extractMetadata)) {
            try {
                i2 = Integer.parseInt(extractMetadata);
            } catch (NumberFormatException e) {
            }
        }
        return i2;
    }

    private static long m8200a(MediaMetadataRetriever mediaMetadataRetriever, int i, long j) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (!Strings.isNullOrEmpty(extractMetadata)) {
            try {
                j = Long.parseLong(extractMetadata);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}

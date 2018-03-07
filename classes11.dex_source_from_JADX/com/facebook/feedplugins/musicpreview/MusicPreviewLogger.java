package com.facebook.feedplugins.musicpreview;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: composer_too_many_attachments */
public class MusicPreviewLogger {
    private static final ImmutableMap<Integer, String> f8054b = ImmutableMap.builder().b(Integer.valueOf(-1004), "media_error_io").b(Integer.valueOf(-1007), "media_error_malformed").b(Integer.valueOf(-1010), "media_error_unsupported").b(Integer.valueOf(-110), "media_error_timed_out").b();
    public static final ImmutableMap<Integer, String> f8055c = ImmutableMap.builder().b(Integer.valueOf(1), "media_error_unknown").b(Integer.valueOf(100), "media_error_server_died").b();
    private static volatile MusicPreviewLogger f8056d;
    public final AnalyticsLogger f8057a;

    public static com.facebook.feedplugins.musicpreview.MusicPreviewLogger m9098a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8056d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.musicpreview.MusicPreviewLogger.class;
        monitor-enter(r1);
        r0 = f8056d;	 Catch:{ all -> 0x003a }
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
        r0 = m9099b(r0);	 Catch:{ all -> 0x0035 }
        f8056d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8056d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.musicpreview.MusicPreviewLogger.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.musicpreview.MusicPreviewLogger");
    }

    private static MusicPreviewLogger m9099b(InjectorLike injectorLike) {
        return new MusicPreviewLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MusicPreviewLogger(AnalyticsLogger analyticsLogger) {
        this.f8057a = analyticsLogger;
    }

    public final void m9102a(String str, String str2, String str3, ArrayNode arrayNode, String str4, String str5) {
        this.f8057a.a(new HoneyClientEvent("music_preview_exception").b("song_clip_url", str).b("og_song_id", str2).b("og_object_id", str3).a("tracking_codes", arrayNode).b("provider_name", str4).b("stack_trace", str5));
    }

    public final void m9101a(String str, String str2, ArrayNode arrayNode, String str3, String str4, int i, int i2) {
        this.f8057a.a(new HoneyClientEvent("music_preview_media_player_error").b("og_song_id", str).b("og_object_id", str2).a("tracking_codes", arrayNode).b("provider_name", str3).b("song_clip_url", str4).b("error_type", (String) Optional.fromNullable(f8055c.get(Integer.valueOf(i))).or("unknown_error_type_" + i)).b("error_info", m9100b(i2)));
    }

    private static String m9100b(int i) {
        return (String) Optional.fromNullable(f8054b.get(Integer.valueOf(i))).or("unknown_error_info_" + i);
    }
}

package com.facebook.facecast.plugin;

import android.os.Build.VERSION;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.video.videostreaming.LiveStreamingError;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: broadcast_session_failed */
public class FacecastAnalyticsLogger {
    private static volatile FacecastAnalyticsLogger f18170I;
    private final AnalyticsLogger f18171A;
    public final FbNetworkManager f18172B;
    public final Lazy<AppStateManager> f18173C;
    private final String f18174D;
    public final FbDataConnectionManager f18175E;
    @Nullable
    public volatile String f18176F;
    @Nullable
    public volatile String f18177G;
    @Nullable
    public volatile ComposerSourceSurface f18178H;
    private final String f18179a = "Facecast";
    private final String f18180b = "facecast_broadcaster_update";
    private final String f18181c = "broadcast_id";
    private final String f18182d = "broadcast_target_type";
    private final String f18183e = "broadcast_transition_from";
    private final String f18184f = "broadcast_transition_to";
    private final String f18185g = "broadcast_transition_reason";
    private final String f18186h = "previous_zoom_level";
    private final String f18187i = "new_zoom_level";
    private final String f18188j = "connection_type";
    private final String f18189k = "connection_quality";
    private final String f18190l = "network_rtt";
    private final String f18191m = "connection_bandwidth";
    private final String f18192n = "composer_source_surface";
    private final String f18193o = "app_state";
    private final String f18194p = "BACKGROUND";
    private final String f18195q = "FOREGROUND";
    private final String f18196r = "base_system_version";
    private final String f18197s = "copyright_monitor_state";
    private final String f18198t = "error_class";
    private final String f18199u = "error_code";
    private final String f18200v = "error_message";
    private final String f18201w = "error_trace";
    private final String f18202x = "inner_error_class";
    private final String f18203y = "inner_error_code";
    private final String f18204z = "inner_error_message";

    /* compiled from: broadcast_session_failed */
    public enum EXIT_SOURCE {
        POST_BUTTON,
        DELETE_BUTTON,
        BACK_BUTTON
    }

    public static com.facebook.facecast.plugin.FacecastAnalyticsLogger m21959a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18170I;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecast.plugin.FacecastAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f18170I;	 Catch:{ all -> 0x003a }
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
        r0 = m21961b(r0);	 Catch:{ all -> 0x0035 }
        f18170I = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18170I;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.plugin.FacecastAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.facecast.plugin.FacecastAnalyticsLogger");
    }

    private static FacecastAnalyticsLogger m21961b(InjectorLike injectorLike) {
        return new FacecastAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 476), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), FbDataConnectionManager.a(injectorLike));
    }

    @Inject
    public FacecastAnalyticsLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager, Lazy<AppStateManager> lazy, String str, FbDataConnectionManager fbDataConnectionManager) {
        this.f18171A = analyticsLogger;
        this.f18172B = fbNetworkManager;
        this.f18173C = lazy;
        this.f18174D = str;
        this.f18175E = fbDataConnectionManager;
    }

    public final void m21964a(String str, String str2, String str3, @Nullable LiveStreamingError liveStreamingError, Map<String, String> map) {
        Map hashMap = new HashMap();
        if (liveStreamingError != null) {
            hashMap.put("error_class", liveStreamingError.domain);
            hashMap.put("error_code", Integer.toString(liveStreamingError.errorCode));
            hashMap.put("error_message", liveStreamingError.reason);
            hashMap.put("error_trace", liveStreamingError.fullDescription);
            hashMap.put("inner_error_class", liveStreamingError.domain);
            hashMap.put("inner_error_code", Integer.toString(liveStreamingError.errorCode));
            hashMap.put("inner_error_message", liveStreamingError.reason);
        }
        hashMap.put("broadcast_transition_from", str);
        hashMap.put("broadcast_transition_to", str2);
        hashMap.put("broadcast_transition_reason", str3);
        if (map != null) {
            hashMap.putAll(map);
        }
        m21965a(hashMap);
    }

    public final void m21963a(String str, String str2) {
        m21964a(str, str, str2, null, null);
    }

    public final void m21962a(EXIT_SOURCE exit_source, long j, boolean z, boolean z2, boolean z3) {
        Map hashMap = new HashMap();
        hashMap.put("broadcast_duration", Long.toString(j));
        hashMap.put("save_to_camera_roll", Boolean.toString(z));
        hashMap.put("upload_hd", Boolean.toString(z2));
        hashMap.put("dvr_file_available", Boolean.toString(z3));
        hashMap.put("exit_source", exit_source.name());
        m21960a("facecast_pre_broadcast_exit", hashMap);
    }

    public final void m21965a(Map<String, String> map) {
        m21960a("facecast_broadcaster_update", (Map) map);
    }

    private void m21960a(String str, Map<String, String> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "Facecast";
        if (map == null) {
            map = Maps.c();
        }
        map.put("broadcast_id", StringUtil.a(this.f18176F) ? "none" : this.f18176F);
        map.put("broadcast_target_type", this.f18177G);
        map.put("base_system_version", VERSION.RELEASE);
        map.put("connection_type", this.f18172B.p());
        map.put("connection_quality", this.f18175E.b().toString());
        map.put("network_rtt", Double.toString(this.f18175E.f()));
        map.put("connection_bandwidth", Double.toString(this.f18175E.e()));
        map.put("app_state", ((AppStateManager) this.f18173C.get()).j() ? "BACKGROUND" : "FOREGROUND");
        ComposerSourceSurface composerSourceSurface = this.f18178H;
        map.put("composer_source_surface", composerSourceSurface != null ? composerSourceSurface.getAnalyticsName() : "n/a");
        for (Entry entry : map.entrySet()) {
            honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
        }
        if (!StringUtil.a(this.f18174D)) {
            honeyClientEvent.j(this.f18174D);
        }
        this.f18171A.a(honeyClientEvent);
    }
}

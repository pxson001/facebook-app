package com.facebook.backstage.analytics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.PrefetchAnalytics;
import com.facebook.analytics.PrefetchAnalyticsProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: segment_count */
public class BackstageAnalyticsLogger {
    private static volatile BackstageAnalyticsLogger f4265e;
    private final AnalyticsLogger f4266a;
    public final PrefetchAnalytics f4267b;
    private String f4268c;
    public int f4269d;

    /* compiled from: segment_count */
    public enum Event {
        ENTRY("backstage_entry", "infra"),
        CLOSE("backstage_exit", "infra"),
        IMPORT_SHARE("backstage_import_share", "production"),
        IMPORT_CANCEL("backstage_import_cancel", "production"),
        IMPORT_PUBLISHER_TO_GRID("backstage_publisher_to_grid", "production"),
        IMPORT_GALLERY_SELECT_ALL("backstage_import_select_all", "production"),
        IMPORT_GALLERY_DESELECT_ALL("backstage_import_deselect_all", "production"),
        IMPORT_GRID_TO_PUBLISHER("backstage_entered_publish_step", "production"),
        IMPORT_ENTER("backstage_entered_import_gallery", "production"),
        EMOJI_REPLY_MENU_OPEN("backstage_emote_flow_started", "conversations"),
        EMOJI_REPLY_MENU_DISMISSED("backstage_emote_flow_abandoned", "conversations"),
        EMOJI_REPLY_SELECTED("backstage_emote_flow_sent", "conversations"),
        NUX_START("backstage_onboarding_start", "onboarding"),
        NUX_STEP_TWO_SHOWN("backstage_onboarding_step2", "onboarding"),
        NUX_CANCEL("backstage_onboarding_cancel", "onboarding"),
        NUX_COMPLETE("backstage_onboarding_complete", "onboarding"),
        CAMERA_OPEN("backstage_enter_camera", "camera"),
        CAMERA_CANCEL("backstage_camera_cancel", "camera"),
        CAMERA_PHOTO_CAPTURE("backstage_camera_capture", "camera"),
        CAMERA_VIDEO_CAPTURE("backstage_camera_video", "camera"),
        CAMERA_MEDIA_PREVIEW("backstage_camera_publish", "camera"),
        AUDIENCE_SELECTION_STARTED("backstage_audience_start", "infra"),
        AUDIENCE_SELECTION_FINISHED("backstage_audience_done", "infra"),
        AUDIENCE_SELECT_ALL("backstage_audience_select_all", "infra"),
        AUDIENCE_DESELECT_ALL("backstage_audience_deselect_all", "infra"),
        UPLOAD_STARTED("backstage_upload_start", "production"),
        UPLOAD_COMPLETED("backstage_upload_complete", "production"),
        UPLOAD_FAILED("backstage_upload_fail", "production"),
        OPENED_SELF_STACK("backstage_selfstack_open", "consumption"),
        CLOSED_SELF_STACK("backstage_selfstack_close", "consumption"),
        OPENED_STACK("backstage_stack_open", "consumption"),
        CLOSED_STACK("backstage_stack_close", "consumption"),
        OPEN_REPLY_LIST("backstage_reactions_list_open", "infra"),
        CLOSE_REPLY_LIST("backstage_reactions_list_closed", "consumption"),
        OPEN_REPLY_THREAD("backstage_reactions_thread_open", "consumption"),
        SUBMITTED_REPLY("backstage_reactions_flow_sent", "conversations");
        
        private String mModuleName;
        private String mName;

        private Event(String str, String str2) {
            this.mName = str;
            this.mModuleName = str2;
        }

        public final String getName() {
            return this.mName;
        }

        public final String getModuleName() {
            return this.mModuleName;
        }
    }

    public static com.facebook.backstage.analytics.BackstageAnalyticsLogger m4259a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4265e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.analytics.BackstageAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f4265e;	 Catch:{ all -> 0x003a }
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
        r0 = m4261b(r0);	 Catch:{ all -> 0x0035 }
        f4265e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4265e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.analytics.BackstageAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.backstage.analytics.BackstageAnalyticsLogger");
    }

    private static BackstageAnalyticsLogger m4261b(InjectorLike injectorLike) {
        return new BackstageAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (PrefetchAnalyticsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrefetchAnalyticsProvider.class));
    }

    @Inject
    public BackstageAnalyticsLogger(AnalyticsLogger analyticsLogger, PrefetchAnalyticsProvider prefetchAnalyticsProvider) {
        this.f4266a = analyticsLogger;
        this.f4267b = prefetchAnalyticsProvider.a("backstage_cache", "backstage_main_list_query");
    }

    public final void m4264a(Event event) {
        m4260a(event, null);
    }

    private void m4260a(Event event, @Nullable Bundle bundle) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(event.getName());
        honeyClientEvent.c = event.getModuleName();
        honeyClientEvent.f = this.f4268c;
        honeyClientEvent.b("backstage_id", this.f4268c);
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                honeyClientEvent.a(str, bundle.get(str));
            }
        }
        this.f4266a.a(honeyClientEvent);
    }

    public final void m4262a() {
        this.f4268c = SafeUUIDGenerator.a().toString();
        m4260a(Event.ENTRY, null);
    }

    public final void m4268b() {
        m4260a(Event.CLOSE, null);
        this.f4268c = null;
    }

    public final void m4265a(Event event, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fb_id", str);
        m4260a(event, bundle);
    }

    public final void m4267a(boolean z, int i, int i2) {
        Bundle bundle = new Bundle(2);
        bundle.putInt("total_assets_count", i);
        bundle.putInt("unseen_assets_count", i2);
        m4260a(z ? Event.OPENED_SELF_STACK : Event.OPENED_STACK, bundle);
    }

    public final void m4266a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("shot_seen_count", this.f4269d);
        this.f4269d = 0;
        if (z) {
            m4260a(Event.CLOSED_SELF_STACK, bundle);
        } else {
            m4260a(Event.CLOSED_STACK, bundle);
        }
    }

    public final void m4263a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("reply_thread_count", i);
        m4260a(Event.OPEN_REPLY_LIST, bundle);
    }
}

package com.facebook.platform.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rp_commerce_location */
public class PlatformAnalyticsLogger {
    private static volatile PlatformAnalyticsLogger f3928c;
    private final AnalyticsLogger f3929a;
    private QeAccessor f3930b;

    /* compiled from: rp_commerce_location */
    public enum Event {
        DRAFT_DIALOG_SEEN("fb4a_draft_dialog_seen"),
        DRAFT_DIALOG_SAVE_CLICKED("fb4a_draft_dialog_save_clicked"),
        DRAFT_DIALOG_DISCARD_CLICKED("fb4a_draft_dialog_discard_clicked"),
        DRAFT_DIALOG_BACK_CLICKED("fb4a_draft_dialog_back_clicked"),
        DRAFT_NOTIFICATION_CLICKED("fb4a_draft_notification_clicked"),
        DRAFT_COMPOSER_POST_CLICKED("fb4a_draft_composer_post_clicked"),
        DRAFT_ERROR_SAVED_MEDIA_NOT_FOUND("fb4a_draft_error_saved_media_not_found");
        
        public final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    public static com.facebook.platform.analytics.PlatformAnalyticsLogger m3921a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3928c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.analytics.PlatformAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f3928c;	 Catch:{ all -> 0x003a }
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
        r0 = m3923b(r0);	 Catch:{ all -> 0x0035 }
        f3928c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3928c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.analytics.PlatformAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.platform.analytics.PlatformAnalyticsLogger");
    }

    private static PlatformAnalyticsLogger m3923b(InjectorLike injectorLike) {
        return new PlatformAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlatformAnalyticsLogger(AnalyticsLogger analyticsLogger, QeAccessor qeAccessor) {
        this.f3929a = analyticsLogger;
        this.f3930b = qeAccessor;
    }

    public final void m3924a(String str) {
        m3922a(new HoneyClientEvent(Event.DRAFT_DIALOG_SEEN.name).b("composer_session_id", str));
    }

    public final void m3926b(String str) {
        m3922a(new HoneyClientEvent(Event.DRAFT_DIALOG_SAVE_CLICKED.name).b("composer_session_id", str));
    }

    public final void m3927c(String str) {
        m3922a(new HoneyClientEvent(Event.DRAFT_DIALOG_DISCARD_CLICKED.name).b("composer_session_id", str));
    }

    public final void m3928d(String str) {
        m3922a(new HoneyClientEvent(Event.DRAFT_DIALOG_BACK_CLICKED.name).b("composer_session_id", str));
    }

    public final void m3929e(String str) {
        m3922a(new HoneyClientEvent(Event.DRAFT_NOTIFICATION_CLICKED.name).b("story_id", str));
    }

    public final void m3925a(String str, String str2) {
        m3922a(new HoneyClientEvent(Event.DRAFT_COMPOSER_POST_CLICKED.name).b("story_id", str).b("composer_session_id", str2));
    }

    private void m3922a(HoneyClientEvent honeyClientEvent) {
        boolean a = this.f3930b.a(ExperimentsForComposerAbTestModule.a, false);
        boolean a2 = this.f3930b.a(ExperimentsForComposerAbTestModule.i, true);
        this.f3929a.a(honeyClientEvent.a("is_external_sharing_enabled", a).a("is_save_draft_default", a2).a("has_keep_button", this.f3930b.a(ExperimentsForComposerAbTestModule.h, true)));
    }
}

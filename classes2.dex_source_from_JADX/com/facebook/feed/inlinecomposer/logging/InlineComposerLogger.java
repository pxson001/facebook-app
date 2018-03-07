package com.facebook.feed.inlinecomposer.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pages_mobile_username_creation */
public class InlineComposerLogger {
    private static volatile InlineComposerLogger f10414d;
    private final AnalyticsLogger f10415a;
    public final NavigationLogger f10416b;
    private final PlacesPerformanceLogger f10417c;

    public static com.facebook.feed.inlinecomposer.logging.InlineComposerLogger m15507a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10414d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.inlinecomposer.logging.InlineComposerLogger.class;
        monitor-enter(r1);
        r0 = f10414d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m15508b(r0);	 Catch:{ all -> 0x0035 }
        f10414d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10414d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.inlinecomposer.logging.InlineComposerLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.inlinecomposer.logging.InlineComposerLogger");
    }

    private static InlineComposerLogger m15508b(InjectorLike injectorLike) {
        return new InlineComposerLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NavigationLogger.m5475a(injectorLike), PlacesPerformanceLogger.m4202a(injectorLike));
    }

    @Inject
    public InlineComposerLogger(AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, PlacesPerformanceLogger placesPerformanceLogger) {
        this.f10415a = analyticsLogger;
        this.f10416b = navigationLogger;
        this.f10417c = placesPerformanceLogger;
    }

    public final void m15511a(String str) {
        m15509b("inline_composer_profile_pic_tapped");
        this.f10416b.m5498a(str);
        this.f10417c.m4217k();
    }

    public final void m15510a() {
        m15509b("inline_composer_text_box_clicked");
        this.f10417c.m4214h();
    }

    public final void m15512b() {
        m15509b("inline_composer_status_button_clicked");
        this.f10417c.m4215i();
    }

    public final void m15513c() {
        m15509b("inline_composer_photo_button_clicked");
        this.f10417c.m4216j();
    }

    public final void m15514d() {
        m15509b("inline_composer_check_in_button_clicked");
    }

    private void m15509b(String str) {
        HoneyClientEventFast a = this.f10415a.mo535a(str, false);
        if (a.m17388a()) {
            a.m17379a("inline_composer");
            a.m17390b();
        }
    }
}

package com.facebook.reviews.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: f55852ea321ad8b1699e751877117738 */
public class ReviewsLogger {
    private static volatile ReviewsLogger f15444b;
    public final AnalyticsLogger f15445a;

    public static com.facebook.reviews.analytics.ReviewsLogger m23062a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15444b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.analytics.ReviewsLogger.class;
        monitor-enter(r1);
        r0 = f15444b;	 Catch:{ all -> 0x003a }
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
        r0 = m23063b(r0);	 Catch:{ all -> 0x0035 }
        f15444b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15444b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.analytics.ReviewsLogger.a(com.facebook.inject.InjectorLike):com.facebook.reviews.analytics.ReviewsLogger");
    }

    private static ReviewsLogger m23063b(InjectorLike injectorLike) {
        return new ReviewsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReviewsLogger(AnalyticsLogger analyticsLogger) {
        this.f15445a = analyticsLogger;
    }

    public final void m23068a(String str, String str2, int i, int i2, int i3) {
        HoneyClientEvent d = m23066d("composer_review_length_category_changed", str, str2);
        d.a("old_review_length", i).a("new_review_length", i2).a("review_length_threshold", i3);
        this.f15445a.a(d);
    }

    public final void m23071b(String str, String str2) {
        m23064b("inline_review_composer_click", str, str2);
    }

    public final void m23073c(String str, String str2) {
        m23064b("reviews_post_review_success", str, str2);
    }

    public final void m23075d(String str, String str2) {
        m23064b("reviews_post_review_failure", str, str2);
    }

    public final void m23077e(String str, String str2) {
        m23064b("reviews_delete_review_success", str, str2);
    }

    public final void m23078f(String str, String str2) {
        m23064b("reviews_delete_review_failure", str, str2);
    }

    public final void m23069a(String str, String str2, String str3, ReviewsClickEventTargets reviewsClickEventTargets) {
        this.f15445a.c(m23065c("reviews_click", str, str2).b("review_creator_id", str3).b("target", reviewsClickEventTargets.toString()));
    }

    public final void m23067a(String str) {
        m23064b("reviews_feed_impression", "reviews_feed", str);
    }

    public final void m23070b(String str) {
        m23064b("reviews_feed_load_stories_success", "reviews_feed", str);
    }

    public final void m23072c(String str) {
        m23064b("reviews_feed_load_stories_failure", "reviews_feed", str);
    }

    public final void m23074d(String str) {
        m23064b("reviews_feed_header_load_success", "reviews_feed", str);
    }

    public final void m23076e(String str) {
        m23064b("reviews_feed_header_load_failure", "reviews_feed", str);
    }

    public final void m23079g(String str, String str2) {
        AnalyticsLogger analyticsLogger = this.f15445a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "reviews_feed";
        analyticsLogger.a(honeyClientEvent.b("story_id", str2));
    }

    private void m23064b(String str, String str2, String str3) {
        this.f15445a.c(m23065c(str, str2, str3));
    }

    public static HoneyClientEvent m23065c(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = str2;
        return honeyClientEvent.b("page_id", str3);
    }

    public static HoneyClientEvent m23066d(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "composer";
        return honeyClientEvent.b("page_id", str2).b("composer_session_id", str3);
    }
}

package com.facebook.feedback.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: WWW_SEARCH_LOCAL_OTHER */
public class FeedbackAnalyticsLogger {
    private static volatile FeedbackAnalyticsLogger f12274e;
    private final AnalyticsLogger f12275a;
    private final LocalStatsLoggerImpl f12276b;
    private final CommonEventsBuilder f12277c;
    private final Clock f12278d;

    /* compiled from: WWW_SEARCH_LOCAL_OTHER */
    public enum CommentPostType {
        REQUEST,
        MANUAL_RETRY,
        AUTOMATIC_RETRY,
        SUCCESS,
        FAILURE,
        OFFLINE
    }

    public static com.facebook.feedback.logging.FeedbackAnalyticsLogger m20307a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12274e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.logging.FeedbackAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f12274e;	 Catch:{ all -> 0x003a }
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
        r0 = m20310b(r0);	 Catch:{ all -> 0x0035 }
        f12274e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12274e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.logging.FeedbackAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.feedback.logging.FeedbackAnalyticsLogger");
    }

    private static FeedbackAnalyticsLogger m20310b(InjectorLike injectorLike) {
        return new FeedbackAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), CommonEventsBuilder.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FeedbackAnalyticsLogger(AnalyticsLogger analyticsLogger, LocalStatsLoggerImpl localStatsLoggerImpl, CommonEventsBuilder commonEventsBuilder, Clock clock) {
        this.f12275a = analyticsLogger;
        this.f12276b = localStatsLoggerImpl;
        this.f12277c = commonEventsBuilder;
        this.f12278d = clock;
    }

    public final void m20316a(CommentPostType commentPostType, String str, FeedbackLoggingParams feedbackLoggingParams) {
        if (CommentPostType.REQUEST == commentPostType) {
            this.f12276b.a(7405570);
        }
        HoneyClientEventFast b = m20309b("comment_post_request", feedbackLoggingParams);
        if (b.a()) {
            b.a("comment_text", str);
            b.a("comment_post_type", commentPostType);
            b.b();
        }
    }

    public final void m20319a(String str, FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_composer_session_ended", feedbackLoggingParams);
        if (b.a()) {
            b.a("comment_text", str);
            b.b();
        }
    }

    public final void m20317a(GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m20308a("comment_like", graphQLFeedback, feedbackLoggingParams);
    }

    public final void m20312a() {
        HoneyClientEventFast a = this.f12275a.a("live_comment_received", false);
        if (a.a()) {
            a.b();
        }
    }

    public final void m20322b(GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        m20308a("story_like", graphQLFeedback, feedbackLoggingParams);
    }

    public final void m20313a(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_sticker_keyboard_opened", feedbackLoggingParams);
        if (b.a()) {
            b.b();
        }
    }

    public final void m20315a(FeedbackLoggingParams feedbackLoggingParams, String str, String str2) {
        HoneyClientEventFast a = m20306a("comment_draft_posted", feedbackLoggingParams, str);
        if (a.a()) {
            a.a("comment_text", str2);
            a.b();
        }
    }

    public final void m20320b(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_draft_cleared", feedbackLoggingParams);
        if (b.a()) {
            b.b();
        }
    }

    public final void m20323c(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_draft_evicted", feedbackLoggingParams);
        if (b.a()) {
            b.b();
        }
    }

    public final void m20314a(FeedbackLoggingParams feedbackLoggingParams, String str) {
        m20311b("comment_draft_recovered", feedbackLoggingParams, str);
    }

    public final void m20321b(FeedbackLoggingParams feedbackLoggingParams, String str) {
        m20311b("comment_draft_saved", feedbackLoggingParams, str);
    }

    public final void m20324d(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_ufi_opened", feedbackLoggingParams);
        if (b.a() && feedbackLoggingParams != null) {
            b.a("nectar_module", feedbackLoggingParams.b);
            b.b();
        }
    }

    public final void m20318a(GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams, boolean z, boolean z2) {
        HoneyClientEventFast b = m20309b("cached_feedback_count_stale", feedbackLoggingParams);
        if (b.a()) {
            b.a("comment_counts_stale", z);
            b.a("like_counts_stale", z2);
            b.a("cached_feedback_age", this.f12278d.a() - graphQLFeedback.v());
            b.b();
        }
    }

    public final void m20325e(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_reply_preview_clicked", feedbackLoggingParams);
        if (b.a() && feedbackLoggingParams != null) {
            b.b();
        }
    }

    public final void m20326f(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_view_more_replies_clicked", feedbackLoggingParams);
        if (b.a() && feedbackLoggingParams != null) {
            b.b();
        }
    }

    public final void m20327g(FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast b = m20309b("comment_curation_menu_opened", feedbackLoggingParams);
        if (b.a() && feedbackLoggingParams != null) {
            b.b();
        }
    }

    private void m20308a(String str, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        String str2;
        JsonNode jsonNode;
        AnalyticsLogger analyticsLogger = this.f12275a;
        String j = graphQLFeedback.j();
        String valueOf = String.valueOf(graphQLFeedback.y_());
        if (feedbackLoggingParams == null || feedbackLoggingParams.c == null) {
            str2 = "unknown";
        } else {
            str2 = feedbackLoggingParams.c;
        }
        HoneyClientEvent a = CommonEventsBuilder.a(str, j, valueOf, str2);
        valueOf = "tracking";
        if (feedbackLoggingParams == null) {
            jsonNode = null;
        } else {
            jsonNode = feedbackLoggingParams.a;
        }
        analyticsLogger.a(a.a(valueOf, jsonNode));
    }

    private HoneyClientEventFast m20309b(String str, FeedbackLoggingParams feedbackLoggingParams) {
        HoneyClientEventFast a = this.f12275a.a(str, false);
        if (a.a() && feedbackLoggingParams != null) {
            a.a("display_type", feedbackLoggingParams.d.name());
            a.a("tracking", feedbackLoggingParams.a);
            if (feedbackLoggingParams.c != null) {
                a.a(feedbackLoggingParams.c);
            }
            if (feedbackLoggingParams.e != null) {
                a.a("notification_source", feedbackLoggingParams.e);
            }
            if (feedbackLoggingParams.f != null) {
                a.a("photo_remix_source", feedbackLoggingParams.f);
            }
        }
        return a;
    }

    private HoneyClientEventFast m20306a(String str, FeedbackLoggingParams feedbackLoggingParams, String str2) {
        HoneyClientEventFast b = m20309b(str, feedbackLoggingParams);
        if (b.a()) {
            b.a("comment_draft_text", str2);
        }
        return b;
    }

    private void m20311b(String str, FeedbackLoggingParams feedbackLoggingParams, String str2) {
        HoneyClientEventFast a = m20306a(str, feedbackLoggingParams, str2);
        if (a.a()) {
            a.b();
        }
    }
}

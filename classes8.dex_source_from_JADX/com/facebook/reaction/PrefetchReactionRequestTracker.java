package com.facebook.reaction;

import com.facebook.common.time.Clock;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger.Event;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidCacheResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionCacheResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureEvent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel.ReactionUnitsModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cache */
public class PrefetchReactionRequestTracker implements InternalTrackerCallback {
    private final Clock f18580a;
    public final ReactionSessionManager f18581b;
    private final ReactionAnalyticsLogger f18582c;
    private final Lazy<ReactionPlaceTipsPostComposeManager> f18583d;

    @Inject
    public PrefetchReactionRequestTracker(@Assisted ReactionSessionManager reactionSessionManager, Clock clock, ReactionAnalyticsLogger reactionAnalyticsLogger, Lazy<ReactionPlaceTipsPostComposeManager> lazy) {
        this.f18581b = reactionSessionManager;
        this.f18580a = clock;
        this.f18582c = reactionAnalyticsLogger;
        this.f18583d = lazy;
    }

    public final void mo1107a(ReactionSession reactionSession, InvalidResponseEvent invalidResponseEvent) {
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f18582c;
        String str = reactionSession.f18658a;
        Surface surface = reactionSession.f18660c;
        reactionAnalyticsLogger.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_OVERLAY_ERROR, str, "reaction_overlay", surface).b("error", invalidResponseEvent.f18885a).b("gravity_suggestifier_id", reactionSession.m22561e()));
        m22483a(reactionSession, invalidResponseEvent.f18885a, Long.valueOf(this.f18580a.a()));
    }

    public final void mo1106a(ReactionSession reactionSession, InvalidCacheResponseEvent invalidCacheResponseEvent) {
        String str = invalidCacheResponseEvent.f18883a;
        m22484c(reactionSession, str, Long.valueOf(this.f18580a.a()));
        ReactionSessionManager reactionSessionManager = this.f18581b;
        reactionSession.m22550H();
        reactionSessionManager.m22607a(reactionSession, str);
    }

    public final void mo1105a(ReactionSession reactionSession) {
        m22483a(reactionSession, "EMPTY_REQUEST", null);
    }

    public final void mo1110a(ReactionSession reactionSession, ReactionResultEvent reactionResultEvent) {
        ReactionStories reactionStories;
        if (reactionResultEvent.f18896c == null) {
            reactionStories = null;
        } else {
            reactionStories = reactionResultEvent.f18896c;
        }
        m22482a(reactionSession, reactionStories, reactionResultEvent.f18894a, reactionResultEvent.f18895b, false);
    }

    private void m22482a(ReactionSession reactionSession, ReactionStories reactionStories, long j, long j2, boolean z) {
        reactionSession.m22557a(reactionStories);
        if (reactionStories instanceof ReactionUnitsModel) {
            reactionSession.m22558a(((ReactionUnitsModel) reactionStories).b());
        }
        reactionSession.m22549F();
        if (z) {
            reactionSession.f18673p = false;
        }
        reactionSession.f18665h = j;
        reactionSession.f18666i = j2;
        reactionSession.f18667j = this.f18580a.a();
        boolean z2 = reactionSession.f18675r;
        if (!reactionSession.m22547B() || z2) {
            if (z2) {
                reactionSession.f18675r = false;
                if (((ReactionPlaceTipsPostComposeManager) this.f18583d.get()).m22521a(this.f18581b, reactionSession, reactionSession.f18682y)) {
                    return;
                }
            }
            if (reactionSession.f18670m) {
                long r = reactionSession.f18667j - reactionSession.m22571r();
                if (r > reactionSession.m22565j()) {
                    this.f18581b.m22606a(reactionSession, r);
                    return;
                }
                reactionSession.f18670m = false;
                this.f18581b.m22605a(reactionSession);
            }
        } else if (reactionSession.m22573u() != null && reactionSession.m22573u().kq_()) {
            reactionSession.m22573u().kQ_();
        }
    }

    public final void mo1108a(ReactionSession reactionSession, ReactionCacheResultEvent reactionCacheResultEvent) {
        ReactionStories reactionStories;
        if (reactionCacheResultEvent.f18889c == null) {
            reactionStories = null;
        } else {
            reactionStories = reactionCacheResultEvent.f18889c;
        }
        m22482a(reactionSession, reactionStories, reactionCacheResultEvent.f18887a, reactionCacheResultEvent.f18888b, true);
    }

    public final void mo1109a(ReactionSession reactionSession, ReactionRequestEvent reactionRequestEvent) {
        reactionSession.m22554a();
        reactionSession.f18663f = null;
        reactionSession.f18682y = reactionRequestEvent.f18892a;
        reactionSession.f18672o = true;
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f18582c;
        String str = reactionSession.f18658a;
        Surface surface = reactionSession.f18660c;
        reactionAnalyticsLogger.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_FETCH, str, "reaction_overlay", surface).b("gravity_suggestifier_id", reactionSession.m22561e()));
    }

    public final void mo1111a(ReactionSession reactionSession, RequestNonCancellationFailureEvent requestNonCancellationFailureEvent) {
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f18582c;
        String str = reactionSession.f18658a;
        Surface surface = reactionSession.f18660c;
        reactionAnalyticsLogger.f18800a.c(ReactionAnalyticsLogger.m22811a(Event.REACTION_OVERLAY_ERROR, str, "reaction_overlay", surface).b("error", "NETWORK_FAILURE").a("error_message", requestNonCancellationFailureEvent.f18898a).b("gravity_suggestifier_id", reactionSession.m22561e()));
        m22483a(reactionSession, "NETWORK_FAILURE", null);
    }

    private void m22483a(ReactionSession reactionSession, String str, @Nullable Long l) {
        m22484c(reactionSession, str, l);
        if (reactionSession.m22573u() != null && reactionSession.m22573u().kq_()) {
            reactionSession.m22573u().kp_();
        } else if (reactionSession.f18670m || reactionSession.f18675r) {
            ReactionSessionManager reactionSessionManager = this.f18581b;
            reactionSession.m22550H();
            reactionSessionManager.m22607a(reactionSession, str);
        }
    }

    public static void m22484c(ReactionSession reactionSession, String str, @Nullable Long l) {
        reactionSession.f18663f = str;
        reactionSession.f18664g = l;
        reactionSession.m22554a();
        reactionSession.m22549F();
    }
}

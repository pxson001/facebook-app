package com.facebook.reaction;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
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
import org.apache.http.MethodNotSupportedException;

/* compiled from: cache_radius */
public class PaginationReactionRequestTracker implements InternalTrackerCallback {
    private final Clock f18579a;

    public static PaginationReactionRequestTracker m22474b(InjectorLike injectorLike) {
        return new PaginationReactionRequestTracker((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final void mo1107a(ReactionSession reactionSession, InvalidResponseEvent invalidResponseEvent) {
        m22473a(reactionSession, invalidResponseEvent.f18885a, Long.valueOf(this.f18579a.a()));
    }

    @Inject
    public PaginationReactionRequestTracker(Clock clock) {
        this.f18579a = clock;
    }

    public final void mo1106a(ReactionSession reactionSession, InvalidCacheResponseEvent invalidCacheResponseEvent) {
        throw new MethodNotSupportedException("There shouldn't be any cache result for PaginationReactionRequestTracker.");
    }

    public final void mo1105a(ReactionSession reactionSession) {
        m22473a(reactionSession, "EMPTY_REQUEST", null);
    }

    public final void mo1108a(ReactionSession reactionSession, ReactionCacheResultEvent reactionCacheResultEvent) {
        throw new MethodNotSupportedException("There shouldn't be any cache result for PaginationReactionRequestTracker.");
    }

    public final void mo1110a(ReactionSession reactionSession, ReactionResultEvent reactionResultEvent) {
        ReactionStories reactionStories;
        if (reactionResultEvent.f18896c == null) {
            reactionStories = null;
        } else {
            reactionStories = reactionResultEvent.f18896c;
        }
        if (reactionStories == null) {
            m22473a(reactionSession, "NO_UNITS_RETURNED", Long.valueOf(this.f18579a.a()));
            return;
        }
        reactionSession.m22557a(reactionStories);
        if (reactionStories instanceof ReactionUnitsModel) {
            reactionSession.m22558a(((ReactionUnitsModel) reactionStories).b());
        }
        reactionSession.m22549F();
        reactionSession.f18665h = reactionResultEvent.f18894a;
        reactionSession.f18666i = reactionResultEvent.f18895b;
        reactionSession.f18667j = this.f18579a.a();
        ReactionSessionListener u = reactionSession.m22573u();
        if (u != null) {
            u.mo726a(reactionStories);
        }
    }

    public final void mo1109a(ReactionSession reactionSession, ReactionRequestEvent reactionRequestEvent) {
        reactionSession.f18663f = null;
        reactionSession.f18672o = true;
        reactionSession.f18682y = reactionRequestEvent.f18892a;
    }

    public final void mo1111a(ReactionSession reactionSession, RequestNonCancellationFailureEvent requestNonCancellationFailureEvent) {
        m22473a(reactionSession, "NETWORK_FAILURE", null);
    }

    private static void m22473a(ReactionSession reactionSession, String str, @Nullable Long l) {
        reactionSession.m22549F();
        reactionSession.f18673p = false;
        reactionSession.f18663f = str;
        reactionSession.f18664g = l;
        ReactionSessionListener u = reactionSession.m22573u();
        if (u != null) {
            u.kr_();
        }
    }
}

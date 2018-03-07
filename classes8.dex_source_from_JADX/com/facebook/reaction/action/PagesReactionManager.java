package com.facebook.reaction.action;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionUtil;
import javax.inject.Inject;

/* compiled from: browse_session_id */
public class PagesReactionManager {
    private final ReactionSessionManager f18766a;
    public final ReactionUtil f18767b;

    /* compiled from: browse_session_id */
    public /* synthetic */ class C20742 {
        public static final /* synthetic */ int[] f18765a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f18765a[GraphQLEntityCardContextItemType.PAGE_POPULAR_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18765a[GraphQLEntityCardContextItemType.PAGE_FRIEND_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18765a[GraphQLEntityCardContextItemType.PAGE_REACTION_UNITS_SANDBOX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static PagesReactionManager m22670b(InjectorLike injectorLike) {
        return new PagesReactionManager(ReactionSessionManager.m22590a(injectorLike), ReactionUtil.m22637a(injectorLike));
    }

    @Inject
    public PagesReactionManager(ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil) {
        this.f18766a = reactionSessionManager;
        this.f18767b = reactionUtil;
    }

    public final ReactionSession m22671a(Surface surface, long j, String str) {
        ReactionSession a = this.f18766a.m22603a(str, surface);
        this.f18766a.m22616c(str);
        final long j2 = j;
        final String str2 = str;
        final Surface surface2 = surface;
        a.f18656A = new Runnable(this) {
            final /* synthetic */ PagesReactionManager f18764d;

            public void run() {
                ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
                reactionQueryParams.f18631l = Long.valueOf(j2);
                reactionQueryParams = reactionQueryParams;
                reactionQueryParams.f18639t = Long.valueOf(j2);
                this.f18764d.f18767b.m22660a(reactionQueryParams, str2, surface2);
            }
        };
        return a;
    }

    public final ReactionSession m22672a(GraphQLEntityCardContextItemType graphQLEntityCardContextItemType, long j, String str) {
        Surface surface;
        switch (C20742.f18765a[graphQLEntityCardContextItemType.ordinal()]) {
            case 1:
                surface = Surface.ANDROID_POPULAR_AT_PLACE_CONTEXT_ITEM;
                break;
            case 2:
                surface = Surface.ANDROID_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM;
                break;
            case 3:
                surface = Surface.ANDROID_PAGE_SANDBOX;
                break;
            default:
                surface = Surface.ANDROID_PAGE_LIKES_CONTEXT_ITEM;
                break;
        }
        return m22671a(surface, j, str);
    }
}

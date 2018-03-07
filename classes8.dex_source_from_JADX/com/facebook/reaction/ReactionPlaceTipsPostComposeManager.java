package com.facebook.reaction;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManager$PresenceUpdateBuilder;
import com.facebook.placetips.presence.PlaceTipsHeaderUtil;
import com.facebook.reaction.abtest.ExperimentsForReactionAbtestModule;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: byline_config */
public class ReactionPlaceTipsPostComposeManager {
    private final Lazy<PagePresenceManager> f18616a;
    public final ReactionExperimentController f18617b;
    private final ReactionUnitValidator f18618c;

    public static ReactionPlaceTipsPostComposeManager m22520b(InjectorLike injectorLike) {
        return new ReactionPlaceTipsPostComposeManager(IdBasedSingletonScopeProvider.b(injectorLike, 3009), ReactionExperimentController.a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    @Inject
    public ReactionPlaceTipsPostComposeManager(Lazy<PagePresenceManager> lazy, ReactionExperimentController reactionExperimentController, ReactionUnitValidator reactionUnitValidator) {
        this.f18616a = lazy;
        this.f18617b = reactionExperimentController;
        this.f18618c = reactionUnitValidator;
    }

    public final boolean m22522a(ReactionSessionManager reactionSessionManager, String str, ReactionQueryParams reactionQueryParams) {
        ReactionSession b = reactionSessionManager.m22614b(str);
        if (b != null) {
            Object obj;
            if (reactionQueryParams == null || reactionQueryParams.f18631l == null || Strings.isNullOrEmpty(reactionQueryParams.f18632m)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null && m22519a(b.f18660c)) {
                if (b.f18672o) {
                    b.f18675r = true;
                    return true;
                }
                m22521a(reactionSessionManager, b, reactionQueryParams);
                return true;
            }
        }
        return false;
    }

    private boolean m22519a(Surface surface) {
        return this.f18617b.a() && (surface == Surface.ANDROID_FEED_CHECKIN_SUGGESTION || surface == Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN);
    }

    public final boolean m22521a(ReactionSessionManager reactionSessionManager, ReactionSession reactionSession, ReactionQueryParams reactionQueryParams) {
        if (!m22519a(reactionSession.f18660c)) {
            return false;
        }
        boolean z;
        ReactionUnitValidator reactionUnitValidator = this.f18618c;
        if (reactionSession.f18680w) {
            z = true;
        } else if (reactionSession.f18662e.isEmpty()) {
            z = false;
        } else {
            Iterator it = reactionSession.f18662e.iterator();
            loop0:
            while (it.hasNext()) {
                ImmutableList a = ((ReactionStories) it.next()).a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (edgesModel != null && edgesModel.a() != null && "SUCCESS".equals(reactionUnitValidator.m22914a(edgesModel.a()).f18877d)) {
                        reactionSession.f18680w = true;
                        z = true;
                        break loop0;
                    }
                }
            }
            z = false;
        }
        if (z) {
            m22518a(reactionSession.f18658a, reactionQueryParams);
        } else {
            reactionSessionManager.m22607a(reactionSession, "NO_CONTENT");
        }
        return true;
    }

    private void m22518a(String str, ReactionQueryParams reactionQueryParams) {
        String valueOf = String.valueOf(reactionQueryParams.f18631l);
        String str2 = reactionQueryParams.f18632m;
        PagePresenceManager$PresenceUpdateBuilder a = ((PagePresenceManager) this.f18616a.get()).a(PresenceSource.m3710a(PresenceSourceType.POST_COMPOSE));
        a.f3883c = valueOf;
        a = a;
        a.f3884d = str2;
        a = a;
        a.f3887g = PlaceTipsHeaderUtil.m3874a(str2, this.f18617b.b.a(ExperimentsForReactionAbtestModule.d, "%s"));
        a = a;
        a.f3888h = null;
        a = a;
        a.f3895o = str;
        a = a;
        a.f3896p = ConfidenceLevel.HIGH;
        a.m3872a();
    }
}

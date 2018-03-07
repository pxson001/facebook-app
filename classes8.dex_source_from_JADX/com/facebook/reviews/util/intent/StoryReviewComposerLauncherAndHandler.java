package com.facebook.reviews.util.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLContactRecommendationField;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler.PostReviewCallbackBase;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: profile_video_android_scrubber_opened */
public class StoryReviewComposerLauncherAndHandler {
    private static final String f5002a = StoryReviewComposerLauncherAndHandler.class.getSimpleName();
    private static StoryReviewComposerLauncherAndHandler f5003d;
    private static final Object f5004e = new Object();
    private final Lazy<ReviewComposerLauncherAndHandler> f5005b;
    private final AbstractFbErrorReporter f5006c;

    private static StoryReviewComposerLauncherAndHandler m4949b(InjectorLike injectorLike) {
        return new StoryReviewComposerLauncherAndHandler(IdBasedLazy.a(injectorLike, 10287), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public StoryReviewComposerLauncherAndHandler(Lazy<ReviewComposerLauncherAndHandler> lazy, FbErrorReporter fbErrorReporter) {
        this.f5005b = lazy;
        this.f5006c = fbErrorReporter;
    }

    public final boolean m4951a(GraphQLStory graphQLStory, int i, Activity activity, ComposerSourceType composerSourceType, CurationSurface curationSurface, CurationMechanism curationMechanism) {
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStory.E(), -1160597742);
        if (m4948a(a)) {
            String str;
            GraphQLContactRecommendationField ak = a.ak();
            ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler = (ReviewComposerLauncherAndHandler) this.f5005b.get();
            int q = ak.q();
            long parseLong = Long.parseLong(ak.v().H());
            String aa = ak.v().aa();
            if (ak.y() == null) {
                str = null;
            } else {
                str = ak.y().a();
            }
            reviewComposerLauncherAndHandler.m4945a(i, activity, composerSourceType, curationSurface, curationMechanism, q, parseLong, aa, str, ((GraphQLPrivacyOptionsContentEdge) ak.s().p().a().get(0)).j(), graphQLStory.g());
            return true;
        }
        this.f5006c.a(f5002a, "No valid information to edit review for story " + graphQLStory.c());
        return false;
    }

    public static StoryReviewComposerLauncherAndHandler m4947a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryReviewComposerLauncherAndHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5004e) {
                StoryReviewComposerLauncherAndHandler storyReviewComposerLauncherAndHandler;
                if (a2 != null) {
                    storyReviewComposerLauncherAndHandler = (StoryReviewComposerLauncherAndHandler) a2.a(f5004e);
                } else {
                    storyReviewComposerLauncherAndHandler = f5003d;
                }
                if (storyReviewComposerLauncherAndHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4949b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5004e, b3);
                        } else {
                            f5003d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyReviewComposerLauncherAndHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m4950a(int i, Intent intent, String str, Optional<PostReviewCallbackBase> optional, Optional<Context> optional2) {
        ((ReviewComposerLauncherAndHandler) this.f5005b.get()).m4946a(i, intent, str, optional, optional2);
    }

    private static boolean m4948a(@Nullable GraphQLStoryActionLink graphQLStoryActionLink) {
        return (graphQLStoryActionLink == null || graphQLStoryActionLink.ak() == null || graphQLStoryActionLink.ak().v() == null || Strings.isNullOrEmpty(graphQLStoryActionLink.ak().v().H()) || Strings.isNullOrEmpty(graphQLStoryActionLink.ak().v().aa()) || graphQLStoryActionLink.ak().s() == null || graphQLStoryActionLink.ak().s().p().a().isEmpty() || ((GraphQLPrivacyOptionsContentEdge) graphQLStoryActionLink.ak().s().p().a().get(0)).j() == null) ? false : true;
    }
}

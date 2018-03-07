package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentState;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpPersistentStateKey;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineRowAnimator.1;
import com.facebook.graphql.enums.ChainingSectionViewState;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.text.FakeCursorHook;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inbox_has_top_unit */
public class InlineCommentComposerPartDefinition<E extends HasPositionInformation & HasPersistentState & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, InlineCommentComposerView> {
    public static final ViewType f20233a = new C08191();
    private static final CallerContext f20234b = CallerContext.m9061a(InlineCommentComposerPartDefinition.class, "unknown");
    private static InlineCommentComposerPartDefinition f20235n;
    private static final Object f20236o = new Object();
    public final AnalyticsLogger f20237c;
    private final NewsFeedAnalyticsEventBuilder f20238d;
    private final BackgroundPartDefinition f20239e;
    private final ClickListenerPartDefinition f20240f;
    private final FeedStoryUtil f20241g;
    private final InlineRowAnimator f20242h;
    public final FeedbackPopoverLauncher f20243i;
    private final Resources f20244j;
    private final QeAccessor f20245k;
    private final Lazy<LoggedInUserAuthDataStore> f20246l;
    private final Lazy<FbErrorReporter> f20247m;

    /* compiled from: inbox_has_top_unit */
    final class C08191 extends ViewType {
        C08191() {
        }

        public final View mo1995a(Context context) {
            return new InlineCommentComposerView(context);
        }
    }

    private void m27909a(InlineCommentComposerView inlineCommentComposerView, InlineCommentPersistentState inlineCommentPersistentState, int i, ChainingSectionViewState chainingSectionViewState) {
        if (!inlineCommentPersistentState.a && chainingSectionViewState == ChainingSectionViewState.START_ANIMATE && !inlineCommentPersistentState.b) {
            if (inlineCommentComposerView.getLayoutParams() != null) {
                inlineCommentComposerView.getLayoutParams().height = 1;
            }
            InlineRowAnimator inlineRowAnimator = this.f20242h;
            inlineRowAnimator.f20251b.m1653a(new 1(inlineRowAnimator, inlineCommentComposerView, i, inlineCommentPersistentState), (long) 0);
            inlineCommentPersistentState.b = true;
        }
    }

    private static InlineCommentComposerPartDefinition m27910b(InjectorLike injectorLike) {
        return new InlineCommentComposerPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), FeedStoryUtil.m18578a(injectorLike), InlineRowAnimator.m27917a(injectorLike), FeedbackPopoverLauncher.m26450a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 339), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494));
    }

    private void m27908a(FeedProps<GraphQLStory> feedProps, InlineCommentPersistentState inlineCommentPersistentState) {
        if (!inlineCommentPersistentState.c) {
            HoneyAnalyticsEvent honeyAnalyticsEvent;
            JsonNode a = TrackableFeedProps.m27451a(feedProps);
            if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                honeyAnalyticsEvent = null;
            } else {
                honeyAnalyticsEvent = new HoneyClientEvent("inline_composer_impression").m5085a("tracking", a);
                honeyAnalyticsEvent.f3099c = "native_newsfeed";
                honeyAnalyticsEvent = honeyAnalyticsEvent;
            }
            this.f20237c.mo533c(honeyAnalyticsEvent);
            inlineCommentPersistentState.c = true;
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20239e, new StylingData(feedProps, PaddingStyle.f13071a, -1, 2130840218));
        subParts.mo2756a(this.f20240f, new 2(this, feedProps, cacheableEntity));
        GraphQLPage O = cacheableEntity.mo2890l().m23221O();
        Uri uri = null;
        if (O == null) {
            uri = Uri.parse(((LoggedInUserSessionManager) this.f20246l.get()).m2523c().m5856x());
        } else if (O.bs() != null) {
            uri = Uri.parse(O.bs().mo2924b());
        } else {
            ((AbstractFbErrorReporter) this.f20247m.get()).m2350b(InlineCommentComposerPartDefinition.class.getSimpleName(), "User acting as Page but no profile picture available!");
        }
        ((HasPrefetcher) hasPositionInformation).mo2434a(ImageRequest.m18795a(uri), f20234b);
        return new State((InlineCommentPersistentState) ((HasPersistentState) hasPositionInformation).mo2425a(new InlineCommentComposerStoryKey(cacheableEntity), cacheableEntity), this.f20244j.getDimensionPixelSize(2131430365), uri, ((FollowUpPersistentState) ((HasPersistentState) hasPositionInformation).mo2425a(new FollowUpPersistentStateKey(cacheableEntity), cacheableEntity)).f21187b);
    }

    public final boolean m27914a(Object obj) {
        return this.f20241g.m18590c((FeedProps) obj);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InlineCommentComposerView inlineCommentComposerView = (InlineCommentComposerView) view;
        if (inlineCommentComposerView.d != null) {
            inlineCommentComposerView.c.m12085b(inlineCommentComposerView.d);
            FakeCursorHook fakeCursorHook = inlineCommentComposerView.d;
            if (fakeCursorHook.d) {
                fakeCursorHook.a.removeCallbacks(fakeCursorHook);
                if (!fakeCursorHook.c) {
                    fakeCursorHook.a.invalidate(fakeCursorHook.f, 20, (fakeCursorHook.f + fakeCursorHook.g) - 1, fakeCursorHook.e - 20);
                }
                fakeCursorHook.c = false;
                fakeCursorHook.d = false;
            }
        }
        inlineCommentComposerView.clearAnimation();
    }

    public static InlineCommentComposerPartDefinition m27906a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineCommentComposerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20236o) {
                InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition;
                if (a2 != null) {
                    inlineCommentComposerPartDefinition = (InlineCommentComposerPartDefinition) a2.mo818a(f20236o);
                } else {
                    inlineCommentComposerPartDefinition = f20235n;
                }
                if (inlineCommentComposerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27910b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20236o, b3);
                        } else {
                            f20235n = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineCommentComposerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InlineCommentComposerPartDefinition(BackgroundPartDefinition backgroundPartDefinition, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, ClickListenerPartDefinition clickListenerPartDefinition, FeedStoryUtil feedStoryUtil, InlineRowAnimator inlineRowAnimator, FeedbackPopoverLauncher feedbackPopoverLauncher, QeAccessor qeAccessor, Resources resources, Lazy<LoggedInUserAuthDataStore> lazy, Lazy<FbErrorReporter> lazy2) {
        this.f20239e = backgroundPartDefinition;
        this.f20237c = analyticsLogger;
        this.f20238d = newsFeedAnalyticsEventBuilder;
        this.f20240f = clickListenerPartDefinition;
        this.f20241g = feedStoryUtil;
        this.f20242h = inlineRowAnimator;
        this.f20243i = feedbackPopoverLauncher;
        this.f20245k = qeAccessor;
        this.f20244j = resources;
        this.f20246l = lazy;
        this.f20247m = lazy2;
    }

    public final ViewType mo2547a() {
        return f20233a;
    }

    private void m27907a(FeedProps<GraphQLStory> feedProps, State state, InlineCommentComposerView inlineCommentComposerView) {
        if (this.f20245k.mo596a(ExperimentsForMultipleRowsStoriesAbtestModule.f6715e, false) && inlineCommentComposerView.c != null) {
            if (inlineCommentComposerView.d == null) {
                inlineCommentComposerView.d = new FakeCursorHook(inlineCommentComposerView.c);
            }
            FakeCursorHook fakeCursorHook = inlineCommentComposerView.d;
            if (!fakeCursorHook.d) {
                fakeCursorHook.d = true;
                fakeCursorHook.c = true;
                fakeCursorHook.a.postDelayed(fakeCursorHook, 500);
            }
            inlineCommentComposerView.c.m12083a(inlineCommentComposerView.d);
        }
        inlineCommentComposerView.a.m20507a(state.c, f20234b);
        m27909a(inlineCommentComposerView, state.a, state.b, state.d);
        m27908a(feedProps, state.a);
    }
}

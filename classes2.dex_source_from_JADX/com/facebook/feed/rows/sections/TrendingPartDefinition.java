package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.annotations.IsTopicEnabled;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.module.NewsFeedModule;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.TrendingView;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryTopicsContext;
import com.facebook.graphql.model.GraphQLTopic;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: initial_backoff_seconds */
public class TrendingPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, HasPositionInformation, TrendingView> implements HasSpecialStyling {
    public static final ViewType f20036a = new C08141();
    private static TrendingPartDefinition f20037j;
    private static final Object f20038k = new Object();
    private final FeedStoryUtil f20039b;
    private final BackgroundPartDefinition f20040c;
    public final IFeedIntentBuilder f20041d;
    public final SecureContextHelper f20042e;
    public final NewsFeedAnalyticsEventBuilder f20043f;
    public final AnalyticsLogger f20044g;
    private final int f20045h = 2130840334;
    @IsTopicEnabled
    private final boolean f20046i;

    /* compiled from: initial_backoff_seconds */
    final class C08141 extends ViewType {
        C08141() {
        }

        public final View mo1995a(Context context) {
            return new TrendingView(context);
        }
    }

    private static TrendingPartDefinition m27761b(InjectorLike injectorLike) {
        return new TrendingPartDefinition(FeedStoryUtil.m18578a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedModule.m27771e());
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20040c, new StylingData(feedProps, PaddingStyle.f13075e, -1, this.f20045h));
        GraphQLTopic a = m27760a(graphQLStory);
        OnClickListener 2 = new 2(this, a, feedProps);
        GraphQLStoryTopicsContext aK = graphQLStory.aK();
        Object obj2 = (aK == null || aK.m24903j() == null || aK.m24903j().isEmpty()) ? null : 1;
        return new State(2, a, obj2 != null ? 0 : 8);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2105626625);
        State state = (State) obj2;
        TrendingView trendingView = (TrendingView) view;
        trendingView.c.setText(state.b.m23566l());
        trendingView.setOnClickListener(state.a);
        trendingView.a.setVisibility(state.c);
        trendingView.b.setVisibility(state.c);
        Logger.a(8, EntryType.MARK_POP, 208753837, a);
    }

    public final boolean m27765a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        return this.f20046i && StoryProps.m27456c(feedProps) == null && StoryHierarchyHelper.m27434a(graphQLStory).m22608j().isEmpty() && m27760a(graphQLStory) != null && !FeedStoryUtil.m18581a(graphQLStory);
    }

    public static TrendingPartDefinition m27759a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TrendingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20038k) {
                TrendingPartDefinition trendingPartDefinition;
                if (a2 != null) {
                    trendingPartDefinition = (TrendingPartDefinition) a2.mo818a(f20038k);
                } else {
                    trendingPartDefinition = f20037j;
                }
                if (trendingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27761b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20038k, b3);
                        } else {
                            f20037j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = trendingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public TrendingPartDefinition(FeedStoryUtil feedStoryUtil, BackgroundPartDefinition backgroundPartDefinition, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, Boolean bool) {
        this.f20039b = feedStoryUtil;
        this.f20040c = backgroundPartDefinition;
        this.f20041d = iFeedIntentBuilder;
        this.f20042e = secureContextHelper;
        this.f20043f = newsFeedAnalyticsEventBuilder;
        this.f20044g = analyticsLogger;
        this.f20046i = bool.booleanValue();
    }

    public final ViewType mo2547a() {
        return f20036a;
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }

    @Nullable
    private static GraphQLTopic m27760a(GraphQLStory graphQLStory) {
        GraphQLStoryTopicsContext aK = graphQLStory.aK();
        if (aK == null) {
            return null;
        }
        ImmutableList j = aK.m24903j();
        if (j != null && !j.isEmpty()) {
            return (GraphQLTopic) j.get(0);
        }
        ImmutableList a = aK.m24902a();
        if (a == null || a.isEmpty()) {
            return null;
        }
        return (GraphQLTopic) a.get(0);
    }
}

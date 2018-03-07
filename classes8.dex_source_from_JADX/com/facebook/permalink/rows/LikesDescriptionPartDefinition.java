package com.facebook.permalink.rows;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.ui.TokenPileHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: story_count */
public class LikesDescriptionPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, OnClickListener, HasPositionInformation, LikesDescriptionView> implements HasSpecialStyling {
    public static final ViewType f2019a = new C02331();
    public static final String f2020b = LikesDescriptionPartDefinition.class.getName();
    private static LikesDescriptionPartDefinition f2021n;
    private static final Object f2022o = new Object();
    public final Context f2023c;
    private final BackgroundPartDefinition f2024d;
    public final SecureContextHelper f2025e;
    public final IFeedIntentBuilder f2026f;
    public final LinkifyUtil f2027g;
    public final GraphQLStoryUtil f2028h;
    public final Lazy<NavigationLogger> f2029i;
    private final ReactionsExperimentUtil f2030j;
    public final QuickPerformanceLogger f2031k;
    public final AbstractFbErrorReporter f2032l;
    public final TokenPileHelper f2033m;

    /* compiled from: story_count */
    final class C02331 extends ViewType {
        C02331() {
        }

        public final View m2252a(Context context) {
            return new LikesDescriptionView(context);
        }
    }

    private static LikesDescriptionPartDefinition m2256b(InjectorLike injectorLike) {
        return new LikesDescriptionPartDefinition((Context) injectorLike.getInstance(Context.class), BackgroundPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), LinkifyUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), GraphQLStoryUtil.a(injectorLike), ReactionsExperimentUtil.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), TokenPileHelper.a(injectorLike));
    }

    public final Object m2258a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f2024d, new StylingData(feedProps, PaddingStyle.a));
        return new OnClickListener(this) {
            final /* synthetic */ LikesDescriptionPartDefinition f2018b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 262255015);
                if (GraphQLHelper.s(graphQLStory.l())) {
                    ((NavigationLogger) this.f2018b.f2029i.get()).a("tap_like_list");
                    Context context = view.getContext();
                    Intent a2 = this.f2018b.f2026f.a(graphQLStory.l(), "native_permalink");
                    a2.putExtra("fragment_title", context.getString(2131233292));
                    a2.putExtra("open_fragment_as_modal", true);
                    this.f2018b.f2031k.b(8519681);
                    this.f2018b.f2025e.a(a2, context);
                    LogUtils.a(-1958397698, a);
                    return;
                }
                this.f2018b.f2032l.a(LikesDescriptionPartDefinition.f2020b, "Reactors list init needs valid reactors count map");
                Logger.a(2, EntryType.UI_INPUT_END, -1248948257, a);
            }
        };
    }

    public final /* bridge */ /* synthetic */ void m2259a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1878750675);
        m2254a((FeedProps) obj, (OnClickListener) obj2, (LikesDescriptionView) view);
        Logger.a(8, EntryType.MARK_POP, -1219153776, a);
    }

    public final boolean m2260a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f2028h.a((GraphQLStory) feedProps.a, feedProps.d());
    }

    public final void m2262b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((LikesDescriptionView) view).setOnClickListener(null);
    }

    public static LikesDescriptionPartDefinition m2253a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikesDescriptionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2022o) {
                LikesDescriptionPartDefinition likesDescriptionPartDefinition;
                if (a2 != null) {
                    likesDescriptionPartDefinition = (LikesDescriptionPartDefinition) a2.a(f2022o);
                } else {
                    likesDescriptionPartDefinition = f2021n;
                }
                if (likesDescriptionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2256b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2022o, b3);
                        } else {
                            f2021n = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = likesDescriptionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LikesDescriptionPartDefinition(Context context, BackgroundPartDefinition backgroundPartDefinition, SecureContextHelper secureContextHelper, IFeedIntentBuilder iFeedIntentBuilder, LinkifyUtil linkifyUtil, Lazy<NavigationLogger> lazy, GraphQLStoryUtil graphQLStoryUtil, ReactionsExperimentUtil reactionsExperimentUtil, QuickPerformanceLogger quickPerformanceLogger, FbErrorReporter fbErrorReporter, TokenPileHelper tokenPileHelper) {
        this.f2023c = context;
        this.f2024d = backgroundPartDefinition;
        this.f2025e = secureContextHelper;
        this.f2026f = iFeedIntentBuilder;
        this.f2027g = linkifyUtil;
        this.f2028h = graphQLStoryUtil;
        this.f2029i = lazy;
        this.f2030j = reactionsExperimentUtil;
        this.f2031k = quickPerformanceLogger;
        this.f2032l = fbErrorReporter;
        this.f2033m = tokenPileHelper;
    }

    public final ViewType m2257a() {
        return f2019a;
    }

    private void m2254a(FeedProps<GraphQLStory> feedProps, OnClickListener onClickListener, LikesDescriptionView likesDescriptionView) {
        likesDescriptionView.setTextColor(likesDescriptionView.getContext().getResources().getColor(ContextUtils.b(likesDescriptionView.getContext(), 2130772563, 2131362048)));
        FeedProps b = m2255b((FeedProps) feedProps);
        ArrayNode a = TrackableFeedProps.a(b);
        GraphQLStory graphQLStory = (GraphQLStory) b.a;
        likesDescriptionView.setOnClickListener(null);
        likesDescriptionView.setBackgroundDrawable(null);
        Optional a2 = this.f2028h.a(graphQLStory.l());
        if (a2 == null || !a2.isPresent()) {
            likesDescriptionView.setText(this.f2023c.getResources().getString(2131233265));
            TokenPileHelper.a(likesDescriptionView);
            return;
        }
        CharSequence a3 = this.f2027g.a(LinkifyUtilConverter.a((GraphQLTextWithEntities) a2.get()), true, a);
        likesDescriptionView.setOnClickListener(onClickListener);
        likesDescriptionView.setMovementMethod(null);
        likesDescriptionView.setText(a3);
        this.f2033m.a(graphQLStory.l(), likesDescriptionView);
    }

    public final SpecialStylingType m2261b() {
        return SpecialStylingType.MAYBE_HAS_COMMENTS_BELOW;
    }

    private static FeedProps<GraphQLStory> m2255b(FeedProps<GraphQLStory> feedProps) {
        if (StoryProps.m(feedProps)) {
            return feedProps.a(((GraphQLStory) feedProps.a).L());
        }
        return feedProps;
    }
}

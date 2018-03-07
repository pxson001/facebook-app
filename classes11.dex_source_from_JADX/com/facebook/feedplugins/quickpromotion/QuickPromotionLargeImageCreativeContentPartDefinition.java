package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.attachments.video.VideoPrefetchPartDefinition;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.FeedTapAction;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.LargeImageProfilePhotoOption;
import com.facebook.feedplugins.quickpromotion.ui.QuickPromotionLargeImageCreativeContentView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionAction;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.quickpromotion.action.DefaultQuickPromotionActionHandler;
import com.facebook.quickpromotion.action.QuickPromotionActionHandler;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.ActionType;
import com.facebook.story.StoryImageSizes;
import com.facebook.user.model.User;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: cation_settings */
public class QuickPromotionLargeImageCreativeContentPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider & HasFeedListType> extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, State, E, QuickPromotionLargeImageCreativeContentView> {
    public static final ViewType f8905a = new C10801();
    private static final PaddingStyle f8906c;
    private static QuickPromotionLargeImageCreativeContentPartDefinition f8907k;
    private static final Object f8908l = new Object();
    @Inject
    @LoggedInUser
    public Provider<User> f8909b;
    private final BackgroundPartDefinition f8910d;
    private final MenuButtonPartDefinition f8911e;
    public final DefaultQuickPromotionActionHandler f8912f;
    public final Lazy<QuickPromotionLogger> f8913g;
    public final Provider<StoryImageSizes> f8914h;
    public final VideoAutoPlaySettingsChecker f8915i;
    private final VideoPrefetchPartDefinition f8916j;

    /* compiled from: cation_settings */
    final class C10801 extends ViewType {
        C10801() {
        }

        public final View m9644a(Context context) {
            return new QuickPromotionLargeImageCreativeContentView(context);
        }
    }

    /* compiled from: cation_settings */
    public class State {
        public final GraphQLQuickPromotion f8894a;
        public final GraphQLQuickPromotionCreative f8895b;
        public final GraphQLImage f8896c;
        public final GraphQLImage f8897d;
        public final GraphQLVideo f8898e;
        public final GraphQLTextWithEntities f8899f;
        public final GraphQLTextWithEntities f8900g;
        public final GraphQLTextWithEntities f8901h;
        public final OnClickListener f8902i;
        public final boolean f8903j;
        public final LargeImageProfilePhotoOption f8904k;

        public State(GraphQLQuickPromotion graphQLQuickPromotion, GraphQLQuickPromotionCreative graphQLQuickPromotionCreative, GraphQLImage graphQLImage, GraphQLImage graphQLImage2, GraphQLVideo graphQLVideo, GraphQLTextWithEntities graphQLTextWithEntities, GraphQLTextWithEntities graphQLTextWithEntities2, GraphQLTextWithEntities graphQLTextWithEntities3, OnClickListener onClickListener, boolean z, LargeImageProfilePhotoOption largeImageProfilePhotoOption) {
            this.f8894a = graphQLQuickPromotion;
            this.f8895b = graphQLQuickPromotionCreative;
            this.f8896c = graphQLImage;
            this.f8897d = graphQLImage2;
            this.f8898e = graphQLVideo;
            this.f8899f = graphQLTextWithEntities;
            this.f8900g = graphQLTextWithEntities2;
            this.f8901h = graphQLTextWithEntities3;
            this.f8902i = onClickListener;
            this.f8903j = z;
            this.f8904k = largeImageProfilePhotoOption;
        }
    }

    private static QuickPromotionLargeImageCreativeContentPartDefinition m9649b(InjectorLike injectorLike) {
        QuickPromotionLargeImageCreativeContentPartDefinition quickPromotionLargeImageCreativeContentPartDefinition = new QuickPromotionLargeImageCreativeContentPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), DefaultQuickPromotionActionHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 3239), IdBasedProvider.a(injectorLike, 3479), VideoAutoPlaySettingsChecker.a(injectorLike), VideoPrefetchPartDefinition.a(injectorLike));
        quickPromotionLargeImageCreativeContentPartDefinition.f8909b = IdBasedProvider.a(injectorLike, 3595);
        return quickPromotionLargeImageCreativeContentPartDefinition;
    }

    public final /* bridge */ /* synthetic */ void m9652a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        Object obj3;
        boolean z;
        int a = Logger.a(8, EntryType.MARK_PUSH, 1662398954);
        State state = (State) obj2;
        QuickPromotionLargeImageCreativeContentView quickPromotionLargeImageCreativeContentView = (QuickPromotionLargeImageCreativeContentView) view;
        quickPromotionLargeImageCreativeContentView.setTitleText(state.f8899f);
        quickPromotionLargeImageCreativeContentView.m9722a(state.f8900g, ((StoryImageSizes) this.f8914h.get()).c);
        quickPromotionLargeImageCreativeContentView.f9016d = this.f8909b;
        quickPromotionLargeImageCreativeContentView.m9723a(state.f8901h, state.f8894a.l().j());
        quickPromotionLargeImageCreativeContentView.setOnClickListener(state.f8902i);
        quickPromotionLargeImageCreativeContentView.setBrandingImage(state.f8897d);
        quickPromotionLargeImageCreativeContentView.m9726a(state.f8894a.l().j(), state.f8894a.l().a());
        quickPromotionLargeImageCreativeContentView.m9725a(state.f8894a.l().j());
        GraphQLVideo graphQLVideo = state.f8898e;
        if (!this.f8915i.a() || graphQLVideo == null) {
            obj3 = null;
        } else {
            obj3 = 1;
        }
        if (obj3 != null) {
            quickPromotionLargeImageCreativeContentView.m9724a(state.f8898e, state.f8896c, ((StoryImageSizes) this.f8914h.get()).c);
        } else {
            quickPromotionLargeImageCreativeContentView.m9721a(state.f8896c, state.f8902i, ((StoryImageSizes) this.f8914h.get()).c);
        }
        if ((state.f8904k == LargeImageProfilePhotoOption.CENTERED ? 1 : null) != null) {
            quickPromotionLargeImageCreativeContentView.m9719a(state.f8902i, state.f8896c);
        }
        if (state.f8903j) {
            z = false;
        } else {
            z = true;
        }
        quickPromotionLargeImageCreativeContentView.setMenuButtonActive(z);
        Logger.a(8, EntryType.MARK_POP, -1767995911, a);
    }

    public final boolean m9653a(Object obj) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLQuickPromotionFeedUnit == null) {
            return false;
        }
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        return (b == null || b.l() == null || QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit) == null || QuickPromotionTemplate.NEWSFEED_LARGE_IMAGE != QuickPromotionTemplate.fromString(b.l().a())) ? false : true;
    }

    public final void m9654b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((QuickPromotionLargeImageCreativeContentView) view).m9718a();
    }

    static {
        Builder d = Builder.d();
        d.b = -2.0f;
        f8906c = d.i();
    }

    public static QuickPromotionLargeImageCreativeContentPartDefinition m9647a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionLargeImageCreativeContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8908l) {
                QuickPromotionLargeImageCreativeContentPartDefinition quickPromotionLargeImageCreativeContentPartDefinition;
                if (a2 != null) {
                    quickPromotionLargeImageCreativeContentPartDefinition = (QuickPromotionLargeImageCreativeContentPartDefinition) a2.a(f8908l);
                } else {
                    quickPromotionLargeImageCreativeContentPartDefinition = f8907k;
                }
                if (quickPromotionLargeImageCreativeContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9649b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8908l, b3);
                        } else {
                            f8907k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionLargeImageCreativeContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionLargeImageCreativeContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, QuickPromotionActionHandler quickPromotionActionHandler, Lazy<QuickPromotionLogger> lazy, Provider<StoryImageSizes> provider, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoPrefetchPartDefinition videoPrefetchPartDefinition) {
        this.f8910d = backgroundPartDefinition;
        this.f8911e = menuButtonPartDefinition;
        this.f8912f = quickPromotionActionHandler;
        this.f8913g = lazy;
        this.f8914h = provider;
        this.f8915i = videoAutoPlaySettingsChecker;
        this.f8916j = videoPrefetchPartDefinition;
    }

    public final ViewType m9650a() {
        return f8905a;
    }

    private State m9646a(SubParts<E> subParts, FeedProps<GraphQLQuickPromotionFeedUnit> feedProps) {
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedProps.a;
        subParts.a(this.f8910d, new StylingData(feedProps, f8906c));
        if (!QuickPromotionFeedUnitUtils.m9625a(graphQLQuickPromotionFeedUnit)) {
            subParts.a(2131566490, this.f8911e, new Props(feedProps, MenuConfig.CLICKABLE));
        }
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        boolean a = QuickPromotionFeedUnitUtils.m9625a(graphQLQuickPromotionFeedUnit);
        LargeImageProfilePhotoOption h = QuickPromotionFeedUnitUtils.m9632h(b.l().j());
        GraphQLImage o = c.o();
        GraphQLImage j = c.j();
        GraphQLVideo b2 = (c.a() == null || c.a().r() == null) ? null : GraphQLMediaConversionHelper.b(c.a().r());
        if (b2 != null) {
            subParts.a(this.f8916j, new VideoPrefetchPartDefinition.Props(feedProps.a(c.a()), -1));
        }
        OnClickListener a2 = m9645a(QuickPromotionFeedUnitUtils.m9622a(b.l().j()), c, b.k());
        if (b2 == null || Strings.isNullOrEmpty(b2.aE())) {
            b2 = null;
        }
        return new State(b, c, o, j, b2, c.s(), c.k(), c.m(), a2, a, h);
    }

    private OnClickListener m9645a(FeedTapAction feedTapAction, final GraphQLQuickPromotionCreative graphQLQuickPromotionCreative, final String str) {
        if (feedTapAction == FeedTapAction.USE_PRIMARY_ACTION && m9648a(graphQLQuickPromotionCreative.p())) {
            return new OnClickListener(this) {
                final /* synthetic */ QuickPromotionLargeImageCreativeContentPartDefinition f8890c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 836292470);
                    this.f8890c.f8912f.a(Uri.parse(graphQLQuickPromotionCreative.p().j()));
                    ((QuickPromotionLogger) this.f8890c.f8913g.get()).a(ActionType.PRIMARY_ACTION, str);
                    Logger.a(2, EntryType.UI_INPUT_END, 663816342, a);
                }
            };
        }
        return (feedTapAction == FeedTapAction.USE_SECONDARY_ACTION && m9648a(graphQLQuickPromotionCreative.q())) ? new OnClickListener(this) {
            final /* synthetic */ QuickPromotionLargeImageCreativeContentPartDefinition f8893c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1177990356);
                this.f8893c.f8912f.a(Uri.parse(graphQLQuickPromotionCreative.q().j()));
                ((QuickPromotionLogger) this.f8893c.f8913g.get()).a(ActionType.SECONDARY_ACTION, str);
                Logger.a(2, EntryType.UI_INPUT_END, 1235717853, a);
            }
        } : null;
    }

    private static boolean m9648a(GraphQLQuickPromotionAction graphQLQuickPromotionAction) {
        return graphQLQuickPromotionAction != null && QuickPromotionFeedUnitUtils.m9623a(graphQLQuickPromotionAction);
    }
}

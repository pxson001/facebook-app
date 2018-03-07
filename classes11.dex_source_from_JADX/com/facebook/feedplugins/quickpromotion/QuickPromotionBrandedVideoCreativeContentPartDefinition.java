package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.feedplugins.quickpromotion.ui.QuickPromotionLargeImageCreativeContentView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.story.StoryImageSizes;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: chained_story_title_impression */
public class QuickPromotionBrandedVideoCreativeContentPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, State, E, QuickPromotionLargeImageCreativeContentView> {
    public static final ViewType f8847a = new C10761();
    private static final PaddingStyle f8848b;
    private static QuickPromotionBrandedVideoCreativeContentPartDefinition f8849f;
    private static final Object f8850g = new Object();
    private final BackgroundPartDefinition f8851c;
    private final MenuButtonPartDefinition f8852d;
    public final Provider<StoryImageSizes> f8853e;

    /* compiled from: chained_story_title_impression */
    final class C10761 extends ViewType {
        C10761() {
        }

        public final View m9593a(Context context) {
            return new QuickPromotionLargeImageCreativeContentView(context);
        }
    }

    /* compiled from: chained_story_title_impression */
    public class State {
        public final GraphQLQuickPromotion f8841a;
        public final GraphQLImage f8842b;
        public final GraphQLImage f8843c;
        public final GraphQLTextWithEntities f8844d;
        public final GraphQLTextWithEntities f8845e;
        public final GraphQLTextWithEntities f8846f;

        public State(GraphQLQuickPromotion graphQLQuickPromotion, GraphQLImage graphQLImage, GraphQLImage graphQLImage2, GraphQLTextWithEntities graphQLTextWithEntities, GraphQLTextWithEntities graphQLTextWithEntities2, GraphQLTextWithEntities graphQLTextWithEntities3) {
            this.f8841a = graphQLQuickPromotion;
            this.f8842b = graphQLImage;
            this.f8843c = graphQLImage2;
            this.f8844d = graphQLTextWithEntities;
            this.f8845e = graphQLTextWithEntities2;
            this.f8846f = graphQLTextWithEntities3;
        }
    }

    private static QuickPromotionBrandedVideoCreativeContentPartDefinition m9595b(InjectorLike injectorLike) {
        return new QuickPromotionBrandedVideoCreativeContentPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 3479));
    }

    public final Object m9597a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedProps.a;
        subParts.a(this.f8851c, new StylingData(feedProps, f8848b));
        subParts.a(2131566490, this.f8852d, new Props(feedProps, MenuConfig.CLICKABLE));
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        return new State(b, c.o(), c.j(), c.s(), c.k(), c.m());
    }

    public final /* bridge */ /* synthetic */ void m9598a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 918735356);
        State state = (State) obj2;
        QuickPromotionLargeImageCreativeContentView quickPromotionLargeImageCreativeContentView = (QuickPromotionLargeImageCreativeContentView) view;
        quickPromotionLargeImageCreativeContentView.setTitleText(state.f8844d);
        quickPromotionLargeImageCreativeContentView.m9722a(state.f8845e, 0);
        quickPromotionLargeImageCreativeContentView.m9723a(state.f8846f, state.f8841a.l().j());
        quickPromotionLargeImageCreativeContentView.setBrandingImage(state.f8843c);
        quickPromotionLargeImageCreativeContentView.m9721a(state.f8842b, null, ((StoryImageSizes) this.f8853e.get()).c);
        quickPromotionLargeImageCreativeContentView.setMenuButtonActive(true);
        Logger.a(8, EntryType.MARK_POP, -502968184, a);
    }

    public final boolean m9599a(Object obj) {
        GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a);
        return (b == null || b.l() == null || QuickPromotionTemplate.NEWSFEED_BRANDED_VIDEO != QuickPromotionTemplate.fromString(b.l().a())) ? false : true;
    }

    public final void m9600b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((QuickPromotionLargeImageCreativeContentView) view).m9718a();
    }

    static {
        Builder d = Builder.d();
        d.b = -2.0f;
        f8848b = d.i();
    }

    public static QuickPromotionBrandedVideoCreativeContentPartDefinition m9594a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionBrandedVideoCreativeContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8850g) {
                QuickPromotionBrandedVideoCreativeContentPartDefinition quickPromotionBrandedVideoCreativeContentPartDefinition;
                if (a2 != null) {
                    quickPromotionBrandedVideoCreativeContentPartDefinition = (QuickPromotionBrandedVideoCreativeContentPartDefinition) a2.a(f8850g);
                } else {
                    quickPromotionBrandedVideoCreativeContentPartDefinition = f8849f;
                }
                if (quickPromotionBrandedVideoCreativeContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9595b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8850g, b3);
                        } else {
                            f8849f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionBrandedVideoCreativeContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionBrandedVideoCreativeContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, Provider<StoryImageSizes> provider) {
        this.f8851c = backgroundPartDefinition;
        this.f8852d = menuButtonPartDefinition;
        this.f8853e = provider;
    }

    public final ViewType<QuickPromotionLargeImageCreativeContentView> m9596a() {
        return f8847a;
    }
}

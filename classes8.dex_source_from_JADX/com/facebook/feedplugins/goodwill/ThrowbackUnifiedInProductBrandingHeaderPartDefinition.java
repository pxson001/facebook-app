package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageOverlay;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: go_live_tap */
public class ThrowbackUnifiedInProductBrandingHeaderPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, State, E, ThrowbackUnifiedInProductBrandingHeaderView> {
    public static final ViewType f12558a = new C13121();
    private static final CallerContext f12559b = CallerContext.a(ThrowbackUnifiedInProductBrandingHeaderPartDefinition.class, "goodwill_throwback");
    private static final PaddingStyle f12560c = Builder.f().i();
    private static ThrowbackUnifiedInProductBrandingHeaderPartDefinition f12561k;
    private static final Object f12562l = new Object();
    private final MenuButtonPartDefinition f12563d;
    private final BackgroundPartDefinition f12564e;
    private final ClickListenerPartDefinition f12565f;
    public final Lazy<DefaultFeedUnitRenderer> f12566g;
    private final LinkifyUtil f12567h;
    private final Resources f12568i;
    private final QeAccessor f12569j;

    /* compiled from: go_live_tap */
    final class C13121 extends ViewType {
        C13121() {
        }

        public final View m14429a(Context context) {
            return new ThrowbackUnifiedInProductBrandingHeaderView(context);
        }
    }

    /* compiled from: go_live_tap */
    public class State {
        public final String f12550a;
        public final CharSequence f12551b;
        public final GraphQLImage f12552c;
        public final GraphQLImage f12553d;
        public final GraphQLImage f12554e;
        public final GraphQLImage f12555f;
        public final int f12556g;
        @Nullable
        public final Integer f12557h;

        public State(String str, CharSequence charSequence, GraphQLImage graphQLImage, GraphQLImage graphQLImage2, GraphQLImage graphQLImage3, GraphQLImage graphQLImage4, int i, @Nullable Integer num) {
            this.f12550a = str;
            this.f12551b = charSequence;
            this.f12552c = graphQLImage;
            this.f12553d = graphQLImage2;
            this.f12554e = graphQLImage3;
            this.f12555f = graphQLImage4;
            this.f12556g = i;
            this.f12557h = num;
        }
    }

    private static ThrowbackUnifiedInProductBrandingHeaderPartDefinition m14434b(InjectorLike injectorLike) {
        return new ThrowbackUnifiedInProductBrandingHeaderPartDefinition(MenuButtonPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), IdBasedLazy.a(injectorLike, 1473), LinkifyUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m14437a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m14431a(subParts, (FeedProps) obj);
    }

    public final boolean m14439a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit) != null) {
            return "friendversary_polaroids_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_card_collage_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friend_birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_video_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "self_birthday_profile_pic_frame".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F());
        } else {
            return false;
        }
    }

    public static ThrowbackUnifiedInProductBrandingHeaderPartDefinition m14432a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackUnifiedInProductBrandingHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12562l) {
                ThrowbackUnifiedInProductBrandingHeaderPartDefinition throwbackUnifiedInProductBrandingHeaderPartDefinition;
                if (a2 != null) {
                    throwbackUnifiedInProductBrandingHeaderPartDefinition = (ThrowbackUnifiedInProductBrandingHeaderPartDefinition) a2.a(f12562l);
                } else {
                    throwbackUnifiedInProductBrandingHeaderPartDefinition = f12561k;
                }
                if (throwbackUnifiedInProductBrandingHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14434b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12562l, b3);
                        } else {
                            f12561k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackUnifiedInProductBrandingHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackUnifiedInProductBrandingHeaderPartDefinition(MenuButtonPartDefinition menuButtonPartDefinition, BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Lazy<DefaultFeedUnitRenderer> lazy, LinkifyUtil linkifyUtil, QeAccessor qeAccessor, Resources resources) {
        this.f12563d = menuButtonPartDefinition;
        this.f12564e = backgroundPartDefinition;
        this.f12565f = clickListenerPartDefinition;
        this.f12566g = lazy;
        this.f12567h = linkifyUtil;
        this.f12569j = qeAccessor;
        this.f12568i = resources;
    }

    public final ViewType m14436a() {
        return f12558a;
    }

    private State m14431a(SubParts<E> subParts, FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps) {
        GraphQLImage graphQLImage;
        Integer num;
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a();
        GraphQLImage A = graphQLGoodwillThrowbackPromotionFeedUnit.A();
        GraphQLImage z = graphQLGoodwillThrowbackPromotionFeedUnit.z();
        GraphQLTextWithEntities x = graphQLGoodwillThrowbackPromotionFeedUnit.x();
        GraphQLTextWithEntities I = graphQLGoodwillThrowbackPromotionFeedUnit.I();
        int i = 0;
        GraphQLImage graphQLImage2 = null;
        if ("friend_birthday_ipb".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a()).F()) || "self_birthday_profile_pic_frame".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a()).F())) {
            graphQLImage2 = GoodwillFeedUnitHelper.a(graphQLGoodwillThrowbackPromotionFeedUnit);
            GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
            if (graphQLImage2 != null) {
                GraphQLImage graphQLImage3;
                i = 2130842777;
                if (g == null || g.G() == null || g.G().isEmpty()) {
                    graphQLImage3 = null;
                } else {
                    graphQLImage3 = ((GraphQLImageOverlay) g.G().get(0)).m();
                }
                if (!(!m14435b() || g == null || g.k() == null)) {
                    subParts.a(2131560271, this.f12565f, m14430a(g.k()));
                }
                graphQLImage = graphQLImage3;
                subParts.a(this.f12564e, new StylingData(feedProps, f12560c, 2130839797, -1));
                subParts.a(2131560877, this.f12563d, new Props(feedProps, MenuConfig.CLICKABLE));
                num = null;
                if (!(graphQLGoodwillThrowbackPromotionFeedUnit.w() == null || graphQLGoodwillThrowbackPromotionFeedUnit.w().a() == null || graphQLGoodwillThrowbackPromotionFeedUnit.w().a().isEmpty())) {
                    num = Integer.valueOf((int) Long.parseLong(graphQLGoodwillThrowbackPromotionFeedUnit.w().a(), 16));
                }
                return new State(x != null ? null : x.a(), I != null ? null : this.f12567h.a(LinkifyUtilConverter.c(I), true, null), A, z, graphQLImage2, graphQLImage, i, num);
            }
        }
        graphQLImage = null;
        subParts.a(this.f12564e, new StylingData(feedProps, f12560c, 2130839797, -1));
        subParts.a(2131560877, this.f12563d, new Props(feedProps, MenuConfig.CLICKABLE));
        num = null;
        num = Integer.valueOf((int) Long.parseLong(graphQLGoodwillThrowbackPromotionFeedUnit.w().a(), 16));
        if (x != null) {
        }
        if (I != null) {
        }
        return new State(x != null ? null : x.a(), I != null ? null : this.f12567h.a(LinkifyUtilConverter.c(I), true, null), A, z, graphQLImage2, graphQLImage, i, num);
    }

    private void m14433a(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps, State state, E e, ThrowbackUnifiedInProductBrandingHeaderView throwbackUnifiedInProductBrandingHeaderView) {
        throwbackUnifiedInProductBrandingHeaderView.f12579j = "self_birthday_profile_pic_frame".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F());
        CharSequence charSequence = state.f12550a;
        CharSequence charSequence2 = state.f12551b;
        throwbackUnifiedInProductBrandingHeaderView.f12571b.setText(charSequence);
        if (throwbackUnifiedInProductBrandingHeaderView.f12579j) {
            throwbackUnifiedInProductBrandingHeaderView.f12571b.setTextSize(2, 20.0f);
            CustomFontHelper.a(throwbackUnifiedInProductBrandingHeaderView.f12571b, FontFamily.ROBOTO, FontWeight.MEDIUM, throwbackUnifiedInProductBrandingHeaderView.f12571b.getTypeface());
            throwbackUnifiedInProductBrandingHeaderView.f12571b.setPadding(0, throwbackUnifiedInProductBrandingHeaderView.getResources().getDimensionPixelSize(2131432812), 0, 0);
        } else {
            throwbackUnifiedInProductBrandingHeaderView.f12571b.setTextAppearance(throwbackUnifiedInProductBrandingHeaderView.f12571b.getContext(), 2131626217);
            throwbackUnifiedInProductBrandingHeaderView.f12571b.setPadding(0, throwbackUnifiedInProductBrandingHeaderView.getResources().getDimensionPixelSize(2131432808), 0, 0);
        }
        throwbackUnifiedInProductBrandingHeaderView.f12572c.setText(charSequence2);
        GraphQLImage graphQLImage = state.f12552c;
        CallerContext callerContext = f12559b;
        throwbackUnifiedInProductBrandingHeaderView.f12570a = graphQLImage;
        throwbackUnifiedInProductBrandingHeaderView.f12573d.a(graphQLImage == null ? null : ImageUtil.a(graphQLImage), callerContext);
        throwbackUnifiedInProductBrandingHeaderView.requestLayout();
        graphQLImage = state.f12553d;
        throwbackUnifiedInProductBrandingHeaderView.f12578i.a(graphQLImage == null ? null : ImageUtil.a(graphQLImage), f12559b);
        LayoutParams layoutParams = throwbackUnifiedInProductBrandingHeaderView.f12578i.getLayoutParams();
        layoutParams.height = graphQLImage.a();
        layoutParams.width = graphQLImage.c();
        throwbackUnifiedInProductBrandingHeaderView.requestLayout();
        graphQLImage = state.f12554e;
        callerContext = f12559b;
        throwbackUnifiedInProductBrandingHeaderView.f12576g = graphQLImage;
        if (graphQLImage != null) {
            throwbackUnifiedInProductBrandingHeaderView.f12574e.a(ImageUtil.a(graphQLImage), callerContext);
            throwbackUnifiedInProductBrandingHeaderView.f12574e.setVisibility(0);
        } else {
            throwbackUnifiedInProductBrandingHeaderView.f12574e.setVisibility(8);
        }
        throwbackUnifiedInProductBrandingHeaderView.requestLayout();
        graphQLImage = state.f12555f;
        callerContext = f12559b;
        if (graphQLImage != null) {
            throwbackUnifiedInProductBrandingHeaderView.f12575f.a(ImageUtil.a(graphQLImage), callerContext);
            throwbackUnifiedInProductBrandingHeaderView.f12575f.setVisibility(0);
        } else {
            throwbackUnifiedInProductBrandingHeaderView.f12575f.setVisibility(8);
        }
        int i = state.f12556g;
        int dimensionPixelSize = throwbackUnifiedInProductBrandingHeaderView.getContext().getResources().getDimensionPixelSize(throwbackUnifiedInProductBrandingHeaderView.f12579j ? 2131432810 : 2131432809);
        if (i == 0) {
            dimensionPixelSize = 0;
        }
        throwbackUnifiedInProductBrandingHeaderView.f12574e.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        throwbackUnifiedInProductBrandingHeaderView.f12574e.setBackgroundResource(i);
        throwbackUnifiedInProductBrandingHeaderView.f12575f.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        Integer num = state.f12557h;
        throwbackUnifiedInProductBrandingHeaderView.f12577h.setGlyphColor(num != null ? ColorStateList.valueOf(num.intValue()) : null);
        super.a(feedProps, state, e, throwbackUnifiedInProductBrandingHeaderView);
    }

    private OnClickListener m14430a(final GraphQLProfile graphQLProfile) {
        return new OnClickListener(this) {
            final /* synthetic */ ThrowbackUnifiedInProductBrandingHeaderPartDefinition f12549b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 134495118);
                ((DefaultFeedUnitRenderer) this.f12549b.f12566g.get()).a(view, LinkifyTargetBuilder.a(graphQLProfile), null);
                Logger.a(2, EntryType.UI_INPUT_END, -1953487112, a);
            }
        };
    }

    private boolean m14435b() {
        return this.f12569j.a(Liveness.Live, ExperimentsForGoodwillFeedModule.f12225a, false);
    }
}

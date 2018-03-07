package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Callbacks;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.ImageOverlay;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.Type;
import com.facebook.feedplugins.quickpromotion.ui.QuickPromotionCreativeContentView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLQPTemplateParameter;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionCreative;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cert */
public class QuickPromotionCreativeContentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, UserTileViewParams, HasPositionInformation, QuickPromotionCreativeContentView> {
    public static final ViewType f8861a = new C10771();
    private static final CallerContext f8862b = CallerContext.a(QuickPromotionCreativeContentPartDefinition.class, "quick_promotion_feed", "quickpromotion");
    private static QuickPromotionCreativeContentPartDefinition f8863f;
    private static final Object f8864g = new Object();
    private final BackgroundPartDefinition f8865c;
    private final DraweeControllerPartDefinition<QuickPromotionCreativeContentView> f8866d;
    private final Context f8867e;

    /* compiled from: cert */
    final class C10771 extends ViewType {
        C10771() {
        }

        public final View m9605a(Context context) {
            return new QuickPromotionCreativeContentView(context);
        }
    }

    private static QuickPromotionCreativeContentPartDefinition m9612b(InjectorLike injectorLike) {
        return new QuickPromotionCreativeContentPartDefinition(BackgroundPartDefinition.a(injectorLike), DraweeControllerPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m9614a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f8865c, new StylingData(feedProps, PaddingStyle.a));
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedProps.a;
        final GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit);
        ImageOverlay a = m9610a(QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit));
        if (a == null || a.equals(ImageOverlay.UNKNOWN)) {
            subParts.a(this.f8866d, new Props(f8862b, new Callbacks<QuickPromotionCreativeContentView>(this) {
                final /* synthetic */ QuickPromotionCreativeContentPartDefinition f8860b;

                public final void m9608a(View view, @Nullable DraweeController draweeController) {
                    QuickPromotionCreativeContentView quickPromotionCreativeContentView = (QuickPromotionCreativeContentView) view;
                    quickPromotionCreativeContentView.f9010j.setController(draweeController);
                    quickPromotionCreativeContentView.m9712a();
                    quickPromotionCreativeContentView.setShowThumbnail(draweeController != null);
                }

                public final ImageRequest m9607a() {
                    if (m9606b() == null) {
                        return null;
                    }
                    return ImageRequest.a(ImageUtil.a(m9606b()));
                }

                private GraphQLImage m9606b() {
                    return c.n();
                }
            }, false, false));
        }
        return m9611a(c, a);
    }

    public final /* bridge */ /* synthetic */ void m9615a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 980077704);
        UserTileViewParams userTileViewParams = (UserTileViewParams) obj2;
        QuickPromotionCreativeContentView quickPromotionCreativeContentView = (QuickPromotionCreativeContentView) view;
        GraphQLQuickPromotionCreative c = QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a);
        GraphQLTextWithEntities s = c.s();
        if (QuickPromotionFeedUnitUtils.m9626a(s)) {
            quickPromotionCreativeContentView.f9008h.a(s, quickPromotionCreativeContentView.f9008h.getTextSize(), 1);
            quickPromotionCreativeContentView.f9008h.setVisibility(0);
        } else {
            quickPromotionCreativeContentView.f9008h.setVisibility(8);
        }
        s = c.k();
        if (QuickPromotionFeedUnitUtils.m9626a(s)) {
            quickPromotionCreativeContentView.f9009i.a(s, quickPromotionCreativeContentView.f9009i.getTextSize(), 1);
            quickPromotionCreativeContentView.f9009i.setVisibility(0);
        } else {
            quickPromotionCreativeContentView.f9009i.setVisibility(8);
        }
        if (!(c.n() == null || userTileViewParams == null)) {
            quickPromotionCreativeContentView.f9011k.setParams(userTileViewParams);
            quickPromotionCreativeContentView.setGravity(19);
            quickPromotionCreativeContentView.f9011k.setVisibility(0);
            quickPromotionCreativeContentView.f9010j.setVisibility(8);
            quickPromotionCreativeContentView.setShowThumbnail(true);
            quickPromotionCreativeContentView.setThumbnailGravity(16);
        }
        Logger.a(8, EntryType.MARK_POP, 1586998922, a);
    }

    public final boolean m9616a(Object obj) {
        return QuickPromotionFeedUnitHelper.c((GraphQLQuickPromotionFeedUnit) ((FeedProps) obj).a) != null;
    }

    public final void m9617b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((QuickPromotionCreativeContentView) view).m9712a();
    }

    public static QuickPromotionCreativeContentPartDefinition m9609a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionCreativeContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8864g) {
                QuickPromotionCreativeContentPartDefinition quickPromotionCreativeContentPartDefinition;
                if (a2 != null) {
                    quickPromotionCreativeContentPartDefinition = (QuickPromotionCreativeContentPartDefinition) a2.a(f8864g);
                } else {
                    quickPromotionCreativeContentPartDefinition = f8863f;
                }
                if (quickPromotionCreativeContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9612b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8864g, b3);
                        } else {
                            f8863f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionCreativeContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public QuickPromotionCreativeContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, DraweeControllerPartDefinition draweeControllerPartDefinition, Context context) {
        this.f8865c = backgroundPartDefinition;
        this.f8866d = draweeControllerPartDefinition;
        this.f8867e = context;
    }

    public final ViewType m9613a() {
        return f8861a;
    }

    @Nullable
    private UserTileViewParams m9611a(GraphQLQuickPromotionCreative graphQLQuickPromotionCreative, ImageOverlay imageOverlay) {
        if (imageOverlay == null || imageOverlay.equals(ImageOverlay.UNKNOWN)) {
            return null;
        }
        ImmutableMap of = ImmutableMap.of(ImageOverlay.CIRCLE_CROP, TileBadge.NONE, ImageOverlay.FACEBOOK_BADGE, TileBadge.FACEBOOK, ImageOverlay.MESSENGER_BADGE, TileBadge.MESSENGER);
        GraphQLImage n = graphQLQuickPromotionCreative.n();
        if (n == null || !of.containsKey(imageOverlay)) {
            return null;
        }
        return UserTileViewParams.a(new PicSquare(new PicSquareUrlWithSize((int) this.f8867e.getResources().getDimension(2131434632), n.b()), null, null), (TileBadge) of.get(imageOverlay));
    }

    private static ImageOverlay m9610a(GraphQLQuickPromotion graphQLQuickPromotion) {
        ImmutableList j = graphQLQuickPromotion.l().j();
        if (j == null || j.isEmpty()) {
            return null;
        }
        int size = j.size();
        for (int i = 0; i < size; i++) {
            GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) j.get(i);
            if (Type.IMAGE_OVERLAY.equals(Type.fromString(graphQLQPTemplateParameter.j()))) {
                return ImageOverlay.fromString(graphQLQPTemplateParameter.l());
            }
        }
        return null;
    }
}

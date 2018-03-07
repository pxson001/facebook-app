package com.facebook.feedplugins.goodwill;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackShareComposerLauncher;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackShareComposerLauncherProvider;
import com.facebook.goodwill.composer.GoodwillComposerActivity;
import com.facebook.goodwill.composer.GoodwillComposerEvent;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPluginConfig;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.intent.SharePreview.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gms_upsell_result_canceled */
public class ThrowbackUnifiedSharePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f12599a = new C13151();
    private static final PaddingStyle f12600b;
    private static ThrowbackUnifiedSharePartDefinition f12601j;
    private static final Object f12602k = new Object();
    private final BackgroundPartDefinition f12603c;
    private final ClickListenerPartDefinition f12604d;
    public final SecureContextHelper f12605e;
    public final ThrowbackShareComposerLauncherProvider f12606f;
    public final ComposerLauncher f12607g;
    public final JsonPluginConfigSerializer f12608h;
    private final AllCapsTransformationMethod f12609i;

    /* compiled from: gms_upsell_result_canceled */
    final class C13151 extends ViewType {
        C13151() {
        }

        public final View m14446a(Context context) {
            return LayoutInflater.from(context).inflate(2130907424, null);
        }
    }

    private static ThrowbackUnifiedSharePartDefinition m14450b(InjectorLike injectorLike) {
        return new ThrowbackUnifiedSharePartDefinition(BackgroundPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (ThrowbackShareComposerLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ThrowbackShareComposerLauncherProvider.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), JsonPluginConfigSerializer.b(injectorLike), AllCapsTransformationMethod.b(injectorLike));
    }

    public final Object m14453a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ThrowbackShareComposerLauncher throwbackShareComposerLauncher;
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12603c, new StylingData(feedProps, f12600b));
        ClickListenerPartDefinition clickListenerPartDefinition = this.f12604d;
        final GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        if (!GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit)) {
            ThrowbackShareComposerLauncher throwbackShareComposerLauncher2;
            GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit2 = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
            if (graphQLGoodwillThrowbackPromotionFeedUnit2.E() == null || graphQLGoodwillThrowbackPromotionFeedUnit2.E().a() == null || graphQLGoodwillThrowbackPromotionFeedUnit2.E().a().isEmpty() || graphQLGoodwillThrowbackPromotionFeedUnit2.E().a().get(0) == null) {
                throwbackShareComposerLauncher2 = null;
            } else {
                throwbackShareComposerLauncher2 = this.f12606f.a(feedProps.a((GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit2.E().a().get(0)), ComposerSourceType.ON_THIS_DAY_PROMO, "goodwill_throwback_promotion_ufi");
            }
            throwbackShareComposerLauncher = throwbackShareComposerLauncher2;
        } else if ("friendversary_polaroids".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_polaroids_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_card_data".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
            int i;
            SharePreview a;
            GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit);
            if (g.u() == null || g.u().isEmpty() || g.u().get(0) == null || ((GraphQLStoryAttachment) g.u().get(0)).r() == null || ((GraphQLStoryAttachment) g.u().get(0)).r().S() == null || ((GraphQLStoryAttachment) g.u().get(0)).r().S().b() == null) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                Builder builder = new Builder();
                builder.a = g.E().a();
                builder = builder;
                builder.d = ((GraphQLStoryAttachment) g.u().get(0)).r().S().b().toString();
                a = builder.a();
            } else {
                a = null;
            }
            throwbackShareComposerLauncher = new OnClickListener(this) {
                final /* synthetic */ ThrowbackUnifiedSharePartDefinition f12595c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -501334861);
                    ComposerConfiguration.Builder pluginConfig = ComposerConfiguration.newBuilder().setComposerType(ComposerType.STATUS).setSourceType(ComposerSourceType.ON_THIS_DAY_FRIENDVERSARY_CARD).setPluginConfig(this.f12595c.f12608h.a(GoodwillFriendversaryCardComposerPluginConfig.m129a("throwback_promotion", GoodwillFeedUnitHelper.g(graphQLGoodwillThrowbackPromotionFeedUnit).t())));
                    ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a();
                    a2.d = a;
                    this.f12595c.f12607g.a(null, pluginConfig.setInitialShareParams(a2.b()).setIsFireAndForget(true).a(), 1756, (Activity) ContextUtils.a(view.getContext(), Activity.class));
                    Logger.a(2, EntryType.UI_INPUT_END, 1836307331, a);
                }
            };
        } else {
            String str = "mle";
            if ("friendversary_card_collage".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friendversary_card_collage_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F())) {
                str = "friendversary_collage";
            }
            final GraphQLGoodwillCampaign graphQLGoodwillCampaign = (GraphQLGoodwillCampaign) graphQLGoodwillThrowbackPromotionFeedUnit.v().a().get(0);
            throwbackShareComposerLauncher = new OnClickListener(this) {
                final /* synthetic */ ThrowbackUnifiedSharePartDefinition f12598c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1344096284);
                    Context context = view.getContext();
                    this.f12598c.f12605e.a(GoodwillComposerActivity.m66a(context, ThrowbackUnifiedSharePartDefinition.m14451b(context, graphQLGoodwillCampaign), new String[]{"photos"}, str), context);
                    Logger.a(2, EntryType.UI_INPUT_END, -1113887854, a);
                }
            };
        }
        subParts.a(clickListenerPartDefinition, throwbackShareComposerLauncher);
        return null;
    }

    static {
        PaddingStyle.Builder d = PaddingStyle.Builder.d();
        d.b = -2.0f;
        d = d;
        d.c = -2.0f;
        f12600b = d.i();
    }

    public static ThrowbackUnifiedSharePartDefinition m14447a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackUnifiedSharePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12602k) {
                ThrowbackUnifiedSharePartDefinition throwbackUnifiedSharePartDefinition;
                if (a2 != null) {
                    throwbackUnifiedSharePartDefinition = (ThrowbackUnifiedSharePartDefinition) a2.a(f12602k);
                } else {
                    throwbackUnifiedSharePartDefinition = f12601j;
                }
                if (throwbackUnifiedSharePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14450b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12602k, b3);
                        } else {
                            f12601j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackUnifiedSharePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackUnifiedSharePartDefinition(BackgroundPartDefinition backgroundPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, SecureContextHelper secureContextHelper, ThrowbackShareComposerLauncherProvider throwbackShareComposerLauncherProvider, ComposerLauncher composerLauncher, JsonPluginConfigSerializer jsonPluginConfigSerializer, AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f12603c = backgroundPartDefinition;
        this.f12604d = clickListenerPartDefinition;
        this.f12605e = secureContextHelper;
        this.f12606f = throwbackShareComposerLauncherProvider;
        this.f12607g = composerLauncher;
        this.f12608h = jsonPluginConfigSerializer;
        this.f12609i = allCapsTransformationMethod;
    }

    public final ViewType m14452a() {
        return f12599a;
    }

    public final boolean m14455a(Object obj) {
        return true;
    }

    public static GoodwillComposerEvent m14451b(Context context, GraphQLGoodwillCampaign graphQLGoodwillCampaign) {
        GoodwillComposerEvent goodwillComposerEvent = new GoodwillComposerEvent(graphQLGoodwillCampaign.t(), m14448a(graphQLGoodwillCampaign.A()), m14448a(graphQLGoodwillCampaign.z()), context.getString(2131239210), context.getString(2131239213), context.getString(2131239214), graphQLGoodwillCampaign.jK_(), "throwback_promotion");
        if (graphQLGoodwillCampaign.u() != null) {
            ImmutableList u = graphQLGoodwillCampaign.u();
            int size = u.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) u.get(i);
                if (graphQLStoryAttachment.r() != null) {
                    goodwillComposerEvent.m91a(new GoodwillPhoto(graphQLStoryAttachment.r()));
                }
            }
        }
        return goodwillComposerEvent;
    }

    private static String m14448a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? graphQLTextWithEntities.a() : "";
    }

    private void m14449a(FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit> feedProps, Void voidR, HasPositionInformation hasPositionInformation, View view) {
        super.a(feedProps, voidR, hasPositionInformation, view);
        ((TextView) view.findViewById(2131567897)).setTransformationMethod(this.f12609i);
    }
}

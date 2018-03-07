package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.goodwill.ThrowbackCallToActionTextPartDefinition.Props;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gms_upsell_result_failed */
public class ThrowbackUnifiedSeeMorePartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, HasPositionInformation, View> {
    public static final ViewType f12583a = ViewType.a(2130907423);
    private static final PaddingStyle f12584b;
    private static ThrowbackUnifiedSeeMorePartDefinition f12585i;
    private static final Object f12586j = new Object();
    private final ClickListenerPartDefinition f12587c;
    public final FbUriIntentHandler f12588d;
    private final BackgroundPartDefinition f12589e;
    private final QeAccessor f12590f;
    private final ThrowbackCallToActionTextPartDefinition f12591g;
    private final Resources f12592h;

    private static ThrowbackUnifiedSeeMorePartDefinition m14442b(InjectorLike injectorLike) {
        return new ThrowbackUnifiedSeeMorePartDefinition(ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), BackgroundPartDefinition.a(injectorLike), ThrowbackCallToActionTextPartDefinition.m14287a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m14444a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String a;
        int color;
        FeedProps feedProps = (FeedProps) obj;
        final GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a;
        final GraphQLStoryActionLink graphQLStoryActionLink = (graphQLGoodwillThrowbackPromotionFeedUnit.H() == null || graphQLGoodwillThrowbackPromotionFeedUnit.H().isEmpty()) ? null : (GraphQLStoryActionLink) graphQLGoodwillThrowbackPromotionFeedUnit.H().get(0);
        if (graphQLStoryActionLink == null || TextUtils.isEmpty(graphQLStoryActionLink.aB())) {
            a = graphQLGoodwillThrowbackPromotionFeedUnit.u().a();
        } else {
            a = graphQLStoryActionLink.aB();
        }
        if (a == null) {
            a = "";
        }
        boolean equals = "birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F());
        if (equals) {
            color = this.f12592h.getColor(2131363661);
        } else {
            color = this.f12592h.getColor(2131362801);
        }
        subParts.a(2131567899, this.f12591g, new Props(color, a));
        subParts.a(this.f12587c, new OnClickListener(this) {
            final /* synthetic */ ThrowbackUnifiedSeeMorePartDefinition f12582c;

            public void onClick(View view) {
                String aE;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2035264450);
                if (graphQLStoryActionLink != null) {
                    aE = graphQLStoryActionLink.aE();
                } else {
                    Object t;
                    boolean f = GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit);
                    if (f) {
                        t = ((GraphQLGoodwillCampaign) graphQLGoodwillThrowbackPromotionFeedUnit.v().a().get(0)).t();
                    } else {
                        String str = "none";
                    }
                    aE = StringFormatUtil.formatStrLocaleSafe(FBLinks.ek, "promotion_feed_story", t, f ? "none" : ((GraphQLStory) graphQLGoodwillThrowbackPromotionFeedUnit.E().a().get(0)).c());
                }
                this.f12582c.f12588d.a(view.getContext(), aE);
                LogUtils.a(-1170096298, a);
            }
        });
        if (equals) {
            subParts.a(this.f12589e, new StylingData(feedProps, f12584b, -1, 2130843608));
        } else {
            subParts.a(this.f12589e, new StylingData(feedProps, f12584b, -1, 2130843607));
        }
        return null;
    }

    public final boolean m14445a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        if (graphQLGoodwillThrowbackPromotionFeedUnit != null) {
            if (graphQLGoodwillThrowbackPromotionFeedUnit.H() != null && !graphQLGoodwillThrowbackPromotionFeedUnit.H().isEmpty() && graphQLGoodwillThrowbackPromotionFeedUnit.H().get(0) != null && !TextUtils.isEmpty(((GraphQLStoryActionLink) graphQLGoodwillThrowbackPromotionFeedUnit.H().get(0)).aB()) && !TextUtils.isEmpty(((GraphQLStoryActionLink) graphQLGoodwillThrowbackPromotionFeedUnit.H().get(0)).aE())) {
                return true;
            }
            if (!(graphQLGoodwillThrowbackPromotionFeedUnit.u() == null || TextUtils.isEmpty(graphQLGoodwillThrowbackPromotionFeedUnit.u().a()))) {
                return true;
            }
        }
        return false;
    }

    static {
        Builder d = Builder.d();
        d.b = -2.0f;
        d = d;
        d.c = -8.0f;
        f12584b = d.i();
    }

    public static ThrowbackUnifiedSeeMorePartDefinition m14441a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackUnifiedSeeMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12586j) {
                ThrowbackUnifiedSeeMorePartDefinition throwbackUnifiedSeeMorePartDefinition;
                if (a2 != null) {
                    throwbackUnifiedSeeMorePartDefinition = (ThrowbackUnifiedSeeMorePartDefinition) a2.a(f12586j);
                } else {
                    throwbackUnifiedSeeMorePartDefinition = f12585i;
                }
                if (throwbackUnifiedSeeMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14442b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12586j, b3);
                        } else {
                            f12585i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackUnifiedSeeMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ThrowbackUnifiedSeeMorePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, BackgroundPartDefinition backgroundPartDefinition, ThrowbackCallToActionTextPartDefinition throwbackCallToActionTextPartDefinition, Resources resources, QeAccessor qeAccessor) {
        this.f12587c = clickListenerPartDefinition;
        this.f12588d = fbUriIntentHandler;
        this.f12589e = backgroundPartDefinition;
        this.f12590f = qeAccessor;
        this.f12591g = throwbackCallToActionTextPartDefinition;
        this.f12592h = resources;
    }

    public final ViewType m14443a() {
        return f12583a;
    }
}

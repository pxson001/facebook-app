package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.facebook.graphql.model.GraphQLCustomizedStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
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
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.quickpromotion.action.QuickPromotionActionHandler;
import javax.inject.Inject;

@ContextScoped
/* compiled from: presence_stale */
public class DailyDialogueLightweightHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLCustomizedStory>, Void, FeedEnvironment, View> {
    public static final ViewType f4270a = new C02011();
    private static final CallerContext f4271b = CallerContext.a(DailyDialogueLightweightHeaderPartDefinition.class);
    private static final PaddingStyle f4272c;
    private static DailyDialogueLightweightHeaderPartDefinition f4273l;
    private static final Object f4274m = new Object();
    public final Lazy<GoodwillAnalyticsLogger> f4275d;
    public final Lazy<QuickPromotionActionHandler> f4276e;
    private final BackgroundPartDefinition f4277f;
    private final TextPartDefinition f4278g;
    private final TextOrHiddenPartDefinition f4279h;
    private final FbDraweePartDefinition f4280i;
    private final MenuButtonPartDefinition f4281j;
    private final ClickListenerPartDefinition f4282k;

    /* compiled from: presence_stale */
    final class C02011 extends ViewType {
        C02011() {
        }

        public final View m4812a(Context context) {
            return LayoutInflater.from(context).inflate(2130903839, null);
        }
    }

    private static DailyDialogueLightweightHeaderPartDefinition m4808b(InjectorLike injectorLike) {
        return new DailyDialogueLightweightHeaderPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 2146), IdBasedLazy.a(injectorLike, 9770), BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m4810a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) feedProps.a;
        GraphQLStoryActionLink a = graphQLCustomizedStory.I().a();
        Object a2 = graphQLCustomizedStory.I().n() != null ? graphQLCustomizedStory.I().n().a() : null;
        subParts.a(this.f4277f, new StylingData(feedProps, f4272c));
        subParts.a(2131558927, this.f4278g, graphQLCustomizedStory.I().o().a());
        subParts.a(2131558926, this.f4279h, a2);
        Object obj2 = null;
        if (!(a == null || TextUtils.isEmpty(a.aB()) || TextUtils.isEmpty(a.aE()))) {
            obj2 = 1;
        }
        if (obj2 != null) {
            subParts.a(2131560879, this.f4279h, a.aB());
            subParts.a(2131560878, this.f4282k, new 2(this, a, graphQLCustomizedStory));
        }
        FbDraweePartDefinition fbDraweePartDefinition = this.f4280i;
        Builder a3 = FbDraweePartDefinition.a().a(graphQLCustomizedStory.I().l().b());
        a3.c = f4271b;
        subParts.a(2131560865, fbDraweePartDefinition, a3.a());
        fbDraweePartDefinition = this.f4280i;
        Builder a4 = FbDraweePartDefinition.a().a(graphQLCustomizedStory.I().j().b());
        a4.c = f4271b;
        subParts.a(2131559119, fbDraweePartDefinition, a4.a());
        subParts.a(2131560877, this.f4281j, new Props(feedProps, MenuConfig.CLICKABLE));
        return null;
    }

    public final boolean m4811a(Object obj) {
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) ((FeedProps) obj).a;
        return (graphQLCustomizedStory == null || graphQLCustomizedStory.I() == null || graphQLCustomizedStory.I().m() == null || !graphQLCustomizedStory.I().m().contains(GraphQLStoryHeaderStyle.DAILY_DIALOGUE_LIGHTWEIGHT) || graphQLCustomizedStory.I().o() == null || graphQLCustomizedStory.I().o().a() == null || graphQLCustomizedStory.I().j() == null || graphQLCustomizedStory.I().j().b() == null || graphQLCustomizedStory.I().l() == null || graphQLCustomizedStory.I().l().b() == null) ? false : true;
    }

    static {
        PaddingStyle.Builder f = PaddingStyle.Builder.f();
        f.c = -6.0f;
        f4272c = f.i();
    }

    public static DailyDialogueLightweightHeaderPartDefinition m4807a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DailyDialogueLightweightHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4274m) {
                DailyDialogueLightweightHeaderPartDefinition dailyDialogueLightweightHeaderPartDefinition;
                if (a2 != null) {
                    dailyDialogueLightweightHeaderPartDefinition = (DailyDialogueLightweightHeaderPartDefinition) a2.a(f4274m);
                } else {
                    dailyDialogueLightweightHeaderPartDefinition = f4273l;
                }
                if (dailyDialogueLightweightHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4808b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4274m, b3);
                        } else {
                            f4273l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dailyDialogueLightweightHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public DailyDialogueLightweightHeaderPartDefinition(Lazy<GoodwillAnalyticsLogger> lazy, Lazy<QuickPromotionActionHandler> lazy2, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f4275d = lazy;
        this.f4276e = lazy2;
        this.f4277f = backgroundPartDefinition;
        this.f4278g = textPartDefinition;
        this.f4279h = textOrHiddenPartDefinition;
        this.f4280i = fbDraweePartDefinition;
        this.f4281j = menuButtonPartDefinition;
        this.f4282k = clickListenerPartDefinition;
    }

    public final ViewType m4809a() {
        return f4270a;
    }
}

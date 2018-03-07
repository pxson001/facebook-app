package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSwitcherPartDefinition.Controller;
import com.facebook.feedplugins.friendingcommon.FriendingCommonHeaderPartDefinition;
import com.facebook.feedplugins.pymk.ExperimentsForPymkModule;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPPersistentState;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.HScrollProps;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TKCA 1ZZ */
public class PaginatedPeopleYouMayKnowPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit>, Void, FeedEnvironment> {
    private static PaginatedPeopleYouMayKnowPartDefinition f24735h;
    private static final Object f24736i = new Object();
    private final FriendingCommonHeaderPartDefinition<GraphQLPaginatedPeopleYouMayKnowFeedUnit> f24737a;
    private final PeopleYouMayKnowFooterPartDefinition<GraphQLPaginatedPeopleYouMayKnowFeedUnit> f24738b;
    private final PeopleYouMayKnowQuickPromotionPartDefinition<FeedEnvironment> f24739c;
    private final PeopleYouMayKnowHScrollPartDefinition<FeedEnvironment> f24740d;
    private final QeAccessor f24741e;
    public final InterstitialManager f24742f;
    public final Context f24743g;

    private static PaginatedPeopleYouMayKnowPartDefinition m26602b(InjectorLike injectorLike) {
        return new PaginatedPeopleYouMayKnowPartDefinition(FriendingCommonHeaderPartDefinition.m26535a(injectorLike), PeopleYouMayKnowQuickPromotionPartDefinition.m26633a(injectorLike), PeopleYouMayKnowFooterPartDefinition.m26608a(injectorLike), PeopleYouMayKnowHScrollPartDefinition.m26627a(injectorLike), InterstitialManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m26603a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) feedProps.a;
        Controller controller = new Controller();
        baseMultiRowSubParts.a(this.f24737a, feedProps);
        baseMultiRowSubParts.a(this.f24740d, new HScrollProps(feedProps, controller));
        boolean a = this.f24741e.a(ExperimentsForPymkModule.f24678a, false);
        if (a) {
            baseMultiRowSubParts.a(this.f24738b, feedProps);
        }
        QPPersistentState qPPersistentState = (QPPersistentState) feedEnvironment.a(new QPContextStateKey(graphQLPaginatedPeopleYouMayKnowFeedUnit.g(), new QPPersistentState(false, null)), graphQLPaginatedPeopleYouMayKnowFeedUnit);
        if (!qPPersistentState.f24688a || qPPersistentState.f24689b == null) {
            obj2 = null;
        } else {
            QuickPromotionController quickPromotionController = (QuickPromotionController) this.f24742f.a(qPPersistentState.f24689b, QuickPromotionFeedPYMKController.class);
            Intent a2 = quickPromotionController == null ? null : quickPromotionController.a(this.f24743g);
            obj2 = a2 == null ? null : ((QuickPromotionDefinition) a2.getParcelableExtra("qp_definition")).e() == TemplateType.FEED_PYMK ? 1 : null;
        }
        if (obj2 != null) {
            baseMultiRowSubParts.a(this.f24739c, feedProps);
        }
        if (!a) {
            baseMultiRowSubParts.a(this.f24738b, feedProps);
        }
        return null;
    }

    @Inject
    public PaginatedPeopleYouMayKnowPartDefinition(FriendingCommonHeaderPartDefinition friendingCommonHeaderPartDefinition, PeopleYouMayKnowQuickPromotionPartDefinition peopleYouMayKnowQuickPromotionPartDefinition, PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition, PeopleYouMayKnowHScrollPartDefinition peopleYouMayKnowHScrollPartDefinition, InterstitialManager interstitialManager, Context context, QeAccessor qeAccessor) {
        this.f24737a = friendingCommonHeaderPartDefinition;
        this.f24738b = peopleYouMayKnowFooterPartDefinition;
        this.f24739c = peopleYouMayKnowQuickPromotionPartDefinition;
        this.f24740d = peopleYouMayKnowHScrollPartDefinition;
        this.f24742f = interstitialManager;
        this.f24743g = context;
        this.f24741e = qeAccessor;
    }

    public static PaginatedPeopleYouMayKnowPartDefinition m26601a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PaginatedPeopleYouMayKnowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24736i) {
                PaginatedPeopleYouMayKnowPartDefinition paginatedPeopleYouMayKnowPartDefinition;
                if (a2 != null) {
                    paginatedPeopleYouMayKnowPartDefinition = (PaginatedPeopleYouMayKnowPartDefinition) a2.a(f24736i);
                } else {
                    paginatedPeopleYouMayKnowPartDefinition = f24735h;
                }
                if (paginatedPeopleYouMayKnowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26602b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24736i, b3);
                        } else {
                            f24735h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = paginatedPeopleYouMayKnowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m26604a(Object obj) {
        return true;
    }
}

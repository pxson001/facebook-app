package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.friendingcommon.FriendingCommonHeaderPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLQuickPromotionPeopleYouMayKnowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_MULTI */
public class QuickPromotionPeopleYouMayKnowPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit>, Void, FeedEnvironment> {
    private static QuickPromotionPeopleYouMayKnowPartDefinition f24873f;
    private static final Object f24874g = new Object();
    private final GatekeeperStoreImpl f24875a;
    private final FriendingCommonHeaderPartDefinition<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> f24876b;
    private final QuickPromotionPeopleYouMayKnowHeaderPartDefinition<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> f24877c;
    private final QuickPromotionPeopleYouMayKnowHScrollPartDefinition<FeedEnvironment> f24878d;
    private final PeopleYouMayKnowFooterPartDefinition<GraphQLQuickPromotionPeopleYouMayKnowFeedUnit> f24879e;

    private static QuickPromotionPeopleYouMayKnowPartDefinition m26658b(InjectorLike injectorLike) {
        return new QuickPromotionPeopleYouMayKnowPartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), FriendingCommonHeaderPartDefinition.m26535a(injectorLike), QuickPromotionPeopleYouMayKnowHeaderPartDefinition.m26652a(injectorLike), PeopleYouMayKnowFooterPartDefinition.m26608a(injectorLike), QuickPromotionPeopleYouMayKnowHScrollPartDefinition.m26646a(injectorLike));
    }

    public final Object m26659a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (this.f24875a.a(630, false)) {
            baseMultiRowSubParts.a(this.f24877c, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f24876b, feedProps);
        }
        baseMultiRowSubParts.a(this.f24878d, feedProps);
        baseMultiRowSubParts.a(this.f24879e, feedProps);
        return null;
    }

    @Inject
    public QuickPromotionPeopleYouMayKnowPartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl, FriendingCommonHeaderPartDefinition friendingCommonHeaderPartDefinition, QuickPromotionPeopleYouMayKnowHeaderPartDefinition quickPromotionPeopleYouMayKnowHeaderPartDefinition, PeopleYouMayKnowFooterPartDefinition peopleYouMayKnowFooterPartDefinition, QuickPromotionPeopleYouMayKnowHScrollPartDefinition quickPromotionPeopleYouMayKnowHScrollPartDefinition) {
        this.f24875a = gatekeeperStoreImpl;
        this.f24876b = friendingCommonHeaderPartDefinition;
        this.f24877c = quickPromotionPeopleYouMayKnowHeaderPartDefinition;
        this.f24879e = peopleYouMayKnowFooterPartDefinition;
        this.f24878d = quickPromotionPeopleYouMayKnowHScrollPartDefinition;
    }

    public final boolean m26660a(Object obj) {
        return true;
    }

    public static QuickPromotionPeopleYouMayKnowPartDefinition m26657a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionPeopleYouMayKnowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24874g) {
                QuickPromotionPeopleYouMayKnowPartDefinition quickPromotionPeopleYouMayKnowPartDefinition;
                if (a2 != null) {
                    quickPromotionPeopleYouMayKnowPartDefinition = (QuickPromotionPeopleYouMayKnowPartDefinition) a2.a(f24874g);
                } else {
                    quickPromotionPeopleYouMayKnowPartDefinition = f24873f;
                }
                if (quickPromotionPeopleYouMayKnowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26658b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24874g, b3);
                        } else {
                            f24873f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionPeopleYouMayKnowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

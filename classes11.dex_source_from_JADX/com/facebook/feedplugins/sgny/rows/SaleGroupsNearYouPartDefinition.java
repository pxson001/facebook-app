package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
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
/* compiled from: buildRevision */
public class SaleGroupsNearYouPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLSaleGroupsNearYouFeedUnit>, Void, FeedEnvironment> {
    private static SaleGroupsNearYouPartDefinition f9415d;
    private static final Object f9416e = new Object();
    private final SaleGroupsNearYouHeaderPartDefinition f9417a;
    private final SaleGroupsNearYouRecyclerViewPartDefinition<FeedEnvironment> f9418b;
    private final SaleGroupsNearYouFooterPartDefinition f9419c;

    private static SaleGroupsNearYouPartDefinition m9985b(InjectorLike injectorLike) {
        return new SaleGroupsNearYouPartDefinition(SaleGroupsNearYouHeaderPartDefinition.m9976a(injectorLike), SaleGroupsNearYouRecyclerViewPartDefinition.m9992a(injectorLike), SaleGroupsNearYouFooterPartDefinition.m9971a(injectorLike));
    }

    public final Object m9986a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f9417a, feedProps);
        baseMultiRowSubParts.a(this.f9418b, feedProps);
        baseMultiRowSubParts.a(this.f9419c, feedProps);
        return null;
    }

    @Inject
    public SaleGroupsNearYouPartDefinition(SaleGroupsNearYouHeaderPartDefinition saleGroupsNearYouHeaderPartDefinition, SaleGroupsNearYouRecyclerViewPartDefinition saleGroupsNearYouRecyclerViewPartDefinition, SaleGroupsNearYouFooterPartDefinition saleGroupsNearYouFooterPartDefinition) {
        this.f9417a = saleGroupsNearYouHeaderPartDefinition;
        this.f9418b = saleGroupsNearYouRecyclerViewPartDefinition;
        this.f9419c = saleGroupsNearYouFooterPartDefinition;
    }

    public final boolean m9987a(Object obj) {
        return true;
    }

    public static SaleGroupsNearYouPartDefinition m9984a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SaleGroupsNearYouPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9416e) {
                SaleGroupsNearYouPartDefinition saleGroupsNearYouPartDefinition;
                if (a2 != null) {
                    saleGroupsNearYouPartDefinition = (SaleGroupsNearYouPartDefinition) a2.a(f9416e);
                } else {
                    saleGroupsNearYouPartDefinition = f9415d;
                }
                if (saleGroupsNearYouPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9985b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9416e, b3);
                        } else {
                            f9415d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = saleGroupsNearYouPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

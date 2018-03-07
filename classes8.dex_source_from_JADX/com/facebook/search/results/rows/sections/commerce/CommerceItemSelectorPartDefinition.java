package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELOAD_UNIT_TAP */
public class CommerceItemSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsProductItemUnit>>, Void, SearchResultsFeedEnvironment> {
    private static CommerceItemSelectorPartDefinition f23858c;
    private static final Object f23859d = new Object();
    private final CommerceProductItemsGroupPartDefinition f23860a;
    private final CommerceProductCarouselPartDefinition f23861b;

    private static CommerceItemSelectorPartDefinition m27468b(InjectorLike injectorLike) {
        return new CommerceItemSelectorPartDefinition(CommerceProductItemsGroupPartDefinition.m27535a(injectorLike), CommerceProductCarouselPartDefinition.m27500a(injectorLike));
    }

    public final Object m27469a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f23861b, feedProps).a(this.f23860a, feedProps.a);
        return null;
    }

    public final boolean m27470a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_B2C || ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_C2C || ((SearchResultsCollectionUnit) feedProps.a).mo1321k() == GraphQLGraphSearchResultRole.COMMERCE_COMBINED;
    }

    @Inject
    public CommerceItemSelectorPartDefinition(CommerceProductItemsGroupPartDefinition commerceProductItemsGroupPartDefinition, CommerceProductCarouselPartDefinition commerceProductCarouselPartDefinition) {
        this.f23860a = commerceProductItemsGroupPartDefinition;
        this.f23861b = commerceProductCarouselPartDefinition;
    }

    public static CommerceItemSelectorPartDefinition m27467a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceItemSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23859d) {
                CommerceItemSelectorPartDefinition commerceItemSelectorPartDefinition;
                if (a2 != null) {
                    commerceItemSelectorPartDefinition = (CommerceItemSelectorPartDefinition) a2.a(f23859d);
                } else {
                    commerceItemSelectorPartDefinition = f23858c;
                }
                if (commerceItemSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27468b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23859d, b3);
                        } else {
                            f23858c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceItemSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

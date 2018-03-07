package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RELATIVE_LAYOUT */
public class CommerceListItemCallToActionPartDefinition extends BaseSinglePartDefinition<SearchResultsProductItemUnit, Void, AnyEnvironment, BetterTextView> {
    private static CommerceListItemCallToActionPartDefinition f23866c;
    private static final Object f23867d = new Object();
    private final CommerceListItemMessengerCallToActionPartDefinition f23868a;
    private final CommerceListItemBuyNowCallToActionPartDefinition f23869b;

    private static CommerceListItemCallToActionPartDefinition m27477b(InjectorLike injectorLike) {
        return new CommerceListItemCallToActionPartDefinition(CommerceListItemMessengerCallToActionPartDefinition.m27479a(injectorLike), CommerceListItemBuyNowCallToActionPartDefinition.m27472a(injectorLike));
    }

    public final Object m27478a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProductItemUnit searchResultsProductItemUnit = (SearchResultsProductItemUnit) obj;
        if (searchResultsProductItemUnit.mo1321k().equals(GraphQLGraphSearchResultRole.COMMERCE_B2C)) {
            subParts.a(this.f23869b, searchResultsProductItemUnit);
        } else {
            subParts.a(this.f23868a, searchResultsProductItemUnit);
        }
        return null;
    }

    @Inject
    public CommerceListItemCallToActionPartDefinition(CommerceListItemMessengerCallToActionPartDefinition commerceListItemMessengerCallToActionPartDefinition, CommerceListItemBuyNowCallToActionPartDefinition commerceListItemBuyNowCallToActionPartDefinition) {
        this.f23868a = commerceListItemMessengerCallToActionPartDefinition;
        this.f23869b = commerceListItemBuyNowCallToActionPartDefinition;
    }

    public static CommerceListItemCallToActionPartDefinition m27476a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CommerceListItemCallToActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23867d) {
                CommerceListItemCallToActionPartDefinition commerceListItemCallToActionPartDefinition;
                if (a2 != null) {
                    commerceListItemCallToActionPartDefinition = (CommerceListItemCallToActionPartDefinition) a2.a(f23867d);
                } else {
                    commerceListItemCallToActionPartDefinition = f23866c;
                }
                if (commerceListItemCallToActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27477b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23867d, b3);
                        } else {
                            f23866c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = commerceListItemCallToActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

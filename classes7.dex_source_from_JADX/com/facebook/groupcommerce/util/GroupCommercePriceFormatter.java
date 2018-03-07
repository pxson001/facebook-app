package com.facebook.groupcommerce.util;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLCurrencyQuantity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.text.NumberFormat;
import java.util.Currency;
import javax.inject.Inject;

@ContextScoped
/* compiled from: reaction_photo_with_attribution */
public class GroupCommercePriceFormatter {
    private static GroupCommercePriceFormatter f5498c;
    private static final Object f5499d = new Object();
    private final Context f5500a;
    private final NumberFormat f5501b = NumberFormat.getCurrencyInstance();

    private static GroupCommercePriceFormatter m6194b(InjectorLike injectorLike) {
        return new GroupCommercePriceFormatter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public GroupCommercePriceFormatter(Context context) {
        this.f5500a = context;
    }

    public final String m6195a(GraphQLCurrencyQuantity graphQLCurrencyQuantity, boolean z) {
        if (graphQLCurrencyQuantity == null || Long.parseLong(graphQLCurrencyQuantity.n()) == 0) {
            return this.f5500a.getResources().getString(2131237864);
        }
        this.f5501b.setCurrency(Currency.getInstance(graphQLCurrencyQuantity.k()));
        this.f5501b.setMaximumFractionDigits(0);
        return StringFormatUtil.formatStrLocaleSafe(z ? "%s (%s)" : "%s", this.f5501b.format(Long.parseLong(graphQLCurrencyQuantity.n()) / 100), this.f5500a.getResources().getString(2131237865));
    }

    public final String m6196a(String str) {
        if (StringUtil.a(str)) {
            return "";
        }
        if (str.equals(this.f5500a.getResources().getString(2131237864))) {
            return "0";
        }
        return str.replaceAll("[\\D]", "");
    }

    public static GroupCommercePriceFormatter m6193a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommercePriceFormatter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5499d) {
                GroupCommercePriceFormatter groupCommercePriceFormatter;
                if (a2 != null) {
                    groupCommercePriceFormatter = (GroupCommercePriceFormatter) a2.a(f5499d);
                } else {
                    groupCommercePriceFormatter = f5498c;
                }
                if (groupCommercePriceFormatter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6194b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5499d, b3);
                        } else {
                            f5498c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommercePriceFormatter;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

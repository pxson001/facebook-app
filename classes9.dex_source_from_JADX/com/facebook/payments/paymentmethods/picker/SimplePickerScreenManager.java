package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.payments.picker.RowItemViewFactory;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bookmark_click */
public class SimplePickerScreenManager {
    private static SimplePickerScreenManager f18825b;
    private static final Object f18826c = new Object();
    private final ImmutableMap<PickerScreenStyle, PickerScreenStyleAssociation> f18827a;

    private static SimplePickerScreenManager m18834b(InjectorLike injectorLike) {
        return new SimplePickerScreenManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PickerScreenStyleAssociation(injectorLike)));
    }

    @Inject
    public SimplePickerScreenManager(Set<PickerScreenStyleAssociation> set) {
        Builder builder = ImmutableMap.builder();
        for (PickerScreenStyleAssociation pickerScreenStyleAssociation : set) {
            builder.b(pickerScreenStyleAssociation.f15837a, pickerScreenStyleAssociation);
        }
        this.f18827a = builder.b();
    }

    public final PickerScreenStyleRenderer m18835a(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (PickerScreenStyleRenderer) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15838b.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final PickerScreenDataFetcher m18836b(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (PickerScreenDataFetcher) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15839c.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final SectionOrganizer m18837c(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (SectionOrganizer) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15840d.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final RowItemsGenerator m18838d(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (RowItemsGenerator) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15841e.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public static SimplePickerScreenManager m18833a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SimplePickerScreenManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18826c) {
                SimplePickerScreenManager simplePickerScreenManager;
                if (a2 != null) {
                    simplePickerScreenManager = (SimplePickerScreenManager) a2.a(f18826c);
                } else {
                    simplePickerScreenManager = f18825b;
                }
                if (simplePickerScreenManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18834b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18826c, b3);
                        } else {
                            f18825b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = simplePickerScreenManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final PickerScreenDataMutator m18840f(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (PickerScreenDataMutator) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15843g.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final PickerScreenOnActivityResultHandler m18839e(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (PickerScreenOnActivityResultHandler) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15842f.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final PaymentMethodsPickerScreenSubScreenParamsGenerator m18841g(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (PaymentMethodsPickerScreenSubScreenParamsGenerator) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15844h.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }

    public final RowItemViewFactory m18842h(PickerScreenStyle pickerScreenStyle) {
        if (this.f18827a.containsKey(pickerScreenStyle)) {
            return (RowItemViewFactory) ((PickerScreenStyleAssociation) this.f18827a.get(pickerScreenStyle)).f15845i.get();
        }
        throw new IllegalArgumentException("Style " + pickerScreenStyle + " have not defined association");
    }
}

package com.facebook.search.searchbox;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ui.search.SearchEditText;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: PHOTO_REMINDER_TAP_ON_MORE */
public class GraphSearchTitleEditTextSupplier implements Supplier<SearchEditText> {
    private static GraphSearchTitleEditTextSupplier f25329b;
    private static final Object f25330c = new Object();
    public SearchEditText f25331a;

    private static GraphSearchTitleEditTextSupplier m28574c() {
        return new GraphSearchTitleEditTextSupplier();
    }

    @Nullable
    public final SearchEditText m28575b() {
        return this.f25331a;
    }

    @Nullable
    public /* synthetic */ Object get() {
        return this.f25331a;
    }

    public static GraphSearchTitleEditTextSupplier m28573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchTitleEditTextSupplier c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25330c) {
                GraphSearchTitleEditTextSupplier graphSearchTitleEditTextSupplier;
                if (a2 != null) {
                    graphSearchTitleEditTextSupplier = (GraphSearchTitleEditTextSupplier) a2.a(f25330c);
                } else {
                    graphSearchTitleEditTextSupplier = f25329b;
                }
                if (graphSearchTitleEditTextSupplier == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m28574c();
                        if (a2 != null) {
                            a2.a(f25330c, c);
                        } else {
                            f25329b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = graphSearchTitleEditTextSupplier;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}

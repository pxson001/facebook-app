package com.facebook.search.searchbox;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox;
import com.google.common.base.Supplier;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: PHOTO_REMINDER_TAP_ON_MEDIA */
public class GraphSearchTitleSearchBoxSupplier implements Supplier<GraphSearchTitleSearchBox> {
    private static GraphSearchTitleSearchBoxSupplier f25332b;
    private static final Object f25333c = new Object();
    public GraphSearchTitleSearchBox f25334a;

    private static GraphSearchTitleSearchBoxSupplier m28577d() {
        return new GraphSearchTitleSearchBoxSupplier();
    }

    @Nullable
    public final GraphSearchTitleSearchBox m28578b() {
        return this.f25334a;
    }

    @Nullable
    public /* synthetic */ Object get() {
        return this.f25334a;
    }

    public final String m28579c() {
        return this.f25334a != null ? this.f25334a.e.getText().toString() : "";
    }

    public static GraphSearchTitleSearchBoxSupplier m28576a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchTitleSearchBoxSupplier d;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25333c) {
                GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier;
                if (a2 != null) {
                    graphSearchTitleSearchBoxSupplier = (GraphSearchTitleSearchBoxSupplier) a2.a(f25333c);
                } else {
                    graphSearchTitleSearchBoxSupplier = f25332b;
                }
                if (graphSearchTitleSearchBoxSupplier == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        d = m28577d();
                        if (a2 != null) {
                            a2.a(f25333c, d);
                        } else {
                            f25332b = d;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    d = graphSearchTitleSearchBoxSupplier;
                }
            }
            return d;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.search.titlebar;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.searchbox.GraphSearchTitleEditTextSupplier;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.ui.search.SearchEditText;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_frame_rate */
public class GraphSearchTitleBarLifeCycleController {
    private static GraphSearchTitleBarLifeCycleController f402g;
    private static final Object f403h = new Object();
    public final GraphSearchTitleSearchBoxSupplier f404a;
    public final GraphSearchTitleEditTextSupplier f405b;
    public Product f406c;
    public GraphSearchTitleSearchBox f407d;
    public SearchEditText f408e;
    public HasTitleBar f409f;

    private static GraphSearchTitleBarLifeCycleController m521b(InjectorLike injectorLike) {
        return new GraphSearchTitleBarLifeCycleController(GraphSearchTitleSearchBoxSupplier.a(injectorLike), GraphSearchTitleEditTextSupplier.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public GraphSearchTitleBarLifeCycleController(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, GraphSearchTitleEditTextSupplier graphSearchTitleEditTextSupplier, Product product) {
        this.f404a = graphSearchTitleSearchBoxSupplier;
        this.f405b = graphSearchTitleEditTextSupplier;
        this.f406c = product;
    }

    public static GraphSearchTitleBarLifeCycleController m520a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphSearchTitleBarLifeCycleController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f403h) {
                GraphSearchTitleBarLifeCycleController graphSearchTitleBarLifeCycleController;
                if (a2 != null) {
                    graphSearchTitleBarLifeCycleController = (GraphSearchTitleBarLifeCycleController) a2.a(f403h);
                } else {
                    graphSearchTitleBarLifeCycleController = f402g;
                }
                if (graphSearchTitleBarLifeCycleController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m521b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f403h, b3);
                        } else {
                            f402g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphSearchTitleBarLifeCycleController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

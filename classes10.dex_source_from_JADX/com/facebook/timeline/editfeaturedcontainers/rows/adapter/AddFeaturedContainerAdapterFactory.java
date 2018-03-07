package com.facebook.timeline.editfeaturedcontainers.rows.adapter;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.editfeaturedcontainers.models.NullStateData;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateRootGroupPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getCallingPackageSigHash==null; finish() called. see t1732910 */
public class AddFeaturedContainerAdapterFactory {
    private static AddFeaturedContainerAdapterFactory f10898d;
    private static final Object f10899e = new Object();
    public final MultiRowAdapterBuilder f10900a;
    public final Lazy<NullStateRootGroupPartDefinition> f10901b;
    public final NullStateData f10902c;

    private static AddFeaturedContainerAdapterFactory m11004b(InjectorLike injectorLike) {
        return new AddFeaturedContainerAdapterFactory(MultiRowAdapterBuilder.b(injectorLike), IdBasedLazy.a(injectorLike, 11199), NullStateData.m10787a(injectorLike));
    }

    @Inject
    public AddFeaturedContainerAdapterFactory(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<NullStateRootGroupPartDefinition> lazy, NullStateData nullStateData) {
        this.f10900a = multiRowAdapterBuilder;
        this.f10901b = lazy;
        this.f10902c = nullStateData;
    }

    public static AddFeaturedContainerAdapterFactory m11003a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AddFeaturedContainerAdapterFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10899e) {
                AddFeaturedContainerAdapterFactory addFeaturedContainerAdapterFactory;
                if (a2 != null) {
                    addFeaturedContainerAdapterFactory = (AddFeaturedContainerAdapterFactory) a2.a(f10899e);
                } else {
                    addFeaturedContainerAdapterFactory = f10898d;
                }
                if (addFeaturedContainerAdapterFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11004b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10899e, b3);
                        } else {
                            f10898d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = addFeaturedContainerAdapterFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

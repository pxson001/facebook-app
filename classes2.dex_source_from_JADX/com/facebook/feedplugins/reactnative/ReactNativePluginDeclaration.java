package com.facebook.feedplugins.reactnative;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.ReactNativeFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key_values */
public class ReactNativePluginDeclaration implements RootPartsDeclaration {
    private static ReactNativePluginDeclaration f18416b;
    private static final Object f18417c = new Object();
    private final Lazy<ReactNativePartDefinition> f18418a;

    private static ReactNativePluginDeclaration m25847b(InjectorLike injectorLike) {
        return new ReactNativePluginDeclaration(IdBasedLazy.m1808a(injectorLike, 6514));
    }

    @Inject
    public ReactNativePluginDeclaration(Lazy<ReactNativePartDefinition> lazy) {
        this.f18418a = lazy;
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(ReactNativeFeedUnit.class, this.f18418a);
    }

    public static ReactNativePluginDeclaration m25846a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactNativePluginDeclaration b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18417c) {
                ReactNativePluginDeclaration reactNativePluginDeclaration;
                if (a2 != null) {
                    reactNativePluginDeclaration = (ReactNativePluginDeclaration) a2.mo818a(f18417c);
                } else {
                    reactNativePluginDeclaration = f18416b;
                }
                if (reactNativePluginDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m25847b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18417c, b3);
                        } else {
                            f18416b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = reactNativePluginDeclaration;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

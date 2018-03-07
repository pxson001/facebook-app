package com.facebook.feedplugins.reactnative;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: can_viewer_create_content_extra */
public class ReactNativePluginFeedRowSupportDeclaration implements FeedRowSupportDeclaration {
    private static ReactNativePluginFeedRowSupportDeclaration f9033a;
    private static final Object f9034b = new Object();

    private static ReactNativePluginFeedRowSupportDeclaration m9736a() {
        return new ReactNativePluginFeedRowSupportDeclaration();
    }

    public final void m9738a(ListItemRowController listItemRowController) {
        listItemRowController.a(ReactNativePartDefinition.f9028a);
    }

    public static ReactNativePluginFeedRowSupportDeclaration m9737a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactNativePluginFeedRowSupportDeclaration a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f9034b) {
                ReactNativePluginFeedRowSupportDeclaration reactNativePluginFeedRowSupportDeclaration;
                if (a3 != null) {
                    reactNativePluginFeedRowSupportDeclaration = (ReactNativePluginFeedRowSupportDeclaration) a3.a(f9034b);
                } else {
                    reactNativePluginFeedRowSupportDeclaration = f9033a;
                }
                if (reactNativePluginFeedRowSupportDeclaration == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9736a();
                        if (a3 != null) {
                            a3.a(f9034b, a2);
                        } else {
                            f9033a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactNativePluginFeedRowSupportDeclaration;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: goodfriends_exit */
public class ThrowbackToEdgeStoryConverter {
    private static ThrowbackToEdgeStoryConverter f12535a;
    private static final Object f12536b = new Object();

    private static ThrowbackToEdgeStoryConverter m14416a() {
        return new ThrowbackToEdgeStoryConverter();
    }

    public static ThrowbackToEdgeStoryConverter m14417a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackToEdgeStoryConverter a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f12536b) {
                ThrowbackToEdgeStoryConverter throwbackToEdgeStoryConverter;
                if (a3 != null) {
                    throwbackToEdgeStoryConverter = (ThrowbackToEdgeStoryConverter) a3.a(f12536b);
                } else {
                    throwbackToEdgeStoryConverter = f12535a;
                }
                if (throwbackToEdgeStoryConverter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14416a();
                        if (a3 != null) {
                            a3.a(f12536b, a2);
                        } else {
                            f12535a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = throwbackToEdgeStoryConverter;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

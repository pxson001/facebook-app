package com.facebook.messaging.xma;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tint */
public class StyleRendererManager {
    private static StyleRendererManager f1566c;
    private static final Object f1567d = new Object();
    private final ImmutableMap<GraphQLStoryAttachmentStyle, Lazy<StyleRenderer>> f1568a;
    private final Lazy<StyleRenderer> f1569b;

    private static StyleRendererManager m1740b(InjectorLike injectorLike) {
        return new StyleRendererManager(STATICDI_MULTIBIND_PROVIDER$StyleAssociation.m1724a(injectorLike), IdBasedLazy.a(injectorLike, 8435));
    }

    @Inject
    public StyleRendererManager(Set<StyleAssociation> set, Lazy<StyleRenderer> lazy) {
        Builder builder = ImmutableMap.builder();
        for (StyleAssociation styleAssociation : set) {
            if (!styleAssociation.f1565d) {
                builder.b(styleAssociation.f1562a, styleAssociation.f1563b);
            }
        }
        this.f1568a = builder.b();
        this.f1569b = lazy;
    }

    public final StyleRenderer m1741a(ImmutableList<GraphQLStoryAttachmentStyle> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = (GraphQLStoryAttachmentStyle) immutableList.get(i);
            if (this.f1568a.containsKey(graphQLStoryAttachmentStyle)) {
                return (SimpleStyleRenderer) ((Lazy) this.f1568a.get(graphQLStoryAttachmentStyle)).get();
            }
        }
        return (SimpleStyleRenderer) this.f1569b.get();
    }

    public static StyleRendererManager m1739a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StyleRendererManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1567d) {
                StyleRendererManager styleRendererManager;
                if (a2 != null) {
                    styleRendererManager = (StyleRendererManager) a2.a(f1567d);
                } else {
                    styleRendererManager = f1566c;
                }
                if (styleRendererManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1740b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1567d, b3);
                        } else {
                            f1566c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = styleRendererManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.InternalNode;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Image;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@LayoutSpec
@ContextScoped
/* compiled from: http.proxyPort */
public class HeaderMenuComponentSpec {
    private static final SparseArray<Object> f20782a = new C08311(1);
    private static HeaderMenuComponentSpec f20783b;
    private static final Object f20784c = new Object();

    /* compiled from: http.proxyPort */
    final class C08311 extends SparseArray<Object> {
        C08311(int i) {
            super(i);
            append(2131558756, Boolean.valueOf(true));
        }
    }

    private static HeaderMenuComponentSpec m28500a() {
        return new HeaderMenuComponentSpec();
    }

    protected static InternalNode m28499a(ComponentContext componentContext, MenuConfig menuConfig) {
        if (menuConfig == MenuConfig.HIDDEN) {
            throw new IllegalArgumentException("Shouldn't be laying out a hidden menu");
        }
        return Image.m31069a(componentContext).m31092h(2130840320).m30663c().mo3310a(f20782a).mo3358t(2131233595).mo3311a(menuConfig == MenuConfig.CLICKABLE ? ComponentLifecycle.m28112a(componentContext, 2045072523, null) : null).mo3343j();
    }

    public static HeaderMenuComponentSpec m28501a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderMenuComponentSpec a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f20784c) {
                HeaderMenuComponentSpec headerMenuComponentSpec;
                if (a3 != null) {
                    headerMenuComponentSpec = (HeaderMenuComponentSpec) a3.mo818a(f20784c);
                } else {
                    headerMenuComponentSpec = f20783b;
                }
                if (headerMenuComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m28500a();
                        if (a3 != null) {
                            a3.mo822a(f20784c, a2);
                        } else {
                            f20783b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = headerMenuComponentSpec;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}

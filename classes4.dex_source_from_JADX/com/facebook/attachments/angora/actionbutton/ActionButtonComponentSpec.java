package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.reference.Reference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.SolidColor;
import com.facebook.components.widget.Text;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: net.sf.cglib.proxy. */
public class ActionButtonComponentSpec {
    public static final int f7254a = 2130839739;
    private static ActionButtonComponentSpec f7255c;
    private static final Object f7256d = new Object();
    private final int f7257b;

    private static ActionButtonComponentSpec m7583b(InjectorLike injectorLike) {
        return new ActionButtonComponentSpec(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ActionButtonComponentSpec(Resources resources) {
        this.f7257b = resources.getDimensionPixelSize(2131428992);
    }

    public static ActionButtonComponentSpec m7582a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ActionButtonComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7256d) {
                ActionButtonComponentSpec actionButtonComponentSpec;
                if (a2 != null) {
                    actionButtonComponentSpec = (ActionButtonComponentSpec) a2.a(f7256d);
                } else {
                    actionButtonComponentSpec = f7255c;
                }
                if (actionButtonComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7583b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7256d, b3);
                        } else {
                            f7255c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = actionButtonComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final ComponentLayout m7584a(ComponentContext componentContext, CharSequence charSequence, Reference<Drawable> reference, int i, Reference<Drawable> reference2, @DrawableRes int i2, boolean z, CharSequence charSequence2, int i3, SparseArray<Object> sparseArray, OnClickListener onClickListener) {
        Builder builder;
        ComponentLayout.Builder a;
        ContainerBuilder b = Container.a(componentContext, 2131624283).C(2).l(8, this.f7257b).G(i2).a(charSequence2).b(sparseArray).b(ActionButtonComponent.m7577a(componentContext, onClickListener));
        if (i3 != Integer.MIN_VALUE) {
            b.l(5, i3);
        }
        if (reference2 == null) {
            builder = null;
        } else {
            builder = Image.a(componentContext).a(reference2);
        }
        b.a(builder);
        if (charSequence != null) {
            Text.Builder o = Text.a(componentContext).a(charSequence).r(1).o(2131427400);
            if (i == Integer.MIN_VALUE) {
                o.l(2131364066);
            } else {
                o.k(i);
            }
            b.a(o);
        }
        if (reference != null) {
            Image.Builder a2 = Image.a(componentContext).a(reference);
            if (charSequence != null) {
                a2.c().g(7, 2131427421);
            }
            b.a(a2);
        }
        if (z) {
            a = SolidColor.a(componentContext).h(2131362055).c().e(4, this.f7257b).l(2131427528).a(4);
        } else {
            a = null;
        }
        return Container.a(componentContext).C(2).u(4).E(2).D(1).a(a).a(Container.a(componentContext).a(b).l(8, this.f7257b)).j();
    }
}

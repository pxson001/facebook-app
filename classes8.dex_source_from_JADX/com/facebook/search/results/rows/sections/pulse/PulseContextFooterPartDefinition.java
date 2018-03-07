package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsPulseContextUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PROFILE_PICTURE */
public class PulseContextFooterPartDefinition<V extends View & Footer> extends MultiRowSinglePartDefinition<SearchResultsPulseContextUnit, Void, AnyEnvironment, V> {
    public static final ViewType f24797a = PulseContextFooterView.f24805a;
    private static PulseContextFooterPartDefinition f24798d;
    private static final Object f24799e = new Object();
    private final DefaultFooterBackgroundPartDefinition<V> f24800b;
    private final PulseContextFooterButtonsPartDefinition f24801c;

    private static PulseContextFooterPartDefinition m28192b(InjectorLike injectorLike) {
        return new PulseContextFooterPartDefinition(DefaultFooterBackgroundPartDefinition.a(injectorLike), PulseContextFooterButtonsPartDefinition.m28177a(injectorLike));
    }

    public final Object m28194a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24801c, (SearchResultsPulseContextUnit) obj);
        subParts.a(this.f24800b, new Props(true, true, true, FooterLevel.TOP, null));
        return null;
    }

    @Inject
    public PulseContextFooterPartDefinition(DefaultFooterBackgroundPartDefinition defaultFooterBackgroundPartDefinition, PulseContextFooterButtonsPartDefinition pulseContextFooterButtonsPartDefinition) {
        this.f24800b = defaultFooterBackgroundPartDefinition;
        this.f24801c = pulseContextFooterButtonsPartDefinition;
    }

    public final ViewType m28193a() {
        return f24797a;
    }

    public final boolean m28195a(Object obj) {
        return true;
    }

    public static PulseContextFooterPartDefinition m28191a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseContextFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24799e) {
                PulseContextFooterPartDefinition pulseContextFooterPartDefinition;
                if (a2 != null) {
                    pulseContextFooterPartDefinition = (PulseContextFooterPartDefinition) a2.a(f24799e);
                } else {
                    pulseContextFooterPartDefinition = f24798d;
                }
                if (pulseContextFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28192b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24799e, b3);
                        } else {
                            f24798d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseContextFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

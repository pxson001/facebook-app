package com.facebook.feed.tooltip;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placetips_footer_question */
public class MenuButtonTooltipTriggerManager {
    private static MenuButtonTooltipTriggerManager f9744e;
    private static final Object f9745f = new Object();
    private final TriState f9746a;
    private final Set<Class<? extends Fragment>> f9747b = Sets.m1313a();
    public final Set<MenuButtonTooltipTrigger> f9748c;
    public final Set<MenuButtonTooltipTrigger> f9749d = Sets.m1313a();

    private static MenuButtonTooltipTriggerManager m14754b(InjectorLike injectorLike) {
        return new MenuButtonTooltipTriggerManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$MenuButtonTooltipTrigger(injectorLike)), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2185a(460));
    }

    @Inject
    public MenuButtonTooltipTriggerManager(Set<MenuButtonTooltipTrigger> set, TriState triState) {
        this.f9748c = set;
        this.f9746a = triState;
    }

    private boolean m14753a() {
        return this.f9746a.asBoolean(false);
    }

    public final <E extends HasAnchoredTooltipProvider & HasInvalidate & HasPersistentState> void m14756a(Class<? extends Fragment> cls, E e) {
        if (m14753a()) {
            if (this.f9747b.isEmpty()) {
                for (MenuButtonTooltipTrigger menuButtonTooltipTrigger : this.f9748c) {
                    if (menuButtonTooltipTrigger.mo2660c()) {
                        menuButtonTooltipTrigger.mo2658a(e);
                        this.f9749d.add(menuButtonTooltipTrigger);
                    }
                }
            }
            this.f9747b.add(cls);
        }
    }

    public static MenuButtonTooltipTriggerManager m14752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MenuButtonTooltipTriggerManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9745f) {
                MenuButtonTooltipTriggerManager menuButtonTooltipTriggerManager;
                if (a2 != null) {
                    menuButtonTooltipTriggerManager = (MenuButtonTooltipTriggerManager) a2.mo818a(f9745f);
                } else {
                    menuButtonTooltipTriggerManager = f9744e;
                }
                if (menuButtonTooltipTriggerManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14754b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9745f, b3);
                        } else {
                            f9744e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = menuButtonTooltipTriggerManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final void m14755a(Class<? extends Fragment> cls) {
        if (m14753a()) {
            this.f9747b.remove(cls);
            if (this.f9747b.isEmpty()) {
                for (MenuButtonTooltipTrigger b : this.f9749d) {
                    b.mo2659b();
                }
                this.f9749d.clear();
            }
        }
    }
}

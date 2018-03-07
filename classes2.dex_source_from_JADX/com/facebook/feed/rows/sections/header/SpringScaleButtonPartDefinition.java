package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.widget.springbutton.SpringScaleButton;
import com.facebook.widget.springbutton.TouchSpring;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: http_client_execute */
public class SpringScaleButtonPartDefinition extends BaseSinglePartDefinition<Props, SpringState, HasPersistentState, SpringScaleButton> {
    private static SpringScaleButtonPartDefinition f20739b;
    private static final Object f20740c = new Object();
    private final Provider<TouchSpring> f20741a;

    private static SpringScaleButtonPartDefinition m28461b(InjectorLike injectorLike) {
        return new SpringScaleButtonPartDefinition(IdBasedProvider.m1811a(injectorLike, 3736));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        SpringState springState = (SpringState) ((HasPersistentState) anyEnvironment).mo2425a(new Key(props.b), props.a);
        if (springState.a == null) {
            springState.a = (TouchSpring) this.f20741a.get();
        }
        return springState;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -157697438);
        Props props = (Props) obj;
        SpringState springState = (SpringState) obj2;
        SpringScaleButton springScaleButton = (SpringScaleButton) view;
        springScaleButton.setVisibility(0);
        springScaleButton.setOnClickListener(props.c);
        springScaleButton.setSelected(props.d);
        springScaleButton.a(springState.a);
        Logger.a(8, EntryType.MARK_POP, -1516301133, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SpringScaleButton springScaleButton = (SpringScaleButton) view;
        springScaleButton.setOnClickListener(null);
        springScaleButton.a();
        springScaleButton.setVisibility(8);
    }

    public static SpringScaleButtonPartDefinition m28460a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SpringScaleButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20740c) {
                SpringScaleButtonPartDefinition springScaleButtonPartDefinition;
                if (a2 != null) {
                    springScaleButtonPartDefinition = (SpringScaleButtonPartDefinition) a2.mo818a(f20740c);
                } else {
                    springScaleButtonPartDefinition = f20739b;
                }
                if (springScaleButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28461b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20740c, b3);
                        } else {
                            f20739b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = springScaleButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SpringScaleButtonPartDefinition(Provider<TouchSpring> provider) {
        this.f20741a = provider;
    }
}

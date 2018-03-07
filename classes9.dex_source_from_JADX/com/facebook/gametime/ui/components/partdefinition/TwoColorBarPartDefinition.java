package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gametime.ui.components.view.TwoColorBarView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: TAB_ORION_PAY */
public class TwoColorBarPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<Props, Void, E, TwoColorBarView> {
    public static final ViewType f25168a = new C30131();
    private static TwoColorBarPartDefinition f25169b;
    private static final Object f25170c = new Object();

    /* compiled from: TAB_ORION_PAY */
    final class C30131 extends ViewType {
        C30131() {
        }

        public final View m27132a(Context context) {
            return new TwoColorBarView(context);
        }
    }

    /* compiled from: TAB_ORION_PAY */
    public class Props {
        public final int f25163a;
        public final int f25164b;
        public final float f25165c;
        public final float f25166d;
        @DimenRes
        public final int f25167e;

        public Props(int i, int i2, float f, float f2, @DimenRes int i3) {
            this.f25163a = i;
            this.f25164b = i2;
            this.f25165c = f;
            this.f25166d = f2;
            this.f25167e = i3;
        }
    }

    private static TwoColorBarPartDefinition m27134b() {
        return new TwoColorBarPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m27136a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1403754864);
        Props props = (Props) obj;
        TwoColorBarView twoColorBarView = (TwoColorBarView) view;
        twoColorBarView.m27218a(props.f25167e, ((HasContext) anyEnvironment).getContext());
        twoColorBarView.m27216a(props.f25165c, props.f25166d);
        twoColorBarView.m27217a(props.f25163a, props.f25164b);
        Logger.a(8, EntryType.MARK_POP, 2117284784, a);
    }

    public final boolean m27137a(Object obj) {
        Props props = (Props) obj;
        return props.f25165c >= 0.0f && props.f25166d >= 0.0f;
    }

    public final ViewType m27135a() {
        return f25168a;
    }

    public static TwoColorBarPartDefinition m27133a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TwoColorBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25170c) {
                TwoColorBarPartDefinition twoColorBarPartDefinition;
                if (a2 != null) {
                    twoColorBarPartDefinition = (TwoColorBarPartDefinition) a2.a(f25170c);
                } else {
                    twoColorBarPartDefinition = f25169b;
                }
                if (twoColorBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m27134b();
                        if (a2 != null) {
                            a2.a(f25170c, b3);
                        } else {
                            f25169b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = twoColorBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THANKS_FOR_FEEDBACK */
public class RadioButtonPartDefinition extends MultiRowSinglePartDefinition<Props, State, AnyEnvironment, RadioButton> {
    public static final ViewType f22726a = new C19771();
    private static RadioButtonPartDefinition f22727c;
    private static final Object f22728d = new Object();
    private final ClickListenerPartDefinition f22729b;

    /* compiled from: THANKS_FOR_FEEDBACK */
    final class C19771 extends ViewType {
        C19771() {
        }

        public final View m25345a(Context context) {
            return new RadioButton(context);
        }
    }

    @Immutable
    /* compiled from: THANKS_FOR_FEEDBACK */
    public class Props {
        public final int f22719a;
        public final boolean f22720b;
        public final boolean f22721c;
        public final OnClickListener f22722d;

        public Props(int i, boolean z, boolean z2, OnClickListener onClickListener) {
            this.f22720b = z;
            this.f22719a = i;
            this.f22721c = z2;
            this.f22722d = onClickListener;
        }
    }

    @Immutable
    /* compiled from: THANKS_FOR_FEEDBACK */
    public class State {
        public final int f22723a;
        public final boolean f22724b;
        public final boolean f22725c;

        public State(int i, boolean z, boolean z2) {
            this.f22723a = i;
            this.f22724b = z;
            this.f22725c = z2;
        }
    }

    private static RadioButtonPartDefinition m25347b(InjectorLike injectorLike) {
        return new RadioButtonPartDefinition(ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m25349a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f22729b, props.f22722d);
        return new State(props.f22719a, props.f22720b, props.f22721c);
    }

    public final /* bridge */ /* synthetic */ void m25350a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2147441814);
        State state = (State) obj2;
        RadioButton radioButton = (RadioButton) view;
        if (state.f22725c) {
            radioButton.setChecked(state.f22724b);
            radioButton.setButtonDrawable(state.f22723a);
            radioButton.setVisibility(0);
        } else {
            radioButton.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 1731440511, a);
    }

    public static RadioButtonPartDefinition m25346a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RadioButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22728d) {
                RadioButtonPartDefinition radioButtonPartDefinition;
                if (a2 != null) {
                    radioButtonPartDefinition = (RadioButtonPartDefinition) a2.a(f22728d);
                } else {
                    radioButtonPartDefinition = f22727c;
                }
                if (radioButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25347b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22728d, b3);
                        } else {
                            f22727c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = radioButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RadioButtonPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f22729b = clickListenerPartDefinition;
    }

    public final boolean m25351a(Object obj) {
        return true;
    }

    public final ViewType<RadioButton> m25348a() {
        return f22726a;
    }
}

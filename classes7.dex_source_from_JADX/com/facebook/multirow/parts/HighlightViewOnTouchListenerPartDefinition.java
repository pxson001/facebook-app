package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;

@ContextScoped
/* compiled from: num_impressions */
public class HighlightViewOnTouchListenerPartDefinition extends BaseSinglePartDefinition<Void, State, AnyEnvironment, View> {
    private static HighlightViewOnTouchListenerPartDefinition f7926a;
    private static final Object f7927b = new Object();

    /* compiled from: num_impressions */
    public class State {
        public final HighlightViewOnTouchListener f7925a;

        public State(HighlightViewOnTouchListener highlightViewOnTouchListener) {
            this.f7925a = highlightViewOnTouchListener;
        }
    }

    private static HighlightViewOnTouchListenerPartDefinition m9556b() {
        return new HighlightViewOnTouchListenerPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9558a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2090288430);
        view.setOnTouchListener(((State) obj2).f7925a);
        Logger.a(8, EntryType.MARK_POP, 1545809276, a);
    }

    public final Object m9557a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(new HighlightViewOnTouchListener());
    }

    public final void m9559b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnTouchListener(null);
    }

    public static HighlightViewOnTouchListenerPartDefinition m9555a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HighlightViewOnTouchListenerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7927b) {
                HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition;
                if (a2 != null) {
                    highlightViewOnTouchListenerPartDefinition = (HighlightViewOnTouchListenerPartDefinition) a2.a(f7927b);
                } else {
                    highlightViewOnTouchListenerPartDefinition = f7926a;
                }
                if (highlightViewOnTouchListenerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m9556b();
                        if (a2 != null) {
                            a2.a(f7927b, b3);
                        } else {
                            f7926a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = highlightViewOnTouchListenerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.multirow.parts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fig.listitem.FigListItem;
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
import javax.annotation.concurrent.Immutable;

@ContextScoped
/* compiled from: num_matched */
public class FigListItemToggleButtonPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FigListItem> {
    private static FigListItemToggleButtonPartDefinition f7923a;
    private static final Object f7924b = new Object();

    @Immutable
    /* compiled from: num_matched */
    public final class Props {
        public final Drawable f7920a;
        public final boolean f7921b;
        public final OnClickListener f7922c;

        public Props(Drawable drawable, boolean z, OnClickListener onClickListener) {
            this.f7920a = drawable;
            this.f7921b = z;
            this.f7922c = onClickListener;
        }
    }

    private static FigListItemToggleButtonPartDefinition m9551a() {
        return new FigListItemToggleButtonPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9553a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -785389092);
        Props props = (Props) obj;
        FigListItem figListItem = (FigListItem) view;
        figListItem.setActionType(7);
        figListItem.setActionDrawable(props.f7920a);
        figListItem.setActionState(props.f7921b);
        figListItem.setActionOnClickListener(props.f7922c);
        Logger.a(8, EntryType.MARK_POP, 2146724954, a);
    }

    public final void m9554b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FigListItem figListItem = (FigListItem) view;
        figListItem.setActionDrawable(null);
        figListItem.setActionOnClickListener(null);
    }

    public static FigListItemToggleButtonPartDefinition m9552a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemToggleButtonPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7924b) {
                FigListItemToggleButtonPartDefinition figListItemToggleButtonPartDefinition;
                if (a3 != null) {
                    figListItemToggleButtonPartDefinition = (FigListItemToggleButtonPartDefinition) a3.a(f7924b);
                } else {
                    figListItemToggleButtonPartDefinition = f7923a;
                }
                if (figListItemToggleButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9551a();
                        if (a3 != null) {
                            a3.a(f7924b, a2);
                        } else {
                            f7923a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemToggleButtonPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

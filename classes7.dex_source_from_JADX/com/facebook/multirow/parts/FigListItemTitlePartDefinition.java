package com.facebook.multirow.parts;

import android.content.Context;
import android.view.View;
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
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@ContextScoped
/* compiled from: num_of_friends */
public class FigListItemTitlePartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FigListItem> {
    private static FigListItemTitlePartDefinition f7918a;
    private static final Object f7919b = new Object();

    @Immutable
    /* compiled from: num_of_friends */
    public final class Props {
        public final CharSequence f7916a;
        @Nullable
        public final Integer f7917b;

        public Props(CharSequence charSequence) {
            this(charSequence, null);
        }

        public Props(CharSequence charSequence, Integer num) {
            this.f7916a = charSequence;
            this.f7917b = num;
        }
    }

    private static FigListItemTitlePartDefinition m9548a() {
        return new FigListItemTitlePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9550a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1262378917);
        Props props = (Props) obj;
        FigListItem figListItem = (FigListItem) view;
        if (props.f7917b != null) {
            figListItem.setTitleMaxLines(props.f7917b.intValue());
        }
        figListItem.setTitleText(props.f7916a);
        Logger.a(8, EntryType.MARK_POP, -1372623237, a);
    }

    public static FigListItemTitlePartDefinition m9549a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemTitlePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7919b) {
                FigListItemTitlePartDefinition figListItemTitlePartDefinition;
                if (a3 != null) {
                    figListItemTitlePartDefinition = (FigListItemTitlePartDefinition) a3.a(f7919b);
                } else {
                    figListItemTitlePartDefinition = f7918a;
                }
                if (figListItemTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9548a();
                        if (a3 != null) {
                            a3.a(f7919b, a2);
                        } else {
                            f7918a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemTitlePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

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
/* compiled from: num_results */
public class FigListItemBodyPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FigListItem> {
    private static FigListItemBodyPartDefinition f7906a;
    private static final Object f7907b = new Object();

    @Immutable
    /* compiled from: num_results */
    public final class Props {
        public final CharSequence f7904a;
        @Nullable
        public final Integer f7905b;

        public Props(CharSequence charSequence, Integer num) {
            this.f7904a = charSequence;
            this.f7905b = num;
        }
    }

    private static FigListItemBodyPartDefinition m9536a() {
        return new FigListItemBodyPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9538a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1122445846);
        Props props = (Props) obj;
        FigListItem figListItem = (FigListItem) view;
        if (props.f7905b != null) {
            figListItem.setBodyMaxLines(props.f7905b.intValue());
        }
        figListItem.setBodyText(props.f7904a);
        Logger.a(8, EntryType.MARK_POP, 1427907210, a);
    }

    public static FigListItemBodyPartDefinition m9537a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemBodyPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7907b) {
                FigListItemBodyPartDefinition figListItemBodyPartDefinition;
                if (a3 != null) {
                    figListItemBodyPartDefinition = (FigListItemBodyPartDefinition) a3.a(f7907b);
                } else {
                    figListItemBodyPartDefinition = f7906a;
                }
                if (figListItemBodyPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9536a();
                        if (a3 != null) {
                            a3.a(f7907b, a2);
                        } else {
                            f7906a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemBodyPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

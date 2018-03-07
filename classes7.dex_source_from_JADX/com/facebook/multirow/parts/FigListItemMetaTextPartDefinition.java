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
/* compiled from: num_processed */
public class FigListItemMetaTextPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FigListItem> {
    private static FigListItemMetaTextPartDefinition f7912a;
    private static final Object f7913b = new Object();

    @Immutable
    /* compiled from: num_processed */
    public final class Props {
        public final CharSequence f7910a;
        @Nullable
        public final Integer f7911b;

        public Props(CharSequence charSequence, Integer num) {
            this.f7910a = charSequence;
            this.f7911b = num;
        }
    }

    private static FigListItemMetaTextPartDefinition m9542a() {
        return new FigListItemMetaTextPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9544a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1571825113);
        Props props = (Props) obj;
        FigListItem figListItem = (FigListItem) view;
        if (props.f7911b != null) {
            figListItem.setMetaMaxLines(props.f7911b.intValue());
        }
        figListItem.setMetaText(props.f7910a);
        Logger.a(8, EntryType.MARK_POP, 35211042, a);
    }

    public static FigListItemMetaTextPartDefinition m9543a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FigListItemMetaTextPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7913b) {
                FigListItemMetaTextPartDefinition figListItemMetaTextPartDefinition;
                if (a3 != null) {
                    figListItemMetaTextPartDefinition = (FigListItemMetaTextPartDefinition) a3.a(f7913b);
                } else {
                    figListItemMetaTextPartDefinition = f7912a;
                }
                if (figListItemMetaTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9542a();
                        if (a3 != null) {
                            a3.a(f7913b, a2);
                        } else {
                            f7912a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = figListItemMetaTextPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

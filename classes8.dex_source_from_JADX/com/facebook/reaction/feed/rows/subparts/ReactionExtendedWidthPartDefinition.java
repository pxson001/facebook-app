package com.facebook.reaction.feed.rows.subparts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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

@ContextScoped
/* compiled from: anniversary_photo_collage */
public class ReactionExtendedWidthPartDefinition extends BaseSinglePartDefinition<Float, Integer, HasContext, View> {
    private static ReactionExtendedWidthPartDefinition f19425a;
    private static final Object f19426b = new Object();

    private static ReactionExtendedWidthPartDefinition m23411a() {
        return new ReactionExtendedWidthPartDefinition();
    }

    public final Object m23413a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return Integer.valueOf((int) (((float) ((HasContext) anyEnvironment).getContext().getResources().getDisplayMetrics().widthPixels) * ((Float) obj).floatValue()));
    }

    public final /* bridge */ /* synthetic */ void m23414a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1536684077);
        Integer num = (Integer) obj2;
        if (view.getLayoutParams() != null) {
            view.getLayoutParams().width = num.intValue();
        }
        Logger.a(8, EntryType.MARK_POP, 1084653299, a);
    }

    public static ReactionExtendedWidthPartDefinition m23412a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionExtendedWidthPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19426b) {
                ReactionExtendedWidthPartDefinition reactionExtendedWidthPartDefinition;
                if (a3 != null) {
                    reactionExtendedWidthPartDefinition = (ReactionExtendedWidthPartDefinition) a3.a(f19426b);
                } else {
                    reactionExtendedWidthPartDefinition = f19425a;
                }
                if (reactionExtendedWidthPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m23411a();
                        if (a3 != null) {
                            a3.a(f19426b, a2);
                        } else {
                            f19425a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = reactionExtendedWidthPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

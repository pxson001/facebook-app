package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: arg_dialog_width */
public class ReactionStoryBottomWithMarginPartDefinition extends MultiRowSinglePartDefinition<Void, Void, AnyEnvironment, View> {
    public static final ViewType f19286a = new C21011();
    private static ReactionStoryBottomWithMarginPartDefinition f19287b;
    private static final Object f19288c = new Object();

    /* compiled from: arg_dialog_width */
    final class C21011 extends ViewType {
        C21011() {
        }

        public final View m23291a(Context context) {
            return LayoutInflater.from(context).inflate(2130906622, null);
        }
    }

    private static ReactionStoryBottomWithMarginPartDefinition m23293c() {
        return new ReactionStoryBottomWithMarginPartDefinition();
    }

    public final ViewType m23294a() {
        return f19286a;
    }

    public final boolean m23295a(Object obj) {
        return true;
    }

    public static ReactionStoryBottomWithMarginPartDefinition m23292a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryBottomWithMarginPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19288c) {
                ReactionStoryBottomWithMarginPartDefinition reactionStoryBottomWithMarginPartDefinition;
                if (a2 != null) {
                    reactionStoryBottomWithMarginPartDefinition = (ReactionStoryBottomWithMarginPartDefinition) a2.a(f19288c);
                } else {
                    reactionStoryBottomWithMarginPartDefinition = f19287b;
                }
                if (reactionStoryBottomWithMarginPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m23293c();
                        if (a2 != null) {
                            a2.a(f19288c, c);
                        } else {
                            f19287b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionStoryBottomWithMarginPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}

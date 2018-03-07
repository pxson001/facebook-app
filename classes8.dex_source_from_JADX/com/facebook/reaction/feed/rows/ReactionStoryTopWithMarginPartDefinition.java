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
/* compiled from: arg_album */
public class ReactionStoryTopWithMarginPartDefinition extends MultiRowSinglePartDefinition<Void, Void, AnyEnvironment, View> {
    public static final ViewType f19302a = new C21031();
    private static ReactionStoryTopWithMarginPartDefinition f19303b;
    private static final Object f19304c = new Object();

    /* compiled from: arg_album */
    final class C21031 extends ViewType {
        C21031() {
        }

        public final View m23304a(Context context) {
            return LayoutInflater.from(context).inflate(2130906634, null);
        }
    }

    private static ReactionStoryTopWithMarginPartDefinition m23306c() {
        return new ReactionStoryTopWithMarginPartDefinition();
    }

    public final ViewType m23307a() {
        return f19302a;
    }

    public final boolean m23308a(Object obj) {
        return true;
    }

    public static ReactionStoryTopWithMarginPartDefinition m23305a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryTopWithMarginPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19304c) {
                ReactionStoryTopWithMarginPartDefinition reactionStoryTopWithMarginPartDefinition;
                if (a2 != null) {
                    reactionStoryTopWithMarginPartDefinition = (ReactionStoryTopWithMarginPartDefinition) a2.a(f19304c);
                } else {
                    reactionStoryTopWithMarginPartDefinition = f19303b;
                }
                if (reactionStoryTopWithMarginPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m23306c();
                        if (a2 != null) {
                            a2.a(f19304c, c);
                        } else {
                            f19303b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = reactionStoryTopWithMarginPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}

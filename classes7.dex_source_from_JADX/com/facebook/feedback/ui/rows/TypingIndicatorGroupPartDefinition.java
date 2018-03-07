package com.facebook.feedback.ui.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: review_title */
public class TypingIndicatorGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Integer, Void, CommentsEnvironment> {
    private static TypingIndicatorGroupPartDefinition f5125b;
    private static final Object f5126c = new Object();
    private final Lazy<TypingIndicatorPartDefinition> f5127a;

    private static TypingIndicatorGroupPartDefinition m5583b(InjectorLike injectorLike) {
        return new TypingIndicatorGroupPartDefinition(IdBasedLazy.a(injectorLike, 6162));
    }

    public final Object m5584a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(true, this.f5127a, (Integer) obj);
        return null;
    }

    @Inject
    public TypingIndicatorGroupPartDefinition(Lazy<TypingIndicatorPartDefinition> lazy) {
        this.f5127a = lazy;
    }

    public final boolean m5585a(Object obj) {
        return true;
    }

    public static TypingIndicatorGroupPartDefinition m5582a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TypingIndicatorGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5126c) {
                TypingIndicatorGroupPartDefinition typingIndicatorGroupPartDefinition;
                if (a2 != null) {
                    typingIndicatorGroupPartDefinition = (TypingIndicatorGroupPartDefinition) a2.a(f5126c);
                } else {
                    typingIndicatorGroupPartDefinition = f5125b;
                }
                if (typingIndicatorGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5583b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5126c, b3);
                        } else {
                            f5125b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = typingIndicatorGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

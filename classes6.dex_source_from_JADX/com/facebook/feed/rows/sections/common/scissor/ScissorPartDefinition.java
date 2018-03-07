package com.facebook.feed.rows.sections.common.scissor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.model.GapFeedEdge.GapFeedUnit;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: message_capping_keyboard_guard_impression */
public class ScissorPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GapFeedUnit>, Void, AnyEnvironment, View> {
    public static final ViewType f10402a = new C06301();
    private static ScissorPartDefinition f10403b;
    private static final Object f10404c = new Object();

    /* compiled from: message_capping_keyboard_guard_impression */
    final class C06301 extends ViewType {
        C06301() {
        }

        public final View m16580a(Context context) {
            return LayoutInflater.from(context).inflate(2130904314, null);
        }
    }

    private static ScissorPartDefinition m16582b() {
        return new ScissorPartDefinition();
    }

    public final boolean m16584a(Object obj) {
        return "Head_Fetch_Gap".equals(((GapFeedUnit) ((FeedProps) obj).a).a);
    }

    public final ViewType m16583a() {
        return f10402a;
    }

    public static ScissorPartDefinition m16581a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ScissorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10404c) {
                ScissorPartDefinition scissorPartDefinition;
                if (a2 != null) {
                    scissorPartDefinition = (ScissorPartDefinition) a2.a(f10404c);
                } else {
                    scissorPartDefinition = f10403b;
                }
                if (scissorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m16582b();
                        if (a2 != null) {
                            a2.a(f10404c, b3);
                        } else {
                            f10403b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = scissorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.appdiscovery.lite.ui.rows.sections.actor;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: num_unseen */
public class MessagePartDefinition extends MultiRowSinglePartDefinition<String, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f6529a = ViewType.a(2130905234);
    private static MessagePartDefinition f6530c;
    private static final Object f6531d = new Object();
    private final TextPartDefinition f6532b;

    private static MessagePartDefinition m6950b(InjectorLike injectorLike) {
        return new MessagePartDefinition(TextPartDefinition.a(injectorLike));
    }

    public final Object m6952a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6532b, (String) obj);
        return null;
    }

    public final boolean m6953a(Object obj) {
        return !StringUtil.a((String) obj);
    }

    @Inject
    public MessagePartDefinition(TextPartDefinition textPartDefinition) {
        this.f6532b = textPartDefinition;
    }

    public final ViewType m6951a() {
        return f6529a;
    }

    public static MessagePartDefinition m6949a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6531d) {
                MessagePartDefinition messagePartDefinition;
                if (a2 != null) {
                    messagePartDefinition = (MessagePartDefinition) a2.a(f6531d);
                } else {
                    messagePartDefinition = f6530c;
                }
                if (messagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6950b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6531d, b3);
                        } else {
                            f6530c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

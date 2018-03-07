package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_share_message_open */
public class ThrowbackCallToActionTextPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, TextView> {
    private static ThrowbackCallToActionTextPartDefinition f12355b;
    private static final Object f12356c = new Object();
    public final AllCapsTransformationMethod f12357a;

    /* compiled from: goodwill_throwback_share_message_open */
    public class Props {
        public int f12353a;
        public String f12354b;

        public Props(int i, String str) {
            this.f12353a = i;
            this.f12354b = str;
        }
    }

    private static ThrowbackCallToActionTextPartDefinition m14288b(InjectorLike injectorLike) {
        return new ThrowbackCallToActionTextPartDefinition(AllCapsTransformationMethod.b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m14289a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1407573885);
        Props props = (Props) obj;
        TextView textView = (TextView) view;
        textView.setTextColor(props.f12353a);
        textView.setTransformationMethod(this.f12357a);
        textView.setText(props.f12354b);
        Logger.a(8, EntryType.MARK_POP, -1619957583, a);
    }

    @Inject
    public ThrowbackCallToActionTextPartDefinition(AllCapsTransformationMethod allCapsTransformationMethod) {
        this.f12357a = allCapsTransformationMethod;
    }

    public static ThrowbackCallToActionTextPartDefinition m14287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackCallToActionTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12356c) {
                ThrowbackCallToActionTextPartDefinition throwbackCallToActionTextPartDefinition;
                if (a2 != null) {
                    throwbackCallToActionTextPartDefinition = (ThrowbackCallToActionTextPartDefinition) a2.a(f12356c);
                } else {
                    throwbackCallToActionTextPartDefinition = f12355b;
                }
                if (throwbackCallToActionTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12356c, b3);
                        } else {
                            f12355b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackCallToActionTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

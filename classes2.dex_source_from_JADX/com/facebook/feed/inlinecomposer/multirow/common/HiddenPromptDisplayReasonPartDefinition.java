package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptDisplayReasonView;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
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
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

@ContextScoped
/* compiled from: mqtt_ipc_client_log */
public class HiddenPromptDisplayReasonPartDefinition<V extends View & HasPromptDisplayReasonView & HasPromptFlyout> extends BaseSinglePartDefinition<PromptDisplayReason, Void, AnyEnvironment, V> {
    private static HiddenPromptDisplayReasonPartDefinition f13262a;
    private static final Object f13263b = new Object();

    private static HiddenPromptDisplayReasonPartDefinition m19517b() {
        return new HiddenPromptDisplayReasonPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1492492932);
        m19518b(view);
        Logger.a(8, EntryType.MARK_POP, 20762417, a);
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }

    public static void m19518b(V v) {
        if (((HasPromptDisplayReasonView) v).mo2702a()) {
            TextWithEntitiesView promptDisplayReasonView = ((HasPromptDisplayReasonView) v).getPromptDisplayReasonView();
            promptDisplayReasonView.setVisibility(8);
            ((FrameLayout) promptDisplayReasonView.getParent()).setVisibility(8);
            promptDisplayReasonView.setText("");
        }
        ((HasPromptDisplayReasonView) v).mo2701a(false);
    }

    public static HiddenPromptDisplayReasonPartDefinition m19516a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HiddenPromptDisplayReasonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13263b) {
                HiddenPromptDisplayReasonPartDefinition hiddenPromptDisplayReasonPartDefinition;
                if (a2 != null) {
                    hiddenPromptDisplayReasonPartDefinition = (HiddenPromptDisplayReasonPartDefinition) a2.mo818a(f13263b);
                } else {
                    hiddenPromptDisplayReasonPartDefinition = f13262a;
                }
                if (hiddenPromptDisplayReasonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m19517b();
                        if (a2 != null) {
                            a2.mo822a(f13263b, b3);
                        } else {
                            f13262a = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = hiddenPromptDisplayReasonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

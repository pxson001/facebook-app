package com.facebook.feed.inlinecomposer.multirow.common;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptDisplayReasonView;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
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
/* compiled from: mqtt_publish_received */
public class TopPromptDisplayReasonPartDefinition<V extends View & HasPromptDisplayReasonView & HasPromptFlyout> extends BaseSinglePartDefinition<PromptDisplayReason, DefaultTextWithEntitiesLongFieldsModel, AnyEnvironment, V> {
    private static TopPromptDisplayReasonPartDefinition f13260a;
    private static final Object f13261b = new Object();

    private static TopPromptDisplayReasonPartDefinition m19512a() {
        return new TopPromptDisplayReasonPartDefinition();
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        PromptDisplayReason promptDisplayReason = (PromptDisplayReason) obj;
        return promptDisplayReason == null ? null : promptDisplayReason.textWithEntities;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -824260978);
        DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) obj2;
        TextWithEntitiesView promptDisplayReasonView = ((HasPromptDisplayReasonView) view).getPromptDisplayReasonView();
        promptDisplayReasonView.setVisibility(0);
        promptDisplayReasonView.setTextWithEntities(defaultTextWithEntitiesLongFieldsModel);
        promptDisplayReasonView.setMovementMethod(LinkMovementMethod.getInstance());
        ((HasPromptDisplayReasonView) view).mo2701a(true);
        view.setOnClickListener(null);
        Logger.a(8, EntryType.MARK_POP, -95862159, a);
    }

    public static TopPromptDisplayReasonPartDefinition m19513a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopPromptDisplayReasonPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13261b) {
                TopPromptDisplayReasonPartDefinition topPromptDisplayReasonPartDefinition;
                if (a3 != null) {
                    topPromptDisplayReasonPartDefinition = (TopPromptDisplayReasonPartDefinition) a3.mo818a(f13261b);
                } else {
                    topPromptDisplayReasonPartDefinition = f13260a;
                }
                if (topPromptDisplayReasonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19512a();
                        if (a3 != null) {
                            a3.mo822a(f13261b, a2);
                        } else {
                            f13260a = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = topPromptDisplayReasonPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}

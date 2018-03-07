package com.facebook.productionprompts.v3;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.productionprompts.common.v3.ProductionPromptSmallView;
import com.facebook.productionprompts.model.ClipboardPromptObject;
import javax.inject.Inject;

@ContextScoped
/* compiled from: reply_comment_tap */
public class ClipboardPromptSmallPartDefinition<E extends HasPositionInformation & PromptViewStateUpdater> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, Void, E, ProductionPromptSmallView> {
    public static final ViewType f4540a = new C05941();
    public static final CallerContext f4541b = CallerContext.a(ProductionPromptSmallPartDefintion.class);
    private static ClipboardPromptSmallPartDefinition f4542d;
    private static final Object f4543e = new Object();
    private final BaseV3PromptPartDefinition f4544c;

    /* compiled from: reply_comment_tap */
    final class C05941 extends ViewType {
        C05941() {
        }

        public final View m4401a(Context context) {
            return new ProductionPromptSmallView(context);
        }
    }

    private static ClipboardPromptSmallPartDefinition m4403b(InjectorLike injectorLike) {
        return new ClipboardPromptSmallPartDefinition(BaseV3PromptPartDefinition.a(injectorLike));
    }

    public final Object m4405a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f4544c, Props.a((PromptPartDefinitionProps) obj));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m4406a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2023447943);
        ((ProductionPromptSmallView) view).m4378a(((PromptPartDefinitionProps) obj).c.f(), f4541b);
        Logger.a(8, EntryType.MARK_POP, 386508186, a);
    }

    public final boolean m4407a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        return (promptPartDefinitionProps == null || promptPartDefinitionProps.a == null || promptPartDefinitionProps.a.a == null || !(promptPartDefinitionProps.a.a instanceof ClipboardPromptObject) || !promptPartDefinitionProps.a.a.c().equals(GraphQLPromptType.CLIPBOARD.toString())) ? false : true;
    }

    @Inject
    public ClipboardPromptSmallPartDefinition(BaseV3PromptPartDefinition baseV3PromptPartDefinition) {
        this.f4544c = baseV3PromptPartDefinition;
    }

    public final ViewType<ProductionPromptSmallView> m4404a() {
        return f4540a;
    }

    public static ClipboardPromptSmallPartDefinition m4402a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClipboardPromptSmallPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4543e) {
                ClipboardPromptSmallPartDefinition clipboardPromptSmallPartDefinition;
                if (a2 != null) {
                    clipboardPromptSmallPartDefinition = (ClipboardPromptSmallPartDefinition) a2.a(f4543e);
                } else {
                    clipboardPromptSmallPartDefinition = f4542d;
                }
                if (clipboardPromptSmallPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4403b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4543e, b3);
                        } else {
                            f4542d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = clipboardPromptSmallPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.productionprompts.v3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition;
import com.facebook.feed.inlinecomposer.multirow.common.BaseV3PromptPartDefinition.Props;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: replace_unit_tap */
public class ProductionPromptSmallPartDefintion<E extends HasPositionInformation & PromptViewStateUpdater> extends MultiRowSinglePartDefinition<PromptPartDefinitionProps, Void, E, ProductionPromptSmallView> {
    public static final ViewType f4545a = new C05951();
    public static final CallerContext f4546b = CallerContext.a(ProductionPromptSmallPartDefintion.class);
    private static ProductionPromptSmallPartDefintion f4547d;
    private static final Object f4548e = new Object();
    private final BaseV3PromptPartDefinition f4549c;

    /* compiled from: replace_unit_tap */
    final class C05951 extends ViewType {
        C05951() {
        }

        public final View m4408a(Context context) {
            return new ProductionPromptSmallView(context);
        }
    }

    private static ProductionPromptSmallPartDefintion m4410b(InjectorLike injectorLike) {
        return new ProductionPromptSmallPartDefintion(BaseV3PromptPartDefinition.a(injectorLike));
    }

    public final Object m4412a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f4549c, Props.a((PromptPartDefinitionProps) obj));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m4413a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1685494082);
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        ProductionPromptSmallView productionPromptSmallView = (ProductionPromptSmallView) view;
        if (TextUtils.isEmpty(null)) {
            productionPromptSmallView.f4525k.setVisibility(8);
        } else {
            productionPromptSmallView.f4525k.setVisibility(0);
            productionPromptSmallView.f4525k.setText(null);
        }
        productionPromptSmallView.m4378a(promptPartDefinitionProps.c.f(), f4546b);
        Logger.a(8, EntryType.MARK_POP, -881943143, a);
    }

    public final boolean m4414a(Object obj) {
        PromptPartDefinitionProps promptPartDefinitionProps = (PromptPartDefinitionProps) obj;
        return (promptPartDefinitionProps == null || promptPartDefinitionProps.c == null) ? false : true;
    }

    @Inject
    public ProductionPromptSmallPartDefintion(BaseV3PromptPartDefinition baseV3PromptPartDefinition) {
        this.f4549c = baseV3PromptPartDefinition;
    }

    public final ViewType<ProductionPromptSmallView> m4411a() {
        return f4545a;
    }

    public static ProductionPromptSmallPartDefintion m4409a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProductionPromptSmallPartDefintion b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4548e) {
                ProductionPromptSmallPartDefintion productionPromptSmallPartDefintion;
                if (a2 != null) {
                    productionPromptSmallPartDefintion = (ProductionPromptSmallPartDefintion) a2.a(f4548e);
                } else {
                    productionPromptSmallPartDefintion = f4547d;
                }
                if (productionPromptSmallPartDefintion == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4410b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4548e, b3);
                        } else {
                            f4547d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = productionPromptSmallPartDefintion;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

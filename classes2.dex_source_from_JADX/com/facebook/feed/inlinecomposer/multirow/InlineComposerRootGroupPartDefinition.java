package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: navigation */
public class InlineComposerRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<InlineComposerModel, Void, InlineComposerEnvironment> {
    private static InlineComposerRootGroupPartDefinition f12968b;
    private static final Object f12969c = new Object();
    private final InlineComposerSelectorPartDefinition f12970a;

    private static InlineComposerRootGroupPartDefinition m19057b(InjectorLike injectorLike) {
        return new InlineComposerRootGroupPartDefinition(InlineComposerSelectorPartDefinition.m19068a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.m19112a(this.f12970a, (InlineComposerModel) obj);
        return null;
    }

    @Inject
    public InlineComposerRootGroupPartDefinition(InlineComposerSelectorPartDefinition inlineComposerSelectorPartDefinition) {
        this.f12970a = inlineComposerSelectorPartDefinition;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static InlineComposerRootGroupPartDefinition m19056a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12969c) {
                InlineComposerRootGroupPartDefinition inlineComposerRootGroupPartDefinition;
                if (a2 != null) {
                    inlineComposerRootGroupPartDefinition = (InlineComposerRootGroupPartDefinition) a2.mo818a(f12969c);
                } else {
                    inlineComposerRootGroupPartDefinition = f12968b;
                }
                if (inlineComposerRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19057b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12969c, b3);
                        } else {
                            f12968b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

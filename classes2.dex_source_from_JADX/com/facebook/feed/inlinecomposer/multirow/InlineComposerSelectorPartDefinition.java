package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.feed.inlinecomposer.multirow.work.InlineComposerWorkPartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
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
/* compiled from: native_post/<q$3>?fallback_url=  */
public class InlineComposerSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<InlineComposerModel, Void, InlineComposerEnvironment> {
    private static InlineComposerSelectorPartDefinition f12971c;
    private static final Object f12972d = new Object();
    private final Lazy<InlineComposerWorkPartDefinition> f12973a;
    private final Lazy<InlineComposerGroupPartDefinition> f12974b;

    private static InlineComposerSelectorPartDefinition m19069b(InjectorLike injectorLike) {
        return new InlineComposerSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1388), IdBasedLazy.m1808a(injectorLike, 1409));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (InlineComposerModel) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f12973a, obj).m19119a(this.f12974b, obj);
        return null;
    }

    @Inject
    public InlineComposerSelectorPartDefinition(Lazy<InlineComposerGroupPartDefinition> lazy, Lazy<InlineComposerWorkPartDefinition> lazy2) {
        this.f12974b = lazy;
        this.f12973a = lazy2;
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }

    public static InlineComposerSelectorPartDefinition m19068a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12972d) {
                InlineComposerSelectorPartDefinition inlineComposerSelectorPartDefinition;
                if (a2 != null) {
                    inlineComposerSelectorPartDefinition = (InlineComposerSelectorPartDefinition) a2.mo818a(f12972d);
                } else {
                    inlineComposerSelectorPartDefinition = f12971c;
                }
                if (inlineComposerSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19069b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12972d, b3);
                        } else {
                            f12971c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

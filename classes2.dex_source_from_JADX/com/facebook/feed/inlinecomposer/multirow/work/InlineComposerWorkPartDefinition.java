package com.facebook.feed.inlinecomposer.multirow.work;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.inlinecomposer.abtest.WorkInlineComposerGateKeepers;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
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
/* compiled from: native_feed */
public class InlineComposerWorkPartDefinition extends BaseMultiRowGroupPartDefinition<InlineComposerModel, Void, HasPositionInformation> {
    private static InlineComposerWorkPartDefinition f12996d;
    private static final Object f12997e = new Object();
    private final WorkInlineComposerGateKeepers f12998a;
    private final InlineComposerWorkHeaderPartDefinition f12999b;
    private final InlineComposerHscrollRecyclerViewPartDefinition f13000c;

    private static InlineComposerWorkPartDefinition m19123b(InjectorLike injectorLike) {
        return new InlineComposerWorkPartDefinition(WorkInlineComposerGateKeepers.m15308b(injectorLike), InlineComposerWorkHeaderPartDefinition.m19126a(injectorLike), InlineComposerHscrollRecyclerViewPartDefinition.m19316a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (InlineComposerModel) obj;
        baseMultiRowSubParts.m19112a(this.f12999b, obj);
        baseMultiRowSubParts.m19112a(this.f13000c, (Object) obj.f12913h);
        return null;
    }

    @Inject
    public InlineComposerWorkPartDefinition(WorkInlineComposerGateKeepers workInlineComposerGateKeepers, InlineComposerWorkHeaderPartDefinition inlineComposerWorkHeaderPartDefinition, InlineComposerHscrollRecyclerViewPartDefinition inlineComposerHscrollRecyclerViewPartDefinition) {
        this.f12998a = workInlineComposerGateKeepers;
        this.f12999b = inlineComposerWorkHeaderPartDefinition;
        this.f13000c = inlineComposerHscrollRecyclerViewPartDefinition;
    }

    public final boolean mo2536a(Object obj) {
        return this.f12998a.m15310b();
    }

    public static InlineComposerWorkPartDefinition m19122a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerWorkPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f12997e) {
                InlineComposerWorkPartDefinition inlineComposerWorkPartDefinition;
                if (a2 != null) {
                    inlineComposerWorkPartDefinition = (InlineComposerWorkPartDefinition) a2.mo818a(f12997e);
                } else {
                    inlineComposerWorkPartDefinition = f12996d;
                }
                if (inlineComposerWorkPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19123b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f12997e, b3);
                        } else {
                            f12996d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerWorkPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

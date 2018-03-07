package com.facebook.feed.rows.sections.common.unknown;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
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
/* compiled from: message_capping_keyboard_guard_dismissal */
public class UnknownFeedUnitMultiRowGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, AnyEnvironment> {
    private static UnknownFeedUnitMultiRowGroupPartDefinition f10405c;
    private static final Object f10406d = new Object();
    private final UnknownFeedUnitPartDefinition f10407a;
    private final EmptyPartDefinition f10408b;

    private static UnknownFeedUnitMultiRowGroupPartDefinition m16586b(InjectorLike injectorLike) {
        return new UnknownFeedUnitMultiRowGroupPartDefinition(UnknownFeedUnitPartDefinition.m16590a(injectorLike), EmptyPartDefinition.m16566a(injectorLike));
    }

    @Inject
    public UnknownFeedUnitMultiRowGroupPartDefinition(UnknownFeedUnitPartDefinition unknownFeedUnitPartDefinition, EmptyPartDefinition emptyPartDefinition) {
        this.f10407a = unknownFeedUnitPartDefinition;
        this.f10408b = emptyPartDefinition;
    }

    public final boolean m16588a(Object obj) {
        return true;
    }

    public final Object m16587a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SubPartsSelector.a(baseMultiRowSubParts, this.f10407a, obj).a(this.f10408b, obj);
        return null;
    }

    public static UnknownFeedUnitMultiRowGroupPartDefinition m16585a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UnknownFeedUnitMultiRowGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10406d) {
                UnknownFeedUnitMultiRowGroupPartDefinition unknownFeedUnitMultiRowGroupPartDefinition;
                if (a2 != null) {
                    unknownFeedUnitMultiRowGroupPartDefinition = (UnknownFeedUnitMultiRowGroupPartDefinition) a2.a(f10406d);
                } else {
                    unknownFeedUnitMultiRowGroupPartDefinition = f10405c;
                }
                if (unknownFeedUnitMultiRowGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16586b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10406d, b3);
                        } else {
                            f10405c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = unknownFeedUnitMultiRowGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

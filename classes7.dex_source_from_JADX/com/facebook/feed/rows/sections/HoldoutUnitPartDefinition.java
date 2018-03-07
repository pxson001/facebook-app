package com.facebook.feed.rows.sections;

import android.content.Context;
import android.view.View;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.model.GraphQLHoldoutAdFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: ^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$ */
public class HoldoutUnitPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLHoldoutAdFeedUnit, Void, AnyEnvironment> {
    public static final ViewType f20379a = new C17581();
    private static HoldoutUnitPartDefinition f20380c;
    private static final Object f20381d = new Object();
    public final InvisibleViewPartDefinition f20382b = new InvisibleViewPartDefinition();

    /* compiled from: ^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$ */
    final class C17581 extends ViewType {
        C17581() {
        }

        public final View m23499a(Context context) {
            View view = new View(context);
            view.setVisibility(8);
            return view;
        }
    }

    @VisibleForTesting
    /* compiled from: ^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$ */
    public class InvisibleViewPartDefinition extends MultiRowSinglePartDefinition<GraphQLHoldoutAdFeedUnit, Void, AnyEnvironment, View> {
        public final ViewType m23500a() {
            return HoldoutUnitPartDefinition.f20379a;
        }

        public final boolean m23501a(Object obj) {
            return true;
        }
    }

    private static HoldoutUnitPartDefinition m23503b() {
        return new HoldoutUnitPartDefinition();
    }

    public final Object m23504a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f20382b, (GraphQLHoldoutAdFeedUnit) obj);
        return null;
    }

    public final boolean m23505a(Object obj) {
        return true;
    }

    public static HoldoutUnitPartDefinition m23502a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HoldoutUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20381d) {
                HoldoutUnitPartDefinition holdoutUnitPartDefinition;
                if (a2 != null) {
                    holdoutUnitPartDefinition = (HoldoutUnitPartDefinition) a2.a(f20381d);
                } else {
                    holdoutUnitPartDefinition = f20380c;
                }
                if (holdoutUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23503b();
                        if (a2 != null) {
                            a2.a(f20381d, b3);
                        } else {
                            f20380c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = holdoutUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

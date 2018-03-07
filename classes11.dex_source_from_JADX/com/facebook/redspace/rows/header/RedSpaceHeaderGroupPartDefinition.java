package com.facebook.redspace.rows.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.redspace.model.RedSpaceHeaderSectionModel;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.redspace.rows.sharedactivities.RedSpaceSharedActivitiesGroupPartDefinition;
import com.facebook.redspace.rows.visits.RedSpaceVisitorsPartDefinition;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: PYMA footer has NULL ActionLink */
public class RedSpaceHeaderGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, RedSpaceEnvironment> {
    private static RedSpaceHeaderGroupPartDefinition f12205d;
    private static final Object f12206e = new Object();
    private final Lazy<RedSpaceSharedActivitiesGroupPartDefinition> f12207a;
    private final Lazy<RedSpaceHeaderTitlePartDefinition> f12208b;
    private final Lazy<RedSpaceVisitorsPartDefinition> f12209c;

    private static RedSpaceHeaderGroupPartDefinition m12678b(InjectorLike injectorLike) {
        return new RedSpaceHeaderGroupPartDefinition(IdBasedLazy.a(injectorLike, 10215), IdBasedLazy.a(injectorLike, 10210), IdBasedLazy.a(injectorLike, 10218));
    }

    @Inject
    private RedSpaceHeaderGroupPartDefinition(Lazy<RedSpaceSharedActivitiesGroupPartDefinition> lazy, Lazy<RedSpaceHeaderTitlePartDefinition> lazy2, Lazy<RedSpaceVisitorsPartDefinition> lazy3) {
        this.f12207a = lazy;
        this.f12208b = lazy2;
        this.f12209c = lazy3;
    }

    public final boolean m12680a(Object obj) {
        return obj instanceof RedSpaceHeaderSectionModel;
    }

    public final Object m12679a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        RedSpaceHeaderSectionModel redSpaceHeaderSectionModel = (RedSpaceHeaderSectionModel) obj;
        int size = redSpaceHeaderSectionModel.c.a.size();
        int i = (redSpaceHeaderSectionModel.b == null || redSpaceHeaderSectionModel.b.j() <= 0) ? 0 : 1;
        if (i + size > 0) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12208b.get(), redSpaceHeaderSectionModel.a);
        }
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12209c.get(), redSpaceHeaderSectionModel.b);
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12207a.get(), redSpaceHeaderSectionModel.c);
        return null;
    }

    public static RedSpaceHeaderGroupPartDefinition m12677a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceHeaderGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12206e) {
                RedSpaceHeaderGroupPartDefinition redSpaceHeaderGroupPartDefinition;
                if (a2 != null) {
                    redSpaceHeaderGroupPartDefinition = (RedSpaceHeaderGroupPartDefinition) a2.a(f12206e);
                } else {
                    redSpaceHeaderGroupPartDefinition = f12205d;
                }
                if (redSpaceHeaderGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12678b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12206e, b3);
                        } else {
                            f12205d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceHeaderGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.pymk.views.rows.PeopleYouMayKnowLoadView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: notifs */
public class PymkLoadingPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, PeopleYouMayKnowLoadView> {
    public static final ViewType<PeopleYouMayKnowLoadView> f6705a = new C03101();
    private static PymkLoadingPartDefinition f6706b;
    private static final Object f6707c = new Object();

    /* compiled from: notifs */
    final class C03101 extends ViewType<PeopleYouMayKnowLoadView> {
        C03101() {
        }

        public final View m7103a(Context context) {
            return new PeopleYouMayKnowLoadView(context);
        }
    }

    private static PymkLoadingPartDefinition m7101b() {
        return new PymkLoadingPartDefinition();
    }

    public final ViewType<PeopleYouMayKnowLoadView> m7102a() {
        return f6705a;
    }

    public static PymkLoadingPartDefinition m7100a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymkLoadingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6707c) {
                PymkLoadingPartDefinition pymkLoadingPartDefinition;
                if (a2 != null) {
                    pymkLoadingPartDefinition = (PymkLoadingPartDefinition) a2.a(f6707c);
                } else {
                    pymkLoadingPartDefinition = f6706b;
                }
                if (pymkLoadingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m7101b();
                        if (a2 != null) {
                            a2.a(f6707c, b3);
                        } else {
                            f6706b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymkLoadingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

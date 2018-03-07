package com.facebook.timeline.pymk.rows;

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
/* compiled from: facewebStatusButton */
public class PeopleYouMayKnowLoadingPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, PeopleYouMayKnowLoadView> {
    public static final ViewType<PeopleYouMayKnowLoadView> f12548a = new C17701();
    private static PeopleYouMayKnowLoadingPartDefinition f12549b;
    private static final Object f12550c = new Object();

    /* compiled from: facewebStatusButton */
    final class C17701 extends ViewType<PeopleYouMayKnowLoadView> {
        C17701() {
        }

        public final View m12538a(Context context) {
            return new PeopleYouMayKnowLoadView(context, null, 1);
        }
    }

    private static PeopleYouMayKnowLoadingPartDefinition m12540b() {
        return new PeopleYouMayKnowLoadingPartDefinition();
    }

    public final ViewType<PeopleYouMayKnowLoadView> m12541a() {
        return f12548a;
    }

    public static PeopleYouMayKnowLoadingPartDefinition m12539a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowLoadingPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12550c) {
                PeopleYouMayKnowLoadingPartDefinition peopleYouMayKnowLoadingPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowLoadingPartDefinition = (PeopleYouMayKnowLoadingPartDefinition) a2.a(f12550c);
                } else {
                    peopleYouMayKnowLoadingPartDefinition = f12549b;
                }
                if (peopleYouMayKnowLoadingPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m12540b();
                        if (a2 != null) {
                            a2.a(f12550c, b3);
                        } else {
                            f12549b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowLoadingPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

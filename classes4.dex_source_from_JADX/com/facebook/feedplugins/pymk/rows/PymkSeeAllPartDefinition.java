package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.pymk.views.rows.SeeAllPeopleYouMayKnowView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifs_highlight_star_nux_enabled */
public class PymkSeeAllPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, SeeAllPeopleYouMayKnowView> {
    public static final ViewType<SeeAllPeopleYouMayKnowView> f6700a = new C03091();
    private static PymkSeeAllPartDefinition f6701d;
    private static final Object f6702e = new Object();
    private final ClickListenerPartDefinition f6703b;
    public final IFeedIntentBuilder f6704c;

    /* compiled from: notifs_highlight_star_nux_enabled */
    final class C03091 extends ViewType<SeeAllPeopleYouMayKnowView> {
        C03091() {
        }

        public final View m7099a(Context context) {
            return new SeeAllPeopleYouMayKnowView(context);
        }
    }

    private static PymkSeeAllPartDefinition m7096b(InjectorLike injectorLike) {
        return new PymkSeeAllPartDefinition(ClickListenerPartDefinition.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike));
    }

    @Inject
    public PymkSeeAllPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, IFeedIntentBuilder iFeedIntentBuilder) {
        this.f6703b = clickListenerPartDefinition;
        this.f6704c = iFeedIntentBuilder;
    }

    public final ViewType<SeeAllPeopleYouMayKnowView> m7097a() {
        return f6700a;
    }

    public final Object m7098a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(2131566455, this.f6703b, new 2(this));
        return null;
    }

    public static PymkSeeAllPartDefinition m7095a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymkSeeAllPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6702e) {
                PymkSeeAllPartDefinition pymkSeeAllPartDefinition;
                if (a2 != null) {
                    pymkSeeAllPartDefinition = (PymkSeeAllPartDefinition) a2.a(f6702e);
                } else {
                    pymkSeeAllPartDefinition = f6701d;
                }
                if (pymkSeeAllPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7096b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6702e, b3);
                        } else {
                            f6701d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymkSeeAllPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

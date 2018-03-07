package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.hpp.ui.MobilePageAdminPanelPagePartDefinition.Props;
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
/* compiled from: null_state */
public class MobilePageAdminPanelSeeAllPagesPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, AnyEnvironment, SeeAllPagesYouManagedView> {
    public static final ViewType<SeeAllPagesYouManagedView> f6630a = new C03011();
    private static MobilePageAdminPanelSeeAllPagesPartDefinition f6631d;
    private static final Object f6632e = new Object();
    public final IFeedIntentBuilder f6633b;
    private final ClickListenerPartDefinition f6634c;

    /* compiled from: null_state */
    final class C03011 extends ViewType<SeeAllPagesYouManagedView> {
        C03011() {
        }

        public final View m7039a(Context context) {
            return new SeeAllPagesYouManagedView(context);
        }
    }

    private static MobilePageAdminPanelSeeAllPagesPartDefinition m7036b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelSeeAllPagesPartDefinition((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    @Inject
    public MobilePageAdminPanelSeeAllPagesPartDefinition(IFeedIntentBuilder iFeedIntentBuilder, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f6633b = iFeedIntentBuilder;
        this.f6634c = clickListenerPartDefinition;
    }

    public static MobilePageAdminPanelSeeAllPagesPartDefinition m7035a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelSeeAllPagesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6632e) {
                MobilePageAdminPanelSeeAllPagesPartDefinition mobilePageAdminPanelSeeAllPagesPartDefinition;
                if (a2 != null) {
                    mobilePageAdminPanelSeeAllPagesPartDefinition = (MobilePageAdminPanelSeeAllPagesPartDefinition) a2.a(f6632e);
                } else {
                    mobilePageAdminPanelSeeAllPagesPartDefinition = f6631d;
                }
                if (mobilePageAdminPanelSeeAllPagesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7036b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6632e, b3);
                        } else {
                            f6631d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelSeeAllPagesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SeeAllPagesYouManagedView> m7037a() {
        return f6630a;
    }

    public final Object m7038a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f6634c, new SeeAllButtonClickListener(this));
        return null;
    }
}

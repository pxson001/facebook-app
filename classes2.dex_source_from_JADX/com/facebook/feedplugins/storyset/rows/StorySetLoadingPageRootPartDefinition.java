package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.views.HScrollLoadingCardView;
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
/* compiled from: ka_GE */
public class StorySetLoadingPageRootPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, AnyEnvironment, HScrollLoadingCardView> {
    public static final ViewType<HScrollLoadingCardView> f18533a = new C07311();
    private static StorySetLoadingPageRootPartDefinition f18534b;
    private static final Object f18535c = new Object();

    /* compiled from: ka_GE */
    final class C07311 extends ViewType<HScrollLoadingCardView> {
        C07311() {
        }

        public final View mo1995a(Context context) {
            return new HScrollLoadingCardView(context);
        }
    }

    private static StorySetLoadingPageRootPartDefinition m26012b() {
        return new StorySetLoadingPageRootPartDefinition();
    }

    public final ViewType<HScrollLoadingCardView> mo2547a() {
        return f18533a;
    }

    public static StorySetLoadingPageRootPartDefinition m26011a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetLoadingPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18535c) {
                StorySetLoadingPageRootPartDefinition storySetLoadingPageRootPartDefinition;
                if (a2 != null) {
                    storySetLoadingPageRootPartDefinition = (StorySetLoadingPageRootPartDefinition) a2.mo818a(f18535c);
                } else {
                    storySetLoadingPageRootPartDefinition = f18534b;
                }
                if (storySetLoadingPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m26012b();
                        if (a2 != null) {
                            a2.mo822a(f18535c, b3);
                        } else {
                            f18534b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetLoadingPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feedplugins.storyset.rows.ui.StoryPageAppInstallPromoCardView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ka */
public class StorySetAppInstallPageRootPartDefinition extends BaseSinglePartDefinitionWithViewType<StorySetPageProps, Void, HasPositionInformation, StoryPageAppInstallPromoCardView> {
    public static final ViewType<StoryPageAppInstallPromoCardView> f18536a = new C07321();
    private static StorySetAppInstallPageRootPartDefinition f18537d;
    private static final Object f18538e = new Object();
    private final StorySetPageAppInstallPartDefinition f18539b;
    private final StorySetBackgroundPartDefinition f18540c;

    /* compiled from: ka */
    final class C07321 extends ViewType<StoryPageAppInstallPromoCardView> {
        C07321() {
        }

        public final View mo1995a(Context context) {
            return new StoryPageAppInstallPromoCardView(context);
        }
    }

    private static StorySetAppInstallPageRootPartDefinition m26016b(InjectorLike injectorLike) {
        return new StorySetAppInstallPageRootPartDefinition(StorySetPageAppInstallPartDefinition.a(injectorLike), StorySetBackgroundPartDefinition.a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f18539b, (StorySetPageProps) obj);
        subParts.mo2756a(this.f18540c, null);
        return null;
    }

    @Inject
    public StorySetAppInstallPageRootPartDefinition(StorySetPageAppInstallPartDefinition storySetPageAppInstallPartDefinition, StorySetBackgroundPartDefinition storySetBackgroundPartDefinition) {
        this.f18539b = storySetPageAppInstallPartDefinition;
        this.f18540c = storySetBackgroundPartDefinition;
    }

    public final ViewType<StoryPageAppInstallPromoCardView> mo2547a() {
        return f18536a;
    }

    public static StorySetAppInstallPageRootPartDefinition m26015a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetAppInstallPageRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18538e) {
                StorySetAppInstallPageRootPartDefinition storySetAppInstallPageRootPartDefinition;
                if (a2 != null) {
                    storySetAppInstallPageRootPartDefinition = (StorySetAppInstallPageRootPartDefinition) a2.mo818a(f18538e);
                } else {
                    storySetAppInstallPageRootPartDefinition = f18537d;
                }
                if (storySetAppInstallPageRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26016b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18538e, b3);
                        } else {
                            f18537d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetAppInstallPageRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.feedplugins.momentsupsell;

import android.content.Context;
import android.view.View;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.momentsupsell.analytics.MomentsUpsellFeedPluginLogger;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: imp_reason */
public class MomentsUpsellPartDefinition extends MultiRowSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, MomentsUpsellFooterView> {
    public static final ViewType f20336a = new C08231();
    private static MomentsUpsellPartDefinition f20337f;
    private static final Object f20338g = new Object();
    private final ClickListenerPartDefinition f20339b;
    public final AppsInstallHelper f20340c;
    private final MomentsUpsellImpressionHelper f20341d;
    public final MomentsUpsellFeedPluginLogger f20342e;

    /* compiled from: imp_reason */
    final class C08231 extends ViewType {
        C08231() {
        }

        public final View mo1995a(Context context) {
            return new MomentsUpsellFooterView(context);
        }
    }

    private static MomentsUpsellPartDefinition m27999b(InjectorLike injectorLike) {
        return new MomentsUpsellPartDefinition(ClickListenerPartDefinition.m19353a(injectorLike), (AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class), MomentsUpsellImpressionHelper.m27962a(injectorLike), MomentsUpsellFeedPluginLogger.m27970a(injectorLike));
    }

    public final boolean m28002a(Object obj) {
        return this.f20341d.m27966a((GraphQLStory) obj);
    }

    @Inject
    public MomentsUpsellPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, AppsInstallHelperProvider appsInstallHelperProvider, MomentsUpsellImpressionHelper momentsUpsellImpressionHelper, MomentsUpsellFeedPluginLogger momentsUpsellFeedPluginLogger) {
        this.f20339b = clickListenerPartDefinition;
        this.f20340c = appsInstallHelperProvider.m27972a(new MomentsInstallInfo());
        this.f20341d = momentsUpsellImpressionHelper;
        this.f20342e = momentsUpsellFeedPluginLogger;
    }

    public final ViewType mo2547a() {
        return f20336a;
    }

    public static MomentsUpsellPartDefinition m27998a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MomentsUpsellPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20338g) {
                MomentsUpsellPartDefinition momentsUpsellPartDefinition;
                if (a2 != null) {
                    momentsUpsellPartDefinition = (MomentsUpsellPartDefinition) a2.mo818a(f20338g);
                } else {
                    momentsUpsellPartDefinition = f20337f;
                }
                if (momentsUpsellPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27999b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20338g, b3);
                        } else {
                            f20337f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = momentsUpsellPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2755a(2131563918, this.f20339b, new 2(this));
        return null;
    }
}

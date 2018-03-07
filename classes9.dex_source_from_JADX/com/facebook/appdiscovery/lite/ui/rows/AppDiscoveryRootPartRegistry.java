package com.facebook.appdiscovery.lite.ui.rows;

import android.content.Context;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.appdiscovery.lite.model.unit.LiteRelatedAppsFeedUnit;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.AppDetailsGroupPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps.RelatedAppsGroupPartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.sections.GraphQLStorySelectorPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.PartWithIsNeeded;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_transaction_shipping_option */
public class AppDiscoveryRootPartRegistry {
    private static AppDiscoveryRootPartRegistry f4149b;
    private static final Object f4150c = new Object();
    public final Map<Class<?>, PartWithIsNeeded<?>> f4151a = new HashMap();

    private static AppDiscoveryRootPartRegistry m4210b(InjectorLike injectorLike) {
        return new AppDiscoveryRootPartRegistry(GraphQLStorySelectorPartDefinition.a(injectorLike), RelatedAppsGroupPartDefinition.m4232a(injectorLike), AppDetailsGroupPartDefinition.m4211a(injectorLike));
    }

    @Inject
    public AppDiscoveryRootPartRegistry(GraphQLStorySelectorPartDefinition graphQLStorySelectorPartDefinition, RelatedAppsGroupPartDefinition relatedAppsGroupPartDefinition, AppDetailsGroupPartDefinition appDetailsGroupPartDefinition) {
        m4209a(GraphQLStory.class, graphQLStorySelectorPartDefinition);
        m4209a(LiteRelatedAppsFeedUnit.class, relatedAppsGroupPartDefinition);
        m4209a(AppDetailsFeedUnit.class, appDetailsGroupPartDefinition);
    }

    private <T> void m4209a(Class<? extends T> cls, PartWithIsNeeded<? extends T> partWithIsNeeded) {
        this.f4151a.put(cls, partWithIsNeeded);
    }

    public static AppDiscoveryRootPartRegistry m4208a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppDiscoveryRootPartRegistry b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4150c) {
                AppDiscoveryRootPartRegistry appDiscoveryRootPartRegistry;
                if (a2 != null) {
                    appDiscoveryRootPartRegistry = (AppDiscoveryRootPartRegistry) a2.a(f4150c);
                } else {
                    appDiscoveryRootPartRegistry = f4149b;
                }
                if (appDiscoveryRootPartRegistry == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4210b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4150c, b3);
                        } else {
                            f4149b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = appDiscoveryRootPartRegistry;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

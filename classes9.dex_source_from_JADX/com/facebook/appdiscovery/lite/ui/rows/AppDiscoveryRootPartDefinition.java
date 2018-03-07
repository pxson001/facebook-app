package com.facebook.appdiscovery.lite.ui.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
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
import java.util.Map.Entry;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selection_index */
public class AppDiscoveryRootPartDefinition extends BaseMultiRowGroupPartDefinition<FeedUnit, Void, AppDiscoveryEnvironment> {
    private static AppDiscoveryRootPartDefinition f4145c;
    private static final Object f4146d = new Object();
    private final AppDiscoveryRootPartRegistry f4147a;
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f4148b;

    private static AppDiscoveryRootPartDefinition m4205b(InjectorLike injectorLike) {
        return new AppDiscoveryRootPartDefinition(AppDiscoveryRootPartRegistry.m4208a(injectorLike), IdBasedLazy.a(injectorLike, 6023));
    }

    public final Object m4206a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedUnit feedUnit = (FeedUnit) obj;
        for (Entry entry : this.f4147a.f4151a.entrySet()) {
            if (((Class) entry.getKey()).isInstance(feedUnit) && baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) entry.getValue(), FeedProps.c(feedUnit))) {
                break;
            }
        }
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f4148b.get(), feedUnit);
        return null;
    }

    @Inject
    public AppDiscoveryRootPartDefinition(AppDiscoveryRootPartRegistry appDiscoveryRootPartRegistry, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy) {
        this.f4147a = appDiscoveryRootPartRegistry;
        this.f4148b = lazy;
    }

    public final boolean m4207a(Object obj) {
        return true;
    }

    public static AppDiscoveryRootPartDefinition m4204a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppDiscoveryRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4146d) {
                AppDiscoveryRootPartDefinition appDiscoveryRootPartDefinition;
                if (a2 != null) {
                    appDiscoveryRootPartDefinition = (AppDiscoveryRootPartDefinition) a2.a(f4146d);
                } else {
                    appDiscoveryRootPartDefinition = f4145c;
                }
                if (appDiscoveryRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4205b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4146d, b3);
                        } else {
                            f4145c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = appDiscoveryRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.privacy;

import android.content.Context;
import com.facebook.api.feedcache.db.FeedDbCacheServiceHandler;
import com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.privacy.service.PrivacyCacheServiceHandler;
import com.facebook.privacy.service.PrivacyServiceHandler;

/* compiled from: fetch_hashtag_feed */
public class BlueServiceHandler_PrivacyDataQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    private static BlueServiceHandler f14943a;
    private static final Object f14944b = new Object();

    private static BlueServiceHandler m22541b(InjectorLike injectorLike) {
        return PrivacyModule.m22543a(FeedMemoryCacheServiceHandler.a(injectorLike), FeedDbCacheServiceHandler.a(injectorLike), PrivacyCacheServiceHandler.a(injectorLike), PrivacyServiceHandler.m22913b(injectorLike));
    }

    public Object get() {
        return PrivacyModule.m22543a(FeedMemoryCacheServiceHandler.a(this), FeedDbCacheServiceHandler.a(this), PrivacyCacheServiceHandler.a(this), PrivacyServiceHandler.m22913b(this));
    }

    public static BlueServiceHandler m22540a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlueServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14944b) {
                BlueServiceHandler blueServiceHandler;
                if (a2 != null) {
                    blueServiceHandler = (BlueServiceHandler) a2.a(f14944b);
                } else {
                    blueServiceHandler = f14943a;
                }
                if (blueServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22541b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14944b, b3);
                        } else {
                            f14943a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blueServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feed.data.followup.cache;

import android.content.Context;
import android.support.v4.util.LruCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: platform_upload_staging_resource_photos */
public class FollowUpStateCache {
    private static FollowUpStateCache f9576b;
    private static final Object f9577c = new Object();
    private final LruCache<String, FollowUpState> f9578a = new LruCache(16);

    private static FollowUpStateCache m14601a() {
        return new FollowUpStateCache();
    }

    public final boolean m14606a(String str) {
        return m14603c(str).a;
    }

    public final void m14605a(String str, boolean z) {
        m14603c(str).a = z;
    }

    public final GraphQLFollowUpFeedUnitActionType m14607b(String str) {
        return m14603c(str).b;
    }

    public final void m14604a(String str, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        m14603c(str).b = graphQLFollowUpFeedUnitActionType;
    }

    public static FollowUpStateCache m14602a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowUpStateCache a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f9577c) {
                FollowUpStateCache followUpStateCache;
                if (a3 != null) {
                    followUpStateCache = (FollowUpStateCache) a3.mo818a(f9577c);
                } else {
                    followUpStateCache = f9576b;
                }
                if (followUpStateCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m14601a();
                        if (a3 != null) {
                            a3.mo822a(f9577c, a2);
                        } else {
                            f9576b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = followUpStateCache;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }

    private FollowUpState m14603c(String str) {
        FollowUpState followUpState = (FollowUpState) this.f9578a.m4432a((Object) str);
        if (followUpState != null) {
            return followUpState;
        }
        Object followUpState2 = new FollowUpState();
        this.f9578a.m4433a((Object) str, followUpState2);
        return followUpState2;
    }
}

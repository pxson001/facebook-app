package com.facebook.redspace.badge;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.Set;

@ContextScoped
/* compiled from: Unable to convert filters to json string */
public class RedSpaceOptimisticBadgeStoreDebugHelper {
    private static RedSpaceOptimisticBadgeStoreDebugHelper f21268a;
    private static final Object f21269b = new Object();

    private static RedSpaceOptimisticBadgeStoreDebugHelper m24882a() {
        return new RedSpaceOptimisticBadgeStoreDebugHelper();
    }

    public static String m24884a(RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total badge count:\n").append(redSpaceOptimisticBadgeStore.i);
        stringBuilder.append("\nFriends with unseen stories:\n");
        for (String str : redSpaceOptimisticBadgeStore.e) {
            stringBuilder.append("friend: ").append(str).append(" stories: ").append((Set) redSpaceOptimisticBadgeStore.f.get(str));
        }
        stringBuilder.append("\nSeen stories:\n").append(redSpaceOptimisticBadgeStore.b);
        stringBuilder.append("\nFriend to stories:\n").append(redSpaceOptimisticBadgeStore.f);
        stringBuilder.append("\nStory to friends:\n").append(redSpaceOptimisticBadgeStore.g);
        return stringBuilder.toString();
    }

    public static RedSpaceOptimisticBadgeStoreDebugHelper m24883a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceOptimisticBadgeStoreDebugHelper a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f21269b) {
                RedSpaceOptimisticBadgeStoreDebugHelper redSpaceOptimisticBadgeStoreDebugHelper;
                if (a3 != null) {
                    redSpaceOptimisticBadgeStoreDebugHelper = (RedSpaceOptimisticBadgeStoreDebugHelper) a3.a(f21269b);
                } else {
                    redSpaceOptimisticBadgeStoreDebugHelper = f21268a;
                }
                if (redSpaceOptimisticBadgeStoreDebugHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m24882a();
                        if (a3 != null) {
                            a3.a(f21269b, a2);
                        } else {
                            f21268a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = redSpaceOptimisticBadgeStoreDebugHelper;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

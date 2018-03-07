package com.facebook.feed.rows.core.persistence;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ContextScoped
@ThreadSafe
/* compiled from: photos_create_album */
public class ContextStateMap {
    private static ContextStateMap f9905e;
    private static final Object f9906f = new Object();
    private final Object f9907a = new Object();
    @GuardedBy("mLock")
    private final Map<Object, Object> f9908b = new HashMap();
    @GuardedBy("mLock")
    private final List<String> f9909c = new ArrayList();
    @GuardedBy("mLock")
    private final List<Object> f9910d = new ArrayList();

    private static ContextStateMap m14936b() {
        return new ContextStateMap();
    }

    public final <K, T> T m14939a(ContextStateKey<K, T> contextStateKey) {
        T b = m14937b((ContextStateKey) contextStateKey);
        if (b == null) {
            b = contextStateKey.mo2130a();
            synchronized (this.f9907a) {
                T b2 = m14937b((ContextStateKey) contextStateKey);
                if (b2 == null) {
                    this.f9908b.put(contextStateKey.mo2131b(), b);
                } else {
                    b = b2;
                }
            }
        }
        return b;
    }

    public static ContextStateMap m14935a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContextStateMap b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9906f) {
                ContextStateMap contextStateMap;
                if (a2 != null) {
                    contextStateMap = (ContextStateMap) a2.mo818a(f9906f);
                } else {
                    contextStateMap = f9905e;
                }
                if (contextStateMap == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m14936b();
                        if (a2 != null) {
                            a2.mo822a(f9906f, b3);
                        } else {
                            f9905e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = contextStateMap;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final <K, T> T m14940a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        T b = m14937b((ContextStateKey) contextStateKey);
        if (b == null) {
            b = contextStateKey.mo2130a();
            synchronized (this.f9907a) {
                T b2 = m14937b((ContextStateKey) contextStateKey);
                if (b2 == null) {
                    this.f9908b.put(contextStateKey.mo2131b(), b);
                    this.f9909c.add(cacheableEntity.mo2507g());
                    this.f9910d.add(contextStateKey.mo2131b());
                } else {
                    b = b2;
                }
            }
        }
        return b;
    }

    public final <K, T> boolean m14943a(ContextStateKey<K, T> contextStateKey, T t) {
        boolean z;
        synchronized (this.f9907a) {
            if (m14937b((ContextStateKey) contextStateKey) == null) {
                z = false;
            } else {
                this.f9908b.put(contextStateKey.mo2131b(), t);
                z = true;
            }
        }
        return z;
    }

    public final void m14942a(List<String> list) {
        synchronized (this.f9907a) {
            m14938b((List) list);
        }
    }

    public final void m14941a() {
        synchronized (this.f9907a) {
            for (Object remove : this.f9910d) {
                this.f9908b.remove(remove);
            }
            this.f9910d.clear();
            this.f9909c.clear();
        }
    }

    private <K, T> T m14937b(ContextStateKey<K, T> contextStateKey) {
        T t;
        synchronized (this.f9907a) {
            t = this.f9908b.get(contextStateKey.mo2131b());
        }
        return t;
    }

    @GuardedBy("mLock")
    private void m14938b(List<String> list) {
        Iterator it = this.f9909c.iterator();
        Iterator it2 = this.f9910d.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object next = it2.next();
            if (list.contains(str)) {
                it.remove();
                it2.remove();
                this.f9908b.remove(next);
            }
        }
    }
}

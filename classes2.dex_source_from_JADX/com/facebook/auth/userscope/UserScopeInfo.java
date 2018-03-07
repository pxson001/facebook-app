package com.facebook.auth.userscope;

import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.BasicAllocator;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import java.util.concurrent.ConcurrentMap;

/* compiled from: sgny_imp */
public class UserScopeInfo {
    private static final ObjectPool<UserScopeInfo> f5031a;
    public ViewerContextManager f5032b;
    public ConcurrentMap<Object, Object> f5033c;

    /* compiled from: sgny_imp */
    final class C02451 extends BasicAllocator<UserScopeInfo> {
        C02451(Class cls) {
            super(cls);
        }

        public final void mo87a(Object obj) {
            UserScopeInfo userScopeInfo = (UserScopeInfo) obj;
            userScopeInfo.f5032b = null;
            userScopeInfo.f5033c = null;
        }

        public final Object mo86a() {
            return new UserScopeInfo();
        }
    }

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(UserScopeInfo.class, AwakeTimeSinceBootClock.INSTANCE);
        objectPoolBuilder.f517f = new C02451(UserScopeInfo.class);
        f5031a = objectPoolBuilder.m1047a();
    }

    static UserScopeInfo m8950a(ViewerContextManager viewerContextManager, ConcurrentMap<Object, Object> concurrentMap) {
        UserScopeInfo userScopeInfo = (UserScopeInfo) f5031a.m1057a();
        userScopeInfo.f5032b = viewerContextManager;
        userScopeInfo.f5033c = concurrentMap;
        return userScopeInfo;
    }

    public final ConcurrentMap<Object, Object> m8951b() {
        return this.f5033c;
    }

    public final void m8952c() {
        f5031a.m1058a((Object) this);
    }
}

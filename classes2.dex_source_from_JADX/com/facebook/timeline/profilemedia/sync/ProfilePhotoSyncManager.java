package com.facebook.timeline.profilemedia.sync;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.GuardedBy;

@UserScoped
/* compiled from: place_name */
public class ProfilePhotoSyncManager {
    private static final Object f9804g = new Object();
    @Inject
    public ProfilePicFetcher f9805a;
    @Inject
    @ForUiThread
    public ExecutorService f9806b;
    @GuardedBy("mRwLock")
    public final List<WeakReference<Listener>> f9807c = new ArrayList();
    private final ReadWriteLock f9808d = new ReentrantReadWriteLock();
    public final Lock f9809e = this.f9808d.readLock();
    private final Lock f9810f = this.f9808d.writeLock();

    /* compiled from: place_name */
    public interface Listener {
        void mo1950a();
    }

    private static ProfilePhotoSyncManager m14831b(InjectorLike injectorLike) {
        ProfilePhotoSyncManager profilePhotoSyncManager = new ProfilePhotoSyncManager();
        ExecutorService a = ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike);
        profilePhotoSyncManager.f9805a = ProfilePicFetcher.m14834a(injectorLike);
        profilePhotoSyncManager.f9806b = a;
        return profilePhotoSyncManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager m14830a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.m1499a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.mo191b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.m1454a(r1);
        r4 = r3.m8951b();	 Catch:{ all -> 0x006c }
        r1 = f9804g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.m8952c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.m1504b(r1);	 Catch:{  }
        r6 = r0.m1455a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.m1474e();	 Catch:{ all -> 0x0062 }
        r1 = m14831b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9804g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.f724a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.m1505c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager) r0;	 Catch:{  }
        r3.m8952c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.m1452a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.m1505c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.m8952c();
        throw r0;
    L_0x0071:
        r0 = f9804g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager");
    }

    public final void m14832a(Listener listener) {
        m14833b();
        this.f9810f.lock();
        try {
            this.f9807c.add(new WeakReference(listener));
        } finally {
            this.f9810f.unlock();
        }
    }

    @VisibleForTesting
    final void m14833b() {
        this.f9810f.lock();
        try {
            Iterator it = this.f9807c.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == null) {
                    it.remove();
                }
            }
        } finally {
            this.f9810f.unlock();
        }
    }
}

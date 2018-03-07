package com.facebook.multiprocess.peer.state;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.facebook.messages.ipc.peer.NotificationPeerRoleFactory;
import com.facebook.multiprocess.peer.PeerInfo;
import com.facebook.multiprocess.peer.PeerProcessManager;
import com.facebook.multiprocess.peer.PeerProcessManagerFactory;
import com.facebook.multiprocess.peer.PeerProcessMessageListener;
import com.facebook.multiprocess.peer.PeerProcessStatusListener;
import com.facebook.multiprocess.peer.PeerProcessStatusListener.Direction;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: time_last_photo_reminder_prompt_posted */
public class StatefulPeerManagerImpl implements IHaveUserData, INeedInit {
    protected final Class<?> f2868a = getClass();
    private final NotificationPeerRoleFactory f2869b;
    @GuardedBy("this")
    public final Map<PeerInfo, Set<PeerStateRole>> f2870c;
    @GuardedBy("this")
    public final Map<Uri, SortedSet<PeerStateRole>> f2871d;
    @GuardedBy("this")
    private final Map<Uri, WeakHashMap<PeerStateObserver, Boolean>> f2872e;
    public final ImmutableSet<PeerStateRole> f2873f;
    public final PeerProcessManager f2874g;
    public final ClassLoader f2875h;
    public final Lazy<FbErrorReporter> f2876i;
    private final boolean f2877j;

    /* compiled from: time_last_photo_reminder_prompt_posted */
    class PeerListener implements PeerProcessMessageListener, PeerProcessStatusListener {
        final /* synthetic */ StatefulPeerManagerImpl f2902a;

        public PeerListener(StatefulPeerManagerImpl statefulPeerManagerImpl) {
            this.f2902a = statefulPeerManagerImpl;
        }

        public final void mo688a(PeerInfo peerInfo, Message message) {
            Bundle data = message.getData();
            if (this.f2902a.f2875h != null) {
                data.setClassLoader(this.f2902a.f2875h);
            }
            switch (message.what) {
                case 1000000000:
                    this.f2902a.m4868b(peerInfo, data);
                    return;
                case 1000000001:
                    this.f2902a.m4863a(peerInfo, data);
                    return;
                default:
                    return;
            }
        }

        public final void mo689a(PeerInfo peerInfo, Direction direction) {
            if (!this.f2902a.f2873f.isEmpty()) {
                this.f2902a.f2874g.mo685a(peerInfo, StatefulPeerManagerImpl.m4862a(this.f2902a));
            }
        }

        public final void mo687a(PeerInfo peerInfo) {
            synchronized (this.f2902a) {
                Set<PeerStateRole> set = (Set) this.f2902a.f2870c.get(peerInfo);
                if (!(set == null || set.isEmpty())) {
                    for (PeerStateRole peerStateRole : set) {
                        peerStateRole.mo677a();
                        SortedSet sortedSet = (SortedSet) this.f2902a.f2871d.get(peerStateRole.m4850c());
                        if (sortedSet == null) {
                            BLog.b(this.f2902a.f2868a, "Invalid state: there should be roles for base uri %s when %s disconnected.", new Object[]{peerStateRole.m4850c(), peerInfo.f2901c});
                            ((AbstractFbErrorReporter) this.f2902a.f2876i.get()).m2340a(this.f2902a.f2868a.getSimpleName(), "Invalid state: there should be roles for base uri " + peerStateRole.m4850c() + " when " + peerInfo.f2901c + " disconnected.");
                        } else {
                            sortedSet.remove(peerStateRole);
                            if (sortedSet.isEmpty()) {
                                this.f2902a.f2871d.remove(peerStateRole.m4850c());
                            }
                        }
                    }
                }
                this.f2902a.f2870c.remove(peerInfo);
            }
            if (set != null) {
                for (PeerStateRole c : set) {
                    StatefulPeerManagerImpl.m4865a(this.f2902a, Uri.withAppendedPath(c.m4850c(), "disconnected"), false);
                }
            }
        }
    }

    public StatefulPeerManagerImpl(PeerStateRoleFactory peerStateRoleFactory, ImmutableSet<PeerStateRole> immutableSet, PeerProcessManagerFactory peerProcessManagerFactory, String str, FbBroadcastManager fbBroadcastManager, ClassLoader classLoader, Lazy<FbErrorReporter> lazy, boolean z) {
        this.f2869b = peerStateRoleFactory;
        this.f2873f = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
        this.f2876i = lazy;
        this.f2870c = Maps.m838c();
        this.f2871d = Maps.m838c();
        this.f2872e = Maps.m838c();
        this.f2877j = z;
        this.f2875h = classLoader;
        this.f2874g = peerProcessManagerFactory.m4836a(str, fbBroadcastManager, this.f2877j);
        PeerProcessMessageListener peerListener = new PeerListener(this);
        this.f2874g.mo686a((PeerProcessStatusListener) peerListener);
        this.f2874g.mo683a(1000000000, peerListener);
        this.f2874g.mo683a(1000000001, peerListener);
        m4864a(this.f2874g.mo682a(), this.f2873f);
    }

    public void init() {
        this.f2874g.init();
    }

    public void clearUserData() {
        if (this.f2877j) {
            synchronized (this) {
                this.f2870c.clear();
                this.f2871d.clear();
                Iterator it = this.f2873f.iterator();
                while (it.hasNext()) {
                    ((PeerStateRole) it.next()).mo677a();
                }
                m4864a(this.f2874g.mo682a(), this.f2873f);
            }
            this.f2874g.clearUserData();
        }
    }

    public final synchronized Object m4870a(Uri uri) {
        Object obj;
        for (Entry entry : this.f2871d.entrySet()) {
            if (m4867a(uri, (Uri) entry.getKey())) {
                QueryStateResult queryStateResult = new QueryStateResult();
                for (PeerStateRole a : (SortedSet) entry.getValue()) {
                    a.mo678a(uri, queryStateResult);
                    if (queryStateResult.b) {
                        obj = queryStateResult.a;
                        break;
                    }
                }
                obj = queryStateResult.a;
            }
        }
        obj = null;
        return obj;
    }

    public final void m4872a(Uri uri, @Nullable Object obj) {
        if (this.f2873f.isEmpty()) {
            throw new IllegalStateException("Current process " + this.f2874g.mo682a().f2901c + " is not a stateful peer.");
        }
        PeerStateRole peerStateRole;
        Iterator it = this.f2873f.iterator();
        while (it.hasNext()) {
            peerStateRole = (PeerStateRole) it.next();
            if (m4867a(uri, peerStateRole.m4850c())) {
                break;
            }
        }
        peerStateRole = null;
        if (peerStateRole != null) {
            boolean a;
            Message obtain = Message.obtain(null, 1000000001);
            Bundle data = obtain.getData();
            synchronized (this) {
                a = peerStateRole.mo680a(uri, obj);
                if (a) {
                    peerStateRole.mo679a(data);
                }
            }
            if (a) {
                data.putParcelable("__STATE_URI__", uri);
                this.f2874g.mo684a(obtain);
                m4865a(this, uri, true);
            }
        }
    }

    public final synchronized void m4871a(Uri uri, PeerStateObserver peerStateObserver) {
        WeakHashMap weakHashMap = (WeakHashMap) this.f2872e.get(uri);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
        }
        weakHashMap.put(peerStateObserver, Boolean.valueOf(true));
        this.f2872e.put(uri, weakHashMap);
    }

    public final synchronized void m4873a(PeerStateObserver peerStateObserver) {
        Iterator it = this.f2872e.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((WeakHashMap) entry.getValue()).remove(peerStateObserver) != null && ((WeakHashMap) entry.getValue()).isEmpty()) {
                it.remove();
            }
        }
    }

    public static void m4865a(StatefulPeerManagerImpl statefulPeerManagerImpl, Uri uri, boolean z) {
        List<PeerStateObserver> a = Lists.m1296a();
        synchronized (statefulPeerManagerImpl) {
            for (Entry entry : statefulPeerManagerImpl.f2872e.entrySet()) {
                if (m4867a(uri, (Uri) entry.getKey())) {
                    a.addAll(((WeakHashMap) entry.getValue()).keySet());
                }
            }
        }
        for (PeerStateObserver a2 : a) {
            a2.mo882a(uri, z);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4863a(com.facebook.multiprocess.peer.PeerInfo r6, android.os.Bundle r7) {
        /*
        r5 = this;
        r2 = 0;
        r0 = "__STATE_URI__";
        r0 = r7.getParcelable(r0);
        r0 = (android.net.Uri) r0;
        monitor-enter(r5);
        r1 = r5.f2870c;	 Catch:{ all -> 0x003b }
        r1 = r1.get(r6);	 Catch:{ all -> 0x003b }
        r1 = (java.util.Set) r1;	 Catch:{ all -> 0x003b }
        if (r1 != 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
    L_0x0015:
        return;
    L_0x0016:
        r3 = r1.iterator();	 Catch:{ all -> 0x003b }
    L_0x001a:
        r1 = r3.hasNext();	 Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x003e;
    L_0x0020:
        r1 = r3.next();	 Catch:{ all -> 0x003b }
        r1 = (com.facebook.multiprocess.peer.state.PeerStateRole) r1;	 Catch:{ all -> 0x003b }
        r4 = r1.m4850c();	 Catch:{ all -> 0x003b }
        r4 = m4867a(r0, r4);	 Catch:{ all -> 0x003b }
        if (r4 == 0) goto L_0x001a;
    L_0x0030:
        r1.mo681b(r7);	 Catch:{ all -> 0x003b }
        r1 = 1;
    L_0x0034:
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x0015;
    L_0x0037:
        m4865a(r5, r0, r2);
        goto L_0x0015;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x003e:
        r1 = r2;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl.a(com.facebook.multiprocess.peer.PeerInfo, android.os.Bundle):void");
    }

    private synchronized void m4864a(PeerInfo peerInfo, Set<PeerStateRole> set) {
        this.f2870c.put(peerInfo, set);
        for (PeerStateRole peerStateRole : set) {
            SortedSet sortedSet = (SortedSet) this.f2871d.get(peerStateRole.m4850c());
            if (sortedSet == null) {
                sortedSet = Sets.m1319a(PeerStateRole.f2852a);
            }
            sortedSet.add(peerStateRole);
            this.f2871d.put(peerStateRole.m4850c(), sortedSet);
        }
    }

    public static synchronized Message m4862a(StatefulPeerManagerImpl statefulPeerManagerImpl) {
        Message obtain;
        synchronized (statefulPeerManagerImpl) {
            obtain = Message.obtain(null, 1000000000);
            Bundle data = obtain.getData();
            ArrayList a = Lists.m1296a();
            ArrayList a2 = Lists.m1296a();
            ArrayList a3 = Lists.m1296a();
            Iterator it = statefulPeerManagerImpl.f2873f.iterator();
            while (it.hasNext()) {
                PeerStateRole peerStateRole = (PeerStateRole) it.next();
                a2.add(peerStateRole.m4850c());
                a3.add(Integer.valueOf(peerStateRole.m4848b()));
                Bundle bundle = new Bundle();
                peerStateRole.mo679a(bundle);
                a.add(bundle);
            }
            data.putParcelableArrayList("__BASE_URIS__", a2);
            data.putIntegerArrayList("__PRIORITIES__", a3);
            data.putParcelableArrayList("__ROLES_DATA__", a);
        }
        return obtain;
    }

    private synchronized void m4868b(PeerInfo peerInfo, Bundle bundle) {
        List parcelableArrayList = bundle.getParcelableArrayList("__BASE_URIS__");
        List integerArrayList = bundle.getIntegerArrayList("__PRIORITIES__");
        List parcelableArrayList2 = bundle.getParcelableArrayList("__ROLES_DATA__");
        Set a = Sets.m1313a();
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            PeerStateRole a2 = this.f2869b.m4832a((Uri) parcelableArrayList.get(i), ((Integer) integerArrayList.get(i)).intValue());
            if (a2 == null) {
                ((AbstractFbErrorReporter) this.f2876i.get()).m2340a(this.f2868a.getSimpleName(), "Can not create PeerStateRole for base uri " + parcelableArrayList.get(i) + " with priority " + integerArrayList.get(i) + " in process " + this.f2874g.mo682a().f2901c);
            } else {
                a2.mo681b((Bundle) parcelableArrayList2.get(i));
                a.add(a2);
            }
        }
        m4864a(peerInfo, a);
    }

    private static boolean m4867a(Uri uri, Uri uri2) {
        if (!uri.getAuthority().equals(uri2.getAuthority())) {
            return false;
        }
        List pathSegments = uri.getPathSegments();
        List pathSegments2 = uri2.getPathSegments();
        if (pathSegments.size() < pathSegments2.size()) {
            return false;
        }
        for (int i = 0; i < pathSegments2.size(); i++) {
            if (!((String) pathSegments.get(i)).equals(pathSegments2.get(i))) {
                return false;
            }
        }
        return true;
    }
}

package com.facebook.video.server.prefetcher;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Lazy;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.server.prefetcher.VideoPrefetcher.VideoPrefetcherCallback;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: place_review_img_width */
public class VideoPrefetchModel {
    private static final String f9790a = VideoPrefetchModel.class.getSimpleName();
    private static final Comparator<VideoPrefetchLocation> f9791b = new C04121();
    private final AbstractFbErrorReporter f9792c;
    private final Lazy<VideoPrefetcher> f9793d;
    private final Lazy<VideoPrefetchExperimentHelper> f9794e;
    @GuardedBy("this")
    private final TreeMap<VideoPrefetchLocation, VideoPrefetchListImpl> f9795f = new TreeMap(f9791b);
    private final TreeMap<VideoPrefetchLocation, VideoPrefetchListImpl> f9796g = new TreeMap(f9791b);
    @GuardedBy("this")
    private final Set<Uri> f9797h = new HashSet();
    @GuardedBy("mCallbacks")
    private final Set<Callback> f9798i = new HashSet();

    /* compiled from: place_review_img_width */
    final class C04121 implements Comparator<VideoPrefetchLocation> {
        C04121() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((VideoPrefetchLocation) obj2).priority - ((VideoPrefetchLocation) obj).priority;
        }
    }

    /* compiled from: place_review_img_width */
    public class ListCallback {
        final /* synthetic */ VideoPrefetchModel f11474a;

        public ListCallback(VideoPrefetchModel videoPrefetchModel) {
            this.f11474a = videoPrefetchModel;
        }

        public final void m16786a() {
            VideoPrefetchModel.m14815c(this.f11474a);
        }

        public final void m16787b() {
            VideoPrefetchModel.m14815c(this.f11474a);
        }

        public final void m16788c() {
            VideoPrefetchModel.m14815c(this.f11474a);
        }
    }

    public VideoPrefetchModel(FbErrorReporter fbErrorReporter, Lazy<VideoPrefetcher> lazy, Lazy<VideoPrefetchExperimentHelper> lazy2) {
        this.f9792c = fbErrorReporter;
        this.f9793d = lazy;
        this.f9794e = lazy2;
    }

    public final synchronized VideoPrefetchList m14816a(VideoPrefetchLocation videoPrefetchLocation) {
        VideoPrefetchList twoPassPrefetchList;
        Integer.valueOf(((VideoPrefetcher) this.f9793d.get()).hashCode());
        VideoPrefetchListImpl a = m14813a(this.f9795f, videoPrefetchLocation);
        if (((VideoPrefetchExperimentHelper) this.f9794e.get()).m16708a()) {
            twoPassPrefetchList = new TwoPassPrefetchList(a, m14813a(this.f9796g, videoPrefetchLocation));
        } else {
            twoPassPrefetchList = a;
        }
        return twoPassPrefetchList;
    }

    private VideoPrefetchListImpl m14813a(Map<VideoPrefetchLocation, VideoPrefetchListImpl> map, VideoPrefetchLocation videoPrefetchLocation) {
        VideoPrefetchListImpl videoPrefetchListImpl = (VideoPrefetchListImpl) map.get(videoPrefetchLocation);
        if (videoPrefetchListImpl != null) {
            return videoPrefetchListImpl;
        }
        videoPrefetchListImpl = new VideoPrefetchListImpl(new ListCallback(this), this.f9792c, videoPrefetchLocation);
        map.put(videoPrefetchLocation, videoPrefetchListImpl);
        return videoPrefetchListImpl;
    }

    public final synchronized boolean m14820a() {
        boolean z;
        for (VideoPrefetchListImpl c : this.f9795f.values()) {
            if (c.m16778c()) {
                z = true;
                break;
            }
        }
        if (((VideoPrefetchExperimentHelper) this.f9794e.get()).m16708a()) {
            for (VideoPrefetchListImpl c2 : this.f9796g.values()) {
                if (c2.m16778c()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }

    @Nullable
    public final synchronized VideoPrefetchItem m14821b() {
        VideoPrefetchItem a;
        VideoPrefetchItem a2 = m14812a(this.f9795f, false);
        if (a2 == null && ((VideoPrefetchExperimentHelper) this.f9794e.get()).m16708a()) {
            a = m14812a(this.f9796g, true);
        } else {
            a = a2;
        }
        if (a != null) {
            this.f9797h.add(a.a().a());
        }
        return a;
    }

    @GuardedBy("this")
    private static VideoPrefetchItem m14812a(Map<VideoPrefetchLocation, VideoPrefetchListImpl> map, boolean z) {
        for (VideoPrefetchListImpl videoPrefetchListImpl : map.values()) {
            if (videoPrefetchListImpl.m16778c()) {
                return new VideoPrefetchItem(videoPrefetchListImpl.m16779d(), videoPrefetchListImpl.f11471e, z);
            }
        }
        return null;
    }

    public final synchronized void m14817a(Uri uri) {
        for (VideoPrefetchListImpl a : this.f9795f.values()) {
            a.m16771a(uri);
        }
        for (VideoPrefetchListImpl a2 : this.f9796g.values()) {
            a2.m16771a(uri);
        }
    }

    public final synchronized boolean m14822b(Uri uri) {
        return !this.f9797h.contains(uri);
    }

    @GuardedBy("this")
    private void m14814a(VideoPrefetchItem videoPrefetchItem) {
        VideoPrefetchList videoPrefetchList = (VideoPrefetchList) this.f9795f.get(videoPrefetchItem.c);
        if (videoPrefetchList != null) {
            videoPrefetchList.mo2175a(videoPrefetchItem.b);
        }
    }

    public final synchronized void m14818a(VideoPrefetchItem videoPrefetchItem, boolean z) {
        boolean remove = this.f9797h.remove(videoPrefetchItem.a().a());
        if (!z && remove) {
            m14814a(videoPrefetchItem);
        }
    }

    public final synchronized void m14819a(VideoPrefetcherCallback videoPrefetcherCallback) {
        synchronized (this.f9798i) {
            this.f9798i.add(videoPrefetcherCallback);
        }
    }

    public static void m14815c(VideoPrefetchModel videoPrefetchModel) {
        synchronized (videoPrefetchModel.f9798i) {
            for (VideoPrefetcherCallback a : videoPrefetchModel.f9798i) {
                a.m16739a();
            }
        }
    }
}

package com.facebook.feed.rows.core;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.collectlite.ManagedIntArray;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.util.unit.FeedUnitCacheIdUtil;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nearby/subcategory */
public class DefaultAdaptersCollection<T> implements AdaptersCollection<T> {
    private final AndroidComponentsExperimentHelper f12936a;
    private final FeedUnitAdapterFactory f12937b;
    private final ListItemCollection<T> f12938c;
    private final ListItemComparator f12939d;
    private final Map<RowKey, Integer> f12940e = Maps.m838c();
    private final AnyEnvironment f12941f;
    public final Set<Object> f12942g = new HashSet();
    private final RowIdentifier f12943h = new C05271(this);
    private final DirtyListener f12944i = new C05282(this);
    public List<BoundedAdapter> f12945j = Lists.m1296a();
    private ManagedIntArray f12946k = ManagedIntArray.m19031a(10);
    private int[] f12947l;

    /* compiled from: nearby/subcategory */
    class C05271 implements RowIdentifier {
        final /* synthetic */ DefaultAdaptersCollection f12948a;

        C05271(DefaultAdaptersCollection defaultAdaptersCollection) {
            this.f12948a = defaultAdaptersCollection;
        }

        @Nullable
        public final RowKey mo2531a(int i) {
            return DefaultAdaptersCollection.m18999f(this.f12948a, i);
        }

        public final int mo2530a() {
            return this.f12948a.mo2521b();
        }
    }

    /* compiled from: nearby/subcategory */
    class C05282 implements DirtyListener {
        final /* synthetic */ DefaultAdaptersCollection f12949a;

        C05282(DefaultAdaptersCollection defaultAdaptersCollection) {
            this.f12949a = defaultAdaptersCollection;
        }

        public final void mo2532a(Object obj) {
            this.f12949a.f12942g.add(FeedUnitCacheIdUtil.m20097a(obj));
        }
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        DumpsysDumper dumpsysDumper = dumpsysContext.f;
        PrintWriter printWriter = dumpsysContext.e;
        int i = 0;
        for (FeedUnitAdapter feedUnitAdapter : new 4(this)) {
            printWriter.println("story " + i + " of " + this.f12938c.mo1374a());
            dumpsysDumper.a(feedUnitAdapter, dumpsysContext);
            i++;
        }
    }

    @Inject
    public DefaultAdaptersCollection(@Assisted FeedUnitAdapterFactory feedUnitAdapterFactory, @Assisted ListItemCollection listItemCollection, @Assisted AnyEnvironment anyEnvironment, @Assisted ListItemComparator listItemComparator, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f12937b = feedUnitAdapterFactory;
        this.f12938c = listItemCollection;
        this.f12939d = listItemComparator;
        this.f12941f = anyEnvironment;
        this.f12936a = androidComponentsExperimentHelper;
        if (this.f12941f instanceof DirtyUnitObserver) {
            DirtyUnitObserver dirtyUnitObserver = (DirtyUnitObserver) this.f12941f;
            dirtyUnitObserver.mo2435a(this.f12944i);
            dirtyUnitObserver.a_(true);
        }
    }

    public final void mo2520a() {
        m18998b(this.f12945j);
        if (this.f12936a.m10063o()) {
            FeedUnitAdapter feedUnitAdapter = null;
            for (BoundedAdapter boundedAdapter : this.f12945j) {
                FeedUnitAdapter feedUnitAdapter2;
                if (boundedAdapter.f13446a != feedUnitAdapter) {
                    feedUnitAdapter2 = boundedAdapter.f13446a;
                    feedUnitAdapter2.m19051d();
                } else {
                    feedUnitAdapter2 = feedUnitAdapter;
                }
                feedUnitAdapter = feedUnitAdapter2;
            }
        }
    }

    public final BoundedAdapter mo2519a(int i) {
        return (BoundedAdapter) this.f12945j.get(i);
    }

    public final int mo2522b(int i) {
        if ((this.f12946k.f12951b == 0 ? 1 : null) != null) {
            return 0;
        }
        return this.f12946k.m19034c(Math.max(Math.min(i, this.f12946k.f12951b - 1), 0));
    }

    public final int mo2523c(int i) {
        if (this.f12947l.length == 0) {
            return 0;
        }
        return this.f12947l[Math.max(Math.min(i, this.f12947l.length - 1), 0)];
    }

    public final int mo2525d(int i) {
        if (this.f12947l.length == 0) {
            return 0;
        }
        int max = Math.max(Math.min(i, this.f12947l.length - 1), 0);
        if (this.f12945j.size() <= this.f12947l[max]) {
            return 0;
        }
        return (((BoundedAdapter) this.f12945j.get(this.f12947l[max])).f13446a.m19044a() - 1) + this.f12947l[max];
    }

    public final int mo2527e(int i) {
        return ((BoundedAdapter) this.f12945j.get(this.f12947l[i])).f13446a.m19044a();
    }

    public final int mo2521b() {
        return this.f12945j.size();
    }

    public final void mo2524c() {
        m18998b(this.f12945j);
        this.f12945j = Lists.m1296a();
    }

    public final RowIdentifier mo2526d() {
        return this.f12943h;
    }

    public final void mo2528e() {
        DirtyUnitObserver dirtyUnitObserver;
        int i = 0;
        TracerDetour.a("AdaptersCollection.regenerateInternalAdapters", -2032073109);
        if (this.f12941f instanceof DirtyUnitObserver) {
            dirtyUnitObserver = (DirtyUnitObserver) this.f12941f;
        } else {
            dirtyUnitObserver = null;
        }
        try {
            m19000g();
            List list = this.f12945j;
            this.f12945j = Lists.m1296a();
            int i2 = 0;
            while (i2 < this.f12938c.mo1374a()) {
                int i3;
                Object a = this.f12938c.mo1375a(i2);
                if (i >= list.size()) {
                    m18996a(a, i2);
                    i3 = i;
                } else if (dirtyUnitObserver != null && FeedUnitCacheIdUtil.m20098b(a) && this.f12942g.remove(FeedUnitCacheIdUtil.m20097a(a))) {
                    m18996a(a, i2);
                    i3 = i;
                } else {
                    BoundedAdapter boundedAdapter = (BoundedAdapter) list.get(i);
                    if (this.f12939d.mo1978a(a, m18995a(boundedAdapter))) {
                        int a2 = boundedAdapter.f13446a.m19044a();
                        if (this.f12939d.mo1979a(a, m18995a(boundedAdapter), boundedAdapter.f13448c)) {
                            m18997a(list, i, i2);
                        } else {
                            m18996a(a, i2);
                            boundedAdapter.f13446a.m19050c();
                        }
                        i3 = i + a2;
                    } else {
                        m18996a(a, i2);
                        i3 = i;
                    }
                }
                i2++;
                i = i3;
            }
            m18998b(list.subList(i, list.size()));
        } finally {
            TracerDetour.a(-1970822128);
        }
    }

    public final int mo2529f() {
        return this.f12938c.mo1374a();
    }

    private static Object m18995a(BoundedAdapter boundedAdapter) {
        if (boundedAdapter.f13449d != null) {
            return boundedAdapter.f13449d;
        }
        return boundedAdapter.f13446a.f12957b;
    }

    @Nullable
    public static RowKey m18999f(DefaultAdaptersCollection defaultAdaptersCollection, int i) {
        if (i < 0 || i >= defaultAdaptersCollection.f12945j.size()) {
            return null;
        }
        return ((BoundedAdapter) defaultAdaptersCollection.f12945j.get(i)).m19813d();
    }

    private void m19000g() {
        this.f12946k.m19035c();
        this.f12940e.clear();
        this.f12947l = new int[this.f12938c.mo1374a()];
    }

    private void m18997a(List<BoundedAdapter> list, int i, int i2) {
        this.f12947l[i2] = this.f12945j.size();
        for (int i3 = 0; i3 < ((BoundedAdapter) list.get(i)).f13446a.m19044a(); i3++) {
            this.f12946k.m19033b(i2);
            this.f12945j.add(list.get(i + i3));
            m19001g(this.f12945j.size() - 1);
        }
    }

    private void m18996a(T t, int i) {
        FeedUnitAdapter a = this.f12937b.mo2518a(t, this.f12941f);
        this.f12947l[i] = this.f12945j.size();
        for (int i2 = 0; i2 < a.m19044a(); i2++) {
            this.f12946k.m19033b(i);
            this.f12945j.add(a.m19054g(i2));
            m19001g(this.f12945j.size() - 1);
        }
    }

    private void m19001g(int i) {
        this.f12940e.put(m18999f(this, i), Integer.valueOf(i));
    }

    private static void m18998b(List<BoundedAdapter> list) {
        FeedUnitAdapter feedUnitAdapter = null;
        for (BoundedAdapter boundedAdapter : list) {
            FeedUnitAdapter feedUnitAdapter2;
            if (boundedAdapter.f13446a != feedUnitAdapter) {
                feedUnitAdapter2 = boundedAdapter.f13446a;
                feedUnitAdapter2.m19050c();
            } else {
                feedUnitAdapter2 = feedUnitAdapter;
            }
            feedUnitAdapter = feedUnitAdapter2;
        }
    }
}

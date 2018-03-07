package com.facebook.feed.rows.core;

import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.facebook.api.feed.data.collections.ObservableListItemCollection;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.collect.ListObserver;
import com.facebook.common.collectlite.ManagedIntArray;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.DirtyListener;
import com.facebook.multirow.api.DirtyUnitObserver;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: min_duration */
public class ObservableAdaptersCollection<T, E extends AnyEnvironment> implements AdaptersCollection<T> {
    private static final AdapterDataObserver f13502a = new C05481();
    private final AbstractFbErrorReporter f13503b;
    private final AndroidComponentsExperimentHelper f13504c;
    public final ObservableListItemCollection<T> f13505d;
    private final FeedUnitAdapterFactory<T, E> f13506e;
    private final E f13507f;
    public final List<FeedUnitAdapter<?, E>> f13508g = new ArrayList();
    public final List<RowKey> f13509h = new ArrayList();
    private final ManagedIntArray f13510i;
    private final ManagedIntArray f13511j;
    public final ListItemCollectionObserver f13512k = new ListItemCollectionObserver(this);
    private final RowIdentifier f13513l = new C05492(this);
    private final DirtyListener f13514m = new C05503(this);
    public AdapterDataObserver f13515n = f13502a;
    private boolean f13516o = true;
    private int f13517p = 0;
    @Nullable
    private Exception f13518q;

    /* compiled from: min_duration */
    final class C05481 extends AdapterDataObserver {
        C05481() {
        }
    }

    /* compiled from: min_duration */
    class ListItemCollectionObserver implements ListObserver<T> {
        final /* synthetic */ ObservableAdaptersCollection f13582a;

        public ListItemCollectionObserver(ObservableAdaptersCollection observableAdaptersCollection) {
            this.f13582a = observableAdaptersCollection;
        }

        public final void mo1387a(int i, T t, T t2, boolean z) {
            TracerDetour.a("ObservableAdaptersCollection.onItemChanged", -1627563185);
            try {
                int c = this.f13582a.mo2523c(i);
                FeedUnitAdapter feedUnitAdapter = (FeedUnitAdapter) this.f13582a.f13508g.get(i);
                FeedUnitAdapter h = ObservableAdaptersCollection.m19876h(this.f13582a, i);
                int a = feedUnitAdapter.m19044a();
                if (m19967a(feedUnitAdapter, h)) {
                    this.f13582a.f13508g.set(i, h);
                    this.f13582a.f13515n.mo2217a(c, a);
                    this.f13582a.f13517p = 4;
                } else {
                    this.f13582a.f13508g.remove(i);
                    ObservableAdaptersCollection.m19875g(this.f13582a);
                    this.f13582a.f13515n.mo2212c(c, a);
                    this.f13582a.f13508g.add(i, h);
                    ObservableAdaptersCollection.m19875g(this.f13582a);
                    this.f13582a.f13515n.mo2210b(c, h.m19044a());
                    this.f13582a.f13517p = 7;
                }
                feedUnitAdapter.m19050c();
                ObservableAdaptersCollection.m19869a(this.f13582a, i, z);
                TracerDetour.a(-457790827);
            } catch (Exception e) {
                this.f13582a.f13518q = e;
                throw Throwables.propagate(e);
            } catch (Throwable th) {
                TracerDetour.a(692769052);
            }
        }

        private static boolean m19967a(FeedUnitAdapter<?, E> feedUnitAdapter, FeedUnitAdapter<?, E> feedUnitAdapter2) {
            if (feedUnitAdapter.m19044a() != feedUnitAdapter2.m19044a()) {
                return false;
            }
            for (int a = feedUnitAdapter.m19044a() - 1; a >= 0; a--) {
                if (!feedUnitAdapter.m19047b(a).equals(feedUnitAdapter2.m19047b(a))) {
                    return false;
                }
            }
            return true;
        }

        public final void mo1388a(int i, T t, boolean z) {
            if (i > this.f13582a.f13508g.size()) {
                ObservableAdaptersCollection.m19872b(this.f13582a, i, z);
            }
            TracerDetour.a("ObservableAdaptersCollection.onItemInserted", 1303183470);
            try {
                int b = i == this.f13582a.f13508g.size() ? this.f13582a.mo2521b() : this.f13582a.mo2523c(i);
                FeedUnitAdapter h = ObservableAdaptersCollection.m19876h(this.f13582a, i);
                this.f13582a.f13508g.add(i, h);
                ObservableAdaptersCollection.m19875g(this.f13582a);
                this.f13582a.f13515n.mo2210b(b, h.m19044a());
                ObservableAdaptersCollection.m19869a(this.f13582a, i, z);
                TracerDetour.a(192803945);
                this.f13582a.f13517p = 1;
            } catch (Exception e) {
                this.f13582a.f13518q = e;
                throw Throwables.propagate(e);
            } catch (Throwable th) {
                TracerDetour.a(-417095424);
            }
        }

        public final void mo1389b(int i, T t, boolean z) {
            TracerDetour.a("ObservableAdaptersCollection.onItemRemoved", 743892554);
            try {
                int c = this.f13582a.mo2523c(i);
                FeedUnitAdapter feedUnitAdapter = (FeedUnitAdapter) this.f13582a.f13508g.remove(i);
                feedUnitAdapter.m19050c();
                ObservableAdaptersCollection.m19875g(this.f13582a);
                this.f13582a.f13515n.mo2212c(c, feedUnitAdapter.m19044a());
                if (i < this.f13582a.f13508g.size()) {
                    ObservableAdaptersCollection.m19869a(this.f13582a, i, z);
                }
                TracerDetour.a(128505734);
                this.f13582a.f13517p = 2;
            } catch (Exception e) {
                this.f13582a.f13518q = e;
                throw Throwables.propagate(e);
            } catch (Throwable th) {
                TracerDetour.a(-2129895822);
            }
        }

        public final void mo1386a(int i, int i2, T t, boolean z) {
            TracerDetour.a("ObservableAdaptersCollection.onItemMoved", -1580457468);
            try {
                int c = this.f13582a.mo2523c(i);
                FeedUnitAdapter feedUnitAdapter = (FeedUnitAdapter) this.f13582a.f13508g.remove(i);
                Preconditions.checkState(ObservableAdaptersCollection.m19867a((Object) t).equals(feedUnitAdapter.m19048b()), "Moved item should not have changed.");
                ObservableAdaptersCollection.m19875g(this.f13582a);
                int a = feedUnitAdapter.m19044a();
                this.f13582a.f13515n.mo2212c(c, a);
                c = i2 == this.f13582a.f13508g.size() ? this.f13582a.mo2521b() : this.f13582a.mo2523c(i2);
                this.f13582a.f13508g.add(i2, feedUnitAdapter);
                ObservableAdaptersCollection.m19875g(this.f13582a);
                this.f13582a.f13515n.mo2210b(c, a);
                ObservableAdaptersCollection.m19869a(this.f13582a, i, z);
                ObservableAdaptersCollection.m19869a(this.f13582a, i2, z);
                TracerDetour.a(324338329);
                this.f13582a.f13517p = 3;
            } catch (Exception e) {
                this.f13582a.f13518q = e;
                throw Throwables.propagate(e);
            } catch (Throwable th) {
                TracerDetour.a(2058653707);
            }
        }
    }

    /* compiled from: min_duration */
    class C05492 implements RowIdentifier {
        final /* synthetic */ ObservableAdaptersCollection f13583a;

        C05492(ObservableAdaptersCollection observableAdaptersCollection) {
            this.f13583a = observableAdaptersCollection;
        }

        @Nullable
        public final RowKey mo2531a(int i) {
            ObservableAdaptersCollection.m19877h(this.f13583a);
            return (RowKey) this.f13583a.f13509h.get(i);
        }

        public final int mo2530a() {
            return this.f13583a.mo2521b();
        }
    }

    /* compiled from: min_duration */
    public class C05503 implements DirtyListener {
        public final /* synthetic */ ObservableAdaptersCollection f13584a;

        C05503(ObservableAdaptersCollection observableAdaptersCollection) {
            this.f13584a = observableAdaptersCollection;
        }

        public final void mo2532a(Object obj) {
            for (int a = this.f13584a.f13505d.mo1374a() - 1; a >= 0; a--) {
                Object a2 = this.f13584a.f13505d.mo1375a(a);
                if (a2 instanceof GraphQLFeedUnitEdge) {
                    a2 = ((GraphQLFeedUnitEdge) a2).mo2540c();
                }
                Object obj2 = a2;
                if (obj2 == obj) {
                    this.f13584a.f13512k.mo1387a(a, obj2, obj2, true);
                    return;
                }
            }
        }
    }

    public final void mo1888a(DumpsysContext dumpsysContext) {
        DumpsysDumper dumpsysDumper = dumpsysContext.f;
        PrintWriter printWriter = dumpsysContext.e;
        int size = this.f13508g.size();
        for (int i = 0; i < size; i++) {
            printWriter.println("story " + i + " of " + size);
            dumpsysDumper.a(this.f13508g.get(i), dumpsysContext);
        }
    }

    @Inject
    public ObservableAdaptersCollection(@Assisted FeedUnitAdapterFactory feedUnitAdapterFactory, @Assisted E e, @Assisted ObservableListItemCollection<T> observableListItemCollection, FbErrorReporter fbErrorReporter, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f13503b = fbErrorReporter;
        this.f13504c = androidComponentsExperimentHelper;
        this.f13505d = observableListItemCollection;
        this.f13507f = e;
        this.f13506e = feedUnitAdapterFactory;
        this.f13510i = ManagedIntArray.m19031a(observableListItemCollection.mo1374a());
        this.f13511j = ManagedIntArray.m19031a(observableListItemCollection.mo1374a());
    }

    public final int mo2522b(int i) {
        m19877h(this);
        m19868a(i, this.f13511j);
        return this.f13511j.m19034c(i);
    }

    public final int mo2523c(int i) {
        m19868a(i, this.f13510i);
        return this.f13510i.m19034c(i);
    }

    public final int mo2525d(int i) {
        return (mo2523c(i) + mo2527e(i)) - 1;
    }

    public final int mo2527e(int i) {
        return ((FeedUnitAdapter) this.f13508g.get(i)).m19044a();
    }

    public final RowIdentifier mo2526d() {
        return this.f13513l;
    }

    public final int mo2521b() {
        return this.f13508g.isEmpty() ? 0 : mo2525d(this.f13508g.size() - 1) + 1;
    }

    public final BoundedAdapter mo2519a(int i) {
        int b = mo2522b(i);
        int c = mo2523c(b);
        try {
            return ((FeedUnitAdapter) this.f13508g.get(b)).m19054g(i - c);
        } catch (IndexOutOfBoundsException e) {
            this.f13503b.m2340a("ObservableAdaptersCollection.getAt", "last operation " + this.f13517p + "rowIndex " + i + " feedEdgeIndex " + b + " firstRowIndex " + c + " size " + mo2521b() + "\nrowsToUnits " + Arrays.toString(this.f13511j.m19036d()) + "\nrowsToFirst " + Arrays.toString(this.f13510i.m19036d()) + " logged exception " + this.f13518q + " " + e.getMessage());
            return m19874g(i);
        }
    }

    public final void mo2520a() {
        m19873f(1);
    }

    public final void mo2524c() {
        m19873f(0);
        mo2528e();
    }

    private void m19873f(int i) {
        TracerDetour.a("ObservableAdaptersCollection.destroy", 892358530);
        try {
            m19877h(this);
            if (this.f13515n != null) {
                this.f13515n.mo2212c(0, this.f13511j.m19032a());
            }
            for (FeedUnitAdapter feedUnitAdapter : this.f13508g) {
                feedUnitAdapter.m19050c();
                if ((i & 1) != 0 && this.f13504c.m10063o()) {
                    feedUnitAdapter.m19051d();
                }
            }
            this.f13508g.clear();
            this.f13511j.m19035c();
            this.f13510i.m19035c();
            this.f13509h.clear();
            this.f13505d.mo1377b(this.f13512k);
            m19870a(null);
            this.f13517p = 5;
            TracerDetour.a(1377376825);
        } catch (Throwable e) {
            this.f13518q = e;
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            TracerDetour.a(-1555733663);
        }
    }

    public final void mo2528e() {
        TracerDetour.a("ObservableAdaptersCollection.regenerateInternalAdapters", 1242789669);
        try {
            m19870a(this.f13514m);
            this.f13505d.mo1376a(this.f13512k);
            for (int i = 0; i < this.f13505d.mo1374a(); i++) {
                this.f13508g.add(m19876h(this, i));
            }
            m19875g(this);
            m19877h(this);
            if (this.f13515n != null) {
                this.f13515n.mo2210b(0, this.f13511j.m19032a());
            }
            this.f13517p = 6;
            TracerDetour.a(1073051386);
        } catch (Throwable e) {
            this.f13518q = e;
            throw Throwables.propagate(e);
        } catch (Throwable th) {
            TracerDetour.a(-2042579795);
        }
    }

    public final int mo2529f() {
        return this.f13505d.mo1374a();
    }

    public final void m19880a(AdapterDataObserver adapterDataObserver) {
        m19873f(0);
        if (adapterDataObserver == null) {
            adapterDataObserver = f13502a;
        }
        this.f13515n = adapterDataObserver;
        mo2528e();
    }

    private BoundedAdapter m19874g(int i) {
        m19875g(this);
        m19877h(this);
        int b = mo2522b(i);
        return ((FeedUnitAdapter) this.f13508g.get(b)).m19054g(i - mo2523c(b));
    }

    private void m19870a(DirtyListener dirtyListener) {
        if (this.f13507f instanceof DirtyUnitObserver) {
            ((DirtyUnitObserver) this.f13507f).mo2435a(dirtyListener);
        }
    }

    public static void m19875g(ObservableAdaptersCollection observableAdaptersCollection) {
        observableAdaptersCollection.f13511j.m19035c();
        observableAdaptersCollection.f13510i.m19035c();
        observableAdaptersCollection.f13509h.clear();
        int size = observableAdaptersCollection.f13508g.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            observableAdaptersCollection.f13510i.m19033b(i);
            i += ((FeedUnitAdapter) observableAdaptersCollection.f13508g.get(i2)).m19044a();
        }
        observableAdaptersCollection.f13516o = true;
    }

    public static void m19877h(ObservableAdaptersCollection observableAdaptersCollection) {
        if (observableAdaptersCollection.f13516o) {
            TracerDetour.a("ObservableAdaptersCollection.updateRowPositions", 1654720877);
            try {
                int size = observableAdaptersCollection.f13508g.size();
                for (int i = 0; i < size; i++) {
                    int a = ((FeedUnitAdapter) observableAdaptersCollection.f13508g.get(i)).m19044a();
                    for (int i2 = 0; i2 < a; i2++) {
                        observableAdaptersCollection.f13509h.add(((FeedUnitAdapter) observableAdaptersCollection.f13508g.get(i)).m19045a(i2));
                        observableAdaptersCollection.f13511j.m19033b(i);
                    }
                }
                observableAdaptersCollection.f13516o = false;
            } finally {
                TracerDetour.a(1512977846);
            }
        }
    }

    public static void m19869a(ObservableAdaptersCollection observableAdaptersCollection, int i, boolean z) {
        if (!z || !BuildConstants.i) {
            return;
        }
        if (observableAdaptersCollection.f13505d.mo1374a() != observableAdaptersCollection.f13508g.size()) {
            throw new IllegalStateException("ListItemCollection has size " + observableAdaptersCollection.f13505d.mo1374a() + " but AdaptersCollection has size " + observableAdaptersCollection.f13508g.size());
        } else if (m19867a(observableAdaptersCollection.f13505d.mo1375a(i)) != ((FeedUnitAdapter) observableAdaptersCollection.f13508g.get(i)).f12957b) {
            throw new IllegalStateException("Item " + i + " in ListItemCollection does not match item in AdaptersCollection");
        }
    }

    private static void m19868a(int i, ManagedIntArray managedIntArray) {
        if (i < 0 || i >= managedIntArray.f12951b) {
            throw new IndexOutOfBoundsException("rowIndex " + i + " would be out of bounds of collection of size " + managedIntArray.f12951b);
        }
    }

    private static Object m19867a(Object obj) {
        return obj instanceof GraphQLFeedUnitEdge ? ((GraphQLFeedUnitEdge) obj).mo2540c() : obj;
    }

    public static FeedUnitAdapter m19876h(ObservableAdaptersCollection observableAdaptersCollection, int i) {
        return observableAdaptersCollection.f13506e.mo2518a(observableAdaptersCollection.f13505d.mo1375a(i), observableAdaptersCollection.f13507f);
    }

    public static void m19872b(ObservableAdaptersCollection observableAdaptersCollection, int i, boolean z) {
        if (z) {
            for (int i2 = 0; i2 < observableAdaptersCollection.f13505d.mo1374a(); i2++) {
                Object obj;
                Object a = m19867a(observableAdaptersCollection.f13505d.mo1375a(i2));
                if (i2 < observableAdaptersCollection.f13508g.size()) {
                    obj = ((FeedUnitAdapter) observableAdaptersCollection.f13508g.get(i2)).f12957b;
                } else {
                    obj = null;
                }
                if (a != obj) {
                    throw new RuntimeException("While trying to insert into " + i + " the following feedUnit at position " + i2 + " is in the ListItemCollection but not the AdaptersCollection: " + a + " Last operation was " + observableAdaptersCollection.f13517p + " Logged exception " + observableAdaptersCollection.f13518q);
                }
            }
        }
    }
}

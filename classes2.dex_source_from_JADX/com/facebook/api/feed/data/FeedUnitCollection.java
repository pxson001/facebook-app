package com.facebook.api.feed.data;

import com.facebook.api.feed.data.collections.ObservableListItemCollection;
import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.common.collect.ListObserver;
import com.facebook.common.collect.ListObserverAnnouncer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.data.FeedDataLoader.1;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.model.GapFeedEdge;
import com.facebook.feed.sponsored.SponsoredFeedUnitValidator;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: send_invite */
public class FeedUnitCollection implements ObservableListItemCollection<FeedEdge>, Iterable<FeedEdge> {
    private static final String f5625b = FeedUnitCollection.class.getSimpleName();
    public static final Comparator<FeedEdge> f5626c = FeedEdgeComparator.f5641a;
    public final LegacyFeedUnitUpdater f5627a = new C02641(this);
    public final PendingStoryCache f5628d;
    private final AbstractFbErrorReporter f5629e;
    private final boolean f5630f;
    public final FeedUnitCollectionData f5631g = new FeedUnitCollectionData();
    public final ListObserverAnnouncer<FeedEdge> f5632h = new ListObserverAnnouncer();
    public final StagedFeed f5633i;
    public final FeedOnTopCache f5634j;
    private final FeedUnitCollectionDataObserver f5635k = new FeedUnitCollectionDataObserver(this);
    private String f5636l = null;
    private String f5637m = null;
    public boolean f5638n = false;
    public boolean f5639o = false;
    @Nullable
    public 1 f5640p;

    /* compiled from: send_invite */
    class C02641 implements LegacyFeedUnitUpdater {
        final /* synthetic */ FeedUnitCollection f5656a;

        C02641(FeedUnitCollection feedUnitCollection) {
            this.f5656a = feedUnitCollection;
        }

        public final void mo1379a(FeedUnit feedUnit) {
            FeedUnitCollection.m9647a(this.f5656a, feedUnit);
        }

        public final void mo1380a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
            this.f5656a.m9685c(graphQLFeedUnitEdge);
        }

        public final void mo1378a() {
            this.f5656a.m9696m();
        }

        public final void mo1381a(String str) {
            this.f5656a.f5628d.m9718b(str);
        }

        public final GraphQLStory mo1382b(String str) {
            return this.f5656a.m9678b(str);
        }

        public final GraphQLStory mo1383c(String str) {
            return this.f5656a.f5628d.m9724f(str);
        }

        public final List<FeedEdge> mo1384d(String str) {
            return this.f5656a.m9669a(str);
        }

        public final GraphQLFeedUnitEdge mo1385e(String str) {
            return this.f5656a.m9683c(str);
        }
    }

    /* compiled from: send_invite */
    class FeedUnitCollectionDataObserver implements ListObserver<FeedEdge> {
        final /* synthetic */ FeedUnitCollection f5658a;

        public FeedUnitCollectionDataObserver(FeedUnitCollection feedUnitCollection) {
            this.f5658a = feedUnitCollection;
        }

        public final void mo1386a(int i, int i2, Object obj, boolean z) {
            obj = (GraphQLFeedUnitEdge) obj;
            int c = this.f5658a.f5628d.m9719c();
            this.f5658a.f5632h.mo1386a(i + c, c + i2, obj, z);
        }

        public final void mo1387a(int i, Object obj, Object obj2, boolean z) {
            this.f5658a.f5632h.mo1387a(this.f5658a.f5628d.m9719c() + i, (GraphQLFeedUnitEdge) obj, (GraphQLFeedUnitEdge) obj2, z);
        }

        public final void mo1388a(int i, Object obj, boolean z) {
            this.f5658a.f5632h.mo1388a(this.f5658a.f5628d.m9719c() + i, (GraphQLFeedUnitEdge) obj, z);
        }

        public final void mo1389b(int i, Object obj, boolean z) {
            this.f5658a.f5632h.mo1389b(this.f5658a.f5628d.m9719c() + i, (GraphQLFeedUnitEdge) obj, z);
        }
    }

    /* compiled from: send_invite */
    public class FeedEdgeSortInfo {
        public final String f17924a;

        public FeedEdgeSortInfo(String str) {
            this.f17924a = str;
        }

        public final String m25158a() {
            return this.f17924a;
        }
    }

    /* compiled from: send_invite */
    final class C07282 implements Comparator<FeedEdgeSortInfo> {
        C07282() {
        }

        public final int compare(Object obj, Object obj2) {
            FeedEdgeSortInfo feedEdgeSortInfo = (FeedEdgeSortInfo) obj2;
            String str = ((FeedEdgeSortInfo) obj).f17924a;
            String str2 = feedEdgeSortInfo.f17924a;
            if (str != null) {
                if (str2 != null) {
                    return str2.compareTo(str);
                }
                return 1;
            } else if (str2 == null) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static FeedUnitCollection m9651b(InjectorLike injectorLike) {
        return new FeedUnitCollection(PendingStoryCache.m9709b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), MainProcessModule.m4794d());
    }

    public static FeedUnitCollection m9645a(InjectorLike injectorLike) {
        return m9651b(injectorLike);
    }

    public final /* synthetic */ Object mo1375a(int i) {
        return m9677b(i);
    }

    public final LegacyFeedUnitUpdater m9676b() {
        return this.f5627a;
    }

    public final StagedFeed m9682c() {
        return this.f5633i;
    }

    @Inject
    public FeedUnitCollection(PendingStoryCache pendingStoryCache, AbstractFbErrorReporter abstractFbErrorReporter, Boolean bool) {
        this.f5628d = pendingStoryCache;
        this.f5629e = abstractFbErrorReporter;
        this.f5630f = bool.booleanValue();
        this.f5633i = new StagedFeed();
        this.f5634j = new FeedOnTopCache();
        this.f5628d.f5645b.f5655f = this.f5632h;
        this.f5631g.f5659a.f5655f = this.f5635k;
    }

    public final boolean m9686d() {
        return this.f5633i.f5669f;
    }

    public final void m9672a(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo, FetchPortion fetchPortion) {
        m9673a(list, graphQLPageInfo, fetchPortion, false, false);
    }

    public final void m9673a(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo, FetchPortion fetchPortion, boolean z, boolean z2) {
        TracerDetour.a("FeedUnitCollection.addElementsAtHead", -1966942866);
        try {
            int t = m9701t();
            if (z2 && t > 0 && !this.f5634j.m9786d()) {
                this.f5634j.m9785a(list);
            }
            if (!z || t <= 0) {
                m9653b(list, graphQLPageInfo, fetchPortion);
            } else {
                this.f5633i.m9780a(list, graphQLPageInfo, fetchPortion);
            }
            m9640D();
        } finally {
            TracerDetour.a(-1851921683);
        }
    }

    public final void m9689e() {
        this.f5628d.m9714a(GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        this.f5628d.m9714a(GraphQLFeedOptimisticPublishState.SUCCESS);
    }

    public final boolean m9690f() {
        return this.f5634j.m9786d();
    }

    public final void m9692h() {
        if (!this.f5634j.m9786d()) {
            String str;
            ImmutableList copyOf = ImmutableList.copyOf(this.f5634j.f5672c);
            FeedOnTopCache feedOnTopCache = this.f5634j;
            String str2 = null;
            if (feedOnTopCache.f5672c == null || feedOnTopCache.f5672c.isEmpty()) {
                str = null;
            } else {
                str = ((GraphQLFeedUnitEdge) feedOnTopCache.f5672c.get(0)).W_();
                str2 = ((GraphQLFeedUnitEdge) feedOnTopCache.f5672c.get(feedOnTopCache.f5672c.size() - 1)).W_();
            }
            m9653b(copyOf, GraphQLHelper.m22460a(str, str2, false, true), this.f5634j.f5671b);
            this.f5634j.m9784a();
        }
    }

    public final void m9693i() {
        if (m9686d()) {
            ImmutableList<GraphQLFeedUnitEdge> copyOf = ImmutableList.copyOf(this.f5633i.f5664a);
            FetchPortion fetchPortion = this.f5633i.f5665b;
            StagedFeed stagedFeed = this.f5633i;
            m9653b(copyOf, GraphQLHelper.m22460a(stagedFeed.m9783g(), stagedFeed.f5666c, stagedFeed.f5667d, stagedFeed.f5668e), fetchPortion);
            this.f5633i.m9781b();
            if (copyOf != null && this.f5640p != null) {
                1 1 = this.f5640p;
                if (!(copyOf == null || copyOf.isEmpty())) {
                    List arrayList = new ArrayList();
                    for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : copyOf) {
                        if (graphQLFeedUnitEdge instanceof GraphQLFeedUnitEdge) {
                            arrayList.add(graphQLFeedUnitEdge);
                        }
                    }
                    ((SponsoredFeedUnitValidator) 1.a.N.get()).m26732a(1.a.f5161b, arrayList, true, fetchPortion);
                }
            }
        }
    }

    private void m9653b(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo, FetchPortion fetchPortion) {
        if (fetchPortion == FetchPortion.CHUNKED_REMAINDER && list.isEmpty()) {
            m9644K();
            return;
        }
        if (graphQLPageInfo != null) {
            this.f5638n = graphQLPageInfo.mo1408c();
            this.f5639o = graphQLPageInfo.mo1407b();
        }
        if (IsValidUtil.m22952a(graphQLPageInfo) || !(list == null || list.isEmpty())) {
            int t = m9701t();
            m9650a((List) list, graphQLPageInfo.mo1407b(), fetchPortion);
            m9654c((List) list);
            if (fetchPortion != FetchPortion.CHUNKED_REMAINDER) {
                this.f5638n = graphQLPageInfo.mo1408c();
                if (t == 0) {
                    this.f5639o = graphQLPageInfo.mo1407b();
                }
            } else if (t == 0) {
                this.f5638n = graphQLPageInfo.mo1408c();
                this.f5639o = graphQLPageInfo.mo1407b();
            }
            if (m9643H()) {
                m9661w();
                this.f5636l = m9641E();
                return;
            }
            this.f5636l = m9663y();
        }
    }

    private void m9654c(List<? extends FeedEdge> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
            m9656e(graphQLFeedUnitEdge);
            if (graphQLFeedUnitEdge instanceof GapFeedEdge) {
                int a = m9666a(graphQLFeedUnitEdge);
                int i = a - 1;
                a++;
                if (i >= 0 && i < m9701t() && (m9677b(i) instanceof GapFeedEdge)) {
                    m9685c(graphQLFeedUnitEdge);
                } else if (a < m9701t()) {
                    GraphQLFeedUnitEdge b = m9677b(a);
                    if (b instanceof GapFeedEdge) {
                        m9685c(b);
                    }
                }
            }
        }
        m9661w();
    }

    private void m9656e(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        GraphQLFeedUnitEdge b = this.f5631g.m9773b(DedupableUtil.m23084a(graphQLFeedUnitEdge));
        if (b == null || f5626c.compare(graphQLFeedUnitEdge, b) < 0) {
            if (b != null) {
                this.f5631g.m9768a(b);
            }
            m9648a(graphQLFeedUnitEdge.mo2540c(), DedupableUtil.m23084a(graphQLFeedUnitEdge));
            this.f5631g.m9774c(graphQLFeedUnitEdge);
        }
    }

    private void m9661w() {
        TracerDetour.a("FeedUnitCollection.setFeedUnitRerankingData", 1545867692);
        try {
            Iterator it = this.f5631g.iterator();
            int i = 0;
            while (it.hasNext()) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
                if (graphQLFeedUnitEdge.mo2540c() != null) {
                    PropertyHelper.m21266a(graphQLFeedUnitEdge.mo2540c(), i);
                    int b = StringUtil.m3593b(graphQLFeedUnitEdge.V_(), graphQLFeedUnitEdge.m19084d());
                    if (b == 0) {
                        PropertyHelper.m21268a(graphQLFeedUnitEdge.mo2540c(), "0");
                    } else if (b > 0) {
                        PropertyHelper.m21268a(graphQLFeedUnitEdge.mo2540c(), "1");
                    } else {
                        PropertyHelper.m21268a(graphQLFeedUnitEdge.mo2540c(), "-1");
                    }
                    PropertyHelper.m21291b(graphQLFeedUnitEdge.mo2540c(), graphQLFeedUnitEdge.m19087j());
                }
                i++;
            }
        } finally {
            TracerDetour.a(-1991776722);
        }
    }

    public final void m9671a(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo) {
        TracerDetour.a("FeedUnitCollection.addElementsAtTail", 954343722);
        try {
            m9652b(list, graphQLPageInfo);
            m9640D();
        } finally {
            TracerDetour.a(563458141);
        }
    }

    private void m9652b(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo) {
        if (IsValidUtil.m22952a(graphQLPageInfo) || !(list == null || list.isEmpty())) {
            this.f5639o = graphQLPageInfo.mo1407b();
            m9654c((List) list);
            this.f5637m = graphQLPageInfo.mo1405a();
            if (m9643H()) {
                m9661w();
            }
        }
    }

    @Nullable
    public final String m9694j() {
        String g;
        if (m9686d()) {
            g = this.f5633i.m9783g();
        } else if (this.f5634j.m9786d()) {
            g = m9662x();
        } else {
            FeedOnTopCache feedOnTopCache = this.f5634j;
            String str = null;
            if (!(feedOnTopCache.f5672c == null || feedOnTopCache.f5672c.isEmpty())) {
                str = ((GraphQLFeedUnitEdge) feedOnTopCache.f5672c.get(0)).W_();
            }
            g = str;
        }
        return m9655d(g) ? g : m9641E();
    }

    private String m9662x() {
        if (this.f5636l != null) {
            return this.f5636l;
        }
        return m9663y();
    }

    private String m9663y() {
        if (m9701t() == 0) {
            return null;
        }
        return this.f5631g.m9776d(0).W_();
    }

    public static boolean m9655d(@Nullable String str) {
        return (StringUtil.m3589a((CharSequence) str) || str.equals("synthetic_cursor")) ? false : true;
    }

    public final int m9667a(List<? extends FeedEdge> list) {
        List a = Lists.m1296a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
            if (graphQLFeedUnitEdge.mo2540c() != null) {
                FeedUnit c = graphQLFeedUnitEdge.mo2540c();
                if ((c instanceof GraphQLStory) || !(c instanceof Sponsorable)) {
                    a.add(graphQLFeedUnitEdge);
                }
            }
        }
        List<GraphQLFeedUnitEdge> list2 = a;
        int i = 0;
        for (GraphQLFeedUnitEdge graphQLFeedUnitEdge2 : list2) {
            int i2;
            if (m9687d(graphQLFeedUnitEdge2)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i - this.f5628d.m9711a((List) list2);
    }

    public final GraphQLFeedUnitEdge m9677b(int i) {
        if (this.f5628d.m9719c() > i) {
            return (GraphQLFeedUnitEdge) this.f5628d.m9713a().get(i);
        }
        return this.f5631g.m9776d(i - this.f5628d.m9719c());
    }

    public final int mo1374a() {
        return m9701t() + this.f5628d.m9719c();
    }

    public final int m9695k() {
        return mo1374a() + this.f5633i.m9782f();
    }

    public final boolean m9675a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i, boolean z) {
        int a = m9666a(graphQLFeedUnitEdge);
        if ((a >= 0 && a < this.f5628d.m9719c()) || i < this.f5628d.m9719c() || a > mo1374a() || i > mo1374a() || a == i) {
            return false;
        }
        if (!z) {
            int u = m9702u();
            if (a < u && i > u) {
                return false;
            }
            if (i < u && a > u) {
                return false;
            }
        }
        String d = m9677b(i).m19084d();
        String V_ = m9677b(i).V_();
        Builder builder = new Builder();
        builder.f15732i = graphQLFeedUnitEdge.mo2540c();
        builder = builder;
        builder.f15729f = graphQLFeedUnitEdge.m19080b();
        builder = builder;
        builder.f15734k = d;
        builder = builder;
        builder.f15728e = "synthetic_cursor";
        builder = builder;
        builder.f15733j = graphQLFeedUnitEdge.X_();
        builder = builder;
        builder.f15731h = graphQLFeedUnitEdge.m19088k();
        builder = builder;
        builder.f15730g = graphQLFeedUnitEdge.m19089l();
        GraphQLFeedUnitEdge a2 = builder.m22415a();
        PropertyHelper.m21292b(a2, "synthetic_cursor");
        PropertyHelper.m21272a(a2, V_);
        GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = a2;
        GraphQLFeedUnitEdge b = this.f5631g.m9773b(DedupableUtil.m23084a(graphQLFeedUnitEdge));
        if (!(b == null || b.mo2540c() == graphQLFeedUnitEdge.mo2540c())) {
            this.f5631g.m9768a(b);
        }
        m9680b(graphQLFeedUnitEdge2);
        return true;
    }

    private static void m9657f(List<FeedEdgeSortInfo> list) {
        Collections.sort(list, new C07282());
    }

    public final void m9681b(List<? extends FeedEdge> list) {
        int i = 0;
        TracerDetour.a("FeedUnitCollection.addAtEnd", 834195874);
        try {
            if (m9658g(list)) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge;
                int i2;
                List<GraphQLFeedUnitEdge> z = m9664z();
                List B = m9638B();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
                    if (!this.f5631g.m9770a(DedupableUtil.m23084a(graphQLFeedUnitEdge))) {
                        B.add(new FeedEdgeSortInfo(graphQLFeedUnitEdge.V_()));
                    }
                }
                m9657f(B);
                for (i2 = 0; i2 < this.f5631g.m9771b(); i2++) {
                    m9649a(this.f5631g.m9776d(i2), ((FeedEdgeSortInfo) B.get(i)).m25158a());
                    i++;
                }
                int t = m9701t();
                Iterator it2 = list.iterator();
                i2 = t;
                int i3 = i;
                while (it2.hasNext()) {
                    graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it2.next();
                    if (!this.f5631g.m9770a(DedupableUtil.m23084a(graphQLFeedUnitEdge))) {
                        m9649a(graphQLFeedUnitEdge, ((FeedEdgeSortInfo) B.get(i3)).m25158a());
                        i3++;
                        PropertyHelper.m21266a(graphQLFeedUnitEdge.mo2540c(), i2);
                        PropertyHelper.m21268a(graphQLFeedUnitEdge.mo2540c(), "0");
                        i = i2 + 1;
                        m9680b(graphQLFeedUnitEdge);
                        i2 = i;
                    }
                }
                for (GraphQLFeedUnitEdge graphQLFeedUnitEdge2 : z) {
                    m9680b(graphQLFeedUnitEdge2);
                }
                m9642G();
                m9640D();
                TracerDetour.a(-272067596);
            }
        } finally {
            TracerDetour.a(1302708423);
        }
    }

    private boolean m9658g(List<? extends FeedEdge> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!this.f5631g.m9770a(DedupableUtil.m23084a((GraphQLFeedUnitEdge) it.next()))) {
                return true;
            }
        }
        return false;
    }

    private List<FeedEdge> m9664z() {
        List<FeedEdge> arrayList = new ArrayList();
        for (int i = 0; i < this.f5631g.m9771b(); i++) {
            GraphQLFeedUnitEdge d = this.f5631g.m9776d(i);
            if (d instanceof GapFeedEdge) {
                arrayList.add(d);
            }
        }
        List<FeedEdge> list = arrayList;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            m9685c((GraphQLFeedUnitEdge) it.next());
        }
        return list;
    }

    private List<FeedEdgeSortInfo> m9638B() {
        List<FeedEdgeSortInfo> arrayList = new ArrayList();
        for (int i = 0; i < this.f5631g.m9771b(); i++) {
            arrayList.add(new FeedEdgeSortInfo(this.f5631g.m9776d(i).V_()));
        }
        return arrayList;
    }

    private static void m9649a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, String str) {
        if (graphQLFeedUnitEdge instanceof GraphQLFeedUnitEdge) {
            PropertyHelper.m21272a(graphQLFeedUnitEdge, str);
        } else if (graphQLFeedUnitEdge instanceof ClientFeedUnitEdge) {
            PropertyHelper.m21272a((ClientFeedUnitEdge) graphQLFeedUnitEdge, str);
        }
    }

    public static void m9647a(FeedUnitCollection feedUnitCollection, FeedUnit feedUnit) {
        if (feedUnit != null) {
            if (feedUnit.mo2507g() == null && (feedUnit instanceof GraphQLStory)) {
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (graphQLStory.m22350c() != null && graphQLStory.mo2890l() != null) {
                    feedUnitCollection.f5628d.m9717a(graphQLStory);
                    return;
                } else if (feedUnitCollection.f5628d.m9722d(graphQLStory.m22334T())) {
                    feedUnitCollection.f5628d.m9716a(graphQLStory.m22334T(), graphQLStory);
                    return;
                } else {
                    return;
                }
            }
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : feedUnitCollection.m9669a(feedUnit.mo2507g())) {
                Builder builder = new Builder();
                builder.f15732i = feedUnit;
                builder = builder;
                builder.f15729f = graphQLFeedUnitEdge.m19080b();
                builder = builder;
                builder.f15734k = graphQLFeedUnitEdge.m19084d();
                builder = builder;
                builder.f15728e = graphQLFeedUnitEdge.m19086g();
                builder = builder;
                builder.f15733j = graphQLFeedUnitEdge.X_();
                builder = builder;
                builder.f15731h = graphQLFeedUnitEdge.m19088k();
                builder = builder;
                builder.f15730g = graphQLFeedUnitEdge.m19089l();
                GraphQLFeedUnitEdge a = builder.m22415a();
                PropertyHelper.m21292b(a, graphQLFeedUnitEdge.W_());
                PropertyHelper.m21272a(a, graphQLFeedUnitEdge.V_());
                if (graphQLFeedUnitEdge.mo2540c() != null) {
                    PropertyHelper.m21266a(feedUnit, PropertyHelper.m21303f(graphQLFeedUnitEdge.mo2540c()));
                    PropertyHelper.m21268a(feedUnit, PropertyHelper.m21264a(graphQLFeedUnitEdge.mo2540c()));
                    PropertyHelper.m21291b(feedUnit, PropertyHelper.m21289b(graphQLFeedUnitEdge.mo2540c()));
                }
                feedUnitCollection.m9680b(a);
            }
        }
    }

    public final List<FeedEdge> m9669a(String str) {
        if (str == null) {
            return RegularImmutableList.f535a;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < m9701t(); i++) {
            GraphQLFeedUnitEdge d = this.f5631g.m9776d(i);
            FeedUnitCommon c = d.mo2540c();
            if (!(c == null || c.mo2507g() == null || !c.mo2507g().equals(str))) {
                builder.m1069c(d);
            }
        }
        return builder.m1068b();
    }

    public final GraphQLStory m9678b(String str) {
        return this.f5628d.m9723e(str);
    }

    public final int m9666a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        int indexOf = this.f5628d.m9713a().indexOf(graphQLFeedUnitEdge);
        if (indexOf >= 0) {
            return indexOf;
        }
        int i;
        GraphQLFeedUnitEdge b = this.f5631g.m9773b(DedupableUtil.m23084a(graphQLFeedUnitEdge));
        if (b == null) {
            i = -1;
        } else {
            i = this.f5631g.f5659a.m9733a(b);
        }
        indexOf = i;
        if (indexOf >= 0) {
            return indexOf + this.f5628d.m9719c();
        }
        return indexOf;
    }

    public final void m9696m() {
        this.f5631g.m9767a();
        this.f5638n = false;
        this.f5639o = false;
        m9642G();
        this.f5628d.m9721d();
        this.f5633i.m9781b();
        m9640D();
    }

    public final void m9684c(int i) {
        if (m9701t() > i) {
            m9660i(i);
            m9639C();
            m9640D();
        }
    }

    public final boolean m9674a(int i, int i2, int i3) {
        if (m9701t() < i) {
            return false;
        }
        if (!(this.f5631g.m9776d(i3) instanceof GapFeedEdge)) {
            GraphQLFeedUnitEdge i4 = m9659i(this.f5631g.m9776d(i3 - 1));
            if (i4 != null) {
                m9656e(GapFactory.a(i4, "Head_Fetch_Gap"));
            }
        }
        m9646a(i3 + 1, m9701t() - i2);
        return true;
    }

    public final void mo1376a(ListObserver<FeedEdge> listObserver) {
        this.f5632h.m9754a(listObserver);
    }

    public final void mo1377b(ListObserver<FeedEdge> listObserver) {
        this.f5632h.m9756b(listObserver);
    }

    public final boolean m9697n() {
        return this.f5640p != null;
    }

    private void m9639C() {
        if (m9700s() && m9691f(m9701t() - 1)) {
            m9644K();
        }
    }

    public final void m9680b(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        m9648a(graphQLFeedUnitEdge.mo2540c(), DedupableUtil.m23084a(graphQLFeedUnitEdge));
        this.f5631g.m9774c(graphQLFeedUnitEdge);
        m9640D();
    }

    private static void m9648a(FeedUnit feedUnit, String str) {
        if (feedUnit != null && (feedUnit instanceof HasProperty)) {
            PropertyHelper.m21296c(feedUnit, str);
        }
    }

    public final void m9685c(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        this.f5631g.m9768a(graphQLFeedUnitEdge);
        m9642G();
        m9640D();
    }

    public final int m9698q() {
        return m9700s() ? m9688e(this.f5631g.m9772b(-1)) : 0;
    }

    public final int m9688e(int i) {
        if (!m9700s()) {
            return 0;
        }
        int t = m9701t();
        m9660i(i);
        t -= m9701t();
        Integer.valueOf(t);
        m9640D();
        return t;
    }

    private void m9640D() {
        if (this.f5630f) {
            final int a = mo1374a();
            final boolean s = m9700s();
            final GraphQLPageInfo a2 = GraphQLHelper.m22460a(m9694j(), m9699r(), this.f5638n, this.f5639o);
            this.f5629e.mo338a(f5625b, new FbCustomReportDataSupplier(this) {
                final /* synthetic */ FeedUnitCollection f18992d;

                public final String mo633a(Throwable th) {
                    return GraphQLHelper.m22474a(a2) + " Gap=" + s + " Size=" + a;
                }

                public final String mo632a() {
                    return null;
                }
            });
        }
    }

    @Nullable
    public final String m9699r() {
        String str = null;
        if (this.f5637m != null) {
            str = this.f5637m;
        } else if (m9701t() > 0) {
            str = this.f5631g.m9776d(m9701t() - 1).W_();
        }
        if (m9655d(str)) {
            return str;
        }
        String W_;
        for (int b = this.f5631g.m9771b() - 1; b >= 0; b--) {
            W_ = this.f5631g.m9776d(b).W_();
            if (m9655d(W_)) {
                break;
            }
        }
        W_ = null;
        return W_;
    }

    @Nullable
    public final GraphQLFeedUnitEdge m9683c(String str) {
        Iterator it = this.f5631g.iterator();
        while (it.hasNext()) {
            String str2;
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) it.next();
            if (graphQLFeedUnitEdge == null || !(graphQLFeedUnitEdge.mo2540c() instanceof GraphQLStory)) {
                str2 = null;
            } else {
                str2 = ((GraphQLStory) graphQLFeedUnitEdge.mo2540c()).m22350c();
            }
            if (str.equals(str2)) {
                return graphQLFeedUnitEdge;
            }
        }
        return null;
    }

    @Nullable
    private String m9641E() {
        int b = this.f5631g.m9771b();
        for (int i = 0; i < b; i++) {
            String W_ = this.f5631g.m9776d(i).W_();
            if (m9655d(W_)) {
                return W_;
            }
        }
        return null;
    }

    private void m9660i(int i) {
        int t = m9701t();
        while (t > i) {
            m9685c(this.f5631g.m9776d(t - 1));
            t--;
        }
        if (t == 0) {
            m9696m();
        }
        m9642G();
    }

    private void m9646a(int i, int i2) {
        while (i2 > i) {
            m9685c(this.f5631g.m9776d(i2 - 1));
            i2--;
        }
    }

    private void m9642G() {
        this.f5636l = null;
        this.f5637m = null;
    }

    public final boolean m9687d(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return !this.f5631g.m9770a(DedupableUtil.m23084a(graphQLFeedUnitEdge));
    }

    public final boolean m9700s() {
        return this.f5631g.m9777d();
    }

    public final int m9701t() {
        return this.f5631g.m9771b();
    }

    public final int m9702u() {
        return this.f5631g.m9779f();
    }

    public final boolean m9691f(int i) {
        return this.f5631g.m9775c(i);
    }

    public final boolean m9703v() {
        return mo1374a() == 0;
    }

    @VisibleForTesting
    private boolean m9643H() {
        if (!m9700s() || !m9691f(0)) {
            return false;
        }
        m9644K();
        return true;
    }

    private void m9650a(List<? extends FeedEdge> list, boolean z, FetchPortion fetchPortion) {
        if (fetchPortion == FetchPortion.CHUNKED_REMAINDER) {
            m9644K();
        }
        m9698q();
        if (z) {
            Object obj;
            if (m9701t() > 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && !list.isEmpty()) {
                boolean z2;
                int i = 1;
                if (list.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Preconditions.checkState(z2);
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) list.get(0);
                while (i < list.size()) {
                    GraphQLFeedUnitEdge graphQLFeedUnitEdge2 = (GraphQLFeedUnitEdge) list.get(i);
                    if (f5626c.compare(graphQLFeedUnitEdge, graphQLFeedUnitEdge2) >= 0) {
                        graphQLFeedUnitEdge2 = graphQLFeedUnitEdge;
                    }
                    i++;
                    graphQLFeedUnitEdge = graphQLFeedUnitEdge2;
                }
                GraphQLFeedUnitEdge i2 = m9659i(graphQLFeedUnitEdge);
                if (i2 != null) {
                    m9656e(GapFactory.a(i2, "Head_Fetch_Gap"));
                }
            }
        }
    }

    @Nullable
    private GraphQLFeedUnitEdge m9659i(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        for (int i = 0; i < m9701t(); i++) {
            GraphQLFeedUnitEdge d = this.f5631g.m9776d(i);
            if (f5626c.compare(graphQLFeedUnitEdge, d) < 0) {
                return d;
            }
        }
        return null;
    }

    private void m9644K() {
        this.f5631g.m9778e();
    }

    public Iterator<FeedEdge> iterator() {
        return this.f5631g.iterator();
    }
}

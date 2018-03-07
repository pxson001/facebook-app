package com.facebook.feed.sponsored;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.HideFeedStoryMethod.Params;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FeedUnitData;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.sponsored.SponsoredFeedUnitCache.FeedEdgeCacheEntry;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.HasSponsoredImpression;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.InstagramPhotosFromFriendsPhoto;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: is_messenger_user */
public class SponsoredFeedUnitValidator {
    private static final String f18993a = SponsoredFeedUnitValidator.class.getSimpleName();
    private static volatile SponsoredFeedUnitValidator f18994k;
    private final AnalyticsLogger f18995b;
    private final AbstractFbErrorReporter f18996c;
    private final NewsFeedAnalyticsEventBuilder f18997d;
    public final FbSharedPreferences f18998e;
    private final DefaultBlueServiceOperationFactory f18999f;
    public final FeedUnitDataController f19000g;
    private final SponsoredFeedUnitCache f19001h;
    public final GatekeeperStoreImpl f19002i;
    private int f19003j = 0;

    public static com.facebook.feed.sponsored.SponsoredFeedUnitValidator m26693a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f18994k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.sponsored.SponsoredFeedUnitValidator.class;
        monitor-enter(r1);
        r0 = f18994k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m26710b(r0);	 Catch:{ all -> 0x0035 }
        f18994k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18994k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.sponsored.SponsoredFeedUnitValidator.a(com.facebook.inject.InjectorLike):com.facebook.feed.sponsored.SponsoredFeedUnitValidator");
    }

    private static SponsoredFeedUnitValidator m26710b(InjectorLike injectorLike) {
        return new SponsoredFeedUnitValidator(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), FeedUnitDataController.m14175a(injectorLike), SponsoredFeedUnitCache.m26733a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public SponsoredFeedUnitValidator(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FbSharedPreferences fbSharedPreferences, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FeedUnitDataController feedUnitDataController, SponsoredFeedUnitCache sponsoredFeedUnitCache, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f18995b = analyticsLogger;
        this.f18996c = abstractFbErrorReporter;
        this.f18997d = newsFeedAnalyticsEventBuilder;
        this.f18998e = fbSharedPreferences;
        this.f18999f = defaultBlueServiceOperationFactory;
        this.f19000g = feedUnitDataController;
        this.f19001h = sponsoredFeedUnitCache;
        this.f19002i = gatekeeperStoreImpl;
    }

    public final void m26731a() {
        Iterator b = this.f19001h.m26741b();
        while (b.hasNext()) {
            FeedEdgeCacheEntry feedEdgeCacheEntry = (FeedEdgeCacheEntry) b.next();
            m26700a(FeedProps.m19802c(feedEdgeCacheEntry.d()), "delayed_move_failure", -1, false);
            m26702a(feedEdgeCacheEntry.b, feedEdgeCacheEntry.c, -1, true, "session_ended");
        }
        this.f19001h.m26743c();
    }

    public final void m26732a(FeedUnitCollection feedUnitCollection, List<GraphQLFeedUnitEdge> list, boolean z, FetchPortion fetchPortion) {
        String str = null;
        Object obj = null;
        if (feedUnitCollection != null) {
            try {
                if (m26724e()) {
                    m26696a(feedUnitCollection);
                }
                if (m26722d()) {
                    this.f19001h.m26738a((List) list);
                }
                if (this.f19002i.m2189a(532, false) && !list.isEmpty()) {
                    m26714b(feedUnitCollection);
                }
                if (m26725f() && !list.isEmpty()) {
                    m26719c(feedUnitCollection);
                }
                if (fetchPortion == FetchPortion.CHUNKED_REMAINDER || (fetchPortion == FetchPortion.FULL && !list.isEmpty())) {
                    obj = 1;
                }
                if (this.f19002i.m2189a(536, false) && r1 != null) {
                    String str2;
                    boolean f;
                    int a = this.f19001h.m26737a();
                    boolean a2 = this.f19002i.m2189a(549, false);
                    if (a2) {
                        if (z) {
                            str = m26711b(feedUnitCollection, (List) list);
                        }
                        str2 = str;
                    } else {
                        str2 = null;
                    }
                    Set a3 = m26694a((List) list);
                    Set b = m26712b();
                    if (this.f19002i.m2189a(537, false)) {
                        f = m26726f(feedUnitCollection);
                    } else {
                        f = m26716b(feedUnitCollection, a3);
                    }
                    b.removeAll(m26712b());
                    b.removeAll(a3);
                    m26699a(feedUnitCollection, a3, b);
                    m26698a(feedUnitCollection, b);
                    if (z && a2) {
                        m26703a(str2, m26711b(feedUnitCollection, (List) list), f, a, this.f19001h.m26737a());
                    }
                }
                if (z) {
                    m26713b((List) list);
                }
            } catch (Throwable e) {
                this.f18996c.m2351b(f18993a, "Exception during ad invalidation checks", e);
            }
        }
    }

    private static Set<String> m26694a(List<GraphQLFeedUnitEdge> list) {
        Set<String> hashSet = new HashSet();
        for (GraphQLFeedUnitEdge a : list) {
            hashSet.add(DedupableUtil.m23084a(a));
        }
        return hashSet;
    }

    private Set<String> m26712b() {
        Set<String> hashSet = new HashSet();
        Iterator b = this.f19001h.m26741b();
        while (b.hasNext()) {
            hashSet.add(DedupableUtil.m23084a(((FeedEdgeCacheEntry) b.next()).b));
        }
        return hashSet;
    }

    private void m26713b(List<GraphQLFeedUnitEdge> list) {
        TracerDetour.a("SponsoredFeedUnitValidator.logValidatedNewSponsoredFeedUnits", -1093012076);
        try {
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : list) {
                FeedUnit c = graphQLFeedUnitEdge.mo2540c();
                if (m26706a(c) && !this.f19001h.m26739a(graphQLFeedUnitEdge)) {
                    this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14105a(TrackableFeedProps.m27452b(FeedProps.m19802c(c))));
                }
            }
        } finally {
            TracerDetour.a(-1541591341);
        }
    }

    private void m26698a(FeedUnitCollection feedUnitCollection, Set<String> set) {
        if (!set.isEmpty()) {
            for (int i = 0; i < feedUnitCollection.mo1374a(); i++) {
                GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
                FeedUnit c = b.mo2540c();
                String a = DedupableUtil.m23084a(b);
                if (c != null && m26706a(c) && set.contains(a)) {
                    this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14105a(TrackableFeedProps.m27452b(FeedProps.m19802c(c))));
                }
            }
        }
    }

    private void m26703a(String str, String str2, boolean z, int i, int i2) {
        this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14109a(str, str2, z, i, i2, this.f19003j));
        this.f19003j++;
    }

    private void m26701a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i, int i2, boolean z) {
        this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14106a(TrackableFeedProps.m27452b(FeedProps.m19802c(graphQLFeedUnitEdge.mo2540c())), i, i2, true, z, null));
    }

    private void m26702a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i, int i2, boolean z, String str) {
        this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14106a(TrackableFeedProps.m27452b(FeedProps.m19802c(graphQLFeedUnitEdge.mo2540c())), i, i2, false, z, str));
    }

    private static boolean m26706a(FeedUnit feedUnit) {
        return SponsoredUtils.m21145a(feedUnit) && ((Sponsorable) feedUnit).mo2879o() != StoryVisibility.GONE;
    }

    private void m26696a(FeedUnitCollection feedUnitCollection) {
        TracerDetour.a("SponsoredFeedUnitValidator.processDelayedInvalidations", -713049368);
        int i = 0;
        while (i < feedUnitCollection.mo1374a()) {
            try {
                FeedUnit c = feedUnitCollection.m9677b(i).mo2540c();
                if (c instanceof Sponsorable) {
                    FeedUnitData a = this.f19000g.m14177a(c);
                    if (!(a == null || !a.m27203j() || a.m27202g())) {
                        m26700a(FeedProps.m19802c((Sponsorable) c), "delayed_invalidation", -1, true);
                    }
                }
                i++;
            } finally {
                TracerDetour.a(-1479717004);
            }
        }
    }

    private boolean m26718c() {
        return this.f19002i.m2189a(543, false);
    }

    private boolean m26722d() {
        return this.f19002i.m2189a(534, false);
    }

    private boolean m26724e() {
        return this.f19002i.m2189a(533, false);
    }

    private boolean m26725f() {
        return this.f19002i.m2189a(548, false);
    }

    private boolean m26727g() {
        return this.f19002i.m2189a(542, true);
    }

    private boolean m26728h() {
        return this.f19002i.m2189a(547, false);
    }

    private boolean m26729i() {
        return this.f19002i.m2189a(540, false);
    }

    private boolean m26730k() {
        return this.f19002i.m2189a(550, false);
    }

    private boolean m26714b(FeedUnitCollection feedUnitCollection) {
        TracerDetour.a("SponsoredFeedUnitValidator.invalidateFirstPositionSponsorable", -1951135753);
        int i = 0;
        boolean z = false;
        while (i < feedUnitCollection.mo1374a()) {
            try {
                boolean z2;
                FeedUnit c = feedUnitCollection.m9677b(i).mo2540c();
                if (!(c == null || m26720c(c))) {
                    if (!SponsoredUtils.m21145a(c)) {
                        if (m26717b(c)) {
                            break;
                        }
                    } else if (m26718c() && m26715b(feedUnitCollection, i, 1)) {
                        break;
                    } else {
                        m26700a(FeedProps.m19802c((Sponsorable) c), "ad_first_position", 0, false);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            } catch (Throwable th) {
                TracerDetour.a(1608019100);
            }
        }
        TracerDetour.a(1108712451);
        return z;
    }

    private boolean m26719c(FeedUnitCollection feedUnitCollection) {
        int i = 0;
        while (i < feedUnitCollection.mo1374a()) {
            GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
            FeedUnit c = b.mo2540c();
            if (c == null || !m26717b(c)) {
                i++;
            } else if (!b.m19089l()) {
                return false;
            } else {
                boolean z;
                GraphQLFeedUnitEdge b2 = feedUnitCollection.m9677b(i);
                int i2 = i + 1;
                while (i2 < feedUnitCollection.mo1374a()) {
                    GraphQLFeedUnitEdge b3 = feedUnitCollection.m9677b(i2);
                    FeedUnit c2 = b3.mo2540c();
                    if (c2 == null || !m26717b(c2)) {
                        i2++;
                    } else {
                        if (b3.m19089l()) {
                            z = false;
                        } else {
                            z = feedUnitCollection.m9675a(b2, i2, false);
                        }
                        return z;
                    }
                }
                z = false;
                return z;
            }
        }
        return false;
    }

    private boolean m26716b(FeedUnitCollection feedUnitCollection, Set<String> set) {
        boolean z = false;
        HasSponsoredImpression hasSponsoredImpression = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < feedUnitCollection.mo1374a()) {
            int i4;
            GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i3);
            FeedUnit c = b.mo2540c();
            if (!(c == null || m26720c(c))) {
                int i5;
                if (!feedUnitCollection.m9691f(i3)) {
                    if (SponsoredUtils.m21145a(c)) {
                        Sponsorable sponsorable = (Sponsorable) c;
                        FeedProps c2 = FeedProps.m19802c(sponsorable);
                        if (hasSponsoredImpression != null) {
                            boolean z2;
                            HasSponsoredImpression hasSponsoredImpression2;
                            int a = m26687a(sponsorable.ab_().m29341n(), hasSponsoredImpression.ab_().m29341n()) - 1;
                            if (i < a) {
                                boolean z3;
                                Object obj = null;
                                a -= i;
                                if (m26718c()) {
                                    if (this.f19002i.m2189a(546, false) && i2 > 0 && m26704a(feedUnitCollection, i2, a)) {
                                        obj = 1;
                                        i2 = 0;
                                    } else {
                                        i2 = i;
                                    }
                                    if (obj == null && m26715b(feedUnitCollection, i3, a)) {
                                        obj = 1;
                                        i2++;
                                    }
                                } else {
                                    i2 = i;
                                }
                                if (obj != null) {
                                    z3 = z;
                                } else if (m26722d() && this.f19001h.m26740a(b, i3)) {
                                    feedUnitCollection.m9685c(b);
                                    i4 = i3 - 1;
                                    z2 = z;
                                    hasSponsoredImpression2 = hasSponsoredImpression;
                                } else {
                                    m26695a(i2, true, false, set.contains(DedupableUtil.m23084a(b)), false, -1, -1, -1);
                                    m26700a(c2, "ad_spacing_violation", i2, true);
                                    z3 = true;
                                }
                                hasSponsoredImpression2 = hasSponsoredImpression;
                                z2 = z3;
                                i4 = i3;
                            } else {
                                i2 = 0;
                                z2 = z;
                                Object obj2 = sponsorable;
                                i4 = i3;
                            }
                            hasSponsoredImpression = hasSponsoredImpression2;
                            z = z2;
                            i5 = i4;
                            i4 = 0;
                            i3 = i5;
                        } else {
                            i2 = 0;
                            Object obj3 = sponsorable;
                            i4 = i3;
                        }
                    } else if (m26717b(c)) {
                        i5 = i2;
                        i2 = i + 1;
                        i4 = i5;
                    }
                    i3++;
                    i = i2;
                    i2 = i4;
                } else if (this.f19002i.m2189a(544, false)) {
                    hasSponsoredImpression = null;
                    i5 = i2;
                    i2 = 0;
                    i4 = i5;
                    i3++;
                    i = i2;
                    i2 = i4;
                }
            }
            i4 = i2;
            i2 = i;
            i3++;
            i = i2;
            i2 = i4;
        }
        if (m26722d()) {
            m26721d(feedUnitCollection);
        }
        return z;
    }

    private void m26721d(FeedUnitCollection feedUnitCollection) {
        FeedEdgeCacheEntry feedEdgeCacheEntry;
        SponsoredFeedUnitCache sponsoredFeedUnitCache = this.f19001h;
        if (sponsoredFeedUnitCache.f19011g.isEmpty()) {
            feedEdgeCacheEntry = null;
        } else {
            Comparator comparator;
            Collection collection = sponsoredFeedUnitCache.f19011g;
            if (sponsoredFeedUnitCache.f19009e.m2189a(535, false)) {
                comparator = SponsoredFeedUnitCache.f19005b;
            } else {
                comparator = SponsoredFeedUnitCache.f19004a;
            }
            feedEdgeCacheEntry = (FeedEdgeCacheEntry) Collections.max(collection, comparator);
        }
        FeedEdgeCacheEntry feedEdgeCacheEntry2 = feedEdgeCacheEntry;
        if (feedEdgeCacheEntry2 != null && m26705a(feedUnitCollection, feedEdgeCacheEntry2.b, feedEdgeCacheEntry2.c)) {
            this.f19001h.m26742b(feedEdgeCacheEntry2.b);
        }
    }

    private void m26723e(FeedUnitCollection feedUnitCollection) {
        Iterator b = this.f19001h.m26741b();
        while (b.hasNext()) {
            GraphQLFeedUnitEdge graphQLFeedUnitEdge = ((FeedEdgeCacheEntry) b.next()).b;
            if (feedUnitCollection.m9687d(graphQLFeedUnitEdge)) {
                feedUnitCollection.m9680b(graphQLFeedUnitEdge);
            }
        }
        this.f19001h.m26743c();
    }

    private static int m26690a(FeedUnitCollection feedUnitCollection, SponsorableUnit sponsorableUnit, int i, Queue<SponsorableUnit> queue) {
        if (!feedUnitCollection.m9675a(sponsorableUnit.a, i, true)) {
            return -1;
        }
        int i2 = i + 1;
        String a = DedupableUtil.m23084a(sponsorableUnit.a);
        while (i2 < feedUnitCollection.mo1374a()) {
            GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i2);
            if (b != null) {
                if (Objects.equal(a, DedupableUtil.m23084a(b))) {
                    return i2;
                }
                if (b.mo2540c() != null && SponsoredUtils.m21145a(b.mo2540c())) {
                    queue.offer(new SponsorableUnit(b, i2));
                    feedUnitCollection.m9685c(b);
                    i2--;
                }
            }
            i2++;
        }
        return i2;
    }

    private boolean m26726f(FeedUnitCollection feedUnitCollection) {
        if (m26730k()) {
            m26723e(feedUnitCollection);
        }
        Queue linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Sponsorable sponsorable = null;
        int i2 = -1;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        int i4 = 0;
        while (i4 < feedUnitCollection.mo1374a()) {
            int i5;
            boolean z3;
            int i6;
            Sponsorable sponsorable2;
            int i7;
            boolean z4;
            GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i4);
            FeedUnit c = b.mo2540c();
            if (c == null || m26720c(c) || !m26717b(c)) {
                i5 = i4;
                z3 = z2;
                i6 = i3;
                sponsorable2 = sponsorable;
                i7 = i;
                i4 = i2;
                z4 = z;
            } else if (SponsoredUtils.m21145a(c)) {
                sponsorable2 = (Sponsorable) c;
                if (m26707a(sponsorable, sponsorable2, i, z2)) {
                    z4 = z;
                    i6 = i3 + 1;
                    i7 = 0;
                    z3 = z2;
                    i5 = i4;
                } else {
                    if (i3 == 1) {
                        i6 = m26691a(sponsorable, sponsorable2, z2) - i;
                        i5 = m26689a(feedUnitCollection, i2, i6, m26692a(z2), m26729i());
                        if (i5 >= i6) {
                            z4 = z;
                            i6 = i3 + 1;
                            i7 = 0;
                            z3 = z2;
                            i5 = i4;
                        } else {
                            r4 = i + i5;
                        }
                    } else {
                        r4 = i;
                    }
                    linkedList.offer(new SponsorableUnit(b, i4));
                    feedUnitCollection.m9685c(b);
                    i5 = i4 - 1;
                    i6 = i3;
                    i4 = i2;
                    sponsorable2 = sponsorable;
                    i7 = r4;
                    z3 = z2;
                    z4 = z;
                }
            } else {
                Sponsorable sponsorable3;
                int i8;
                boolean z5;
                int i9;
                if (feedUnitCollection.m9691f(i4)) {
                    z4 = true;
                    if (!m26727g()) {
                        z |= m26708a(linkedList, (List) arrayList);
                    }
                    sponsorable3 = null;
                    i8 = -1;
                    i7 = 0;
                    z5 = z;
                    i9 = 0;
                } else {
                    z5 = z;
                    i7 = i3;
                    i8 = i2;
                    z4 = z2;
                    i9 = i + 1;
                    sponsorable3 = sponsorable;
                }
                if (!linkedList.isEmpty()) {
                    SponsorableUnit sponsorableUnit = (SponsorableUnit) linkedList.peek();
                    sponsorable2 = sponsorableUnit.b();
                    if (m26707a(sponsorable3, sponsorable2, i9, z4)) {
                        r4 = m26690a(feedUnitCollection, sponsorableUnit, i4, linkedList);
                        if (r4 >= 0) {
                            linkedList.poll();
                            i7++;
                            m26701a(sponsorableUnit.a(), sponsorableUnit.c(), r4 - sponsorableUnit.c(), false);
                            i5 = r4;
                            i4 = r4;
                            z3 = z4;
                            z4 = z5;
                            i6 = i7;
                            i7 = 0;
                        }
                    }
                }
                i5 = i4;
                z3 = z4;
                sponsorable2 = sponsorable3;
                i4 = i8;
                z4 = z5;
                i6 = i7;
                i7 = i9;
            }
            z2 = z3;
            z = z4;
            i3 = i6;
            sponsorable = sponsorable2;
            i = i7;
            i2 = i4;
            i4 = i5 + 1;
        }
        if (!linkedList.isEmpty()) {
            z |= m26708a(linkedList, (List) arrayList);
        } else if (!m26730k()) {
            m26721d(feedUnitCollection);
        }
        m26697a(feedUnitCollection, (List) arrayList);
        return z;
    }

    private boolean m26707a(@Nullable Sponsorable sponsorable, Sponsorable sponsorable2, int i, boolean z) {
        return i >= m26691a(sponsorable, sponsorable2, z);
    }

    private int m26691a(@Nullable Sponsorable sponsorable, Sponsorable sponsorable2, boolean z) {
        if (sponsorable == null) {
            return m26709b(z);
        }
        return m26687a(sponsorable2.ab_().f21621t, sponsorable.ab_().f21621t) - 1;
    }

    private int m26692a(boolean z) {
        if (m26728h() && z) {
            return 0;
        }
        return 2;
    }

    private int m26709b(boolean z) {
        if (m26728h() && z) {
            return 0;
        }
        return 1;
    }

    private boolean m26708a(Queue<SponsorableUnit> queue, List<SponsorableUnit> list) {
        boolean z = false;
        while (!queue.isEmpty()) {
            boolean z2;
            SponsorableUnit sponsorableUnit = (SponsorableUnit) queue.poll();
            if (this.f19001h.m26740a(sponsorableUnit.a, sponsorableUnit.b)) {
                z2 = z;
            } else {
                list.add(sponsorableUnit);
                z2 = true;
            }
            z = z2;
        }
        return z;
    }

    private void m26697a(FeedUnitCollection feedUnitCollection, List<SponsorableUnit> list) {
        for (SponsorableUnit sponsorableUnit : list) {
            if (this.f19002i.m2189a(538, false)) {
                feedUnitCollection.m9680b(sponsorableUnit.a);
            }
            m26700a(FeedProps.m19802c(sponsorableUnit.b()), "ad_spacing_violation", -1, true);
            m26702a(sponsorableUnit.a, sponsorableUnit.b, -1, false, "end_of_feed");
        }
    }

    private void m26699a(FeedUnitCollection feedUnitCollection, Set<String> set, Set<String> set2) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < feedUnitCollection.mo1374a()) {
            boolean z3;
            GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
            FeedUnit c = b.mo2540c();
            if (c == null || !m26717b(c)) {
                z3 = z2;
                z2 = z;
            } else if (feedUnitCollection.m9691f(i)) {
                i4++;
                i2++;
                i3 = 0;
                z2 = false;
                z3 = false;
            } else {
                boolean z4;
                if (SponsoredUtils.m21145a(c)) {
                    String a = DedupableUtil.m23084a(b);
                    m26695a(z2, false, !z, set.contains(a), set2.contains(a), i4, i3, i2);
                    z++;
                    z4 = false;
                } else {
                    z4 = z2 + 1;
                }
                i4++;
                i3++;
                z2 = z;
                z3 = z4;
            }
            i++;
            z = z2;
            z2 = z3;
        }
    }

    @Deprecated
    private boolean m26704a(FeedUnitCollection feedUnitCollection, int i, int i2) {
        GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            FeedUnit c = feedUnitCollection.m9677b(i5).mo2540c();
            if (!(c == null || m26720c(c))) {
                if (feedUnitCollection.m9691f(i5) || SponsoredUtils.m21145a(c)) {
                    break;
                } else if (m26717b(c)) {
                    i4++;
                    if (i4 == i2 + 1) {
                        i3 = i5;
                    }
                    if (i4 == i2 + 2) {
                        if (feedUnitCollection.m9675a(b, i3, false)) {
                            m26701a(b, i, i2 * -1, false);
                            return true;
                        }
                        m26702a(b, i, 0, false, "move_failure");
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        m26702a(b, i, ((i2 + 2) - i4) * -1, false, "top_of_feed");
        return false;
    }

    private int m26689a(FeedUnitCollection feedUnitCollection, int i, int i2, int i3, boolean z) {
        int i4 = -1;
        int i5 = i - 1;
        int i6 = 0;
        while (i5 >= 0) {
            FeedUnit c = feedUnitCollection.m9677b(i5).mo2540c();
            if (!(c == null || m26720c(c) || !m26717b(c))) {
                if (SponsoredUtils.m21145a(c)) {
                    break;
                }
                if (i6 == i2) {
                    i4 = i5;
                }
                if (!feedUnitCollection.m9691f(i5)) {
                    i6++;
                }
                if (i6 < i2 + i3 || i4 < 0) {
                    if (feedUnitCollection.m9691f(i5)) {
                        break;
                    }
                } else {
                    return m26688a(feedUnitCollection, i, i4, i2);
                }
            }
            i5--;
        }
        if (z) {
            i4 = 0;
            while (true) {
                if (i5 < 0 || i4 < i3) {
                    i5++;
                    if (i5 >= i - 1) {
                        break;
                    }
                    c = feedUnitCollection.m9677b(i5).mo2540c();
                    if (!(c == null || m26720c(c) || !m26717b(c))) {
                        i4++;
                    }
                } else {
                    return m26688a(feedUnitCollection, i, i5, i6 - i4);
                }
            }
        }
        m26702a(feedUnitCollection.m9677b(i), i, -((i2 + i3) - i6), false, "top_of_feed");
        return 0;
    }

    private int m26688a(FeedUnitCollection feedUnitCollection, int i, int i2, int i3) {
        GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
        if (feedUnitCollection.m9675a(b, i2, false)) {
            m26701a(b, i, -i3, false);
            return i3;
        }
        m26702a(b, i, 0, false, "move_failure");
        return 0;
    }

    private boolean m26715b(FeedUnitCollection feedUnitCollection, int i, int i2) {
        GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
        int i3 = 0;
        for (int i4 = i + 1; i4 < feedUnitCollection.mo1374a(); i4++) {
            FeedUnit c = feedUnitCollection.m9677b(i4).mo2540c();
            if (!(c == null || m26720c(c))) {
                if (SponsoredUtils.m21145a(c)) {
                    m26702a(b, i, i2 - i3, false, "ad_present");
                    return false;
                } else if (m26717b(c)) {
                    i3++;
                    if (i3 == i2) {
                        if (feedUnitCollection.m9675a(b, i4, false)) {
                            m26701a(b, i, i2, false);
                            return true;
                        }
                        m26702a(b, i, 0, false, "move_failure");
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        m26702a(b, i, i2 - i3, false, "end_of_feed");
        return false;
    }

    private boolean m26705a(FeedUnitCollection feedUnitCollection, GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i) {
        Preconditions.checkNotNull(graphQLFeedUnitEdge);
        Preconditions.checkArgument(SponsoredUtils.m21145a(graphQLFeedUnitEdge.mo2540c()));
        HasSponsoredImpression hasSponsoredImpression = null;
        int i2 = ((Sponsorable) graphQLFeedUnitEdge.mo2540c()).ab_().f21621t;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        while (z < feedUnitCollection.mo1374a() && !feedUnitCollection.m9691f((int) z)) {
            boolean z3;
            Sponsorable sponsorable;
            int i4;
            HasSponsoredImpression hasSponsoredImpression2;
            Object obj;
            FeedUnit c = feedUnitCollection.m9677b((int) z).mo2540c();
            if (!(c == null || m26720c(c))) {
                if (SponsoredUtils.m21145a(c)) {
                    z3 = false;
                    sponsorable = (Sponsorable) c;
                    i4 = 0;
                } else if (m26717b(c)) {
                    i4 = i3 + 1;
                    if (hasSponsoredImpression == null || z2 || i4 < m26687a(hasSponsoredImpression.ab_().f21621t, i2) - 1) {
                        z3 = z2;
                        hasSponsoredImpression2 = hasSponsoredImpression;
                    } else {
                        z3 = z;
                        hasSponsoredImpression2 = hasSponsoredImpression;
                    }
                }
                z++;
                obj = sponsorable;
                z2 = z3;
                i3 = i4;
            }
            i4 = i3;
            z3 = z2;
            hasSponsoredImpression2 = hasSponsoredImpression;
            z++;
            obj = sponsorable;
            z2 = z3;
            i3 = i4;
        }
        if (z2 > false || !feedUnitCollection.m9675a(graphQLFeedUnitEdge, (int) z2, false)) {
            return false;
        }
        m26701a(graphQLFeedUnitEdge, i, z2 - i, true);
        return true;
    }

    public static boolean m26717b(FeedUnit feedUnit) {
        return ((feedUnit instanceof HideableUnit) && ((HideableUnit) feedUnit).mo2879o() == StoryVisibility.GONE) ? false : true;
    }

    private boolean m26720c(FeedUnit feedUnit) {
        if (!(feedUnit instanceof Sponsorable)) {
            return false;
        }
        Sponsorable sponsorable = (Sponsorable) feedUnit;
        if (sponsorable.mo2879o() == StoryVisibility.GONE) {
            return true;
        }
        SponsoredImpression ab_ = sponsorable.ab_();
        if (ab_ == null || ab_ == SponsoredImpression.f21615n) {
            return false;
        }
        if (ab_.f21622u) {
            return true;
        }
        if (!ab_.f21618q) {
            return false;
        }
        boolean z = false;
        if (!this.f18998e.mo286a(FeedPrefKeys.f5751o, false)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    private void m26700a(FeedProps<? extends Sponsorable> feedProps, String str, int i, boolean z) {
        String r;
        FeedUnit feedUnit = (Sponsorable) feedProps.m19804a();
        FeedUnitData a = this.f19000g.m14177a(feedUnit);
        if (m26724e() && a != null) {
            if (a.m27202g() && z) {
                a.f19503j = true;
                return;
            }
            a.f19503j = false;
        }
        FeedUnitMutator.a(feedUnit, StoryVisibility.GONE);
        Sponsorable sponsorable = (Sponsorable) FeedUnitMutator.a(feedUnit).a(StoryVisibility.GONE).a();
        FeedProps b = feedProps.m19805b(sponsorable);
        JsonNode b2 = TrackableFeedProps.m27452b(b);
        if (sponsorable instanceof ScrollableItemListFeedUnit) {
            HasTracking hasTracking = (ScrollableItemListFeedUnit) sponsorable;
            for (Object next : hasTracking.mo2882v()) {
                JsonNode a2;
                if (next instanceof CachedFeedTrackable) {
                    a2 = TrackableFeedProps.m27451a(b.m19803a((Flattenable) next));
                } else if (next instanceof HasTracking) {
                    a2 = GraphQLHelper.m22468a((HasTracking) next, hasTracking);
                } else if (next instanceof InstagramPhotosFromFriendsPhoto) {
                    a2 = ((InstagramPhotosFromFriendsPhoto) next).a();
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    this.f18995b.mo534d(NewsFeedAnalyticsEventBuilder.m14100a(a2, sponsorable.getType(), str, i));
                }
            }
        } else {
            this.f18995b.mo534d(NewsFeedAnalyticsEventBuilder.m14100a(b2, sponsorable.getType(), str, i));
        }
        Bundle bundle = new Bundle();
        GraphQLObjectType type = sponsorable.getType();
        String q = sponsorable.mo2881q();
        String arrayNode = b2.toString();
        StoryVisibility storyVisibility = StoryVisibility.GONE;
        String g = sponsorable.mo2507g();
        int p = sponsorable.mo2880p();
        if (sponsorable instanceof NegativeFeedbackActionsUnit) {
            r = ((NegativeFeedbackActionsUnit) sponsorable).mo2892r();
        } else {
            r = null;
        }
        bundle.putParcelable("hideFeedStoryParams", new Params(type, q, arrayNode, storyVisibility, false, g, p, r));
        BlueServiceOperationFactoryDetour.a(this.f18999f, "feed_hide_story", bundle, -2087574298).mo3451a(true).mo3452a();
    }

    private void m26695a(int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3, int i4) {
        this.f18995b.mo526a(NewsFeedAnalyticsEventBuilder.m14095a(i, z, z2, z3, z4, i2, i3, i4));
    }

    private int m26687a(int i, int i2) {
        return this.f19002i.m2189a(539, false) ? Math.min(i, i2) : Math.max(i, i2);
    }

    @VisibleForTesting
    private String m26711b(FeedUnitCollection feedUnitCollection, List<GraphQLFeedUnitEdge> list) {
        TracerDetour.a("SponsoredFeedUnitValidator.serializeFeedUnitCollection", -490714984);
        try {
            StringBuilder stringBuilder = new StringBuilder(feedUnitCollection.mo1374a());
            for (int i = 0; i < feedUnitCollection.mo1374a(); i++) {
                GraphQLFeedUnitEdge b = feedUnitCollection.m9677b(i);
                char a = m26686a(b, feedUnitCollection.m9691f(i), list.contains(b));
                if (a != '\u0000') {
                    stringBuilder.append(a);
                }
            }
            String stringBuilder2 = stringBuilder.toString();
            return stringBuilder2;
        } finally {
            TracerDetour.a(-93161706);
        }
    }

    private char m26686a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, boolean z, boolean z2) {
        FeedUnit c = graphQLFeedUnitEdge.mo2540c();
        if (c == null) {
            return '\u0000';
        }
        if (z) {
            return 'C';
        }
        char c2;
        if (c instanceof Sponsorable) {
            int i;
            Sponsorable sponsorable = (Sponsorable) c;
            SponsoredImpression ab_ = sponsorable.ab_();
            if (ab_ == null || ab_ == SponsoredImpression.f21615n) {
                i = 0;
            } else {
                i = ab_.f21621t;
            }
            if (sponsorable.mo2879o() == StoryVisibility.GONE) {
                return i > 0 ? 'X' : 'G';
            } else {
                if (i > 0) {
                    return Integer.toString(i).charAt(0);
                }
            }
        }
        if (!m26717b(c)) {
            c2 = 'I';
        } else if (z2) {
            c2 = 'N';
        } else {
            FeedUnitData a = this.f19000g.m14177a(c);
            if (a == null) {
                c2 = '?';
            } else if (a.f19499f) {
                c2 = 'O';
            } else if (a.m27201f()) {
                c2 = 'o';
            } else {
                c2 = '.';
            }
        }
        return c2;
    }
}

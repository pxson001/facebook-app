package com.facebook.feedplugins.momentscalltoaction;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: STICKER_REMOVED */
public class MomentsCallToActionImpressionHelper implements IHaveNonCriticalKeysToClear {
    private static final Class<?> f23530a = MomentsCallToActionImpressionHelper.class;
    public static final PrefKey f23531b = ((PrefKey) ((PrefKey) SharedPrefKeys.a.a("moments_call_to_action_prefs/")).a("impressions"));
    private static volatile MomentsCallToActionImpressionHelper f23532h;
    private final QeAccessor f23533c;
    private final Clock f23534d;
    public final FbSharedPreferences f23535e;
    public final Set<String> f23536f = new HashSet();
    @Nullable
    public LinkedList<Long> f23537g;

    public static com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionImpressionHelper m25773a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23532h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionImpressionHelper.class;
        monitor-enter(r1);
        r0 = f23532h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m25775b(r0);	 Catch:{ all -> 0x0035 }
        f23532h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23532h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionImpressionHelper.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.momentscalltoaction.MomentsCallToActionImpressionHelper");
    }

    private static MomentsCallToActionImpressionHelper m25775b(InjectorLike injectorLike) {
        return new MomentsCallToActionImpressionHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MomentsCallToActionImpressionHelper(QeAccessor qeAccessor, Clock clock, FbSharedPreferences fbSharedPreferences) {
        this.f23533c = qeAccessor;
        this.f23534d = clock;
        this.f23535e = fbSharedPreferences;
    }

    public final ImmutableSet<PrefKey> m25783a() {
        return ImmutableSet.of(f23531b);
    }

    public final boolean m25784a(GraphQLStory graphQLStory) {
        if (m25777c(graphQLStory)) {
            return true;
        }
        m25781g();
        if (m25779e() >= ((long) m25774b())) {
            return false;
        }
        return true;
    }

    public final void m25785b(GraphQLStory graphQLStory) {
        if (!m25777c(graphQLStory)) {
            m25781g();
            m25780f();
            this.f23537g.add(Long.valueOf(m25778d()));
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f23537g.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(l);
            }
            this.f23535e.edit().a(f23531b, stringBuilder.toString()).commit();
            if (graphQLStory.g() != null) {
                this.f23536f.add(graphQLStory.g());
            }
        }
    }

    private int m25774b() {
        return this.f23533c.a(ExperimentsForMomentsCallToActionFeedPluginModule.f23529b, 0);
    }

    private long m25776c() {
        return ((long) this.f23533c.a(ExperimentsForMomentsCallToActionFeedPluginModule.f23528a, 24)) * 3600;
    }

    private boolean m25777c(GraphQLStory graphQLStory) {
        if (graphQLStory.g() == null) {
            return false;
        }
        return this.f23536f.contains(graphQLStory.g());
    }

    private long m25778d() {
        return this.f23534d.a() / 1000;
    }

    private long m25779e() {
        long c = m25776c();
        long d = m25778d();
        Iterator it = this.f23537g.iterator();
        long j = 0;
        while (it.hasNext()) {
            long j2;
            if (d - ((Long) it.next()).longValue() <= c) {
                j2 = 1 + j;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    private void m25780f() {
        int b = m25774b();
        long c = m25776c();
        long d = m25778d();
        Iterator it = this.f23537g.iterator();
        while (it.hasNext()) {
            if (d - ((Long) it.next()).longValue() > c) {
                it.remove();
            }
        }
        if (this.f23537g.size() > b) {
            this.f23537g.subList(b, this.f23537g.size()).clear();
        }
    }

    private void m25781g() {
        if (this.f23537g == null) {
            m25782h();
        }
    }

    private void m25782h() {
        String a = this.f23535e.a(f23531b, "");
        this.f23537g = new LinkedList();
        if (!Strings.isNullOrEmpty(a)) {
            try {
                for (String parseLong : a.split(",")) {
                    this.f23537g.add(Long.valueOf(Long.parseLong(parseLong)));
                }
            } catch (Throwable e) {
                BLog.a(f23530a, e, "Failed to read Moments CTA impressions from: '%s'", new Object[]{a});
            }
        }
    }
}

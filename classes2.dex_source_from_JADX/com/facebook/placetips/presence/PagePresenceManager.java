package com.facebook.placetips.presence;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.bootstrap.event.PlaceTipsEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceChangedEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceStayedTheSameEvent;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLInterfaces.LocationTriggerWithReactionUnits;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.prefs.shared.objects.FbSharedObjectPreferencesImpl;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipWelcomeHeaderFragmentModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: maximum weight was already set to %s */
public class PagePresenceManager implements PagePresenceProvider {
    private static volatile PagePresenceManager f14805i;
    private final AppStateManager f14806a;
    public final Clock f14807b;
    private final FbSharedObjectPreferencesImpl f14808c;
    private final PlaceTipsAnalyticsLogger f14809d;
    private final PlaceTipsEventBus f14810e;
    private final Accessor f14811f;
    private Optional<PresenceDescription> f14812g = null;
    private Optional<LocationTriggerWithReactionUnits> f14813h = Absent.INSTANCE;

    public static com.facebook.placetips.presence.PagePresenceManager m21206a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14805i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.presence.PagePresenceManager.class;
        monitor-enter(r1);
        r0 = f14805i;	 Catch:{ all -> 0x003a }
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
        r0 = m21210b(r0);	 Catch:{ all -> 0x0035 }
        f14805i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14805i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.presence.PagePresenceManager.a(com.facebook.inject.InjectorLike):com.facebook.placetips.presence.PagePresenceManager");
    }

    private static PagePresenceManager m21210b(InjectorLike injectorLike) {
        return new PagePresenceManager(AppStateManager.m2245a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbSharedObjectPreferencesImpl.m21242b(injectorLike), PlaceTipsAnalyticsLogger.m21246a(injectorLike), PlaceTipsEventBus.m4590a(injectorLike), Accessor.m21309b(injectorLike));
    }

    @Inject
    public PagePresenceManager(AppStateManager appStateManager, Clock clock, FbSharedObjectPreferencesImpl fbSharedObjectPreferencesImpl, PlaceTipsAnalyticsLogger placeTipsAnalyticsLogger, PlaceTipsEventBus placeTipsEventBus, Accessor accessor) {
        this.f14806a = appStateManager;
        this.f14807b = clock;
        this.f14808c = fbSharedObjectPreferencesImpl;
        this.f14809d = placeTipsAnalyticsLogger;
        this.f14810e = placeTipsEventBus;
        this.f14811f = accessor;
    }

    private synchronized void m21212c() {
        if (this.f14812g == null) {
            this.f14812g = this.f14811f.m21315e() ? Optional.fromNullable(this.f14808c.m21244a(PlaceTipsPresencePrefs.a)) : Absent.withType();
        }
    }

    public final Optional<PresenceDescription> mo2826a() {
        m21212c();
        return this.f14812g;
    }

    public final Optional<LocationTriggerWithReactionUnits> mo2827b() {
        return this.f14813h;
    }

    public final synchronized PlaceTipsPresenceEvent m21214a(PresenceSourceType presenceSourceType, @Nullable LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel) {
        m21212c();
        m21208a(locationTriggerWithReactionUnitsModel);
        return m21213a(presenceSourceType);
    }

    public final synchronized PlaceTipsPresenceEvent m21213a(PresenceSourceType presenceSourceType) {
        PlaceTipsPresenceEvent a;
        m21212c();
        if (presenceSourceType == PresenceSourceType.FORCE_OFF) {
            this.f14813h = Absent.withType();
        }
        if (this.f14812g.isPresent()) {
            PresenceSourceType l = ((PresenceDescription) this.f14812g.get()).l();
            if (presenceSourceType.equals(l) || presenceSourceType.nothingFoundPriority > l.foundPriority) {
                a = m21203a(null, presenceSourceType);
            } else {
                a = m21209b(((PresenceDescription) this.f14812g.get()).k());
            }
        } else {
            a = m21205a(null, PresenceSource.a(presenceSourceType));
        }
        return a;
    }

    public final PresenceUpdateBuilder m21215a(PresenceSource presenceSource) {
        m21212c();
        return new PresenceUpdateBuilder(this, presenceSource);
    }

    final void m21217a(boolean z) {
        if (z) {
            m21213a(PresenceSourceType.FORCE_OFF);
        }
        m21211b(null);
    }

    private void m21208a(@Nullable LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel) {
        if (locationTriggerWithReactionUnitsModel != null || !this.f14813h.isPresent()) {
            this.f14813h = Optional.fromNullable(locationTriggerWithReactionUnitsModel);
        }
    }

    public static synchronized PlaceTipsPresenceEvent m21204a(PagePresenceManager pagePresenceManager, PresenceUpdateBuilder presenceUpdateBuilder) {
        PlaceTipsPresenceEvent a;
        synchronized (pagePresenceManager) {
            pagePresenceManager.m21208a(presenceUpdateBuilder.q);
            if (!pagePresenceManager.f14806a.m2262j() || pagePresenceManager.f14811f.m21315e()) {
                PresenceSourceType a2 = presenceUpdateBuilder.b.a();
                if (pagePresenceManager.f14812g.isPresent() && presenceUpdateBuilder.c.equals(((PresenceDescription) pagePresenceManager.f14812g.get()).i())) {
                    a = pagePresenceManager.m21205a(presenceUpdateBuilder, presenceUpdateBuilder.b);
                } else {
                    PresenceDescription b = presenceUpdateBuilder.b();
                    if (pagePresenceManager.f14812g.isPresent()) {
                        PresenceDescription presenceDescription = (PresenceDescription) pagePresenceManager.f14812g.get();
                        PresenceSourceType l = presenceDescription.l();
                        if (a2.equals(l) || a2.foundPriority >= l.foundPriority) {
                            a = pagePresenceManager.m21203a(b, a2);
                        } else {
                            a = pagePresenceManager.m21209b(presenceDescription.k());
                        }
                    } else {
                        a = pagePresenceManager.m21203a(b, a2);
                    }
                }
            } else {
                a = pagePresenceManager.m21213a(PresenceSourceType.FORCE_OFF);
            }
        }
        return a;
    }

    private synchronized PlaceTipsPresenceStayedTheSameEvent m21205a(@Nullable PresenceUpdateBuilder presenceUpdateBuilder, PresenceSource presenceSource) {
        PlaceTipsPresenceStayedTheSameEvent b;
        ConfidenceLevel confidenceLevel = null;
        synchronized (this) {
            if (this.f14812g.isPresent()) {
                PresenceDescription presenceDescription = (PresenceDescription) this.f14812g.get();
                long a = this.f14807b.mo211a();
                PlaceTipWelcomeHeaderFragmentModel placeTipWelcomeHeaderFragmentModel = presenceUpdateBuilder == null ? null : presenceUpdateBuilder.f;
                ReactionStories reactionStories = presenceUpdateBuilder == null ? null : presenceUpdateBuilder.m;
                String str = presenceUpdateBuilder == null ? null : presenceUpdateBuilder.n;
                String str2 = presenceUpdateBuilder == null ? null : presenceUpdateBuilder.o;
                if (presenceUpdateBuilder != null) {
                    confidenceLevel = presenceUpdateBuilder.p;
                }
                m21207a(presenceDescription.a(a, placeTipWelcomeHeaderFragmentModel, reactionStories, str, str2, presenceSource, confidenceLevel));
            }
            b = m21209b(presenceSource);
        }
        return b;
    }

    private synchronized PlaceTipsPresenceStayedTheSameEvent m21209b(PresenceSource presenceSource) {
        PlaceTipsPresenceEvent placeTipsPresenceStayedTheSameEvent;
        placeTipsPresenceStayedTheSameEvent = new PlaceTipsPresenceStayedTheSameEvent(this.f14812g);
        this.f14810e.m4593a((PlaceTipsEvent) placeTipsPresenceStayedTheSameEvent);
        this.f14809d.m21255a(placeTipsPresenceStayedTheSameEvent, presenceSource.a());
        return placeTipsPresenceStayedTheSameEvent;
    }

    private synchronized PlaceTipsPresenceChangedEvent m21203a(@Nullable PresenceDescription presenceDescription, PresenceSourceType presenceSourceType) {
        PlaceTipsPresenceEvent placeTipsPresenceChangedEvent;
        Optional optional = this.f14812g;
        m21207a(presenceDescription);
        placeTipsPresenceChangedEvent = new PlaceTipsPresenceChangedEvent(optional, this.f14812g);
        this.f14810e.m4593a((PlaceTipsEvent) placeTipsPresenceChangedEvent);
        this.f14809d.m21255a(placeTipsPresenceChangedEvent, presenceSourceType);
        return placeTipsPresenceChangedEvent;
    }

    private synchronized void m21207a(@Nullable PresenceDescription presenceDescription) {
        this.f14812g = Optional.fromNullable(presenceDescription);
        if (this.f14811f.m21315e()) {
            if (presenceDescription == null || !presenceDescription.l().isPersistent) {
                m21211b(null);
            } else {
                m21211b(presenceDescription);
            }
        }
    }

    private void m21211b(@Nullable PresenceDescription presenceDescription) {
        this.f14808c.m21243a().a(PlaceTipsPresencePrefs.a, presenceDescription).a();
    }
}

package com.facebook.search.suggestions.nullstate;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.bootstrap.PresenceDescription;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventBus;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel.UnitsModel.PlacesModel;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.GapTypeaheadUnit.BackgroundType;
import com.facebook.search.model.NullStateModuleSuggestionUnit.Type;
import com.facebook.search.model.SuggestionGroup;
import com.facebook.search.model.SuggestionGroup.Builder;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.converter.NearbyEntitySuggestionGraphQLModelConverter;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: liveVideoLogWatchTimeParamsKey */
public class NearbyNullStateSupplier extends NullStateSupplier {
    private static volatile NearbyNullStateSupplier f9272l;
    private final Resources f9273a;
    private final SuggestionsListRowItemFactory f9274b;
    private final QeAccessor f9275c;
    private final GatekeeperStoreImpl f9276d;
    private final Provider<Boolean> f9277e;
    private final Lazy<PagePresenceProvider> f9278f;
    private final NearbyEntitySuggestionGraphQLModelConverter f9279g;
    private final GraphSearchErrorReporter f9280h;
    private final PlaceTipsEventBus f9281i;
    private LocationTriggerEventSubscriber f9282j = null;
    private ImmutableList<TypeaheadUnit> f9283k = null;

    public static com.facebook.search.suggestions.nullstate.NearbyNullStateSupplier m9654a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9272l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.NearbyNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9272l;	 Catch:{ all -> 0x003a }
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
        r0 = m9655b(r0);	 Catch:{ all -> 0x0035 }
        f9272l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9272l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.NearbyNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.NearbyNullStateSupplier");
    }

    private static NearbyNullStateSupplier m9655b(InjectorLike injectorLike) {
        return new NearbyNullStateSupplier(ResourcesMethodAutoProvider.a(injectorLike), SuggestionsListRowItemFactory.m9618a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4323), IdBasedSingletonScopeProvider.b(injectorLike, 3009), NearbyEntitySuggestionGraphQLModelConverter.m9664a(injectorLike), GraphSearchErrorReporter.a(injectorLike), PlaceTipsEventBus.a(injectorLike));
    }

    public /* synthetic */ Object get() {
        return m9660d();
    }

    @Inject
    public NearbyNullStateSupplier(Resources resources, SuggestionsListRowItemFactory suggestionsListRowItemFactory, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, Provider<Boolean> provider, Lazy<PagePresenceProvider> lazy, NearbyEntitySuggestionGraphQLModelConverter nearbyEntitySuggestionGraphQLModelConverter, GraphSearchErrorReporter graphSearchErrorReporter, PlaceTipsEventBus placeTipsEventBus) {
        this.f9273a = resources;
        this.f9274b = suggestionsListRowItemFactory;
        this.f9275c = qeAccessor;
        this.f9276d = gatekeeperStore;
        this.f9277e = provider;
        this.f9278f = lazy;
        this.f9279g = nearbyEntitySuggestionGraphQLModelConverter;
        this.f9280h = graphSearchErrorReporter;
        this.f9281i = placeTipsEventBus;
    }

    protected void finalize() {
        this.f9281i.b(this.f9282j);
        super.finalize();
    }

    public final ImmutableList<TypeaheadUnit> m9660d() {
        if (this.f9283k == null) {
            m9656k(this);
        }
        if (this.f9282j == null) {
            this.f9282j = new LocationTriggerEventSubscriber(this);
            this.f9281i.a(this.f9282j);
        }
        return this.f9283k;
    }

    public final boolean m9657a() {
        if (this.f9276d.a(SearchAbTestGatekeepers.f).asBoolean(false) && this.f9275c.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForSearchAbTestModule.aS, false)) {
            return true;
        }
        return false;
    }

    public final NullStateStatus m9659c() {
        return NullStateStatus.READY;
    }

    public final int m9661e() {
        Optional b = ((PagePresenceProvider) this.f9278f.get()).b();
        if (b.isPresent()) {
            UnitsModel a = ((LocationTriggerWithReactionUnitsModel) b.get()).a();
            if (a != null) {
                return a.b();
            }
        }
        return -1;
    }

    public final void m9658b() {
        this.f9283k = null;
    }

    public static synchronized void m9656k(NearbyNullStateSupplier nearbyNullStateSupplier) {
        synchronized (nearbyNullStateSupplier) {
            Collection arrayList = new ArrayList();
            PagePresenceProvider pagePresenceProvider = (PagePresenceProvider) nearbyNullStateSupplier.f9278f.get();
            Optional b = pagePresenceProvider.b();
            if (b.isPresent()) {
                LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel = (LocationTriggerWithReactionUnitsModel) b.get();
                if (!(locationTriggerWithReactionUnitsModel == null || locationTriggerWithReactionUnitsModel.a() == null)) {
                    PresenceSource k;
                    ImmutableList d = locationTriggerWithReactionUnitsModel.a().d();
                    Optional a = pagePresenceProvider.a();
                    if (a.isPresent()) {
                        k = ((PresenceDescription) a.get()).k();
                    } else {
                        k = null;
                    }
                    int e = nearbyNullStateSupplier.m9661e();
                    int size = d.size();
                    for (int i = 0; i < size; i++) {
                        try {
                            arrayList.add(NearbyEntitySuggestionGraphQLModelConverter.m9662a((PlacesModel) d.get(i), k, Type.ns_local, e));
                        } catch (GraphSearchException e2) {
                            nearbyNullStateSupplier.f9280h.a(e2);
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                nearbyNullStateSupplier.f9283k = ImmutableList.copyOf(arrayList);
            } else {
                List of = ImmutableList.of(new Builder().a(SuggestionGroup.Type.PLACE_TIP).a(nearbyNullStateSupplier.f9273a.getString(2131237429)).a(ImmutableList.copyOf(arrayList)).a());
                if (!nearbyNullStateSupplier.f9275c.a(ExperimentsForSearchAbTestModule.aV, false) || nearbyNullStateSupplier.m9661e() <= 0) {
                    nearbyNullStateSupplier.f9283k = SuggestionsListRowItemFactory.m9621b(of);
                } else {
                    nearbyNullStateSupplier.f9283k = SuggestionsListRowItemFactory.m9619a(of, BackgroundType.GRAY);
                }
            }
        }
    }
}

package com.facebook.places.create.citypicker;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.places.create.citypicker.NewCityPickerFragment.C04551;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: see_more_results_clicked */
public class CitySearchResultsManager {
    private static volatile CitySearchResultsManager f3561f;
    public Optional<FetchCityParam> f3562a = Absent.INSTANCE;
    public Optional<ImmutableList<CheckinPlace>> f3563b = Absent.INSTANCE;
    public final FetchCityRunner f3564c;
    public final DefaultAndroidThreadUtil f3565d;
    public final Set<Listener> f3566e = Sets.a();

    /* compiled from: see_more_results_clicked */
    public class FetchCityCallback implements FutureCallback<ArrayList<CheckinPlace>> {
        final /* synthetic */ CitySearchResultsManager f3560a;

        public FetchCityCallback(CitySearchResultsManager citySearchResultsManager) {
            this.f3560a = citySearchResultsManager;
        }

        public void onSuccess(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            this.f3560a.f3565d.a();
            this.f3560a.f3563b = Optional.of(ImmutableList.copyOf(arrayList));
            for (C04551 c04551 : this.f3560a.f3566e) {
                c04551.f3575a.at();
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static com.facebook.places.create.citypicker.CitySearchResultsManager m3484a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3561f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.places.create.citypicker.CitySearchResultsManager.class;
        monitor-enter(r1);
        r0 = f3561f;	 Catch:{ all -> 0x003a }
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
        r0 = m3485b(r0);	 Catch:{ all -> 0x0035 }
        f3561f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3561f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.create.citypicker.CitySearchResultsManager.a(com.facebook.inject.InjectorLike):com.facebook.places.create.citypicker.CitySearchResultsManager");
    }

    private static CitySearchResultsManager m3485b(InjectorLike injectorLike) {
        return new CitySearchResultsManager(FetchCityRunner.m3486b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public CitySearchResultsManager(FetchCityRunner fetchCityRunner, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f3564c = fetchCityRunner;
        this.f3565d = defaultAndroidThreadUtil;
    }
}

package com.facebook.geocoder;

import android.location.Address;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.locale.Locales;
import com.facebook.geocoder.GeocoderQuery.ReverseGeocodeQueryString;
import com.facebook.geocoder.GeocoderQueryModels.GeocodeQueryModel;
import com.facebook.geocoder.GeocoderQueryModels.GeocodeQueryModel.GeocodeAddressDataModel.EdgesModel;
import com.facebook.geocoder.GeocoderQueryModels.GeocodeQueryModel.GeocodeAddressDataModel.EdgesModel.NodeModel;
import com.facebook.geocoder.GeocoderQueryModels.ReverseGeocodeQueryModel;
import com.facebook.geocoder.GeocoderQueryModels.ReverseGeocodeQueryModel.ReverseGeocodeDataModel.NodesModel;
import com.facebook.graphql.calls.ReverseGeocodeInputQueryParams;
import com.facebook.graphql.calls.ReverseGeocodeInputQueryParams.GpsPoints;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: peer_to_peer_platform_contexts */
public class FbGeocoder {
    public static final String f6752a = FbGeocoder.class.getSimpleName();
    private static volatile FbGeocoder f6753e;
    public final GraphQLQueryExecutor f6754b;
    public final AbstractFbErrorReporter f6755c;
    public final Locale f6756d;

    /* compiled from: peer_to_peer_platform_contexts */
    class C06921 implements Function<GraphQLResult<ReverseGeocodeQueryModel>, ImmutableList<Address>> {
        final /* synthetic */ FbGeocoder f6750a;

        C06921(FbGeocoder fbGeocoder) {
            this.f6750a = fbGeocoder;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((ReverseGeocodeQueryModel) graphQLResult.e).m7074a() == null || ((ReverseGeocodeQueryModel) graphQLResult.e).m7074a().m7071a().isEmpty()) {
                return RegularImmutableList.a;
            }
            Builder builder = ImmutableList.builder();
            ImmutableList a = ((ReverseGeocodeQueryModel) graphQLResult.e).m7074a().m7071a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                Address address = new Address(this.f6750a.f6756d);
                address.setAddressLine(0, nodesModel.m7066a());
                address.setLocality(nodesModel.m7067j());
                builder.c(address);
            }
            return builder.b();
        }
    }

    /* compiled from: peer_to_peer_platform_contexts */
    public class C06932 implements Function<GraphQLResult<GeocodeQueryModel>, ImmutableList<Address>> {
        final /* synthetic */ FbGeocoder f6751a;

        public C06932(FbGeocoder fbGeocoder) {
            this.f6751a = fbGeocoder;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.d() == null || ((GeocodeQueryModel) graphQLResult.d()).m7058a() == null || ((GeocodeQueryModel) graphQLResult.d()).m7058a().m7055a().isEmpty()) {
                return ImmutableList.of();
            }
            Builder builder = ImmutableList.builder();
            ImmutableList a = ((GeocodeQueryModel) graphQLResult.d()).m7058a().m7055a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodeModel a2 = ((EdgesModel) a.get(i)).m7050a();
                if (a2 != null) {
                    Address address = new Address(this.f6751a.f6756d);
                    address.setAddressLine(0, a2.m7044a());
                    address.setLocality(a2.m7045j());
                    try {
                        address.setLatitude(Double.parseDouble(a2.m7046k()));
                        address.setLongitude(Double.parseDouble(a2.m7047l()));
                    } catch (Throwable e) {
                        this.f6751a.f6755c.a(FbGeocoder.f6752a, "Failed to parseDouble from result", e);
                    }
                    builder.c(address);
                }
            }
            return builder.b();
        }
    }

    public static com.facebook.geocoder.FbGeocoder m7032a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6753e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.geocoder.FbGeocoder.class;
        monitor-enter(r1);
        r0 = f6753e;	 Catch:{ all -> 0x003a }
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
        r0 = m7033b(r0);	 Catch:{ all -> 0x0035 }
        f6753e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6753e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.geocoder.FbGeocoder.a(com.facebook.inject.InjectorLike):com.facebook.geocoder.FbGeocoder");
    }

    private static FbGeocoder m7033b(InjectorLike injectorLike) {
        return new FbGeocoder(GraphQLQueryExecutor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public FbGeocoder(GraphQLQueryExecutor graphQLQueryExecutor, AbstractFbErrorReporter abstractFbErrorReporter, Locales locales) {
        this.f6754b = graphQLQueryExecutor;
        this.f6755c = abstractFbErrorReporter;
        this.f6756d = locales.a();
    }

    public final ListenableFuture<ImmutableList<Address>> m7034a(double d, double d2, int i) {
        boolean z = true;
        boolean z2 = d >= -90.0d && d <= 90.0d;
        Preconditions.checkState(z2);
        if (d2 < -180.0d || d2 > 180.0d) {
            z = false;
        }
        Preconditions.checkState(z);
        return Futures.a(this.f6754b.a(GraphQLRequest.a((ReverseGeocodeQueryString) new ReverseGeocodeQueryString().a("coordinates", new ReverseGeocodeInputQueryParams().a(ImmutableList.of(new GpsPoints().a(Double.valueOf(d)).b(Double.valueOf(d2))))).a("limit", Integer.valueOf(i)))), new C06921(this), MoreExecutors.a());
    }
}

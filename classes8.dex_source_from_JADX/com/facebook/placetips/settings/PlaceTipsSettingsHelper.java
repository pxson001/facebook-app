package com.facebook.placetips.settings;

import android.os.Bundle;
import com.facebook.backgroundlocation.settings.write.BackgroundLocationUpdateSettingsParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.TimeConversions;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.FeedbackType;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.LocationData;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData.FeatureEnabled;
import com.facebook.graphql.calls.GravitySettingsForUserUpdateInputData.NotificationsEnabled;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentInterfaces.GravitySettingsGraphQlFragment;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsMutation.GravityNegativeFeedbackMutationString;
import com.facebook.placetips.settings.graphql.GravitySettingsMutation.GravitySettingsMutationString;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationModels.GravitySettingsMutationModel;
import com.facebook.placetips.settings.graphql.GravitySettingsQueryModels.GravitySettingsQueryModel;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: save_og_object */
public class PlaceTipsSettingsHelper {
    private static volatile PlaceTipsSettingsHelper f3915e;
    public final Lazy<FbErrorReporter> f3916a;
    public final Lazy<GraphQLQueryExecutor> f3917b;
    public final Lazy<Accessor> f3918c;
    private final Lazy<BlueServiceOperationFactory> f3919d;

    /* compiled from: save_og_object */
    public class C04931 implements AsyncFunction<GraphQLResult<GravitySettingsQueryModel>, GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsSettingsHelper f3911a;

        public C04931(PlaceTipsSettingsHelper placeTipsSettingsHelper) {
            this.f3911a = placeTipsSettingsHelper;
        }

        public final ListenableFuture m3884a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                throw new NullPointerException("result is null");
            }
            GravitySettingsQueryModel gravitySettingsQueryModel = (GravitySettingsQueryModel) graphQLResult.e;
            if (gravitySettingsQueryModel == null) {
                throw new NullPointerException("result.getResult is null");
            }
            GravitySettingsGraphQlFragmentModel a = gravitySettingsQueryModel.a();
            if (a != null) {
                return Futures.a(a);
            }
            throw new NullPointerException("result's gravity_settings is null");
        }
    }

    /* compiled from: save_og_object */
    public class C04942 implements FutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsSettingsHelper f3912a;

        public C04942(PlaceTipsSettingsHelper placeTipsSettingsHelper) {
            this.f3912a = placeTipsSettingsHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            ((Accessor) this.f3912a.f3918c.get()).a((GravitySettingsGraphQlFragmentModel) obj);
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f3912a.f3916a.get()).a("place_tips_settings_load", "Failed to load gravity settings", th);
        }
    }

    /* compiled from: save_og_object */
    class C04953 implements AsyncFunction<GraphQLResult<GravitySettingsMutationModel>, GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsSettingsHelper f3913a;

        C04953(PlaceTipsSettingsHelper placeTipsSettingsHelper) {
            this.f3913a = placeTipsSettingsHelper;
        }

        public final ListenableFuture m3885a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            Preconditions.checkNotNull(graphQLResult);
            Preconditions.checkNotNull(graphQLResult.e);
            Preconditions.checkNotNull(((GravitySettingsMutationModel) graphQLResult.e).m3910a());
            return Futures.a(((GravitySettingsMutationModel) graphQLResult.e).m3910a());
        }
    }

    /* compiled from: save_og_object */
    class C04964 implements FutureCallback<GravitySettingsGraphQlFragment> {
        final /* synthetic */ PlaceTipsSettingsHelper f3914a;

        C04964(PlaceTipsSettingsHelper placeTipsSettingsHelper) {
            this.f3914a = placeTipsSettingsHelper;
        }

        public void onSuccess(Object obj) {
            ((Accessor) this.f3914a.f3918c.get()).a((GravitySettingsGraphQlFragmentModel) obj);
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f3914a.f3916a.get()).a("place_tips_settings_update", "Failed to update gravity settings", th);
        }
    }

    public static com.facebook.placetips.settings.PlaceTipsSettingsHelper m3886a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3915e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.settings.PlaceTipsSettingsHelper.class;
        monitor-enter(r1);
        r0 = f3915e;	 Catch:{ all -> 0x003a }
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
        r0 = m3887b(r0);	 Catch:{ all -> 0x0035 }
        f3915e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3915e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.settings.PlaceTipsSettingsHelper.a(com.facebook.inject.InjectorLike):com.facebook.placetips.settings.PlaceTipsSettingsHelper");
    }

    private static PlaceTipsSettingsHelper m3887b(InjectorLike injectorLike) {
        return new PlaceTipsSettingsHelper(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 2164), IdBasedLazy.a(injectorLike, 3022), IdBasedLazy.a(injectorLike, 1144));
    }

    @Inject
    public PlaceTipsSettingsHelper(Lazy<FbErrorReporter> lazy, Lazy<GraphQLQueryExecutor> lazy2, Lazy<Accessor> lazy3, Lazy<BlueServiceOperationFactory> lazy4) {
        this.f3916a = lazy;
        this.f3917b = lazy2;
        this.f3918c = lazy3;
        this.f3919d = lazy4;
    }

    @Nullable
    public final String m3890a() {
        GravitySettingsGraphQlFragmentModel b = ((Accessor) this.f3918c.get()).b();
        if (b != null && !Strings.isNullOrEmpty(b.b())) {
            return b.b();
        }
        ((AbstractFbErrorReporter) this.f3916a.get()).a("place_tips_settings_helper", "Failed to get place tips learn more link");
        return null;
    }

    public final void m3891a(FeedbackType feedbackType, @Nullable PlaceTipsLocationData placeTipsLocationData, String str, long j) {
        if (placeTipsLocationData == null) {
            placeTipsLocationData = new PlaceTipsLocationData();
        }
        LocationData c = new LocationData().c(Integer.valueOf(placeTipsLocationData.f3904a));
        c.a("client_location_time", Integer.valueOf(placeTipsLocationData.f3905b));
        GraphQlCallInput graphQlCallInput = c;
        graphQlCallInput.a("horizontal_accuracy", Double.valueOf(placeTipsLocationData.f3906c));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("latitude", Double.valueOf(placeTipsLocationData.f3907d));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("longitude", Double.valueOf(placeTipsLocationData.f3908e));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("pulsar_rssi", Integer.valueOf(placeTipsLocationData.f3909f));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("vertical_accuracy", Double.valueOf(placeTipsLocationData.f3910g));
        LocationData locationData = graphQlCallInput;
        locationData.c(Integer.valueOf((int) TimeConversions.m(j)));
        GravityNegativeFeedbackInputData gravityNegativeFeedbackInputData = new GravityNegativeFeedbackInputData();
        gravityNegativeFeedbackInputData.a("feedback_type", feedbackType);
        GraphQlCallInput graphQlCallInput2 = gravityNegativeFeedbackInputData;
        graphQlCallInput2.a("location_data", locationData);
        GraphQlCallInput graphQlCallInput3 = graphQlCallInput2;
        graphQlCallInput3.a("page_id", str);
        ((GraphQLQueryExecutor) this.f3917b.get()).a(GraphQLRequest.a((GravityNegativeFeedbackMutationString) new GravityNegativeFeedbackMutationString().a("input", graphQlCallInput3)));
    }

    public final ListenableFuture<OperationResult> m3888a(CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BackgroundLocationUpdateSettingsParams", new BackgroundLocationUpdateSettingsParams(Optional.of(Boolean.valueOf(true)), Absent.INSTANCE));
        return BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f3919d.get(), "background_location_update_settings", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -864512140).a();
    }

    public final ListenableFuture<GravitySettingsGraphQlFragment> m3889a(@Nullable FeatureEnabled featureEnabled, @Nullable NotificationsEnabled notificationsEnabled) {
        if (featureEnabled == null && notificationsEnabled == null) {
            return Futures.a(new IllegalArgumentException("both parameters are null"));
        }
        GravitySettingsForUserUpdateInputData gravitySettingsForUserUpdateInputData = new GravitySettingsForUserUpdateInputData();
        if (notificationsEnabled != null) {
            gravitySettingsForUserUpdateInputData.a("notifications_enabled", notificationsEnabled);
        }
        if (featureEnabled != null) {
            gravitySettingsForUserUpdateInputData.a("feature_enabled", featureEnabled);
        }
        ListenableFuture<GravitySettingsGraphQlFragment> b = Futures.b(((GraphQLQueryExecutor) this.f3917b.get()).a(GraphQLRequest.a((GravitySettingsMutationString) new GravitySettingsMutationString().a("input", gravitySettingsForUserUpdateInputData))), new C04953(this), MoreExecutors.a());
        Futures.a(b, new C04964(this), MoreExecutors.a());
        return b;
    }
}

package com.facebook.backgroundlocation.reporting;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQL;
import com.facebook.backgroundlocation.reporting.graphql.BackgroundLocationReportingGraphQLModels.FetchBackgroundLocationReportingSettingsModel;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.FutureUtils;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ispx_impl */
public class BackgroundLocationReportingNewImplService extends FbIntentService {
    private static final Class<?> f9760e = BackgroundLocationReportingNewImplService.class;
    private static final CallerContext f9761f = CallerContext.b(BackgroundLocationReportingNewImplService.class, "background_location");
    @Inject
    public BackgroundLocationReportingNewImplWakeLockHolder f9762a;
    @Inject
    public GraphQLQueryExecutor f9763b;
    @Inject
    public DefaultBlueServiceOperationFactory f9764c;
    @Inject
    public Provider<FbLocationOperation> f9765d;

    private static <T extends Context> void m10171a(Class<T> cls, T t) {
        m10172a((Object) t, (Context) t);
    }

    public static void m10172a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BackgroundLocationReportingNewImplService backgroundLocationReportingNewImplService = (BackgroundLocationReportingNewImplService) obj;
        BackgroundLocationReportingNewImplWakeLockHolder a = BackgroundLocationReportingNewImplWakeLockHolder.m10183a(fbInjector);
        GraphQLQueryExecutor a2 = GraphQLQueryExecutor.a(fbInjector);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        Provider a3 = IdBasedProvider.a(fbInjector, 2481);
        backgroundLocationReportingNewImplService.f9762a = a;
        backgroundLocationReportingNewImplService.f9763b = a2;
        backgroundLocationReportingNewImplService.f9764c = b;
        backgroundLocationReportingNewImplService.f9765d = a3;
    }

    public static void m10167a(Context context, PendingIntent pendingIntent) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED");
        intent.putExtra("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED.callback", pendingIntent);
        m10168a(context, intent);
    }

    public static Optional<Boolean> m10173b(Intent intent) {
        if (intent.hasExtra("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED.result")) {
            return Optional.of(Boolean.valueOf(intent.getBooleanExtra("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED.result", false)));
        }
        return Absent.INSTANCE;
    }

    public static void m10170a(Context context, BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams, PendingIntent pendingIntent) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER");
        intent.putExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.params", backgroundLocationReportingUpdateParams);
        intent.putExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.callback", pendingIntent);
        m10168a(context, intent);
    }

    public static BackgroundLocationReportingUpdateParams m10174c(Intent intent) {
        return (BackgroundLocationReportingUpdateParams) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.params");
    }

    @Nullable
    public static BackgroundLocationReportingUpdateResult m10175d(Intent intent) {
        return (BackgroundLocationReportingUpdateResult) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.result");
    }

    public static void m10169a(Context context, BackgroundLocationReportingLocationRequestParams backgroundLocationReportingLocationRequestParams, PendingIntent pendingIntent) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION");
        intent.putExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.params", backgroundLocationReportingLocationRequestParams);
        intent.putExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.callback", pendingIntent);
        m10168a(context, intent);
    }

    public static BackgroundLocationReportingLocationRequestParams m10176e(Intent intent) {
        return (BackgroundLocationReportingLocationRequestParams) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.params");
    }

    @Nullable
    public static ImmutableLocation m10177f(Intent intent) {
        return (ImmutableLocation) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.result");
    }

    private static void m10168a(Context context, Intent intent) {
        FbInjector fbInjector = FbInjector.get(context);
        BackgroundLocationReportingNewImplWakeLockHolder a = BackgroundLocationReportingNewImplWakeLockHolder.m10183a(fbInjector);
        a.a.c();
        try {
            intent.setClass(context, BackgroundLocationReportingNewImplService.class);
            if (context.startService(intent) == null) {
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector)).a(f9760e.getSimpleName(), "could not start service");
            }
        } finally {
            a.a.d();
        }
    }

    public BackgroundLocationReportingNewImplService() {
        super(BackgroundLocationReportingNewImplService.class.getSimpleName());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1958566393);
        super.onCreate();
        Class cls = BackgroundLocationReportingNewImplService.class;
        m10172a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -140404184, a);
    }

    protected final void m10182a(Intent intent) {
        try {
            Object g = m10178g(intent);
            if (g != null) {
                this.f9762a.a.a(500);
            }
        } finally {
            this.f9762a.a.d();
        }
    }

    private boolean m10178g(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (action.equals("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED")) {
            return m10179h(intent);
        }
        if (action.equals("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER")) {
            return m10180i(intent);
        }
        if (action.equals("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION")) {
            return m10181j(intent);
        }
        throw new IllegalArgumentException("Unknown action: " + action);
    }

    private boolean m10179h(Intent intent) {
        GraphQLResult graphQLResult = null;
        try {
            graphQLResult = (GraphQLResult) FutureUtils.b(this.f9763b.a(GraphQLRequest.a(BackgroundLocationReportingGraphQL.m10199a())));
        } catch (ExecutionException e) {
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED.callback");
        Intent intent2 = new Intent();
        if (graphQLResult != null) {
            intent2.putExtra("BackgroundLocationReportingNewImplService.FETCH_IS_ENABLED.result", ((FetchBackgroundLocationReportingSettingsModel) graphQLResult.d()).m10201a().m11073a());
        }
        try {
            pendingIntent.send(this, 0, intent2);
            return true;
        } catch (CanceledException e2) {
            return false;
        }
    }

    private boolean m10180i(Intent intent) {
        BackgroundLocationReportingUpdateParams backgroundLocationReportingUpdateParams = (BackgroundLocationReportingUpdateParams) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.params");
        Bundle bundle = new Bundle();
        bundle.putParcelable("BackgroundLocationReportingUpdateParams", backgroundLocationReportingUpdateParams);
        OperationResult operationResult = null;
        try {
            operationResult = (OperationResult) FutureUtils.b(BlueServiceOperationFactoryDetour.a(this.f9764c, "background_location_update", bundle, ErrorPropagation.BY_EXCEPTION, f9761f, -965981464).c());
        } catch (ExecutionException e) {
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.callback");
        Intent intent2 = new Intent();
        intent2.putExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.params", backgroundLocationReportingUpdateParams);
        if (operationResult != null) {
            intent2.putExtra("BackgroundLocationReportingNewImplService.WRITE_TO_SERVER.result", (BackgroundLocationReportingUpdateResult) operationResult.h());
        }
        try {
            pendingIntent.send(this, 0, intent2);
            return true;
        } catch (CanceledException e2) {
            return false;
        }
    }

    private boolean m10181j(Intent intent) {
        BackgroundLocationReportingLocationRequestParams backgroundLocationReportingLocationRequestParams = (BackgroundLocationReportingLocationRequestParams) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.params");
        FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f9765d.get();
        fbLocationOperation.a(backgroundLocationReportingLocationRequestParams.c, f9761f);
        Parcelable parcelable = null;
        try {
            parcelable = (ImmutableLocation) FutureUtils.b(fbLocationOperation);
        } catch (ExecutionException e) {
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.callback");
        Intent intent2 = new Intent();
        intent2.putExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.params", backgroundLocationReportingLocationRequestParams);
        if (parcelable != null) {
            intent2.putExtra("BackgroundLocationReportingNewImplService.OBTAIN_SINGLE_LOCATION.result", parcelable);
        }
        try {
            pendingIntent.send(this, 0, intent2);
            return true;
        } catch (CanceledException e2) {
            return false;
        }
    }
}

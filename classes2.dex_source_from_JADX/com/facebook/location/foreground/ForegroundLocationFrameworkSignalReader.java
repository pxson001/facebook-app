package com.facebook.location.foreground;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FbFutures$3;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.hardware.TelephonyManagerUtils;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LocationUpdateInputData;
import com.facebook.graphql.calls.LocationUpdateInputData.AppUseState;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo;
import com.facebook.graphql.calls.LocationUpdateInputData.CellInfo.HasIccCard;
import com.facebook.graphql.calls.LocationUpdateInputData.LocationManagerInfo;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.C0664xc4defe1d;
import com.facebook.location.FbLocationManagerParams.Priority;
import com.facebook.location.FbLocationOperation;
import com.facebook.location.FbLocationOperationParams;
import com.facebook.location.LocationSignalDataPackage.GeneralCellInfo;
import com.facebook.location.LocationSignalPackage;
import com.facebook.location.LocationSignalPackage.Builder;
import com.facebook.location.foreground.ForegroundLocationFrameworkResultWriter.1;
import com.facebook.location.write.LocationMutationModelCreator;
import com.facebook.location.write.graphql.LocationMutations.LocationUpdateMutationString;
import com.facebook.wifiscan.ConnectedWifis;
import com.facebook.wifiscan.WifiScanOperation;
import com.facebook.wifiscan.WifiScanOperationParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: log_to_qe */
public class ForegroundLocationFrameworkSignalReader {
    public static final CallerContext f16214a = CallerContext.m9064b(ForegroundLocationFrameworkSignalReader.class, "foreground_location_framework");
    public final Context f16215b;
    public final Provider<FbLocationOperation> f16216c;
    public final Provider<WifiScanOperation> f16217d;
    public final ForegroundLocationFrameworkConfig f16218e;
    private final ForegroundLocationFrameworkResultWriter f16219f;
    public final ForegroundLocationFrameworkAnalyticsLogger f16220g;
    public final ForegroundLocationStatusBroadcaster f16221h;
    public final AbstractFbErrorReporter f16222i;
    private final ExecutorService f16223j;
    public final AppStateManager f16224k;
    private FbLocationOperationParams f16225l;
    private WifiScanOperationParams f16226m;
    public FutureAndCallbackHolder<List<Object>> f16227n;

    /* compiled from: log_to_qe */
    class C07701 extends AbstractDisposableFutureCallback<List<Object>> {
        final /* synthetic */ ForegroundLocationFrameworkSignalReader f19357a;

        C07701(ForegroundLocationFrameworkSignalReader foregroundLocationFrameworkSignalReader) {
            this.f19357a = foregroundLocationFrameworkSignalReader;
        }

        protected final void mo347a(Object obj) {
            List a;
            Builder b;
            WifiInfo wifiInfo;
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = list.get(1);
            if (ForegroundLocationFrameworkSignalReader.m23059b(this.f19357a.f16218e.m22184l())) {
                try {
                    a = CellInfos.a(this.f19357a.f16215b);
                } catch (CellTowerInfoNotAvailableException e) {
                }
                b = LocationSignalPackage.a().a(obj2).a(Boolean.valueOf(this.f19357a.f16224k.m2264l())).b(obj3);
                if (ForegroundLocationFrameworkSignalReader.m23059b(this.f19357a.f16218e.m22183k())) {
                    wifiInfo = null;
                } else {
                    wifiInfo = ConnectedWifis.a(this.f19357a.f16215b);
                }
                ForegroundLocationFrameworkSignalReader.m23057a(this.f19357a, b.a(wifiInfo).a(ForegroundLocationFrameworkSignalReader.m23060c(this.f19357a)).a(a).a());
                this.f19357a.f16227n = null;
            }
            a = null;
            b = LocationSignalPackage.a().a(obj2).a(Boolean.valueOf(this.f19357a.f16224k.m2264l())).b(obj3);
            if (ForegroundLocationFrameworkSignalReader.m23059b(this.f19357a.f16218e.m22183k())) {
                wifiInfo = null;
            } else {
                wifiInfo = ConnectedWifis.a(this.f19357a.f16215b);
            }
            ForegroundLocationFrameworkSignalReader.m23057a(this.f19357a, b.a(wifiInfo).a(ForegroundLocationFrameworkSignalReader.m23060c(this.f19357a)).a(a).a());
            this.f19357a.f16227n = null;
        }

        protected final void mo348a(Throwable th) {
            this.f19357a.f16222i.m2343a("foreground_location_framework", "Request future failed", th);
            this.f19357a.f16220g.m21733a(null);
            this.f19357a.f16227n = null;
            this.f19357a.f16221h.m23331c();
        }
    }

    public static ForegroundLocationFrameworkSignalReader m23058b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkSignalReader((Context) injectorLike.getInstance(Context.class), C0664xc4defe1d.m21716a(injectorLike), IdBasedProvider.m1811a(injectorLike, 2481), IdBasedProvider.m1811a(injectorLike, 3743), ForegroundLocationFrameworkConfig.m22169a(injectorLike), ForegroundLocationFrameworkResultWriter.m23081b(injectorLike), ForegroundLocationFrameworkAnalyticsLogger.m21719a(injectorLike), ForegroundLocationStatusBroadcaster.m23326a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AppStateManager.m2245a(injectorLike));
    }

    @Inject
    public ForegroundLocationFrameworkSignalReader(Context context, ListeningScheduledExecutorService listeningScheduledExecutorService, Provider<FbLocationOperation> provider, Provider<WifiScanOperation> provider2, ForegroundLocationFrameworkConfig foregroundLocationFrameworkConfig, ForegroundLocationFrameworkResultWriter foregroundLocationFrameworkResultWriter, ForegroundLocationFrameworkAnalyticsLogger foregroundLocationFrameworkAnalyticsLogger, ForegroundLocationStatusBroadcaster foregroundLocationStatusBroadcaster, FbErrorReporter fbErrorReporter, AppStateManager appStateManager) {
        this.f16215b = context;
        this.f16216c = provider;
        this.f16217d = provider2;
        this.f16218e = foregroundLocationFrameworkConfig;
        this.f16219f = foregroundLocationFrameworkResultWriter;
        this.f16220g = foregroundLocationFrameworkAnalyticsLogger;
        this.f16222i = fbErrorReporter;
        this.f16221h = foregroundLocationStatusBroadcaster;
        this.f16223j = listeningScheduledExecutorService;
        this.f16224k = appStateManager;
    }

    public final void m23063a() {
        ListenableFuture a;
        m23064b();
        this.f16220g.m21732a(m23061d(), m23062e());
        Object[] objArr = new ListenableFuture[2];
        FbLocationOperationParams d = m23061d();
        if (m23059b(this.f16218e.m22181i())) {
            FbLocationOperation fbLocationOperation = (FbLocationOperation) this.f16216c.get();
            fbLocationOperation.m24986a(d, f16214a);
        } else {
            a = Futures.m2453a(new ForegroundLocationSignalGatedOffException());
        }
        objArr[0] = a;
        WifiScanOperationParams e = m23062e();
        if (m23059b(this.f16218e.m22182j())) {
            WifiScanOperation wifiScanOperation = (WifiScanOperation) this.f16217d.get();
            wifiScanOperation.m26786a(e);
        } else {
            a = Futures.m2453a(new ForegroundLocationSignalGatedOffException());
        }
        objArr[1] = a;
        ListenableFuture a2 = Futures.m2451a(Iterables.m945a(Lists.m1300a(objArr), new FbFutures$3()));
        this.f16227n = FutureAndCallbackHolder.m20344a(a2, new C07701(this));
        Futures.m2458a(a2, (FutureCallback) this.f16227n.f14026b, this.f16223j);
    }

    @Nullable
    public static GeneralCellInfo m23060c(ForegroundLocationFrameworkSignalReader foregroundLocationFrameworkSignalReader) {
        TelephonyManager telephonyManager = (TelephonyManager) foregroundLocationFrameworkSignalReader.f16215b.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return new GeneralCellInfo(TelephonyManagerUtils.m27408b(telephonyManager.getPhoneType()), telephonyManager.getSimCountryIso(), telephonyManager.getSimOperator(), telephonyManager.getSimOperatorName(), telephonyManager.hasIccCard());
    }

    public final void m23064b() {
        if (this.f16227n != null) {
            this.f16227n.m20346a(false);
            this.f16227n = null;
            ForegroundLocationFrameworkAnalyticsLogger foregroundLocationFrameworkAnalyticsLogger = this.f16220g;
            foregroundLocationFrameworkAnalyticsLogger.f15202g = Long.MIN_VALUE;
            foregroundLocationFrameworkAnalyticsLogger.f15201f = Long.MIN_VALUE;
        }
        this.f16219f.m23082a();
    }

    public static void m23057a(ForegroundLocationFrameworkSignalReader foregroundLocationFrameworkSignalReader, LocationSignalPackage locationSignalPackage) {
        if (locationSignalPackage.a.a == null) {
            foregroundLocationFrameworkSignalReader.f16220g.m21733a(locationSignalPackage);
            foregroundLocationFrameworkSignalReader.f16221h.m23331c();
            return;
        }
        Enum enumR;
        GraphQlCallInput wifiInfo;
        foregroundLocationFrameworkSignalReader.f16220g.m21736b(locationSignalPackage);
        ForegroundLocationFrameworkResultWriter foregroundLocationFrameworkResultWriter = foregroundLocationFrameworkSignalReader.f16219f;
        foregroundLocationFrameworkResultWriter.m23082a();
        foregroundLocationFrameworkResultWriter.f16262d.m21737c();
        TypedGraphQLMutationString locationUpdateMutationString = new LocationUpdateMutationString();
        String str = "input";
        LocationUpdateInputData locationUpdateInputData = new LocationUpdateInputData();
        if (locationSignalPackage.a.b != null) {
            if (locationSignalPackage.a.b.booleanValue()) {
                enumR = AppUseState.FOREGROUND;
            } else {
                enumR = AppUseState.BACKGROUND;
            }
            locationUpdateInputData.m11395a("app_use_state", enumR);
        }
        locationUpdateInputData.m11397a("device_id", foregroundLocationFrameworkResultWriter.f16263e.f16469c.m4346a());
        if (locationSignalPackage.a.a != null) {
            LocationMutationModelCreator locationMutationModelCreator = foregroundLocationFrameworkResultWriter.f16263e;
            Preconditions.checkNotNull(locationSignalPackage.a.a);
            LocationManagerInfo locationManagerInfo = new LocationManagerInfo();
            String str2 = "locations";
            locationManagerInfo.m11398a(str2, Lists.m1300a(locationMutationModelCreator.f16472f.m23325a(r6)));
            locationUpdateInputData.m11393a("location_manager_info", (GraphQlCallInput) locationManagerInfo);
        }
        if (!(locationSignalPackage.a.d == null && locationSignalPackage.a.c == null)) {
            wifiInfo = new LocationUpdateInputData.WifiInfo();
            if (locationSignalPackage.a.d != null) {
                wifiInfo.m11398a("scan_results", foregroundLocationFrameworkResultWriter.f16263e.m23324a(locationSignalPackage.a.d));
            }
            if (locationSignalPackage.a.c != null) {
                wifiInfo.m11393a("connected", foregroundLocationFrameworkResultWriter.f16263e.m23323a(locationSignalPackage.a.c));
            }
            locationUpdateInputData.m11393a("wifi_info", wifiInfo);
        }
        if (!(locationSignalPackage.a.e == null && locationSignalPackage.a.f == null)) {
            GraphQlCallInput cellInfo = new CellInfo();
            if (locationSignalPackage.a.e != null) {
                cellInfo.m11397a("phone_type", locationSignalPackage.a.e.a);
                wifiInfo = cellInfo;
                wifiInfo.m11397a("sim_country_iso", locationSignalPackage.a.e.b);
                wifiInfo = wifiInfo;
                wifiInfo.m11397a("sim_operator_mcc_mnc", locationSignalPackage.a.e.c);
                wifiInfo = wifiInfo;
                wifiInfo.m11397a("sim_operator_name", locationSignalPackage.a.e.d);
                GraphQlCallInput graphQlCallInput = wifiInfo;
                if (locationSignalPackage.a.e.e) {
                    enumR = HasIccCard.TRUE;
                } else {
                    enumR = HasIccCard.FALSE;
                }
                graphQlCallInput.m11395a("has_icc_card", enumR);
            }
            if (locationSignalPackage.a.f != null) {
                locationMutationModelCreator = foregroundLocationFrameworkResultWriter.f16263e;
                List list = locationSignalPackage.a.f;
                Preconditions.checkNotNull(list);
                cellInfo.m11398a("scan_results", Lists.m1303a(list, locationMutationModelCreator.f16475i));
                List a = CellInfos.a(locationSignalPackage.a.f);
                if (a != null) {
                    LocationMutationModelCreator locationMutationModelCreator2 = foregroundLocationFrameworkResultWriter.f16263e;
                    Preconditions.checkNotNull(a);
                    cellInfo.m11398a("connected", Lists.m1303a(a, locationMutationModelCreator2.f16474h));
                }
            }
            locationUpdateInputData.m11393a("cell_info", cellInfo);
        }
        locationUpdateMutationString.m11310a(str, (GraphQlCallInput) locationUpdateInputData);
        ListenableFuture a2 = foregroundLocationFrameworkResultWriter.f16260b.m10448a(GraphQLRequest.m11588a(locationUpdateMutationString));
        foregroundLocationFrameworkResultWriter.f16265g = FutureAndCallbackHolder.m20344a(a2, new 1(foregroundLocationFrameworkResultWriter));
        Futures.m2458a(a2, (FutureCallback) foregroundLocationFrameworkResultWriter.f16265g.f14026b, foregroundLocationFrameworkResultWriter.f16264f);
        foregroundLocationFrameworkSignalReader.f16221h.m23329a();
    }

    private FbLocationOperationParams m23061d() {
        if (this.f16225l == null) {
            FbLocationOperationParams.Builder c = FbLocationOperationParams.m23332a(Priority.BALANCED_POWER_AND_ACCURACY).m23334c(this.f16218e.m22173a());
            c.f16491b = this.f16218e.m22174b();
            c = c;
            c.f16492c = this.f16218e.m22175c();
            c = c;
            c.f16493d = this.f16218e.m22177e();
            this.f16225l = c.m23333a();
        }
        return this.f16225l;
    }

    private WifiScanOperationParams m23062e() {
        if (this.f16226m == null) {
            this.f16226m = new WifiScanOperationParams(this.f16218e.m22177e(), this.f16218e.m22173a());
        }
        return this.f16226m;
    }

    public static boolean m23059b(ForegroundLocationFrameworkSignalScenario foregroundLocationFrameworkSignalScenario) {
        return foregroundLocationFrameworkSignalScenario == ForegroundLocationFrameworkSignalScenario.MEDIUM_POWER || foregroundLocationFrameworkSignalScenario == ForegroundLocationFrameworkSignalScenario.LOW_POWER;
    }
}

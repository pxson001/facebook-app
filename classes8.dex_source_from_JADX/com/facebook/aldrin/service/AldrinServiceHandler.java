package com.facebook.aldrin.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.aldrin.graphql.AldrinGraphQL;
import com.facebook.aldrin.graphql.AldrinGraphQL.RegionTosRespondMutationString;
import com.facebook.aldrin.graphql.AldrinGraphQLModels.RegionTosRespondMutationModel;
import com.facebook.aldrin.graphql.AldrinGraphQLModels.RegionTosStatusFragmentModel;
import com.facebook.aldrin.prefs.AldrinPrefKeys;
import com.facebook.aldrin.protocol.FetchAldrinLoggedOutStatusMethod;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.AldrinUserStatusBuilder;
import com.facebook.aldrin.status.AldrinUserStatusManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.RegionTosRespondInputData;
import com.facebook.graphql.calls.RegionTosRespondInputData.RegionCode;
import com.facebook.graphql.calls.RegionTosRespondInputData.ResponseAction;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: left_margin */
public class AldrinServiceHandler implements BlueServiceHandler {
    private static AldrinServiceHandler f10356g;
    private static final Object f10357h = new Object();
    private final FbSharedPreferences f10358a;
    private final Provider<SingleMethodRunner> f10359b;
    private final GraphQLQueryExecutor f10360c;
    private final Clock f10361d;
    private final Lazy<FetchAldrinLoggedOutStatusMethod> f10362e;
    private final AldrinUserStatusManager f10363f;

    private static AldrinServiceHandler m12169b(InjectorLike injectorLike) {
        return new AldrinServiceHandler((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), GraphQLQueryExecutor.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 4766), AldrinUserStatusManager.a(injectorLike));
    }

    public final OperationResult m12174a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_aldrin_logged_out_status".equalsIgnoreCase(str)) {
            return m12170b(operationParams);
        }
        if ("fetch_region_tos_status".equalsIgnoreCase(str)) {
            return m12172c(operationParams);
        }
        if ("respond_to_region_tos".equalsIgnoreCase(str)) {
            return m12173d(operationParams);
        }
        throw new RuntimeException("Unknown operation type: " + str);
    }

    @Inject
    public AldrinServiceHandler(FbSharedPreferences fbSharedPreferences, Provider<SingleMethodRunner> provider, GraphQLQueryExecutor graphQLQueryExecutor, Clock clock, Lazy<FetchAldrinLoggedOutStatusMethod> lazy, AldrinUserStatusManager aldrinUserStatusManager) {
        this.f10358a = fbSharedPreferences;
        this.f10359b = provider;
        this.f10360c = graphQLQueryExecutor;
        this.f10361d = clock;
        this.f10362e = lazy;
        this.f10363f = aldrinUserStatusManager;
    }

    public static AldrinServiceHandler m12166a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AldrinServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10357h) {
                AldrinServiceHandler aldrinServiceHandler;
                if (a2 != null) {
                    aldrinServiceHandler = (AldrinServiceHandler) a2.a(f10357h);
                } else {
                    aldrinServiceHandler = f10356g;
                }
                if (aldrinServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12169b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10357h, b3);
                        } else {
                            f10356g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = aldrinServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m12170b(OperationParams operationParams) {
        try {
            AldrinUserStatus aldrinUserStatus = (AldrinUserStatus) ((AbstractSingleMethodRunner) this.f10359b.get()).a((ApiMethod) this.f10362e.get(), null, operationParams.f());
            this.f10363f.a(aldrinUserStatus);
            this.f10363f.c();
            m12168a();
            return OperationResult.a(aldrinUserStatus);
        } catch (Throwable e) {
            m12171b();
            BLog.b(AldrinServiceHandler.class, "Error fetching Aldrin logged-out settings", e);
            return OperationResult.a(ErrorCodeUtil.a(e));
        }
    }

    private OperationResult m12172c(OperationParams operationParams) {
        Bundle b = operationParams.b();
        try {
            RegionTosStatusFragmentModel regionTosStatusFragmentModel;
            GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(this.f10360c.a(GraphQLRequest.a(AldrinGraphQL.m12130a()).a(operationParams.f()).a(GraphQLCachePolicy.c).a(600)), -1643020416);
            if (graphQLResult == null || graphQLResult.d() == null) {
                regionTosStatusFragmentModel = null;
            } else {
                regionTosStatusFragmentModel = (RegionTosStatusFragmentModel) graphQLResult.d();
            }
            return m12167a(b, regionTosStatusFragmentModel);
        } catch (Throwable e) {
            m12171b();
            return OperationResult.a(ErrorCodeUtil.a(e));
        } catch (Throwable e2) {
            m12171b();
            return OperationResult.a(ErrorCodeUtil.a(e2));
        }
    }

    private OperationResult m12173d(OperationParams operationParams) {
        Bundle b = operationParams.b();
        RegionTosRespondInputData regionTosRespondInputData = new RegionTosRespondInputData();
        regionTosRespondInputData.a(RegionCode.valueOf(b.getString("region_code")));
        regionTosRespondInputData.a(ResponseAction.valueOf(b.getString("response_action")));
        regionTosRespondInputData.a(b.getString("response_version"));
        RegionTosRespondMutationString b2 = AldrinGraphQL.m12131b();
        b2.a("0", regionTosRespondInputData);
        try {
            RegionTosStatusFragmentModel regionTosStatusFragmentModel;
            GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(this.f10360c.a(GraphQLRequest.a(b2)), 95694569);
            if (graphQLResult == null || graphQLResult.d() == null) {
                regionTosStatusFragmentModel = null;
            } else {
                regionTosStatusFragmentModel = ((RegionTosRespondMutationModel) graphQLResult.d()).m12135a();
            }
            return m12167a(b, regionTosStatusFragmentModel);
        } catch (Throwable e) {
            m12171b();
            return OperationResult.a(ErrorCodeUtil.a(e));
        } catch (Throwable e2) {
            m12171b();
            return OperationResult.a(ErrorCodeUtil.a(e2));
        }
    }

    private OperationResult m12167a(Bundle bundle, RegionTosStatusFragmentModel regionTosStatusFragmentModel) {
        AldrinUserStatusBuilder aldrinUserStatusBuilder = new AldrinUserStatusBuilder();
        aldrinUserStatusBuilder.f10384k = bundle.getString("user_id");
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder.f10383j = this.f10361d.a();
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        if (regionTosStatusFragmentModel != null) {
            aldrinUserStatusBuilder.f10374a = regionTosStatusFragmentModel.m12151j();
            AldrinUserStatusBuilder aldrinUserStatusBuilder2 = aldrinUserStatusBuilder;
            aldrinUserStatusBuilder2.f10375b = regionTosStatusFragmentModel.m12149a();
            aldrinUserStatusBuilder2.f10376c = regionTosStatusFragmentModel.m12152k();
        }
        AldrinUserStatus l = aldrinUserStatusBuilder.m12181l();
        this.f10363f.a(l);
        this.f10363f.c();
        m12168a();
        return OperationResult.a(l);
    }

    private void m12168a() {
        this.f10358a.edit().a(AldrinPrefKeys.f10343a, this.f10361d.a()).a(AldrinPrefKeys.f10345c).a(AldrinPrefKeys.f10344b).commit();
    }

    private void m12171b() {
        this.f10358a.edit().a(AldrinPrefKeys.f10344b, this.f10361d.a()).a(AldrinPrefKeys.f10343a).commit();
    }
}

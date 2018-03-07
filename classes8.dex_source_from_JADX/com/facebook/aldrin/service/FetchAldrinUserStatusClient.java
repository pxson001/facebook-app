package com.facebook.aldrin.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.RegionTosResponseAction;
import com.facebook.aldrin.transition.AldrinTransitionLauncher;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: left_flush */
public class FetchAldrinUserStatusClient {
    public final Context f10369a;
    private final DefaultBlueServiceOperationFactory f10370b;
    private final ExecutorService f10371c;
    private final Provider<User> f10372d;
    public final Lazy<AldrinTransitionLauncher> f10373e;

    /* compiled from: left_flush */
    class C11022 implements Function<OperationResult, AldrinUserStatus> {
        final /* synthetic */ FetchAldrinUserStatusClient f10366a;

        C11022(FetchAldrinUserStatusClient fetchAldrinUserStatusClient) {
            this.f10366a = fetchAldrinUserStatusClient;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null) {
                return (AldrinUserStatus) operationResult.k();
            }
            return null;
        }
    }

    /* compiled from: left_flush */
    class C11033 implements Function<OperationResult, AldrinUserStatus> {
        final /* synthetic */ FetchAldrinUserStatusClient f10367a;

        C11033(FetchAldrinUserStatusClient fetchAldrinUserStatusClient) {
            this.f10367a = fetchAldrinUserStatusClient;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null) {
                return (AldrinUserStatus) operationResult.k();
            }
            return null;
        }
    }

    /* compiled from: left_flush */
    /* synthetic */ class C11044 {
        static final /* synthetic */ int[] f10368a = new int[GraphQLTosTransitionTypeEnum.values().length];

        static {
            try {
                f10368a[GraphQLTosTransitionTypeEnum.IMPLICIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10368a[GraphQLTosTransitionTypeEnum.EXPLICIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10368a[GraphQLTosTransitionTypeEnum.EXPLICIT_FROM_BLOCKING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10368a[GraphQLTosTransitionTypeEnum.NOOP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static FetchAldrinUserStatusClient m12176b(InjectorLike injectorLike) {
        return new FetchAldrinUserStatusClient((Context) injectorLike.getInstance(Context.class, ForAppContext.class), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4769), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    @Inject
    public FetchAldrinUserStatusClient(@ForAppContext Context context, BlueServiceOperationFactory blueServiceOperationFactory, Lazy<AldrinTransitionLauncher> lazy, ExecutorService executorService, Provider<User> provider) {
        this.f10369a = context;
        this.f10370b = blueServiceOperationFactory;
        this.f10373e = lazy;
        this.f10371c = executorService;
        this.f10372d = provider;
    }

    public final ListenableFuture<AldrinUserStatus> m12179a(@Nullable CallerContext callerContext) {
        if (this.f10372d.get() == null) {
            return m12177b(callerContext);
        }
        return m12178c(callerContext);
    }

    private ListenableFuture<AldrinUserStatus> m12177b(@Nullable CallerContext callerContext) {
        return m12175a("fetch_aldrin_logged_out_status", new Bundle(), callerContext);
    }

    private ListenableFuture<AldrinUserStatus> m12178c(@Nullable final CallerContext callerContext) {
        Bundle bundle = new Bundle();
        User user = (User) this.f10372d.get();
        Preconditions.checkNotNull(user);
        bundle.putString("user_id", user.a);
        ListenableFuture<AldrinUserStatus> a = m12175a("fetch_region_tos_status", bundle, callerContext);
        Futures.a(a, new FutureCallback<AldrinUserStatus>(this) {
            final /* synthetic */ FetchAldrinUserStatusClient f10365b;

            public void onSuccess(@Nullable Object obj) {
                AldrinUserStatus aldrinUserStatus = (AldrinUserStatus) obj;
                if (aldrinUserStatus != null && aldrinUserStatus.tosTransitionType != null) {
                    switch (C11044.f10368a[aldrinUserStatus.tosTransitionType.ordinal()]) {
                        case 1:
                            GraphQLTosRegionCodeEnum graphQLTosRegionCodeEnum = aldrinUserStatus.currentRegion;
                            if (graphQLTosRegionCodeEnum == null) {
                                return;
                            }
                            if (graphQLTosRegionCodeEnum == GraphQLTosRegionCodeEnum.GENERAL || graphQLTosRegionCodeEnum == GraphQLTosRegionCodeEnum.ALDRIN) {
                                this.f10365b.m12180a(callerContext, graphQLTosRegionCodeEnum, RegionTosResponseAction.AGREED_IMPLICIT, aldrinUserStatus.tosVersion);
                                return;
                            }
                            return;
                        case 2:
                        case 3:
                            ((AldrinTransitionLauncher) this.f10365b.f10373e.get()).m12190a(this.f10365b.f10369a);
                            return;
                        default:
                            return;
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f10371c);
        return a;
    }

    private ListenableFuture<AldrinUserStatus> m12175a(String str, Bundle bundle, @Nullable CallerContext callerContext) {
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f10370b, str, bundle, ErrorPropagation.BY_ERROR_CODE, callerContext, 66666984).a(), new C11022(this), this.f10371c);
    }

    public final ListenableFuture<AldrinUserStatus> m12180a(@Nullable CallerContext callerContext, GraphQLTosRegionCodeEnum graphQLTosRegionCodeEnum, RegionTosResponseAction regionTosResponseAction, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("region_code", graphQLTosRegionCodeEnum.name());
        bundle.putString("response_action", regionTosResponseAction.name());
        bundle.putString("response_version", str);
        User user = (User) this.f10372d.get();
        Preconditions.checkNotNull(user);
        bundle.putString("user_id", user.a);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f10370b, "respond_to_region_tos", bundle, ErrorPropagation.BY_ERROR_CODE, callerContext, 1284360100).a(), new C11033(this), this.f10371c);
    }
}

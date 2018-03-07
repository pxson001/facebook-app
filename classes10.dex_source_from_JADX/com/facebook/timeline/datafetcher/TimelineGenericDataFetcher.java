package com.facebook.timeline.datafetcher;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.LegacyConsistencyBridge;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.protocol.FetchParcelableResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groupInformation or groupId is null in changeGroupSubscriptionStatus */
public class TimelineGenericDataFetcher {
    private static final Class<?> f10506a = TimelineGenericDataFetcher.class;
    private final Context f10507b;
    public final ProfileViewerContext f10508c;
    @Nullable
    private final CallerContext f10509d;
    private final Provider<AppChoreographer> f10510e;
    public final Lazy<BlueServiceOperationFactory> f10511f;
    private final LegacyConsistencyBridge f10512g;
    public final Set<ListenableFuture<?>> f10513h = new HashSet();
    private final Executor f10514i;
    public State f10515j = State.VISIBLE;

    /* compiled from: groupInformation or groupId is null in changeGroupSubscriptionStatus */
    public enum State {
        VISIBLE,
        PAUSED,
        CANCELLED,
        REFRESH_ON_RESUME
    }

    public static String m10594a(ServiceException serviceException) {
        Bundle bundle = serviceException.result.d;
        if (bundle != null) {
            String str = (String) bundle.get("originalExceptionStack");
            if (!(str == null || StringUtil.a(str))) {
                String[] split = str.split("\\n", 2);
                if (split.length > 0) {
                    return split[0].trim();
                }
            }
            str = (String) bundle.get("originalExceptionMessage");
            if (!(str == null || StringUtil.a(str))) {
                return str;
            }
        }
        return serviceException.getMessage();
    }

    @Inject
    public TimelineGenericDataFetcher(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, @Nullable @Assisted CallerContext callerContext, Provider<AppChoreographer> provider, Lazy<BlueServiceOperationFactory> lazy, LegacyConsistencyBridge legacyConsistencyBridge, Executor executor) {
        this.f10507b = context;
        this.f10508c = profileViewerContext;
        this.f10509d = callerContext;
        this.f10510e = provider;
        this.f10511f = lazy;
        this.f10512g = legacyConsistencyBridge;
        this.f10514i = executor;
    }

    public final void m10597a() {
        Iterator it = this.f10513h.iterator();
        List<ListenableFuture> arrayList = new ArrayList();
        while (it.hasNext()) {
            ListenableFuture listenableFuture = (ListenableFuture) it.next();
            it.remove();
            arrayList.add(listenableFuture);
        }
        for (ListenableFuture listenableFuture2 : arrayList) {
            listenableFuture2.cancel(true);
        }
    }

    public static void m10596a(TimelineGenericDataFetcher timelineGenericDataFetcher, int i, String str, Throwable th) {
        if (!BuildConstants.i) {
            return;
        }
        if (th instanceof ServiceException) {
            m10595a(timelineGenericDataFetcher, i, str, m10594a((ServiceException) th));
            if (((ServiceException) th).errorCode == ErrorCode.OUT_OF_MEMORY) {
                throw new OutOfMemoryError("Intentional timeline out of memory crash");
            }
            return;
        }
        m10595a(timelineGenericDataFetcher, i, str, th.getMessage());
    }

    public final void m10598a(Parcelable parcelable, final String str, final int i, GraphQLVisitableModel graphQLVisitableModel, FutureCallback<OperationResult> futureCallback) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("operationParams", parcelable);
        bundle.putLong("profileId", Long.parseLong(this.f10508c.a));
        final ListenableFuture a = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f10511f.get(), str, bundle, this.f10509d, 1934149396).a();
        this.f10512g.a(a, graphQLVisitableModel);
        Futures.a(a, futureCallback, this.f10514i);
        this.f10513h.add(a);
        Futures.a(a, new OperationResultFutureCallback(this) {
            final /* synthetic */ TimelineGenericDataFetcher f10502d;

            public final void m10591a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f10502d.f10513h.remove(a);
                if (operationResult.k() instanceof FetchParcelableResult) {
                    FetchParcelableResult fetchParcelableResult = (FetchParcelableResult) operationResult.k();
                    if (fetchParcelableResult.c != null) {
                        TimelineGenericDataFetcher.m10595a(this.f10502d, i, str, fetchParcelableResult.c);
                    }
                }
            }

            public final void m10590a(ServiceException serviceException) {
                this.f10502d.f10513h.remove(a);
                TimelineGenericDataFetcher.m10596a(this.f10502d, i, str, (Throwable) serviceException);
            }
        }, this.f10514i);
    }

    public final <T> void m10599a(final GraphQLQueryFuture<T> graphQLQueryFuture, final String str) {
        ((DefaultAppChoreographer) this.f10510e.get()).a(graphQLQueryFuture);
        this.f10513h.add(graphQLQueryFuture);
        Futures.a(graphQLQueryFuture, new AbstractDisposableFutureCallback<T>(this) {
            final /* synthetic */ TimelineGenericDataFetcher f10505c;

            protected final void m10592a(T t) {
                this.f10505c.f10513h.remove(graphQLQueryFuture);
            }

            protected final void m10593a(Throwable th) {
                this.f10505c.f10513h.remove(graphQLQueryFuture);
                TimelineGenericDataFetcher.m10596a(this.f10505c, 2131234935, str, th);
            }
        }, this.f10514i);
    }

    public final boolean m10600b() {
        return !this.f10513h.isEmpty();
    }

    public static void m10595a(TimelineGenericDataFetcher timelineGenericDataFetcher, int i, String str, String str2) {
        if (timelineGenericDataFetcher.f10515j == State.VISIBLE) {
            if (BuildConstants.i) {
                String str3 = timelineGenericDataFetcher.f10507b.getString(i) + " : " + str2;
                if (i == 2131234935) {
                    str3 = str3 + " in " + str;
                }
                BLog.b(f10506a, "TimelineDataFetcher: %s", new Object[]{str3});
            } else if (i != 2131234935) {
                Toast.makeText(timelineGenericDataFetcher.f10507b, i, 1).show();
            }
        }
    }
}

package com.facebook.notifications.protocol;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker;
import com.facebook.notifications.server.FetchNotificationSeenStatesParams;
import com.facebook.notifications.server.GetNotificationsSettingsParams;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.facebook.notifications.server.NotificationsChangeSettingsParams;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messenger_media_upload_request_canceled */
public class NotificationsServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f7954a;
    public final Lazy<NotificationsChangeSettingsMethod> f7955b;
    private final Lazy<FetchGraphQLNotificationsMethod> f7956c;
    private final Lazy<GraphNotificationsChangeSeenStateMethod> f7957d;
    public final Lazy<GetNotificationsSettingsMethod> f7958e;
    private final Lazy<FetchNotificationSeenStatesMethod> f7959f;
    public final Lazy<FetchJewelCountsMethod> f7960g;
    public final Lazy<FetchNotificationURIMethod> f7961h;
    public final Provider<FolderCountsDebugDataTracker> f7962i;

    public static NotificationsServiceHandler m8286b(InjectorLike injectorLike) {
        return new NotificationsServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 8713), IdBasedLazy.a(injectorLike, 2815), IdBasedLazy.a(injectorLike, 8711), IdBasedLazy.a(injectorLike, 8712), IdBasedLazy.a(injectorLike, 2817), IdBasedLazy.a(injectorLike, 2816), IdBasedLazy.a(injectorLike, 8710), IdBasedProvider.a(injectorLike, 2558));
    }

    @Inject
    public NotificationsServiceHandler(Provider<SingleMethodRunner> provider, Lazy<NotificationsChangeSettingsMethod> lazy, Lazy<FetchGraphQLNotificationsMethod> lazy2, Lazy<GetNotificationsSettingsMethod> lazy3, Lazy<GraphNotificationsChangeSeenStateMethod> lazy4, Lazy<FetchNotificationSeenStatesMethod> lazy5, Lazy<FetchJewelCountsMethod> lazy6, Lazy<FetchNotificationURIMethod> lazy7, Provider<FolderCountsDebugDataTracker> provider2) {
        this.f7954a = provider;
        this.f7955b = lazy;
        this.f7956c = lazy2;
        this.f7957d = lazy4;
        this.f7958e = lazy3;
        this.f7959f = lazy5;
        this.f7960g = lazy6;
        this.f7961h = lazy7;
        this.f7962i = provider2;
    }

    public final OperationResult m8290a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("notifChangeSetting".equals(str)) {
            ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7955b.get(), (NotificationsChangeSettingsParams) operationParams.c.getParcelable("notificationsChangeSettingsParams"));
            return OperationResult.a;
        } else if ("fetch_gql_notifications".equals(str)) {
            return m8287c(operationParams);
        } else {
            if ("force_fetch_gql_notifications_from_server".equals(str)) {
                return m8287c(operationParams);
            }
            if ("graphNotifUpdateSeenState".equals(str)) {
                return m8288d(operationParams);
            }
            if ("graphNotifUpdateSeenStateOnlyOnServer".equals(str)) {
                return m8288d(operationParams);
            }
            if ("getNotificationsSettings".equals(str)) {
                return OperationResult.a((GetNotificationsSettingsResult) ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7958e.get(), (GetNotificationsSettingsParams) operationParams.c.getParcelable("notificationsGetSettingsParams"), operationParams.e));
            } else if ("fecthNotificationSeenStates".equals(str)) {
                return m8289f(operationParams);
            } else {
                if ("fetchNotificationSeenStatesServerOnly".equals(str)) {
                    return m8289f(operationParams);
                }
                if ("fetchJewelCount".equals(str)) {
                    FetchJewelCountsResult fetchJewelCountsResult = (FetchJewelCountsResult) ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7960g.get(), null);
                    ((FolderCountsDebugDataTracker) this.f7962i.get()).m10062b(fetchJewelCountsResult.m10001c(), fetchJewelCountsResult.m10000b(), fetchJewelCountsResult.m10002d());
                    return OperationResult.a(fetchJewelCountsResult);
                } else if ("fetchNotificationURI".equals(str)) {
                    return OperationResult.a((FetchNotificationURIResult) ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7961h.get(), operationParams.c.getString("url")));
                } else {
                    throw new Exception("Unknown operation type");
                }
            }
        }
    }

    private OperationResult m8287c(OperationParams operationParams) {
        return OperationResult.a((FetchGraphQLNotificationsResult) ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7956c.get(), (FetchGraphQLNotificationsParams) operationParams.c.getParcelable("fetchGraphQLNotificationsParams"), operationParams.e));
    }

    private OperationResult m8288d(OperationParams operationParams) {
        ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7957d.get(), (NotificationsChangeSeenStateParams) operationParams.c.getParcelable("graphNotifsUpdateSeenStatePrams"), operationParams.e);
        return OperationResult.a;
    }

    private OperationResult m8289f(OperationParams operationParams) {
        return OperationResult.a((FetchNotificationSeenStatesResult) ((AbstractSingleMethodRunner) this.f7954a.get()).a((ApiMethod) this.f7959f.get(), (FetchNotificationSeenStatesParams) operationParams.c.getParcelable("notificationsFetchSeenStatesParams")));
    }
}

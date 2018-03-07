package com.facebook.notifications.provider;

import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.model.NotificationSeenStates.NotificationSeenState;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationSeenStatesResult;
import com.facebook.notifications.server.NotificationsChangeSeenStateParams;
import com.facebook.notifications.util.NotificationsLastUpdatedUtil;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap$Builder;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: messenger_media_upload_request_finished */
public class GraphQLNotificationsContentProviderHandler implements BlueServiceHandler$Filter {
    public final GraphQLNotificationsContentProviderHelper f7952a;
    public final NotificationsLastUpdatedUtil f7953b;

    public static GraphQLNotificationsContentProviderHandler m8282b(InjectorLike injectorLike) {
        return new GraphQLNotificationsContentProviderHandler(GraphQLNotificationsContentProviderHelper.m7861a(injectorLike), NotificationsLastUpdatedUtil.m7923b(injectorLike));
    }

    @Inject
    public GraphQLNotificationsContentProviderHandler(GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationsLastUpdatedUtil notificationsLastUpdatedUtil) {
        this.f7952a = graphQLNotificationsContentProviderHelper;
        this.f7953b = notificationsLastUpdatedUtil;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        if (str.equals("fetch_gql_notifications")) {
            Object obj;
            OperationResult a;
            OperationResult a2;
            int b;
            FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams) operationParams.c.getParcelable("fetchGraphQLNotificationsParams");
            int b2 = this.f7952a.m7904b(fetchGraphQLNotificationsParams.m8042f());
            Editor edit = this.f7953b.f7614a.edit();
            edit.a(NotificationsPreferenceConstants.f7727d, b2);
            edit.commit();
            if (DataFreshnessParam.STALE_DATA_OKAY != fetchGraphQLNotificationsParams.f7674a || fetchGraphQLNotificationsParams.f7685l >= b2) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                BaseResult baseResult;
                if (!fetchGraphQLNotificationsParams.f7683j || this.f7952a.m7919e(fetchGraphQLNotificationsParams.m8042f()).size() <= fetchGraphQLNotificationsParams.f7676c) {
                    baseResult = null;
                } else {
                    baseResult = this.f7952a.m7907b(fetchGraphQLNotificationsParams);
                }
                if (baseResult == null) {
                    baseResult = this.f7952a.m7895a(fetchGraphQLNotificationsParams);
                }
                if (DataFreshnessResult.NO_DATA != baseResult.freshness) {
                    a = OperationResult.a(baseResult);
                    if (a == null) {
                        a2 = blueServiceHandler.a(operationParams);
                        if (a2.b) {
                            this.f7952a.m7898a((FetchGraphQLNotificationsResult) a2.k(), fetchGraphQLNotificationsParams.f7682i);
                        }
                        a = a2;
                    }
                    b = this.f7952a.m7904b(fetchGraphQLNotificationsParams.m8042f());
                    edit = this.f7953b.f7614a.edit();
                    edit.a(NotificationsPreferenceConstants.f7728e, b);
                    edit.commit();
                    return a;
                }
            }
            a = null;
            if (a == null) {
                a2 = blueServiceHandler.a(operationParams);
                if (a2.b) {
                    this.f7952a.m7898a((FetchGraphQLNotificationsResult) a2.k(), fetchGraphQLNotificationsParams.f7682i);
                }
                a = a2;
            }
            b = this.f7952a.m7904b(fetchGraphQLNotificationsParams.m8042f());
            edit = this.f7953b.f7614a.edit();
            edit.a(NotificationsPreferenceConstants.f7728e, b);
            edit.commit();
            return a;
        }
        if (str.equals("graphNotifUpdateSeenState")) {
            m8281a(operationParams);
        } else if (str.equals("fecthNotificationSeenStates")) {
            return m8283c(operationParams, blueServiceHandler);
        }
        return blueServiceHandler.a(operationParams);
    }

    private void m8281a(OperationParams operationParams) {
        NotificationsChangeSeenStateParams notificationsChangeSeenStateParams = (NotificationsChangeSeenStateParams) operationParams.c.getParcelable("graphNotifsUpdateSeenStatePrams");
        this.f7952a.m7892a((Iterable) notificationsChangeSeenStateParams.a, notificationsChangeSeenStateParams.b, true);
    }

    private OperationResult m8283c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        OperationResult a = blueServiceHandler.a(operationParams);
        if (!a.b) {
            return a;
        }
        int i;
        FetchNotificationSeenStatesResult fetchNotificationSeenStatesResult = (FetchNotificationSeenStatesResult) a.h();
        GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper = this.f7952a;
        ImmutableList immutableList = fetchNotificationSeenStatesResult.a.notificationSeenStatesList;
        ImmutableMultimap$Builder immutableMultimap$Builder = new ImmutableMultimap$Builder();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            NotificationSeenState notificationSeenState = (NotificationSeenState) immutableList.get(i);
            immutableMultimap$Builder.mo697b(notificationSeenState.seenState, notificationSeenState.id);
        }
        Iterator it = immutableMultimap$Builder.mo698b().b.entrySet().iterator();
        i = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            i = graphQLNotificationsContentProviderHelper.m7892a((Iterable) entry.getValue(), (GraphQLStorySeenState) entry.getKey(), true) + i;
        }
        if (i > 0) {
            graphQLNotificationsContentProviderHelper.f7577e.notifyChange(graphQLNotificationsContentProviderHelper.f7576d.f7611b, null);
        }
        return a;
    }
}

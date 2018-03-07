package com.facebook.katana.util;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PushTokenMuteNotificationsInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.NotificationSettingMutations.PushNotificationsMuteMutationString;
import com.facebook.notifications.util.NotificationsSettingsHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.externalcloud.PushServiceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.ServiceType;
import javax.inject.Inject;

/* compiled from: p2p_initiate_set_pin */
public class MutePushNotificationsHelper {
    public FbSharedPreferences f7584a;
    public NotificationsSettingsHelper f7585b;
    private PushServiceSelector f7586c;
    public PushPreferenceSelector f7587d;

    public static MutePushNotificationsHelper m7876b(InjectorLike injectorLike) {
        return new MutePushNotificationsHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NotificationsSettingsHelper.a(injectorLike), PushServiceSelector.a(injectorLike), PushPreferenceSelector.a(injectorLike));
    }

    @Inject
    public MutePushNotificationsHelper(FbSharedPreferences fbSharedPreferences, NotificationsSettingsHelper notificationsSettingsHelper, PushServiceSelector pushServiceSelector, PushPreferenceSelector pushPreferenceSelector) {
        this.f7584a = fbSharedPreferences;
        this.f7585b = notificationsSettingsHelper;
        this.f7586c = pushServiceSelector;
        this.f7587d = pushPreferenceSelector;
    }

    public final void m7877a(final boolean z) {
        PushServiceSelector pushServiceSelector = this.f7586c;
        C08441 c08441 = new Object(this) {
            public final /* synthetic */ MutePushNotificationsHelper f7583b;
        };
        for (ServiceType a : pushServiceSelector.a()) {
            PushTokenHolder a2 = c08441.f7583b.f7587d.a(a);
            if (a2 != null) {
                int i;
                NotificationsSettingsHelper notificationsSettingsHelper = c08441.f7583b.f7585b;
                boolean z2 = c08441.f7582a;
                String a3 = a2.a();
                PushTokenMuteNotificationsInputData pushTokenMuteNotificationsInputData = new PushTokenMuteNotificationsInputData();
                pushTokenMuteNotificationsInputData.a("actor_id", notificationsSettingsHelper.a);
                GraphQlCallInput graphQlCallInput = pushTokenMuteNotificationsInputData;
                if (z2) {
                    i = Integer.MAX_VALUE;
                } else {
                    i = 0;
                }
                graphQlCallInput.a("duration", Integer.valueOf(i));
                GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
                graphQlCallInput2.a("token", a3);
                graphQlCallInput2 = graphQlCallInput2;
                GraphQlQueryString pushNotificationsMuteMutationString = new PushNotificationsMuteMutationString();
                pushNotificationsMuteMutationString.a("input", graphQlCallInput2);
                notificationsSettingsHelper.b.a(GraphQLRequest.a(pushNotificationsMuteMutationString));
            }
        }
    }
}

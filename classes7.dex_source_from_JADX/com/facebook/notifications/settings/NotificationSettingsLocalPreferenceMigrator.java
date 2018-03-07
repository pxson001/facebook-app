package com.facebook.notifications.settings;

import android.util.Base64;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.NotifOptionActionInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Lazy;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.NotifOptionRowsMutation;
import com.facebook.notifications.protocol.NotifOptionRowsMutation.NotifOptionActionMutationString;
import com.facebook.notifications.protocol.NotifOptionRowsMutationModels.NotifOptionActionMutationModel;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: minutiae_verb_picker_tti */
public class NotificationSettingsLocalPreferenceMigrator {
    private static final ImmutableList<String> f8728a = ImmutableList.of("notifs", "lockscreen_on", "vibrate", "use_led", "wall_posts", "comments", "friend_requests", "friend_confirmations", "photo_tags", "event_invites", "app_requests", "groups", new String[]{"place_tips"});
    public final Lazy<GraphQLQueryExecutor> f8729b;
    public final FbSharedPreferences f8730c;

    @Inject
    public NotificationSettingsLocalPreferenceMigrator(Lazy<GraphQLQueryExecutor> lazy, FbSharedPreferences fbSharedPreferences) {
        this.f8729b = lazy;
        this.f8730c = fbSharedPreferences;
    }

    @Nullable
    public final ListenableFuture<GraphQLResult<NotifOptionActionMutationModel>> m10698a() {
        StringBuilder stringBuilder = new StringBuilder("AndroidLegacyPushSettingsServerActionToken;");
        ArrayList arrayList = new ArrayList();
        int size = f8728a.size();
        for (int i = 0; i < size; i++) {
            boolean z;
            String str = (String) f8728a.get(i);
            if (this.f8730c.a((PrefKey) NotificationsPreferenceConstants.a.a(str), true)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            m10699c();
            return null;
        }
        stringBuilder.append(StringUtil.b("|", new Object[]{arrayList}));
        NotifOptionActionInputData a = new NotifOptionActionInputData().c(Base64.encodeToString(stringBuilder.toString().getBytes(), 0)).a(SafeUUIDGenerator.a().toString());
        NotifOptionActionMutationString a2 = NotifOptionRowsMutation.m10379a();
        a2.a("input", a);
        ((GraphQLQueryExecutor) this.f8729b.get()).a(GraphQLRequest.a(a2));
        return ((GraphQLQueryExecutor) this.f8729b.get()).a(GraphQLRequest.a(a2));
    }

    public final void m10699c() {
        this.f8730c.edit().putBoolean(NotificationsPreferenceConstants.L, false).commit();
    }
}

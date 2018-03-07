package com.facebook.notifications.settings.bottomsheet;

import android.content.Context;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.action.NotificationsActionExecutor.1;
import com.facebook.notifications.logging.NotificationSettingsLogger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;

/* compiled from: experiment_logging_params */
public class NotificationBottomSheetAdapterProvider extends AbstractAssistedProvider<NotificationBottomSheetAdapter> {
    public final NotificationBottomSheetAdapter m13420a(NotifOptionSetFragment notifOptionSetFragment, Context context, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, String str, 1 1) {
        return new NotificationBottomSheetAdapter(notifOptionSetFragment, context, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, str, 1, NotificationsActionExecutor.m13401a((InjectorLike) this), GlyphColorizer.a(this), NotificationSettingsLogger.m13424b(this));
    }
}

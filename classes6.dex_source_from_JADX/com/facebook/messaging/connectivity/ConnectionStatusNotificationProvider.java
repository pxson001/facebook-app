package com.facebook.messaging.connectivity;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.BannerNotificationAnalyticsHelper;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.messaging.captiveportal.CaptivePortalUtil;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: is_order_cancelled */
public class ConnectionStatusNotificationProvider extends AbstractAssistedProvider<ConnectionStatusNotification> {
    public final ConnectionStatusNotification m18929a(ConnectionStatusSurface connectionStatusSurface) {
        return new ConnectionStatusNotification(ConnectionStatusMonitorMethodAutoProvider.a(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this), (BaseFbBroadcastManager) GlobalFbBroadcastManager.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), LayoutInflaterMethodAutoProvider.b(this), BannerNotificationAnalyticsHelper.m11006b(this), (Context) getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(this), CaptivePortalUtil.a(this), IdBasedSingletonScopeProvider.a(this, 2588), ConnectivityBannerDisplayTracker.m18932a(this), connectionStatusSurface);
    }
}

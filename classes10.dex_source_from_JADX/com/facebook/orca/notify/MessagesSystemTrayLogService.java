package com.facebook.orca.notify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.analytics.util.LoggerMapUtils;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: no placement in response */
public class MessagesSystemTrayLogService extends FbIntentService {
    @Inject
    public ReliabilityAnalyticsLogger f6248a;
    @Inject
    public SecureContextHelper f6249b;

    public static void m5951a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MessagesSystemTrayLogService messagesSystemTrayLogService = (MessagesSystemTrayLogService) obj;
        ReliabilityAnalyticsLogger a = ReliabilityAnalyticsLogger.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        messagesSystemTrayLogService.f6248a = a;
        messagesSystemTrayLogService.f6249b = secureContextHelper;
    }

    public MessagesSystemTrayLogService() {
        super("MessagesSystemTrayLogService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1358788330);
        super.onCreate();
        AppInitLockHelper.a(this);
        Class cls = MessagesSystemTrayLogService.class;
        m5951a(this, this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 335505748, a);
    }

    protected final void m5952a(Intent intent) {
        Bundle extras = intent.getExtras();
        String str = (String) extras.get("push_source");
        String str2 = (String) extras.get("push_id");
        String str3 = (String) extras.get("push_type");
        ReliabilityAnalyticsLogger reliabilityAnalyticsLogger = this.f6248a;
        Map a = LoggerMapUtils.a(new String[]{"source", str});
        if (str2 != null) {
            a.put("push_id", str2);
        }
        if (str3 != null) {
            a.put("type", str3);
        }
        reliabilityAnalyticsLogger.a("messaging_push_notif", "click_from_tray", a, null, null, null);
        this.f6249b.a((Intent) extras.getParcelable("redirect_intent"), this);
    }
}

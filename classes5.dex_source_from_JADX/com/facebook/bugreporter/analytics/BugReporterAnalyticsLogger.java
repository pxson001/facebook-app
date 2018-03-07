package com.facebook.bugreporter.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutCompat;
import android.telephony.TelephonyManager;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bugreporter.analytics.NetworkUtils.ConnectionType;
import com.facebook.bugreporter.analytics.NetworkUtils.MobileConnectionSubtype;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: android.media.metadata.ALBUM_ART */
public class BugReporterAnalyticsLogger {
    public final AnalyticsLogger f10727a;
    private final NetworkUtils f10728b;

    /* compiled from: android.media.metadata.ALBUM_ART */
    /* synthetic */ class C10351 {
        static final /* synthetic */ int[] f10726a = new int[ConnectionType.values().length];

        static {
            try {
                f10726a[ConnectionType.NoConnection.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10726a[ConnectionType.Wifi.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10726a[ConnectionType.Other.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10726a[ConnectionType.Mobile.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: android.media.metadata.ALBUM_ART */
    public enum CoreEvent {
        RAP_BEGIN_FLOW("rap_begin_flow"),
        RAP_SELECT_FEEDBACK("rap_select_feedback"),
        RAP_SELECT_BUG("rap_select_bug"),
        RAP_SELECT_ABUSE("rap_select_abuse"),
        BUG_REPORT_BEGIN_FLOW("bug_report_begin_flow"),
        BUG_REPORT_DID_DISMISS_CREATION_DIALOG("bug_report_did_dismiss_creation_dialog"),
        BUG_REPORT_DID_SELECT_PRODUCT("bug_report_did_select_product"),
        BUG_REPORT_DID_ENTER_DESCRIPTION("bug_report_did_enter_description"),
        BUG_REPORT_DID_ATTACH_SCREENSHOT("bug_report_did_attach_screenshot"),
        BUG_REPORT_DID_DETACH_SCREENSHOT("bug_report_did_detach_screenshot"),
        BUG_REPORT_DID_COMPLETE("bug_report_did_complete"),
        BUG_REPORT_DID_UPLOAD("bug_report_did_upload"),
        BUG_REPORT_FAILED_TO_UPLOAD("bug_report_failed_to_upload"),
        BUG_REPORT_RETRY_UPLOAD_SUCCESS("bug_report_retry_upload_success"),
        BUG_REPORT_FAILED_TOO_OLD("bug_report_failed_too_old"),
        BUG_REPORT_FAILED_EXCEEDED_QUEUE_SIZE("bug_report_failed_exceeded_queue_size"),
        BUG_REPORT_FAILED_EXCEEDED_RETRIES("bug_report_failed_exceeded_retries"),
        BUG_REPORT_CORRUPTED_DIRECTORY_DELETED("bug_report_corrupted_directory_deleted"),
        BUG_REPORT_UNTRACKED_DIRECTORY_DELETED("bug_report_untracked_directory_deleted"),
        BUG_REPORT_ATTACHMENT_DID_UPLOAD("bug_report_attachment_did_upload"),
        BUG_REPORT_ATTACHMENT_FAILED_TO_UPLOAD("bug_report_attachment_failed_to_upload"),
        BUG_REPORT_ATTACHMENT_RETRY_UPLOAD_SUCCESS("bug_report_attachment_retry_upload_success"),
        BUG_REPORT_ATTACHMENT_FAILED_EXCEEDED_RETRIES("bug_report_attachment_failed_exceeded_retries");
        
        public final String name;

        private CoreEvent(String str) {
            this.name = str;
        }
    }

    public static BugReporterAnalyticsLogger m18744b(InjectorLike injectorLike) {
        return new BugReporterAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), new NetworkUtils((Context) injectorLike.getInstance(Context.class)));
    }

    public static BugReporterAnalyticsLogger m18741a(InjectorLike injectorLike) {
        return m18744b(injectorLike);
    }

    @Inject
    public BugReporterAnalyticsLogger(AnalyticsLogger analyticsLogger, NetworkUtils networkUtils) {
        this.f10727a = analyticsLogger;
        this.f10728b = networkUtils;
    }

    public final void m18746a(CoreEvent coreEvent) {
        m18743a(coreEvent.name, null);
    }

    public final void m18745a() {
        m18742a(CoreEvent.BUG_REPORT_FAILED_EXCEEDED_QUEUE_SIZE, null);
    }

    public final void m18748b() {
        m18742a(CoreEvent.BUG_REPORT_FAILED_EXCEEDED_RETRIES, null);
    }

    private void m18743a(String str, Map<String, Object> map) {
        AnalyticsLogger analyticsLogger = this.f10727a;
        HoneyClientEvent a = new HoneyClientEvent(str).a(map);
        a.c = "bugreporter";
        analyticsLogger.a(a);
    }

    public final void m18747a(CoreEvent coreEvent, String str, String str2, long j) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("bug_id", str2);
        arrayMap.put("attachment_size", Long.valueOf(j));
        arrayMap.put("attachment_name", str);
        m18742a(coreEvent, (Map) arrayMap);
    }

    private void m18742a(CoreEvent coreEvent, Map<String, Object> map) {
        ConnectionType connectionType;
        m18743a(coreEvent.name, (Map) map);
        Object obj = "";
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f10728b.f10729a.getSystemService("connectivity");
        if (connectivityManager == null) {
            connectionType = ConnectionType.Other;
        } else {
            Object obj2;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 == null) {
                connectionType = ConnectionType.NoConnection;
            } else if (activeNetworkInfo.getType() == 1) {
                connectionType = ConnectionType.Wifi;
            } else if (activeNetworkInfo.getType() == 0) {
                connectionType = ConnectionType.Mobile;
            } else {
                connectionType = ConnectionType.Other;
            }
        }
        ConnectionType connectionType2 = connectionType;
        switch (C10351.f10726a[connectionType2.ordinal()]) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
            case 3:
                obj = connectionType2.name();
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                MobileConnectionSubtype mobileConnectionSubtype;
                TelephonyManager telephonyManager = (TelephonyManager) this.f10728b.f10729a.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                        case 7:
                        case 11:
                            mobileConnectionSubtype = MobileConnectionSubtype.G2;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            mobileConnectionSubtype = MobileConnectionSubtype.G3;
                            break;
                        case 13:
                            mobileConnectionSubtype = MobileConnectionSubtype.G4;
                            break;
                        default:
                            mobileConnectionSubtype = MobileConnectionSubtype.OtherMobile;
                            break;
                    }
                }
                mobileConnectionSubtype = MobileConnectionSubtype.OtherMobile;
                obj = mobileConnectionSubtype.name();
                break;
        }
        Preconditions.checkState(!StringUtil.a(obj));
        m18743a(coreEvent.name + '_' + obj.toLowerCase(Locale.US), (Map) map);
    }
}

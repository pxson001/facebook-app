package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.analytics.SmsCallerContext;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.analytics.SmsTakeoverState;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

/* compiled from: com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE */
public class SmsDefaultAppDialogActivity extends FbFragmentActivity {
    @Inject
    SecureContextHelper f17585p;
    @Inject
    SmsDefaultAppManager f17586q;
    @ForNonUiThread
    @Inject
    Handler f17587r;
    @Inject
    SmsIntegrationState f17588s;
    @Inject
    SmsTakeoverAnalyticsLogger f17589t;
    @Inject
    FbSharedPreferences f17590u;
    @Inject
    ChatHeadsBroadcaster f17591v;
    public SmsCallerContext f17592w;
    private SmsTakeoverState f17593x;

    /* compiled from: com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE */
    class C20831 implements Runnable {
        final /* synthetic */ SmsDefaultAppDialogActivity f17581a;

        C20831(SmsDefaultAppDialogActivity smsDefaultAppDialogActivity) {
            this.f17581a = smsDefaultAppDialogActivity;
        }

        public void run() {
            SmsDefaultAppManager smsDefaultAppManager = this.f17581a.f17586q;
            SmsCallerContext smsCallerContext = this.f17581a.f17592w;
            SmsDefaultAppDialogActivity smsDefaultAppDialogActivity = this.f17581a;
            if (!SmsDefaultAppManager.a(smsDefaultAppDialogActivity)) {
                boolean a = smsDefaultAppManager.a(smsCallerContext, smsDefaultAppDialogActivity, true);
            }
            SecureContextHelper secureContextHelper = this.f17581a.f17585p;
            SmsDefaultAppDialogActivity smsDefaultAppDialogActivity2 = this.f17581a;
            Intent intent = new Intent("android.provider.Telephony.ACTION_CHANGE_DEFAULT");
            intent.putExtra("package", smsDefaultAppDialogActivity2.getPackageName());
            secureContextHelper.b(intent, 2357, this.f17581a);
        }
    }

    /* compiled from: com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE */
    public class C20842 implements OnCancelListener {
        final /* synthetic */ SmsDefaultAppDialogActivity f17582a;

        public C20842(SmsDefaultAppDialogActivity smsDefaultAppDialogActivity) {
            this.f17582a = smsDefaultAppDialogActivity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.f17582a.f17589t.c(this.f17582a.f17592w.toString());
            SmsDefaultAppDialogActivity.m17572i(this.f17582a);
        }
    }

    /* compiled from: com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE */
    public class C20853 implements OnClickListener {
        final /* synthetic */ SmsDefaultAppDialogActivity f17583a;

        public C20853(SmsDefaultAppDialogActivity smsDefaultAppDialogActivity) {
            this.f17583a = smsDefaultAppDialogActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f17583a.f17589t.b(this.f17583a.f17592w.toString());
            SmsDefaultAppDialogActivity.m17573j(this.f17583a);
        }
    }

    /* compiled from: com.facebook.rtc.fbwebrtc.CALL_STATUS_AND_DURATION_UPDATE */
    public /* synthetic */ class C20864 {
        public static final /* synthetic */ int[] f17584a = new int[SmsCallerContext.values().length];

        static {
            try {
                f17584a[SmsCallerContext.DELETE_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17584a[SmsCallerContext.SEND_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17584a[SmsCallerContext.RETRY_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17584a[SmsCallerContext.DELETE_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17584a[SmsCallerContext.DOWNLOAD_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17584a[SmsCallerContext.MARK_READ.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f17584a[SmsCallerContext.MARK_UNREAD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f17584a[SmsCallerContext.SETTINGS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f17584a[SmsCallerContext.UNDEFINED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f17584a[SmsCallerContext.OPT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f17584a[SmsCallerContext.KILL_SWITCH.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f17584a[SmsCallerContext.LOGGED_OUT.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f17584a[SmsCallerContext.SYSTEM_CHANGE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f17584a[SmsCallerContext.PERMISSION_CHANGE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public static void m17571a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SmsDefaultAppDialogActivity) obj).m17570a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), SmsDefaultAppManager.a(fbInjector), Handler_ForNonUiThreadMethodAutoProvider.b(fbInjector), SmsIntegrationState.a(fbInjector), SmsTakeoverAnalyticsLogger.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), ChatHeadsBroadcaster.a(fbInjector));
    }

    private void m17570a(SecureContextHelper secureContextHelper, SmsDefaultAppManager smsDefaultAppManager, Handler handler, SmsIntegrationState smsIntegrationState, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, FbSharedPreferences fbSharedPreferences, ChatHeadsBroadcaster chatHeadsBroadcaster) {
        this.f17585p = secureContextHelper;
        this.f17586q = smsDefaultAppManager;
        this.f17587r = handler;
        this.f17588s = smsIntegrationState;
        this.f17589t = smsTakeoverAnalyticsLogger;
        this.f17590u = fbSharedPreferences;
        this.f17591v = chatHeadsBroadcaster;
    }

    protected final void m17574b(Bundle bundle) {
        super.b(bundle);
        Class cls = SmsDefaultAppDialogActivity.class;
        m17571a(this, this);
        Intent intent = getIntent();
        if (intent == null || intent.getExtras() == null) {
            this.f17592w = SmsCallerContext.UNDEFINED;
        } else {
            this.f17592w = (SmsCallerContext) intent.getExtras().getSerializable("analytics_caller_context");
        }
        this.f17593x = this.f17589t.g();
    }

    protected void onResume() {
        int i;
        AlertDialog alertDialog;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -670533416);
        super.onResume();
        this.f17591v.b();
        switch (C20864.f17584a[this.f17592w.ordinal()]) {
            case 1:
                i = 2131232364;
                break;
            case 2:
                i = 2131232359;
                break;
            case 3:
                i = 2131232361;
                break;
            case 4:
                i = 2131232360;
                break;
            case 5:
                i = 2131232362;
                break;
            case 6:
            case 7:
                i = 2131232363;
                break;
            default:
                i = -1;
                break;
        }
        int i2 = i;
        if (i2 == -1) {
            alertDialog = null;
        } else {
            alertDialog = new FbAlertDialogBuilder(this).a(17039370, new C20853(this)).a(2131232358).b(i2).a(new C20842(this)).a();
        }
        AlertDialog alertDialog2 = alertDialog;
        if (alertDialog2 == null) {
            m17573j(this);
        } else {
            alertDialog2.show();
            this.f17589t.a(this.f17592w.toString());
        }
        LogUtils.c(1183472347, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2357) {
            m17572i(this);
        }
    }

    public static void m17572i(SmsDefaultAppDialogActivity smsDefaultAppDialogActivity) {
        smsDefaultAppDialogActivity.f17588s.e();
        if (smsDefaultAppDialogActivity.f17588s.d()) {
            smsDefaultAppDialogActivity.f17590u.edit().a(SmsPrefKeys.b).commit();
            if (smsDefaultAppDialogActivity.f17593x != SmsTakeoverState.FULL) {
                Toast.makeText(smsDefaultAppDialogActivity, 2131232365, 0).show();
            }
        }
        smsDefaultAppDialogActivity.f17589t.a(smsDefaultAppDialogActivity.f17592w, smsDefaultAppDialogActivity.f17593x, smsDefaultAppDialogActivity.f17589t.g());
        SmsDefaultAppManager smsDefaultAppManager = smsDefaultAppDialogActivity.f17586q;
        if (!smsDefaultAppManager.d.d()) {
            smsDefaultAppManager.l.clear();
        } else if (!smsDefaultAppManager.l.isEmpty()) {
            smsDefaultAppManager.h.a("processSmsReadOnlyPendingActions", smsDefaultAppManager.m, Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, ThreadType.UI);
        }
        smsDefaultAppDialogActivity.finish();
    }

    public static void m17573j(SmsDefaultAppDialogActivity smsDefaultAppDialogActivity) {
        HandlerDetour.a(smsDefaultAppDialogActivity.f17587r, new C20831(smsDefaultAppDialogActivity), 959644792);
    }
}

package com.facebook.orca.notify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.DateFormat;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.alarm.AndroidFormattedAlarmParser;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.prefs.counters.UiCounters;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/* compiled from: sessions_updated_count */
public class MuteNotificationHelper {
    private final Context f2467a;
    private final Clock f2468b;
    private final AndroidFormattedAlarmParser f2469c;
    private final AnalyticsLogger f2470d;
    private final UiCounters f2471e;
    private final NotificationSettingsUtil f2472f;
    private final FbSharedPreferences f2473g;
    private final BugReportOperationLogger f2474h;
    private final OnClickListener f2475i = new C01191(this);

    /* compiled from: sessions_updated_count */
    class C01191 implements OnClickListener {
        final /* synthetic */ MuteNotificationHelper f2487a;

        C01191(MuteNotificationHelper muteNotificationHelper) {
            this.f2487a = muteNotificationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    public static MuteNotificationHelper m2746a(InjectorLike injectorLike) {
        return new MuteNotificationHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NotificationSettingsUtil.m9290b(injectorLike), (Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), AndroidFormattedAlarmParser.m2748a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), UiCounters.a(injectorLike), BugReportOperationLogger.m2756a(injectorLike));
    }

    @Inject
    public MuteNotificationHelper(FbSharedPreferences fbSharedPreferences, NotificationSettingsUtil notificationSettingsUtil, Context context, Clock clock, AndroidFormattedAlarmParser androidFormattedAlarmParser, AnalyticsLogger analyticsLogger, UiCounters uiCounters, BugReportOperationLogger bugReportOperationLogger) {
        this.f2473g = fbSharedPreferences;
        this.f2472f = notificationSettingsUtil;
        this.f2467a = context;
        this.f2468b = clock;
        this.f2469c = androidFormattedAlarmParser;
        this.f2470d = analyticsLogger;
        this.f2471e = uiCounters;
        this.f2474h = bugReportOperationLogger;
    }

    public final List<MuteOption> m2747a(ThreadKey threadKey) {
        List<MuteOption> a = Lists.a();
        a.add(new MuteOption(this.f2467a.getString(2131231133), this.f2467a.getString(2131231142), new Date(this.f2468b.a() + 3600000)));
        a.add(0, new MuteOption(this.f2467a.getString(2131231132), this.f2467a.getString(2131231141), new Date(this.f2468b.a() + 900000)));
        a.add(new MuteOption(this.f2467a.getString(2131231134), this.f2467a.getString(2131231143), new Date(this.f2468b.a() + 28800000)));
        a.add(new MuteOption(this.f2467a.getString(2131231135), this.f2467a.getString(2131231144), new Date(this.f2468b.a() + 86400000)));
        long a2 = this.f2468b.a();
        Date a3 = this.f2469c.m2754a();
        Date date = new Date(a2 + 86400000);
        if (a3 != null && a3.before(date)) {
            a.add(new MuteOption(this.f2467a.getString(2131231137, new Object[]{DateFormat.getTimeFormat(this.f2467a).format(a3)}), this.f2467a.getString(2131231146), a3));
        }
        if (threadKey != null) {
            a.add(new MuteOption(this.f2467a.getString(2131231131), this.f2467a.getString(2131231147), NotificationSetting.b));
        }
        return a;
    }
}

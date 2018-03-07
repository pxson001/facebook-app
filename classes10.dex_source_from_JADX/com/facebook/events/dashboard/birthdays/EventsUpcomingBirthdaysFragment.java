package com.facebook.events.dashboard.birthdays;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.debug.log.BLog;
import com.facebook.events.dashboard.birthdays.BirthdaysPager.BirthdaysPagerCallback;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Strings;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.environment */
public class EventsUpcomingBirthdaysFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    BirthdaysPager f16997a;
    public boolean al = true;
    public String am;
    public String an;
    private GregorianCalendar ao;
    private SimpleDateFormat ap;
    @Inject
    EventsUpcomingBirthdaysAdapter f16998b;
    @Inject
    BirthdaysPerformanceLogger f16999c;
    @Inject
    EventEventLogger f17000d;
    @Inject
    BirthdayReminderLogger f17001e;
    @Inject
    FbTitleBarSupplier f17002f;
    @Inject
    QeAccessor f17003g;
    private BetterListView f17004h;
    public String f17005i;

    /* compiled from: com.facebook.timeline.environment */
    class C23861 implements OnDrawListener {
        final /* synthetic */ EventsUpcomingBirthdaysFragment f16994a;

        C23861(EventsUpcomingBirthdaysFragment eventsUpcomingBirthdaysFragment) {
            this.f16994a = eventsUpcomingBirthdaysFragment;
        }

        public final boolean gD_() {
            Object obj;
            EventsUpcomingBirthdaysAdapter eventsUpcomingBirthdaysAdapter = this.f16994a.f16998b;
            if (eventsUpcomingBirthdaysAdapter.f16990i || !eventsUpcomingBirthdaysAdapter.f16989h) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return false;
            }
            BirthdaysPerformanceLogger birthdaysPerformanceLogger = this.f16994a.f16999c;
            birthdaysPerformanceLogger.f16971b.b(birthdaysPerformanceLogger.f16970a);
            EventEventLogger eventEventLogger = this.f16994a.f17000d;
            HoneyClientEventFast a = eventEventLogger.f17787i.a("view", true);
            if (a.a()) {
                a.a("event_birthdays").d(eventEventLogger.f17788j.b(eventEventLogger.f17785g)).a("has_installed_launcher", false).b();
            }
            return true;
        }
    }

    /* compiled from: com.facebook.timeline.environment */
    class C23872 implements OnScrollListener {
        final /* synthetic */ EventsUpcomingBirthdaysFragment f16995a;

        C23872(EventsUpcomingBirthdaysFragment eventsUpcomingBirthdaysFragment) {
            this.f16995a = eventsUpcomingBirthdaysFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                this.f16995a.f17001e.m18114b(this.f16995a.an);
                EventsUpcomingBirthdaysFragment.m17325e(this.f16995a);
            }
        }
    }

    /* compiled from: com.facebook.timeline.environment */
    class C23883 implements BirthdaysPagerCallback {
        final /* synthetic */ EventsUpcomingBirthdaysFragment f16996a;

        C23883(EventsUpcomingBirthdaysFragment eventsUpcomingBirthdaysFragment) {
            this.f16996a = eventsUpcomingBirthdaysFragment;
        }

        public final void mo788a(boolean z, String str, String str2, @Nonnull List<EventUserWithBirthdayFragmentModel> list) {
            this.f16996a.al = z;
            this.f16996a.am = str;
            this.f16996a.f17005i = str2;
            this.f16996a.f16998b.m17311a((List) list, z);
        }
    }

    public static void m17324a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsUpcomingBirthdaysFragment) obj).m17323a(BirthdaysPager.m17292b(injectorLike), EventsUpcomingBirthdaysAdapter.m17304b(injectorLike), BirthdaysPerformanceLogger.m17295a(injectorLike), EventEventLogger.m18119b(injectorLike), BirthdayReminderLogger.m18107a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m17323a(BirthdaysPager birthdaysPager, EventsUpcomingBirthdaysAdapter eventsUpcomingBirthdaysAdapter, BirthdaysPerformanceLogger birthdaysPerformanceLogger, EventEventLogger eventEventLogger, BirthdayReminderLogger birthdayReminderLogger, FbTitleBarSupplier fbTitleBarSupplier, QeAccessor qeAccessor) {
        this.f16997a = birthdaysPager;
        this.f16998b = eventsUpcomingBirthdaysAdapter;
        this.f16999c = birthdaysPerformanceLogger;
        this.f17000d = eventEventLogger;
        this.f17001e = birthdayReminderLogger;
        this.f17002f = fbTitleBarSupplier;
        this.f17003g = qeAccessor;
    }

    public final void m17328c(Bundle bundle) {
        super.c(bundle);
        this.ap = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        Class cls = EventsUpcomingBirthdaysFragment.class;
        m17324a((Object) this, getContext());
        BirthdaysPerformanceLogger birthdaysPerformanceLogger = this.f16999c;
        birthdaysPerformanceLogger.f16971b.c(birthdaysPerformanceLogger.f16970a);
        this.an = m17322a(bundle, o().getIntent());
        this.f16998b.f16991j = this.an;
        this.f16998b.f16987f = this;
        if (!(bundle == null || bundle.getBundle("posted_birthdays_fbids") == null)) {
            this.f16998b.f16992k = bundle.getBundle("posted_birthdays_fbids");
        }
        m17325e(this);
    }

    public final void m17329e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("birthday_view_waterfall_id_param", this.an);
        bundle.putBundle("posted_birthdays_fbids", this.f16998b.f16992k);
    }

    private String m17322a(Bundle bundle, Intent intent) {
        long time;
        GregorianCalendar gregorianCalendar;
        Boolean valueOf;
        BirthdayReminderLogger birthdayReminderLogger;
        boolean z = false;
        String str = null;
        Boolean valueOf2 = Boolean.valueOf(false);
        if (intent != null) {
            str = intent.getStringExtra("birthday_view_referrer_param");
        }
        String stringExtra = o().getIntent().getStringExtra("birthday_view_start_date");
        try {
            if (!Strings.isNullOrEmpty(stringExtra)) {
                time = this.ap.parse(stringExtra).getTime();
                gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
                this.ao = new GregorianCalendar(TimeZone.getDefault());
                if (time == -1) {
                    this.ao.setTimeInMillis(time);
                    if (this.ao.get(6) != gregorianCalendar.get(6)) {
                        z = true;
                    }
                    valueOf = Boolean.valueOf(z);
                } else {
                    valueOf = valueOf2;
                }
                if (bundle == null && bundle.getString("birthday_view_waterfall_id_param") != null) {
                    return bundle.getString("birthday_view_waterfall_id_param");
                }
                birthdayReminderLogger = this.f17001e;
                if (str == null) {
                    str = "";
                }
                return birthdayReminderLogger.m18112a(str, valueOf.booleanValue());
            }
        } catch (Throwable e) {
            BLog.b(BirthdaysUriIntentBuilder.class, e, "Invalid date format", new Object[0]);
        }
        time = -1;
        gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        this.ao = new GregorianCalendar(TimeZone.getDefault());
        if (time == -1) {
            valueOf = valueOf2;
        } else {
            this.ao.setTimeInMillis(time);
            if (this.ao.get(6) != gregorianCalendar.get(6)) {
                z = true;
            }
            valueOf = Boolean.valueOf(z);
        }
        if (bundle == null) {
        }
        birthdayReminderLogger = this.f17001e;
        if (str == null) {
            str = "";
        }
        return birthdayReminderLogger.m18112a(str, valueOf.booleanValue());
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1725138544);
        super.mi_();
        ((FbTitleBar) this.f17002f.get()).setTitle(2131237144);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 176931484, a);
    }

    public final View m17326a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1050439512);
        this.f17004h = (BetterListView) layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625810)).inflate(2130904176, viewGroup, false);
        this.f17004h.a(new C23861(this));
        this.f17004h.setAdapter(this.f16998b);
        this.f17004h.setStickyHeaderEnabled(false);
        this.f17004h.setOnScrollListener(new C23872(this));
        BetterListView betterListView = this.f17004h;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -639186904, a);
        return betterListView;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1083611389);
        this.f17004h = null;
        BirthdaysPerformanceLogger birthdaysPerformanceLogger = this.f16999c;
        birthdaysPerformanceLogger.f16971b.f(birthdaysPerformanceLogger.f16970a);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 895570208, a);
    }

    public static void m17325e(EventsUpcomingBirthdaysFragment eventsUpcomingBirthdaysFragment) {
        if (eventsUpcomingBirthdaysFragment.al && !eventsUpcomingBirthdaysFragment.f16997a.m17294a()) {
            eventsUpcomingBirthdaysFragment.f17003g.a(ExperimentsForEventsGatingModule.c, false);
            eventsUpcomingBirthdaysFragment.f16997a.m17293a(24, eventsUpcomingBirthdaysFragment.am, eventsUpcomingBirthdaysFragment.f17005i, eventsUpcomingBirthdaysFragment.ao, new C23883(eventsUpcomingBirthdaysFragment));
        }
    }

    public final String am_() {
        return "event_birthdays";
    }

    public final void m17327a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (intent != null && i == 1756) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            if (publishPostParams != null) {
                this.f16998b.m17310a(String.valueOf(publishPostParams.targetId), publishPostParams.originalPostTime);
            }
        }
    }
}

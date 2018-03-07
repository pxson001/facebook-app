package com.facebook.events.dashboard.birthdays;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.debug.log.BLog;
import com.facebook.events.dashboard.EventsDashboardFragment;
import com.facebook.events.dashboard.birthdays.BirthdaysPager.BirthdaysPagerCallback;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.logging.BirthdayReminderLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Strings;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: com.facebook.sdk.appEventPreferences */
public class EventsUpcomingBirthdaysListViewHelper {
    private BirthdayReminderLogger f17009a;
    private BirthdaysPager f17010b;
    private QeAccessor f17011c;
    public OnScrollListener f17012d;
    private BetterListView f17013e;
    private boolean f17014f;
    public boolean f17015g = true;
    public EventsDashboardFragment f17016h;
    public EventsUpcomingBirthdaysAdapter f17017i;
    private GregorianCalendar f17018j;
    private int f17019k;
    public FbSwipeRefreshLayout f17020l;
    public OnRefreshListener f17021m;
    private SimpleDateFormat f17022n;
    public String f17023o;
    public String f17024p;

    /* compiled from: com.facebook.sdk.appEventPreferences */
    public class C23891 implements OnScrollListener {
        final /* synthetic */ EventsUpcomingBirthdaysListViewHelper f17006a;

        public C23891(EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper) {
            this.f17006a = eventsUpcomingBirthdaysListViewHelper;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 > i3 - 3) {
                EventsUpcomingBirthdaysListViewHelper.m17336c(this.f17006a);
            }
        }
    }

    /* compiled from: com.facebook.sdk.appEventPreferences */
    public class C23902 implements OnRefreshListener {
        final /* synthetic */ EventsUpcomingBirthdaysListViewHelper f17007a;

        public C23902(EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper) {
            this.f17007a = eventsUpcomingBirthdaysListViewHelper;
        }

        public final void m17331a() {
            EventsUpcomingBirthdaysListViewHelper.m17336c(this.f17007a);
            this.f17007a.f17016h.m17056e();
            this.f17007a.f17020l.setRefreshing(false);
        }
    }

    /* compiled from: com.facebook.sdk.appEventPreferences */
    class C23913 implements BirthdaysPagerCallback {
        final /* synthetic */ EventsUpcomingBirthdaysListViewHelper f17008a;

        C23913(EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper) {
            this.f17008a = eventsUpcomingBirthdaysListViewHelper;
        }

        public final void mo788a(boolean z, String str, String str2, List<EventUserWithBirthdayFragmentModel> list) {
            this.f17008a.f17015g = z;
            this.f17008a.f17024p = str;
            this.f17008a.f17023o = str2;
            this.f17008a.f17017i.m17311a((List) list, z);
        }
    }

    public static EventsUpcomingBirthdaysListViewHelper m17333a(InjectorLike injectorLike) {
        return new EventsUpcomingBirthdaysListViewHelper(BirthdayReminderLogger.m18107a(injectorLike), BirthdaysPager.m17292b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), EventsUpcomingBirthdaysAdapter.m17304b(injectorLike));
    }

    @Inject
    public EventsUpcomingBirthdaysListViewHelper(BirthdayReminderLogger birthdayReminderLogger, BirthdaysPager birthdaysPager, QeAccessor qeAccessor, EventsUpcomingBirthdaysAdapter eventsUpcomingBirthdaysAdapter) {
        this.f17009a = birthdayReminderLogger;
        this.f17010b = birthdaysPager;
        this.f17011c = qeAccessor;
        this.f17017i = eventsUpcomingBirthdaysAdapter;
    }

    public final void m17337a(EventsDashboardFragment eventsDashboardFragment, BetterListView betterListView, FbSwipeRefreshLayout fbSwipeRefreshLayout) {
        if (!this.f17014f) {
            m17335b(eventsDashboardFragment, betterListView, fbSwipeRefreshLayout);
        }
        this.f17013e.setOnScrollListener(this.f17012d);
        this.f17020l.e = this.f17021m;
        this.f17013e.setAdapter(this.f17017i);
        m17336c(this);
    }

    private void m17335b(EventsDashboardFragment eventsDashboardFragment, BetterListView betterListView, FbSwipeRefreshLayout fbSwipeRefreshLayout) {
        this.f17016h = eventsDashboardFragment;
        this.f17013e = betterListView;
        this.f17020l = fbSwipeRefreshLayout;
        this.f17022n = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
        this.f17017i.f16991j = m17334a(eventsDashboardFragment.o().getIntent());
        this.f17017i.f16987f = eventsDashboardFragment;
        this.f17019k = eventsDashboardFragment.jW_().getDimensionPixelSize(2131431107);
        this.f17012d = new C23891(this);
        this.f17021m = new C23902(this);
        this.f17014f = true;
    }

    private String m17334a(Intent intent) {
        String stringExtra;
        long time;
        GregorianCalendar gregorianCalendar;
        boolean z;
        Boolean valueOf;
        BirthdayReminderLogger birthdayReminderLogger;
        String str = null;
        Boolean valueOf2 = Boolean.valueOf(false);
        if (intent != null) {
            stringExtra = intent.getStringExtra("birthday_view_referrer_param");
            str = intent.getStringExtra("birthday_view_start_date");
        } else {
            stringExtra = null;
        }
        try {
            if (!Strings.isNullOrEmpty(str)) {
                time = this.f17022n.parse(str).getTime();
                gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
                this.f17018j = new GregorianCalendar(TimeZone.getDefault());
                if (time == -1) {
                    this.f17018j.setTimeInMillis(time);
                    if (this.f17018j.get(6) == gregorianCalendar.get(6)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    valueOf = Boolean.valueOf(z);
                } else {
                    valueOf = valueOf2;
                }
                birthdayReminderLogger = this.f17009a;
                if (stringExtra == null) {
                    stringExtra = "";
                }
                return birthdayReminderLogger.m18112a(stringExtra, valueOf.booleanValue());
            }
        } catch (Throwable e) {
            BLog.b(BirthdaysUriIntentBuilder.class, e, "Invalid date format", new Object[0]);
        }
        time = -1;
        gregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
        this.f17018j = new GregorianCalendar(TimeZone.getDefault());
        if (time == -1) {
            valueOf = valueOf2;
        } else {
            this.f17018j.setTimeInMillis(time);
            if (this.f17018j.get(6) == gregorianCalendar.get(6)) {
                z = false;
            } else {
                z = true;
            }
            valueOf = Boolean.valueOf(z);
        }
        birthdayReminderLogger = this.f17009a;
        if (stringExtra == null) {
            stringExtra = "";
        }
        return birthdayReminderLogger.m18112a(stringExtra, valueOf.booleanValue());
    }

    public static void m17336c(EventsUpcomingBirthdaysListViewHelper eventsUpcomingBirthdaysListViewHelper) {
        if (eventsUpcomingBirthdaysListViewHelper.f17015g && !eventsUpcomingBirthdaysListViewHelper.f17010b.m17294a()) {
            eventsUpcomingBirthdaysListViewHelper.f17010b.m17293a(24, eventsUpcomingBirthdaysListViewHelper.f17024p, eventsUpcomingBirthdaysListViewHelper.f17023o, eventsUpcomingBirthdaysListViewHelper.f17018j, new C23913(eventsUpcomingBirthdaysListViewHelper));
        }
    }
}

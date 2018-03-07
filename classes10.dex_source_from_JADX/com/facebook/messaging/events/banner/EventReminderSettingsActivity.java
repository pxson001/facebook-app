package com.facebook.messaging.events.banner;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.actionbar.ActionBarOwner;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.graphql.calls.LightweightEventDeleteInputData;
import com.facebook.graphql.calls.LightweightEventDeleteInputData.Context;
import com.facebook.graphql.calls.LightweightEventDeleteInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.LightweightEventRsvpInputData.GuestListState;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.events.banner.EventReminderMutator.C03901;
import com.facebook.messaging.events.graphql.EventRemindersMutation.LightweightEventDeleteString;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadEventReminder;
import com.facebook.resources.ui.FbCheckedTextView;
import com.facebook.user.model.UserKey;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: snapshot_log_delay_second */
public class EventReminderSettingsActivity extends FbFragmentActivity implements ActionBarOwner {
    public boolean f2352A;
    public EventReminderSettingsRow f2353B;
    public EventReminderSettingsRow f2354C;
    public EventReminderMembersRowView f2355D;
    public FbCheckedTextView f2356E;
    public FbCheckedTextView f2357F;
    public Calendar f2358G;
    public String f2359H;
    @Inject
    AppCompatActivityOverrider f2360p;
    @Inject
    EventReminderMutator f2361q;
    @Inject
    EventRemindersUtil f2362r;
    @Inject
    EventsDashboardTimeFormatUtil f2363s;
    @Inject
    EventReminderMembersUtil f2364t;
    @Inject
    DataCache f2365u;
    @Inject
    @LoggedInUserKey
    Provider<UserKey> f2366v;
    public ThreadEventReminder f2367w;
    @Nullable
    private ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> f2368x;
    public EventReminderMembers f2369y;
    private ThreadKey f2370z;

    /* compiled from: snapshot_log_delay_second */
    public class C03971 implements OnClickListener {
        public final /* synthetic */ EventReminderSettingsActivity f2346a;

        /* compiled from: snapshot_log_delay_second */
        public class C03961 {
            public final /* synthetic */ C03971 f2345a;

            C03961(C03971 c03971) {
                this.f2345a = c03971;
            }
        }

        public C03971(EventReminderSettingsActivity eventReminderSettingsActivity) {
            this.f2346a = eventReminderSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1454244507);
            EventReminderEditTitleDialogFragment a2 = EventReminderEditTitleDialogFragment.m2163a(this.f2346a.f2367w.a, this.f2346a.f2359H, "event_reminder_settings", "event_reminder_settings");
            a2.as = new C03961(this);
            a2.a(this.f2346a.kO_(), "edit_event_reminder_title");
            Logger.a(2, EntryType.UI_INPUT_END, 1114979218, a);
        }
    }

    /* compiled from: snapshot_log_delay_second */
    public class C03992 implements OnClickListener {
        public final /* synthetic */ EventReminderSettingsActivity f2348a;

        /* compiled from: snapshot_log_delay_second */
        public class C03981 {
            public final /* synthetic */ C03992 f2347a;

            C03981(C03992 c03992) {
                this.f2347a = c03992;
            }
        }

        public C03992(EventReminderSettingsActivity eventReminderSettingsActivity) {
            this.f2348a = eventReminderSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1799438004);
            EventReminderEditTimeDialogFragment a2 = EventReminderEditTimeDialogFragment.m2159a(this.f2348a.f2367w.a, this.f2348a.f2358G.getTimeInMillis(), "event_reminder_settings", "event_reminder_settings");
            a2.at = new C03981(this);
            a2.a(this.f2348a.kO_(), "edit_event_reminder_time");
            Logger.a(2, EntryType.UI_INPUT_END, 1226474523, a);
        }
    }

    /* compiled from: snapshot_log_delay_second */
    public class C04003 implements OnClickListener {
        final /* synthetic */ EventReminderSettingsActivity f2349a;

        public C04003(EventReminderSettingsActivity eventReminderSettingsActivity) {
            this.f2349a = eventReminderSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1380990668);
            this.f2349a.f2361q.m2189a(this.f2349a.f2367w.a, GuestListState.GOING);
            EventReminderSettingsActivity.m2200a(this.f2349a, GraphQLLightweightEventGuestStatus.GOING);
            this.f2349a.f2356E.setChecked(true);
            this.f2349a.f2357F.setChecked(false);
            Logger.a(2, EntryType.UI_INPUT_END, -345796517, a);
        }
    }

    /* compiled from: snapshot_log_delay_second */
    public class C04014 implements OnClickListener {
        final /* synthetic */ EventReminderSettingsActivity f2350a;

        public C04014(EventReminderSettingsActivity eventReminderSettingsActivity) {
            this.f2350a = eventReminderSettingsActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1110131027);
            this.f2350a.f2361q.m2189a(this.f2350a.f2367w.a, GuestListState.DECLINED);
            EventReminderSettingsActivity.m2200a(this.f2350a, GraphQLLightweightEventGuestStatus.DECLINED);
            this.f2350a.f2357F.setChecked(true);
            this.f2350a.f2356E.setChecked(false);
            Logger.a(2, EntryType.UI_INPUT_END, -128825851, a);
        }
    }

    /* compiled from: snapshot_log_delay_second */
    class C04025 implements OnMenuItemClickListener {
        final /* synthetic */ EventReminderSettingsActivity f2351a;

        C04025(EventReminderSettingsActivity eventReminderSettingsActivity) {
            this.f2351a = eventReminderSettingsActivity;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            EventReminderMutator eventReminderMutator = this.f2351a.f2361q;
            String str = this.f2351a.f2367w.a;
            if (!Strings.isNullOrEmpty(str)) {
                LightweightEventDeleteInputData lightweightEventDeleteInputData = new LightweightEventDeleteInputData();
                lightweightEventDeleteInputData.a("event_id", str);
                EventActionHistory b = new EventActionHistory().a("messenger_thread").b("event_reminder_banner");
                EventActionHistory b2 = new EventActionHistory().a("event_reminder_settings").b("event_reminder_settings");
                Context context = new Context();
                context.a("event_action_history", ImmutableList.of(b, b2));
                lightweightEventDeleteInputData.a("context", context);
                eventReminderMutator.f2327b.a("tasks-deleteEvent:" + str, eventReminderMutator.f2326a.a(GraphQLRequest.a((LightweightEventDeleteString) new LightweightEventDeleteString().a("input", lightweightEventDeleteInputData))), new C03901(eventReminderMutator));
            }
            this.f2351a.finish();
            return true;
        }
    }

    public static void m2201a(Object obj, android.content.Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventReminderSettingsActivity) obj).m2199a(AppCompatActivityOverrider.b(fbInjector), EventReminderMutator.m2188b(fbInjector), EventRemindersUtil.m2207b(fbInjector), EventsDashboardTimeFormatUtil.a(fbInjector), EventReminderMembersUtil.m2177b(fbInjector), DataCache.a(fbInjector), IdBasedProvider.a(fbInjector, 3597));
    }

    private void m2199a(AppCompatActivityOverrider appCompatActivityOverrider, EventReminderMutator eventReminderMutator, EventRemindersUtil eventRemindersUtil, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, EventReminderMembersUtil eventReminderMembersUtil, DataCache dataCache, Provider<UserKey> provider) {
        this.f2360p = appCompatActivityOverrider;
        this.f2361q = eventReminderMutator;
        this.f2362r = eventRemindersUtil;
        this.f2363s = eventsDashboardTimeFormatUtil;
        this.f2364t = eventReminderMembersUtil;
        this.f2365u = dataCache;
        this.f2366v = provider;
    }

    protected final void m2204a(@Nullable Bundle bundle) {
        super.a(bundle);
        MessengerMaterialThemeUtil.a(this, 2131625175);
        Class cls = EventReminderSettingsActivity.class;
        m2201a((Object) this, (android.content.Context) this);
        a(this.f2360p);
    }

    protected final void m2205b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130904094);
        this.f2367w = (ThreadEventReminder) getIntent().getParcelableExtra("thread_event_reminder_model_extra");
        this.f2370z = (ThreadKey) getIntent().getParcelableExtra("thread_key_extra");
        this.f2368x = this.f2365u.a(this.f2370z, this.f2367w.a);
        this.f2369y = this.f2364t.m2178a(this.f2370z, this.f2368x);
        this.f2352A = this.f2362r.m2208b(this.f2370z, this.f2367w, this.f2369y);
        this.f2358G = Calendar.getInstance();
        if (bundle == null) {
            String str;
            if (Strings.isNullOrEmpty(this.f2367w.c)) {
                str = "";
            } else {
                str = this.f2367w.c;
            }
            this.f2359H = str;
            this.f2358G.setTimeInMillis(TimeUnit.SECONDS.toMillis(this.f2367w.b));
        } else {
            this.f2359H = bundle.getString("event_title");
            this.f2358G.setTimeInMillis(bundle.getLong("event_timestamp"));
        }
        ActionBar a = m2203a();
        if (a != null) {
            a.b(2131241210);
        }
        this.f2353B = (EventReminderSettingsRow) a(2131561386);
        this.f2353B.setGlyphImageResId(2130841451);
        if (Strings.isNullOrEmpty(this.f2359H)) {
            this.f2353B.setPlaceholderText(getResources().getString(2131241211));
        } else {
            this.f2353B.setText(this.f2359H);
        }
        this.f2353B.setOnClickListener(new C03971(this));
        this.f2354C = (EventReminderSettingsRow) a(2131561385);
        this.f2354C.setText(m2202m(this));
        this.f2354C.setGlyphImageResId(2130841355);
        this.f2354C.setOnClickListener(new C03992(this));
        this.f2355D = (EventReminderMembersRowView) a(2131561387);
        if (this.f2352A) {
            this.f2355D.setMembers(this.f2369y);
            this.f2355D.setVisibility(0);
        } else {
            this.f2355D.setVisibility(8);
        }
        this.f2356E = (FbCheckedTextView) a(2131561388);
        this.f2357F = (FbCheckedTextView) a(2131561389);
        if (this.f2352A) {
            if (this.f2369y.f2309a == GraphQLLightweightEventGuestStatus.GOING) {
                this.f2356E.setChecked(true);
            } else if (this.f2369y.f2309a == GraphQLLightweightEventGuestStatus.DECLINED) {
                this.f2357F.setChecked(true);
            }
            this.f2356E.setOnClickListener(new C04003(this));
            this.f2357F.setOnClickListener(new C04014(this));
            this.f2356E.setVisibility(0);
            this.f2357F.setVisibility(0);
            return;
        }
        this.f2356E.setVisibility(8);
        this.f2357F.setVisibility(8);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("event_timestamp", this.f2358G.getTimeInMillis());
        bundle.putString("event_title", this.f2359H);
    }

    public static String m2202m(EventReminderSettingsActivity eventReminderSettingsActivity) {
        return eventReminderSettingsActivity.f2363s.a(false, eventReminderSettingsActivity.f2358G.getTime(), null);
    }

    public static void m2200a(EventReminderSettingsActivity eventReminderSettingsActivity, GraphQLLightweightEventGuestStatus graphQLLightweightEventGuestStatus) {
        if (eventReminderSettingsActivity.f2369y.f2309a != graphQLLightweightEventGuestStatus) {
            Builder builder = new Builder();
            UserKey userKey = (UserKey) eventReminderSettingsActivity.f2366v.get();
            Iterator it = eventReminderSettingsActivity.f2368x.keySet().iterator();
            while (it.hasNext()) {
                UserKey userKey2 = (UserKey) it.next();
                if (!userKey2.equals(userKey)) {
                    builder.b(userKey2, eventReminderSettingsActivity.f2368x.get(userKey2));
                }
            }
            builder.b(userKey, graphQLLightweightEventGuestStatus);
            eventReminderSettingsActivity.f2368x = builder.b();
            eventReminderSettingsActivity.f2369y = eventReminderSettingsActivity.f2364t.m2178a(eventReminderSettingsActivity.f2370z, eventReminderSettingsActivity.f2368x);
            eventReminderSettingsActivity.f2355D.setMembers(eventReminderSettingsActivity.f2369y);
        }
    }

    public final ActionBar m2203a() {
        return this.f2360p.g();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        menu.clear();
        menu.add(2131241209).setOnMenuItemClickListener(new C04025(this));
        return onCreateOptionsMenu;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}

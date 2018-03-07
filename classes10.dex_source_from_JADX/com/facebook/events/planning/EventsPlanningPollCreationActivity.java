package com.facebook.events.planning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.planning.navigation.DefaultEventsPlanningNavHandler;
import com.facebook.events.ui.date.EventsCalendarDatePickerActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import java.util.ArrayList;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: b5b2861a931e6697eae26b889561765a */
public class EventsPlanningPollCreationActivity extends FbFragmentActivity {
    @Inject
    public DefaultEventsPlanningNavHandler f18988p;
    @Inject
    public SecureContextHelper f18989q;
    private FbFragmentActivity f18990r;
    private BetterListView f18991s;
    private EventsPlanningPollAdapter f18992t;
    public ArrayList<CalendarRange> f18993u;
    private int f18994v;
    private final OnClickListener f18995w = new C26931(this);
    private final OnClickListener f18996x = new C26942(this);

    /* compiled from: b5b2861a931e6697eae26b889561765a */
    class C26931 implements OnClickListener {
        final /* synthetic */ EventsPlanningPollCreationActivity f18985a;

        C26931(EventsPlanningPollCreationActivity eventsPlanningPollCreationActivity) {
            this.f18985a = eventsPlanningPollCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1010680466);
            this.f18985a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 491196153, a);
        }
    }

    /* compiled from: b5b2861a931e6697eae26b889561765a */
    class C26942 implements OnClickListener {
        final /* synthetic */ EventsPlanningPollCreationActivity f18986a;

        C26942(EventsPlanningPollCreationActivity eventsPlanningPollCreationActivity) {
            this.f18986a = eventsPlanningPollCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -966867708);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("extra_poll_times", this.f18986a.f18993u);
            this.f18986a.setResult(-1, intent);
            this.f18986a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1675755052, a);
        }
    }

    /* compiled from: b5b2861a931e6697eae26b889561765a */
    class C26953 implements OnClickListener {
        final /* synthetic */ EventsPlanningPollCreationActivity f18987a;

        C26953(EventsPlanningPollCreationActivity eventsPlanningPollCreationActivity) {
            this.f18987a = eventsPlanningPollCreationActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1950276477);
            EventsPlanningPollCreationActivity.m19234i(this.f18987a);
            Logger.a(2, EntryType.UI_INPUT_END, 1640145001, a);
        }
    }

    private static <T extends Context> void m19231a(Class<T> cls, T t) {
        m19232a((Object) t, (Context) t);
    }

    public static void m19232a(Object obj, Context context) {
        EventsPlanningPollCreationActivity eventsPlanningPollCreationActivity = (EventsPlanningPollCreationActivity) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        eventsPlanningPollCreationActivity.f18988p = new DefaultEventsPlanningNavHandler();
        eventsPlanningPollCreationActivity.f18989q = secureContextHelper;
    }

    protected final void m19235b(@Nullable Bundle bundle) {
        super.b(bundle);
        this.f18990r = this;
        Class cls = EventsPlanningPollCreationActivity.class;
        m19232a((Object) this, (Context) this);
        setContentView(2130906291);
        if (getIntent().hasExtra("extra_poll_times")) {
            this.f18993u = getIntent().getParcelableArrayListExtra("extra_poll_times");
        } else {
            this.f18993u = new ArrayList();
        }
        this.f18992t = new EventsPlanningPollAdapter(this, this.f18993u, 111);
        this.f18991s = (BetterListView) findViewById(2131566072);
        this.f18991s.setEmptyView(findViewById(2131566073));
        this.f18991s.setAdapter(this.f18992t);
        a(2131566074).setOnClickListener(new C26953(this));
        DefaultEventsPlanningNavHandler defaultEventsPlanningNavHandler = this.f18988p;
        String string = getString(2131241630);
        String string2 = getString(2131241631);
        findViewById(2131566071);
        defaultEventsPlanningNavHandler.m19245a(this, string, string2, this.f18995w, this.f18996x);
    }

    public static void m19234i(EventsPlanningPollCreationActivity eventsPlanningPollCreationActivity) {
        Calendar instance = Calendar.getInstance();
        instance.set(12, 0);
        instance.add(11, 1);
        Intent a = EventsCalendarDatePickerActivity.m19545a(eventsPlanningPollCreationActivity.f18990r, instance, null, false);
        a.putExtra("extra_enable_time_picker", true);
        eventsPlanningPollCreationActivity.f18989q.a(a, 110, (Activity) ContextUtils.a(eventsPlanningPollCreationActivity.f18990r, FbFragmentActivity.class));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Calendar calendar;
        Calendar calendar2 = null;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 110) {
            Calendar calendar3;
            if (intent.hasExtra("extra_start_time")) {
                calendar = (Calendar) intent.getSerializableExtra("extra_start_time");
            } else {
                calendar = null;
            }
            if (intent.hasExtra("extra_end_time")) {
                calendar3 = (Calendar) intent.getSerializableExtra("extra_end_time");
            } else {
                calendar3 = null;
            }
            this.f18993u.add(new CalendarRange(calendar, calendar3));
            AdapterDetour.a(this.f18992t, 1800689002);
        }
        if (i2 == -1 && i == 111) {
            if (intent.hasExtra("extra_start_time")) {
                calendar = (Calendar) intent.getSerializableExtra("extra_start_time");
            } else {
                calendar = null;
            }
            if (intent.hasExtra("extra_end_time")) {
                calendar2 = (Calendar) intent.getSerializableExtra("extra_end_time");
            }
            ((CalendarRange) this.f18993u.get(this.f18994v)).f18982a = calendar;
            ((CalendarRange) this.f18993u.get(this.f18994v)).f18983b = calendar2;
            AdapterDetour.a(this.f18992t, -1470940740);
        }
    }

    public static Intent m19229a(Context context) {
        return new Intent(context, EventsPlanningPollCreationActivity.class);
    }
}

package com.facebook.events.ui.date;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.ui.date.navigation.DefaultEventsCalendarNavHandler;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uicontrib.calendar.CalendarView;
import com.facebook.uicontrib.calendar.CalendarView$OnDateChangeListener;
import com.facebook.widget.CustomLinearLayout;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;
import junit.framework.Assert;

/* compiled from: application_request_delete_all */
public class EventsCalendarDatePickerActivity extends FbFragmentActivity {
    boolean f19399A;
    String f19400B;
    String f19401C;
    Boolean f19402D;
    Calendar f19403E;
    private final OnClickListener f19404F = new C27491(this);
    private final OnClickListener f19405G = new C27502(this);
    @Inject
    public EventsDashboardTimeFormatUtil f19406p;
    @Inject
    public DefaultEventsCalendarNavHandler f19407q;
    CalendarView f19408r;
    FbTextView f19409s;
    FbTextView f19410t;
    CustomLinearLayout f19411u;
    CustomLinearLayout f19412v;
    GlyphView f19413w;
    Calendar f19414x;
    Calendar f19415y;
    TimePicker f19416z;

    /* compiled from: application_request_delete_all */
    class C27491 implements OnClickListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19391a;

        C27491(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19391a = eventsCalendarDatePickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 297591591);
            this.f19391a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -438762346, a);
        }
    }

    /* compiled from: application_request_delete_all */
    class C27502 implements OnClickListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19392a;

        C27502(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19392a = eventsCalendarDatePickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -854955624);
            Intent intent = new Intent();
            intent.putExtra("extra_start_time", this.f19392a.f19414x);
            intent.putExtra("extra_end_time", this.f19392a.f19415y);
            this.f19392a.setResult(-1, intent);
            this.f19392a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 1693239734, a);
        }
    }

    /* compiled from: application_request_delete_all */
    class C27524 implements CalendarView$OnDateChangeListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19395a;

        C27524(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19395a = eventsCalendarDatePickerActivity;
        }

        public final void mo883a(Calendar calendar, Calendar calendar2) {
            if (calendar2 != null) {
                this.f19395a.f19415y = calendar2;
                this.f19395a.m19550a(this.f19395a.f19410t, calendar2);
            }
            this.f19395a.f19414x = calendar;
            this.f19395a.m19550a(this.f19395a.f19409s, calendar);
            if (!this.f19395a.f19399A) {
                this.f19395a.m19546a(this.f19395a.f19414x.get(11), this.f19395a.f19414x.get(12));
            } else if (this.f19395a.f19415y != null) {
                this.f19395a.m19546a(this.f19395a.f19415y.get(11), this.f19395a.f19415y.get(12));
            }
        }
    }

    /* compiled from: application_request_delete_all */
    class C27535 implements OnClickListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19396a;

        C27535(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19396a = eventsCalendarDatePickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 944769929);
            this.f19396a.f19412v.setVisibility(0);
            if (this.f19396a.f19415y == null) {
                this.f19396a.f19415y = Calendar.getInstance();
                this.f19396a.f19415y.setTime(this.f19396a.f19414x.getTime());
                this.f19396a.f19415y.add(11, 3);
            }
            this.f19396a.f19408r.setIsSelectingSecondDate(true);
            this.f19396a.f19399A = true;
            this.f19396a.f19408r.setDate(this.f19396a.f19415y.getTimeInMillis());
            this.f19396a.f19410t.performClick();
            ((LayoutParams) this.f19396a.f19416z.getLayoutParams()).topMargin = this.f19396a.getResources().getDimensionPixelSize(2131431131);
            this.f19396a.f19411u.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -974978591, a);
        }
    }

    /* compiled from: application_request_delete_all */
    class C27546 implements OnClickListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19397a;

        C27546(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19397a = eventsCalendarDatePickerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -685634086);
            this.f19397a.f19415y = null;
            this.f19397a.f19408r.a();
            this.f19397a.f19409s.performClick();
            ((LayoutParams) this.f19397a.f19416z.getLayoutParams()).topMargin = 0;
            this.f19397a.f19412v.setVisibility(8);
            this.f19397a.f19411u.setVisibility(0);
            Logger.a(2, EntryType.UI_INPUT_END, -540405877, a);
        }
    }

    /* compiled from: application_request_delete_all */
    class C27557 implements OnTimeChangedListener {
        final /* synthetic */ EventsCalendarDatePickerActivity f19398a;

        C27557(EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity) {
            this.f19398a = eventsCalendarDatePickerActivity;
        }

        public void onTimeChanged(TimePicker timePicker, int i, int i2) {
            this.f19398a.m19554a(this.f19398a.f19399A ? this.f19398a.f19415y : this.f19398a.f19414x, i, i2);
        }
    }

    private static <T extends Context> void m19552a(Class<T> cls, T t) {
        m19553a((Object) t, (Context) t);
    }

    public static void m19553a(Object obj, Context context) {
        EventsCalendarDatePickerActivity eventsCalendarDatePickerActivity = (EventsCalendarDatePickerActivity) obj;
        DefaultEventsCalendarNavHandler defaultEventsCalendarNavHandler = new DefaultEventsCalendarNavHandler();
        eventsCalendarDatePickerActivity.f19406p = EventsDashboardTimeFormatUtil.a(FbInjector.get(context));
        eventsCalendarDatePickerActivity.f19407q = defaultEventsCalendarNavHandler;
    }

    protected final void m19561b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventsCalendarDatePickerActivity.class;
        m19553a((Object) this, (Context) this);
        setContentView(2130904115);
        this.f19401C = getIntent().getStringExtra("extra_calendar_picker_title");
        this.f19402D = Boolean.valueOf(getIntent().getBooleanExtra("extra_enable_time_picker", false));
        DefaultEventsCalendarNavHandler defaultEventsCalendarNavHandler = this.f19407q;
        String string = StringUtil.a(this.f19401C) ? getString(2131236954) : this.f19401C;
        String string2 = getString(2131236903);
        findViewById(2131561481);
        defaultEventsCalendarNavHandler.m19631a(this, string, string2, this.f19404F, this.f19405G);
        this.f19400B = getResources().getString(2131236957);
        this.f19416z = (TimePicker) a(2131561489);
        this.f19416z.setVisibility(this.f19402D.booleanValue() ? 0 : 8);
        this.f19408r = (CalendarView) a(2131561488);
        this.f19403E = Calendar.getInstance();
        this.f19403E.add(6, -7);
        this.f19408r.a(this.f19403E.get(1), this.f19403E.get(2), this.f19403E.get(5));
        this.f19408r.aa = 10368000000L;
        m19556i();
        this.f19409s = (FbTextView) a(2131561483);
        m19551a(this.f19409s, false);
        this.f19410t = (FbTextView) a(2131561486);
        m19551a(this.f19410t, true);
        this.f19412v = (CustomLinearLayout) a(2131561485);
        this.f19411u = (CustomLinearLayout) a(2131561484);
        m19557j();
        this.f19413w = (GlyphView) a(2131561487);
        m19558k();
        m19559l();
        m19560m();
    }

    private void m19551a(FbTextView fbTextView, boolean z) {
        if (fbTextView != null) {
            fbTextView.setOnClickListener(m19555b(z));
        }
    }

    private OnClickListener m19555b(final boolean z) {
        return new OnClickListener(this) {
            final /* synthetic */ EventsCalendarDatePickerActivity f19394b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -766108866);
                this.f19394b.f19408r.setIsSelectingSecondDate(z);
                this.f19394b.f19399A = z;
                Resources resources = this.f19394b.getResources();
                if (z) {
                    this.f19394b.f19409s.setTextColor(resources.getColor(2131361974));
                    this.f19394b.f19410t.setTextColor(resources.getColor(2131361917));
                    if (this.f19394b.f19415y != null) {
                        this.f19394b.m19546a(this.f19394b.f19415y.get(11), this.f19394b.f19415y.get(12));
                    }
                } else {
                    this.f19394b.f19409s.setTextColor(resources.getColor(2131361917));
                    this.f19394b.f19410t.setTextColor(resources.getColor(2131361974));
                    if (this.f19394b.f19414x != null) {
                        this.f19394b.m19546a(this.f19394b.f19414x.get(11), this.f19394b.f19414x.get(12));
                    }
                }
                LogUtils.a(-1642595032, a);
            }
        };
    }

    private void m19556i() {
        this.f19408r.N = new C27524(this);
    }

    private void m19557j() {
        this.f19411u.setOnClickListener(new C27535(this));
    }

    private void m19558k() {
        this.f19413w.setOnClickListener(new C27546(this));
    }

    private void m19550a(FbTextView fbTextView, Calendar calendar) {
        if (this.f19402D.booleanValue()) {
            CharSequence a = this.f19406p.a(false, calendar.getTime(), null);
        } else {
            Object a2 = ((TimeFormatUtil) this.f19406p.d.get()).a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, calendar.getTime().getTime());
        }
        if (fbTextView == this.f19410t) {
            fbTextView.setText(StringFormatUtil.a(this.f19400B, new Object[]{a}));
            return;
        }
        fbTextView.setText(a);
    }

    private void m19546a(int i, int i2) {
        if (this.f19416z.getCurrentHour().intValue() != i) {
            this.f19416z.setCurrentHour(Integer.valueOf(i));
        }
        if (this.f19416z.getCurrentMinute().intValue() != i2) {
            this.f19416z.setCurrentMinute(Integer.valueOf(i2));
        }
    }

    private void m19559l() {
        if (getIntent().hasExtra("extra_start_time")) {
            this.f19409s.performClick();
            this.f19414x = (Calendar) getIntent().getSerializableExtra("extra_start_time");
            if (this.f19414x.before(this.f19408r.ab)) {
                this.f19408r.a(this.f19414x.get(1), this.f19414x.get(2), this.f19414x.get(5));
            }
            this.f19408r.setDate(this.f19414x.getTimeInMillis());
        }
        if (getIntent().hasExtra("extra_end_time")) {
            this.f19415y = (Calendar) getIntent().getSerializableExtra("extra_end_time");
            if (this.f19415y != null) {
                this.f19411u.performClick();
            }
        }
        if (!getIntent().getBooleanExtra("extra_is_selecting_second_date", false) || this.f19415y == null) {
            this.f19409s.performClick();
        }
    }

    private void m19560m() {
        this.f19416z.setOnTimeChangedListener(new C27557(this));
    }

    private void m19554a(Calendar calendar, int i, int i2) {
        this.f19403E.setTimeInMillis(calendar.getTimeInMillis());
        this.f19403E.set(11, i);
        this.f19403E.set(12, i2);
        this.f19408r.setDate(this.f19403E.getTimeInMillis());
    }

    public static Intent m19545a(Context context, Calendar calendar, @Nullable Calendar calendar2, boolean z) {
        Intent intent = new Intent(context, EventsCalendarDatePickerActivity.class);
        Assert.assertNotNull(calendar);
        intent.putExtra("extra_start_time", calendar);
        if (calendar2 != null) {
            intent.putExtra("extra_end_time", calendar2);
        }
        intent.putExtra("extra_is_selecting_second_date", z);
        return intent;
    }
}

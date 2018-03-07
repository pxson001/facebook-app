package com.facebook.events.ui.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.events.ui.date.DatePickerView.OnCalendarDatePickedListener;
import com.facebook.events.ui.date.TimePickerView.OnCalendarTimePickedListener;
import com.facebook.inject.FbInjector;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomRelativeLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: application_request_block_user */
public class StartAndEndTimeNikumanPicker extends CustomRelativeLayout {
    @Inject
    public Toaster f19429a;
    public DatePickerView f19430b;
    public TimePickerView f19431c;
    public View f19432d;
    public DatePickerView f19433e;
    public TimePickerView f19434f;
    private EventTimeModel f19435g;
    public boolean f19436h = false;

    /* compiled from: application_request_block_user */
    class C27581 implements OnCalendarDatePickedListener {
        final /* synthetic */ StartAndEndTimeNikumanPicker f19425a;

        C27581(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
            this.f19425a = startAndEndTimeNikumanPicker;
        }

        public final void mo884a(Calendar calendar) {
            this.f19425a.f19433e;
            this.f19425a.f19432d;
        }
    }

    /* compiled from: application_request_block_user */
    class C27592 implements OnCalendarTimePickedListener {
        final /* synthetic */ StartAndEndTimeNikumanPicker f19426a;

        C27592(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
            this.f19426a = startAndEndTimeNikumanPicker;
        }

        public final void mo885a(Calendar calendar) {
            if (calendar == null) {
                this.f19426a.f19433e.m19535a();
                this.f19426a.f19434f.m19628a();
                this.f19426a.f19432d.setVisibility(8);
            } else {
                this.f19426a.f19432d.setVisibility(0);
            }
            this.f19426a.f19433e;
            this.f19426a.f19432d;
        }
    }

    /* compiled from: application_request_block_user */
    class C27603 implements OnCalendarDatePickedListener {
        final /* synthetic */ StartAndEndTimeNikumanPicker f19427a;

        C27603(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
            this.f19427a = startAndEndTimeNikumanPicker;
        }

        public final void mo884a(Calendar calendar) {
            if (calendar == null) {
                this.f19427a.f19434f.m19628a();
            } else if (this.f19427a.f19434f.f19456e == null) {
                Calendar calendar2 = (Calendar) this.f19427a.f19431c.f19456e.clone();
                this.f19427a.f19434f.setTime(calendar2);
                if (StartAndEndTimeNikumanPicker.getStartTimestamp(this.f19427a) == StartAndEndTimeNikumanPicker.getEndTimestamp(this.f19427a)) {
                    calendar2.add(11, 1);
                    this.f19427a.f19434f.setTime(calendar2);
                }
            }
            this.f19427a.f19433e;
            this.f19427a.f19432d;
        }
    }

    /* compiled from: application_request_block_user */
    class C27614 implements OnCalendarTimePickedListener {
        final /* synthetic */ StartAndEndTimeNikumanPicker f19428a;

        C27614(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
            this.f19428a = startAndEndTimeNikumanPicker;
        }

        public final void mo885a(Calendar calendar) {
            if (calendar == null) {
                this.f19428a.f19433e.m19535a();
            } else if (this.f19428a.f19433e.f19384d == null) {
                Calendar calendar2 = (Calendar) this.f19428a.f19430b.f19384d.clone();
                calendar2.add(5, 1);
                this.f19428a.f19433e.setDate(calendar2);
            }
            this.f19428a.f19433e;
            this.f19428a.f19432d;
        }
    }

    private static <T extends View> void m19573a(Class<T> cls, T t) {
        m19574a((Object) t, t.getContext());
    }

    private static void m19574a(Object obj, Context context) {
        ((StartAndEndTimeNikumanPicker) obj).f19429a = Toaster.b(FbInjector.get(context));
    }

    private void m19572a(Toaster toaster) {
        this.f19429a = toaster;
    }

    public StartAndEndTimeNikumanPicker(Context context) {
        super(context);
        m19575b();
    }

    public StartAndEndTimeNikumanPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19575b();
    }

    public StartAndEndTimeNikumanPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19575b();
    }

    private void m19575b() {
        m19573a(StartAndEndTimeNikumanPicker.class, (View) this);
        setContentView(2130907223);
        this.f19430b = (DatePickerView) a(2131567624);
        this.f19431c = (TimePickerView) a(2131567625);
        this.f19432d = a(2131567626);
        this.f19433e = (DatePickerView) a(2131567627);
        this.f19434f = (TimePickerView) a(2131567628);
        m19580d();
    }

    public final void m19588a(EventTimeModel eventTimeModel) {
        this.f19435g = eventTimeModel;
        m19584f();
    }

    public final boolean m19589a() {
        return this.f19436h;
    }

    public static void m19578c(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
        startAndEndTimeNikumanPicker.f19436h = true;
        long endTimestamp = getEndTimestamp(startAndEndTimeNikumanPicker);
        if (endTimestamp != 0) {
            long startTimestamp = getStartTimestamp(startAndEndTimeNikumanPicker);
            Date date;
            Calendar instance;
            if (startTimestamp >= endTimestamp) {
                date = new Date(startTimestamp + 10800000);
                instance = Calendar.getInstance(startAndEndTimeNikumanPicker.f19435g.f19388c);
                instance.setTime(date);
                startAndEndTimeNikumanPicker.f19433e.setDate(instance);
                startAndEndTimeNikumanPicker.f19434f.setTime(instance);
                startAndEndTimeNikumanPicker.f19429a.b(new ToastBuilder(2131236946));
            } else if (endTimestamp - startTimestamp > 1209600000) {
                date = new Date(startTimestamp + 1209600000);
                instance = Calendar.getInstance(startAndEndTimeNikumanPicker.f19435g.f19388c);
                instance.setTime(date);
                startAndEndTimeNikumanPicker.f19433e.setDate(instance);
                startAndEndTimeNikumanPicker.f19434f.setTime(instance);
                startAndEndTimeNikumanPicker.f19429a.b(new ToastBuilder(startAndEndTimeNikumanPicker.getContext().getString(2131236947, new Object[]{Long.valueOf(2)})));
            }
            startAndEndTimeNikumanPicker.m19571a(startAndEndTimeNikumanPicker.f19431c, startAndEndTimeNikumanPicker.f19435g.f19389d);
            startAndEndTimeNikumanPicker.m19571a(startAndEndTimeNikumanPicker.f19434f, startAndEndTimeNikumanPicker.f19435g.f19390e);
        }
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19580d() {
        this.f19430b.f19385e = false;
        this.f19430b.f19383c = new C27581(this);
        this.f19431c.f19457f = false;
        this.f19431c.f19455d = new C27592(this);
        this.f19433e.f19385e = true;
        this.f19433e.f19383c = new C27603(this);
        this.f19434f.f19457f = true;
        this.f19434f.f19455d = new C27614(this);
    }

    public static void m19582e(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
        startAndEndTimeNikumanPicker.f19435g.m19538a(startAndEndTimeNikumanPicker.m19569a(startAndEndTimeNikumanPicker.f19430b, startAndEndTimeNikumanPicker.f19431c), startAndEndTimeNikumanPicker.m19569a(startAndEndTimeNikumanPicker.f19433e, startAndEndTimeNikumanPicker.f19434f));
    }

    public static long getStartTimestamp(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
        return startAndEndTimeNikumanPicker.m19569a(startAndEndTimeNikumanPicker.f19430b, startAndEndTimeNikumanPicker.f19431c);
    }

    public static long getEndTimestamp(StartAndEndTimeNikumanPicker startAndEndTimeNikumanPicker) {
        return startAndEndTimeNikumanPicker.m19569a(startAndEndTimeNikumanPicker.f19433e, startAndEndTimeNikumanPicker.f19434f);
    }

    private long m19569a(DatePickerView datePickerView, TimePickerView timePickerView) {
        Calendar instance = Calendar.getInstance(this.f19435g.f19388c);
        Calendar calendar = datePickerView.f19384d;
        instance.clear();
        if (calendar == null) {
            return 0;
        }
        if (timePickerView.f19456e == null) {
            instance.set(calendar.get(1), calendar.get(2), calendar.get(5));
        } else {
            Calendar calendar2 = timePickerView.f19456e;
            instance.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12));
        }
        return instance.getTimeInMillis();
    }

    private void m19584f() {
        Calendar instance = Calendar.getInstance(this.f19435g.f19388c);
        instance.setTimeInMillis(this.f19435g.f19389d);
        this.f19430b.setDate(instance);
        if (this.f19435g.f19387b) {
            this.f19431c.m19628a();
            this.f19432d.setVisibility(8);
        } else {
            this.f19431c.setTime(instance);
            this.f19432d.setVisibility(0);
        }
        m19571a(this.f19431c, this.f19435g.f19389d);
        if (this.f19435g.m19541e()) {
            instance = Calendar.getInstance(this.f19435g.f19388c);
            instance.setTimeInMillis(this.f19435g.f19390e);
            this.f19433e.setDate(instance);
            this.f19434f.setTime(instance);
        } else {
            this.f19433e.m19535a();
            this.f19434f.m19628a();
        }
        m19571a(this.f19434f, this.f19435g.f19390e);
    }

    private void m19571a(TimePickerView timePickerView, long j) {
        TimeZone timeZone = this.f19435g.f19388c;
        if (!TimeZone.getDefault().equals(timeZone) && j != 0) {
            timePickerView.setAppendedText(timeZone.getDisplayName(timeZone.inDaylightTime(new Date(j)), 0));
        }
    }
}

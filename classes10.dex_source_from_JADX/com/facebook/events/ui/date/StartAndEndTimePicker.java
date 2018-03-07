package com.facebook.events.ui.date;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
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

/* compiled from: application_request_accept */
public class StartAndEndTimePicker extends CustomRelativeLayout {
    @Inject
    public Toaster f19444a;
    public DatePickerView f19445b;
    public TimePickerView f19446c;
    public View f19447d;
    public DatePickerView f19448e;
    public TimePickerView f19449f;
    private TimeZone f19450g;
    public boolean f19451h = false;

    /* compiled from: application_request_accept */
    class C27621 implements OnCalendarDatePickedListener {
        final /* synthetic */ StartAndEndTimePicker f19437a;

        C27621(StartAndEndTimePicker startAndEndTimePicker) {
            this.f19437a = startAndEndTimePicker;
        }

        public final void mo884a(Calendar calendar) {
            this.f19437a.f19448e;
            StartAndEndTimePicker.m19604a(this.f19437a.f19446c, this.f19437a.getStartDate(), this.f19437a.getTimeZone());
        }
    }

    /* compiled from: application_request_accept */
    class C27632 implements OnCalendarTimePickedListener {
        final /* synthetic */ StartAndEndTimePicker f19438a;

        C27632(StartAndEndTimePicker startAndEndTimePicker) {
            this.f19438a = startAndEndTimePicker;
        }

        public final void mo885a(Calendar calendar) {
            if (calendar == null) {
                StartAndEndTimePicker.m19610b(this.f19438a.f19448e, this.f19438a.f19449f);
                this.f19438a.f19447d.setVisibility(8);
            } else {
                this.f19438a.f19447d.setVisibility(0);
            }
            this.f19438a.f19448e;
            StartAndEndTimePicker.m19604a(this.f19438a.f19446c, this.f19438a.getStartDate(), this.f19438a.getTimeZone());
        }
    }

    /* compiled from: application_request_accept */
    class C27643 implements OnCalendarDatePickedListener {
        final /* synthetic */ StartAndEndTimePicker f19439a;

        C27643(StartAndEndTimePicker startAndEndTimePicker) {
            this.f19439a = startAndEndTimePicker;
        }

        public final void mo884a(Calendar calendar) {
            if (calendar == null) {
                this.f19439a.f19449f.m19628a();
            } else if (this.f19439a.f19449f.f19456e == null) {
                Calendar calendar2 = (Calendar) this.f19439a.f19446c.f19456e.clone();
                this.f19439a.f19449f.setTime(calendar2);
                if (this.f19439a.getStartDate().equals(this.f19439a.getEndDate())) {
                    calendar2.add(11, 1);
                    this.f19439a.f19449f.setTime(calendar2);
                }
            }
            this.f19439a.f19448e;
            StartAndEndTimePicker.m19604a(this.f19439a.f19449f, this.f19439a.getEndDate(), this.f19439a.getTimeZone());
        }
    }

    /* compiled from: application_request_accept */
    class C27654 implements OnCalendarTimePickedListener {
        final /* synthetic */ StartAndEndTimePicker f19440a;

        C27654(StartAndEndTimePicker startAndEndTimePicker) {
            this.f19440a = startAndEndTimePicker;
        }

        public final void mo885a(Calendar calendar) {
            if (calendar == null) {
                this.f19440a.f19448e.m19535a();
            } else if (this.f19440a.f19448e.f19384d == null) {
                Calendar calendar2 = (Calendar) this.f19440a.f19445b.f19384d.clone();
                calendar2.add(5, 1);
                this.f19440a.f19448e.setDate(calendar2);
            }
            this.f19440a.f19448e;
            StartAndEndTimePicker.m19604a(this.f19440a.f19449f, this.f19440a.getEndDate(), this.f19440a.getTimeZone());
        }
    }

    /* compiled from: application_request_accept */
    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C27661();
        public Date f19441a;
        public boolean f19442b;
        public Date f19443c;

        /* compiled from: application_request_accept */
        final class C27661 implements Creator<SavedState> {
            C27661() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            if (parcel.readInt() == 1) {
                this.f19441a = new Date(parcel.readLong());
            }
            this.f19442b = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                this.f19443c = new Date(parcel.readLong());
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 0;
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f19441a == null ? 0 : 1);
            if (this.f19441a != null) {
                parcel.writeLong(this.f19441a.getTime());
            }
            if (this.f19442b) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (this.f19443c != null) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            if (this.f19443c != null) {
                parcel.writeLong(this.f19443c.getTime());
            }
        }
    }

    private static <T extends View> void m19606a(Class<T> cls, T t) {
        m19607a((Object) t, t.getContext());
    }

    private static void m19607a(Object obj, Context context) {
        ((StartAndEndTimePicker) obj).f19444a = Toaster.b(FbInjector.get(context));
    }

    public StartAndEndTimePicker(Context context) {
        super(context);
        m19609b();
    }

    public StartAndEndTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19609b();
    }

    private void m19605a(Toaster toaster) {
        this.f19444a = toaster;
    }

    public StartAndEndTimePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19609b();
    }

    private void m19609b() {
        m19606a(StartAndEndTimePicker.class, (View) this);
        setContentView(2130907224);
        this.f19445b = (DatePickerView) a(2131567624);
        this.f19446c = (TimePickerView) a(2131567625);
        this.f19447d = a(2131567626);
        this.f19448e = (DatePickerView) a(2131567627);
        this.f19449f = (TimePickerView) a(2131567628);
        m19614d();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19441a = getStartDate();
        savedState.f19442b = getIsDayEvent();
        savedState.f19443c = getEndDate();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m19617a(savedState.f19441a, savedState.f19442b);
            setEndDate(savedState.f19443c);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public boolean getIsDayEvent() {
        return this.f19446c.f19456e == null;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f19450g = timeZone;
        m19604a(this.f19446c, getStartDate(), getTimeZone());
        m19604a(this.f19449f, getEndDate(), getTimeZone());
    }

    public TimeZone getTimeZone() {
        if (this.f19450g != null) {
            return this.f19450g;
        }
        throw new IllegalStateException("Should not be getting time zone before it has been set.");
    }

    public Date getStartDate() {
        Date a = m19600a(this.f19445b, this.f19446c, getTimeZone());
        if (a == null) {
            return new Date();
        }
        return a;
    }

    public final void m19617a(Date date, boolean z) {
        Calendar instance = Calendar.getInstance(getTimeZone());
        if (date != null) {
            instance.setTime(date);
        }
        this.f19445b.setDate(instance);
        if (date == null) {
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            instance.add(11, 1);
        } else if (z) {
            this.f19446c.m19628a();
            this.f19447d.setVisibility(8);
            m19604a(this.f19446c, getStartDate(), getTimeZone());
        }
        this.f19446c.setTime(instance);
        this.f19447d.setVisibility(0);
        m19604a(this.f19446c, getStartDate(), getTimeZone());
    }

    public Date getEndDate() {
        return m19600a(this.f19448e, this.f19449f, getTimeZone());
    }

    public void setEndDate(Date date) {
        if (date == null) {
            m19610b(this.f19448e, this.f19449f);
        } else {
            m19602a(this.f19448e, this.f19449f, date, getTimeZone());
        }
    }

    public final boolean m19618a() {
        return this.f19451h;
    }

    public static void m19612c(StartAndEndTimePicker startAndEndTimePicker) {
        startAndEndTimePicker.f19451h = true;
        Date endDate = startAndEndTimePicker.getEndDate();
        if (endDate != null) {
            Date startDate = startAndEndTimePicker.getStartDate();
            Calendar instance;
            if (startDate.compareTo(endDate) >= 0) {
                endDate = new Date(startDate.getTime() + 10800000);
                instance = Calendar.getInstance(startAndEndTimePicker.getTimeZone());
                instance.setTime(endDate);
                startAndEndTimePicker.f19448e.setDate(instance);
                startAndEndTimePicker.f19449f.setTime(instance);
                startAndEndTimePicker.f19444a.b(new ToastBuilder(2131236946));
            } else if (endDate.getTime() - startDate.getTime() > 1209600000) {
                endDate = new Date((startDate.getTime() + 1209600000) - 86400000);
                instance = Calendar.getInstance(startAndEndTimePicker.getTimeZone());
                instance.setTime(endDate);
                startAndEndTimePicker.f19448e.setDate(instance);
                startAndEndTimePicker.f19444a.b(new ToastBuilder(startAndEndTimePicker.getContext().getString(2131236947, new Object[]{Long.valueOf(2)})));
            }
        }
    }

    private void m19614d() {
        this.f19445b.f19385e = false;
        this.f19445b.f19383c = new C27621(this);
        this.f19446c.f19457f = false;
        this.f19446c.f19455d = new C27632(this);
        this.f19448e.f19385e = true;
        this.f19448e.f19383c = new C27643(this);
        this.f19449f.f19457f = true;
        this.f19449f.f19455d = new C27654(this);
    }

    private static Date m19600a(DatePickerView datePickerView, TimePickerView timePickerView, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        Calendar calendar = datePickerView.f19384d;
        instance.clear();
        if (calendar == null) {
            return null;
        }
        if (timePickerView.f19456e == null) {
            instance.set(calendar.get(1), calendar.get(2), calendar.get(5));
        } else {
            Calendar calendar2 = timePickerView.f19456e;
            instance.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12));
        }
        return instance.getTime();
    }

    private static void m19602a(DatePickerView datePickerView, TimePickerView timePickerView, Date date, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(date);
        datePickerView.setDate(instance);
        timePickerView.setTime(instance);
        m19604a(timePickerView, date, timeZone);
    }

    public static void m19610b(DatePickerView datePickerView, TimePickerView timePickerView) {
        datePickerView.m19535a();
        timePickerView.m19628a();
    }

    public static void m19604a(TimePickerView timePickerView, Date date, TimeZone timeZone) {
        if (!TimeZone.getDefault().equals(timeZone) && date != null) {
            timePickerView.setAppendedText(timeZone.getDisplayName(timeZone.inDaylightTime(date), 0));
        }
    }
}

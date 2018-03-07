package com.facebook.events.ui.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.events.ui.date.util.DateTimeChangeListener;
import com.facebook.events.ui.date.util.QuickEventTimeUtils;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.Assisted;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: application_request_blocked_users */
public class QuickEventTimePickerDialog extends AlertDialog implements OnTimeChangedListener {
    private final TimeFormatUtil f19419b;
    @Nonnull
    public final Time f19420c;
    public Time f19421d;
    public TimePicker f19422e;
    public DateTimeChangeListener f19423f;
    private final TimeFormatStyle f19424g;

    /* compiled from: application_request_blocked_users */
    public class C27561 implements OnClickListener {
        final /* synthetic */ QuickEventTimePickerDialog f19417a;

        public C27561(QuickEventTimePickerDialog quickEventTimePickerDialog) {
            this.f19417a = quickEventTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            Time a = QuickEventTimeUtils.m19632a(this.f19417a.f19420c, this.f19417a.f19422e.getCurrentHour().intValue(), this.f19417a.f19422e.getCurrentMinute().intValue());
            QuickEventTimePickerDialog quickEventTimePickerDialog = this.f19417a;
            if (quickEventTimePickerDialog.f19423f != null) {
                Time time = quickEventTimePickerDialog.f19421d;
                boolean z = true;
                if (time != a) {
                    if (time == null || a == null) {
                        z = false;
                    } else if (!(time.allDay == a.allDay && time.toMillis(true) == a.toMillis(true))) {
                        z = false;
                    }
                }
                if (!z) {
                    quickEventTimePickerDialog.f19423f.mo886a(a);
                    quickEventTimePickerDialog.f19421d = a;
                }
            }
        }
    }

    /* compiled from: application_request_blocked_users */
    public class C27572 implements OnClickListener {
        final /* synthetic */ QuickEventTimePickerDialog f19418a;

        public C27572(QuickEventTimePickerDialog quickEventTimePickerDialog) {
            this.f19418a = quickEventTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        m19562a(QuickEventTimeUtils.m19632a(this.f19420c, i, i2));
    }

    private void m19562a(Time time) {
        setTitle(this.f19419b.a(this.f19424g, time.toMillis(true)));
    }

    @Inject
    public QuickEventTimePickerDialog(@Assisted Context context, @Nonnull @Assisted Time time, @Assisted DateTimeChangeListener dateTimeChangeListener, @Assisted TimeFormatStyle timeFormatStyle, TimeFormatUtil timeFormatUtil) {
        super(context, 0);
        this.f19421d = time;
        this.f19424g = timeFormatStyle;
        this.f19419b = timeFormatUtil;
        if (time.allDay) {
            Time time2 = new Time();
            time2.setToNow();
            this.f19420c = new Time(time);
            this.f19420c.set(0, time2.minute, time2.hour, time.monthDay, time.month, time.year);
        } else {
            this.f19420c = time;
        }
        this.f19423f = dateTimeChangeListener;
        m19563b();
    }

    @SuppressLint({"InflateParams"})
    private void m19563b() {
        this.f19422e = (TimePicker) LayoutInflater.from(getContext()).inflate(2130907428, null);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        this.f19422e.setIs24HourView(Boolean.valueOf(DateFormat.is24HourFormat(getContext())));
        this.f19422e.setCurrentHour(Integer.valueOf(this.f19420c.hour));
        this.f19422e.setCurrentMinute(Integer.valueOf(this.f19420c.minute));
        this.f19422e.setOnTimeChangedListener(this);
        m19562a(this.f19420c);
        this.f19422e.setLayoutParams(layoutParams);
        a(this.f19422e);
        a(-1, getContext().getString(2131230726), new C27561(this));
        a(-2, getContext().getString(2131236949), new C27572(this));
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putBoolean("is24Hour", this.f19422e.is24HourView());
        onSaveInstanceState.putInt("hour", this.f19422e.getCurrentHour().intValue());
        onSaveInstanceState.putInt("minute", this.f19422e.getCurrentMinute().intValue());
        return onSaveInstanceState;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        boolean z = bundle.getBoolean("is24Hour");
        int i = bundle.getInt("hour");
        int i2 = bundle.getInt("minute");
        this.f19422e.setIs24HourView(Boolean.valueOf(z));
        this.f19422e.setCurrentHour(Integer.valueOf(i));
        this.f19422e.setCurrentMinute(Integer.valueOf(i2));
    }
}

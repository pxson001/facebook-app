package com.facebook.uicontrib.datetimepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.messaging.events.banner.EventReminderEditTimeDialogFragment.C03821;
import com.facebook.messaging.events.banner.EventReminderMutator;
import com.facebook.messaging.events.banner.EventReminderSettingsActivity;
import com.facebook.messaging.events.banner.EventReminderSettingsActivity.C03992.C03981;
import com.google.common.base.Strings;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/* compiled from: extra_event_end_time */
public class DateTimePickerDialog extends AlertDialog {
    public DateTimePicker f12919b;
    public C03821 f12920c;

    /* compiled from: extra_event_end_time */
    public class C18051 implements OnClickListener {
        final /* synthetic */ DateTimePickerDialog f12917a;

        public C18051(DateTimePickerDialog dateTimePickerDialog) {
            this.f12917a = dateTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f12917a.f12920c != null) {
                C03821 c03821 = this.f12917a.f12920c;
                long timeInMillis = this.f12917a.f12919b.f12915c.f12932h.getTimeInMillis();
                if (timeInMillis > c03821.f2294a.am.a()) {
                    c03821.f2294a.aq.setTimeInMillis(timeInMillis);
                    if (!Strings.isNullOrEmpty(c03821.f2294a.au)) {
                        ((EventReminderMutator) c03821.f2294a.an.get()).m2192b(c03821.f2294a.au, c03821.f2294a.aq, c03821.f2294a.ar, c03821.f2294a.as);
                    } else if (!Strings.isNullOrEmpty(c03821.f2294a.ao) && timeInMillis != TimeUnit.SECONDS.toMillis(c03821.f2294a.ap)) {
                        ((EventReminderMutator) c03821.f2294a.an.get()).m2191a(c03821.f2294a.ao, c03821.f2294a.aq, c03821.f2294a.ar, c03821.f2294a.as);
                        if (c03821.f2294a.at != null) {
                            C03981 c03981 = c03821.f2294a.at;
                            c03981.f2347a.f2348a.f2358G = c03821.f2294a.aq;
                            c03981.f2347a.f2348a.f2354C.setText(EventReminderSettingsActivity.m2202m(c03981.f2347a.f2348a));
                        }
                    }
                }
            }
        }
    }

    /* compiled from: extra_event_end_time */
    public class C18062 implements OnClickListener {
        final /* synthetic */ DateTimePickerDialog f12918a;

        public C18062(DateTimePickerDialog dateTimePickerDialog) {
            this.f12918a = dateTimePickerDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public DateTimePickerDialog(Context context, Calendar calendar, C03821 c03821) {
        super(context);
        this.f12920c = c03821;
        this.f12919b = new DateTimePicker(getContext(), calendar);
        a(this.f12919b, 0, 0, 0, 0);
        a(-1, getContext().getString(2131230726), new C18051(this));
        a(-2, getContext().getString(2131230727), new C18062(this));
    }
}

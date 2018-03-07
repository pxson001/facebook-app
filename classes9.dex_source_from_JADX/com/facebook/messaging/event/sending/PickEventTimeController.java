package com.facebook.messaging.event.sending;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Calendar;
import javax.inject.Inject;

/* compiled from: mShowCardAddedNux */
public class PickEventTimeController {
    public final Context f11104a;
    public final TimeFormatUtil f11105b;

    /* compiled from: mShowCardAddedNux */
    public interface Host {
        void mo431a(Calendar calendar);
    }

    /* compiled from: mShowCardAddedNux */
    public class PickEventTimeDialog extends AlertDialog {
        private final TimeFormatUtil f11099b;
        private TextView f11100c;
        private TextView f11101d;
        public Calendar f11102e;
        public C12371 f11103f;

        /* compiled from: mShowCardAddedNux */
        class C12381 implements OnClickListener {
            final /* synthetic */ PickEventTimeDialog f11094a;

            C12381(PickEventTimeDialog pickEventTimeDialog) {
                this.f11094a = pickEventTimeDialog;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f11094a.dismiss();
                if (this.f11094a.f11103f != null) {
                    C12371 c12371 = this.f11094a.f11103f;
                    c12371.f11092a.mo431a(this.f11094a.f11102e);
                }
            }
        }

        /* compiled from: mShowCardAddedNux */
        class C12392 implements View.OnClickListener {
            final /* synthetic */ PickEventTimeDialog f11095a;

            C12392(PickEventTimeDialog pickEventTimeDialog) {
                this.f11095a = pickEventTimeDialog;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -202018812);
                PickEventTimeDialog pickEventTimeDialog = this.f11095a;
                new DatePickerDialog(pickEventTimeDialog.getContext(), new C12414(pickEventTimeDialog), pickEventTimeDialog.f11102e.get(1), pickEventTimeDialog.f11102e.get(2), pickEventTimeDialog.f11102e.get(5)).show();
                Logger.a(2, EntryType.UI_INPUT_END, 1796341574, a);
            }
        }

        /* compiled from: mShowCardAddedNux */
        class C12403 implements View.OnClickListener {
            final /* synthetic */ PickEventTimeDialog f11096a;

            C12403(PickEventTimeDialog pickEventTimeDialog) {
                this.f11096a = pickEventTimeDialog;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1895458997);
                PickEventTimeDialog pickEventTimeDialog = this.f11096a;
                new TimePickerDialog(pickEventTimeDialog.getContext(), new C12425(pickEventTimeDialog), pickEventTimeDialog.f11102e.get(11), pickEventTimeDialog.f11102e.get(12), DateFormat.is24HourFormat(pickEventTimeDialog.getContext())).show();
                Logger.a(2, EntryType.UI_INPUT_END, 1858360639, a);
            }
        }

        /* compiled from: mShowCardAddedNux */
        public class C12414 implements OnDateSetListener {
            final /* synthetic */ PickEventTimeDialog f11097a;

            public C12414(PickEventTimeDialog pickEventTimeDialog) {
                this.f11097a = pickEventTimeDialog;
            }

            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                PickEventTimeDialog.m11485a(this.f11097a, i, i2, i3);
            }
        }

        /* compiled from: mShowCardAddedNux */
        public class C12425 implements OnTimeSetListener {
            final /* synthetic */ PickEventTimeDialog f11098a;

            public C12425(PickEventTimeDialog pickEventTimeDialog) {
                this.f11098a = pickEventTimeDialog;
            }

            public void onTimeSet(TimePicker timePicker, int i, int i2) {
                PickEventTimeDialog.m11484a(this.f11098a, i, i2);
            }
        }

        protected PickEventTimeDialog(Context context, TimeFormatUtil timeFormatUtil) {
            super(context);
            this.f11099b = timeFormatUtil;
        }

        public void show() {
            throw new IllegalArgumentException("Use show(int, Calendar, Listener) instead");
        }

        public final void m11487a(int i, Calendar calendar, C12371 c12371) {
            this.f11102e = calendar;
            this.f11103f = c12371;
            Context context = getContext();
            LayoutInflater from = LayoutInflater.from(context);
            View frameLayout = new FrameLayout(context);
            View inflate = from.inflate(2130906227, frameLayout);
            a(frameLayout);
            a(null);
            setTitle(context.getString(i));
            a(context.getString(2131241000), new C12381(this));
            b(context.getString(2131241001), null);
            this.f11100c = (TextView) inflate.findViewById(2131565951);
            this.f11100c.setOnClickListener(new C12392(this));
            this.f11101d = (TextView) inflate.findViewById(2131565952);
            this.f11101d.setOnClickListener(new C12403(this));
            m11486d();
            super.show();
        }

        public static void m11485a(PickEventTimeDialog pickEventTimeDialog, int i, int i2, int i3) {
            pickEventTimeDialog.f11102e.set(i, i2, i3);
            pickEventTimeDialog.m11486d();
        }

        public static void m11484a(PickEventTimeDialog pickEventTimeDialog, int i, int i2) {
            pickEventTimeDialog.f11102e.set(11, i);
            pickEventTimeDialog.f11102e.set(12, i2);
            pickEventTimeDialog.m11486d();
        }

        private void m11486d() {
            this.f11100c.setText(PickEventTimeController.m11488c(this.f11099b, this.f11102e));
            this.f11101d.setText(PickEventTimeController.m11489d(this.f11099b, this.f11102e));
        }
    }

    @Inject
    public PickEventTimeController(Context context, TimeFormatUtil timeFormatUtil) {
        this.f11104a = context;
        this.f11105b = timeFormatUtil;
    }

    public final void m11490a(int i, final Host host) {
        Calendar instance = Calendar.getInstance();
        instance.add(12, 30 - (instance.get(12) % 30));
        new PickEventTimeDialog(this.f11104a, this.f11105b).m11487a(i, instance, new Object(this) {
            final /* synthetic */ PickEventTimeController f11093b;
        });
    }

    public static String m11488c(TimeFormatUtil timeFormatUtil, Calendar calendar) {
        return timeFormatUtil.a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, calendar.getTimeInMillis());
    }

    public static String m11489d(TimeFormatUtil timeFormatUtil, Calendar calendar) {
        return timeFormatUtil.a(TimeFormatStyle.HOUR_MINUTE_STYLE, calendar.getTimeInMillis());
    }
}

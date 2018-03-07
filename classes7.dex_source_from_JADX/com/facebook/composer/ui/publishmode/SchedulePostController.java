package com.facebook.composer.ui.publishmode;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import com.facebook.common.time.Clock;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.util.Calendar;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_crop */
public class SchedulePostController {
    public final SchedulePostControllerHost f17094a;
    public final Context f17095b;
    public final ScheduleCalendarDialog f17096c;
    public Calendar f17097d = Calendar.getInstance();
    public Toaster f17098e;
    public Clock f17099f;
    public final PublishModeTitleGenerator f17100g;

    /* compiled from: composer_crop */
    public interface SchedulePostControllerHost {
        void mo1337i();
    }

    /* compiled from: composer_crop */
    public class C13841 implements OnDateSetListener {
        final /* synthetic */ SchedulePostController f17083a;

        public C13841(SchedulePostController schedulePostController) {
            this.f17083a = schedulePostController;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            SchedulePostController schedulePostController = this.f17083a;
            schedulePostController.f17097d.set(i, i2, i3);
            schedulePostController.f17096c.m21037b();
        }
    }

    /* compiled from: composer_crop */
    public class C13852 implements OnTimeSetListener {
        final /* synthetic */ SchedulePostController f17084a;

        public C13852(SchedulePostController schedulePostController) {
            this.f17084a = schedulePostController;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            SchedulePostController schedulePostController = this.f17084a;
            schedulePostController.f17097d.set(11, i);
            schedulePostController.f17097d.set(12, i2);
            schedulePostController.f17096c.m21038c();
        }
    }

    /* compiled from: composer_crop */
    public class ScheduleCalendarDialog extends AlertDialog {
        public final /* synthetic */ SchedulePostController f17091b;
        public EditText f17092c;
        public EditText f17093d;

        /* compiled from: composer_crop */
        public class C13861 implements OnClickListener {
            final /* synthetic */ ScheduleCalendarDialog f17085a;

            public C13861(ScheduleCalendarDialog scheduleCalendarDialog) {
                this.f17085a = scheduleCalendarDialog;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* compiled from: composer_crop */
        public class C13882 implements OnShowListener {
            final /* synthetic */ ScheduleCalendarDialog f17087a;

            /* compiled from: composer_crop */
            class C13871 implements View.OnClickListener {
                final /* synthetic */ C13882 f17086a;

                C13871(C13882 c13882) {
                    this.f17086a = c13882;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -756662968);
                    if (SchedulePostController.m21039a(this.f17086a.f17087a.f17091b.f17097d.getTimeInMillis(), this.f17086a.f17087a.f17091b.f17099f.a(), this.f17086a.f17087a.f17091b.f17098e)) {
                        this.f17086a.f17087a.dismiss();
                        this.f17086a.f17087a.f17091b.f17094a.mo1337i();
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1269259151, a);
                }
            }

            public C13882(ScheduleCalendarDialog scheduleCalendarDialog) {
                this.f17087a = scheduleCalendarDialog;
            }

            public void onShow(DialogInterface dialogInterface) {
                this.f17087a.a(-1).setOnClickListener(new C13871(this));
            }
        }

        /* compiled from: composer_crop */
        public class C13893 implements OnClickListener {
            final /* synthetic */ ScheduleCalendarDialog f17088a;

            public C13893(ScheduleCalendarDialog scheduleCalendarDialog) {
                this.f17088a = scheduleCalendarDialog;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* compiled from: composer_crop */
        public class C13904 implements View.OnClickListener {
            final /* synthetic */ ScheduleCalendarDialog f17089a;

            public C13904(ScheduleCalendarDialog scheduleCalendarDialog) {
                this.f17089a = scheduleCalendarDialog;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1424534827);
                SchedulePostController schedulePostController = this.f17089a.f17091b;
                DatePickerDialog datePickerDialog = new DatePickerDialog(schedulePostController.f17095b, new C13841(schedulePostController), schedulePostController.f17097d.get(1), schedulePostController.f17097d.get(2), schedulePostController.f17097d.get(5));
                datePickerDialog.getDatePicker().setMinDate(Math.min(schedulePostController.f17099f.a() - 600000, schedulePostController.f17097d.getTimeInMillis()));
                datePickerDialog.show();
                Logger.a(2, EntryType.UI_INPUT_END, 883632623, a);
            }
        }

        /* compiled from: composer_crop */
        public class C13915 implements View.OnClickListener {
            final /* synthetic */ ScheduleCalendarDialog f17090a;

            public C13915(ScheduleCalendarDialog scheduleCalendarDialog) {
                this.f17090a = scheduleCalendarDialog;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 83239585);
                SchedulePostController schedulePostController = this.f17090a.f17091b;
                new TimePickerDialog(schedulePostController.f17095b, new C13852(schedulePostController), schedulePostController.f17097d.get(11), schedulePostController.f17097d.get(12), DateFormat.is24HourFormat(schedulePostController.f17095b)).show();
                Logger.a(2, EntryType.UI_INPUT_END, -964668626, a);
            }
        }

        protected ScheduleCalendarDialog(SchedulePostController schedulePostController, Context context) {
            this.f17091b = schedulePostController;
            super(context);
            View inflate = LayoutInflater.from(this.f17091b.f17095b).inflate(2130906957, null);
            a(inflate);
            a(null);
            setTitle(this.f17091b.f17095b.getString(2131234622));
            a(this.f17091b.f17095b.getString(2131234629), new C13861(this));
            setOnShowListener(new C13882(this));
            b(this.f17091b.f17095b.getString(2131230727), new C13893(this));
            this.f17092c = (EditText) inflate.findViewById(2131567236);
            this.f17092c.setOnClickListener(new C13904(this));
            m21037b();
            this.f17093d = (EditText) inflate.findViewById(2131567237);
            this.f17093d.setOnClickListener(new C13915(this));
            m21038c();
        }

        public final void m21037b() {
            this.f17092c.setText(this.f17091b.f17100g.m21035b(this.f17091b.f17097d.getTimeInMillis()));
        }

        public final void m21038c() {
            this.f17093d.setText(this.f17091b.f17100g.m21036c(this.f17091b.f17097d.getTimeInMillis()));
        }
    }

    @Inject
    public SchedulePostController(@Nonnull @Assisted SchedulePostControllerHost schedulePostControllerHost, @Nullable @Assisted Long l, Toaster toaster, Clock clock, Context context, PublishModeTitleGenerator publishModeTitleGenerator) {
        this.f17094a = schedulePostControllerHost;
        this.f17095b = context;
        this.f17098e = toaster;
        this.f17099f = clock;
        this.f17100g = publishModeTitleGenerator;
        if (l == null || l.longValue() < 0) {
            this.f17097d.add(12, 11);
        } else {
            this.f17097d.setTimeInMillis(l.longValue() * 1000);
        }
        this.f17096c = new ScheduleCalendarDialog(this, this.f17095b);
    }

    public static boolean m21039a(long j, long j2, Toaster toaster) {
        if (j - j2 < 600000) {
            toaster.b(new ToastBuilder(2131234620));
            return false;
        } else if (j - j2 <= 15552000000L) {
            return true;
        } else {
            toaster.b(new ToastBuilder(2131234621));
            return false;
        }
    }
}

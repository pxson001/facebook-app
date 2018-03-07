package com.facebook.events.ui.date;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ultralight.Inject;
import com.facebook.widget.dialog.FbDatePickerDialog;
import java.util.Calendar;
import javax.inject.Provider;

/* compiled from: application_request_unblock_user */
public class DatePickerView extends FbEditText implements OnDateSetListener, OnDismissListener, OnClickListener {
    @Inject
    public Provider<TimeFormatUtil> f19382b;
    public OnCalendarDatePickedListener f19383c;
    public Calendar f19384d = null;
    public boolean f19385e = false;

    /* compiled from: application_request_unblock_user */
    class C27471 implements DialogInterface.OnClickListener {
        final /* synthetic */ DatePickerView f19381a;

        C27471(DatePickerView datePickerView) {
            this.f19381a = datePickerView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19381a.m19535a();
            DatePickerView.m19534c(this.f19381a);
        }
    }

    /* compiled from: application_request_unblock_user */
    public interface OnCalendarDatePickedListener {
        void mo884a(Calendar calendar);
    }

    private static <T extends View> void m19530a(Class<T> cls, T t) {
        m19531a((Object) t, t.getContext());
    }

    private static void m19531a(Object obj, Context context) {
        ((DatePickerView) obj).f19382b = IdBasedSingletonScopeProvider.a(FbInjector.get(context), 610);
    }

    public DatePickerView(Context context) {
        super(context);
        m19533b();
    }

    public DatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19533b();
    }

    public DatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19533b();
    }

    private void m19532a(Provider<TimeFormatUtil> provider) {
        this.f19382b = provider;
    }

    public void setOnCalendarDatePickedListener(OnCalendarDatePickedListener onCalendarDatePickedListener) {
        this.f19383c = onCalendarDatePickedListener;
    }

    public Calendar getPickedDate() {
        return this.f19384d;
    }

    private void m19528a(int i, int i2, int i3) {
        this.f19384d = Calendar.getInstance();
        this.f19384d.set(i, i2, i3);
        setText(((TimeFormatUtil) this.f19382b.get()).a(TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE, this.f19384d.getTimeInMillis()));
    }

    public void setDate(Calendar calendar) {
        m19528a(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    public final void m19535a() {
        this.f19384d = null;
        setText("");
    }

    public void setIsClearable(boolean z) {
        this.f19385e = z;
    }

    private void m19533b() {
        m19530a(DatePickerView.class, (View) this);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 35639869);
        if (this.f19384d == null) {
            this.f19384d = Calendar.getInstance();
        }
        FbDatePickerDialog fbDatePickerDialog = new FbDatePickerDialog(new ContextThemeWrapper(getContext(), 2131625746), this, this.f19384d.get(1), this.f19384d.get(2), this.f19384d.get(5));
        fbDatePickerDialog.setOnDismissListener(this);
        if (this.f19385e) {
            fbDatePickerDialog.setButton(-2, getContext().getString(2131236948), new C27471(this));
        }
        fbDatePickerDialog.show();
        Logger.a(2, EntryType.UI_INPUT_END, 1233681680, a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f19384d != null) {
            m19528a(this.f19384d.get(1), this.f19384d.get(2), this.f19384d.get(5));
        }
        m19534c(this);
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        if (this.f19384d != null) {
            m19528a(i, i2, i3);
        }
        m19534c(this);
    }

    public static void m19534c(DatePickerView datePickerView) {
        if (datePickerView.f19383c != null) {
            datePickerView.f19383c.mo884a(datePickerView.f19384d);
        }
    }
}

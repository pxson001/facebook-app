package com.facebook.events.ui.date;

import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.format.Time;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.util.StringUtil;
import com.facebook.events.ui.date.util.DateTimeChangeListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import java.util.Calendar;
import javax.inject.Provider;

/* compiled from: application_request_block_application */
public class TimePickerView extends FbEditText implements OnClickListener, DateTimeChangeListener {
    @Inject
    volatile Provider<TimeFormatUtil> f19453b = UltralightRuntime.a;
    @Inject
    QuickEventTimePickerDialogProvider f19454c;
    public OnCalendarTimePickedListener f19455d;
    public Calendar f19456e = null;
    public boolean f19457f = false;
    private String f19458g = null;

    /* compiled from: application_request_block_application */
    public interface OnCalendarTimePickedListener {
        void mo885a(Calendar calendar);
    }

    /* compiled from: application_request_block_application */
    class C27671 implements DialogInterface.OnClickListener {
        final /* synthetic */ TimePickerView f19452a;

        C27671(TimePickerView timePickerView) {
            this.f19452a = timePickerView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f19452a.m19628a();
            TimePickerView.m19627d(this.f19452a);
        }
    }

    private static <T extends View> void m19622a(Class<T> cls, T t) {
        m19623a((Object) t, t.getContext());
    }

    private static void m19623a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimePickerView) obj).m19624a(IdBasedSingletonScopeProvider.a(fbInjector, 610), (QuickEventTimePickerDialogProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickEventTimePickerDialogProvider.class));
    }

    public TimePickerView(Context context) {
        super(context);
        m19626c();
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19626c();
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19626c();
    }

    public void setOnCalendarTimePickedListener(OnCalendarTimePickedListener onCalendarTimePickedListener) {
        this.f19455d = onCalendarTimePickedListener;
    }

    public Calendar getPickedTime() {
        return this.f19456e;
    }

    private void m19620a(int i, int i2) {
        this.f19456e = Calendar.getInstance();
        this.f19456e.set(11, i);
        this.f19456e.set(12, i2);
        m19625b();
    }

    public void setTime(Calendar calendar) {
        m19620a(calendar.get(11), calendar.get(12));
    }

    public final void m19628a() {
        this.f19456e = null;
        m19625b();
    }

    public void setAppendedText(String str) {
        this.f19458g = str;
        m19625b();
    }

    private void m19625b() {
        if (this.f19456e == null) {
            setText("");
            return;
        }
        CharSequence spannableString = new SpannableString(((TimeFormatUtil) this.f19453b.get()).a(TimeFormatStyle.HOUR_MINUTE_STYLE, this.f19456e.getTimeInMillis()));
        if (!StringUtil.a(this.f19458g)) {
            CharSequence string = getResources().getString(2131236956, new Object[]{string, this.f19458g});
            int indexOf = string.indexOf(this.f19458g);
            int a = indexOf + StringLengthHelper.a(this.f19458g);
            spannableString = new SpannableString(string);
            spannableString.setSpan(new AbsoluteSizeSpan((int) getResources().getDimension(2131427400)), indexOf, a, 17);
        }
        setText(spannableString);
    }

    public void setIsClearable(boolean z) {
        this.f19457f = z;
    }

    private void m19626c() {
        m19622a(TimePickerView.class, (View) this);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1577998704);
        if (this.f19456e == null) {
            this.f19456e = Calendar.getInstance();
            this.f19456e.set(11, (this.f19456e.get(11) + 1) % 24);
            this.f19456e.set(12, 0);
        }
        Time time = new Time();
        time.set(this.f19456e.getTimeInMillis());
        QuickEventTimePickerDialogProvider quickEventTimePickerDialogProvider = this.f19454c;
        AlertDialog quickEventTimePickerDialog = new QuickEventTimePickerDialog(getContext(), time, this, TimeFormatStyle.HOUR_MINUTE_STYLE, (TimeFormatUtil) DefaultTimeFormatUtil.a(quickEventTimePickerDialogProvider));
        if (this.f19457f) {
            quickEventTimePickerDialog.a(-2, getContext().getString(2131236948), new C27671(this));
        }
        quickEventTimePickerDialog.show();
        Logger.a(2, EntryType.UI_INPUT_END, 1294072219, a);
    }

    private void m19624a(Provider<TimeFormatUtil> provider, QuickEventTimePickerDialogProvider quickEventTimePickerDialogProvider) {
        this.f19453b = provider;
        this.f19454c = quickEventTimePickerDialogProvider;
    }

    public final void mo886a(Time time) {
        if (this.f19456e != null) {
            m19620a(time.hour, time.minute);
        }
        m19627d(this);
    }

    public static void m19627d(TimePickerView timePickerView) {
        if (timePickerView.f19455d != null) {
            timePickerView.f19455d.mo885a(timePickerView.f19456e);
        }
    }
}

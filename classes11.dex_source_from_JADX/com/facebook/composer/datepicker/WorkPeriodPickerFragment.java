package com.facebook.composer.datepicker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.uicontrib.datepicker.DatePicker;
import com.facebook.uicontrib.datepicker.DatePicker.OnSelectedDateChangedListener;

/* compiled from: handleApplicationStrictModeViolation */
public class WorkPeriodPickerFragment extends FbFragment implements IResultIntentFragment {
    private DatePicker f6375a;
    public DatePicker f6376b;
    public LinearLayout f6377c;
    public TextView f6378d;
    public boolean f6379e;

    /* compiled from: handleApplicationStrictModeViolation */
    class C08001 implements OnSelectedDateChangedListener {
        final /* synthetic */ WorkPeriodPickerFragment f6373a;

        C08001(WorkPeriodPickerFragment workPeriodPickerFragment) {
            this.f6373a = workPeriodPickerFragment;
        }

        public final void m7803a(Date date) {
            this.f6373a.f6376b.setMinimumDate(date);
        }
    }

    /* compiled from: handleApplicationStrictModeViolation */
    class C08012 implements OnCheckedChangeListener {
        final /* synthetic */ WorkPeriodPickerFragment f6374a;

        C08012(WorkPeriodPickerFragment workPeriodPickerFragment) {
            this.f6374a = workPeriodPickerFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                WorkPeriodPickerFragment workPeriodPickerFragment = this.f6374a;
                workPeriodPickerFragment.f6379e = true;
                workPeriodPickerFragment.f6377c.setVisibility(8);
                return;
            }
            workPeriodPickerFragment = this.f6374a;
            workPeriodPickerFragment.f6379e = false;
            workPeriodPickerFragment.f6377c.setVisibility(0);
            workPeriodPickerFragment.f6378d.setText(2131242368);
        }
    }

    public final View m7804a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1592777596);
        View inflate = layoutInflater.inflate(2130907785, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1602415194, a);
        return inflate;
    }

    public final void m7805a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f6375a = (DatePicker) view.findViewById(2131561153);
        this.f6376b = (DatePicker) view.findViewById(2131561155);
        this.f6377c = (LinearLayout) view.findViewById(2131568566);
        this.f6375a.b = new C08001(this);
        this.f6378d = (TextView) view.findViewById(2131561154);
        CheckBox checkBox = (CheckBox) view.findViewById(2131568565);
        checkBox.setText(this.s.getString("currentActionText"));
        checkBox.setOnCheckedChangeListener(new C08012(this));
        if (bundle == null) {
            boolean z;
            Date date = (Date) this.s.getParcelable("minimumDate");
            Date date2 = (Date) this.s.getParcelable("startDate");
            Date date3 = (Date) this.s.getParcelable("endDate");
            if (date2 == null || this.s.getBoolean("isCurrent")) {
                z = true;
            } else {
                z = false;
            }
            this.f6379e = z;
            if (date != null) {
                this.f6375a.setMinimumDate(date);
            }
            DatePicker datePicker = this.f6375a;
            if (date2 == null) {
                date2 = Date.a;
            }
            datePicker.setSelectedDate(date2);
            this.f6376b.setSelectedDate(date3);
            if (this.f6379e) {
                checkBox.setChecked(true);
                return;
            }
            return;
        }
        this.f6379e = bundle.getBoolean("isCurrent");
    }

    public final void m7807e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("isCurrent", this.f6379e);
    }

    public final Intent mo187b() {
        Intent intent = new Intent();
        Parcelable selectedDate = this.f6375a.getSelectedDate();
        if (DateUtil.m7797a(selectedDate)) {
            selectedDate = null;
        }
        intent.putExtra("startDate", selectedDate);
        if (this.f6379e) {
            intent.putExtra("isCurrent", true);
        } else {
            intent.putExtra("endDate", this.f6376b.getSelectedDate());
        }
        return intent;
    }
}

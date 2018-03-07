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
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.uicontrib.datepicker.DatePicker;
import com.facebook.uicontrib.datepicker.DatePicker.OnSelectedDateChangedListener;

/* compiled from: handleResponse */
public class EducationPeriodPickerFragment extends FbFragment implements IResultIntentFragment {
    private DatePicker f6370a;
    public DatePicker f6371b;
    public boolean f6372c;

    /* compiled from: handleResponse */
    class C07981 implements OnSelectedDateChangedListener {
        final /* synthetic */ EducationPeriodPickerFragment f6368a;

        C07981(EducationPeriodPickerFragment educationPeriodPickerFragment) {
            this.f6368a = educationPeriodPickerFragment;
        }

        public final void m7798a(Date date) {
            this.f6368a.f6371b.setMinimumDate(date);
        }
    }

    /* compiled from: handleResponse */
    class C07992 implements OnCheckedChangeListener {
        final /* synthetic */ EducationPeriodPickerFragment f6369a;

        C07992(EducationPeriodPickerFragment educationPeriodPickerFragment) {
            this.f6369a = educationPeriodPickerFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                this.f6369a.f6372c = true;
            } else {
                this.f6369a.f6372c = false;
            }
        }
    }

    public final View m7799a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 990748103);
        View inflate = layoutInflater.inflate(2130903963, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 794002215, a);
        return inflate;
    }

    public final void m7800a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f6370a = (DatePicker) view.findViewById(2131561153);
        this.f6371b = (DatePicker) view.findViewById(2131561155);
        this.f6370a.b = new C07981(this);
        CheckBox checkBox = (CheckBox) view.findViewById(2131561156);
        checkBox.setText(getContext().getString(2131242373));
        checkBox.setOnCheckedChangeListener(new C07992(this));
        if (bundle == null) {
            Date date = (Date) this.s.getParcelable("minimumDate");
            Date date2 = (Date) this.s.getParcelable("startDate");
            Date date3 = (Date) this.s.getParcelable("endDate");
            this.f6372c = this.s.getBoolean("hasGraduated");
            if (date != null) {
                this.f6370a.setMinimumDate(date);
            }
            DatePicker datePicker = this.f6370a;
            if (date2 == null) {
                date2 = Date.a;
            }
            datePicker.setSelectedDate(date2);
            this.f6371b.setSelectedDate(date3);
            if (this.f6372c) {
                checkBox.setChecked(true);
                return;
            }
            return;
        }
        this.f6372c = bundle.getBoolean("hasGraduated");
    }

    public final void m7802e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("hasGraduated", this.f6372c);
    }

    public final Intent mo187b() {
        Intent intent = new Intent();
        Parcelable selectedDate = this.f6370a.getSelectedDate();
        if (DateUtil.m7797a(selectedDate)) {
            selectedDate = null;
        }
        intent.putExtra("startDate", selectedDate);
        intent.putExtra("endDate", this.f6371b.getSelectedDate());
        intent.putExtra("hasGraduated", this.f6372c);
        return intent;
    }
}

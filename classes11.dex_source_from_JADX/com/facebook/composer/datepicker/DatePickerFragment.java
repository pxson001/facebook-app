package com.facebook.composer.datepicker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.datepicker.Date;
import com.facebook.uicontrib.datepicker.DatePicker;

/* compiled from: handler_start */
public class DatePickerFragment extends FbFragment implements IResultIntentFragment {
    public final View m7794a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1431332495);
        View inflate = layoutInflater.inflate(2130903665, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2052072757, a);
        return inflate;
    }

    public final void m7795a(View view, Bundle bundle) {
        super.a(view, bundle);
        DatePicker datePicker = (DatePicker) view.findViewById(2131560497);
        Date date = (Date) this.s.getParcelable("minimumDate");
        if (date != null) {
            datePicker.setMinimumDate(date);
        }
        date = (Date) this.s.getParcelable("startDate");
        if (date == null) {
            date = Date.a;
        }
        datePicker.setSelectedDate(date);
    }

    public final Intent mo187b() {
        Intent intent = new Intent();
        Parcelable selectedDate = ((DatePicker) this.T.findViewById(2131560497)).getSelectedDate();
        if (DateUtil.m7797a(selectedDate)) {
            selectedDate = null;
        }
        intent.putExtra("startDate", selectedDate);
        return intent;
    }
}

package com.facebook.timeline.tempprofilepic;

import android.content.res.Resources;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.inject.Inject;

/* compiled from: facecast_event_name */
public class ExpirationDialogNumberPickersViewBinder {
    public static final SimpleDateFormat f14950a = new SimpleDateFormat("MMM d");
    private final Resources f14951b;

    @Inject
    public ExpirationDialogNumberPickersViewBinder(Resources resources) {
        this.f14951b = resources;
    }

    public final void m18789a(ExpirationDialogModel expirationDialogModel, NumberPicker numberPicker, OnValueChangeListener onValueChangeListener, NumberPicker numberPicker2, OnValueChangeListener onValueChangeListener2, NumberPicker numberPicker3, OnValueChangeListener onValueChangeListener3, NumberPicker numberPicker4, OnValueChangeListener onValueChangeListener4) {
        if (!expirationDialogModel.m18783f()) {
            if (expirationDialogModel.m18786i()) {
                expirationDialogModel.m18785h();
            } else {
                expirationDialogModel.m18780a(3, 1);
            }
        }
        m18787a(numberPicker, 0, m18788a(), onValueChangeListener, expirationDialogModel.f14947e);
        m18787a(numberPicker2, 1, this.f14951b.getStringArray(2131755078), onValueChangeListener2, expirationDialogModel.f14948f % 12);
        m18787a(numberPicker3, 0, this.f14951b.getStringArray(2131755079), onValueChangeListener3, expirationDialogModel.f14949g / 15);
        m18787a(numberPicker4, 0, this.f14951b.getStringArray(2131755080), onValueChangeListener4, expirationDialogModel.f14948f / 12);
    }

    private static void m18787a(NumberPicker numberPicker, int i, String[] strArr, OnValueChangeListener onValueChangeListener, int i2) {
        numberPicker.setMinValue(i);
        numberPicker.setMaxValue((strArr.length + i) - 1);
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setDescendantFocusability(393216);
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker.setValue(i2);
    }

    private static String[] m18788a() {
        Calendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = (Calendar) gregorianCalendar.clone();
        int actualMaximum = calendar.getActualMaximum(5);
        for (int i = 0; i < 3; i++) {
            calendar.add(2, 1);
            actualMaximum += calendar.getActualMaximum(5);
        }
        int i2 = actualMaximum;
        String[] strArr = new String[i2];
        strArr[0] = "Today";
        for (int i3 = 1; i3 < i2; i3++) {
            gregorianCalendar.add(6, 1);
            strArr[i3] = f14950a.format(gregorianCalendar.getTime());
        }
        return strArr;
    }
}

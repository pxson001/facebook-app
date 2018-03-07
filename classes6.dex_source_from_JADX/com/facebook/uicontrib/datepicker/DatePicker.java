package com.facebook.uicontrib.datepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.facebook.R;
import com.facebook.uicontrib.datepicker.Date.Builder;
import com.facebook.uicontrib.datepicker.DatePickerRow.OnSelectionChangedListener;
import com.facebook.widget.CustomLinearLayout;
import java.util.Calendar;
import javax.annotation.Nullable;

/* compiled from: search_ad */
public class DatePicker extends CustomLinearLayout {
    private static final Date f5245a;
    public OnSelectedDateChangedListener f5246b;
    private DatePickerRow f5247c;
    private DatePickerRow f5248d;
    private DatePickerRow f5249e;
    private Period f5250f;
    private boolean f5251g;

    /* compiled from: search_ad */
    class C03141 implements OnSelectionChangedListener {
        final /* synthetic */ DatePicker f5244a;

        C03141(DatePicker datePicker) {
            this.f5244a = datePicker;
        }

        public final void mo352a(int i) {
            if (i == 2131560880) {
                this.f5244a.f5246b;
            } else if (i == 2131560881) {
                DatePicker.m7951d(this.f5244a);
            }
            if (this.f5244a.f5246b != null) {
                this.f5244a.f5246b.m7940a(this.f5244a.getSelectedDate());
            }
        }
    }

    /* compiled from: search_ad */
    public interface OnSelectedDateChangedListener {
        void m7940a(Date date);
    }

    static {
        Builder builder = new Builder();
        builder.f5238a = Calendar.getInstance().get(1);
        builder = builder;
        builder.f5239b = null;
        builder = builder;
        builder.f5240c = null;
        f5245a = builder.m7932a();
    }

    public DatePicker(Context context) {
        super(context);
        m7942a(context, null, 0);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7942a(context, attributeSet, 0);
    }

    public Date getSelectedDate() {
        if (getSelectedYear() == 0) {
            return null;
        }
        Builder builder = new Builder();
        builder.f5238a = getSelectedYear();
        builder = builder;
        builder.f5239b = getSelectedMonth();
        builder = builder;
        builder.f5240c = getSelectedDay();
        return builder.m7932a();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Parcelable bundle = new Bundle();
        bundle.putParcelable("superSavedState", onSaveInstanceState);
        bundle.putParcelable("selectedDate", getSelectedDate());
        bundle.putParcelable("period", this.f5250f);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("superSavedState"));
            this.f5250f = (Period) bundle.getParcelable("period");
            setupSpinners((Date) bundle.getParcelable("selectedDate"));
        }
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    public void setSelectedDate(Date date) {
        if (date == null) {
            setupSpinners(this.f5251g ? Date.f5242b : f5245a);
        } else {
            setupSpinners(date);
        }
    }

    public void setMinimumDate(Date date) {
        this.f5250f.f5270c = date;
        m7941a();
    }

    public void setMaximumDate(Date date) {
        this.f5250f.f5271d = date;
        m7941a();
    }

    public void setOnSelectedDateChangedListener(OnSelectedDateChangedListener onSelectedDateChangedListener) {
        this.f5246b = onSelectedDateChangedListener;
    }

    private void m7941a() {
        ((YearsAdapter) this.f5247c.getSpinnerAdapter()).f5273b = this.f5250f;
        ((MonthsAdapter) this.f5248d.getSpinnerAdapter()).f5267c = this.f5250f;
        ((DatesAdapter) this.f5249e.getSpinnerAdapter()).f5264d = this.f5250f;
        m7946b();
    }

    private void m7942a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DatePicker, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f5251g = obtainStyledAttributes.getBoolean(0, false);
        }
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setContentView(2130903840);
        setPadding(getResources().getDimensionPixelSize(2131430590), 0, getResources().getDimensionPixelSize(2131430590), 0);
        this.f5250f = new Period();
        this.f5250f.f5271d = Date.f5241a;
        setupSpinners(this.f5251g ? Date.f5242b : f5245a);
    }

    private void setupSpinners(Date date) {
        this.f5247c = (DatePickerRow) findViewById(2131560880);
        this.f5248d = (DatePickerRow) findViewById(2131560881);
        this.f5249e = (DatePickerRow) findViewById(2131560882);
        OnSelectionChangedListener onSelectionChangedListener = getOnSelectionChangedListener();
        m7944a(onSelectionChangedListener, date.m7933a(), this.f5251g);
        m7945a(onSelectionChangedListener, date.m7934b());
        m7948b(onSelectionChangedListener, date.m7935c());
    }

    private OnSelectionChangedListener getOnSelectionChangedListener() {
        return new C03141(this);
    }

    private void m7944a(OnSelectionChangedListener onSelectionChangedListener, int i, boolean z) {
        this.f5247c.setLabelText(getResources().getString(2131235786));
        this.f5247c.setClearButtonAccessibilityText(getResources().getString(2131235789));
        this.f5247c.setAddViewText(getResources().getString(2131235783));
        this.f5247c.setIsOptional(z);
        Object yearsAdapter = new YearsAdapter(getContext(), 2130903842, this.f5250f);
        yearsAdapter.setDropDownViewResource(17367049);
        this.f5247c.setSpinnerAdapter(yearsAdapter);
        this.f5247c.f5259e = onSelectionChangedListener;
        this.f5247c.setActive(i != 0);
        if (this.f5247c.f5260f) {
            this.f5247c.setSpinnerSelection(yearsAdapter.m7982a(i));
        }
    }

    private void m7945a(OnSelectionChangedListener onSelectionChangedListener, Integer num) {
        boolean z;
        int i = 0;
        this.f5248d.setLabelText(getResources().getString(2131235787));
        this.f5248d.setClearButtonAccessibilityText(getResources().getString(2131235790));
        this.f5248d.setAddViewText(getResources().getString(2131235784));
        Object monthsAdapter = new MonthsAdapter(getContext(), 2130903842, getSelectedYear(), this.f5250f);
        monthsAdapter.setDropDownViewResource(17367049);
        this.f5248d.setSpinnerAdapter(monthsAdapter);
        this.f5248d.f5259e = onSelectionChangedListener;
        DatePickerRow datePickerRow = this.f5248d;
        if (!this.f5247c.f5260f || num == null) {
            z = false;
        } else {
            z = true;
        }
        datePickerRow.setActive(z);
        if (this.f5248d.f5260f) {
            this.f5248d.setSpinnerSelection(monthsAdapter.m7971a(num));
        }
        DatePickerRow datePickerRow2 = this.f5248d;
        if (!this.f5247c.f5260f) {
            i = 8;
        }
        datePickerRow2.setVisibility(i);
    }

    private void m7948b(OnSelectionChangedListener onSelectionChangedListener, Integer num) {
        boolean z;
        int i = 0;
        this.f5249e.setLabelText(getResources().getString(2131235788));
        this.f5249e.setClearButtonAccessibilityText(getResources().getString(2131235791));
        this.f5249e.setAddViewText(getResources().getString(2131235785));
        Object datesAdapter = new DatesAdapter(getContext(), 2130903842, getSelectedYear(), getSelectedMonth(), this.f5250f);
        datesAdapter.setDropDownViewResource(17367049);
        this.f5249e.setSpinnerAdapter(datesAdapter);
        this.f5249e.f5259e = onSelectionChangedListener;
        DatePickerRow datePickerRow = this.f5249e;
        if (!this.f5248d.f5260f || num == null) {
            z = false;
        } else {
            z = true;
        }
        datePickerRow.setActive(z);
        if (this.f5249e.f5260f) {
            this.f5249e.setSpinnerSelection(datesAdapter.m7966a(num));
        }
        DatePickerRow datePickerRow2 = this.f5249e;
        if (!this.f5248d.f5260f) {
            i = 8;
        }
        datePickerRow2.setVisibility(i);
    }

    private void m7946b() {
        boolean z;
        int selectedYear = getSelectedYear();
        YearsAdapter yearsAdapter = (YearsAdapter) this.f5247c.getSpinnerAdapter();
        yearsAdapter.m7983a();
        DatePickerRow datePickerRow = this.f5247c;
        if (selectedYear != 0) {
            Object obj;
            if (yearsAdapter.f5273b.m7973a() > selectedYear || selectedYear > yearsAdapter.f5273b.m7974b()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                z = true;
                datePickerRow.setActive(z);
                if (this.f5247c.f5260f) {
                    this.f5247c.setSpinnerSelection(yearsAdapter.m7982a(selectedYear));
                }
                this.f5246b;
            }
        }
        z = false;
        datePickerRow.setActive(z);
        if (this.f5247c.f5260f) {
            this.f5247c.setSpinnerSelection(yearsAdapter.m7982a(selectedYear));
        }
        this.f5246b;
    }

    public static void m7950c(DatePicker datePicker) {
        int i = 0;
        Integer selectedMonth = datePicker.getSelectedMonth();
        int selectedYear = datePicker.getSelectedYear();
        if (selectedYear == 0) {
            datePicker.f5248d.setActive(false);
        } else {
            boolean z;
            MonthsAdapter monthsAdapter = (MonthsAdapter) datePicker.f5248d.getSpinnerAdapter();
            monthsAdapter.f5266b = selectedYear;
            monthsAdapter.m7972a();
            DatePickerRow datePickerRow = datePicker.f5248d;
            if (selectedMonth != null) {
                Object obj = 1;
                if (selectedMonth != null) {
                    if (monthsAdapter.f5266b == 0) {
                        obj = null;
                    } else if (monthsAdapter.f5266b < monthsAdapter.f5267c.m7973a() || monthsAdapter.f5266b > monthsAdapter.f5267c.m7974b()) {
                        obj = null;
                    } else if (monthsAdapter.f5266b == monthsAdapter.f5267c.m7974b() && selectedMonth.intValue() > monthsAdapter.f5267c.m7976d().intValue()) {
                        obj = null;
                    } else if (monthsAdapter.f5266b == monthsAdapter.f5267c.m7973a() && selectedMonth.intValue() < monthsAdapter.f5267c.m7975c().intValue()) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    z = true;
                    datePickerRow.setActive(z);
                    if (datePicker.f5248d.f5260f) {
                        datePicker.f5248d.setSpinnerSelection(monthsAdapter.m7971a(selectedMonth));
                    }
                }
            }
            z = false;
            datePickerRow.setActive(z);
            if (datePicker.f5248d.f5260f) {
                datePicker.f5248d.setSpinnerSelection(monthsAdapter.m7971a(selectedMonth));
            }
        }
        DatePickerRow datePickerRow2 = datePicker.f5248d;
        if (!datePicker.f5247c.f5260f) {
            i = 8;
        }
        datePickerRow2.setVisibility(i);
        m7951d(datePicker);
    }

    public static void m7951d(DatePicker datePicker) {
        int i = 0;
        Integer selectedDay = datePicker.getSelectedDay();
        Integer selectedMonth = datePicker.getSelectedMonth();
        int selectedYear = datePicker.getSelectedYear();
        if (selectedMonth == null) {
            datePicker.f5249e.setActive(false);
        } else {
            boolean z;
            DatesAdapter datesAdapter = (DatesAdapter) datePicker.f5249e.getSpinnerAdapter();
            datesAdapter.f5262b = selectedYear;
            datesAdapter.f5263c = selectedMonth;
            datesAdapter.m7967a();
            DatePickerRow datePickerRow = datePicker.f5249e;
            if (selectedDay == null || !datesAdapter.m7968b(selectedDay)) {
                z = false;
            } else {
                z = true;
            }
            datePickerRow.setActive(z);
            if (datePicker.f5249e.f5260f) {
                datePicker.f5249e.setSpinnerSelection(datesAdapter.m7966a(selectedDay));
            }
        }
        DatePickerRow datePickerRow2 = datePicker.f5249e;
        if (!datePicker.f5248d.f5260f) {
            i = 8;
        }
        datePickerRow2.setVisibility(i);
    }

    private int getSelectedYear() {
        if (this.f5247c.f5260f) {
            return YearsAdapter.m7979a(this.f5247c.getSpinnerSelection());
        }
        return 0;
    }

    @Nullable
    private Integer getSelectedMonth() {
        if (!this.f5248d.f5260f) {
            return null;
        }
        return Integer.valueOf(MonthsAdapter.f5265a.indexOf(this.f5248d.getSpinnerSelection()) + 1);
    }

    @Nullable
    private Integer getSelectedDay() {
        if (!this.f5249e.f5260f) {
            return null;
        }
        return Integer.valueOf(DatesAdapter.f5261a.indexOf(this.f5249e.getSpinnerSelection()) + 1);
    }
}

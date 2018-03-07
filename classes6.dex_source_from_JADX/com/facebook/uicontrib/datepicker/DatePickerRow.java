package com.facebook.uicontrib.datepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: search_awareness/ */
public class DatePickerRow extends CustomFrameLayout {
    private FbTextView f5255a;
    public Spinner f5256b;
    private ImageView f5257c;
    private FbTextView f5258d;
    public OnSelectionChangedListener f5259e;
    public boolean f5260f;

    /* compiled from: search_awareness/ */
    public interface OnSelectionChangedListener {
        void mo352a(int i);
    }

    /* compiled from: search_awareness/ */
    class C03151 implements OnItemSelectedListener {
        final /* synthetic */ DatePickerRow f5252a;

        C03151(DatePickerRow datePickerRow) {
            this.f5252a = datePickerRow;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f5252a.f5259e != null) {
                this.f5252a.f5259e.mo352a(this.f5252a.getId());
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: search_awareness/ */
    class C03162 implements OnClickListener {
        final /* synthetic */ DatePickerRow f5253a;

        C03162(DatePickerRow datePickerRow) {
            this.f5253a = datePickerRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 951228709);
            this.f5253a.setActive(false);
            if (this.f5253a.f5259e != null) {
                this.f5253a.f5259e.mo352a(this.f5253a.getId());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -518468575, a);
        }
    }

    /* compiled from: search_awareness/ */
    class C03173 implements OnClickListener {
        final /* synthetic */ DatePickerRow f5254a;

        C03173(DatePickerRow datePickerRow) {
            this.f5254a = datePickerRow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1684935825);
            if (!this.f5254a.f5260f) {
                this.f5254a.setActive(true);
                this.f5254a.f5259e.mo352a(this.f5254a.getId());
            }
            this.f5254a.f5256b.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, 1173264359, a);
        }
    }

    public DatePickerRow(Context context) {
        this(context, null);
    }

    public DatePickerRow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DatePickerRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7953b();
    }

    private void m7953b() {
        setContentView(2130903841);
        this.f5255a = (FbTextView) findViewById(2131560883);
        this.f5256b = (Spinner) findViewById(2131560884);
        this.f5257c = (ImageView) findViewById(2131560885);
        this.f5258d = (FbTextView) findViewById(2131560886);
        this.f5256b.setOnItemSelectedListener(new C03151(this));
        this.f5257c.setOnClickListener(new C03162(this));
        setOnClickListener(new C03173(this));
        setActive(false);
    }

    public void setLabelText(String str) {
        this.f5255a.setText(str);
    }

    public String getSpinnerSelection() {
        return this.f5256b.getSelectedItem().toString();
    }

    public SpinnerAdapter getSpinnerAdapter() {
        return this.f5256b.getAdapter();
    }

    public void setSpinnerAdapter(SpinnerAdapter spinnerAdapter) {
        this.f5256b.setAdapter(spinnerAdapter);
    }

    public void setSpinnerSelection(int i) {
        this.f5256b.setSelection(i);
    }

    public void setIsOptional(boolean z) {
        if (z) {
            this.f5257c.setImageResource(2130838084);
            this.f5257c.setImportantForAccessibility(0);
            return;
        }
        this.f5257c.setImageResource(17170445);
        this.f5257c.setImportantForAccessibility(2);
    }

    public void setClearButtonAccessibilityText(String str) {
        this.f5257c.setContentDescription(str);
    }

    public void setAddViewText(String str) {
        this.f5258d.setText(str);
    }

    public void setOnSelectionChangedListener(OnSelectionChangedListener onSelectionChangedListener) {
        this.f5259e = onSelectionChangedListener;
    }

    public final boolean m7956a() {
        return this.f5260f;
    }

    public void setActive(boolean z) {
        this.f5260f = z;
        if (this.f5260f) {
            this.f5258d.setVisibility(8);
            this.f5255a.setVisibility(0);
            this.f5256b.setVisibility(0);
            this.f5257c.setVisibility(0);
            this.f5256b.setSelection(0);
            return;
        }
        this.f5255a.setVisibility(8);
        this.f5256b.setVisibility(8);
        this.f5257c.setVisibility(8);
        this.f5258d.setVisibility(0);
    }
}

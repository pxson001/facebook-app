package com.facebook.crowdsourcing.placequestion;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: com.facebook.iorg.app.activity.IorgDialogActivity */
public class PlaceQuestionAnswerView extends CustomLinearLayout implements Checkable {
    private TextView f17512a;
    private CheckBox f17513b;

    public PlaceQuestionAnswerView(Context context) {
        super(context);
        m21409a(null);
    }

    public PlaceQuestionAnswerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21409a(attributeSet);
    }

    public void setChecked(boolean z) {
        this.f17513b.setChecked(z);
    }

    public boolean isChecked() {
        return this.f17513b.isChecked();
    }

    public void toggle() {
        this.f17513b.setChecked(!this.f17513b.isChecked());
    }

    public void setAnswerLabel(String str) {
        this.f17512a.setText(str);
    }

    public void setCheckBoxVisibility(int i) {
        this.f17513b.setVisibility(i);
        this.f17512a.setGravity(i == 0 ? 8388611 : 1);
    }

    private void m21409a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PlaceQuestionAnswerView);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        setOrientation(0);
        setContentView(2130906257);
        this.f17512a = (TextView) a(2131565984);
        this.f17513b = (CheckBox) a(2131565985);
        setCheckBoxVisibility(z ? 0 : 8);
    }
}

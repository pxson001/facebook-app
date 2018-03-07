package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: Unsupported status for account component */
public abstract class BaseEditableRadioGroupView extends CustomLinearLayout {
    protected EditableRadioGroup f23057a;
    public EditableRadioButton f23058b;
    public ImmutableList<FbCustomRadioButton> f23059c;

    protected abstract void mo1033a();

    public BaseEditableRadioGroupView(Context context) {
        super(context);
        mo1033a();
    }

    public BaseEditableRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1033a();
    }

    protected BaseEditableRadioGroupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1033a();
    }

    public final void m25050e(int i) {
        boolean z = i >= 0 && i < this.f23059c.size();
        Preconditions.checkArgument(z);
        this.f23057a.m25129a(this.f23057a.getChildAt(i).getId());
    }

    public void setOnCheckChangedListener(OnCheckedChangeRadioGroupListener onCheckedChangeRadioGroupListener) {
        this.f23057a.f23144d = onCheckedChangeRadioGroupListener;
    }

    public int getSelectedIndex() {
        View findViewById = this.f23057a.findViewById(this.f23057a.f23141a);
        if (findViewById == null || findViewById.getTag() == null) {
            return -1;
        }
        return ((Integer) findViewById.getTag()).intValue();
    }

    public final void m25049c() {
        this.f23058b.setTextEditText("");
        this.f23058b.setChecked(false);
        this.f23057a.m25128a();
    }

    public void setRadioButtonClickListeners(OnClickListener onClickListener) {
        for (int i = 0; i < this.f23059c.size(); i++) {
            ((FbCustomRadioButton) this.f23059c.get(i)).setOnClickListener(onClickListener);
        }
    }
}

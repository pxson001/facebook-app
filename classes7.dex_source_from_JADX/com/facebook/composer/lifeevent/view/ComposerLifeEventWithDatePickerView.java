package com.facebook.composer.lifeevent.view;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: context_item_impression */
public class ComposerLifeEventWithDatePickerView extends CustomLinearLayout implements ComposerLifeEventEditor {
    private static final CallerContext f16813a = CallerContext.a(ComposerLifeEventWithDatePickerView.class);
    private FbDraweeView f16814b;
    private EditText f16815c;
    private TextView f16816d;

    public ComposerLifeEventWithDatePickerView(Context context) {
        super(context);
        m20816c();
    }

    public ComposerLifeEventWithDatePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20816c();
    }

    public ComposerLifeEventWithDatePickerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20816c();
    }

    private void m20816c() {
        setContentView(2130903694);
        this.f16814b = (FbDraweeView) a(2131560549);
        this.f16815c = (EditText) a(2131560550);
        this.f16816d = (TextView) a(2131560551);
    }

    public final void hr_() {
        this.f16815c.requestFocus();
        this.f16815c.setSelection(this.f16815c.getText().length());
    }

    public void setIsTitleEditable(boolean z) {
        this.f16815c.setEnabled(z);
    }

    public final boolean hs_() {
        return this.f16815c.isEnabled();
    }

    public void setTitle(String str) {
        this.f16815c.setText(str);
    }

    public final void mo1293a(TextWatcher textWatcher) {
        this.f16815c.addTextChangedListener(textWatcher);
    }

    public void setIconUri(String str) {
        this.f16814b.a(UriUtil.a(str), f16813a);
    }

    public void setIconSize(int i) {
        this.f16814b.getLayoutParams().width = i;
        this.f16814b.getLayoutParams().height = i;
    }

    public void setDatePickerClickListener(OnClickListener onClickListener) {
        this.f16816d.setOnClickListener(onClickListener);
    }

    public void setDateLabel(String str) {
        this.f16816d.setText(str);
    }
}

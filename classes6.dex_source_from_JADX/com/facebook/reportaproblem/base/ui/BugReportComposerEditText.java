package com.facebook.reportaproblem.base.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.EditText;

/* compiled from: setProductItemAttachment */
public class BugReportComposerEditText extends EditText {
    public String f4596a;
    public Spannable f4597b;
    public boolean f4598c;

    /* compiled from: setProductItemAttachment */
    class C02791 implements TextWatcher {
        final /* synthetic */ BugReportComposerEditText f4595a;

        C02791(BugReportComposerEditText bugReportComposerEditText) {
            this.f4595a = bugReportComposerEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int i = (!this.f4595a.f4598c || editable.length() == 0) ? 0 : 1;
            if (i != 0) {
                if (this.f4595a.f4597b == null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    i = editable.length();
                    this.f4595a.f4597b = this.f4595a.m7099a(" " + this.f4595a.getResources().getString(2131235890, new Object[]{this.f4595a.f4596a}));
                    editable.append(this.f4595a.f4597b);
                    this.f4595a.setSelection(i);
                } else if (editable.length() == this.f4595a.f4597b.length()) {
                    this.f4595a.f4597b = null;
                    editable.clear();
                }
            }
        }
    }

    public BugReportComposerEditText(Context context) {
        super(context);
        m7100a();
    }

    public BugReportComposerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7100a();
    }

    public BugReportComposerEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7100a();
    }

    public void setCategoryDescription(String str) {
        this.f4596a = str;
        this.f4598c = true;
        m7103b();
    }

    public String getWrittenDescription() {
        String obj = getText() == null ? "" : getText().toString();
        if (this.f4597b != null) {
            return obj.substring(0, obj.length() - this.f4597b.length());
        }
        return obj;
    }

    private void m7100a() {
        addTextChangedListener(new C02791(this));
        m7103b();
    }

    private Spannable m7099a(String str) {
        int indexOf = str.indexOf(this.f4596a);
        Spannable spannableStringBuilder = new SpannableStringBuilder(str);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131363154)), 0, indexOf, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131363150)), indexOf, this.f4596a.length() + indexOf, 33);
        }
        return spannableStringBuilder;
    }

    private void m7103b() {
        if (this.f4598c) {
            setHint(m7099a(getResources().getString(2131235889, new Object[]{this.f4596a})));
        }
    }

    private int getEndIndex() {
        Editable text = getText();
        if (text == null || this.f4597b == null) {
            return -1;
        }
        return text.length() - this.f4597b.length();
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (getEndIndex() != -1) {
            setSelection(Math.min(Math.max(i, 0), getEndIndex()), Math.max(0, Math.min(i2, getEndIndex())));
        }
    }
}

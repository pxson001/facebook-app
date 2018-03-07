package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: clickListener */
public class SuggestEditsMultiValueView extends CustomLinearLayout {
    private TextView f17710a;
    private Drawable f17711b;
    private Drawable f17712c;
    private String f17713d;
    private String f17714e;

    public SuggestEditsMultiValueView(Context context) {
        super(context);
        m21573b();
    }

    public SuggestEditsMultiValueView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21573b();
    }

    public SuggestEditsMultiValueView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21573b();
    }

    private void m21573b() {
        setContentView(2130907306);
        setOrientation(1);
        this.f17710a = (TextView) a(2131567756);
        this.f17711b = getResources().getDrawable(2130843502);
        this.f17713d = getResources().getString(2131239164);
        this.f17712c = getResources().getDrawable(2130843509);
        this.f17714e = getResources().getString(2131239163);
    }

    public final void m21574a() {
        removeViews(0, getChildCount() - 1);
        this.f17710a.setOnClickListener(null);
    }

    public final void m21575a(String str, String str2, OnClickListener onClickListener) {
        SuggestEditsTextFieldView a = m21571a(str2, onClickListener);
        a.setFieldText(str);
        a.m21593a(this.f17711b, this.f17713d);
        m21572a(a);
    }

    public final void m21576b(String str, String str2, OnClickListener onClickListener) {
        SuggestEditsTextFieldView a = m21571a(str2, onClickListener);
        CharSequence spannableString = new SpannableString(str);
        spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 0);
        a.setFieldHintText(spannableString);
        a.m21593a(this.f17712c, this.f17714e);
        m21572a(a);
    }

    public void setAddText(@Nullable String str) {
        this.f17710a.setText(str);
        this.f17710a.setContentDescription(str != null ? str.toLowerCase(Locale.getDefault()) : null);
        this.f17710a.setVisibility(Strings.isNullOrEmpty(str) ? 8 : 0);
    }

    public void setAddValueListener(OnClickListener onClickListener) {
        this.f17710a.setOnClickListener(onClickListener);
    }

    private void m21572a(View view) {
        addView(view, getChildCount() - 1);
    }

    private SuggestEditsTextFieldView m21571a(String str, OnClickListener onClickListener) {
        SuggestEditsTextFieldView suggestEditsTextFieldView = (SuggestEditsTextFieldView) LayoutInflater.from(getContext()).inflate(2130907311, this, false);
        suggestEditsTextFieldView.setFieldTextFocusable(false);
        suggestEditsTextFieldView.setFieldTextLongClickable(false);
        suggestEditsTextFieldView.setActionButtonVisible(true);
        suggestEditsTextFieldView.setActionButtonOnClickListener(onClickListener);
        suggestEditsTextFieldView.setFieldOnClickListener(onClickListener);
        suggestEditsTextFieldView.setIcon(str);
        return suggestEditsTextFieldView;
    }
}

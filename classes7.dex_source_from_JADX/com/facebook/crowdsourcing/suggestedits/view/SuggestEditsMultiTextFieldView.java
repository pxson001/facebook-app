package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: click_back_button_after_submit */
public class SuggestEditsMultiTextFieldView extends CustomLinearLayout {
    public SuggestEditsTextFieldView f17707a;
    private Drawable f17708b;
    private String f17709c;

    /* compiled from: click_back_button_after_submit */
    public interface OnFocusChangeListenerWithChildIndex {
        void mo1374a(View view, boolean z, int i);
    }

    public SuggestEditsTextFieldView getPrimaryTextField() {
        return this.f17707a;
    }

    public SuggestEditsMultiTextFieldView(Context context) {
        super(context);
        m21567b();
    }

    public SuggestEditsMultiTextFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21567b();
    }

    public SuggestEditsMultiTextFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21567b();
    }

    private void m21567b() {
        setOrientation(1);
        this.f17708b = getResources().getDrawable(2130843502);
        this.f17709c = getResources().getString(2131239164);
    }

    public final void m21570a() {
        clearFocus();
        removeAllViews();
        this.f17707a = m21568c();
        addView(this.f17707a);
    }

    public final SuggestEditsTextFieldView m21569a(@Nullable String str, OnClickListener onClickListener, final SuggestEditsController suggestEditsController, String str2) {
        SuggestEditsTextFieldView c = m21568c();
        c.setFieldText(str);
        c.setIcon(str2);
        c.setTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SuggestEditsMultiTextFieldView f17703b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                suggestEditsController.m21473a();
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        c.m21593a(this.f17708b, this.f17709c);
        c.setActionButtonOnClickListener(onClickListener);
        addView(c);
        return c;
    }

    private SuggestEditsTextFieldView m21568c() {
        SuggestEditsTextFieldView suggestEditsTextFieldView = (SuggestEditsTextFieldView) LayoutInflater.from(getContext()).inflate(2130907311, this, false);
        suggestEditsTextFieldView.setActionButtonVisible(true);
        return suggestEditsTextFieldView;
    }

    public void setOnFocusChangeListener(final OnFocusChangeListenerWithChildIndex onFocusChangeListenerWithChildIndex) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ SuggestEditsMultiTextFieldView f17706c;

                public void onFocusChange(View view, boolean z) {
                    onFocusChangeListenerWithChildIndex.mo1374a(view, z, i);
                }
            });
        }
    }

    public ImmutableList<String> getValues() {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof SuggestEditsTextFieldView) {
                builder.c(((SuggestEditsTextFieldView) getChildAt(i)).getText());
            }
        }
        return builder.b();
    }

    public SuggestEditsTextFieldView getLastTextFieldView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (getChildAt(childCount) instanceof SuggestEditsTextFieldView) {
                return (SuggestEditsTextFieldView) getChildAt(childCount);
            }
        }
        return null;
    }
}

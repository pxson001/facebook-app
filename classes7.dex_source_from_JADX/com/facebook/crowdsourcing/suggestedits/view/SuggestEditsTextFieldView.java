package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: claim_offer */
public class SuggestEditsTextFieldView extends CustomLinearLayout {
    public EditText f17728a;
    private FbDraweeView f17729b;
    public ImageView f17730c;
    private int f17731d;
    private TextWatcher f17732e;

    public SuggestEditsTextFieldView(Context context) {
        super(context);
        m21591a(context, null);
    }

    public SuggestEditsTextFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21591a(context, attributeSet);
    }

    public SuggestEditsTextFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21591a(context, attributeSet);
    }

    public EditText getFieldValueView() {
        return this.f17728a;
    }

    private void m21591a(Context context, AttributeSet attributeSet) {
        setContentView(2130907310);
        setOrientation(0);
        this.f17728a = (EditText) a(2131567758);
        this.f17729b = (FbDraweeView) a(2131567750);
        this.f17730c = (ImageView) a(2131567759);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuggestEditsTextFieldView);
        setIconVisible(obtainStyledAttributes.getBoolean(0, false));
        setActionButtonVisible(obtainStyledAttributes.getBoolean(1, false));
        obtainStyledAttributes.recycle();
        this.f17731d = getResources().getDimensionPixelSize(2131432716);
    }

    public final void m21592a() {
        setTextChangedListener(null);
        setFieldHintText(null);
        setFieldOnClickListener(null);
        setOnFocusChangeListener(null);
        setFieldText(null);
        setIconVisible(true);
        setActionButtonVisible(true);
        setActionButtonOnClickListener(null);
        setFocusable(true);
    }

    public View getActionButtonView() {
        return this.f17730c;
    }

    public String getText() {
        return this.f17728a.getText().toString();
    }

    public void setFieldTextFocusable(boolean z) {
        this.f17728a.setFocusable(z);
    }

    public void setFieldTextLongClickable(boolean z) {
        this.f17728a.setLongClickable(z);
    }

    public void setFieldHintText(@Nullable CharSequence charSequence) {
        this.f17728a.setHint(charSequence);
    }

    public void setFieldOnClickListener(@Nullable OnClickListener onClickListener) {
        setFocusable(onClickListener == null);
        this.f17728a.setOnClickListener(onClickListener);
    }

    public void setFieldText(@Nullable String str) {
        this.f17728a.setText(Strings.nullToEmpty(str));
    }

    public void setIcon(@Nullable String str) {
        m21594a(str, CallerContext.a(getClass(), "crowdsourcing_edit"));
    }

    public final void m21594a(@Nullable String str, CallerContext callerContext) {
        if (str != null) {
            this.f17729b.a(Uri.parse(str), callerContext);
        }
    }

    public void setIconVisible(boolean z) {
        this.f17729b.setVisibility(z ? 0 : 4);
    }

    public void setActionButtonVisible(boolean z) {
        this.f17730c.setVisibility(z ? 0 : 4);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f17730c.setOnClickListener(onClickListener);
    }

    public final void m21593a(Drawable drawable, String str) {
        this.f17730c.setImageDrawable(drawable);
        this.f17730c.setContentDescription(str);
    }

    public void setTextChangedListener(@Nullable TextWatcher textWatcher) {
        if (this.f17732e != null) {
            this.f17728a.removeTextChangedListener(this.f17732e);
        }
        this.f17732e = textWatcher;
        if (this.f17732e != null) {
            this.f17728a.addTextChangedListener(this.f17732e);
        }
    }

    public void setFocusable(boolean z) {
        if (z) {
            this.f17728a.setFocusableInTouchMode(true);
        } else {
            this.f17728a.setFocusable(false);
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f17728a.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void setTextFieldTag(int i) {
        this.f17728a.setTag(Integer.valueOf(i));
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f17730c.getVisibility() != 0) {
            return;
        }
        if (VERSION.SDK_INT >= 17) {
            this.f17728a.setPaddingRelative(this.f17728a.getPaddingStart(), this.f17728a.getPaddingTop(), this.f17730c.getWidth() + this.f17731d, this.f17728a.getPaddingBottom());
        } else {
            this.f17728a.setPadding(this.f17728a.getPaddingLeft(), this.f17728a.getPaddingTop(), this.f17730c.getWidth() + this.f17731d, this.f17728a.getPaddingBottom());
        }
    }
}

package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.location.Location;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.maps.FbStaticMapView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: click_submit_button */
public class SuggestEditsLocationView extends CustomLinearLayout {
    private SuggestEditsTextFieldView f17696a;
    private SuggestEditsTextFieldView f17697b;
    private SuggestEditsTextFieldView f17698c;
    private FbStaticMapView f17699d;
    private final StaticMapOptions f17700e = new StaticMapOptions("suggest_edits");
    private Location f17701f;

    public SuggestEditsLocationView(Context context) {
        super(context);
        m21564b();
    }

    public SuggestEditsLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21564b();
    }

    protected SuggestEditsLocationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21564b();
    }

    public final void m21565a() {
        setTextChangedListener(null);
        this.f17696a.setFieldText(null);
        this.f17696a.setFieldHintText(null);
        this.f17696a.setFieldOnClickListener(null);
        this.f17697b.setFieldText(null);
        this.f17697b.setFieldHintText(null);
        this.f17697b.setFieldOnClickListener(null);
        setStreetAddressFieldFocusable(true);
        setOnFocusChangeListener(null);
        this.f17698c.setFieldText(null);
        this.f17698c.setFieldHintText(null);
        this.f17698c.setFieldOnClickListener(null);
    }

    public View getActionButtonView() {
        return this.f17697b.f17730c;
    }

    public String getStreetAddress() {
        return this.f17697b.getText();
    }

    public String getZip() {
        return this.f17698c.getText();
    }

    public void setCity(@Nullable String str) {
        this.f17696a.setFieldText(str);
    }

    public void setCityHintText(@Nullable String str) {
        this.f17696a.setFieldHintText(str);
    }

    public void setCityOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f17696a.setFieldOnClickListener(onClickListener);
    }

    public void setIcon(@Nullable String str) {
        this.f17697b.m21594a(str, CallerContext.a(getClass(), "crowdsourcing_edit"));
    }

    public void setStreetAddress(@Nullable String str) {
        this.f17697b.setFieldText(str);
    }

    public void setStreetAddressHintText(@Nullable String str) {
        this.f17697b.setFieldHintText(str);
    }

    public void setStreetAddressFieldFocusable(boolean z) {
        this.f17697b.setFocusable(z);
    }

    public void setStreetAddressOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f17697b.setFieldOnClickListener(onClickListener);
    }

    public void setZip(@Nullable String str) {
        this.f17698c.setFieldText(str);
    }

    public void setZipHintText(@Nullable String str) {
        this.f17698c.setFieldHintText(str);
    }

    public void setMapLocation(@Nullable Location location) {
        if (location != null) {
            if (this.f17701f == null || location.distanceTo(this.f17701f) > 0.001f) {
                this.f17699d.setMapOptions(this.f17700e.a().a(10).a(location));
                this.f17701f = location;
            }
        }
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f17697b.setActionButtonOnClickListener(onClickListener);
    }

    public void setTextChangedListener(@Nullable TextWatcher textWatcher) {
        this.f17696a.setTextChangedListener(textWatcher);
        this.f17697b.setTextChangedListener(textWatcher);
        this.f17698c.setTextChangedListener(textWatcher);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    private void m21564b() {
        setContentView(2130907303);
        this.f17697b = (SuggestEditsTextFieldView) a(2131567753);
        this.f17696a = (SuggestEditsTextFieldView) a(2131567754);
        this.f17698c = (SuggestEditsTextFieldView) a(2131567755);
        this.f17699d = (FbStaticMapView) a(2131564226);
        this.f17697b.setTextFieldTag(2131567753);
        this.f17696a.setTextFieldTag(2131567754);
        this.f17698c.setTextFieldTag(2131567755);
    }
}

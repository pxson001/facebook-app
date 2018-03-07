package com.facebook.dialtone.switcher;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ToggleButton;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.zero.service.ZeroUpdateStatusManager;

/* compiled from: sl_SI */
public class DialtoneManualSwitcher extends CustomLinearLayout {
    private String f4703a;
    private FbTextView f4704b;
    private ToggleButton f4705c;
    public OnClickListener f4706d;
    private ViewStub f4707e;
    private View f4708f;
    private FbTextView f4709g;
    private FbTextView f4710h;
    private Tooltip f4711i;
    private int f4712j;

    /* compiled from: sl_SI */
    public interface OnClickListener {
        void mo1235a();

        void mo1236a(Context context);

        void mo1237a(CompoundButton compoundButton, Context context);
    }

    public DialtoneManualSwitcher(Context context) {
        super(context);
        m8487n();
    }

    public DialtoneManualSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8487n();
    }

    public DialtoneManualSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8487n();
    }

    public final boolean m8491a() {
        return getVisibility() == 0;
    }

    public final void mo1242b() {
        setVisibility(8);
    }

    public final void m8493c() {
        setVisibility(0);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f4706d = onClickListener;
    }

    public void setCarrierName(String str) {
        this.f4703a = str;
    }

    public void setInfoBannerHeight(int i) {
        this.f4712j = i;
    }

    public final void m8494d() {
        Object string = getResources().getString(2131232587);
        this.f4704b.setText(string);
        this.f4704b.setTextSize(0, string.length() > 25 ? (float) getResources().getDimensionPixelSize(2131427400) : (float) getResources().getDimensionPixelSize(2131427402));
        this.f4704b.setContentDescription(getResources().getString(2131232587));
        m8486m();
        String string2 = getResources().getString(2131232614);
        this.f4705c.setTextSize(0, string2.length() > 20 ? (float) getResources().getDimensionPixelSize(2131427397) : (float) getResources().getDimensionPixelSize(2131427400));
        int dimensionPixelSize = string2.length() > 20 ? getResources().getDimensionPixelSize(2131428082) : getResources().getDimensionPixelSize(2131428083);
        this.f4705c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.f4705c.setChecked(true);
        setBackgroundResource(2131362575);
        m8499i();
    }

    public final void m8495e() {
        Object string = getResources().getString(2131232586);
        this.f4704b.setText(string);
        this.f4704b.setTextSize(0, string.length() > 25 ? (float) getResources().getDimensionPixelSize(2131427400) : (float) getResources().getDimensionPixelSize(2131427402));
        this.f4704b.setContentDescription(getResources().getString(2131232586));
        m8486m();
        String string2 = getResources().getString(2131232615);
        this.f4705c.setTextSize(0, string2.length() > 20 ? (float) getResources().getDimensionPixelSize(2131427397) : (float) getResources().getDimensionPixelSize(2131427400));
        int dimensionPixelSize = string2.length() > 20 ? getResources().getDimensionPixelSize(2131428082) : getResources().getDimensionPixelSize(2131428083);
        this.f4705c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.f4705c.setChecked(false);
        setBackgroundResource(2131362571);
        m8499i();
    }

    private void m8486m() {
        Drawable drawable = getResources().getDrawable(2130840947);
        int lineHeight = this.f4704b.getLineHeight();
        drawable.setBounds(0, 0, lineHeight, lineHeight);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f4704b.getText());
        spannableStringBuilder.append("  ");
        spannableStringBuilder.append(" ");
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        this.f4704b.setText(spannableStringBuilder);
    }

    public final boolean m8496f() {
        return !this.f4705c.isChecked();
    }

    public final void mo1243g() {
        this.f4705c.setClickable(true);
    }

    public final void m8488a(long j) {
        this.f4705c.postDelayed(new 1(this), j);
    }

    public final void m8498h() {
        this.f4705c.setClickable(false);
    }

    public final void m8499i() {
        if (this.f4709g != null) {
            CharSequence string;
            if (this.f4705c.isChecked()) {
                string = getResources().getString(2131232594, new Object[]{this.f4703a});
            } else {
                string = getResources().getString(2131232593);
            }
            this.f4709g.setText(string);
            this.f4709g.setContentDescription(string);
        }
    }

    public final boolean m8500j() {
        return this.f4708f != null && this.f4708f.getVisibility() == 0;
    }

    public final void m8501k() {
        if (this.f4708f == null) {
            this.f4708f = this.f4707e.inflate();
            this.f4708f.setLayoutParams(new LayoutParams(-1, (int) getResources().getDimension(this.f4712j)));
            this.f4709g = (FbTextView) m8506a(2131561008);
            this.f4710h = (FbTextView) m8506a(2131561009);
            this.f4710h.setVisibility(0);
            this.f4710h.setOnClickListener(new 2(this));
        }
        m8499i();
        this.f4708f.setVisibility(0);
    }

    public final void m8502l() {
        if (this.f4708f != null) {
            this.f4708f.setVisibility(8);
        }
    }

    public final void m8490a(Lazy<FbSharedPreferences> lazy, Lazy<AnalyticsLogger> lazy2, Lazy<ZeroUpdateStatusManager> lazy3) {
        m8484a((Lazy) lazy);
        m8483a(this.f4711i, this.f4705c, lazy, lazy2, lazy3);
    }

    public final void m8489a(Lazy<FbSharedPreferences> lazy, Lazy<AnalyticsLogger> lazy2) {
        m8485b(lazy);
        m8482a(this.f4711i, this.f4704b, lazy, lazy2);
    }

    private void m8487n() {
        setContentView(2130903900);
        ((ViewStub) m8506a(2131561002)).inflate();
        this.f4704b = (FbTextView) m8506a(2131561022);
        this.f4705c = (ToggleButton) m8506a(2131561024);
        this.f4707e = (ViewStub) m8506a(2131561004);
        this.f4703a = getResources().getString(2131232601);
        this.f4705c.setOnClickListener(new 3(this));
        this.f4704b.setOnClickListener(new 4(this));
        this.f4705c.setBackgroundDrawable(getContext().getResources().getDrawable(2130838406));
        this.f4705c.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428082);
        this.f4705c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, getResources().getDimensionPixelSize(2131428081));
        layoutParams.gravity = 16;
        layoutParams.rightMargin = getResources().getDimensionPixelSize(2131428080);
        this.f4705c.setLayoutParams(layoutParams);
        this.f4705c.setTextOn(getResources().getString(2131232614));
        this.f4705c.setTextOff(getResources().getString(2131232615));
    }

    private void m8484a(Lazy<FbSharedPreferences> lazy) {
        if (this.f4711i == null) {
            this.f4711i = new Tooltip(getContext(), 2);
            this.f4711i.t = -1;
            this.f4711i.a(Position.BELOW);
            this.f4711i.H = new 5(this, lazy);
        }
    }

    private void m8485b(Lazy<FbSharedPreferences> lazy) {
        if (this.f4711i == null) {
            this.f4711i = new Tooltip(getContext(), 2);
            this.f4711i.t = -1;
            this.f4711i.a(Position.BELOW);
            this.f4711i.r = 20;
            this.f4711i.H = new 6(this, lazy);
        }
    }

    private void m8483a(Tooltip tooltip, View view, Lazy<FbSharedPreferences> lazy, Lazy<AnalyticsLogger> lazy2, Lazy<ZeroUpdateStatusManager> lazy3) {
        view.postDelayed(new 7(this, view, tooltip, lazy, lazy3, lazy2), 1000);
    }

    private void m8482a(Tooltip tooltip, View view, Lazy<FbSharedPreferences> lazy, Lazy<AnalyticsLogger> lazy2) {
        view.postDelayed(new 8(this, view, tooltip, lazy, lazy2), 1000);
    }
}

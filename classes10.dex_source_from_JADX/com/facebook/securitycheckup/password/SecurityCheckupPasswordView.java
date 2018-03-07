package com.facebook.securitycheckup.password;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.password.PasswordStrengthIndicator.Strength;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableMap;

/* compiled from: hostActionBar */
public class SecurityCheckupPasswordView extends CustomLinearLayout {
    private static final ImmutableMap<Strength, Integer> f9926g = ImmutableMap.builder().b(Strength.WEAK, Integer.valueOf(2131363874)).b(Strength.OK, Integer.valueOf(2131363875)).b(Strength.STRONG, Integer.valueOf(2131363876)).b();
    private static final ImmutableMap<Strength, Integer> f9927h = ImmutableMap.builder().b(Strength.WEAK, Integer.valueOf(2130843363)).b(Strength.OK, Integer.valueOf(2130843359)).b(Strength.STRONG, Integer.valueOf(2130843361)).b();
    private static final ImmutableMap<Strength, Integer> f9928i = ImmutableMap.builder().b(Strength.WEAK, Integer.valueOf(2130843364)).b(Strength.OK, Integer.valueOf(2130843360)).b(Strength.STRONG, Integer.valueOf(2130843362)).b();
    private static final ImmutableMap<Strength, Integer> f9929j = ImmutableMap.builder().b(Strength.WEAK, Integer.valueOf(2131241617)).b(Strength.OK, Integer.valueOf(2131241618)).b(Strength.STRONG, Integer.valueOf(2131241619)).b();
    private FbTextView f9930a;
    public FbEditText f9931b;
    private FbTextView f9932c;
    private ImageView f9933d;
    public ImageView f9934e;
    public Strength f9935f;

    /* compiled from: hostActionBar */
    class C14721 implements OnFocusChangeListener {
        final /* synthetic */ SecurityCheckupPasswordView f9924a;

        C14721(SecurityCheckupPasswordView securityCheckupPasswordView) {
            this.f9924a = securityCheckupPasswordView;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f9924a.f9934e.setImageDrawable(this.f9924a.getContext().getResources().getDrawable(2130843253));
            } else {
                this.f9924a.f9934e.setImageDrawable(this.f9924a.getContext().getResources().getDrawable(2130843251));
            }
        }
    }

    /* compiled from: hostActionBar */
    class C14732 implements OnClickListener {
        final /* synthetic */ SecurityCheckupPasswordView f9925a;

        C14732(SecurityCheckupPasswordView securityCheckupPasswordView) {
            this.f9925a = securityCheckupPasswordView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 262631331);
            this.f9925a.f9931b.requestFocus();
            Logger.a(2, EntryType.UI_INPUT_END, -44622062, a);
        }
    }

    public SecurityCheckupPasswordView(Context context) {
        super(context);
        m10061d();
    }

    public SecurityCheckupPasswordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10061d();
    }

    public SecurityCheckupPasswordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10061d();
    }

    public String getText() {
        return this.f9931b.getText().toString();
    }

    public Strength getCurrentDisplayedStrengthType() {
        return this.f9935f;
    }

    public void setStrengthString(String str) {
        this.f9932c.setText(str);
    }

    public final void m10063a(TextWatcher textWatcher) {
        this.f9931b.addTextChangedListener(textWatcher);
    }

    public final void m10062a() {
        this.f9934e.setImageDrawable(getContext().getResources().getDrawable(2130843252));
        this.f9931b.setTextColor(getContext().getResources().getColor(2131361918));
    }

    public void setPasswordStrength(Strength strength) {
        this.f9935f = strength;
        if (strength == Strength.NULL) {
            this.f9932c.setText("");
            this.f9933d.setImageDrawable(null);
            return;
        }
        this.f9932c.setText(((Integer) f9929j.get(strength)).intValue());
        this.f9932c.setTextColor(getContext().getResources().getColor(((Integer) f9926g.get(strength)).intValue()));
    }

    public void setPasswordsMatch(boolean z) {
        if (this.f9935f != Strength.NULL) {
            this.f9933d.setImageDrawable(getContext().getResources().getDrawable((z ? (Integer) f9928i.get(this.f9935f) : (Integer) f9927h.get(this.f9935f)).intValue()));
        }
    }

    public final void m10064b() {
        m10065c();
        this.f9933d.setImageDrawable(getContext().getResources().getDrawable(2130843358));
    }

    public final void m10065c() {
        this.f9932c.setText("");
    }

    public FbEditText getPasswordEditText() {
        return this.f9931b;
    }

    public void setName(String str) {
        this.f9930a.setText(str);
    }

    public void setNameWidth(int i) {
        this.f9930a.setWidth(i);
    }

    public int getNameWidth() {
        return this.f9930a.getWidth();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m10061d() {
        this.f9935f = Strength.NULL;
        setContentView(2130907036);
        this.f9930a = (FbTextView) a(2131567364);
        this.f9931b = (FbEditText) a(2131567365);
        this.f9932c = (FbTextView) a(2131567367);
        this.f9933d = (ImageView) a(2131567368);
        this.f9934e = (ImageView) a(2131567369);
        this.f9931b.setTypeface(Typeface.defaultFromStyle(0));
        this.f9931b.setOnFocusChangeListener(new C14721(this));
        setOnClickListener(new C14732(this));
    }
}

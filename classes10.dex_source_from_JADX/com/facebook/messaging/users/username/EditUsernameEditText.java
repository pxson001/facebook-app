package com.facebook.messaging.users.username;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: ping_type */
public class EditUsernameEditText extends CustomFrameLayout {
    public int f4894a;
    public int f4895b;
    @Nullable
    public UsernameAvailabilityListener f4896c;
    private EditText f4897d;
    private View f4898e;
    public TextView f4899f;
    private ProgressBar f4900g;

    /* compiled from: ping_type */
    class C06691 implements TextWatcher {
        final /* synthetic */ EditUsernameEditText f4893a;

        C06691(EditUsernameEditText editUsernameEditText) {
            this.f4893a = editUsernameEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f4893a.f4899f.setText(editable.length() + "/" + this.f4893a.f4895b);
            if (this.f4893a.f4896c != null) {
                this.f4893a.f4896c.mo132a(editable.toString());
            }
            if (editable.length() < this.f4893a.f4894a) {
                this.f4893a.m4425e();
            }
        }
    }

    /* compiled from: ping_type */
    public interface UsernameAvailabilityListener {
        void mo132a(String str);
    }

    public EditUsernameEditText(Context context) {
        super(context);
        m4421g();
    }

    public EditUsernameEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4421g();
    }

    public EditUsernameEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4421g();
    }

    private void m4421g() {
        setContentView(2130905690);
        this.f4894a = getContext().getResources().getInteger(2131492877);
        this.f4895b = getContext().getResources().getInteger(2131492878);
        this.f4899f = (TextView) c(2131564849);
        this.f4898e = c(2131564848);
        this.f4897d = (EditText) c(2131564846);
        this.f4897d.addTextChangedListener(new C06691(this));
        m4426f();
        m4422h();
    }

    public final void m4423a() {
        this.f4900g.setVisibility(0);
    }

    public final void m4424b() {
        this.f4900g.setVisibility(8);
    }

    public final void m4425e() {
        this.f4897d.getBackground().setColorFilter(getResources().getColor(2131361918), Mode.SRC_ATOP);
        this.f4898e.setVisibility(0);
    }

    public final void m4426f() {
        this.f4897d.getBackground().setColorFilter(getResources().getColor(2131362241), Mode.SRC_ATOP);
        this.f4898e.setVisibility(8);
    }

    public void setUsernameAvailabilityListener(@Nullable UsernameAvailabilityListener usernameAvailabilityListener) {
        this.f4896c = usernameAvailabilityListener;
    }

    public String getText() {
        return this.f4897d.getText().toString();
    }

    public void setText(@Nullable String str) {
        if (str != null) {
            this.f4897d.setText(str);
            this.f4897d.setSelection(str.length());
        }
    }

    private void m4422h() {
        this.f4900g = (ProgressBar) c(2131564847);
        this.f4900g.getIndeterminateDrawable().setColorFilter(getResources().getColor(2131362241), Mode.SRC_ATOP);
    }
}

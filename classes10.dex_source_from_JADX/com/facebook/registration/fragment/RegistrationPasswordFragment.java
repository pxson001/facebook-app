package com.facebook.registration.fragment;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.facebook.common.util.FindViewUtil;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.fragment.RegistrationInputFragment.RegInputException;
import com.facebook.widget.text.watcher.BaseTextWatcher;

/* compiled from: language_switcher_switch */
public class RegistrationPasswordFragment extends RegistrationInputFragment {
    private EditText f8868b;

    /* compiled from: language_switcher_switch */
    class C13481 extends BaseTextWatcher {
        final /* synthetic */ RegistrationPasswordFragment f8867a;

        C13481(RegistrationPasswordFragment registrationPasswordFragment) {
            this.f8867a = registrationPasswordFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f8867a.av();
        }
    }

    protected final void mo393b(View view) {
        this.f8868b = (EditText) FindViewUtil.b(view, 2131566937);
        this.f8868b.setText(this.f8777f.n);
        this.f8868b.addTextChangedListener(new C13481(this));
        m8774a(this.f8868b);
    }

    protected final int mo384e() {
        return 2131239834;
    }

    protected final int mz_() {
        return 2131239835;
    }

    protected final int as() {
        return 2131239836;
    }

    protected final int at() {
        return 2130906812;
    }

    protected final void au() {
        if (this.f8868b.getText().toString().length() < 6) {
            throw new RegInputException(2131239838);
        }
    }

    protected final void av() {
        this.f8777f.n = this.f8868b.getText().toString();
    }

    protected final RegFragmentState aw() {
        return RegFragmentState.PASSWORD_ACQUIRED;
    }

    protected final RegErrorCategory ax() {
        return RegErrorCategory.PASSWORD;
    }
}

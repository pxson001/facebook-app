package com.facebook.confirmation.fragment;

import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.constants.ConfFragmentState;
import com.facebook.growth.model.Contactpoint;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import javax.annotation.Nullable;

/* compiled from: intermediate_image_width */
public class ConfEmailFragment extends ConfContactpointFragment {
    private AutoCompleteTextView f10752e;

    /* compiled from: intermediate_image_width */
    class C11551 extends BaseTextWatcher {
        final /* synthetic */ ConfEmailFragment f10751a;

        C11551(ConfEmailFragment confEmailFragment) {
            this.f10751a = confEmailFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f10751a.aq.setVisibility(8);
        }
    }

    protected final void mo765b(View view) {
        this.f10752e = (AutoCompleteTextView) FindViewUtil.b(view, 2131560674);
        m12662a(this.f10752e);
        this.f10752e.addTextChangedListener(new C11551(this));
    }

    protected final int az() {
        return 2131239770;
    }

    protected final int aB() {
        return 2131239758;
    }

    protected final int mo756e() {
        return 2130903745;
    }

    protected final int ar() {
        return 2131239771;
    }

    protected final ConfFragmentState ay() {
        return ConfFragmentState.EMAIL_SWITCH_TO_PHONE;
    }

    @Nullable
    protected final Contactpoint au() {
        Object obj = this.f10752e.getText().toString();
        if (StringUtil.a(obj)) {
            return null;
        }
        return Contactpoint.m17343a(obj);
    }

    protected final ConfFragmentState av() {
        return ConfFragmentState.EMAIL_ACQUIRED;
    }
}

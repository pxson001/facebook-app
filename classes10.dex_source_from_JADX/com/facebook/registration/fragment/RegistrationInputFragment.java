package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.constants.RegErrorCategory;
import com.facebook.registration.constants.RegFragmentState;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.model.SimpleRegFormData;
import com.facebook.resources.ui.FbButton;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.inject.Inject;

/* compiled from: last_successful_fetch_ms */
public abstract class RegistrationInputFragment extends RegistrationFragment {
    public TextView al;
    protected TextView am;
    @Inject
    @Sessionless
    public GatekeeperStoreImpl f8776e;
    @Inject
    public SimpleRegFormData f8777f;
    @Inject
    public SimpleRegLogger f8778g;
    protected TextView f8779h;
    protected FbButton f8780i;

    /* compiled from: last_successful_fetch_ms */
    class C13381 implements OnClickListener {
        final /* synthetic */ RegistrationInputFragment f8854a;

        C13381(RegistrationInputFragment registrationInputFragment) {
            this.f8854a = registrationInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1985634062);
            this.f8854a.ay();
            Logger.a(2, EntryType.UI_INPUT_END, 706787524, a);
        }
    }

    /* compiled from: last_successful_fetch_ms */
    class C13392 implements OnEditorActionListener {
        final /* synthetic */ RegistrationInputFragment f8855a;

        C13392(RegistrationInputFragment registrationInputFragment) {
            this.f8855a = registrationInputFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((keyEvent == null || keyEvent.getKeyCode() != 66) && i != 6) {
                return false;
            }
            KeyboardUtils.a(this.f8855a.o());
            this.f8855a.ay();
            return true;
        }
    }

    /* compiled from: last_successful_fetch_ms */
    class C13403 implements OnClickListener {
        final /* synthetic */ RegistrationInputFragment f8856a;

        C13403(RegistrationInputFragment registrationInputFragment) {
            this.f8856a = registrationInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 126590086);
            this.f8856a.m8773b(true);
            Logger.a(2, EntryType.UI_INPUT_END, -122012148, a);
        }
    }

    /* compiled from: last_successful_fetch_ms */
    class C13414 implements OnClickListener {
        final /* synthetic */ RegistrationInputFragment f8857a;

        C13414(RegistrationInputFragment registrationInputFragment) {
            this.f8857a = registrationInputFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1709538653);
            this.f8857a.m8771a(true);
            Logger.a(2, EntryType.UI_INPUT_END, -1776747781, a);
        }
    }

    /* compiled from: last_successful_fetch_ms */
    public class RegInputException extends Exception {
        public RegInputException(int i) {
            super(RegistrationInputFragment.this.b(i));
        }
    }

    public static void m8770a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationInputFragment registrationInputFragment = (RegistrationInputFragment) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector);
        SimpleRegFormData a2 = SimpleRegFormData.a(fbInjector);
        SimpleRegLogger b = SimpleRegLogger.b(fbInjector);
        registrationInputFragment.f8776e = a;
        registrationInputFragment.f8777f = a2;
        registrationInputFragment.f8778g = b;
    }

    protected abstract int as();

    protected abstract int at();

    protected abstract void au();

    protected abstract void av();

    protected abstract RegFragmentState aw();

    protected abstract RegErrorCategory ax();

    protected abstract int mz_();

    public void mo394c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationInputFragment.class;
        m8770a((Object) this, getContext());
    }

    protected final void mo383b(View view, Bundle bundle) {
        if (at() != 0) {
            ViewStub viewStub = (ViewStub) FindViewUtil.b(view, 2131566928);
            viewStub.setLayoutResource(at());
            viewStub.inflate();
        }
        if (az() != 0) {
            viewStub = (ViewStub) FindViewUtil.b(view, 2131566929);
            viewStub.setLayoutResource(az());
            viewStub.inflate();
        }
        this.f8779h = (TextView) FindViewUtil.b(view, 2131560676);
        this.f8780i = (FbButton) FindViewUtil.b(view, 2131566905);
        this.al = (TextView) FindViewUtil.b(view, 2131566900);
        this.am = (TextView) FindViewUtil.b(view, 2131560281);
        this.am.setText(mz_());
        this.am.setContentDescription(jW_().getText(mz_()));
        aB();
        this.f8780i.setOnClickListener(new C13381(this));
        mo393b(view);
    }

    protected void mo393b(View view) {
    }

    protected final int aq() {
        return 2130906806;
    }

    protected int az() {
        return 0;
    }

    protected void aA() {
    }

    protected void ay() {
        try {
            au();
            av();
            aA();
            mo385a(aw());
        } catch (RegInputException e) {
            CharSequence message = e.getMessage();
            this.f8779h.setText(message);
            this.f8779h.setContentDescription(message);
            m8773b(true);
        }
    }

    protected final void mo385a(RegFragmentState regFragmentState) {
        KeyboardUtils.a(o());
        super.mo385a(regFragmentState);
    }

    protected final void m8774a(TextView textView) {
        textView.setOnEditorActionListener(new C13392(this));
    }

    protected static void m8768a(AutoCompleteTextView autoCompleteTextView, String str) {
        ListAdapter adapter = autoCompleteTextView.getAdapter();
        if (adapter instanceof ArrayAdapter) {
            autoCompleteTextView.setAdapter(null);
            autoCompleteTextView.setText(str);
            autoCompleteTextView.setAdapter((ArrayAdapter) adapter);
            return;
        }
        autoCompleteTextView.setText(str);
    }

    private void aB() {
        boolean z;
        if (as() != 0) {
            CharSequence string = jW_().getString(as());
            this.al.setText(string);
            this.al.setContentDescription(string);
        }
        RegErrorCategory ax = ax();
        if (!this.f8777f.d(ax) || StringUtil.c(this.f8777f.c(ax))) {
            z = false;
        } else {
            z = true;
            CharSequence c = this.f8777f.c(ax);
            this.f8779h.setText(c);
            this.f8779h.setContentDescription(c);
        }
        switch (jW_().getConfiguration().orientation) {
            case 1:
                this.al.setMinLines(3);
                this.f8779h.setMinLines(3);
                break;
            case 2:
                this.al.setMinLines(2);
                this.f8779h.setMinLines(2);
                break;
            default:
                this.al.setMinLines(3);
                this.f8779h.setMinLines(3);
                break;
        }
        this.al.setOnClickListener(new C13403(this));
        this.f8779h.setOnClickListener(new C13414(this));
        if (z) {
            m8773b(false);
        } else {
            m8771a(false);
        }
    }

    private void m8771a(boolean z) {
        if (!StringUtil.c(this.al.getText())) {
            m8767a(this.f8779h, this.al, z);
        }
    }

    private void m8773b(boolean z) {
        if (!StringUtil.c(this.f8779h.getText())) {
            m8767a(this.al, this.f8779h, z);
        }
    }

    private static void m8767a(View view, View view2, boolean z) {
        view.setVisibility(8);
        view2.setVisibility(0);
        if (z) {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100);
            view2.startAnimation(alphaAnimation);
        }
    }
}

package com.facebook.uberbar.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import com.facebook.analytics.InteractionLogger;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper;
import com.facebook.ui.keyboard.SmoothKeyboardFragmentBehavior;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import javax.inject.Inject;

/* compiled from: nearby_tiles */
public class UberbarFragment extends FbFragment implements CanHandleBackPressed {
    @Inject
    public NativeUberbarFragmentDelegate f5108a;
    @Inject
    public InputMethodManager f5109b;
    public EditText f5110c;
    private ImageButton f5111d;
    private ViewGroup f5112e;
    private View f5113f;
    public UberbarResultsFragment f5114g;
    public boolean f5115h = false;

    /* compiled from: nearby_tiles */
    class C06671 implements OnClickListener {
        final /* synthetic */ UberbarFragment f5107a;

        C06671(UberbarFragment uberbarFragment) {
            this.f5107a = uberbarFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -583600254);
            if (this.f5107a.f5110c == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1508380566, a);
                return;
            }
            if (this.f5107a.f5110c.getText().length() > 0) {
                this.f5107a.f5110c.setText("");
            } else {
                this.f5107a.f5109b.hideSoftInputFromWindow(this.f5107a.f5110c.getWindowToken(), 0);
                this.f5107a.f5108a.f5093h.e = true;
                this.f5107a.f5115h = true;
                this.f5107a.ao().onBackPressed();
            }
            LogUtils.a(-44586075, a);
        }
    }

    public static void m6387a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UberbarFragment uberbarFragment = (UberbarFragment) obj;
        NativeUberbarFragmentDelegate nativeUberbarFragmentDelegate = new NativeUberbarFragmentDelegate(InteractionLogger.a(fbInjector), FragmentActivityMethodAutoProvider.b(fbInjector), UberbarResultsAnalyticHelper.b(fbInjector));
        InputMethodManager b = InputMethodManagerMethodAutoProvider.b(fbInjector);
        uberbarFragment.f5108a = nativeUberbarFragmentDelegate;
        uberbarFragment.f5109b = b;
    }

    public final void m6391c(Bundle bundle) {
        super.c(bundle);
        Class cls = UberbarFragment.class;
        m6387a(this, getContext());
        a(new SmoothKeyboardFragmentBehavior());
    }

    public final void m6392d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1828357207);
        super.d(bundle);
        this.f5110c = (EditText) e(2131563410);
        this.f5110c.setFocusableInTouchMode(true);
        OnClickListener c06671 = new C06671(this);
        this.f5111d = (ImageButton) e(2131568156);
        this.f5111d.setOnClickListener(c06671);
        this.f5113f = e(2131568154);
        this.f5113f.setOnClickListener(c06671);
        this.f5112e = (ViewGroup) e(2131568157);
        ViewGroup viewGroup = this.f5112e;
        FragmentManager s = s();
        this.f5114g = (UberbarResultsFragment) s.a("results_fragment");
        if (this.f5114g == null) {
            this.f5114g = new UberbarResultsFragment();
            FragmentTransaction a2 = s.a();
            a2.a(viewGroup.getId(), this.f5114g, "results_fragment");
            a2.b();
        }
        NativeUberbarDelegate nativeUberbarDelegate = this.f5108a;
        nativeUberbarDelegate.f5092g = this.f5114g;
        nativeUberbarDelegate.f5092g.as = nativeUberbarDelegate.f5093h;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1598055436, a);
    }

    public final View m6390a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1465351069);
        View inflate = layoutInflater.inflate(2130907585, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 734667979, a);
        return inflate;
    }

    public final void m6388G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 753686232);
        super.G();
        e(2131562506);
        this.f5108a.mo148a(this.f5110c, this.f5112e, new NativeUberbarTextWatcher(this.f5108a, this.f5111d));
        if (Strings.isNullOrEmpty(this.f5110c.getText().toString())) {
            this.f5110c.requestFocus();
            this.f5109b.showSoftInput(this.f5110c, 0);
        }
        AbstractUberbarDelegate abstractUberbarDelegate = this.f5108a;
        Preconditions.checkState(abstractUberbarDelegate.f5086c);
        UberbarResultsAnalyticHelper uberbarResultsAnalyticHelper = abstractUberbarDelegate.f5093h;
        uberbarResultsAnalyticHelper.a = SafeUUIDGenerator.a().toString();
        uberbarResultsAnalyticHelper.b = Lists.a();
        uberbarResultsAnalyticHelper.e = false;
        uberbarResultsAnalyticHelper.f = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1989322157, a);
    }

    public final void m6389H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1786645910);
        super.H();
        this.f5108a.m6381c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -785271599, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 314285652);
        super.mY_();
        this.f5113f.setOnClickListener(null);
        this.f5111d.setOnClickListener(null);
        this.f5111d = null;
        this.f5110c = null;
        this.f5112e = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1650721735, a);
    }

    public final boolean O_() {
        if (this.f5115h) {
            this.f5115h = false;
        } else {
            this.f5108a.f5093h.f = true;
        }
        return false;
    }
}

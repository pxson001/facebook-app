package com.facebook.common.title;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dialtone.switcher.DialtoneManualSwitcher;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController;
import com.facebook.dialtone.switcher.DialtoneManualSwitcherController.IndicatorVisibilityListener;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.abtest.ExperimentsForFbZeroModule;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.ui.ZeroIndicator;
import com.facebook.zero.ui.ZeroIndicatorController;
import com.facebook.zero.ui.ZeroIndicatorController.Listener;
import com.facebook.zero.ui.ZeroTitlebarIndicator;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sim_mcc */
public class IndicatorBarController {
    public final ZeroTitlebarIndicator f4746a;
    public final SecureContextHelper f4747b;
    private final Provider<TriState> f4748c;
    public final DialtoneManualSwitcherController f4749d;
    private final QeAccessor f4750e;
    public ViewStub f4751f;
    public FbTextView f4752g;
    private ZeroIndicatorController f4753h;
    private Listener f4754i = new C02401(this);
    private IndicatorVisibilityListener f4755j;
    private IndicatorVisibilityListener f4756k;

    /* compiled from: sim_mcc */
    class C02401 implements Listener {
        final /* synthetic */ IndicatorBarController f4759a;

        C02401(IndicatorBarController indicatorBarController) {
            this.f4759a = indicatorBarController;
        }

        public final void mo1258a() {
            this.f4759a.m8570b();
        }

        public final void mo1259b() {
            this.f4759a.m8570b();
        }
    }

    /* compiled from: sim_mcc */
    class C02412 implements IndicatorVisibilityListener {
        final /* synthetic */ IndicatorBarController f4760a;

        C02412(IndicatorBarController indicatorBarController) {
            this.f4760a = indicatorBarController;
        }

        public final void mo1260a() {
            this.f4760a.m8564b(this.f4760a.f4749d);
        }

        public final void mo1261b() {
            IndicatorBarController indicatorBarController = this.f4760a;
            IndicatorBarController.m8565c(this.f4760a.f4749d);
        }
    }

    /* compiled from: sim_mcc */
    class C02423 implements IndicatorVisibilityListener {
        final /* synthetic */ IndicatorBarController f4761a;

        C02423(IndicatorBarController indicatorBarController) {
            this.f4761a = indicatorBarController;
        }

        public final void mo1260a() {
            DialtoneManualSwitcher d = this.f4761a.f4749d.m8419d();
            if (d != null) {
                d.m8501k();
            }
        }

        public final void mo1261b() {
            DialtoneManualSwitcher d = this.f4761a.f4749d.m8419d();
            if (d != null) {
                d.m8502l();
            }
        }
    }

    public static IndicatorBarController m8563b(InjectorLike injectorLike) {
        return new IndicatorBarController((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 640), DefaultSecureContextHelper.m4636a(injectorLike), ZeroIndicatorController.m8360b(injectorLike), DialtoneManualSwitcherController.m8378a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static IndicatorBarController m8560a(InjectorLike injectorLike) {
        return m8563b(injectorLike);
    }

    @Inject
    public IndicatorBarController(Context context, Provider<TriState> provider, SecureContextHelper secureContextHelper, ZeroIndicatorController zeroIndicatorController, DialtoneManualSwitcherController dialtoneManualSwitcherController, QeAccessor qeAccessor) {
        this.f4746a = new ZeroTitlebarIndicator(context);
        this.f4748c = provider;
        this.f4747b = secureContextHelper;
        this.f4750e = qeAccessor;
        this.f4753h = zeroIndicatorController;
        this.f4749d = dialtoneManualSwitcherController;
        this.f4755j = new C02412(this);
        this.f4756k = new C02423(this);
    }

    public final IndicatorBarController m8567a(ViewStub viewStub) {
        this.f4751f = viewStub;
        return this;
    }

    public final void m8571b(ViewStub viewStub) {
        this.f4749d.m8412a(viewStub);
    }

    public final ZeroIndicator m8568a() {
        return this.f4746a;
    }

    public final void m8570b() {
        if (this.f4746a.mo1255c()) {
            m8566g();
            return;
        }
        if (this.f4752g != null) {
            this.f4752g.setVisibility(8);
        }
    }

    public final void m8569a(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        DialtoneManualSwitcher d = dialtoneManualSwitcherController.m8419d();
        if (d == null || !d.m8491a()) {
            m8565c(dialtoneManualSwitcherController);
        } else {
            m8564b(dialtoneManualSwitcherController);
        }
    }

    private void m8564b(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        DialtoneManualSwitcher d = dialtoneManualSwitcherController.m8419d();
        if (d == null) {
            m8561a(dialtoneManualSwitcherController.m8417c());
            dialtoneManualSwitcherController.m8422f();
            return;
        }
        d.m8493c();
    }

    public static void m8565c(DialtoneManualSwitcherController dialtoneManualSwitcherController) {
        DialtoneManualSwitcher d = dialtoneManualSwitcherController.m8419d();
        if (d != null) {
            d.mo1242b();
        }
    }

    public final void m8572c() {
        this.f4749d.m8413a(this.f4755j);
        this.f4749d.m8416b(this.f4756k);
        this.f4749d.m8411a();
        m8569a(this.f4749d);
    }

    public final void m8573d() {
        ZeroIndicatorController zeroIndicatorController = this.f4753h;
        zeroIndicatorController.f4614o = this.f4754i;
        zeroIndicatorController.f4615p = ZeroFeatureKey.FB4A_INDICATOR;
        this.f4753h.m8368a();
        m8570b();
        m8572c();
    }

    public final void m8574e() {
        this.f4749d.m8418c(this.f4755j);
        this.f4749d.m8420d(this.f4756k);
        this.f4749d.m8415b();
    }

    public final void m8575f() {
        this.f4753h.m8369b();
        m8574e();
    }

    private void m8566g() {
        String charSequence;
        if (this.f4752g == null) {
            this.f4752g = (FbTextView) this.f4751f.inflate();
            m8561a(this.f4752g);
            if (this.f4750e.mo581a(ExperimentsForFbZeroModule.c, "blue").equalsIgnoreCase("purple")) {
                this.f4752g.setBackgroundResource(2131362571);
            }
        } else {
            this.f4752g.setVisibility(0);
        }
        FbTextView fbTextView = this.f4752g;
        if (this.f4746a.mo1255c()) {
            charSequence = this.f4746a.getText().toString();
        } else {
            charSequence = null;
        }
        fbTextView.setText(charSequence);
        if (this.f4746a.mo1255c()) {
            charSequence = this.f4746a.f4757a;
        } else {
            charSequence = null;
        }
        String str = charSequence;
        if (!Strings.isNullOrEmpty(str)) {
            Drawable drawable = this.f4752g.getResources().getDrawable(2130840947);
            int lineHeight = this.f4752g.getLineHeight();
            drawable.setBounds(0, 0, lineHeight, lineHeight);
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f4752g.getText());
            spannableStringBuilder.append(" ");
            spannableStringBuilder.append(" ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            this.f4752g.setText(spannableStringBuilder);
            this.f4752g.setOnClickListener(new 4(this, str));
        }
    }

    private void m8561a(View view) {
        if (this.f4748c.get() == TriState.YES) {
            view.setOnLongClickListener(new 5(this, view));
        } else {
            view.setClickable(true);
        }
    }
}

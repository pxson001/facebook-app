package com.facebook.adspayments.validation;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.adspayments.PaymentsQeAccessor;
import com.facebook.adspayments.adinterfaces.abtest.AdsPaymentsExperimentsHelper;
import com.facebook.adspayments.analytics.PaymentsFlowContext;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: Unable to download sticker image */
public abstract class CardInputFieldController<V extends InputValidatorCallbackHandler> {
    protected final PaymentsQeAccessor f23632a;
    @Nullable
    public View f23633b;
    private final int f23634c;
    private final int f23635d;
    private final AdsPaymentsExperimentsHelper f23636e;
    public final V f23637f;
    public int f23638g;
    public int f23639h;
    public int f23640i;
    public int f23641j;
    public boolean f23642k = false;
    public PaymentsFlowContext f23643l;

    /* compiled from: Unable to download sticker image */
    class C28701 implements Runnable {
        final /* synthetic */ CardInputFieldController f23727a;

        C28701(CardInputFieldController cardInputFieldController) {
            this.f23727a = cardInputFieldController;
        }

        public void run() {
            ((View) Preconditions.checkNotNull(this.f23727a.f23633b)).requestFocus();
        }
    }

    protected abstract void mo1088a(View view);

    public abstract boolean mo1089a();

    public abstract String mo1090b();

    public abstract EditText mo1091c();

    protected abstract TextView mo1092d();

    public final void m25625a(ExecutorService executorService) {
        Preconditions.checkState(this.f23633b != null, "This must be called after nextView is bound");
        if (this.f23636e.m25615a(this.f23643l.f3967b)) {
            this.f23633b.requestFocus();
        } else {
            ExecutorDetour.a(executorService, new C28701(this), 181533714);
        }
    }

    public final void m25626a(boolean z) {
        this.f23642k = z;
        if (this.f23642k) {
            mH_();
        } else {
            m25621j();
        }
    }

    public CardInputFieldController(V v, Resources resources, AdsPaymentsExperimentsHelper adsPaymentsExperimentsHelper, PaymentsQeAccessor paymentsQeAccessor) {
        this.f23637f = v;
        this.f23636e = adsPaymentsExperimentsHelper;
        this.f23632a = paymentsQeAccessor;
        this.f23634c = resources.getColor(2131361918);
        this.f23635d = resources.getColor(2131361921);
    }

    private void m25621j() {
        mo1091c().setTextColor(this.f23635d);
        mo1091c().setBackgroundResource(2130842552);
        m25622l();
        mo1092d().setVisibility(8);
    }

    public void mH_() {
        mo1091c().setTextColor(this.f23634c);
        mo1091c().setBackgroundResource(2130842565);
        m25622l();
        mo1092d().setVisibility(0);
    }

    private void m25622l() {
        mo1091c().setPadding(this.f23638g, this.f23639h, this.f23640i, this.f23641j);
    }

    public final void m25624a(View view, @Nullable View view2, PaymentsFlowContext paymentsFlowContext) {
        this.f23633b = view2;
        this.f23643l = paymentsFlowContext;
        mo1088a(view);
        this.f23638g = mo1091c().getPaddingLeft();
        this.f23639h = mo1091c().getPaddingTop();
        this.f23640i = mo1091c().getPaddingRight();
        this.f23641j = mo1091c().getPaddingBottom();
        if (this.f23633b != null) {
            mo1091c().setImeOptions(5);
        }
    }

    public final boolean m25631i() {
        boolean a = mo1089a();
        this.f23637f.m25760a(a);
        return a;
    }
}

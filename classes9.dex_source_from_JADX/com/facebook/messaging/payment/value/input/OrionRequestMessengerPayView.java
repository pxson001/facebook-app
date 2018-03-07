package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.messaging.payment.value.input.EnterPaymentValueTextController.Listener;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: escalation_declined */
public class OrionRequestMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    @Inject
    public EnterPaymentValueTextControllerProvider f15665a;
    @Inject
    public MessengerPayViewMenuItemHelper f15666b;
    private final DollarIconEditText f15667c;
    public final MemoInputView f15668d;
    public ViewPager f15669e;
    public C17747 f15670f;
    public EnterPaymentValueTextController f15671g;
    public OrionRequestMessengerPayViewParams f15672h;

    /* compiled from: escalation_declined */
    class C18351 implements Listener {
        final /* synthetic */ OrionRequestMessengerPayView f15661a;

        C18351(OrionRequestMessengerPayView orionRequestMessengerPayView) {
            this.f15661a = orionRequestMessengerPayView;
        }

        public final void mo625a(String str) {
            this.f15661a.f15670f.m15631b(str);
        }
    }

    /* compiled from: escalation_declined */
    class C18362 implements MemoInputView.Listener {
        final /* synthetic */ OrionRequestMessengerPayView f15662a;

        C18362(OrionRequestMessengerPayView orionRequestMessengerPayView) {
            this.f15662a = orionRequestMessengerPayView;
        }

        public final void mo626a(String str) {
            this.f15662a.f15670f.m15629a(str);
        }
    }

    /* compiled from: escalation_declined */
    class C18373 extends SimpleOnPageChangeListener {
        final /* synthetic */ OrionRequestMessengerPayView f15663a;

        C18373(OrionRequestMessengerPayView orionRequestMessengerPayView) {
            this.f15663a = orionRequestMessengerPayView;
        }

        public final void e_(int i) {
            this.f15663a.f15670f.m15628a(ThemeHelper.m15869a(this.f15663a.f15672h.f15676d, i));
        }
    }

    public static void m15843a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OrionRequestMessengerPayView orionRequestMessengerPayView = (OrionRequestMessengerPayView) obj;
        EnterPaymentValueTextControllerProvider enterPaymentValueTextControllerProvider = (EnterPaymentValueTextControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EnterPaymentValueTextControllerProvider.class);
        MessengerPayViewMenuItemHelper b = MessengerPayViewMenuItemHelper.m15777b(fbInjector);
        orionRequestMessengerPayView.f15665a = enterPaymentValueTextControllerProvider;
        orionRequestMessengerPayView.f15666b = b;
    }

    public OrionRequestMessengerPayView(Context context) {
        this(context, null);
    }

    private OrionRequestMessengerPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private OrionRequestMessengerPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = OrionRequestMessengerPayView.class;
        m15843a(this, getContext());
        setContentView(2130905933);
        this.f15669e = (ViewPager) a(2131565279);
        this.f15667c = (DollarIconEditText) a(2131561181);
        this.f15668d = (MemoInputView) a(2131561190);
        this.f15667c.m15483b();
        this.f15667c.setLongClickable(false);
        this.f15671g = this.f15665a.m15673a(new C18351(this));
        this.f15671g.m15668a(this.f15667c);
    }

    @Nullable
    public View getImmediateFocusView() {
        return this.f15667c;
    }

    public void setListener(C17747 c17747) {
        this.f15670f = c17747;
        this.f15668d.setListener(new C18362(this));
        this.f15669e.setOnPageChangeListener(new C18373(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15672h = (OrionRequestMessengerPayViewParams) messengerPayViewParams;
        this.f15671g.m15670a(this.f15672h.f15674b.f15443b, this.f15672h.f15674b.f15442a);
        this.f15671g.m15672b(this.f15672h.f15674b.f15442a);
        switch (this.f15672h.f15673a) {
            case PREPARE_PAYMENT:
                this.f15671g.m15671a(true);
                break;
            default:
                this.f15671g.m15671a(false);
                break;
        }
        this.f15668d.setMemoText(this.f15672h.f15675c);
        if (this.f15672h.f15676d != null) {
            if (this.f15669e.getAdapter() == null) {
                this.f15669e.setAdapter(new ThemePagerAdapter(this.f15672h.f15676d, getContext()));
            } else {
                this.f15669e.a(ThemeHelper.m15867a(this.f15672h.f15676d, this.f15672h.f15677e), false);
            }
        }
    }

    public final void mo620a() {
        this.f15671g.m15667a();
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        this.f15666b.m15779a(menuItem, null, this.f15672h.f15674b, this.f15672h.f15673a, true);
    }
}

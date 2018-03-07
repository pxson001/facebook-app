package com.facebook.messaging.payment.value.input;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Vibrator;
import android.text.Editable;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.util.PaymentsSoundUtil;
import com.facebook.messaging.payment.utils.PaymentTextUtils;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import javax.inject.Inject;

/* compiled from: extra_custom_title */
public class EnterPaymentValueTextController {
    public final Context f15309a;
    public final PaymentViewUtil f15310b;
    private final PaymentTextUtils f15311c;
    private final PaymentValueFormattingTextWatcher f15312d;
    public final PaymentsSoundUtil f15313e;
    public final Vibrator f15314f;
    private final C17801 f15315g = new C17801(this);
    public DollarIconEditText f15316h;
    public Listener f15317i;
    public ValueAnimator f15318j;
    private ValueAnimator f15319k;
    public boolean f15320l = true;

    /* compiled from: extra_custom_title */
    public class C17801 {
        public final /* synthetic */ EnterPaymentValueTextController f15304a;

        C17801(EnterPaymentValueTextController enterPaymentValueTextController) {
            this.f15304a = enterPaymentValueTextController;
        }

        public final void m15663d() {
            this.f15304a.f15310b.m15543a(this.f15304a.f15316h);
        }
    }

    /* compiled from: extra_custom_title */
    public class C17812 implements AnimatorUpdateListener {
        final /* synthetic */ EnterPaymentValueTextController f15305a;

        public C17812(EnterPaymentValueTextController enterPaymentValueTextController) {
            this.f15305a = enterPaymentValueTextController;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f15305a.f15316h.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: extra_custom_title */
    class C17834 implements AnimatorListener {
        final /* synthetic */ EnterPaymentValueTextController f15308a;

        C17834(EnterPaymentValueTextController enterPaymentValueTextController) {
            this.f15308a = enterPaymentValueTextController;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            int i = 0;
            Editable text = this.f15308a.f15316h.getText();
            FlyingInCharacterStaticSpan[] flyingInCharacterStaticSpanArr = (FlyingInCharacterStaticSpan[]) text.getSpans(0, text.length(), FlyingInCharacterStaticSpan.class);
            int length = flyingInCharacterStaticSpanArr.length;
            while (i < length) {
                text.removeSpan(flyingInCharacterStaticSpanArr[i]);
                i++;
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: extra_custom_title */
    public interface Listener {
        void mo625a(String str);
    }

    @Inject
    public EnterPaymentValueTextController(@Assisted Listener listener, Context context, PaymentViewUtil paymentViewUtil, PaymentTextUtils paymentTextUtils, PaymentValueFormattingTextWatcher paymentValueFormattingTextWatcher, PaymentsSoundUtil paymentsSoundUtil, Vibrator vibrator) {
        this.f15317i = listener;
        this.f15309a = context;
        this.f15310b = paymentViewUtil;
        this.f15311c = paymentTextUtils;
        this.f15312d = paymentValueFormattingTextWatcher;
        this.f15313e = paymentsSoundUtil;
        this.f15314f = vibrator;
    }

    public final void m15668a(DollarIconEditText dollarIconEditText) {
        this.f15316h = dollarIconEditText;
        this.f15316h.addTextChangedListener(this.f15312d);
        this.f15312d.f15695e = this.f15315g;
        m15672b(this.f15316h.getText().toString());
    }

    public final void m15667a() {
        String obj = this.f15316h.getText().toString();
        if (!obj.isEmpty()) {
            int indexOf = obj.indexOf(".");
            if (indexOf == -1) {
                return;
            }
            if (indexOf == obj.length() - 1) {
                m15666c("00");
            } else if (indexOf == obj.length() - 2) {
                m15666c("0");
            }
        }
    }

    public final void m15669a(String str) {
        if ((!StringUtil.a(str) ? 1 : null) != null) {
            this.f15316h.m15481a();
        } else {
            this.f15316h.m15483b();
        }
    }

    public final void m15671a(boolean z) {
        this.f15316h.setEnabled(z);
    }

    public final void m15672b(String str) {
        float a = (float) this.f15311c.m15540a(str);
        if (this.f15316h.getTextSize() != a) {
            if (this.f15318j != null) {
                this.f15318j.cancel();
                this.f15318j = null;
            }
            this.f15318j = ValueAnimator.ofFloat(new float[]{r1, a});
            this.f15318j.setDuration((long) this.f15309a.getResources().getInteger(2131492953));
            this.f15318j.addUpdateListener(new C17812(this));
            this.f15318j.start();
        }
    }

    public static void m15665a(EnterPaymentValueTextController enterPaymentValueTextController, final int i) {
        if (enterPaymentValueTextController.f15319k != null) {
            enterPaymentValueTextController.f15319k.end();
            enterPaymentValueTextController.f15319k = null;
        }
        enterPaymentValueTextController.f15319k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        enterPaymentValueTextController.f15319k.setDuration((long) enterPaymentValueTextController.f15309a.getResources().getInteger(2131492954));
        enterPaymentValueTextController.f15319k.addUpdateListener(new AnimatorUpdateListener(enterPaymentValueTextController) {
            final /* synthetic */ EnterPaymentValueTextController f15307b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Editable text = this.f15307b.f15316h.getText();
                if (text.length() < i) {
                    valueAnimator.cancel();
                } else {
                    text.setSpan(new FlyingInCharacterStaticSpan(floatValue), i - 1, i, 18);
                }
            }
        });
        enterPaymentValueTextController.f15319k.addListener(new C17834(enterPaymentValueTextController));
        enterPaymentValueTextController.f15319k.start();
    }

    private void m15666c(String str) {
        this.f15320l = false;
        this.f15316h.getText().append(str);
        this.f15320l = true;
    }

    public final void m15670a(String str, String str2) {
        if (!StringUtil.a(this.f15316h.getText().toString(), str2)) {
            this.f15320l = false;
            this.f15316h.m15482a(str, str2);
            this.f15320l = true;
        }
    }
}

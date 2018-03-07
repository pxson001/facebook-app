package com.facebook.messaging.payment.thread;

import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.orca.threadview.MessageItemView.23;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed_fetch_user */
public class PaymentTriggerHelper {
    public 23 f14996a;
    private Provider<Boolean> f14997b;
    private PaymentCurrencyUtil f14998c;
    private Provider<Boolean> f14999d;
    private final Pattern f15000e = Pattern.compile("\\$((\\d{1,3}(,\\d{3})*)|\\d+)(\\.\\d{1,2})?(?=\\s|\\.\\s|\\,\\s|$|\\.$|\\,$|\\?|\\!)");

    public static PaymentTriggerHelper m15381a(InjectorLike injectorLike) {
        return new PaymentTriggerHelper(IdBasedProvider.a(injectorLike, 4177), IdBasedProvider.a(injectorLike, 4113), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public PaymentTriggerHelper(Provider<Boolean> provider, Provider<Boolean> provider2, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f14997b = provider;
        this.f14999d = provider2;
        this.f14998c = paymentCurrencyUtil;
    }

    public final boolean m15383a(Spannable spannable, ImmutableList<ThreadParticipant> immutableList) {
        if (!((Boolean) this.f14997b.get()).booleanValue()) {
            return false;
        }
        String obj = spannable.toString();
        Matcher matcher = this.f15000e.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            if (m15382a((ImmutableList) immutableList)) {
                return false;
            }
            int start = matcher.start();
            int end = matcher.end();
            try {
                int b = this.f14998c.m13203b(obj.substring(start + 1, end));
                if (b <= 1000000) {
                    final String a = this.f14998c.m13198a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, b);
                    spannable.setSpan(new ClickableSpan(this) {
                        final /* synthetic */ PaymentTriggerHelper f14995b;

                        public void onClick(View view) {
                            23 23 = this.f14995b.f14996a;
                            23.a.bg.c(a);
                        }
                    }, start, end, 33);
                    z = true;
                }
            } catch (NumberFormatException e) {
            }
        }
        return z;
    }

    private boolean m15382a(ImmutableList<ThreadParticipant> immutableList) {
        if (((Boolean) this.f14999d.get()).booleanValue() && immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                if (((ThreadParticipant) immutableList.get(i)).f()) {
                    return true;
                }
            }
        }
        return false;
    }
}

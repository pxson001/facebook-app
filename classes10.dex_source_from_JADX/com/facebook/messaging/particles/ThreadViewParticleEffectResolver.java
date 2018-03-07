package com.facebook.messaging.particles;

import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.giftwrap.GiftWrapFeature;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: resend_dialog */
public class ThreadViewParticleEffectResolver {
    public static final String f3417a = new String(Character.toChars(10084));
    private static final String f3418b = new String(Character.toChars(10052));
    private static final String f3419c = new String(Character.toChars(9731));
    private static final String f3420d = new String(Character.toChars(9924));
    private static final String f3421e = new String(Character.toChars(127877));
    private static final String f3422f = new String(Character.toChars(127876));
    private static final String f3423g = new String(Character.toChars(127938));
    private static final String f3424h = new String(Character.toChars(9975));
    private static final String f3425i = new String(Character.toChars(127784));
    private static final List<String> f3426j = Arrays.asList(new String[]{f3418b, f3419c, f3420d, f3421e, f3422f, f3423g, f3424h, f3425i});
    public final GiftWrapFeature f3427k;
    public final GiftWrapResolver f3428l;
    public final Provider<Boolean> f3429m;
    public final Provider<Boolean> f3430n;
    private final Provider<Boolean> f3431o;
    public final PaymentCurrencyUtil f3432p;
    public final MessageClassifier f3433q;
    public final XConfigReader f3434r;
    public String[] f3435s;
    public String[] f3436t;

    public static ThreadViewParticleEffectResolver m3320b(InjectorLike injectorLike) {
        return new ThreadViewParticleEffectResolver(GiftWrapFeature.b(injectorLike), GiftWrapResolver.b(injectorLike), IdBasedProvider.a(injectorLike, 4173), IdBasedProvider.a(injectorLike, 4174), IdBasedProvider.a(injectorLike, 4175), PaymentCurrencyUtil.a(injectorLike), MessageClassifier.a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    ThreadViewParticleEffectResolver(GiftWrapFeature giftWrapFeature, GiftWrapResolver giftWrapResolver, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, PaymentCurrencyUtil paymentCurrencyUtil, MessageClassifier messageClassifier, XConfigReader xConfigReader) {
        this.f3427k = giftWrapFeature;
        this.f3428l = giftWrapResolver;
        this.f3429m = provider;
        this.f3430n = provider2;
        this.f3431o = provider3;
        this.f3432p = paymentCurrencyUtil;
        this.f3433q = messageClassifier;
        this.f3434r = xConfigReader;
    }

    public final boolean m3321b(Message message) {
        if (!((Boolean) this.f3431o.get()).booleanValue()) {
            return false;
        }
        if (StringUtil.a(message.k)) {
            CharSequence charSequence = message.f;
            return !StringUtil.a(charSequence) && f3426j.contains(charSequence);
        } else {
            if (this.f3436t == null) {
                Object a = this.f3434r.a(SnowFallStickersXConfig.c, "");
                if (StringUtil.a(a)) {
                    this.f3436t = new String[0];
                } else {
                    String[] split = a.split(",");
                    Arrays.sort(split);
                    this.f3436t = split;
                }
            }
            return Arrays.binarySearch(this.f3436t, message.k) >= 0;
        }
    }
}

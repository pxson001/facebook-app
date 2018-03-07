package com.facebook.messaging.payment.method.verification;

import android.support.v4.app.Fragment;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.model.PaymentCard;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: image_format = 'WEBP' AND  */
public class PaymentMethodVerificationParams {
    @Nullable
    public final PaymentCard f13182a;
    public final ImmutableList<PaymentCard> f13183b;
    @Nullable
    public final Fragment f13184c;
    public final boolean f13185d;
    public final PaymentFlowType f13186e;
    @Nullable
    public final String f13187f;
    @Nullable
    public final String f13188g;
    public final LaunchMode f13189h;
    public final String f13190i;
    public final String f13191j;
    public final boolean f13192k;

    /* compiled from: image_format = 'WEBP' AND  */
    public class Builder {
        public PaymentCard f13171a;
        public ImmutableList<PaymentCard> f13172b;
        public Fragment f13173c;
        public boolean f13174d;
        public PaymentFlowType f13175e;
        public String f13176f;
        public String f13177g;
        public LaunchMode f13178h = LaunchMode.VERIFY;
        public String f13179i;
        public String f13180j;
        public boolean f13181k;

        public final PaymentMethodVerificationParams m13461a() {
            return new PaymentMethodVerificationParams(this);
        }
    }

    /* compiled from: image_format = 'WEBP' AND  */
    public enum LaunchMode {
        NEW("new"),
        VERIFY("verify");
        
        private final String type;

        private LaunchMode(String str) {
            this.type = str;
        }

        public static LaunchMode fromString(String str) {
            for (LaunchMode launchMode : values()) {
                if (launchMode.type.equals(str)) {
                    return launchMode;
                }
            }
            return VERIFY;
        }
    }

    public PaymentMethodVerificationParams(Builder builder) {
        this.f13182a = builder.f13171a;
        this.f13183b = builder.f13172b;
        this.f13184c = builder.f13173c;
        this.f13185d = builder.f13174d;
        this.f13186e = builder.f13175e;
        this.f13187f = builder.f13176f;
        this.f13188g = builder.f13177g;
        this.f13189h = builder.f13178h;
        this.f13190i = builder.f13179i;
        this.f13191j = builder.f13180j;
        this.f13192k = builder.f13181k;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}

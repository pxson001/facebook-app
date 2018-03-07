package com.facebook.messaging.payment.utils;

import android.content.res.Resources;
import android.text.TextUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: extra_shipping_option_id */
public class PaymentTextUtils {
    private Resources f15182a;

    public static PaymentTextUtils m15538b(InjectorLike injectorLike) {
        return new PaymentTextUtils(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PaymentTextUtils(Resources resources) {
        this.f15182a = resources;
    }

    public final int m15540a(String str) {
        int trimmedLength = str.contains(".") ? TextUtils.getTrimmedLength(str) - 1 : TextUtils.getTrimmedLength(str);
        if (trimmedLength >= 7) {
            return this.f15182a.getDimensionPixelSize(2131433399);
        }
        if (trimmedLength >= 6) {
            return this.f15182a.getDimensionPixelSize(2131433398);
        }
        if (trimmedLength >= 5) {
            return this.f15182a.getDimensionPixelSize(2131433397);
        }
        if (trimmedLength >= 4) {
            return this.f15182a.getDimensionPixelSize(2131433396);
        }
        return this.f15182a.getDimensionPixelSize(2131433395);
    }

    public final int m15539a(int i) {
        switch (i) {
            case 1:
                return this.f15182a.getDimensionPixelSize(2131433422);
            case 2:
                return this.f15182a.getDimensionPixelSize(2131433423);
            case 3:
                return this.f15182a.getDimensionPixelSize(2131433424);
            case 4:
                return this.f15182a.getDimensionPixelSize(2131433425);
            case 5:
                return this.f15182a.getDimensionPixelSize(2131433426);
            default:
                throw new IllegalArgumentException("Too large dollar amount provided.");
        }
    }
}

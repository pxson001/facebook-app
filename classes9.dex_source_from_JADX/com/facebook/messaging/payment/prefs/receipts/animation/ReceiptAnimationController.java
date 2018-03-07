package com.facebook.messaging.payment.prefs.receipts.animation;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.facebook.inject.InjectorLike;

/* compiled from: gql_fetch_msg_fail */
public class ReceiptAnimationController {
    public static ReceiptAnimationController m14526a(InjectorLike injectorLike) {
        return new ReceiptAnimationController();
    }

    public static void m14527a(View view, int i) {
        Animation alphaAnimation = i == 0 ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i == 0 ? 2000 : 200);
        view.setVisibility(i);
        view.startAnimation(alphaAnimation);
    }

    public static void m14528a(View view, int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        view.setTranslationY((float) (iArr[1] - iArr2[1]));
        view.animate().setDuration(500).translationY(0.0f);
    }
}

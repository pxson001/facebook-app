package com.facebook.orca.threadview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.facebook.inject.InjectorLike;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: messages_sync_message_requests_fetch_error */
public class PaymentsAnimationManager {
    public final Map<String, ValueAnimator> f7342a = new HashMap();
    public MessageListHelper f7343b;

    /* compiled from: messages_sync_message_requests_fetch_error */
    public class C11022 implements AnimatorUpdateListener {
        final /* synthetic */ AnimatingItemInfo f7340a;
        final /* synthetic */ PaymentsAnimationManager f7341b;

        public C11022(PaymentsAnimationManager paymentsAnimationManager, AnimatingItemInfo animatingItemInfo) {
            this.f7341b = paymentsAnimationManager;
            this.f7340a = animatingItemInfo;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7340a.setAnimationOffset(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7341b.f7343b.mo351b();
        }
    }

    public static PaymentsAnimationManager m6978a(InjectorLike injectorLike) {
        return new PaymentsAnimationManager();
    }

    public final void m6979a(final String str) {
        if (((ValueAnimator) this.f7342a.get(str)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.setDuration(300);
            ofFloat.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ PaymentsAnimationManager f7339b;

                public void onAnimationEnd(Animator animator) {
                    this.f7339b.f7342a.remove(str);
                }

                public void onAnimationCancel(Animator animator) {
                    this.f7339b.f7342a.remove(str);
                }
            });
            this.f7342a.put(str, ofFloat);
            ofFloat.start();
        }
    }
}

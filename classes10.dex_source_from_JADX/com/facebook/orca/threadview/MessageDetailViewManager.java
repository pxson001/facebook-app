package com.facebook.orca.threadview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_wear_reply */
public class MessageDetailViewManager {
    @Nullable
    @VisibleForTesting
    Message f7032a;
    private final ValueAnimator f7033b = new ValueAnimator();
    private final ValueAnimator f7034c = new ValueAnimator();
    public final AnimatingItemInfo f7035d = new AnimatingItemInfo();
    public final AnimatingItemInfo f7036e = new AnimatingItemInfo();
    public MessageListHelper f7037f;
    @Nullable
    private Message f7038g;
    @Nullable
    private Message f7039h;

    /* compiled from: messenger_wear_reply */
    class C10521 implements AnimatorUpdateListener {
        final /* synthetic */ MessageDetailViewManager f7028a;

        C10521(MessageDetailViewManager messageDetailViewManager) {
            this.f7028a = messageDetailViewManager;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7028a.f7035d.setAnimationOffset(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7028a.f7037f.mo351b();
        }
    }

    /* compiled from: messenger_wear_reply */
    class C10532 implements AnimatorListener {
        final /* synthetic */ MessageDetailViewManager f7029a;

        C10532(MessageDetailViewManager messageDetailViewManager) {
            this.f7029a = messageDetailViewManager;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f7029a.m6614a();
        }

        public void onAnimationCancel(Animator animator) {
            this.f7029a.m6614a();
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: messenger_wear_reply */
    class C10543 implements AnimatorUpdateListener {
        final /* synthetic */ MessageDetailViewManager f7030a;

        C10543(MessageDetailViewManager messageDetailViewManager) {
            this.f7030a = messageDetailViewManager;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f7030a.f7036e.setAnimationOffset(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f7030a.f7037f.mo351b();
        }
    }

    /* compiled from: messenger_wear_reply */
    class C10554 implements AnimatorListener {
        final /* synthetic */ MessageDetailViewManager f7031a;

        C10554(MessageDetailViewManager messageDetailViewManager) {
            this.f7031a = messageDetailViewManager;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f7031a.m6617b();
        }

        public void onAnimationCancel(Animator animator) {
            this.f7031a.m6617b();
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static MessageDetailViewManager m6609a(InjectorLike injectorLike) {
        return new MessageDetailViewManager();
    }

    @Inject
    public MessageDetailViewManager() {
        m6612c();
    }

    public final void m6616a(RowMessageItem rowMessageItem) {
        Message message = rowMessageItem.f4732a;
        if (m6610a(message, this.f7038g)) {
            rowMessageItem.f4753v = this.f7035d;
            rowMessageItem.f4751t = true;
            rowMessageItem.m4301a(0);
        } else if (m6610a(message, this.f7039h)) {
            rowMessageItem.f4753v = this.f7036e;
            rowMessageItem.f4751t = false;
            rowMessageItem.m4301a(0);
        } else if (m6610a(message, this.f7032a)) {
            rowMessageItem.f4753v = null;
            rowMessageItem.f4751t = true;
            rowMessageItem.m4301a(0);
        } else {
            rowMessageItem.f4753v = null;
            rowMessageItem.f4751t = false;
            rowMessageItem.m4301a(8);
        }
    }

    public final void m6615a(Message message) {
        if (this.f7032a == null) {
            this.f7032a = message;
            m6611b(message);
        } else if (m6610a(this.f7032a, message)) {
            this.f7032a = null;
            m6613c(message);
        } else {
            m6613c(this.f7032a);
            m6611b(message);
            this.f7032a = message;
        }
    }

    private void m6612c() {
        this.f7033b.setFloatValues(new float[]{0.0f, 1.0f});
        this.f7033b.setDuration(300);
        this.f7033b.addUpdateListener(new C10521(this));
        this.f7033b.addListener(new C10532(this));
        this.f7034c.setFloatValues(new float[]{1.0f, 0.0f});
        this.f7034c.setDuration(300);
        this.f7034c.addUpdateListener(new C10543(this));
        this.f7034c.addListener(new C10554(this));
    }

    @VisibleForTesting
    private static boolean m6610a(Message message, Message message2) {
        if (message == null || message2 == null) {
            return false;
        }
        if (message.a != null && message2.a != null && Objects.equal(message.a, message2.a)) {
            return true;
        }
        if (message.n == null || message2.n == null) {
            return false;
        }
        return Objects.equal(message.n, message2.n);
    }

    private void m6611b(Message message) {
        this.f7038g = message;
        this.f7033b.start();
    }

    private void m6613c(Message message) {
        this.f7039h = message;
        this.f7034c.start();
    }

    @VisibleForTesting
    final void m6614a() {
        this.f7038g = null;
    }

    @VisibleForTesting
    final void m6617b() {
        this.f7039h = null;
    }
}

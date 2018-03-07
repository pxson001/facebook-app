package com.facebook.orca.threadview;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import javax.inject.Inject;

/* compiled from: message_event_guests_canceled */
public class SendMessageAnimationManager {
    private static final AnimationLinker f7407a = new C11081();
    public static final Interpolator f7408b = new DecelerateInterpolator(1.8f);
    public final MessageStateAnimationManager f7409c;
    public boolean f7410d;

    /* compiled from: message_event_guests_canceled */
    final class C11081 implements AnimationLinker {
        C11081() {
        }

        public final void mo251a(RowItem rowItem, float f) {
            ((RowMessageItem) rowItem).m4300a(f);
        }

        public final void mo250a(RowItem rowItem) {
            RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
            rowMessageItem.m4300a(rowMessageItem.m4313l() != MessageType.REGULAR ? 0.0f : 1.0f);
        }
    }

    public static SendMessageAnimationManager m7055a(InjectorLike injectorLike) {
        return new SendMessageAnimationManager(MessageStateAnimationManager.m6914a(injectorLike));
    }

    @Inject
    public SendMessageAnimationManager(MessageStateAnimationManager messageStateAnimationManager) {
        this.f7409c = messageStateAnimationManager;
    }

    public final void m7056a(RowMessageItem rowMessageItem) {
        if (this.f7410d) {
            this.f7409c.m6916a(rowMessageItem.f4732a.n, rowMessageItem, f7407a);
        }
    }
}

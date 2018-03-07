package com.facebook.orca.threadview;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.giftwrap.GiftWrapResolver;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass18;
import javax.inject.Inject;

/* compiled from: minute */
public class GiftWrapAnimationManager {
    public static final Interpolator f6930a = new LinearInterpolator();
    private final AnimationLinker f6931b = new C10421(this);
    public final GiftWrapResolver f6932c;
    public final MessageStateAnimationManager f6933d;

    /* compiled from: minute */
    class C10421 implements AnimationLinker {
        final /* synthetic */ GiftWrapAnimationManager f6927a;

        C10421(GiftWrapAnimationManager giftWrapAnimationManager) {
            this.f6927a = giftWrapAnimationManager;
        }

        public final void mo251a(RowItem rowItem, float f) {
            ((RowMessageItem) rowItem).m4305b(f);
        }

        public final void mo250a(RowItem rowItem) {
            RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
            rowMessageItem.m4305b(this.f6927a.f6932c.b(rowMessageItem.f4732a) ? 0.0f : 1.0f);
        }
    }

    /* compiled from: minute */
    public class C10432 {
        public final /* synthetic */ AnonymousClass18 f6928a;
        final /* synthetic */ GiftWrapAnimationManager f6929b;

        public C10432(GiftWrapAnimationManager giftWrapAnimationManager, AnonymousClass18 anonymousClass18) {
            this.f6929b = giftWrapAnimationManager;
            this.f6928a = anonymousClass18;
        }
    }

    public static GiftWrapAnimationManager m6558a(InjectorLike injectorLike) {
        return new GiftWrapAnimationManager(GiftWrapResolver.b(injectorLike), MessageStateAnimationManager.m6914a(injectorLike));
    }

    @Inject
    public GiftWrapAnimationManager(GiftWrapResolver giftWrapResolver, MessageStateAnimationManager messageStateAnimationManager) {
        this.f6932c = giftWrapResolver;
        this.f6933d = messageStateAnimationManager;
    }

    public final void m6560b(RowMessageItem rowMessageItem) {
        this.f6933d.m6916a(m6559c(rowMessageItem), rowMessageItem, this.f6931b);
    }

    public static String m6559c(RowMessageItem rowMessageItem) {
        if (rowMessageItem.f4732a.n != null) {
            return rowMessageItem.f4732a.n;
        }
        return rowMessageItem.f4732a.a;
    }
}

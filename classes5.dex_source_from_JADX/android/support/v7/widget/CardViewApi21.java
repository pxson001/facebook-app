package android.support.v7.widget;

import android.content.Context;
import android.view.View;

/* compiled from: type parameters */
class CardViewApi21 implements CardViewImpl {
    CardViewApi21() {
    }

    public final void mo437a(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
        cardViewDelegate.setBackgroundDrawable(new RoundRectDrawable(i, f));
        View view = (View) cardViewDelegate;
        view.setClipToOutline(true);
        view.setElevation(f2);
        mo439b(cardViewDelegate, f3);
    }

    public final void mo435a(CardViewDelegate cardViewDelegate, float f) {
        ((RoundRectDrawable) cardViewDelegate.getBackground()).m1949a(f);
    }

    public final void mo434a() {
    }

    public final void mo439b(CardViewDelegate cardViewDelegate, float f) {
        ((RoundRectDrawable) cardViewDelegate.getBackground()).m1950a(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        m1830h(cardViewDelegate);
    }

    public final float mo433a(CardViewDelegate cardViewDelegate) {
        return ((RoundRectDrawable) cardViewDelegate.getBackground()).f1420e;
    }

    public final float mo438b(CardViewDelegate cardViewDelegate) {
        return mo442d(cardViewDelegate) * 2.0f;
    }

    public final float mo440c(CardViewDelegate cardViewDelegate) {
        return mo442d(cardViewDelegate) * 2.0f;
    }

    public final float mo442d(CardViewDelegate cardViewDelegate) {
        return ((RoundRectDrawable) cardViewDelegate.getBackground()).f1416a;
    }

    public final void mo441c(CardViewDelegate cardViewDelegate, float f) {
        ((View) cardViewDelegate).setElevation(f);
    }

    public final float mo443e(CardViewDelegate cardViewDelegate) {
        return ((View) cardViewDelegate).getElevation();
    }

    private void m1830h(CardViewDelegate cardViewDelegate) {
        if (cardViewDelegate.getUseCompatPadding()) {
            float a = mo433a(cardViewDelegate);
            float d = mo442d(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.m1954b(a, d, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.m1951a(a, d, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.mo430a(ceil, ceil2, ceil, ceil2);
            return;
        }
        cardViewDelegate.mo430a(0, 0, 0, 0);
    }

    public final void mo444f(CardViewDelegate cardViewDelegate) {
        mo439b(cardViewDelegate, mo433a(cardViewDelegate));
    }

    public final void mo445g(CardViewDelegate cardViewDelegate) {
        mo439b(cardViewDelegate, mo433a(cardViewDelegate));
    }

    public final void mo436a(CardViewDelegate cardViewDelegate, int i) {
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) cardViewDelegate.getBackground();
        roundRectDrawable.f1417b.setColor(i);
        roundRectDrawable.invalidateSelf();
    }
}

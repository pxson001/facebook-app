package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: twitter_share */
class CardViewEclairMr1 implements CardViewImpl {
    final RectF f1331a = new RectF();

    /* compiled from: twitter_share */
    class C00651 implements RoundRectHelper {
        final /* synthetic */ CardViewEclairMr1 f1330a;

        C00651(CardViewEclairMr1 cardViewEclairMr1) {
            this.f1330a = cardViewEclairMr1;
        }

        public final void mo446a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                f += 0.5f;
                this.f1330a.f1331a.set(-f, -f, f, f);
                int save = canvas.save();
                canvas.translate(rectF.left + f, rectF.top + f);
                canvas.drawArc(this.f1330a.f1331a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1330a.f1331a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1330a.f1331a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f1330a.f1331a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f) - 1.0f, rectF.top, (rectF.right - f) + 1.0f, rectF.top + f, paint);
                canvas.drawRect((rectF.left + f) - 1.0f, (rectF.bottom - f) + 1.0f, (rectF.right - f) + 1.0f, rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, (rectF.bottom - f) + 1.0f, paint);
        }
    }

    CardViewEclairMr1() {
    }

    public void mo434a() {
        RoundRectDrawableWithShadow.f1424c = new C00651(this);
    }

    public final void mo437a(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
        Drawable a = m1846a(context, i, f, f2, f3);
        a.m1958a(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setBackgroundDrawable(a);
        m1847h(cardViewDelegate);
    }

    private static RoundRectDrawableWithShadow m1846a(Context context, int i, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), i, f, f2, f3);
    }

    private void m1847h(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        m1848i(cardViewDelegate).getPadding(rect);
        ((View) cardViewDelegate).setMinimumHeight((int) Math.ceil((double) mo440c(cardViewDelegate)));
        ((View) cardViewDelegate).setMinimumWidth((int) Math.ceil((double) mo438b(cardViewDelegate)));
        cardViewDelegate.mo430a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void mo444f(CardViewDelegate cardViewDelegate) {
    }

    public final void mo445g(CardViewDelegate cardViewDelegate) {
        m1848i(cardViewDelegate).m1958a(cardViewDelegate.getPreventCornerOverlap());
        m1847h(cardViewDelegate);
    }

    public final void mo436a(CardViewDelegate cardViewDelegate, int i) {
        RoundRectDrawableWithShadow i2 = m1848i(cardViewDelegate);
        i2.f1426d.setColor(i);
        i2.invalidateSelf();
    }

    public final void mo435a(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow i = m1848i(cardViewDelegate);
        float f2 = (float) ((int) (0.5f + f));
        if (i.f1430h != f2) {
            i.f1430h = f2;
            i.f1436n = true;
            i.invalidateSelf();
        }
        m1847h(cardViewDelegate);
    }

    public final float mo442d(CardViewDelegate cardViewDelegate) {
        return m1848i(cardViewDelegate).f1430h;
    }

    public final void mo441c(CardViewDelegate cardViewDelegate, float f) {
        m1848i(cardViewDelegate).m1959b(f);
    }

    public final float mo443e(CardViewDelegate cardViewDelegate) {
        return m1848i(cardViewDelegate).f1435m;
    }

    public final void mo439b(CardViewDelegate cardViewDelegate, float f) {
        m1848i(cardViewDelegate).m1960c(f);
        m1847h(cardViewDelegate);
    }

    public final float mo433a(CardViewDelegate cardViewDelegate) {
        return m1848i(cardViewDelegate).f1433k;
    }

    public final float mo438b(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow i = m1848i(cardViewDelegate);
        return (Math.max(i.f1433k, (i.f1430h + ((float) i.f1425b)) + (i.f1433k / 2.0f)) * 2.0f) + ((i.f1433k + ((float) i.f1425b)) * 2.0f);
    }

    public final float mo440c(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow i = m1848i(cardViewDelegate);
        return (Math.max(i.f1433k, (i.f1430h + ((float) i.f1425b)) + ((i.f1433k * 1.5f) / 2.0f)) * 2.0f) + (((i.f1433k * 1.5f) + ((float) i.f1425b)) * 2.0f);
    }

    private static RoundRectDrawableWithShadow m1848i(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getBackground();
    }
}

package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: twitter_importer */
class CardViewJellybeanMr1 extends CardViewEclairMr1 {

    /* compiled from: twitter_importer */
    class C00661 implements RoundRectHelper {
        final /* synthetic */ CardViewJellybeanMr1 f1332a;

        C00661(CardViewJellybeanMr1 cardViewJellybeanMr1) {
            this.f1332a = cardViewJellybeanMr1;
        }

        public final void mo446a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    CardViewJellybeanMr1() {
    }

    public final void mo434a() {
        RoundRectDrawableWithShadow.f1424c = new C00661(this);
    }
}

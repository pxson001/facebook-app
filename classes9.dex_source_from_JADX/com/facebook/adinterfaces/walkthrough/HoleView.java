package com.facebook.adinterfaces.walkthrough;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: Unexpected mCamera in callback! */
public class HoleView extends View {
    private Paint f23393a;
    private Paint f23394b;
    private Canvas f23395c;
    private Bitmap f23396d;
    private Rect f23397e;
    private Rect f23398f;
    private CloseableReference<Bitmap> f23399g;
    @Inject
    public PlatformBitmapFactory f23400h;

    /* compiled from: Unexpected mCamera in callback! */
    class C27891 implements OnTouchListener {
        final /* synthetic */ HoleView f23392a;

        C27891(HoleView holeView) {
            this.f23392a = holeView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    private static <T extends View> void m25330a(Class<T> cls, T t) {
        m25331a((Object) t, t.getContext());
    }

    private static void m25331a(Object obj, Context context) {
        ((HoleView) obj).f23400h = PlatformBitmapFactoryMethodAutoProvider.a(FbInjector.get(context));
    }

    public HoleView(Context context) {
        super(context);
    }

    public HoleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HoleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m25333a(Rect rect) {
        this.f23398f = this.f23397e;
        this.f23397e = rect;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (this.f23397e != null) {
            if (this.f23393a == null) {
                m25328a(canvas);
                this.f23395c.drawRect(0.0f, 0.0f, (float) this.f23395c.getWidth(), (float) this.f23395c.getHeight(), this.f23394b);
            }
            if (this.f23398f != null) {
                this.f23395c.drawRect(this.f23398f, this.f23394b);
            }
            this.f23395c.drawRect(this.f23397e, this.f23393a);
            canvas.drawBitmap(this.f23396d, 0.0f, 0.0f, null);
        }
    }

    private void m25328a(Canvas canvas) {
        if (VERSION.SDK_INT <= 19) {
            setLayerType(1, null);
        }
        this.f23393a = new Paint();
        this.f23393a.setColor(getResources().getColor(17170445));
        this.f23393a.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        m25330a(HoleView.class, (View) this);
        this.f23399g = this.f23400h.a(canvas.getWidth(), canvas.getHeight());
        this.f23396d = (Bitmap) this.f23399g.a();
        this.f23395c = new Canvas(this.f23396d);
        this.f23394b = new Paint();
        this.f23394b.setColor(getResources().getColor(2131362873));
        setOnTouchListener(new C27891(this));
    }

    private void m25329a(PlatformBitmapFactory platformBitmapFactory) {
        this.f23400h = platformBitmapFactory;
    }

    public final void m25332a() {
        this.f23399g.close();
    }
}

package com.facebook.timeline.header.coverphoto.edit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;
import com.facebook.bitmaps.BitmapDecodeException;
import com.facebook.bitmaps.BitmapOutOfMemoryException;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.inject.FbInjector;
import com.facebook.timeline.event.CoverPhotoEditEventBus;
import com.facebook.timeline.event.CoverPhotoEditEvents.EditCoverPhotoLoadedEvent;
import com.facebook.widget.images.PhotoFocusUtil;
import com.facebook.widget.images.RotateBitmap;
import javax.annotation.Nullable;

/* compiled from: finish_reg_notification_1hr */
public class CoverPhotoEditView extends ImageView {
    public AbstractFbErrorReporter f11674a;
    public BitmapUtils f11675b;
    public CoverPhotoEditEventBus f11676c;
    public String f11677d;
    public float f11678e;
    public float f11679f;
    private Matrix f11680g;
    public int f11681h;
    public int f11682i;
    private int f11683j;
    private int f11684k;
    private float f11685l;
    private Bitmap f11686m;

    /* compiled from: finish_reg_notification_1hr */
    class LoadScaledPhotoTask extends FbAsyncTask<Void, Void, Bitmap> {
        final /* synthetic */ CoverPhotoEditView f11673a;

        @Nullable
        protected final Object m11740a(Object[] objArr) {
            Object obj = null;
            try {
                obj = this.f11673a.f11675b.a(this.f11673a.f11677d, this.f11673a.f11681h, this.f11673a.f11682i);
            } catch (BitmapOutOfMemoryException e) {
                this.f11673a.m11750a("out of memory");
            } catch (BitmapDecodeException e2) {
                this.f11673a.m11750a("decode failed");
            }
            return obj;
        }

        protected void onPostExecute(@Nullable Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null) {
                Toast.makeText(this.f11673a.getContext(), 2131234967, 1).show();
            } else {
                this.f11673a.m11744a(bitmap);
            }
        }

        public LoadScaledPhotoTask(CoverPhotoEditView coverPhotoEditView) {
            this.f11673a = coverPhotoEditView;
        }
    }

    private static <T extends View> void m11748a(Class<T> cls, T t) {
        m11749a((Object) t, t.getContext());
    }

    private static void m11749a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CoverPhotoEditView coverPhotoEditView = (CoverPhotoEditView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        BitmapUtils a = BitmapUtils.a(fbInjector);
        CoverPhotoEditEventBus a2 = CoverPhotoEditEventBus.a(fbInjector);
        coverPhotoEditView.f11675b = a;
        coverPhotoEditView.f11674a = abstractFbErrorReporter;
        coverPhotoEditView.f11676c = a2;
    }

    static /* synthetic */ float m11742a(CoverPhotoEditView coverPhotoEditView, float f) {
        float f2 = coverPhotoEditView.f11678e + f;
        coverPhotoEditView.f11678e = f2;
        return f2;
    }

    static /* synthetic */ float m11754c(CoverPhotoEditView coverPhotoEditView, float f) {
        float f2 = coverPhotoEditView.f11679f + f;
        coverPhotoEditView.f11679f = f2;
        return f2;
    }

    public CoverPhotoEditView(Context context) {
        super(context);
        m11753b();
    }

    public CoverPhotoEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11753b();
    }

    public CoverPhotoEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11753b();
    }

    private void m11753b() {
        m11748a(CoverPhotoEditView.class, (View) this);
    }

    public final void m11761a(String str, int i, int i2) {
        this.f11677d = str;
        this.f11681h = i;
        this.f11682i = i2;
        getLayoutParams().height = this.f11682i;
        setScaleType(ScaleType.MATRIX);
        new LoadScaledPhotoTask(this).a(getContext(), new Void[0]);
    }

    public RectF getNormalizedCropBounds() {
        float f = ((float) this.f11681h) / (((float) this.f11683j) * this.f11685l);
        float f2 = ((float) this.f11682i) / (((float) this.f11684k) * this.f11685l);
        return new RectF(getFocusX() - (f / 2.0f), getFocusY() - (f2 / 2.0f), (f / 2.0f) + getFocusX(), (f2 / 2.0f) + getFocusY());
    }

    public float getFocusY() {
        float f = 0.5f - (this.f11679f / (this.f11685l * ((float) this.f11684k)));
        if (Float.isNaN(f)) {
            this.f11674a.a("CoverPhotoEditView", "focusY is NaN. scale:" + this.f11685l + "image height: " + this.f11684k);
        }
        return f;
    }

    public float getFocusX() {
        float f = 0.5f - (this.f11678e / (this.f11685l * ((float) this.f11683j)));
        if (Float.isNaN(f)) {
            this.f11674a.a("CoverPhotoEditView", "focusX is NaN. scale:" + this.f11685l + "image width: " + this.f11683j);
        }
        return f;
    }

    private void m11750a(String str) {
        this.f11674a.a("editcoverphoto_decodeimage", str);
    }

    private void m11744a(Bitmap bitmap) {
        float f;
        this.f11686m = bitmap;
        setImageBitmap(bitmap);
        this.f11680g = new Matrix();
        int b = BitmapUtils.b(this.f11677d);
        if (b > 0) {
            RotateBitmap rotateBitmap = new RotateBitmap(bitmap, b);
            this.f11683j = rotateBitmap.e();
            this.f11684k = rotateBitmap.d();
            this.f11680g.postConcat(rotateBitmap.c());
        } else {
            this.f11683j = bitmap.getWidth();
            this.f11684k = bitmap.getHeight();
        }
        this.f11680g.postConcat(PhotoFocusUtil.a(this.f11681h, this.f11682i, this.f11683j, this.f11684k, 0.5d, 0.5d));
        b = this.f11681h;
        int i = this.f11682i;
        int i2 = this.f11683j;
        int i3 = this.f11684k;
        if (((float) i2) / ((float) i3) > ((float) b) / ((float) i)) {
            f = ((float) i) / ((float) i3);
        } else {
            f = ((float) b) / ((float) i2);
        }
        this.f11685l = f;
        final float f2 = 0.5f * ((((float) this.f11683j) * this.f11685l) - ((float) this.f11681h));
        final float f3 = -f2;
        final float f4 = 0.5f * ((((float) this.f11684k) * this.f11685l) - ((float) this.f11682i));
        final float f5 = -f4;
        m11743a(Math.max(Math.min(this.f11678e, f2), f3), Math.max(Math.min(this.f11679f, f4), f5));
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CoverPhotoEditView f11670e;
            private float f11671f;
            private float f11672g;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.f11671f = motionEvent.getX();
                        this.f11672g = motionEvent.getY();
                        break;
                    case 2:
                        float y = motionEvent.getY() - this.f11672g;
                        CoverPhotoEditView.m11742a(this.f11670e, motionEvent.getX() - this.f11671f);
                        if (this.f11670e.f11678e < f3) {
                            this.f11670e.f11678e = f3;
                        }
                        if (this.f11670e.f11678e > f2) {
                            this.f11670e.f11678e = f2;
                        }
                        CoverPhotoEditView.m11754c(this.f11670e, y);
                        if (this.f11670e.f11679f < f5) {
                            this.f11670e.f11679f = f5;
                        }
                        if (this.f11670e.f11679f > f4) {
                            this.f11670e.f11679f = f4;
                        }
                        this.f11671f = motionEvent.getX();
                        this.f11672g = motionEvent.getY();
                        this.f11670e.m11743a(this.f11670e.f11678e, this.f11670e.f11679f);
                        this.f11670e.invalidate();
                        break;
                }
                return true;
            }
        });
        CoverPhotoEditEventBus coverPhotoEditEventBus = this.f11676c;
        boolean z = f4 > 0.0f || f2 > 0.0f;
        coverPhotoEditEventBus.a(new EditCoverPhotoLoadedEvent(z));
    }

    private void m11743a(float f, float f2) {
        Matrix matrix = new Matrix(this.f11680g);
        matrix.postTranslate(f, f2);
        setImageMatrix(matrix);
    }

    public final void m11760a() {
        setImageBitmap(null);
        if (this.f11686m != null) {
            this.f11686m.recycle();
            this.f11686m = null;
        }
    }
}

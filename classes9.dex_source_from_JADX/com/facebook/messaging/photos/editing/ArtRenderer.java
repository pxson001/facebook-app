package com.facebook.messaging.photos.editing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: disposed_wakelock_held_ms */
public class ArtRenderer {
    private final PlatformBitmapFactory f16019a;

    /* compiled from: disposed_wakelock_held_ms */
    interface ArtBackgroundRenderer {
        int mo659a();

        void mo660a(Canvas canvas);

        int mo661b();

        Config mo662c();
    }

    /* compiled from: disposed_wakelock_held_ms */
    class BitmapArtBackgroundRenderer implements ArtBackgroundRenderer {
        private final WeakReference<Bitmap> f16017a;

        public BitmapArtBackgroundRenderer(Bitmap bitmap) {
            this.f16017a = new WeakReference(bitmap);
        }

        public final void mo660a(Canvas canvas) {
            Bitmap bitmap = (Bitmap) this.f16017a.get();
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
            }
        }

        public final int mo659a() {
            Bitmap bitmap = (Bitmap) this.f16017a.get();
            return bitmap == null ? 0 : bitmap.getWidth();
        }

        public final int mo661b() {
            Bitmap bitmap = (Bitmap) this.f16017a.get();
            return bitmap == null ? 0 : bitmap.getHeight();
        }

        public final Config mo662c() {
            Bitmap bitmap = (Bitmap) this.f16017a.get();
            return (bitmap == null || bitmap.getConfig() == null) ? Config.ARGB_8888 : bitmap.getConfig();
        }
    }

    /* compiled from: disposed_wakelock_held_ms */
    public enum Rotation {
        NONE,
        ROTATE_90_CCW,
        ROTATE_90_CW
    }

    /* compiled from: disposed_wakelock_held_ms */
    class ViewArtBackgroundRenderer implements ArtBackgroundRenderer {
        private final WeakReference<View> f16018a;

        public ViewArtBackgroundRenderer(View view) {
            this.f16018a = new WeakReference(view);
        }

        public final void mo660a(Canvas canvas) {
            View view = (View) this.f16018a.get();
            if (view != null) {
                view.draw(canvas);
            }
        }

        public final int mo659a() {
            View view = (View) this.f16018a.get();
            return view == null ? 0 : view.getWidth();
        }

        public final int mo661b() {
            View view = (View) this.f16018a.get();
            return view == null ? 0 : view.getHeight();
        }

        public final Config mo662c() {
            return Config.ARGB_8888;
        }
    }

    public static ArtRenderer m16167b(InjectorLike injectorLike) {
        return new ArtRenderer(PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ArtRenderer(PlatformBitmapFactory platformBitmapFactory) {
        this.f16019a = platformBitmapFactory;
    }

    public final Bitmap m16168a(@Nullable Bitmap bitmap, ViewGroup viewGroup, @ColorInt int i, Rotation rotation) {
        return m16166a(bitmap == null ? null : new BitmapArtBackgroundRenderer(bitmap), viewGroup, i, rotation);
    }

    public final Bitmap m16169a(@Nullable View view, ViewGroup viewGroup, @ColorInt int i, Rotation rotation) {
        return m16166a(view == null ? null : new ViewArtBackgroundRenderer(view), viewGroup, i, rotation);
    }

    private Bitmap m16166a(@Nullable ArtBackgroundRenderer artBackgroundRenderer, ViewGroup viewGroup, @ColorInt int i, Rotation rotation) {
        int width;
        CloseableReference a;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof EditText) {
                EditText editText = (EditText) childAt;
                editText.clearComposingText();
                editText.setInputType(editText.getInputType() | 524288);
            }
        }
        Config c = artBackgroundRenderer == null ? null : artBackgroundRenderer.mo662c();
        PlatformBitmapFactory platformBitmapFactory;
        int height;
        if (rotation == Rotation.NONE) {
            platformBitmapFactory = this.f16019a;
            width = viewGroup.getWidth();
            height = viewGroup.getHeight();
            if (c == null) {
                c = Config.ARGB_8888;
            }
            a = platformBitmapFactory.a(width, height, c);
        } else {
            platformBitmapFactory = this.f16019a;
            width = viewGroup.getHeight();
            height = viewGroup.getWidth();
            if (c == null) {
                c = Config.ARGB_8888;
            }
            a = platformBitmapFactory.a(width, height, c);
        }
        Bitmap bitmap = (Bitmap) a.a();
        Canvas canvas = new Canvas(bitmap);
        if (i != 0) {
            canvas.drawColor(i);
        }
        if (rotation != Rotation.NONE) {
            Matrix matrix = new Matrix();
            if (artBackgroundRenderer != null) {
                matrix.postTranslate((float) ((-artBackgroundRenderer.mo659a()) / 2), (float) ((-artBackgroundRenderer.mo661b()) / 2));
            }
            if (rotation == Rotation.ROTATE_90_CCW) {
                matrix.postRotate(90.0f);
            } else if (rotation == Rotation.ROTATE_90_CW) {
                matrix.postRotate(-90.0f);
            }
            if (artBackgroundRenderer != null) {
                matrix.postTranslate((float) (artBackgroundRenderer.mo661b() / 2), (float) (artBackgroundRenderer.mo659a() / 2));
            }
            canvas.setMatrix(matrix);
        }
        if (artBackgroundRenderer == null) {
            viewGroup.draw(canvas);
        } else {
            artBackgroundRenderer.mo660a(canvas);
            canvas.save();
            canvas.translate((float) ((artBackgroundRenderer.mo659a() - viewGroup.getWidth()) / 2), (float) ((artBackgroundRenderer.mo661b() - viewGroup.getHeight()) / 2));
            viewGroup.draw(canvas);
            canvas.restore();
        }
        for (width = viewGroup.getChildCount() - 1; width >= 0; width--) {
            View childAt2 = viewGroup.getChildAt(width);
            if (childAt2 instanceof EditText) {
                EditText editText2 = (EditText) childAt2;
                editText2.setInputType(editText2.getInputType() & -524289);
            }
        }
        return bitmap;
    }
}

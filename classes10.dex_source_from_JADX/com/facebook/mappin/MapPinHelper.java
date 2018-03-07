package com.facebook.mappin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.facebook.bitmaps.FbBitmapFactory;
import com.google.common.base.Preconditions;

/* compiled from: thread_view */
public class MapPinHelper {
    public final Resources f1468a;

    public MapPinHelper(Resources resources) {
        this.f1468a = resources;
    }

    public final Drawable m1459a(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        return m1457c(m1455a(2130841148, drawable));
    }

    public final Drawable m1461b(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        return m1457c(m1455a(2130841156, drawable));
    }

    public final Drawable m1460a(Drawable drawable, int i) {
        Preconditions.checkNotNull(drawable);
        LayerDrawable a = m1455a(2130841155, drawable);
        m1456a(a, i);
        return m1457c(a);
    }

    public final Drawable m1458a(int i) {
        LayerDrawable layerDrawable = (LayerDrawable) this.f1468a.getDrawable(2130841155);
        m1456a(layerDrawable, i);
        return m1457c(layerDrawable);
    }

    private void m1456a(LayerDrawable layerDrawable, int i) {
        Bitmap a = FbBitmapFactory.a(this.f1468a, 2130841140);
        Bitmap copy = a.copy(Config.ARGB_8888, true);
        a.recycle();
        layerDrawable.mutate();
        String valueOf = String.valueOf(i);
        Paint paint = new Paint();
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextSize(((float) copy.getHeight()) * 0.4f);
        Canvas canvas = new Canvas(copy);
        canvas.drawText(valueOf, (((float) canvas.getWidth()) / 2.0f) - (paint.measureText(valueOf) / 2.0f), (((float) canvas.getHeight()) / 2.0f) - ((paint.descent() + paint.ascent()) / 2.0f), paint);
        Drawable bitmapDrawable = new BitmapDrawable(this.f1468a, copy);
        bitmapDrawable.setGravity(53);
        layerDrawable.setDrawableByLayerId(2131568586, bitmapDrawable);
    }

    public static Drawable m1457c(Drawable drawable) {
        drawable.setBounds((-drawable.getIntrinsicWidth()) / 2, -drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth() / 2, 0);
        return drawable;
    }

    private LayerDrawable m1455a(int i, Drawable drawable) {
        LayerDrawable layerDrawable = (LayerDrawable) this.f1468a.getDrawable(i);
        int applyDimension = (int) TypedValue.applyDimension(1, 30.0f, this.f1468a.getDisplayMetrics());
        drawable.setBounds(0, 0, applyDimension, applyDimension);
        layerDrawable.mutate();
        layerDrawable.setDrawableByLayerId(2131568585, drawable);
        return layerDrawable;
    }
}

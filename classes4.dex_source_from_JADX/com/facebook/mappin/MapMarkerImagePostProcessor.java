package com.facebook.mappin;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.SizeUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: network_session_id */
public class MapMarkerImagePostProcessor extends BasePostprocessor {
    private final int f7205a;
    private final int f7206b;
    private final int f7207c;

    public static MapMarkerImagePostProcessor m7528b(InjectorLike injectorLike) {
        return new MapMarkerImagePostProcessor(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MapMarkerImagePostProcessor(Resources resources) {
        this.f7205a = SizeUtil.a(resources, 3.0f);
        this.f7206b = SizeUtil.a(resources, 40.0f);
        this.f7207c = SizeUtil.a(resources, 7.0f);
    }

    public final CloseableReference<Bitmap> mo602a(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        int i = (this.f7205a * 4) + this.f7206b;
        CloseableReference a = platformBitmapFactory.a(i, this.f7207c + i, Config.ARGB_8888);
        Canvas canvas = new Canvas((Bitmap) a.a());
        int parseColor = Color.parseColor("#fff5156f");
        m7527a(canvas, parseColor, new RectF(0.0f, 0.0f, (float) i, (float) i));
        m7527a(canvas, -1, new RectF((float) this.f7205a, (float) this.f7205a, (float) ((this.f7205a * 3) + this.f7206b), (float) ((this.f7205a * 3) + this.f7206b)));
        m7525a(i, canvas, parseColor);
        m7526a(bitmap, a, canvas);
        return a;
    }

    private void m7526a(Bitmap bitmap, CloseableReference<Bitmap> closeableReference, Canvas canvas) {
        ((Bitmap) closeableReference.a()).setHasAlpha(true);
        canvas.drawBitmap(bitmap, null, new RectF((float) (this.f7205a * 2), (float) (this.f7205a * 2), (float) ((this.f7205a * 2) + this.f7206b), (float) ((this.f7205a * 2) + this.f7206b)), null);
    }

    private void m7525a(int i, Canvas canvas, int i2) {
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        Point point = new Point((i / 2) - this.f7207c, i);
        Point point2 = new Point(i / 2, this.f7207c + i);
        Point point3 = new Point((i / 2) + this.f7207c, i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        path.lineTo((float) point.x, (float) point.y);
        path.close();
        canvas.drawPath(path, paint);
    }

    private static void m7527a(Canvas canvas, int i, RectF rectF) {
        Paint paint = new Paint();
        paint.setColor(i);
        canvas.drawRect(rectF, paint);
    }
}

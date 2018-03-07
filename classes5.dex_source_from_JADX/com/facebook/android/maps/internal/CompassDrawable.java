package com.facebook.android.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.facebook.android.maps.CameraUpdate;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;

/* compiled from: away_team */
public class CompassDrawable extends MapDrawable {
    private float f8318o;
    private float f8319p;
    private float f8320q;
    private float f8321r;
    private float f8322s;
    private float f8323t;
    private float f8324u;
    private float f8325v;
    private final float f8326w;
    private Bitmap f8327x;

    public CompassDrawable(FacebookMap facebookMap) {
        super(facebookMap);
        this.f8318o = 12.0f * this.f8079d;
        this.f8319p = 0.4f * this.f8079d;
        this.f8320q = 16.0f * this.f8079d;
        this.f8321r = 12.0f * this.f8079d;
        this.f8322s = 4.8f * this.f8079d;
        this.f8323t = 1.6f * this.f8079d;
        this.f8326w = 44.0f * this.f8079d;
        this.j = 3;
        this.k = 1.0f;
        this.l = false;
        int ceil = (int) Math.ceil((double) ((this.f8320q * 1.08f) * 2.0f));
        int ceil2 = (int) Math.ceil((double) ((this.f8320q * 1.08f) * 2.0f));
        this.f8327x = Bitmap.createBitmap(ceil, ceil2, Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f8327x);
        float f = ((float) ceil) / 2.0f;
        float f2 = ((float) ceil2) / 2.0f;
        RectF rectF = new RectF(f - this.f8323t, f2 - this.f8323t, this.f8323t + f, this.f8323t + f2);
        float f3 = 1.08f * this.f8320q;
        Shader radialGradient = new RadialGradient(f, f2, f3, new int[]{570425344, 570425344, 0}, new float[]{0.9259259f, 0.9259259f, 1.0f}, TileMode.CLAMP);
        Path path = new Path();
        Paint paint = new Paint(1);
        paint.setStyle(Style.FILL);
        paint.setShader(radialGradient);
        canvas.drawCircle(f, f2, f3, paint);
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Style.FILL);
        paint.setColor(-2046820353);
        canvas.drawCircle(f, f2, this.f8320q, paint);
        paint.setStyle(Style.STROKE);
        paint.setColor(-6118750);
        paint.setStrokeWidth(this.f8319p);
        canvas.drawCircle(f, f2, this.f8320q, paint);
        paint.setFlags(1);
        paint.setStyle(Style.FILL);
        paint.setColor(-1365724);
        path.reset();
        path.moveTo(f - this.f8322s, f2);
        path.lineTo(f - this.f8323t, f2);
        path.addArc(rectF, 180.0f, 90.0f);
        path.lineTo(f, f2 - this.f8321r);
        path.lineTo(f - this.f8322s, f2);
        path.close();
        canvas.drawPath(path, paint);
        paint.setStyle(Style.FILL);
        paint.setColor(-2811114);
        path.reset();
        path.moveTo(this.f8322s + f, f2);
        path.lineTo(this.f8323t + f, f2);
        path.addArc(rectF, 0.0f, -90.0f);
        path.lineTo(f, f2 - this.f8321r);
        path.lineTo(this.f8322s + f, f2);
        path.close();
        canvas.drawPath(path, paint);
        paint.setStyle(Style.FILL);
        paint.setColor(-4013374);
        path.reset();
        path.moveTo(f - this.f8322s, f2);
        path.lineTo(f - this.f8323t, f2);
        path.addArc(rectF, 180.0f, -90.0f);
        path.lineTo(f, this.f8321r + f2);
        path.lineTo(f - this.f8322s, f2);
        path.close();
        canvas.drawPath(path, paint);
        paint.setStyle(Style.FILL);
        paint.setColor(-2434342);
        path.reset();
        path.moveTo(this.f8322s + f, f2);
        path.lineTo(this.f8323t + f, f2);
        path.addArc(rectF, 0.0f, 90.0f);
        path.lineTo(f, this.f8321r + f2);
        path.lineTo(this.f8322s + f, f2);
        path.close();
        canvas.drawPath(path, paint);
    }

    protected final void mo1036b() {
        float f = this.f8318o + ((float) this.f8080e.f8130d);
        this.f8324u = (this.f8318o + ((float) this.f8080e.f8129c)) + this.f8320q;
        this.f8325v = this.f8320q + f;
    }

    public final int mo1031a(float f, float f2) {
        if (f >= this.f8324u - this.f8320q && f <= this.f8324u + this.f8320q && f2 >= this.f8325v - this.f8320q && f2 <= this.f8325v + this.f8320q) {
            return 2;
        }
        if (f < this.f8324u - this.f8326w || f > this.f8324u + this.f8326w || f2 < this.f8325v - this.f8326w || f2 > this.f8325v + this.f8326w) {
            return 0;
        }
        return 1;
    }

    public final boolean mo1038b(float f, float f2) {
        FacebookMap facebookMap = this.f8080e;
        CameraUpdate cameraUpdate = new CameraUpdate();
        cameraUpdate.f8045h = 0.0f;
        facebookMap.m14281a(cameraUpdate);
        return true;
    }

    public final void mo1032a(Canvas canvas) {
        canvas.save(1);
        canvas.rotate(this.f8080e.f8137k.b(), this.f8324u, this.f8325v);
        canvas.drawBitmap(this.f8327x, this.f8324u - this.f8320q, this.f8325v - this.f8320q, null);
        canvas.restore();
    }
}

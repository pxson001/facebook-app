package com.facebook.android.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: autoFocus failed */
public final class BitmapDescriptorFactory {
    public static float f8537a = 1.0f;
    private static final HashMap<String, WeakReference<BitmapDescriptor>> f8538b = new HashMap(16);
    public static Context f8539c;
    private static long f8540d;
    private static final float f8541e = (((float) Math.sqrt(3.0d)) / 2.0f);

    /* compiled from: autoFocus failed */
    interface BitmapCreator {
        Bitmap mo1080a();
    }

    /* compiled from: autoFocus failed */
    public final class C09321 implements BitmapCreator {
        final /* synthetic */ float f8535a;

        public C09321(float f) {
            this.f8535a = f;
        }

        public final Bitmap mo1080a() {
            float f = this.f8535a;
            Paint paint = new Paint(1);
            float f2 = 10.0f * BitmapDescriptorFactory.f8537a;
            int round = Math.round(2.0f * f2);
            int round2 = Math.round(3.0f * f2);
            Bitmap createBitmap = Bitmap.createBitmap(round + 10, round2 + 10, Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            float[] fArr = new float[]{f, 1.0f, 1.0f};
            int HSVToColor = Color.HSVToColor(fArr);
            fArr[2] = 0.8f;
            int HSVToColor2 = Color.HSVToColor(fArr);
            fArr[2] = 0.5f;
            int HSVToColor3 = Color.HSVToColor(fArr);
            paint.setColor(HSVToColor);
            BitmapDescriptorFactory.m14559a(canvas, paint, 5.0f + f2, (float) (round2 + 5), f2);
            paint.setColor(HSVToColor3);
            canvas.drawCircle(f2 + 5.0f, f2 + 5.0f, f2 / 2.5f, paint);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth(BitmapDescriptorFactory.f8537a);
            paint.setColor(HSVToColor2);
            BitmapDescriptorFactory.m14559a(canvas, paint, 5.0f + f2, (float) (round2 + 5), f2);
            return createBitmap;
        }
    }

    /* compiled from: autoFocus failed */
    final class C09335 implements BitmapCreator {
        final /* synthetic */ int f8536a;

        C09335(int i) {
            this.f8536a = i;
        }

        public final Bitmap mo1080a() {
            return BitmapFactory.decodeResource(BitmapDescriptorFactory.f8539c.getResources(), this.f8536a);
        }
    }

    public static void m14558a(Context context) {
        f8539c = context;
        f8537a = context.getResources().getDisplayMetrics().density;
    }

    public static BitmapDescriptor m14556a(Bitmap bitmap) {
        return new BitmapDescriptor(bitmap.copy(bitmap.getConfig(), false));
    }

    public static BitmapDescriptor m14555a(int i) {
        if (f8539c == null) {
            return null;
        }
        return m14557a("resource_" + i, new C09335(i));
    }

    public static BitmapDescriptor m14557a(String str, BitmapCreator bitmapCreator) {
        BitmapDescriptor bitmapDescriptor = null;
        WeakReference weakReference = (WeakReference) f8538b.get(str);
        BitmapDescriptor bitmapDescriptor2 = weakReference != null ? (BitmapDescriptor) weakReference.get() : null;
        long uptimeMillis;
        Iterator it;
        if (bitmapDescriptor2 == null) {
            Bitmap a = bitmapCreator.mo1080a();
            if (a != null) {
                bitmapDescriptor2 = new BitmapDescriptor(a);
                f8538b.put(str, new WeakReference(bitmapDescriptor2));
                bitmapDescriptor = bitmapDescriptor2;
                uptimeMillis = SystemClock.uptimeMillis();
                if (f8540d >= 600000 || f8540d == 0) {
                    f8540d = uptimeMillis;
                    it = f8538b.entrySet().iterator();
                    while (it.hasNext()) {
                        if (((WeakReference) ((Entry) it.next()).getValue()).get() == null) {
                            it.remove();
                        }
                    }
                }
            }
        } else {
            bitmapDescriptor = bitmapDescriptor2;
            uptimeMillis = SystemClock.uptimeMillis();
            f8540d = uptimeMillis;
            it = f8538b.entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) ((Entry) it.next()).getValue()).get() == null) {
                    it.remove();
                }
            }
        }
        return bitmapDescriptor;
    }

    public static void m14559a(Canvas canvas, Paint paint, float f, float f2, float f3) {
        Path path = new Path();
        float f4 = f2 - (2.0f * f3);
        path.moveTo(f, f4);
        path.arcTo(new RectF(f - f3, f4 - f3, f + f3, f4 + f3), 30.0f, -240.0f, true);
        path.lineTo(f, (f3 * 2.0f) + f4);
        path.lineTo((f8541e * f3) + f, f4 + (0.5f * f3));
        path.close();
        canvas.drawPath(path, paint);
    }
}

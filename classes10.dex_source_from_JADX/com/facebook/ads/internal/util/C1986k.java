package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.thirdparty.http.C1961a;
import com.facebook.ads.internal.view.C2000e;

public class C1986k extends AsyncTask<String, Void, Bitmap[]> {
    private static final String f14340a = C1986k.class.getSimpleName();
    private final Context f14341b;
    private final ImageView f14342c;
    private final C2000e f14343d;
    public C1887l f14344e;

    public C1986k(Context context) {
        this.f14341b = context;
        this.f14343d = null;
        this.f14342c = null;
    }

    public C1986k(ImageView imageView) {
        this.f14341b = imageView.getContext();
        this.f14343d = null;
        this.f14342c = imageView;
    }

    public C1986k(C2000e c2000e) {
        this.f14341b = c2000e.getContext();
        this.f14343d = c2000e;
        this.f14342c = null;
    }

    protected Object doInBackground(Object[] objArr) {
        Bitmap a;
        Throwable th;
        Object obj;
        Object obj2;
        Bitmap bitmap;
        String str = null;
        String str2 = ((String[]) objArr)[0];
        try {
            a = C1988m.m14475a(this.f14341b, str2);
            if (a == null) {
                try {
                    byte[] d = new C1961a(this.f14341b).m14415a(str2, null).m14436d();
                    a = BitmapFactory.decodeByteArray(d, 0, d.length);
                    C1988m.m14476a(this.f14341b, str2, a);
                } catch (Throwable th2) {
                    th = th2;
                    obj = str;
                    Log.e(f14340a, "Error downloading image: " + str2, th);
                    C1976c.m14446a(C1975b.m14443a(th, str));
                    obj2 = bitmap;
                    bitmap = a;
                    return new Bitmap[]{bitmap, str};
                }
            }
            bitmap = a;
            try {
                if (!(this.f14343d == null || bitmap == null)) {
                    try {
                        C1993q c1993q = new C1993q(bitmap);
                        c1993q.m14485a(Math.round(((float) bitmap.getWidth()) / 40.0f));
                        str = c1993q.m14484a();
                    } catch (Throwable th3) {
                        th = th3;
                        a = bitmap;
                        Log.e(f14340a, "Error downloading image: " + str2, th);
                        C1976c.m14446a(C1975b.m14443a(th, str));
                        obj2 = bitmap;
                        bitmap = a;
                        return new Bitmap[]{bitmap, str};
                    }
                }
            } catch (Throwable th32) {
                th = th32;
                a = bitmap;
                obj = str;
                Log.e(f14340a, "Error downloading image: " + str2, th);
                C1976c.m14446a(C1975b.m14443a(th, str));
                obj2 = bitmap;
                bitmap = a;
                return new Bitmap[]{bitmap, str};
            }
        } catch (Throwable th22) {
            th = th22;
            a = str;
            bitmap = str;
            Log.e(f14340a, "Error downloading image: " + str2, th);
            C1976c.m14446a(C1975b.m14443a(th, str));
            obj2 = bitmap;
            bitmap = a;
            return new Bitmap[]{bitmap, str};
        }
        return new Bitmap[]{bitmap, str};
    }

    protected void onPostExecute(Object obj) {
        Bitmap[] bitmapArr = (Bitmap[]) obj;
        if (this.f14342c != null) {
            this.f14342c.setImageBitmap(bitmapArr[0]);
        }
        if (this.f14343d != null) {
            this.f14343d.m14491a(bitmapArr[0], bitmapArr[1]);
        }
        if (this.f14344e != null) {
            this.f14344e.mo703a();
        }
    }
}

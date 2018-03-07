package com.facebook.messaging.camerautil;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.messaging.camerautil.MonitoredActivity.LifeCycleAdapter;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: proxy_login_permissions_list */
public class CameraUtil {
    private static final Class<?> f9612a = CameraUtil.class;

    /* compiled from: proxy_login_permissions_list */
    class BackgroundJob extends LifeCycleAdapter implements Runnable {
        public final MonitoredActivity f9607a;
        public final ProgressDialog f9608b;
        private final Runnable f9609c;
        private final Handler f9610d;
        private final Runnable f9611e = new C11161(this);

        /* compiled from: proxy_login_permissions_list */
        class C11161 implements Runnable {
            final /* synthetic */ BackgroundJob f9606a;

            C11161(BackgroundJob backgroundJob) {
                this.f9606a = backgroundJob;
            }

            public void run() {
                MonitoredActivity monitoredActivity = this.f9606a.f9607a;
                monitoredActivity.f9629p.remove(this.f9606a);
                if (this.f9606a.f9608b.getWindow() != null) {
                    this.f9606a.f9608b.dismiss();
                }
            }
        }

        public BackgroundJob(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.f9607a = monitoredActivity;
            this.f9608b = progressDialog;
            this.f9609c = runnable;
            MonitoredActivity monitoredActivity2 = this.f9607a;
            if (!monitoredActivity2.f9629p.contains(this)) {
                monitoredActivity2.f9629p.add(this);
            }
            this.f9610d = handler;
        }

        public void run() {
            try {
                this.f9609c.run();
            } finally {
                HandlerDetour.a(this.f9610d, this.f9611e, 1414511967);
            }
        }

        public final void mo380a() {
            this.f9611e.run();
            HandlerDetour.a(this.f9610d, this.f9611e);
        }

        public final void mo381b() {
            this.f9608b.hide();
        }

        public final void mo382c() {
            this.f9608b.show();
        }
    }

    private CameraUtil() {
    }

    public static Bitmap m10217a(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == createBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    private static int m10213a(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        if (min >= ceil) {
            if (i2 == -1 && i == -1) {
                ceil = 1;
            } else if (i != -1) {
                ceil = min;
            }
        }
        int i3 = ceil;
        if (i3 > 8) {
            return ((i3 + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < i3) {
            i4 <<= 1;
        }
        return i4;
    }

    public static Bitmap m10218a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        Bitmap createBitmap;
        Matrix matrix2 = null;
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        if (z || (width >= 0 && height >= 0)) {
            Bitmap createBitmap2;
            float width2 = (float) bitmap.getWidth();
            float height2 = (float) bitmap.getHeight();
            if (width2 / height2 > ((float) i) / ((float) i2)) {
                width2 = ((float) i2) / height2;
                if (width2 < 0.9f || width2 > 1.0f) {
                    matrix.setScale(width2, width2);
                    matrix2 = matrix;
                }
            } else {
                width2 = ((float) i) / width2;
                if (width2 < 0.9f || width2 > 1.0f) {
                    matrix.setScale(width2, width2);
                    matrix2 = matrix;
                }
            }
            if (matrix2 != null) {
                createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } else {
                createBitmap2 = bitmap;
            }
            if (z2 && createBitmap2 != bitmap) {
                bitmap.recycle();
            }
            createBitmap = Bitmap.createBitmap(createBitmap2, Math.max(0, createBitmap2.getWidth() - i) / 2, Math.max(0, createBitmap2.getHeight() - i2) / 2, i, i2);
            if (createBitmap != createBitmap2 && (z2 || createBitmap2 != bitmap)) {
                createBitmap2.recycle();
            }
        } else {
            createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            width = Math.max(0, width / 2);
            int max = Math.max(0, height / 2);
            Rect rect = new Rect(width, max, Math.min(i, bitmap.getWidth()) + width, Math.min(i2, bitmap.getHeight()) + max);
            max = (i - rect.width()) / 2;
            width = (i2 - rect.height()) / 2;
            canvas.drawBitmap(bitmap, rect, new Rect(max, width, i - max, i2 - width), null);
            if (z2) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }

    public static void m10223a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    private static void m10221a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (Throwable th) {
            }
        }
    }

    public static Bitmap m10215a(int i, int i2, Uri uri, ContentResolver contentResolver, boolean z) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        try {
            Options a;
            openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (z) {
                try {
                    a = m10219a();
                } catch (IOException e) {
                    m10221a(openFileDescriptor);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    m10221a(openFileDescriptor);
                    throw th;
                }
            }
            a = null;
            Bitmap a2 = m10214a(i, i2, uri, contentResolver, openFileDescriptor, a);
            m10221a(openFileDescriptor);
            return a2;
        } catch (IOException e2) {
            openFileDescriptor = null;
            m10221a(openFileDescriptor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            openFileDescriptor = null;
            m10221a(openFileDescriptor);
            throw th;
        }
    }

    public static Bitmap m10216a(int i, int i2, ParcelFileDescriptor parcelFileDescriptor, boolean z) {
        Options a;
        if (z) {
            a = m10219a();
        } else {
            a = null;
        }
        return m10214a(i, i2, null, null, parcelFileDescriptor, a);
    }

    private static Bitmap m10214a(int i, int i2, Uri uri, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, Options options) {
        Bitmap bitmap = null;
        if (parcelFileDescriptor == null) {
            try {
                parcelFileDescriptor = m10220a(uri, contentResolver);
            } catch (Throwable e) {
                BLog.b(f9612a, "Got oom exception ", e);
            } finally {
                m10221a(parcelFileDescriptor);
            }
        }
        if (parcelFileDescriptor == null) {
            m10221a(parcelFileDescriptor);
        } else {
            if (options == null) {
                options = new Options();
            }
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            options.inJustDecodeBounds = true;
            BitmapManager.m10202a().m10206a(fileDescriptor, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                m10221a(parcelFileDescriptor);
            } else {
                options.inSampleSize = m10213a(options, i, i2);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Config.ARGB_8888;
                bitmap = BitmapManager.m10202a().m10206a(fileDescriptor, options);
                m10221a(parcelFileDescriptor);
            }
        }
        return bitmap;
    }

    private static ParcelFileDescriptor m10220a(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openFileDescriptor(uri, "r");
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean m10224a(String str, String str2) {
        return str == str2 || str.equals(str2);
    }

    public static void m10222a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        ThreadInitDetour.a(new BackgroundJob(monitoredActivity, runnable, ProgressDialog.a(monitoredActivity, str, str2, true, false), handler), 1955606940).start();
    }

    private static Options m10219a() {
        return new Options();
    }
}

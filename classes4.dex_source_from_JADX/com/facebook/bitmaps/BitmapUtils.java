package com.facebook.bitmaps;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: gcm_empty_push_notification */
public class BitmapUtils {
    private static final Map<Integer, String[]> f11310b;
    private static final Paint f11311c = new Paint(2);
    public boolean f11312a = true;

    public static BitmapUtils m11716a(InjectorLike injectorLike) {
        return new BitmapUtils();
    }

    static {
        Map hashMap = new HashMap();
        f11310b = hashMap;
        hashMap.put(Integer.valueOf(11), new String[]{"FNumber", "ExposureTime", "ISOSpeedRatings"});
        f11310b.put(Integer.valueOf(9), new String[]{"GPSAltitude", "GPSAltitudeRef"});
        f11310b.put(Integer.valueOf(8), new String[]{"FocalLength", "GPSDateStamp", "GPSTimeStamp", "GPSProcessingMethod"});
        f11310b.put(Integer.valueOf(5), new String[]{"DateTime", "Flash", "Orientation", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "WhiteBalance"});
    }

    public static Dimension m11717a(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Dimension(options.outWidth, options.outHeight);
    }

    public final Bitmap m11726a(String str, int i, int i2) {
        Dimension a = m11717a(str);
        if (a.b <= i && a.a <= i2) {
            return m11715a(str, null);
        }
        float f;
        float f2 = ((float) a.a) / ((float) i2);
        if (((float) a.b) / ((float) i) > f2) {
            f = (float) i;
        } else {
            f = ((float) a.b) / f2;
        }
        if (((float) a.b) <= f) {
            return m11715a(str, null);
        }
        Options options = new Options();
        options.inSampleSize = a.b / ((int) f);
        return m11715a(str, options);
    }

    final Bitmap m11724a(Context context, File file, int i) {
        Throwable th;
        Bitmap bitmap = null;
        try {
            Bitmap a = m11722a(context, Uri.fromFile(file), i, i, false);
            if (a == null) {
                if (!(a == null || a == null)) {
                    a.recycle();
                }
                return null;
            }
            try {
                if (a.getWidth() <= i && a.getHeight() <= i) {
                    return a;
                }
                int i2;
                double width = ((double) a.getWidth()) / ((double) a.getHeight());
                if (width > 1.0d) {
                    i2 = i;
                    i = (int) (((double) i) / width);
                } else {
                    i2 = (int) (width * ((double) i));
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, i2, i, true);
                if (!(a == null || a == createScaledBitmap)) {
                    a.recycle();
                }
                return createScaledBitmap;
            } catch (Throwable th2) {
                bitmap = a;
                th = th2;
                if (!(bitmap == null || bitmap == null)) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap.recycle();
            throw th;
        }
    }

    @TargetApi(10)
    public final Bitmap m11725a(Uri uri, Rect rect, int i, int i2, int i3, boolean z) {
        BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri.toString(), true);
        float a = m11711a(rect.width(), rect.height(), i, i2, i3, z);
        Options options = new Options();
        options.inSampleSize = (int) a;
        options.inPurgeable = true;
        return m11714a(newInstance.decodeRegion(rect, options), i, z);
    }

    public static Bitmap m11713a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return Bitmap.createBitmap(bitmap, i, i2, i3, i4);
    }

    public final void m11727a(String str, String str2) {
        m11719a(str, str2, 0);
    }

    public static void m11719a(String str, String str2, int i) {
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            ExifInterface exifInterface2 = new ExifInterface(str2);
            int i2 = VERSION.SDK_INT;
            for (Integer num : f11310b.keySet()) {
                if (i2 >= num.intValue()) {
                    for (String str3 : (String[]) f11310b.get(num)) {
                        String attribute = exifInterface.getAttribute(str3);
                        if (attribute != null) {
                            exifInterface2.setAttribute(str3, attribute);
                        }
                    }
                }
            }
            if (i != 0) {
                exifInterface2.setAttribute("Orientation", String.valueOf(i));
            }
            exifInterface2.saveAttributes();
        } catch (IOException e) {
            throw new BitmapIOException("copyExif from " + str + " to " + str2, e);
        }
    }

    private static float m11711a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (!(z && (i3 == 90 || i3 == 270))) {
            int i6 = i2;
            i2 = i;
            i = i6;
        }
        if (i2 > i4 || i > i5) {
            return Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i5));
        }
        return 1.0f;
    }

    public static Bitmap m11714a(Bitmap bitmap, int i, boolean z) {
        if (!z || i <= 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) i);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (!(bitmap == null || bitmap == createBitmap)) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Throwable th) {
            if (!(bitmap == null || bitmap == null)) {
                bitmap.recycle();
            }
        }
    }

    public final Bitmap m11722a(Context context, Uri uri, int i, int i2, boolean z) {
        try {
            return m11712a(context, new ImageSource(uri), m11721a(context, uri), i, i2, z);
        } catch (IOException e) {
            throw new BitmapIOException(uri.toString(), e);
        }
    }

    private Bitmap m11712a(Context context, ImageSource imageSource, int i, int i2, int i3, boolean z) {
        OutOfMemoryError outOfMemoryError;
        try {
            Options a = imageSource.a(context);
            float a2 = m11711a(a.outWidth, a.outHeight, i, i2, i3, z);
            int i4 = 0;
            outOfMemoryError = null;
            for (float f = 1.0f; f < 2.0f; f *= 1.19f) {
                if (((int) a2) != i4) {
                    try {
                        Options options = new Options();
                        options.inSampleSize = (int) a2;
                        return m11714a(imageSource.a(context, options), i, z);
                    } catch (OutOfMemoryError e) {
                        outOfMemoryError = e;
                        if (!this.f11312a) {
                            throw new BitmapOutOfMemoryException(outOfMemoryError);
                        }
                    }
                }
                i4 = (int) a2;
                a2 *= 1.19f;
            }
            BLog.b("BitmapUtils", "unable to resize image, even after additional subsampling");
            throw new BitmapOutOfMemoryException(outOfMemoryError);
        } catch (OutOfMemoryError outOfMemoryError2) {
            throw new BitmapOutOfMemoryException(outOfMemoryError2);
        } catch (UndeclaredThrowableException e2) {
            throw new BitmapImageSourceException(e2);
        }
    }

    public final Bitmap m11723a(Context context, Uri uri, boolean z) {
        return m11722a(context, uri, 960, 960, z);
    }

    public final int m11721a(Context context, Uri uri) {
        if (!uri.getScheme().equals("content") || !uri.getHost().equals("media") || !uri.getPath().startsWith(Media.EXTERNAL_CONTENT_URI.getPath())) {
            return uri.getScheme().equals("file") ? m11720b(uri.getPath()) : -1;
        } else {
            Cursor query = context.getContentResolver().query(uri, new String[]{"orientation"}, null, null, null);
            try {
                if (query.getCount() != 1) {
                    return -1;
                }
                query.moveToFirst();
                int i = query.getInt(0);
                query.close();
                return i;
            } finally {
                query.close();
            }
        }
    }

    public static int m11720b(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 1:
                    return 0;
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return -1;
            }
        } catch (IOException e) {
            return -1;
        }
    }

    private static Bitmap m11715a(String str, @Nullable Options options) {
        Object obj;
        Bitmap a;
        if (options != null) {
            try {
                if (!options.inPurgeable) {
                    obj = null;
                    a = obj == null ? FbBitmapFactory.m13881a(str, options) : FbBitmapFactory.m13886b(str, options);
                    if (a == null) {
                        return a;
                    }
                    throw new BitmapDecodeException();
                }
            } catch (OutOfMemoryError e) {
                throw new BitmapOutOfMemoryException(e);
            }
        }
        obj = 1;
        if (obj == null) {
        }
        if (a == null) {
            return a;
        }
        throw new BitmapDecodeException();
    }

    public static void m11718a(Bitmap bitmap, CompressFormat compressFormat, int i, File file) {
        IOException e;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                if (bitmap.compress(compressFormat, i, fileOutputStream)) {
                    fileOutputStream.close();
                    return;
                }
                throw new IOException("cannot compress bitmap to file: " + file.getPath());
            } catch (IOException e2) {
                e = e2;
                try {
                    throw new BitmapIOException(file.getPath(), e);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    file.delete();
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            throw new BitmapIOException(file.getPath(), e);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            throw th;
        }
    }

    public final boolean m11728a(Context context, File file, File file2, int i, int i2, int i3) {
        Bitmap a;
        Throwable th;
        File file3 = null;
        try {
            boolean z;
            a = m11722a(context, Uri.fromFile(file), i, i2, false);
            if (a != null) {
                try {
                    m11718a(a, CompressFormat.JPEG, i3, file2);
                    m11727a(file.getAbsolutePath(), file2.getAbsolutePath());
                    z = true;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.recycle();
                    }
                    file2.delete();
                    throw th;
                }
            }
            z = false;
            file3 = file2;
            if (a != null) {
                a.recycle();
            }
            if (file3 != null && file3.exists()) {
                file3.delete();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.recycle();
            }
            if (file2 != null && file2.exists()) {
                file2.delete();
            }
            throw th;
        }
    }
}

package com.facebook.bitmaps;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.facebook.debug.log.BLog;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: end_call_reason_string */
public class FbBitmapFactory {
    private static byte[] f13034a = new byte[16384];
    private static final Lock f13035b = new ReentrantLock();
    private static int f13036c = 0;

    private FbBitmapFactory() {
    }

    private static boolean m13885a() {
        if (f13035b.tryLock()) {
            return true;
        }
        int i = f13036c + 1;
        f13036c = i;
        Integer.valueOf(i);
        return false;
    }

    public static Bitmap m13882a(byte[] bArr, int i, int i2) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, m13884a(null));
    }

    public static Options m13884a(@Nullable Options options) {
        if (options == null) {
            options = new Options();
        }
        if (!options.inJustDecodeBounds) {
            options.inPurgeable = true;
            options.inInputShareable = true;
        }
        return options;
    }

    public static Bitmap m13883a(byte[] bArr, int i, int i2, Options options) {
        return BitmapFactory.decodeByteArray(bArr, i, i2, m13884a(options));
    }

    public static Bitmap m13881a(String str, Options options) {
        Throwable th;
        Bitmap bitmap = null;
        Object obj = 1;
        if (options != null) {
            try {
                if (options.inJustDecodeBounds) {
                    if (m13885a()) {
                        try {
                            options.inTempStorage = f13034a;
                        } catch (Throwable th2) {
                            th = th2;
                            if (obj != null) {
                                f13035b.unlock();
                            }
                            throw th;
                        }
                    }
                    obj = null;
                    bitmap = BitmapFactory.decodeFile(str, options);
                    if (obj != null) {
                        f13035b.unlock();
                    }
                    return bitmap;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = null;
                if (obj != null) {
                    f13035b.unlock();
                }
                throw th;
            }
        }
        FileInputStream fileInputStream;
        try {
            Options a = m13884a(options);
            fileInputStream = new FileInputStream(str);
            try {
                FileDescriptor fd = fileInputStream.getFD();
                if (m13885a()) {
                    try {
                        a.inTempStorage = f13034a;
                    } catch (IOException e) {
                        try {
                            BLog.b("FbBitmapFactory", "Unable to open image file %s", new Object[]{str});
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    BLog.a("FbBitmapFactory", "Unable to close image file %s", new Object[]{str});
                                }
                            }
                            if (obj != null) {
                                f13035b.unlock();
                            }
                            return bitmap;
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    BLog.a("FbBitmapFactory", "Unable to close image file %s", new Object[]{str});
                                }
                            }
                            throw th;
                        }
                    }
                }
                obj = null;
                bitmap = m13879a(fd, null, a);
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    BLog.a("FbBitmapFactory", "Unable to close image file %s", new Object[]{str});
                }
                if (obj != null) {
                    f13035b.unlock();
                }
            } catch (IOException e5) {
                obj = null;
                BLog.b("FbBitmapFactory", "Unable to open image file %s", new Object[]{str});
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (obj != null) {
                    f13035b.unlock();
                }
                return bitmap;
            } catch (Throwable th5) {
                th = th5;
                obj = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            fileInputStream = null;
            obj = null;
            BLog.b("FbBitmapFactory", "Unable to open image file %s", new Object[]{str});
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (obj != null) {
                f13035b.unlock();
            }
            return bitmap;
        } catch (Throwable th6) {
            obj = null;
            th = th6;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return bitmap;
    }

    static Bitmap m13886b(String str, @Nullable Options options) {
        if (options == null) {
            options = new Options();
        }
        if (options != null) {
            options.inPurgeable = false;
        }
        if (!m13885a()) {
            return BitmapFactory.decodeFile(str, options);
        }
        try {
            options.inTempStorage = f13034a;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            return decodeFile;
        } finally {
            f13035b.unlock();
        }
    }

    private static Bitmap m13878a(Resources resources, int i, Options options) {
        Options a = m13884a(options);
        if (!m13885a()) {
            return BitmapFactory.decodeResource(resources, i, a);
        }
        try {
            a.inTempStorage = f13034a;
            Bitmap decodeResource = BitmapFactory.decodeResource(resources, i, a);
            return decodeResource;
        } finally {
            f13035b.unlock();
        }
    }

    public static Bitmap m13877a(Resources resources, int i) {
        return m13878a(resources, i, null);
    }

    public static Bitmap m13880a(InputStream inputStream, Rect rect, Options options) {
        Options a = m13884a(options);
        if (!m13885a()) {
            return BitmapFactory.decodeStream(inputStream, rect, a);
        }
        try {
            a.inTempStorage = f13034a;
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, a);
            return decodeStream;
        } finally {
            f13035b.unlock();
        }
    }

    public static Bitmap m13879a(FileDescriptor fileDescriptor, Rect rect, Options options) {
        Options a = m13884a(options);
        if (!m13885a()) {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, a);
        }
        try {
            a.inTempStorage = f13034a;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, a);
            return decodeFileDescriptor;
        } finally {
            f13035b.unlock();
        }
    }
}

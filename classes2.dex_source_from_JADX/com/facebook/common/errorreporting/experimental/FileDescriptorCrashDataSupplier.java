package com.facebook.common.errorreporting.experimental;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.TransactionTooLargeException;
import com.facebook.acra.util.ProcFileReader;
import com.facebook.common.errorreporting.FbCustomReportDataSupplier;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Method;

/* compiled from: ts_percent_in_viewport */
public class FileDescriptorCrashDataSupplier implements FbCustomReportDataSupplier {
    private final String f2232a = FileDescriptorCrashDataSupplier.class.getSimpleName();

    public final String mo633a(Throwable th) {
        if (!m4376b(th)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Method declaredMethod = Debug.class.getDeclaredMethod("countInstancesOfClass", new Class[]{Class.class});
            try {
                stringBuilder.append("Bitmaps=").append(declaredMethod.invoke(null, new Object[]{Bitmap.class})).append("\n");
                stringBuilder.append("FacewebFragments=").append(declaredMethod.invoke(null, new Object[]{Class.forName("com.facebook.katana.activity.faceweb.FacewebFragment")})).append("\n");
                stringBuilder.append("fd_count=").append(ProcFileReader.getOpenFDCount()).append("\n");
                stringBuilder.append("fd_dump=").append(ProcFileReader.getOpenFileDescriptors()).append("\n");
            } catch (Throwable e) {
                BLog.b(this.f2232a, "exception", e);
            }
            return stringBuilder.toString();
        } catch (NoSuchMethodException e2) {
            return stringBuilder.toString();
        }
    }

    public final String mo632a() {
        return "fd_crash_data";
    }

    private static boolean m4376b(Throwable th) {
        if (th == null || VERSION.SDK_INT < 15) {
            return false;
        }
        while (!(th instanceof TransactionTooLargeException)) {
            th = th.getCause();
            if (th == null) {
                return false;
            }
        }
        return true;
    }
}

package com.facebook.reportaproblem.base.bugreport;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import com.facebook.reportaproblem.base.dialog.ReportAProblemDialogFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: shared_media */
public class BugReportScreenshotHelper {
    private static final Class<?> f4562a = BugReportScreenshotHelper.class;

    public static List<Fragment> m7045a(FragmentManager fragmentManager) {
        try {
            Field declaredField = fragmentManager.getClass().getDeclaredField("mAdded");
            declaredField.setAccessible(true);
            List<Fragment> list = (List) declaredField.get(fragmentManager);
            declaredField.setAccessible(false);
            if (list != null) {
                return list;
            }
        } catch (Throwable e) {
            Log.e(f4562a.getName(), "Could not access fragment list for screenshot.", e);
        } catch (Throwable e2) {
            Log.e(f4562a.getName(), "Could not access fragment list for screenshot.", e2);
        }
        return new ArrayList();
    }

    public static void m7046a(List<Fragment> list, Canvas canvas) {
        int[] iArr = new int[2];
        for (Fragment fragment : list) {
            if ((fragment instanceof DialogFragment) && !(fragment instanceof ReportAProblemDialogFragment)) {
                DialogFragment dialogFragment = (DialogFragment) fragment;
                if (!(dialogFragment.K || dialogFragment.f == null)) {
                    View decorView = dialogFragment.f.getWindow().getDecorView();
                    decorView.getLocationOnScreen(iArr);
                    canvas.translate((float) iArr[0], (float) iArr[1]);
                    decorView.draw(canvas);
                    canvas.translate((float) (-iArr[0]), (float) (-iArr[1]));
                }
            }
            m7046a(m7045a(fragment.s()), canvas);
        }
    }

    public static String m7044a(Bitmap bitmap, File file) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        } finally {
            fileOutputStream.close();
        }
    }
}

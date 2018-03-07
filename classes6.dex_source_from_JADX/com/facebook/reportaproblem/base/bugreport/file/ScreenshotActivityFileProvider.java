package com.facebook.reportaproblem.base.bugreport.file;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.facebook.reportaproblem.base.bugreport.BugReportScreenshotHelper;
import java.io.File;
import java.util.List;

/* compiled from: setTopics */
public class ScreenshotActivityFileProvider implements BugReportActivityFileProvider {
    private Bitmap f4564a;

    public final void m7055a(Activity activity) {
        Activity parent;
        if (activity.getParent() != null) {
            parent = activity.getParent();
        } else {
            parent = activity;
        }
        View decorView = parent.getWindow().getDecorView();
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        decorView.draw(canvas);
        if (parent instanceof FragmentActivity) {
            List a = BugReportScreenshotHelper.m7045a(((FragmentActivity) parent).kO_());
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            canvas.translate((float) (-iArr[0]), (float) (-iArr[1]));
            BugReportScreenshotHelper.m7046a(a, canvas);
            canvas.translate((float) iArr[0], (float) iArr[1]);
        }
        this.f4564a = createBitmap;
    }

    public final BugReportFile m7054a(File file) {
        return new BugReportFile("screenshot.png", BugReportScreenshotHelper.m7044a(this.f4564a, new File(file, "screenshot.png")), "image/png");
    }
}

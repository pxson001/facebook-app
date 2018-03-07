package com.facebook.composer.minutiae.widget;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.facebook.content.SecurePendingIntent;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: task_key_update_timeline_collection_ */
public class RidgeWidgetController {
    public static final int f1918a = 2131567099;
    public static final int f1919b = 2131567104;
    public static final int f1920c = 2131567101;
    public static final int f1921d = 2131567102;
    public static final int f1922e = 2131567103;
    public static final int f1923f = 2131567100;
    public static final int f1924g = 2131567109;
    public static final int f1925h = 2131567110;
    public static final int f1926i = 2131567111;
    public static final int f1927j = 2131567112;
    public static final int f1928k = 2131567113;
    public final AppWidgetManager f1929l;
    public final int[] f1930m;
    public final Context f1931n;
    public RemoteViews f1932o;

    /* compiled from: task_key_update_timeline_collection_ */
    public enum RidgePrompt {
        BLANK(0),
        INITIALIZING(1),
        WHAT_ARE_YOU_DOING(2),
        FAILED(3);
        
        public int index;

        private RidgePrompt(int i) {
            this.index = i;
        }
    }

    /* compiled from: task_key_update_timeline_collection_ */
    public abstract class RidgeViewDelegate<T extends RidgeViewDelegate> {
        final /* synthetic */ RidgeWidgetController f1915b;

        public RidgeViewDelegate(RidgeWidgetController ridgeWidgetController) {
            this.f1915b = ridgeWidgetController;
        }

        public final T m1865a(int i, Intent intent) {
            this.f1915b.f1932o.setOnClickPendingIntent(i, SecurePendingIntent.c(this.f1915b.f1931n, 0, intent, 134217728));
            return this;
        }

        public final T m1866b(int i, Intent intent) {
            this.f1915b.f1932o.setOnClickPendingIntent(i, SecurePendingIntent.a(this.f1915b.f1931n, 0, intent, 134217728));
            return this;
        }

        public void m1867c() {
            this.f1915b.f1929l.updateAppWidget(this.f1915b.f1930m, this.f1915b.f1932o);
            this.f1915b.f1932o = null;
        }
    }

    /* compiled from: task_key_update_timeline_collection_ */
    public class RidgePromptViewDelegate extends RidgeViewDelegate<RidgePromptViewDelegate> {
        final /* synthetic */ RidgeWidgetController f1916a;

        public RidgePromptViewDelegate(RidgeWidgetController ridgeWidgetController) {
            this.f1916a = ridgeWidgetController;
            super(ridgeWidgetController);
        }

        public final RidgePromptViewDelegate m1868a() {
            RidgeWidgetController.m1874a(this.f1916a, RidgeWidgetController.f1920c, false);
            RidgeWidgetController.m1874a(this.f1916a, RidgeWidgetController.f1921d, true);
            return this;
        }

        public final RidgePromptViewDelegate m1871b() {
            RidgeWidgetController.m1874a(this.f1916a, RidgeWidgetController.f1920c, true);
            RidgeWidgetController.m1874a(this.f1916a, RidgeWidgetController.f1921d, false);
            return this;
        }

        public final RidgePromptViewDelegate m1869a(Bitmap bitmap) {
            RidgeWidgetController.m1872a(this.f1916a, RidgeWidgetController.f1922e, bitmap);
            return this;
        }

        @TargetApi(14)
        public final RidgePromptViewDelegate m1870a(@Nonnull RidgePrompt ridgePrompt) {
            this.f1916a.f1932o.setDisplayedChild(RidgeWidgetController.f1919b, ridgePrompt.index);
            return this;
        }
    }

    /* compiled from: task_key_update_timeline_collection_ */
    public class RidgeResultViewDelegate extends RidgeViewDelegate<RidgeResultViewDelegate> {
        public final /* synthetic */ RidgeWidgetController f1917a;

        public RidgeResultViewDelegate(RidgeWidgetController ridgeWidgetController) {
            this.f1917a = ridgeWidgetController;
            super(ridgeWidgetController);
        }
    }

    /* compiled from: task_key_update_timeline_collection_ */
    public enum WidgetView {
        PROMPT(0),
        RESULT(1);
        
        public int index;

        private WidgetView(int i) {
            this.index = i;
        }
    }

    public RidgeWidgetController(int[] iArr, Context context) {
        this.f1929l = AppWidgetManager.getInstance(context);
        this.f1930m = iArr;
        this.f1931n = context;
    }

    public final RidgeWidgetController m1875a() {
        this.f1932o = new RemoteViews(this.f1931n.getPackageName(), 2130906901);
        return this;
    }

    @TargetApi(14)
    public final RidgePromptViewDelegate m1876b() {
        this.f1932o.setDisplayedChild(f1918a, WidgetView.PROMPT.index);
        return new RidgePromptViewDelegate(this);
    }

    public static void m1872a(RidgeWidgetController ridgeWidgetController, @Nullable int i, Bitmap bitmap) {
        if (bitmap != null) {
            ridgeWidgetController.f1932o.setImageViewBitmap(i, bitmap);
        }
        m1874a(ridgeWidgetController, i, bitmap != null);
    }

    public static void m1874a(RidgeWidgetController ridgeWidgetController, int i, boolean z) {
        ridgeWidgetController.f1932o.setViewVisibility(i, z ? 0 : 8);
    }

    public static void m1873a(RidgeWidgetController ridgeWidgetController, @Nullable int i, String str) {
        if (str != null) {
            ridgeWidgetController.f1932o.setTextViewText(i, str);
        }
        m1874a(ridgeWidgetController, i, str != null);
    }
}

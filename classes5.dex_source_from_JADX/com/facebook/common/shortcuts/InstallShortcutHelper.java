package com.facebook.common.shortcuts;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ajax/reqs.php */
public class InstallShortcutHelper {
    private static final CallerContext f11112a = CallerContext.a(InstallShortcutHelper.class, "shortcut");
    private final boolean f11113b;
    private final Context f11114c;
    private final Resources f11115d;
    private final ImagePipeline f11116e;
    private final Executor f11117f;
    private final AnalyticsLogger f11118g;

    /* compiled from: ajax/reqs.php */
    public enum IconStyle {
        DEFAULT,
        ROUNDED,
        CIRCLE
    }

    public static InstallShortcutHelper m19109b(InjectorLike injectorLike) {
        return new InstallShortcutHelper((Context) injectorLike.getInstance(Context.class), ImagePipelineMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    public static InstallShortcutHelper m19106a(InjectorLike injectorLike) {
        return m19109b(injectorLike);
    }

    @Inject
    public InstallShortcutHelper(Context context, ImagePipeline imagePipeline, Executor executor, AnalyticsLogger analyticsLogger, Boolean bool) {
        this.f11114c = context;
        this.f11115d = context.getResources();
        this.f11116e = imagePipeline;
        this.f11117f = executor;
        this.f11118g = analyticsLogger;
        this.f11113b = bool.booleanValue();
    }

    public final void m19112a(Intent intent, String str, @Nullable Bitmap bitmap, @Nullable Drawable drawable, boolean z) {
        Preconditions.checkNotNull(intent, "Intent cannot be null");
        Preconditions.checkNotNull(str, "Caption cannot be null");
        int a = m19110a();
        boolean z2 = bitmap == null || (bitmap.getWidth() == a && bitmap.getHeight() == a);
        Preconditions.checkArgument(z2, "Unexpected icon size. Use getLauncherIconSize() to get the proper size of an icon");
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        if (bitmap != null) {
            if (drawable != null) {
                Canvas canvas = new Canvas(bitmap);
                int i = (int) (((float) a) / 2.75f);
                drawable.setBounds(a - i, a - i, a, a);
                drawable.draw(canvas);
            }
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        }
        intent2.putExtra("duplicate", z);
        this.f11114c.sendOrderedBroadcast(intent2, null);
    }

    public final void m19113a(String str, String str2, @Nullable Uri uri, IconStyle iconStyle) {
        m19107a(str, "com.facebook.katana.IntentUriHandler", str2, uri, iconStyle, m19108b(), false, true);
        this.f11118g.c(new HoneyClientEvent("create_shortcut").b("uri", str));
    }

    public final void m19115b(String str, String str2, @Nullable Uri uri, IconStyle iconStyle) {
        m19107a(str, "com.facebook.katana.IntentUriHandler", str2, uri, iconStyle, m19108b(), true, true);
        this.f11118g.c(new HoneyClientEvent("create_shortcut").b("uri", str));
    }

    public final void m19114a(String str, @Nullable String str2, String str3, @Nullable Bitmap bitmap, IconStyle iconStyle, int i, boolean z, boolean z2, @Nullable Bundle bundle) {
        Preconditions.checkNotNull(str, "URL cannot be null");
        Preconditions.checkNotNull(str3, "Icon name cannot be null");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (str2 != null) {
            intent.setComponent(new ComponentName(this.f11114c, str2));
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setData(Uri.parse(str));
        intent.putExtra("shortcut_open", true);
        intent.addFlags(335544320);
        m19112a(intent, str3, m19105a(bitmap, iconStyle, z2), i != -1 ? this.f11115d.getDrawable(i) : null, z);
    }

    private void m19107a(String str, @Nullable String str2, String str3, @Nullable Uri uri, IconStyle iconStyle, int i, boolean z, boolean z2) {
        Preconditions.checkNotNull(str, "URL cannot be null");
        Preconditions.checkNotNull(str3, "Icon name cannot be null");
        if (uri == null) {
            m19114a(str, str2, str3, null, iconStyle, i, z, z2, null);
            return;
        }
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final IconStyle iconStyle2 = iconStyle;
        final int i2 = i;
        final boolean z3 = z;
        final boolean z4 = z2;
        this.f11116e.c(ImageRequest.a(uri), f11112a).a(new BaseBitmapDataSubscriber(this) {
            final /* synthetic */ InstallShortcutHelper f11111h;

            public final void mo1184a(@Nullable Bitmap bitmap) {
                this.f11111h.m19114a(str4, str5, str6, bitmap, iconStyle2, i2, z3, z4, null);
            }

            public final void m19103f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f11111h.m19114a(str4, str5, str6, null, iconStyle2, i2, z3, z4, null);
            }
        }, this.f11117f);
    }

    public final Bitmap m19111a(Drawable drawable) {
        int a = m19110a();
        Bitmap createBitmap = Bitmap.createBitmap(a, a, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(drawable.getBounds());
        drawable.setBounds(0, 0, a, a);
        drawable.draw(canvas);
        drawable.setBounds(rect);
        return createBitmap;
    }

    private Bitmap m19105a(Bitmap bitmap, IconStyle iconStyle, boolean z) {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(this.f11115d, 2130841706);
        }
        if (bitmap == null) {
            return null;
        }
        int a = m19110a();
        int a2 = z ? m19104a(a) : a;
        Bitmap createBitmap = Bitmap.createBitmap(a, a, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        float max = Math.max(((float) a2) / ((float) bitmap.getWidth()), ((float) a2) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * max);
        int round2 = Math.round(max * ((float) bitmap.getHeight()));
        int round3 = Math.round(((float) (a - round)) / 2.0f);
        int round4 = Math.round(((float) (a - round2)) / 2.0f);
        Rect rect2 = new Rect(round3, round4, round + round3, round2 + round4);
        if (iconStyle == IconStyle.ROUNDED || iconStyle == IconStyle.CIRCLE) {
            if (iconStyle == IconStyle.ROUNDED) {
                max = ((float) a2) * 0.1f;
            } else {
                max = ((float) a2) / 2.0f;
            }
            a = Math.round(((float) (a - a2)) / 2.0f);
            canvas.drawRoundRect(new RectF((float) a, (float) a, (float) (a + a2), (float) (a2 + a)), max, max, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    @TargetApi(11)
    public final int m19110a() {
        if (VERSION.SDK_INT >= 11) {
            ActivityManager activityManager = (ActivityManager) this.f11114c.getSystemService("activity");
            if (activityManager != null) {
                return activityManager.getLauncherLargeIconSize();
            }
        }
        return this.f11115d.getDimensionPixelSize(17104896);
    }

    private static int m19104a(int i) {
        switch (i) {
            case 36:
                return 34;
            case 48:
                return 42;
            case 72:
                return 62;
            case 96:
                return 82;
            default:
                return Math.round(((float) i) * 0.875f);
        }
    }

    private int m19108b() {
        return this.f11113b ? 2130844053 : 2130839574;
    }
}

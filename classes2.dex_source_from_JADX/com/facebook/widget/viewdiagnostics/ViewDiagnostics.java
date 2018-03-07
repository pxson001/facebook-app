package com.facebook.widget.viewdiagnostics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.TriState;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: minimized */
public class ViewDiagnostics<T extends View> extends Drawable {
    public static TriState f13456a = TriState.UNSET;
    private long f13457A = -1;
    private long f13458B = 0;
    public boolean f13459C = false;
    private final ExecutorService f13460b;
    public final AnalyticsLogger f13461c;
    private final BaseAnalyticsConfig f13462d;
    private final FbSharedPreferences f13463e;
    private final Random f13464f;
    private final TextPaint f13465g;
    private final Rect f13466h;
    private final Paint f13467i;
    private final StringBuilder f13468j;
    private final int f13469k;
    private final int f13470l;
    private final int f13471m;
    private final int f13472n;
    public String f13473o;
    public long f13474p = -1;
    public long f13475q = -1;
    public long f13476r = -1;
    public long f13477s = -1;
    public long f13478t = -1;
    public long f13479u = 0;
    public long f13480v = -1;
    public long f13481w = -1;
    private long f13482x = -1;
    private long f13483y = -1;
    private long f13484z = -1;

    @Inject
    public ViewDiagnostics(FbSharedPreferences fbSharedPreferences, ExecutorService executorService, AnalyticsLogger analyticsLogger, BaseAnalyticsConfig baseAnalyticsConfig, Random random, Context context) {
        this.f13463e = fbSharedPreferences;
        this.f13460b = executorService;
        this.f13461c = analyticsLogger;
        this.f13462d = baseAnalyticsConfig;
        this.f13464f = random;
        this.f13469k = SizeUtil.m19191a(context, 12.0f);
        this.f13470l = SizeUtil.m19191a(context, 2.0f);
        this.f13471m = SizeUtil.m19191a(context, 2.0f);
        this.f13472n = SizeUtil.m19191a(context, 8.0f);
        int a = SizeUtil.m19191a(context, 10.0f);
        this.f13465g = new TextPaint();
        this.f13465g.setColor(-65536);
        this.f13465g.setAntiAlias(true);
        this.f13465g.setTextSize((float) a);
        this.f13466h = new Rect();
        this.f13467i = new Paint();
        this.f13467i.setColor(-256);
        this.f13468j = new StringBuilder(65);
    }

    public final void m19827c(long j) {
        this.f13476r = j;
    }

    public final void m19829d(long j) {
        this.f13477s = j;
    }

    public final void m19831e(long j) {
        this.f13478t = j;
    }

    public final void m19833f(long j) {
        this.f13481w = j;
        this.f13479u = 0;
        if (this.f13480v != -1) {
            this.f13479u += this.f13480v;
        }
        if (this.f13481w != -1) {
            this.f13479u += this.f13481w;
        }
    }

    public final void m19824a(T t) {
        if (t == null) {
            this.f13473o = null;
        } else if (this.f13473o == null) {
            this.f13473o = t.getClass().getSimpleName();
        }
    }

    private boolean m19820g() {
        return this.f13476r != -1;
    }

    public final void m19823a() {
        this.f13474p = -1;
        this.f13475q = -1;
        this.f13476r = -1;
        this.f13477s = -1;
        this.f13478t = -1;
        this.f13479u = 0;
        this.f13480v = -1;
        this.f13481w = -1;
        this.f13459C = false;
    }

    private String m19821i() {
        m19822j();
        this.f13468j.setLength(0);
        return this.f13468j.append(this.f13473o).append(" prepare: ").append(this.f13482x).append(" bind: ").append(this.f13483y).append(" measure: ").append(this.f13484z).append(" layout: ").append(this.f13457A).append(" draw: ").append(this.f13458B).toString();
    }

    private void m19822j() {
        if (m19820g()) {
            this.f13482x = Math.max(this.f13474p, this.f13475q);
            this.f13483y = this.f13476r;
            this.f13484z = this.f13478t;
            this.f13457A = this.f13477s;
            this.f13458B = this.f13479u;
        }
    }

    public void draw(Canvas canvas) {
        int i = -65536;
        if (m19826b()) {
            Object i2 = m19821i();
            long j = (((this.f13482x + this.f13483y) + this.f13484z) + this.f13457A) + this.f13458B;
            this.f13465g.setColor(j > 20 ? -256 : -65536);
            Paint paint = this.f13467i;
            if (j <= 20) {
                i = -256;
            }
            paint.setColor(i);
            this.f13466h.set(0, 0, ((int) Layout.getDesiredWidth(i2, this.f13465g)) + (this.f13470l * 2), this.f13469k);
            canvas.drawRect(this.f13466h, this.f13467i);
            canvas.drawText(i2, (float) this.f13471m, (float) this.f13472n, this.f13465g);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }

    public final boolean m19826b() {
        return m19819a(this.f13463e);
    }

    public static boolean m19819a(FbSharedPreferences fbSharedPreferences) {
        if (f13456a.isSet()) {
            if (f13456a == TriState.YES) {
                return true;
            }
            return false;
        } else if (fbSharedPreferences == null || !fbSharedPreferences.mo284a()) {
            return false;
        } else {
            TriState b = fbSharedPreferences.mo287b(ViewDiagnosticsPreferenceKeys.f13486b);
            f13456a = b;
            if (b.equals(TriState.UNSET)) {
                f13456a = TriState.NO;
            }
            if (f13456a != TriState.YES) {
                return false;
            }
            return true;
        }
    }

    public final boolean m19828c() {
        if (this.f13462d.m3563a("view_scroll_perf")) {
            this.f13459C = this.f13464f.nextInt(100) == 0;
        }
        return this.f13459C;
    }

    public final void m19825b(boolean z) {
        this.f13459C = z;
    }

    public final boolean m19830d() {
        return this.f13459C;
    }

    public final void m19832f() {
        if (m19820g() && this.f13459C) {
            Executor executor = this.f13460b;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("view_scroll_perf");
            honeyClientEvent.m5084a("prepare_time", this.f13474p);
            honeyClientEvent.m5084a("prepare_async_time", this.f13475q);
            honeyClientEvent.m5084a("bind_time", this.f13476r);
            honeyClientEvent.m5084a("measure_time", this.f13478t);
            honeyClientEvent.m5084a("layout_time", this.f13477s);
            honeyClientEvent.m5084a("draw_time", this.f13479u);
            honeyClientEvent.m5090b("class_name", this.f13473o);
            ExecutorDetour.a(executor, new ReportEventRunnable(this, honeyClientEvent), -2049410417);
        }
    }
}

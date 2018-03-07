package com.facebook.fig.common;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.fbui.widget.text.ResourceTextLayoutHelper;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: media-upload-video-chunk-start */
public class FigTextHelper {
    public TextLayoutBuilder f10484a = new TextLayoutBuilder();
    public Layout f10485b = null;
    public int f10486c = 0;
    public int f10487d;
    public int f10488e;

    public final CharSequence m16652a() {
        return this.f10484a.a();
    }

    public final void m16656a(CharSequence charSequence) {
        this.f10484a.a(charSequence);
    }

    public final void m16659b(int i) {
        boolean z = true;
        TextLayoutBuilder textLayoutBuilder = this.f10484a;
        if (i != 1) {
            z = false;
        }
        textLayoutBuilder.b(z);
        this.f10484a.e(i);
        this.f10484a.a(TruncateAt.END);
    }

    public final void m16653a(Context context, int i) {
        ResourceTextLayoutHelper.b(this.f10484a, context, i);
    }

    public final int m16658b() {
        return LayoutMeasureUtil.a(this.f10485b);
    }

    public final int m16660c() {
        return this.f10486c != 8 ? LayoutMeasureUtil.b(this.f10485b) : 0;
    }

    public final void m16661c(int i) {
        if (this.f10486c != 8) {
            this.f10484a.a(MeasureSpec.getSize(i));
            this.f10485b = this.f10484a.d();
            return;
        }
        this.f10485b = null;
    }

    public final void m16657a(boolean z, int i, int i2, int i3) {
        if (this.f10486c != 8) {
            if (!z) {
                i = i3 - m16658b();
            }
            this.f10487d = i;
            this.f10488e = i2;
        }
    }

    public final void m16654a(Canvas canvas) {
        if (this.f10486c == 0 && this.f10485b != null) {
            canvas.translate((float) this.f10487d, (float) this.f10488e);
            this.f10485b.draw(canvas);
            canvas.translate((float) (-this.f10487d), (float) (-this.f10488e));
        }
    }

    public final boolean m16662d() {
        return !TextUtils.isEmpty(m16652a());
    }

    public final void m16655a(AccessibilityEvent accessibilityEvent) {
        if (m16662d()) {
            accessibilityEvent.getText().add(m16652a());
        }
    }
}

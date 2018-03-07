package com.facebook.fbui.feed.attachment;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.fbui.widget.text.ResourceTextLayoutHelper;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: article_hide_suggestion */
public class AttachmentView$TextHelper {
    final /* synthetic */ AttachmentView f19112a;
    public CharSequence f19113b;
    private TextLayoutBuilder f19114c = new TextLayoutBuilder();
    private Layout f19115d;
    private boolean f19116e;
    private int f19117f;
    private int f19118g;

    public AttachmentView$TextHelper(AttachmentView attachmentView, Context context, int i) {
        this.f19112a = attachmentView;
        ResourceTextLayoutHelper.a(this.f19114c, context, i);
        this.f19114c.e = true;
        this.f19114c.f = true;
        m22662a();
    }

    public final void m22662a() {
        this.f19113b = null;
        this.f19114c.a(null);
        this.f19115d = null;
        this.f19116e = false;
        this.f19117f = 0;
        this.f19118g = 0;
    }

    public final void m22668a(CharSequence charSequence) {
        this.f19113b = charSequence;
        this.f19116e = true;
    }

    public final int m22669c() {
        return LayoutMeasureUtil.a(this.f19115d);
    }

    public final int m22670d() {
        if (!this.f19116e || this.f19115d == null) {
            return 0;
        }
        return LayoutMeasureUtil.b(this.f19115d);
    }

    public final void m22663a(int i) {
        if (!this.f19116e || TextUtils.isEmpty(this.f19113b)) {
            this.f19115d = null;
            return;
        }
        int i2 = this.f19114c.a.k;
        this.f19114c.a(MeasureSpec.getSize(i));
        this.f19114c.a(this.f19113b);
        this.f19114c.b(false);
        this.f19114c.e(Integer.MAX_VALUE);
        this.f19115d = this.f19114c.d();
        this.f19114c.b(i2 == 1);
        this.f19114c.e(i2);
        if (this.f19115d.getLineCount() > i2) {
            CharSequence subSequence = this.f19113b.subSequence(0, this.f19115d.getLineEnd(i2 - 1));
            if (subSequence.length() > 1 && subSequence.charAt(subSequence.length() - 1) != '\n') {
                subSequence = m22661b(subSequence);
            }
            this.f19114c.a(subSequence);
            this.f19115d = this.f19114c.d();
            while (this.f19115d.getLineCount() > i2) {
                int lastIndexOf = subSequence.toString().lastIndexOf(32);
                if (lastIndexOf != -1) {
                    subSequence = m22661b(subSequence.subSequence(0, lastIndexOf));
                    this.f19114c.a(subSequence);
                    this.f19115d = this.f19114c.d();
                } else {
                    return;
                }
            }
        }
    }

    private static CharSequence m22661b(CharSequence charSequence) {
        while (!TextUtils.isEmpty(charSequence) && Character.isWhitespace(charSequence.charAt(charSequence.length() - 1))) {
            charSequence = charSequence.subSequence(0, charSequence.length() - 1);
        }
        return TextUtils.concat(new CharSequence[]{charSequence, "…"});
    }

    public final void m22664a(int i, int i2, int i3) {
        if (!this.f19112a.c()) {
            i = i3 - m22669c();
        }
        this.f19117f = i;
        this.f19118g = i2;
    }

    public final void m22665a(Canvas canvas) {
        if (this.f19116e && this.f19115d != null) {
            canvas.translate((float) this.f19117f, (float) this.f19118g);
            this.f19115d.draw(canvas);
            canvas.translate((float) (-this.f19117f), (float) (-this.f19118g));
        }
    }

    public final boolean m22671e() {
        return this.f19116e && !TextUtils.isEmpty(this.f19113b);
    }

    public final void m22666a(AccessibilityEvent accessibilityEvent) {
        CharSequence a = this.f19114c.a();
        if (!TextUtils.isEmpty(a)) {
            accessibilityEvent.getText().add(a);
        }
    }

    public final void m22667a(FbTextLayoutCacheWarmer fbTextLayoutCacheWarmer) {
        this.f19114c.d = fbTextLayoutCacheWarmer;
    }
}

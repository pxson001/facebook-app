package com.facebook.fbui.widget.contentview;

import android.graphics.Canvas;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.fbui.widget.text.ResourceTextLayoutHelper;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: XGROUP_ITEMS_FOR_SALE_NOTIFICATION */
class ContentView$TextHelper {
    public View f12232a;
    public TextLayoutBuilder f12233b;
    public Layout f12234c;
    public int f12235d;
    public int f12236e;
    public int f12237f;
    final /* synthetic */ ContentView f12238g;

    public ContentView$TextHelper(ContentView contentView) {
        this.f12238g = contentView;
        this.f12233b = new TextLayoutBuilder();
        this.f12234c = null;
        this.f12235d = 0;
    }

    public final ContentView$TextType m20251a() {
        if (this.f12232a != null) {
            return ContentView$TextType.VIEW;
        }
        if (this.f12233b != null) {
            return ContentView$TextType.LAYOUT;
        }
        return ContentView$TextType.NONE;
    }

    public final CharSequence m20258b() {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a instanceof TextView) {
                    return ((TextView) this.f12232a).getText();
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return this.f12233b.a();
        }
        return null;
    }

    public final void m20257a(CharSequence charSequence) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a instanceof TextView) {
                    ((TextView) this.f12232a).setText(charSequence);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f12233b.a(charSequence);
                return;
            default:
                return;
        }
    }

    public final void m20252a(int i) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a instanceof TextView) {
                    ((TextView) this.f12232a).setGravity(i);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f12233b.a(i == 3 ? TextDirectionHeuristicsCompat.a : TextDirectionHeuristicsCompat.c);
                return;
            default:
                return;
        }
    }

    public final void m20259b(int i) {
        this.f12235d = i;
        if (m20251a() == ContentView$TextType.VIEW) {
            this.f12232a.setVisibility(i);
        }
    }

    public final void m20261c(int i) {
        boolean z = true;
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a instanceof TextView) {
                    TextView textView = (TextView) this.f12232a;
                    if (i != 1) {
                        z = false;
                    }
                    textView.setSingleLine(z);
                    textView.setMaxLines(i);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                TextLayoutBuilder textLayoutBuilder = this.f12233b;
                if (i != 1) {
                    z = false;
                }
                textLayoutBuilder.b(z);
                this.f12233b.e(i);
                return;
            default:
                return;
        }
    }

    public final void m20263d(int i) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a instanceof TextView) {
                    ((TextView) this.f12232a).setTextAppearance(this.f12232a.getContext(), i);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                ResourceTextLayoutHelper.m4264b(this.f12233b, this.f12238g.getContext(), i);
                return;
            default:
                return;
        }
    }

    public final int m20260c() {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                return this.f12232a.getMeasuredWidth();
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return LayoutMeasureUtil.a(this.f12234c);
            default:
                return 0;
        }
    }

    public final int m20262d() {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a.getVisibility() != 8) {
                    return this.f12232a.getMeasuredHeight();
                }
                return 0;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return this.f12235d != 8 ? LayoutMeasureUtil.b(this.f12234c) : 0;
            default:
                return 0;
        }
    }

    public final int m20264e() {
        if (m20251a() == ContentView$TextType.VIEW) {
            return ((ContentView$LayoutParams) this.f12232a.getLayoutParams()).topMargin;
        }
        return 0;
    }

    public final int m20265f() {
        if (m20251a() != ContentView$TextType.VIEW) {
            return 0;
        }
        ContentView$LayoutParams contentView$LayoutParams = (ContentView$LayoutParams) this.f12232a.getLayoutParams();
        return contentView$LayoutParams.bottomMargin + contentView$LayoutParams.topMargin;
    }

    public final void m20253a(int i, int i2) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a.getVisibility() != 8) {
                    ContentView$LayoutParams contentView$LayoutParams = (ContentView$LayoutParams) this.f12232a.getLayoutParams();
                    ContentView.a(this.f12238g, this.f12232a, i, contentView$LayoutParams.leftMargin + contentView$LayoutParams.rightMargin, i2, contentView$LayoutParams.topMargin + contentView$LayoutParams.bottomMargin);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (this.f12235d != 8) {
                    this.f12233b.a(MeasureSpec.getSize(i));
                    this.f12234c = this.f12233b.d();
                    return;
                }
                this.f12234c = null;
                return;
            default:
                return;
        }
    }

    public final void m20254a(int i, int i2, int i3) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if (this.f12232a.getVisibility() != 8) {
                    m20250a(this.f12232a, i, i2, i3);
                    return;
                }
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (this.f12235d != 8) {
                    if (!ContentView.a(this.f12238g)) {
                        i = i3 - m20260c();
                    }
                    this.f12236e = i;
                    this.f12237f = i2;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m20250a(View view, int i, int i2, int i3) {
        boolean b = ContentView.b(this.f12238g);
        ContentView$LayoutParams contentView$LayoutParams = (ContentView$LayoutParams) view.getLayoutParams();
        int i4 = (contentView$LayoutParams.d < 0 ? 8388611 : contentView$LayoutParams.d) & 7;
        int a = MarginLayoutParamsCompat.a(contentView$LayoutParams);
        int b2 = MarginLayoutParamsCompat.b(contentView$LayoutParams);
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (b) {
            if (i4 == 5) {
                b2 = (i3 - b2) - measuredWidth;
            } else if (i4 == 1) {
                b2 = ((((((i3 - i) - a) - measuredWidth) - b2) / 2) + i) + a;
            } else {
                b2 = i + a;
            }
        } else if (i4 == 5) {
            b2 += i;
        } else if (i4 == 1) {
            b2 += (((((i3 - i) - a) - measuredWidth) - b2) / 2) + i;
        } else {
            b2 = (i3 - a) - measuredWidth;
        }
        view.layout(b2, i2, b2 + measuredWidth, i2 + measuredHeight);
    }

    public final void m20255a(Canvas canvas) {
        if (m20251a() == ContentView$TextType.LAYOUT && this.f12235d == 0 && this.f12234c != null) {
            canvas.translate((float) this.f12236e, (float) this.f12237f);
            this.f12234c.draw(canvas);
            canvas.translate((float) (-this.f12236e), (float) (-this.f12237f));
        }
    }

    public final boolean m20266g() {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                if ((this.f12232a instanceof TextView) && TextUtils.isEmpty(m20258b())) {
                    return false;
                }
                return true;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return !TextUtils.isEmpty(m20258b());
            default:
                return false;
        }
    }

    public final void m20256a(AccessibilityEvent accessibilityEvent) {
        switch (ContentView$1.f12230b[m20251a().ordinal()]) {
            case 1:
                this.f12232a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                CharSequence a = this.f12233b.a();
                if (!TextUtils.isEmpty(a)) {
                    accessibilityEvent.getText().add(a);
                    return;
                }
                return;
            default:
                return;
        }
    }
}

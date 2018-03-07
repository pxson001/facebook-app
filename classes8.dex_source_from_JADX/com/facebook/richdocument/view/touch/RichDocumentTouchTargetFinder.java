package com.facebook.richdocument.view.touch;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.tinyclicks.DefaultTouchTargetFinder;
import com.facebook.fbui.tinyclicks.TouchTarget;
import com.facebook.inject.InjectorLike;
import com.google.common.base.MoreObjects;
import javax.inject.Inject;

/* compiled from: pageTopicsByCount */
public class RichDocumentTouchTargetFinder extends DefaultTouchTargetFinder {
    private TouchTarget f6945f = null;

    private static RichDocumentTouchTargetFinder m7192c(InjectorLike injectorLike) {
        return new RichDocumentTouchTargetFinder((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public RichDocumentTouchTargetFinder(Context context) {
        super(context);
    }

    public final TouchTarget m7194a(ViewGroup viewGroup, int i, int i2) {
        TouchTarget touchTarget = null;
        if (viewGroup != null) {
            m7193c();
            this.a = i;
            this.b = i2;
            viewGroup.getLocationInWindow(this.c);
            if (a(viewGroup, true)) {
                m7193c();
            } else {
                touchTarget = m7191a();
                if (touchTarget != null) {
                    touchTarget.b = this.e;
                }
                m7193c();
            }
        }
        return touchTarget;
    }

    private TouchTarget m7191a() {
        TouchTarget touchTarget;
        int size = this.d.size();
        if (size == 1) {
            touchTarget = (TouchTarget) this.d.get(0);
        } else if (size > 1) {
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            for (TouchTarget a : this.d) {
                int a2 = m7190a(a);
                int max = Math.max(i2, a2);
                i = Math.min(i, a2);
                i2 = max;
            }
            if (i == i2) {
                i2 = -1;
            }
            size = i2;
            if (size != -1) {
                for (i2 = this.d.size() - 1; i2 >= 0; i2--) {
                    if (m7190a((TouchTarget) this.d.get(i2)) != size) {
                        this.d.remove(i2);
                    }
                }
            }
            if (this.d.size() == 1) {
                touchTarget = (TouchTarget) this.d.get(0);
            } else {
                int i3 = Integer.MAX_VALUE;
                TouchTarget touchTarget2 = null;
                for (TouchTarget touchTarget3 : this.d) {
                    if (touchTarget3 == this.f6945f) {
                        break;
                    }
                    TouchTarget touchTarget4;
                    int a3 = touchTarget3.a(this.a, this.b);
                    if (a3 < i3) {
                        int i4 = a3;
                        touchTarget4 = touchTarget3;
                        size = i4;
                    } else {
                        size = i3;
                        touchTarget4 = touchTarget2;
                    }
                    i3 = size;
                    touchTarget2 = touchTarget4;
                }
                touchTarget3 = touchTarget2;
            }
        } else {
            touchTarget3 = null;
        }
        if (touchTarget3 == this.f6945f) {
            return null;
        }
        return touchTarget3;
    }

    public static int m7190a(TouchTarget touchTarget) {
        return ((Integer) MoreObjects.firstNonNull((Integer) touchTarget.a.getTag(RichDocumentTouch.f6944c), Integer.valueOf(1))).intValue();
    }

    private void m7193c() {
        this.d.clear();
        this.e = null;
        this.f6945f = null;
    }

    protected final boolean m7195a(View view) {
        Rect b = b(view);
        if (b.contains(this.a, this.b)) {
            TouchTarget touchTarget = new TouchTarget(view, new Rect(b), new Rect(b));
            if (this.f6945f == null) {
                this.f6945f = touchTarget;
            }
            this.d.add(touchTarget);
        } else {
            Rect rect;
            int intValue = ((Integer) MoreObjects.firstNonNull((Integer) view.getTag(RichDocumentTouch.f6942a), Integer.valueOf(0))).intValue();
            int intValue2 = ((Integer) MoreObjects.firstNonNull((Integer) view.getTag(RichDocumentTouch.f6943b), Integer.valueOf(0))).intValue();
            if (intValue == 0 && intValue2 == 0) {
                rect = null;
            } else {
                rect = new Rect(b.left - intValue, b.top - intValue2, intValue + b.right, intValue2 + b.bottom);
            }
            Rect rect2 = rect;
            if (rect2 != null && rect2.contains(this.a, this.b)) {
                this.d.add(new TouchTarget(view, new Rect(b), rect2));
            }
        }
        return false;
    }
}

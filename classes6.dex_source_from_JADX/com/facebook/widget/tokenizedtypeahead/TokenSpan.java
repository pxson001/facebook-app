package com.facebook.widget.tokenizedtypeahead;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import com.facebook.widget.tokenizedtypeahead.model.Token;

/* compiled from: com.facebook.reportaproblem.base.dialog.ParamBundle */
public abstract class TokenSpan<T extends Token> extends ReplacementSpan {
    protected static final int[] f19983a = new int[0];
    protected static final int[] f19984b = new int[]{-16842910};
    protected static final int[] f19985c = new int[]{16842913};
    protected static final int[] f19986d = new int[]{16842919};
    protected final Rect f19987e = new Rect();
    public final T f19988f;
    protected final Resources f19989g;
    protected final int f19990h;
    protected final boolean f19991i;

    public TokenSpan(T t, Resources resources, int i, boolean z) {
        this.f19988f = t;
        this.f19989g = resources;
        this.f19990h = i;
        this.f19991i = z;
    }

    public void mo1516a(Context context) {
    }

    public void mo1520a() {
    }

    public final void m28687a(Rect rect) {
        rect.set(this.f19987e);
    }

    public void mo1521b(Rect rect) {
        rect.setEmpty();
    }

    protected final int[] m28689c() {
        if (!this.f19988f.mo1195a()) {
            return f19984b;
        }
        if (this.f19988f.f15077c) {
            return f19985c;
        }
        if (this.f19988f.f15078d) {
            return f19986d;
        }
        return f19983a;
    }
}

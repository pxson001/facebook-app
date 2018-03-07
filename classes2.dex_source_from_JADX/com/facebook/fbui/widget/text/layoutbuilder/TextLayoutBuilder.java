package com.facebook.fbui.widget.text.layoutbuilder;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.util.LruCache;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.Log;
import com.facebook.fbui.textcachewarmer.FbTextLayoutCacheWarmer;
import com.facebook.fbui.widget.text.staticlayouthelper.StaticLayoutHelper;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: host_name */
public class TextLayoutBuilder {
    private static final LruCache<Integer, Layout> f20861c = new LruCache(100);
    public final Params f20862a = new Params();
    protected Layout f20863b = null;
    public FbTextLayoutCacheWarmer f20864d;
    public boolean f20865e = true;
    public boolean f20866f = false;

    /* compiled from: host_name */
    public class Params {
        public TextPaint f20867a = new ComparableTextPaint(1);
        public int f20868b;
        public int f20869c;
        public CharSequence f20870d;
        public ColorStateList f20871e;
        public float f20872f = 1.0f;
        public float f20873g = 0.0f;
        public boolean f20874h = true;
        public TruncateAt f20875i = null;
        public boolean f20876j = false;
        public int f20877k = Integer.MAX_VALUE;
        public Alignment f20878l = Alignment.ALIGN_NORMAL;
        public TextDirectionHeuristicCompat f20879m = TextDirectionHeuristicsCompat.f7478c;
        public boolean f20880n = false;

        protected Params() {
        }

        final void m28611a() {
            if (this.f20880n) {
                this.f20867a = new ComparableTextPaint(this.f20867a);
                this.f20880n = false;
            }
        }

        public int hashCode() {
            return HashCodeBuilder.m29739a(HashCodeBuilder.m29739a(HashCodeBuilder.m29739a(HashCodeBuilder.m29738a(HashCodeBuilder.m29740a(HashCodeBuilder.m29739a(HashCodeBuilder.m29740a(HashCodeBuilder.m29737a(HashCodeBuilder.m29737a(HashCodeBuilder.m29738a(HashCodeBuilder.m29738a(HashCodeBuilder.m29739a(1, this.f20867a), this.f20868b), this.f20869c), this.f20872f), this.f20873g), this.f20874h), this.f20875i), this.f20876j), this.f20877k), this.f20878l), this.f20879m), this.f20870d);
        }
    }

    /* compiled from: host_name */
    class ComparableTextPaint extends TextPaint {
        private float f20881a;
        private float f20882b;
        private float f20883c;
        private int f20884d;

        public ComparableTextPaint(int i) {
            super(i);
        }

        public ComparableTextPaint(Paint paint) {
            super(paint);
        }

        public void setShadowLayer(float f, float f2, float f3, int i) {
            this.f20883c = f;
            this.f20881a = f2;
            this.f20882b = f3;
            this.f20884d = i;
            super.setShadowLayer(f, f2, f3, i);
        }

        public int hashCode() {
            return HashCodeBuilder.m29737a(HashCodeBuilder.m29737a(HashCodeBuilder.m29737a(HashCodeBuilder.m29739a(HashCodeBuilder.m29737a(HashCodeBuilder.m29738a(1, getColor()), getTextSize()), getTypeface()), this.f20881a), this.f20882b), this.f20883c);
        }
    }

    public final TextLayoutBuilder m28592a(int i) {
        return m28593a(i, i <= 0 ? 0 : 1);
    }

    public final TextLayoutBuilder m28593a(int i, int i2) {
        if (!(this.f20862a.f20868b == i && this.f20862a.f20869c == i2)) {
            this.f20862a.f20868b = i;
            this.f20862a.f20869c = i2;
            this.f20863b = null;
        }
        return this;
    }

    public final CharSequence m28601a() {
        return this.f20862a.f20870d;
    }

    public final float m28602b() {
        return this.f20862a.f20867a.getTextSize();
    }

    public final TextLayoutBuilder m28599a(CharSequence charSequence) {
        if (charSequence != this.f20862a.f20870d && (charSequence == null || this.f20862a.f20870d == null || !charSequence.equals(this.f20862a.f20870d))) {
            this.f20862a.f20870d = charSequence;
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28604b(int i) {
        if (this.f20862a.f20867a.getTextSize() != ((float) i)) {
            this.f20862a.m28611a();
            this.f20862a.f20867a.setTextSize((float) i);
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28606c(int i) {
        this.f20862a.m28611a();
        this.f20862a.f20871e = null;
        this.f20862a.f20867a.setColor(i);
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28594a(ColorStateList colorStateList) {
        this.f20862a.m28611a();
        this.f20862a.f20871e = colorStateList;
        this.f20862a.f20867a.setColor(this.f20862a.f20871e != null ? this.f20862a.f20871e.getDefaultColor() : -16777216);
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28590a(float f) {
        this.f20862a.f20873g = f;
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28603b(float f) {
        this.f20862a.f20872f = f;
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28600a(boolean z) {
        this.f20862a.f20874h = z;
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28597a(Alignment alignment) {
        this.f20862a.f20878l = alignment;
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28596a(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        if (this.f20862a.f20879m != textDirectionHeuristicCompat) {
            this.f20862a.f20879m = textDirectionHeuristicCompat;
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28591a(float f, float f2, float f3, int i) {
        this.f20862a.m28611a();
        this.f20862a.f20867a.setShadowLayer(f, f2, f3, i);
        this.f20863b = null;
        return this;
    }

    public final TextLayoutBuilder m28609d(int i) {
        return m28595a(Typeface.defaultFromStyle(i));
    }

    public final TextLayoutBuilder m28595a(Typeface typeface) {
        if (this.f20862a.f20867a.getTypeface() != typeface) {
            this.f20862a.m28611a();
            this.f20862a.f20867a.setTypeface(typeface);
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28598a(TruncateAt truncateAt) {
        if (this.f20862a.f20875i != truncateAt) {
            this.f20862a.f20875i = truncateAt;
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28605b(boolean z) {
        if (this.f20862a.f20876j != z) {
            this.f20862a.f20876j = z;
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28610e(int i) {
        if (this.f20862a.f20877k != i) {
            this.f20862a.f20877k = i;
            this.f20863b = null;
        }
        return this;
    }

    public final TextLayoutBuilder m28607c(boolean z) {
        this.f20865e = z;
        return this;
    }

    public final Layout m28608d() {
        if (this.f20865e && this.f20863b != null) {
            return this.f20863b;
        }
        if (TextUtils.isEmpty(this.f20862a.f20870d)) {
            return null;
        }
        Layout layout;
        int i;
        int ceil;
        int i2 = -1;
        Object obj;
        if (this.f20865e && (this.f20862a.f20870d instanceof Spannable)) {
            obj = ((ClickableSpan[]) ((Spannable) this.f20862a.f20870d).getSpans(0, this.f20862a.f20870d.length() + -1, ClickableSpan.class)).length > 0 ? 1 : null;
        } else {
            obj = null;
        }
        if (this.f20865e && r18 == null) {
            i2 = this.f20862a.hashCode();
            layout = (Layout) f20861c.m4432a(Integer.valueOf(i2));
            if (layout != null) {
                return layout;
            }
        }
        int i3 = i2;
        Metrics metrics = null;
        if (this.f20862a.f20876j) {
            i = 1;
        } else {
            i = this.f20862a.f20877k;
        }
        if (i == 1) {
            metrics = BoringLayout.isBoring(this.f20862a.f20870d, this.f20862a.f20867a);
        }
        switch (this.f20862a.f20869c) {
            case 0:
                ceil = (int) Math.ceil((double) Layout.getDesiredWidth(this.f20862a.f20870d, this.f20862a.f20867a));
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                ceil = this.f20862a.f20868b;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                ceil = Math.min((int) Math.ceil((double) Layout.getDesiredWidth(this.f20862a.f20870d, this.f20862a.f20867a)), this.f20862a.f20868b);
                break;
            default:
                throw new IllegalStateException("Unexpected measure mode " + this.f20862a.f20869c);
        }
        if (metrics != null) {
            layout = BoringLayout.make(this.f20862a.f20870d, this.f20862a.f20867a, ceil, this.f20862a.f20878l, this.f20862a.f20872f, this.f20862a.f20873g, metrics, this.f20862a.f20874h, this.f20862a.f20875i, ceil);
        } else {
            while (true) {
                try {
                    layout = StaticLayoutHelper.m29632a(this.f20862a.f20870d, 0, this.f20862a.f20870d.length(), this.f20862a.f20867a, ceil, this.f20862a.f20878l, this.f20862a.f20872f, this.f20862a.f20873g, this.f20862a.f20874h, this.f20862a.f20875i, ceil, i, this.f20862a.f20879m);
                    break;
                } catch (Throwable e) {
                    if (this.f20862a.f20870d instanceof String) {
                        throw e;
                    }
                    Log.e("TextLayoutBuilder", "Hit bug #35412, retrying with Spannables removed", e);
                    this.f20862a.f20870d = this.f20862a.f20870d.toString();
                }
            }
        }
        if (this.f20865e && r18 == null) {
            this.f20863b = layout;
            f20861c.m4433a(Integer.valueOf(i3), (Object) layout);
        }
        this.f20862a.f20880n = true;
        if (!this.f20866f || this.f20864d == null) {
            return layout;
        }
        this.f20864d.m28445a(layout);
        return layout;
    }
}

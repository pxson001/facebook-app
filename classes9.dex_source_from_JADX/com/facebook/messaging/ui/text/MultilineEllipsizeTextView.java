package com.facebook.messaging.ui.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.typeface.TypefaceUtil;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/* compiled from: chat_heads_interstitial_tag */
public class MultilineEllipsizeTextView extends View {
    private static final Class<?> f18273a = MultilineEllipsizeTextView.class;
    private int f18274b;
    private float f18275c;
    private Typeface f18276d;
    private int f18277e;
    private int f18278f;
    private int f18279g;
    private int f18280h;
    private int f18281i;
    private boolean f18282j;
    private float f18283k;
    private float f18284l;
    private float f18285m;
    private int f18286n;
    private CharSequence f18287o;
    private TextPaint f18288p;
    private LayoutResult f18289q;
    private int f18290r;
    private LayoutResult f18291s;

    /* compiled from: chat_heads_interstitial_tag */
    class LayoutResult {
        final Layout f18269a;
        final int f18270b;

        public LayoutResult(Layout layout, int i) {
            this.f18269a = layout;
            this.f18270b = i;
        }
    }

    /* compiled from: chat_heads_interstitial_tag */
    class LineResult {
        final List<CharSequence> f18271a;
        final int f18272b;

        public LineResult(List<CharSequence> list, int i) {
            this.f18271a = list;
            this.f18272b = i;
        }
    }

    public MultilineEllipsizeTextView(Context context) {
        this(context, null);
    }

    public MultilineEllipsizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultilineEllipsizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18290r = -1;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MultilineEllipsizeTextView, i, 0);
        this.f18274b = obtainStyledAttributes.getColor(0, Color.rgb(0, 0, 0));
        this.f18275c = (float) obtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.f18278f = obtainStyledAttributes.getInteger(2, 1);
        this.f18279g = obtainStyledAttributes.getInteger(1, 2);
        this.f18280h = obtainStyledAttributes.getDimensionPixelSize(6, Integer.MAX_VALUE);
        this.f18281i = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.f18282j = obtainStyledAttributes.getBoolean(8, false);
        this.f18283k = obtainStyledAttributes.getFloat(9, 0.0f);
        this.f18284l = obtainStyledAttributes.getFloat(10, 0.0f);
        this.f18285m = obtainStyledAttributes.getFloat(11, 0.0f);
        this.f18286n = obtainStyledAttributes.getInt(12, 0);
        m18242a(obtainStyledAttributes.getInt(3, -1), obtainStyledAttributes.getInteger(4, 0));
        obtainStyledAttributes.recycle();
        if (this.f18275c == -1.0f) {
            this.f18275c = (float) SizeUtil.a(context.getResources(), 2131427402);
        }
    }

    public int getTextColor() {
        return this.f18274b;
    }

    public void setTextColor(int i) {
        this.f18274b = i;
        if (this.f18288p != null) {
            this.f18288p.setColor(this.f18274b);
        }
        invalidate();
    }

    public float getTextSize() {
        return this.f18275c;
    }

    public void setTextSize(float f) {
        this.f18275c = f;
        this.f18288p = null;
    }

    public int getMaxLines() {
        return this.f18279g;
    }

    public void setMaxLines(int i) {
        this.f18279g = i;
        m18241a();
    }

    public int getMinLines() {
        return this.f18278f;
    }

    public void setMinLines(int i) {
        this.f18278f = i;
        m18241a();
    }

    public int getMaxWidth() {
        return this.f18280h;
    }

    public void setMaxWidth(int i) {
        this.f18280h = i;
        m18241a();
    }

    public CharSequence getText() {
        return this.f18287o;
    }

    public void setText(CharSequence charSequence) {
        this.f18287o = charSequence;
        setContentDescription(charSequence);
        m18241a();
    }

    private void m18242a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m18243a(typeface, i2);
    }

    private void m18243a(Typeface typeface, int i) {
        this.f18276d = TypefaceUtil.a(typeface, i);
        this.f18276d = typeface;
        this.f18277e = i;
        this.f18288p = null;
        m18241a();
    }

    public Typeface getTypeface() {
        return this.f18276d;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 964646671);
        super.onSizeChanged(i, i2, i3, i4);
        m18241a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1274342143, a);
    }

    private void m18241a() {
        this.f18289q = null;
        this.f18291s = null;
        this.f18290r = -1;
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("MultilineEllipsizeTextView.onMeasure", -166599221);
        try {
            m18245b();
            int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), this.f18280h);
            if (min != this.f18290r || this.f18291s == null) {
                this.f18291s = m18239a(min);
                this.f18290r = min;
            }
            setMeasuredDimension(m18237a(this.f18291s.f18269a, i), m18244b(this.f18291s.f18269a, i2));
        } finally {
            TracerDetour.a(-1717575616);
        }
    }

    private int m18237a(Layout layout, int i) {
        int i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        float f = 0.0f;
        for (i2 = 0; i2 < layout.getLineCount(); i2++) {
            f = Math.max(f, layout.getLineWidth(i2));
        }
        i2 = (int) ((Math.ceil((double) f) + ((double) getPaddingLeft())) + ((double) getPaddingRight()));
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i2, size);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    private int m18244b(Layout layout, int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int max = Math.max(this.f18281i, (layout.getHeight() + getPaddingTop()) + getPaddingBottom());
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(max, size);
            case 0:
                return max;
            default:
                return size;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m18245b();
        m18246c();
        canvas.save();
        int height = getHeight();
        Layout layout = this.f18289q.f18269a;
        canvas.translate((float) getPaddingLeft(), (float) (Math.max(0, height - layout.getHeight()) / 2));
        if (this.f18289q.f18270b == -1) {
            canvas.translate((float) (-(layout.getWidth() - (getWidth() - (getPaddingLeft() + getPaddingRight())))), 0.0f);
        }
        layout.draw(canvas);
        canvas.restore();
    }

    private void m18245b() {
        if (this.f18288p == null) {
            this.f18288p = new TextPaint(1);
            this.f18288p.density = getResources().getDisplayMetrics().density;
            this.f18288p.setTextSize(this.f18275c);
            this.f18288p.setColor(this.f18274b);
            TypefaceUtil.a(this.f18288p, this.f18276d, this.f18277e);
            this.f18288p.setTypeface(this.f18276d);
            this.f18288p.setShadowLayer(this.f18285m, this.f18283k, this.f18284l, this.f18286n);
        }
    }

    private void m18246c() {
        if (this.f18289q == null) {
            this.f18289q = m18239a(getWidth());
        }
    }

    private LayoutResult m18239a(int i) {
        m18245b();
        int max = Math.max(0, i - (getPaddingLeft() + getPaddingRight()));
        LineResult a = m18240a(this.f18287o, this.f18288p, max, this.f18279g, this.f18278f);
        return new LayoutResult(m18238a(a, this.f18288p, max), a.f18272b);
    }

    private LineResult m18240a(CharSequence charSequence, TextPaint textPaint, int i, int i2, int i3) {
        if (StringUtil.a(charSequence) || i < 0) {
            return new LineResult(Collections.emptyList(), 1);
        }
        Layout staticLayout = new StaticLayout(charSequence, textPaint, i, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, this.f18282j);
        int a = m18236a(staticLayout);
        List a2 = Lists.a();
        int i4 = 0;
        for (int i5 = i2; i5 > 0 && i4 < staticLayout.getLineCount(); i5--) {
            int lineStart = staticLayout.getLineStart(i4);
            if (lineStart >= charSequence.length()) {
                break;
            }
            int lineEnd;
            if (i4 < i2 - 1 || a == 0) {
                lineEnd = staticLayout.getLineEnd(i4);
                if (charSequence.charAt(lineEnd - 1) == '\n') {
                    lineEnd--;
                }
            } else {
                lineEnd = lineStart;
                while (lineEnd < charSequence.length() && charSequence.charAt(lineEnd) != '\n') {
                    lineEnd++;
                }
            }
            a2.add(charSequence.subSequence(lineStart, lineEnd));
            i4++;
        }
        while (a2.size() < i3) {
            a2.add("");
        }
        return new LineResult(a2, a);
    }

    private StaticLayout m18238a(LineResult lineResult, TextPaint textPaint, int i) {
        if (lineResult == null) {
            return null;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 1;
        for (CharSequence charSequence : lineResult.f18271a) {
            if (i2 == 0) {
                spannableStringBuilder.append("\n");
            }
            spannableStringBuilder.append(StringUtil.b(charSequence));
            i2 = 0;
        }
        return new StaticLayout(spannableStringBuilder, 0, spannableStringBuilder.length(), textPaint, lineResult.f18272b == 0 ? i : 16384, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, this.f18282j, TruncateAt.END, i);
    }

    private static int m18236a(Layout layout) {
        Object obj = 1;
        int i = 1;
        for (int i2 = 0; i2 < layout.getLineCount(); i2++) {
            int paragraphDirection = layout.getParagraphDirection(i2);
            if (i2 == 0) {
                i = paragraphDirection;
            } else if (i != paragraphDirection) {
                obj = null;
                break;
            }
        }
        return obj != null ? i : 0;
    }
}

package com.facebook.components.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import com.facebook.R;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentsConstants;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;
import com.facebook.components.annotations.MountSpec;
import com.facebook.fbui.widget.text.LayoutMeasureUtil;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.proxygen.HTTPTransportCallback;

@MountSpec
/* compiled from: from_index */
class TextSpec {
    protected static final ColorStateList f22928a = null;
    protected static final int f22929b = f22935h.getStyle();
    protected static final Typeface f22930c = f22935h;
    protected static final VerticalGravity f22931d = VerticalGravity.TOP;
    protected static final Alignment f22932e = Alignment.ALIGN_NORMAL;
    private static final Alignment[] f22933f = Alignment.values();
    private static final TruncateAt[] f22934g = TruncateAt.values();
    private static final Typeface f22935h = Typeface.DEFAULT;
    private static final Path f22936i = new Path();
    private static final Rect f22937j = new Rect();
    private static final RectF f22938k = new RectF();
    private static final Pools$SynchronizedPool<TextLayoutBuilder> f22939l = new Pools$SynchronizedPool(2);

    /* compiled from: from_index */
    /* synthetic */ class C09281 {
        static final /* synthetic */ int[] f23008a = new int[VerticalGravity.values().length];

        static {
            try {
                f23008a[VerticalGravity.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23008a[VerticalGravity.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    TextSpec() {
    }

    protected static void m31034a(ComponentContext componentContext, Output<TruncateAt> output, Output<Boolean> output2, Output<Float> output3, Output<Integer> output4, Output<Integer> output5, Output<Boolean> output6, Output<CharSequence> output7, Output<ColorStateList> output8, Output<Integer> output9, Output<Integer> output10, Output<Integer> output11, Output<Alignment> output12, Output<Integer> output13) {
        TypedArray a = componentContext.m30446a(R.styleable.Text, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index == 6) {
                output7.m31110a(a.getString(index));
            } else if (index == 2) {
                output8.m31110a(a.getColorStateList(index));
            } else if (index == 0) {
                output11.m31110a(Integer.valueOf(a.getDimensionPixelSize(index, 0)));
            } else if (index == 5) {
                index = a.getInteger(index, 0);
                if (index > 0) {
                    output.m31110a(f22934g[index - 1]);
                }
            } else if (VERSION.SDK_INT >= 17 && index == 12) {
                output12.m31110a(f22933f[a.getInteger(index, 0)]);
            } else if (index == 10) {
                output2.m31110a(Boolean.valueOf(a.getBoolean(index, false)));
            } else if (index == 8) {
                output4.m31110a(Integer.valueOf(a.getInteger(index, -1)));
            } else if (index == 7) {
                output5.m31110a(Integer.valueOf(a.getInteger(index, -1)));
            } else if (index == 9) {
                output6.m31110a(Boolean.valueOf(a.getBoolean(index, false)));
            } else if (index == 4) {
                output9.m31110a(Integer.valueOf(a.getColor(index, 0)));
            } else if (index == 3) {
                output10.m31110a(Integer.valueOf(a.getColor(index, 0)));
            } else if (index == 1) {
                output13.m31110a(Integer.valueOf(a.getInteger(index, 0)));
            } else if (index == 11) {
                output3.m31110a(Float.valueOf(a.getFloat(index, 0.0f)));
            }
        }
        a.recycle();
    }

    protected static void m31035a(ComponentLayout componentLayout, int i, int i2, Size size, CharSequence charSequence, TruncateAt truncateAt, boolean z, int i3, int i4, float f, float f2, float f3, int i5, boolean z2, int i6, ColorStateList colorStateList, int i7, int i8, float f4, float f5, int i9, Typeface typeface, Alignment alignment, boolean z3, Output<Layout> output) {
        if (TextUtils.isEmpty(charSequence)) {
            output.m31110a(null);
            size.f22987a = 0;
            size.f22988b = 0;
            return;
        }
        Layout a = m31031a(i, truncateAt, z, i4, f, f2, f3, i5, z2, charSequence, i6, colorStateList, i7, i8, f4, f5, i9, typeface, alignment, z3, componentLayout.m30809i());
        output.m31110a(a);
        size.f22987a = SizeSpec.m30707b(i, a.getWidth());
        int b = LayoutMeasureUtil.m29744b(a);
        int lineCount = a.getLineCount();
        if (lineCount < i3) {
            b += Math.round((((float) a.getPaint().getFontMetricsInt(null)) * f5) + f4) * (i3 - lineCount);
        }
        size.f22988b = SizeSpec.m30707b(i2, b);
    }

    private static Layout m31031a(int i, TruncateAt truncateAt, boolean z, int i2, float f, float f2, float f3, int i3, boolean z2, CharSequence charSequence, int i4, ColorStateList colorStateList, int i5, int i6, float f4, float f5, int i7, Typeface typeface, Alignment alignment, boolean z3, int i8) {
        int i9;
        TextLayoutBuilder textLayoutBuilder = (TextLayoutBuilder) f22939l.mo740a();
        if (textLayoutBuilder == null) {
            textLayoutBuilder = new TextLayoutBuilder();
            textLayoutBuilder.m28607c(false);
        }
        switch (SizeSpec.m30704a(i)) {
            case Integer.MIN_VALUE:
                i9 = 2;
                break;
            case 0:
                i9 = 0;
                break;
            case 1073741824:
                i9 = 1;
                break;
            default:
                throw new IllegalStateException("Unexpected size mode: " + SizeSpec.m30704a(i));
        }
        textLayoutBuilder.m28598a(truncateAt).m28610e(i2).m28591a(f, f2, f3, i3).m28605b(z2).m28599a(charSequence).m28604b(i6).m28593a(SizeSpec.m30706b(i), i9);
        if (colorStateList != null) {
            textLayoutBuilder.m28594a(colorStateList);
        } else {
            textLayoutBuilder.m28606c(i4);
        }
        if (typeface != f22935h) {
            textLayoutBuilder.m28595a(typeface);
        } else {
            textLayoutBuilder.m28609d(i7);
        }
        textLayoutBuilder.m28596a(i8 == 2 ? TextDirectionHeuristicsCompat.f7479d : TextDirectionHeuristicsCompat.f7478c);
        textLayoutBuilder.m28600a(z);
        textLayoutBuilder.m28590a(f4);
        textLayoutBuilder.m28603b(f5);
        textLayoutBuilder.m28597a(alignment);
        Layout d = textLayoutBuilder.m28608d();
        textLayoutBuilder.m28599a(null);
        f22939l.mo741a(textLayoutBuilder);
        d.getPaint().linkColor = i5;
        if (z3 && !ComponentsConstants.f22749b) {
            GlyphWarmer.m31111a().m31112a(d);
        }
        return d;
    }

    protected static void m31036a(ComponentLayout componentLayout, CharSequence charSequence, TruncateAt truncateAt, boolean z, int i, float f, float f2, float f3, int i2, boolean z2, int i3, ColorStateList colorStateList, int i4, int i5, float f4, float f5, VerticalGravity verticalGravity, int i6, Typeface typeface, Alignment alignment, boolean z3, Layout layout, Output<Layout> output, Output<Float> output2, Output<ClickableSpan[]> output3) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (layout != null) {
                output.m31110a(layout);
            } else {
                Output<Layout> output4 = output;
                output4.m31110a(m31031a(SizeSpec.m30705a(componentLayout.m30790c(), 1073741824), truncateAt, z, i, f, f2, f3, i2, z2, charSequence, i3, colorStateList, i4, i5, f4, f5, i6, typeface, alignment, z3, componentLayout.m30809i()));
            }
            float b = (float) LayoutMeasureUtil.m29744b((Layout) output.m31109a());
            float d = (float) ((componentLayout.m30793d() - componentLayout.m30796e()) - componentLayout.m30801g());
            switch (C09281.f23008a[verticalGravity.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    output2.m31110a(Float.valueOf((d - b) / 2.0f));
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    output2.m31110a(Float.valueOf(d - b));
                    break;
                default:
                    output2.m31110a(Float.valueOf(0.0f));
                    break;
            }
            if (charSequence instanceof Spanned) {
                output3.m31110a(((Spanned) charSequence).getSpans(0, charSequence.length() - 1, ClickableSpan.class));
            }
        }
    }

    protected static TextDrawable m31032a(TextDrawable textDrawable, CharSequence charSequence, int i, int i2, ColorStateList colorStateList, Layout layout, Float f, ClickableSpan[] clickableSpanArr) {
        TextDrawable textDrawable2;
        if (textDrawable == null) {
            textDrawable2 = new TextDrawable();
        } else {
            textDrawable2 = textDrawable;
        }
        textDrawable2.m31177a(charSequence, layout, f == null ? 0.0f : f.floatValue(), colorStateList, i, i2, clickableSpanArr);
        return textDrawable2;
    }

    protected static void m31033a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i, int i2, int i3, CharSequence charSequence, Layout layout, ClickableSpan[] clickableSpanArr) {
        Spanned spanned = (Spanned) charSequence;
        Object obj = clickableSpanArr[i];
        int spanStart = spanned.getSpanStart(obj);
        int spanEnd = spanned.getSpanEnd(obj);
        layout.getSelectionPath(spanStart, spanEnd, f22936i);
        f22936i.computeBounds(f22938k, true);
        f22937j.set(((int) f22938k.left) + i2, ((int) f22938k.top) + i3, ((int) f22938k.right) + i2, ((int) f22938k.bottom) + i3);
        accessibilityNodeInfoCompat.b(f22937j);
        accessibilityNodeInfoCompat.f(true);
        accessibilityNodeInfoCompat.a(true);
        accessibilityNodeInfoCompat.h(true);
        accessibilityNodeInfoCompat.c(true);
        accessibilityNodeInfoCompat.c(spanned.subSequence(spanStart, spanEnd));
    }

    protected static int m31030a(int i, int i2, CharSequence charSequence, Layout layout, ClickableSpan[] clickableSpanArr) {
        Spanned spanned = (Spanned) charSequence;
        for (int i3 = 0; i3 < clickableSpanArr.length; i3++) {
            Object obj = clickableSpanArr[i3];
            layout.getSelectionPath(spanned.getSpanStart(obj), spanned.getSpanEnd(obj), f22936i);
            f22936i.computeBounds(f22938k, true);
            if (f22938k.contains((float) i, (float) i2)) {
                return i3;
            }
        }
        return Integer.MIN_VALUE;
    }
}

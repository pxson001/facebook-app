package com.facebook.react.views.text;

import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: RKI18n */
public class ReactTextShadowNode extends LayoutShadowNode {
    public static final TextPaint f11524j;
    private static final MeasureFunction f11525k = new C13901();
    @Nullable
    public Spannable f11526A;
    private final boolean f11527B;
    protected int f11528g = -1;
    protected int f11529h = -1;
    protected boolean f11530i = false;
    public int f11531l = -1;
    private boolean f11532m = false;
    private int f11533n;
    private boolean f11534o = false;
    private int f11535p;
    private float f11536q = 0.0f;
    private float f11537r = 0.0f;
    private float f11538s = 1.0f;
    private int f11539t = 1426063360;
    private boolean f11540u = false;
    private boolean f11541v = false;
    private int f11542w = -1;
    private int f11543x = -1;
    @Nullable
    private String f11544y = null;
    @Nullable
    private String f11545z = null;

    /* compiled from: RKI18n */
    final class C13901 implements MeasureFunction {
        C13901() {
        }

        public final void m11998a(CSSNode cSSNode, float f, CSSMeasureMode cSSMeasureMode, float f2, CSSMeasureMode cSSMeasureMode2, MeasureOutput measureOutput) {
            Layout staticLayout;
            ReactTextShadowNode reactTextShadowNode = (ReactTextShadowNode) cSSNode;
            TextPaint textPaint = ReactTextShadowNode.f11524j;
            Spanned spanned = (Spanned) Assertions.a(reactTextShadowNode.f11526A, "Spannable element has not been prepared in onBeforeLayout");
            Metrics isBoring = BoringLayout.isBoring(spanned, textPaint);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spanned, textPaint) : Float.NaN;
            Object obj = (cSSMeasureMode == CSSMeasureMode.UNDEFINED || f < 0.0f) ? 1 : null;
            if (isBoring == null && (obj != null || (!CSSConstants.a(desiredWidth) && desiredWidth <= f))) {
                staticLayout = new StaticLayout(spanned, textPaint, (int) Math.ceil((double) desiredWidth), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            } else if (isBoring == null || (obj == null && ((float) isBoring.width) > f)) {
                staticLayout = new StaticLayout(spanned, textPaint, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            } else {
                staticLayout = BoringLayout.make(spanned, textPaint, isBoring.width, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, isBoring, true);
            }
            measureOutput.b = (float) staticLayout.getHeight();
            measureOutput.a = (float) staticLayout.getWidth();
            if (reactTextShadowNode.f11528g != -1 && reactTextShadowNode.f11528g < staticLayout.getLineCount()) {
                measureOutput.b = (float) staticLayout.getLineBottom(reactTextShadowNode.f11528g - 1);
            }
            if (reactTextShadowNode.f11531l != -1) {
                measureOutput.b = ((float) (reactTextShadowNode.f11528g != -1 ? Math.min(reactTextShadowNode.f11528g, staticLayout.getLineCount()) : staticLayout.getLineCount())) * PixelUtil.b((float) reactTextShadowNode.f11531l);
            }
        }
    }

    /* compiled from: RKI18n */
    class SetSpanOperation {
        protected int f11521a;
        protected int f11522b;
        protected Object f11523c;

        SetSpanOperation(int i, int i2, Object obj) {
            this.f11521a = i;
            this.f11522b = i2;
            this.f11523c = obj;
        }

        public final void m11999a(SpannableStringBuilder spannableStringBuilder) {
            int i = 34;
            if (this.f11521a == 0) {
                i = 18;
            }
            spannableStringBuilder.setSpan(this.f11523c, this.f11521a, this.f11522b, i);
        }
    }

    static {
        TextPaint textPaint = new TextPaint();
        f11524j = textPaint;
        textPaint.setFlags(1);
    }

    private static void m12002a(ReactTextShadowNode reactTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int length = spannableStringBuilder.length();
        if (reactTextShadowNode.f11545z != null) {
            spannableStringBuilder.append(reactTextShadowNode.f11545z);
        }
        int a = reactTextShadowNode.a();
        for (int i = 0; i < a; i++) {
            ReactShadowNode e = reactTextShadowNode.e(i);
            if (e instanceof ReactTextShadowNode) {
                m12002a((ReactTextShadowNode) e, spannableStringBuilder, list);
            } else if (e instanceof ReactTextInlineImageShadowNode) {
                spannableStringBuilder.append("I");
                list.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ((ReactTextInlineImageShadowNode) e).mo316O()));
            } else {
                throw new IllegalViewOperationException("Unexpected view type nested under text node: " + e.getClass());
            }
            e.w();
        }
        int length2 = spannableStringBuilder.length();
        if (length2 >= length) {
            if (reactTextShadowNode.f11532m) {
                list.add(new SetSpanOperation(length, length2, new ForegroundColorSpan(reactTextShadowNode.f11533n)));
            }
            if (reactTextShadowNode.f11534o) {
                list.add(new SetSpanOperation(length, length2, new BackgroundColorSpan(reactTextShadowNode.f11535p)));
            }
            if (reactTextShadowNode.f11529h != -1) {
                list.add(new SetSpanOperation(length, length2, new AbsoluteSizeSpan(reactTextShadowNode.f11529h)));
            }
            if (!(reactTextShadowNode.f11542w == -1 && reactTextShadowNode.f11543x == -1 && reactTextShadowNode.f11544y == null)) {
                list.add(new SetSpanOperation(length, length2, new CustomStyleSpan(reactTextShadowNode.f11542w, reactTextShadowNode.f11543x, reactTextShadowNode.f11544y, reactTextShadowNode.E().getAssets())));
            }
            if (reactTextShadowNode.f11540u) {
                list.add(new SetSpanOperation(length, length2, new UnderlineSpan()));
            }
            if (reactTextShadowNode.f11541v) {
                list.add(new SetSpanOperation(length, length2, new StrikethroughSpan()));
            }
            if (!(reactTextShadowNode.f11536q == 0.0f && reactTextShadowNode.f11537r == 0.0f)) {
                list.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(reactTextShadowNode.f11536q, reactTextShadowNode.f11537r, reactTextShadowNode.f11538s, reactTextShadowNode.f11539t)));
            }
            list.add(new SetSpanOperation(length, length2, new ReactTagSpan(reactTextShadowNode.g)));
        }
    }

    protected static Spannable m12001a(ReactTextShadowNode reactTextShadowNode) {
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        List arrayList = new ArrayList();
        m12002a(reactTextShadowNode, spannableStringBuilder, arrayList);
        if (reactTextShadowNode.f11529h == -1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) Math.ceil((double) PixelUtil.b(14.0f))), 0, spannableStringBuilder.length(), 17);
        }
        reactTextShadowNode.f11530i = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            SetSpanOperation setSpanOperation = (SetSpanOperation) arrayList.get(size);
            if (setSpanOperation.f11523c instanceof TextInlineImageSpan) {
                reactTextShadowNode.f11530i = true;
            }
            setSpanOperation.m11999a(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static int m12003b(String str) {
        return (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - 48) * 100;
    }

    public ReactTextShadowNode(boolean z) {
        this.f11527B = z;
        if (!z) {
            a(f11525k);
        }
    }

    public void mo324A() {
        if (!this.f11527B) {
            this.f11526A = m12001a(this);
            m12010x();
        }
    }

    protected final void m12010x() {
        super.x();
        if (!this.f11527B) {
            super.f();
        }
    }

    @ReactProp(name = "text")
    public void setText(@Nullable String str) {
        this.f11545z = str;
        m12010x();
    }

    @ReactProp(c = -1, name = "numberOfLines")
    public void setNumberOfLines(int i) {
        this.f11528g = i;
        m12010x();
    }

    @ReactProp(c = -1, name = "lineHeight")
    public void setLineHeight(int i) {
        this.f11531l = i;
        m12010x();
    }

    @ReactProp(b = -1.0f, name = "fontSize")
    public void setFontSize(float f) {
        if (f != -1.0f) {
            f = (float) Math.ceil((double) PixelUtil.b(f));
        }
        this.f11529h = (int) f;
        m12010x();
    }

    @ReactProp(name = "color")
    public void setColor(@Nullable Integer num) {
        this.f11532m = num != null;
        if (this.f11532m) {
            this.f11533n = num.intValue();
        }
        m12010x();
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        if (!t()) {
            this.f11534o = num != null;
            if (this.f11534o) {
                this.f11535p = num.intValue();
            }
            m12010x();
        }
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(@Nullable String str) {
        this.f11544y = str;
        m12010x();
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(@Nullable String str) {
        int i = -1;
        int b = str != null ? m12003b(str) : -1;
        if (b >= 500 || "bold".equals(str)) {
            i = 1;
        } else if ("normal".equals(str) || (b != -1 && b < 500)) {
            i = 0;
        }
        if (i != this.f11543x) {
            this.f11543x = i;
            m12010x();
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(@Nullable String str) {
        int i = -1;
        if ("italic".equals(str)) {
            i = 2;
        } else if ("normal".equals(str)) {
            i = 0;
        }
        if (i != this.f11542w) {
            this.f11542w = i;
            m12010x();
        }
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(@Nullable String str) {
        int i = 0;
        this.f11540u = false;
        this.f11541v = false;
        if (str != null) {
            String[] split = str.split(" ");
            int length = split.length;
            while (i < length) {
                Object obj = split[i];
                if ("underline".equals(obj)) {
                    this.f11540u = true;
                } else if ("line-through".equals(obj)) {
                    this.f11541v = true;
                }
                i++;
            }
        }
        m12010x();
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.f11536q = 0.0f;
        this.f11537r = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.f11536q = PixelUtil.a(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.f11537r = PixelUtil.a(readableMap.getDouble("height"));
            }
        }
        m12010x();
    }

    @ReactProp(c = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f) {
        if (f != this.f11538s) {
            this.f11538s = f;
            m12010x();
        }
    }

    @ReactProp(c = 1426063360, customType = "Color", name = "textShadowColor")
    public void setTextShadowColor(int i) {
        if (i != this.f11539t) {
            this.f11539t = i;
            m12010x();
        }
    }

    public final boolean m12009t() {
        return !this.f11527B;
    }

    public final boolean m12008s() {
        return this.f11527B;
    }

    public void mo325a(UIViewOperationQueue uIViewOperationQueue) {
        if (!this.f11527B) {
            super.a(uIViewOperationQueue);
            if (this.f11526A != null) {
                uIViewOperationQueue.a(this.g, new ReactTextUpdate(this.f11526A, -1, this.f11530i));
            }
        }
    }
}

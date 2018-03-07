package com.facebook.widget.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.resources.utils.ResourceUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: d895b1aad4ce698fa481ae42663fa708 */
public class SimpleVariableTextLayoutView extends VariableTextLayoutView<String> {
    private final Computer f16170a;
    private boolean f16171b;

    /* compiled from: d895b1aad4ce698fa481ae42663fa708 */
    class Computer implements VariableTextLayoutComputer<String> {
        private TruncateAt f16167a;

        private Layout m20220a(String str, List<TextPaint> list, int i, Alignment alignment, int i2, int i3) {
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            Result a = m20222a((List) list, str, i);
            return m20221a(a.f16169b, a.f16168a, i, alignment);
        }

        private Result m20222a(List<TextPaint> list, String str, int i) {
            for (TextPaint textPaint : list) {
                if (m20223a(textPaint, str, i)) {
                    return new Result(textPaint, ImmutableList.of(str));
                }
            }
            return new Result((TextPaint) list.get(list.size() - 1), ImmutableList.of(str));
        }

        private StaticLayout m20221a(List<String> list, TextPaint textPaint, int i, Alignment alignment) {
            if (list == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : list) {
                if (obj == null) {
                    stringBuilder.append("\n");
                }
                stringBuilder.append(str);
                obj = null;
            }
            CharSequence stringBuilder2 = stringBuilder.toString();
            return new StaticLayout(stringBuilder2, 0, stringBuilder2.length(), textPaint, 16384, alignment, 1.0f, 0.0f, false, this.f16167a, i);
        }

        private static boolean m20223a(TextPaint textPaint, String str, int i) {
            return textPaint.measureText(str) <= ((float) i);
        }

        public final void m20225a(boolean z) {
            this.f16167a = z ? null : TruncateAt.END;
        }
    }

    /* compiled from: d895b1aad4ce698fa481ae42663fa708 */
    class Result {
        final TextPaint f16168a;
        final List<String> f16169b;

        public Result(TextPaint textPaint, List<String> list) {
            this.f16168a = textPaint;
            this.f16169b = list;
        }
    }

    @Nullable
    protected final CharSequence m20226a(Object obj) {
        return (String) obj;
    }

    public SimpleVariableTextLayoutView(Context context) {
        this(context, null, 0);
    }

    public SimpleVariableTextLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleVariableTextLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16170a = new Computer();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleVariableTextLayoutView);
        String a = ResourceUtils.a(context, obtainStyledAttributes, 1);
        if (a == null) {
            a = "";
        }
        setText(a);
        this.f16171b = obtainStyledAttributes.getBoolean(0, false);
        this.f16170a.m20225a(this.f16171b);
        obtainStyledAttributes.recycle();
    }

    protected VariableTextLayoutComputer<String> getVariableTextLayoutComputer() {
        return this.f16170a;
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        setData(str);
    }
}

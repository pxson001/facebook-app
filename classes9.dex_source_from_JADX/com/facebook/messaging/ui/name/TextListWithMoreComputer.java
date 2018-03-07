package com.facebook.messaging.ui.name;

import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: checking */
public class TextListWithMoreComputer {
    private final I18nJoiner f18245a;
    private final StringBuilder f18246b = new StringBuilder(30);

    /* compiled from: checking */
    class PeekingIteratorWithCount<T> implements PeekingIterator<T> {
        private final PeekingIterator<T> f18241a;
        private int f18242b;

        public static <T> PeekingIteratorWithCount<T> m18198a(Collection<T> collection) {
            return new PeekingIteratorWithCount(collection);
        }

        private PeekingIteratorWithCount(Collection<T> collection) {
            this.f18241a = Iterators.i(collection.iterator());
            this.f18242b = collection.size();
        }

        public final T m18199a() {
            return this.f18241a.a();
        }

        public boolean hasNext() {
            return this.f18241a.hasNext();
        }

        public T next() {
            T next = this.f18241a.next();
            this.f18242b--;
            return next;
        }

        public void remove() {
            this.f18241a.remove();
        }

        public final int m18200b() {
            return this.f18242b;
        }
    }

    /* compiled from: checking */
    public class Result {
        public final List<String> f18243a;
        public final int f18244b;

        public Result(List<String> list, int i) {
            this.f18243a = list;
            this.f18244b = i;
        }

        public final List<String> m18201a() {
            return this.f18243a;
        }

        public final int m18202b() {
            return this.f18244b;
        }

        public String toString() {
            return Objects.toStringHelper(TextListWithMoreComputer.class).add("lines", this.f18243a).add("moreCount", this.f18244b).toString();
        }
    }

    public static TextListWithMoreComputer m18207b(InjectorLike injectorLike) {
        return new TextListWithMoreComputer(I18nJoiner.b(injectorLike));
    }

    @Inject
    public TextListWithMoreComputer(I18nJoiner i18nJoiner) {
        this.f18245a = i18nJoiner;
    }

    public final Result m18208a(List<String> list, float f, int i, float f2, TextPaint textPaint, float[] fArr) {
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        float max = Math.max(f2, f3);
        List a = Lists.a();
        PeekingIteratorWithCount a2 = PeekingIteratorWithCount.m18198a(list);
        int i2 = -1;
        char a3 = this.f18245a.a();
        float measureText = textPaint.measureText(Character.toString(a3));
        StringBuilder stringBuilder = new StringBuilder(100);
        while (i > 0 && a2.m18200b() > 0 && max >= f3) {
            i--;
            float f4 = max - f3;
            stringBuilder.setLength(0);
            float f5 = f;
            int i3 = i2;
            while (a2.hasNext()) {
                int i4;
                String str = (String) a2.m18199a();
                float a4 = m18203a((CharSequence) str, stringBuilder.length() != 0, textPaint);
                if (a2.m18200b() <= 1 || i <= 0) {
                    max = a4;
                } else {
                    max = a4 + measureText;
                }
                if (i > 0 && f4 >= f3) {
                    if (max >= f5) {
                        stringBuilder.append(a3);
                        break;
                    }
                    boolean z;
                    a2.next();
                    if (stringBuilder.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    m18206a(stringBuilder, str, z);
                    i4 = i3;
                } else if (a2.m18200b() == 1) {
                    if (f5 < a4) {
                        i3 = 1;
                    } else {
                        m18206a(stringBuilder, str, stringBuilder.length() > 0);
                    }
                    a2.next();
                    i4 = i3;
                } else {
                    int b = a2.m18200b();
                    float a5 = m18204a(fArr, a2.m18200b());
                    if (f5 - a4 < a5) {
                        if (b < 5) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            while (a2.hasNext()) {
                                String str2 = (String) a2.next();
                                boolean z2 = (stringBuilder.length() == 0 && stringBuilder2.length() == 0) ? false : true;
                                m18206a(stringBuilder2, str2, z2);
                            }
                            if (m18203a((CharSequence) stringBuilder2, false, textPaint) <= f5) {
                                stringBuilder.append(stringBuilder2);
                            }
                        }
                        if (stringBuilder.length() == 0) {
                            str = m18205a(str, textPaint, f5 - a5);
                            if (str != null) {
                                stringBuilder.append(str);
                                stringBuilder.append("…");
                                i2 = b - 1;
                                i3 = i2;
                            }
                        }
                        i2 = b;
                        i3 = i2;
                    } else {
                        a2.next();
                        m18206a(stringBuilder, str, stringBuilder.length() > 0);
                        i4 = i3;
                    }
                }
                f5 -= a4;
                i3 = i4;
            }
            if (stringBuilder.length() != 0) {
                a.add(stringBuilder.toString());
            }
            i2 = i3;
            max = f4;
        }
        return new Result(a, i2);
    }

    private String m18205a(String str, TextPaint textPaint, float f) {
        Object append = new StringBuilder(3).append("…").append(this.f18245a.b());
        float measureText = textPaint.measureText(append, 0, append.length());
        int length = str.length();
        float measureText2 = textPaint.measureText(str);
        while (f < measureText2 && length > append.length()) {
            length -= Character.charCount(str.codePointBefore(length));
            measureText2 = textPaint.measureText(str, 0, length) + measureText;
        }
        if (f >= measureText2) {
            return str.substring(0, length);
        }
        return null;
    }

    private float m18203a(CharSequence charSequence, boolean z, TextPaint textPaint) {
        this.f18246b.setLength(0);
        if (z) {
            this.f18246b.append(this.f18245a.b()).append(charSequence);
        } else {
            this.f18246b.append(charSequence);
        }
        return textPaint.measureText(this.f18246b, 0, this.f18246b.length());
    }

    private void m18206a(StringBuilder stringBuilder, String str, boolean z) {
        if (z) {
            stringBuilder.append(this.f18245a.b());
        }
        stringBuilder.append(str);
    }

    private static float m18204a(float[] fArr, int i) {
        if (fArr == null || fArr.length == 0) {
            return 0.0f;
        }
        if (fArr.length == 1 || i < 10) {
            return fArr[0];
        }
        if (fArr.length == 2 || i < 100) {
            return fArr[1];
        }
        return fArr[2];
    }
}

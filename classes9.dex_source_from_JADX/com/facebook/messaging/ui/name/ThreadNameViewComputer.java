package com.facebook.messaging.ui.name;

import android.content.res.Resources;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.messaging.ui.name.ThreadNameView.TextOptions;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.widget.text.VariableTextLayoutComputer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;

/* compiled from: check_payment_pin */
public class ThreadNameViewComputer implements VariableTextLayoutComputer<ThreadNameViewData> {
    private final EmojiUtil f18252a;
    private final Resources f18253b;
    private final TextListWithMoreComputer f18254c;
    private final TextOptions f18255d;
    private final I18nJoiner f18256e;

    /* compiled from: check_payment_pin */
    class Result {
        final TextPaint f18250a;
        final List<String> f18251b;

        public Result(TextPaint textPaint, List<String> list) {
            this.f18250a = textPaint;
            this.f18251b = list;
        }
    }

    public ThreadNameViewComputer(EmojiUtil emojiUtil, Resources resources, TextListWithMoreComputer textListWithMoreComputer, TextOptions textOptions, I18nJoiner i18nJoiner) {
        this.f18252a = emojiUtil;
        this.f18253b = resources;
        this.f18254c = textListWithMoreComputer;
        this.f18255d = textOptions;
        this.f18256e = i18nJoiner;
    }

    private Layout m18214a(ThreadNameViewData threadNameViewData, List<TextPaint> list, int i, Alignment alignment, int i2, int i3) {
        TextPaint textPaint = (TextPaint) list.get(0);
        if (threadNameViewData == null) {
            return m18215a(RegularImmutableList.a, textPaint, i, alignment);
        }
        if (m18220a(threadNameViewData)) {
            return m18215a(ImmutableList.of(threadNameViewData.f18234b), textPaint, i, alignment);
        }
        Result a = m18217a(list, threadNameViewData.f18235c, i, i2, i3);
        return m18215a(a.f18251b, a.f18250a, i, alignment);
    }

    public final CharSequence m18222a(ThreadNameViewData threadNameViewData, int i) {
        if (m18220a(threadNameViewData)) {
            return threadNameViewData.f18234b;
        }
        List list = threadNameViewData.f18235c;
        if (i == -1 || list.size() <= i) {
            return m18219a(list);
        }
        return this.f18256e.a(list.subList(0, i)) + m18218a(list.size() - i);
    }

    private boolean m18220a(ThreadNameViewData threadNameViewData) {
        return this.f18255d == TextOptions.USE_THREAD_NAME_IF_AVAILABLE && threadNameViewData.f18233a;
    }

    private Result m18217a(List<TextPaint> list, List<String> list2, int i, int i2, int i3) {
        String a = m18219a((List) list2);
        for (TextPaint a2 : list) {
            Result a3 = m18216a(a2, a, i);
            if (a3 != null) {
                return a3;
            }
        }
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
        }
        TextPaint textPaint = (TextPaint) list.get(list.size() - 1);
        if (list2.size() < 2) {
            return new Result(textPaint, ImmutableList.of(a));
        }
        List<String> list3 = list2;
        int i4 = i2;
        com.facebook.messaging.ui.name.TextListWithMoreComputer.Result a4 = this.f18254c.m18208a(list3, (float) i, i4, (float) i3, textPaint, new float[]{textPaint.measureText(m18218a(8)), textPaint.measureText(m18218a(88)), textPaint.measureText(m18218a(888))});
        List list4 = a4.f18243a;
        int size = list4.size();
        if (list4.size() > 0 && a4.f18244b > 0) {
            list4.set(size - 1, ((String) list4.get(size - 1)) + m18218a(a4.f18244b));
        }
        return new Result(textPaint, list4);
    }

    private StaticLayout m18215a(List<String> list, TextPaint textPaint, int i, Alignment alignment) {
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
        CharSequence valueOf = SpannableStringBuilder.valueOf(stringBuilder.toString());
        this.f18252a.a(valueOf, (int) textPaint.getTextSize());
        return new StaticLayout(valueOf, 0, valueOf.length(), textPaint, 16384, alignment, 1.0f, 0.0f, true, TruncateAt.END, i);
    }

    private static Result m18216a(TextPaint textPaint, String str, int i) {
        if (textPaint.measureText(str) <= ((float) i)) {
            return new Result(textPaint, ImmutableList.of(str));
        }
        return null;
    }

    private String m18219a(List<String> list) {
        if (list.isEmpty()) {
            return this.f18253b.getString(2131231061);
        }
        return this.f18256e.a(list);
    }

    private String m18218a(int i) {
        return this.f18256e.b() + this.f18253b.getString(2131231062, new Object[]{Integer.valueOf(i)});
    }
}

package com.facebook.common.util;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: settings_bar_menu */
public class StyledStringBuilder {
    private final Resources f2791a;
    private SpannableStringBuilder f2792b;
    private LinkedList<SpanStart> f2793c;

    /* compiled from: settings_bar_menu */
    class SpanStart {
        final int f2788a;
        final Object f2789b;
        final int f2790c;

        public SpanStart(int i, Object obj, int i2) {
            this.f2788a = i;
            this.f2789b = obj;
            this.f2790c = i2;
        }
    }

    public StyledStringBuilder(Resources resources) {
        this(new SpannableStringBuilder(), resources);
    }

    public StyledStringBuilder(SpannableStringBuilder spannableStringBuilder, Resources resources) {
        this.f2792b = new SpannableStringBuilder();
        this.f2793c = Lists.b();
        this.f2792b = spannableStringBuilder;
        this.f2791a = resources;
    }

    public final StyledStringBuilder m3921a(CharSequence charSequence) {
        this.f2792b.append(charSequence);
        return this;
    }

    public final StyledStringBuilder m3920a(int i) {
        this.f2792b.append(this.f2791a.getString(i));
        return this;
    }

    public final StyledStringBuilder m3922a(Object obj, int i) {
        this.f2793c.addFirst(new SpanStart(this.f2792b.length(), obj, i));
        return this;
    }

    public final StyledStringBuilder m3919a() {
        Preconditions.checkState(!this.f2793c.isEmpty());
        SpanStart spanStart = (SpanStart) this.f2793c.removeFirst();
        this.f2792b.setSpan(spanStart.f2789b, spanStart.f2788a, this.f2792b.length(), spanStart.f2790c);
        return this;
    }

    public final StyledStringBuilder m3925a(String str, String str2, Object obj, int i) {
        return m3924a(str, (CharSequence) str2, i, obj);
    }

    public final StyledStringBuilder m3924a(String str, CharSequence charSequence, int i, Object... objArr) {
        Preconditions.checkState(this.f2793c.isEmpty());
        Matcher matcher = Pattern.compile(Pattern.quote(str)).matcher(this.f2792b);
        if (matcher.find()) {
            int start = matcher.start();
            this.f2792b.replace(start, matcher.end(), charSequence);
            for (Object span : objArr) {
                this.f2792b.setSpan(span, start, charSequence.length() + start, i);
            }
        }
        return this;
    }

    public final StyledStringBuilder m3923a(String str, CharSequence charSequence) {
        return m3924a(str, charSequence, 0, Collections.EMPTY_LIST);
    }

    public final SpannableString m3926b() {
        return new SpannableString(this.f2792b);
    }
}

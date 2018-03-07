package com.facebook.resources.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.facebook.R;
import com.facebook.common.i18n.LastBreakIterator;
import com.facebook.common.util.TextRTLUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: display_reactions */
public class EllipsizingTextView extends FbTextView {
    private CharSequence f13742a;
    private int f13743b;
    private boolean f13744c;
    private int f13745d;
    private boolean f13746e;
    private boolean f13747f;
    private boolean f13748g;
    private boolean f13749h;
    private CharSequence f13750i;
    private boolean f13751j;

    public EllipsizingTextView(Context context) {
        super(context);
        m14476a(context, null);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14476a(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14476a(context, attributeSet);
    }

    private void m14476a(Context context, AttributeSet attributeSet) {
        super.setEllipsize(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizingTextView);
        this.f13747f = obtainStyledAttributes.getBoolean(0, true);
        if (this.f13743b == 0) {
            this.f13743b = Integer.MAX_VALUE;
        }
        this.f13748g = obtainStyledAttributes.getBoolean(1, false);
        this.f13749h = obtainStyledAttributes.getBoolean(2, false);
        if (obtainStyledAttributes.getString(3) != null) {
            this.f13750i = Html.fromHtml(obtainStyledAttributes.getString(3));
        } else {
            this.f13750i = "…";
        }
        obtainStyledAttributes.recycle();
    }

    public int getMaxLines() {
        return this.f13743b;
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f13743b = i;
        this.f13744c = true;
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.f13746e) {
            this.f13742a = charSequence;
            this.f13744c = true;
        }
        this.f13751j = TextRTLUtil.a(this, charSequence, i3);
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1258759430);
        super.onMeasure(i, i2);
        if (this.f13744c || this.f13745d != getMeasuredWidth()) {
            this.f13746e = true;
            setText(m14474a(), BufferType.SPANNABLE);
            this.f13746e = false;
            this.f13744c = false;
            this.f13745d = getMeasuredWidth();
            super.onMeasure(i, i2);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1977223181, a);
    }

    private CharSequence m14474a() {
        CharSequence charSequence = this.f13742a;
        Layout d = m14479d(charSequence);
        if (d.getLineCount() <= this.f13743b) {
            return charSequence;
        }
        charSequence = this.f13742a.subSequence(0, d.getLineEnd(this.f13743b - 1));
        if (!this.f13747f && charSequence.charAt(charSequence.length() - 1) == '\n') {
            return charSequence;
        }
        charSequence = m14480e(charSequence);
        if (this.f13749h) {
            return m14478c(charSequence);
        }
        if (this.f13748g) {
            return TextUtils.concat(new CharSequence[]{m14477b(charSequence), this.f13750i});
        }
        return TextUtils.concat(new CharSequence[]{m14475a(charSequence), this.f13750i});
    }

    private CharSequence m14475a(CharSequence charSequence) {
        while (true) {
            if (m14479d(TextUtils.concat(new CharSequence[]{charSequence, this.f13750i})).getLineCount() <= this.f13743b) {
                break;
            }
            int lastIndexOf = charSequence.toString().lastIndexOf(32);
            if (lastIndexOf == -1) {
                break;
            }
            charSequence = m14480e(charSequence.subSequence(0, lastIndexOf));
        }
        return charSequence;
    }

    private CharSequence m14477b(CharSequence charSequence) {
        LastBreakIterator lastBreakIterator = new LastBreakIterator(charSequence);
        while (true) {
            if (m14479d(TextUtils.concat(new CharSequence[]{charSequence, this.f13750i})).getLineCount() <= this.f13743b) {
                break;
            }
            CharSequence a = lastBreakIterator.a();
            if (TextUtils.isEmpty(a)) {
                break;
            }
            charSequence = a;
        }
        return charSequence;
    }

    private CharSequence m14478c(CharSequence charSequence) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        while (m14479d(spannableStringBuilder.append(this.f13750i)).getLineCount() > this.f13743b) {
            if (spannableStringBuilder.length() > 1) {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
            }
        }
        return spannableStringBuilder;
    }

    private Layout m14479d(CharSequence charSequence) {
        return new StaticLayout(charSequence, getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    private static CharSequence m14480e(CharSequence charSequence) {
        while (!TextUtils.isEmpty(charSequence) && Character.isWhitespace(charSequence.charAt(charSequence.length() - 1))) {
            charSequence = charSequence.subSequence(0, charSequence.length() - 1);
        }
        return charSequence;
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}

package com.facebook.photos.warning;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;

/* compiled from: selected_cards */
public class DisturbingMediaText extends FbTextView {
    private static final String f3499a = System.getProperty("line.separator");

    public DisturbingMediaText(Context context) {
        super(context);
        m3442a();
    }

    public DisturbingMediaText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3442a();
    }

    private void m3442a() {
        Resources resources = getResources();
        String string = resources.getString(2131238509);
        String string2 = resources.getString(2131238510);
        String a = StringLocaleUtil.a(resources.getString(2131238519), new Object[]{string, string2, resources.getString(2131238511), resources.getString(2131238512), f3499a, f3499a});
        CharSequence spannableString = new SpannableString(a);
        int indexOf = a.indexOf(string);
        spannableString.setSpan(new ForegroundColorSpan(-65536), indexOf, string.length() + indexOf, 0);
        int indexOf2 = a.indexOf(f3499a);
        Preconditions.checkState(indexOf2 > 0);
        spannableString.setSpan(new StyleSpan(1), indexOf, indexOf2, 0);
        spannableString.setSpan(new RelativeSizeSpan(1.1f), indexOf, indexOf2, 33);
        setText(spannableString, BufferType.SPANNABLE);
    }
}

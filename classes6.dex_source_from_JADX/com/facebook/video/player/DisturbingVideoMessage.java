package com.facebook.video.player;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.facebook.resources.ui.FbTextView;

/* compiled from: composer_post_completed */
public class DisturbingVideoMessage extends FbTextView {
    public DisturbingVideoMessage(Context context) {
        super(context);
        m27687a();
    }

    public DisturbingVideoMessage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27687a();
    }

    private void m27687a() {
        setTextColor(-1);
        setBackgroundDrawable(new ColorDrawable(-16777216));
        String string = getResources().getString(2131232770);
        String str = " - " + getResources().getString(2131232771);
        String string2 = getResources().getString(2131232772);
        CharSequence spannableString = new SpannableString(string + str + "\n" + string2 + "\n" + getResources().getString(2131232773));
        spannableString.setSpan(new ForegroundColorSpan(-65536), 0, string.length(), 0);
        int length = string.length() + str.length();
        spannableString.setSpan(new StyleSpan(1), 0, length, 0);
        spannableString.setSpan(new RelativeSizeSpan(1.1f), 0, length, 33);
        setText(spannableString, BufferType.SPANNABLE);
    }
}

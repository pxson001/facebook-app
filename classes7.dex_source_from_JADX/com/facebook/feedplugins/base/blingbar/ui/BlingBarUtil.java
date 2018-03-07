package com.facebook.feedplugins.base.blingbar.ui;

import android.widget.TextView;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.resources.utils.ResourceUtils;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: TD; */
public class BlingBarUtil {
    private static final NumberFormat f22904a = NumberFormat.getNumberInstance(Locale.getDefault());

    public static void m25437a(TextView textView, int i, String str, String str2) {
        if (i == 0) {
            textView.setText("");
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.getResources();
        textView.setText(ResourceUtils.a(str, str2, i));
    }

    public static void m25436a(TextView textView, int i, int i2, NumberTruncationUtil numberTruncationUtil) {
        if (i == 0) {
            textView.setText("");
            textView.setVisibility(8);
            return;
        }
        CharSequence quantityString = textView.getContext().getResources().getQuantityString(i2, i, new Object[]{numberTruncationUtil.a(i)});
        textView.setVisibility(0);
        textView.setText(quantityString);
    }
}

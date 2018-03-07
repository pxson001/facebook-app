package com.facebook.widget.text;

import android.content.Context;
import android.text.Layout;
import android.widget.TextView;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;

/* compiled from: production_prompt_id */
public class TextViewUtils {
    public static boolean m13826a(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout != null && layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
            return true;
        }
        return false;
    }

    public static String m13827b(TextView textView) {
        if (m13826a(textView)) {
            return textView.getText().toString();
        }
        return null;
    }

    public static void m13828c(TextView textView) {
        textView.setCustomSelectionActionModeCallback(new 1());
    }

    public static void m13825a(Context context, TextView textView) {
        if (ChatHeadsContextDetector.a(context)) {
            m13828c(textView);
        }
    }
}

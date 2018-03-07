package com.facebook.common.util;

import android.os.Build.VERSION;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.ViewCompat;
import android.widget.TextView;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: report_reason */
public class TextRTLUtil {
    public static boolean m12086a(TextView textView, CharSequence charSequence, int i) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2;
        if (VERSION.SDK_INT >= 17) {
            switch (textView.getTextDirection()) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (textView.getLayoutDirection() != 1) {
                        textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7478c;
                        break;
                    }
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7479d;
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7480e;
                    break;
                case 3:
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7476a;
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7477b;
                    break;
                case 5:
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7481f;
                    break;
                default:
                    textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7478c;
                    break;
            }
            textDirectionHeuristicCompat = textDirectionHeuristicCompat2;
        } else {
            if (ViewCompat.m10967h(textView) == 1) {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7479d;
            } else {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f7478c;
            }
            textDirectionHeuristicCompat = textDirectionHeuristicCompat2;
        }
        return textDirectionHeuristicCompat.mo1670a(charSequence, 0, i);
    }
}

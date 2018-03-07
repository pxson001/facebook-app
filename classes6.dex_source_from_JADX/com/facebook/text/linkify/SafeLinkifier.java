package com.facebook.text.linkify;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.widget.TextView;
import com.facebook.debug.log.BLog;
import java.util.regex.Pattern;

/* compiled from: deltaMarkRead */
public class SafeLinkifier {
    @SuppressLint({"BadMethodUse-com.facebook.text.FbLinkify.addLinks"})
    public static boolean m25595a(Spannable spannable, int i) {
        boolean z = false;
        try {
            z = FbLinkify.m25592a(spannable, i);
        } catch (Throwable e) {
            BLog.c("SafeLinkifier", e, "unable to linkify: %s", new Object[]{e.getMessage()});
        }
        return z;
    }

    @SuppressLint({"BadMethodUse-com.facebook.text.FbLinkify.addLinks"})
    public static boolean m25596a(TextView textView, int i) {
        boolean z = false;
        try {
            z = FbLinkify.m25593a(textView, i);
        } catch (Throwable e) {
            BLog.c("SafeLinkifier", e, "unable to linkify: %s", new Object[]{e.getMessage()});
        }
        return z;
    }

    @SuppressLint({"BadMethodUse-android.text.util.Linkify.addLinks"})
    public static void m25594a(TextView textView, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter) {
        try {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } catch (Throwable e) {
            BLog.c("SafeLinkifier", e, "unable to linkify: %s", new Object[]{e.getMessage()});
        }
    }
}

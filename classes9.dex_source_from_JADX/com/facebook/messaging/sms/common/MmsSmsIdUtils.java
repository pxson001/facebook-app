package com.facebook.messaging.sms.common;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.Telephony;
import android_src.provider.Telephony.Mms;
import android_src.provider.Telephony.Sms;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Predicate;
import javax.annotation.Nullable;

/* compiled from: commerce_page_nux_contents */
public class MmsSmsIdUtils {
    public static final Predicate<ThreadKey> f17520a = new C20791();
    public static final Predicate<ThreadKey> f17521b = new C20802();

    /* compiled from: commerce_page_nux_contents */
    final class C20791 implements Predicate<ThreadKey> {
        C20791() {
        }

        public final boolean apply(@Nullable Object obj) {
            return ThreadKey.d((ThreadKey) obj);
        }
    }

    /* compiled from: commerce_page_nux_contents */
    final class C20802 implements Predicate<ThreadKey> {
        C20802() {
        }

        public final boolean apply(@Nullable Object obj) {
            ThreadKey threadKey = (ThreadKey) obj;
            return (threadKey == null || ThreadKey.d(threadKey)) ? false : true;
        }
    }

    public static Uri m17497a(String str) {
        if (str.startsWith("smsid:")) {
            return ContentUris.withAppendedId(Sms.a, Long.parseLong(str.substring(6)));
        }
        throw new IllegalArgumentException("Not a valid sms message id: " + str);
    }

    public static Uri m17500b(String str) {
        if (str.startsWith("mmsid:")) {
            return ContentUris.withAppendedId(Mms.a, Long.parseLong(str.substring(6)));
        }
        throw new IllegalArgumentException("Not a valid mms message id: " + str);
    }

    @TargetApi(19)
    public static String m17499a(Uri uri) {
        long parseId = ContentUris.parseId(uri);
        String uri2 = uri.toString();
        if (uri2.startsWith(Telephony.Sms.CONTENT_URI.toString())) {
            return m17498a(parseId);
        }
        if (uri2.startsWith(Telephony.Mms.CONTENT_URI.toString())) {
            return m17501b(parseId);
        }
        throw new IllegalArgumentException("Not a valid message uri: " + uri);
    }

    public static String m17498a(long j) {
        return "smsid:" + j;
    }

    public static String m17501b(long j) {
        return "mmsid:" + j;
    }

    public static boolean m17502c(String str) {
        return str.startsWith("smsid:");
    }

    public static boolean m17503d(String str) {
        return str.startsWith("mmsid:");
    }
}

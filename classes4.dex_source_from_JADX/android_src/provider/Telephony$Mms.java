package android_src.provider;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: fb4a_upload_quality */
public final class Telephony$Mms implements Telephony$BaseMmsColumns {
    public static final Uri f12071a;
    public static final Uri f12072b;
    public static final Uri f12073c = Uri.withAppendedPath(f12071a, "report-status");
    public static final Pattern f12074d = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
    public static final Pattern f12075e = Pattern.compile("\\s*\"([^\"]*)\"\\s*");

    /* compiled from: fb4a_upload_quality */
    public final class Inbox implements Telephony$BaseMmsColumns {
        public static final Uri f12076a = Uri.parse("content://mms/inbox");
    }

    static {
        Uri parse = Uri.parse("content://mms");
        f12071a = parse;
        f12072b = Uri.withAppendedPath(parse, "report-request");
    }

    public static String m12757a(String str) {
        Matcher matcher = f12074d.matcher(str);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        return str;
    }

    public static boolean m12758b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(m12757a(str)).matches();
    }
}

package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzln {
    private static final zzl f10187a = new zzl("MetadataUtils");
    private static final String[] f10188b = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String f10189c = ("yyyyMMdd'T'HHmmss" + f10188b[0]);

    public static Calendar m11967a(String str) {
        if (TextUtils.isEmpty(str)) {
            f10187a.m11956b("Input string is empty or null", new Object[0]);
            return null;
        }
        String b = m11970b(str);
        if (TextUtils.isEmpty(b)) {
            f10187a.m11956b("Invalid date format", new Object[0]);
            return null;
        }
        String c = m11971c(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(c)) {
            b = b + "T" + c;
            str2 = c.length() == 6 ? "yyyyMMdd'T'HHmmss" : f10189c;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(b));
            return instance;
        } catch (ParseException e) {
            f10187a.m11956b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    public static void m11968a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void m11969a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage e : list) {
                jSONArray.put(e.e());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e2) {
            }
        }
    }

    private static String m11970b(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            f10187a.m11956b("Input string is empty or null", new Object[0]);
        } else {
            try {
                str2 = str.substring(0, 8);
            } catch (IndexOutOfBoundsException e) {
                f10187a.m11957c("Error extracting the date: %s", e.getMessage());
            }
        }
        return str2;
    }

    private static String m11971c(String str) {
        if (TextUtils.isEmpty(str)) {
            f10187a.m11956b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != 8) {
            f10187a.m11956b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == 6) {
                return substring;
            }
            switch (substring.charAt(6)) {
                case '+':
                case '-':
                    return m11972d(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case 'Z':
                    return substring.length() == f10188b[0].length() + 6 ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            f10187a.m11956b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean m11972d(String str) {
        int length = str.length();
        return length == f10188b[1].length() + 6 || length == f10188b[2].length() + 6 || length == 6 + f10188b[3].length();
    }
}

package com.facebook.common.uri;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.Tuple;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
/* compiled from: time_last_production_prompt_network_fetch_seconds */
public class UriTemplateMap<T> {
    public static final Pattern f2857b = Pattern.compile("\\{([#]?)([^ }]+)\\}");
    public static final Pattern f2858c = Pattern.compile("\\{([#!]?)([^ }]+)(?: ([^}]+))?\\}");
    private static final Pattern f2859d = Pattern.compile("&?([^=]+)=([^&]+)");
    private final List<MapEntry> f2860a = Lists.m1296a();

    /* compiled from: time_last_production_prompt_network_fetch_seconds */
    class MapEntry {
        List<Tuple<Class<?>, String>> f2861a;
        final /* synthetic */ UriTemplateMap f2862b;
        private Map<String, QueryParameter> f2863c;
        private Pattern f2864d;
        private final String f2865e;
        private final T f2866f;
        private final int f2867g;

        MapEntry(UriTemplateMap uriTemplateMap, String str, T t) {
            this.f2862b = uriTemplateMap;
            this.f2865e = str;
            this.f2866f = t;
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == '{' || charAt == '?' || charAt == '%') {
                    break;
                }
                i++;
            }
            i = str.charAt(length + -1) == '/' ? length - 1 : length;
            this.f2867g = i;
        }

        private synchronized void m4860a() {
            this.f2863c = Maps.m838c();
            this.f2861a = Lists.m1296a();
            String[] f = UriTemplateMap.m4857f(this.f2865e);
            String str = f[0];
            String str2 = f[1];
            Matcher matcher = UriTemplateMap.f2857b.matcher(str);
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            Set a = Sets.m1313a();
            String str3 = str;
            while (matcher.find()) {
                CharSequence group = matcher.group(0);
                boolean equals = matcher.group(1).equals("#");
                Object obj = equals ? Long.class : String.class;
                String group2 = matcher.group(2);
                this.f2861a.add(new Tuple(obj, group2));
                if (a.add(group2)) {
                    str3 = str3.replace(group, equals ? "(-?[0-9]+)" : "([^/]+)");
                } else {
                    throw new InvalidUriTemplateException("Duplicate template key");
                }
            }
            this.f2864d = Pattern.compile(str3 + "[/]?");
            for (Entry entry : UriTemplateMap.m4856e(str2).entrySet()) {
                matcher = UriTemplateMap.f2858c.matcher((CharSequence) entry.getValue());
                if (matcher.matches()) {
                    TemplateValueType templateValueType = TemplateValueType.STRING;
                    if ("#".equals(matcher.group(1))) {
                        templateValueType = TemplateValueType.LONG;
                    } else if ("!".equals(matcher.group(1))) {
                        templateValueType = TemplateValueType.BOOLEAN;
                    }
                    String group3 = matcher.group(2);
                    String group4 = matcher.group(3);
                    str = (String) entry.getKey();
                    if (a.add(str)) {
                        this.f2863c.put(str, new QueryParameter(this.f2862b, group3, templateValueType, group4));
                    } else {
                        throw new InvalidUriTemplateException("Duplicate template key");
                    }
                }
                throw new InvalidUriTemplateException("Query parameter does not match templating syntax");
            }
        }

        final UriMatch<T> m4861a(String str) {
            if (!str.regionMatches(0, this.f2865e, 0, this.f2867g)) {
                return null;
            }
            String[] f = UriTemplateMap.m4857f(str);
            CharSequence charSequence = f[0];
            String str2 = f[1];
            if (this.f2864d == null) {
                m4860a();
            }
            Matcher matcher = this.f2864d.matcher(charSequence);
            if (!matcher.matches()) {
                return null;
            }
            Bundle bundle = new Bundle();
            for (int i = 0; i < this.f2861a.size(); i++) {
                Tuple tuple = (Tuple) this.f2861a.get(i);
                if (tuple.a == Long.class) {
                    bundle.putLong((String) tuple.b, Long.parseLong(matcher.group(i + 1)));
                } else {
                    bundle.putString((String) tuple.b, matcher.group(i + 1));
                }
            }
            Map e = UriTemplateMap.m4856e(str2);
            for (Entry entry : this.f2863c.entrySet()) {
                String str3 = (String) entry.getKey();
                QueryParameter queryParameter = (QueryParameter) entry.getValue();
                String str4 = queryParameter.c;
                if (queryParameter.a && !e.containsKey(str3)) {
                    return null;
                }
                str3 = e.containsKey(str3) ? (String) e.get(str3) : queryParameter.b;
                if (queryParameter.d == TemplateValueType.LONG) {
                    bundle.putLong(str4, Long.parseLong(str3));
                } else if (queryParameter.d == TemplateValueType.BOOLEAN) {
                    bundle.putBoolean(str4, Boolean.valueOf(str3).booleanValue());
                } else {
                    bundle.putString(str4, str3);
                }
            }
            return new UriMatch(this.f2866f, bundle);
        }
    }

    public final void m4859a(String str, T t) {
        if (str == null) {
            throw new InvalidUriTemplateException("Key template may not be null");
        }
        this.f2860a.add(new MapEntry(this, str, t));
    }

    public final UriMatch<T> m4858a(String str) {
        if (str == null) {
            throw new InvalidUriException("Key may not be null");
        }
        for (MapEntry a : this.f2860a) {
            UriMatch<T> a2 = a.m4861a(str);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public static Map<String, String> m4856e(String str) {
        Map<String, String> c = Maps.m838c();
        Matcher matcher = f2859d.matcher(str);
        while (matcher.find()) {
            c.put(Uri.decode(matcher.group(1)), Uri.decode(matcher.group(2)));
        }
        return c;
    }

    public static String[] m4857f(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case '?':
                    if (i != 0) {
                        break;
                    }
                    return new String[]{str.substring(0, i2), str.substring(i2 + 1)};
                case '{':
                    i = 1;
                    break;
                case '}':
                    i = 0;
                    break;
                default:
                    break;
            }
        }
        return new String[]{str, ""};
    }
}

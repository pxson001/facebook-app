package com.facebook.text.linkify;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: deltaMarkUnread */
class FbLinkify {
    private static final Pattern f17607a = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\_][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\_\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");

    /* compiled from: deltaMarkUnread */
    final class C12861 implements Comparator<LinkSpec> {
        C12861() {
        }

        public final int compare(Object obj, Object obj2) {
            LinkSpec linkSpec = (LinkSpec) obj;
            LinkSpec linkSpec2 = (LinkSpec) obj2;
            if (linkSpec.f17609b < linkSpec2.f17609b) {
                return -1;
            }
            if (linkSpec.f17609b > linkSpec2.f17609b) {
                return 1;
            }
            if (linkSpec.f17610c < linkSpec2.f17610c) {
                return 1;
            }
            if (linkSpec.f17610c <= linkSpec2.f17610c) {
                return 0;
            }
            return -1;
        }

        public final boolean equals(Object obj) {
            return false;
        }
    }

    FbLinkify() {
    }

    static final boolean m25592a(Spannable spannable, int i) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            Spannable spannable2 = spannable;
            m25591a(arrayList, spannable2, f17607a, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            m25591a(arrayList, spannable, Patterns.EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 4) != 0) {
            spannable2 = spannable;
            m25591a(arrayList, spannable2, Patterns.PHONE, new String[]{"tel:"}, Linkify.sPhoneNumberMatchFilter, Linkify.sPhoneNumberTransformFilter);
        }
        if ((i & 8) != 0) {
            m25590a(arrayList, spannable);
        }
        m25589a(arrayList);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            String str = linkSpec.f17608a;
            spannable.setSpan(new URLSpan(str), linkSpec.f17609b, linkSpec.f17610c, 33);
        }
        return true;
    }

    static final boolean m25593a(TextView textView, int i) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            Spannable valueOf = SpannableString.valueOf(text);
            if (!m25592a(valueOf, i)) {
                return false;
            }
            m25588a(textView);
            textView.setText(valueOf);
            return true;
        } else if (!m25592a((Spannable) text, i)) {
            return false;
        } else {
            m25588a(textView);
            return true;
        }
    }

    private static final void m25588a(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private static final String m25587a(String str, String[] strArr, Matcher matcher, TransformFilter transformFilter) {
        String transformUrl;
        boolean z = true;
        if (transformFilter != null) {
            transformUrl = transformFilter.transformUrl(matcher, str);
        } else {
            transformUrl = str;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (transformUrl.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!transformUrl.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    transformUrl = strArr[i] + transformUrl.substring(strArr[i].length());
                }
                if (z) {
                    return strArr[0] + transformUrl;
                }
                return transformUrl;
            }
        }
        z = false;
        if (z) {
            return transformUrl;
        }
        return strArr[0] + transformUrl;
    }

    private static final void m25591a(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.f17608a = m25587a(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.f17609b = start;
                linkSpec.f17610c = end;
                arrayList.add(linkSpec);
            }
        }
    }

    private static final void m25590a(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        String obj = spannable.toString();
        int i = 0;
        while (true) {
            String findAddress = WebView.findAddress(obj);
            if (findAddress != null) {
                int indexOf = obj.indexOf(findAddress);
                if (indexOf >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = findAddress.length() + indexOf;
                    linkSpec.f17609b = indexOf + i;
                    linkSpec.f17610c = i + length;
                    obj = obj.substring(length);
                    i += length;
                    try {
                        linkSpec.f17608a = "geo:0,0?q=" + URLEncoder.encode(findAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException e) {
                    }
                } else {
                    return;
                }
            }
            return;
        }
    }

    private static final void m25589a(ArrayList<LinkSpec> arrayList) {
        Collections.sort(arrayList, new C12861());
        int i = 0;
        int size = arrayList.size();
        while (i < size - 1) {
            LinkSpec linkSpec = (LinkSpec) arrayList.get(i);
            LinkSpec linkSpec2 = (LinkSpec) arrayList.get(i + 1);
            if (linkSpec.f17609b <= linkSpec2.f17609b && linkSpec.f17610c > linkSpec2.f17609b) {
                int i2;
                if (linkSpec2.f17610c <= linkSpec.f17610c) {
                    i2 = i + 1;
                } else if (linkSpec.f17610c - linkSpec.f17609b > linkSpec2.f17610c - linkSpec2.f17609b) {
                    i2 = i + 1;
                } else if (linkSpec.f17610c - linkSpec.f17609b < linkSpec2.f17610c - linkSpec2.f17609b) {
                    i2 = i;
                } else {
                    i2 = -1;
                }
                if (i2 != -1) {
                    arrayList.remove(i2);
                    size--;
                }
            }
            i++;
        }
    }
}

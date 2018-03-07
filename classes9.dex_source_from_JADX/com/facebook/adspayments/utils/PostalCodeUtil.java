package com.facebook.adspayments.utils;

import com.facebook.common.locale.Country;
import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.regex.Pattern;

/* compiled from: UPLOAD_RECEIPT */
public class PostalCodeUtil {
    public static final ImmutableSet<String> f23720a = ImmutableSet.of("AD", "AR", "AZ", "BB", "BN", "CA", new String[]{"IE", "KZ", "MT", "NL", "PE", "VC", "SO", "SZ", "GB"});
    public static final ImmutableMap<String, String> f23721b = ImmutableMap.builder().b("AX", "CC-").b("AD", "CC").b("AI", "AI-2640").b("AC", "ASCN 1ZZ").b("AZ", "CC").b("BB", "CC").b("AQ", "BIQQ 1ZZ").b("IO", "BBND 1ZZ").b("VG", "CC").b("KY", "CC").b("FK", "FIQQ 1ZZ").b("GF", "973").b("PF", "987").b("GG", "GY").b("GI", "GX11 1AA").b("GP", "971").b("HN", "CC").b("IM", "CC").b("JE", "CC").b("LV", "CC-").b("LT", "CC-").b("MQ", "972").b("YT", "976").b("MD", "CC").b("MC", "980").b("MS", "MSR 1110-1350").b("NC", "988").b("PE", "CC ").b("PN", "PCRN 1ZZ").b("RE", "974").b("BL", "97133").b("SH", "STHL 1ZZ").b("LC", "LC").b("MF", "97150").b("PM", "97500").b("VC", "CC").b("WS", "CC").b("SM", "4789").b("SI", "CC-").b("GS", "SIQQ 1ZZ").b("TA", "TDCU 1ZZ").b("TC", "TKCA 1ZZ").b("VA", "00120").b("WF", "986").b();
    private static final ImmutableSet<String> f23722c = ImmutableSet.of("CN", "UK", "US");
    public static final ImmutableMap<String, String> f23723d = ImmutableMap.builder().b("GB", "GIR[ ]?0AA|((AB|AL|B|BA|BB|BD|BH|BL|BN|BR|BS|BT|CA|CB|CF|CH|CM|CO|CR|CT|CV|CW|DA|DD|DE|DG|DH|DL|DN|DT|DY|E|EC|EH|EN|EX|FK|FY|G|GL|GY|GU|HA|HD|HG|HP|HR|HS|HU|HX|IG|IM|IP|IV|JE|KA|KT|KW|KY|L|LA|LD|LE|LL|LN|LS|LU|M|ME|MK|ML|N|NE|NG|NN|NP|NR|NW|OL|OX|PA|PE|PH|PL|PO|PR|RG|RH|RM|S|SA|SE|SG|SK|SL|SM|SN|SO|SP|SR|SS|ST|SW|SY|TA|TD|TF|TN|TQ|TR|TS|TW|UB|W|WA|WC|WD|WF|WN|WR|WS|WV|YO|ZE)(\\d[\\dA-Z]?[ ]?\\d[ABD-HJLN-UW-Z]{2}))|BFPO[ ]?\\d{1,4}").b("JE", "\\d[\\dA-Z]?[ ]?\\d[ABD-HJLN-UW-Z]{2}").b("GG", "GY\\d[\\dA-Z]?[ ]?\\d[ABD-HJLN-UW-Z]{2}").b("IM", "\\d[\\dA-Z]?[ ]?\\d[ABD-HJLN-UW-Z]{2}").b("US", "\\d{5}([ \\-]\\d{4})?").b("CA", "[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ ]?\\d[ABCEGHJ-NPRSTV-Z]\\d").b("DE", "\\d{5}").b("JP", "\\d{3}-\\d{4}").b("FR", "\\d{2}[ ]?\\d{3}").b("AU", "\\d{4}").b("IT", "\\d{5}").b("CH", "\\d{4}").b("AT", "\\d{4}").b("ES", "\\d{5}").b("NL", "\\d{4}[ ]?[A-Z]{2}").b("BE", "\\d{4}").b("DK", "\\d{4}").b("SE", "\\d{3}[ ]?\\d{2}").b("NO", "\\d{4}").b("BR", "\\d{5}[\\-]?\\d{3}").b("PT", "\\d{4}([\\-]\\d{3})?").b("FI", "\\d{5}").b("AX", "22\\d{3}").b("KR", "\\d{3}[\\-]\\d{3}").b("CN", "\\d{6}").b("TW", "\\d{3}(\\d{2})?").b("SG", "\\d{6}").b("DZ", "\\d{5}").b("AD", "\\d{3}").b("AR", "([A-HJ-NP-Z])?\\d{4}([A-Z]{3})?").b("AM", "(37)?\\d{4}").b("AZ", "\\d{4}").b("BH", "((1[0-2]|[2-9])\\d{2})?").b("BD", "\\d{4}").b("BB", "(\\d{5})?").b("BY", "\\d{6}").b("BM", "[A-Z]{2}[ ]?[A-Z0-9]{2}").b("BA", "\\d{5}").b("IO", "BBND 1ZZ").b("BN", "[A-Z]{2}[ ]?\\d{4}").b("BG", "\\d{4}").b("KH", "\\d{5}").b("CV", "\\d{4}").b("CL", "\\d{7}").b("CR", "\\d{4,5}|\\d{3}-\\d{4}").b("HR", "\\d{5}").b("CY", "\\d{4}").b("CZ", "\\d{3}[ ]?\\d{2}").b("DO", "\\d{5}").b("EC", "([A-Z]\\d{4}[A-Z]|(?:[A-Z]{2})?\\d{6})?").b("EG", "\\d{5}").b("EE", "\\d{5}").b("FO", "\\d{3}").b("GE", "\\d{4}").b("GR", "\\d{3}[ ]?\\d{2}").b("GL", "39\\d{2}").b("GT", "\\d{5}").b("HT", "\\d{4}").b("HN", "(?:\\d{5})?").b("HU", "\\d{4}").b("IS", "\\d{3}").b("IN", "\\d{6}").b("ID", "\\d{5}").b("IL", "\\d{5}").b("JO", "\\d{5}").b("KZ", "\\d{6}").b("KE", "\\d{5}").b("KW", "\\d{5}").b("LA", "\\d{5}").b("LV", "\\d{4}").b("LB", "(\\d{4}([ ]?\\d{4})?)?").b("LI", "(948[5-9])|(949[0-7])").b("LT", "\\d{5}").b("LU", "\\d{4}").b("MK", "\\d{4}").b("MY", "\\d{5}").b("MV", "\\d{5}").b("MT", "[A-Z]{3}[ ]?\\d{2,4}").b("MU", "(\\d{3}[A-Z]{2}\\d{3})?").b("MX", "\\d{5}").b("MD", "\\d{4}").b("MC", "980\\d{2}").b("MA", "\\d{5}").b("NP", "\\d{5}").b("NZ", "\\d{4}").b("NI", "((\\d{4}-)?\\d{3}-\\d{3}(-\\d{1})?)?").b("NG", "(\\d{6})?").b("OM", "(PC )?\\d{3}").b("PK", "\\d{5}").b("PY", "\\d{4}").b("PH", "\\d{4}").b("PL", "\\d{2}-\\d{3}").b("PR", "00[679]\\d{2}([ \\-]\\d{4})?").b("RO", "\\d{6}").b("RU", "\\d{6}").b("SM", "4789\\d").b("SA", "\\d{5}").b("SN", "\\d{5}").b("SK", "\\d{3}[ ]?\\d{2}").b("SI", "\\d{4}").b("ZA", "\\d{4}").b("LK", "\\d{5}").b("TJ", "\\d{6}").b("TH", "\\d{5}").b("TN", "\\d{4}").b("TR", "\\d{5}").b("TM", "\\d{6}").b("UA", "\\d{5}").b("UY", "\\d{5}").b("UZ", "\\d{6}").b("VA", "00120").b("VE", "\\d{4}").b("ZM", "\\d{5}").b("AS", "96799").b("CC", "6799").b("CK", "\\d{4}").b("RS", "\\d{6}").b("ME", "8\\d{4}").b("CS", "\\d{5}").b("YU", "\\d{5}").b("CX", "6798").b("ET", "\\d{4}").b("FK", "FIQQ 1ZZ").b("NF", "2899").b("FM", "(9694[1-4])([ \\-]\\d{4})?").b("GF", "9[78]3\\d{2}").b("GN", "\\d{3}").b("GP", "9[78][01]\\d{2}").b("GS", "SIQQ 1ZZ").b("GU", "969[123]\\d([ \\-]\\d{4})?").b("GW", "\\d{4}").b("HM", "\\d{4}").b("IQ", "\\d{5}").b("KG", "\\d{6}").b("LR", "\\d{4}").b("LS", "\\d{3}").b("MG", "\\d{3}").b("MH", "969[67]\\d([ \\-]\\d{4})?").b("MN", "\\d{6}").b("MP", "9695[012]([ \\-]\\d{4})?").b("MQ", "9[78]2\\d{2}").b("NC", "988\\d{2}").b("NE", "\\d{4}").b("VI", "008(([0-4]\\d)|(5[01]))([ \\-]\\d{4})?").b("PF", "987\\d{2}").b("PG", "\\d{3}").b("PM", "9[78]5\\d{2}").b("PN", "PCRN 1ZZ").b("PW", "96940").b("RE", "9[78]4\\d{2}").b("SH", "(ASCN|STHL) 1ZZ").b("SJ", "\\d{4}").b("SO", "\\d{5}").b("SZ", "[HLMS]\\d{3}").b("TC", "TKCA 1ZZ").b("WF", "986\\d{2}").b("XK", "\\d{5}").b("YT", "976\\d{2}").b();
    private static final LoadingCache<String, Pattern> f23724e = CacheBuilder.newBuilder().a(new C28691());

    /* compiled from: UPLOAD_RECEIPT */
    final class C28691 extends CacheLoader<String, Pattern> {
        C28691() {
        }

        public final Object m25757a(Object obj) {
            String str = (String) obj;
            String str2 = (String) PostalCodeUtil.f23723d.get(str);
            if (str2 == null) {
                str2 = ".*";
            } else {
                String str3 = (String) PostalCodeUtil.f23721b.get(str);
                if (str3 != null && str3.startsWith("CC")) {
                    str2 = StringFormatUtil.a("%s%s", new Object[]{str3.replace("CC", str), str2});
                }
            }
            return Pattern.compile(str2);
        }
    }

    public static boolean m25759b(Country country) {
        return f23722c.contains(country.b());
    }

    public static boolean m25758a(CharSequence charSequence, Country country) {
        return ((Pattern) f23724e.d(country.b())).matcher(charSequence).matches();
    }

    private PostalCodeUtil() {
    }
}

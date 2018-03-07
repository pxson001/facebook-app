package com.facebook.common.locale;

import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Locale;

/* compiled from: sender_mqtt_client */
public class FBLocaleMapper {
    public static String m9532a(Locale locale) {
        String str;
        String locale2 = locale.toString();
        Object obj = -1;
        switch (locale2.hashCode()) {
            case 96646193:
                if (locale2.equals("en_GB")) {
                    obj = null;
                    break;
                }
                break;
            case 96795103:
                if (locale2.equals("es_ES")) {
                    obj = 1;
                    break;
                }
                break;
            case 97212394:
                if (locale2.equals("fb_LS")) {
                    obj = 2;
                    break;
                }
                break;
            case 97688753:
                if (locale2.equals("fr_CA")) {
                    obj = 3;
                    break;
                }
                break;
            case 106983967:
                if (locale2.equals("pt_PT")) {
                    obj = 4;
                    break;
                }
                break;
            case 115861276:
                if (locale2.equals("zh_CN")) {
                    obj = 5;
                    break;
                }
                break;
            case 115861428:
                if (locale2.equals("zh_HK")) {
                    obj = 6;
                    break;
                }
                break;
            case 115861812:
                if (locale2.equals("zh_TW")) {
                    obj = 7;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                str = "en_GB";
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                str = "es_ES";
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                str = "fb_LS";
                break;
            case 3:
                str = "fr_CA";
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                str = "pt_PT";
                break;
            case 5:
                str = "zh_CN";
                break;
            case 6:
                str = "zh_HK";
                break;
            case 7:
                str = "zh_TW";
                break;
            default:
                str = null;
                break;
        }
        locale2 = str;
        if (locale2 == null) {
            locale2 = locale.getLanguage();
            obj = -1;
            switch (locale2.hashCode()) {
                case 3109:
                    if (locale2.equals("af")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3121:
                    if (locale2.equals("ar")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3122:
                    if (locale2.equals("as")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 3129:
                    if (locale2.equals("az")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 3139:
                    if (locale2.equals("be")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3141:
                    if (locale2.equals("bg")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 3148:
                    if (locale2.equals("bn")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 3153:
                    if (locale2.equals("bs")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 3166:
                    if (locale2.equals("ca")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 3176:
                    if (locale2.equals("ck")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 3184:
                    if (locale2.equals("cs")) {
                        obj = 10;
                        break;
                    }
                    break;
                case 3189:
                    if (locale2.equals("cx")) {
                        obj = 11;
                        break;
                    }
                    break;
                case 3190:
                    if (locale2.equals("cy")) {
                        obj = 12;
                        break;
                    }
                    break;
                case 3197:
                    if (locale2.equals("da")) {
                        obj = 13;
                        break;
                    }
                    break;
                case 3201:
                    if (locale2.equals("de")) {
                        obj = 14;
                        break;
                    }
                    break;
                case 3239:
                    if (locale2.equals("el")) {
                        obj = 15;
                        break;
                    }
                    break;
                case 3242:
                    if (locale2.equals("eo")) {
                        obj = 16;
                        break;
                    }
                    break;
                case 3246:
                    if (locale2.equals("es")) {
                        obj = 17;
                        break;
                    }
                    break;
                case 3247:
                    if (locale2.equals("et")) {
                        obj = 18;
                        break;
                    }
                    break;
                case 3248:
                    if (locale2.equals("eu")) {
                        obj = 19;
                        break;
                    }
                    break;
                case 3259:
                    if (locale2.equals("fa")) {
                        obj = 20;
                        break;
                    }
                    break;
                case 3260:
                    if (locale2.equals("fb")) {
                        obj = 21;
                        break;
                    }
                    break;
                case 3267:
                    if (locale2.equals("fi")) {
                        obj = 22;
                        break;
                    }
                    break;
                case 3273:
                    if (locale2.equals("fo")) {
                        obj = 24;
                        break;
                    }
                    break;
                case 3276:
                    if (locale2.equals("fr")) {
                        obj = 25;
                        break;
                    }
                    break;
                case 3283:
                    if (locale2.equals("fy")) {
                        obj = 26;
                        break;
                    }
                    break;
                case 3290:
                    if (locale2.equals("ga")) {
                        obj = 27;
                        break;
                    }
                    break;
                case 3301:
                    if (locale2.equals("gl")) {
                        obj = 28;
                        break;
                    }
                    break;
                case 3303:
                    if (locale2.equals("gn")) {
                        obj = 29;
                        break;
                    }
                    break;
                case 3310:
                    if (locale2.equals("gu")) {
                        obj = 30;
                        break;
                    }
                    break;
                case 3329:
                    if (locale2.equals("hi")) {
                        obj = 31;
                        break;
                    }
                    break;
                case 3338:
                    if (locale2.equals("hr")) {
                        obj = 32;
                        break;
                    }
                    break;
                case 3341:
                    if (locale2.equals("hu")) {
                        obj = 33;
                        break;
                    }
                    break;
                case 3345:
                    if (locale2.equals("hy")) {
                        obj = 34;
                        break;
                    }
                    break;
                case 3365:
                    if (locale2.equals("in")) {
                        obj = 35;
                        break;
                    }
                    break;
                case 3370:
                    if (locale2.equals("is")) {
                        obj = 36;
                        break;
                    }
                    break;
                case 3371:
                    if (locale2.equals("it")) {
                        obj = 37;
                        break;
                    }
                    break;
                case 3374:
                    if (locale2.equals("iw")) {
                        obj = 38;
                        break;
                    }
                    break;
                case 3383:
                    if (locale2.equals("ja")) {
                        obj = 39;
                        break;
                    }
                    break;
                case 3404:
                    if (locale2.equals("jv")) {
                        obj = 40;
                        break;
                    }
                    break;
                case 3414:
                    if (locale2.equals("ka")) {
                        obj = 41;
                        break;
                    }
                    break;
                case 3426:
                    if (locale2.equals("km")) {
                        obj = 42;
                        break;
                    }
                    break;
                case 3427:
                    if (locale2.equals("kn")) {
                        obj = 43;
                        break;
                    }
                    break;
                case 3428:
                    if (locale2.equals("ko")) {
                        obj = 44;
                        break;
                    }
                    break;
                case 3434:
                    if (locale2.equals("ku")) {
                        obj = 45;
                        break;
                    }
                    break;
                case 3445:
                    if (locale2.equals("la")) {
                        obj = 46;
                        break;
                    }
                    break;
                case 3466:
                    if (locale2.equals("lv")) {
                        obj = 47;
                        break;
                    }
                    break;
                case 3486:
                    if (locale2.equals("mk")) {
                        obj = 48;
                        break;
                    }
                    break;
                case 3487:
                    if (locale2.equals("ml")) {
                        obj = 49;
                        break;
                    }
                    break;
                case 3489:
                    if (locale2.equals("mn")) {
                        obj = 50;
                        break;
                    }
                    break;
                case 3493:
                    if (locale2.equals("mr")) {
                        obj = 51;
                        break;
                    }
                    break;
                case 3494:
                    if (locale2.equals("ms")) {
                        obj = 52;
                        break;
                    }
                    break;
                case 3500:
                    if (locale2.equals("my")) {
                        obj = 53;
                        break;
                    }
                    break;
                case 3508:
                    if (locale2.equals("nb")) {
                        obj = 54;
                        break;
                    }
                    break;
                case 3511:
                    if (locale2.equals("ne")) {
                        obj = 55;
                        break;
                    }
                    break;
                case 3518:
                    if (locale2.equals("nl")) {
                        obj = 56;
                        break;
                    }
                    break;
                case 3520:
                    if (locale2.equals("nn")) {
                        obj = 57;
                        break;
                    }
                    break;
                case 3555:
                    if (locale2.equals("or")) {
                        obj = 58;
                        break;
                    }
                    break;
                case 3569:
                    if (locale2.equals("pa")) {
                        obj = 59;
                        break;
                    }
                    break;
                case 3580:
                    if (locale2.equals("pl")) {
                        obj = 60;
                        break;
                    }
                    break;
                case 3587:
                    if (locale2.equals("ps")) {
                        obj = 61;
                        break;
                    }
                    break;
                case 3588:
                    if (locale2.equals("pt")) {
                        obj = 62;
                        break;
                    }
                    break;
                case 3645:
                    if (locale2.equals("ro")) {
                        obj = 63;
                        break;
                    }
                    break;
                case 3651:
                    if (locale2.equals("ru")) {
                        obj = 64;
                        break;
                    }
                    break;
                case 3653:
                    if (locale2.equals("rw")) {
                        obj = 65;
                        break;
                    }
                    break;
                case 3670:
                    if (locale2.equals("si")) {
                        obj = 66;
                        break;
                    }
                    break;
                case 3672:
                    if (locale2.equals("sk")) {
                        obj = 67;
                        break;
                    }
                    break;
                case 3673:
                    if (locale2.equals("sl")) {
                        obj = 68;
                        break;
                    }
                    break;
                case 3678:
                    if (locale2.equals("sq")) {
                        obj = 69;
                        break;
                    }
                    break;
                case 3679:
                    if (locale2.equals("sr")) {
                        obj = 70;
                        break;
                    }
                    break;
                case 3683:
                    if (locale2.equals("sv")) {
                        obj = 71;
                        break;
                    }
                    break;
                case 3684:
                    if (locale2.equals("sw")) {
                        obj = 72;
                        break;
                    }
                    break;
                case 3693:
                    if (locale2.equals("ta")) {
                        obj = 73;
                        break;
                    }
                    break;
                case 3697:
                    if (locale2.equals("te")) {
                        obj = 74;
                        break;
                    }
                    break;
                case 3700:
                    if (locale2.equals("th")) {
                        obj = 75;
                        break;
                    }
                    break;
                case 3704:
                    if (locale2.equals("tl")) {
                        obj = 76;
                        break;
                    }
                    break;
                case 3710:
                    if (locale2.equals("tr")) {
                        obj = 77;
                        break;
                    }
                    break;
                case 3734:
                    if (locale2.equals("uk")) {
                        obj = 78;
                        break;
                    }
                    break;
                case 3741:
                    if (locale2.equals("ur")) {
                        obj = 79;
                        break;
                    }
                    break;
                case 3763:
                    if (locale2.equals("vi")) {
                        obj = 80;
                        break;
                    }
                    break;
                case 3886:
                    if (locale2.equals("zh")) {
                        obj = 81;
                        break;
                    }
                    break;
                case 101385:
                    if (locale2.equals("fil")) {
                        obj = 23;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    str = "af_ZA";
                    break;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    str = "ar_AR";
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    str = "as_IN";
                    break;
                case 3:
                    str = "az_AZ";
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    str = "be_BY";
                    break;
                case 5:
                    str = "bg_BG";
                    break;
                case 6:
                    str = "bn_IN";
                    break;
                case 7:
                    str = "bs_BA";
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                    str = "ca_ES";
                    break;
                case 9:
                    str = "ck_US";
                    break;
                case 10:
                    str = "cs_CZ";
                    break;
                case 11:
                    str = "cx_PH";
                    break;
                case 12:
                    str = "cy_GB";
                    break;
                case 13:
                    str = "da_DK";
                    break;
                case 14:
                    str = "de_DE";
                    break;
                case 15:
                    str = "el_GR";
                    break;
                case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                    str = "eo_EO";
                    break;
                case 17:
                    str = "es_LA";
                    break;
                case 18:
                    str = "et_EE";
                    break;
                case 19:
                    str = "eu_ES";
                    break;
                case 20:
                    str = "fa_IR";
                    break;
                case 21:
                    str = "fb_HA";
                    break;
                case 22:
                    str = "fi_FI";
                    break;
                case 23:
                    str = "tl_PH";
                    break;
                case 24:
                    str = "fo_FO";
                    break;
                case 25:
                    str = "fr_FR";
                    break;
                case 26:
                    str = "fy_NL";
                    break;
                case 27:
                    str = "ga_IE";
                    break;
                case 28:
                    str = "gl_ES";
                    break;
                case 29:
                    str = "gn_PY";
                    break;
                case 30:
                    str = "gu_IN";
                    break;
                case 31:
                    str = "hi_IN";
                    break;
                case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                    str = "hr_HR";
                    break;
                case 33:
                    str = "hu_HU";
                    break;
                case 34:
                    str = "hy_AM";
                    break;
                case 35:
                    str = "id_ID";
                    break;
                case 36:
                    str = "is_IS";
                    break;
                case 37:
                    str = "it_IT";
                    break;
                case 38:
                    str = "he_IL";
                    break;
                case 39:
                    str = "ja_JP";
                    break;
                case 40:
                    str = "jv_ID";
                    break;
                case 41:
                    str = "ka_GE";
                    break;
                case 42:
                    str = "km_KH";
                    break;
                case 43:
                    str = "kn_IN";
                    break;
                case 44:
                    str = "ko_KR";
                    break;
                case 45:
                    str = "ku_TR";
                    break;
                case 46:
                    str = "la_VA";
                    break;
                case 47:
                    str = "lv_LV";
                    break;
                case 48:
                    str = "mk_MK";
                    break;
                case 49:
                    str = "ml_IN";
                    break;
                case 50:
                    str = "mn_MN";
                    break;
                case 51:
                    str = "mr_IN";
                    break;
                case 52:
                    str = "ms_MY";
                    break;
                case 53:
                    str = "my_MM";
                    break;
                case 54:
                    str = "nb_NO";
                    break;
                case 55:
                    str = "ne_NP";
                    break;
                case 56:
                    str = "nl_NL";
                    break;
                case 57:
                    str = "nn_NO";
                    break;
                case 58:
                    str = "or_IN";
                    break;
                case 59:
                    str = "pa_IN";
                    break;
                case 60:
                    str = "pl_PL";
                    break;
                case 61:
                    str = "ps_AF";
                    break;
                case 62:
                    str = "pt_BR";
                    break;
                case 63:
                    str = "ro_RO";
                    break;
                case HTTPTransportCallback.BODY_BYTES_GENERATED /*64*/:
                    str = "ru_RU";
                    break;
                case 65:
                    str = "rw_RW";
                    break;
                case 66:
                    str = "si_LK";
                    break;
                case 67:
                    str = "sk_SK";
                    break;
                case 68:
                    str = "sl_SI";
                    break;
                case 69:
                    str = "sq_AL";
                    break;
                case 70:
                    str = "sr_RS";
                    break;
                case 71:
                    str = "sv_SE";
                    break;
                case 72:
                    str = "sw_KE";
                    break;
                case 73:
                    str = "ta_IN";
                    break;
                case 74:
                    str = "te_IN";
                    break;
                case 75:
                    str = "th_TH";
                    break;
                case 76:
                    str = "tl_PH";
                    break;
                case 77:
                    str = "tr_TR";
                    break;
                case 78:
                    str = "uk_UA";
                    break;
                case 79:
                    str = "ur_PK";
                    break;
                case 80:
                    str = "vi_VN";
                    break;
                case 81:
                    str = "zh_CN";
                    break;
                default:
                    str = null;
                    break;
            }
            locale2 = str;
        }
        if (locale2 == null) {
            return "en_US";
        }
        return locale2;
    }
}

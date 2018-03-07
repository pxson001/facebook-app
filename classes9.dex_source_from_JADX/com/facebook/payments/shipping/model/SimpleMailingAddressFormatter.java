package com.facebook.payments.shipping.model;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: backstage_onboarding_start */
public class SimpleMailingAddressFormatter {

    /* compiled from: backstage_onboarding_start */
    public @interface FormatType {
    }

    public static String m18984a(MailingAddress mailingAddress, @FormatType String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1221322072:
                if (str.equals("%s\n%s\n%s, %s\n%s")) {
                    i = 1;
                    break;
                }
                break;
            case -382452385:
                if (str.equals("%s (%s, %s, %s, %s)")) {
                    i = 0;
                    break;
                }
                break;
            case 1600881940:
                if (str.equals("%s, %s, %s, %s")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
                return StringFormatUtil.a(str, new Object[]{mailingAddress.mo766f(), mailingAddress.mo762b(), mailingAddress.mo767g(), mailingAddress.mo764d(), mailingAddress.mo765e()});
            case 2:
                return StringFormatUtil.formatStrLocaleSafe(str, mailingAddress.mo762b(), mailingAddress.mo767g(), mailingAddress.mo764d(), mailingAddress.mo765e());
            default:
                throw new IllegalArgumentException("Unknown formatter : " + str);
        }
    }
}

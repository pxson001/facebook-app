package com.facebook.confirmation.task;

import com.facebook.common.util.StringUtil;

/* compiled from: innerBackgroundResourceId is already defined */
public class SmsCode implements Comparable<SmsCode> {
    public final String f10806a;
    public final SmsCodeType f10807b;

    public int compareTo(Object obj) {
        SmsCode smsCode = (SmsCode) obj;
        if (smsCode == null || smsCode.f10807b == null) {
            return -1;
        }
        if (this.f10807b == null) {
            return 1;
        }
        return this.f10807b.ordinal() - smsCode.f10807b.ordinal();
    }

    public SmsCode(String str, SmsCodeType smsCodeType) {
        this.f10806a = str;
        this.f10807b = smsCodeType;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SmsCode)) {
            return false;
        }
        SmsCode smsCode = (SmsCode) obj;
        if (StringUtil.a(this.f10806a, smsCode.f10806a) && this.f10807b == smsCode.f10807b) {
            return true;
        }
        return false;
    }
}

package com.facebook.messaging.sms.contacts;

import java.util.Comparator;

/* compiled from: is_cancellation */
class SmsContactsRankingHelper$1 implements Comparator<String> {
    final /* synthetic */ SmsContactsRankingHelper f12115a;

    SmsContactsRankingHelper$1(SmsContactsRankingHelper smsContactsRankingHelper) {
        this.f12115a = smsContactsRankingHelper;
    }

    public int compare(Object obj, Object obj2) {
        Double d = (Double) this.f12115a.d.get((String) obj);
        Double d2 = (Double) this.f12115a.d.get((String) obj2);
        return Double.compare(d2 != null ? d2.doubleValue() : 0.0d, d != null ? d.doubleValue() : 0.0d);
    }
}

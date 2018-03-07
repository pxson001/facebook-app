package com.facebook.confirmation.task;

/* compiled from: inner_scroll */
public class SimpleSmsMessage {
    private static final String[] f10800f = new String[]{"fb.com", "fb.me", "facebook.com", "#fb"};
    public final long f10801a;
    public final long f10802b;
    public final String f10803c;
    public final String f10804d;
    public final boolean f10805e;

    public SimpleSmsMessage(long j, String str, String str2) {
        this(0, j, str, str2);
    }

    public SimpleSmsMessage(long j, long j2, String str, String str2) {
        boolean z = false;
        this.f10801a = j;
        this.f10802b = j2;
        this.f10803c = str;
        this.f10804d = str2;
        if (str2 != null) {
            for (CharSequence contains : f10800f) {
                if (str2.contains(contains)) {
                    z = true;
                    break;
                }
            }
        }
        this.f10805e = z;
    }
}

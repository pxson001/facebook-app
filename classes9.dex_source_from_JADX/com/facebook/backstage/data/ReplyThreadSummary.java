package com.facebook.backstage.data;

import com.google.common.base.Strings;
import java.util.Date;
import javax.annotation.Nullable;

/* compiled from: resp_st */
public class ReplyThreadSummary {
    public final String f5139a;
    public final String f5140b;
    public final BackstageUser f5141c;
    public final String f5142d;
    public final Date f5143e;
    @Nullable
    public final String f5144f;

    public ReplyThreadSummary(String str, String str2, String str3, Date date, BackstageUser backstageUser, @Nullable String str4) {
        this.f5139a = str;
        this.f5142d = str2;
        this.f5141c = backstageUser;
        this.f5140b = str3;
        this.f5143e = date;
        this.f5144f = str4;
    }

    public final String m4918a() {
        return this.f5141c.f5100a;
    }

    public final boolean m4919i() {
        return !Strings.isNullOrEmpty(this.f5144f);
    }
}

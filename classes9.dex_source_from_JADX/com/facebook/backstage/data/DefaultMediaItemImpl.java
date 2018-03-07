package com.facebook.backstage.data;

import android.support.annotation.Nullable;
import com.google.common.base.Strings;

/* compiled from: rideshare_destination */
public class DefaultMediaItemImpl implements MediaItem {
    public String f4817a;
    private final String f4818b;
    private final String f4819c;
    private final boolean f4820d;
    public final TimezoneDate f4821e;

    public DefaultMediaItemImpl(String str, String str2, String str3, TimezoneDate timezoneDate) {
        this.f4818b = str;
        this.f4819c = str2;
        this.f4817a = str3;
        this.f4821e = timezoneDate;
        this.f4820d = !Strings.isNullOrEmpty(str2);
    }

    public final String mo171f() {
        return this.f4818b;
    }

    public final boolean mo172g() {
        return this.f4820d;
    }

    @Nullable
    public final String mo173h() {
        return this.f4817a;
    }

    public final String mo174i() {
        return this.f4819c;
    }

    public final TimezoneDate m4712j() {
        return this.f4821e;
    }
}

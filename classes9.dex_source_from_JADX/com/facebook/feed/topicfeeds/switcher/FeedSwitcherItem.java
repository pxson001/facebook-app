package com.facebook.feed.topicfeeds.switcher;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

/* compiled from: TT;) */
public abstract class FeedSwitcherItem {
    @DrawableRes
    public int f24533a;
    public String f24534b;
    public String f24535c;

    public abstract Fragment mo1155d();

    public FeedSwitcherItem(String str, String str2) {
        this(str, str2, 0);
    }

    public FeedSwitcherItem(String str, String str2, int i) {
        this.f24534b = str;
        this.f24535c = str2;
        this.f24533a = i;
    }

    public String toString() {
        return "(" + this.f24534b + ": " + this.f24535c + ")";
    }
}

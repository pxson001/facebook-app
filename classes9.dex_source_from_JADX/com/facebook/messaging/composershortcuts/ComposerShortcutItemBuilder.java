package com.facebook.messaging.composershortcuts;

import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import com.facebook.common.util.TriState;
import com.google.common.base.Preconditions;

/* compiled from: messenger_ads_message_seen_thread */
public class ComposerShortcutItemBuilder {
    public double f9991a = ComposerShortcutItem.f9972a;
    public String f9992b;
    public int f9993c;
    public int f9994d;
    public String f9995e;
    public Drawable f9996f;
    public String f9997g;
    public String f9998h;
    public String f9999i;
    public boolean f10000j;
    public boolean f10001k;
    public TriState f10002l = TriState.UNSET;
    public long f10003m;
    public long f10004n;
    public boolean f10005o;
    public int f10006p;
    public boolean f10007q;
    public int[] f10008r;

    public final ComposerShortcutItemBuilder m10520a(ComposerShortcutItem composerShortcutItem) {
        this.f9992b = composerShortcutItem.f9973b;
        this.f9993c = composerShortcutItem.f9974c;
        this.f9994d = composerShortcutItem.f9975d;
        this.f9995e = composerShortcutItem.f9976e;
        this.f9996f = composerShortcutItem.f9977f;
        this.f9997g = composerShortcutItem.f9978g;
        this.f9998h = composerShortcutItem.f9979h;
        this.f9999i = composerShortcutItem.f9980i;
        this.f10000j = composerShortcutItem.f9981j;
        this.f10001k = composerShortcutItem.f9982k;
        this.f10002l = composerShortcutItem.f9983l;
        this.f10003m = composerShortcutItem.f9984m;
        this.f9991a = composerShortcutItem.f9985n;
        this.f10004n = composerShortcutItem.f9986o;
        this.f10005o = composerShortcutItem.f9987p;
        this.f10006p = composerShortcutItem.f9988q;
        this.f10007q = composerShortcutItem.f9989r;
        this.f10008r = composerShortcutItem.f9990s;
        return this;
    }

    public final ComposerShortcutItemBuilder m10521a(String str) {
        this.f9992b = str;
        return this;
    }

    public final ComposerShortcutItemBuilder m10518a(int i) {
        this.f9993c = i;
        return this;
    }

    public final ComposerShortcutItemBuilder m10523b(int i) {
        this.f9994d = i;
        return this;
    }

    public final ComposerShortcutItemBuilder m10526c(String str) {
        this.f9997g = str;
        return this;
    }

    public final ComposerShortcutItemBuilder m10522a(boolean z) {
        this.f10000j = z;
        return this;
    }

    public final ComposerShortcutItemBuilder m10517a(double d) {
        this.f9991a = d;
        return this;
    }

    public final ComposerShortcutItemBuilder m10524b(boolean z) {
        this.f10005o = z;
        return this;
    }

    public final ComposerShortcutItemBuilder m10525c(int i) {
        this.f10006p = i;
        return this;
    }

    public final ComposerShortcutItemBuilder m10527d(@LayoutRes int i) {
        this.f10008r = i == 0 ? null : new int[]{i};
        return this;
    }

    public final ComposerShortcutItemBuilder m10519a(@LayoutRes int i, @LayoutRes int i2) {
        boolean z;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f10008r = new int[]{i, i2};
        return this;
    }

    public final ComposerShortcutItem m10528s() {
        return new ComposerShortcutItem(this);
    }
}

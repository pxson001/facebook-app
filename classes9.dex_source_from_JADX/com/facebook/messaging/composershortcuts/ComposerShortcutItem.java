package com.facebook.messaging.composershortcuts;

import android.graphics.drawable.Drawable;
import com.facebook.common.util.TriState;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: messenger_basketball */
public class ComposerShortcutItem {
    public static double f9972a = -1.0d;
    public final String f9973b;
    public final int f9974c;
    public final int f9975d;
    public final String f9976e;
    public final Drawable f9977f;
    public final String f9978g;
    public final String f9979h;
    public final String f9980i;
    public final boolean f9981j;
    public final boolean f9982k;
    public final TriState f9983l;
    public final long f9984m;
    public final double f9985n;
    public final long f9986o;
    public final boolean f9987p;
    public int f9988q;
    public final boolean f9989r;
    public final int[] f9990s;

    ComposerShortcutItem(ComposerShortcutItemBuilder composerShortcutItemBuilder) {
        boolean z;
        this.f9973b = composerShortcutItemBuilder.f9992b;
        this.f9974c = composerShortcutItemBuilder.f9993c;
        this.f9975d = composerShortcutItemBuilder.f9994d;
        this.f9976e = composerShortcutItemBuilder.f9995e;
        this.f9977f = composerShortcutItemBuilder.f9996f;
        this.f9978g = composerShortcutItemBuilder.f9997g;
        this.f9979h = composerShortcutItemBuilder.f9998h;
        this.f9980i = composerShortcutItemBuilder.f9999i;
        this.f9981j = composerShortcutItemBuilder.f10000j;
        if (this.f9981j || composerShortcutItemBuilder.f10001k) {
            z = true;
        } else {
            z = false;
        }
        this.f9982k = z;
        this.f9983l = composerShortcutItemBuilder.f10002l;
        this.f9984m = composerShortcutItemBuilder.f10003m;
        this.f9985n = composerShortcutItemBuilder.f9991a;
        this.f9986o = composerShortcutItemBuilder.f10004n;
        this.f9987p = composerShortcutItemBuilder.f10005o;
        this.f9988q = composerShortcutItemBuilder.f10006p;
        this.f9989r = composerShortcutItemBuilder.f10007q;
        this.f9990s = composerShortcutItemBuilder.f10008r;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ComposerShortcutItem)) {
            return false;
        }
        ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) obj;
        if (Objects.equal(this.f9973b, composerShortcutItem.f9973b) && this.f9974c == composerShortcutItem.f9974c && this.f9975d == composerShortcutItem.f9975d && Objects.equal(this.f9976e, composerShortcutItem.f9976e) && Objects.equal(this.f9977f, composerShortcutItem.f9977f) && Objects.equal(this.f9978g, composerShortcutItem.f9978g) && Objects.equal(this.f9979h, composerShortcutItem.f9979h) && Objects.equal(this.f9980i, composerShortcutItem.f9980i) && this.f9981j == composerShortcutItem.f9981j && this.f9982k == composerShortcutItem.f9982k && Objects.equal(this.f9983l, composerShortcutItem.f9983l) && this.f9984m == composerShortcutItem.f9984m && this.f9985n == composerShortcutItem.f9985n && this.f9986o == composerShortcutItem.f9986o && this.f9987p == composerShortcutItem.f9987p && Objects.equal(Boolean.valueOf(this.f9989r), Boolean.valueOf(composerShortcutItem.f9989r)) && this.f9990s == composerShortcutItem.f9990s) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f9973b, Integer.valueOf(this.f9974c), this.f9976e, this.f9977f, this.f9978g, this.f9979h, this.f9980i, Boolean.valueOf(this.f9981j), Boolean.valueOf(this.f9982k), this.f9983l, Long.valueOf(this.f9984m), Double.valueOf(this.f9985n), Long.valueOf(this.f9986o), Boolean.valueOf(this.f9987p), Boolean.valueOf(this.f9989r), this.f9990s});
    }

    public static ComposerShortcutItemBuilder newBuilder() {
        return new ComposerShortcutItemBuilder();
    }
}

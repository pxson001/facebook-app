package com.facebook.widget;

import android.view.View;
import java.util.Comparator;

/* compiled from: com.google.android.gms.signin.internal.realClientPackageName */
class CustomViewPager$1 implements Comparator<View> {
    final /* synthetic */ CustomViewPager f5601a;

    CustomViewPager$1(CustomViewPager customViewPager) {
        this.f5601a = customViewPager;
    }

    public int compare(Object obj, Object obj2) {
        return ((View) obj).getLeft() - ((View) obj2).getLeft();
    }
}

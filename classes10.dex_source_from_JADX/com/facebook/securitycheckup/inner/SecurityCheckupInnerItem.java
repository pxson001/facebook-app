package com.facebook.securitycheckup.inner;

import android.net.Uri;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: image_prefetch */
public class SecurityCheckupInnerItem {
    public Optional<Integer> f9775a;
    public Optional<Uri> f9776b;
    public final String f9777c;
    public final String f9778d;
    public boolean f9779e;
    public String f9780f;

    public static SecurityCheckupInnerItem m10011a(int i, String str, String str2) {
        SecurityCheckupInnerItem securityCheckupInnerItem = new SecurityCheckupInnerItem(str, str2);
        securityCheckupInnerItem.f9775a = Optional.of(Integer.valueOf(i));
        securityCheckupInnerItem.f9776b = Absent.INSTANCE;
        return securityCheckupInnerItem;
    }

    public static SecurityCheckupInnerItem m10012a(Uri uri, String str, String str2) {
        SecurityCheckupInnerItem securityCheckupInnerItem = new SecurityCheckupInnerItem(str, str2);
        securityCheckupInnerItem.f9776b = Optional.of(uri);
        securityCheckupInnerItem.f9775a = Absent.INSTANCE;
        return securityCheckupInnerItem;
    }

    private SecurityCheckupInnerItem(String str, String str2) {
        this.f9777c = str;
        this.f9778d = str2;
    }
}

package com.facebook.tigon.httpclientadapter;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.tigon.tigonapi.TigonError;
import java.io.IOException;

/* compiled from: notifications_count */
class TigonErrorException extends IOException {
    public final TigonError tigonError;

    public TigonErrorException(TigonError tigonError) {
        int i;
        if (tigonError.f5033d == null || tigonError.f5033d.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        String str = "TigonError(%d): %s(%d)%s%s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(tigonError.f5030a);
        objArr[1] = tigonError.f5031b;
        objArr[2] = Integer.valueOf(tigonError.f5032c);
        objArr[3] = i != 0 ? " " : "";
        objArr[4] = i != 0 ? tigonError.f5033d : "";
        super(StringFormatUtil.a(str, objArr));
        this.tigonError = tigonError;
    }
}

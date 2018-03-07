package com.facebook.payments.picker.model;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: battery_health */
public class HeaderRowItem implements RowItem {
    public final String f18885a;

    public HeaderRowItem(String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f18885a = str;
    }

    public final RowType mo657a() {
        return RowType.HEADER;
    }
}

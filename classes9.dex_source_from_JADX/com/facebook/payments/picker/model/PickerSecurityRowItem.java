package com.facebook.payments.picker.model;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: battery */
public class PickerSecurityRowItem implements RowItem {
    public final String f18886a;

    public PickerSecurityRowItem(String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f18886a = str;
    }

    public final RowType mo657a() {
        return RowType.SECURITY_FOOTER;
    }
}

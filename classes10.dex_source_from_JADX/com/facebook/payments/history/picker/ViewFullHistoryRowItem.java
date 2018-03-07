package com.facebook.payments.history.picker;

import android.content.Intent;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import javax.annotation.Nullable;

/* compiled from: login_recoverable */
public class ViewFullHistoryRowItem implements RowItem {
    @Nullable
    public final Intent f8416a;
    @Nullable
    public final int f8417b;

    public ViewFullHistoryRowItem(Intent intent, int i) {
        this.f8416a = intent;
        this.f8417b = i;
    }

    public final RowType m8345a() {
        return RowType.VIEW_FULL_HISTORY;
    }
}

package com.facebook.messaging.threadview.rows;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: plutonium_cover_photo */
public class RowMontageStatusItem implements RowItem {
    @Nullable
    public final ThreadKey f4756a;
    public final User f4757b;

    public RowMontageStatusItem(User user, ThreadKey threadKey) {
        this.f4757b = (User) Preconditions.checkNotNull(user);
        this.f4756a = threadKey;
    }

    public final RowType mo131b() {
        return RowType.MONTAGE_STATUS;
    }

    public final long m4315a() {
        return Long.MIN_VALUE;
    }
}

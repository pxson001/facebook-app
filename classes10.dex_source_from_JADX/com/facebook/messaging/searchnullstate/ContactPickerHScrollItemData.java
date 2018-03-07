package com.facebook.messaging.searchnullstate;

import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: refresher_configuration */
public class ContactPickerHScrollItemData {
    @Nullable
    public final User f3816a;
    @Nullable
    public final ThreadSummary f3817b;
    public final DataSource f3818c;

    /* compiled from: refresher_configuration */
    public enum DataSource {
        TOP_FRIENDS,
        GROUP_THREADS,
        BYMM,
        BOTS
    }

    public ContactPickerHScrollItemData(User user, DataSource dataSource) {
        this.f3816a = user;
        this.f3817b = null;
        this.f3818c = dataSource;
    }

    public ContactPickerHScrollItemData(ThreadSummary threadSummary, DataSource dataSource) {
        this.f3816a = null;
        this.f3817b = threadSummary;
        this.f3818c = dataSource;
    }
}

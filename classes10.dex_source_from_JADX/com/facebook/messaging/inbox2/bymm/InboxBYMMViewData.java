package com.facebook.messaging.inbox2.bymm;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: setUpSingleEmailSuggestionView() requires exactly 1 Google account */
public class InboxBYMMViewData {
    public final ImmutableList<InboxBusinessYouMayMessage> f2690a;

    public InboxBYMMViewData(ImmutableList<InboxBusinessYouMayMessage> immutableList) {
        this.f2690a = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }
}

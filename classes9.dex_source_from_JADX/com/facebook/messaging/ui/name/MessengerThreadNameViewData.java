package com.facebook.messaging.ui.name;

import com.facebook.messaging.model.messages.ParticipantInfo;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: checkout_data */
public class MessengerThreadNameViewData extends ThreadNameViewData {
    public final ParticipantInfo f18236a;
    private final long f18237b;

    public MessengerThreadNameViewData(boolean z, @Nullable String str, ImmutableList<String> immutableList, @Nullable ParticipantInfo participantInfo, long j) {
        super(z, str, immutableList);
        this.f18236a = participantInfo;
        this.f18237b = j;
    }

    public final long m18193b() {
        return this.f18236a != null ? this.f18237b : -1;
    }
}

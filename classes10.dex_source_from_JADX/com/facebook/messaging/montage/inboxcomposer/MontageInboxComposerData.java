package com.facebook.messaging.montage.inboxcomposer;

import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: save_image */
public class MontageInboxComposerData {
    public final ThreadKey f3294a;
    @Nullable
    public final ImmutableList<UserKey> f3295b;
    @Nullable
    public final Message f3296c;

    public MontageInboxComposerData(ThreadKey threadKey, @Nullable ImmutableList<UserKey> immutableList, @Nullable Message message) {
        this.f3294a = threadKey;
        this.f3295b = immutableList;
        this.f3296c = message;
    }
}

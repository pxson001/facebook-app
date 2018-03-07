package com.facebook.messaging.montage.model;

import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Preconditions;

/* compiled from: is_hard_nag */
public class MontageThreadInfo {
    public final ThreadSummary f12560a;
    public final MessagesCollection f12561b;

    public MontageThreadInfo(ThreadSummary threadSummary, MessagesCollection messagesCollection) {
        this.f12560a = (ThreadSummary) Preconditions.checkNotNull(threadSummary);
        this.f12561b = (MessagesCollection) Preconditions.checkNotNull(messagesCollection);
    }
}

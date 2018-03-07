package com.facebook.orca.notify;

import com.facebook.messaging.model.messages.Message;
import com.google.common.collect.Lists;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: news_feed_qp */
public class ThreadSystemTrayMessageList {
    public final LinkedList<Message> f6276a = Lists.b();
    public long f6277b;

    ThreadSystemTrayMessageList() {
    }

    final void m5963a(Message message) {
        if (this.f6276a.size() == 7) {
            m5965c();
        }
        this.f6276a.add(message);
        this.f6277b = message.c;
    }

    final int m5964b() {
        return this.f6276a.size();
    }

    final void m5965c() {
        this.f6276a.removeFirst();
    }
}

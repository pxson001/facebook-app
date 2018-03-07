package com.facebook.react.bridge.queue;

import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: get_background_color */
public class MessageQueueThreadRegistry {
    private static ThreadLocal<MessageQueueThread> f11563a = new ThreadLocal();

    static void m13570a(MessageQueueThread messageQueueThread) {
        messageQueueThread.assertIsOnThread();
        f11563a.set(messageQueueThread);
    }

    @DoNotStrip
    public static MessageQueueThread myMessageQueueThread() {
        return (MessageQueueThread) Assertions.a(f11563a.get(), "This thread doesn't have a MessageQueueThread registered to it!");
    }
}

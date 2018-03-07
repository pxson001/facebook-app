package com.facebook.messaging.cache;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: messenger_video_edit */
public class ThreadSummaryUtil {
    public static final Function<ThreadSummary, ThreadKey> f9579a = new C11151();

    /* compiled from: messenger_video_edit */
    final class C11151 implements Function<ThreadSummary, ThreadKey> {
        C11151() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            if (threadSummary == null) {
                return null;
            }
            return threadSummary.a;
        }
    }
}

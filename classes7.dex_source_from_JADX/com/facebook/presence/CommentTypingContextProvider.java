package com.facebook.presence;

import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: impression_info */
public class CommentTypingContextProvider extends AbstractAssistedProvider<CommentTypingContext> {
    public final CommentTypingContext m13081a(String str) {
        return new CommentTypingContext(new CommentTypingManager(IdBasedLazy.a(this, 2164), (QeAccessor) QeInternalImplMethodAutoProvider.a(this)), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this), str);
    }
}

package com.facebook.messaging.users.refresh;

import com.facebook.backgroundtasks.BackgroundResult;
import java.util.concurrent.Callable;

/* compiled from: chat_head_nux_message_button */
class DefaultMessagesRefreshUserInfoBackgroundTask$1 implements Callable<BackgroundResult> {
    final /* synthetic */ DefaultMessagesRefreshUserInfoBackgroundTask f18322a;

    DefaultMessagesRefreshUserInfoBackgroundTask$1(DefaultMessagesRefreshUserInfoBackgroundTask defaultMessagesRefreshUserInfoBackgroundTask) {
        this.f18322a = defaultMessagesRefreshUserInfoBackgroundTask;
    }

    public Object call() {
        try {
            ((MessagesUserInfoRefresher) this.f18322a.h.get()).m18280a();
            return new BackgroundResult(true);
        } catch (Exception e) {
            return new BackgroundResult(false);
        }
    }
}

package com.facebook.messaging.inbox2.sharing;

import com.facebook.messaging.send.common.SendResult;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: mPymk */
public interface UserSelectionListener {
    void mo433a();

    void mo434a(User user, FutureCallback<SendResult> futureCallback);
}

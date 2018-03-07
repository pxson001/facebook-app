package com.facebook.messaging.inbox2.recents;

import com.facebook.messaging.send.common.SendResult;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: selfupdate_skip_oxygen_download */
public interface InboxRecentItemsListener {
    void mo89a(InboxRecentItem inboxRecentItem);

    void mo90a(InboxRecentItem inboxRecentItem, User user, FutureCallback<SendResult> futureCallback);

    void mo91a(InboxRecentItem inboxRecentItem, String str, @Nullable Map<String, String> map);

    boolean mo92b(InboxRecentItem inboxRecentItem);
}

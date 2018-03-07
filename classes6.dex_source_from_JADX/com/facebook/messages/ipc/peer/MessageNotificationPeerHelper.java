package com.facebook.messages.ipc.peer;

import android.net.Uri;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import java.util.Set;

/* compiled from: vipAddr */
public class MessageNotificationPeerHelper {
    public static int m384a(ThreadKey threadKey, String str, StatefulPeerManagerImpl statefulPeerManagerImpl) {
        Set set = (Set) statefulPeerManagerImpl.a(MessageNotificationPeerContract.b(threadKey));
        if (set == null) {
            return 1;
        }
        return set.contains(str) ? set.size() : set.size() + 1;
    }

    public static void m386b(ThreadKey threadKey, String str, StatefulPeerManagerImpl statefulPeerManagerImpl) {
        statefulPeerManagerImpl.a(MessageNotificationPeerContract.b(threadKey), str);
    }

    public static void m385a(ThreadKey threadKey, StatefulPeerManagerImpl statefulPeerManagerImpl) {
        statefulPeerManagerImpl.a(Uri.parse("peer://msg_notification_unread_count/clear_thread/" + Uri.encode(threadKey.toString())), null);
    }
}

package com.facebook.multiprocess.peer;

import android.os.Message;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.init.INeedInit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: time_last_media_prompt_seen */
public interface PeerProcessManager extends IHaveUserData, INeedInit {
    PeerInfo mo682a();

    void mo683a(int i, PeerProcessMessageListener peerProcessMessageListener);

    void mo684a(Message message);

    void mo685a(PeerInfo peerInfo, Message message);

    void mo686a(PeerProcessStatusListener peerProcessStatusListener);
}

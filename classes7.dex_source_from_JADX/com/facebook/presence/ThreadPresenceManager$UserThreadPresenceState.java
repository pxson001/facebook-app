package com.facebook.presence;

import com.facebook.user.model.UserKey;
import com.google.common.collect.Maps;
import java.util.concurrent.ConcurrentMap;

/* compiled from: image_block_image */
public class ThreadPresenceManager$UserThreadPresenceState {
    volatile UserKey f11201a;
    volatile ConcurrentMap<String, ThreadPresenceManager$ThreadPresenceState> f11202b = Maps.e();
}

package com.facebook.sync.connection;

import com.facebook.sync.model.IrisQueueTypes;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* compiled from: feedback_comments */
public class SyncConnectionStateManager$QueueKey {
    final String f14479a;
    final IrisQueueTypes f14480b;

    public static SyncConnectionStateManager$QueueKey m18363a(String str, IrisQueueTypes irisQueueTypes) {
        if (Strings.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("queueEntityId cannot be null nor empty");
        } else if (irisQueueTypes != null) {
            return new SyncConnectionStateManager$QueueKey(str, irisQueueTypes);
        } else {
            throw new IllegalArgumentException("queueType cannot be null");
        }
    }

    private SyncConnectionStateManager$QueueKey(String str, IrisQueueTypes irisQueueTypes) {
        this.f14479a = (String) Preconditions.checkNotNull(str);
        this.f14480b = (IrisQueueTypes) Preconditions.checkNotNull(irisQueueTypes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncConnectionStateManager$QueueKey)) {
            return false;
        }
        SyncConnectionStateManager$QueueKey syncConnectionStateManager$QueueKey = (SyncConnectionStateManager$QueueKey) obj;
        if (this.f14479a.equals(syncConnectionStateManager$QueueKey.f14479a) && this.f14480b == syncConnectionStateManager$QueueKey.f14480b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f14479a.hashCode() + 527) * 31) + this.f14480b.hashCode();
    }

    public String toString() {
        return String.format("id:%s, type:%s", new Object[]{this.f14479a, this.f14480b.name()});
    }
}

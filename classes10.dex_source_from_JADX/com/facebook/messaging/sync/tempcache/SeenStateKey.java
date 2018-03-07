package com.facebook.messaging.sync.tempcache;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: postId */
public class SeenStateKey {
    public final ThreadKey f4678a;
    public final String f4679b;

    public SeenStateKey(ThreadKey threadKey, String str) {
        this.f4678a = (ThreadKey) Preconditions.checkNotNull(threadKey);
        this.f4679b = (String) Preconditions.checkNotNull(str);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f4678a, this.f4679b});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SeenStateKey seenStateKey = (SeenStateKey) obj;
        if (!this.f4678a.equals(seenStateKey.f4678a)) {
            return false;
        }
        if (this.f4679b.equals(seenStateKey.f4679b)) {
            return true;
        }
        return false;
    }
}

package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: free_bytes */
public enum RemovalCause {
    EXPLICIT {
        final boolean wasEvicted() {
            return false;
        }
    },
    REPLACED {
        final boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED {
        final boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED {
        final boolean wasEvicted() {
            return true;
        }
    },
    SIZE {
        final boolean wasEvicted() {
            return true;
        }
    };

    abstract boolean wasEvicted();
}

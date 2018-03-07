package com.facebook.ui.typeahead;

/* compiled from: createView() shall not return null value! */
public enum FetchSource {
    UNSET,
    MEMORY_CACHE,
    LOCAL,
    REMOTE,
    REMOTE_ENTITY,
    REMOTE_KEYWORD,
    NULL_STATE;

    public final boolean isRemote() {
        return this == REMOTE || this == REMOTE_ENTITY || this == REMOTE_KEYWORD;
    }
}

package com.facebook.ui.media.cache;

import java.util.List;

/* compiled from: offline_mode_operation_retry_limit_reached */
public interface PartialFileStorage<Key> {
    PartialFile<Key> mo2147a(Key key, FileMetadata fileMetadata);

    List<Key> mo2148a();

    void mo2149a(Key key);

    PartialFile<Key> mo2150b(Key key);
}

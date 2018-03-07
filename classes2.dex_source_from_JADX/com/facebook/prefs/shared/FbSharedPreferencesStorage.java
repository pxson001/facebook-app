package com.facebook.prefs.shared;

import com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.bookmark */
public interface FbSharedPreferencesStorage {
    void mo315a(Map<PrefKey, Object> map);

    void mo316a(Map<PrefKey, Object> map, Collection<PrefKey> collection);
}

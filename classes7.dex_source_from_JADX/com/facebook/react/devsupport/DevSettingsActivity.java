package com.facebook.react.devsupport;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: gallery_fetcher_rule */
public class DevSettingsActivity extends PreferenceActivity {
    public void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 119104746);
        super.onCreate(bundle);
        setTitle(2131238201);
        addPreferencesFromResource(2131099653);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1299475090, a);
    }
}

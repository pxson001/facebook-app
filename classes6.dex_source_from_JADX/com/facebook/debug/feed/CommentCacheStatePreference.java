package com.facebook.debug.feed;

import android.content.Context;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: open_draft_dialog */
public class CommentCacheStatePreference extends CheckBoxOrSwitchPreference {
    public CommentCacheStatePreference(Context context) {
        super(context);
        a(FeedPrefKeys.y);
        setTitle("Show comment cache status");
        setSummary("Show whether comments are cached or not for a story");
    }
}

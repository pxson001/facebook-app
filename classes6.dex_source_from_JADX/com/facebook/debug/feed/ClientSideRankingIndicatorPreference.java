package com.facebook.debug.feed;

import android.content.Context;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: open_link_by_image */
public class ClientSideRankingIndicatorPreference extends CheckBoxOrSwitchPreference {
    public ClientSideRankingIndicatorPreference(Context context) {
        super(context);
        a(FeedPrefKeys.x);
        setTitle("Client rerank bump indicator");
        setSummary("Indicates a client side rerank bump by showing an up arrow in story header.");
    }
}

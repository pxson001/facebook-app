package com.facebook.feed.module;

import android.content.Context;
import android.preference.Preference;
import com.facebook.feed.prefs.NativeFeedPreferences;
import com.facebook.prefs.provider.IProvidePreferences;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: album_position */
final class NewsFeedModule$1 implements IProvidePreferences {
    NewsFeedModule$1() {
    }

    public final List<Preference> m22857a(Context context) {
        List<Preference> b = Lists.b();
        b.add(new NativeFeedPreferences(context));
        return b;
    }
}

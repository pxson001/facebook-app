package com.facebook.timeline.header;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;

/* compiled from: friend_list_mutual_friends_seen */
public class TimelineHeaderTopAdapterProvider extends AbstractAssistedProvider<TimelineHeaderTopAdapter> {
    public final TimelineHeaderTopAdapter m11482a(Context context, TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData, boolean z) {
        return new TimelineHeaderTopAdapter(context, timelineUserContext, timelineHeaderUserData, z, (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedLazy.a(this, 11245), ManageInterstitialHelper.m11395b(this), SeeFirstInterstitialHelper.m11405b(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}

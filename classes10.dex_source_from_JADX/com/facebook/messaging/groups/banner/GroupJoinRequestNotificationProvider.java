package com.facebook.messaging.groups.banner;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: sideloading_diode_screen_download_button_on_click */
public class GroupJoinRequestNotificationProvider extends AbstractAssistedProvider<GroupJoinRequestNotification> {
    public final GroupJoinRequestNotification m2358a(Context context) {
        return new GroupJoinRequestNotification(context, new GroupBannerPreferences((FbSharedPreferences) FbSharedPreferencesImpl.a(this), (Clock) SystemClockMethodAutoProvider.a(this)), GroupAdminController.m2341b(this));
    }
}

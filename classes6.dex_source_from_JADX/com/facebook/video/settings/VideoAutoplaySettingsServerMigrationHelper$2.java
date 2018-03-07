package com.facebook.video.settings;

import com.facebook.graphql.enums.GraphQLAutoplaySettingEffective;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.video.settings.graphql.AutoplaySettingsMutationsModels.DeviceAutoplaySettingUpdateModel;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.model.internal.IMarkerDelegate */
class VideoAutoplaySettingsServerMigrationHelper$2 implements FutureCallback<DeviceAutoplaySettingUpdateModel> {
    final /* synthetic */ AutoPlaySettingValue f19623a;
    final /* synthetic */ FbSharedPreferences f19624b;
    final /* synthetic */ VideoAutoplaySettingsServerMigrationHelper f19625c;

    VideoAutoplaySettingsServerMigrationHelper$2(VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper, AutoPlaySettingValue autoPlaySettingValue, FbSharedPreferences fbSharedPreferences) {
        this.f19625c = videoAutoplaySettingsServerMigrationHelper;
        this.f19623a = autoPlaySettingValue;
        this.f19624b = fbSharedPreferences;
    }

    public void onSuccess(@Nullable Object obj) {
        DeviceAutoplaySettingUpdateModel deviceAutoplaySettingUpdateModel = (DeviceAutoplaySettingUpdateModel) obj;
        this.f19625c.b.c.a(ImmutableSet.of("AUTOPLAY_SETTING_READ_QUERY"));
        this.f19625c.e = this.f19623a;
        VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper = this.f19625c;
        FbSharedPreferences fbSharedPreferences = this.f19624b;
        GraphQLAutoplaySettingEffective a = deviceAutoplaySettingUpdateModel.m28366a().m28359a();
        boolean j = deviceAutoplaySettingUpdateModel.m28366a().m28362j();
        boolean z = false;
        boolean asBoolean = VideoAutoPlayListPreferenceSettings.b(fbSharedPreferences).asBoolean(false);
        AutoPlaySettingValue a2 = VideoAutoplaySettingsServerMigrationHelper.a(a);
        if (!asBoolean) {
            videoAutoplaySettingsServerMigrationHelper.e = a2;
            VideoAutoPlayListPreferenceSettings.a(fbSharedPreferences, videoAutoplaySettingsServerMigrationHelper.e);
            if (!j) {
                z = true;
            }
            VideoAutoPlayListPreferenceSettings.a(fbSharedPreferences, z);
        } else if (asBoolean && videoAutoplaySettingsServerMigrationHelper.e != a2) {
            videoAutoplaySettingsServerMigrationHelper.c.a(VideoAutoplaySettingsServerMigrationHelper.a, "Server outcome did not match the request. Sent " + videoAutoplaySettingsServerMigrationHelper.e + " received " + a2);
        }
    }

    public void onFailure(Throwable th) {
        this.f19625c.a("Failed to write the client autoplay setting to the server.", th);
    }
}

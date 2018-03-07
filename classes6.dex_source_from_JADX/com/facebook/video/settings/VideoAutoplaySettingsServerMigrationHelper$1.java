package com.facebook.video.settings;

import com.facebook.graphql.calls.DeviceAutoplaySettingUpdateInputData.UpdateType;
import com.facebook.graphql.enums.GraphQLAutoplaySettingEffective;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQLModels.ViewerQueryModel.DeviceAutoplaySettingModel;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQLModels.ViewerQueryModel.DeviceAutoplaySettingModel.NodesModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.model.internal.IMarkerDelegate */
public class VideoAutoplaySettingsServerMigrationHelper$1 implements FutureCallback<DeviceAutoplaySettingModel> {
    final /* synthetic */ FbSharedPreferences f19621a;
    final /* synthetic */ VideoAutoplaySettingsServerMigrationHelper f19622b;

    public VideoAutoplaySettingsServerMigrationHelper$1(VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper, FbSharedPreferences fbSharedPreferences) {
        this.f19622b = videoAutoplaySettingsServerMigrationHelper;
        this.f19621a = fbSharedPreferences;
    }

    public void onSuccess(@Nullable Object obj) {
        DeviceAutoplaySettingModel deviceAutoplaySettingModel = (DeviceAutoplaySettingModel) obj;
        if (deviceAutoplaySettingModel.m28343a().size() == 1) {
            NodesModel nodesModel = (NodesModel) deviceAutoplaySettingModel.m28343a().get(0);
            VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper = this.f19622b;
            FbSharedPreferences fbSharedPreferences = this.f19621a;
            GraphQLAutoplaySettingEffective a = nodesModel.m28336a();
            boolean j = nodesModel.m28339j();
            boolean z = false;
            boolean asBoolean = VideoAutoPlayListPreferenceSettings.b(fbSharedPreferences).asBoolean(false);
            AutoPlaySettingValue a2 = VideoAutoplaySettingsServerMigrationHelper.a(a);
            if (!asBoolean) {
                if (videoAutoplaySettingsServerMigrationHelper.e != a2 && j) {
                    VideoAutoPlayListPreferenceSettings.b(fbSharedPreferences, videoAutoplaySettingsServerMigrationHelper.e);
                }
                videoAutoplaySettingsServerMigrationHelper.e = a2;
                VideoAutoPlayListPreferenceSettings.a(fbSharedPreferences, videoAutoplaySettingsServerMigrationHelper.e);
                if (!j) {
                    z = true;
                }
                VideoAutoPlayListPreferenceSettings.a(fbSharedPreferences, z);
            } else if (asBoolean && videoAutoplaySettingsServerMigrationHelper.e != a2) {
                videoAutoplaySettingsServerMigrationHelper.a(fbSharedPreferences, videoAutoplaySettingsServerMigrationHelper.e, UpdateType.SETTING_CHANGE);
            }
        } else if (deviceAutoplaySettingModel.m28343a().isEmpty()) {
            this.f19622b.a(this.f19621a, this.f19622b.e, UpdateType.MIGRATION);
        }
    }

    public void onFailure(Throwable th) {
        this.f19622b.a("Failed to read the client autoplay setting from the server.", th);
    }
}

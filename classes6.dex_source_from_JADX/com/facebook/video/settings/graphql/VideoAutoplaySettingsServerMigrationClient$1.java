package com.facebook.video.settings.graphql;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.settings.graphql.AutoplaySettingsMutationsModels.DeviceAutoplaySettingUpdateModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate */
public class VideoAutoplaySettingsServerMigrationClient$1 implements Function<GraphQLResult<DeviceAutoplaySettingUpdateModel>, DeviceAutoplaySettingUpdateModel> {
    final /* synthetic */ VideoAutoplaySettingsServerMigrationClient f19636a;

    public VideoAutoplaySettingsServerMigrationClient$1(VideoAutoplaySettingsServerMigrationClient videoAutoplaySettingsServerMigrationClient) {
        this.f19636a = videoAutoplaySettingsServerMigrationClient;
    }

    public Object apply(@Nullable Object obj) {
        return (DeviceAutoplaySettingUpdateModel) ((GraphQLResult) obj).e;
    }
}

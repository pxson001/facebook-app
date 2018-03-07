package com.facebook.video.settings.graphql;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQLModels.ViewerQueryModel;
import com.facebook.video.settings.graphql.AutoplaySettingsGraphQLModels.ViewerQueryModel.DeviceAutoplaySettingModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate */
public class VideoAutoplaySettingsServerMigrationClient$2 implements Function<GraphQLResult<ViewerQueryModel>, DeviceAutoplaySettingModel> {
    final /* synthetic */ VideoAutoplaySettingsServerMigrationClient f19637a;

    public VideoAutoplaySettingsServerMigrationClient$2(VideoAutoplaySettingsServerMigrationClient videoAutoplaySettingsServerMigrationClient) {
        this.f19637a = videoAutoplaySettingsServerMigrationClient;
    }

    public Object apply(@Nullable Object obj) {
        return ((ViewerQueryModel) ((GraphQLResult) obj).e).m28347a();
    }
}

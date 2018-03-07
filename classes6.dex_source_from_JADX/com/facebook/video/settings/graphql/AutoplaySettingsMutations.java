package com.facebook.video.settings.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.video.settings.graphql.AutoplaySettingsMutationsModels.DeviceAutoplaySettingUpdateModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate */
public final class AutoplaySettingsMutations {

    /* compiled from: com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate */
    public class DeviceAutoplaySettingUpdateString extends TypedGraphQLMutationString<DeviceAutoplaySettingUpdateModel> {
        public DeviceAutoplaySettingUpdateString() {
            super(DeviceAutoplaySettingUpdateModel.class, false, "DeviceAutoplaySettingUpdate", "abb915f90ae2e22dbb93c0f94de51771", "device_autoplay_setting_update", "0", "10154205152741729", RegularImmutableSet.a);
        }

        public final String m28353a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}

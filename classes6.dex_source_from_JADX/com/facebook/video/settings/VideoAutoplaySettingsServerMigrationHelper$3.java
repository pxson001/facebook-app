package com.facebook.video.settings;

import com.facebook.graphql.enums.GraphQLAutoplaySettingEffective;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;

/* compiled from: com.google.android.gms.maps.model.internal.IMarkerDelegate */
public /* synthetic */ class VideoAutoplaySettingsServerMigrationHelper$3 {
    static final /* synthetic */ int[] f19626a = new int[GraphQLAutoplaySettingEffective.values().length];
    public static final /* synthetic */ int[] f19627b = new int[AutoPlaySettingValue.values().length];

    static {
        try {
            f19627b[AutoPlaySettingValue.ON.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f19627b[AutoPlaySettingValue.WIFI_ONLY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f19627b[AutoPlaySettingValue.OFF.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f19626a[GraphQLAutoplaySettingEffective.ON.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f19626a[GraphQLAutoplaySettingEffective.WIFI_ONLY.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f19626a[GraphQLAutoplaySettingEffective.OFF.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}

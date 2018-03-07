package com.facebook.placetips.settings.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: ringtone_toast_shown */
public final class GravitySettingsQuery {

    /* compiled from: ringtone_toast_shown */
    public class GravitySettingsQueryString extends TypedGraphQlQueryString<GravitySettingsQueryModels$GravitySettingsQueryModel> {
        public GravitySettingsQueryString() {
            super(GravitySettingsQueryModels$GravitySettingsQueryModel.class, false, "GravitySettingsQuery", "336dd97a00efb92ff0e588f88c0b1478", "viewer", "10154343226786729", RegularImmutableSet.a);
        }
    }

    public static final GravitySettingsQueryString m3560a() {
        return new GravitySettingsQueryString();
    }
}

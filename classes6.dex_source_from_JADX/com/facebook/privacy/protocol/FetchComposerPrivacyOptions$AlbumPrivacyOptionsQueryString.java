package com.facebook.privacy.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.privacy.protocol.FetchComposerPrivacyOptionsModels.AlbumPrivacyOptionsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: sticker_packs_reordered */
public class FetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString extends TypedGraphQlQueryString<AlbumPrivacyOptionsModel> {
    public FetchComposerPrivacyOptions$AlbumPrivacyOptionsQueryString() {
        super(AlbumPrivacyOptionsModel.class, false, "AlbumPrivacyOptionsQuery", "dafe3ac143653926b537df678c88d499", "album", "10154658546066729", RegularImmutableSet.a);
    }

    public final TriState m6051g() {
        return TriState.NO;
    }

    public final String m6050a(String str) {
        switch (str.hashCode()) {
            case 1532078315:
                return "0";
            default:
                return str;
        }
    }
}

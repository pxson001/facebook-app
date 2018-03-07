package com.facebook.privacy.checkup.photofeed.data;

import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SimplePulsarScanQuery */
public class POPPhotoCheckupData {
    public String f11056a;
    private String f11057b;
    public ImmutableList<MediaMetadataWithCreatorPrivacyOptions> f11058c;
    public Map<String, PrivacyOptionFieldsWithExplanation> f11059d = new HashMap();
    public DefaultImageFields f11060e;
    public DefaultImageFields f11061f;
    public String f11062g;
    public boolean f11063h;

    public POPPhotoCheckupData(String str, String str2, ImmutableList<MediaMetadataWithCreatorPrivacyOptions> immutableList, DefaultImageFields defaultImageFields, DefaultImageFields defaultImageFields2, String str3, boolean z) {
        this.f11056a = str;
        this.f11057b = str2;
        this.f11058c = immutableList;
        this.f11060e = defaultImageFields;
        this.f11061f = defaultImageFields2;
        this.f11062g = str3;
        this.f11063h = z;
    }
}

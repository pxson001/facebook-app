package com.facebook.placetips.presence;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.Builder;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: savedThreadName */
public class PlaceTipsHeaderUtil {
    public static DefaultTextWithEntitiesLongFields m3874a(String str, @Nullable String str2) {
        if (StringUtil.a(str)) {
            return null;
        }
        if (str2 == null) {
            str2 = "%s";
        }
        int indexOf = str2.indexOf("%s");
        if (indexOf < 0) {
            str2 = (str2 + " %s").trim();
            indexOf = str2.indexOf("%s");
        }
        Builder builder = new Builder();
        builder.b = StringFormatUtil.formatStrLocaleSafe(str2, str);
        builder = builder;
        RangesModel.Builder builder2 = new RangesModel.Builder();
        builder2.c = indexOf;
        RangesModel.Builder builder3 = builder2;
        builder3.b = str.length();
        builder.a = ImmutableList.of(builder3.a());
        return builder.a();
    }
}

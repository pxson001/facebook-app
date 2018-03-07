package com.facebook.crowdsourcing.suggestedits.helper;

import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

/* compiled from: client_info */
public class FieldTypesHelper {
    private static final Map<String, SuggestEditsListViewType> f17686a = new Builder().b("337046403064701", SuggestEditsListViewType.LOCATION).b("333522400104087", SuggestEditsListViewType.MULTI_VALUE_FIELD).b("463427363734722", SuggestEditsListViewType.TEXT_FIELD).b("114481832091120", SuggestEditsListViewType.HOURS_FIELD).b("137075966484179", SuggestEditsListViewType.TEXT_FIELD).b("376081639179091", SuggestEditsListViewType.MULTI_TEXT_FIELD).b();
    private static final Map<String, SuggestEditsInputType> f17687b = new Builder().b("337046403064701", SuggestEditsInputType.LOCATION).b("333522400104087", SuggestEditsInputType.CATEGORY_PICKER).b("463427363734722", SuggestEditsInputType.TEXT).b("114481832091120", SuggestEditsInputType.HOURS_PICKER).b("137075966484179", SuggestEditsInputType.TEXT).b("376081639179091", SuggestEditsInputType.TEXT).b();

    public static SuggestEditsListViewType m21544a(SuggestEditsField suggestEditsField) {
        if (f17686a.get(suggestEditsField.mo109d()) == null) {
            return SuggestEditsListViewType.UNSUPPORTED;
        }
        return (SuggestEditsListViewType) f17686a.get(suggestEditsField.mo109d());
    }

    public static boolean m21545b(SuggestEditsField suggestEditsField) {
        return m21544a(suggestEditsField) != SuggestEditsListViewType.UNSUPPORTED;
    }

    public static SuggestEditsInputType m21546c(SuggestEditsField suggestEditsField) {
        if (f17687b.containsKey(suggestEditsField.mo109d())) {
            return (SuggestEditsInputType) f17687b.get(suggestEditsField.mo109d());
        }
        return SuggestEditsInputType.TEXT;
    }
}

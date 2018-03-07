package com.facebook.feedplugins.placetips;

import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: friend_search_performed */
public class PlaceTipsUtils {
    public static void m14663a(TextWithEntitiesView textWithEntitiesView, @Nullable DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields == null || Strings.isNullOrEmpty(defaultTextWithEntitiesLongFields.a())) {
            textWithEntitiesView.setVisibility(8);
            return;
        }
        textWithEntitiesView.setTextWithEntities(defaultTextWithEntitiesLongFields);
        textWithEntitiesView.setVisibility(0);
    }
}

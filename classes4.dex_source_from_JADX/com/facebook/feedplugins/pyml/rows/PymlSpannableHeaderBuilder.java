package com.facebook.feedplugins.pyml.rows;

import android.text.Spannable;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.InjectorLike;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

/* compiled from: onInfo MEDIA_INFO_NOT_SEEKABLE */
public class PymlSpannableHeaderBuilder {
    private final LinkifyUtil f6179a;

    public static PymlSpannableHeaderBuilder m6647b(InjectorLike injectorLike) {
        return new PymlSpannableHeaderBuilder(LinkifyUtil.a(injectorLike));
    }

    @Inject
    public PymlSpannableHeaderBuilder(LinkifyUtil linkifyUtil) {
        this.f6179a = linkifyUtil;
    }

    public final Spannable m6648a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
        LinkifyTargetGraphQL a = LinkifyTargetBuilder.a(suggestedPageUnitItem.mo548m());
        ArrayNode a2 = GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit);
        if (a == null) {
            return null;
        }
        return this.f6179a.a(a, a2, LinkifyUtil.a, true);
    }
}

package com.facebook.friending.suggestion.model;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TEXT_ONLY */
public class FriendingSuggestionListLoaderResult {
    public final ImmutableList<FriendingSuggestionItemModel> f24963a;
    public final DefaultPageInfoFieldsModel f24964b;

    public FriendingSuggestionListLoaderResult(ImmutableList<FriendingSuggestionItemModel> immutableList, DefaultPageInfoFieldsModel defaultPageInfoFieldsModel) {
        this.f24963a = immutableList;
        this.f24964b = defaultPageInfoFieldsModel;
    }
}

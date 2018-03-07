package com.facebook.friendlist.data;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: actor_profile_pic_uri */
public final class FriendListLoaderResult {
    public final ImmutableList<FriendPageListItemModel> f20297a;
    public final DefaultPageInfoFieldsModel f20298b;

    public FriendListLoaderResult(ImmutableList<FriendPageListItemModel> immutableList, DefaultPageInfoFieldsModel defaultPageInfoFieldsModel) {
        this.f20297a = immutableList;
        this.f20298b = defaultPageInfoFieldsModel;
    }
}

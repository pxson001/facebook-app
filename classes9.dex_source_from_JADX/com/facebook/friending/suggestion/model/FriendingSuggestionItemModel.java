package com.facebook.friending.suggestion.model;

import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLModels.FriendingSuggestionUserFieldsModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import javax.annotation.Nullable;

/* compiled from: THEME */
public class FriendingSuggestionItemModel implements FriendListUserCommonModel {
    private final int f24954a;
    private final long f24955b;
    private final String f24956c;
    @Nullable
    private final String f24957d;
    public boolean f24958e;
    public GraphQLFriendshipStatus f24959f;

    public FriendingSuggestionItemModel(FriendingSuggestionUserFieldsModel friendingSuggestionUserFieldsModel) {
        this.f24955b = Long.parseLong(friendingSuggestionUserFieldsModel.m26753k());
        this.f24957d = friendingSuggestionUserFieldsModel.m26756n() == null ? null : friendingSuggestionUserFieldsModel.m26756n().m26744a();
        this.f24956c = friendingSuggestionUserFieldsModel.m26755m();
        this.f24954a = friendingSuggestionUserFieldsModel.m26754l().m26736a();
        this.f24959f = friendingSuggestionUserFieldsModel.m26752j();
        this.f24958e = false;
    }

    public final long m26713a() {
        return this.f24955b;
    }

    public final String m26714b() {
        return this.f24956c;
    }

    @Nullable
    public final String m26715d() {
        return this.f24957d;
    }

    public final int m26716e() {
        return this.f24954a;
    }

    public final GraphQLFriendshipStatus m26717f() {
        return this.f24959f;
    }
}

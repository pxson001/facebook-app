package com.facebook.groups.fb4a.create;

import android.content.res.Resources;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.memberpicker.MemberPickerToken;
import com.facebook.groups.memberpicker.SuggestedMemberListLoader;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQuery;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQuery.GroupInviteMembersSearchQueryString;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryModels.GroupInviteMembersSearchQueryModel;
import com.facebook.groups.memberpicker.protocol.GroupSuggestedInviteSearchQueryModels.GroupInviteMembersSearchQueryModel.GroupInviteMembersModel.EdgesModel;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapterCallback;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: payments_new_credit_card_selected */
public class FB4AGroupsCreateFilter extends TypeaheadMatcherFilter {
    private final GraphQLQueryExecutor f6843a;
    private final Provider<String> f6844b;
    private final Resources f6845c;
    private GraphQLResult<GroupInviteMembersSearchQueryModel> f6846d = null;
    private String f6847e = "";

    @Inject
    public FB4AGroupsCreateFilter(FbHandlerThreadFactory fbHandlerThreadFactory, UserTokenMatcher userTokenMatcher, @Assisted TypeaheadAdapterCallback typeaheadAdapterCallback, GraphQLQueryExecutor graphQLQueryExecutor, Provider<String> provider, Resources resources) {
        super(fbHandlerThreadFactory, userTokenMatcher, typeaheadAdapterCallback);
        this.f6843a = graphQLQueryExecutor;
        this.f6844b = provider;
        this.f6845c = resources;
    }

    protected final FilterResults m7125b(CharSequence charSequence) {
        FilterResults b = super.b(charSequence);
        String charSequence2 = charSequence.toString();
        if (Strings.isNullOrEmpty(charSequence2) || charSequence2.length() < 2) {
            return m7124a(null, b);
        }
        if (this.f6847e.equals(charSequence2)) {
            return m7124a(this.f6846d, b);
        }
        this.f6846d = null;
        this.f6847e = charSequence2;
        try {
            GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(m7123a(charSequence.toString()), -1752437255);
            this.f6846d = graphQLResult;
            return m7124a(graphQLResult, b);
        } catch (Exception e) {
            return m7124a(null, b);
        }
    }

    private FilterResults m7124a(GraphQLResult<GroupInviteMembersSearchQueryModel> graphQLResult, FilterResults filterResults) {
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        Builder builder3 = ImmutableList.builder();
        List list = (List) filterResults.a;
        if (!(list == null || list.isEmpty() || list.get(0) == null)) {
            for (BaseToken baseToken : ((SectionedListSection) list.get(0)).b()) {
                if (baseToken instanceof SimpleUserToken) {
                    builder.c(((SimpleUserToken) baseToken).p());
                    builder2.c(new MemberPickerToken((SimpleUserToken) baseToken, this.f6845c.getString(2131239521)));
                }
            }
        }
        ImmutableList b = builder.b();
        if (!(graphQLResult == null || graphQLResult.e == null || ((GroupInviteMembersSearchQueryModel) graphQLResult.e).j() == null || ((GroupInviteMembersSearchQueryModel) graphQLResult.e).j().a() == null)) {
            ImmutableList a = ((GroupInviteMembersSearchQueryModel) graphQLResult.e).j().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Object j;
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                String a2 = edgesModel.a();
                String k = edgesModel.k();
                if (edgesModel.j() != null) {
                    j = edgesModel.j().j();
                } else {
                    String str = "";
                }
                if (!(b.contains(j) || ((String) this.f6844b.get()).equals(j))) {
                    if (!Strings.isNullOrEmpty(a2) && a2.equals("can_add")) {
                        builder2.c(new MemberPickerToken(SuggestedMemberListLoader.a(edgesModel.j(), k)));
                    } else if (!Strings.isNullOrEmpty(a2) && a2.equals("can_invite")) {
                        builder3.c(new MemberPickerToken(SuggestedMemberListLoader.a(edgesModel.j(), k), true));
                    }
                }
            }
        }
        FilterResults filterResults2 = new FilterResults();
        List arrayList = new ArrayList();
        ImmutableList b2 = builder2.b();
        ImmutableList b3 = builder3.b();
        if (b2.size() > 0) {
            arrayList.add(new ImmutableSectionedListSection(this.f6845c.getString(2131239519), b2));
        }
        if (b3.size() > 0) {
            arrayList.add(new ImmutableSectionedListSection(this.f6845c.getString(2131239520), b3));
        }
        filterResults2.a = arrayList;
        filterResults2.b = arrayList.size();
        return filterResults2;
    }

    private GraphQLQueryFuture<GraphQLResult<GroupInviteMembersSearchQueryModel>> m7123a(String str) {
        GroupInviteMembersSearchQueryString a = GroupSuggestedInviteSearchQuery.a();
        a.a("user_id", (String) this.f6844b.get()).a("named", str).a("max_count", Integer.valueOf(12));
        return this.f6843a.a(GraphQLRequest.a(a).a(GraphQLCachePolicy.c));
    }
}

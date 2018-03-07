package com.facebook.goodfriends.audience;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger.Event;
import com.facebook.goodfriends.audience.AudienceFragment.C14262;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.goodfriends.data.FriendStateMutationHelper;
import com.facebook.goodfriends.data.FriendStateMutationHelper.1;
import com.facebook.goodfriends.data.GoodFriendsSearchEngine;
import com.facebook.goodfriends.protocol.GoodFriendsMutators.FriendListUpdateMembersString;
import com.facebook.graphql.calls.FriendListUpdateMembersInputData;
import com.facebook.graphql.calls.FriendListUpdateMembersInputData.ListType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: fetch_memberlist_header */
public class AudienceRecyclerAdapter extends BaseAwesomizerAdapter<FriendData> {
    private static final CallerContext f13416d = CallerContext.a(AudienceRecyclerAdapter.class);
    public final FriendStateFetcher f13417e;
    private final GoodFriendsSearchEngine f13418f;
    public final Callback f13419g = new C14331(this);
    private final FriendStateMutationHelper f13420h;
    public final boolean f13421i;
    public final Set<FriendData> f13422j;
    public final Set<FriendData> f13423k;
    public ImmutableList<FriendData> f13424l;
    private ImmutableList<FriendData> f13425m;
    public String f13426n;
    public int f13427o;
    public boolean f13428p;
    private GoodFriendsAnalyticsLogger f13429q;

    /* compiled from: fetch_memberlist_header */
    class C14331 implements Callback {
        final /* synthetic */ AudienceRecyclerAdapter f13414a;

        C14331(AudienceRecyclerAdapter audienceRecyclerAdapter) {
            this.f13414a = audienceRecyclerAdapter;
        }

        public final void m15039a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
            boolean z;
            this.f13414a.f13424l = immutableList;
            this.f13414a.f13422j.clear();
            this.f13414a.f13423k.clear();
            int size = immutableList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f13414a.f13422j.add((FriendData) immutableList2.get(i2));
            }
            this.f13414a.f13427o = immutableList2.size() + i;
            this.f13414a.m15047a(this.f13414a.f13426n);
            AudienceRecyclerAdapter audienceRecyclerAdapter = this.f13414a;
            if (immutableList2.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            audienceRecyclerAdapter.f13428p = z;
            this.f13414a.notifyDataSetChanged();
        }

        public final void m15040a(Throwable th) {
        }
    }

    @Inject
    protected AudienceRecyclerAdapter(AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, FriendStateFetcher friendStateFetcher, FriendStateMutationHelper friendStateMutationHelper, @Assisted boolean z, GoodFriendsAnalyticsLogger goodFriendsAnalyticsLogger, GoodFriendsSearchEngine goodFriendsSearchEngine) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f13417e = friendStateFetcher;
        this.f13420h = friendStateMutationHelper;
        this.f13421i = z;
        this.f13429q = goodFriendsAnalyticsLogger;
        this.f13425m = RegularImmutableList.a;
        this.f13424l = RegularImmutableList.a;
        this.f13422j = new HashSet();
        this.f13423k = new HashSet();
        this.f13418f = goodFriendsSearchEngine;
    }

    public final void m15047a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            this.f13425m = new Builder().b(this.f13424l).b();
            this.f13426n = null;
            notifyDataSetChanged();
            return;
        }
        this.f13426n = str;
        this.f13425m = this.f13418f.a(this.f13424l, this.f13426n);
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return 1;
    }

    public final ViewHolder mo835a(ViewGroup viewGroup, int i) {
        return i == 0 ? new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903315, viewGroup, false)) {
            final /* synthetic */ AudienceRecyclerAdapter f13415l;
        } : mo805c(viewGroup);
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903314, viewGroup, false));
    }

    public final void m15044a(ViewHolder viewHolder, int i) {
        if (i == 0) {
            FbTextView fbTextView = (FbTextView) viewHolder.a;
            Context context = fbTextView.getContext();
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f13421i) {
                stringBuilder.append(context.getString(2131236168));
                if (this.f13428p) {
                    stringBuilder.append(" ");
                    stringBuilder.append(context.getString(2131236169));
                }
            } else {
                stringBuilder.append(context.getString(2131236166));
            }
            fbTextView.setText(stringBuilder.toString());
        } else if (viewHolder instanceof ViewHolderItem) {
            FriendData h = m15042h(i);
            FriendItemView friendItemView = (FriendItemView) ((ViewHolderItem) viewHolder).f11795l;
            friendItemView.setAvatarNameViewText(h.b);
            friendItemView.m13850a(h.c, f13416d);
            if (this.f13422j.contains(h)) {
                friendItemView.setSelected(true);
            } else if (this.f13423k.contains(h)) {
                friendItemView.setSelected(false);
            } else {
                friendItemView.setSelected(h.b());
            }
        }
    }

    public static int m15041e(int i, int i2) {
        return i == 0 ? i2 : 1;
    }

    public final void mo802a(View view, int i) {
        if (i != 0) {
            FriendData h = m15042h(i);
            FriendItemView friendItemView = (FriendItemView) view;
            friendItemView.setSelected(!friendItemView.isSelected());
            if (friendItemView.isSelected()) {
                if (this.f13423k.contains(h)) {
                    this.f13423k.remove(h);
                }
                this.f13422j.add(h);
                this.f13427o++;
                this.f13429q.m15026a(Event.PICKER_SELECT);
            } else {
                if (this.f13422j.contains(h)) {
                    this.f13422j.remove(h);
                }
                this.f13423k.add(h);
                this.f13427o--;
                this.f13429q.m15026a(Event.PICKER_DESELECT);
            }
            Preconditions.checkArgument(this.f13422j.contains(h) ^ this.f13423k.contains(h));
        }
    }

    public final int aZ_() {
        return this.f13425m == null ? 0 : this.f13425m.size() + 1;
    }

    private FriendData m15042h(int i) {
        if (this.f13425m == null || i == 0) {
            return null;
        }
        return (FriendData) this.f13425m.get(i - 1);
    }

    protected final String mo807g() {
        return "";
    }

    public final void m15046a(C14262 c14262) {
        Builder builder = new Builder();
        builder.b(this.f13422j);
        Builder builder2 = new Builder();
        builder2.b(this.f13423k);
        FriendStateMutationHelper friendStateMutationHelper = this.f13420h;
        ImmutableList<FriendData> b = builder.b();
        ImmutableList<FriendData> b2 = builder2.b();
        GraphQlQueryString friendListUpdateMembersString = new FriendListUpdateMembersString();
        FriendListUpdateMembersInputData friendListUpdateMembersInputData = new FriendListUpdateMembersInputData();
        friendListUpdateMembersInputData.a("actor_id", (String) friendStateMutationHelper.c.get());
        GraphQlCallInput graphQlCallInput = friendListUpdateMembersInputData;
        graphQlCallInput.a("client_mutation_id", friendListUpdateMembersString.d);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("list_type", ListType.GOOD_FRIENDS);
        GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        Builder builder3 = new Builder();
        for (FriendData friendData : b) {
            builder3.c(friendData.a);
        }
        graphQlCallInput2.a("add_ids", builder3.b());
        builder3 = new Builder();
        for (FriendData friendData2 : b2) {
            builder3.c(friendData2.a);
        }
        graphQlCallInput2.a("remove_ids", builder3.b());
        friendListUpdateMembersString.a("input", graphQlCallInput2);
        Futures.a(friendStateMutationHelper.a.a(GraphQLRequest.a(friendListUpdateMembersString)), new 1(friendStateMutationHelper, c14262), friendStateMutationHelper.b);
    }

    public final int m15050l() {
        return this.f13424l.size();
    }
}

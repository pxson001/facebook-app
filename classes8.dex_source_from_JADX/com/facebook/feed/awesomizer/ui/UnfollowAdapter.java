package com.facebook.feed.awesomizer.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.EdgesModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: group_unblock_user */
public class UnfollowAdapter extends BaseAwesomizerAdapter<FollowedProfilesModel> {
    private static final CallerContext f11866e = CallerContext.a(UnfollowAdapter.class, "feed_awesomizer");
    private final AwesomizerNetworkQueryHelper f11867d;

    @Inject
    public UnfollowAdapter(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f11867d = awesomizerNetworkQueryHelper;
    }

    public final void m13979a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolderItem) {
            m13977a(m13978h(i), ((ViewHolderItem) viewHolder).f11795l);
        }
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    private static void m13977a(Object obj, View view) {
        String string;
        EdgesModel edgesModel = (EdgesModel) obj;
        AwesomizerGridItemView awesomizerGridItemView = (AwesomizerGridItemView) view;
        Resources resources = view.getContext().getResources();
        int j = edgesModel.m13667j();
        if (edgesModel.m13664a().m13541o() != GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            string = resources.getString(2131236155);
        } else if (j != 0) {
            string = resources.getQuantityString(2131689651, j, new Object[]{Integer.valueOf(j)});
        } else {
            string = resources.getString(2131236154);
        }
        awesomizerGridItemView.setAvatarContextViewText(string);
        awesomizerGridItemView.m13852a(edgesModel.m13664a().m13541o() != GraphQLSubscribeStatus.IS_SUBSCRIBED);
        AwesomizerProfileViewBinder.m13877a(awesomizerGridItemView, edgesModel.m13664a().m13540n(), AwesomizerAvatarUtil.m13831a(edgesModel.m13664a()), edgesModel.m13664a().m13536j().g(), f11866e);
    }

    protected final String mo807g() {
        return AwesomizerCards.UNFOLLOW.getName();
    }

    private EdgesModel m13978h(int i) {
        return (this.f11803g == null || i >= aZ_() || i <= 0) ? null : (EdgesModel) ((FollowedProfilesModel) this.f11803g).m13680j().get(i - 1);
    }

    public final void mo802a(View view, int i) {
        final FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) this.f11803g;
        followedProfilesModel = this.f11867d.m13871a(followedProfilesModel, m13978h(i), new FutureCallback<Void>(this) {
            final /* synthetic */ UnfollowAdapter f11865b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f11865b.m13882a(followedProfilesModel, followedProfilesModel.m13681k().m13674j(), followedProfilesModel.m13676a());
            }
        });
        m13882a(followedProfilesModel, followedProfilesModel.m13681k().m13674j(), followedProfilesModel.m13676a());
        this.f11798a.m13943a(i, m13978h(i).m13664a().m13541o() == GraphQLSubscribeStatus.CAN_SUBSCRIBE);
    }

    public final int aZ_() {
        return this.f11803g != null ? ((FollowedProfilesModel) this.f11803g).m13680j().size() + 1 : 1;
    }
}

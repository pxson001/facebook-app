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
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel.ConnectedFriendsModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.NodesModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: gysc_mall */
public class DiscoverTopicAdapter extends BaseAwesomizerAdapter<SuggestedPagesModel> {
    public static final CallerContext f11833d = CallerContext.a(DiscoverTopicAdapter.class, "feed_awesomizer");
    private final AwesomizerNetworkQueryHelper f11834e;

    @Inject
    public DiscoverTopicAdapter(AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f11834e = awesomizerNetworkQueryHelper;
    }

    public final void m13928a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolderItem) {
            NodesModel h = m13927h(i);
            View view = ((ViewHolderItem) viewHolder).f11795l;
            int i2 = 0;
            AwesomizerGridItemView awesomizerGridItemView = (AwesomizerGridItemView) view;
            Resources resources = view.getContext().getResources();
            boolean z = h.m13634o() == GraphQLSubscribeStatus.IS_SUBSCRIBED;
            awesomizerGridItemView.m13852a(z);
            awesomizerGridItemView.setAvatarContextViewText(z ? resources.getString(2131236159) : "");
            AwesomizerProfileViewBinder.m13877a(awesomizerGridItemView, h.m13633n(), h.m13631l().m13691a(), 2479791, f11833d);
            if (h.m13630k() != null) {
                List arrayList = new ArrayList();
                ImmutableList j = h.m13630k().m13560j();
                int size = j.size();
                while (i2 < size) {
                    ConnectedFriendsModel.NodesModel nodesModel = (ConnectedFriendsModel.NodesModel) j.get(i2);
                    if (nodesModel.m13551a() != null) {
                        arrayList.add(nodesModel.m13551a().m13548a());
                    }
                    i2++;
                }
                awesomizerGridItemView.m13851a(arrayList, h.m13630k().m13556a());
            }
        }
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    protected final String mo807g() {
        return AwesomizerCards.DISCOVER.getName();
    }

    public final boolean mo817e(int i) {
        return false;
    }

    private NodesModel m13927h(int i) {
        return (this.f11803g == null || i >= aZ_()) ? null : (NodesModel) ((SuggestedPagesModel) this.f11803g).m13647j().get(i);
    }

    public final void mo802a(View view, int i) {
        final SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) this.f11803g;
        suggestedPagesModel = this.f11834e.m13870a(suggestedPagesModel, m13927h(i), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ DiscoverTopicAdapter f11832b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f11832b.m13882a(suggestedPagesModel, suggestedPagesModel.m13648k().m13641j(), suggestedPagesModel.m13643a());
            }
        });
        m13882a(suggestedPagesModel, suggestedPagesModel.m13648k().m13641j(), suggestedPagesModel.m13643a());
    }

    public final int aZ_() {
        return this.f11803g != null ? ((SuggestedPagesModel) this.f11803g).m13647j().size() : 0;
    }
}

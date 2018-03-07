package com.facebook.feed.awesomizer.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardConnectedFriendsFragmentModel.ConnectedFriendsModel.NodesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel.PageTopicsByCountModel.SuggestedPagesModel.EdgesModel.NodeModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.BaseAwesomizerAdapter.ViewHolderItem;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

/* compiled from: gysccta_imp */
public class DiscoverAdapter extends BaseAwesomizerAdapter<ImmutableList<PageTopicsByCountModel>> {
    private static final String f11824d = DiscoverAdapter.class.getSimpleName();
    public static final CallerContext f11825e = CallerContext.a(DiscoverAdapter.class, "feed_awesomizer");
    public static String f11826f;
    private final Context f11827g;
    private final AwesomizerNetworkQueryHelper f11828h;
    private final ComponentName f11829i;
    private final SecureContextHelper f11830j;

    /* compiled from: gysccta_imp */
    public class ItemModel {
        public Section f11822a;
        public Object f11823b;

        public ItemModel(Section section, Object obj) {
            this.f11822a = section;
            this.f11823b = obj;
        }
    }

    /* compiled from: gysccta_imp */
    public enum Section {
        TOPIC_HEADER,
        PAGE_PROFILE,
        SEE_MORE
    }

    @Inject
    public DiscoverAdapter(Context context, AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper, @FragmentChromeActivity ComponentName componentName, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        super(abstractFbErrorReporter, secureContextHelper, uriIntentMapper);
        this.f11827g = context;
        this.f11828h = awesomizerNetworkQueryHelper;
        this.f11829i = componentName;
        this.f11830j = secureContextHelper;
    }

    public final void mo802a(View view, int i) {
        if (!mo806f(i)) {
            if (mo808g(i)) {
                this.f11830j.a(new Intent().setComponent(this.f11829i).putExtra("target_fragment", ContentFragmentType.AWESOMIZER_DISCOVER_TOPIC_FRAGMENT.ordinal()).putExtra("session_id", f11826f).putExtra("topic_id", ((PageTopicsByCountModel) ((ImmutableList) this.f11803g).get(m13910m(i))).m13609j()).putExtra("topic_name", ((PageTopicsByCountModel) ((ImmutableList) this.f11803g).get(m13910m(i))).m13610k()), this.f11827g);
            }
            final ImmutableList immutableList = (ImmutableList) this.f11803g;
            m13882a(this.f11828h.m13874a(immutableList, (NodeModel) m13909h(i).f11823b, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ DiscoverAdapter f11820b;

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                }

                public void onFailure(Throwable th) {
                    this.f11820b.m13882a(immutableList, false, this.f11820b.aZ_());
                }
            }), false, aZ_());
        }
    }

    protected final ViewHolderItem mo805c(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    protected final ViewHolderItem mo801a(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903335, viewGroup, false));
    }

    protected final ViewHolderItem mo804b(ViewGroup viewGroup) {
        return new ViewHolderItem(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903336, viewGroup, false));
    }

    public final void m13912a(ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolderItem) {
            m13907a(m13909h(i), ((ViewHolderItem) viewHolder).f11795l);
        }
    }

    private void m13907a(ItemModel itemModel, View view) {
        switch (itemModel.f11822a) {
            case TOPIC_HEADER:
                m13908a((String) itemModel.f11823b, view);
                return;
            case PAGE_PROFILE:
                NodeModel nodeModel = (NodeModel) itemModel.f11823b;
                int i = 0;
                AwesomizerGridItemView awesomizerGridItemView = (AwesomizerGridItemView) view;
                Resources resources = view.getContext().getResources();
                boolean z = nodeModel.m13593o() == GraphQLSubscribeStatus.IS_SUBSCRIBED;
                awesomizerGridItemView.m13852a(z);
                awesomizerGridItemView.setAvatarContextViewText(z ? resources.getString(2131236159) : "");
                AwesomizerProfileViewBinder.m13877a(awesomizerGridItemView, nodeModel.m13592n(), nodeModel.m13590l().m13691a(), 2479791, f11825e);
                if (nodeModel.m13589k() != null) {
                    List a = Lists.a();
                    ImmutableList j = nodeModel.m13589k().m13560j();
                    int size = j.size();
                    while (i < size) {
                        NodesModel nodesModel = (NodesModel) j.get(i);
                        if (nodesModel.m13551a() != null) {
                            a.add(nodesModel.m13551a().m13548a());
                        }
                        i++;
                    }
                    awesomizerGridItemView.m13851a(a, nodeModel.m13589k().m13556a());
                }
                return;
            case SEE_MORE:
                m13906a(view);
                return;
            default:
                this.f11800c.b(f11824d, "Invalid discover section type " + itemModel.f11822a + " in the awesomizer discover adapter");
                return;
        }
    }

    private static void m13908a(String str, View view) {
        ((AwesomizerTopicHeaderView) view).setTopicHeaderTitle(str);
    }

    public final int aZ_() {
        if (this.f11803g == null) {
            return 1;
        }
        int size = ((ImmutableList) this.f11803g).size();
        return (size + (size * 6)) + 1;
    }

    private static void m13906a(View view) {
        AwesomizerProfileViewBinder.m13877a((AwesomizerGridItemView) view, "More", null, 2479791, f11825e);
    }

    private ItemModel m13909h(int i) {
        if (mo817e(i)) {
            return null;
        }
        if (mo806f(i)) {
            return new ItemModel(Section.TOPIC_HEADER, ((PageTopicsByCountModel) ((ImmutableList) this.f11803g).get((i - 1) / 7)).m13610k());
        } else if (mo808g(i)) {
            return new ItemModel(Section.SEE_MORE, null);
        } else {
            ItemModel itemModel;
            int i2 = i % 7;
            SuggestedPagesModel l = ((PageTopicsByCountModel) ((ImmutableList) this.f11803g).get((i - i2) / 7)).m13611l();
            if (l == null || l.m13599a() == 0) {
                itemModel = null;
            } else {
                itemModel = new ItemModel(Section.PAGE_PROFILE, ((EdgesModel) l.m13603j().get(i2 - 2)).m13596a());
            }
            return itemModel;
        }
    }

    public final boolean mo806f(int i) {
        return (i + -1) % 7 == 0;
    }

    public final boolean mo808g(int i) {
        return i % 7 == 0;
    }

    protected final String mo807g() {
        return AwesomizerCards.DISCOVER.getName();
    }

    public static int m13910m(int i) {
        return (i / 7) - 1;
    }
}

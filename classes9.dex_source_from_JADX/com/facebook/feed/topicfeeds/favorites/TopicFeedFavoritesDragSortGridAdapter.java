package com.facebook.feed.topicfeeds.favorites;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.topicfeeds.events.TopicFeedsEventBus;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.TopicFeedsListItemToggledEvent;
import com.facebook.feed.topicfeeds.events.TopicFeedsEvents.UpdatedState;
import com.facebook.feed.topicfeeds.favorites.TopicFeedFavoritesFragment.C29715;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.TopicsSetFavoritesInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.topics.data.TopicFavoritesOrderMutator;
import com.facebook.topics.protocol.TopicFavoritesMutations.FavoriteASetOfTopicFeedsMutationString;
import com.facebook.topics.protocol.TopicFavoritesMutationsModels.SetOfFavoritesMutationFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedFragmentModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel;
import com.facebook.topics.protocol.TopicFavoritesQueryModels.TopicFeedListModel.Builder;
import com.facebook.topics.protocol.TopicModelHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.dragsortgridview.AbstractDragSortGridWithStableIdsAdapter;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: TRANSFER */
public class TopicFeedFavoritesDragSortGridAdapter extends AbstractDragSortGridWithStableIdsAdapter {
    public static final CallerContext f24607a = CallerContext.a(TopicFeedFavoritesDragSortGridAdapter.class, "topic_feeds_favorites");
    public C29715 f24608b;
    private ImmutableList<TopicFeedFragmentModel> f24609c;
    private TopicFeedsEventBus f24610d;
    private TopicFavoritesOrderMutator f24611e;

    /* compiled from: TRANSFER */
    public class ViewHolder {
        final /* synthetic */ TopicFeedFavoritesDragSortGridAdapter f24603a;
        public ContentView f24604b;
        public FbDraweeView f24605c = ((FbDraweeView) FindViewUtil.b(this.f24604b, 2131568076));
        public SwitchCompat f24606d = ((SwitchCompat) FindViewUtil.b(this.f24604b, 2131568077));

        /* compiled from: TRANSFER */
        public class C29661 implements OnCheckedChangeListener {
            final /* synthetic */ TopicFeedFragmentModel f24601a;
            final /* synthetic */ ViewHolder f24602b;

            public C29661(ViewHolder viewHolder, TopicFeedFragmentModel topicFeedFragmentModel) {
                this.f24602b = viewHolder;
                this.f24601a = topicFeedFragmentModel;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TopicFeedFavoritesDragSortGridAdapter.m26514a(this.f24602b.f24603a, this.f24601a);
            }
        }

        public ViewHolder(TopicFeedFavoritesDragSortGridAdapter topicFeedFavoritesDragSortGridAdapter, View view) {
            this.f24603a = topicFeedFavoritesDragSortGridAdapter;
            this.f24604b = (ContentView) view;
        }
    }

    public static TopicFeedFavoritesDragSortGridAdapter m26516b(InjectorLike injectorLike) {
        return new TopicFeedFavoritesDragSortGridAdapter(TopicFeedsEventBus.m26511a(injectorLike), new TopicFavoritesOrderMutator(TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike)));
    }

    @Inject
    public TopicFeedFavoritesDragSortGridAdapter(TopicFeedsEventBus topicFeedsEventBus, TopicFavoritesOrderMutator topicFavoritesOrderMutator) {
        this.f24610d = topicFeedsEventBus;
        this.f24611e = topicFavoritesOrderMutator;
    }

    public final void m26519a(int i, int i2) {
        m26517b(i, i2);
        if (this.f24608b != null) {
            C29715 c29715 = this.f24608b;
            int min = Math.min(Math.max(i, i2), c29715.f24616a.f24619c.getLastVisiblePosition());
            for (int max = Math.max(Math.min(i, i2), c29715.f24616a.f24619c.getFirstVisiblePosition()); max <= min; max++) {
                c29715.f24616a.f24620d.getView(max, c29715.f24616a.f24619c.getChildAt(max - c29715.f24616a.f24619c.getFirstVisiblePosition()), c29715.f24616a.f24619c);
            }
        }
    }

    public final int m26518a() {
        if (this.f24609c == null) {
            return 0;
        }
        return this.f24609c.size();
    }

    public int getCount() {
        if (this.f24609c == null) {
            return 0;
        }
        return this.f24609c.size();
    }

    public int getViewTypeCount() {
        return 1;
    }

    public Object getItem(int i) {
        return this.f24609c != null ? (TopicFeedFragmentModel) this.f24609c.get(i) : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(2130907528, viewGroup, false);
            ViewHolder viewHolder2 = new ViewHolder(this, view);
            view.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) getItem(i);
        if (topicFeedFragmentModel == null) {
            viewHolder.f24604b.setTitleText("");
            viewHolder.f24605c.a(null, f24607a);
            viewHolder.f24606d.setOnClickListener(null);
        } else {
            String a;
            viewHolder.f24604b.setTitleText(topicFeedFragmentModel.k());
            if (topicFeedFragmentModel.fc_()) {
                a = topicFeedFragmentModel.n().a();
            } else {
                a = topicFeedFragmentModel.m().a();
            }
            viewHolder.f24605c.a(Uri.parse(a), f24607a);
            viewHolder.f24606d.setOnCheckedChangeListener(null);
            if (viewHolder.f24606d.isChecked() != topicFeedFragmentModel.fc_()) {
                viewHolder.f24606d.setCheckedNoAnimation(topicFeedFragmentModel.fc_());
            }
            viewHolder.f24606d.setOnCheckedChangeListener(new C29661(viewHolder, topicFeedFragmentModel));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(topicFeedFragmentModel.k());
            stringBuilder.append(" ").append(viewHolder.f24604b.getContext().getString(topicFeedFragmentModel.fc_() ? 2131241420 : 2131241421));
            viewHolder.f24604b.setContentDescription(stringBuilder.toString());
            viewHolder.f24606d.setContentDescription(viewHolder.f24604b.getContext().getString(2131241422));
        }
        return view;
    }

    public final void m26520a(ImmutableList<TopicFeedFragmentModel> immutableList) {
        this.f24609c = immutableList;
        this.a.clear();
        a(this.f24609c);
        AdapterDetour.a(this, 88946090);
    }

    @Nullable
    public final TopicFeedListModel m26521c() {
        if (this.f24609c == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.a = this.f24609c;
        return builder.a();
    }

    public static void m26514a(TopicFeedFavoritesDragSortGridAdapter topicFeedFavoritesDragSortGridAdapter, TopicFeedFragmentModel topicFeedFragmentModel) {
        ImmutableList immutableList = topicFeedFavoritesDragSortGridAdapter.f24609c;
        int i = 0;
        while (i < immutableList.size()) {
            if (((TopicFeedFragmentModel) immutableList.get(i)).fb_().equals(topicFeedFragmentModel.fb_())) {
                break;
            }
            i++;
        }
        i = -1;
        int i2 = i;
        if (i2 >= 0) {
            UpdatedState updatedState;
            ImmutableList a = TopicModelHelper.a(topicFeedFavoritesDragSortGridAdapter.f24609c, i2);
            TopicFeedFragmentModel topicFeedFragmentModel2 = (TopicFeedFragmentModel) a.get(i2);
            topicFeedFavoritesDragSortGridAdapter.m26515a(topicFeedFavoritesDragSortGridAdapter.f24609c, a, StringFormatUtil.formatStrLocaleSafe("Failed to update topic: %s", topicFeedFragmentModel.k()));
            TopicFeedsEventBus topicFeedsEventBus = topicFeedFavoritesDragSortGridAdapter.f24610d;
            if (topicFeedFragmentModel2.fc_()) {
                updatedState = UpdatedState.FAVORITE_INSERTED;
            } else {
                updatedState = UpdatedState.FAVORITE_REMOVED;
            }
            Builder builder = new Builder();
            builder.a = a;
            topicFeedsEventBus.a(new TopicFeedsListItemToggledEvent(updatedState, topicFeedFragmentModel2, builder.a()));
            topicFeedFavoritesDragSortGridAdapter.m26520a(a);
        }
    }

    private void m26517b(int i, int i2) {
        TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) this.f24609c.get(i);
        ImmutableList a = TopicModelHelper.a(this.f24609c, i, i2);
        m26515a(this.f24609c, a, StringFormatUtil.formatStrLocaleSafe("Failed to reorder topic %s from pos %d to %d", topicFeedFragmentModel, Integer.valueOf(i), Integer.valueOf(i2)));
        TopicFeedFragmentModel topicFeedFragmentModel2 = (TopicFeedFragmentModel) this.f24609c.get(i2);
        if (topicFeedFragmentModel.fc_() && topicFeedFragmentModel2.fc_()) {
            Builder builder = new Builder();
            builder.a = a;
            TopicFeedListModel a2 = builder.a();
            this.f24610d.a(new TopicFeedsListItemToggledEvent(UpdatedState.FAVORITE_REMOVED, topicFeedFragmentModel2, a2));
            this.f24610d.a(new TopicFeedsListItemToggledEvent(UpdatedState.FAVORITE_INSERTED, topicFeedFragmentModel2, a2));
        }
        this.f24609c = a;
    }

    private void m26515a(final ImmutableList<TopicFeedFragmentModel> immutableList, ImmutableList<TopicFeedFragmentModel> immutableList2, final String str) {
        TopicFavoritesOrderMutator topicFavoritesOrderMutator = this.f24611e;
        C29651 c29651 = new AbstractDisposableFutureCallback<GraphQLResult<SetOfFavoritesMutationFragmentModel>>(this) {
            final /* synthetic */ TopicFeedFavoritesDragSortGridAdapter f24600c;

            protected final void m26513a(Throwable th) {
                this.f24600c.m26520a(immutableList);
            }
        };
        List arrayList = new ArrayList();
        int size = immutableList2.size();
        for (int i = 0; i < size; i++) {
            TopicFeedFragmentModel topicFeedFragmentModel = (TopicFeedFragmentModel) immutableList2.get(i);
            if (topicFeedFragmentModel.fc_()) {
                arrayList.add(topicFeedFragmentModel.fb_());
            }
        }
        GraphQlQueryString favoriteASetOfTopicFeedsMutationString = new FavoriteASetOfTopicFeedsMutationString();
        TopicsSetFavoritesInputData topicsSetFavoritesInputData = new TopicsSetFavoritesInputData();
        topicsSetFavoritesInputData.a("actor_id", topicFavoritesOrderMutator.c);
        GraphQlCallInput graphQlCallInput = topicsSetFavoritesInputData;
        graphQlCallInput.a("favorited_topic_ids", arrayList);
        favoriteASetOfTopicFeedsMutationString.a("input", graphQlCallInput);
        topicFavoritesOrderMutator.a.c("MUTATE_TOPIC_FEEDS_FAVORITES_KEY", topicFavoritesOrderMutator.b.a(GraphQLRequest.a(favoriteASetOfTopicFeedsMutationString)), c29651);
    }
}

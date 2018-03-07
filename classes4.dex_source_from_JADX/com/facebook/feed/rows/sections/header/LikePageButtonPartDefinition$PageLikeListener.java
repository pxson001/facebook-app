package com.facebook.feed.rows.sections.header;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.CanLikePage;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: native_settings_changed */
public class LikePageButtonPartDefinition$PageLikeListener<E extends CanLikePage> implements OnClickListener {
    private final FeedProps<GraphQLStory> f7284a;
    private final GraphQLPage f7285b;
    private final GatekeeperStoreImpl f7286c;
    private final E f7287d;

    public LikePageButtonPartDefinition$PageLikeListener(FeedProps<GraphQLStory> feedProps, GraphQLPage graphQLPage, GatekeeperStore gatekeeperStore, E e) {
        this.f7284a = feedProps;
        this.f7285b = graphQLPage;
        this.f7286c = gatekeeperStore;
        this.f7287d = e;
    }

    public void onClick(View view) {
        FeedProps e;
        String str = null;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2005337774);
        GraphQLStory graphQLStory = (GraphQLStory) this.f7284a.a;
        GraphQLStory d = StoryProps.d(this.f7284a);
        FeedProps feedProps = this.f7284a;
        Flattenable b = feedProps.b();
        if (b == null || !(b instanceof GraphQLStorySet)) {
            e = StoryProps.e(feedProps);
        } else {
            e = FeedProps.c((GraphQLStorySet) b);
        }
        feedProps = e;
        String str2 = this.f7286c.a(830, false) ? (graphQLStory.u() || d.u()) ? "sponsored_story" : "feed_story" : null;
        CanLikePage canLikePage = this.f7287d;
        String ae = this.f7285b.ae();
        if (graphQLStory.l() != null) {
            str = graphQLStory.l().j();
        }
        canLikePage.a(feedProps, ae, str, str2);
        LogUtils.a(716459598, a);
    }
}

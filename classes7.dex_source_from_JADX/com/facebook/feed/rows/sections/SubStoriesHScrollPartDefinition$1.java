package com.facebook.feed.rows.sections;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.VisibleItemHelper;
import com.google.common.collect.ImmutableList;

/* compiled from: \f */
public class SubStoriesHScrollPartDefinition$1 extends SimpleCallbacks<E> {
    final /* synthetic */ FeedProps f20457a;
    final /* synthetic */ ImmutableList f20458b;
    final /* synthetic */ GraphQLStory f20459c;
    final /* synthetic */ SubStoriesHScrollPartDefinition f20460d;

    public SubStoriesHScrollPartDefinition$1(SubStoriesHScrollPartDefinition subStoriesHScrollPartDefinition, FeedProps feedProps, ImmutableList immutableList, GraphQLStory graphQLStory) {
        this.f20460d = subStoriesHScrollPartDefinition;
        this.f20457a = feedProps;
        this.f20458b = immutableList;
        this.f20459c = graphQLStory;
    }

    public final void m23541a(PageSubParts<E> pageSubParts) {
        boolean e = FeedStoryUtil.e((GraphQLStory) this.f20457a.a);
        for (int i = 0; i < this.f20458b.size(); i++) {
            pageSubParts.a(e ? this.f20460d.b : this.f20460d.a, this.f20457a.a((Flattenable) this.f20458b.get(i)));
        }
    }

    public final void m23542c(int i) {
        VisibleItemHelper.a(this.f20459c, i);
    }
}

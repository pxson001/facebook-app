package com.facebook.feedback.ui;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.rows.CommentLevel;
import com.facebook.feedback.ui.rows.LoadMoreCommentsPartDefinition;
import com.facebook.feedback.ui.rows.OriginalPostButtonPartDefinition;
import com.facebook.feedback.ui.rows.RootProps;
import com.facebook.feedback.ui.rows.TopLevelCommentGroupPartDefinition.Props;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: saturation */
public class FeedbackListItemCollection implements ListItemCollection<RootProps>, Bindable<FeedProps<GraphQLFeedback>> {
    public List<RootProps> f4549a = new ArrayList();
    private FeedProps<GraphQLFeedback> f4550b;
    private FeedProps<GraphQLStory> f4551c;

    public FeedbackListItemCollection(FeedProps<GraphQLStory> feedProps) {
        this.f4551c = feedProps;
    }

    public final int m5104a() {
        return this.f4549a.size();
    }

    public final Object m5106a(int i) {
        return (RootProps) this.f4549a.get(i);
    }

    public final int m5105a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < this.f4549a.size(); i++) {
            RootProps rootProps = (RootProps) this.f4549a.get(i);
            if (rootProps instanceof Props) {
                GraphQLComment graphQLComment = ((Props) rootProps).f5117b;
                if (graphQLComment != null && str.equals(graphQLComment.y())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public final void m5107a(FeedProps<GraphQLFeedback> feedProps) {
        this.f4549a.clear();
        if (this.f4551c != null) {
            this.f4549a.add(new OriginalPostButtonPartDefinition.Props(this.f4551c));
        }
        this.f4550b = feedProps;
        if (feedProps != null) {
            CommentOrderType order = CommentOrderType.getOrder((GraphQLFeedback) feedProps.a);
            CommentLoadDirection commentLoadDirection = CommentOrderType.RANKED_ORDER.equals(order) ? CommentLoadDirection.LOAD_BEFORE : CommentLoadDirection.LOAD_AFTER;
            CommentLoadDirection commentLoadDirection2 = commentLoadDirection == CommentLoadDirection.LOAD_BEFORE ? CommentLoadDirection.LOAD_AFTER : CommentLoadDirection.LOAD_BEFORE;
            LoadMoreCommentsPartDefinition.Props props = new LoadMoreCommentsPartDefinition.Props((GraphQLFeedback) feedProps.a, commentLoadDirection, CommentLevel.TOP_LEVEL);
            if (LoadMoreCommentsPartDefinition.m5550a(props)) {
                this.f4549a.add(props);
            }
            ImmutableList i = GraphQLHelper.i((GraphQLFeedback) feedProps.a);
            if (!CommentOrderType.isReverseOrder((GraphQLFeedback) feedProps.a)) {
                i = i.reverse();
            }
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f4549a.add(new Props(feedProps.a((GraphQLComment) i.get(i2)), order));
            }
            LoadMoreCommentsPartDefinition.Props props2 = new LoadMoreCommentsPartDefinition.Props((GraphQLFeedback) feedProps.a, commentLoadDirection2, CommentLevel.TOP_LEVEL);
            if (LoadMoreCommentsPartDefinition.m5550a(props2)) {
                this.f4549a.add(props2);
            }
        }
    }
}

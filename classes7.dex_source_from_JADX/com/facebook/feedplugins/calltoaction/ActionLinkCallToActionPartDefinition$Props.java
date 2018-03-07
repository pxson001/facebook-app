package com.facebook.feedplugins.calltoaction;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: SwipeableFrameNuxPreference */
public class ActionLinkCallToActionPartDefinition$Props {
    public final FeedProps<GraphQLStory> f23045a;
    @Nullable
    public final OnClickListener f23046b;
    public final OnClickListener f23047c;
    @Nullable
    public final Uri f23048d;
    @Nullable
    public final Drawable f23049e;
    public final GraphQLStoryActionLink f23050f;
    public final CharSequence f23051g;
    public final PaddingStyle f23052h;
    public final boolean f23053i;

    public static ActionLinkCallToActionPartDefinition$Props m25512a(FeedProps<GraphQLStory> feedProps, @Nullable OnClickListener onClickListener, OnClickListener onClickListener2, @Nullable Uri uri, @Nullable Drawable drawable) {
        GraphQLStoryActionLink c = ActionLinkCallToActionPartDefinition.c((GraphQLStory) feedProps.a);
        return new ActionLinkCallToActionPartDefinition$Props(feedProps, onClickListener, onClickListener2, uri, drawable, c, ActionLinkCallToActionPartDefinition.b(c), PaddingStyle.m, true);
    }

    private ActionLinkCallToActionPartDefinition$Props(FeedProps<GraphQLStory> feedProps, @Nullable OnClickListener onClickListener, OnClickListener onClickListener2, @Nullable Uri uri, @Nullable Drawable drawable, GraphQLStoryActionLink graphQLStoryActionLink, CharSequence charSequence, PaddingStyle paddingStyle, boolean z) {
        Preconditions.checkArgument(ActionLinkCallToActionPartDefinition.a((GraphQLStory) feedProps.a));
        boolean z2 = uri == null || drawable == null;
        Preconditions.checkArgument(z2, "Do not specify both a URI and a resource drawable");
        this.f23045a = feedProps;
        this.f23046b = onClickListener;
        this.f23047c = onClickListener2;
        this.f23048d = uri;
        this.f23049e = drawable;
        this.f23050f = graphQLStoryActionLink;
        this.f23051g = charSequence;
        this.f23052h = paddingStyle;
        this.f23053i = z;
    }

    public static ActionLinkCallToActionPartDefinition$Props m25513a(FeedProps<GraphQLStory> feedProps, GraphQLStoryActionLink graphQLStoryActionLink, @Nullable OnClickListener onClickListener, OnClickListener onClickListener2, @Nullable Uri uri, Drawable drawable, CharSequence charSequence, boolean z) {
        return new ActionLinkCallToActionPartDefinition$Props(feedProps, onClickListener, onClickListener2, uri, drawable, graphQLStoryActionLink, graphQLStoryActionLink.t() == null ? charSequence : ActionLinkCallToActionPartDefinition.b(graphQLStoryActionLink), PaddingStyle.n, z);
    }
}

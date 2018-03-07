package com.facebook.tablet.sideshow.ads.model;

import android.net.Uri;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.tablet.sideshow.ads.model.AppAdsSideshowSecondaryAction.SecondaryActionType;
import com.facebook.tablet.sideshow.ads.util.AppAdsSideshowStoryAccessor;
import com.google.common.collect.ImmutableMap;

/* compiled from: onSubmitEditingCapture */
public class AppAdsSideshowRow {
    public final FeedProps<GraphQLStory> f4652a;
    public final Uri f4653b;
    public final String f4654c;
    private final String f4655d;
    private final Float f4656e;
    public final String f4657f;
    public final String f4658g;
    public final String f4659h;
    public Boolean f4660i;
    public final ImmutableMap<SecondaryActionType, AppAdsSideshowSecondaryAction> f4661j;

    public AppAdsSideshowRow(FeedProps<GraphQLStory> feedProps) {
        Uri uri;
        String str;
        GraphQLRating graphQLRating;
        Boolean valueOf;
        this.f4652a = feedProps;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).r() == null || StoryAttachmentHelper.o(graphQLStory).r().S() == null) {
            uri = null;
        } else {
            uri = ImageUtil.a(StoryAttachmentHelper.o(graphQLStory).r().S());
        }
        this.f4653b = uri;
        if (graphQLStory == null || graphQLStory.b().isEmpty() || graphQLStory.b().get(0) == null) {
            str = null;
        } else {
            str = ((GraphQLActor) graphQLStory.b().get(0)).aa();
        }
        this.f4654c = str;
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).u() == null) {
            str = null;
        } else {
            str = StoryAttachmentHelper.o(graphQLStory).u().a();
        }
        this.f4655d = str;
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).z() == null) {
            graphQLRating = null;
        } else {
            graphQLRating = StoryAttachmentHelper.o(graphQLStory).z().gq();
        }
        GraphQLRating graphQLRating2 = graphQLRating;
        if (graphQLRating2 != null) {
            this.f4656e = Float.valueOf((float) graphQLRating2.k());
        } else {
            this.f4656e = null;
        }
        if (graphQLStory == null || StoryHierarchyHelper.b(graphQLStory) == null) {
            str = null;
        } else {
            str = StoryHierarchyHelper.b(graphQLStory).a();
        }
        this.f4657f = str;
        if (!(graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null)) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(StoryAttachmentHelper.o(graphQLStory));
            if (a != null) {
                str = a.aB();
                this.f4658g = str;
                this.f4659h = AppAdsSideshowStoryAccessor.m5867g(graphQLStory);
                if (graphQLStory != null || graphQLStory.ab_() == null) {
                    valueOf = Boolean.valueOf(false);
                } else {
                    valueOf = Boolean.valueOf(graphQLStory.ab_().w);
                }
                this.f4660i = valueOf;
                this.f4661j = AppAdsSideshowStoryAccessor.m5868i(graphQLStory);
            }
        }
        str = null;
        this.f4658g = str;
        this.f4659h = AppAdsSideshowStoryAccessor.m5867g(graphQLStory);
        if (graphQLStory != null) {
        }
        valueOf = Boolean.valueOf(false);
        this.f4660i = valueOf;
        this.f4661j = AppAdsSideshowStoryAccessor.m5868i(graphQLStory);
    }
}

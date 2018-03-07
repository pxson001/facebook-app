package com.facebook.feedplugins.multishare;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Preconditions;

/* compiled from: device_fbid */
public class MultiShareAttachmentItemViewModel {
    public final FeedProps<GraphQLStoryAttachment> f13897a;
    public final FeedProps<GraphQLStory> f13898b;
    public final int f13899c;
    public final int f13900d;
    public final boolean f13901e;
    public final boolean f13902f;
    public final boolean f13903g;
    public final float f13904h;
    public final float f13905i;
    public final float f13906j;

    public MultiShareAttachmentItemViewModel(FeedProps<GraphQLStoryAttachment> feedProps, int i, int i2, boolean z, boolean z2, boolean z3, float f, float f2, float f3) {
        Preconditions.checkNotNull(feedProps);
        this.f13897a = feedProps;
        this.f13898b = AttachmentProps.e(feedProps);
        this.f13899c = i;
        this.f13900d = i2;
        this.f13901e = z;
        this.f13902f = z2;
        this.f13903g = z3;
        this.f13904h = f;
        this.f13905i = f2;
        this.f13906j = f3;
    }

    public final int m14695f() {
        return this.f13900d;
    }

    public final float m14696h() {
        return this.f13904h;
    }
}

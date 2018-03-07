package com.facebook.attachments.angora.actionbutton;

import android.view.View.OnClickListener;
import com.facebook.analytics.CurationSurface;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import javax.annotation.Nullable;

/* compiled from: user_paid_mode */
public class SaveButtonProps {
    public final GraphQLNode f871a;
    public final CurationSurface f872b;
    @Nullable
    public final FeedProps<? extends FeedUnit> f873c;
    @Nullable
    public final OnClickListener f874d;
    public final boolean f875e;

    public SaveButtonProps(GraphQLNode graphQLNode, CurationSurface curationSurface, FeedProps<? extends FeedUnit> feedProps, OnClickListener onClickListener, boolean z) {
        this.f871a = graphQLNode;
        this.f872b = curationSurface;
        this.f873c = feedProps;
        this.f874d = onClickListener;
        this.f875e = z;
    }
}

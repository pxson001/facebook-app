package com.facebook.feedplugins.base.footer;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.feed.viewstate.UnseenBackgroundDrawable;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.ViewPadding;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import javax.annotation.Nullable;

/* compiled from: is_offline */
public class FooterBackgroundStyleDefinition {
    public final int f18969a;
    public final int f18970b;
    public final ViewPadding f18971c;
    public final int f18972d;
    public final int f18973e;
    public final DownstateType f18974f;
    public final DividerStyle f18975g;
    public final DividerStyle f18976h;

    public FooterBackgroundStyleDefinition(int i, int i2, ViewPadding viewPadding, int i3, int i4, DownstateType downstateType, DividerStyle dividerStyle, DividerStyle dividerStyle2) {
        this.f18969a = i;
        this.f18970b = i2;
        this.f18971c = viewPadding;
        this.f18972d = i3;
        this.f18973e = i4;
        this.f18974f = downstateType;
        this.f18975g = dividerStyle;
        this.f18976h = dividerStyle2;
    }

    @Nullable
    public final Drawable m26679a(Resources resources, GraphQLStorySeenState graphQLStorySeenState) {
        if (this.f18969a <= 0) {
            return null;
        }
        if (graphQLStorySeenState != GraphQLStorySeenState.UNSEEN_AND_UNREAD || this.f18970b == -1) {
            return resources.getDrawable(this.f18969a);
        }
        return new UnseenBackgroundDrawable(new Drawable[]{resources.getDrawable(this.f18969a), resources.getDrawable(this.f18970b)});
    }

    @Nullable
    public final Drawable m26680b(Resources resources, GraphQLStorySeenState graphQLStorySeenState) {
        if (this.f18972d <= 0) {
            return null;
        }
        if (graphQLStorySeenState != GraphQLStorySeenState.UNSEEN_AND_UNREAD || this.f18973e == -1) {
            return resources.getDrawable(this.f18972d);
        }
        return new UnseenBackgroundDrawable(new Drawable[]{resources.getDrawable(this.f18972d), resources.getDrawable(this.f18973e)});
    }
}

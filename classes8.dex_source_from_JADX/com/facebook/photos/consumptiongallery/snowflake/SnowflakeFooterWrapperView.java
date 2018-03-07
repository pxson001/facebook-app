package com.facebook.photos.consumptiongallery.snowflake;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.FindViewUtil;
import com.facebook.friendsharing.souvenirs.fragment.SouvenirsFragment.7;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.photos.consumptiongallery.Feedback;

/* compiled from: state_home_creation_model */
public class SnowflakeFooterWrapperView extends BaseSnowflakeFooter {
    private SnowflakeDefaultBlingBarView f2145a;
    private SnowflakeDefaultFooterView f2146b;

    public SnowflakeFooterWrapperView(Context context) {
        this(context, null);
    }

    public SnowflakeFooterWrapperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907149);
        setOrientation(1);
        this.f2145a = (SnowflakeDefaultBlingBarView) FindViewUtil.b(this, 2131567504);
        this.f2146b = (SnowflakeDefaultFooterView) FindViewUtil.b(this, 2131567510);
        this.f2146b.f2142m = this.f2145a;
    }

    public final void mo106a() {
        this.f2146b.mo106a();
    }

    public void setListener(7 7) {
        this.f2145a.f2124j = 7;
        this.f2146b.setListener(7);
    }

    public final void mo107a(Feedback feedback, GraphQLStory graphQLStory) {
        this.f2146b.mo107a(feedback, graphQLStory);
    }

    public void setTagButtonEnabled(boolean z) {
        this.f2146b.setTagButtonEnabled(z);
    }

    public void setShareButtonEnabled(boolean z) {
        this.f2146b.setShareButtonEnabled(z);
    }

    public void setMenuButtonEnabled(boolean z) {
        this.f2146b.setMenuButtonEnabled(z);
    }

    public String getLikeText() {
        return this.f2146b.getLikeText();
    }

    public String getCommentText() {
        return this.f2146b.getCommentText();
    }

    public void setLikesCount(int i) {
        this.f2145a.setLikesCount(i);
    }

    public void setCommentsCount(int i) {
        this.f2145a.setCommentsCount(i);
    }

    public void setIsExpanded(boolean z) {
        this.f2145a.setIsExpanded(z);
    }
}

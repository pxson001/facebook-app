package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.net.Uri;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;

/* compiled from: android_native_article_webview_ad_impression */
public abstract class AbstractReactionHeaderView extends CustomLinearLayout {
    private TextWithEntitiesView f19453a = ((TextWithEntitiesView) a(2131566653));
    private TextWithEntitiesView f19454b = ((TextWithEntitiesView) a(2131566648));

    protected abstract int getContentViewId();

    public abstract void setIconUri(@Nullable Uri uri);

    public AbstractReactionHeaderView(Context context) {
        super(context);
        setContentView(getContentViewId());
    }
}

package com.facebook.groups.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel;
import com.facebook.groups.staticadapter.StaticAdapter.Bindable;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: TimelineEarlyFetcherRequest */
public class GroupsFeedBrowseCategoriesBar extends CustomFrameLayout implements Bindable<FetchGroupInformationModel> {
    @Inject
    public FbUriIntentHandler f22117a;
    public FetchGroupInformationModel f22118b;

    public static void m23224a(Object obj, Context context) {
        ((GroupsFeedBrowseCategoriesBar) obj).f22117a = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public final void mo758a(Object obj) {
        this.f22118b = (FetchGroupInformationModel) obj;
    }

    public GroupsFeedBrowseCategoriesBar(Context context) {
        this(context, null);
    }

    private GroupsFeedBrowseCategoriesBar(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2131626078);
        Class cls = GroupsFeedBrowseCategoriesBar.class;
        m23224a(this, getContext());
        View.inflate(context, 2130904703, this);
        ((FbButton) c(2131562751)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GroupsFeedBrowseCategoriesBar f22116b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -889369200);
                this.f22116b.f22117a.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, StringFormatUtil.formatStrLocaleSafe("/groups/browse_categories/?group_id=%s", this.f22116b.f22118b.gW_())));
                Logger.a(2, EntryType.UI_INPUT_END, -704791471, a);
            }
        });
    }
}

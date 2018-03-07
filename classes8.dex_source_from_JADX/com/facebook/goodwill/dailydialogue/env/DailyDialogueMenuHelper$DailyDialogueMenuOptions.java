package com.facebook.goodwill.dailydialogue.env;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: fetchVideosUploadedQuery_%s-%s */
class DailyDialogueMenuHelper$DailyDialogueMenuOptions extends BaseFeedStoryMenuOptions<FeedUnit> {
    final /* synthetic */ DailyDialogueMenuHelper f13437b;

    /* compiled from: fetchVideosUploadedQuery_%s-%s */
    class C14351 implements OnMenuItemClickListener {
        final /* synthetic */ DailyDialogueMenuHelper$DailyDialogueMenuOptions f13436a;

        C14351(DailyDialogueMenuHelper$DailyDialogueMenuOptions dailyDialogueMenuHelper$DailyDialogueMenuOptions) {
            this.f13436a = dailyDialogueMenuHelper$DailyDialogueMenuOptions;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f13436a.f13437b.r.run();
            return true;
        }
    }

    public final void m15059a(Menu menu, FeedProps<FeedUnit> feedProps, View view) {
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        MenuItem add = menu.add(2131233432);
        add.setOnMenuItemClickListener(new C14351(this));
        this.f13437b.a(add, 2130839920, feedUnit);
    }

    DailyDialogueMenuHelper$DailyDialogueMenuOptions(DailyDialogueMenuHelper dailyDialogueMenuHelper) {
        this.f13437b = dailyDialogueMenuHelper;
        super(dailyDialogueMenuHelper);
    }

    public final boolean m15060a(FeedProps<FeedUnit> feedProps) {
        return true;
    }

    @VisibleForTesting
    public final boolean m15061c(FeedProps<? extends FeedUnit> feedProps) {
        return true;
    }
}

package com.facebook.goodwill.dailydialogue.env;

import android.content.Context;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: method/user.bypassLoginWithConfirmedMessengerCredentials */
public class DailyDialogueEnvironment extends BaseFeedEnvironment {
    private final BaseFeedStoryMenuHelper f13568m;

    public final FeedListType mo2446c() {
        return DailyDialogueFeedListType.f13573a;
    }

    @Inject
    public DailyDialogueEnvironment(Context context, DailyDialogueMenuHelperProvider dailyDialogueMenuHelperProvider, @Assisted Delegate delegate, @Assisted Runnable runnable, @Assisted Runnable runnable2) {
        super(context, runnable, delegate);
        this.f13568m = dailyDialogueMenuHelperProvider.m19952a(runnable2, this);
    }

    public final BaseFeedStoryMenuHelper mo2448e() {
        return this.f13568m;
    }
}

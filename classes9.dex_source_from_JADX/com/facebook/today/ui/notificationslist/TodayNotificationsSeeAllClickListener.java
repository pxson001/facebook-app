package com.facebook.today.ui.notificationslist;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionSource;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.today.notifications.TodayNotificationsHolder;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: transcoded_video_larger */
public class TodayNotificationsSeeAllClickListener implements OnClickListener {
    private final UriIntentMapper f1379a;
    private final ReactionInteractionTracker f1380b;
    private final boolean f1381c;
    private final SecureContextHelper f1382d;
    private final TodayNotificationsHolder f1383e;
    private final String f1384f;
    private final String f1385g;

    @Inject
    public TodayNotificationsSeeAllClickListener(@Assisted Boolean bool, @Assisted ReactionInteractionTracker reactionInteractionTracker, @Assisted String str, @Assisted String str2, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, TodayNotificationsHolder todayNotificationsHolder) {
        this.f1379a = uriIntentMapper;
        this.f1380b = reactionInteractionTracker;
        this.f1381c = bool.booleanValue();
        this.f1382d = secureContextHelper;
        this.f1383e = todayNotificationsHolder;
        this.f1384f = str;
        this.f1385g = str2;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 404594213);
        if (this.f1381c) {
            this.f1380b.a(this.f1384f, this.f1385g, UnitInteractionSource.FOOTER, UnitInteractionType.OPEN_ALL_NOTIFICATIONS_TAP);
            this.f1382d.a(this.f1379a.a(view.getContext(), FBLinks.ci), view.getContext());
        } else {
            this.f1380b.a(this.f1384f, this.f1385g, UnitInteractionSource.FOOTER, UnitInteractionType.NOTIFICATIONS_INLINE_EXPANSION_TAP);
            this.f1383e.m1367a(true);
            this.f1383e.m1371g();
        }
        LogUtils.a(1507911422, a);
    }
}

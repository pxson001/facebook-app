package com.facebook.notifications.multirow;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.Assisted;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.ui.touchlistener.HighlightViewUtil;
import javax.inject.Inject;

/* compiled from: custom_cta_mobile_back_click_no */
public class TodayNotificationLongClickListener implements OnLongClickListener {
    private final NotificationsEdgeFields f16138a;
    private final NotificationsInlineActionsHelper f16139b;
    private final NotificationsRowWithActionHelper f16140c;
    private final TodayExperimentController f16141d;

    @Inject
    public TodayNotificationLongClickListener(@Assisted NotificationsEdgeFields notificationsEdgeFields, NotificationsInlineActionsHelper notificationsInlineActionsHelper, NotificationsRowWithActionHelper notificationsRowWithActionHelper, TodayExperimentController todayExperimentController) {
        this.f16138a = notificationsEdgeFields;
        this.f16139b = notificationsInlineActionsHelper;
        this.f16140c = notificationsRowWithActionHelper;
        this.f16141d = todayExperimentController;
    }

    public boolean onLongClick(View view) {
        this.f16138a.k().g();
        this.f16139b.a(this.f16138a, view.getContext(), view, this.f16140c.a(this.f16138a.k().g(), this.f16138a.k().c()), 0);
        if (this.f16141d.z()) {
            View findViewById = view.findViewById(2131567802);
            if (findViewById instanceof ViewGroup) {
                HighlightViewUtil.a((ViewGroup) findViewById, 3);
            }
            if (findViewById instanceof ImageBlockLayout) {
                HighlightViewUtil.a((ImageBlockLayout) findViewById, 3);
            }
        }
        return true;
    }
}

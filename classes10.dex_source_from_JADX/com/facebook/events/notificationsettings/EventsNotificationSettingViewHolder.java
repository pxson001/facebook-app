package com.facebook.events.notificationsettings;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.notificationsettings.EventsNotificationSettingsAdapter.C25191;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel.PossibleNotificationSubscriptionLevelsModel.EdgesModel.NodeModel;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ch */
public class EventsNotificationSettingViewHolder extends ViewHolder {
    public CheckedContentView f17792l;
    public NodeModel f17793m;
    public C25191 f17794n;
    public final OnClickListener f17795o = new C25181(this);

    /* compiled from: ch */
    public class C25181 implements OnClickListener {
        final /* synthetic */ EventsNotificationSettingViewHolder f17791a;

        public C25181(EventsNotificationSettingViewHolder eventsNotificationSettingViewHolder) {
            this.f17791a = eventsNotificationSettingViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1428896506);
            if (this.f17791a.f17794n != null) {
                this.f17791a.f17794n.m18147a(this.f17791a.f17793m.m18170k());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1577527376, a);
        }
    }

    public EventsNotificationSettingViewHolder(CheckedContentView checkedContentView) {
        super(checkedContentView);
        this.f17792l = checkedContentView;
    }
}

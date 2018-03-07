package com.facebook.events.widget.eventcard;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: calculate_stats */
public class EventActionButtonStateSelector$PrivateEventOptionsPresenter implements OnClickListener {
    final /* synthetic */ EventActionButtonStateSelector f17907a;
    public final GraphQLEventGuestStatus f17908b;

    public EventActionButtonStateSelector$PrivateEventOptionsPresenter(EventActionButtonStateSelector eventActionButtonStateSelector, GraphQLEventGuestStatus graphQLEventGuestStatus) {
        this.f17907a = eventActionButtonStateSelector;
        this.f17908b = graphQLEventGuestStatus;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1188102194);
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        PopoverMenu c = figPopoverMenuWindow.c();
        for (final GraphQLEventGuestStatus graphQLEventGuestStatus : EventActionButtonStateSelector.a) {
            int i;
            boolean z = graphQLEventGuestStatus == this.f17908b;
            switch (EventActionButtonStateSelector$1.f17901b[graphQLEventGuestStatus.ordinal()]) {
                case 1:
                    i = 2131233837;
                    break;
                case 2:
                    i = 2131233838;
                    break;
                case 3:
                    i = 2131233839;
                    break;
                default:
                    i = 0;
                    break;
            }
            MenuItemImpl a2 = c.a(i);
            a2.setIcon(EventActionButtonStateSelector.a(this.f17907a, graphQLEventGuestStatus, z));
            a2.setCheckable(true);
            a2.setChecked(z);
            a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ EventActionButtonStateSelector$PrivateEventOptionsPresenter f17906b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f17906b.f17907a.e.a(this.f17906b.f17908b, graphQLEventGuestStatus);
                    return true;
                }
            });
        }
        figPopoverMenuWindow.f(view);
        LogUtils.a(-8864086, a);
    }
}

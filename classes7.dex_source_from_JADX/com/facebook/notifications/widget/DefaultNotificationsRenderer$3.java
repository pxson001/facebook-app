package com.facebook.notifications.widget;

import android.graphics.Point;
import android.view.View;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper$RowWithActionTaken;
import com.facebook.notifications.widget.SwitchableNotificationView.State;
import javax.annotation.Nullable;

/* compiled from: methods */
public class DefaultNotificationsRenderer$3 {
    final /* synthetic */ NotificationsRowWithActionHelper f8999a;
    final /* synthetic */ GraphQLStory f9000b;
    final /* synthetic */ SwitchableNotificationView f9001c;
    final /* synthetic */ NotificationsRowWithActionHelper$RowWithActionTaken f9002d;
    final /* synthetic */ int f9003e;
    final /* synthetic */ DefaultNotificationsRenderer f9004f;

    DefaultNotificationsRenderer$3(DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, GraphQLStory graphQLStory, SwitchableNotificationView switchableNotificationView, NotificationsRowWithActionHelper$RowWithActionTaken notificationsRowWithActionHelper$RowWithActionTaken, int i) {
        this.f9004f = defaultNotificationsRenderer;
        this.f8999a = notificationsRowWithActionHelper;
        this.f9000b = graphQLStory;
        this.f9001c = switchableNotificationView;
        this.f9002d = notificationsRowWithActionHelper$RowWithActionTaken;
        this.f9003e = i;
    }

    public final void m10858a(@Nullable View view) {
        String str;
        NotificationsRowWithActionHelper notificationsRowWithActionHelper = this.f8999a;
        String g = this.f9000b.g();
        if (notificationsRowWithActionHelper.f.d()) {
            notificationsRowWithActionHelper.k.remove(g);
        } else {
            notificationsRowWithActionHelper.j = null;
        }
        this.f9001c.m10897a(State.NOTIFICATION, true, view == null ? null : (Point) view.getTag(2131558428));
        NotificationsActionExecutor notificationsActionExecutor = this.f9004f.e;
        String str2 = this.f9002d.f8906e;
        if (this.f9004f.d.c()) {
            str = "chevron";
        } else {
            str = "long_press";
        }
        notificationsActionExecutor.a(str2, str, this.f9000b, this.f9003e);
    }
}

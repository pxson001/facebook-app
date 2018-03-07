package com.facebook.notifications.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.widget.listview.BetterListView;

/* compiled from: exception when running mDevicePostMethod */
public class NotificationsListView extends BetterListView {
    public AbstractFbErrorReporter f12722a;

    private static <T extends View> void m13535a(Class<T> cls, T t) {
        m13536a((Object) t, t.getContext());
    }

    private static void m13536a(Object obj, Context context) {
        ((NotificationsListView) obj).f12722a = (AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(context));
    }

    public NotificationsListView(Context context) {
        super(context);
        m13535a(NotificationsListView.class, (View) this);
    }

    public NotificationsListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13535a(NotificationsListView.class, (View) this);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        try {
            return super.drawChild(canvas, view, j);
        } catch (StringIndexOutOfBoundsException e) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof NotificationsAdapter) {
                Object item = adapter.getItem(((Integer) view.getTag(2131558555)).intValue());
                if (item instanceof FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
                    this.f12722a.b("notification_out_of_bounds_category", ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) item).mo822k().toString());
                }
            }
            throw e;
        }
    }
}

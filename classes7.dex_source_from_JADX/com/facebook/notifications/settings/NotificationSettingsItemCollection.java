package com.facebook.notifications.settings;

import com.facebook.api.feed.data.collections.ListItemCollection;
import java.util.ArrayList;
import java.util.List;

/* compiled from: minutiae_verb_picker_tti_cached */
public class NotificationSettingsItemCollection implements ListItemCollection<NotifOptionSetNode> {
    public final List<NotifOptionSetNode> f8727a = new ArrayList();

    public final int m10696a() {
        return this.f8727a.size();
    }

    public final Object m10697a(int i) {
        return (NotifOptionSetNode) this.f8727a.get(i);
    }
}

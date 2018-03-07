package com.facebook.notifications.connectioncontroller;

import com.facebook.api.feed.data.collections.ObservableListItemCollection;
import com.facebook.common.collect.ListObserver;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: timeline_collection_app_sections */
public class NotificationsConnectionCollection implements ObservableListItemCollection<NotificationsEdgeFieldsModel> {
    @Nullable
    public ConnectionState<NotificationsEdgeFieldsModel> f907a;
    public ListObserver<NotificationsEdgeFieldsModel> f908b;

    public static NotificationsConnectionCollection m1177a(InjectorLike injectorLike) {
        return new NotificationsConnectionCollection();
    }

    public final /* synthetic */ Object m1179a(int i) {
        return m1181b(i);
    }

    public final int m1178a() {
        return this.f907a == null ? 0 : this.f907a.d();
    }

    public final NotificationsEdgeFieldsModel m1181b(int i) {
        return (NotificationsEdgeFieldsModel) this.f907a.a(i);
    }

    public final void m1180a(ListObserver<NotificationsEdgeFieldsModel> listObserver) {
        Preconditions.checkState(this.f908b == null);
        this.f908b = listObserver;
    }

    public final void m1182b(ListObserver<NotificationsEdgeFieldsModel> listObserver) {
        Preconditions.checkArgument(listObserver == this.f908b);
        this.f908b = null;
    }
}

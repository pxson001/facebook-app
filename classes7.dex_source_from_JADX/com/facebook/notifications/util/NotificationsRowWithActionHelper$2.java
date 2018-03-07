package com.facebook.notifications.util;

import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: minutiae_configuration */
class NotificationsRowWithActionHelper$2 implements Runnable {
    final /* synthetic */ NotificationsRowWithActionHelper$RowWithActionTaken f8897a;
    final /* synthetic */ NotificationsRowWithActionHelper f8898b;

    NotificationsRowWithActionHelper$2(NotificationsRowWithActionHelper notificationsRowWithActionHelper, NotificationsRowWithActionHelper$RowWithActionTaken notificationsRowWithActionHelper$RowWithActionTaken) {
        this.f8898b = notificationsRowWithActionHelper;
        this.f8897a = notificationsRowWithActionHelper$RowWithActionTaken;
    }

    public void run() {
        if (this.f8898b.f.d()) {
            this.f8898b.e.a(new ArrayList(this.f8898b.k.keySet()), false);
            this.f8898b.k.clear();
            return;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f8898b.j.f8903b);
        this.f8898b.e.a(arrayList, false);
        if (this.f8898b.j != null) {
            GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper = this.f8898b.e;
            String str = this.f8898b.j.f8902a;
            graphQLNotificationsContentProviderHelper.g.c(str);
            graphQLNotificationsContentProviderHelper.h.c(str);
            this.f8898b.j = this.f8897a;
            return;
        }
        this.f8898b.b.a(getClass().getSimpleName(), "mRowWithActionTaken was null when trying to delete row from cache");
    }
}

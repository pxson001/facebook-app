package com.facebook.notifications.provider;

import java.util.List;

/* compiled from: mqtt_rewrite_rules */
class GraphQLNotificationsContentProviderHelper$2 implements Runnable {
    final /* synthetic */ List f8670a;
    final /* synthetic */ boolean f8671b;
    final /* synthetic */ GraphQLNotificationsContentProviderHelper f8672c;

    GraphQLNotificationsContentProviderHelper$2(GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, List list, boolean z) {
        this.f8672c = graphQLNotificationsContentProviderHelper;
        this.f8670a = list;
        this.f8671b = z;
    }

    public void run() {
        GraphQLNotificationsContentProviderHelper.b(this.f8672c, this.f8670a, this.f8671b);
    }
}

package com.facebook.notifications.multirow;

import android.os.Bundle;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.sections.NotificationsSectionBuilder;
import com.facebook.notifications.sections.NotificationsSectionSplitter;
import com.facebook.notifications.sections.SeenNotificationsSectionSplitter;
import com.facebook.notifications.sections.StickyNotificationsSectionSplitter;
import com.facebook.notifications.sections.UnseenNotificationsSectionSplitter;
import com.facebook.today.abtest.TodayExperimentController;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_fonts */
public class NotificationsFeedCollection implements ListItemCollection<Object> {
    private final GraphQLNotificationsContentProviderHelper f16042a;
    public NotificationHolder f16043b = new NotificationHolder(this);
    public NotificationHolder f16044c = new NotificationHolder(this);
    private ImmutableList<Object> f16045d = RegularImmutableList.a;
    private NotificationsSectionBuilder f16046e;
    private boolean f16047f = false;

    /* compiled from: custom_fonts */
    public class NotificationHolder {
        public Map<String, Integer> f16038a = new HashMap();
        public List<NotificationsEdgeFields> f16039b = new ArrayList();
        public Map<String, NotificationsEdgeFields> f16040c = new HashMap();
        final /* synthetic */ NotificationsFeedCollection f16041d;

        public NotificationHolder(NotificationsFeedCollection notificationsFeedCollection) {
            this.f16041d = notificationsFeedCollection;
        }

        public final int m18832a() {
            return this.f16039b.size();
        }

        public final void m18835b() {
            this.f16039b.clear();
            this.f16038a.clear();
            this.f16040c.clear();
        }

        public final void m18834a(Collection<NotificationsEdgeFields> collection) {
            int size = this.f16039b.size();
            this.f16039b.addAll(collection);
            for (int i = size; i < this.f16039b.size(); i++) {
                NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) this.f16039b.get(i);
                if (!(notificationsEdgeFields.k() == null || Strings.isNullOrEmpty(notificationsEdgeFields.k().c()))) {
                    this.f16038a.put(notificationsEdgeFields.k().c(), Integer.valueOf(i));
                    m18831a(notificationsEdgeFields);
                }
            }
        }

        public final void m18833a(NotificationsEdgeFields notificationsEdgeFields, NotificationsEdgeFields notificationsEdgeFields2) {
            String c = notificationsEdgeFields.k().c();
            if (c.equals(notificationsEdgeFields2.k().c()) && this.f16038a.containsKey(c)) {
                this.f16039b.set(((Integer) this.f16038a.get(c)).intValue(), notificationsEdgeFields2);
                m18831a(notificationsEdgeFields2);
            }
        }

        private void m18831a(NotificationsEdgeFields notificationsEdgeFields) {
            if (notificationsEdgeFields.n() != null && !Strings.isNullOrEmpty(notificationsEdgeFields.n().d())) {
                this.f16040c.put(notificationsEdgeFields.n().d(), notificationsEdgeFields);
            }
        }
    }

    public static NotificationsFeedCollection m18836a(InjectorLike injectorLike) {
        return new NotificationsFeedCollection(GraphQLNotificationsContentProviderHelper.a(injectorLike), new NotificationsSectionBuilder(new UnseenNotificationsSectionSplitter(TodayExperimentController.a(injectorLike)), new StickyNotificationsSectionSplitter(TodayExperimentController.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), new SeenNotificationsSectionSplitter(TodayExperimentController.a(injectorLike)), TodayExperimentController.a(injectorLike)));
    }

    @Inject
    public NotificationsFeedCollection(GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, NotificationsSectionBuilder notificationsSectionBuilder) {
        this.f16042a = graphQLNotificationsContentProviderHelper;
        this.f16046e = notificationsSectionBuilder;
    }

    private void m18837a(boolean z) {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f16044c.f16039b);
        arrayList.addAll(this.f16043b.f16039b);
        NotificationsSectionBuilder notificationsSectionBuilder = this.f16046e;
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_new_data", z);
        for (NotificationsSectionSplitter a : notificationsSectionBuilder.a) {
            a.a(bundle);
        }
        this.f16045d = this.f16046e.a(arrayList);
    }

    public final Object m18840a(int i) {
        return this.f16045d.get(i);
    }

    public final int m18838a() {
        return this.f16045d.size();
    }

    public final void m18841a(long j) {
        NotificationsSectionBuilder notificationsSectionBuilder = this.f16046e;
        Bundle bundle = new Bundle();
        bundle.putLong("latest_notification_creation_time", j);
        bundle.putBoolean("should_rebuild_sections", true);
        for (NotificationsSectionSplitter a : notificationsSectionBuilder.a) {
            a.a(bundle);
        }
        m18837a(false);
    }

    public final void m18843a(@Nullable Collection<NotificationsEdgeFields> collection) {
        this.f16044c.m18835b();
        if (!CollectionUtil.a(collection)) {
            this.f16044c.m18834a((Collection) collection);
            if (!this.f16047f) {
                this.f16043b.m18834a(this.f16042a.c());
                this.f16047f = true;
            }
            m18837a(true);
        }
    }

    public final void m18846b(@Nullable Collection<NotificationsEdgeFields> collection) {
        this.f16043b.m18835b();
        if (!CollectionUtil.a(collection)) {
            this.f16043b.m18834a((Collection) collection);
            m18837a(true);
        }
    }

    public final boolean m18847e() {
        return m18838a() <= 0;
    }

    public final int m18839a(String str) {
        if (this.f16044c.f16038a.containsKey(str)) {
            return ((Integer) this.f16044c.f16038a.get(str)).intValue();
        }
        if (this.f16043b.f16038a.containsKey(str)) {
            return ((Integer) this.f16043b.f16038a.get(str)).intValue() + this.f16044c.m18832a();
        }
        return -1;
    }

    @Nullable
    public final NotificationsEdgeFields m18845b(String str) {
        if (this.f16044c.f16040c.containsKey(str)) {
            return (NotificationsEdgeFields) this.f16044c.f16040c.get(str);
        }
        if (this.f16043b.f16040c.containsKey(str)) {
            return (NotificationsEdgeFields) this.f16043b.f16040c.get(str);
        }
        return null;
    }

    public final boolean m18844a(NotificationsEdgeFields notificationsEdgeFields) {
        return this.f16043b.f16038a.containsKey(notificationsEdgeFields.k().c());
    }

    public final void m18842a(NotificationsEdgeFields notificationsEdgeFields, NotificationsEdgeFields notificationsEdgeFields2) {
        this.f16044c.m18833a(notificationsEdgeFields, notificationsEdgeFields2);
        this.f16043b.m18833a(notificationsEdgeFields, notificationsEdgeFields2);
        m18837a(false);
    }
}

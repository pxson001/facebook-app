package com.facebook.notifications.notificationsfriending.adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.notificationsfriending.NotificationsFriendingAdapter.ViewTypes;
import com.facebook.notifications.notificationsfriending.abtest.ExperimentsForNotificationsFriendingAbTestModule;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.notificationsfriending.logging.NotificationsFriendingAnalyticsLogger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.RowWithActionTaken;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.notifications.widget.SwitchableNotificationView;
import com.facebook.notifications.widget.SwitchableNotificationView.State;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tigonliger */
public class NotificationsAdapterSection implements NotificationsFriendingAdapterSection<NotificationsEdgeFields> {
    private static final String f1004a = NotificationsFriendingAdapterSection.class.getSimpleName();
    private final AbstractFbErrorReporter f1005b;
    public final FbUriIntentHandler f1006c;
    private final NotificationsFriendingExperimentController f1007d;
    private final DefaultNotificationsRenderer f1008e;
    private final NotificationsRowWithActionHelper f1009f;
    public final NotificationsFriendingAnalyticsLogger f1010g;
    public final Resources f1011h;
    public final OnSectionUpdatedListener f1012i;
    public boolean f1013j;
    public final List<NotificationsEdgeFields> f1014k;
    public final List<NotificationsEdgeFields> f1015l;
    public Optional<LoadResult> f1016m = Absent.INSTANCE;

    /* compiled from: tigonliger */
    public class C01431 implements OnClickListener {
        final /* synthetic */ NotificationsAdapterSection f1002a;

        public C01431(NotificationsAdapterSection notificationsAdapterSection) {
            this.f1002a = notificationsAdapterSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 393342374);
            int g = this.f1002a.mo21g();
            this.f1002a.f1013j = true;
            this.f1002a.f1014k.addAll(this.f1002a.f1015l);
            this.f1002a.f1015l.clear();
            this.f1002a.f1010g.m1392c(g, this.f1002a.mo21g());
            this.f1002a.f1012i.mo13e();
            Logger.a(2, EntryType.UI_INPUT_END, -1449666657, a);
        }
    }

    /* compiled from: tigonliger */
    public class C01442 implements OnClickListener {
        final /* synthetic */ NotificationsAdapterSection f1003a;

        public C01442(NotificationsAdapterSection notificationsAdapterSection) {
            this.f1003a = notificationsAdapterSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1284558351);
            Bundle bundle = new Bundle();
            bundle.putString("fragment_title", this.f1003a.f1011h.getString(2131241743));
            this.f1003a.f1006c.a(view.getContext(), FBLinks.cj, bundle);
            this.f1003a.f1010g.m1388a(this.f1003a.mo21g());
            Logger.a(2, EntryType.UI_INPUT_END, 1868628636, a);
        }
    }

    /* compiled from: tigonliger */
    public enum LoadResult {
        SUCCESS,
        FAILURE
    }

    @Nullable
    public final /* synthetic */ Object mo16b(int i) {
        return m1345d(i);
    }

    @Inject
    public NotificationsAdapterSection(AbstractFbErrorReporter abstractFbErrorReporter, FbUriIntentHandler fbUriIntentHandler, NotificationsFriendingExperimentController notificationsFriendingExperimentController, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, NotificationsFriendingAnalyticsLogger notificationsFriendingAnalyticsLogger, Resources resources, @Assisted OnSectionUpdatedListener onSectionUpdatedListener) {
        this.f1005b = abstractFbErrorReporter;
        this.f1006c = fbUriIntentHandler;
        this.f1007d = notificationsFriendingExperimentController;
        this.f1008e = defaultNotificationsRenderer;
        this.f1009f = notificationsRowWithActionHelper;
        this.f1011h = resources;
        this.f1012i = onSectionUpdatedListener;
        this.f1010g = notificationsFriendingAnalyticsLogger;
        this.f1014k = new ArrayList();
        this.f1015l = new ArrayList();
    }

    public final void m1350b(@Nullable List<NotificationsEdgeFields> list, boolean z) {
        this.f1016m = Optional.of(LoadResult.SUCCESS);
        if (list == null || list.isEmpty()) {
            this.f1014k.clear();
            this.f1015l.clear();
            return;
        }
        if (this.f1014k.isEmpty()) {
            int a;
            if (z) {
                a = this.f1007d.a.a(ExperimentsForNotificationsFriendingAbTestModule.g, 3);
            } else {
                a = this.f1007d.g();
            }
            m1342a(list, this.f1014k, a, this.f1007d.h());
        } else {
            List arrayList = new ArrayList(this.f1014k);
            NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) arrayList.get(0);
            this.f1014k.clear();
            int h = this.f1007d.h();
            m1344a(arrayList, (List) list, this.f1014k, notificationsEdgeFields.k().V(), h);
            if (this.f1014k.isEmpty()) {
                m1342a(list, this.f1014k, this.f1007d.g(), h);
            }
        }
        if (this.f1007d.a.a(ExperimentsForNotificationsFriendingAbTestModule.b, false) && !this.f1013j) {
            m1343a((List) list, this.f1014k, this.f1015l, this.f1007d.a.a(ExperimentsForNotificationsFriendingAbTestModule.d, 5), this.f1007d.a.a(ExperimentsForNotificationsFriendingAbTestModule.c, 10));
        }
    }

    public final void m1353c(int i) {
        if (i < mo21g()) {
            NotificationsEdgeFields d = m1345d(i);
            if (d != null) {
                this.f1014k.set(i, NotificationsMutator.a(d));
                this.f1012i.mo13e();
            }
        }
    }

    public final boolean m1351b() {
        return this.f1016m.isPresent();
    }

    public final String mo17c() {
        return this.f1011h.getString(2131233663);
    }

    public final boolean mo18d() {
        return false;
    }

    @Nullable
    public final String mo19e() {
        return null;
    }

    @Nullable
    public final OnClickListener mo20f() {
        return null;
    }

    public final int mo21g() {
        return this.f1014k.isEmpty() ? 1 : this.f1014k.size();
    }

    @Nullable
    private NotificationsEdgeFields m1345d(int i) {
        if (this.f1014k.isEmpty() || i >= this.f1014k.size()) {
            return null;
        }
        return (NotificationsEdgeFields) this.f1014k.get(i);
    }

    public final View mo14a(int i, View view, ViewGroup viewGroup) {
        if (this.f1014k.isEmpty()) {
            return m1340a(view, viewGroup);
        }
        View a = view != null ? view : this.f1008e.a(viewGroup);
        NotificationsEdgeFields d = m1345d(i);
        if (!(d == null || d.k() == null)) {
            Object obj;
            String g = d.k().g();
            if (this.f1009f.b(g)) {
                obj = 1;
            } else {
                obj = null;
            }
            3 a2 = this.f1009f.a(g, d.k().c());
            this.f1008e.a(a, d, a2, i, false, null);
            if (obj != null) {
                RowWithActionTaken c = this.f1009f.c(g);
                if (c != null) {
                    this.f1008e.a(a, c, this.f1009f, d, a2, i);
                    if (a instanceof SwitchableNotificationView) {
                        ((SwitchableNotificationView) a).a(State.POST_FEEDBACK, c.g);
                        c.g = false;
                    }
                }
            }
        }
        a.setTag(2131558555, Integer.valueOf(i));
        return a;
    }

    public final boolean mo22h() {
        return !this.f1014k.isEmpty();
    }

    public final ViewTypes mo15a(int i) {
        return this.f1014k.isEmpty() ? ViewTypes.NOTIFICATIONS_EMPTY_VIEW : ViewTypes.NOTIFICATION;
    }

    public final boolean mo23i() {
        return !this.f1014k.isEmpty();
    }

    public final ViewTypes mo24j() {
        return m1346o() ? ViewTypes.SEE_MORE_FOOTER : ViewTypes.SEE_ALL_FOOTER;
    }

    public final OnClickListener mo25k() {
        return m1346o() ? new C01431(this) : new C01442(this);
    }

    private static void m1342a(List<NotificationsEdgeFields> list, List<NotificationsEdgeFields> list2, int i, int i2) {
        int min = Math.min(list.size(), i2) - 1;
        while (min >= 0) {
            if (GraphQLStorySeenState.UNSEEN_AND_UNREAD.equals(((NotificationsEdgeFields) list.get(min)).k().au()) || min <= i - 1) {
                list2.addAll(list.subList(0, min + 1));
                return;
            }
            min--;
        }
    }

    private static void m1344a(List<NotificationsEdgeFields> list, List<NotificationsEdgeFields> list2, List<NotificationsEdgeFields> list3, long j, int i) {
        Set hashSet = new HashSet();
        for (NotificationsEdgeFields notificationsEdgeFields : list2) {
            if (notificationsEdgeFields.k().V() <= j) {
                break;
            }
            list3.add(notificationsEdgeFields);
            if (!Strings.isNullOrEmpty(notificationsEdgeFields.k().c())) {
                hashSet.add(notificationsEdgeFields.k().c());
            }
            if (list3.size() >= i) {
                return;
            }
        }
        Map a = m1341a((List) list2);
        for (NotificationsEdgeFields notificationsEdgeFields2 : list) {
            if (list3.size() < i) {
                String c = notificationsEdgeFields2.k().c();
                Object obj = (Strings.isNullOrEmpty(c) || !a.containsKey(c)) ? null : 1;
                boolean contains = hashSet.contains(c);
                if (!(obj == null || contains)) {
                    list3.add(a.get(c));
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, NotificationsEdgeFields> m1341a(List<NotificationsEdgeFields> list) {
        Map<String, NotificationsEdgeFields> hashMap = new HashMap();
        for (NotificationsEdgeFields notificationsEdgeFields : list) {
            if (!Strings.isNullOrEmpty(notificationsEdgeFields.k().c())) {
                hashMap.put(notificationsEdgeFields.k().c(), notificationsEdgeFields);
            }
        }
        return hashMap;
    }

    private void m1343a(List<NotificationsEdgeFields> list, List<NotificationsEdgeFields> list2, List<NotificationsEdgeFields> list3, int i, int i2) {
        list3.clear();
        if (!list2.isEmpty()) {
            int indexOf = list.indexOf(list2.get(list2.size() - 1));
            if (indexOf == -1) {
                this.f1005b.a(f1004a, "Notification in truncated list not present in full list");
                return;
            }
            int size = (list.size() - indexOf) - 1;
            if (size >= i) {
                list3.addAll(list.subList(indexOf + 1, (indexOf + Math.min(i2, size)) + 1));
            }
        }
    }

    private View m1340a(@Nullable View view, ViewGroup viewGroup) {
        view = view != null ? (ImageWithTextView) view : (ImageWithTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905498, viewGroup, false);
        CharSequence string = (this.f1016m.isPresent() && this.f1016m.get() == LoadResult.SUCCESS) ? this.f1011h.getString(2131233662) : this.f1011h.getString(2131241745);
        view.setText(string);
        return view;
    }

    private boolean m1346o() {
        return (this.f1013j || this.f1015l.isEmpty()) ? false : true;
    }
}

package com.facebook.notifications.widget;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLNotifImportanceType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.action.NotificationsInlineNotificationNuxManager;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.Builder;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.NotifOptionSetsModel;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsMutator;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.RowWithActionTaken;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.notifications.util.NotificationsUtils.5;
import com.facebook.notifications.widget.SwitchableNotificationView.State;
import com.facebook.today.abtest.ExperimentsForTodayAbTestModule;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: expectedKeys */
public class NotificationsAdapter extends BaseAdapter {
    private final Clock f12641a;
    private final GraphQLNotificationsContentProviderHelper f12642b;
    public final NotificationsInlineNotificationNuxManager f12643c;
    public final DefaultNotificationsRenderer f12644d;
    private final NotificationsRowWithActionHelper f12645e;
    private final NotificationsUtils f12646f;
    public final TodayExperimentController f12647g;
    public final AbstractFbErrorReporter f12648h;
    public final int f12649i;
    public final NotificationsList f12650j = new NotificationsList(this);
    public int f12651k = -1;
    public int f12652l = -1;
    private boolean f12653m;

    @VisibleForTesting
    /* compiled from: expectedKeys */
    public class NotificationsList {
        public final /* synthetic */ NotificationsAdapter f12686a;
        public final List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> f12687b = new ArrayList();
        public final List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> f12688c = new ArrayList();
        public final List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> f12689d = new ArrayList();

        protected NotificationsList(NotificationsAdapter notificationsAdapter) {
            this.f12686a = notificationsAdapter;
        }

        public final int m13497a() {
            return this.f12689d.size();
        }

        @Nullable
        public final FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m13498a(int i) {
            int size = i - this.f12687b.size();
            if (i >= 0 && i < this.f12687b.size()) {
                return (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f12687b.get(i);
            }
            if (size < 0 || size >= this.f12688c.size()) {
                return null;
            }
            return (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) this.f12688c.get(size);
        }

        public final void m13501c(@Nullable Collection<? extends FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> collection) {
            if (collection != null) {
                this.f12688c.addAll(collection);
            }
            m13500b();
        }

        public final void m13499a(FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields, int i) {
            int size = i - this.f12687b.size();
            if (i < 30 && i < this.f12687b.size()) {
                this.f12687b.set(i, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
            } else if (size >= 0 && size < this.f12688c.size()) {
                this.f12688c.set(size, fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields);
            }
        }

        public final void m13500b() {
            this.f12689d.clear();
            this.f12689d.addAll(this.f12687b);
            this.f12689d.addAll(this.f12688c);
        }
    }

    /* compiled from: expectedKeys */
    public enum ViewType {
        VIEW_TYPE_NOTIFICATION,
        VIEW_TYPE_HEADER,
        VIEW_TYPE_INLINE_ACTION_NUX
    }

    /* compiled from: expectedKeys */
    public class C06091 implements Runnable {
        final /* synthetic */ NotificationsAdapter f12784a;

        public C06091(NotificationsAdapter notificationsAdapter) {
            this.f12784a = notificationsAdapter;
        }

        public void run() {
            AdapterDetour.a(this.f12784a, -972103375);
        }
    }

    public static NotificationsAdapter m13454b(InjectorLike injectorLike) {
        return new NotificationsAdapter((Clock) SystemClockMethodAutoProvider.a(injectorLike), GraphQLNotificationsContentProviderHelper.m7861a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), NotificationsInlineNotificationNuxManager.m13472a(injectorLike), DefaultNotificationsRenderer.m13481a(injectorLike), NotificationsRowWithActionHelper.m13438a(injectorLike), NotificationsUtils.m7841a(injectorLike), TodayExperimentController.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public NotificationsAdapter(Clock clock, GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper, VMMemoryInfo vMMemoryInfo, NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, NotificationsUtils notificationsUtils, TodayExperimentController todayExperimentController, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f12642b = graphQLNotificationsContentProviderHelper;
        this.f12643c = notificationsInlineNotificationNuxManager;
        this.f12641a = clock;
        this.f12644d = defaultNotificationsRenderer;
        this.f12645e = notificationsRowWithActionHelper;
        this.f12646f = notificationsUtils;
        this.f12647g = todayExperimentController;
        this.f12648h = abstractFbErrorReporter;
        this.f12649i = vMMemoryInfo.a() ? 30 : 100;
    }

    public final void m13464a(@Nullable Collection<? extends FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> collection) {
        NotificationsList notificationsList = this.f12650j;
        notificationsList.f12687b.clear();
        if (collection != null) {
            notificationsList.f12687b.addAll(collection);
        }
        notificationsList.m13500b();
        if (!(this.f12653m || collection == null)) {
            this.f12650j.m13501c(this.f12642b.m7915c());
            this.f12653m = true;
        }
        m13459i();
    }

    public final void m13467b(@Nullable Collection<? extends FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> collection) {
        NotificationsList notificationsList = this.f12650j;
        notificationsList.f12688c.clear();
        notificationsList.m13501c(collection);
        m13459i();
    }

    private void m13459i() {
        if (this.f12647g.I()) {
            NotificationsList notificationsList = this.f12650j;
            int i = notificationsList.f12686a.m13470d() ? notificationsList.f12686a.f12651k - 1 : notificationsList.f12686a.f12651k;
            if (i < 0 || i >= notificationsList.f12689d.size()) {
                notificationsList.f12686a.f12648h.a(SoftError.m4760b("Seen section header index is incorrect", "Trying to rank notifications, while seen section index is not valid"));
                return;
            }
            Collection arrayList = new ArrayList(notificationsList.f12689d.subList(0, i));
            int i2 = i;
            while (i2 < notificationsList.f12689d.size()) {
                Collection collection;
                int j = ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsList.f12689d.get(i2)).mo821j();
                List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> arrayList2 = new ArrayList();
                while (i2 < notificationsList.f12689d.size() && j == ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsList.f12689d.get(i2)).mo821j()) {
                    arrayList2.add(notificationsList.f12689d.get(i2));
                    i2++;
                }
                if (j > 0) {
                    FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
                    int i3 = 0;
                    List arrayList3 = new ArrayList();
                    for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 : arrayList2) {
                        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2.mo817g().equals(GraphQLNotifImportanceType.IMPORTANT)) {
                            arrayList3.add(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2);
                        }
                    }
                    Collections.sort(arrayList3, new 1(notificationsList));
                    int min = Math.min(notificationsList.f12686a.f12647g.b.a(ExperimentsForTodayAbTestModule.i, 3), arrayList3.size());
                    Collection subList = arrayList3.subList(0, min);
                    arrayList2.removeAll(subList);
                    arrayList2.addAll(0, subList);
                    arrayList3 = new ArrayList();
                    while (i3 < arrayList2.size()) {
                        fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2 = (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) arrayList2.get(i3);
                        if (i3 < min || !fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2.mo817g().equals(GraphQLNotifImportanceType.IMPORTANT)) {
                            arrayList3.add(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2);
                        } else {
                            GraphQLNotifImportanceType graphQLNotifImportanceType = GraphQLNotifImportanceType.NOT_IMPORTANT;
                            Builder a = Builder.a(FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.m11248a(fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields2));
                            a.f = graphQLNotifImportanceType;
                            arrayList3.add(a.a());
                        }
                        i3++;
                    }
                    collection = arrayList3;
                } else {
                    Object obj = arrayList2;
                }
                arrayList.addAll(collection);
            }
            notificationsList.f12689d.clear();
            notificationsList.f12689d.addAll(arrayList);
        }
    }

    public final void m13462a(int i) {
        if (i < getCount()) {
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields d = m13469d(i);
            if (d != null) {
                d = NotificationsMutator.a(d);
                this.f12650j.f12689d.set(m13458h(i), d);
            }
        }
    }

    public final void m13465a(List<Integer> list, int i) {
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = this.f12650j.m13498a(intValue2);
            if (a != null) {
                this.f12650j.m13499a(NotificationsMutator.a(a, i), intValue2);
            }
        }
        this.f12650j.m13500b();
        m13459i();
    }

    public final void m13463a(int i, String str) {
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a = this.f12650j.m13498a(i);
        if (a != null) {
            FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a2 = NotificationsMutator.a(a, str);
            if (a2 != null) {
                GraphQLNotificationsContentProviderHelper graphQLNotificationsContentProviderHelper = this.f12642b;
                String g = a.mo822k().g();
                graphQLNotificationsContentProviderHelper.f7579g.m7938a(g, str);
                graphQLNotificationsContentProviderHelper.f7580h.f7620b = false;
                graphQLNotificationsContentProviderHelper.f7580h.m7938a(g, str);
                graphQLNotificationsContentProviderHelper.f7580h.f7620b = true;
                NotificationsUtils notificationsUtils = this.f12646f;
                String c = a.mo822k().c();
                NotifOptionSetsModel m = a2.mo824m();
                Preconditions.checkNotNull(c);
                ExecutorDetour.a(notificationsUtils.f7561d, new 5(notificationsUtils, c, m), -894506481);
                this.f12650j.m13499a(a2, i);
                this.f12650j.m13500b();
                m13459i();
                AdapterDetour.a(this, -1491319428);
            }
        }
    }

    public final boolean m13468c() {
        return m13460j() || m13470d();
    }

    public final boolean m13470d() {
        return this.f12652l >= 0;
    }

    private boolean m13460j() {
        return this.f12651k >= 0;
    }

    private boolean m13455e(int i) {
        return m13468c() && (i == this.f12651k || i == this.f12652l);
    }

    private boolean m13456f(int i) {
        return i == m13461k() && this.f12643c.m13476c();
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public int getItemViewType(int i) {
        return m13457g(i).ordinal();
    }

    private ViewType m13457g(int i) {
        if (m13456f(i)) {
            return ViewType.VIEW_TYPE_INLINE_ACTION_NUX;
        }
        return m13455e(i) ? ViewType.VIEW_TYPE_HEADER : ViewType.VIEW_TYPE_NOTIFICATION;
    }

    public boolean isEnabled(int i) {
        return m13457g(i) == ViewType.VIEW_TYPE_NOTIFICATION;
    }

    public int getCount() {
        int i;
        int i2 = 1;
        int i3 = m13470d() ? 1 : 0;
        if (m13460j()) {
            i = 1;
        } else {
            i = 0;
        }
        i3 += i;
        if (this.f12650j.m13497a() <= 0 || !this.f12643c.m13476c()) {
            i2 = 0;
        }
        return (i3 + m13471e()) + i2;
    }

    @Nullable
    public Object getItem(int i) {
        if (m13455e(i) || m13456f(i)) {
            return null;
        }
        NotificationsList notificationsList = this.f12650j;
        return (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) notificationsList.f12689d.get(m13458h(i));
    }

    @Nullable
    public final FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields m13469d(int i) {
        Object item = getItem(i);
        if (item instanceof FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
            return (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) item;
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final int m13471e() {
        return this.f12650j.m13497a();
    }

    @SuppressLint({"DeprecatedClass"})
    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        if (m13457g(i) == ViewType.VIEW_TYPE_HEADER) {
            return m13453a(i, view, viewGroup);
        }
        if (m13457g(i) == ViewType.VIEW_TYPE_INLINE_ACTION_NUX) {
            return this.f12643c.m13475a(i, view, viewGroup);
        }
        View a;
        if (view == null || view.getId() == 2131564271) {
            a = this.f12644d.m13486a(viewGroup);
        } else {
            a = view;
        }
        FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields d = m13469d(i);
        if (!(d == null || d.mo822k() == null)) {
            Object obj;
            String g = d.mo822k().g();
            if (this.f12645e.m13443b(g)) {
                obj = 1;
            } else {
                obj = null;
            }
            3 a2 = this.f12645e.m13441a(g, d.mo822k().c());
            Object obj2 = (d.mo822k().au().equals(GraphQLStorySeenState.SEEN_BUT_UNREAD) || d.mo822k().au().equals(GraphQLStorySeenState.UNSEEN_AND_UNREAD)) ? 1 : null;
            boolean z = m13460j() && i > this.f12651k && this.f12641a.a() - (1000 * d.mo822k().V()) <= 1000 * this.f12647g.f() && obj2 != null && d.mo821j() > 0;
            this.f12644d.m13487a(a, d, a2, i, z, null);
            if (obj != null) {
                RowWithActionTaken c = this.f12645e.m13444c(g);
                if (c != null) {
                    this.f12644d.m13488a(a, c, this.f12645e, d, a2, i);
                    if (a instanceof SwitchableNotificationView) {
                        ((SwitchableNotificationView) a).a(State.POST_FEEDBACK, c.d());
                        c.a(false);
                    }
                }
            }
        }
        a.setTag(2131558555, Integer.valueOf(i));
        return a;
    }

    private int m13458h(int i) {
        r0 = m13468c() ? (m13470d() && m13460j() && i > this.f12651k) ? i - 2 : i - 1 : i;
        if (!this.f12643c.m13476c() || i <= m13461k()) {
            return r0;
        }
        return r0 - 1;
    }

    private BetterTextView m13453a(int i, @Nullable View view, ViewGroup viewGroup) {
        if (view == null || view.getId() != 2131564271) {
            view = (BetterTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905499, viewGroup, false);
        } else {
            view = (BetterTextView) view;
        }
        CharSequence o = i == this.f12651k ? m13470d() ? this.f12647g.o() : this.f12647g.p() : this.f12647g.t();
        view.setText(o);
        return view;
    }

    public final void m13466a(boolean z) {
        NotificationsInlineNotificationNuxManager notificationsInlineNotificationNuxManager = this.f12643c;
        Object obj = null;
        if (!notificationsInlineNotificationNuxManager.f12665j) {
            if (notificationsInlineNotificationNuxManager.f12656a.a() - notificationsInlineNotificationNuxManager.f12658c.a(NotificationsPreferenceConstants.f7722K, 0) > ((long) notificationsInlineNotificationNuxManager.f12657b.f7750a.a(ExperimentsForNotificationsAbtestModule.f7779r, 0)) * 1000) {
                notificationsInlineNotificationNuxManager.f12666k = true;
                notificationsInlineNotificationNuxManager.f12658c.edit().putBoolean(NotificationsPreferenceConstants.f7721J, true).commit();
                obj = 1;
            }
        }
        if (obj != null) {
            AdapterDetour.a(this, 617948957);
        } else if (this.f12643c.f12669n && this.f12643c.f12665j) {
            this.f12643c.m13477e();
            this.f12643c.m13478h();
        } else {
            this.f12643c.f12670o = z;
        }
    }

    private int m13461k() {
        if (m13470d() && this.f12643c.f12665j) {
            return this.f12652l + 1;
        }
        if (m13460j()) {
            return this.f12651k + 1;
        }
        return 0;
    }
}

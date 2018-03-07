package com.facebook.notifications.notificationsfriending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.jewel.adapter.FriendRequestsAdapter;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.notificationsfriending.adapter.FriendRequestsAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.FriendRequestsAdapterSectionProvider;
import com.facebook.notifications.notificationsfriending.adapter.NotificationsAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.NotificationsAdapterSectionProvider;
import com.facebook.notifications.notificationsfriending.adapter.NotificationsFriendingAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.OnSectionUpdatedListener;
import com.facebook.notifications.notificationsfriending.adapter.PeopleYouMayKnowAdapterSection;
import com.facebook.notifications.notificationsfriending.adapter.PeopleYouMayKnowAdapterSectionProvider;
import com.facebook.notifications.notificationsfriending.logging.NotificationsFriendingAnalyticsLogger;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: tilesCache */
public class NotificationsFriendingAdapter extends SectionedListAdapter implements FriendRequestsAdapter, OnSectionUpdatedListener {
    public final AllCapsTransformationMethod f942c;
    private final NotificationsFriendingExperimentController f943d;
    public final NotificationsAdapterSection f944e;
    public final FriendRequestsAdapterSection f945f;
    public final PeopleYouMayKnowAdapterSection f946g;
    public final List<NotificationsFriendingAdapterSection> f947h = new ArrayList();

    /* compiled from: tilesCache */
    public enum ViewTypes {
        HEADER,
        NOTIFICATION,
        NOTIFICATIONS_EMPTY_VIEW,
        FRIEND_REQUEST,
        FRIEND_REQUEST_EMPTY_VIEW,
        FRIEND_REQUEST_ERROR_VIEW,
        FIND_FRIENDS,
        PERSON_YOU_MAY_KNOW,
        RESPONDED_PERSON_YOU_MAY_KNOW,
        SEE_ALL_FOOTER,
        SEE_MORE_FOOTER
    }

    public static NotificationsFriendingAdapter m1232a(InjectorLike injectorLike) {
        return new NotificationsFriendingAdapter(AllCapsTransformationMethod.b(injectorLike), NotificationsFriendingExperimentController.a(injectorLike), (NotificationsAdapterSectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsAdapterSectionProvider.class), (FriendRequestsAdapterSectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendRequestsAdapterSectionProvider.class), (PeopleYouMayKnowAdapterSectionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PeopleYouMayKnowAdapterSectionProvider.class));
    }

    @Inject
    public NotificationsFriendingAdapter(AllCapsTransformationMethod allCapsTransformationMethod, NotificationsFriendingExperimentController notificationsFriendingExperimentController, NotificationsAdapterSectionProvider notificationsAdapterSectionProvider, FriendRequestsAdapterSectionProvider friendRequestsAdapterSectionProvider, PeopleYouMayKnowAdapterSectionProvider peopleYouMayKnowAdapterSectionProvider) {
        this.f942c = allCapsTransformationMethod;
        this.f943d = notificationsFriendingExperimentController;
        this.f944e = new NotificationsAdapterSection((AbstractFbErrorReporter) FbErrorReporterImpl.a(notificationsAdapterSectionProvider), FbUriIntentHandler.a(notificationsAdapterSectionProvider), NotificationsFriendingExperimentController.a(notificationsAdapterSectionProvider), DefaultNotificationsRenderer.a(notificationsAdapterSectionProvider), NotificationsRowWithActionHelper.a(notificationsAdapterSectionProvider), NotificationsFriendingAnalyticsLogger.m1384a((InjectorLike) notificationsAdapterSectionProvider), ResourcesMethodAutoProvider.a(notificationsAdapterSectionProvider), this);
        this.f945f = friendRequestsAdapterSectionProvider.m1339a(this);
        this.f946g = peopleYouMayKnowAdapterSectionProvider.m1383a(this);
    }

    public final void m1242a(List<NotificationsEdgeFields> list, boolean z) {
        NotificationsAdapterSection notificationsAdapterSection = this.f944e;
        notificationsAdapterSection.f1013j = false;
        notificationsAdapterSection.f1014k.clear();
        notificationsAdapterSection.f1015l.clear();
        notificationsAdapterSection.m1350b(list, z);
        AdapterDetour.a(this, -998500447);
    }

    public final void m1244b(@Nullable List<NotificationsEdgeFields> list, boolean z) {
        this.f944e.m1350b(list, z);
        m1235y();
        AdapterDetour.a(this, 1949166154);
    }

    public final int m1251g(int i) {
        int[] d = d(i);
        if (this.f947h.get(d[0]) == this.f944e) {
            return d[1];
        }
        return -1;
    }

    public final void mo13e() {
        m1235y();
        AdapterDetour.a(this, 1239487316);
    }

    protected final int m1246c() {
        return this.f947h.size();
    }

    protected final View m1238a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130905489, viewGroup, false);
            inflate.setTag(2131558812, inflate.findViewById(2131564274));
            inflate.setTag(2131558813, inflate.findViewById(2131564275));
            view = inflate;
        }
        TextView textView = (TextView) view.getTag(2131558812);
        TextView textView2 = (TextView) view.getTag(2131558813);
        NotificationsFriendingAdapterSection notificationsFriendingAdapterSection = (NotificationsFriendingAdapterSection) this.f947h.get(i);
        if (notificationsFriendingAdapterSection.mo18d()) {
            textView2.setVisibility(0);
            textView2.setText(notificationsFriendingAdapterSection.mo19e());
            textView2.setOnClickListener(notificationsFriendingAdapterSection.mo20f());
        } else {
            textView2.setVisibility(8);
        }
        textView.setText(notificationsFriendingAdapterSection.mo17c());
        return view;
    }

    protected final int m1236a(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    protected final Object m1243b(int i) {
        return (NotificationsFriendingAdapterSection) this.f947h.get(i);
    }

    protected final int m1247c(int i) {
        NotificationsFriendingAdapterSection notificationsFriendingAdapterSection = (NotificationsFriendingAdapterSection) this.f947h.get(i);
        return notificationsFriendingAdapterSection.mo23i() ? notificationsFriendingAdapterSection.mo21g() + 1 : notificationsFriendingAdapterSection.mo21g();
    }

    protected final Object m1239a(int i, int i2) {
        NotificationsFriendingAdapterSection notificationsFriendingAdapterSection = (NotificationsFriendingAdapterSection) this.f947h.get(i);
        if (m1233a(notificationsFriendingAdapterSection, i2)) {
            return Boolean.valueOf(notificationsFriendingAdapterSection.mo23i());
        }
        return notificationsFriendingAdapterSection.mo16b(i2);
    }

    protected final View m1237a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        NotificationsFriendingAdapterSection notificationsFriendingAdapterSection = (NotificationsFriendingAdapterSection) this.f947h.get(i);
        if (m1233a(notificationsFriendingAdapterSection, i2)) {
            return m1231a(notificationsFriendingAdapterSection, viewGroup, view);
        }
        return notificationsFriendingAdapterSection.mo14a(i2, view, viewGroup);
    }

    protected final boolean m1245b(int i, int i2) {
        return ((NotificationsFriendingAdapterSection) this.f947h.get(i)).mo22h();
    }

    protected final int m1248c(int i, int i2) {
        NotificationsFriendingAdapterSection notificationsFriendingAdapterSection = (NotificationsFriendingAdapterSection) this.f947h.get(i);
        if (m1233a(notificationsFriendingAdapterSection, i2)) {
            return notificationsFriendingAdapterSection.mo24j().ordinal();
        }
        return notificationsFriendingAdapterSection.mo15a(i2).ordinal();
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final void m1240a(String str) {
        this.f945f.m1323a(Long.parseLong(str));
    }

    public final void m1241a(String str, FriendRequestState friendRequestState, boolean z) {
        this.f945f.m1324a(Long.parseLong(str), friendRequestState);
    }

    public final void m1249c(long j) {
        this.f946g.m1369a(j);
    }

    public final int m1254i(int i) {
        boolean z = false;
        int[] d = d(i);
        if (this.f947h.get(d[0]) == this.f946g) {
            z = true;
        }
        Preconditions.checkArgument(z, "The given position is not within the People You May Know section");
        return d[1];
    }

    public final int m1252h() {
        Preconditions.checkArgument(m1258n(), "The Friend Request list is empty");
        return p_(this.f947h.indexOf(this.f945f)) + 1;
    }

    public final int m1253i() {
        return this.f945f.f998j.size();
    }

    public final int m1255j() {
        return this.f946g.f1025f.size();
    }

    public final boolean m1256k() {
        return this.f944e.m1351b();
    }

    public final boolean m1257l() {
        return this.f945f.m1326b();
    }

    public final boolean m1258n() {
        return m1253i() > 0 && this.f947h.indexOf(this.f945f) != -1;
    }

    private void m1235y() {
        boolean z = true;
        this.f947h.clear();
        if (this.f944e.m1351b()) {
            this.f947h.add(this.f944e);
            if (this.f945f.m1326b()) {
                boolean z2;
                if (this.f943d.o() || this.f943d.m()) {
                    z2 = m1253i() > 0 || !this.f945f.m1338n();
                    if (!z2 && !this.f946g.m1382l()) {
                        return;
                    }
                    if (z2 || m1255j() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
                this.f946g.f1028i = z2;
                if (z2) {
                    this.f947h.add(this.f945f);
                }
                if (this.f946g.m1382l()) {
                    if (m1255j() <= 0) {
                        z = false;
                    }
                    this.f945f.f1001m = z;
                    if (z) {
                        this.f947h.add(this.f946g);
                    }
                }
            }
        }
    }

    private TextView m1231a(NotificationsFriendingAdapterSection notificationsFriendingAdapterSection, ViewGroup viewGroup, @Nullable View view) {
        TextView a = ViewTypes.SEE_ALL_FOOTER.equals(notificationsFriendingAdapterSection.mo24j()) ? m1230a(viewGroup, view) : m1234b(viewGroup, view);
        a.setOnClickListener(notificationsFriendingAdapterSection.mo25k());
        return a;
    }

    private TextView m1230a(ViewGroup viewGroup, @Nullable View view) {
        if (view != null) {
            return (TextView) view;
        }
        View view2 = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905490, viewGroup, false);
        view2.setText(this.f942c.getTransformation(view2.getResources().getString(2131241741), view2));
        return view2;
    }

    private TextView m1234b(ViewGroup viewGroup, @Nullable View view) {
        if (view != null) {
            return (TextView) view;
        }
        View view2 = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130905491, viewGroup, false);
        view2.setText(this.f942c.getTransformation(view2.getResources().getString(2131241742), view2));
        return view2;
    }

    private static boolean m1233a(NotificationsFriendingAdapterSection notificationsFriendingAdapterSection, int i) {
        return notificationsFriendingAdapterSection.mo23i() && i == notificationsFriendingAdapterSection.mo21g();
    }
}

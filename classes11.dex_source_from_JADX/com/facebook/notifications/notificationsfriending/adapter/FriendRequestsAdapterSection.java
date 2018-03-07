package com.facebook.notifications.notificationsfriending.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.friending.center.constants.FriendsCenterSource;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.common.list.FriendRequestItemView;
import com.facebook.friending.jewel.adapter.FriendingRequestBinder;
import com.facebook.friending.jewel.adapter.FriendingRequestBinderProvider;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.notificationsfriending.NotificationsFriendingAdapter.ViewTypes;
import com.facebook.notifications.notificationsfriending.abtest.NotificationsFriendingExperimentController;
import com.facebook.notifications.notificationsfriending.logging.NotificationsFriendingAnalyticsLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: tileTtl */
public class FriendRequestsAdapterSection implements NotificationsFriendingAdapterSection<FriendRequest> {
    public final NotificationsFriendingAnalyticsLogger f989a;
    public final NotificationsFriendingExperimentController f990b;
    public final FbSharedPreferences f991c;
    public final FbUriIntentHandler f992d;
    private final FriendingRequestBinder f993e;
    public final Provider<String> f994f;
    private final Resources f995g;
    public final RTLUtil f996h;
    public final OnSectionUpdatedListener f997i;
    public final List<FriendRequest> f998j;
    public final Set<Long> f999k;
    public LoadingState f1000l = LoadingState.LOADING;
    public boolean f1001m = true;

    /* compiled from: tileTtl */
    public class C01381 {
        final /* synthetic */ FriendRequestsAdapterSection f983a;

        C01381(FriendRequestsAdapterSection friendRequestsAdapterSection) {
            this.f983a = friendRequestsAdapterSection;
        }

        public final void m1303a(long j, boolean z) {
            if (z) {
                this.f983a.m1323a(j);
            } else if (this.f983a.m1327b(j)) {
                this.f983a.f997i.mo13e();
            }
        }
    }

    /* compiled from: tileTtl */
    class C01392 implements OnClickListener {
        final /* synthetic */ FriendRequestsAdapterSection f984a;

        C01392(FriendRequestsAdapterSection friendRequestsAdapterSection) {
            this.f984a = friendRequestsAdapterSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -545010277);
            this.f984a.f992d.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.NOTIFICATIONS_FRIENDING_TAB_SEE_ALL_FRIEND_REQUESTS.name(), FriendsCenterTabType.REQUESTS.name()));
            this.f984a.f989a.m1390b(this.f984a.f998j.size());
            Logger.a(2, EntryType.UI_INPUT_END, 730353154, a);
        }
    }

    /* compiled from: tileTtl */
    public class C01414 implements OnClickListener {
        final /* synthetic */ FriendRequestsAdapterSection f987a;

        public C01414(FriendRequestsAdapterSection friendRequestsAdapterSection) {
            this.f987a = friendRequestsAdapterSection;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1183849974);
            this.f987a.f992d.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.NOTIFICATIONS_FRIENDING_TAB_FIND_FRIENDS.name(), FriendsCenterTabType.SUGGESTIONS.name()));
            Logger.a(2, EntryType.UI_INPUT_END, -1452039579, a);
        }
    }

    /* compiled from: tileTtl */
    public enum LoadingState {
        SUCCESS,
        FAILURE,
        LOADING
    }

    @Nullable
    public final /* synthetic */ Object mo16b(int i) {
        return m1318c(i);
    }

    @Inject
    public FriendRequestsAdapterSection(NotificationsFriendingAnalyticsLogger notificationsFriendingAnalyticsLogger, NotificationsFriendingExperimentController notificationsFriendingExperimentController, FbSharedPreferences fbSharedPreferences, FbUriIntentHandler fbUriIntentHandler, FriendingRequestBinderProvider friendingRequestBinderProvider, Provider<String> provider, Resources resources, RTLUtil rTLUtil, @Assisted OnSectionUpdatedListener onSectionUpdatedListener) {
        this.f997i = onSectionUpdatedListener;
        this.f991c = fbSharedPreferences;
        this.f992d = fbUriIntentHandler;
        this.f993e = friendingRequestBinderProvider.a(FriendingLocation.JEWEL, new C01381(this));
        this.f989a = notificationsFriendingAnalyticsLogger;
        this.f990b = notificationsFriendingExperimentController;
        this.f995g = resources;
        this.f996h = rTLUtil;
        this.f994f = provider;
        this.f998j = new ArrayList();
        this.f999k = new HashSet();
    }

    public final boolean m1326b() {
        return !LoadingState.LOADING.equals(this.f1000l);
    }

    public final String mo17c() {
        if (this.f990b.o()) {
            return this.f995g.getString(2131233242);
        }
        Object obj = (this.f998j.isEmpty() && this.f1000l == LoadingState.SUCCESS && m1320o()) ? 1 : null;
        return this.f995g.getString(obj != null ? 2131233204 : 2131233203);
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
        return this.f998j.isEmpty() ? 1 : this.f998j.size();
    }

    @Nullable
    private FriendRequest m1318c(int i) {
        return this.f998j.isEmpty() ? null : (FriendRequest) this.f998j.get(i);
    }

    public final View mo14a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = m1316a(i, viewGroup);
        }
        m1317a(i, view);
        return view;
    }

    private View m1316a(int i, ViewGroup viewGroup) {
        switch (mo15a(i)) {
            case FIND_FRIENDS:
                ContentView contentView = (ContentView) LayoutInflater.from(viewGroup.getContext()).inflate(2130904373, viewGroup, false);
                if (this.f990b.o()) {
                    contentView.setTitleText("");
                }
                ((ImageView) contentView.a).setImageDrawable(this.f996h.a(2130838068));
                return contentView;
            case FRIEND_REQUEST_EMPTY_VIEW:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130904488, viewGroup, false);
                inflate.findViewById(2131562270).setOnClickListener(new C01414(this));
                return inflate;
            case FRIEND_REQUEST_ERROR_VIEW:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904489, viewGroup, false);
            case FRIEND_REQUEST:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130905488, viewGroup, false);
            default:
                throw new IllegalArgumentException("Unexpected view type");
        }
    }

    private void m1317a(int i, View view) {
        switch (mo15a(i)) {
            case FIND_FRIENDS:
                ContentView contentView = (ContentView) view;
                int i2 = 2131241746;
                FriendsCenterTabType friendsCenterTabType = FriendsCenterTabType.SUGGESTIONS;
                if (!this.f1001m) {
                    String str = (String) this.f994f.get();
                    boolean z = false;
                    if (!(StringUtil.a(str) || this.f991c.a(GrowthPrefKeys.a(str), false))) {
                        z = true;
                    }
                    if (z) {
                        i2 = 2131241748;
                        friendsCenterTabType = FriendsCenterTabType.CONTACTS;
                    } else {
                        i2 = 2131241747;
                        friendsCenterTabType = FriendsCenterTabType.SEARCH;
                    }
                }
                contentView.setSubtitleText(i2);
                contentView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FriendRequestsAdapterSection f986b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1304012887);
                        this.f986b.f992d.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cd, FriendsCenterSource.NOTIFICATIONS_FRIENDING_TAB_FIND_FRIENDS.name(), friendsCenterTabType.name()));
                        Logger.a(2, EntryType.UI_INPUT_END, 1337864773, a);
                    }
                });
                return;
            case FRIEND_REQUEST:
                this.f993e.a((FriendRequestItemView) view, (FriendRequest) Preconditions.checkNotNull(m1318c(i)));
                return;
            default:
                return;
        }
    }

    public final boolean mo22h() {
        return !this.f998j.isEmpty();
    }

    public final ViewTypes mo15a(int i) {
        if (!this.f998j.isEmpty()) {
            return ViewTypes.FRIEND_REQUEST;
        }
        if (this.f1000l != LoadingState.SUCCESS) {
            return ViewTypes.FRIEND_REQUEST_ERROR_VIEW;
        }
        if (m1320o()) {
            return ViewTypes.FIND_FRIENDS;
        }
        return ViewTypes.FRIEND_REQUEST_EMPTY_VIEW;
    }

    public final boolean mo23i() {
        return !this.f998j.isEmpty();
    }

    public final ViewTypes mo24j() {
        return ViewTypes.SEE_ALL_FOOTER;
    }

    public final OnClickListener mo25k() {
        return new C01392(this);
    }

    public final void m1323a(long j) {
        if (this.f999k.contains(Long.valueOf(j))) {
            int d = m1319d(j);
            if (d != -1) {
                this.f998j.remove(d);
                this.f999k.remove(Long.valueOf(j));
                this.f997i.mo13e();
            }
        }
    }

    public final void m1324a(long j, FriendRequestState friendRequestState) {
        if (this.f999k.contains(Long.valueOf(j))) {
            int d = m1319d(j);
            if (d != -1) {
                ((FriendRequest) this.f998j.get(d)).j = friendRequestState;
                this.f997i.mo13e();
            }
        }
    }

    public final boolean m1327b(long j) {
        return this.f999k.contains(Long.valueOf(j));
    }

    public final boolean m1329c(long j) {
        if (!this.f999k.contains(Long.valueOf(j))) {
            return false;
        }
        int d = m1319d(j);
        return d != -1 && ((FriendRequest) this.f998j.get(d)).l();
    }

    public final boolean m1338n() {
        return this.f1000l.equals(LoadingState.SUCCESS);
    }

    private int m1319d(long j) {
        for (int i = 0; i < this.f998j.size(); i++) {
            if (((FriendRequest) this.f998j.get(i)).a() == j) {
                return i;
            }
        }
        return -1;
    }

    private boolean m1320o() {
        return this.f990b.p();
    }
}

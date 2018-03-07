package com.facebook.orca.threadlist;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.common.time.Clock;
import com.facebook.common.util.CollectionUtil;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.inject.Lazy;
import com.facebook.messaging.inbox2.activenow.InboxActiveNowController.Result;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementData;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementUnitItem;
import com.facebook.messaging.inbox2.bymm.BYMMInboxItem;
import com.facebook.messaging.inbox2.bymm.InboxBYMMData;
import com.facebook.messaging.inbox2.bymm.InboxBYMMViewData;
import com.facebook.messaging.inbox2.cameraroll.CameraRollInboxItem;
import com.facebook.messaging.inbox2.data.common.InboxUnit;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.mrt.InboxMessageRequestThreadsData;
import com.facebook.messaging.inbox2.mrt.InboxMessageRequestThreadsViewData;
import com.facebook.messaging.inbox2.mrt.MessageRequestThreadsInboxItem;
import com.facebook.messaging.inbox2.photoreminders.InboxUnitPhotoRemindersItem;
import com.facebook.messaging.inbox2.recents.RecentLinkInboxItem;
import com.facebook.messaging.inbox2.recents.RecentLinksInboxItem;
import com.facebook.messaging.inbox2.recents.RecentVideoInboxItem;
import com.facebook.messaging.inbox2.recents.RecentVideosInboxItem;
import com.facebook.messaging.inbox2.rtc.RtcRecommendationInboxItem;
import com.facebook.messaging.inbox2.sectionheader.InboxUnitSectionHeaderItem;
import com.facebook.messaging.inbox2.trendinggifs.TrendingGifsInboxItem;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerData;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageData;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageViewData;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageViewDataFactory;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxData;
import com.facebook.orca.threadlist.Addables.Addable;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nearby_friends_informational_more_info_click */
public class InboxItemHelper {
    private static final Class<?> f6477a = InboxItemHelper.class;
    private final Context f6478b;
    public final Clock f6479c;
    private final InboxUnitThreadItemProvider f6480d;
    private final PeopleYouMayMessageViewDataFactory f6481e;
    public final Lazy<ConnectivityManager> f6482f;

    /* compiled from: nearby_friends_informational_more_info_click */
    public class C09751 implements Predicate<MessengerInboxUnitItemsModel> {
        final /* synthetic */ InboxItemHelper f6476a;

        public C09751(InboxItemHelper inboxItemHelper) {
            this.f6476a = inboxItemHelper;
        }

        public boolean apply(Object obj) {
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) obj;
            if (messengerInboxUnitItemsModel.m() == 0) {
                messengerInboxUnitItemsModel.j();
                return false;
            } else if (messengerInboxUnitItemsModel.n() == 0) {
                messengerInboxUnitItemsModel.j();
                return false;
            } else if (messengerInboxUnitItemsModel.l() != 0) {
                return true;
            } else {
                messengerInboxUnitItemsModel.j();
                return false;
            }
        }
    }

    @Inject
    public InboxItemHelper(Context context, Clock clock, InboxUnitThreadItemProvider inboxUnitThreadItemProvider, PeopleYouMayMessageViewDataFactory peopleYouMayMessageViewDataFactory, Lazy<ConnectivityManager> lazy) {
        this.f6478b = context;
        this.f6479c = clock;
        this.f6480d = inboxUnitThreadItemProvider;
        this.f6481e = peopleYouMayMessageViewDataFactory;
        this.f6482f = lazy;
    }

    @VisibleForTesting
    public static void m6136a(Addable<InboxItem> addable, InboxUnit<PhotoRemindersInboxData> inboxUnit) {
        addable.m6119a(new InboxUnitPhotoRemindersItem(inboxUnit.f2735b, (PhotoRemindersInboxData) inboxUnit.f2736c));
    }

    @VisibleForTesting
    public final void m6141a(Addable<InboxItem> addable, InboxUnit<PeopleYouMayMessageData> inboxUnit, boolean z) {
        PeopleYouMayMessageViewData a = PeopleYouMayMessageViewDataFactory.m3380a((PeopleYouMayMessageData) inboxUnit.f2736c);
        if (!a.f3497a.isEmpty()) {
            if (z) {
                m6138j(addable, inboxUnit);
            }
            addable.m6119a(new InboxUnitPeopleYouMayMessageItem(inboxUnit.f2735b, a));
        }
    }

    @VisibleForTesting
    public final void m6142b(Addable<InboxItem> addable, InboxUnit<?> inboxUnit) {
        m6138j(addable, inboxUnit);
        for (MessengerInboxUnitItemsModel messengerInboxUnitItemsModel : m6135a(inboxUnit.f2735b)) {
            if (messengerInboxUnitItemsModel.k() != null) {
                addable.m6119a(new InboxUnitConversationStarterItem(inboxUnit.f2735b, messengerInboxUnitItemsModel, messengerInboxUnitItemsModel.k()));
            }
        }
    }

    @VisibleForTesting
    public final void m6143b(Addable<InboxItem> addable, InboxUnit<?> inboxUnit, boolean z) {
        ImmutableList m = inboxUnit.f2735b.m();
        if (!m.isEmpty()) {
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(0);
            if (messengerInboxUnitItemsModel.k() != null) {
                MessageRequestsSnippet messageRequestsSnippet = new MessageRequestsSnippet(messengerInboxUnitItemsModel.k().s(), messengerInboxUnitItemsModel.k().q());
                if (z) {
                    m6138j(addable, inboxUnit);
                }
                addable.m6119a(new InboxUnitMessageRequestsItem(inboxUnit.f2735b, messageRequestsSnippet));
            }
        }
    }

    @VisibleForTesting
    public static void m6137a(Addable<InboxItem> addable, InboxUnit<?> inboxUnit, @Nullable MontageInboxComposerData montageInboxComposerData) {
        addable.m6119a(new InboxUnitMontageComposerItem(inboxUnit.f2735b, montageInboxComposerData));
    }

    final void m6144c(Addable<InboxItem> addable, InboxUnit<?> inboxUnit) {
        Object obj;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6482f.get()).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m6138j(addable, inboxUnit);
            addable.m6119a(new TrendingGifsInboxItem(inboxUnit.f2735b));
        }
    }

    final void m6145d(Addable<InboxItem> addable, InboxUnit<MediaResource> inboxUnit) {
        Object obj;
        MediaResource mediaResource = (MediaResource) inboxUnit.f2736c;
        if (mediaResource == null || this.f6479c.a() - mediaResource.A >= 86400000) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m6138j(addable, inboxUnit);
            addable.m6119a(new CameraRollInboxItem(inboxUnit.f2735b));
        }
    }

    final void m6146e(Addable<InboxItem> addable, InboxUnit<InboxBYMMData> inboxUnit) {
        InboxBYMMData inboxBYMMData = (InboxBYMMData) inboxUnit.f2736c;
        if (inboxBYMMData != null) {
            InboxBYMMViewData inboxBYMMViewData = new InboxBYMMViewData(inboxBYMMData.f2681a);
            m6138j(addable, inboxUnit);
            addable.m6119a(new BYMMInboxItem(inboxUnit.f2735b, inboxBYMMViewData));
        }
    }

    final void m6147f(Addable<InboxItem> addable, InboxUnit<InboxMessageRequestThreadsData> inboxUnit) {
        InboxMessageRequestThreadsData inboxMessageRequestThreadsData = (InboxMessageRequestThreadsData) inboxUnit.f2736c;
        if (inboxMessageRequestThreadsData != null) {
            InboxMessageRequestThreadsViewData inboxMessageRequestThreadsViewData = new InboxMessageRequestThreadsViewData(inboxMessageRequestThreadsData.f2853a);
            m6138j(addable, inboxUnit);
            addable.m6119a(new MessageRequestThreadsInboxItem(inboxUnit.f2735b, inboxMessageRequestThreadsViewData));
        }
    }

    final void m6148g(Addable<InboxItem> addable, InboxUnit<ImmutableList<RtcRecommendationInboxItem>> inboxUnit) {
        ImmutableList immutableList = (ImmutableList) inboxUnit.f2736c;
        if (inboxUnit.f2736c != null && CollectionUtil.b(immutableList)) {
            m6138j(addable, inboxUnit);
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                addable.m6119a(new RtcRecommendationInboxItem(inboxUnit.f2735b, ((RtcRecommendationInboxItem) immutableList.get(i)).f2962f));
            }
        }
    }

    final void m6149h(Addable<InboxItem> addable, InboxUnit<ImmutableList<InboxAnnouncementData>> inboxUnit) {
        boolean z;
        Preconditions.checkNotNull(inboxUnit.f2736c);
        if (((ImmutableList) inboxUnit.f2736c).isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        m6138j(addable, inboxUnit);
        addable.m6119a(new InboxAnnouncementUnitItem(inboxUnit.f2735b, (InboxAnnouncementData) ((ImmutableList) inboxUnit.f2736c).get(0)));
    }

    @VisibleForTesting
    public final void m6140a(Addable<InboxItem> addable, InboxUnit<?> inboxUnit, Result result) {
        if (result != null && result.f2589a) {
            if (result.f2591c) {
                m6138j(addable, inboxUnit);
                addable.m6119a(new InboxUnitActiveNowLoadingItem(inboxUnit.f2735b));
                return;
            }
            Object obj;
            if (result.f2590b == null || result.f2590b.isEmpty()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m6138j(addable, inboxUnit);
                addable.m6119a(new InboxUnitActiveNowEmptyItem(inboxUnit.f2735b));
                return;
            }
            Integer.valueOf(result.f2592d);
            int size = result.f2592d - result.f2590b.size();
            if (!inboxUnit.f2735b.p() || size <= 0) {
                m6138j(addable, inboxUnit);
            } else if (inboxUnit.f2735b.q() != null) {
                addable.m6119a(new InboxUnitSectionHeaderItem(inboxUnit.f2735b, size, true));
            }
            ImmutableList immutableList = result.f2590b;
            int size2 = immutableList.size();
            for (int i = 0; i < size2; i++) {
                addable.m6119a(new InboxUnitActiveNowItem(inboxUnit.f2735b, (ContactPickerUserRow) immutableList.get(i)));
            }
        }
    }

    @VisibleForTesting
    public final void m6150i(Addable<InboxItem> addable, InboxUnit<Map<String, ThreadSummary>> inboxUnit) {
        Map map = (Map) inboxUnit.f2736c;
        if (map != null) {
            m6138j(addable, inboxUnit);
            for (MessengerInboxUnitItemsModel messengerInboxUnitItemsModel : m6135a(inboxUnit.f2735b)) {
                ThreadSummary threadSummary = (ThreadSummary) map.get(messengerInboxUnitItemsModel.j());
                if (threadSummary != null) {
                    addable.m6119a(this.f6480d.m6195a(inboxUnit.f2735b, messengerInboxUnitItemsModel, threadSummary));
                }
            }
        }
    }

    static void m6138j(Addable<InboxItem> addable, InboxUnit<?> inboxUnit) {
        if (inboxUnit.f2735b.q() != null) {
            addable.m6119a(new InboxUnitSectionHeaderItem(inboxUnit.f2735b));
        }
    }

    final void m6151k(Addable<InboxItem> addable, InboxUnit<ImmutableList<RecentVideoInboxItem>> inboxUnit) {
        Preconditions.checkNotNull(inboxUnit.f2736c);
        m6138j(addable, inboxUnit);
        addable.m6119a(new RecentVideosInboxItem(inboxUnit.f2735b, (ImmutableList) inboxUnit.f2736c));
    }

    final void m6152l(Addable<InboxItem> addable, InboxUnit<ImmutableList<RecentLinkInboxItem>> inboxUnit) {
        Preconditions.checkNotNull(inboxUnit.f2736c);
        m6138j(addable, inboxUnit);
        addable.m6119a(new RecentLinksInboxItem(inboxUnit.f2735b, (ImmutableList) inboxUnit.f2736c));
    }

    @VisibleForTesting
    public final InboxUnitThreadItem m6139a(NodesModel nodesModel, ThreadSummary threadSummary) {
        return this.f6480d.m6195a(nodesModel, null, threadSummary);
    }

    private Iterable<MessengerInboxUnitItemsModel> m6135a(NodesModel nodesModel) {
        return Iterables.c(nodesModel.m(), new C09751(this));
    }
}

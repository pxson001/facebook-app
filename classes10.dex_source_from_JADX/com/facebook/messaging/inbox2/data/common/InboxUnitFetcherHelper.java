package com.facebook.messaging.inbox2.data.common;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.pictures.ContactPictureSizes;
import com.facebook.contacts.pictures.ContactPictureSizes.Size;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLMessengerInbox2MessageThreadReason;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.contacts.picker.DefaultMultiPickerRowCreator;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementData;
import com.facebook.messaging.inbox2.announcements.InboxAnnouncementItem;
import com.facebook.messaging.inbox2.bymm.BYMMInboxUserItem;
import com.facebook.messaging.inbox2.bymm.InboxBYMMData;
import com.facebook.messaging.inbox2.bymm.InboxBusinessYouMayMessage;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.AnnouncementInbox2UnitFragmentModel.ActionTextModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.AnnouncementInbox2UnitFragmentModel.DescriptionModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.ExternalUrlInboxItemFragmentModel.LinkModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.Inbox2PageItemFragmentModel.PageModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.Inbox2VideoItemFragmentModel.VideoModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel.MessengerInboxItemAttachmentModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel.MessengerInboxItemAttachmentModel.ItemImageModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel.MessengerInboxItemTitleModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.MessageThreadsInbox2UnitFragmentModel.ThreadModel;
import com.facebook.messaging.inbox2.mrt.InboxMessageRequestThreadsData;
import com.facebook.messaging.inbox2.recents.RecentLinkInboxItem;
import com.facebook.messaging.inbox2.recents.RecentVideoInboxItem;
import com.facebook.messaging.inbox2.rtc.RtcRecommendationInboxItem;
import com.facebook.messaging.media.loader.LocalMediaLoader;
import com.facebook.messaging.media.loader.LocalMediaLoaderParams;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageDataDeserializer;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher;
import com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher.FetchThreadsAndMessagesResult;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setMixedContentMode */
public class InboxUnitFetcherHelper {
    private static final Class<?> f2739a = InboxUnitFetcherHelper.class;
    private final ContactPictureSizes f2740b;
    public final PeopleYouMayMessageDataDeserializer f2741c;
    private final DbFetchThreadHandler f2742d;
    private final AbstractFbErrorReporter f2743e;
    public final LocalMediaLoader f2744f;
    private final MessagesSyncThreadsFetcher f2745g;
    private final ThreadUnreadCountUtil f2746h;
    private final Resources f2747i;
    public final RuntimePermissionsUtil f2748j;
    private final User f2749k;
    private final UserIterators f2750l;
    private final DefaultMultiPickerRowCreator f2751m;

    /* compiled from: setMixedContentMode */
    /* synthetic */ class C04531 {
        static final /* synthetic */ int[] f2737a = new int[GraphQLMessengerInboxUnitType.values().length];
        static final /* synthetic */ int[] f2738b = new int[DataFreshnessResult.values().length];

        static {
            try {
                f2738b[DataFreshnessResult.FROM_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2738b[DataFreshnessResult.FROM_CACHE_UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2738b[DataFreshnessResult.FROM_CACHE_STALE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2738b[DataFreshnessResult.FROM_CACHE_INCOMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2738b[DataFreshnessResult.FROM_CACHE_HAD_SERVER_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.PYMM.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.MESSAGE_THREADS.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.MONTAGE_COMPOSER.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.VIDEOS.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.EXTERNAL_URL.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.CAMERA_ROLL.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.BYMM.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.MESSAGE_REQUEST_THREADS.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.RTC_RECOMMENDATION.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f2737a[GraphQLMessengerInboxUnitType.ANNOUNCEMENT.ordinal()] = 10;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public static InboxUnitFetcherHelper m2700b(InjectorLike injectorLike) {
        return new InboxUnitFetcherHelper(ContactPictureSizes.a(injectorLike), new PeopleYouMayMessageDataDeserializer((Clock) SystemClockMethodAutoProvider.a(injectorLike)), DbFetchThreadHandler.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), LocalMediaLoader.b(injectorLike), MessagesSyncThreadsFetcher.m3933a(injectorLike), ThreadUnreadCountUtil.a(injectorLike), UserIterators.a(injectorLike), DefaultMultiPickerRowCreator.m1878b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), User_LoggedInUserMethodAutoProvider.b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public InboxUnitFetcherHelper(ContactPictureSizes contactPictureSizes, PeopleYouMayMessageDataDeserializer peopleYouMayMessageDataDeserializer, DbFetchThreadHandler dbFetchThreadHandler, AbstractFbErrorReporter abstractFbErrorReporter, LocalMediaLoader localMediaLoader, MessagesSyncThreadsFetcher messagesSyncThreadsFetcher, ThreadUnreadCountUtil threadUnreadCountUtil, UserIterators userIterators, DefaultMultiPickerRowCreator defaultMultiPickerRowCreator, Resources resources, User user, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f2740b = contactPictureSizes;
        this.f2741c = peopleYouMayMessageDataDeserializer;
        this.f2742d = dbFetchThreadHandler;
        this.f2743e = abstractFbErrorReporter;
        this.f2744f = localMediaLoader;
        this.f2745g = messagesSyncThreadsFetcher;
        this.f2746h = threadUnreadCountUtil;
        this.f2750l = userIterators;
        this.f2751m = defaultMultiPickerRowCreator;
        this.f2747i = resources;
        this.f2749k = user;
        this.f2748j = runtimePermissionsUtil;
    }

    @VisibleForTesting
    public final Map<String, ?> m2711a() {
        Map<String, ?> hashMap = new HashMap();
        hashMap.put("scaling_factor", GraphQlQueryDefaults.a());
        hashMap.put("profile_pic_small_size", Integer.valueOf(this.f2740b.a(Size.SMALL)));
        hashMap.put("recent_item_image_height", Integer.valueOf(this.f2747i.getDimensionPixelSize(2131433628)));
        hashMap.put("recent_item_image_width", Integer.valueOf(this.f2747i.getDimensionPixelSize(2131433627)));
        return hashMap;
    }

    public final ImmutableList<InboxUnit<?>> m2710a(InboxV2QueryModel inboxV2QueryModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList a = inboxV2QueryModel.a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel.l() == 0) {
                nodesModel.r();
            } else {
                nodesModel.r();
                InboxUnit a2 = m2709a(nodesModel);
                if (a2 != null) {
                    builder.c(a2);
                }
            }
        }
        return builder.b();
    }

    @Nullable
    public final InboxUnit<?> m2709a(NodesModel nodesModel) {
        ImmutableList i;
        InboxUnit<?> inboxUnit;
        switch (C04531.f2737a[nodesModel.r().ordinal()]) {
            case 1:
                return new InboxUnit(nodesModel, this.f2741c.m3360a(nodesModel));
            case 2:
                return m2707m(nodesModel);
            case 3:
                return new InboxUnit(nodesModel);
            case 4:
                i = m2704i(nodesModel);
                if (i.isEmpty()) {
                    inboxUnit = null;
                } else {
                    inboxUnit = new InboxUnit(nodesModel, i);
                }
                return inboxUnit;
            case 5:
                i = m2705j(nodesModel);
                if (i.isEmpty()) {
                    inboxUnit = null;
                } else {
                    inboxUnit = new InboxUnit(nodesModel, i);
                }
                return inboxUnit;
            case 6:
                Object obj;
                Object obj2 = null;
                if (VERSION.SDK_INT <= 21 || this.f2748j.a("android.permission.READ_EXTERNAL_STORAGE")) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i = this.f2744f.a(new LocalMediaLoaderParams(false, 1));
                    if (!(i == null || i.isEmpty())) {
                        MediaResource mediaResource = (MediaResource) i.get(0);
                    }
                    inboxUnit = new InboxUnit(nodesModel, obj2);
                }
                return inboxUnit;
            case 7:
                return m2701c(nodesModel);
            case 8:
                return m2702d(nodesModel);
            case 9:
                return m2703h(nodesModel);
            case 10:
                return m2706l(nodesModel);
            default:
                return new InboxUnit(nodesModel);
        }
    }

    private static InboxUnit<?> m2701c(NodesModel nodesModel) {
        Builder builder = ImmutableList.builder();
        ImmutableList m = nodesModel.m();
        int size = m.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            InboxBusinessYouMayMessage inboxBusinessYouMayMessage;
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i);
            int i3 = i2 + 1;
            MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
            if (k == null) {
                inboxBusinessYouMayMessage = null;
            } else {
                PageModel n = k.n();
                UserBuilder userBuilder = new UserBuilder();
                userBuilder.a(Type.FACEBOOK, n.j());
                userBuilder.g = new Name(n.l());
                userBuilder.A = n.k();
                User aa = userBuilder.aa();
                BYMMInboxUserItem bYMMInboxUserItem = new BYMMInboxUserItem(nodesModel, messengerInboxUnitItemsModel);
                bYMMInboxUserItem.a(i2);
                inboxBusinessYouMayMessage = new InboxBusinessYouMayMessage(aa, bYMMInboxUserItem);
            }
            InboxBusinessYouMayMessage inboxBusinessYouMayMessage2 = inboxBusinessYouMayMessage;
            if (inboxBusinessYouMayMessage2 != null) {
                builder.c(inboxBusinessYouMayMessage2);
            }
            i++;
            i2 = i3;
        }
        return new InboxUnit(nodesModel, new InboxBYMMData(builder.b()));
    }

    private InboxUnit<?> m2702d(NodesModel nodesModel) {
        DbFetchThreadHandler dbFetchThreadHandler = this.f2742d;
        Builder builder = ImmutableList.builder();
        ImmutableList m = nodesModel.m();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            Object obj;
            MessengerInboxItemAttachmentModel k = ((MessengerInboxUnitItemsModel) m.get(i)).k();
            if (k == null) {
                obj = null;
            } else {
                ThreadSummary threadSummary;
                FetchThreadResult a = dbFetchThreadHandler.a(ThreadKey.a(k.r().j().j()), 1);
                if (a == null || a == FetchThreadResult.a) {
                    threadSummary = null;
                } else {
                    threadSummary = a.c;
                }
                ThreadSummary threadSummary2 = threadSummary;
            }
            Object obj2 = obj;
            if (obj2 != null) {
                builder.c(obj2);
            }
        }
        return new InboxUnit(nodesModel, new InboxMessageRequestThreadsData(builder.b()));
    }

    private InboxUnit<?> m2703h(NodesModel nodesModel) {
        return new InboxUnit(nodesModel, m2708n(nodesModel));
    }

    public static ImmutableList<RecentVideoInboxItem> m2704i(NodesModel nodesModel) {
        Builder builder = ImmutableList.builder();
        int i = 0;
        ImmutableList m = nodesModel.m();
        int size = m.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i2);
            if (messengerInboxUnitItemsModel.m() != 0) {
                MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
                if (k != null) {
                    VideoModel u = k.u();
                    if (u != null) {
                        String a;
                        String str;
                        String str2;
                        String str3;
                        CharSequence a2 = u.r() == null ? null : u.r().a();
                        if (!TextUtils.isEmpty(a2) || u.n() == null) {
                            CharSequence charSequence = a2;
                        } else {
                            a = u.n().a();
                        }
                        String k2 = u.k();
                        if (u.m() == null) {
                            str = null;
                        } else {
                            str = u.m().a();
                        }
                        String q = u.q();
                        String o = u.o();
                        String s = u.s();
                        if (u.l() == null) {
                            str2 = null;
                        } else {
                            str2 = u.l().a();
                        }
                        if (u.n() == null) {
                            str3 = null;
                        } else {
                            str3 = u.n().j().a();
                        }
                        RecentVideoInboxItem recentVideoInboxItem = new RecentVideoInboxItem(nodesModel, messengerInboxUnitItemsModel, k2, a, str, q, o, s, str2, str3, u.t(), u.j(), u.p());
                        int i4 = i + 1;
                        recentVideoInboxItem.a(i);
                        builder.c(recentVideoInboxItem);
                        i3 = i4;
                        i2++;
                        i = i3;
                    }
                }
            }
            i3 = i;
            i2++;
            i = i3;
        }
        return builder.b();
    }

    public static ImmutableList<RecentLinkInboxItem> m2705j(NodesModel nodesModel) {
        Builder builder = ImmutableList.builder();
        int i = 0;
        ImmutableList m = nodesModel.m();
        int size = m.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i2);
            if (messengerInboxUnitItemsModel.m() != 0) {
                MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
                if (k != null) {
                    LinkModel m2 = k.m();
                    if (m2 != null) {
                        String a;
                        String a2;
                        String str;
                        String str2;
                        String str3;
                        if (m2.r() != null && !TextUtils.isEmpty(m2.r().a())) {
                            a = m2.r().a();
                        } else if (TextUtils.isEmpty(m2.o())) {
                            a = m2.j();
                        } else {
                            a = m2.o();
                        }
                        if (m2.k() != null && m2.k().a() != null && !TextUtils.isEmpty(m2.k().a().a())) {
                            a2 = m2.k().a().a();
                        } else if (m2.l() == null || TextUtils.isEmpty(m2.l().a())) {
                            a2 = null;
                        } else {
                            a2 = m2.l().a();
                        }
                        String m3 = m2.m();
                        if (m2.q() == null) {
                            str = null;
                        } else {
                            str = m2.q().a();
                        }
                        String s = m2.s();
                        if (m2.p() == null) {
                            str2 = null;
                        } else {
                            str2 = m2.p().a();
                        }
                        if (m2.n() == null || m2.n().a() == null) {
                            str3 = null;
                        } else {
                            str3 = m2.n().a().a();
                        }
                        RecentLinkInboxItem recentLinkInboxItem = new RecentLinkInboxItem(nodesModel, messengerInboxUnitItemsModel, m3, a, str, s, str2, str3, a2);
                        int i4 = i + 1;
                        recentLinkInboxItem.a(i);
                        builder.c(recentLinkInboxItem);
                        i3 = i4;
                        i2++;
                        i = i3;
                    }
                }
            }
            i3 = i;
            i2++;
            i = i3;
        }
        return builder.b();
    }

    @Nullable
    private static InboxUnit<?> m2706l(NodesModel nodesModel) {
        ImmutableList m = nodesModel.m();
        if (m.isEmpty()) {
            return null;
        }
        Builder builder = ImmutableList.builder();
        int size = m.size();
        for (int i = 0; i < size; i++) {
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i);
            MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
            MessengerInboxItemTitleModel p = messengerInboxUnitItemsModel.p();
            String a = p == null ? null : p.a();
            if (!(k == null || a == null || messengerInboxUnitItemsModel.m() == 0)) {
                DescriptionModel k2 = k.k();
                ActionTextModel j = k.j();
                ItemImageModel l = k.l();
                builder.c(new InboxAnnouncementData(new InboxAnnouncementItem(nodesModel, messengerInboxUnitItemsModel), a, k2 == null ? null : k2.a(), j == null ? null : j.a(), l == null ? null : l.a()));
            }
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            return null;
        }
        return new InboxUnit(nodesModel, b);
    }

    private InboxUnit<?> m2707m(NodesModel nodesModel) {
        int i;
        ImmutableMap.Builder builder = ImmutableMap.builder();
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        ImmutableList m = nodesModel.m();
        int size = m.size();
        for (i = 0; i < size; i++) {
            MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i);
            MessengerInboxItemAttachmentModel k = messengerInboxUnitItemsModel.k();
            if (k != null) {
                ThreadKey a = m2698a(k);
                FetchThreadResult a2 = this.f2742d.a(ThreadCriteria.a(a), 0);
                if (a2 == null || a2 == FetchThreadResult.a) {
                    builder2.c(a);
                } else if (!m2699a(k, a2.c)) {
                    builder.b(messengerInboxUnitItemsModel.j(), a2.c);
                }
            }
        }
        Set b = builder2.b();
        if (!b.isEmpty()) {
            try {
                FetchThreadsAndMessagesResult a3 = this.f2745g.m3943a(b, ImmutableSet.of(), -1);
                m = nodesModel.m();
                size = m.size();
                for (i = 0; i < size; i++) {
                    messengerInboxUnitItemsModel = (MessengerInboxUnitItemsModel) m.get(i);
                    k = messengerInboxUnitItemsModel.k();
                    if (k != null) {
                        ThreadSummary threadSummary = (ThreadSummary) a3.f4327a.get(m2698a(k));
                        if (!(threadSummary == null || m2699a(k, threadSummary))) {
                            builder.b(messengerInboxUnitItemsModel.j(), threadSummary);
                        }
                    }
                }
            } catch (Throwable e) {
                this.f2743e.a(f2739a.getSimpleName(), e);
                return null;
            }
        }
        return builder.b().size() > 0 ? new InboxUnit(nodesModel, builder.b()) : null;
    }

    private ImmutableList<RtcRecommendationInboxItem> m2708n(NodesModel nodesModel) {
        UserIterator a = this.f2750l.a(ContactCursorsQuery.c(ContactProfileType.MESSAGABLE_TYPES, 3));
        Builder builder = ImmutableList.builder();
        if (a != null) {
            while (a.hasNext()) {
                try {
                    ContactPickerUserRow contactPickerUserRow = (ContactPickerUserRow) this.f2751m.m1879a((User) a.next(), false, ContactRowSectionType.SUGGESTIONS);
                    contactPickerUserRow.c(false);
                    contactPickerUserRow.d(true);
                    contactPickerUserRow.a("inbox_recommend_audio");
                    contactPickerUserRow.e(true);
                    contactPickerUserRow.b("inbox_recommend_video");
                    builder.c(new RtcRecommendationInboxItem(nodesModel, contactPickerUserRow));
                } finally {
                    a.close();
                }
            }
        }
        return builder.b();
    }

    private ThreadKey m2698a(MessengerInboxItemAttachmentModel messengerInboxItemAttachmentModel) {
        ThreadModel r = messengerInboxItemAttachmentModel.r();
        return r.a() ? ThreadKey.a(Long.parseLong(r.j().j())) : ThreadKey.a(Long.parseLong(r.j().a()), Long.parseLong(this.f2749k.a));
    }

    private boolean m2699a(MessengerInboxItemAttachmentModel messengerInboxItemAttachmentModel, ThreadSummary threadSummary) {
        if (messengerInboxItemAttachmentModel.p() != GraphQLMessengerInbox2MessageThreadReason.UNREAD || this.f2746h.a(threadSummary)) {
            return false;
        }
        return true;
    }
}

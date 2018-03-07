package com.facebook.orca.threadlist;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLMessengerInbox2RecentUnitConfigType;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.inbox2.activenow.InboxActiveNowController.Result;
import com.facebook.messaging.inbox2.data.common.InboxUnit;
import com.facebook.messaging.inbox2.data.common.InboxUnitSnapshot;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel.MessengerInboxItemAttachmentModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.MessengerInbox2RecentUnitConfigModel;
import com.facebook.messaging.inbox2.items.InboxItem;
import com.facebook.messaging.inbox2.items.InboxItemType;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.inbox2.sectionheader.InboxUnitSectionHeaderItem;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.montage.inboxcomposer.MontageInboxComposerData;
import com.facebook.messaging.peopleyoumaymessage.PeopleYouMayMessageViewDataFactory;
import com.facebook.messaging.photoreminders.inboxheader.PhotoRemindersInboxData;
import com.facebook.orca.threadlist.Addables.Addable;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: nearby_friends_informational_ok */
public class InboxItemCreator {
    private static final Class<?> f6465a = InboxItemCreator.class;
    public final InboxItemHelper f6466b;
    private final MontageTestHelper f6467c;
    private final ThreadUnreadCountUtil f6468d;
    private final Clock f6469e;
    private final List<ThreadSummary> f6470f;
    private boolean f6471g;
    public boolean f6472h;
    public long f6473i;
    public int f6474j;
    private boolean f6475k = false;

    /* compiled from: nearby_friends_informational_ok */
    class C09724 implements Predicate<ThreadSummary> {
        final /* synthetic */ InboxItemCreator f6451a;

        C09724(InboxItemCreator inboxItemCreator) {
            this.f6451a = inboxItemCreator;
        }

        public boolean apply(Object obj) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            if (threadSummary.k >= this.f6451a.f6473i) {
                return true;
            }
            if (!this.f6451a.f6472h || this.f6451a.f6474j <= 0) {
                return false;
            }
            this.f6451a.f6473i = threadSummary.k;
            InboxItemCreator inboxItemCreator = this.f6451a;
            inboxItemCreator.f6474j--;
            return true;
        }
    }

    /* compiled from: nearby_friends_informational_ok */
    /* synthetic */ class C09746 {
        static final /* synthetic */ int[] f6459a = new int[GraphQLMessengerInboxUnitType.values().length];
        static final /* synthetic */ int[] f6460b = new int[GraphQLMessengerInbox2RecentUnitConfigType.values().length];

        static {
            try {
                f6460b[GraphQLMessengerInbox2RecentUnitConfigType.STALENESS_BASED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6460b[GraphQLMessengerInbox2RecentUnitConfigType.UNREAD_BASED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.ALL_REMAINING_THREADS.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.PYMM.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.CONVERSATION_STARTERS.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.CONVERSATION_REQUESTS.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.MESSAGE_THREADS.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.MONTAGE_COMPOSER.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.ACTIVE_NOW.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.VIDEOS.ordinal()] = 9;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.EXTERNAL_URL.ordinal()] = 10;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.GIFS.ordinal()] = 11;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.CAMERA_ROLL.ordinal()] = 12;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.BYMM.ordinal()] = 13;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.MESSAGE_REQUEST_THREADS.ordinal()] = 14;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.RTC_RECOMMENDATION.ordinal()] = 15;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f6459a[GraphQLMessengerInboxUnitType.ANNOUNCEMENT.ordinal()] = 16;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    /* compiled from: nearby_friends_informational_ok */
    public class RowListBuilder {
        private final Builder<InboxItem> f6461a = ImmutableList.builder();
        @Nullable
        private InboxItem f6462b;
        @Nullable
        private InboxItem f6463c;
        private int f6464d;

        public final void m6118a(InboxItem inboxItem) {
            if (this.f6462b != null) {
                if (inboxItem.a() != InboxItemType.V2_SECTION_HEADER) {
                    m6116b(this.f6462b);
                }
                this.f6462b = null;
            }
            if (inboxItem.a() == InboxItemType.V2_SECTION_HEADER) {
                this.f6462b = inboxItem;
            } else {
                m6116b(inboxItem);
            }
        }

        public final InboxItem m6117a() {
            return this.f6463c;
        }

        public final ImmutableList<InboxItem> m6120b() {
            return this.f6461a.b();
        }

        private void m6116b(InboxItem inboxItem) {
            if (inboxItem.a() == InboxItemType.V2_SECTION_HEADER) {
                this.f6464d = 0;
            } else if (!(this.f6463c == null || this.f6463c.a() == InboxItemType.V2_SECTION_HEADER || this.f6463c.a() == inboxItem.a())) {
                this.f6464d = 0;
            }
            this.f6461a.c(inboxItem);
            this.f6463c = inboxItem;
            if (inboxItem instanceof InboxUnitItem) {
                ((InboxUnitItem) inboxItem).a(this.f6464d);
            }
            this.f6464d++;
        }
    }

    public static InboxItemCreator m6125a(InjectorLike injectorLike) {
        return new InboxItemCreator(new InboxItemHelper((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (InboxUnitThreadItemProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InboxUnitThreadItemProvider.class), PeopleYouMayMessageViewDataFactory.m3382a(injectorLike), IdBasedLazy.a(injectorLike, 38)), MontageTestHelper.b(injectorLike), ThreadUnreadCountUtil.a(injectorLike), (Clock) DbClock.a(injectorLike));
    }

    @Inject
    public InboxItemCreator(InboxItemHelper inboxItemHelper, MontageTestHelper montageTestHelper, ThreadUnreadCountUtil threadUnreadCountUtil, Clock clock) {
        this.f6466b = inboxItemHelper;
        this.f6467c = montageTestHelper;
        this.f6468d = threadUnreadCountUtil;
        this.f6469e = clock;
        this.f6470f = new ArrayList();
    }

    public final boolean m6133a() {
        if (!this.f6472h) {
            return false;
        }
        this.f6474j = 6;
        if (this.f6471g || this.f6470f.size() > 6) {
            return true;
        }
        return false;
    }

    public final ImmutableList<InboxItem> m6132a(@Nullable InboxUnitSnapshot inboxUnitSnapshot, Iterable<ThreadSummary> iterable, Result result, @Nullable MontageInboxComposerData montageInboxComposerData, PhotoRemindersInboxData photoRemindersInboxData, boolean z, boolean z2) {
        if (inboxUnitSnapshot != null) {
            Integer.valueOf(inboxUnitSnapshot.f2757d.size());
        }
        Boolean.valueOf(z2);
        if (m6134a(inboxUnitSnapshot)) {
            return m6131b(inboxUnitSnapshot, iterable, result, montageInboxComposerData, photoRemindersInboxData, z, z2);
        }
        return m6127a(inboxUnitSnapshot, iterable, photoRemindersInboxData, z);
    }

    private ImmutableList<InboxItem> m6127a(@Nullable InboxUnitSnapshot inboxUnitSnapshot, Iterable<ThreadSummary> iterable, PhotoRemindersInboxData photoRemindersInboxData, boolean z) {
        final Predicate a = m6126a(iterable, false, null);
        C09691 c09691 = new Predicate<ThreadSummary>(this) {
            final /* synthetic */ InboxItemCreator f6446b;

            public boolean apply(Object obj) {
                a.apply((ThreadSummary) obj);
                return true;
            }
        };
        final InboxUnit b = m6130b(inboxUnitSnapshot);
        RowListBuilder rowListBuilder = new RowListBuilder();
        if (photoRemindersInboxData != null) {
            InboxItemHelper.m6136a(rowListBuilder, m6124a(photoRemindersInboxData));
        }
        m6128a(rowListBuilder, iterable, z, c09691, new Function<ThreadSummary, InboxItem>(this) {
            final /* synthetic */ InboxItemCreator f6448b;

            public Object apply(Object obj) {
                return this.f6448b.f6466b.m6139a(b.f2735b, (ThreadSummary) obj);
            }
        });
        if (!z) {
            rowListBuilder.m6118a(new InboxLoadMorePlaceholderItem(b.f2735b));
        }
        return rowListBuilder.m6120b();
    }

    private ImmutableList<InboxItem> m6131b(@Nullable InboxUnitSnapshot inboxUnitSnapshot, Iterable<ThreadSummary> iterable, Result result, @Nullable MontageInboxComposerData montageInboxComposerData, PhotoRemindersInboxData photoRemindersInboxData, boolean z, boolean z2) {
        RowListBuilder rowListBuilder = new RowListBuilder();
        if (photoRemindersInboxData != null) {
            InboxItemHelper.m6136a(rowListBuilder, m6124a(photoRemindersInboxData));
        }
        UnmodifiableIterator it = inboxUnitSnapshot.f2757d.iterator();
        GraphQLMessengerInboxUnitType graphQLMessengerInboxUnitType = null;
        this.f6472h = false;
        boolean z3 = false;
        while (it.hasNext()) {
            GraphQLMessengerInboxUnitType graphQLMessengerInboxUnitType2;
            InboxItem a = rowListBuilder.m6117a();
            final InboxUnit inboxUnit = (InboxUnit) it.next();
            if (!(inboxUnit.f2734a == GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS || inboxUnit.f2734a == GraphQLMessengerInboxUnitType.PYMM)) {
                z3 = true;
            }
            switch (C09746.f6459a[inboxUnit.f2734a.ordinal()]) {
                case 1:
                    if (z3) {
                        InboxItemHelper.m6138j(rowListBuilder, inboxUnit);
                    }
                    C09713 c09713 = new Function<ThreadSummary, InboxItem>(this) {
                        final /* synthetic */ InboxItemCreator f6450b;

                        public Object apply(Object obj) {
                            return this.f6450b.f6466b.m6139a(inboxUnit.f2735b, (ThreadSummary) obj);
                        }
                    };
                    this.f6472h = inboxUnit.f2735b.p();
                    m6128a(rowListBuilder, iterable, z, m6126a(iterable, z2, inboxUnit.f2735b.k()), c09713);
                    if (this.f6472h && (this.f6470f.size() > 0 || !z)) {
                        rowListBuilder.m6118a(new InboxLoadMorePlaceholderItem(inboxUnit.f2735b));
                        z3 = true;
                        break;
                    }
                    z3 = true;
                    break;
                case 2:
                    if (!this.f6472h) {
                        if (!this.f6470f.isEmpty()) {
                            Integer.valueOf(this.f6470f.size());
                            if (graphQLMessengerInboxUnitType != GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                                rowListBuilder.m6118a(new InboxUnitSectionHeaderItem(inboxUnit.f2735b));
                            }
                            for (ThreadSummary a2 : this.f6470f) {
                                rowListBuilder.m6118a(this.f6466b.m6139a(inboxUnit.f2735b, a2));
                            }
                            this.f6470f.clear();
                        }
                        if (!z) {
                            rowListBuilder.m6118a(new InboxLoadMorePlaceholderItem(inboxUnit.f2735b));
                            break;
                        }
                    }
                    break;
                case 3:
                    this.f6466b.m6141a(rowListBuilder, inboxUnit, z3);
                    break;
                case 4:
                    this.f6466b.m6142b(rowListBuilder, inboxUnit);
                    break;
                case 5:
                    this.f6466b.m6143b(rowListBuilder, inboxUnit, true);
                    break;
                case 6:
                    this.f6466b.m6150i(rowListBuilder, inboxUnit);
                    break;
                case 7:
                    if (this.f6467c.c()) {
                        InboxItemHelper.m6137a(rowListBuilder, inboxUnit, montageInboxComposerData);
                        break;
                    }
                    break;
                case 8:
                    this.f6466b.m6140a(rowListBuilder, inboxUnit, result);
                    break;
                case 9:
                    this.f6466b.m6151k(rowListBuilder, inboxUnit);
                    break;
                case 10:
                    this.f6466b.m6152l(rowListBuilder, inboxUnit);
                    break;
                case 11:
                    this.f6466b.m6144c(rowListBuilder, inboxUnit);
                    break;
                case 12:
                    this.f6466b.m6145d(rowListBuilder, inboxUnit);
                    break;
                case 13:
                    this.f6466b.m6146e(rowListBuilder, inboxUnit);
                    break;
                case 14:
                    this.f6466b.m6147f(rowListBuilder, inboxUnit);
                    break;
                case 15:
                    this.f6466b.m6148g(rowListBuilder, inboxUnit);
                    break;
                case 16:
                    this.f6466b.m6149h(rowListBuilder, inboxUnit);
                    break;
            }
            if (a != rowListBuilder.m6117a()) {
                graphQLMessengerInboxUnitType2 = inboxUnit.f2734a;
            } else {
                graphQLMessengerInboxUnitType2 = graphQLMessengerInboxUnitType;
            }
            graphQLMessengerInboxUnitType = graphQLMessengerInboxUnitType2;
        }
        return rowListBuilder.m6120b();
    }

    private Predicate<ThreadSummary> m6126a(Iterable<ThreadSummary> iterable, boolean z, @Nullable MessengerInbox2RecentUnitConfigModel messengerInbox2RecentUnitConfigModel) {
        int i = 1;
        boolean z2 = (messengerInbox2RecentUnitConfigModel == null || messengerInbox2RecentUnitConfigModel.a() == null || messengerInbox2RecentUnitConfigModel.a() == GraphQLMessengerInbox2RecentUnitConfigType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? false : true;
        if (this.f6475k || !z2) {
            i = 0;
        }
        if (z && r1 == 0) {
            Long.valueOf(this.f6473i);
            Integer.valueOf(this.f6474j);
            return new C09724(this);
        }
        this.f6475k = z2;
        final GraphQLMessengerInbox2RecentUnitConfigType a = z2 ? messengerInbox2RecentUnitConfigModel.a() : GraphQLMessengerInbox2RecentUnitConfigType.UNREAD_BASED;
        i = z2 ? messengerInbox2RecentUnitConfigModel.j() : 24;
        final int l = z2 ? messengerInbox2RecentUnitConfigModel.l() : 3;
        final int k = z2 ? messengerInbox2RecentUnitConfigModel.k() : 20;
        final int a2 = m6122a((Iterable) iterable, i);
        final long a3 = this.f6469e.a() - (((long) i) * 3600000);
        this.f6474j = 0;
        return new Predicate<ThreadSummary>(this) {
            int f6452a = 0;
            final /* synthetic */ InboxItemCreator f6458g;

            public boolean apply(Object obj) {
                ThreadSummary threadSummary = (ThreadSummary) obj;
                if (this.f6452a >= k) {
                    return false;
                }
                if (this.f6452a >= l) {
                    switch (C09746.f6460b[a.ordinal()]) {
                        case 1:
                            if (threadSummary.k < a3) {
                                return false;
                            }
                            break;
                        case 2:
                            if (this.f6452a > a2) {
                                return false;
                            }
                            break;
                    }
                }
                this.f6452a++;
                this.f6458g.f6473i = threadSummary.k;
                return true;
            }
        };
    }

    private int m6122a(Iterable<ThreadSummary> iterable, int i) {
        long a = this.f6469e.a();
        int i2 = 0;
        int i3 = 0;
        for (ThreadSummary threadSummary : iterable) {
            if (a - threadSummary.k > 3600000 * ((long) i)) {
                break;
            }
            if (this.f6468d.a(threadSummary)) {
                i3 = i2;
            }
            i2++;
        }
        return i3;
    }

    private void m6128a(Addable<InboxItem> addable, Iterable<ThreadSummary> iterable, boolean z, Predicate<ThreadSummary> predicate, Function<ThreadSummary, InboxItem> function) {
        this.f6470f.clear();
        PeekingIterator i = Iterators.i(iterable.iterator());
        while (i.hasNext()) {
            if (predicate.apply((ThreadSummary) i.a())) {
                addable.m6119a(function.apply(i.next()));
            } else {
                Iterators.a(this.f6470f, i);
                this.f6471g = z;
                return;
            }
        }
    }

    final boolean m6134a(@Nullable InboxUnitSnapshot inboxUnitSnapshot) {
        if (inboxUnitSnapshot == null) {
            return false;
        }
        int a = m6121a(inboxUnitSnapshot, GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS);
        int a2 = m6121a(inboxUnitSnapshot, GraphQLMessengerInboxUnitType.ALL_REMAINING_THREADS);
        if (inboxUnitSnapshot.f2755b == InboxUnitsToFetch.TOP) {
            if (a >= 0) {
                return true;
            }
            return false;
        } else if (a == -1 || a2 == -1 || a2 < a || inboxUnitSnapshot.f2757d.size() == 2) {
            return false;
        } else {
            return true;
        }
    }

    private static int m6121a(InboxUnitSnapshot inboxUnitSnapshot, GraphQLMessengerInboxUnitType graphQLMessengerInboxUnitType) {
        int i = -1;
        for (int i2 = 0; i2 < inboxUnitSnapshot.f2757d.size(); i2++) {
            if (((InboxUnit) inboxUnitSnapshot.f2757d.get(i2)).f2735b.r() == graphQLMessengerInboxUnitType) {
                if (i != -1) {
                    return -1;
                }
                i = i2;
            }
        }
        return i;
    }

    private InboxUnit<?> m6130b(InboxUnitSnapshot inboxUnitSnapshot) {
        InboxUnit<?> inboxUnit = null;
        if (inboxUnitSnapshot != null) {
            InboxUnit<?> inboxUnit2;
            ImmutableList immutableList = inboxUnitSnapshot.f2757d;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                inboxUnit2 = (InboxUnit) immutableList.get(i);
                if (inboxUnit2.f2735b.r() == GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                    break;
                }
            }
            inboxUnit2 = null;
            inboxUnit = inboxUnit2;
        }
        if (inboxUnit == null) {
            return m6129b();
        }
        return inboxUnit;
    }

    public static InboxUnit<?> m6129b() {
        NodesModel.Builder builder = new NodesModel.Builder();
        builder.i = GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS;
        builder = builder;
        builder.a = "1674434246165228";
        builder = builder;
        builder.f = false;
        return new InboxUnit(builder.a());
    }

    public static InboxUnit<PhotoRemindersInboxData> m6124a(PhotoRemindersInboxData photoRemindersInboxData) {
        NodesModel.Builder builder = new NodesModel.Builder();
        builder.i = GraphQLMessengerInboxUnitType.PHOTO_REMINDERS;
        builder = builder;
        builder.a = "1161184033900246";
        builder = builder;
        builder.f = true;
        return new InboxUnit(builder.a(), photoRemindersInboxData);
    }

    public static InboxUnit<?> m6123a(MessageRequestsSnippet messageRequestsSnippet) {
        MessengerInboxUnitItemsModel.Builder builder = new MessengerInboxUnitItemsModel.Builder();
        MessengerInboxItemAttachmentModel.Builder builder2 = new MessengerInboxItemAttachmentModel.Builder();
        builder2.u = messageRequestsSnippet.f3257a;
        builder2 = builder2;
        builder2.r = messageRequestsSnippet.f3258b;
        builder.b = builder2.a();
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.a);
        int a = ModelHelper.a(flatBufferBuilder, builder.b);
        int b2 = flatBufferBuilder.b(builder.f);
        int a2 = ModelHelper.a(flatBufferBuilder, builder.g);
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.a(2, builder.c, 0);
        flatBufferBuilder.a(3, builder.d, 0);
        flatBufferBuilder.a(4, builder.e, 0);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = new MessengerInboxUnitItemsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        NodesModel.Builder builder3 = new NodesModel.Builder();
        builder3.i = GraphQLMessengerInboxUnitType.CONVERSATION_REQUESTS;
        builder3 = builder3;
        builder3.a = "849346485182969";
        builder3 = builder3;
        builder3.f = true;
        builder3 = builder3;
        builder3.d = ImmutableList.of(messengerInboxUnitItemsModel);
        return new InboxUnit(builder3.a());
    }
}

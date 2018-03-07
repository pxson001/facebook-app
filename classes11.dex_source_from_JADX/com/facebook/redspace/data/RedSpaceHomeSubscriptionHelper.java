package com.facebook.redspace.data;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.redspace.adapter.RedSpaceFriendsAdapter;
import com.facebook.redspace.adapter.RedSpaceHomeMultiAdapter;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.event.FriendsFetchEvent;
import com.facebook.redspace.event.OverflowCountChangedEvent;
import com.facebook.redspace.event.OverflowPicturesUpdateEvent;
import com.facebook.redspace.event.RedSpaceEventBus;
import com.facebook.redspace.event.RedSpaceEventSubscriber;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.ApproximateCountModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel.ApproximateCountModel.Builder;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import java.util.Map;

/* compiled from: PrivacyCheckupComposerStepTTI */
public class RedSpaceHomeSubscriptionHelper extends SimpleFriendChangedSubscriber {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendsCacheHelper> f11818a = UltralightRuntime.b;
    public final RedSpaceMutationsExecutor f11819b;
    private final RedSpaceHomeMultiAdapter f11820c;
    public final Adapter f11821d;
    private final Map<RedSpaceFriendsSection, RedSpaceFriendsCollection> f11822e;
    private final Map<RedSpaceFriendsSection, RedSpaceFriendsAdapter> f11823f;
    public final RedSpaceEventBus f11824g;
    public final RedSpaceEventSubscriber<OverflowCountChangedEvent> f11825h = new C14001(this);
    public final RedSpaceEventSubscriber<OverflowPicturesUpdateEvent> f11826i = new C14012(this);
    public final RedSpaceEventSubscriber<FriendsFetchEvent> f11827j = new C14023(this);

    /* compiled from: PrivacyCheckupComposerStepTTI */
    class C14001 extends RedSpaceEventSubscriber<OverflowCountChangedEvent> {
        final /* synthetic */ RedSpaceHomeSubscriptionHelper f11815a;

        C14001(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper) {
            this.f11815a = redSpaceHomeSubscriptionHelper;
        }

        public final void m12253b(FbEvent fbEvent) {
            OverflowCountChangedEvent overflowCountChangedEvent = (OverflowCountChangedEvent) fbEvent;
            if (overflowCountChangedEvent.f11931a != null) {
                OverflowFriendsModel overflowFriendsModel = RedSpaceHomeSubscriptionHelper.m12271c(this.f11815a, overflowCountChangedEvent.f11931a).f11774a;
                if (overflowFriendsModel != null) {
                    Builder a = Builder.a(overflowFriendsModel.a());
                    a.a = overflowCountChangedEvent.f11932b;
                    a.b = false;
                    RedSpaceHomeSubscriptionHelper.m12271c(this.f11815a, overflowCountChangedEvent.f11931a).m12215a(a.a());
                    RedSpaceHomeSubscriptionHelper.m12265a(this.f11815a, overflowCountChangedEvent.f11931a);
                }
            }
        }

        public final Class<OverflowCountChangedEvent> m12252a() {
            return OverflowCountChangedEvent.class;
        }
    }

    /* compiled from: PrivacyCheckupComposerStepTTI */
    class C14012 extends RedSpaceEventSubscriber<OverflowPicturesUpdateEvent> {
        final /* synthetic */ RedSpaceHomeSubscriptionHelper f11816a;

        C14012(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper) {
            this.f11816a = redSpaceHomeSubscriptionHelper;
        }

        public final void m12255b(FbEvent fbEvent) {
            OverflowPicturesUpdateEvent overflowPicturesUpdateEvent = (OverflowPicturesUpdateEvent) fbEvent;
            if (overflowPicturesUpdateEvent.f11933a != null) {
                RedSpaceFriendsCollection c = RedSpaceHomeSubscriptionHelper.m12271c(this.f11816a, overflowPicturesUpdateEvent.f11933a);
                c.f11774a = RedSpaceMutator.m12294a(c.f11774a, overflowPicturesUpdateEvent.f11934b);
                RedSpaceHomeSubscriptionHelper.m12265a(this.f11816a, overflowPicturesUpdateEvent.f11933a);
            }
        }

        public final Class<OverflowPicturesUpdateEvent> m12254a() {
            return OverflowPicturesUpdateEvent.class;
        }
    }

    /* compiled from: PrivacyCheckupComposerStepTTI */
    class C14023 extends RedSpaceEventSubscriber<FriendsFetchEvent> {
        final /* synthetic */ RedSpaceHomeSubscriptionHelper f11817a;

        C14023(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper) {
            this.f11817a = redSpaceHomeSubscriptionHelper;
        }

        public final void m12257b(FbEvent fbEvent) {
            FriendsFetchEvent friendsFetchEvent = (FriendsFetchEvent) fbEvent;
            if (friendsFetchEvent.f11929a != null) {
                RedSpaceHomeSubscriptionHelper.m12271c(this.f11817a, friendsFetchEvent.f11929a).m12214a(friendsFetchEvent.f11930b);
                RedSpaceHomeSubscriptionHelper.m12268b(this.f11817a);
            }
        }

        public final Class<FriendsFetchEvent> m12256a() {
            return FriendsFetchEvent.class;
        }
    }

    @Inject
    public RedSpaceHomeSubscriptionHelper(RedSpaceMutationsExecutor redSpaceMutationsExecutor, RedSpaceEventBus redSpaceEventBus, @Assisted RedSpaceFriendsCollection redSpaceFriendsCollection, @Assisted RedSpaceFriendsAdapter redSpaceFriendsAdapter, @Assisted RedSpaceFriendsCollection redSpaceFriendsCollection2, @Assisted RedSpaceFriendsAdapter redSpaceFriendsAdapter2, @Assisted RedSpaceHomeMultiAdapter redSpaceHomeMultiAdapter, @Assisted Adapter adapter) {
        this.f11819b = redSpaceMutationsExecutor;
        this.f11824g = redSpaceEventBus;
        this.f11822e = new ArrayMap();
        this.f11822e.put(RedSpaceFriendsSection.TOP, redSpaceFriendsCollection);
        this.f11822e.put(RedSpaceFriendsSection.OTHERS, redSpaceFriendsCollection2);
        this.f11823f = new ArrayMap();
        this.f11823f.put(RedSpaceFriendsSection.TOP, redSpaceFriendsAdapter);
        this.f11823f.put(RedSpaceFriendsSection.OTHERS, redSpaceFriendsAdapter2);
        this.f11820c = redSpaceHomeMultiAdapter;
        this.f11821d = adapter;
        this.f11819b.m12288a((SimpleFriendChangedSubscriber) this);
        this.f11824g.a(this.f11825h);
        this.f11824g.a(this.f11826i);
        this.f11824g.a(this.f11827j);
    }

    public final void mo335a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        m12271c(this, RedSpaceFriendsSection.TOP).m12217a(redSpaceFeedProfileFragmentModel);
        m12271c(this, RedSpaceFriendsSection.OTHERS).m12217a(redSpaceFeedProfileFragmentModel);
        int c = m12269c(redSpaceFeedProfileFragmentModel);
        if (c != -1) {
            this.f11821d.j_(c);
        } else {
            m12268b(this);
        }
    }

    public final void mo336a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (redSpaceFriendsSection.isOverflow()) {
            m12264a(redSpaceFriendsSection, 1);
            RedSpaceFriendsCollection c = m12271c(this, redSpaceFriendsSection);
            c.f11774a = RedSpaceMutator.m12300b(c.f11774a, ImmutableList.of(RedSpaceMutator.m12292a(redSpaceFeedProfileFragmentModel.l())));
            m12265a(this, redSpaceFriendsSection);
            return;
        }
        boolean z;
        RedSpaceFriendsCollection c2 = m12271c(this, redSpaceFriendsSection);
        if (redSpaceFriendsSection.isTop()) {
            z = false;
        } else {
            z = true;
        }
        c2.m12216a(z, redSpaceFeedProfileFragmentModel);
        m12267b(m12270c(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection));
    }

    public final void mo337b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (redSpaceFriendsSection.isOverflow()) {
            m12264a(redSpaceFriendsSection, -1);
            RedSpaceFriendsCollection c = m12271c(this, redSpaceFriendsSection);
            c.f11774a = RedSpaceMutator.m12302c(c.f11774a, ImmutableList.of(RedSpaceMutator.m12292a(redSpaceFeedProfileFragmentModel.l())));
            m12265a(this, redSpaceFriendsSection);
            return;
        }
        int c2 = m12270c(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
        RedSpaceFriendsAdapter redSpaceFriendsAdapter = (RedSpaceFriendsAdapter) this.f11823f.get(redSpaceFriendsSection);
        int count = redSpaceFriendsAdapter.getCount();
        m12271c(this, redSpaceFriendsSection).m12220b(redSpaceFeedProfileFragmentModel);
        if (redSpaceFriendsAdapter.getCount() != 0 || count == 0) {
            m12262a(c2);
        } else {
            m12263a(redSpaceFriendsAdapter, count);
        }
    }

    private void m12264a(RedSpaceFriendsSection redSpaceFriendsSection, int i) {
        OverflowFriendsModel overflowFriendsModel = m12271c(this, redSpaceFriendsSection).f11774a;
        if (overflowFriendsModel != null) {
            ApproximateCountModel a = overflowFriendsModel.a();
            if (!a.j()) {
                Builder a2 = Builder.a(a);
                a2.a = a.a() + i;
                m12271c(this, redSpaceFriendsSection).m12215a(a2.a());
            }
        }
    }

    private int m12269c(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        int c = m12270c(redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection.TOP);
        if (c == -1) {
            return m12270c(redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection.OTHERS);
        }
        return c;
    }

    private int m12270c(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        RedSpaceFriendsAdapter b = m12266b(redSpaceFriendsSection);
        for (int i = 0; i < b.getCount(); i++) {
            Object item = b.getItem(i);
            if ((item instanceof RedSpaceFeedProfileFragmentModel) && ((RedSpaceFeedProfileFragmentModel) item).k().equals(redSpaceFeedProfileFragmentModel.k())) {
                return this.f11820c.a(b) + i;
            }
        }
        return -1;
    }

    public static void m12265a(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper, RedSpaceFriendsSection redSpaceFriendsSection) {
        RedSpaceFriendsAdapter b = redSpaceHomeSubscriptionHelper.m12266b(redSpaceFriendsSection);
        int count = b.getCount() - 1;
        if (b.m12152a(count) == 3) {
            redSpaceHomeSubscriptionHelper.f11821d.j_(redSpaceHomeSubscriptionHelper.f11820c.a(b) + count);
            redSpaceHomeSubscriptionHelper.m12272c();
        } else {
            m12268b(redSpaceHomeSubscriptionHelper);
        }
        RedSpaceFriendsCacheHelper redSpaceFriendsCacheHelper = (RedSpaceFriendsCacheHelper) redSpaceHomeSubscriptionHelper.f11818a.get();
        redSpaceFriendsCacheHelper.f11771a.a(m12271c(redSpaceHomeSubscriptionHelper, redSpaceFriendsSection).f11774a, redSpaceFriendsSection.getApiName());
    }

    private void m12263a(RedSpaceFriendsAdapter redSpaceFriendsAdapter, int i) {
        if (redSpaceFriendsAdapter == m12266b(RedSpaceFriendsSection.TOP)) {
            m12266b(RedSpaceFriendsSection.TOP).f11726j = false;
            m12266b(RedSpaceFriendsSection.OTHERS).f11726j = false;
            m12268b(this);
            return;
        }
        int a = this.f11820c.a(redSpaceFriendsAdapter);
        if (a != -1) {
            this.f11821d.d(a, a + i);
            m12272c();
            return;
        }
        m12268b(this);
    }

    private void m12262a(int i) {
        if (i != -1) {
            this.f11821d.l_(i);
            m12272c();
            return;
        }
        m12268b(this);
    }

    private void m12267b(int i) {
        if (i != -1) {
            this.f11821d.k_(i);
            m12272c();
            return;
        }
        m12268b(this);
    }

    private RedSpaceFriendsAdapter m12266b(RedSpaceFriendsSection redSpaceFriendsSection) {
        return (RedSpaceFriendsAdapter) this.f11823f.get(redSpaceFriendsSection.getNotOverflowVariant());
    }

    public static RedSpaceFriendsCollection m12271c(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper, RedSpaceFriendsSection redSpaceFriendsSection) {
        if (redSpaceFriendsSection == null) {
            return null;
        }
        return (RedSpaceFriendsCollection) redSpaceHomeSubscriptionHelper.f11822e.get(redSpaceFriendsSection.getNotOverflowVariant());
    }

    public static void m12268b(RedSpaceHomeSubscriptionHelper redSpaceHomeSubscriptionHelper) {
        redSpaceHomeSubscriptionHelper.m12273d();
        AdapterDetour.a(redSpaceHomeSubscriptionHelper.f11820c, -1123320322);
    }

    private void m12272c() {
        m12273d();
        this.f11820c.b();
    }

    private void m12273d() {
        boolean z;
        RedSpaceFriendsAdapter redSpaceFriendsAdapter = (RedSpaceFriendsAdapter) this.f11823f.get(RedSpaceFriendsSection.OTHERS);
        if (((RedSpaceFriendsAdapter) this.f11823f.get(RedSpaceFriendsSection.TOP)).getCount() == 0) {
            z = true;
        } else {
            z = false;
        }
        redSpaceFriendsAdapter.f11725i = z;
        int a = this.f11820c.a(redSpaceFriendsAdapter);
        if (a != -1) {
            this.f11821d.j_(a);
        }
    }
}

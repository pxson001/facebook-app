package com.facebook.entitycards;

import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.Event;
import com.facebook.entitycards.analytics.EntityCardsScrollTTITracker;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.controller.EntityCardsPresenterRegistry;
import com.facebook.entitycards.controller.EntityCardsPresenterRegistryProvider;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.EntityCardsDataKey;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.entitycards.model.EntityCardsDataSource.State;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.model.OrderedImmutableMap;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelCollectionChangedEvent;
import com.facebook.entitycards.model.event.EntityModelCollectionChangedEventSubscriber;
import com.facebook.entitycards.view.EntityCardContainerPresenterProvider;
import com.facebook.entitycards.view.EntityCardContainerView;
import com.facebook.entitycards.view.EntityCardDimensionsHelper;
import com.facebook.inject.Assisted;
import com.facebook.presenter.Presenter;
import com.facebook.presenter.ViewPresenter;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.widget.viewpager.BetterPagerAdapter;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initial_url */
public class EntityCardsAdapter extends BetterPagerAdapter implements OnPageChangeListener {
    private final int f10838a;
    private final int f10839b;
    public final EntityCardContainerPresenterProvider f10840c;
    public final EntityCardsController f10841d;
    private final LayoutInflater f10842e;
    public final EntityCardsInitialCardsSequenceLogger f10843f;
    public final AbstractFbErrorReporter f10844g;
    public final EntityCardsScrollTTITracker f10845h;
    public final RecyclableViewPoolManager f10846i;
    public final EntityCardsDataSource f10847j;
    public final EntityCardsDatasourceEventBus f10848k;
    public final FbEventSubscriberListManager f10849l;
    public EntityModelCollectionChangedEventSubscriber f10850m;
    private final HashMap<EntityCardsDataKey, EntityCardContainerView> f10851n = Maps.c();
    public final HashMap<EntityCardsDataKey, ViewPresenter> f10852o = Maps.c();
    public OrderedImmutableMap<EntityCardsDataKey, Object> f10853p;
    public final EntityCardsPresenterRegistry f10854q;

    /* compiled from: initial_url */
    class C11671 extends EntityModelCollectionChangedEventSubscriber {
        final /* synthetic */ EntityCardsAdapter f10833a;

        C11671(EntityCardsAdapter entityCardsAdapter) {
            this.f10833a = entityCardsAdapter;
        }

        public final void m12758b(FbEvent fbEvent) {
            EntityModelCollectionChangedEvent entityModelCollectionChangedEvent = (EntityModelCollectionChangedEvent) fbEvent;
            this.f10833a.f10843f.m12816a(Event.ADAPTER_UDPATED);
            OrderedImmutableMap orderedImmutableMap = this.f10833a.f10853p;
            this.f10833a.f10853p = entityModelCollectionChangedEvent.f11083a;
            EntityCardsAdapter entityCardsAdapter = this.f10833a;
            if (!Sets.c(orderedImmutableMap.m12988b(), this.f10833a.f10853p.m12988b()).isEmpty()) {
                entityCardsAdapter.f10844g.a("entity_cards_adapter_keys_removed_in_update", StringFormatUtil.a("Keys were removed on collection update! %d of %d old keys were removed.", new Object[]{Integer.valueOf(Sets.c(orderedImmutableMap.m12988b(), this.f10833a.f10853p.m12988b()).size()), Integer.valueOf(orderedImmutableMap.m12989c())}));
            }
            this.f10833a.kR_();
            if (entityModelCollectionChangedEvent.f11084b != State.INITIAL_ENTITIES_LOADED && entityModelCollectionChangedEvent.f11085c == State.INITIAL_ENTITIES_LOADED) {
                EntityCardsAdapter.m12766g(this.f10833a, this.f10833a.f10847j.mo786i());
            }
            EntityCardsScrollTTITracker entityCardsScrollTTITracker = this.f10833a.f10845h;
            entityCardsScrollTTITracker.m12833a(entityCardsScrollTTITracker.f10897b, this.f10833a.m12774e(this.f10833a.f10845h.f10897b));
        }
    }

    @Nullable
    public final String m12775f() {
        Object obj = (EntityCardsDataKey) this.f10837d;
        if (obj == null) {
            return null;
        }
        return this.f10847j.mo778a(obj);
    }

    @Inject
    public EntityCardsAdapter(@Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, @Assisted EntityCardsController entityCardsController, @Assisted EntityCardsDataSource entityCardsDataSource, @Assisted C11761 c11761, @Assisted EntityCardsScrollTTITracker entityCardsScrollTTITracker, @Assisted LayoutInflater layoutInflater, @Assisted RecyclableViewPoolManager recyclableViewPoolManager, @Assisted Integer num, @Assisted Bundle bundle, DefaultAndroidThreadUtil defaultAndroidThreadUtil, EntityCardContainerPresenterProvider entityCardContainerPresenterProvider, EntityCardDimensionsHelper entityCardDimensionsHelper, EntityCardsPresenterRegistryProvider entityCardsPresenterRegistryProvider, EntityCardsInitialCardsSequenceLogger entityCardsInitialCardsSequenceLogger, AbstractFbErrorReporter abstractFbErrorReporter, FbEventSubscriberListManager fbEventSubscriberListManager) {
        super(defaultAndroidThreadUtil);
        this.f10838a = entityCardDimensionsHelper.m13045a();
        this.f10839b = num.intValue();
        this.f10842e = layoutInflater;
        this.f10840c = entityCardContainerPresenterProvider;
        this.f10843f = entityCardsInitialCardsSequenceLogger;
        this.f10844g = abstractFbErrorReporter;
        this.f10845h = entityCardsScrollTTITracker;
        this.f10846i = recyclableViewPoolManager;
        this.f10853p = OrderedImmutableMap.m12984a();
        this.f10841d = entityCardsController;
        this.f10847j = entityCardsDataSource;
        this.f10848k = entityCardsDataSource.mo775a();
        this.f10849l = fbEventSubscriberListManager;
        this.f10850m = new C11671(this);
        this.f10854q = EntityCardsPresenterRegistryProvider.m12892a(bundle, this.f10841d, this.f10848k, c11761, this.f10847j.mo776d(), entityCardsAnalyticsLogger);
        m12765g();
        this.f10849l.a(this.f10848k);
    }

    public final int m12770b() {
        return this.f10853p.m12989c();
    }

    public final Object mo767b(ViewGroup viewGroup, int i) {
        Presenter a;
        EntityCardContainerView entityCardContainerView = new EntityCardContainerView(this.f10842e.getContext());
        entityCardContainerView.f11106b.setLayoutParams(new LayoutParams(this.f10838a, this.f10839b, 17));
        Preconditions.checkArgument(i < this.f10853p.m12989c(), "getKey() for invalid index");
        EntityCardsDataKey entityCardsDataKey = (EntityCardsDataKey) this.f10853p.m12987b(i);
        Object e = m12774e(i);
        if (this.f10852o.containsKey(entityCardsDataKey)) {
            ViewPresenter viewPresenter = (ViewPresenter) this.f10852o.get(entityCardsDataKey);
        } else {
            a = this.f10840c.m13042a(this.f10841d, entityCardsDataKey, this.f10848k, this.f10854q, this.f10846i, e);
            this.f10852o.put(entityCardsDataKey, a);
        }
        a.m13029a(entityCardContainerView);
        viewGroup.addView(entityCardContainerView);
        this.f10851n.put(entityCardsDataKey, entityCardContainerView);
        return entityCardsDataKey;
    }

    public final void mo768c(ViewGroup viewGroup, int i, Object obj) {
        EntityCardsDataKey entityCardsDataKey = (EntityCardsDataKey) obj;
        Preconditions.checkArgument(this.f10851n.containsKey(entityCardsDataKey), "Trying to destroy unknown item at position " + i);
        EntityCardContainerView entityCardContainerView = (EntityCardContainerView) Preconditions.checkNotNull(this.f10851n.remove(entityCardsDataKey));
        Preconditions.checkState(this.f10852o.containsKey(entityCardsDataKey));
        ((ViewPresenter) this.f10852o.get(entityCardsDataKey)).mo790b(entityCardContainerView);
        viewGroup.removeView(entityCardContainerView);
    }

    public final boolean m12769a(View view, Object obj) {
        return view == this.f10851n.get((EntityCardsDataKey) obj);
    }

    public final int m12767a(Object obj) {
        EntityCardsDataKey entityCardsDataKey = (EntityCardsDataKey) obj;
        if (this.f10851n.containsKey(entityCardsDataKey)) {
            int indexOf = this.f10853p.f11040b.indexOf(entityCardsDataKey);
            if (indexOf != -1 && indexOf < b()) {
                return indexOf;
            }
            m12764a(indexOf, entityCardsDataKey, this.f10853p.m12986a((Object) entityCardsDataKey));
            return -2;
        }
        m12764a(-2, entityCardsDataKey, this.f10853p.m12986a((Object) entityCardsDataKey));
        return -2;
    }

    private void m12764a(int i, EntityCardsDataKey entityCardsDataKey, Object obj) {
        this.f10844g.a("entity_cards_adapter_item_not_recognized", StringFormatUtil.a("Key not recognized at position %d with key %s and value %s", new Object[]{Integer.valueOf(i), entityCardsDataKey, obj}));
    }

    public final void m12768a(int i, float f, int i2) {
    }

    public final void e_(int i) {
        this.f10845h.m12833a(i, m12774e(i));
        m12766g(this, i);
    }

    public final void m12772b(int i) {
    }

    public final Object m12774e(int i) {
        Preconditions.checkArgument(i < this.f10853p.m12989c(), "getModel() for invalid index");
        return this.f10853p.m12985a(i);
    }

    private void m12765g() {
        this.f10849l.a(this.f10850m);
    }

    public static void m12766g(EntityCardsAdapter entityCardsAdapter, int i) {
        int k = entityCardsAdapter.f10847j.mo788k() + 2;
        if (i <= k) {
            entityCardsAdapter.f10847j.mo779a(EntityCardsScrollDirection.LEFT);
        }
        if (i >= entityCardsAdapter.b() - k) {
            entityCardsAdapter.f10847j.mo779a(EntityCardsScrollDirection.RIGHT);
        }
    }
}

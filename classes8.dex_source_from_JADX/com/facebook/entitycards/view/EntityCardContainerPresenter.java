package com.facebook.entitycards.view;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.event.FbEvent;
import com.facebook.entitycards.controller.EntityCardsController;
import com.facebook.entitycards.controller.EntityCardsPresenterRegistry;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.model.event.EntityModelChangedEvent;
import com.facebook.entitycards.model.event.EntityModelChangedEventSubscriber;
import com.facebook.inject.Assisted;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.presenter.ViewPresenter;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: home_creation_cell_tapped */
public class EntityCardContainerPresenter extends ViewPresenter<EntityCardContainerView> {
    private final EntityCardsController f11095a;
    public final EntityCardsPresenterRegistry f11096b;
    private final EntityCardsViewFactory f11097c;
    private final RecyclableViewPoolManager f11098d;
    private final ViewHelperViewAnimatorFactory f11099e;
    public final Object f11100f;
    public ViewPresenter f11101g = this.f11096b.m12891a(this.f11102h);
    public Object f11102h;
    private final EntityCardsDatasourceEventBus f11103i;
    public final EntityModelChangedEventSubscriber f11104j;

    /* compiled from: home_creation_cell_tapped */
    class C11991 extends EntityModelChangedEventSubscriber {
        final /* synthetic */ EntityCardContainerPresenter f11090a;

        C11991(EntityCardContainerPresenter entityCardContainerPresenter) {
            this.f11090a = entityCardContainerPresenter;
        }

        public final boolean m13026a(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            return (entityModelChangedEvent.f11082c == null || !Objects.equal(this.f11090a.f11100f, entityModelChangedEvent.f11080a) || this.f11090a.f11102h.getClass() == entityModelChangedEvent.f11082c.getClass()) ? false : true;
        }

        public final void m13027b(FbEvent fbEvent) {
            EntityModelChangedEvent entityModelChangedEvent = (EntityModelChangedEvent) fbEvent;
            this.f11090a.f11102h = Preconditions.checkNotNull(entityModelChangedEvent.f11082c);
            this.f11090a.f11101g = this.f11090a.f11096b.m12891a(this.f11090a.f11102h);
            EntityCardContainerPresenter.m13038d(this.f11090a);
        }
    }

    public final /* synthetic */ void mo790b(Object obj) {
        m13039a((EntityCardContainerView) obj);
    }

    @Inject
    public EntityCardContainerPresenter(@Assisted EntityCardsController entityCardsController, @Assisted Object obj, @Assisted EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, @Assisted EntityCardsPresenterRegistry entityCardsPresenterRegistry, @Assisted RecyclableViewPoolManager recyclableViewPoolManager, @Assisted Object obj2, EntityCardsViewFactory entityCardsViewFactory, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        this.f11095a = (EntityCardsController) Preconditions.checkNotNull(entityCardsController);
        this.f11103i = (EntityCardsDatasourceEventBus) Preconditions.checkNotNull(entityCardsDatasourceEventBus);
        this.f11100f = Preconditions.checkNotNull(obj);
        this.f11096b = entityCardsPresenterRegistry;
        this.f11102h = Preconditions.checkNotNull(obj2);
        this.f11097c = entityCardsViewFactory;
        this.f11098d = recyclableViewPoolManager;
        this.f11099e = viewHelperViewAnimatorFactory;
        this.f11104j = new C11991(this);
    }

    private void m13035b(EntityCardContainerView entityCardContainerView) {
        entityCardContainerView.f11105a = this;
        View a = m13034a(this.f11102h, m13033a(m13037d(this.f11102h).a()), entityCardContainerView);
        if (entityCardContainerView.f11106b.getChildCount() > 0) {
            entityCardContainerView.f11106b.removeAllViews();
        }
        entityCardContainerView.f11106b.addView(a);
    }

    protected final void mo789b() {
        this.f11103i.b(this.f11104j);
        this.f11103i.a(this.f11104j);
        m13036c();
    }

    public final void m13039a(EntityCardContainerView entityCardContainerView) {
        Object obj = 1;
        ImmutableList cardViews = entityCardContainerView.getCardViews();
        int size = cardViews.size();
        for (int i = 0; i < size; i++) {
            View view = (View) cardViews.get(i);
            if (obj != null) {
                this.f11101g.mo790b(view);
                obj = null;
            }
            this.f11098d.a(view.getClass(), view, entityCardContainerView.f11106b);
        }
        super.mo790b(entityCardContainerView);
    }

    private void m13036c() {
        Optional a = m13028a();
        if (a.isPresent()) {
            m13035b((EntityCardContainerView) a.get());
        }
    }

    public static void m13038d(EntityCardContainerPresenter entityCardContainerPresenter) {
        Optional a = entityCardContainerPresenter.m13028a();
        if (a.isPresent()) {
            final EntityCardContainerView entityCardContainerView = (EntityCardContainerView) a.get();
            entityCardContainerView.f11105a = entityCardContainerPresenter;
            final View view = (View) entityCardContainerView.getCardViews().get(0);
            entityCardContainerView.f11106b.addView(entityCardContainerPresenter.m13034a(entityCardContainerPresenter.f11102h, entityCardContainerPresenter.m13033a(entityCardContainerPresenter.m13037d(entityCardContainerPresenter.f11102h).a()), entityCardContainerView), 0);
            VisibilityAnimator visibilityAnimator = new VisibilityAnimator(view, (long) entityCardContainerView.getResources().getInteger(17694721), false, entityCardContainerPresenter.f11099e, 1.0f, 0.0f);
            visibilityAnimator.a(1.0f);
            visibilityAnimator.j = new Object(entityCardContainerPresenter) {
                final /* synthetic */ EntityCardContainerPresenter f11093c;
            };
            visibilityAnimator.d();
        }
    }

    private View m13034a(Object obj, @Nullable View view, ViewGroup viewGroup) {
        if (view == null) {
            view = m13037d(obj).mo791a(viewGroup);
            Preconditions.checkNotNull(view, "createView() shall not return null value!");
        }
        view.setTag(obj);
        Preconditions.checkNotNull(view);
        this.f11101g.m13029a(view);
        return view;
    }

    private EntityCardsCardType m13037d(Object obj) {
        return this.f11095a.m12888a(obj);
    }

    private View m13033a(Class cls) {
        View a = this.f11098d.a(cls);
        if (a != null) {
            Preconditions.checkState(cls == a.getClass(), "Requested view of type %s but got view of type %s. Types must be identical.", new Object[]{cls, a.getClass()});
        }
        return a;
    }
}

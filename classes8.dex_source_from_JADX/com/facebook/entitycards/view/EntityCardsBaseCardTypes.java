package com.facebook.entitycards.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.controller.EntityCardsController.EntityCardController;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.ScrollLoadError;
import com.facebook.entitycards.model.ScrollLoadTrigger;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.inject.InjectorLike;
import com.facebook.presenter.ViewPresenter;
import com.facebook.ui.recyclableviewpool.IRecyclableViewFactory;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: home_%s_privacy_tapped */
public class EntityCardsBaseCardTypes implements EntityCardsCardSupportDeclaration {
    public static final ViewPoolLimit f11116a = new ViewPoolLimit(2, 1);
    public static final ViewPoolPrefillAmount f11117b = new ViewPoolPrefillAmount(0, 0);
    private static volatile EntityCardsBaseCardTypes f11118h;
    public final EntityCardsCardType f11119c = new C12021(this);
    public final EntityCardsCardType f11120d = new C12042(this);
    public final ImmutableMap<Class<?>, EntityCardController<?>> f11121e = ImmutableMap.builder().b(ScrollLoadTrigger.class, new C12064(this)).b(ScrollLoadError.class, new C12053(this)).b();
    public final ImmutableSet<EntityCardsCardType> f11122f = ImmutableSet.of(this.f11119c, this.f11120d);
    public final EntityCardsLoadingCardPresenterProvider f11123g;

    /* compiled from: home_%s_privacy_tapped */
    class C12021 implements EntityCardsCardType {
        final /* synthetic */ EntityCardsBaseCardTypes f11111a;

        /* compiled from: home_%s_privacy_tapped */
        public class C12011 implements IRecyclableViewFactory<EntityCardsLoadingCardView> {
            final /* synthetic */ C12021 f11110a;

            public C12011(C12021 c12021) {
                this.f11110a = c12021;
            }

            public final View m13046a(Context context) {
                return new EntityCardsLoadingCardView(context);
            }
        }

        C12021(EntityCardsBaseCardTypes entityCardsBaseCardTypes) {
            this.f11111a = entityCardsBaseCardTypes;
        }

        public final Class<EntityCardsLoadingCardView> m13049a() {
            return EntityCardsLoadingCardView.class;
        }

        public final ViewPoolLimit m13050b() {
            return EntityCardsBaseCardTypes.f11116a;
        }

        public final ViewPoolPrefillAmount m13051c() {
            return EntityCardsBaseCardTypes.f11117b;
        }

        public final View mo791a(ViewGroup viewGroup) {
            return new C12011(this).a(viewGroup.getContext());
        }
    }

    /* compiled from: home_%s_privacy_tapped */
    class C12042 implements EntityCardsCardType {
        final /* synthetic */ EntityCardsBaseCardTypes f11113a;

        /* compiled from: home_%s_privacy_tapped */
        public class C12031 implements IRecyclableViewFactory<EntityCardsErrorCardView> {
            final /* synthetic */ C12042 f11112a;

            public C12031(C12042 c12042) {
                this.f11112a = c12042;
            }

            public final View m13052a(Context context) {
                return new EntityCardsErrorCardView(context);
            }
        }

        C12042(EntityCardsBaseCardTypes entityCardsBaseCardTypes) {
            this.f11113a = entityCardsBaseCardTypes;
        }

        public final Class<EntityCardsErrorCardView> m13054a() {
            return EntityCardsErrorCardView.class;
        }

        public final ViewPoolLimit m13055b() {
            return EntityCardsBaseCardTypes.f11116a;
        }

        public final ViewPoolPrefillAmount m13056c() {
            return EntityCardsBaseCardTypes.f11117b;
        }

        public final View mo791a(ViewGroup viewGroup) {
            return new C12031(this).a(viewGroup.getContext());
        }
    }

    /* compiled from: home_%s_privacy_tapped */
    class C12053 extends EntityCardController<ScrollLoadError> {
        final /* synthetic */ EntityCardsBaseCardTypes f11114a;

        C12053(EntityCardsBaseCardTypes entityCardsBaseCardTypes) {
            this.f11114a = entityCardsBaseCardTypes;
        }

        public final ViewPresenter mo793a(Object obj, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, Bundle bundle) {
            return new EntityCardsErrorCardPresenter((ScrollLoadError) obj, c11881);
        }

        public final EntityCardsCardType mo792a(Object obj) {
            return this.f11114a.f11120d;
        }
    }

    /* compiled from: home_%s_privacy_tapped */
    class C12064 extends EntityCardController<ScrollLoadTrigger> {
        final /* synthetic */ EntityCardsBaseCardTypes f11115a;

        C12064(EntityCardsBaseCardTypes entityCardsBaseCardTypes) {
            this.f11115a = entityCardsBaseCardTypes;
        }

        public final ViewPresenter mo793a(Object obj, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, Bundle bundle) {
            ScrollLoadTrigger scrollLoadTrigger = (ScrollLoadTrigger) obj;
            EntityCardsLoadingCardPresenterProvider entityCardsLoadingCardPresenterProvider = this.f11115a.f11123g;
            return new EntityCardsLoadingCardPresenter(scrollLoadTrigger);
        }

        public final EntityCardsCardType mo792a(Object obj) {
            return this.f11115a.f11119c;
        }
    }

    public static com.facebook.entitycards.view.EntityCardsBaseCardTypes m13061a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11118h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycards.view.EntityCardsBaseCardTypes.class;
        monitor-enter(r1);
        r0 = f11118h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13062b(r0);	 Catch:{ all -> 0x0035 }
        f11118h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11118h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.view.EntityCardsBaseCardTypes.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.view.EntityCardsBaseCardTypes");
    }

    private static EntityCardsBaseCardTypes m13062b(InjectorLike injectorLike) {
        return new EntityCardsBaseCardTypes((EntityCardsLoadingCardPresenterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EntityCardsLoadingCardPresenterProvider.class));
    }

    @Inject
    public EntityCardsBaseCardTypes(EntityCardsLoadingCardPresenterProvider entityCardsLoadingCardPresenterProvider) {
        this.f11123g = entityCardsLoadingCardPresenterProvider;
    }

    public final ImmutableSet<EntityCardsCardType> mo794a() {
        return this.f11122f;
    }

    public final ImmutableMap<Class<?>, EntityCardController<?>> mo795b() {
        return this.f11121e;
    }

    public final boolean mo796c() {
        return true;
    }
}

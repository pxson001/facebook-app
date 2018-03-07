package com.facebook.entitycardsplugins.person;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.analytics.EntityCardsAnalyticsLogger;
import com.facebook.entitycards.controller.EntityCardsController.EntityCardController;
import com.facebook.entitycards.intent.EntityCardsFragment.C11761;
import com.facebook.entitycards.model.AbstractEntityCardsDataSource.C11881;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.event.EntityCardsDatasourceEventBus;
import com.facebook.entitycards.view.EntityCardsCardType;
import com.facebook.entitycardsplugins.person.presenter.PersonCardPresenterProvider;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.view.PersonCardView;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
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
/* compiled from: home_%s_done_tapped */
public class PersonCardSupportDeclaration implements EntityCardsCardSupportDeclaration {
    public static final ViewPoolLimit f11136a = new ViewPoolLimit(6, 5);
    public static final ViewPoolPrefillAmount f11137b = new ViewPoolPrefillAmount(0, 0);
    private static volatile PersonCardSupportDeclaration f11138h;
    public final EntityCardsCardType f11139c = new C12091(this);
    public final PersonCardPresenterProvider f11140d;
    private final PersonCardViewHelper f11141e;
    private final ImmutableMap<Class<?>, EntityCardController<?>> f11142f = ImmutableMap.builder().b(PersonCardModel.class, new C12102(this)).b();
    private final ImmutableSet<EntityCardsCardType> f11143g = ImmutableSet.of(this.f11139c);

    /* compiled from: home_%s_done_tapped */
    class C12091 implements EntityCardsCardType {
        final /* synthetic */ PersonCardSupportDeclaration f11134a;

        /* compiled from: home_%s_done_tapped */
        public class C12081 implements IRecyclableViewFactory<PersonCardView> {
            final /* synthetic */ C12091 f11133a;

            public C12081(C12091 c12091) {
                this.f11133a = c12091;
            }

            public final View m13072a(Context context) {
                return new PersonCardView(context);
            }
        }

        C12091(PersonCardSupportDeclaration personCardSupportDeclaration) {
            this.f11134a = personCardSupportDeclaration;
        }

        public final Class<PersonCardView> m13074a() {
            return PersonCardView.class;
        }

        public final ViewPoolLimit m13075b() {
            return PersonCardSupportDeclaration.f11136a;
        }

        public final ViewPoolPrefillAmount m13076c() {
            return PersonCardSupportDeclaration.f11137b;
        }

        public final View mo791a(ViewGroup viewGroup) {
            return new C12081(this).a(viewGroup.getContext());
        }
    }

    /* compiled from: home_%s_done_tapped */
    class C12102 extends EntityCardController<PersonCardModel> {
        final /* synthetic */ PersonCardSupportDeclaration f11135a;

        C12102(PersonCardSupportDeclaration personCardSupportDeclaration) {
            this.f11135a = personCardSupportDeclaration;
        }

        public final EntityCardsCardType mo792a(Object obj) {
            return this.f11135a.f11139c;
        }

        private ViewPresenter m13077a(PersonCardModel personCardModel, EntityCardsDatasourceEventBus entityCardsDatasourceEventBus, C11761 c11761, C11881 c11881, EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, Bundle bundle) {
            Object string;
            Object string2;
            FriendingLocation friendingLocation;
            FriendRequestMakeRef friendRequestMakeRef;
            if (bundle != null) {
                string = bundle.getString("extra_friending_location_name");
                string2 = bundle.getString("extra_friend_request_make_ref");
            } else {
                string2 = null;
                string = null;
            }
            if (StringUtil.a(string)) {
                friendingLocation = null;
            } else {
                friendingLocation = FriendingLocation.valueOf(string);
            }
            if (StringUtil.a(string2)) {
                friendRequestMakeRef = null;
            } else {
                friendRequestMakeRef = FriendRequestMakeRef.valueOf(string2);
            }
            return this.f11135a.f11140d.m13096a(personCardModel, entityCardsAnalyticsLogger, entityCardsDatasourceEventBus, c11761, c11881, friendingLocation, friendRequestMakeRef);
        }
    }

    public static com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration m13080a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11138h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration.class;
        monitor-enter(r1);
        r0 = f11138h;	 Catch:{ all -> 0x003a }
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
        r0 = m13081b(r0);	 Catch:{ all -> 0x0035 }
        f11138h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11138h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.entitycardsplugins.person.PersonCardSupportDeclaration");
    }

    private static PersonCardSupportDeclaration m13081b(InjectorLike injectorLike) {
        return new PersonCardSupportDeclaration((PersonCardPresenterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PersonCardPresenterProvider.class), PersonCardViewHelper.m13239a(injectorLike));
    }

    @Inject
    public PersonCardSupportDeclaration(PersonCardPresenterProvider personCardPresenterProvider, PersonCardViewHelper personCardViewHelper) {
        this.f11140d = personCardPresenterProvider;
        this.f11141e = personCardViewHelper;
    }

    public final ImmutableSet<EntityCardsCardType> mo794a() {
        return this.f11143g;
    }

    public final ImmutableMap<Class<?>, EntityCardController<?>> mo795b() {
        return this.f11142f;
    }

    public final boolean mo796c() {
        return this.f11141e.m13246e() >= 2;
    }
}

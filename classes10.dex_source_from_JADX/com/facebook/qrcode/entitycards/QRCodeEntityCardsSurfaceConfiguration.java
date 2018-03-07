package com.facebook.qrcode.entitycards;

import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoaderProvider;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.STATICDI_MULTIBIND_PROVIDER.EntityCardsCardSupportDeclaration__com_facebook_qrcode_entitycards_QRCodeEntityCards;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfigurationHelper;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoaderProvider;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: link_uri */
public class QRCodeEntityCardsSurfaceConfiguration extends BasePersonCardsSurfaceConfiguration {
    private static volatile QRCodeEntityCardsSurfaceConfiguration f8633e;
    private final Lazy<Set<EntityCardsCardSupportDeclaration>> f8634d;

    public static com.facebook.qrcode.entitycards.QRCodeEntityCardsSurfaceConfiguration m8595a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8633e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.qrcode.entitycards.QRCodeEntityCardsSurfaceConfiguration.class;
        monitor-enter(r1);
        r0 = f8633e;	 Catch:{ all -> 0x003a }
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
        r0 = m8596b(r0);	 Catch:{ all -> 0x0035 }
        f8633e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8633e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.qrcode.entitycards.QRCodeEntityCardsSurfaceConfiguration.a(com.facebook.inject.InjectorLike):com.facebook.qrcode.entitycards.QRCodeEntityCardsSurfaceConfiguration");
    }

    private static QRCodeEntityCardsSurfaceConfiguration m8596b(InjectorLike injectorLike) {
        return new QRCodeEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper.b(injectorLike), EntityCardsIntentHelper.a(injectorLike), ProviderLazy.a(new EntityCardsCardSupportDeclaration__com_facebook_qrcode_entitycards_QRCodeEntityCards(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (DefaultPersonCardsLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPersonCardsLoaderProvider.class), (DefaultEntityCardsPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultEntityCardsPageLoaderProvider.class), IdBasedProvider.a(injectorLike, 5523), PersonCardViewHelper.a(injectorLike));
    }

    @Inject
    public QRCodeEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper entityCardsSurfaceConfigurationHelper, EntityCardsIntentHelper entityCardsIntentHelper, Lazy<Set<EntityCardsCardSupportDeclaration>> lazy, DefaultPersonCardsLoaderProvider defaultPersonCardsLoaderProvider, DefaultEntityCardsPageLoaderProvider defaultEntityCardsPageLoaderProvider, Provider<PersonCardActivityResultHandler> provider, PersonCardViewHelper personCardViewHelper) {
        super(entityCardsSurfaceConfigurationHelper, provider, personCardViewHelper, entityCardsIntentHelper, defaultPersonCardsLoaderProvider, defaultEntityCardsPageLoaderProvider);
        this.f8634d = lazy;
    }

    public final String m8597a() {
        return "qr_code";
    }

    public final Set<EntityCardsCardSupportDeclaration> m8598b() {
        return (Set) this.f8634d.get();
    }
}

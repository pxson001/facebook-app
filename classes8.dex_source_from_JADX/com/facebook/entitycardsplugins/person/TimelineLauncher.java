package com.facebook.entitycardsplugins.person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.earlyfetch.EarlyFetchController;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardContextItemModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.timeline.intent.ModelBundle;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: home_%s_city_updated */
public class TimelineLauncher {
    private static volatile TimelineLauncher f11144e;
    private final Provider<UriIntentMapper> f11145a;
    private final Provider<EarlyFetchController> f11146b;
    private final Provider<SecureContextHelper> f11147c;
    private final InteractionTTILogger f11148d;

    public static com.facebook.entitycardsplugins.person.TimelineLauncher m13085a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11144e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycardsplugins.person.TimelineLauncher.class;
        monitor-enter(r1);
        r0 = f11144e;	 Catch:{ all -> 0x003a }
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
        r0 = m13087b(r0);	 Catch:{ all -> 0x0035 }
        f11144e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11144e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycardsplugins.person.TimelineLauncher.a(com.facebook.inject.InjectorLike):com.facebook.entitycardsplugins.person.TimelineLauncher");
    }

    private static TimelineLauncher m13087b(InjectorLike injectorLike) {
        return new TimelineLauncher(IdBasedSingletonScopeProvider.a(injectorLike, 2436), IdBasedSingletonScopeProvider.a(injectorLike, 1120), IdBasedSingletonScopeProvider.a(injectorLike, 968), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public TimelineLauncher(Provider<UriIntentMapper> provider, Provider<EarlyFetchController> provider2, Provider<SecureContextHelper> provider3, InteractionTTILogger interactionTTILogger) {
        this.f11146b = provider2;
        this.f11145a = provider;
        this.f11147c = provider3;
        this.f11148d = interactionTTILogger;
    }

    public final void m13088a(Context context, PersonCardModel personCardModel) {
        String b;
        DefaultVect2FieldsModel defaultVect2FieldsModel;
        this.f11148d.a(context, "TimelineLauncher");
        String r = personCardModel.m13204r();
        String a = StringFormatUtil.a(FBLinks.aX, new Object[]{r});
        Bundle bundle = new Bundle();
        if (!(personCardModel.m13185A() == null || personCardModel.m13185A().m13155a().isEmpty())) {
            PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) personCardModel.m13185A().m13155a().get(0);
            if (!(personCardContextItemModel == null || personCardContextItemModel.m13125r() == null || personCardContextItemModel.m13125r() == GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                bundle.putString("timeline_context_item_type", personCardContextItemModel.m13125r().name());
            }
        }
        if (personCardModel.m13210x() != null) {
            b = personCardModel.m13210x().b();
        } else {
            b = null;
        }
        String u = personCardModel.m13207u();
        String a2 = m13086a(personCardModel);
        if (personCardModel == null || personCardModel.m13202p() == null || m13086a(personCardModel) == null) {
            defaultVect2FieldsModel = null;
        } else {
            defaultVect2FieldsModel = personCardModel.m13202p().m13172a();
        }
        ModelBundle.a(bundle, r, b, u, a2, defaultVect2FieldsModel);
        Intent a3 = ((UriIntentMapper) this.f11145a.get()).a(context, a);
        if (a3 != null) {
            a3.putExtras(bundle);
            this.f11148d.q(context.toString());
            ((EarlyFetchController) this.f11146b.get()).a(a3);
            ((SecureContextHelper) this.f11147c.get()).a(a3, context);
            this.f11148d.r(context.toString());
            return;
        }
        this.f11148d.a();
    }

    public static String m13086a(PersonCardModel personCardModel) {
        if (personCardModel == null || personCardModel.m13202p() == null || personCardModel.m13202p().m13174j() == null || personCardModel.m13202p().m13174j().m13168j() == null) {
            return null;
        }
        return personCardModel.m13202p().m13174j().m13168j().b();
    }
}

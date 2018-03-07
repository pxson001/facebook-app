package com.facebook.privacy.educator;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorAction;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: STOPPED */
public class AudienceEducatorTooltipGenerator {
    private static volatile AudienceEducatorTooltipGenerator f11288b;
    public final Lazy<Resources> f11289a;

    /* compiled from: STOPPED */
    public /* synthetic */ class C13671 {
        public static final /* synthetic */ int[] f11286a = new int[AudienceEducatorAction.values().length];
        public static final /* synthetic */ int[] f11287b = new int[AudienceEducatorType.values().length];

        static {
            try {
                f11287b[AudienceEducatorType.NEWCOMER_AUDIENCE_EDUCATOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11287b[AudienceEducatorType.AUDIENCE_ALIGNMENT_EDUCATOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11287b[AudienceEducatorType.AUDIENCE_ALIGNMENT_ONLY_ME_EDUCATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11286a[AudienceEducatorAction.SET_PRIVACY_TO_ONLY_ME.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11286a[AudienceEducatorAction.SET_PRIVACY_TO_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11286a[AudienceEducatorAction.SET_PRIVACY_TO_WIDEST.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11286a[AudienceEducatorAction.OPEN_MORE_OPTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11286a[AudienceEducatorAction.SKIPPED_EDUCATOR.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static com.facebook.privacy.educator.AudienceEducatorTooltipGenerator m11662a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11288b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.educator.AudienceEducatorTooltipGenerator.class;
        monitor-enter(r1);
        r0 = f11288b;	 Catch:{ all -> 0x003a }
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
        r0 = m11663b(r0);	 Catch:{ all -> 0x0035 }
        f11288b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11288b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.educator.AudienceEducatorTooltipGenerator.a(com.facebook.inject.InjectorLike):com.facebook.privacy.educator.AudienceEducatorTooltipGenerator");
    }

    private static AudienceEducatorTooltipGenerator m11663b(InjectorLike injectorLike) {
        return new AudienceEducatorTooltipGenerator(IdBasedSingletonScopeProvider.b(injectorLike, 30));
    }

    @Inject
    AudienceEducatorTooltipGenerator(Lazy<Resources> lazy) {
        this.f11289a = lazy;
    }

    public final Map<String, String> m11664a(AudienceEducatorAction audienceEducatorAction, AudienceEducatorType audienceEducatorType, GraphQLPrivacyOption graphQLPrivacyOption) {
        Map<String, String> c = Maps.c();
        switch (C13671.f11286a[audienceEducatorAction.ordinal()]) {
            case 1:
            case 2:
            case 3:
                Preconditions.checkNotNull(graphQLPrivacyOption);
                Preconditions.checkArgument(!StringUtil.a(graphQLPrivacyOption.d()));
                switch (C13671.f11287b[audienceEducatorType.ordinal()]) {
                    case 1:
                        c.put("tooltip_title", ((Resources) this.f11289a.get()).getString(2131242432, new Object[]{graphQLPrivacyOption.d()}));
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242435));
                        break;
                    case 2:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242416, new Object[]{graphQLPrivacyOption.d()}));
                        break;
                    case 3:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242424, new Object[]{graphQLPrivacyOption.d()}));
                        break;
                }
                break;
            case 4:
                switch (C13671.f11287b[audienceEducatorType.ordinal()]) {
                    case 1:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242433));
                        break;
                    case 2:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242417));
                        break;
                    case 3:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242425));
                        break;
                }
                break;
            case 5:
                switch (C13671.f11287b[audienceEducatorType.ordinal()]) {
                    case 1:
                        c.put("tooltip_title", ((Resources) this.f11289a.get()).getString(2131242434));
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242435));
                        break;
                    case 2:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242418));
                        break;
                    case 3:
                        c.put("tooltip_body", ((Resources) this.f11289a.get()).getString(2131242426));
                        break;
                }
                break;
        }
        return c;
    }
}

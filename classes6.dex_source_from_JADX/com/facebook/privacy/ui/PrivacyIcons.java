package com.facebook.privacy.ui;

import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: farLeft */
public class PrivacyIcons {
    @VisibleForTesting
    static final Integer f15322a = Integer.valueOf(0);
    @VisibleForTesting
    static final ImmutableMap<GraphQLPrivacyOptionType, Integer> f15323b = ImmutableMap.builder().b(GraphQLPrivacyOptionType.ACQUAINTANCES, Integer.valueOf(2130842742)).b(GraphQLPrivacyOptionType.CLOSE_FRIENDS, Integer.valueOf(2130842743)).b(GraphQLPrivacyOptionType.CUSTOM, Integer.valueOf(2130842744)).b(GraphQLPrivacyOptionType.EVERYONE, Integer.valueOf(2130842746)).b(GraphQLPrivacyOptionType.FACEBOOK, Integer.valueOf(2130842747)).b(GraphQLPrivacyOptionType.GENERIC_LIST, Integer.valueOf(2130842752)).b(GraphQLPrivacyOptionType.FRIENDS, Integer.valueOf(2130842749)).b(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Integer.valueOf(2130842750)).b(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS, Integer.valueOf(2130842751)).b(GraphQLPrivacyOptionType.FAMILY_LIST, Integer.valueOf(2130842748)).b(GraphQLPrivacyOptionType.LOCATION_LIST, Integer.valueOf(2130842756)).b(GraphQLPrivacyOptionType.ONLY_ME, Integer.valueOf(2130842757)).b(GraphQLPrivacyOptionType.SCHOOL_LIST, Integer.valueOf(2130842758)).b(GraphQLPrivacyOptionType.WORK_LIST, Integer.valueOf(2130842759)).b(GraphQLPrivacyOptionType.GROUP, Integer.valueOf(2130842754)).b(GraphQLPrivacyOptionType.EVENT, Integer.valueOf(2130842745)).b();
    @VisibleForTesting
    static final ImmutableMap<GraphQLPrivacyOptionType, Integer> f15324c = ImmutableMap.builder().b(GraphQLPrivacyOptionType.EVERYONE, Integer.valueOf(2130837722)).b(GraphQLPrivacyOptionType.FRIENDS, Integer.valueOf(2130837697)).b(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Integer.valueOf(2130837701)).b(GraphQLPrivacyOptionType.ONLY_ME, Integer.valueOf(2130837721)).b(GraphQLPrivacyOptionType.FACEBOOK, Integer.valueOf(2130837688)).b(GraphQLPrivacyOptionType.GENERIC_LIST, Integer.valueOf(2130837695)).b(GraphQLPrivacyOptionType.CUSTOM, Integer.valueOf(2130837682)).b(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS, Integer.valueOf(2130837702)).b(GraphQLPrivacyOptionType.CLOSE_FRIENDS, Integer.valueOf(2130837680)).b(GraphQLPrivacyOptionType.ACQUAINTANCES, Integer.valueOf(2130837676)).b(GraphQLPrivacyOptionType.FAMILY_LIST, Integer.valueOf(2130837690)).b(GraphQLPrivacyOptionType.LOCATION_LIST, Integer.valueOf(2130837716)).b(GraphQLPrivacyOptionType.SCHOOL_LIST, Integer.valueOf(2130837723)).b(GraphQLPrivacyOptionType.WORK_LIST, Integer.valueOf(2130837731)).b(GraphQLPrivacyOptionType.GROUP, f15322a).b(GraphQLPrivacyOptionType.EVENT, f15322a).b();
    @VisibleForTesting
    static final ImmutableMap<GraphQLPrivacyOptionType, Integer> f15325d = new Builder().b(GraphQLPrivacyOptionType.EVERYONE, Integer.valueOf(2130837685)).b(GraphQLPrivacyOptionType.FRIENDS, Integer.valueOf(2130837696)).b(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Integer.valueOf(2130837698)).b(GraphQLPrivacyOptionType.ONLY_ME, Integer.valueOf(2130837719)).b(GraphQLPrivacyOptionType.FACEBOOK, Integer.valueOf(2130837687)).b(GraphQLPrivacyOptionType.GENERIC_LIST, Integer.valueOf(2130837714)).b(GraphQLPrivacyOptionType.CUSTOM, Integer.valueOf(2130837681)).b(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS, Integer.valueOf(2130837693)).b(GraphQLPrivacyOptionType.CLOSE_FRIENDS, Integer.valueOf(2130837678)).b(GraphQLPrivacyOptionType.ACQUAINTANCES, Integer.valueOf(2130837675)).b(GraphQLPrivacyOptionType.FAMILY_LIST, Integer.valueOf(2130837692)).b(GraphQLPrivacyOptionType.LOCATION_LIST, Integer.valueOf(2130837718)).b(GraphQLPrivacyOptionType.SCHOOL_LIST, Integer.valueOf(2130837725)).b(GraphQLPrivacyOptionType.WORK_LIST, Integer.valueOf(2130837733)).b(GraphQLPrivacyOptionType.GROUP, Integer.valueOf(2130837681)).b(GraphQLPrivacyOptionType.EVENT, Integer.valueOf(2130837681)).b();
    @VisibleForTesting
    static final ImmutableMap<GraphQLPrivacyOptionType, Integer> f15326e = new Builder().b(GraphQLPrivacyOptionType.EVERYONE, Integer.valueOf(2130837686)).b(GraphQLPrivacyOptionType.FRIENDS, Integer.valueOf(2130837700)).b(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Integer.valueOf(2130837699)).b(GraphQLPrivacyOptionType.ONLY_ME, Integer.valueOf(2130837720)).b(GraphQLPrivacyOptionType.FACEBOOK, Integer.valueOf(2130837689)).b(GraphQLPrivacyOptionType.GENERIC_LIST, Integer.valueOf(2130837715)).b(GraphQLPrivacyOptionType.CUSTOM, Integer.valueOf(2130837683)).b(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS, Integer.valueOf(2130837694)).b(GraphQLPrivacyOptionType.CLOSE_FRIENDS, Integer.valueOf(2130837679)).b(GraphQLPrivacyOptionType.ACQUAINTANCES, Integer.valueOf(2130837677)).b(GraphQLPrivacyOptionType.FAMILY_LIST, Integer.valueOf(2130837691)).b(GraphQLPrivacyOptionType.LOCATION_LIST, Integer.valueOf(2130837717)).b(GraphQLPrivacyOptionType.SCHOOL_LIST, Integer.valueOf(2130837724)).b(GraphQLPrivacyOptionType.WORK_LIST, Integer.valueOf(2130837732)).b(GraphQLPrivacyOptionType.GROUP, Integer.valueOf(2130837683)).b(GraphQLPrivacyOptionType.EVENT, Integer.valueOf(2130837683)).b();
    @VisibleForTesting
    static final ImmutableMap<GraphQLPrivacyOptionType, Integer> f15327f = new Builder().b(GraphQLPrivacyOptionType.EVERYONE, Integer.valueOf(2130839905)).b(GraphQLPrivacyOptionType.FRIENDS, Integer.valueOf(2130839882)).b(GraphQLPrivacyOptionType.FRIENDS_EXCEPT_ACQUAINTANCES, Integer.valueOf(2130839881)).b(GraphQLPrivacyOptionType.ONLY_ME, Integer.valueOf(2130839972)).b(GraphQLPrivacyOptionType.FACEBOOK, Integer.valueOf(2130839681)).b(GraphQLPrivacyOptionType.GENERIC_LIST, Integer.valueOf(2130839886)).b(GraphQLPrivacyOptionType.CUSTOM, Integer.valueOf(2130839901)).b(GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS, Integer.valueOf(2130839914)).b(GraphQLPrivacyOptionType.CLOSE_FRIENDS, Integer.valueOf(2130840114)).b(GraphQLPrivacyOptionType.ACQUAINTANCES, Integer.valueOf(2130839885)).b(GraphQLPrivacyOptionType.FAMILY_LIST, Integer.valueOf(2130839921)).b(GraphQLPrivacyOptionType.LOCATION_LIST, Integer.valueOf(2130840023)).b(GraphQLPrivacyOptionType.SCHOOL_LIST, Integer.valueOf(2130839844)).b(GraphQLPrivacyOptionType.WORK_LIST, Integer.valueOf(2130839723)).b(GraphQLPrivacyOptionType.GROUP, Integer.valueOf(2130839901)).b(GraphQLPrivacyOptionType.EVENT, Integer.valueOf(2130839901)).b();
    private static volatile PrivacyIcons f15328g;

    /* compiled from: farLeft */
    public enum Size {
        PILL,
        TOKEN,
        LIST,
        COMPOSER_FOOTER,
        GLYPH
    }

    public static com.facebook.privacy.ui.PrivacyIcons m22956a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f15328g;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.privacy.ui.PrivacyIcons.class;
        monitor-enter(r1);
        r0 = f15328g;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m22955a();	 Catch:{ all -> 0x0034 }
        f15328g = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f15328g;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.ui.PrivacyIcons.a(com.facebook.inject.InjectorLike):com.facebook.privacy.ui.PrivacyIcons");
    }

    private static PrivacyIcons m22955a() {
        return new PrivacyIcons();
    }

    public final int m22959a(PrivacyIconFields privacyIconFields, Size size) {
        GraphQLPrivacyOptionType graphQLPrivacyOptionType = GraphQLPrivacyOptionType.CUSTOM;
        if (!(privacyIconFields == null || privacyIconFields.d() == null)) {
            graphQLPrivacyOptionType = GraphQLPrivacyOptionType.fromIconName(privacyIconFields.d());
        }
        return m22957a(graphQLPrivacyOptionType, size);
    }

    public final int m22958a(GraphQLImage graphQLImage, Size size) {
        GraphQLPrivacyOptionType graphQLPrivacyOptionType = GraphQLPrivacyOptionType.CUSTOM;
        if (!(graphQLImage == null || graphQLImage.d() == null)) {
            graphQLPrivacyOptionType = GraphQLPrivacyOptionType.fromIconName(graphQLImage.d());
        }
        return m22957a(graphQLPrivacyOptionType, size);
    }

    public final int m22957a(GraphQLPrivacyOptionType graphQLPrivacyOptionType, Size size) {
        switch (size) {
            case PILL:
                return m22954a(f15323b, graphQLPrivacyOptionType);
            case TOKEN:
                return m22954a(f15324c, graphQLPrivacyOptionType);
            case LIST:
                return m22954a(f15325d, graphQLPrivacyOptionType);
            case COMPOSER_FOOTER:
                return m22954a(f15326e, graphQLPrivacyOptionType);
            case GLYPH:
                return m22954a(f15327f, graphQLPrivacyOptionType);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static int m22954a(Map<GraphQLPrivacyOptionType, Integer> map, GraphQLPrivacyOptionType graphQLPrivacyOptionType) {
        Integer num = (Integer) map.get(graphQLPrivacyOptionType);
        Preconditions.checkState(!f15322a.equals(num));
        if (num == null) {
            num = (Integer) map.get(GraphQLPrivacyOptionType.CUSTOM);
        }
        return num.intValue();
    }
}

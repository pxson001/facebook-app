package com.facebook.entitycardsplugins.person.widget.contextitemlist;

import com.facebook.common.util.StringUtil;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardContextItemModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: heisman_fetch_recent_video_thumbnail_failed */
public class PersonCardContextItemsHelper {
    private static volatile PersonCardContextItemsHelper f11393a;

    public static com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemsHelper m13317a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11393a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemsHelper.class;
        monitor-enter(r1);
        r0 = f11393a;	 Catch:{ all -> 0x0039 }
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
        r0 = m13316a();	 Catch:{ all -> 0x0034 }
        f11393a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11393a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemsHelper.a(com.facebook.inject.InjectorLike):com.facebook.entitycardsplugins.person.widget.contextitemlist.PersonCardContextItemsHelper");
    }

    private static PersonCardContextItemsHelper m13316a() {
        return new PersonCardContextItemsHelper();
    }

    @Nullable
    public final ImmutableList<PersonCardContextItemModel> m13319a(PersonCardModel personCardModel) {
        Preconditions.checkNotNull(personCardModel);
        if (personCardModel.m13185A() == null) {
            return null;
        }
        ImmutableList<PersonCardContextItemModel> a = personCardModel.m13185A().m13155a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            if (m13318a((PersonCardContextItemModel) a.get(i))) {
                i++;
            } else {
                Builder builder = ImmutableList.builder();
                int size2 = a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    PersonCardContextItemModel personCardContextItemModel = (PersonCardContextItemModel) a.get(i2);
                    if (m13318a(personCardContextItemModel)) {
                        builder.c(personCardContextItemModel);
                    }
                }
                return builder.b();
            }
        }
        return a;
    }

    public static boolean m13318a(PersonCardContextItemModel personCardContextItemModel) {
        return (personCardContextItemModel.m13124q() == null || StringUtil.a(personCardContextItemModel.m13124q().a())) ? false : true;
    }
}

package com.facebook.identitygrowth.profilequestion.utils;

import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel.InferencesModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel.EdgesModel;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: mHugePictureSize */
public class ProfileQuestionHelper {
    private static volatile ProfileQuestionHelper f11091a;

    public static com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper m17839a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11091a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper.class;
        monitor-enter(r1);
        r0 = f11091a;	 Catch:{ all -> 0x0039 }
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
        r0 = m17838a();	 Catch:{ all -> 0x0034 }
        f11091a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f11091a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper.a(com.facebook.inject.InjectorLike):com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper");
    }

    private static ProfileQuestionHelper m17838a() {
        return new ProfileQuestionHelper();
    }

    public final boolean m17842a(@Nullable ProfileQuestionsModel profileQuestionsModel) {
        return profileQuestionsModel == null || profileQuestionsModel.m18057b().isEmpty() || profileQuestionsModel.m18057b().get(0) == null || !m17840a(((EdgesModel) profileQuestionsModel.m18057b().get(0)).m18050a());
    }

    public static boolean m17840a(@Nullable ProfileQuestionFragmentModel profileQuestionFragmentModel) {
        return (profileQuestionFragmentModel == null || profileQuestionFragmentModel.dm_() == null || profileQuestionFragmentModel.dl_() == null || profileQuestionFragmentModel.m18037c() == null) ? false : true;
    }

    public static boolean m17841b(@Nullable ProfileQuestionFragmentModel profileQuestionFragmentModel) {
        return profileQuestionFragmentModel == null || profileQuestionFragmentModel.dn_() == null || profileQuestionFragmentModel.dn_().m18005a().isEmpty() || profileQuestionFragmentModel.dn_().m18005a().get(0) == null || ((InferencesModel.EdgesModel) profileQuestionFragmentModel.dn_().m18005a().get(0)).m18000a() == null;
    }
}

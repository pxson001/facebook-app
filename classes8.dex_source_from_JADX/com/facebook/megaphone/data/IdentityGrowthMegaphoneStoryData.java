package com.facebook.megaphone.data;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionOptionListData;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionPrivacySelectorView.PrivacyData;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: type_display_extras */
public class IdentityGrowthMegaphoneStoryData implements IHaveUserData, ProfileQuestionOptionListData, PrivacyData {
    private static volatile IdentityGrowthMegaphoneStoryData f1285k;
    public ProfileQuestionsModel f1286a;
    public boolean f1287b;
    private String f1288c;
    private String f1289d;
    private boolean f1290e;
    @Nullable
    private String f1291f;
    @Nullable
    private String f1292g;
    private GraphQLPrivacyOption f1293h;
    public boolean f1294i;
    public boolean f1295j;

    public static com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData m1517a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1285k;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData.class;
        monitor-enter(r1);
        r0 = f1285k;	 Catch:{ all -> 0x0039 }
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
        r0 = m1518l();	 Catch:{ all -> 0x0034 }
        f1285k = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1285k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData.a(com.facebook.inject.InjectorLike):com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData");
    }

    private static IdentityGrowthMegaphoneStoryData m1518l() {
        return new IdentityGrowthMegaphoneStoryData();
    }

    public final boolean m1523a() {
        return this.f1287b;
    }

    public final void m1521a(@Nullable String str, @Nullable String str2) {
        this.f1288c = str;
        this.f1289d = str2;
    }

    @Nullable
    public final String m1524b() {
        return this.f1288c;
    }

    @Nullable
    public final String m1530i() {
        return this.f1289d;
    }

    public final void m1522a(boolean z) {
        this.f1290e = z;
    }

    public final boolean m1526c() {
        return this.f1290e;
    }

    public final void m1520a(@Nullable String str) {
        this.f1291f = str;
        if (str != null) {
            m1521a(str, "page");
            m1522a(true);
        }
    }

    public final void m1525b(@Nullable String str) {
        this.f1292g = str;
    }

    @Nullable
    public final String m1527d() {
        return this.f1291f;
    }

    @Nullable
    public final String m1528e() {
        return this.f1292g;
    }

    public void clearUserData() {
        this.f1286a = null;
        this.f1287b = false;
        m1521a(null, null);
        m1522a(false);
        m1520a(null);
        m1525b(null);
        m1519a(null);
    }

    public final void m1519a(@Nullable GraphQLPrivacyOption graphQLPrivacyOption) {
        this.f1293h = graphQLPrivacyOption;
    }

    @Nullable
    public final GraphQLPrivacyOption m1529f() {
        return this.f1293h;
    }
}

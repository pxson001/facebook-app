package com.facebook.story;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.StoryExtra;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.abtest.ExperimentsForStoryModule;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: scan_end_time */
public class GraphQLStoryHelper {
    public static final Integer f6084c = Integer.valueOf(100);
    public static final Integer f6085d = Integer.valueOf(3);
    private static volatile GraphQLStoryHelper f6086i;
    public final Integer f6087a = Integer.valueOf(2048);
    public final Integer f6088b = Integer.valueOf(50);
    public final Resources f6089e;
    private final StoryImageSizes f6090f;
    private final GraphQLImageHelper f6091g;
    private final QeAccessor f6092h;

    public static com.facebook.story.GraphQLStoryHelper m10197a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6086i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.story.GraphQLStoryHelper.class;
        monitor-enter(r1);
        r0 = f6086i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10200b(r0);	 Catch:{ all -> 0x0035 }
        f6086i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6086i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.story.GraphQLStoryHelper.a(com.facebook.inject.InjectorLike):com.facebook.story.GraphQLStoryHelper");
    }

    private static GraphQLStoryHelper m10200b(InjectorLike injectorLike) {
        return new GraphQLStoryHelper(ResourcesMethodAutoProvider.m6510a(injectorLike), StoryImageSizesMethodAutoProvider.m10232b(injectorLike), GraphQLImageHelper.m10139a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public GraphQLStoryHelper(Resources resources, StoryImageSizes storyImageSizes, GraphQLImageHelper graphQLImageHelper, QeAccessor qeAccessor) {
        this.f6089e = resources;
        this.f6090f = storyImageSizes;
        this.f6091g = graphQLImageHelper;
        this.f6092h = qeAccessor;
    }

    @Nullable
    public static GraphQLPrivacyScope m10201c(GraphQLStory graphQLStory) {
        StoryExtra bd = graphQLStory.bd();
        if (bd != null) {
            GraphQLPrivacyScope graphQLPrivacyScope = bd.f20928a;
            if (graphQLPrivacyScope != null) {
                return graphQLPrivacyScope;
            }
        }
        return graphQLStory.ao();
    }

    public static boolean m10202d(GraphQLStory graphQLStory) {
        GraphQLPrivacyScope c = m10201c(graphQLStory);
        return c != null && "good_friends".equals(c.m23522s());
    }

    public static boolean m10199a(@Nullable GraphQLStory graphQLStory, @Nullable GraphQLStory graphQLStory2) {
        if (graphQLStory == null || graphQLStory2 == null) {
            return false;
        }
        String g = graphQLStory.mo2507g();
        if (g == null || !g.equals(graphQLStory2.mo2507g())) {
            return false;
        }
        return true;
    }

    public static Integer m10198a() {
        return Integer.valueOf(GraphQlQueryDefaults.m11419b());
    }

    public final Integer m10216c() {
        return m10198a();
    }

    public final Integer m10217g() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131430278));
    }

    public final Integer m10218i() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428867));
    }

    public final Integer m10219j() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428868));
    }

    public final Integer m10220k() {
        return m10198a();
    }

    public final Integer m10221l() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428890));
    }

    public final Integer m10222m() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428892));
    }

    public static Integer m10204o() {
        return Integer.valueOf(GraphQlQueryDefaults.m11421c());
    }

    public static Integer m10205p() {
        return Integer.valueOf(GraphQlQueryDefaults.m11421c());
    }

    public static Integer m10206q() {
        return Integer.valueOf(GraphQlQueryDefaults.m11421c());
    }

    public final Integer m10223r() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428989));
    }

    public final Integer m10224s() {
        return m10198a();
    }

    public final Integer m10225t() {
        return m10198a();
    }

    public final Integer m10226u() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131429027));
    }

    public final Integer m10227v() {
        if (this.f6092h.mo596a(ExperimentsForStoryModule.f6589a, false)) {
            return GraphQLImageHelper.m10140a(GraphQLImageHelper.m10140a(this.f6090f.f6095c).intValue() / 3);
        }
        return GraphQLImageHelper.m10140a(this.f6090f.f6093a);
    }

    public final Integer m10228w() {
        return GraphQLImageHelper.m10140a(GraphQLImageHelper.m10140a(this.f6090f.f6095c).intValue() / 2);
    }

    public final Integer m10229x() {
        return GraphQLImageHelper.m10140a(this.f6090f.f6095c);
    }

    public final Integer m10230y() {
        return GraphQLImageHelper.m10140a(this.f6090f.f6095c);
    }

    public final Integer m10231z() {
        return Integer.valueOf((int) (((float) GraphQLImageHelper.m10140a(this.f6090f.f6095c).intValue()) / 1.9318181f));
    }

    public final Integer m10207A() {
        return m10227v();
    }

    public final Integer m10208B() {
        return m10228w();
    }

    public final Integer m10209C() {
        return m10229x();
    }

    public final Integer m10210H() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428873));
    }

    public final Integer m10211I() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428911));
    }

    public final Integer m10212J() {
        return this.f6091g.m10148f();
    }

    public final Integer m10213L() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428922));
    }

    public final Integer m10214M() {
        return GraphQLImageHelper.m10140a(this.f6089e.getDimensionPixelSize(2131428923));
    }

    public final Integer m10215P() {
        return m10198a();
    }

    public static int m10203e(GraphQLStory graphQLStory) {
        if (!StoryAttachmentHelper.m28037j(graphQLStory)) {
            graphQLStory = graphQLStory.m22326L();
        }
        for (GraphQLStoryAttachment graphQLStoryAttachment : r4.m22367x()) {
            if (GraphQLStoryAttachmentUtil.m28055d(graphQLStoryAttachment) && graphQLStoryAttachment.m23979r() != null && graphQLStoryAttachment.m23979r().m24453j() != null && graphQLStoryAttachment.m23979r().m24453j().m22301g() == 82650203) {
                return graphQLStoryAttachment.m23979r().aJ();
            }
        }
        return 0;
    }
}

package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.res.Resources;
import android.text.style.StyleSpan;
import com.facebook.common.util.SpannableStringFormatter;
import com.facebook.common.util.SpannableStringSubstitution;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: includeVectorData */
public class AttachmentDisplayInfoHelper {
    private static volatile AttachmentDisplayInfoHelper f20232a;

    public static com.facebook.feedplugins.graphqlstory.inlinecomments.AttachmentDisplayInfoHelper m27903a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20232a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.feedplugins.graphqlstory.inlinecomments.AttachmentDisplayInfoHelper.class;
        monitor-enter(r1);
        r0 = f20232a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m27902a();	 Catch:{ all -> 0x0034 }
        f20232a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f20232a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.graphqlstory.inlinecomments.AttachmentDisplayInfoHelper.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.graphqlstory.inlinecomments.AttachmentDisplayInfoHelper");
    }

    private static AttachmentDisplayInfoHelper m27902a() {
        return new AttachmentDisplayInfoHelper();
    }

    public static GraphQLImage m27904a(Resources resources, GraphQLStoryAttachment graphQLStoryAttachment) {
        int dimensionPixelSize = resources.getDimensionPixelSize(2131429108);
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        if (r.m24446Y() != null && r.m24446Y().mo2925c() >= dimensionPixelSize && r.m24446Y().mo2923a() >= dimensionPixelSize) {
            return r.m24446Y();
        }
        if (r.m24447Z() != null && r.m24447Z().mo2925c() >= dimensionPixelSize && r.m24447Z().mo2923a() >= dimensionPixelSize) {
            return r.m24447Z();
        }
        if (r.m24441T() == null || r.m24441T().mo2925c() < dimensionPixelSize || r.m24441T().mo2923a() < dimensionPixelSize) {
            return r.m24440S();
        }
        return r.m24441T();
    }

    @Nullable
    public static CharSequence m27905a(GraphQLComment graphQLComment, int i, Resources resources) {
        if (GraphQLCommentHelper.m29313i(graphQLComment)) {
            return null;
        }
        Object aa = graphQLComment.m27185r() == null ? "" : graphQLComment.m27185r().aa();
        return SpannableStringFormatter.a(resources, i, new SpannableStringSubstitution[]{new SpannableStringSubstitution(aa, new StyleSpan(1), 33)});
    }
}

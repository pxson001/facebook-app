package com.facebook.leadgen;

import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLLeadGenContextPage;
import com.facebook.graphql.model.GraphQLLeadGenData;
import com.facebook.graphql.model.GraphQLLeadGenLegalContent;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLLeadGenPrivacyNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_payment_eligible_contacts */
public class LeadGenUtil {
    private static volatile LeadGenUtil f23984a;

    public static com.facebook.leadgen.LeadGenUtil m32381a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23984a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.leadgen.LeadGenUtil.class;
        monitor-enter(r1);
        r0 = f23984a;	 Catch:{ all -> 0x0039 }
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
        r0 = m32380a();	 Catch:{ all -> 0x0034 }
        f23984a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f23984a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.leadgen.LeadGenUtil.a(com.facebook.inject.InjectorLike):com.facebook.leadgen.LeadGenUtil");
    }

    private static LeadGenUtil m32380a() {
        return new LeadGenUtil();
    }

    @Nullable
    public static GraphQLStoryActionLink m32379a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        return ActionLinkHelper.m22936a(graphQLStoryAttachment, 1185006756);
    }

    public static boolean m32383a(GraphQLLeadGenPage graphQLLeadGenPage) {
        boolean z;
        boolean z2 = graphQLLeadGenPage.a() == null || graphQLLeadGenPage.a().isEmpty();
        if (graphQLLeadGenPage.j() != null) {
            ImmutableList j = graphQLLeadGenPage.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (((GraphQLLeadGenPrivacyNode) j.get(i)).j() == GraphQLLeadGenPrivacyType.PRIVACY_WITH_PHONE) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z2 && r0) {
            return true;
        }
        return false;
    }

    public static String m32382a(GraphQLStoryActionLink graphQLStoryActionLink) {
        return graphQLStoryActionLink.m22886M().m23417p();
    }

    public static int m32378a(String str, ImmutableList<String> immutableList) {
        if (!(StringUtil.m3589a((CharSequence) str) || immutableList == null)) {
            for (int i = 0; i < immutableList.size(); i++) {
                if (str.equals(immutableList.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean m32387g(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLLeadGenLegalContent h = m32388h(graphQLStoryAttachment);
        if (h == null || h.k().isEmpty() || h.l() == null || h.l().isEmpty()) {
            return false;
        }
        return true;
    }

    public static GraphQLLeadGenLegalContent m32388h(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryActionLink a = m32379a(graphQLStoryAttachment);
        if (a == null) {
            return null;
        }
        return a.m22886M().m23413l();
    }

    public static boolean m32384a(GraphQLStoryAttachment graphQLStoryAttachment, int i, int i2) {
        if (m32387g(graphQLStoryAttachment) && i == i2 - 1) {
            return true;
        }
        return false;
    }

    public static boolean m32385b(GraphQLLeadGenPage graphQLLeadGenPage) {
        if (graphQLLeadGenPage == null) {
            return false;
        }
        ImmutableList j = graphQLLeadGenPage.j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            if (((GraphQLLeadGenPrivacyNode) j.get(i)).j() == GraphQLLeadGenPrivacyType.DISCLAIMER_PAGE_TITLE) {
                return true;
            }
        }
        return false;
    }

    public static boolean m32386c(GraphQLStoryActionLink graphQLStoryActionLink) {
        GraphQLLeadGenData M = graphQLStoryActionLink.m22886M();
        if (M == null) {
            return false;
        }
        return M.m23414m();
    }

    public static GraphQLLeadGenContextPage m32389s(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.m22936a(graphQLStoryAttachment, 1185006756);
        if (a != null) {
            return a.m22886M().m23408a();
        }
        return null;
    }

    public static int m32390v(GraphQLStoryAttachment graphQLStoryAttachment) {
        int i = 0;
        ImmutableList n = m32379a(graphQLStoryAttachment).m22886M().m23415n();
        if (n != null) {
            int size = n.size();
            int i2 = 0;
            while (i2 < size) {
                int i3;
                if (m32385b((GraphQLLeadGenPage) n.get(i2))) {
                    i3 = i;
                } else {
                    i3 = i + 1;
                }
                i2++;
                i = i3;
            }
        }
        return i;
    }

    public static int m32377a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        if (c == null) {
            return -1;
        }
        List i = StoryAttachmentHelper.m28036i(c);
        if (i == null || i.isEmpty()) {
            return -1;
        }
        for (int i2 = 0; i2 < i.size(); i2++) {
            if (i.get(i2) == feedProps.f13444a) {
                return i2 + 1;
            }
        }
        return -1;
    }
}

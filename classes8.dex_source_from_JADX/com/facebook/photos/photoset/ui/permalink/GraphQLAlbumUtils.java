package com.facebook.photos.photoset.ui.permalink;

import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAlbum;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: close_button */
public class GraphQLAlbumUtils {
    private static volatile GraphQLAlbumUtils f17824a;

    public static com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils m21791a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17824a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils.class;
        monitor-enter(r1);
        r0 = f17824a;	 Catch:{ all -> 0x0039 }
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
        r0 = m21790a();	 Catch:{ all -> 0x0034 }
        f17824a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17824a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils.a(com.facebook.inject.InjectorLike):com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils");
    }

    private static GraphQLAlbumUtils m21790a() {
        return new GraphQLAlbumUtils();
    }

    public static boolean m21792a(GraphQLAlbum graphQLAlbum, String str) {
        Preconditions.checkNotNull(graphQLAlbum);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        if (!(graphQLAlbum.q() == null || graphQLAlbum.q().isEmpty())) {
            ImmutableList q = graphQLAlbum.q();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(((GraphQLActor) q.get(i)).H())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m21793b(GraphQLAlbum graphQLAlbum, String str) {
        boolean z;
        Preconditions.checkNotNull(graphQLAlbum);
        if (Strings.isNullOrEmpty(str)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (graphQLAlbum.B() == null || graphQLAlbum.B().H() == null || !graphQLAlbum.B().H().equals(str)) {
            return false;
        }
        return true;
    }
}

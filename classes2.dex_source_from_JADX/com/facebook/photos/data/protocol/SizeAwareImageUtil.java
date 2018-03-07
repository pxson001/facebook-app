package com.facebook.photos.data.protocol;

import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.graphql.util.GraphQLImageHelper.SIZING_STYLE;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: saw_recent_activity */
public class SizeAwareImageUtil {
    private static volatile SizeAwareImageUtil f6096c;
    private final GraphQLStoryHelper f6097a;
    private final GraphQLImageHelper f6098b;

    public static com.facebook.photos.data.protocol.SizeAwareImageUtil m10234a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6096c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.data.protocol.SizeAwareImageUtil.class;
        monitor-enter(r1);
        r0 = f6096c;	 Catch:{ all -> 0x003a }
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
        r0 = m10236b(r0);	 Catch:{ all -> 0x0035 }
        f6096c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6096c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.SizeAwareImageUtil.a(com.facebook.inject.InjectorLike):com.facebook.photos.data.protocol.SizeAwareImageUtil");
    }

    private static SizeAwareImageUtil m10236b(InjectorLike injectorLike) {
        return new SizeAwareImageUtil(GraphQLStoryHelper.m10197a(injectorLike), GraphQLImageHelper.m10139a(injectorLike));
    }

    @Inject
    public SizeAwareImageUtil(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper) {
        this.f6097a = graphQLStoryHelper;
        this.f6098b = graphQLImageHelper;
    }

    public final GraphQlQueryString m10237a(GraphQlQueryString graphQlQueryString) {
        return m10235b(graphQlQueryString, null);
    }

    public final GraphQlQueryString m10239b(GraphQlQueryString graphQlQueryString) {
        return m10235b(graphQlQueryString, null);
    }

    public final GraphQlQueryString m10238a(GraphQlQueryString graphQlQueryString, @Nullable MediaTypeInputMimeType mediaTypeInputMimeType) {
        return m10235b(graphQlQueryString, mediaTypeInputMimeType);
    }

    private GraphQlQueryString m10235b(GraphQlQueryString graphQlQueryString, @Nullable MediaTypeInputMimeType mediaTypeInputMimeType) {
        Enum a;
        String str = "media_type";
        if (mediaTypeInputMimeType == null) {
            a = this.f6098b.m10143a();
        }
        graphQlQueryString.m11313a(str, a);
        graphQlQueryString.m11313a("profile_pic_media_type", this.f6098b.m10145b());
        graphQlQueryString.m11315a("size_style", SIZING_STYLE.CONTAIN_FIT.styleString());
        graphQlQueryString.m11314a("image_high_width", this.f6097a.m10229x());
        graphQlQueryString.m11314a("image_high_height", this.f6097a.f6087a);
        graphQlQueryString.m11314a("image_medium_width", this.f6097a.m10228w());
        graphQlQueryString.m11314a("image_medium_height", this.f6097a.f6087a);
        graphQlQueryString.m11314a("image_low_width", this.f6097a.m10227v());
        graphQlQueryString.m11314a("image_low_height", this.f6097a.f6087a);
        return graphQlQueryString;
    }
}

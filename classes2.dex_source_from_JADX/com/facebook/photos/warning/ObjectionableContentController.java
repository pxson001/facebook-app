package com.facebook.photos.warning;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.yearclass.YearClass;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.photos.warning.ObjectionableContentView.State;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomViewUtils;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: info_banner_impression_cap */
public class ObjectionableContentController {
    private static volatile ObjectionableContentController f20144j;
    private final ObjectionableContentLoggerHelper f20145a;
    private final FbDraweeControllerBuilder f20146b;
    public final FbDataConnectionManager f20147c;
    public final SecureContextHelper f20148d;
    private final GatekeeperStoreImpl f20149e;
    public final UriIntentMapper f20150f;
    public final QeAccessor f20151g;
    private final Set<String> f20152h = new HashSet();
    private DarkenAndBlurPostprocessor f20153i;

    public static com.facebook.photos.warning.ObjectionableContentController m27812a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20144j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.warning.ObjectionableContentController.class;
        monitor-enter(r1);
        r0 = f20144j;	 Catch:{ all -> 0x003a }
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
        r0 = m27814b(r0);	 Catch:{ all -> 0x0035 }
        f20144j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20144j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.warning.ObjectionableContentController.a(com.facebook.inject.InjectorLike):com.facebook.photos.warning.ObjectionableContentController");
    }

    private static ObjectionableContentController m27814b(InjectorLike injectorLike) {
        return new ObjectionableContentController(new ObjectionableContentLoggerHelper(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike)), FbDraweeControllerBuilder.m19410b(injectorLike), FbDataConnectionManager.m3787a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), Fb4aUriIntentMapper.m8640a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public ObjectionableContentController(ObjectionableContentLoggerHelper objectionableContentLoggerHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, FbDataConnectionManager fbDataConnectionManager, SecureContextHelper secureContextHelper, GatekeeperStoreImpl gatekeeperStoreImpl, UriIntentMapper uriIntentMapper, QeAccessor qeAccessor) {
        this.f20145a = objectionableContentLoggerHelper;
        this.f20146b = fbDraweeControllerBuilder;
        this.f20147c = fbDataConnectionManager;
        this.f20148d = secureContextHelper;
        this.f20149e = gatekeeperStoreImpl;
        this.f20150f = uriIntentMapper;
        this.f20151g = qeAccessor;
    }

    public static boolean m27815b(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.m28048a((GraphQLStoryAttachment) feedProps.f13444a, 970097864);
        return a != null && a.m27601B();
    }

    public final boolean m27823a(GraphQLMedia graphQLMedia) {
        return m27821a() && m27816b(graphQLMedia) && !m27826c(graphQLMedia.m24452b());
    }

    public static boolean m27816b(GraphQLMedia graphQLMedia) {
        return graphQLMedia != null && graphQLMedia.ba();
    }

    public final boolean m27822a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        return m27821a() && m27815b((FeedProps) feedProps) && c != null && !m27826c(c.m22350c());
    }

    public final boolean m27821a() {
        return this.f20149e.m2189a(394, false);
    }

    public final Postprocessor m27824b() {
        if (this.f20153i == null) {
            this.f20153i = new DarkenAndBlurPostprocessor(30, 8);
        }
        return this.f20153i;
    }

    public final void m27820a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f20152h.add(str);
            this.f20145a.m27827a("warning_screen_dismissed", str);
        }
    }

    public final void m27825b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f20152h.remove(str);
            this.f20145a.m27827a("warning_screen_reenabled", str);
        }
    }

    public final boolean m27826c(String str) {
        return !TextUtils.isEmpty(str) && this.f20152h.contains(str);
    }

    public final SpannableString m27817a(Context context) {
        Resources resources = context.getResources();
        CharSequence string = resources.getString(2131238514);
        return new StyledStringBuilder(context.getResources()).a(string).a("link_change_content_filter", resources.getString(2131238515), new 1(this, context), 33).b();
    }

    public final void m27819a(ObjectionableContentView objectionableContentView, State state) {
        Object obj;
        DraweeView draweeView = objectionableContentView.b;
        View view = objectionableContentView.c;
        Context context = objectionableContentView.getContext();
        boolean z = false;
        ConnectionQuality c = this.f20147c.m3801c();
        if (this.f20151g.mo596a(ExperimentsForNewsFeedAbTestModule.f5095V, false) && (c == ConnectionQuality.MODERATE || c == ConnectionQuality.POOR)) {
            z = true;
        }
        if (!z) {
            z = false;
            if (this.f20151g.mo596a(ExperimentsForNewsFeedAbTestModule.f5094U, false) && YearClass.m30095a(context) <= 2011) {
                z = true;
            }
            if (!z) {
                obj = null;
                if (obj == null) {
                    CustomViewUtils.m30286b(view, new ColorDrawable(ContextCompat.m7855b(context, state.b)));
                    draweeView.setVisibility(8);
                    view.setVisibility(0);
                }
                draweeView.setController(state.a);
                draweeView.setVisibility(0);
                view.setVisibility(8);
                return;
            }
        }
        obj = 1;
        if (obj == null) {
            draweeView.setController(state.a);
            draweeView.setVisibility(0);
            view.setVisibility(8);
            return;
        }
        CustomViewUtils.m30286b(view, new ColorDrawable(ContextCompat.m7855b(context, state.b)));
        draweeView.setVisibility(8);
        view.setVisibility(0);
    }

    public static void m27813a(ObjectionableContentView objectionableContentView) {
        DraweeView draweeView = objectionableContentView.b;
        draweeView.setController(null);
        draweeView.setVisibility(0);
        objectionableContentView.a.a();
        View view = objectionableContentView.c;
        CustomViewUtils.m30286b(view, null);
        view.setVisibility(8);
    }

    public final <E extends HasPrefetcher & HasImageLoadListener> State m27818a(FeedProps<GraphQLStoryAttachment> feedProps, Uri uri, E e, CallerContext callerContext) {
        ImageRequestBuilder a = ImageRequestBuilder.m18776a(uri);
        a.f12726j = m27824b();
        Object m = a.m18785m();
        e.mo2434a(m, callerContext);
        AbstractDraweeControllerBuilder r = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f20146b.m19417a(callerContext).m19441a(true)).m19452c(m)).m19434r();
        r.f13208g = false;
        r = r;
        r.f13224n = false;
        FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) r.mo2600o()).m19456d(null);
        fbDraweeControllerBuilder.f13209h = null;
        DraweeController s = fbDraweeControllerBuilder.m19435s();
        ((HasImageLoadListener) e).mo2426a(s, AttachmentProps.m28712a((FeedProps) feedProps).mo2507g(), m);
        return new State(s, 2131361953);
    }
}

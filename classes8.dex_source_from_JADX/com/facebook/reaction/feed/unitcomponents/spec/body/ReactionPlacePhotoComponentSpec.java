package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.InlineLayoutSpec;
import com.facebook.components.InternalNode;
import com.facebook.components.Layout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.fb.widget.FbFacepileComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.components.widget.Image;
import com.facebook.components.widget.Text;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _id=? */
public class ReactionPlacePhotoComponentSpec {
    public static final CallerContext f20374a = CallerContext.a(ReactionPlacePhotoComponent.class);
    public static final Component f20375b = new C21651();
    private static volatile ReactionPlacePhotoComponentSpec f20376e;
    private final FbFacepileComponent f20377c;
    public final FbDraweeControllerBuilder f20378d;

    /* compiled from: _id=? */
    final class C21651 extends InlineLayoutSpec {
        C21651() {
        }

        protected final InternalNode m24182a(ComponentContext componentContext) {
            return Container.a(componentContext).H(0).j();
        }
    }

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponentSpec m24185a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20376e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponentSpec.class;
        monitor-enter(r1);
        r0 = f20376e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m24186b(r0);	 Catch:{ all -> 0x0035 }
        f20376e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20376e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlacePhotoComponentSpec");
    }

    private static ReactionPlacePhotoComponentSpec m24186b(InjectorLike injectorLike) {
        return new ReactionPlacePhotoComponentSpec(FbDraweeControllerBuilder.b(injectorLike), FbFacepileComponent.a(injectorLike));
    }

    @Inject
    public ReactionPlacePhotoComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder, FbFacepileComponent fbFacepileComponent) {
        this.f20378d = fbDraweeControllerBuilder;
        this.f20377c = fbFacepileComponent;
    }

    protected final ComponentLayout m24187a(ComponentContext componentContext, List<Uri> list, String str, String str2, Uri uri, int i, Uri uri2) {
        return Container.a(componentContext).a(m24183a(componentContext, uri).c().b(1).e(0).g(0).i(0).d(0)).a(Image.a(componentContext).h(2130842899).c().b(1).e(0).g(0).i(0).d(0)).a(Container.a(componentContext).b(1.0f).n(8, 2131431413).D(3).E(4).a(this.f20377c.a(componentContext).a(f20374a).a(list).h(2131431383).i(2131431384).j(2131492930).c().p(2131431381)).a(m24184a(componentContext, str, str2, i, uri2))).j();
    }

    private ContainerBuilder m24184a(ComponentContext componentContext, String str, String str2, int i, Uri uri) {
        ContainerBuilder E = Container.a(componentContext).C(2).E(2);
        Component d = uri != null ? FbFrescoComponent.a(componentContext).a(this.f20378d.b(uri).a(f20374a).s()).d() : i != Integer.MIN_VALUE ? Image.a(componentContext).h(i).d() : f20375b;
        return E.a(Layout.a(componentContext, d).m(20).q(20).c(2, 2131431415)).a(Container.a(componentContext).C(0).b(1.0f).a(Text.a(componentContext).l(2131361978).r(1).o(2131427402).a(str).c().a(1.0f)).a(Text.a(componentContext).l(2131361978).r(2).o(2131427400).a(str2).c().a(1.0f)));
    }

    private Builder m24183a(ComponentContext componentContext, Uri uri) {
        if (uri != null) {
            return FbFrescoComponent.a(componentContext).a(ColorDrawableReference.a(componentContext).i(2131361970).b()).a(this.f20378d.b(uri).a(f20374a).s());
        }
        Image.Builder a = Image.a(componentContext);
        a.a.a = a.d(0, 0);
        return a;
    }
}

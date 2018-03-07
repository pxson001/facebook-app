package com.facebook.components.fb.widget;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.ComponentLayout.Builder;
import com.facebook.components.ComponentLayout.ContainerBuilder;
import com.facebook.components.Container;
import com.facebook.components.Output;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.inject.InjectorLike;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: creative_tools */
public class FbFacepileComponentSpec {
    protected static final List<Uri> f16613a = Collections.emptyList();
    private static volatile FbFacepileComponentSpec f16614d;
    private final FbFacepileCountComponent f16615b;
    private final FbDraweeControllerBuilder f16616c;

    public static com.facebook.components.fb.widget.FbFacepileComponentSpec m20670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16614d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.components.fb.widget.FbFacepileComponentSpec.class;
        monitor-enter(r1);
        r0 = f16614d;	 Catch:{ all -> 0x003a }
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
        r0 = m20672b(r0);	 Catch:{ all -> 0x0035 }
        f16614d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16614d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.fb.widget.FbFacepileComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.components.fb.widget.FbFacepileComponentSpec");
    }

    private static FbFacepileComponentSpec m20672b(InjectorLike injectorLike) {
        return new FbFacepileComponentSpec(FbFacepileCountComponent.m20678a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    @Inject
    public FbFacepileComponentSpec(FbFacepileCountComponent fbFacepileCountComponent, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f16615b = fbFacepileCountComponent;
        this.f16616c = fbDraweeControllerBuilder;
    }

    protected static void m20671a(ComponentContext componentContext, Output<Integer> output, Output<Integer> output2, Output<Integer> output3, Output<Integer> output4, Output<Boolean> output5, Output<Integer> output6) {
        TypedArray a = componentContext.a(R.styleable.FbFacepileComponent, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = a.getIndex(i);
            if (index == 0) {
                output.a = Integer.valueOf(a.getDimensionPixelSize(index, 0));
            } else if (index == 1) {
                output2.a = Integer.valueOf(a.getColor(index, 0));
            } else if (index == 2) {
                output3.a = Integer.valueOf(a.getDimensionPixelSize(index, 0));
            } else if (index == 3) {
                output4.a = Integer.valueOf(a.getDimensionPixelSize(index, 0));
            } else if (index == 4) {
                output5.a = Boolean.valueOf(a.getBoolean(index, false));
            } else if (index == 5) {
                output6.a = Integer.valueOf(a.getInteger(index, 0));
            }
        }
        a.recycle();
    }

    protected final ComponentLayout m20673a(ComponentContext componentContext, CallerContext callerContext, int i, int i2, int i3, int i4, boolean z, List<Uri> list, int i5) {
        Resources resources = componentContext.getResources();
        if (i == Integer.MIN_VALUE) {
            i = resources.getDimensionPixelSize(2131431074);
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = resources.getColor(2131363329);
        }
        if (i3 == Integer.MIN_VALUE) {
            i3 = resources.getDimensionPixelSize(2131431076);
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = resources.getDimensionPixelOffset(2131431075);
        }
        if (i5 == Integer.MIN_VALUE) {
            i5 = resources.getInteger(2131492919);
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("faceCount cannot be < 0");
        }
        int size = list.size();
        Object obj = (!z || size <= i5) ? null : 1;
        int min = Math.min(size, i5) - (obj != null ? 1 : 0);
        RoundingParams a = RoundingParams.e().a(i2, (float) i3);
        ContainerBuilder C = Container.a(componentContext).C(2);
        for (int i6 = 0; i6 < min; i6++) {
            Builder j = FbFrescoComponent.a(componentContext).a(ColorDrawableReference.a(componentContext).h(0).b()).a(this.f16616c.b((Uri) list.get(i6)).a(callerContext).s()).a(a).c().n(i).j(i);
            if (i6 > 0 && i4 != 0) {
                j.a(6, i4);
            }
            C.a(j);
        }
        if (obj != null) {
            j = this.f16615b.m20680a(componentContext).m20677h(size - min).c().n(i).j(i);
            if (i4 != 0) {
                j.a(6, i4);
            }
            C.a(j);
        }
        return C.j();
    }
}

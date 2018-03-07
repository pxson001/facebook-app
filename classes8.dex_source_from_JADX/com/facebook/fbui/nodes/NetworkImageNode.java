package com.facebook.fbui.nodes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.util.Pools.SimplePool;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.drawee.view.AspectRatioMeasure.Spec;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.nodes.AttachDetachListener;
import com.facebook.nodes.BaseThreadingModel;
import com.facebook.nodes.Node;
import com.facebook.nodes.canvas.CanvasOperation;
import com.facebook.nodes.canvas.DeferredModeCanvasProxy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: has_shown_tag_place_tip_or_suggestion */
public final class NetworkImageNode extends Node implements InjectableComponentWithoutContext {
    private static final Spec f11597b = new Spec();
    public static final SimplePool<DraweeController> f11598e = new SimplePool(16);
    private static final CallerContext f11599f = CallerContext.a(NetworkImageNode.class, "unknown", "network_image_node");
    @Inject
    public Provider<FbDraweeControllerBuilder> f11600a = null;
    private State f11601g;
    private float f11602h;

    /* compiled from: has_shown_tag_place_tip_or_suggestion */
    final class State implements AttachDetachListener, CanvasOperation {
        private final FbDraweeControllerBuilder f11587a;
        private final GenericDraweeHierarchyBuilder f11588b;
        private Uri f11589c;
        private CallerContext f11590d;
        private DraweeController f11591e;
        private int f11592f;
        private int f11593g;
        private int f11594h;
        private int f11595i;
        private View f11596j;

        public State(FbDraweeControllerBuilder fbDraweeControllerBuilder, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
            this.f11587a = fbDraweeControllerBuilder;
            this.f11588b = genericDraweeHierarchyBuilder;
        }

        public final void m13495a(ScaleType scaleType) {
            if (this.f11588b.n != scaleType) {
                this.f11588b.e(scaleType);
                if (this.f11591e != null) {
                    ((GenericDraweeHierarchy) this.f11591e.d()).a(scaleType);
                }
            }
        }

        public final void m13493a(Uri uri, CallerContext callerContext) {
            if (uri == null) {
                m13490c();
                this.f11589c = null;
            } else if (!uri.equals(this.f11589c) || !callerContext.equals(this.f11590d)) {
                this.f11589c = uri;
                this.f11590d = callerContext;
                if (this.f11596j != null) {
                    m13488a(true);
                }
            }
        }

        private void m13489b() {
            this.f11587a.b(this.f11589c);
            this.f11587a.a(this.f11590d);
            this.f11587a.b(this.f11591e);
            GenericDraweeHierarchy a = m13485a(this.f11591e);
            this.f11591e = this.f11587a.s();
            this.f11591e.a(a);
        }

        private GenericDraweeHierarchy m13485a(DraweeController draweeController) {
            GenericDraweeHierarchy genericDraweeHierarchy;
            if (draweeController != null) {
                genericDraweeHierarchy = (GenericDraweeHierarchy) draweeController.d();
                draweeController.a(null);
            } else {
                genericDraweeHierarchy = null;
            }
            if (genericDraweeHierarchy == null) {
                return this.f11588b.u();
            }
            return genericDraweeHierarchy;
        }

        public final void m13492a(Canvas canvas) {
            if (this.f11591e != null) {
                this.f11591e.d().a().draw(canvas);
            }
        }

        public final void m13494a(View view) {
            this.f11596j = view;
            m13488a(false);
        }

        public final void m13491a() {
            this.f11596j = null;
            m13490c();
        }

        private void m13488a(boolean z) {
            if (this.f11589c != null) {
                if (this.f11591e == null) {
                    this.f11591e = (DraweeController) NetworkImageNode.f11598e.a();
                    z = true;
                }
                if (z) {
                    m13489b();
                }
                this.f11591e.e();
                Drawable a = this.f11591e.d().a();
                a.setBounds(this.f11592f, this.f11593g, this.f11594h, this.f11595i);
                a.setCallback(this.f11596j);
            }
        }

        private void m13490c() {
            if (this.f11589c != null && this.f11591e != null) {
                this.f11591e.f();
                this.f11591e.d().a().setCallback(null);
                if (this.f11589c != Uri.EMPTY) {
                    NetworkImageNode.f11598e.a(this.f11591e);
                    this.f11591e = null;
                }
            }
        }

        private void m13486a(int i, int i2, int i3, int i4) {
            this.f11592f = i;
            this.f11593g = i2;
            this.f11594h = i3;
            this.f11595i = i4;
            if (this.f11591e != null) {
                this.f11591e.d().a().setBounds(i, i2, i3, i4);
            }
        }
    }

    private static <T extends InjectableComponentWithoutContext> void m13497a(Class<T> cls, T t, Context context) {
        m13498a((Object) t, context);
    }

    public static void m13498a(Object obj, Context context) {
        ((NetworkImageNode) obj).f11600a = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    private void m13499a(Provider<FbDraweeControllerBuilder> provider) {
        this.f11600a = provider;
    }

    public final void m13504a(BaseThreadingModel baseThreadingModel) {
        BaseThreadingModel baseThreadingModel2 = this.q;
        if (baseThreadingModel2 != null) {
            baseThreadingModel2.b(this.f11601g);
        }
        if (baseThreadingModel != null) {
            baseThreadingModel.a(this.f11601g);
        }
        super.a(baseThreadingModel);
    }

    public NetworkImageNode(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Class cls = NetworkImageNode.class;
        m13498a((Object) this, context);
        GenericDraweeHierarchyBuilder a = GenericDraweeHierarchyInflater.a(context, attributeSet);
        this.f11602h = a.e;
        this.f11601g = new State((FbDraweeControllerBuilder) this.f11600a.get(), a);
    }

    public final void m13502a(Uri uri, CallerContext callerContext) {
        this.f11601g.m13493a(uri, callerContext);
    }

    public final void m13503a(ScaleType scaleType) {
        this.f11601g.m13495a(scaleType);
    }

    protected final void m13505a(DeferredModeCanvasProxy deferredModeCanvasProxy) {
        deferredModeCanvasProxy.a(this.f11601g);
    }

    protected final void m13500a(int i, int i2) {
        f11597b.a = i;
        f11597b.b = i2;
        AspectRatioMeasure.a(f11597b, this.f11602h, this.f, this.l + this.m, this.n + this.o);
        super.a(f11597b.a, f11597b.b);
    }

    protected final void m13501a(int i, int i2, int i3, int i4) {
        this.f11601g.m13486a(this.l + i, this.n + i2, i3 - this.m, i4 - this.o);
    }
}

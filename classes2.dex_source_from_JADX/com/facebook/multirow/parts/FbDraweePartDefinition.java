package com.facebook.multirow.parts;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: infinite_hscroll_fetch */
public class FbDraweePartDefinition<E extends HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, DraweeController, E, FbDraweeView> {
    private static FbDraweePartDefinition f20166b;
    private static final Object f20167c = new Object();
    private final FbDraweeControllerBuilder f20168a;

    /* compiled from: infinite_hscroll_fetch */
    public class Props {
        public final ImageRequest f21897a;
        public final float f21898b;
        public final CallerContext f21899c;
        public final int f21900d;
        public final int f21901e;
        public final boolean f21902f;
        public final PointF f21903g;
        public final ScalingUtils$ScaleType f21904h;

        /* compiled from: infinite_hscroll_fetch */
        public class Builder {
            private ImageRequest f21887a;
            public float f21888b;
            public CallerContext f21889c;
            private int f21890d;
            private int f21891e;
            public boolean f21892f;
            public PointF f21893g;
            public ScalingUtils$ScaleType f21894h;

            public final Builder m29720a(String str) {
                return m29719a(Uri.parse(str));
            }

            public final Builder m29719a(Uri uri) {
                this.f21887a = ImageRequest.m18795a(uri);
                return this;
            }

            public final Builder m29718a(int i, int i2) {
                this.f21890d = i2;
                this.f21891e = i;
                return this;
            }

            public final Props m29721a() {
                boolean z;
                if (this.f21889c != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "You must set a CallerContext");
                return new Props(this.f21887a, this.f21888b, this.f21889c, this.f21890d, this.f21891e, this.f21892f, this.f21893g, this.f21894h);
            }
        }

        private Props(ImageRequest imageRequest, float f, CallerContext callerContext, int i, int i2, boolean z, PointF pointF, ScalingUtils$ScaleType scalingUtils$ScaleType) {
            this.f21897a = imageRequest;
            this.f21898b = f;
            this.f21899c = callerContext;
            this.f21900d = i;
            this.f21901e = i2;
            this.f21902f = z;
            this.f21903g = pointF;
            this.f21904h = scalingUtils$ScaleType;
        }
    }

    private static FbDraweePartDefinition m27840b(InjectorLike injectorLike) {
        return new FbDraweePartDefinition(FbDraweeControllerBuilder.m19410b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        if (props.f21902f && ((HasRowKey) hasPrefetcher).mo2461o() && props.f21897a != null) {
            hasPrefetcher.mo2434a(props.f21897a, props.f21899c);
        }
        if (props.f21897a == null) {
            return null;
        }
        return ((FbDraweeControllerBuilder) this.f20168a.m19417a(props.f21899c).m19452c(props.f21897a)).m19435s();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1144471064);
        Props props = (Props) obj;
        DraweeController draweeController = (DraweeController) obj2;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        if (props.f21898b != 0.0f) {
            fbDraweeView.setAspectRatio(props.f21898b);
        }
        if (props.f21903g != null) {
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).m20602a(ScalingUtils$ScaleType.f14221h);
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).m20597a(props.f21903g);
        } else if (props.f21904h != null) {
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).m20602a(props.f21904h);
        }
        if (!(props.f21900d == 0 || props.f21901e == 0)) {
            LayoutParams layoutParams = fbDraweeView.getLayoutParams();
            if (layoutParams == null) {
                fbDraweeView.setLayoutParams(new LayoutParams(props.f21901e, props.f21900d));
            } else {
                layoutParams.height = props.f21900d;
                layoutParams.width = props.f21901e;
            }
        }
        if (draweeController != null) {
            fbDraweeView.setController(draweeController);
        }
        Logger.a(8, EntryType.MARK_POP, -1811330229, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FbDraweeView) view).setController(null);
    }

    public static FbDraweePartDefinition m27839a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbDraweePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20167c) {
                FbDraweePartDefinition fbDraweePartDefinition;
                if (a2 != null) {
                    fbDraweePartDefinition = (FbDraweePartDefinition) a2.mo818a(f20167c);
                } else {
                    fbDraweePartDefinition = f20166b;
                }
                if (fbDraweePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27840b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20167c, b3);
                        } else {
                            f20166b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = fbDraweePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static Builder m27838a() {
        return new Builder();
    }

    @Inject
    public FbDraweePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f20168a = fbDraweeControllerBuilder;
    }
}

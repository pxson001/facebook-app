package com.facebook.feedplugins.images;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.fb.fresco.FbFrescoComponent;
import com.facebook.components.fb.fresco.FbFrescoComponent.Builder;
import com.facebook.components.reference.Reference;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: image_large_aspect_width */
public class FbFeedFrescoComponentSpec<E extends HasFeedListType & HasPersistentState & HasPrefetcher & HasRowKey> {
    private static final String f20420c = FbFeedFrescoComponentSpec.class.getSimpleName();
    private static FbFeedFrescoComponentSpec f20421d;
    private static final Object f20422e = new Object();
    private final FbDraweeControllerBuilder f20423a;
    private final AndroidComponentsExperimentHelper f20424b;

    /* compiled from: image_large_aspect_width */
    public class DraweeControllerPersistentStateKey implements ContextStateKey<String, FbPipelineDraweeController> {
        final /* synthetic */ FbFeedFrescoComponentSpec f22864a;
        private final CallerContext f22865b;
        private final Uri f22866c;
        private final String f22867d;

        public DraweeControllerPersistentStateKey(FbFeedFrescoComponentSpec fbFeedFrescoComponentSpec, CallerContext callerContext, Uri uri, String str, FeedProps<? extends CacheableEntity> feedProps, FeedListName feedListName) {
            String str2;
            this.f22864a = fbFeedFrescoComponentSpec;
            this.f22865b = callerContext;
            this.f22866c = uri;
            String str3 = ((CacheableEntity) feedProps.f13444a).mo2507g() + str;
            Flattenable b = feedProps.m19806b();
            if (b instanceof CacheableEntity) {
                str2 = str3 + ((CacheableEntity) b).mo2507g();
            } else {
                str2 = str3;
            }
            if (this.f22866c != null) {
                str2 = str2 + this.f22866c;
            }
            this.f22867d = str2 + feedListName;
        }

        public final Object mo2130a() {
            return FbFeedFrescoComponentSpec.m28165a(this.f22864a, this.f22866c, this.f22865b);
        }

        public final Object mo2131b() {
            return this.f22867d;
        }
    }

    private static FbFeedFrescoComponentSpec m28167b(InjectorLike injectorLike) {
        return new FbFeedFrescoComponentSpec(FbDraweeControllerBuilder.m19410b(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike));
    }

    public static FbFeedFrescoComponentSpec m28166a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbFeedFrescoComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20422e) {
                FbFeedFrescoComponentSpec fbFeedFrescoComponentSpec;
                if (a2 != null) {
                    fbFeedFrescoComponentSpec = (FbFeedFrescoComponentSpec) a2.mo818a(f20422e);
                } else {
                    fbFeedFrescoComponentSpec = f20421d;
                }
                if (fbFeedFrescoComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28167b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20422e, b3);
                        } else {
                            f20421d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = fbFeedFrescoComponentSpec;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FbFeedFrescoComponentSpec(FbDraweeControllerBuilder fbDraweeControllerBuilder, AndroidComponentsExperimentHelper androidComponentsExperimentHelper) {
        this.f20423a = fbDraweeControllerBuilder;
        this.f20424b = androidComponentsExperimentHelper;
    }

    private FbPipelineDraweeController m28164a(FeedProps<? extends CacheableEntity> feedProps, Uri uri, CallerContext callerContext, E e) {
        Object obj;
        if (((CacheableEntity) feedProps.f13444a).mo2507g() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f20424b;
            boolean z = true;
            if (androidComponentsExperimentHelper.f5911o == null) {
                androidComponentsExperimentHelper.f5911o = Boolean.valueOf(androidComponentsExperimentHelper.f5897a.mo596a(ExperimentsForMultiRowQEModule.f5926j, true));
            }
            if (!(androidComponentsExperimentHelper.f5911o.booleanValue() || androidComponentsExperimentHelper.m10064s())) {
                z = false;
            }
            if (z) {
                return (FbPipelineDraweeController) ((HasPersistentState) e).mo2425a(new DraweeControllerPersistentStateKey(this, callerContext, uri, f20420c, feedProps, e.mo2446c() != null ? e.mo2446c().mo2419a() : null), (CacheableEntity) feedProps.f13444a);
            }
        }
        return m28165a(this, uri, callerContext);
    }

    public final ComponentLayout m28168a(ComponentContext componentContext, FeedProps<? extends CacheableEntity> feedProps, Uri uri, CallerContext callerContext, E e, boolean z, Reference<Drawable> reference, ScalingUtils$ScaleType scalingUtils$ScaleType, RoundingParams roundingParams, ScalingUtils$ScaleType scalingUtils$ScaleType2, PointF pointF, float f) {
        if (z && uri != null && ((HasRowKey) e).mo2461o()) {
            ((HasPrefetcher) e).mo2434a(ImageRequest.m18795a(uri), callerContext);
        }
        Builder b = FbFrescoComponent.m30975a(componentContext).m30994a(m28164a(feedProps, uri, callerContext, e)).m30991a((Reference) reference).m30996b(f).m30993a(roundingParams).m30997b(scalingUtils$ScaleType2);
        b.f22880a.f22877g = pointF;
        return b.m30992a(scalingUtils$ScaleType).m30663c().mo3343j();
    }

    public static FbPipelineDraweeController m28165a(FbFeedFrescoComponentSpec fbFeedFrescoComponentSpec, Uri uri, CallerContext callerContext) {
        return fbFeedFrescoComponentSpec.f20423a.m19424b(uri).m19417a(callerContext).m19435s();
    }
}

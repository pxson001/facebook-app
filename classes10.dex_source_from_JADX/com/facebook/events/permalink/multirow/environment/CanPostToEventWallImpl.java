package com.facebook.events.permalink.multirow.environment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.multirow.CanPostToEventWall;
import com.facebook.events.permalink.pagevc.PageViewerContextForAnEvent;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: batchInvite */
public class CanPostToEventWallImpl implements CanPostToEventWall {
    public final ComposerIntentLauncher f18724a;
    public final ComposerLauncher f18725b;
    private final PageViewerContextForAnEvent f18726c;
    public final Product f18727d;
    private final Lazy<QeAccessor> f18728e;

    public static CanPostToEventWallImpl m19009b(InjectorLike injectorLike) {
        return new CanPostToEventWallImpl(ComposerIntentLauncher.b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), PageViewerContextForAnEvent.m19058a(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    public static CanPostToEventWallImpl m19008a(InjectorLike injectorLike) {
        return m19009b(injectorLike);
    }

    @Inject
    public CanPostToEventWallImpl(ComposerIntentLauncher composerIntentLauncher, ComposerLauncher composerLauncher, PageViewerContextForAnEvent pageViewerContextForAnEvent, Product product, Lazy<QeAccessor> lazy) {
        this.f18725b = composerLauncher;
        this.f18724a = composerIntentLauncher;
        this.f18726c = pageViewerContextForAnEvent;
        this.f18727d = product;
        this.f18728e = lazy;
    }

    public final void mo847a(final Context context, final Event event) {
        this.f18726c.m19060a(event, new Function<ViewerContext, Void>(this) {
            final /* synthetic */ CanPostToEventWallImpl f18720c;

            @Nullable
            public Object apply(@Nullable Object obj) {
                this.f18720c.f18725b.a(null, this.f18720c.m19012b((ViewerContext) obj, event), 502, (Activity) ContextUtils.a(context, Activity.class));
                return null;
            }
        });
    }

    public final void mo848b(final Context context, final Event event) {
        this.f18726c.m19060a(event, new Function<ViewerContext, Void>(this) {
            final /* synthetic */ CanPostToEventWallImpl f18723c;

            @Nullable
            public Object apply(@Nullable Object obj) {
                this.f18723c.f18724a.a(this.f18723c.m19010a((ViewerContext) obj, context, event), 502, (Activity) ContextUtils.a(context, Activity.class));
                return null;
            }
        });
    }

    public final ComposerConfiguration m19012b(ViewerContext viewerContext, Event event) {
        boolean z;
        boolean z2 = true;
        Builder a = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventWallStatus");
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(event.a), TargetType.EVENT);
        builder.c = event.b;
        ComposerTargetData.Builder builder2 = builder;
        if (event.v != null) {
            z = true;
        } else {
            z = false;
        }
        builder2.f = z;
        builder = builder2;
        builder.d = event.w;
        Builder initialTargetData = a.setInitialTargetData(builder.a(event.an).a());
        if (this.f18727d != Product.PAA) {
            z2 = false;
        }
        return initialTargetData.setDisableFriendTagging(z2).setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext(viewerContext).a()).a();
    }

    public final Intent m19010a(ViewerContext viewerContext, Context context, Event event) {
        boolean z;
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(event.a), TargetType.EVENT);
        builder.c = event.b;
        ComposerTargetData.Builder builder2 = builder;
        if (event.v != null) {
            z = true;
        } else {
            z = false;
        }
        builder2.f = z;
        builder = builder2;
        builder.d = event.w;
        Builder initialTargetData = ComposerConfigurationFactory.a(ComposerSourceSurface.EVENT, "eventWallPhoto").setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext(viewerContext).a()).setInitialTargetData(builder.a());
        SimplePickerLauncherConfiguration.Builder builder3 = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.EVENT);
        builder3.a = initialTargetData.a();
        builder3 = builder3;
        if (((QeAccessor) this.f18728e.get()).a(ExperimentsForComposerAbTestModule.K, false)) {
            builder3.b();
        }
        return SimplePickerIntent.a(context, builder3);
    }
}

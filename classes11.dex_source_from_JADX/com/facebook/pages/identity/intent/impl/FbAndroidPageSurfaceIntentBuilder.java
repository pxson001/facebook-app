package com.facebook.pages.identity.intent.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.places.create.home.HomeActivityEntryFlow;
import com.facebook.places.create.home.HomeActivityIntentBuilder;
import com.facebook.places.create.home.HomeEditActivity;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel.PageVisitsModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.reviews.composer.config.ReviewComposerPluginConfig;
import com.facebook.timeline.intent.ModelBundle;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_timeline_fragment_tag */
public class FbAndroidPageSurfaceIntentBuilder extends DefaultPageSurfaceIntentBuilder {
    private static final Class<?> f4131b = FbAndroidPageSurfaceIntentBuilder.class;
    public final Context f4132c;
    private final FbUriIntentHandler f4133d;
    public final UriIntentMapper f4134e;
    private final ComposerConfigurationFactory f4135f;
    private final String f4136g;
    private final Lazy<QeAccessor> f4137h;
    private Product f4138i;

    public static FbAndroidPageSurfaceIntentBuilder m5074b(InjectorLike injectorLike) {
        return new FbAndroidPageSurfaceIntentBuilder((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), ComposerConfigurationFactory.b(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    public static FbAndroidPageSurfaceIntentBuilder m5073a(InjectorLike injectorLike) {
        return m5074b(injectorLike);
    }

    @Inject
    public FbAndroidPageSurfaceIntentBuilder(Context context, FbUriIntentHandler fbUriIntentHandler, UriIntentMapper uriIntentMapper, ComposerConfigurationFactory composerConfigurationFactory, String str, Product product, Lazy<QeAccessor> lazy) {
        this.f4136g = str;
        this.f4132c = context;
        this.f4133d = fbUriIntentHandler;
        this.f4134e = uriIntentMapper;
        this.f4135f = composerConfigurationFactory;
        this.f4138i = product;
        this.f4137h = lazy;
    }

    public final Builder m5079a(long j, String str) {
        Builder c = ComposerConfigurationFactory.c(ComposerSourceType.PAGE);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder();
        builder.b = TargetType.UNDIRECTED;
        builder = builder;
        builder.c = str;
        c = c.setInitialTargetData(builder.a());
        ComposerLocationInfo.Builder newBuilder = ComposerLocationInfo.newBuilder();
        CheckinPlaceModel.Builder builder2 = new CheckinPlaceModel.Builder();
        builder2.f = String.valueOf(j);
        builder2 = builder2;
        builder2.h = str;
        builder2 = builder2;
        PageVisitsModel.Builder builder3 = new PageVisitsModel.Builder();
        builder3.a = -1;
        builder2.i = builder3.a();
        return c.setInitialLocationInfo(newBuilder.b(builder2.a()).b());
    }

    public final Builder m5081a(long j, String str, String str2, ViewerContext viewerContext) {
        ComposerPageData.Builder a = this.a != null ? ComposerPageData.a(this.a) : ComposerPageData.newBuilder();
        a.setPostAsPageViewerContext(viewerContext);
        Builder sourceType = ComposerConfiguration.newBuilder().setSourceType(ComposerSourceType.PAGE);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(j, TargetType.PAGE);
        builder.c = str;
        builder = builder;
        builder.d = str2;
        builder = builder;
        builder.f = true;
        return sourceType.setInitialTargetData(builder.a()).setInitialPageData(a.a()).setComposerType(ComposerType.STATUS).setDisableAttachToAlbum(true).setUseOptimisticPosting(true).setDisableFriendTagging(true).setReactionSurface(Surface.ANDROID_PAGE_ADMIN_COMPOSER);
    }

    public final Builder m5082a(long j, String str, String str2, boolean z) {
        Builder a = ComposerConfigurationFactory.a();
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(j, TargetType.PAGE);
        builder.c = str;
        builder = builder;
        builder.d = str2;
        return a.setInitialTargetData(builder.a()).setDisablePhotos(!z);
    }

    private Intent m5072a(long j, String str, String str2, ViewerContext viewerContext, SimplePickerSource simplePickerSource, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = (z && z2) ? false : true;
        Preconditions.checkArgument(z5);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(j, TargetType.PAGE);
        builder.c = str;
        builder = builder;
        builder.d = str2;
        builder = builder;
        builder.f = true;
        ComposerTargetData a = builder.a();
        ComposerPageData.Builder a2 = this.a != null ? ComposerPageData.a(this.a) : ComposerPageData.newBuilder();
        a2.setPostAsPageViewerContext(viewerContext);
        ComposerConfiguration a3 = ComposerConfiguration.newBuilder().setSourceType(ComposerSourceType.PAGE).setComposerType(ComposerType.STATUS).setUseOptimisticPosting(!z2).setReactionSurface(Surface.ANDROID_PAGE_ADMIN_COMPOSER).setInitialTargetData(a).setInitialPageData(a2.a()).a();
        SimplePickerLauncherConfiguration.Builder g = new SimplePickerLauncherConfiguration.Builder(simplePickerSource).g();
        g.a = a3;
        SimplePickerLauncherConfiguration.Builder builder2 = g;
        if (z) {
            builder2.i();
        } else if (z2) {
            builder2.j();
        } else {
            if (z3) {
                builder2.b();
            }
            if (z4) {
                builder2.a(3, 7);
            }
        }
        if (this.f4138i == Product.PAA) {
            builder2.k();
        }
        return SimplePickerIntent.a(this.f4132c, builder2);
    }

    public final Intent m5087b(long j, String str, String str2, ViewerContext viewerContext) {
        return m5072a(j, str, str2, viewerContext, SimplePickerSource.PAGE, false, false, ((QeAccessor) this.f4137h.get()).a(ExperimentsForComposerAbTestModule.M, false), ((QeAccessor) this.f4137h.get()).a(ExperimentsForComposerAbTestModule.x, false));
    }

    public final Intent m5077a(long j, String str, String str2) {
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(j, TargetType.PAGE);
        builder.c = str;
        builder = builder;
        builder.d = str2;
        Builder initialTargetData = ComposerConfigurationFactory.a().setInitialTargetData(builder.a());
        SimplePickerLauncherConfiguration.Builder k = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.PAGE).k();
        k.a = initialTargetData.a();
        return SimplePickerIntent.a(this.f4132c, k.h());
    }

    public final Intent m5088c(long j, String str) {
        Intent a = this.f4134e.a(this.f4132c, StringFormatUtil.formatStrLocaleSafe(FBLinks.ap, Long.valueOf(j)));
        if (a == null) {
            return null;
        }
        a.putExtra("extra_page_name", str);
        return a;
    }

    public final Intent m5086b(long j, String str, String str2) {
        String a = StringFormatUtil.a(FBLinks.af, new Object[]{Long.valueOf(j)});
        Bundle bundle = new Bundle();
        ModelBundle.b(bundle, String.valueOf(j), str, str2);
        Intent a2 = this.f4134e.a(this.f4132c, a);
        if (a2 == null) {
            return null;
        }
        a2.putExtras(bundle);
        return a2;
    }

    public final void m5084a(long j) {
        this.f4133d.a(this.f4132c, StringFormatUtil.a(FBLinks.am, new Object[]{Long.valueOf(j)}));
    }

    public final Builder m5080a(long j, String str, @Nullable GraphQLPrivacyOption graphQLPrivacyOption, CurationMechanism curationMechanism, int i) {
        return ComposerConfigurationFactory.a(ComposerSourceType.PAGE, i != 0, j, str, curationMechanism, CurationSurface.NATIVE_PAGE_PROFILE).setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.c())).setHideKeyboardIfReachedMinimumHeight(true).setInitialRating(i).setInitialPrivacyOverride(graphQLPrivacyOption);
    }

    public final Builder m5083a(@Nullable String str, int i, String str2, long j, GraphQLPrivacyOption graphQLPrivacyOption, CurationMechanism curationMechanism) {
        Builder a = ComposerConfigurationFactory.a(ComposerSourceType.PAGE, i != 0, j, str, curationMechanism, CurationSurface.NATIVE_PAGE_PROFILE);
        a.setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.c())).setHideKeyboardIfReachedMinimumHeight(i == 0).setInitialRating(i).setInitialPrivacyOverride(graphQLPrivacyOption);
        if (str2 != null) {
            a.setInitialText(GraphQLHelper.a(str2));
        }
        return a;
    }

    public final Intent m5075a() {
        return this.f4134e.a(this.f4132c, FBLinks.aD);
    }

    public final Intent m5085b(long j, String str) {
        Intent intent = new Intent(new HomeActivityIntentBuilder(this.f4132c).a, HomeEditActivity.class);
        intent.putExtra("home_id", j);
        intent.putExtra("home_name", str);
        intent.putExtra("home_activity_entry_flow", HomeActivityEntryFlow.PAGES.ordinal());
        return intent;
    }

    public final Intent m5078a(long j, String str, String str2, String str3) {
        Intent a = this.f4134e.a(this.f4132c, StringFormatUtil.formatStrLocaleSafe(FBLinks.at, Long.valueOf(j)));
        if (a == null) {
            return null;
        }
        a.putExtra("extra_page_name", str);
        a.putExtra("extra_ref_module", str2);
        a.putExtra("event_ref_mechanism", str3);
        return a;
    }

    public final Intent m5076a(long j, String str, ActionMechanism actionMechanism) {
        return EventCreationNikumanActivity.a(this.f4132c, str, actionMechanism, Long.valueOf(j));
    }
}

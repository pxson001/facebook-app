package com.facebook.feed.util.composer.launch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.appdiscovery.composer.activity.AppComposerActivity;
import com.facebook.audiofingerprinting.MusicMetadata;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.MinutiaeConstants.TargetFragment;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration;
import com.facebook.composer.minutiae.util.MinutiaeConfiguration.Action;
import com.facebook.composer.minutiae.util.MinutiaeIntentHelper;
import com.facebook.composer.stickerpost.ComposerStickerPickerFragment;
import com.facebook.content.SecureContextHelper;
import com.facebook.facecast.FacecastActivity;
import com.facebook.friendsharing.gif.activity.GifPickerActivity;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPluginConfig;
import com.facebook.ipc.composer.intent.ComposerPluginConfigSerializer;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.friendsharing.listeningto.ListeningToComposerPluginConfig;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.places.checkin.analytics.PlacesPerformanceLogger;
import com.facebook.places.checkin.ipc.CheckinComposerEntryPoint;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.protocol.CheckinPrefetchRunner;
import com.facebook.places.checkin.protocol.PlacePickerFetchParams;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Tab layout should be a subclass of FbTextView */
public class FeedComposerLauncher {
    public static final ComposerConfigCustomizer f22338a = new C19111();
    private final AnalyticsLogger f22339b;
    private final ComposerIntentLauncher f22340c;
    private final NavigationLogger f22341d;
    private final Lazy<PlacesPerformanceLogger> f22342e;
    private final Provider<CheckinPrefetchRunner> f22343f;
    private final Lazy<SecureContextHelper> f22344g;
    private final ComposerLauncher f22345h;
    public final LauncherContext f22346i;
    public final ComposerConfigCustomizer f22347j;
    public final QeAccessor f22348k;
    private final JsonPluginConfigSerializer f22349l;

    /* compiled from: Tab layout should be a subclass of FbTextView */
    final class C19111 implements ComposerConfigCustomizer {
        C19111() {
        }

        public final void m24943a(Builder builder) {
        }
    }

    private Builder m24947a() {
        return m24948a(RegularImmutableList.a);
    }

    @Inject
    public FeedComposerLauncher(AnalyticsLogger analyticsLogger, ComposerIntentLauncher composerIntentLauncher, NavigationLogger navigationLogger, Lazy<PlacesPerformanceLogger> lazy, Provider<CheckinPrefetchRunner> provider, Lazy<SecureContextHelper> lazy2, ComposerLauncher composerLauncher, QeAccessor qeAccessor, JsonPluginConfigSerializer jsonPluginConfigSerializer, @Assisted LauncherContext launcherContext, @Assisted ComposerConfigCustomizer composerConfigCustomizer) {
        this.f22339b = analyticsLogger;
        this.f22340c = composerIntentLauncher;
        this.f22341d = navigationLogger;
        this.f22342e = lazy;
        this.f22343f = provider;
        this.f22344g = lazy2;
        this.f22345h = composerLauncher;
        this.f22349l = jsonPluginConfigSerializer;
        this.f22346i = launcherContext;
        this.f22347j = (ComposerConfigCustomizer) Preconditions.checkNotNull(composerConfigCustomizer);
        this.f22348k = qeAccessor;
    }

    public final void m24954a(Optional<String> optional, Activity activity) {
        m24950a((Optional) optional, m24947a().a(), "tap_status_button", activity);
    }

    public final void m24956a(Optional<String> optional, Activity activity, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        m24950a((Optional) optional, m24947a().setTopics(immutableList).setTopicFeedId(graphQLExploreFeed != null ? graphQLExploreFeed.n() : null).a(), "tap_status_button", activity);
    }

    public final <T extends ComposerPluginConfig> void m24959a(Optional<String> optional, T t, ComposerPluginConfigSerializer<T> composerPluginConfigSerializer, Activity activity, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        m24950a((Optional) optional, m24947a().setTopics(immutableList).setTopicFeedId(graphQLExploreFeed != null ? graphQLExploreFeed.n() : null).setPluginConfig(composerPluginConfigSerializer.a(t)).a(), "tap_status_button", activity);
    }

    public final <T extends ComposerPluginConfig> void m24958a(Optional<String> optional, T t, ComposerPluginConfigSerializer<T> composerPluginConfigSerializer, Activity activity) {
        Builder a = m24947a();
        a.setPluginConfig(composerPluginConfigSerializer.a(t));
        m24950a((Optional) optional, a.a(), "tap_status_button", activity);
    }

    public final void m24962b(Optional<String> optional, Activity activity) {
        int i = 1;
        ComposerFacecastInfo.Builder builder = new ComposerFacecastInfo.Builder();
        if (Camera.getNumberOfCameras() <= 1) {
            i = 0;
        }
        builder.a = i;
        m24950a((Optional) optional, m24947a().setInitialFacecastInfo(builder.a()).a(), "tap_status_button", activity);
    }

    public final void m24965c(Optional<String> optional, Activity activity, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        m24949a(m24952b((Optional) optional, (Context) activity, (ImmutableList) immutableList, graphQLExploreFeed), "tap_minutiae", activity);
    }

    public final void m24961a(Optional<String> optional, String str, Activity activity) {
        m24949a(m24945a((Optional) optional, str, (Context) activity), "tap_minutiae", activity);
    }

    public final void m24964c(Optional<String> optional, Activity activity) {
        m24949a(m24944a((Optional) optional, (Context) activity), "tap_listening_to_button", activity);
    }

    public final <T extends ComposerPluginConfig> void m24960a(Optional<String> optional, ImmutableList<MediaItem> immutableList, T t, ComposerPluginConfigSerializer<T> composerPluginConfigSerializer, Activity activity) {
        Preconditions.checkNotNull(activity);
        m24950a((Optional) optional, m24948a((ImmutableList) immutableList).setPluginConfig(composerPluginConfigSerializer.a(t)).a(), "tap_photo_tray", activity);
    }

    public final void m24967d(Optional<String> optional, Activity activity, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        String n;
        HoneyClientEventFast a = this.f22339b.a("checkin_button_clicked", false);
        if (a.a()) {
            a.b();
        }
        CheckinPrefetchRunner checkinPrefetchRunner = (CheckinPrefetchRunner) this.f22343f.get();
        PlacePickerFetchParams placePickerFetchParams = new PlacePickerFetchParams();
        placePickerFetchParams.f11114g = CheckinComposerEntryPoint.Checkin;
        checkinPrefetchRunner.m13025a(placePickerFetchParams);
        ((PlacesPerformanceLogger) this.f22342e.get()).c();
        Builder topics = ComposerConfigurationFactory.a(this.f22346i.c(), this.f22346i.d()).setInitialTargetData(this.f22346i.a()).setComposerType(this.f22346i.g()).setNectarModule(this.f22346i.b()).setReactionSurface(this.f22346i.e()).setShouldPickerSupportLiveCamera(true).setTopics(immutableList);
        if (graphQLExploreFeed != null) {
            n = graphQLExploreFeed.n();
        } else {
            n = null;
        }
        Builder topicFeedId = topics.setTopicFeedId(n);
        this.f22347j.a(topicFeedId);
        PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
        newBuilder.p = SearchType.CHECKIN;
        newBuilder = newBuilder;
        newBuilder.i = true;
        newBuilder = newBuilder;
        newBuilder.c = topicFeedId.a();
        PlacePickerConfiguration.Builder builder = newBuilder;
        builder.s = true;
        newBuilder = builder;
        if (optional.isPresent()) {
            newBuilder.e = (String) optional.get();
        }
        m24949a(CheckinIntentCreator.a(activity, newBuilder.a()), "tap_check_in_button", activity);
    }

    public final void m24966d(Optional<String> optional, Activity activity) {
        m24949a(AppComposerActivity.m20516a(activity, (String) optional.orNull(), m24947a().a()), "tap_app_button", activity);
    }

    private void m24949a(Intent intent, String str, Activity activity) {
        this.f22341d.a(str);
        this.f22340c.a(intent, 1756, activity);
    }

    public final void m24957a(Optional<String> optional, FragmentManager fragmentManager) {
        Builder a = m24947a();
        this.f22347j.a(a);
        this.f22341d.a("tap_sticker_button");
        FragmentTransaction a2 = fragmentManager.a();
        ComposerStickerPickerFragment composerStickerPickerFragment = new ComposerStickerPickerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("sessionId", (String) optional.orNull());
        bundle.putParcelable("composerConfiguration", a.a());
        composerStickerPickerFragment.g(bundle);
        a2.a(composerStickerPickerFragment, "STICKER_PICKER_FRAGMENT_TAG").b();
    }

    public final void m24955a(Optional<String> optional, Activity activity, MusicMetadata musicMetadata) {
        Builder a = m24947a();
        a.setPluginConfig(this.f22349l.a(ListeningToComposerPluginConfig.a(musicMetadata.f1072a, musicMetadata.f1074c, (String) optional.orNull())));
        m24950a((Optional) optional, a.a(), "tap_listening_to_button", activity);
    }

    public final void m24968e(Optional<String> optional, Activity activity) {
        m24949a(GifPickerActivity.m26008a((String) optional.get(), activity, ComposerConfigurationFactory.a(this.f22346i.c(), this.f22346i.d()).setInitialTargetData(this.f22346i.a()).setComposerType(this.f22346i.g()).setNectarModule(this.f22346i.b()).setReactionSurface(this.f22346i.e()).a()), "tap_gif_button", activity);
    }

    public final void m24969f(Optional<String> optional, Activity activity) {
        m24949a(m24951b((Optional) optional, (Context) activity), "tap_recommendations_button", activity);
    }

    public final void m24953a(Activity activity) {
        Intent intent = new Intent(activity, FacecastActivity.class);
        intent.putExtras(FacecastActivity.m21781a(this.f22346i.c(), this.f22346i.a()));
        ((SecureContextHelper) this.f22344g.get()).a(intent, activity);
    }

    private void m24950a(Optional<String> optional, ComposerConfiguration composerConfiguration, String str, Activity activity) {
        this.f22341d.a(str);
        this.f22345h.a((String) optional.orNull(), composerConfiguration, 1756, activity);
    }

    private Builder m24948a(ImmutableList<MediaItem> immutableList) {
        Builder shouldPickerSupportLiveCamera = ComposerConfigurationFactory.a(this.f22346i.c(), this.f22346i.d()).setInitialTargetData(this.f22346i.a()).setComposerType(this.f22346i.g()).setNectarModule(this.f22346i.b()).setReactionSurface(this.f22346i.e()).setShouldPickerSupportLiveCamera(true);
        if (!immutableList.isEmpty()) {
            shouldPickerSupportLiveCamera.setInitialAttachments(ComposerAttachment.a(immutableList));
        }
        this.f22347j.a(shouldPickerSupportLiveCamera);
        return shouldPickerSupportLiveCamera;
    }

    public final void m24963b(Optional<String> optional, Activity activity, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        Builder topicFeedId = ComposerConfigurationFactory.a(this.f22346i.c(), this.f22346i.d()).setComposerType(this.f22346i.g()).setReactionSurface(this.f22346i.e()).setShouldPickerSupportLiveCamera(true).setInitialTargetData(this.f22346i.a()).setTopics(immutableList).setTopicFeedId(graphQLExploreFeed != null ? graphQLExploreFeed.n() : null);
        this.f22347j.a(topicFeedId);
        SimplePickerLauncherConfiguration.Builder builder = new SimplePickerLauncherConfiguration.Builder(this.f22346i.f());
        builder.a = topicFeedId.a();
        builder = builder.o().p().g().c().e();
        if (this.f22348k.a(ExperimentsForComposerAbTestModule.Q, false)) {
            builder.b();
        }
        if (this.f22346i.a().targetType == TargetType.USER) {
            builder.h();
            builder.d();
        }
        m24949a(SimplePickerIntent.a(activity, builder, (String) optional.orNull()), "tap_photo_button", activity);
        CheckinPrefetchRunner checkinPrefetchRunner = (CheckinPrefetchRunner) this.f22343f.get();
        PlacePickerFetchParams placePickerFetchParams = new PlacePickerFetchParams();
        placePickerFetchParams.f11114g = CheckinComposerEntryPoint.Photo;
        checkinPrefetchRunner.m13025a(placePickerFetchParams);
    }

    private Intent m24952b(Optional<String> optional, Context context, ImmutableList<GraphQLExploreFeed> immutableList, @Nullable GraphQLExploreFeed graphQLExploreFeed) {
        Builder topicFeedId = m24947a().setTopics(immutableList).setTopicFeedId(graphQLExploreFeed != null ? graphQLExploreFeed.n() : null);
        this.f22347j.a(topicFeedId);
        ComposerConfiguration a = topicFeedId.a();
        String str = (String) optional.orNull();
        MinutiaeConfiguration.Builder b = MinutiaeConfiguration.m1813b();
        b.f1823b = TargetFragment.VERB_PICKER;
        b = b;
        b.f1828g = true;
        b = b;
        b.f1829h = Action.LAUNCH_COMPOSER;
        b = b;
        b.f1830i = a;
        b = b;
        b.f1822a = str;
        return b.m1809a(context);
    }

    private Intent m24945a(Optional<String> optional, String str, Context context) {
        Builder a = m24947a();
        this.f22347j.a(a);
        ComposerConfiguration a2 = a.a();
        String str2 = (String) optional.orNull();
        MinutiaeTaggableActivityModel.Builder a3 = m24946a("dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODM1MDA2MTQ2", "383634835006146");
        a3.e = true;
        a3 = a3;
        a3.q = true;
        return MinutiaeIntentHelper.m1819a(context, a2, str2, a3.a(), str, null);
    }

    private Intent m24944a(Optional<String> optional, Context context) {
        Builder a = m24947a();
        this.f22347j.a(a);
        ComposerConfiguration a2 = a.a();
        String str = (String) optional.orNull();
        MinutiaeTaggableActivityModel.Builder a3 = m24946a("dGFnZ2FibGVfYWN0aXZpdHk6MzgzNjM0ODY4MzM5NDc2", "383634868339476");
        a3.q = true;
        a3 = a3;
        a3.p = true;
        return MinutiaeIntentHelper.m1819a(context, a2, str, a3.a(), context.getString(2131234555), null);
    }

    private Intent m24951b(Optional<String> optional, Context context) {
        Builder a = m24947a();
        this.f22347j.a(a);
        ComposerConfiguration a2 = a.a();
        String str = (String) optional.orNull();
        MinutiaeTaggableActivityModel.Builder a3 = m24946a("dGFnZ2FibGVfYWN0aXZpdHk6NjAxMzY5OTc2NTY1OTYz", "601369976565963");
        a3.q = false;
        a3 = a3;
        a3.e = true;
        return MinutiaeIntentHelper.m1819a(context, a2, str, a3.a(), context.getString(2131234556), "social_search");
    }

    private static MinutiaeTaggableActivityModel.Builder m24946a(String str, String str2) {
        MinutiaeTaggableActivityModel.Builder builder = new MinutiaeTaggableActivityModel.Builder();
        builder.d = str;
        builder = builder;
        builder.f = str2;
        builder = builder;
        IconImageLargeModel.Builder builder2 = new IconImageLargeModel.Builder();
        builder2.a = "";
        builder.c = builder2.a();
        builder = builder;
        GlyphModel.Builder builder3 = new GlyphModel.Builder();
        builder3.a = "";
        builder.b = builder3.a();
        builder = builder;
        AllIconsModel.Builder builder4 = new AllIconsModel.Builder();
        builder4.a = 1;
        builder.a = builder4.a();
        return builder;
    }
}

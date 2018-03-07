package com.facebook.feed.goodfriends.composer;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.goodfriends.data.GoodFriendsMetadataFetcher;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$Factory;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$PrivacyDelegateGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.graphql.data.GoodFriendsTaggingTypeaheadDataSource;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: announcements */
public class GoodFriendsComposerPlugin extends ComposerPluginDefault {
    public final GoodFriendsComposerPluginConfig f19215a;
    public final ComposerGoodFriendsPrivacyDelegateProvider f19216b;
    public final GoodFriendsTaggingTypeaheadDataSource f19217c;

    /* compiled from: announcements */
    class C16691 implements ComposerPluginGetters$Getter<String> {
        final /* synthetic */ GoodFriendsComposerPlugin f19209a;

        C16691(GoodFriendsComposerPlugin goodFriendsComposerPlugin) {
            this.f19209a = goodFriendsComposerPlugin;
        }

        public final Object mo1300a() {
            return this.f19209a.f19215a.m22735c();
        }
    }

    /* compiled from: announcements */
    class C16702 implements ComposerPluginGetters$PrivacyDelegateGetter {
        final /* synthetic */ GoodFriendsComposerPlugin f19210a;

        C16702(GoodFriendsComposerPlugin goodFriendsComposerPlugin) {
            this.f19210a = goodFriendsComposerPlugin;
        }

        public final ComposerPrivacyDelegate mo1453a(PrivacyUpdatedHandler privacyUpdatedHandler, AnalyticsCallback analyticsCallback) {
            ComposerGoodFriendsPrivacyDelegateProvider composerGoodFriendsPrivacyDelegateProvider = this.f19210a.f19216b;
            return new ComposerGoodFriendsPrivacyDelegate(privacyUpdatedHandler, IdBasedProvider.a(composerGoodFriendsPrivacyDelegateProvider, 4442), (AbstractFbErrorReporter) FbErrorReporterImpl.a(composerGoodFriendsPrivacyDelegateProvider), TasksManager.b(composerGoodFriendsPrivacyDelegateProvider), new GoodFriendsMetadataFetcher(GraphQLQueryExecutor.a(composerGoodFriendsPrivacyDelegateProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(composerGoodFriendsPrivacyDelegateProvider), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(composerGoodFriendsPrivacyDelegateProvider)), ResourcesMethodAutoProvider.a(composerGoodFriendsPrivacyDelegateProvider));
        }
    }

    /* compiled from: announcements */
    class C16713 implements ComposerPluginGetters$Getter<ImmutableList<String>> {
        final /* synthetic */ GoodFriendsComposerPlugin f19211a;

        C16713(GoodFriendsComposerPlugin goodFriendsComposerPlugin) {
            this.f19211a = goodFriendsComposerPlugin;
        }

        public final Object mo1300a() {
            return ImmutableList.of("only_tag_good_friends");
        }
    }

    /* compiled from: announcements */
    class C16724 implements ComposerPluginGetters$Getter<TagTypeaheadDataSource> {
        final /* synthetic */ GoodFriendsComposerPlugin f19212a;

        C16724(GoodFriendsComposerPlugin goodFriendsComposerPlugin) {
            this.f19212a = goodFriendsComposerPlugin;
        }

        public final Object mo1300a() {
            return this.f19212a.f19217c;
        }
    }

    /* compiled from: announcements */
    public class Factory implements ComposerPlugin$Factory {
        private final GoodFriendsComposerPluginProvider f19213a;
        private final JsonPluginConfigSerializer<GoodFriendsComposerPluginConfig> f19214b;

        @Inject
        public Factory(GoodFriendsComposerPluginProvider goodFriendsComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f19213a = goodFriendsComposerPluginProvider;
            this.f19214b = jsonPluginConfigSerializer;
        }

        public final ComposerPluginDefault mo1302a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            GoodFriendsComposerPluginProvider goodFriendsComposerPluginProvider = this.f19213a;
            return new GoodFriendsComposerPlugin((GoodFriendsComposerPluginConfig) this.f19214b.a(serializedComposerPluginConfig, GoodFriendsComposerPluginConfig.class), composerPluginSession, (Context) goodFriendsComposerPluginProvider.getInstance(Context.class), (ComposerGoodFriendsPrivacyDelegateProvider) goodFriendsComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(ComposerGoodFriendsPrivacyDelegateProvider.class), GoodFriendsTaggingTypeaheadDataSource.b(goodFriendsComposerPluginProvider));
        }

        public final String m22729b() {
            return GoodFriendsComposerPluginConfig.f19218a;
        }
    }

    @Inject
    public GoodFriendsComposerPlugin(@Assisted GoodFriendsComposerPluginConfig goodFriendsComposerPluginConfig, @Assisted ComposerPluginSession composerPluginSession, Context context, ComposerGoodFriendsPrivacyDelegateProvider composerGoodFriendsPrivacyDelegateProvider, GoodFriendsTaggingTypeaheadDataSource goodFriendsTaggingTypeaheadDataSource) {
        super(context, composerPluginSession);
        this.f19215a = goodFriendsComposerPluginConfig;
        this.f19216b = composerGoodFriendsPrivacyDelegateProvider;
        this.f19217c = goodFriendsTaggingTypeaheadDataSource;
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter mo1321M() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<String> aB() {
        return new C16691(this);
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter mo1454J() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    protected final ComposerPluginGetters$PrivacyDelegateGetter ab() {
        return new C16702(this);
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<ImmutableList<String>> aN() {
        return new C16713(this);
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<TagTypeaheadDataSource> aO() {
        return new C16724(this);
    }
}

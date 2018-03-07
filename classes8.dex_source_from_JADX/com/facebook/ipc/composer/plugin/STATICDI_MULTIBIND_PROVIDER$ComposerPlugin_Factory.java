package com.facebook.ipc.composer.plugin;

import com.facebook.composer.shareintent.util.UserDraftComposerPlugin;
import com.facebook.composer.shareintent.util.UserDraftComposerPluginProvider;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPlugin;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginProvider;
import com.facebook.feed.photoreminder.composer.PhotoReminderComposerPlugin;
import com.facebook.feed.photoreminder.composer.PhotoReminderComposerPluginProvider;
import com.facebook.friendsharing.listeningto.composer.ListeningToComposerPlugin;
import com.facebook.friendsharing.listeningto.composer.ListeningToComposerPluginProvider;
import com.facebook.friendsharing.souvenirs.prompt.composer.SouvenirPromptComposerPlugin;
import com.facebook.friendsharing.souvenirs.prompt.composer.SouvenirPromptComposerPluginProvider;
import com.facebook.goodwill.composer.GoodwillCampaignComposerPlugin;
import com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPlugin;
import com.facebook.goodwill.composer.GoodwillFriendversaryCardComposerPlugin;
import com.facebook.greetingcards.create.GreetingCardComposerPlugin;
import com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.plugin.ComposerPlugin.Factory;
import com.facebook.productionprompts.composer.ProductionPromptsComposerPlugin;
import com.facebook.reviews.composer.ReviewComposerPlugin;
import com.facebook.timeline.lifeevent.LifeEventComposerPlugin;
import com.facebook.timeline.lifeevent.LifeEventComposerPluginProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$ComposerPlugin_Factory implements MultiBindIndexedProvider<Factory>, Provider<Set<Factory>> {
    private final InjectorLike f1142a;

    public STATICDI_MULTIBIND_PROVIDER$ComposerPlugin_Factory(InjectorLike injectorLike) {
        this.f1142a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1142a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 13;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new UserDraftComposerPlugin.Factory((UserDraftComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(UserDraftComposerPluginProvider.class));
            case 1:
                return new GoodFriendsComposerPlugin.Factory((GoodFriendsComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(GoodFriendsComposerPluginProvider.class), JsonPluginConfigSerializer.b(injector));
            case 2:
                return new PhotoReminderComposerPlugin.Factory((PhotoReminderComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(PhotoReminderComposerPluginProvider.class), JsonPluginConfigSerializer.b(injector));
            case 3:
                return new ListeningToComposerPlugin.Factory((ListeningToComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(ListeningToComposerPluginProvider.class), JsonPluginConfigSerializer.b(injector));
            case 4:
                return new SouvenirPromptComposerPlugin.Factory((SouvenirPromptComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(SouvenirPromptComposerPluginProvider.class), JsonPluginConfigSerializer.b(injector));
            case 5:
                return GoodwillCampaignComposerPlugin.Factory.m35a(injector);
            case 6:
                return GoodwillFriendsBirthdayComposerPlugin.Factory.m101a(injector);
            case 7:
                return GoodwillFriendversaryCardComposerPlugin.Factory.m116a(injector);
            case 8:
                return GreetingCardComposerPlugin.Factory.a(injector);
            case 9:
                return GroupsPollComposerPlugin.Factory.m443a(injector);
            case 10:
                return ProductionPromptsComposerPlugin.Factory.m4385a(injector);
            case 11:
                return ReviewComposerPlugin.Factory.m4840a(injector);
            case 12:
                return new LifeEventComposerPlugin.Factory((LifeEventComposerPluginProvider) injector.getOnDemandAssistedProviderForStaticDi(LifeEventComposerPluginProvider.class));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

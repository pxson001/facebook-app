package com.facebook.feedplugins.profile.calltoaction;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.goodwill.composer.GoodwillFriendsBirthdayComposerPluginConfig;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.heisman.ProfilePictureOverlayAnalyticsLogger;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SNAPSHOT_AND_IMPORT_ID_DELETED */
public class ProfilePictureOverlayCallToActionPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStory f23749a;
    final /* synthetic */ ProfilePictureOverlayCallToActionPartDefinition f23750b;

    public ProfilePictureOverlayCallToActionPartDefinition$1(ProfilePictureOverlayCallToActionPartDefinition profilePictureOverlayCallToActionPartDefinition, GraphQLStory graphQLStory) {
        this.f23750b = profilePictureOverlayCallToActionPartDefinition;
        this.f23749a = graphQLStory;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 828927729);
        if (((Activity) ContextUtils.a(view.getContext(), Activity.class)) != null) {
            GraphQLActor b = StoryActorHelper.b(this.f23749a);
            Builder builder = new Builder(Long.parseLong(b.H()), TargetType.USER);
            builder.d = b.ai().b();
            builder = builder;
            builder.c = b.aa();
            ComposerConfiguration a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "profilePictureOverlayCallToAction").setInitialTargetData(builder.a()).setPluginConfig(((JsonPluginConfigSerializer) this.f23750b.h.get()).a(GoodwillFriendsBirthdayComposerPluginConfig.a(view.getResources().getString(2131239205, new Object[]{b.aa()})))).setIsFireAndForget(true).a();
            String uuid = SafeUUIDGenerator.a().toString();
            ((ProfilePictureOverlayAnalyticsLogger) this.f23750b.c.get()).f(uuid, "birthday_post_cta");
            ((ComposerLauncher) this.f23750b.g.get()).a(uuid, a2, view.getContext());
        }
        Logger.a(2, EntryType.UI_INPUT_END, 990651044, a);
    }
}

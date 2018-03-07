package com.facebook.feed.inlinecomposer.multirow;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.goodfriends.composer.GoodFriendsComposerPluginConfig;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerV2HeaderPartDefinition.Props;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android_ad_offsite_experience_survey */
class InlineComposerV2HeaderPartDefinition$4 implements OnClickListener {
    final /* synthetic */ Props f19250a;
    final /* synthetic */ InlineComposerV2HeaderPartDefinition f19251b;

    InlineComposerV2HeaderPartDefinition$4(InlineComposerV2HeaderPartDefinition inlineComposerV2HeaderPartDefinition, Props props) {
        this.f19251b = inlineComposerV2HeaderPartDefinition;
        this.f19250a = props;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1984011729);
        InlineComposerV2HeaderPartDefinition inlineComposerV2HeaderPartDefinition = this.f19251b;
        Builder pluginConfig = ComposerConfigurationFactory.a(ComposerSourceType.GOOD_FRIENDS_COMPOSER).setPluginConfig(inlineComposerV2HeaderPartDefinition.u.a(GoodFriendsComposerPluginConfig.m22732a(this.f19250a.b.l)));
        CreativeCamLauncher creativeCamLauncher = inlineComposerV2HeaderPartDefinition.w;
        Activity activity = (Activity) ContextUtils.a(inlineComposerV2HeaderPartDefinition.b, Activity.class);
        CreativeCamLaunchConfig.Builder builder = new CreativeCamLaunchConfig.Builder();
        builder.f6153b = true;
        builder = builder;
        builder.f6157f = SupportedMediaType.PHOTO_ONLY;
        builder = builder;
        builder.f6155d = true;
        builder = builder;
        builder.f6162k = pluginConfig.a();
        creativeCamLauncher.a(activity, 1756, builder.m8045a(), SafeUUIDGenerator.a().toString(), null);
        Logger.a(2, EntryType.UI_INPUT_END, 107303893, a);
    }
}

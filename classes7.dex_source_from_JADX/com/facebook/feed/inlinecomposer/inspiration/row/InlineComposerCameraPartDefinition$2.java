package com.facebook.feed.inlinecomposer.inspiration.row;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasContext;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;

/* compiled from: android_pages_ban_actions */
class InlineComposerCameraPartDefinition$2 implements OnClickListener {
    final /* synthetic */ HasContext f19229a;
    final /* synthetic */ InlineComposerCameraPartDefinition$State f19230b;
    final /* synthetic */ CreativeEditingSwipeableController f19231c;
    final /* synthetic */ InlineComposerCameraPartDefinition f19232d;

    InlineComposerCameraPartDefinition$2(InlineComposerCameraPartDefinition inlineComposerCameraPartDefinition, HasContext hasContext, InlineComposerCameraPartDefinition$State inlineComposerCameraPartDefinition$State, CreativeEditingSwipeableController creativeEditingSwipeableController) {
        this.f19232d = inlineComposerCameraPartDefinition;
        this.f19229a = hasContext;
        this.f19230b = inlineComposerCameraPartDefinition$State;
        this.f19231c = creativeEditingSwipeableController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -881529379);
        Activity activity = (Activity) ContextUtils.a(this.f19229a.getContext(), Activity.class);
        Builder a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.NEWSFEED, "inspiration");
        CreativeCamLauncher creativeCamLauncher = this.f19232d.g;
        CreativeCamLaunchConfig.Builder builder = new CreativeCamLaunchConfig.Builder();
        builder.f6153b = true;
        builder = builder;
        builder.f6157f = SupportedMediaType.PHOTO_ONLY;
        builder = builder;
        builder.f6159h = this.f19230b.f19236b;
        builder = builder;
        builder.f6160i = this.f19231c.m11786g();
        builder = builder;
        builder.f6162k = a2.a();
        creativeCamLauncher.a(activity, 8372, builder.m8045a(), "session_id", null);
        Logger.a(2, EntryType.UI_INPUT_END, 151032533, a);
    }
}

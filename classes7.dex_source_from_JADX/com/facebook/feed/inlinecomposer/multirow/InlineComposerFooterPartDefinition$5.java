package com.facebook.feed.inlinecomposer.multirow;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.facecast.abtest.ExperimentsForFacecastAbtestModule;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerEnvironment;
import com.facebook.feed.util.composer.launch.FeedComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: android_media_story_groups_app_promo_call_to_action */
public class InlineComposerFooterPartDefinition$5 implements OnClickListener {
    final /* synthetic */ HasContext f19242a;
    final /* synthetic */ Activity f19243b;
    final /* synthetic */ InlineComposerFooterPartDefinition f19244c;

    public InlineComposerFooterPartDefinition$5(InlineComposerFooterPartDefinition inlineComposerFooterPartDefinition, HasContext hasContext, Activity activity) {
        this.f19244c = inlineComposerFooterPartDefinition;
        this.f19242a = hasContext;
        this.f19243b = activity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -810963783);
        FeedComposerLauncher a2 = this.f19244c.i.a(((InlineComposerEnvironment) this.f19242a).a(true), ((InlineComposerEnvironment) this.f19242a).n);
        Optional optional = Absent.INSTANCE;
        Activity activity = this.f19243b;
        if (a2.f22348k.a(ExperimentsForFacecastAbtestModule.f2796q, false)) {
            a2.m24962b(optional, activity);
        } else {
            a2.m24953a(activity);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1780998841, a);
    }
}

package com.facebook.feed.photoreminder.composer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$Factory;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin_panel_share_photo */
public class PhotoReminderComposerPlugin extends ComposerPluginDefault {
    public final PhotoReminderPluginConfig f19766a;
    public final PromptPublishIntentHelper f19767b;

    /* compiled from: admin_panel_share_photo */
    class C17161 implements ComposerPluginGetters$Getter<Intent> {
        final /* synthetic */ PhotoReminderComposerPlugin f19762a;

        C17161(PhotoReminderComposerPlugin photoReminderComposerPlugin) {
            this.f19762a = photoReminderComposerPlugin;
        }

        public final Object mo1300a() {
            return this.f19762a.f19767b.a(this.f19762a.m20863E().a, this.f19762a.f16931q, this.f19762a.f19766a.m23027c(), PhotoReminderPromptObject.class, this.f19762a.m20863E().a.m().toArray().length != 0);
        }
    }

    /* compiled from: admin_panel_share_photo */
    class C17172 implements ComposerPluginGetters$Getter<Bundle> {
        final /* synthetic */ PhotoReminderComposerPlugin f19763a;

        C17172(PhotoReminderComposerPlugin photoReminderComposerPlugin) {
            this.f19763a = photoReminderComposerPlugin;
        }

        public final Object mo1300a() {
            return PromptPublishIntentHelper.a(this.f19763a.f19766a.m23027c(), PhotoReminderPromptObject.class, null);
        }
    }

    /* compiled from: admin_panel_share_photo */
    public class Factory implements ComposerPlugin$Factory {
        private final PhotoReminderComposerPluginProvider f19764a;
        private final JsonPluginConfigSerializer<PhotoReminderPluginConfig> f19765b;

        @Inject
        public Factory(PhotoReminderComposerPluginProvider photoReminderComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f19764a = photoReminderComposerPluginProvider;
            this.f19765b = jsonPluginConfigSerializer;
        }

        public final String m23020b() {
            return "PHOTO_REMINDER_PERSIST_KEY";
        }

        public final ComposerPluginDefault mo1302a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            PhotoReminderComposerPluginProvider photoReminderComposerPluginProvider = this.f19764a;
            return new PhotoReminderComposerPlugin(composerPluginSession, (PhotoReminderPluginConfig) this.f19765b.a(serializedComposerPluginConfig, PhotoReminderPluginConfig.class), (Context) photoReminderComposerPluginProvider.getInstance(Context.class), PromptPublishIntentHelper.b(photoReminderComposerPluginProvider));
        }
    }

    @Inject
    public PhotoReminderComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted PhotoReminderPluginConfig photoReminderPluginConfig, Context context, PromptPublishIntentHelper promptPublishIntentHelper) {
        super(context, composerPluginSession);
        this.f19766a = photoReminderPluginConfig;
        this.f19767b = promptPublishIntentHelper;
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<Intent> mo1327V() {
        return new C17161(this);
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<Bundle> aI() {
        return new C17172(this);
    }

    protected final ComposerPluginGetters$BooleanGetter aM() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    public final ComposerPluginGetters$BooleanGetter mo1334f() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter mo1321M() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }
}

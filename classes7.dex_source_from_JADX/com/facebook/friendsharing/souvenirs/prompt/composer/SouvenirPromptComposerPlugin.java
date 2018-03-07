package com.facebook.friendsharing.souvenirs.prompt.composer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
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

/* compiled from: REQUEST */
public class SouvenirPromptComposerPlugin extends ComposerPluginDefault {
    public final SouvenirPromptPluginConfig f24124a;
    public final PromptPublishIntentHelper f24125b;

    /* compiled from: REQUEST */
    class C21011 implements ComposerPluginGetters$Getter<Intent> {
        final /* synthetic */ SouvenirPromptComposerPlugin f24120a;

        C21011(SouvenirPromptComposerPlugin souvenirPromptComposerPlugin) {
            this.f24120a = souvenirPromptComposerPlugin;
        }

        public final Object mo1300a() {
            return this.f24120a.f24125b.a(this.f24120a.m20863E().a, this.f24120a.f16931q, this.f24120a.f24124a.promptAnalytics, SouvenirPromptObject.class, this.f24120a.m20863E().a.m().toArray().length != 0);
        }
    }

    /* compiled from: REQUEST */
    class C21022 implements ComposerPluginGetters$Getter<Bundle> {
        final /* synthetic */ SouvenirPromptComposerPlugin f24121a;

        C21022(SouvenirPromptComposerPlugin souvenirPromptComposerPlugin) {
            this.f24121a = souvenirPromptComposerPlugin;
        }

        public final Object mo1300a() {
            return PromptPublishIntentHelper.a(this.f24121a.f24124a.promptAnalytics, SouvenirPromptObject.class, null);
        }
    }

    /* compiled from: REQUEST */
    public class Factory implements ComposerPlugin$Factory {
        private final SouvenirPromptComposerPluginProvider f24122a;
        private final JsonPluginConfigSerializer<SouvenirPromptPluginConfig> f24123b;

        @Inject
        public Factory(SouvenirPromptComposerPluginProvider souvenirPromptComposerPluginProvider, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
            this.f24122a = souvenirPromptComposerPluginProvider;
            this.f24123b = jsonPluginConfigSerializer;
        }

        public final ComposerPluginDefault mo1302a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
            SouvenirPromptComposerPluginProvider souvenirPromptComposerPluginProvider = this.f24122a;
            return new SouvenirPromptComposerPlugin(composerPluginSession, (SouvenirPromptPluginConfig) this.f24123b.a(serializedComposerPluginConfig, SouvenirPromptPluginConfig.class), (Context) souvenirPromptComposerPluginProvider.getInstance(Context.class), PromptPublishIntentHelper.b(souvenirPromptComposerPluginProvider));
        }

        public final String m26242b() {
            return "SOUVENIR_PROMPT_PERSISTENCE_KEY";
        }
    }

    @Inject
    public SouvenirPromptComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, @Assisted SouvenirPromptPluginConfig souvenirPromptPluginConfig, Context context, PromptPublishIntentHelper promptPublishIntentHelper) {
        super(context, composerPluginSession);
        this.f24124a = souvenirPromptPluginConfig;
        this.f24125b = promptPublishIntentHelper;
    }

    @Nullable
    public final ComposerPluginGetters$BooleanGetter mo1334f() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<Intent> mo1327V() {
        return new C21011(this);
    }

    @Nullable
    protected final ComposerPluginGetters$Getter<Bundle> aI() {
        return new C21022(this);
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter aM() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }

    @Nullable
    protected final ComposerPluginGetters$BooleanGetter mo1321M() {
        return ComposerPluginGetters$BooleanGetter.f16887b;
    }
}

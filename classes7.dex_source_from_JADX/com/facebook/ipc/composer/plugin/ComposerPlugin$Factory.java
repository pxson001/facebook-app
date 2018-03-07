package com.facebook.ipc.composer.plugin;

import com.facebook.ipc.composer.intent.HasPersistenceKey;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import javax.annotation.Nullable;

/* compiled from: connection_bandwidth */
public interface ComposerPlugin$Factory extends HasPersistenceKey {
    ComposerPluginDefault mo1302a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState);
}

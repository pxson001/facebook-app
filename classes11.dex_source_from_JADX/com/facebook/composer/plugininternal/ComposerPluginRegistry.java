package com.facebook.composer.plugininternal;

import com.facebook.common.build.BuildConstants;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin.Factory;
import com.facebook.ipc.composer.plugin.ComposerPlugin.InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.STATICDI_MULTIBIND_PROVIDER.ComposerPlugin_Factory;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fontWeight */
public class ComposerPluginRegistry {
    private final Lazy<Set<Factory>> f6855a;
    private final ComposerPluginMock.Factory f6856b;

    public static ComposerPluginRegistry m8201b(InjectorLike injectorLike) {
        return new ComposerPluginRegistry(ProviderLazy.a(new ComposerPlugin_Factory(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), new ComposerPluginMock.Factory((ComposerPluginMockProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerPluginMockProvider.class)));
    }

    @Inject
    public ComposerPluginRegistry(Lazy<Set<Factory>> lazy, ComposerPluginMock.Factory factory) {
        this.f6855a = lazy;
        this.f6856b = factory;
    }

    private Factory m8200a(@Nullable SerializedComposerPluginConfig serializedComposerPluginConfig) {
        if (serializedComposerPluginConfig == null) {
            return this.f6856b;
        }
        for (Factory factory : (Set) this.f6855a.get()) {
            if (serializedComposerPluginConfig.a().equals(factory.b())) {
                return factory;
            }
        }
        throw new IllegalStateException("ComposerPluginRegistry: factory not found for " + serializedComposerPluginConfig.a() + " - did you forget to multi-bind it?");
    }

    private void m8202b(@Nullable SerializedComposerPluginConfig serializedComposerPluginConfig) {
        if (serializedComposerPluginConfig != null) {
            Object obj = null;
            for (Factory factory : (Set) this.f6855a.get()) {
                if (serializedComposerPluginConfig.a().equals(factory.b())) {
                    if (obj == null) {
                        obj = factory;
                    } else {
                        throw new IllegalStateException("ComposerPluginRegistry.verifyNoDuplicates: duplicate ComposerPlugin.Factory for " + serializedComposerPluginConfig.a() + ": " + obj + " and " + factory);
                    }
                }
            }
        }
    }

    public final ComposerPluginDefault m8203a(@Nullable SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable InstanceState instanceState) {
        if (BuildConstants.i) {
            m8202b(serializedComposerPluginConfig);
        }
        return (ComposerPluginDefault) Preconditions.checkNotNull(m8200a(serializedComposerPluginConfig).a(serializedComposerPluginConfig, composerPluginSession, instanceState));
    }
}

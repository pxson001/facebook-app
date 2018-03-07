package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerPluginConfigSerializer.SerializationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: network_info_ms_since_launch */
public class JsonPluginConfigSerializer<T extends ComposerPluginConfig> implements ComposerPluginConfigSerializer<T> {
    private final ObjectMapper f12553a;

    public static JsonPluginConfigSerializer m18629b(InjectorLike injectorLike) {
        return new JsonPluginConfigSerializer(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public JsonPluginConfigSerializer(ObjectMapper objectMapper) {
        this.f12553a = objectMapper;
    }

    public final SerializedComposerPluginConfig mo2485a(T t) {
        try {
            return SerializedComposerPluginConfig.a(t, this.f12553a.m6659a((Object) t));
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }

    public final T m18630a(SerializedComposerPluginConfig serializedComposerPluginConfig, Class<T> cls) {
        Preconditions.checkNotNull(serializedComposerPluginConfig.b());
        try {
            ComposerPluginConfig composerPluginConfig = (ComposerPluginConfig) this.f12553a.m6657a(serializedComposerPluginConfig.b(), (Class) cls);
            Preconditions.checkArgument(serializedComposerPluginConfig.a().equals(composerPluginConfig.b()));
            composerPluginConfig.a();
            return composerPluginConfig;
        } catch (Throwable e) {
            throw new SerializationException(e);
        }
    }

    public static JsonPluginConfigSerializer m18628a(InjectorLike injectorLike) {
        return m18629b(injectorLike);
    }
}

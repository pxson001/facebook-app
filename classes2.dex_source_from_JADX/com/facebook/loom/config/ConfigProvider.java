package com.facebook.loom.config;

import javax.annotation.Nullable;

/* compiled from: zero_rating2/clearable/default_optin/primary_button_text_key */
public interface ConfigProvider {

    /* compiled from: zero_rating2/clearable/default_optin/primary_button_text_key */
    public interface ConfigUpdateListener {
        void m920a(Config config);
    }

    void mo63a(@Nullable ConfigUpdateListener configUpdateListener);

    Config mo64b();
}

package com.facebook.composer.capability;

import com.facebook.config.application.Product;
import com.facebook.transliteration.TransliterationConfig;
import javax.inject.Inject;

/* compiled from: core_attribute_truncation_lines */
public class ComposerTransliterationCapability {
    public final Product f16704a;
    public final TransliterationConfig f16705b;

    @Inject
    public ComposerTransliterationCapability(Product product, TransliterationConfig transliterationConfig) {
        this.f16704a = product;
        this.f16705b = transliterationConfig;
    }
}

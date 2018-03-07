package com.facebook.common.locale;

import com.facebook.inject.AbstractProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.text.Collator;

/* compiled from: read_write_failure_count */
public class Collator_ForPrimaryCanonicalDecompositionMethodAutoProvider extends AbstractProvider<Collator> {
    public Object get() {
        return LocaleModule.m4192b(LocaleMethodAutoProvider.b(this));
    }
}

package com.facebook.common.locale;

import com.facebook.inject.AbstractProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.text.Collator;

/* compiled from: skip */
public class CollatorMethodAutoProvider extends AbstractProvider<Collator> {
    public Object get() {
        return LocaleModule.a(LocaleMethodAutoProvider.b(this));
    }
}

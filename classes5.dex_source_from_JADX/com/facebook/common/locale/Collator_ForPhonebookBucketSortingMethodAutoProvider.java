package com.facebook.common.locale;

import com.facebook.inject.AbstractProvider;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.text.Collator;

/* compiled from: single_unit */
public class Collator_ForPhonebookBucketSortingMethodAutoProvider extends AbstractProvider<Collator> {
    public Object get() {
        return LocaleModule.c(LocaleMethodAutoProvider.b(this));
    }
}

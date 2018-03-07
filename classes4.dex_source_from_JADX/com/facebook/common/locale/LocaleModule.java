package com.facebook.common.locale;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.text.Collator;
import java.util.Locale;

@InjectorModule
/* compiled from: read_sms_last_scan_time */
public class LocaleModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static Collator m4191a(Locale locale) {
        return Collator.getInstance(locale);
    }

    @ProviderMethod
    @ForPrimaryCanonicalDecomposition
    public static Collator m4192b(Locale locale) {
        Collator instance = Collator.getInstance(locale);
        instance.setStrength(0);
        instance.setDecomposition(1);
        return instance;
    }

    @ForPhonebookBucketSorting
    @ProviderMethod
    public static Collator m4193c(Locale locale) {
        String locale2 = locale.toString();
        if ("ja".equalsIgnoreCase(locale2) || "ja_JP".equalsIgnoreCase(locale2)) {
            locale = new Locale("ja@collation=phonebook");
        }
        return Collator.getInstance(locale);
    }
}

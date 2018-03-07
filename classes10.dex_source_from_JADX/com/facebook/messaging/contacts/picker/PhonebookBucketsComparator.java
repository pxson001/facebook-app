package com.facebook.messaging.contacts.picker;

import com.facebook.common.locale.LocaleModule;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.google.common.base.Strings;
import java.text.Collator;
import java.util.Comparator;
import javax.inject.Inject;

/* compiled from: tap_bymm */
public class PhonebookBucketsComparator implements Comparator<ContactAlphabeticIndexBucket> {
    private final Collator f2052a;

    private static PhonebookBucketsComparator m1881b(InjectorLike injectorLike) {
        return new PhonebookBucketsComparator(LocaleModule.c(LocaleMethodAutoProvider.b(injectorLike)));
    }

    public int compare(Object obj, Object obj2) {
        ContactAlphabeticIndexBucket contactAlphabeticIndexBucket = (ContactAlphabeticIndexBucket) obj2;
        String str = ((ContactAlphabeticIndexBucket) obj).f1780a;
        String str2 = contactAlphabeticIndexBucket.f1780a;
        if (Strings.isNullOrEmpty(str) && Strings.isNullOrEmpty(str2)) {
            return 0;
        }
        if (Strings.isNullOrEmpty(str)) {
            return 1;
        }
        if (Strings.isNullOrEmpty(str2)) {
            return -1;
        }
        return this.f2052a.compare(str, str2);
    }

    @Inject
    public PhonebookBucketsComparator(Collator collator) {
        this.f2052a = collator;
    }
}

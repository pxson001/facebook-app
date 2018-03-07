package com.facebook.search.bootstrap.common.normalizer;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.bootstrap.common.phonetic.PhoneticNameToNameConverter;
import com.facebook.search.util.text.TextToNormalizedWordsUtil;
import com.facebook.user.names.ContactNameLookupBuilder;
import com.facebook.user.names.NameNormalizer;
import com.facebook.user.names.Normalizer;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_has_empty_catalog */
public class NormalizedTokenHelper {
    public final Provider<ContactNameLookupBuilder> f15579a;
    private final PhoneticNameToNameConverter f15580b;
    public final TextToNormalizedWordsUtil f15581c;
    public final NameNormalizer f15582d;
    public final QeAccessor f15583e;

    public static NormalizedTokenHelper m23188b(InjectorLike injectorLike) {
        return new NormalizedTokenHelper(IdBasedProvider.a(injectorLike, 3603), new PhoneticNameToNameConverter(), NameNormalizer.b(injectorLike), TextToNormalizedWordsUtil.m23590b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NormalizedTokenHelper(Provider<ContactNameLookupBuilder> provider, PhoneticNameToNameConverter phoneticNameToNameConverter, Normalizer normalizer, TextToNormalizedWordsUtil textToNormalizedWordsUtil, QeAccessor qeAccessor) {
        this.f15579a = provider;
        this.f15580b = phoneticNameToNameConverter;
        this.f15581c = textToNormalizedWordsUtil;
        this.f15582d = normalizer;
        this.f15583e = qeAccessor;
    }
}

package com.facebook.common.i18n;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.util.List;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import javax.inject.Provider;

@Immutable
/* compiled from: setVideoResolution */
public final class I18nJoiner {
    private final Resources f2405a;
    private final Provider<Locale> f2406b;

    public static I18nJoiner m2675b(InjectorLike injectorLike) {
        return new I18nJoiner(IdBasedProvider.a(injectorLike, 4483), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public I18nJoiner(Provider<Locale> provider, Resources resources) {
        this.f2406b = provider;
        this.f2405a = resources;
    }

    public final char m2678a() {
        if (LanguageNameFormats.d.contains(((Locale) this.f2406b.get()).getLanguage())) {
            return '、';
        }
        return ',';
    }

    public final String m2681b() {
        String language = ((Locale) this.f2406b.get()).getLanguage();
        char a = m2678a();
        if (LanguageNameFormats.e.contains(language)) {
            return Character.toString(a);
        }
        return a + " ";
    }

    public final String m2679a(List<String> list) {
        return m2677c(list);
    }

    public final String m2680a(List<String> list, int i) {
        if (i == 0) {
            return m2676b((List) list);
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return this.f2405a.getQuantityString(2131689480, i, new Object[]{m2677c(list), Integer.valueOf(i)});
    }

    private String m2676b(List<String> list) {
        switch (list.size()) {
            case 0:
                throw new IllegalArgumentException();
            case 1:
                return (String) list.get(0);
            default:
                return this.f2405a.getString(2131230953, new Object[]{m2677c(list.subList(0, r0 - 1)), list.get(r0 - 1)});
        }
    }

    private String m2677c(List<String> list) {
        int size = list.size();
        switch (size) {
            case 0:
                throw new IllegalArgumentException();
            case 1:
                return (String) list.get(0);
            default:
                String str = (String) list.get(0);
                for (int i = 1; i < size; i++) {
                    String str2 = (String) list.get(i);
                    str = this.f2405a.getString(2131230952, new Object[]{str, str2});
                }
                return str;
        }
    }
}

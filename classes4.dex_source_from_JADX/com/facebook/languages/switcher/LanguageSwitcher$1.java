package com.facebook.languages.switcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.languages.switcher.protocol.SuggestedLocalesResult;
import com.facebook.languages.switcher.protocol.SuggestedLocalesResult.LocaleModel;
import com.facebook.languages.switchercommon.LanguageSwitcherCommon;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: topContacts */
class LanguageSwitcher$1 implements Callable<ImmutableList<String>> {
    final /* synthetic */ LanguageSwitcher f920a;

    LanguageSwitcher$1(LanguageSwitcher languageSwitcher) {
        this.f920a = languageSwitcher;
    }

    public Object call() {
        int i;
        int i2 = 0;
        List<String> a = Lists.a();
        a.add(this.f920a.d.a().toString());
        try {
            SuggestedLocalesResult suggestedLocalesResult = (SuggestedLocalesResult) ((AbstractSingleMethodRunner) this.f920a.j.get()).a(this.f920a.k, null, CallerContext.b(LanguageSwitcher.class, LanguageSwitcher.class.getName()));
            if (suggestedLocalesResult != null) {
                ImmutableList immutableList = suggestedLocalesResult.locales;
                int size = immutableList.size();
                for (i = 0; i < size; i++) {
                    a.add(((LocaleModel) immutableList.get(i)).locale);
                }
            }
        } catch (Throwable e) {
            BLog.b(LanguageSwitcher.class, "Error fetching suggested locales", e);
        }
        ImmutableCollection d = this.f920a.d();
        Collection a2 = Lists.a();
        for (String str : a) {
            LanguageSwitcher.d(this.f920a);
            String str2 = LanguageSwitcherCommon.a(d, str2);
            if (str2 != null) {
                a2.add(str2);
            }
        }
        while (i2 < a2.size()) {
            for (i = a2.size() - 1; i > i2; i--) {
                if (((String) a2.get(i2)).equals(a2.get(i))) {
                    a2.remove(i);
                }
            }
            i2++;
        }
        return ImmutableList.copyOf(a2);
    }
}

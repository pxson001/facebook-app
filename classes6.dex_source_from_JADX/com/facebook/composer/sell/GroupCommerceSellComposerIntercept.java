package com.facebook.composer.sell;

import com.facebook.common.locale.Locales;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec$ProvidesConfiguration;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: photo_picker_gallery_rotate_photo */
public class GroupCommerceSellComposerIntercept<DataProvider extends ProvidesTextWithEntities & ComposerConfigurationSpec$ProvidesConfiguration> {
    private static final Pattern f8078a = Pattern.compile("\\d+");
    private final GatekeeperStoreImpl f8079b;
    public Locales f8080c;

    @Inject
    public GroupCommerceSellComposerIntercept(GatekeeperStoreImpl gatekeeperStoreImpl, Locales locales) {
        this.f8079b = gatekeeperStoreImpl;
        this.f8080c = locales;
    }

    public final boolean m11667a(DataProvider dataProvider) {
        if (this.f8079b.a(ComposerGatekeepers.f, false) && !Strings.isNullOrEmpty(((ComposerConfigurationSpec$ProvidesConfiguration) dataProvider).m18230o().getCommerceInfo().getCurrencyCode())) {
            Object a = dataProvider.ae().a();
            List a2 = m11665a(Currency.getInstance(((ComposerConfigurationSpec$ProvidesConfiguration) dataProvider).m18230o().getCommerceInfo().getCurrencyCode()).getSymbol(this.f8080c.a()), a);
            ImmutableList interceptWords = ((ComposerConfigurationSpec$ProvidesConfiguration) dataProvider).m18230o().getCommerceInfo().getInterceptWords();
            List arrayList = new ArrayList();
            if (!Strings.isNullOrEmpty(a)) {
                int size = interceptWords.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) interceptWords.get(i);
                    if (Pattern.compile("\\b" + Pattern.quote(str) + "\\b", 2).matcher(a).find()) {
                        arrayList.add(str);
                    }
                }
            }
            List list = arrayList;
            List b = m11666b(((ComposerConfigurationSpec$ProvidesConfiguration) dataProvider).m18230o().getCommerceInfo().getInterceptWordsAfterNumber(), a);
            if (!(a2.isEmpty() && list.isEmpty() && b.isEmpty())) {
                return true;
            }
        }
        return false;
    }

    private static List<String> m11666b(ImmutableList<? extends String> immutableList, String str) {
        List<String> arrayList = new ArrayList();
        if (!Strings.isNullOrEmpty(str)) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str2 = (String) immutableList.get(i);
                if (Pattern.compile("\\b\\d+\\s?" + Pattern.quote(str2) + "\\b", 2).matcher(str).find()) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static List<String> m11665a(String str, String str2) {
        List<String> arrayList = new ArrayList();
        if (!Strings.isNullOrEmpty(str2)) {
            Matcher matcher = Pattern.compile(Pattern.quote(str.toString()) + "\\s*\\d+", 2).matcher(str2);
            while (matcher.find()) {
                Matcher matcher2 = f8078a.matcher(matcher.group());
                if (matcher2.find()) {
                    arrayList.add(matcher2.group());
                }
            }
            matcher = Pattern.compile("\\d+(?=\\s*" + Pattern.quote(str.toString()) + ")", 2).matcher(str2);
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
        }
        return arrayList;
    }
}

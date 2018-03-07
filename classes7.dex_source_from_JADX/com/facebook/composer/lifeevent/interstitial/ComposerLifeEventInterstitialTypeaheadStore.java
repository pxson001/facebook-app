package com.facebook.composer.lifeevent.interstitial;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: copyright_monitor_violated */
public class ComposerLifeEventInterstitialTypeaheadStore {
    public ImmutableListMultimap<String, TypeAheadSuggestionFieldsModel> f16752a = EmptyImmutableListMultimap.a;

    public final void m20777a(String str, List<TypeAheadSuggestionFieldsModel> list) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f16752a = new Builder().a(this.f16752a).a(str, list).a();
    }

    public final ImmutableList<TypeAheadSuggestionFieldsModel> m20778b(String str) {
        if (StringUtil.a(str)) {
            return RegularImmutableList.a;
        }
        Collection<TypeAheadSuggestionFieldsModel> a = Lists.a(this.f16752a.e(str));
        Iterator it = this.f16752a.w().iterator();
        while (it.hasNext()) {
            TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel = (TypeAheadSuggestionFieldsModel) it.next();
            if (!a.contains(typeAheadSuggestionFieldsModel)) {
                Object obj;
                for (TypeAheadSuggestionFieldsModel k : a) {
                    if (k.k().equals(typeAheadSuggestionFieldsModel.k())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    String a2 = StringLocaleUtil.a(typeAheadSuggestionFieldsModel.k());
                    String a3 = StringLocaleUtil.a(str);
                    for (String startsWith : a2.split("\\s")) {
                        if (startsWith.startsWith(a3) || a2.startsWith(a3)) {
                            a.add(typeAheadSuggestionFieldsModel);
                            break;
                        }
                    }
                }
            }
        }
        return ImmutableList.copyOf(a);
    }
}

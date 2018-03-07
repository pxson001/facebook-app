package com.facebook.search.model.converter;

import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.NullStateModuleCollectionUnit;
import com.facebook.search.model.NullStateModuleCollectionUnit.Builder;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.nullstate.NullStateModuleData;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel.ModulesModel;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel.ModulesModel.SuggestionsModel;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: interstitials_fetch_and_update */
public class NullStateModuleConverter {
    private final GraphSearchErrorReporter f19651a;

    @Inject
    public NullStateModuleConverter(GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f19651a = graphSearchErrorReporter;
    }

    @Nullable
    public final NullStateModuleData m27378a(ProviderModel providerModel) {
        NullStateModuleData nullStateModuleData = new NullStateModuleData();
        if (providerModel == null) {
            try {
                throw new GraphSearchException(GraphSearchError.FETCH_NULL_STATE_MODULES_FAIL, "Missing provider");
            } catch (GraphSearchException e) {
                this.f19651a.m27367a(e);
            }
        } else {
            List<ModulesModel> a = providerModel.a();
            if (a.isEmpty()) {
                return new NullStateModuleData();
            }
            for (ModulesModel modulesModel : a) {
                nullStateModuleData.a(m27377a(modulesModel), modulesModel.o());
            }
            return nullStateModuleData;
        }
    }

    private static NullStateModuleCollectionUnit m27377a(ModulesModel modulesModel) {
        Builder a = new Builder().a(modulesModel.l());
        a.b = modulesModel.k();
        a = a;
        a.c = modulesModel.n();
        a = a;
        a.d = modulesModel.a();
        a = a;
        List<SuggestionsModel> m = modulesModel.m();
        String l = modulesModel.l();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (SuggestionsModel suggestionsModel : m) {
            if (!(suggestionsModel.l() == null || suggestionsModel.l().a() == null || suggestionsModel.l().j() == null)) {
                String p;
                NullStateModuleSuggestionUnit.Builder builder2 = new NullStateModuleSuggestionUnit.Builder();
                if (suggestionsModel.p() != null) {
                    p = suggestionsModel.p();
                } else {
                    p = l;
                }
                builder2.a = NullStateModuleSuggestionUnit.Builder.m(p);
                NullStateModuleSuggestionUnit.Builder builder3 = builder2;
                builder3.b = suggestionsModel.q();
                builder3 = builder3;
                builder3.c = suggestionsModel.o();
                builder3 = builder3;
                builder3.d = suggestionsModel.n();
                builder3 = builder3;
                builder3.e = suggestionsModel.m();
                builder2 = builder3;
                if (suggestionsModel.a() != null) {
                    p = suggestionsModel.a().j();
                } else {
                    p = null;
                }
                builder2.f = p;
                builder2 = builder2;
                if (suggestionsModel.a() != null) {
                    p = suggestionsModel.a().k();
                } else {
                    p = null;
                }
                builder2.g = p;
                builder3 = builder2;
                builder3.h = suggestionsModel.l().a();
                builder3 = builder3;
                builder3.i = suggestionsModel.l().j().a();
                builder2 = builder3;
                if (suggestionsModel.k() != null) {
                    p = suggestionsModel.k().a();
                } else {
                    p = null;
                }
                builder2.j = p;
                builder3 = builder2;
                builder3.k = suggestionsModel.r();
                builder3 = builder3;
                builder3.l = suggestionsModel.j();
                NullStateModuleSuggestionUnit.Builder builder4 = builder3;
                builder4.m = NullStateModuleSuggestionUnit.Builder.m(l);
                builder.m1069c(new NullStateModuleSuggestionUnit(builder4));
            }
        }
        a.e = builder.m1068b();
        a = a;
        a.f = modulesModel.j();
        return a.a();
    }
}

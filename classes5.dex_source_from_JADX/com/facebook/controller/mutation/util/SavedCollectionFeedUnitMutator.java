package com.facebook.controller.mutation.util;

import android.annotation.SuppressLint;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit$Builder;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.PropertyBag;
import com.facebook.graphql.model.SavedCollectionFeedUnitHelper;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: access_points */
public class SavedCollectionFeedUnitMutator {
    private final ActionLinkListMutator f11740a;

    public static SavedCollectionFeedUnitMutator m19785b(InjectorLike injectorLike) {
        return new SavedCollectionFeedUnitMutator(ActionLinkListMutator.a(injectorLike));
    }

    @Inject
    public SavedCollectionFeedUnitMutator(ActionLinkListMutator actionLinkListMutator) {
        this.f11740a = actionLinkListMutator;
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public final GraphQLSavedCollectionFeedUnit m19786a(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit, ImmutableMap<String, Boolean> immutableMap) {
        if (immutableMap.isEmpty()) {
            return graphQLSavedCollectionFeedUnit;
        }
        GraphQLSavedCollectionFeedUnit$Builder graphQLSavedCollectionFeedUnit$Builder = new GraphQLSavedCollectionFeedUnit$Builder();
        graphQLSavedCollectionFeedUnit.h();
        graphQLSavedCollectionFeedUnit$Builder.f12956d = graphQLSavedCollectionFeedUnit.t();
        graphQLSavedCollectionFeedUnit$Builder.f12957e = graphQLSavedCollectionFeedUnit.g();
        graphQLSavedCollectionFeedUnit$Builder.f12958f = graphQLSavedCollectionFeedUnit.S_();
        graphQLSavedCollectionFeedUnit$Builder.f12959g = graphQLSavedCollectionFeedUnit.T_();
        graphQLSavedCollectionFeedUnit$Builder.f12960h = graphQLSavedCollectionFeedUnit.u();
        graphQLSavedCollectionFeedUnit$Builder.f12961i = graphQLSavedCollectionFeedUnit.D();
        graphQLSavedCollectionFeedUnit$Builder.f12962j = graphQLSavedCollectionFeedUnit.E();
        graphQLSavedCollectionFeedUnit$Builder.f12963k = graphQLSavedCollectionFeedUnit.F();
        graphQLSavedCollectionFeedUnit$Builder.f12964l = graphQLSavedCollectionFeedUnit.x();
        graphQLSavedCollectionFeedUnit$Builder.f12965m = graphQLSavedCollectionFeedUnit.y();
        graphQLSavedCollectionFeedUnit$Builder.f12966n = graphQLSavedCollectionFeedUnit.z();
        graphQLSavedCollectionFeedUnit$Builder.f12967o = graphQLSavedCollectionFeedUnit.A();
        graphQLSavedCollectionFeedUnit$Builder.f12968p = graphQLSavedCollectionFeedUnit.B();
        graphQLSavedCollectionFeedUnit$Builder.f12969q = graphQLSavedCollectionFeedUnit.C();
        graphQLSavedCollectionFeedUnit$Builder.f12970r = graphQLSavedCollectionFeedUnit.k();
        Builder.a(graphQLSavedCollectionFeedUnit$Builder, graphQLSavedCollectionFeedUnit);
        graphQLSavedCollectionFeedUnit$Builder.f12971s = (PropertyBag) graphQLSavedCollectionFeedUnit.U_().clone();
        GraphQLSavedCollectionFeedUnit$Builder graphQLSavedCollectionFeedUnit$Builder2 = graphQLSavedCollectionFeedUnit$Builder;
        ImmutableList a = SavedCollectionFeedUnitHelper.m22573a(graphQLSavedCollectionFeedUnit);
        if (!a.isEmpty()) {
            ImmutableList.Builder builder = ImmutableList.builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(m19784a((GraphQLSavedCollectionFeedUnitItem) a.get(i), (ImmutableMap) immutableMap));
            }
            graphQLSavedCollectionFeedUnit$Builder2.f12966n = builder.b();
        }
        graphQLSavedCollectionFeedUnit$Builder2.f12959g = System.currentTimeMillis();
        return new GraphQLSavedCollectionFeedUnit(graphQLSavedCollectionFeedUnit$Builder2);
    }

    public static SavedCollectionFeedUnitMutator m19783a(InjectorLike injectorLike) {
        return m19785b(injectorLike);
    }

    private GraphQLSavedCollectionFeedUnitItem m19784a(GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem, ImmutableMap<String, Boolean> immutableMap) {
        if (immutableMap.isEmpty()) {
            return graphQLSavedCollectionFeedUnitItem;
        }
        GraphQLSavedCollectionFeedUnitItem.Builder builder = new GraphQLSavedCollectionFeedUnitItem.Builder();
        graphQLSavedCollectionFeedUnitItem.h();
        builder.f12972d = graphQLSavedCollectionFeedUnitItem.m21539j();
        builder.f12973e = graphQLSavedCollectionFeedUnitItem.m21541l();
        builder.f12974f = graphQLSavedCollectionFeedUnitItem.m21542m();
        builder.f12975g = graphQLSavedCollectionFeedUnitItem.m21543n();
        builder.f12976h = graphQLSavedCollectionFeedUnitItem.m21544o();
        builder.f12977i = graphQLSavedCollectionFeedUnitItem.m21545p();
        builder.f12978j = graphQLSavedCollectionFeedUnitItem.m21540k();
        Builder.a(builder, graphQLSavedCollectionFeedUnitItem);
        builder.f12979k = (PropertyBag) graphQLSavedCollectionFeedUnitItem.U_().clone();
        GraphQLSavedCollectionFeedUnitItem.Builder builder2 = builder;
        builder2.f12972d = this.f11740a.a(graphQLSavedCollectionFeedUnitItem.m21539j(), immutableMap);
        return new GraphQLSavedCollectionFeedUnitItem(builder2);
    }
}

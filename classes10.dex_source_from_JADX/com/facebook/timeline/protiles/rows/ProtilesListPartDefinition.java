package com.facebook.timeline.protiles.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.rows.ProtilesListRowPartDefinition.Props;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fbplatdialog */
public class ProtilesListPartDefinition<E extends HasImageLoadListener & CanFriendPerson & HasPrefetcher> extends BaseMultiRowGroupPartDefinition<ProtileModel, Void, E> {
    private static ProtilesListPartDefinition f12265d;
    private static final Object f12266e = new Object();
    private final ProtilesListRowPartDefinition f12267a;
    private final TimelineCollapsedProtilesExperimentHelper f12268b;
    private final QeAccessor f12269c;

    private static ProtilesListPartDefinition m12334b(InjectorLike injectorLike) {
        return new ProtilesListPartDefinition(ProtilesListRowPartDefinition.m12339a(injectorLike), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m12335a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtileModel protileModel = (ProtileModel) obj;
        List list = protileModel.f12107c;
        for (int i = 0; i < list.size(); i++) {
            baseMultiRowSubParts.a(this.f12267a, new Props(protileModel, (ProtileItemFieldsModel) list.get(i)));
        }
        return null;
    }

    public final boolean m12336a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return protileModel.m12109b() == GraphQLProfileTileSectionType.FRIENDS && !this.f12268b.m12445c(protileModel) && this.f12269c.a(ExperimentsForTimelineAbTestModule.aZ, false);
    }

    @Inject
    public ProtilesListPartDefinition(ProtilesListRowPartDefinition protilesListRowPartDefinition, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper, QeAccessor qeAccessor) {
        this.f12267a = protilesListRowPartDefinition;
        this.f12268b = timelineCollapsedProtilesExperimentHelper;
        this.f12269c = qeAccessor;
    }

    public static ProtilesListPartDefinition m12333a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12266e) {
                ProtilesListPartDefinition protilesListPartDefinition;
                if (a2 != null) {
                    protilesListPartDefinition = (ProtilesListPartDefinition) a2.a(f12266e);
                } else {
                    protilesListPartDefinition = f12265d;
                }
                if (protilesListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12334b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12266e, b3);
                        } else {
                            f12265d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

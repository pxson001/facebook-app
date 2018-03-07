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
import com.facebook.timeline.protiles.model.ProtilesGridRowData;
import com.facebook.timeline.protiles.model.ProtilesGridRowData.ViewPosition;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fe61b85006dc5373c8818a51cba90d5d */
public class ProtilesGridPartDefinition<E extends HasImageLoadListener & CanFriendPerson & HasPrefetcher> extends BaseMultiRowGroupPartDefinition<ProtileModel, Void, E> {
    private static ProtilesGridPartDefinition f12204d;
    private static final Object f12205e = new Object();
    private final ProtilesSingleRowPartDefinition f12206a;
    private final TimelineCollapsedProtilesExperimentHelper f12207b;
    private final QeAccessor f12208c;

    private static ProtilesGridPartDefinition m12301b(InjectorLike injectorLike) {
        return new ProtilesGridPartDefinition(ProtilesSingleRowPartDefinition.m12380a(injectorLike), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m12302a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtileModel protileModel = (ProtileModel) obj;
        List a = Lists.a(protileModel.f12107c, 3);
        for (int i = 0; i < a.size(); i++) {
            ViewPosition viewPosition;
            int size = a.size();
            if (i == 0) {
                viewPosition = ViewPosition.TOP_ROW;
            } else if (i == size - 1) {
                viewPosition = ViewPosition.BOTTOM_ROW;
            } else {
                viewPosition = ViewPosition.MIDDLE_ROW;
            }
            baseMultiRowSubParts.a(this.f12206a, new ProtilesGridRowData(protileModel, viewPosition, (List) a.get(i)));
        }
        return null;
    }

    public final boolean m12303a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return (protileModel.m12109b() != GraphQLProfileTileSectionType.FRIENDS || this.f12207b.m12445c(protileModel) || this.f12208c.a(ExperimentsForTimelineAbTestModule.aZ, false)) ? false : true;
    }

    @Inject
    public ProtilesGridPartDefinition(ProtilesSingleRowPartDefinition protilesSingleRowPartDefinition, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper, QeAccessor qeAccessor) {
        this.f12206a = protilesSingleRowPartDefinition;
        this.f12207b = timelineCollapsedProtilesExperimentHelper;
        this.f12208c = qeAccessor;
    }

    public static ProtilesGridPartDefinition m12300a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesGridPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12205e) {
                ProtilesGridPartDefinition protilesGridPartDefinition;
                if (a2 != null) {
                    protilesGridPartDefinition = (ProtilesGridPartDefinition) a2.a(f12205e);
                } else {
                    protilesGridPartDefinition = f12204d;
                }
                if (protilesGridPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12301b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12205e, b3);
                        } else {
                            f12204d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesGridPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

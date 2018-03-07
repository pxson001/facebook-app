package com.facebook.feedplugins.graphqlstory.footer.util;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.video.abtest.ExperimentsForFeedpluginVideoAbTestModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TE;TV;>; */
public class CrosspostedVideoViewCountTooltipUtil {
    private static CrosspostedVideoViewCountTooltipUtil f351b;
    private static final Object f352c = new Object();
    private final QeAccessor f353a;

    private static CrosspostedVideoViewCountTooltipUtil m316b(InjectorLike injectorLike) {
        return new CrosspostedVideoViewCountTooltipUtil((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CrosspostedVideoViewCountTooltipUtil(QeAccessor qeAccessor) {
        this.f353a = qeAccessor;
    }

    @Nullable
    public final OnClickListener m317a(GraphQLStoryAttachment graphQLStoryAttachment) {
        boolean z = true;
        if (graphQLStoryAttachment.r().bA() <= 1) {
            z = false;
        }
        return (z && this.f353a.a(ExperimentsForFeedpluginVideoAbTestModule.a, false)) ? new 1(this, graphQLStoryAttachment) : null;
    }

    public static CrosspostedVideoViewCountTooltipUtil m314a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CrosspostedVideoViewCountTooltipUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f352c) {
                CrosspostedVideoViewCountTooltipUtil crosspostedVideoViewCountTooltipUtil;
                if (a2 != null) {
                    crosspostedVideoViewCountTooltipUtil = (CrosspostedVideoViewCountTooltipUtil) a2.a(f352c);
                } else {
                    crosspostedVideoViewCountTooltipUtil = f351b;
                }
                if (crosspostedVideoViewCountTooltipUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m316b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f352c, b3);
                        } else {
                            f351b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = crosspostedVideoViewCountTooltipUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static String m315a(int i, int i2, int i3, Context context) {
        String str = context.getResources().getQuantityString(2131689552, i, new Object[]{Integer.valueOf(i)}) + "\n";
        switch (i2 - i) {
            case 0:
                return str + context.getResources().getQuantityString(2131689553, i3);
            case 1:
                return str + context.getResources().getQuantityString(2131689554, i3, new Object[]{Integer.valueOf(i3)});
            default:
                return str + context.getResources().getQuantityString(2131689555, i3, new Object[]{Integer.valueOf(r1), Integer.valueOf(i3)});
        }
    }
}

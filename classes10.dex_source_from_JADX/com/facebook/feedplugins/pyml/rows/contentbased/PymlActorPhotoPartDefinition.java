package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.ContentBasedPageYouMayLikeView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

@ContextScoped
/* compiled from: android.intent.extra.ALLOW_REPLACE */
public class PymlActorPhotoPartDefinition extends BaseSinglePartDefinition<SuggestedPageUnitItem, Uri, AnyEnvironment, ContentBasedPageYouMayLikeView> {
    private static PymlActorPhotoPartDefinition f19876a;
    private static final Object f19877b = new Object();

    private static PymlActorPhotoPartDefinition m20091a() {
        return new PymlActorPhotoPartDefinition();
    }

    public final Object m20093a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLImage b = EgoUnitUtil.b((SuggestedPageUnitItem) obj);
        return b != null ? ImageUtil.a(b) : null;
    }

    public final /* bridge */ /* synthetic */ void m20094a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1542607927);
        ContentBasedPageYouMayLikeView contentBasedPageYouMayLikeView = (ContentBasedPageYouMayLikeView) view;
        contentBasedPageYouMayLikeView.e.a((Uri) obj2, ContentBasedPagesYouMayLikeHScrollPartDefinition.f19852a);
        Logger.a(8, EntryType.MARK_POP, -1733839352, a);
    }

    public static PymlActorPhotoPartDefinition m20092a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlActorPhotoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f19877b) {
                PymlActorPhotoPartDefinition pymlActorPhotoPartDefinition;
                if (a3 != null) {
                    pymlActorPhotoPartDefinition = (PymlActorPhotoPartDefinition) a3.a(f19877b);
                } else {
                    pymlActorPhotoPartDefinition = f19876a;
                }
                if (pymlActorPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m20091a();
                        if (a3 != null) {
                            a3.a(f19877b, a2);
                        } else {
                            f19876a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = pymlActorPhotoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

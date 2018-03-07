package com.facebook.feedplugins.loadingindicator;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: friends_center_invites_tab */
public class LoadingCoverPhotoPartDefinition extends MultiRowSinglePartDefinition<Float, Void, AnyEnvironment, FbDraweeView> {
    public static final ViewType<FbDraweeView> f12885a = new C13411();
    private static LoadingCoverPhotoPartDefinition f12886b;
    private static final Object f12887c = new Object();

    /* compiled from: friends_center_invites_tab */
    final class C13411 extends ViewType<FbDraweeView> {
        C13411() {
        }

        public final /* synthetic */ View m14640a(Context context) {
            return m14639b(context);
        }

        private FbDraweeView m14639b(Context context) {
            return m14639b(context);
        }
    }

    private static LoadingCoverPhotoPartDefinition m14642c() {
        return new LoadingCoverPhotoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m14644a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1869498954);
        Float f = (Float) obj;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(fbDraweeView.getContext().getResources().getDrawable(2130844043), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(fbDraweeView.getContext().getResources());
        genericDraweeHierarchyBuilder.f = autoRotateDrawable;
        fbDraweeView.setHierarchy(genericDraweeHierarchyBuilder.u());
        fbDraweeView.setAspectRatio(f.floatValue());
        Logger.a(8, EntryType.MARK_POP, -1647375570, a);
    }

    public final ViewType<FbDraweeView> m14643a() {
        return f12885a;
    }

    public final boolean m14645a(Object obj) {
        return true;
    }

    public static LoadingCoverPhotoPartDefinition m14641a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoadingCoverPhotoPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12887c) {
                LoadingCoverPhotoPartDefinition loadingCoverPhotoPartDefinition;
                if (a2 != null) {
                    loadingCoverPhotoPartDefinition = (LoadingCoverPhotoPartDefinition) a2.a(f12887c);
                } else {
                    loadingCoverPhotoPartDefinition = f12886b;
                }
                if (loadingCoverPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m14642c();
                        if (a2 != null) {
                            a2.a(f12887c, c);
                        } else {
                            f12886b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = loadingCoverPhotoPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}

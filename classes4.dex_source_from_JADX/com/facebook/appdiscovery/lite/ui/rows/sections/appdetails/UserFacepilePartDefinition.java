package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.UserFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.UserFacePileFragmentModel;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.facepile.FacepileView;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@ContextScoped
/* compiled from: nux_eligibility_finish */
public class UserFacepilePartDefinition extends MultiRowSinglePartDefinition<ImmutableList<UserFacePileFragment>, Void, AnyEnvironment, FacepileView> {
    public static final ViewType f6517a = ViewType.a(2130907623);
    private static UserFacepilePartDefinition f6518b;
    private static final Object f6519c = new Object();

    private static UserFacepilePartDefinition m6934c() {
        return new UserFacepilePartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m6937a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1988986201);
        ImmutableList immutableList = (ImmutableList) obj;
        FacepileView facepileView = (FacepileView) view;
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            UserFacePileFragmentModel userFacePileFragmentModel = (UserFacePileFragmentModel) immutableList.get(i);
            if (!(userFacePileFragmentModel.d() == null || StringUtil.a(userFacePileFragmentModel.d().b()))) {
                builder.c(Uri.parse(userFacePileFragmentModel.d().b()));
            }
        }
        facepileView.setFaceUrls(builder.b());
        Logger.a(8, EntryType.MARK_POP, -1922769769, a);
    }

    public final boolean m6938a(Object obj) {
        return !((ImmutableList) obj).isEmpty();
    }

    public final ViewType m6935a() {
        return f6517a;
    }

    public final Object m6936a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }

    public static UserFacepilePartDefinition m6933a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UserFacepilePartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6519c) {
                UserFacepilePartDefinition userFacepilePartDefinition;
                if (a2 != null) {
                    userFacepilePartDefinition = (UserFacepilePartDefinition) a2.a(f6519c);
                } else {
                    userFacepilePartDefinition = f6518b;
                }
                if (userFacepilePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m6934c();
                        if (a2 != null) {
                            a2.a(f6519c, c);
                        } else {
                            f6518b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = userFacepilePartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}

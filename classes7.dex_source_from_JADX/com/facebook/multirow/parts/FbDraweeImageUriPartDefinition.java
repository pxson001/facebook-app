package com.facebook.multirow.parts;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
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
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@ContextScoped
@Deprecated
/* compiled from: num_stars */
public class FbDraweeImageUriPartDefinition extends BaseSinglePartDefinition<UriContextData, Void, AnyEnvironment, FbDraweeView> {
    private static FbDraweeImageUriPartDefinition f7902a;
    private static final Object f7903b = new Object();

    @Immutable
    /* compiled from: num_stars */
    public class UriContextData {
        @Nullable
        public final String f7900a;
        @Nullable
        public final CallerContext f7901b;

        public UriContextData(String str, CallerContext callerContext) {
            this.f7900a = str;
            this.f7901b = callerContext;
        }
    }

    private static FbDraweeImageUriPartDefinition m9533a() {
        return new FbDraweeImageUriPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m9535a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1879969831);
        UriContextData uriContextData = (UriContextData) obj;
        ((FbDraweeView) view).a(Uri.parse(uriContextData.f7900a), uriContextData.f7901b);
        Logger.a(8, EntryType.MARK_POP, -381081372, a);
    }

    public static FbDraweeImageUriPartDefinition m9534a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FbDraweeImageUriPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f7903b) {
                FbDraweeImageUriPartDefinition fbDraweeImageUriPartDefinition;
                if (a3 != null) {
                    fbDraweeImageUriPartDefinition = (FbDraweeImageUriPartDefinition) a3.a(f7903b);
                } else {
                    fbDraweeImageUriPartDefinition = f7902a;
                }
                if (fbDraweeImageUriPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9533a();
                        if (a3 != null) {
                            a3.a(f7903b, a2);
                        } else {
                            f7902a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = fbDraweeImageUriPartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
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
/* compiled from: must be started */
public class InlineComposerProfilePhotoPartDefinition extends BaseSinglePartDefinition<Props, Void, AnyEnvironment, FbDraweeView> {
    public static final CallerContext f13178a = CallerContext.m9061a(InlineComposerProfilePhotoPartDefinition.class, "inline_composer");
    private static InlineComposerProfilePhotoPartDefinition f13179b;
    private static final Object f13180c = new Object();

    @Immutable
    /* compiled from: must be started */
    public class Props {
        public final Uri f14300a;
        @Nullable
        public final OnClickListener f14301b;

        public Props(Uri uri, @Nullable OnClickListener onClickListener) {
            this.f14300a = uri;
            this.f14301b = onClickListener;
        }
    }

    private static InlineComposerProfilePhotoPartDefinition m19374a() {
        return new InlineComposerProfilePhotoPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1084914655);
        Props props = (Props) obj;
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        fbDraweeView.m20507a(props.f14300a, f13178a);
        if (props.f14301b != null) {
            fbDraweeView.setOnClickListener(props.f14301b);
        }
        Logger.a(8, EntryType.MARK_POP, -633734644, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        FbDraweeView fbDraweeView = (FbDraweeView) view;
        if (((Props) obj).f14301b != null) {
            fbDraweeView.setOnClickListener(null);
        }
    }

    public static InlineComposerProfilePhotoPartDefinition m19375a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerProfilePhotoPartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.m1330a(b2);
            synchronized (f13180c) {
                InlineComposerProfilePhotoPartDefinition inlineComposerProfilePhotoPartDefinition;
                if (a3 != null) {
                    inlineComposerProfilePhotoPartDefinition = (InlineComposerProfilePhotoPartDefinition) a3.mo818a(f13180c);
                } else {
                    inlineComposerProfilePhotoPartDefinition = f13179b;
                }
                if (inlineComposerProfilePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        a2 = m19374a();
                        if (a3 != null) {
                            a3.mo822a(f13180c, a2);
                        } else {
                            f13179b = a2;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    a2 = inlineComposerProfilePhotoPartDefinition;
                }
            }
            return a2;
        } finally {
            a.m1505c(b);
        }
    }
}

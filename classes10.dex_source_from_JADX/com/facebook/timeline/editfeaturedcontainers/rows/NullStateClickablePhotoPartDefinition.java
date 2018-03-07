package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getSuggestedBusinesses */
public class NullStateClickablePhotoPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, NullStateEnvironment, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f10820a = ViewType.a(2130905506);
    private static NullStateClickablePhotoPartDefinition f10821d;
    private static final Object f10822e = new Object();
    private final FbDraweePartDefinition<NullStateEnvironment> f10823b;
    private final ClickListenerPartDefinition f10824c;

    /* compiled from: getSuggestedBusinesses */
    public class Props {
        public final com.facebook.multirow.parts.FbDraweePartDefinition.Props f10818a;
        public final OnClickListener f10819b;

        public Props(com.facebook.multirow.parts.FbDraweePartDefinition.Props props, OnClickListener onClickListener) {
            this.f10818a = props;
            this.f10819b = onClickListener;
        }
    }

    private static NullStateClickablePhotoPartDefinition m10946b(InjectorLike injectorLike) {
        return new NullStateClickablePhotoPartDefinition(FbDraweePartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m10948a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131561583, this.f10823b, props.f10818a);
        subParts.a(this.f10824c, props.f10819b);
        return null;
    }

    @Inject
    public NullStateClickablePhotoPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f10823b = fbDraweePartDefinition;
        this.f10824c = clickListenerPartDefinition;
    }

    public final ViewType<CustomFrameLayout> m10947a() {
        return f10820a;
    }

    public static NullStateClickablePhotoPartDefinition m10945a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateClickablePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10822e) {
                NullStateClickablePhotoPartDefinition nullStateClickablePhotoPartDefinition;
                if (a2 != null) {
                    nullStateClickablePhotoPartDefinition = (NullStateClickablePhotoPartDefinition) a2.a(f10822e);
                } else {
                    nullStateClickablePhotoPartDefinition = f10821d;
                }
                if (nullStateClickablePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10946b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10822e, b3);
                        } else {
                            f10821d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateClickablePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

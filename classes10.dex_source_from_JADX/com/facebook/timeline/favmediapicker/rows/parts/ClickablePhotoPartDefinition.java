package com.facebook.timeline.favmediapicker.rows.parts;

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
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_settings_location_settings */
public class ClickablePhotoPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, Void, FavoriteMediaPickerEnvironment, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f11066a = ViewType.a(2130904247);
    private static ClickablePhotoPartDefinition f11067d;
    private static final Object f11068e = new Object();
    private final FbDraweePartDefinition<FavoriteMediaPickerEnvironment> f11069b;
    private final ClickListenerPartDefinition f11070c;

    /* compiled from: friends_nearby_settings_location_settings */
    public class Props {
        public final com.facebook.multirow.parts.FbDraweePartDefinition.Props f11064a;
        public final OnClickListener f11065b;

        public Props(com.facebook.multirow.parts.FbDraweePartDefinition.Props props, OnClickListener onClickListener) {
            this.f11064a = props;
            this.f11065b = onClickListener;
        }
    }

    private static ClickablePhotoPartDefinition m11236b(InjectorLike injectorLike) {
        return new ClickablePhotoPartDefinition(FbDraweePartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m11238a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(2131561583, this.f11069b, props.f11064a);
        subParts.a(this.f11070c, props.f11065b);
        return null;
    }

    @Inject
    public ClickablePhotoPartDefinition(FbDraweePartDefinition fbDraweePartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f11069b = fbDraweePartDefinition;
        this.f11070c = clickListenerPartDefinition;
    }

    public final ViewType<CustomFrameLayout> m11237a() {
        return f11066a;
    }

    public static ClickablePhotoPartDefinition m11235a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ClickablePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11068e) {
                ClickablePhotoPartDefinition clickablePhotoPartDefinition;
                if (a2 != null) {
                    clickablePhotoPartDefinition = (ClickablePhotoPartDefinition) a2.a(f11068e);
                } else {
                    clickablePhotoPartDefinition = f11067d;
                }
                if (clickablePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11236b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11068e, b3);
                        } else {
                            f11067d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = clickablePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

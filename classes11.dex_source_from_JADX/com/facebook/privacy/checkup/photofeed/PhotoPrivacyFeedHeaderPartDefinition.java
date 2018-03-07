package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.privacy.checkup.photofeed.data.POPPhotoCheckupData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SplittingHeader */
public class PhotoPrivacyFeedHeaderPartDefinition extends MultiRowSinglePartDefinition<POPPhotoCheckupData, Void, PhotoPrivacyFeedEnvironment, View> {
    public static final ViewType f11039a = ViewType.a(2130906203);
    private static final CallerContext f11040b = CallerContext.a(PhotoPrivacyFeedHeaderPartDefinition.class);
    private static final PaddingStyle f11041c;
    private static PhotoPrivacyFeedHeaderPartDefinition f11042h;
    private static final Object f11043i = new Object();
    private final Resources f11044d;
    private final BackgroundPartDefinition f11045e;
    private final FbDraweePartDefinition f11046f;
    private final TextPartDefinition f11047g;

    private static PhotoPrivacyFeedHeaderPartDefinition m11444b(InjectorLike injectorLike) {
        return new PhotoPrivacyFeedHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m11446a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        POPPhotoCheckupData pOPPhotoCheckupData = (POPPhotoCheckupData) obj;
        subParts.a(this.f11045e, new StylingData(f11041c));
        if (pOPPhotoCheckupData.f11061f != null) {
            FbDraweePartDefinition fbDraweePartDefinition = this.f11046f;
            Builder a = new Builder().a(pOPPhotoCheckupData.f11061f.b());
            a.c = f11040b;
            subParts.a(2131562571, fbDraweePartDefinition, a.a());
        }
        subParts.a(2131558927, this.f11047g, this.f11044d.getString(2131242315));
        subParts.a(2131559627, this.f11047g, this.f11044d.getString(2131242316));
        subParts.a(2131565917, this.f11047g, this.f11044d.getString(2131242317));
        return null;
    }

    static {
        PaddingStyle.Builder c = PaddingStyle.Builder.c();
        c.c = -6.0f;
        f11041c = c.i();
    }

    @Inject
    public PhotoPrivacyFeedHeaderPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition) {
        this.f11044d = resources;
        this.f11045e = backgroundPartDefinition;
        this.f11046f = fbDraweePartDefinition;
        this.f11047g = textPartDefinition;
    }

    public final boolean m11447a(Object obj) {
        return true;
    }

    public static PhotoPrivacyFeedHeaderPartDefinition m11443a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoPrivacyFeedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11043i) {
                PhotoPrivacyFeedHeaderPartDefinition photoPrivacyFeedHeaderPartDefinition;
                if (a2 != null) {
                    photoPrivacyFeedHeaderPartDefinition = (PhotoPrivacyFeedHeaderPartDefinition) a2.a(f11043i);
                } else {
                    photoPrivacyFeedHeaderPartDefinition = f11042h;
                }
                if (photoPrivacyFeedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11444b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11043i, b3);
                        } else {
                            f11042h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoPrivacyFeedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m11445a() {
        return f11039a;
    }
}

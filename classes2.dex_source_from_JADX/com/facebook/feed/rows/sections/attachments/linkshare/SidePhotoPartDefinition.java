package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasSideImage;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.sections.attachments.linkshare.SidePhotoShareAttachmentPartDefinition.Props;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_payment_requests */
public class SidePhotoPartDefinition<E extends HasPrefetcher, V extends View & AttachmentHasSideImage> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static SidePhotoPartDefinition f23973b;
    private static final Object f23974c = new Object();
    private final SidePhotoShareAttachmentPartDefinition<E, V> f23975a;

    private static SidePhotoPartDefinition m32361b(InjectorLike injectorLike) {
        return new SidePhotoPartDefinition(SidePhotoShareAttachmentPartDefinition.m32363a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f23975a, new Props(props.a, props.b));
        return null;
    }

    @Inject
    public SidePhotoPartDefinition(SidePhotoShareAttachmentPartDefinition sidePhotoShareAttachmentPartDefinition) {
        this.f23975a = sidePhotoShareAttachmentPartDefinition;
    }

    public static SidePhotoPartDefinition m32360a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SidePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23974c) {
                SidePhotoPartDefinition sidePhotoPartDefinition;
                if (a2 != null) {
                    sidePhotoPartDefinition = (SidePhotoPartDefinition) a2.mo818a(f23974c);
                } else {
                    sidePhotoPartDefinition = f23973b;
                }
                if (sidePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32361b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23974c, b3);
                        } else {
                            f23973b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = sidePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

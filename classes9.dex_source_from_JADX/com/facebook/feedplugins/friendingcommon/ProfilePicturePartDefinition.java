package com.facebook.feedplugins.friendingcommon;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ContentDescriptionPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition.UriContextData;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TOUCH_DOWN */
public class ProfilePicturePartDefinition<E extends HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, Void, E, FbDraweeView> {
    public static final CallerContext f24641a = CallerContext.a(ProfilePicturePartDefinition.class, "native_newsfeed");
    private static ProfilePicturePartDefinition f24642d;
    private static final Object f24643e = new Object();
    private final ContentDescriptionPartDefinition f24644b;
    private final FbDraweeImageUriPartDefinition f24645c;

    /* compiled from: TOUCH_DOWN */
    public class Props {
        public final String f24639a;
        public final String f24640b;

        public Props(String str, String str2) {
            this.f24639a = str;
            this.f24640b = str2;
        }
    }

    private static ProfilePicturePartDefinition m26542b(InjectorLike injectorLike) {
        return new ProfilePicturePartDefinition(ContentDescriptionPartDefinition.a(injectorLike), FbDraweeImageUriPartDefinition.a(injectorLike));
    }

    public final Object m26543a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f24645c, new UriContextData(props.f24639a, f24641a));
        subParts.a(this.f24644b, props.f24640b);
        return null;
    }

    @Inject
    public ProfilePicturePartDefinition(ContentDescriptionPartDefinition contentDescriptionPartDefinition, FbDraweeImageUriPartDefinition fbDraweeImageUriPartDefinition) {
        this.f24644b = contentDescriptionPartDefinition;
        this.f24645c = fbDraweeImageUriPartDefinition;
    }

    public static ProfilePicturePartDefinition m26541a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfilePicturePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24643e) {
                ProfilePicturePartDefinition profilePicturePartDefinition;
                if (a2 != null) {
                    profilePicturePartDefinition = (ProfilePicturePartDefinition) a2.a(f24643e);
                } else {
                    profilePicturePartDefinition = f24642d;
                }
                if (profilePicturePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26542b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24643e, b3);
                        } else {
                            f24642d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profilePicturePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

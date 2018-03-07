package com.facebook.attachments;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.ufiservices.ui.UfiAttachmentStyleSupportDeclaration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class C0427xd24da616 implements MultiBindIndexedProvider<AttachmentStyleSupportDeclaration>, Provider<Set<AttachmentStyleSupportDeclaration>> {
    private final InjectorLike f7347a;

    private C0427xd24da616(InjectorLike injectorLike) {
        this.f7347a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7347a.getScopeAwareInjector(), this);
    }

    public static Set<AttachmentStyleSupportDeclaration> m10452a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0427xd24da616(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return UfiAttachmentStyleSupportDeclaration.m26826a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}

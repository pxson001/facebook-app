package com.facebook.messaging.service.methods;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.service.model.Mark;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: custom_voicemail_create */
public class MarkReadThreadMethod extends AbstractMarkThreadMethod {
    public static MarkReadThreadMethod m16966b(InjectorLike injectorLike) {
        return new MarkReadThreadMethod(IdBasedProvider.a(injectorLike, 4075));
    }

    @Inject
    public MarkReadThreadMethod(Provider<Boolean> provider) {
        super(provider, Mark.READ);
    }
}

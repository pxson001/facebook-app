package com.facebook.messaging.chatheads.prefs;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: is_saving_draft */
public class IsChatHeadsPermittedProvider {
    private static final Class<?> f11994a = IsChatHeadsPermittedProvider.class;
    public final Context f11995b;
    public final Boolean f11996c;
    public final FbAppType f11997d;
    public final Resources f11998e;

    public static IsChatHeadsPermittedProvider m18916b(InjectorLike injectorLike) {
        return new IsChatHeadsPermittedProvider((Context) injectorLike.getInstance(Context.class), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(923, false)), (FbAppType) injectorLike.getInstance(FbAppType.class), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public IsChatHeadsPermittedProvider(Context context, Boolean bool, FbAppType fbAppType, Resources resources) {
        this.f11995b = context;
        this.f11996c = bool;
        this.f11997d = fbAppType;
        this.f11998e = resources;
    }
}

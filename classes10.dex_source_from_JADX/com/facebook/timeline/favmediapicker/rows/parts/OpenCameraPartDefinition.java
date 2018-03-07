package com.facebook.timeline.favmediapicker.rows.parts;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig.Builder;
import com.facebook.ipc.creativecam.CreativeCamLauncher;
import com.facebook.ipc.creativecam.CreativeCamSource;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.photos.creativecam.activity.CreativeCamLauncherImpl;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.timeline.favmediapicker.ui.FavoriteMediaPickerActivity;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_settings_invite_friends */
public class OpenCameraPartDefinition extends BaseSinglePartDefinitionWithViewType<Void, Void, FavoriteMediaPickerEnvironment, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f11075a = ViewType.a(2130904246);
    private static OpenCameraPartDefinition f11076d;
    private static final Object f11077e = new Object();
    private final ClickListenerPartDefinition f11078b;
    public final CreativeCamLauncher f11079c;

    /* compiled from: friends_nearby_settings_invite_friends */
    public class C16021 implements OnClickListener {
        final /* synthetic */ OpenCameraPartDefinition f11074a;

        public C16021(OpenCameraPartDefinition openCameraPartDefinition) {
            this.f11074a = openCameraPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1167721632);
            Builder builder = new Builder();
            builder.l = CreativeCamSource.FAVORITE_MEDIA_PICKER;
            builder = builder;
            builder.f = SupportedMediaType.PHOTO_ONLY;
            this.f11074a.f11079c.a((Activity) ContextUtils.a(view.getContext(), FavoriteMediaPickerActivity.class), 2, builder.a(), "session_id", null);
            Logger.a(2, EntryType.UI_INPUT_END, 1890113897, a);
        }
    }

    private static OpenCameraPartDefinition m11244b(InjectorLike injectorLike) {
        return new OpenCameraPartDefinition(ClickListenerPartDefinition.a(injectorLike), (CreativeCamLauncher) CreativeCamLauncherImpl.a(injectorLike));
    }

    @Inject
    public OpenCameraPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, CreativeCamLauncher creativeCamLauncher) {
        this.f11078b = clickListenerPartDefinition;
        this.f11079c = creativeCamLauncher;
    }

    public final ViewType<CustomFrameLayout> m11245a() {
        return f11075a;
    }

    public final Object m11246a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f11078b, new C16021(this));
        return null;
    }

    public static OpenCameraPartDefinition m11243a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenCameraPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11077e) {
                OpenCameraPartDefinition openCameraPartDefinition;
                if (a2 != null) {
                    openCameraPartDefinition = (OpenCameraPartDefinition) a2.a(f11077e);
                } else {
                    openCameraPartDefinition = f11076d;
                }
                if (openCameraPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11244b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11077e, b3);
                        } else {
                            f11076d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openCameraPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

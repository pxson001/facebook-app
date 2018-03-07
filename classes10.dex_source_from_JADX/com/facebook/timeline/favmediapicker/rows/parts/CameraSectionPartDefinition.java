package com.facebook.timeline.favmediapicker.rows.parts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.favmediapicker.models.CameraRollData;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.timeline.favmediapicker.rows.parts.SectionTitlePartDefinition.Props;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: friends_nearby_settings_manage_location_services */
public class CameraSectionPartDefinition extends BaseMultiRowGroupPartDefinition<CameraRollData, Void, FavoriteMediaPickerEnvironment> {
    private static CameraSectionPartDefinition f11058e;
    private static final Object f11059f = new Object();
    private final SectionTitlePartDefinition f11060a;
    private final CameraRollPartDefinition f11061b;
    public final Provider<SecureContextHelper> f11062c;
    public final Resources f11063d;

    /* compiled from: friends_nearby_settings_manage_location_services */
    public class C16011 implements OnClickListener {
        final /* synthetic */ CameraSectionPartDefinition f11057a;

        public C16011(CameraSectionPartDefinition cameraSectionPartDefinition) {
            this.f11057a = cameraSectionPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -468234865);
            SecureContextHelper secureContextHelper = (SecureContextHelper) this.f11057a.f11062c.get();
            CameraSectionPartDefinition cameraSectionPartDefinition = this.f11057a;
            secureContextHelper.a(SimplePickerIntent.a(view.getContext(), new Builder(SimplePickerSource.ADD_FEATURED_CONTAINER_NULL_STATE).h().i().a(Action.NONE)), 1, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 1594827667, a);
        }
    }

    private static CameraSectionPartDefinition m11232b(InjectorLike injectorLike) {
        return new CameraSectionPartDefinition(SectionTitlePartDefinition.m11248a(injectorLike), CameraRollPartDefinition.m11224a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m11233a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        CameraRollData cameraRollData = (CameraRollData) obj;
        baseMultiRowSubParts.a(this.f11060a, new Props(this.f11063d.getString(2131241398), new C16011(this)));
        baseMultiRowSubParts.a(this.f11061b, cameraRollData);
        return null;
    }

    public final boolean m11234a(Object obj) {
        return !((CameraRollData) obj).f11016a.isEmpty();
    }

    @Inject
    public CameraSectionPartDefinition(SectionTitlePartDefinition sectionTitlePartDefinition, CameraRollPartDefinition cameraRollPartDefinition, Provider<SecureContextHelper> provider, Resources resources) {
        this.f11060a = sectionTitlePartDefinition;
        this.f11061b = cameraRollPartDefinition;
        this.f11062c = provider;
        this.f11063d = resources;
    }

    public static CameraSectionPartDefinition m11231a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CameraSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11059f) {
                CameraSectionPartDefinition cameraSectionPartDefinition;
                if (a2 != null) {
                    cameraSectionPartDefinition = (CameraSectionPartDefinition) a2.a(f11059f);
                } else {
                    cameraSectionPartDefinition = f11058e;
                }
                if (cameraSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11232b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11059f, b3);
                        } else {
                            f11058e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = cameraSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

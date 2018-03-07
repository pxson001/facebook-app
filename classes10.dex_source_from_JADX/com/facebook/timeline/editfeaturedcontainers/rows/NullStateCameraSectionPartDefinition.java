package com.facebook.timeline.editfeaturedcontainers.rows;

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
import com.facebook.timeline.editfeaturedcontainers.models.CameraRollData;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateSectionTitlePartDefinition.Props;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: getSuggestedBusinesses failed */
public class NullStateCameraSectionPartDefinition extends BaseMultiRowGroupPartDefinition<CameraRollData, Void, NullStateEnvironment> {
    private static NullStateCameraSectionPartDefinition f10812e;
    private static final Object f10813f = new Object();
    private final NullStateSectionTitlePartDefinition f10814a;
    private final NullStateCameraRollPartDefinition f10815b;
    public final Provider<SecureContextHelper> f10816c;
    public final Resources f10817d;

    /* compiled from: getSuggestedBusinesses failed */
    public class C15691 implements OnClickListener {
        final /* synthetic */ NullStateCameraSectionPartDefinition f10811a;

        public C15691(NullStateCameraSectionPartDefinition nullStateCameraSectionPartDefinition) {
            this.f10811a = nullStateCameraSectionPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1296498510);
            SecureContextHelper secureContextHelper = (SecureContextHelper) this.f10811a.f10816c.get();
            NullStateCameraSectionPartDefinition nullStateCameraSectionPartDefinition = this.f10811a;
            secureContextHelper.a(SimplePickerIntent.a(view.getContext(), new Builder(SimplePickerSource.ADD_FEATURED_CONTAINER_NULL_STATE).h().i().a(Action.NONE)), 2, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -145099858, a);
        }
    }

    private static NullStateCameraSectionPartDefinition m10942b(InjectorLike injectorLike) {
        return new NullStateCameraSectionPartDefinition(NullStateSectionTitlePartDefinition.m10961a(injectorLike), NullStateCameraRollPartDefinition.m10934a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10943a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        CameraRollData cameraRollData = (CameraRollData) obj;
        baseMultiRowSubParts.a(this.f10814a, new Props(this.f10817d.getString(2131241388), new C15691(this)));
        baseMultiRowSubParts.a(this.f10815b, cameraRollData);
        return null;
    }

    public final boolean m10944a(Object obj) {
        return !((CameraRollData) obj).f10765a.isEmpty();
    }

    @Inject
    public NullStateCameraSectionPartDefinition(NullStateSectionTitlePartDefinition nullStateSectionTitlePartDefinition, NullStateCameraRollPartDefinition nullStateCameraRollPartDefinition, Provider<SecureContextHelper> provider, Resources resources) {
        this.f10814a = nullStateSectionTitlePartDefinition;
        this.f10815b = nullStateCameraRollPartDefinition;
        this.f10816c = provider;
        this.f10817d = resources;
    }

    public static NullStateCameraSectionPartDefinition m10941a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateCameraSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10813f) {
                NullStateCameraSectionPartDefinition nullStateCameraSectionPartDefinition;
                if (a2 != null) {
                    nullStateCameraSectionPartDefinition = (NullStateCameraSectionPartDefinition) a2.a(f10813f);
                } else {
                    nullStateCameraSectionPartDefinition = f10812e;
                }
                if (nullStateCameraSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10942b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10813f, b3);
                        } else {
                            f10812e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateCameraSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

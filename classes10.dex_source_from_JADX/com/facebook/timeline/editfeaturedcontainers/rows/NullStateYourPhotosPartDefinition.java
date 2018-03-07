package com.facebook.timeline.editfeaturedcontainers.rows;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.editfeaturedcontainers.ui.AddFeaturedContainerActivity;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: getDevicePhoneNumber */
public class NullStateYourPhotosPartDefinition extends MultiRowSinglePartDefinition<Void, Void, AnyEnvironment, FbTextView> {
    public static final ViewType<FbTextView> f10890a = new C15771();
    private static NullStateYourPhotosPartDefinition f10891g;
    private static final Object f10892h = new Object();
    private final ViewPaddingPartDefinition f10893b;
    private final ClickListenerPartDefinition f10894c;
    public final Provider<SecureContextHelper> f10895d;
    public final Provider<IFeedIntentBuilder> f10896e;
    public final Resources f10897f;

    /* compiled from: getDevicePhoneNumber */
    final class C15771 extends ViewType<FbTextView> {
        C15771() {
        }

        public final View m10997a(Context context) {
            FbTextView fbTextView = (FbTextView) LayoutInflater.from(context).inflate(2130905511, null);
            LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.a(context, 2130844061);
            layerDrawable.findDrawableByLayerId(2131564232).setColorFilter(ContextCompat.b(context, 2131361920), Mode.SRC_IN);
            if (RTLUtil.a(context)) {
                fbTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, layerDrawable, null);
            } else {
                fbTextView.setCompoundDrawablesWithIntrinsicBounds(layerDrawable, null, null, null);
            }
            return fbTextView;
        }
    }

    /* compiled from: getDevicePhoneNumber */
    public class C15782 implements OnClickListener {
        final /* synthetic */ NullStateYourPhotosPartDefinition f10889a;

        public C15782(NullStateYourPhotosPartDefinition nullStateYourPhotosPartDefinition) {
            this.f10889a = nullStateYourPhotosPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -347031237);
            SecureContextHelper secureContextHelper = (SecureContextHelper) this.f10889a.f10895d.get();
            NullStateYourPhotosPartDefinition nullStateYourPhotosPartDefinition = this.f10889a;
            Intent b = ((IFeedIntentBuilder) nullStateYourPhotosPartDefinition.f10896e.get()).b(view.getContext(), FBLinks.bm);
            b.putExtra("pick_pic_lite", true);
            b.putExtra("extra_should_merge_camera_roll", true);
            b.putExtra("extra_simple_picker_launcher_configuration", new Builder(SimplePickerSource.ADD_FEATURED_CONTAINER_NULL_STATE).h().i().a(Action.NONE).r());
            b.putExtra("title", nullStateYourPhotosPartDefinition.f10897f.getString(2131241383));
            secureContextHelper.a(b, 1, (Activity) ContextUtils.a(view.getContext(), AddFeaturedContainerActivity.class));
            Logger.a(2, EntryType.UI_INPUT_END, -236971132, a);
        }
    }

    private static NullStateYourPhotosPartDefinition m10999b(InjectorLike injectorLike) {
        return new NullStateYourPhotosPartDefinition(ViewPaddingPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedSingletonScopeProvider.a(injectorLike, 2347), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public static NullStateYourPhotosPartDefinition m10998a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateYourPhotosPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10892h) {
                NullStateYourPhotosPartDefinition nullStateYourPhotosPartDefinition;
                if (a2 != null) {
                    nullStateYourPhotosPartDefinition = (NullStateYourPhotosPartDefinition) a2.a(f10892h);
                } else {
                    nullStateYourPhotosPartDefinition = f10891g;
                }
                if (nullStateYourPhotosPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10999b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10892h, b3);
                        } else {
                            f10891g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateYourPhotosPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NullStateYourPhotosPartDefinition(ViewPaddingPartDefinition viewPaddingPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, Resources resources) {
        this.f10893b = viewPaddingPartDefinition;
        this.f10894c = clickListenerPartDefinition;
        this.f10895d = provider;
        this.f10896e = provider2;
        this.f10897f = resources;
    }

    public final ViewType<FbTextView> m11000a() {
        return f10890a;
    }

    public final boolean m11002a(Object obj) {
        return true;
    }

    public final Object m11001a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ViewPaddingPartDefinition viewPaddingPartDefinition = this.f10893b;
        int dimensionPixelSize = this.f10897f.getDimensionPixelSize(2131433933);
        int dimensionPixelSize2 = this.f10897f.getDimensionPixelSize(2131433937);
        subParts.a(viewPaddingPartDefinition, new PaddingData(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2));
        subParts.a(this.f10894c, new C15782(this));
        return null;
    }
}

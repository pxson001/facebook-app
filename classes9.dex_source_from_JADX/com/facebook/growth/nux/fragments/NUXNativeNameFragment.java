package com.facebook.growth.nux.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.api.growth.profile.SetNativeNameParams;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.nux.NUXFragment;
import com.facebook.growth.nux.fragments.nativename.NativeNameFieldsView;
import com.facebook.growth.promotion.NativeNameActivity;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: p2p_settings_get_request */
public class NUXNativeNameFragment extends NUXFragment {
    @Inject
    public ErrorDialogs f7439a;
    @Inject
    public DefaultBlueServiceOperationFactory f7440b;
    public NativeNameFieldsView f7441c;

    /* compiled from: p2p_settings_get_request */
    class ContinueListener implements OnClickListener {
        final /* synthetic */ NUXNativeNameFragment f7438a;

        /* compiled from: p2p_settings_get_request */
        class C08121 implements FutureCallback<OperationResult> {
            final /* synthetic */ ContinueListener f7437a;

            C08121(ContinueListener continueListener) {
                this.f7437a = continueListener;
            }

            public void onSuccess(Object obj) {
                if (this.f7437a.f7438a.o() instanceof NuxStepListener) {
                    ((NuxStepListener) this.f7437a.f7438a.o()).b("native_name");
                } else if (this.f7437a.f7438a.o() instanceof NativeNameActivity) {
                    this.f7437a.f7438a.o().finish();
                }
            }

            public void onFailure(Throwable th) {
                if (th instanceof ServiceException) {
                    ServiceException serviceException = (ServiceException) th;
                    ErrorDialogs errorDialogs = this.f7437a.f7438a.f7439a;
                    ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f7437a.f7438a.jW_());
                    a.f = serviceException;
                    errorDialogs.a(a.a(2131236370).l());
                }
            }
        }

        public ContinueListener(NUXNativeNameFragment nUXNativeNameFragment) {
            this.f7438a = nUXNativeNameFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -458138507);
            NativeNameFieldsView nativeNameFieldsView = this.f7438a.f7441c;
            Builder b = new Builder().b("first_name", ((EditText) nativeNameFieldsView.f7491b.getView(2131564043)).getText().toString()).b("last_name", ((EditText) nativeNameFieldsView.f7491b.getView(2131564042)).getText().toString()).b("locale", nativeNameFieldsView.f7490a.c());
            if (nativeNameFieldsView.f7492c != null) {
                String obj = ((EditText) nativeNameFieldsView.f7492c.findViewById(2131564309)).getText().toString();
                if (obj != null && obj.length() > 0) {
                    b.b("first_name_extra", obj);
                }
                obj = ((EditText) nativeNameFieldsView.f7492c.findViewById(2131564308)).getText().toString();
                if (obj != null && obj.length() > 0) {
                    b.b("last_name_extra", obj);
                }
            }
            ImmutableMap b2 = b.b();
            Parcelable setNativeNameParams = new SetNativeNameParams((String) b2.get("first_name"), (String) b2.get("last_name"), (String) b2.get("first_name_extra"), (String) b2.get("last_name_extra"), (String) b2.get("locale"));
            Bundle bundle = new Bundle();
            bundle.putParcelable("growthSetNativeNameParams", setNativeNameParams);
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f7438a.f7440b, "growth_set_native_name", bundle, -1648976648).a(), new C08121(this));
            Logger.a(2, EntryType.UI_INPUT_END, 982488868, a);
        }
    }

    public static void m7767a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        NUXNativeNameFragment nUXNativeNameFragment = (NUXNativeNameFragment) obj;
        ErrorDialogs a = ErrorDialogs.a(fbInjector);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        nUXNativeNameFragment.f7439a = a;
        nUXNativeNameFragment.f7440b = b;
    }

    public final void m7769c(Bundle bundle) {
        super.c(bundle);
        Class cls = NUXNativeNameFragment.class;
        m7767a(this, getContext());
    }

    public final View m7768a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -824182390);
        View inflate = layoutInflater.inflate(2130904432, viewGroup, false);
        this.f7441c = new NativeNameFieldsView(getContext(), null);
        ((LinearLayout) inflate.findViewById(2131562182)).addView(this.f7441c);
        ((Button) inflate.findViewById(2131562183)).setOnClickListener(new ContinueListener(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1067638872, a);
        return inflate;
    }
}

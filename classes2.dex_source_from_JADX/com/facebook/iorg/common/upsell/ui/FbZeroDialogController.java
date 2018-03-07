package com.facebook.iorg.common.upsell.ui;

import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.dialogprovider.ZeroDialogProvider;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.eventbus.ZeroEventBus;
import com.facebook.iorg.common.zero.eventbus.ZeroEventSubscriber;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogData;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.DialogToShow;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: skip_tail_gap */
public class FbZeroDialogController extends ZeroDialogController {
    private static final Class<?> f4684b = FbZeroDialogController.class;
    private final Resources f4685c;
    private final ZeroEventBus f4686d;
    private final FbZeroFeatureVisibilityHelper f4687e;
    private final DialogEventSubscriber f4688f = new DialogEventSubscriber(this);
    public final Provider<ZeroDialogProvider> f4689g;
    public final Provider<ZeroDialogProvider> f4690h;
    private final Provider<ZeroDialogProvider> f4691i;
    public final Provider<ZeroDialogProvider> f4692j;

    /* compiled from: skip_tail_gap */
    class DialogEventSubscriber extends ZeroEventSubscriber<ZeroDialogActionEvent> {
        final /* synthetic */ FbZeroDialogController f4730a;

        public DialogEventSubscriber(FbZeroDialogController fbZeroDialogController) {
            this.f4730a = fbZeroDialogController;
        }

        public final void mo650b(FbEvent fbEvent) {
            ZeroDialogActionEvent zeroDialogActionEvent = (ZeroDialogActionEvent) fbEvent;
            DialogData dialogData = (DialogData) this.f4730a.f4655a.get(zeroDialogActionEvent.a);
            if (dialogData != null && dialogData.d != null) {
                switch (1.a[zeroDialogActionEvent.b.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        dialogData.d.a(zeroDialogActionEvent.e);
                        return;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        dialogData.d.a();
                        return;
                    case 3:
                        m8535a(zeroDialogActionEvent, dialogData);
                        return;
                    default:
                        return;
                }
            }
        }

        private void m8535a(ZeroDialogActionEvent zeroDialogActionEvent, DialogData dialogData) {
            if (dialogData.i == null) {
                dialogData.d.a();
            } else if (dialogData.i.mo851c()) {
                switch (1.c[zeroDialogActionEvent.c.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        switch (1.b[zeroDialogActionEvent.d.ordinal()]) {
                            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                                ((ZeroDialogProvider) this.f4730a.f4692j.get()).a(dialogData, zeroDialogActionEvent.e, zeroDialogActionEvent.a).m213a(dialogData.i, zeroDialogActionEvent.a.prefString);
                                return;
                            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                                ((ZeroDialogProvider) this.f4730a.f4689g.get()).a(dialogData, zeroDialogActionEvent.e, zeroDialogActionEvent.a).m213a(dialogData.i, zeroDialogActionEvent.a.prefString);
                                return;
                            default:
                                throw new RuntimeException("no failure reason");
                        }
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    case 3:
                        ((ZeroDialogProvider) this.f4730a.f4690h.get()).a(dialogData, zeroDialogActionEvent.e, zeroDialogActionEvent.a).m213a(dialogData.i, zeroDialogActionEvent.a.prefString);
                        return;
                    default:
                        if (dialogData.d != null) {
                            dialogData.d.a();
                            return;
                        }
                        return;
                }
            } else {
                dialogData.d.a();
            }
        }

        public final Class<ZeroDialogActionEvent> mo648a() {
            return ZeroDialogActionEvent.class;
        }
    }

    public static FbZeroDialogController m8472b(InjectorLike injectorLike) {
        return new FbZeroDialogController(ResourcesMethodAutoProvider.m6510a(injectorLike), ZeroEventBus.m8534a(injectorLike), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), IdBasedProvider.m1811a(injectorLike, 7274), IdBasedProvider.m1811a(injectorLike, 11850), IdBasedProvider.m1811a(injectorLike, 7275), IdBasedProvider.m1811a(injectorLike, 7276));
    }

    public static FbZeroDialogController m8470a(InjectorLike injectorLike) {
        return m8472b(injectorLike);
    }

    @Inject
    public FbZeroDialogController(Resources resources, ZeroEventBus zeroEventBus, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<ZeroDialogProvider> provider, Provider<ZeroDialogProvider> provider2, Provider<ZeroDialogProvider> provider3, Provider<ZeroDialogProvider> provider4) {
        this.f4685c = resources;
        this.f4686d = zeroEventBus;
        this.f4687e = zeroFeatureVisibilityHelper;
        this.f4689g = provider;
        this.f4690h = provider2;
        this.f4691i = provider3;
        this.f4692j = provider4;
    }

    protected final DialogFragment mo1238a(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
        switch (1.d[dialogData.j.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                String str = dialogData.b;
                String str2 = dialogData.c;
                SpinnerDialogFragment.av = zeroFeatureKey.equals(ZeroFeatureKey.DIALTONE_PHOTOCAP_SPINNER);
                SpinnerDialogFragment.aw = str;
                SpinnerDialogFragment.ax = str2;
                return new SpinnerDialogFragment();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ((ZeroDialogProvider) this.f4689g.get()).a(dialogData, obj, zeroFeatureKey);
            case 3:
                return m8471b(dialogData, obj, zeroFeatureKey);
            default:
                throw new RuntimeException("Unsupported dialog");
        }
    }

    private DialogFragment m8471b(DialogData dialogData, Object obj, ZeroFeatureKey zeroFeatureKey) {
        ZeroDialogState c = m8473c();
        switch (1.c[c.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ((ZeroDialogProvider) this.f4691i.get()).a(dialogData, obj, zeroFeatureKey);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ((ZeroDialogProvider) this.f4692j.get()).a(dialogData, obj, zeroFeatureKey);
            case 3:
                return ((ZeroDialogProvider) this.f4689g.get()).a(dialogData, obj, zeroFeatureKey);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ((ZeroDialogProvider) this.f4690h.get()).a(dialogData, obj, zeroFeatureKey);
            default:
                throw new UnsupportedOperationException("unsupported dialog state: " + c);
        }
    }

    private ZeroDialogState m8473c() {
        boolean a = this.f4687e.m7923a();
        boolean d = m8474d();
        if (a && d) {
            return ZeroDialogState.UPSELL_WITH_DATA_CONTROL;
        }
        if (a && !d) {
            return ZeroDialogState.UPSELL_WITHOUT_DATA_CONTROL;
        }
        if (!a && d) {
            return ZeroDialogState.DATA_CONTROL_WITHOUT_UPSELL;
        }
        if (a || d) {
            return ZeroDialogState.UNKOWN;
        }
        return ZeroDialogState.NO_DATA_CONTROL_NO_UPSELL;
    }

    public final void mo1239a() {
        this.f4686d.m4567a(this.f4688f.mo648a());
        this.f4686d.m4568a(this.f4688f);
    }

    protected final String mo1241b() {
        return this.f4685c.getString(2131232869);
    }

    public final boolean mo1240a(DialogToShow dialogToShow, ZeroFeatureKey zeroFeatureKey) {
        if (!this.f4687e.m7924a(zeroFeatureKey)) {
            return false;
        }
        if (dialogToShow == DialogToShow.DATA_CONTROL_WITHOUT_UPSELL) {
            return m8474d();
        }
        return true;
    }

    private boolean m8474d() {
        return this.f4687e.m7924a(ZeroFeatureKey.VPN_DATA_CONTROL);
    }
}

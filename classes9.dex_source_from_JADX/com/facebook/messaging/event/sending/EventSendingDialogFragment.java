package com.facebook.messaging.event.sending;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.fullscreendialog.FullScreenDialogFragment;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.orca.compose.ComposeFragment.30;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mSenderPin */
public class EventSendingDialogFragment extends FullScreenDialogFragment {
    @Inject
    public ViewOrientationLockHelperProvider am;
    public 30 an;
    public EventMessageParams ao;
    private ViewOrientationLockHelper ap;

    /* compiled from: mSenderPin */
    class C12341 implements OnClickListener {
        final /* synthetic */ EventSendingDialogFragment f11088a;

        C12341(EventSendingDialogFragment eventSendingDialogFragment) {
            this.f11088a = eventSendingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1644727631);
            if (this.f11088a.an == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1249626186, a);
                return;
            }
            this.f11088a.an.a();
            LogUtils.a(1829492592, a);
        }
    }

    /* compiled from: mSenderPin */
    class C12352 implements OnClickListener {
        final /* synthetic */ EventSendingDialogFragment f11089a;

        C12352(EventSendingDialogFragment eventSendingDialogFragment) {
            this.f11089a = eventSendingDialogFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -853329235);
            if (this.f11089a.an == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1753435976, a);
                return;
            }
            this.f11089a.an.a(this.f11089a.ao);
            LogUtils.a(-5179521, a);
        }
    }

    public static void m11479a(Object obj, Context context) {
        ((EventSendingDialogFragment) obj).am = (ViewOrientationLockHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class);
    }

    public static EventSendingDialogFragment m11478a(FullScreenDialogParams fullScreenDialogParams, @Nullable Bundle bundle) {
        EventSendingDialogFragment eventSendingDialogFragment = new EventSendingDialogFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        fullScreenDialogParams.a(bundle);
        eventSendingDialogFragment.g(bundle);
        return eventSendingDialogFragment;
    }

    public final void m11482a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2079614195);
        super.a(bundle);
        Class cls = EventSendingDialogFragment.class;
        m11479a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1566337476, a);
    }

    public final View m11481a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1195004671);
        View inflate = layoutInflater.inflate(2130904100, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1763812406, a);
        return inflate;
    }

    public final void m11483a(View view, @Nullable Bundle bundle) {
        this.ap = this.am.a(this.T);
        this.ap.a();
        e(2131561421).setOnClickListener(new C12341(this));
        final View e = e(2131561423);
        e.setEnabled(false);
        e.setOnClickListener(new C12352(this));
        EventMessageDetailsFragment eventMessageDetailsFragment = new EventMessageDetailsFragment();
        eventMessageDetailsFragment.f11080i = new Object(this) {
            final /* synthetic */ EventSendingDialogFragment f11091b;

            public final void m11476a(int i) {
                if (this.f11091b.an != null) {
                    30 30 = this.f11091b.an;
                }
            }

            public final void m11477a(EventMessageParams eventMessageParams) {
                boolean z;
                this.f11091b.ao = eventMessageParams;
                View view = e;
                if (Strings.isNullOrEmpty(eventMessageParams.f11081a) || eventMessageParams.f11083c == null || eventMessageParams.f11084d == null || (eventMessageParams.f11085e == null && eventMessageParams.f11086f == null)) {
                    z = false;
                } else {
                    z = true;
                }
                view.setEnabled(z);
            }
        };
        s().a().a(2131561424, eventMessageDetailsFragment, "event_message_details_fragment").b();
    }

    public final void m11480I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1701624786);
        super.I();
        this.ap.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1392297052, a);
    }
}

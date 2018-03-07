package com.facebook.messaging.event.sending;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.facebook.android.maps.model.LatLng;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.event.sending.EventSendingDialogFragment.C12363;
import com.facebook.messaging.event.sending.PickEventTimeController.Host;
import com.facebook.messaging.fullscreendialog.FullScreenDialogParams;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment;
import com.facebook.messaging.location.sending.LocationSendingDialogFragment.Listener;
import com.facebook.messaging.location.sending.NearbyPlace;
import java.util.Calendar;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mSkeletonString */
public class EventMessageDetailsFragment extends FbFragment {
    @Inject
    public PickEventTimeController f11072a;
    private TextView f11073b;
    public TextView f11074c;
    private CheckBox f11075d;
    private TextView f11076e;
    private TextView f11077f;
    public EventMessageParams f11078g;
    private final Listener f11079h = new C12241(this);
    @Nullable
    public C12363 f11080i;

    /* compiled from: mSkeletonString */
    class C12241 implements Listener {
        final /* synthetic */ EventMessageDetailsFragment f11063a;

        C12241(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11063a = eventMessageDetailsFragment;
        }

        public final void mo428a(LatLng latLng) {
            EventMessageDetailsFragment.m11460a(this.f11063a, latLng);
        }

        public final void mo430b(LatLng latLng) {
            EventMessageDetailsFragment.m11460a(this.f11063a, latLng);
        }

        public final void mo429a(NearbyPlace nearbyPlace) {
            EventMessageDetailsFragment eventMessageDetailsFragment = this.f11063a;
            eventMessageDetailsFragment.f11078g.m11474a(nearbyPlace);
            eventMessageDetailsFragment.f11074c.setText(nearbyPlace.f11445b);
            if (eventMessageDetailsFragment.f11080i != null) {
                eventMessageDetailsFragment.f11080i.m11477a(eventMessageDetailsFragment.f11078g);
            }
        }
    }

    /* compiled from: mSkeletonString */
    class C12252 implements TextWatcher {
        final /* synthetic */ EventMessageDetailsFragment f11064a;

        C12252(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11064a = eventMessageDetailsFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            EventMessageParams eventMessageParams = this.f11064a.f11078g;
            if (charSequence == null) {
                str = null;
            } else {
                str = charSequence.toString();
            }
            eventMessageParams.f11081a = str;
            if (this.f11064a.f11080i != null) {
                this.f11064a.f11080i.m11477a(this.f11064a.f11078g);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: mSkeletonString */
    class C12263 implements OnFocusChangeListener {
        final /* synthetic */ EventMessageDetailsFragment f11065a;

        C12263(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11065a = eventMessageDetailsFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (this.f11065a.f11080i != null && z) {
                this.f11065a.f11080i.m11476a(view.getId());
            }
        }
    }

    /* compiled from: mSkeletonString */
    class C12274 implements OnCheckedChangeListener {
        final /* synthetic */ EventMessageDetailsFragment f11066a;

        C12274(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11066a = eventMessageDetailsFragment;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f11066a.f11078g.f11082b = z;
        }
    }

    /* compiled from: mSkeletonString */
    class C12285 implements OnClickListener {
        final /* synthetic */ EventMessageDetailsFragment f11067a;

        C12285(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11067a = eventMessageDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 315753941);
            if (this.f11067a.f11080i != null) {
                this.f11067a.f11080i.m11476a(view.getId());
            }
            EventMessageDetailsFragment eventMessageDetailsFragment = this.f11067a;
            LocationSendingDialogFragment.m11987a(LocationSendingDialogConfig.m11976a(FullScreenDialogParams.a(eventMessageDetailsFragment)).m11974b().m11975d()).a(eventMessageDetailsFragment.s().a(), "LOCATION_SHARE_FRAGMENT_TAG", true);
            Logger.a(2, EntryType.UI_INPUT_END, 113968926, a);
        }
    }

    /* compiled from: mSkeletonString */
    class C12296 implements OnClickListener {
        final /* synthetic */ EventMessageDetailsFragment f11068a;

        C12296(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11068a = eventMessageDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1555502223);
            if (this.f11068a.f11080i != null) {
                this.f11068a.f11080i.m11476a(view.getId());
            }
            EventMessageDetailsFragment eventMessageDetailsFragment = this.f11068a;
            eventMessageDetailsFragment.f11072a.m11490a(2131240998, new C12318(eventMessageDetailsFragment));
            Logger.a(2, EntryType.UI_INPUT_END, 761847066, a);
        }
    }

    /* compiled from: mSkeletonString */
    class C12307 implements OnClickListener {
        final /* synthetic */ EventMessageDetailsFragment f11069a;

        C12307(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11069a = eventMessageDetailsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -485540724);
            if (this.f11069a.f11080i != null) {
                this.f11069a.f11080i.m11476a(view.getId());
            }
            EventMessageDetailsFragment eventMessageDetailsFragment = this.f11069a;
            eventMessageDetailsFragment.f11072a.m11490a(2131240999, new C12329(eventMessageDetailsFragment));
            Logger.a(2, EntryType.UI_INPUT_END, -378983304, a);
        }
    }

    /* compiled from: mSkeletonString */
    public class C12318 implements Host {
        final /* synthetic */ EventMessageDetailsFragment f11070a;

        public C12318(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11070a = eventMessageDetailsFragment;
        }

        public final void mo431a(Calendar calendar) {
            EventMessageDetailsFragment.m11461a(this.f11070a, calendar);
        }
    }

    /* compiled from: mSkeletonString */
    public class C12329 implements Host {
        final /* synthetic */ EventMessageDetailsFragment f11071a;

        public C12329(EventMessageDetailsFragment eventMessageDetailsFragment) {
            this.f11071a = eventMessageDetailsFragment;
        }

        public final void mo431a(Calendar calendar) {
            EventMessageDetailsFragment.m11465b(this.f11071a, calendar);
        }
    }

    public static void m11462a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventMessageDetailsFragment) obj).f11072a = new PickEventTimeController((Context) fbInjector.getInstance(Context.class), (TimeFormatUtil) DefaultTimeFormatUtil.a(fbInjector));
    }

    public final void m11470c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = EventMessageDetailsFragment.class;
        m11462a((Object) this, getContext());
        if (bundle != null) {
            this.f11078g = (EventMessageParams) bundle.getParcelable("group_event_creation_params");
        } else {
            this.f11078g = new EventMessageParams();
        }
    }

    public final void m11471e(Bundle bundle) {
        bundle.putParcelable("group_event_creation_params", this.f11078g);
    }

    public final View m11467a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 719019869);
        View inflate = layoutInflater.inflate(2130904046, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1243215929, a);
        return inflate;
    }

    public final void m11469a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        m11464b();
    }

    private void m11464b() {
        this.f11073b = (TextView) e(2131561323);
        this.f11073b.addTextChangedListener(new C12252(this));
        this.f11073b.setOnFocusChangeListener(new C12263(this));
        this.f11074c = (TextView) e(2131561329);
        this.f11075d = (CheckBox) e(2131561325);
        this.f11076e = (TextView) e(2131561326);
        this.f11077f = (TextView) e(2131561327);
        switch (this.f11078g.f11087g) {
            case USER_LOCATION:
            case PINNED_LOCATION:
                this.f11074c.setText(m11463b(this.f11078g.f11085e));
                break;
            case NEARBY_PLACE:
                this.f11074c.setText(this.f11078g.f11086f.f11445b);
                break;
        }
        this.f11075d.setChecked(this.f11078g.f11082b);
        this.f11075d.setOnCheckedChangeListener(new C12274(this));
        Calendar calendar = this.f11078g.f11083c;
        if (calendar != null) {
            this.f11076e.setText(m11466c(calendar));
        }
        calendar = this.f11078g.f11084d;
        if (calendar != null) {
            this.f11077f.setText(m11466c(calendar));
        }
        this.f11074c.setOnClickListener(new C12285(this));
        this.f11076e.setOnClickListener(new C12296(this));
        this.f11077f.setOnClickListener(new C12307(this));
    }

    public final void m11468a(Fragment fragment) {
        if (fragment instanceof LocationSendingDialogFragment) {
            ((LocationSendingDialogFragment) fragment).ar = this.f11079h;
        }
    }

    public static void m11460a(EventMessageDetailsFragment eventMessageDetailsFragment, LatLng latLng) {
        eventMessageDetailsFragment.f11078g.m11473a(latLng);
        eventMessageDetailsFragment.f11074c.setText(eventMessageDetailsFragment.m11463b(latLng));
        if (eventMessageDetailsFragment.f11080i != null) {
            eventMessageDetailsFragment.f11080i.m11477a(eventMessageDetailsFragment.f11078g);
        }
    }

    private String m11463b(LatLng latLng) {
        String b = b(latLng.a < 0.0d ? 2131241004 : 2131241003);
        String b2 = b(latLng.b < 0.0d ? 2131241006 : 2131241005);
        return a(2131241007, new Object[]{Double.valueOf(Math.abs(latLng.a)), b, Double.valueOf(Math.abs(latLng.b)), b2});
    }

    public static void m11461a(EventMessageDetailsFragment eventMessageDetailsFragment, Calendar calendar) {
        eventMessageDetailsFragment.f11078g.f11083c = calendar;
        eventMessageDetailsFragment.f11076e.setText(eventMessageDetailsFragment.m11466c(calendar));
        if (eventMessageDetailsFragment.f11080i != null) {
            eventMessageDetailsFragment.f11080i.m11477a(eventMessageDetailsFragment.f11078g);
        }
    }

    public static void m11465b(EventMessageDetailsFragment eventMessageDetailsFragment, Calendar calendar) {
        eventMessageDetailsFragment.f11078g.f11084d = calendar;
        eventMessageDetailsFragment.f11077f.setText(eventMessageDetailsFragment.m11466c(calendar));
        if (eventMessageDetailsFragment.f11080i != null) {
            eventMessageDetailsFragment.f11080i.m11477a(eventMessageDetailsFragment.f11078g);
        }
    }

    private String m11466c(Calendar calendar) {
        return this.f11072a.f11104a.getString(2131241008, new Object[]{PickEventTimeController.m11488c(r0.f11105b, calendar), PickEventTimeController.m11489d(r0.f11105b, calendar)});
    }
}

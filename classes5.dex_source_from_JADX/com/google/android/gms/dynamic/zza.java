package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    public T f6791a;
    public Bundle f6792b;
    public LinkedList<zza> f6793c;
    private final zzf<T> f6794d = new C07791(this);

    class C07791 implements zzf<T> {
        final /* synthetic */ zza f6780a;

        C07791(zza com_google_android_gms_dynamic_zza) {
            this.f6780a = com_google_android_gms_dynamic_zza;
        }

        public final void mo807a(T t) {
            this.f6780a.f6791a = t;
            Iterator it = this.f6780a.f6793c.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).mo809b();
            }
            this.f6780a.f6793c.clear();
            this.f6780a.f6792b = null;
        }
    }

    interface zza {
        int mo808a();

        void mo809b();
    }

    final class C07825 implements OnClickListener {
        final /* synthetic */ Context f6788a;
        final /* synthetic */ int f6789b;

        C07825(Context context, int i) {
            this.f6788a = context;
            this.f6789b = i;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1252508192);
            this.f6788a.startActivity(GoogleApiAvailability.b.a(null, this.f6789b, null));
            Logger.a(2, EntryType.UI_INPUT_END, -1264236367, a);
        }
    }

    class C07837 implements zza {
        final /* synthetic */ zza f6790a;

        C07837(zza com_google_android_gms_dynamic_zza) {
            this.f6790a = com_google_android_gms_dynamic_zza;
        }

        public final int mo808a() {
            return 5;
        }

        public final void mo809b() {
            this.f6790a.f6791a.m12667a();
        }
    }

    private void m12684a(int i) {
        while (!this.f6793c.isEmpty() && ((zza) this.f6793c.getLast()).mo808a() >= i) {
            this.f6793c.removeLast();
        }
    }

    private void m12685a(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.f6791a != null) {
            com_google_android_gms_dynamic_zza_zza.mo809b();
            return;
        }
        if (this.f6793c == null) {
            this.f6793c = new LinkedList();
        }
        this.f6793c.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.f6792b == null) {
                this.f6792b = (Bundle) bundle.clone();
            } else {
                this.f6792b.putAll(bundle);
            }
        }
        m12690a(this.f6794d);
    }

    public static void m12686a(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int a = GooglePlayServicesUtil.a(context);
        CharSequence a2 = zzg.a(context, a, GooglePlayServicesUtil.e(context));
        CharSequence b = zzg.b(context, a);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(a2);
        linearLayout.addView(textView);
        if (b != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(b);
            linearLayout.addView(button);
            button.setOnClickListener(new C07825(context, a));
        }
    }

    public final View m12687a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        m12685a(bundle, new zza(this) {
            final /* synthetic */ zza f6787e;

            public final int mo808a() {
                return 2;
            }

            public final void mo809b() {
                frameLayout.removeAllViews();
                frameLayout.addView(this.f6787e.f6791a.m12666a(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.f6791a == null) {
            m12686a(frameLayout);
        }
        return frameLayout;
    }

    public final T m12688a() {
        return this.f6791a;
    }

    public final void m12689a(final Bundle bundle) {
        m12685a(bundle, new zza(this) {
            final /* synthetic */ zza f6782b;

            public final int mo808a() {
                return 1;
            }

            public final void mo809b() {
                this.f6782b.f6791a.m12668a(bundle);
            }
        });
    }

    protected abstract void m12690a(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public final void m12691b() {
        m12685a(null, new C07837(this));
    }

    public final void m12692b(Bundle bundle) {
        if (this.f6791a != null) {
            this.f6791a.m12670b(bundle);
        } else if (this.f6792b != null) {
            bundle.putAll(this.f6792b);
        }
    }

    public final void m12693c() {
        if (this.f6791a != null) {
            this.f6791a.m12669b();
        } else {
            m12684a(5);
        }
    }

    public final void m12694d() {
        if (this.f6791a != null) {
            this.f6791a.m12671c();
        } else {
            m12684a(2);
        }
    }

    public final void m12695e() {
        if (this.f6791a != null) {
            this.f6791a.m12672d();
        } else {
            m12684a(1);
        }
    }

    public final void m12696f() {
        if (this.f6791a != null) {
            this.f6791a.m12673e();
        }
    }
}

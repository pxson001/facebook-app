package com.facebook.messaging.location.sending;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.location.sending.NearbyPlacesLoader.LoadListener;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mIsRecipientEligible */
public class SuggestedNearbyPlacesFragment extends FbFragment {
    @Inject
    public NearbyPlacesLoader f11487a;
    public NearbyPlacesView f11488b;
    @Nullable
    public NearbyPlaceClickListener f11489c;

    /* compiled from: mIsRecipientEligible */
    class C12841 implements NearbyPlaceClickListener {
        final /* synthetic */ SuggestedNearbyPlacesFragment f11485a;

        C12841(SuggestedNearbyPlacesFragment suggestedNearbyPlacesFragment) {
            this.f11485a = suggestedNearbyPlacesFragment;
        }

        public final void mo435a(NearbyPlace nearbyPlace) {
            if (this.f11485a.f11489c != null) {
                this.f11485a.f11489c.mo435a(nearbyPlace);
            }
        }
    }

    /* compiled from: mIsRecipientEligible */
    class C12852 implements LoadListener {
        final /* synthetic */ SuggestedNearbyPlacesFragment f11486a;

        C12852(SuggestedNearbyPlacesFragment suggestedNearbyPlacesFragment) {
            this.f11486a = suggestedNearbyPlacesFragment;
        }

        public final void mo441a(ImmutableList<NearbyPlace> immutableList) {
            this.f11486a.m12091a((ImmutableList) immutableList);
        }

        public final void mo440a() {
            this.f11486a.f11488b.m12084a(this.f11486a.b(2131241014));
        }
    }

    private static <T extends InjectableComponentWithContext> void m12092a(Class<T> cls, T t) {
        m12093a((Object) t, t.getContext());
    }

    private static void m12093a(Object obj, Context context) {
        ((SuggestedNearbyPlacesFragment) obj).f11487a = NearbyPlacesLoader.m12062b(FbInjector.get(context));
    }

    public final void m12101c(Bundle bundle) {
        super.c(bundle);
        m12092a(SuggestedNearbyPlacesFragment.class, (InjectableComponentWithContext) this);
    }

    public final View m12097a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1195620710);
        View inflate = layoutInflater.inflate(2130907317, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 885456011, a);
        return inflate;
    }

    public final void m12098a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f11488b = (NearbyPlacesView) e(2131567766);
        m12095e();
        aq();
        this.f11487a.m12066b();
    }

    public final void m12100b() {
        this.f11487a.m12066b();
        this.f11488b.m12082a();
    }

    private void m12095e() {
        this.f11488b.f11480a = new C12841(this);
    }

    private void aq() {
        this.f11487a.f11469f = new C12852(this);
    }

    private void m12089a(NearbyPlacesLoader nearbyPlacesLoader) {
        this.f11487a = nearbyPlacesLoader;
    }

    private void m12091a(ImmutableList<NearbyPlace> immutableList) {
        if (immutableList.isEmpty()) {
            this.f11488b.m12084a(b(2131241014));
        } else {
            this.f11488b.m12083a((ImmutableList) immutableList);
        }
    }

    public final void m12099a(NearbyPlaceClickListener nearbyPlaceClickListener) {
        this.f11489c = nearbyPlaceClickListener;
    }

    public final void m12096I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -282325645);
        super.I();
        this.f11487a.m12064a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -309709651, a);
    }
}

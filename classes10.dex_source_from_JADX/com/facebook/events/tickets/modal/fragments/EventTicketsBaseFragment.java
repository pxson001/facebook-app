package com.facebook.events.tickets.modal.fragments;

import android.os.Bundle;
import com.facebook.base.fragment.FbFragment;
import javax.annotation.Nullable;

/* compiled from: ar */
public abstract class EventTicketsBaseFragment extends FbFragment {
    private boolean f19287a;

    public boolean mo882e() {
        return false;
    }

    public void mo879c(boolean z) {
        super.c(z);
        this.f19287a = z;
    }

    public void mo880e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("is_hidden", this.f19287a);
    }

    public void mo878c(@Nullable Bundle bundle) {
        super.c(bundle);
        if (bundle != null) {
            this.f19287a = bundle.getBoolean("is_hidden", false);
        }
        if (this.f19287a) {
            kO_().a().b(this).c();
        }
    }
}

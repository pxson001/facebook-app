package com.facebook.composer.shareintent;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import javax.annotation.Nullable;

/* compiled from: context_pop_out_selected */
public class MediaChainingActivity extends FbFragmentActivity {
    private MediaChainingFragment f15854p;

    protected final void m16298b(@Nullable Bundle bundle) {
        setContentView(2130903091);
        if (bundle != null) {
            this.f15854p = (MediaChainingFragment) kO_().a(2131559223);
        }
        if (this.f15854p == null) {
            this.f15854p = new MediaChainingFragment();
            this.f15854p.g(getIntent().getExtras());
            FragmentTransaction a = kO_().a();
            a.a(2131559223, this.f15854p);
            a.b();
        }
    }
}

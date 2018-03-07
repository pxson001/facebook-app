package com.facebook.timeline.aboutpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.timeline.aboutpage.summary.CollectionsSummaryFragment;

/* compiled from: NONE */
public class CollectionsSummaryFragmentFactory implements IFragmentFactory {
    public final Fragment m13781a(Intent intent) {
        String stringExtra = intent.getStringExtra("com.facebook.katana.profile.id");
        String stringExtra2 = intent.getStringExtra("friendship_status");
        String stringExtra3 = intent.getStringExtra("subscribe_status");
        CollectionsSummaryFragment collectionsSummaryFragment = new CollectionsSummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("profile_id", stringExtra);
        bundle.putString("friendship_status", stringExtra2);
        bundle.putString("subscribe_status", stringExtra3);
        collectionsSummaryFragment.g(bundle);
        return collectionsSummaryFragment;
    }
}

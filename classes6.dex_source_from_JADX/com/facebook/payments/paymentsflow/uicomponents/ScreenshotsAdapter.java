package com.facebook.payments.paymentsflow.uicomponents;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: invitee_candidates */
public class ScreenshotsAdapter extends FragmentStatePagerAdapter {
    private Context f12303a;
    public final List<Uri> f12304b = new ArrayList();

    public ScreenshotsAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.f12303a = context;
    }

    public final Fragment m19202a(int i) {
        ScreenshotFragment screenshotFragment = new ScreenshotFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("network_image_uri", (Parcelable) this.f12304b.get(i));
        screenshotFragment.g(bundle);
        return screenshotFragment;
    }

    public final int m19203b() {
        return this.f12304b.size();
    }
}

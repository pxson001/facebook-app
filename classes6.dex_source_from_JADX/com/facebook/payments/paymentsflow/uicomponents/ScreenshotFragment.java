package com.facebook.payments.paymentsflow.uicomponents;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: inviter */
public class ScreenshotFragment extends FbFragment {
    private static final CallerContext f12300a = CallerContext.b(ScreenshotFragment.class, "network_image");
    private FbDraweeView f12301b;
    private Optional<Uri> f12302c = Absent.INSTANCE;

    public final void m19201c(Bundle bundle) {
        super.c(bundle);
        Optional fromNullable = Optional.fromNullable(this.s);
        if (fromNullable.isPresent()) {
            this.f12302c = Optional.fromNullable((Uri) ((Bundle) fromNullable.get()).getParcelable("network_image_uri"));
        }
    }

    public final View m19200a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -205769269);
        View inflate = layoutInflater.inflate(2130906958, viewGroup, false);
        this.f12301b = (FbDraweeView) FindViewUtil.b(inflate, 2131562215);
        if (this.f12302c.isPresent()) {
            this.f12301b.a((Uri) this.f12302c.get(), f12300a);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -990060511, a);
        return inflate;
    }
}

package com.facebook.nux;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.interstitial.BaseNuxScreenController;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/* compiled from: isRawUpload */
public class NuxScreenFragment extends FbFragment {
    public NuxScreen f12241a;
    public Button al;
    public NuxFlowController f12242b;
    public Intent f12243c;
    public ImageView f12244d;
    public ImageView f12245e;
    public TextView f12246f;
    public TextView f12247g;
    public ViewGroup f12248h;
    public Button f12249i;

    /* compiled from: isRawUpload */
    public class C07931 implements OnClickListener {
        final /* synthetic */ NuxScreenFragment f12238a;

        public C07931(NuxScreenFragment nuxScreenFragment) {
            this.f12238a = nuxScreenFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1845055601);
            if (this.f12238a.f12241a.f12237i.isPresent()) {
                ((BaseNuxScreenController) this.f12238a.f12241a.f12237i.get()).f12251b.m19133d();
                Logger.a(2, EntryType.UI_INPUT_END, -668046211, a);
                return;
            }
            this.f12238a.f12242b.m19133d();
            LogUtils.a(1395830443, a);
        }
    }

    /* compiled from: isRawUpload */
    public class C07942 implements OnClickListener {
        final /* synthetic */ NuxScreenFragment f12239a;

        public C07942(NuxScreenFragment nuxScreenFragment) {
            this.f12239a = nuxScreenFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1154561913);
            NuxScreenFragment nuxScreenFragment = this.f12239a;
            if (nuxScreenFragment.f12241a.f12237i.isPresent()) {
                ((BaseNuxScreenController) nuxScreenFragment.f12241a.f12237i.get()).m19148b();
            } else {
                nuxScreenFragment.f12242b.m19130a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 325668200, a);
        }
    }

    /* compiled from: isRawUpload */
    public class C07953 implements OnClickListener {
        final /* synthetic */ NuxScreenFragment f12240a;

        public C07953(NuxScreenFragment nuxScreenFragment) {
            this.f12240a = nuxScreenFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 94697860);
            NuxScreenFragment nuxScreenFragment = this.f12240a;
            if (nuxScreenFragment.f12241a.f12237i.isPresent()) {
                ((BaseNuxScreenController) nuxScreenFragment.f12241a.f12237i.get()).m19146a();
            } else {
                nuxScreenFragment.f12242b.m19132c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -620469357, a);
        }
    }

    public final View m19144a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2103494087);
        super.a(layoutInflater, viewGroup, bundle);
        Preconditions.checkNotNull(this.f12241a);
        View inflate = layoutInflater.inflate(2130905517, viewGroup, false);
        this.f12244d = (ImageView) FindViewUtil.b(inflate, 2131564301);
        this.f12245e = (ImageView) FindViewUtil.b(inflate, 2131559679);
        this.f12246f = (TextView) FindViewUtil.b(inflate, 2131564302);
        this.f12247g = (TextView) FindViewUtil.b(inflate, 2131564303);
        this.f12248h = (ViewGroup) FindViewUtil.b(inflate, 2131564304);
        this.f12249i = (Button) FindViewUtil.b(inflate, 2131564306);
        this.al = (Button) FindViewUtil.b(inflate, 2131564307);
        if (this.f12241a.f12229a) {
            this.f12244d.setVisibility(0);
        } else {
            this.f12244d.setVisibility(8);
        }
        if (this.f12241a.f12230b) {
            this.f12245e.setVisibility(0);
            this.f12245e.setOnClickListener(new C07931(this));
        } else {
            this.f12245e.setVisibility(8);
        }
        this.f12246f.setVisibility(8);
        this.f12247g.setVisibility(8);
        if (!Strings.isNullOrEmpty(this.f12241a.f12231c)) {
            this.f12246f.setText(this.f12241a.f12231c);
            this.f12246f.setVisibility(0);
        }
        if (!Strings.isNullOrEmpty(this.f12241a.f12232d)) {
            this.f12247g.setText(this.f12241a.f12232d);
            this.f12247g.setVisibility(0);
        }
        layoutInflater.inflate(this.f12241a.f12235g, this.f12248h, true);
        this.al.setText(this.f12241a.f12234f);
        this.al.setOnClickListener(new C07942(this));
        if (this.f12241a.f12233e.isPresent()) {
            this.f12249i.setText((CharSequence) this.f12241a.f12233e.get());
            this.f12249i.setOnClickListener(new C07953(this));
        } else {
            this.f12249i.setVisibility(8);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2147250037, a);
        return inflate;
    }

    public final void m19145d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1288267761);
        super.d(bundle);
        if (this.f12241a.f12237i.isPresent()) {
            ((BaseNuxScreenController) this.f12241a.f12237i.get()).m19147a(this.f12241a, this.f12242b, this.f12248h, this.f12243c, s());
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -429340989, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1258315152);
        super.mY_();
        if (this.f12241a.f12237i.isPresent()) {
            this.f12241a.f12237i.get();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1483035062, a);
    }
}

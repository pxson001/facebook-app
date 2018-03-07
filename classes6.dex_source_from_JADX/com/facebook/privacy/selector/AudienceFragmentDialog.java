package com.facebook.privacy.selector;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: fbhtml */
public class AudienceFragmentDialog extends FbDialogFragment {
    public AudienceTypeaheadFragment am;
    public OnAudienceSelectedListener an;
    public DataProvider ao;
    public Dialog ap;
    public String aq;

    /* compiled from: fbhtml */
    public class C10302 implements OnClickListener {
        final /* synthetic */ AudienceFragmentDialog f15145a;

        public C10302(AudienceFragmentDialog audienceFragmentDialog) {
            this.f15145a = audienceFragmentDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 211219670);
            this.f15145a.ap.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -463076696, a);
        }
    }

    /* compiled from: fbhtml */
    public class C10313 extends OnToolbarButtonListener {
        final /* synthetic */ AudienceFragmentDialog f15146a;

        public C10313(AudienceFragmentDialog audienceFragmentDialog) {
            this.f15146a = audienceFragmentDialog;
        }

        public final void m22735a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f15146a.ap.onBackPressed();
        }
    }

    /* compiled from: fbhtml */
    public interface OnAudienceSelectedListener {
        void m22736a(SelectablePrivacyData selectablePrivacyData);
    }

    public final void m22738a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 645093762);
        super.a(bundle);
        a(2, 0);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -553439435, a);
    }

    public final Dialog m22741c(Bundle bundle) {
        this.ap = new Dialog(this, an(), d()) {
            final /* synthetic */ AudienceFragmentDialog f15144a;

            public void onBackPressed() {
                if (this.f15144a.am != null && this.f15144a.am.m22846b()) {
                    SelectablePrivacyData e = this.f15144a.am.m22848e();
                    if (this.f15144a.an != null) {
                        this.f15144a.an.m22736a(e);
                    }
                    super.onBackPressed();
                }
            }
        };
        return this.ap;
    }

    public final View m22737a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -574197989);
        if (bundle != null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 393957604, a);
            return null;
        }
        View inflate = layoutInflater.inflate(2130903313, viewGroup, false);
        LogUtils.f(-1504133582, a);
        return inflate;
    }

    public final void m22739a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        FbTitleBarUtil.m8798a(view);
        FbTitleBar fbTitleBar = (FbTitleBar) e(2131558563);
        fbTitleBar.setTitle(this.aq);
        fbTitleBar.setHasBackButton(false);
        fbTitleBar.a(new C10302(this));
        Builder a = TitleBarButtonSpec.a();
        a.g = b(2131230733);
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C10313(this));
        this.am = (AudienceTypeaheadFragment) s().a(2131559741);
        Preconditions.checkNotNull(this.am);
        if (this.ao != null) {
            this.am.m22843a(this.ao);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -787961905);
        super.mi_();
        if (this.f == null) {
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 418944310, a);
            return;
        }
        LayoutParams attributes = this.f.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        this.f.getWindow().setAttributes((WindowManager.LayoutParams) attributes);
        LogUtils.f(-1495513969, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f != null) {
            this.f.dismiss();
        }
    }

    public final void m22740a(OnAudienceSelectedListener onAudienceSelectedListener) {
        this.an = (OnAudienceSelectedListener) Preconditions.checkNotNull(onAudienceSelectedListener);
    }
}

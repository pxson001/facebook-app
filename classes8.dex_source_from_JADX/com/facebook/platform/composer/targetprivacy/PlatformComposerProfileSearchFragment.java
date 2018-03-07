package com.facebook.platform.composer.targetprivacy;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05061;
import com.facebook.resources.ui.FbTextView;
import javax.annotation.Nullable;

/* compiled from: results_module_role */
public abstract class PlatformComposerProfileSearchFragment extends FbFragment {
    public C05061 f4300a;
    protected String f4301b;

    /* compiled from: results_module_role */
    class C05711 implements OnClickListener {
        final /* synthetic */ PlatformComposerProfileSearchFragment f4380a;

        C05711(PlatformComposerProfileSearchFragment platformComposerProfileSearchFragment) {
            this.f4380a = platformComposerProfileSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1577026685);
            this.f4380a.o().onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 796699676, a);
        }
    }

    protected abstract void mo199b();

    protected abstract FbFragment mo200e();

    public final View m4213a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1496613888);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906314, viewGroup, false);
        mo199b();
        ((FbTextView) viewGroup2.findViewById(2131559636)).setText(this.f4301b);
        viewGroup2.findViewById(2131559455).setOnClickListener(new C05711(this));
        FragmentTransaction a2 = this.D.a();
        a2.a(2131566125, mo200e());
        a2.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 938704087, a);
        return viewGroup2;
    }
}

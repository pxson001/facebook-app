package com.facebook.katana.fragment;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.asserts.Assert;
import com.facebook.katana.activity.FacebookActivity;

/* compiled from: useEntityCard */
public abstract class BaseFacebookFragment extends FbFragment implements IRefreshableFragment {
    private String f839a;

    public final FacebookActivity aq() {
        Activity ao = ao();
        if (ao instanceof FacebookActivity) {
            return (FacebookActivity) ao;
        }
        return null;
    }

    public DialogFragment mo33g(int i) {
        return null;
    }

    public final void m820h(int i) {
        DialogFragment g = mo33g(i);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("Cannot create dialog for %s. Check onCreateDialogFragment(int) method", Integer.valueOf(i));
        if (Assert.a()) {
            junit.framework.Assert.assertNotNull(formatStrLocaleSafe, g);
        }
        FragmentManager fragmentManager = this.D;
        FragmentTransaction a = fragmentManager.a();
        String k = m818k(i);
        Fragment a2 = fragmentManager.a(k);
        if (a2 != null) {
            a.a(a2);
        }
        a.a(4097);
        g.a(a, k, true);
    }

    public static String m818k(int i) {
        return StringFormatUtil.formatStrLocaleSafe("dialogFragment:tag:%s", Integer.valueOf(i));
    }

    public final String ar() {
        if (this.f839a == null) {
            FacebookActivity aq = aq();
            this.f839a = aq != null ? aq.i().d() : "NONE_FACEBOOK_ACTIVITY";
        }
        return this.f839a;
    }

    public final void m821i(int i) {
        FragmentManager fragmentManager = this.D;
        if (fragmentManager != null) {
            String k = m818k(i);
            Fragment a = fragmentManager.a(k);
            if (a instanceof DialogFragment) {
                ((DialogFragment) a).a();
                return;
            }
            k = "Expect a DialogFragment for tag: " + k;
            if (Assert.a()) {
                junit.framework.Assert.assertNull(k, a);
            }
        }
    }
}

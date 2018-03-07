package com.facebook.devicebasedlogin.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import javax.inject.Inject;

/* compiled from: The number of components does not match the size of the weight list */
public class DBLLoginSettingsAccountsListFragment extends FbListFragment implements IAuthNotRequired, IFbResourcesNotRequired {
    private static final Class<?> am = DBLLoginSettingsAccountsListFragment.class;
    public DBLLoginSettingsListener al;
    @Inject
    public DBLAccountsListAdapter f24193i;

    public static void m26157a(Object obj, Context context) {
        ((DBLLoginSettingsAccountsListFragment) obj).f24193i = DBLAccountsListAdapter.m26138b(FbInjector.get(context));
    }

    public final void m26160a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -274608655);
        super.a(bundle);
        Class cls = DBLLoginSettingsAccountsListFragment.class;
        m26157a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1634400811, a);
    }

    public final View m26159a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2072230654);
        View inflate = layoutInflater.inflate(2130903852, viewGroup, false);
        ((TextView) inflate.findViewById(2131559592)).setText(2131236239);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2096802974, a);
        return inflate;
    }

    public final void m26162d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1415553762);
        super.d(bundle);
        a(this.f24193i);
        this.f24193i.f24176d = 2130903853;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -289413257, a);
    }

    public final void m26158G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 973984023);
        super.G();
        if (!(this.f24193i.m26139a() || this.al == null)) {
            this.al.m26163a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1320511599, a);
    }

    public final void m26161a(View view, int i) {
        DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) this.a.getItem(i);
        this.al.m26164a(dBLFacebookCredentials);
        String str = dBLFacebookCredentials.mUsername;
    }
}

package com.facebook.platform.composer.targetprivacy;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.FriendsQuery;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05061;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05094;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbEditText;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.listview.BetterListView;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: results_module_items_count */
public class PlatformComposerFriendsFragment extends FbFragment {
    protected BetterListView f4308a;
    public C05094 al;
    public boolean am;
    public PlatformComposerFriendsSelectorAdapter an;
    private QueryHandler ao;
    public String ap;
    private final OnItemClickListener aq = new C05501(this);
    public C05061 ar;
    @Inject
    TasksManager f4309b;
    @Inject
    AddressBookPeriodicRunner f4310c;
    @Inject
    public FunnelLoggerImpl f4311d;
    @Inject
    NameNormalizer f4312e;
    @Inject
    QeAccessor f4313f;
    public FbEditText f4314g;
    public FbTextView f4315h;
    public View f4316i;

    /* compiled from: results_module_items_count */
    class C05501 implements OnItemClickListener {
        final /* synthetic */ PlatformComposerFriendsFragment f4303a;

        C05501(PlatformComposerFriendsFragment platformComposerFriendsFragment) {
            this.f4303a = platformComposerFriendsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlatformComposerFriendsFragment platformComposerFriendsFragment = this.f4303a;
            if (platformComposerFriendsFragment.an.getItem(i) != null) {
                FacebookProfile facebookProfile = (FacebookProfile) platformComposerFriendsFragment.an.getItem(i);
                if (facebookProfile != null) {
                    Builder builder = new Builder(facebookProfile.mId, TargetType.USER);
                    builder.c = facebookProfile.mDisplayName;
                    builder = builder;
                    builder.d = facebookProfile.mImageUrl;
                    ComposerTargetData a = builder.a();
                    if (platformComposerFriendsFragment.ar != null) {
                        platformComposerFriendsFragment.ar.m3966a(a);
                    }
                    platformComposerFriendsFragment.f4311d.b(FunnelRegistry.l, "target_privacy_picker_friend_selected");
                }
            }
        }
    }

    /* compiled from: results_module_items_count */
    class C05512 implements TextWatcher {
        final /* synthetic */ PlatformComposerFriendsFragment f4304a;

        C05512(PlatformComposerFriendsFragment platformComposerFriendsFragment) {
            this.f4304a = platformComposerFriendsFragment;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f4304a.ap = charSequence.toString().trim();
            this.f4304a.an.f4320c.filter(this.f4304a.ap);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: results_module_items_count */
    class C05523 implements Runnable {
        final /* synthetic */ PlatformComposerFriendsFragment f4305a;

        C05523(PlatformComposerFriendsFragment platformComposerFriendsFragment) {
            this.f4305a = platformComposerFriendsFragment;
        }

        public void run() {
            ((InputMethodManager) this.f4305a.o().getSystemService("input_method")).showSoftInput(this.f4305a.f4314g, 0);
        }
    }

    /* compiled from: results_module_items_count */
    class C05534 implements OnClickListener {
        final /* synthetic */ PlatformComposerFriendsFragment f4306a;

        C05534(PlatformComposerFriendsFragment platformComposerFriendsFragment) {
            this.f4306a = platformComposerFriendsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1297694444);
            if (this.f4306a.al != null) {
                this.f4306a.al.m3969a(80);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -542855244, a);
        }
    }

    /* compiled from: results_module_items_count */
    class QueryHandler extends AsyncQueryHandler {
        private WeakReference<PlatformComposerFriendsFragment> f4307a;

        public QueryHandler(Context context, WeakReference<PlatformComposerFriendsFragment> weakReference) {
            super(context.getContentResolver());
            this.f4307a = weakReference;
        }

        protected void onQueryComplete(int i, Object obj, Cursor cursor) {
            PlatformComposerFriendsFragment platformComposerFriendsFragment = (PlatformComposerFriendsFragment) this.f4307a.get();
            if (platformComposerFriendsFragment != null) {
                FragmentActivity o = platformComposerFriendsFragment.o();
                if (o != null) {
                    if (o.isFinishing()) {
                        cursor.close();
                        return;
                    }
                    o.startManagingCursor(cursor);
                }
                platformComposerFriendsFragment.an.f1207d = cursor;
                if (!StringUtil.a(new CharSequence[]{platformComposerFriendsFragment.ap})) {
                    platformComposerFriendsFragment.an.f4320c.filter(platformComposerFriendsFragment.ap);
                }
                PlatformComposerFriendsFragment.m4220b(platformComposerFriendsFragment);
            }
        }
    }

    public static void m4219a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlatformComposerFriendsFragment) obj).m4218a(TasksManager.b(fbInjector), AddressBookPeriodicRunner.a(fbInjector), FunnelLoggerImpl.a(fbInjector), NameNormalizer.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m4218a(TasksManager tasksManager, AddressBookPeriodicRunner addressBookPeriodicRunner, FunnelLoggerImpl funnelLoggerImpl, NameNormalizer nameNormalizer, QeAccessor qeAccessor) {
        this.f4309b = tasksManager;
        this.f4310c = addressBookPeriodicRunner;
        this.f4311d = funnelLoggerImpl;
        this.f4312e = nameNormalizer;
        this.f4313f = qeAccessor;
    }

    public static PlatformComposerFriendsFragment m4222n(Bundle bundle) {
        PlatformComposerFriendsFragment platformComposerFriendsFragment = new PlatformComposerFriendsFragment();
        platformComposerFriendsFragment.g(bundle);
        return platformComposerFriendsFragment;
    }

    public final void m4226c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerFriendsFragment.class;
        m4219a(this, getContext());
        this.an = new PlatformComposerFriendsSelectorAdapter(getContext(), null, this.f4312e, this.f4313f);
        this.ao = new QueryHandler(getContext(), new WeakReference(this));
    }

    public final View m4225a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2071224189);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906312, viewGroup, false);
        View findViewById = viewGroup2.findViewById(2131566122);
        this.f4314g = (FbEditText) viewGroup2.findViewById(2131566123);
        this.f4314g.setText(this.ap);
        this.f4314g.addTextChangedListener(new C05512(this));
        this.f4314g.setFocusable(this.am);
        if (this.am) {
            this.f4314g.requestFocus();
            this.f4314g.postDelayed(new C05523(this), 100);
        } else {
            OnClickListener c05534 = new C05534(this);
            this.f4314g.setOnClickListener(c05534);
            findViewById.setOnClickListener(c05534);
        }
        findViewById = viewGroup2.findViewById(16908292);
        this.f4308a = (BetterListView) viewGroup2.findViewById(16908298);
        this.f4308a.setEmptyView(findViewById);
        this.f4308a.setOnItemClickListener(this.aq);
        this.f4308a.setAdapter(this.an);
        this.f4315h = (FbTextView) viewGroup2.findViewById(2131561172);
        this.f4316i = viewGroup2.findViewById(2131561173);
        if (this.f4315h != null) {
            this.f4315h.setText(2131238393);
        }
        LogUtils.f(454162580, a);
        return viewGroup2;
    }

    public final void m4223G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 536323473);
        super.G();
        m4221b(true);
        if (this.an.f1207d == null) {
            this.ao.startQuery(1, null, ContactsConnectionsContract.g, FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1726781521, a);
    }

    public final void m4224H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1083993326);
        super.H();
        this.f4309b.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1053195659, a);
    }

    public static void m4220b(PlatformComposerFriendsFragment platformComposerFriendsFragment) {
        if (platformComposerFriendsFragment.an.f1207d == null) {
            platformComposerFriendsFragment.m4221b(true);
            return;
        }
        platformComposerFriendsFragment.m4221b(false);
        platformComposerFriendsFragment.an.mo57a(platformComposerFriendsFragment.an.f1207d);
        if (platformComposerFriendsFragment.an.getCount() == 0) {
            platformComposerFriendsFragment.f4310c.a();
            platformComposerFriendsFragment.m4221b(true);
        }
        platformComposerFriendsFragment.f4314g.setEnabled(true);
    }

    private void m4221b(boolean z) {
        int i;
        if (z) {
            this.f4315h.setVisibility(8);
            this.f4316i.setVisibility(0);
        } else {
            this.f4315h.setVisibility(0);
            this.f4316i.setVisibility(8);
        }
        int i2 = 8;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        if (!z) {
            i2 = 0;
        }
        this.f4316i.setVisibility(i);
        this.f4315h.setVisibility(i2);
    }
}

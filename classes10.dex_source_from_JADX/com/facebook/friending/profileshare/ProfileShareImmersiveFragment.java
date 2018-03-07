package com.facebook.friending.profileshare;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.friending.profileshare.logging.ProfileShareAnalyticsLogger;
import com.facebook.friending.profileshare.logging.ProfileShareAnalyticsLogger.Source;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.HasTitleBar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ad_width */
public class ProfileShareImmersiveFragment extends FbFragment {
    @Inject
    ProfileShareAdapterProvider f20268a;
    @Nullable
    public Intent al;
    @Inject
    ProfileShareAnalyticsLogger f20269b;
    @Inject
    SecureContextHelper f20270c;
    @Inject
    Clock f20271d;
    @Inject
    ProfileShareController f20272e;
    @Inject
    RuntimePermissionsUtil f20273f;
    private ProfileShareAdapter f20274g;
    private BetterRecyclerView f20275h;
    private LinearLayoutManager f20276i;

    /* compiled from: ad_width */
    class C28901 implements OnClickListener {
        final /* synthetic */ ProfileShareImmersiveFragment f20267a;

        C28901(ProfileShareImmersiveFragment profileShareImmersiveFragment) {
            this.f20267a = profileShareImmersiveFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1537976041);
            ProfileShareItem profileShareItem = (ProfileShareItem) view.getTag(2131558805);
            long a2 = this.f20267a.f20271d.a() / 1000;
            this.f20267a.f20269b.m20565a(profileShareItem.f20277a, a2);
            Intent intent = profileShareItem.f20279c;
            intent.putExtra("android.intent.extra.TEXT", this.f20267a.f20272e.m20542a(a2));
            if (intent.getExtras().getBoolean("IS_SMS_INTENT_TAG") && this.f20267a.f20273f.a("android.permission.READ_CONTACTS")) {
                this.f20267a.al = intent;
                this.f20267a.f20270c.b(new Intent("android.intent.action.PICK").setData(Phone.CONTENT_URI), 1, this.f20267a);
                Logger.a(2, EntryType.UI_INPUT_END, -1627163612, a);
                return;
            }
            this.f20267a.f20270c.b(intent, this.f20267a.getContext());
            LogUtils.a(732667475, a);
        }
    }

    public static void m20553a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileShareImmersiveFragment) obj).m20552a((ProfileShareAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfileShareAdapterProvider.class), ProfileShareAnalyticsLogger.m20561a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ProfileShareController.m20540b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    private void m20552a(ProfileShareAdapterProvider profileShareAdapterProvider, ProfileShareAnalyticsLogger profileShareAnalyticsLogger, SecureContextHelper secureContextHelper, Clock clock, ProfileShareController profileShareController, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f20268a = profileShareAdapterProvider;
        this.f20269b = profileShareAnalyticsLogger;
        this.f20270c = secureContextHelper;
        this.f20271d = clock;
        this.f20272e = profileShareController;
        this.f20273f = runtimePermissionsUtil;
    }

    public final void m20559c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileShareImmersiveFragment.class;
        m20553a((Object) this, getContext());
        this.f20274g = this.f20268a.m20538a(true);
    }

    public final View m20556a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -274302541);
        View inflate = layoutInflater.inflate(2130906477, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -926126479, a);
        return inflate;
    }

    public final void m20558a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f20275h = (BetterRecyclerView) e(2131566406);
        this.f20276i = new BetterLinearLayoutManager(getContext());
        this.f20275h.setLayoutManager(this.f20276i);
        this.f20275h.setAdapter(this.f20274g);
        this.f20274g.f20247b = new C28901(this);
        List<ProfileShareItem> a = this.f20272e.m20543a();
        List arrayList = new ArrayList(a.size());
        for (ProfileShareItem profileShareItem : a) {
            arrayList.add(profileShareItem.f20277a);
        }
        this.f20269b.m20564a(Source.NEWS_FEED_QP, arrayList);
        this.f20274g.m20537a(a);
    }

    public final void m20554G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1041453921);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131241359);
            hasTitleBar.c(true);
            hasTitleBar.a(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2141528176, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1434865540);
        this.f20275h = null;
        this.f20276i = null;
        this.f20269b.m20563a();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1838937659, a);
    }

    public final void m20555I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -888082029);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -860193134, a);
    }

    public final void m20557a(int i, int i2, Intent intent) {
        Cursor query;
        Throwable th;
        Cursor cursor = null;
        if (i2 != -1) {
            this.f20269b.m20566a("canceled", null);
            return;
        }
        switch (i) {
            case 1:
                String lastPathSegment = intent.getData().getLastPathSegment();
                try {
                    query = getContext().getContentResolver().query(Phone.CONTENT_URI, new String[]{"data1"}, "_id = ?", new String[]{lastPathSegment}, null);
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndex("data1"));
                            this.f20269b.m20566a("success", string);
                            this.al.putExtra("address", string);
                            this.f20270c.b(this.al, getContext());
                        }
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        try {
                            this.f20269b.m20566a("exception", null);
                            if (query != null) {
                                query.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            cursor = query;
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    query = null;
                    this.f20269b.m20566a("exception", null);
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            default:
                return;
        }
    }
}

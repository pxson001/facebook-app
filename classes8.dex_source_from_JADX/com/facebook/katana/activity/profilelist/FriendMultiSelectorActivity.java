package com.facebook.katana.activity.profilelist;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.FriendsQuery;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: unhandled image view attribute =  */
public class FriendMultiSelectorActivity extends ProfileListActivity implements AnalyticsActivity, UsesSimpleStringTitle {
    private FbTitleBarSupplier f1195A;
    protected QueryHandler f1196p;
    protected ImmutableSet<Long> f1197q;
    protected ArrayList<FacebookProfile> f1198r = Lists.a();
    protected int f1199s;
    protected ImageView f1200t;
    protected TextView f1201u;
    protected String f1202v;
    public AddressBookPeriodicRunner f1203w;
    private ComposerAnalyticsLogger f1204x;
    private NameNormalizer f1205y;
    private QeAccessor f1206z;

    /* compiled from: unhandled image view attribute =  */
    class C01071 extends OnToolbarButtonListener {
        final /* synthetic */ FriendMultiSelectorActivity f1188a;

        C01071(FriendMultiSelectorActivity friendMultiSelectorActivity) {
            this.f1188a = friendMultiSelectorActivity;
        }

        public final void m1428a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            FriendMultiSelectorActivity.m1441j(this.f1188a);
        }
    }

    /* compiled from: unhandled image view attribute =  */
    class C01082 implements TextWatcher {
        final /* synthetic */ FriendMultiSelectorActivity f1189a;

        C01082(FriendMultiSelectorActivity friendMultiSelectorActivity) {
            this.f1189a = friendMultiSelectorActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f1189a.f1202v = charSequence.toString().trim();
            ((SelectableProfileListNaiveCursorAdapter) this.f1189a.f1192B).f1212h.filter(this.f1189a.f1202v);
            this.f1189a.f1193C.setFastScrollEnabled(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int i;
            if (editable.length() > 0) {
                i = 17301594;
            } else {
                i = 2130840885;
            }
            this.f1189a.f1200t.setImageResource(i);
        }
    }

    /* compiled from: unhandled image view attribute =  */
    class C01093 implements OnClickListener {
        final /* synthetic */ FriendMultiSelectorActivity f1190a;

        C01093(FriendMultiSelectorActivity friendMultiSelectorActivity) {
            this.f1190a = friendMultiSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1967503766);
            if (this.f1190a.f1201u.length() > 0) {
                this.f1190a.f1201u.setText("");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1462766272, a);
        }
    }

    /* compiled from: unhandled image view attribute =  */
    final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ FriendMultiSelectorActivity f1191a;

        public QueryHandler(FriendMultiSelectorActivity friendMultiSelectorActivity, Context context) {
            this.f1191a = friendMultiSelectorActivity;
            super(context.getContentResolver());
        }

        protected final void onQueryComplete(int i, Object obj, Cursor cursor) {
            int i2 = false;
            if (this.f1191a.isFinishing()) {
                cursor.close();
                return;
            }
            this.f1191a.m1434a(1, false);
            this.f1191a.startManagingCursor(cursor);
            ((SelectableProfileListNaiveCursorAdapter) this.f1191a.f1192B).mo57a(cursor);
            if (this.f1191a.f1192B.getCount() == 0) {
                this.f1191a.f1203w.a();
                this.f1191a.m1434a(2, true);
            }
            while (i2 < this.f1191a.f1192B.getCount()) {
                FacebookProfile facebookProfile = (FacebookProfile) this.f1191a.f1192B.getItem(i2);
                if (facebookProfile != null && this.f1191a.f1197q.contains(Long.valueOf(facebookProfile.mId))) {
                    this.f1191a.f1198r.add(facebookProfile);
                }
                i2++;
            }
        }
    }

    private static <T extends Context> void m1438a(Class<T> cls, T t) {
        m1439a((Object) t, (Context) t);
    }

    public static void m1439a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendMultiSelectorActivity) obj).m1435a(AddressBookPeriodicRunner.a(fbInjector), ComposerAnalyticsLogger.a(fbInjector), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), NameNormalizer.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private static Intent m1432a(Context context, Set<Long> set) {
        Intent intent = new Intent(context, FriendMultiSelectorActivity.class);
        intent.putExtra("profiles", Longs.a(set));
        return intent;
    }

    public static Intent m1433a(Context context, Set<Long> set, Set<Long> set2) {
        Intent a = m1432a(context, (Set) set);
        a.putExtra("exclude_profiles", Longs.a(set2));
        return a;
    }

    @Inject
    private void m1435a(AddressBookPeriodicRunner addressBookPeriodicRunner, ComposerAnalyticsLogger composerAnalyticsLogger, FbTitleBarSupplier fbTitleBarSupplier, NameNormalizer nameNormalizer, QeAccessor qeAccessor) {
        this.f1203w = addressBookPeriodicRunner;
        this.f1204x = composerAnalyticsLogger;
        this.f1195A = fbTitleBarSupplier;
        this.f1205y = nameNormalizer;
        this.f1206z = qeAccessor;
    }

    public final void mo55b(Bundle bundle) {
        ImmutableSet immutableSet;
        super.mo55b(bundle);
        Class cls = FriendMultiSelectorActivity.class;
        m1439a((Object) this, (Context) this);
        this.f1197q = ImmutableSet.copyOf(Longs.a(bundle != null ? bundle.getLongArray("profiles") : getIntent().getLongArrayExtra("profiles")));
        long[] longArrayExtra = getIntent().getLongArrayExtra("exclude_profiles");
        if (longArrayExtra == null) {
            immutableSet = RegularImmutableSet.a;
        } else {
            immutableSet = ImmutableSet.copyOf(Longs.a(longArrayExtra));
        }
        this.B = new SelectableProfileListNaiveCursorAdapter(this, null, this.f1197q, this.f1205y, this.f1206z, immutableSet);
        this.f1196p = new QueryHandler(this, this);
        m1442k();
        this.f1201u.requestFocus();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLongArray("profiles", Longs.a(this.f1197q));
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -781917668);
        super.onStart();
        Builder a2 = TitleBarButtonSpec.a();
        a2.g = getString(2131237360);
        ((FbTitleBar) this.f1195A.get()).setButtonSpecs(ImmutableList.of(a2.a()));
        ((FbTitleBar) this.f1195A.get()).setOnToolbarButtonListener(new C01071(this));
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 555283472, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -502957563);
        super.onResume();
        if (((SelectableProfileListNaiveCursorAdapter) this.f1192B).f1207d == null) {
            m1434a(1, true);
            this.f1196p.startQuery(1, null, ContactsConnectionsContract.g, FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1777551740, a);
    }

    public final void mo54a(View view, int i) {
        SelectableProfileListNaiveCursorAdapter selectableProfileListNaiveCursorAdapter = (SelectableProfileListNaiveCursorAdapter) this.f1192B;
        FacebookProfile facebookProfile = (FacebookProfile) selectableProfileListNaiveCursorAdapter.getItem(i);
        if (selectableProfileListNaiveCursorAdapter.f1217k == null || !selectableProfileListNaiveCursorAdapter.f1217k.contains(Long.valueOf(facebookProfile.mId))) {
            CheckBoxViewAdapter checkBoxViewAdapter = selectableProfileListNaiveCursorAdapter.f1216c;
            Long valueOf = Long.valueOf(facebookProfile.mId);
            CheckBox checkBox = (CheckBox) view.findViewById(2131560310);
            if (checkBoxViewAdapter.f1187a.contains(valueOf)) {
                checkBoxViewAdapter.f1187a.remove(valueOf);
                checkBox.setChecked(false);
            } else {
                checkBoxViewAdapter.f1187a.add(valueOf);
                checkBox.setChecked(true);
            }
        }
        FacebookProfile facebookProfile2 = (FacebookProfile) this.f1192B.getItem(i);
        if (this.f1197q.contains(Long.valueOf(facebookProfile2.mId))) {
            this.f1198r.add(facebookProfile2);
        } else {
            this.f1198r.remove(facebookProfile2);
        }
    }

    public static void m1441j(FriendMultiSelectorActivity friendMultiSelectorActivity) {
        KeyboardUtils.a(friendMultiSelectorActivity);
        Intent intent = new Intent();
        intent.putExtra("profiles", Longs.a(friendMultiSelectorActivity.f1197q));
        intent.putExtra("full_profiles", friendMultiSelectorActivity.f1198r);
        friendMultiSelectorActivity.setResult(-1, intent);
        friendMultiSelectorActivity.finish();
    }

    private void m1442k() {
        setContentView(2130907024);
        m1431i();
        m1443l();
        this.f1193C.setAdapter(this.f1192B);
        this.f1201u = (TextView) findViewById(2131566358);
        this.f1201u.setText(this.f1202v);
        this.f1201u.addTextChangedListener(new C01082(this));
        this.f1200t = (ImageView) findViewById(2131566359);
        this.f1200t.setOnClickListener(new C01093(this));
    }

    private void m1443l() {
        ((TextView) findViewById(2131561172)).setText(2131234717);
    }

    private void m1434a(int i, boolean z) {
        int i2;
        if (z) {
            this.f1199s |= i;
        } else {
            this.f1199s &= i ^ -1;
        }
        if (this.f1199s != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            findViewById(2131561172).setVisibility(8);
            findViewById(2131561173).setVisibility(0);
            return;
        }
        findViewById(2131561172).setVisibility(0);
        findViewById(2131561173).setVisibility(8);
    }

    public final String m1444a() {
        return getString(2131234715);
    }

    public final String am_() {
        return "select_friends_view";
    }
}

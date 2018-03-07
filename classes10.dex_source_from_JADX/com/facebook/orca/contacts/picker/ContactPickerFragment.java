package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FindViewUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.contacts.picker.PickableContactPickerRow;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.ForDivebarList;
import com.facebook.messaging.annotations.ForFacebookList;
import com.facebook.messaging.annotations.ForVoipGroupCallList;
import com.facebook.messaging.annotations.ForVoipSearchList;
import com.facebook.messaging.annotations.ForVoipSelectSearchList;
import com.facebook.messaging.contacts.picker.ContactPickerHackListAdapter;
import com.facebook.messaging.smsbridge.SmsBridgeHelper;
import com.facebook.messaging.smsbridge.SmsBridgeHelper.C06411;
import com.facebook.messaging.smsbridge.SmsBridgePrefKeys;
import com.facebook.orca.contacts.picker.UserTokenFactory.C09281;
import com.facebook.orca.contacts.picker.UserTokenFactory.C09292;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.User;
import com.facebook.user.model.UserFbidIdentifier;
import com.facebook.user.model.UserIdentifier;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.TokenPickerEditableUtil;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipToken;
import com.facebook.widget.tokenizedtypeahead.model.HasUser;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Provider;

/* compiled from: nux_upload_with_contact_matching_flow */
public class ContactPickerFragment extends FbFragment {
    private static final Class<?> f6050a = ContactPickerFragment.class;
    public ImmutableList<User> aA;
    public boolean aB = false;
    public OnContactPickerTextChangedListener aC;
    public OnMaxRecipientReachedListener aD;
    public OnRowClickedListener aE;
    private boolean aF = true;
    private int aG;
    public Drawable aH;
    public int aI = Integer.MAX_VALUE;
    private int aJ = 2131231635;
    private int aK = 2131231636;
    public ArrayList<User> aL = new ArrayList();
    public ArrayList<PickableContactPickerRow> aM;
    public boolean aN = false;
    private boolean aO = true;
    public boolean aP = false;
    public Mode aQ;
    public int aR = -1;
    public CharSequence aS = "";
    private TextWatcher aT = new C09181(this);
    @Inject
    @ForVoipSearchList
    private Provider<BaseSearchableContactPickerListAdapter> al;
    @ForVoipSelectSearchList
    @Inject
    private Provider<BaseSearchableContactPickerListAdapter> am;
    @Inject
    @ForVoipGroupCallList
    private Provider<BaseSearchableContactPickerListAdapter> an;
    @Inject
    private SmsBridgeHelper ao;
    private Context ap;
    public BaseSearchableContactPickerListAdapter aq;
    public OnPrimaryContactTypeChangedListener ar;
    private OnPickedContactsChangedListener as;
    public OnContactAddedOrRemovedListener at;
    public RowCreator au;
    private TypeaheadViewCreator av = new DefaultTypeaheadViewCreator();
    private View aw;
    public TokenizedAutoCompleteTextView ax;
    public TextView ay;
    private ViewGroup az;
    @Inject
    private AddressBookPeriodicRunner f6051b;
    @Inject
    private ErrorDialogs f6052c;
    @Inject
    @ForDivebarList
    private Provider<BaseSearchableContactPickerListAdapter> f6053d;
    @ForFacebookList
    @Inject
    private Provider<BaseSearchableContactPickerListAdapter> f6054e;
    @Inject
    private InputMethodManager f6055f;
    @IsWorkBuild
    @Inject
    private Boolean f6056g;
    @Inject
    public TokenPickerEditableUtil f6057h;
    @Inject
    private UserTokenFactory f6058i;

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnContactPickerTextChangedListener {
        void mo223a(String str, boolean z);
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnMaxRecipientReachedListener {
        void mo224a();
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnRowClickedListener {
        void mo225a(ContactPickerRow contactPickerRow);
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    class C09181 implements TextWatcher {
        final /* synthetic */ ContactPickerFragment f6034a;
        private boolean f6035b;

        C09181(ContactPickerFragment contactPickerFragment) {
            this.f6034a = contactPickerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f6035b = false;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f6035b = i2 > i3;
        }

        public void afterTextChanged(Editable editable) {
            if (this.f6034a.mx_()) {
                if (this.f6034a.aN) {
                    this.f6034a.ax.removeTextChangedListener(this);
                    this.f6034a.ax.b();
                    int size = this.f6034a.aL.size();
                    for (int i = 0; i < size; i++) {
                        ContactPickerFragment.m5738b(this.f6034a, (User) this.f6034a.aL.get(i), null, ContactRowSectionType.UNKNOWN, -1);
                    }
                    this.f6034a.aL.clear();
                    this.f6034a.aM.clear();
                    this.f6034a.aN = false;
                    this.f6034a.ax.a(this.f6034a.aS);
                    this.f6034a.ax.addTextChangedListener(this);
                } else {
                    if (this.f6035b) {
                        this.f6034a.ax.removeTextChangedListener(this);
                        this.f6034a.f6057h.a(editable);
                        this.f6034a.ax.addTextChangedListener(this);
                    }
                    this.f6034a.m5732a(editable.toString(), this.f6034a.ax.enoughToFilter());
                    this.f6034a.au();
                }
                if (editable.length() == 0) {
                    ContactPickerFragment.aD(this.f6034a);
                } else {
                    this.f6034a.ay.setVisibility(8);
                }
            }
        }
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    class C09192 implements OnItemClickListener {
        final /* synthetic */ ContactPickerFragment f6036a;

        C09192(ContactPickerFragment contactPickerFragment) {
            this.f6036a = contactPickerFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ContactPickerFragment.m5737b(this.f6036a, i, this.f6036a.ax.o);
        }
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    class C09225 implements OnScrollListener {
        final /* synthetic */ ContactPickerFragment f6046a;

        C09225(ContactPickerFragment contactPickerFragment) {
            this.f6046a = contactPickerFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (1 == i) {
                this.f6046a.ax();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public enum ListType {
        VOIP_SEARCH_LIST,
        VOIP_SELECT_SEARCH_LIST,
        VOIP_GROUP_CALL_LIST,
        DIVEBAR_LIST,
        FACEBOOK_LIST
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public enum Mode {
        ADD_MEMBERS,
        OMNI_PICKER
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnContactAddedOrRemovedListener {
        void mo228a(User user);

        void mo229b(User user);
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnPickedContactsChangedListener {
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface OnPrimaryContactTypeChangedListener {
        void mo227a();
    }

    /* compiled from: nux_upload_with_contact_matching_flow */
    public interface TypeaheadViewCreator {
        View mo226a(LayoutInflater layoutInflater, ViewGroup viewGroup);
    }

    @Deprecated
    private static <T> void m5730a(Class<T> cls, T t, Context context) {
        m5731a((Object) t, context);
    }

    public static void m5731a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactPickerFragment) obj).m5725a(AddressBookPeriodicRunner.a(fbInjector), ErrorDialogs.a(fbInjector), IdBasedProvider.a(fbInjector, 5362), IdBasedProvider.a(fbInjector, 5363), InputMethodManagerMethodAutoProvider.b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), TokenPickerEditableUtil.a(fbInjector), UserTokenFactory.m5813b(fbInjector), IdBasedProvider.a(fbInjector, 5370), IdBasedProvider.a(fbInjector, 5371), IdBasedProvider.a(fbInjector, 5369), SmsBridgeHelper.m3878a(fbInjector));
    }

    private void m5725a(AddressBookPeriodicRunner addressBookPeriodicRunner, ErrorDialogs errorDialogs, Provider<BaseSearchableContactPickerListAdapter> provider, Provider<BaseSearchableContactPickerListAdapter> provider2, InputMethodManager inputMethodManager, Boolean bool, TokenPickerEditableUtil tokenPickerEditableUtil, UserTokenFactory userTokenFactory, Provider<BaseSearchableContactPickerListAdapter> provider3, Provider<BaseSearchableContactPickerListAdapter> provider4, Provider<BaseSearchableContactPickerListAdapter> provider5, SmsBridgeHelper smsBridgeHelper) {
        this.f6051b = addressBookPeriodicRunner;
        this.f6052c = errorDialogs;
        this.f6053d = provider;
        this.f6054e = provider2;
        this.f6055f = inputMethodManager;
        this.f6056g = bool;
        this.f6057h = tokenPickerEditableUtil;
        this.f6058i = userTokenFactory;
        this.al = provider3;
        this.am = provider4;
        this.an = provider5;
        this.ao = smsBridgeHelper;
    }

    private void m5724a(final int i, final ContactPickerUserRow contactPickerUserRow) {
        final User user = contactPickerUserRow.a;
        m5729a(user, new Runnable(this) {
            final /* synthetic */ ContactPickerFragment f6040d;

            public void run() {
                if (this.f6040d.aE != null) {
                    this.f6040d.aE.mo225a(contactPickerUserRow);
                }
                if (!this.f6040d.aP) {
                    ContactPickerFragment.m5738b(this.f6040d, user, contactPickerUserRow, ContactRowSectionType.SEARCH_RESULT, i);
                }
                this.f6040d.m5732a(this.f6040d.ax.getText().toString(), false);
            }
        });
    }

    public final void m5770c(Bundle bundle) {
        boolean z = true;
        super.c(bundle);
        if (this.aR > 0) {
            this.ap = new ContextThemeWrapper(getContext(), this.aR);
        } else {
            this.ap = ContextUtils.a(getContext(), 2130772969, 2131625113);
        }
        Class cls = ContactPickerFragment.class;
        m5731a((Object) this, this.ap);
        this.f6051b.a();
        if (bundle != null) {
            this.aF = bundle.getBoolean("selectionOnResume", true);
            this.aO = bundle.getBoolean("isTokenEnabled", true);
            if (this.aO) {
                this.aL = bundle.getParcelableArrayList("userWithIdentifier");
                if (this.aL == null || this.aL.isEmpty()) {
                    z = false;
                }
                this.aN = z;
            } else {
                this.aL = bundle.getParcelableArrayList("userWithIdentifier");
            }
            this.aS = bundle.getCharSequence("incompleteText");
        }
        if (this.aL == null) {
            this.aL = new ArrayList();
        }
        this.aM = new ArrayList();
    }

    public final View m5752a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 266491449);
        super.a(layoutInflater, viewGroup, bundle);
        this.aw = layoutInflater.cloneInContext(this.ap).inflate(2130905649, viewGroup, false);
        this.az = (ViewGroup) FindViewUtil.b(this.aw, 2131564727);
        ay();
        this.ay = (TextView) FindViewUtil.b(this.aw, 2131564731);
        if (this.f6056g.booleanValue()) {
            this.ay.setText(2131231150);
        }
        View view = this.aw;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 61854622, a);
        return view;
    }

    private void ay() {
        if (this.az != null) {
            View a = this.av.mo226a(LayoutInflater.from(this.ap), this.az);
            this.az.removeAllViews();
            this.az.addView(a);
            this.ax = (TokenizedAutoCompleteTextView) FindViewUtil.b(a, 2131564404);
            az();
        }
    }

    private void az() {
        this.ax.setInputType(this.ax.getInputType() | 524288);
        this.ax.z = true;
        this.ax.A = true;
        this.ax.setMinHeight(jW_().getDimensionPixelSize(2131428546));
        this.ax.setOnItemClickListener(new C09192(this));
    }

    private void aA() {
        if (this.ax != null) {
            this.ax.removeTextChangedListener(this.aT);
            this.ax.addTextChangedListener(this.aT);
        }
    }

    public final void m5771d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1670925510);
        super.d(bundle);
        aA();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -580500902, a);
    }

    public final void m5749G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 219683564);
        super.G();
        if (this.aF && aC()) {
            aw();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2061278480, a);
    }

    public final void m5751I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 440048478);
        super.I();
        if (this.ax != null) {
            this.ax.removeTextChangedListener(this.aT);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -37612974, a);
    }

    public final void m5773e(Bundle bundle) {
        if (bundle != null && this.ax != null) {
            bundle.putBoolean("selectionOnResume", this.aF);
            bundle.putBoolean("isTokenEnabled", this.aO);
            if (this.aO) {
                this.aL.clear();
                this.aM.clear();
                ImmutableList pickedTokens = this.ax.getPickedTokens();
                int size = pickedTokens.size();
                for (int i = 0; i < size; i++) {
                    Token token = (Token) pickedTokens.get(i);
                    if (token instanceof HasUser) {
                        this.aL.add(((HasUser) token).c());
                    }
                }
            }
            bundle.putParcelableArrayList("userWithIdentifier", this.aL);
            bundle.putCharSequence("incompleteText", this.ax.getUserEnteredPlainText());
        }
    }

    public final void m5750H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -181430637);
        super.H();
        this.aF = this.ax.isPopupShowing();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 279534733, a);
    }

    public final void m5762a(User user) {
        m5738b(this, user, null, ContactRowSectionType.UNKNOWN, -1);
    }

    public final void m5765a(ImmutableList<User> immutableList) {
        this.aA = immutableList;
    }

    private ImmutableList<UserFbidIdentifier> aB() {
        if (this.aA == null || this.aA.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        int size = this.aA.size();
        for (int i = 0; i < size; i++) {
            builder.c(((User) this.aA.get(i)).n());
        }
        return builder.b();
    }

    public final void m5755a(ListType listType) {
        Preconditions.checkNotNull(this.au, "must set row creator before setting list type");
        switch (listType) {
            case DIVEBAR_LIST:
                this.aq = (BaseSearchableContactPickerListAdapter) this.f6053d.get();
                break;
            case FACEBOOK_LIST:
                this.aq = (BaseSearchableContactPickerListAdapter) this.f6054e.get();
                break;
            case VOIP_SEARCH_LIST:
                this.aq = (BaseSearchableContactPickerListAdapter) this.al.get();
                break;
            case VOIP_SELECT_SEARCH_LIST:
                this.aq = (BaseSearchableContactPickerListAdapter) this.am.get();
                break;
            case VOIP_GROUP_CALL_LIST:
                this.aq = (BaseSearchableContactPickerListAdapter) this.an.get();
                break;
        }
        this.aq.d().a(this.au);
    }

    private boolean aC() {
        return this.aq != null;
    }

    public final void m5754a(RowCreator rowCreator) {
        this.au = rowCreator;
    }

    public final void m5760a(OnPrimaryContactTypeChangedListener onPrimaryContactTypeChangedListener) {
        this.ar = onPrimaryContactTypeChangedListener;
    }

    public final void m5758a(OnContactPickerTextChangedListener onContactPickerTextChangedListener) {
        this.aC = onContactPickerTextChangedListener;
    }

    public final void m5757a(OnContactAddedOrRemovedListener onContactAddedOrRemovedListener) {
        this.at = onContactAddedOrRemovedListener;
    }

    public final void m5759a(OnMaxRecipientReachedListener onMaxRecipientReachedListener) {
        this.aD = onMaxRecipientReachedListener;
    }

    public final void m5761a(OnRowClickedListener onRowClickedListener) {
        this.aE = onRowClickedListener;
    }

    public final void m5766a(String str) {
        this.ax.setHint(str);
    }

    public final void m5769b(String str) {
        this.ax.y = str;
    }

    public final void m5756a(Mode mode) {
        this.aQ = mode;
        if (this.aw != null) {
            aD(this);
        }
    }

    public final Mode m5768b() {
        return this.aQ;
    }

    public static void aD(ContactPickerFragment contactPickerFragment) {
        if (contactPickerFragment.aQ == Mode.ADD_MEMBERS) {
            contactPickerFragment.ay.setVisibility(0);
        } else {
            contactPickerFragment.ay.setVisibility(8);
        }
    }

    public final void m5774g(int i) {
        if (this.av instanceof DefaultTypeaheadViewCreator) {
            DefaultTypeaheadViewCreator defaultTypeaheadViewCreator = (DefaultTypeaheadViewCreator) this.av;
            defaultTypeaheadViewCreator.f6086a.setText(i);
            defaultTypeaheadViewCreator.f6086a.setVisibility(0);
            defaultTypeaheadViewCreator.f6087b.a(false);
            return;
        }
        throw new IllegalStateException("Don't use setLabelText when using a custom typeahead");
    }

    public final void m5775h(int i) {
        this.aI = i;
    }

    public final ImmutableList<User> m5772e() {
        if (!this.aO) {
            return ImmutableList.copyOf(this.aL);
        }
        TokenSpan[] pickedTokenSpans = this.ax.getPickedTokenSpans();
        Builder builder = ImmutableList.builder();
        for (TokenSpan tokenSpan : pickedTokenSpans) {
            Token token = tokenSpan.f;
            if (token instanceof HasUser) {
                builder.c(((HasUser) token).c());
            }
        }
        return builder.b();
    }

    public final ImmutableList<UserIdentifier> aq() {
        int i;
        if (this.aO) {
            TokenSpan[] pickedTokenSpans = this.ax.getPickedTokenSpans();
            Builder builder = ImmutableList.builder();
            for (TokenSpan tokenSpan : pickedTokenSpans) {
                Token token = tokenSpan.f;
                if (token instanceof HasUser) {
                    builder.c(((HasUser) token).c().U);
                }
            }
            return builder.b();
        }
        Collection arrayList = new ArrayList();
        int size = this.aL.size();
        for (i = 0; i < size; i++) {
            arrayList.add(((User) this.aL.get(i)).U);
        }
        return ImmutableList.copyOf(arrayList);
    }

    public final ImmutableList<UserKey> ar() {
        Builder builder = ImmutableList.builder();
        ImmutableList aq = aq();
        int size = aq.size();
        for (int i = 0; i < size; i++) {
            UserIdentifier userIdentifier = (UserIdentifier) aq.get(i);
            if (userIdentifier instanceof UserFbidIdentifier) {
                builder.c(UserKey.a((UserFbidIdentifier) userIdentifier));
            }
        }
        return builder.b();
    }

    public final boolean as() {
        return this.aB;
    }

    public final void at() {
        this.ax.setEnabled(false);
    }

    final void au() {
        boolean z;
        int i = 0;
        aE();
        if (m5772e().size() > 0) {
            z = true;
        } else {
            z = false;
        }
        m5739b(z);
        if (this.as != null) {
            aq();
            if (this.aM.size() > aq().size()) {
                while (i < this.aM.size()) {
                    PickableContactPickerRow pickableContactPickerRow = (PickableContactPickerRow) this.aM.get(i);
                    if ((pickableContactPickerRow instanceof ContactPickerUserRow) && !m5772e().contains(((ContactPickerUserRow) pickableContactPickerRow).a)) {
                        this.aM.remove(i);
                    }
                    i++;
                }
            }
        }
    }

    private void m5739b(boolean z) {
        if (z != this.aB && this.ar != null) {
            this.aB = z;
            this.ar.mo227a();
        }
    }

    public final BaseSearchableContactPickerListAdapter av() {
        return this.aq;
    }

    private Object m5722a(int i, boolean z) {
        if (!z) {
            return this.aq.getItem(i);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.aq.getCount(); i3++) {
            if (this.aq.isEnabled(i3)) {
                if (i2 == i) {
                    return this.aq.getItem(i3);
                }
                i2++;
            }
        }
        return this.aq.getItem(0);
    }

    public static void m5737b(ContactPickerFragment contactPickerFragment, int i, boolean z) {
        if (contactPickerFragment.aF()) {
            contactPickerFragment.f6057h.b(contactPickerFragment.ax.getText());
            if (contactPickerFragment.aD != null) {
                contactPickerFragment.aD.mo224a();
                return;
            }
            return;
        }
        Object a = contactPickerFragment.m5722a(i, z);
        if (a instanceof ContactPickerUserRow) {
            contactPickerFragment.m5724a(i, (ContactPickerUserRow) a);
        } else if (a instanceof ContactPickerGroupRow) {
            contactPickerFragment.m5723a(i, (ContactPickerGroupRow) a);
            contactPickerFragment.m5732a(contactPickerFragment.ax.getText().toString(), false);
        }
    }

    private void m5723a(int i, ContactPickerGroupRow contactPickerGroupRow) {
        if (this.aE != null) {
            this.aE.mo225a(contactPickerGroupRow);
        }
    }

    private void m5732a(String str, boolean z) {
        if (this.aC != null) {
            this.aC.mo223a(str, z);
        }
    }

    public final void m5764a(User user, PickableContactPickerRow pickableContactPickerRow, ContactRowSectionType contactRowSectionType, int i) {
        if (!aF()) {
            final User user2 = user;
            final PickableContactPickerRow pickableContactPickerRow2 = pickableContactPickerRow;
            final ContactRowSectionType contactRowSectionType2 = contactRowSectionType;
            final int i2 = i;
            m5729a(user, new Runnable(this) {
                final /* synthetic */ ContactPickerFragment f6045e;

                public void run() {
                    ContactPickerFragment.m5738b(this.f6045e, user2, pickableContactPickerRow2, contactRowSectionType2, i2);
                }
            });
        }
    }

    public final void m5763a(User user, PickableContactPickerRow pickableContactPickerRow, int i) {
        if (this.aO) {
            this.ax.a(m5736b(user), false);
        } else {
            this.aL.remove(user);
        }
        if (pickableContactPickerRow != null) {
            this.aM.remove(pickableContactPickerRow);
        } else {
            for (int i2 = 0; i2 < this.aM.size(); i2++) {
                PickableContactPickerRow pickableContactPickerRow2 = (PickableContactPickerRow) this.aM.get(i2);
                if ((pickableContactPickerRow2 instanceof ContactPickerUserRow) && ((ContactPickerUserRow) pickableContactPickerRow2).a.a.equals(user.a)) {
                    this.aM.remove(pickableContactPickerRow2);
                }
            }
        }
        if (this.at != null) {
            this.at.mo229b(user);
        }
    }

    public final void m5776i(int i) {
        this.aG = i;
        if (this.ax.getAdapter() instanceof ContactPickerHackListAdapter) {
            ((ContactPickerHackListAdapter) this.ax.getAdapter()).f1800c = i;
        }
    }

    public final void m5753a(Drawable drawable) {
        this.aH = drawable;
    }

    public final void aw() {
        OnScrollListener c09225 = new C09225(this);
        this.aq.a(RegularImmutableList.a);
        ListAdapter contactPickerHackListAdapter = new ContactPickerHackListAdapter(this.aq, c09225);
        contactPickerHackListAdapter.f1800c = this.aG;
        contactPickerHackListAdapter.f1801d = this.aH;
        this.ax.setAdapter(contactPickerHackListAdapter);
        this.ax.setTextKeepState(this.ax.getText());
        this.ax.setDropDownWidth(-2);
        aE();
    }

    private void aE() {
        ImmutableList aB = aB();
        if (aB == null || aB.isEmpty()) {
            this.aq.d().a(aq());
            return;
        }
        Builder builder = ImmutableList.builder();
        builder.b(aq());
        builder.b(aB);
        this.aq.d().a(builder.b());
    }

    public final void ax() {
        this.f6055f.hideSoftInputFromWindow(this.ax.getWindowToken(), 0);
    }

    private boolean aF() {
        if (m5772e().size() < this.aI) {
            return false;
        }
        ErrorDialogs errorDialogs = this.f6052c;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(jW_()).a(this.aJ);
        a.c = jW_().getString(this.aK, new Object[]{Integer.valueOf(this.aI)});
        errorDialogs.a(a.l());
        return true;
    }

    private void m5729a(User user, final Runnable runnable) {
        ImmutableList e;
        if (this.aA == null) {
            e = m5772e();
        } else {
            e = ImmutableList.builder().b(m5772e()).b(this.aA).b();
        }
        boolean b = m5740b(e);
        boolean b2 = user.b();
        if (e.isEmpty() || b == b2) {
            runnable.run();
            return;
        }
        C09237 c09237 = new OnClickListener(this) {
            final /* synthetic */ ContactPickerFragment f6048b;

            public void onClick(DialogInterface dialogInterface, int i) {
                runnable.run();
            }
        };
        if (!b && b2) {
            SmsBridgeHelper smsBridgeHelper = this.ao;
            Context context = getContext();
            PrefKey a = SmsBridgePrefKeys.m3881a(user);
            if (smsBridgeHelper.f4258a.a(a, false)) {
                runnable.run();
            } else {
                OnClickListener c06411 = new C06411(smsBridgeHelper, a, runnable);
                Preconditions.checkArgument(user.b(), "Expected sms type, found:" + user.b);
                AlertDialog b3 = new FbAlertDialogBuilder(context).a(2131241329).b(context.getString(2131241330, new Object[]{user.k()})).a(context.getString(2131230726), c06411).b();
            }
        } else if (!b || b2) {
            throw new IllegalStateException("Should not reach this code path.");
        } else {
            this.ao.m3880a(getContext(), e, runnable);
        }
    }

    private static boolean m5740b(ImmutableList<User> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (!((User) immutableList.get(i)).b()) {
                return false;
            }
        }
        return !immutableList.isEmpty();
    }

    public static void m5738b(ContactPickerFragment contactPickerFragment, User user, PickableContactPickerRow pickableContactPickerRow, ContactRowSectionType contactRowSectionType, int i) {
        if (contactPickerFragment.aO) {
            contactPickerFragment.ax.a(contactPickerFragment.m5736b(user));
        } else {
            contactPickerFragment.ax.getEditableText().clear();
            contactPickerFragment.aL.add(user);
        }
        if (pickableContactPickerRow != null) {
            contactPickerFragment.aM.add(pickableContactPickerRow);
        } else {
            ArrayList arrayList = contactPickerFragment.aM;
            ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
            contactPickerUserRowBuilder.a = user;
            contactPickerUserRowBuilder = contactPickerUserRowBuilder;
            contactPickerUserRowBuilder.j = true;
            arrayList.add(new ContactPickerUserRow(contactPickerUserRowBuilder));
        }
        if (contactPickerFragment.at != null) {
            contactPickerFragment.at.mo228a(user);
        }
    }

    public final void m5777j(int i) {
        this.aR = i;
    }

    public final void m5767a(boolean z) {
        this.ax.setTextMode(z ? TextMode.CHIPS : TextMode.STYLIZED);
    }

    private Token m5736b(User user) {
        if (this.ax.g == TextMode.CHIPS) {
            this.f6058i.f6101b = 6;
            UserTokenFactory userTokenFactory = this.f6058i;
            Context context = getContext();
            TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView = this.ax;
            boolean z = true;
            ContactChipToken contactChipToken = new ContactChipToken(user, (userTokenFactory.f6101b & 1) != 0);
            if ((userTokenFactory.f6101b & 4) != 0) {
                contactChipToken.b = new C09292(userTokenFactory, tokenizedAutoCompleteTextView, context, new C09281(userTokenFactory, tokenizedAutoCompleteTextView));
                if (tokenizedAutoCompleteTextView.isEnabled()) {
                    z = false;
                }
                contactChipToken.e = z;
            }
            return contactChipToken;
        }
        this.f6058i.f6101b = 0;
        return new PickerUserToken(user);
    }
}

package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerUserRow.MenuHandler;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.contacts.abtest.ExperimentsForContactsAbtestModule;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.presence.LastActiveHelper.TextFormat;
import com.facebook.messaging.presence.PresenceIndicatorView;
import com.facebook.messaging.presence.PresenceType;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper;
import com.facebook.messaging.users.CanonicalThreadPresenceHelper.PageResponsivenessListener;
import com.facebook.messaging.users.username.gating.UsernameGatingUtil;
import com.facebook.messaging.users.username.view.UsernameViewUtil;
import com.facebook.orca.contacts.picker.ContactMultipickerFragment.AnonymousClass10;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.annotations.IsVoipVideoEnabled;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.rtc.helpers.RtcCallHandler;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.facebook.user.model.User.CommercePageType;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserPhoneNumber;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.SimpleVariableTextLayoutView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: task_key_saved_dashboard_post_review */
public class ContactPickerListItem extends CustomRelativeLayout {
    private static final String f1849a = ContactPickerListItem.class.getSimpleName();
    public ViewStub f1850A;
    public View f1851B;
    public ViewStubHolder<View> f1852C;
    public ViewStubHolder<BetterTextView> f1853D;
    public ViewStubHolder<ViewGroup> f1854E;
    public ContactPickerUserRow f1855F;
    @Inject
    public RtcCallHandler f1856b;
    @Inject
    public RtcCallButtonIconProvider f1857c;
    @Inject
    private UserTileViewParamsFactory f1858d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbPhoneNumberUtils> f1859e = UltralightRuntime.b;
    @Inject
    public QeAccessor f1860f;
    @Inject
    private SecureContextHelper f1861g;
    @Inject
    public CanonicalThreadPresenceHelper f1862h;
    @Inject
    private UsernameViewUtil f1863i;
    @IsVoipVideoEnabled
    @Inject
    public Provider<Boolean> f1864j;
    public SimpleVariableTextLayoutView f1865k;
    public FbTextView f1866l;
    public int f1867m;
    public TextView f1868n;
    public TextView f1869o;
    public TextView f1870p;
    public UserTileView f1871q;
    public PresenceIndicatorView f1872r;
    public CheckBox f1873s;
    public CheckBox f1874t;
    public Button f1875u;
    public ViewStubHolder<BetterButton> f1876v;
    public View f1877w;
    public ImageView f1878x;
    public ImageView f1879y;
    public ImageView f1880z;

    /* compiled from: task_key_saved_dashboard_post_review */
    public class C03023 implements OnClickListener {
        final /* synthetic */ ContactPickerListItem f1843a;

        public C03023(ContactPickerListItem contactPickerListItem) {
            this.f1843a = contactPickerListItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 117673462);
            if (!ContactPickerListItem.m1769z(this.f1843a)) {
                this.f1843a.f1856b.a(this.f1843a.getContext(), this.f1843a.f1855F.a.T, true, null, null, this.f1843a.f1855F.x, 0);
            } else if (this.f1843a.f1855F.a.w() != null) {
                ContactPickerListItem.m1749a(this.f1843a, this.f1843a.f1855F.a.w().b);
            }
            LogUtils.a(21492613, a);
        }
    }

    /* compiled from: task_key_saved_dashboard_post_review */
    public class C03034 implements OnClickListener {
        final /* synthetic */ ContactPickerListItem f1844a;

        public C03034(ContactPickerListItem contactPickerListItem) {
            this.f1844a = contactPickerListItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1410521230);
            this.f1844a.f1856b.b(this.f1844a.getContext(), this.f1844a.f1855F.a.T, true, null, null, this.f1844a.f1855F.y, 0);
            Logger.a(2, EntryType.UI_INPUT_END, -1584477823, a);
        }
    }

    /* compiled from: task_key_saved_dashboard_post_review */
    public class C03045 implements OnClickListener {
        final /* synthetic */ ContactPickerListItem f1845a;

        public C03045(ContactPickerListItem contactPickerListItem) {
            this.f1845a = contactPickerListItem;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -2071214348, Logger.a(2, EntryType.UI_INPUT_START, 1046347505));
        }
    }

    /* compiled from: task_key_saved_dashboard_post_review */
    public class C03067 implements PageResponsivenessListener {
        final /* synthetic */ ContactPickerListItem f1848a;

        public C03067(ContactPickerListItem contactPickerListItem) {
            this.f1848a = contactPickerListItem;
        }

        public final void m1748a() {
            ContactPickerListItem.m1761j(this.f1848a);
        }
    }

    public static void m1751a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactPickerListItem) obj).m1750a(RtcCallHandler.a(fbInjector), RtcCallButtonIconProvider.b(fbInjector), UserTileViewParamsFactory.a(fbInjector), IdBasedLazy.a(fbInjector, 3494), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), CanonicalThreadPresenceHelper.b(fbInjector), new UsernameViewUtil(UsernameGatingUtil.b(fbInjector), (Context) fbInjector.getInstance(Context.class)), IdBasedProvider.a(fbInjector, 4302));
    }

    private void m1750a(RtcCallHandler rtcCallHandler, RtcCallButtonIconProvider rtcCallButtonIconProvider, UserTileViewParamsFactory userTileViewParamsFactory, com.facebook.inject.Lazy<FbPhoneNumberUtils> lazy, QeAccessor qeAccessor, SecureContextHelper secureContextHelper, CanonicalThreadPresenceHelper canonicalThreadPresenceHelper, UsernameViewUtil usernameViewUtil, Provider<Boolean> provider) {
        this.f1856b = rtcCallHandler;
        this.f1857c = rtcCallButtonIconProvider;
        this.f1858d = userTileViewParamsFactory;
        this.f1859e = lazy;
        this.f1860f = qeAccessor;
        this.f1861g = secureContextHelper;
        this.f1862h = canonicalThreadPresenceHelper;
        this.f1863i = usernameViewUtil;
        this.f1864j = provider;
    }

    public ContactPickerListItem(Context context) {
        super(context, null, 2130772985);
        Class cls = ContactPickerListItem.class;
        m1751a((Object) this, getContext());
        setContentView(2130905656);
        this.f1865k = (SimpleVariableTextLayoutView) a(2131564424);
        this.f1866l = (FbTextView) a(2131564749);
        this.f1867m = this.f1865k.getTextColor();
        this.f1868n = (TextView) a(2131564753);
        this.f1869o = (TextView) a(2131564754);
        this.f1870p = (TextView) a(2131564755);
        this.f1871q = (UserTileView) a(2131564423);
        this.f1872r = (PresenceIndicatorView) a(2131564756);
        this.f1873s = (CheckBox) a(2131561316);
        this.f1874t = (CheckBox) a(2131564758);
        this.f1875u = (Button) a(2131564757);
        this.f1876v = ViewStubHolder.a((ViewStubCompat) a(2131564744));
        this.f1877w = a(2131564745);
        this.f1878x = (ImageView) a(2131564759);
        this.f1879y = (ImageView) a(2131564760);
        this.f1880z = (ImageView) a(2131564761);
        this.f1850A = (ViewStub) a(2131564746);
        this.f1852C = ViewStubHolder.a((ViewStubCompat) a(2131563878));
        this.f1853D = ViewStubHolder.a((ViewStubCompat) a(2131564751));
        this.f1854E = ViewStubHolder.a((ViewStubCompat) a(2131564752));
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1516445644);
        super.onDetachedFromWindow();
        this.f1862h.a(false);
        this.f1862h.t = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1201130108, a);
    }

    public void setContactRow(ContactPickerUserRow contactPickerUserRow) {
        this.f1855F = contactPickerUserRow;
        m1752b(this);
    }

    public static void m1752b(ContactPickerListItem contactPickerListItem) {
        User user = contactPickerListItem.f1855F.a;
        contactPickerListItem.f1871q.setParams(contactPickerListItem.f1858d.a(user));
        contactPickerListItem.m1757f();
        contactPickerListItem.m1758g();
        contactPickerListItem.m1760i();
        m1761j(contactPickerListItem);
        contactPickerListItem.m1759h();
        contactPickerListItem.m1762l();
        final AnonymousClass10 anonymousClass10 = contactPickerListItem.f1855F.t;
        if (anonymousClass10 != null) {
            contactPickerListItem.f1874t.setOnClickListener(new OnClickListener(contactPickerListItem) {
                final /* synthetic */ ContactPickerListItem f1847b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1997841879);
                    anonymousClass10.m5659a(this.f1847b.f1855F.a);
                    Logger.a(2, EntryType.UI_INPUT_END, -815551557, a);
                }
            });
            contactPickerListItem.f1874t.setClickable(true);
            contactPickerListItem.f1874t.setFocusable(true);
        } else {
            contactPickerListItem.f1874t.setOnClickListener(null);
            contactPickerListItem.f1874t.setClickable(false);
            contactPickerListItem.f1874t.setFocusable(false);
        }
        if (contactPickerListItem.f1855F.o) {
            if (contactPickerListItem.f1851B == null) {
                contactPickerListItem.f1851B = contactPickerListItem.f1850A.inflate();
            }
            contactPickerListItem.f1851B.setVisibility(0);
        } else if (contactPickerListItem.f1851B != null) {
            contactPickerListItem.f1851B.setVisibility(8);
        }
        contactPickerListItem.m1763n();
        if (contactPickerListItem.f1855F.B) {
            contactPickerListItem.f1853D.f();
        } else {
            contactPickerListItem.f1853D.e();
        }
        if (contactPickerListItem.f1855F.A) {
            contactPickerListItem.f1852C.e();
        } else {
            int i;
            UsernameViewUtil usernameViewUtil = contactPickerListItem.f1863i;
            String str = user.g;
            ViewStubHolder viewStubHolder = contactPickerListItem.f1852C;
            if (contactPickerListItem.f1868n.getVisibility() == 0 || contactPickerListItem.f1853D.d()) {
                i = 1;
            } else {
                i = 0;
            }
            if (!usernameViewUtil.f4923a.a() || StringUtil.c(str)) {
                viewStubHolder.e();
            } else {
                BetterTextView betterTextView = (BetterTextView) viewStubHolder.a();
                StringBuilder stringBuilder = new StringBuilder(usernameViewUtil.f4924b.getResources().getString(2131233172));
                stringBuilder.append(str);
                if (i != 0) {
                    stringBuilder.append(usernameViewUtil.f4924b.getResources().getString(2131233173));
                    stringBuilder.append(usernameViewUtil.f4924b.getResources().getString(2131233171));
                    stringBuilder.append(usernameViewUtil.f4924b.getResources().getString(2131233173));
                }
                betterTextView.setText(stringBuilder.toString());
                betterTextView.setTextAppearance(usernameViewUtil.f4924b, 2131625090);
                if (2131625090 == 2131625090) {
                    betterTextView.setIncludeFontPadding(false);
                }
                viewStubHolder.f();
            }
        }
        if (!contactPickerListItem.f1855F.C().isEmpty()) {
            contactPickerListItem.f1865k.setTextColor(contactPickerListItem.getResources().getColor(((Integer) contactPickerListItem.f1855F.C().get(0)).intValue()));
        }
        if (contactPickerListItem.m1768w()) {
            contactPickerListItem.f1868n.setTextColor(contactPickerListItem.getResources().getColor(((Integer) contactPickerListItem.f1855F.D().get(0)).intValue()));
        }
        final MenuHandler menuHandler = contactPickerListItem.f1855F.s;
        if (menuHandler != null) {
            contactPickerListItem.f1877w.setVisibility(0);
            contactPickerListItem.f1877w.setOnClickListener(new OnClickListener(contactPickerListItem) {
                final /* synthetic */ ContactPickerListItem f1840b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -437473895);
                    PopupMenu popupMenu = new PopupMenu(this.f1840b.getContext(), view);
                    final ContactPickerUserRow contactPickerUserRow = this.f1840b.f1855F;
                    menuHandler.a(this.f1840b.f1855F, popupMenu.b, popupMenu.b());
                    popupMenu.e = new OnMenuItemClickListener(this) {
                        final /* synthetic */ C03001 f1838b;

                        public final boolean m1747a(MenuItem menuItem) {
                            return menuHandler.a(menuItem, contactPickerUserRow);
                        }
                    };
                    menuHandler.a(view);
                    popupMenu.c();
                    Logger.a(2, EntryType.UI_INPUT_END, -601593803, a);
                }
            });
        } else {
            contactPickerListItem.f1877w.setVisibility(8);
        }
        contactPickerListItem.m1756e();
        contactPickerListItem.m1754c();
        contactPickerListItem.m1755d();
    }

    private void m1754c() {
        boolean z = false;
        if (m1766s()) {
            this.f1875u.setVisibility(0);
            boolean d = this.f1855F.d();
            Button button = this.f1875u;
            if (!d) {
                z = true;
            }
            button.setEnabled(z);
            this.f1875u.setText(d ? getResources().getString(2131231928) : getResources().getString(2131231102));
            setPropagateToRowClickOnClickListener(this.f1875u);
            return;
        }
        this.f1875u.setVisibility(8);
    }

    private void m1755d() {
        Object obj;
        BetterButton betterButton = (BetterButton) this.f1876v.a();
        if (this.f1855F.b == RowStyle.SINGLE_TAP_SEND) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            CharSequence string;
            betterButton.setVisibility(0);
            betterButton.setEnabled(this.f1855F.r);
            if (this.f1855F.r) {
                string = getResources().getString(2131231251);
            } else {
                string = getResources().getString(2131231550);
            }
            betterButton.setText(string);
            setPropagateToRowClickOnClickListener(betterButton);
            return;
        }
        betterButton.setVisibility(8);
    }

    private void setPropagateToRowClickOnClickListener(Button button) {
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactPickerListItem f1842b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1727239087);
                ListView listView = (ListView) this.getParent();
                listView.performItemClick(this, listView.getPositionForView(this), (long) this.getId());
                this.f1842b.f1855F.b(false);
                ContactPickerListItem.m1752b(this.f1842b);
                Logger.a(2, EntryType.UI_INPUT_END, 417561473, a);
            }
        });
    }

    private void m1756e() {
        boolean a = this.f1860f.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.s, false);
        ImageView imageView = a ? this.f1879y : this.f1878x;
        if (this.f1855F.u) {
            Drawable a2;
            Preconditions.checkNotNull(this.f1855F.x);
            imageView.setOnClickListener(new C03023(this));
            if (m1769z(this)) {
                a2 = new GlyphColorizer(getResources()).a(2130841339, getResources().getColor(2131362502));
            } else if (this.f1855F.g && this.f1860f.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.o, false)) {
                a2 = this.f1857c.d();
            } else {
                a2 = this.f1857c.a();
            }
            imageView.setImageDrawable(a2);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (a) {
            imageView = this.f1878x;
        } else {
            imageView = this.f1879y;
        }
        if (this.f1855F.v) {
            Preconditions.checkNotNull(this.f1855F.y);
            if (((Boolean) this.f1864j.get()).booleanValue()) {
                imageView.setOnClickListener(new C03034(this));
                imageView.setImageDrawable(this.f1857c.e());
            } else {
                imageView.setOnClickListener(new C03045(this));
                imageView.setImageDrawable(this.f1857c.f());
            }
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    public static void m1749a(ContactPickerListItem contactPickerListItem, String str) {
        if (!StringUtil.c(str)) {
            Intent intent = new Intent("android.intent.action.CALL");
            intent.setData(Uri.parse("tel:" + str));
            intent.setFlags(268435456);
            try {
                contactPickerListItem.f1861g.b(intent, contactPickerListItem.getContext());
            } catch (Throwable e) {
                BLog.a(f1849a, e, "Failed to open dialer for number %s", new Object[]{str});
            }
        }
    }

    private void m1757f() {
        String string;
        if (m1765r()) {
            if (this.f1855F.d()) {
                this.f1865k.setTextColor(getResources().getColor(2131362241));
            } else {
                this.f1865k.setTextColor(this.f1867m);
            }
        }
        User user = this.f1855F.a;
        SimpleVariableTextLayoutView simpleVariableTextLayoutView = this.f1865k;
        if (this.f1855F.z) {
            string = getContext().getResources().getString(2131231892, new Object[]{user.j()});
        } else {
            string = user.j();
        }
        simpleVariableTextLayoutView.setText(string);
        if (!this.f1860f.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.ao, false) || this.f1855F.G <= 1) {
            this.f1866l.setVisibility(8);
            return;
        }
        this.f1866l.setText("(" + this.f1855F.G + ")");
        this.f1866l.setVisibility(0);
    }

    private void m1758g() {
        if (m1769z(this) || ((m1767u() && this.f1855F.k == null) || (m1765r() && this.f1855F.m == ContactRowSectionType.AUTO_COMPLETE))) {
            this.f1872r.setVisibility(8);
        } else if (this.f1855F.a.b == Type.FACEBOOK) {
            this.f1872r.setVisibility(0);
            if (!m1767u() || this.f1855F.k == null) {
                Object obj;
                if (this.f1855F.b == RowStyle.FACEBOOK_TAB) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f1872r.setTextColor(getResources().getColor(2131362396));
                    if (this.f1855F.c) {
                        this.f1872r.setStatus(PresenceType.AVAILABLE_ON_MOBILE);
                        return;
                    } else if (this.f1855F.d || this.f1855F.e) {
                        this.f1872r.setStatus(PresenceType.AVAILABLE_ON_WEB);
                        return;
                    } else {
                        this.f1872r.setStatus(PresenceType.NONE);
                        return;
                    }
                }
                this.f1872r.setShowIcon(this.f1855F.j);
                if (this.f1855F.l == null || this.f1855F.l.b() == null) {
                    obj = null;
                } else {
                    obj = this.f1855F.l.b().b() == GraphQLUserChatContextType.NEARBY ? 1 : null;
                }
                if (obj != null) {
                    this.f1872r.setStatus(PresenceType.NEARBY);
                    return;
                } else if (this.f1855F.e) {
                    this.f1872r.setStatus(PresenceType.ONLINE);
                    return;
                } else if (this.f1855F.h) {
                    if (this.f1855F.b == RowStyle.ONE_LINE) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f1872r.a(PresenceType.PUSHABLE, this.f1855F.k);
                        return;
                    } else {
                        this.f1872r.setStatus(PresenceType.PUSHABLE);
                        return;
                    }
                } else {
                    this.f1872r.setStatus(PresenceType.NONE);
                    return;
                }
            }
            this.f1872r.a(PresenceType.NONE, this.f1855F.k);
        } else {
            this.f1872r.setStatus(PresenceType.NONE);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1759h() {
        /*
        r13 = this;
        r11 = 3;
        r10 = 2;
        r9 = 1;
        r5 = 8;
        r8 = 0;
        r0 = r13.m1764q();
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r0 = r13.f1854E;
        r0.e();
    L_0x0011:
        return;
    L_0x0012:
        r0 = r13.f1854E;
        r0.f();
        r0 = 2131564776; // 0x7f0d18e8 float:1.8755047E38 double:1.0531329277E-314;
        r0 = r13.a(r0);
        r0 = (com.facebook.fbui.glyph.GlyphView) r0;
        r1 = 2131564775; // 0x7f0d18e7 float:1.8755045E38 double:1.053132927E-314;
        r1 = r13.a(r1);
        r1 = (com.facebook.fbui.glyph.GlyphView) r1;
        r2 = 2131564774; // 0x7f0d18e6 float:1.8755043E38 double:1.0531329267E-314;
        r2 = r13.a(r2);
        r2 = (com.facebook.fbui.glyph.GlyphView) r2;
        r3 = 2131564773; // 0x7f0d18e5 float:1.875504E38 double:1.053132926E-314;
        r3 = r13.a(r3);
        r3 = (com.facebook.fbui.glyph.GlyphView) r3;
        r4 = 2131564772; // 0x7f0d18e4 float:1.8755039E38 double:1.0531329257E-314;
        r4 = r13.a(r4);
        r4 = (com.facebook.resources.ui.FbTextView) r4;
        r0.setVisibility(r5);
        r1.setVisibility(r5);
        r2.setVisibility(r5);
        r3.setVisibility(r5);
        r4.setVisibility(r5);
        r5 = r13.f1855F;
        r12 = r5.G;
        r5 = r12;
        r6 = 5;
        r6 = java.lang.Math.min(r5, r6);
        switch(r6) {
            case 1: goto L_0x00d7;
            case 2: goto L_0x00a6;
            case 3: goto L_0x0075;
            case 4: goto L_0x0075;
            case 5: goto L_0x0075;
            default: goto L_0x0060;
        };
    L_0x0060:
        r0 = r13.f1860f;
        r1 = com.facebook.qe.api.Liveness.Cached;
        r2 = com.facebook.qe.api.ExposureLogging.Off;
        r5 = com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule.ap;
        r0 = r0.a(r1, r2, r5, r8);
        if (r0 == 0) goto L_0x010a;
    L_0x006e:
        r0 = 5;
        if (r6 != r0) goto L_0x010a;
    L_0x0071:
        r4.setVisibility(r8);
        goto L_0x0011;
    L_0x0075:
        r5 = r13.f1855F;
        r5 = r5.B();
        r5 = r5.get(r10);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r2.setImageResource(r5);
        r7 = r13.getResources();
        r5 = r13.f1855F;
        r5 = r5.D();
        r5 = r5.get(r10);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r5 = r7.getColor(r5);
        r2.setGlyphColor(r5);
        r2.setVisibility(r8);
    L_0x00a6:
        r2 = r13.f1855F;
        r2 = r2.B();
        r2 = r2.get(r9);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r1.setImageResource(r2);
        r5 = r13.getResources();
        r2 = r13.f1855F;
        r2 = r2.D();
        r2 = r2.get(r9);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r2 = r5.getColor(r2);
        r1.setGlyphColor(r2);
        r1.setVisibility(r8);
    L_0x00d7:
        r1 = r13.f1855F;
        r1 = r1.B();
        r1 = r1.get(r8);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r0.setImageResource(r1);
        r2 = r13.getResources();
        r1 = r13.f1855F;
        r1 = r1.D();
        r1 = r1.get(r8);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r1 = r2.getColor(r1);
        r0.setGlyphColor(r1);
        r0.setVisibility(r8);
        goto L_0x0060;
    L_0x010a:
        r0 = 4;
        if (r6 < r0) goto L_0x0011;
    L_0x010d:
        r0 = r13.f1855F;
        r0 = r0.B();
        r0 = r0.get(r11);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r3.setImageResource(r0);
        r1 = r13.getResources();
        r0 = r13.f1855F;
        r0 = r0.D();
        r0 = r0.get(r11);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r0 = r1.getColor(r0);
        r3.setGlyphColor(r0);
        r3.setVisibility(r8);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.picker.ContactPickerListItem.h():void");
    }

    private void m1760i() {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int i = 0;
        User user = this.f1855F.a;
        Object obj;
        if (user.b != Type.FACEBOOK) {
            if (user.b.isPhoneContact()) {
                String string;
                Preconditions.checkArgument(user.ao());
                if (Strings.isNullOrEmpty(user.an())) {
                    string = getResources().getString(2131231806);
                } else {
                    UserPhoneNumber c = m1753c(user, 0);
                    if (c == null) {
                        string = null;
                    } else {
                        string = ((FbPhoneNumberUtils) this.f1859e.get()).b(c.b);
                    }
                }
                obj = string;
                if (!StringUtil.a(obj)) {
                    switch (m1753c(user, 0).d) {
                        case 1:
                            string = getResources().getString(2131231804);
                            break;
                        case 2:
                            string = getResources().getString(2131231803);
                            break;
                        case 3:
                            string = getResources().getString(2131231805);
                            break;
                        default:
                            string = null;
                            break;
                    }
                    Object obj2 = string;
                }
            }
            charSequence = null;
        } else if (this.f1855F.m == ContactRowSectionType.SELF_PROFILE) {
            Spannable spannableString = new SpannableString(getContext().getResources().getString(2131230838));
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131361917)), 0, spannableString.length(), 33);
            charSequence = spannableString;
        } else if (this.f1855F.l != null && this.f1855F.l.b() != null) {
            charSequence = this.f1855F.l.b().a().a();
        } else if (this.f1855F.q) {
            charSequence = getContext().getString(2131230995);
        } else if (m1768w()) {
            charSequence = getTwoLineText();
        } else {
            if (!(user.z || user.q == null)) {
                obj = user.q;
            }
            charSequence = null;
        }
        this.f1868n.setText(charSequence);
        this.f1868n.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
        this.f1869o.setText(charSequence2);
        TextView textView = this.f1869o;
        if (TextUtils.isEmpty(charSequence2)) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public static void m1761j(ContactPickerListItem contactPickerListItem) {
        CharSequence charSequence;
        User user = contactPickerListItem.f1855F.a;
        if (!user.T() || user.v == CommercePageType.COMMERCE_PAGE_TYPE_AGENT) {
            charSequence = "";
        } else {
            String str = null;
            if (contactPickerListItem.f1860f.a(Liveness.Live, ExperimentsForContactsAbtestModule.a, false)) {
                if (!contactPickerListItem.f1862h.l) {
                    contactPickerListItem.f1862h.a(true);
                    contactPickerListItem.f1862h.t = new C03067(contactPickerListItem);
                }
                str = contactPickerListItem.f1862h.a(contactPickerListItem.getContext(), null, TextFormat.NORMAL, false, user);
            }
            charSequence = str;
        }
        contactPickerListItem.f1870p.setText(charSequence);
        contactPickerListItem.f1870p.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    private CharSequence getTwoLineText() {
        if (this.f1855F.e) {
            return getContext().getString(2131231559);
        }
        if (!this.f1855F.h && !m1764q()) {
            User user = this.f1855F.a;
            if (user.r != null) {
                return user.r;
            }
            if (user.q != null) {
                return user.q;
            }
            return null;
        } else if (StringUtil.a(this.f1855F.k)) {
            return getContext().getString(2131231601);
        } else {
            return this.f1855F.k;
        }
    }

    private void m1762l() {
        int i = 8;
        if (m1766s() || !this.f1855F.p) {
            this.f1873s.setVisibility(8);
            this.f1874t.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1873s;
        if (!m1765r()) {
            i = 0;
        }
        checkBox.setVisibility(i);
        this.f1873s.setChecked(this.f1855F.d());
        this.f1874t.setVisibility(0);
        this.f1874t.setChecked(this.f1855F.d());
    }

    private void m1763n() {
        int i;
        int i2 = 0;
        if (this.f1855F.m == ContactRowSectionType.SELF_PROFILE) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            this.f1880z.setImageResource(2130837850);
        }
        ImageView imageView = this.f1880z;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    private boolean m1764q() {
        return this.f1855F.m == ContactRowSectionType.CALL_LOGS;
    }

    private boolean m1765r() {
        return this.f1855F.b == RowStyle.NEUE_PICKER;
    }

    private boolean m1766s() {
        return this.f1855F.b == RowStyle.INVITE_BUTTON_PICKER;
    }

    private boolean m1767u() {
        return this.f1855F.b == RowStyle.MESSENGER_TAB;
    }

    private boolean m1768w() {
        return this.f1855F.b == RowStyle.TWO_LINE;
    }

    public static boolean m1769z(ContactPickerListItem contactPickerListItem) {
        return contactPickerListItem.f1855F.a.ao();
    }

    @Nullable
    public static UserPhoneNumber m1753c(User user, int i) {
        ImmutableList r = user.r();
        if (r == null || i < 0 || i >= r.size()) {
            return null;
        }
        return (UserPhoneNumber) r.get(i);
    }
}

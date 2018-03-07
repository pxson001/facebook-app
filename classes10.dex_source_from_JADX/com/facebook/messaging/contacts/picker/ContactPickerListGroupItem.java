package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerGroupRow.GroupMenuHandler;
import com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.helpers.RtcCallButtonIconProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.tiles.ThreadTileView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.inject.Inject;

/* compiled from: tasks-createEvent */
public class ContactPickerListGroupItem extends CustomRelativeLayout {
    private static final Class<?> f1814a = ContactPickerListGroupItem.class;
    @Inject
    private MessengerThreadNameViewDataFactory f1815b;
    @Inject
    private MessengerThreadTileViewDataFactory f1816c;
    @Inject
    public Clock f1817d;
    @Inject
    private QeAccessor f1818e;
    @Inject
    private RtcCallButtonIconProvider f1819f;
    @Inject
    @Lazy
    @BackgroundExecutorService
    private com.facebook.inject.Lazy<ScheduledExecutorService> f1820g;
    @Inject
    @Lazy
    @ForUiThread
    public com.facebook.inject.Lazy<ExecutorService> f1821h;
    public final ThreadNameView f1822i;
    private final FbTextView f1823j;
    public final int f1824k;
    private final ThreadNameView f1825l;
    private final ThreadTileView f1826m;
    public final ImageView f1827n;
    public CheckBox f1828o;
    public ViewStub f1829p;
    public View f1830q;
    private ViewStubHolder<ViewGroup> f1831r;
    private ViewStubHolder<ViewGroup> f1832s;
    private ViewStubHolder<BetterButton> f1833t;
    public FbTextView f1834u;
    private ScheduledFuture<?> f1835v;
    public ContactPickerGroupRow f1836w;

    /* compiled from: tasks-createEvent */
    class C02952 implements Runnable {
        final /* synthetic */ ContactPickerListGroupItem f1809a;

        C02952(ContactPickerListGroupItem contactPickerListGroupItem) {
            this.f1809a = contactPickerListGroupItem;
        }

        public void run() {
            ContactPickerListGroupItem contactPickerListGroupItem = this.f1809a;
            ExecutorDetour.a((ExecutorService) contactPickerListGroupItem.f1821h.get(), new C02974(contactPickerListGroupItem), -1684063601);
        }
    }

    /* compiled from: tasks-createEvent */
    public class C02974 implements Runnable {
        final /* synthetic */ ContactPickerListGroupItem f1812a;

        public C02974(ContactPickerListGroupItem contactPickerListGroupItem) {
            this.f1812a = contactPickerListGroupItem;
        }

        public void run() {
            if (this.f1812a.f1834u != null && this.f1812a.f1836w != null) {
                this.f1812a.f1834u.setText(DateUtils.formatElapsedTime((this.f1812a.f1817d.a() - this.f1812a.f1836w.o) / 1000));
            }
        }
    }

    /* compiled from: tasks-createEvent */
    class C02985 implements OnClickListener {
        final /* synthetic */ ContactPickerListGroupItem f1813a;

        C02985(ContactPickerListGroupItem contactPickerListGroupItem) {
            this.f1813a = contactPickerListGroupItem;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -566450771, Logger.a(2, EntryType.UI_INPUT_START, 2117150182));
        }
    }

    public static void m1743a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactPickerListGroupItem) obj).m1742a(MessengerThreadNameViewDataFactory.a(fbInjector), MessengerThreadTileViewDataFactory.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), RtcCallButtonIconProvider.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 4527), IdBasedSingletonScopeProvider.b(fbInjector, 3863));
    }

    private void m1742a(MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, MessengerThreadTileViewDataFactory messengerThreadTileViewDataFactory, Clock clock, QeAccessor qeAccessor, RtcCallButtonIconProvider rtcCallButtonIconProvider, com.facebook.inject.Lazy<ScheduledExecutorService> lazy, com.facebook.inject.Lazy<ExecutorService> lazy2) {
        this.f1815b = messengerThreadNameViewDataFactory;
        this.f1816c = messengerThreadTileViewDataFactory;
        this.f1817d = clock;
        this.f1818e = qeAccessor;
        this.f1819f = rtcCallButtonIconProvider;
        this.f1820g = lazy;
        this.f1821h = lazy2;
    }

    public ContactPickerListGroupItem(Context context) {
        this(context, null);
    }

    private ContactPickerListGroupItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772985);
    }

    private ContactPickerListGroupItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1820g = UltralightRuntime.b;
        this.f1821h = UltralightRuntime.b;
        setContentView(2130905655);
        setId(2131558473);
        this.f1822i = (ThreadNameView) a(2131562738);
        this.f1823j = (FbTextView) a(2131564740);
        this.f1824k = this.f1822i.getTextColor();
        this.f1825l = (ThreadNameView) a(2131564422);
        this.f1826m = (ThreadTileView) a(2131564421);
        this.f1827n = (ImageView) a(2131564745);
        this.f1828o = (CheckBox) a(2131561316);
        this.f1829p = (ViewStub) a(2131564746);
        this.f1831r = ViewStubHolder.a((ViewStubCompat) a(2131564741));
        this.f1832s = ViewStubHolder.a((ViewStubCompat) a(2131564743));
        this.f1833t = ViewStubHolder.a((ViewStubCompat) a(2131564744));
        Class cls = ContactPickerListGroupItem.class;
        m1743a(this, getContext());
    }

    public ContactPickerGroupRow getContactRow() {
        return this.f1836w;
    }

    public static void m1741a(ContactPickerListGroupItem contactPickerListGroupItem) {
        ThreadSummary threadSummary = contactPickerListGroupItem.f1836w.a;
        MessengerThreadNameViewData a = contactPickerListGroupItem.f1815b.a(threadSummary);
        contactPickerListGroupItem.f1822i.setData(a);
        if (!contactPickerListGroupItem.f1818e.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.ao, false) || contactPickerListGroupItem.f1836w.p <= 1) {
            contactPickerListGroupItem.f1823j.setVisibility(8);
        } else {
            contactPickerListGroupItem.f1823j.setText("(" + contactPickerListGroupItem.f1836w.p + ")");
            contactPickerListGroupItem.f1823j.setVisibility(0);
        }
        contactPickerListGroupItem.f1826m.setThreadTileViewData(contactPickerListGroupItem.f1816c.a(threadSummary));
        if (threadSummary.a()) {
            contactPickerListGroupItem.f1825l.setData(a);
            contactPickerListGroupItem.f1825l.setVisibility(0);
        } else {
            contactPickerListGroupItem.f1825l.setVisibility(8);
        }
        final GroupMenuHandler groupMenuHandler = contactPickerListGroupItem.f1836w.d;
        if (groupMenuHandler != null) {
            contactPickerListGroupItem.f1827n.setVisibility(0);
            contactPickerListGroupItem.f1827n.setOnClickListener(new OnClickListener(contactPickerListGroupItem) {
                final /* synthetic */ ContactPickerListGroupItem f1808b;

                /* compiled from: tasks-createEvent */
                class C02931 implements OnMenuItemClickListener {
                    final /* synthetic */ C02941 f1806a;

                    C02931(C02941 c02941) {
                        this.f1806a = c02941;
                    }

                    public final boolean m1740a(MenuItem menuItem) {
                        return groupMenuHandler.a();
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -950707643);
                    PopupMenu popupMenu = new PopupMenu(this.f1808b.getContext(), view);
                    popupMenu.b();
                    popupMenu.e = new C02931(this);
                    popupMenu.c();
                    Logger.a(2, EntryType.UI_INPUT_END, -672856401, a);
                }
            });
        } else {
            contactPickerListGroupItem.f1827n.setVisibility(8);
        }
        if (contactPickerListGroupItem.f1836w.h) {
            contactPickerListGroupItem.f1828o.setVisibility(0);
            contactPickerListGroupItem.f1828o.setChecked(contactPickerListGroupItem.f1836w.d());
        } else {
            contactPickerListGroupItem.f1828o.setVisibility(8);
        }
        if (contactPickerListGroupItem.f1836w.d()) {
            contactPickerListGroupItem.f1822i.setTextColor(ContextCompat.b(contactPickerListGroupItem.getContext(), 2131362241));
        } else {
            contactPickerListGroupItem.f1822i.setTextColor(contactPickerListGroupItem.f1824k);
        }
        if (contactPickerListGroupItem.f1836w.g) {
            if (contactPickerListGroupItem.f1830q == null) {
                contactPickerListGroupItem.f1830q = contactPickerListGroupItem.f1829p.inflate();
            }
            contactPickerListGroupItem.f1830q.setVisibility(0);
        } else if (contactPickerListGroupItem.f1830q != null) {
            contactPickerListGroupItem.f1830q.setVisibility(8);
        }
        contactPickerListGroupItem.m1746j();
        contactPickerListGroupItem.m1744f();
        contactPickerListGroupItem.m1745g();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1744f() {
        /*
        r12 = this;
        r10 = 5;
        r9 = 1;
        r5 = 8;
        r8 = 0;
        r0 = r12.f1836w;
        r11 = r0.b;
        r0 = r11;
        r1 = com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType.CALL_LOG;
        if (r0 == r1) goto L_0x001d;
    L_0x000e:
        r0 = r12.f1836w;
        r11 = r0.b;
        r0 = r11;
        r1 = com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType.ONGOING_GROUP_CALL;
        if (r0 == r1) goto L_0x001d;
    L_0x0017:
        r0 = r12.f1831r;
        r0.e();
    L_0x001c:
        return;
    L_0x001d:
        r0 = r12.f1831r;
        r0.f();
        r0 = 2131564742; // 0x7f0d18c6 float:1.8754978E38 double:1.053132911E-314;
        r0 = r12.a(r0);
        r0 = (com.facebook.resources.ui.FbTextView) r0;
        r12.f1834u = r0;
        r0 = r12.f1834u;
        r1 = r12.f1836w;
        r11 = r1.m;
        r1 = r11;
        r0.setText(r1);
        r0 = r12.f1834u;
        r0.setVisibility(r8);
        r0 = r12.f1825l;
        r0.setVisibility(r5);
        r0 = 2131564776; // 0x7f0d18e8 float:1.8755047E38 double:1.0531329277E-314;
        r0 = r12.a(r0);
        r0 = (com.facebook.fbui.glyph.GlyphView) r0;
        r1 = 2131564775; // 0x7f0d18e7 float:1.8755045E38 double:1.053132927E-314;
        r1 = r12.a(r1);
        r1 = (com.facebook.fbui.glyph.GlyphView) r1;
        r2 = 2131564774; // 0x7f0d18e6 float:1.8755043E38 double:1.0531329267E-314;
        r2 = r12.a(r2);
        r2 = (com.facebook.fbui.glyph.GlyphView) r2;
        r3 = 2131564773; // 0x7f0d18e5 float:1.875504E38 double:1.053132926E-314;
        r3 = r12.a(r3);
        r3 = (com.facebook.fbui.glyph.GlyphView) r3;
        r4 = 2131564772; // 0x7f0d18e4 float:1.8755039E38 double:1.0531329257E-314;
        r4 = r12.a(r4);
        r4 = (com.facebook.resources.ui.FbTextView) r4;
        r0.setVisibility(r5);
        r1.setVisibility(r5);
        r2.setVisibility(r5);
        r3.setVisibility(r5);
        r4.setVisibility(r5);
        r5 = r12.f1836w;
        r11 = r5.b;
        r5 = r11;
        r6 = com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType.ONGOING_GROUP_CALL;
        if (r5 != r6) goto L_0x00a5;
    L_0x0086:
        r0 = r12.f1835v;
        if (r0 != 0) goto L_0x001c;
    L_0x008a:
        r0 = r12.f1820g;
        r0 = r0.get();
        r0 = (java.util.concurrent.ScheduledExecutorService) r0;
        r1 = new com.facebook.messaging.contacts.picker.ContactPickerListGroupItem$2;
        r1.<init>(r12);
        r2 = 0;
        r4 = 1;
        r6 = java.util.concurrent.TimeUnit.SECONDS;
        r0 = r0.scheduleAtFixedRate(r1, r2, r4, r6);
        r12.f1835v = r0;
        goto L_0x001c;
    L_0x00a5:
        r5 = r12.f1835v;
        if (r5 == 0) goto L_0x00b1;
    L_0x00a9:
        r5 = r12.f1835v;
        r5.cancel(r9);
        r5 = 0;
        r12.f1835v = r5;
    L_0x00b1:
        r5 = r12.f1836w;
        r11 = r5.p;
        r5 = r11;
        r6 = java.lang.Math.min(r5, r10);
        switch(r6) {
            case 1: goto L_0x010b;
            case 2: goto L_0x00ef;
            case 3: goto L_0x00d2;
            case 4: goto L_0x00d2;
            case 5: goto L_0x00d2;
            default: goto L_0x00bd;
        };
    L_0x00bd:
        r0 = r12.f1818e;
        r1 = com.facebook.qe.api.Liveness.Cached;
        r2 = com.facebook.qe.api.ExposureLogging.Off;
        r5 = com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule.ap;
        r0 = r0.a(r1, r2, r5, r8);
        if (r0 == 0) goto L_0x0128;
    L_0x00cb:
        if (r6 != r10) goto L_0x0128;
    L_0x00cd:
        r4.setVisibility(r8);
        goto L_0x001c;
    L_0x00d2:
        r5 = r12.f1836w;
        r5 = r5.m();
        r7 = 2;
        r5 = r5.get(r7);
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r2.setImageResource(r5);
        r5 = 2131362509; // 0x7f0a02cd float:1.83448E38 double:1.0530329945E-314;
        r2.setGlyphColor(r5);
        r2.setVisibility(r8);
    L_0x00ef:
        r2 = r12.f1836w;
        r2 = r2.m();
        r2 = r2.get(r9);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r1.setImageResource(r2);
        r2 = 2131362509; // 0x7f0a02cd float:1.83448E38 double:1.0530329945E-314;
        r1.setGlyphColor(r2);
        r1.setVisibility(r8);
    L_0x010b:
        r1 = r12.f1836w;
        r1 = r1.m();
        r1 = r1.get(r8);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r0.setImageResource(r1);
        r1 = 2131362509; // 0x7f0a02cd float:1.83448E38 double:1.0530329945E-314;
        r0.setGlyphColor(r1);
        r0.setVisibility(r8);
        goto L_0x00bd;
    L_0x0128:
        r0 = 4;
        if (r6 < r0) goto L_0x001c;
    L_0x012b:
        r0 = r12.f1836w;
        r0 = r0.m();
        r1 = 3;
        r0 = r0.get(r1);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r3.setImageResource(r0);
        r0 = 2131362509; // 0x7f0a02cd float:1.83448E38 double:1.0530329945E-314;
        r3.setGlyphColor(r0);
        r3.setVisibility(r8);
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.picker.ContactPickerListGroupItem.f():void");
    }

    private void m1745g() {
        if (this.f1836w.k) {
            CharSequence string;
            this.f1833t.f();
            ((BetterButton) this.f1833t.a()).setEnabled(this.f1836w.f);
            BetterButton betterButton = (BetterButton) this.f1833t.a();
            if (this.f1836w.f) {
                string = getResources().getString(2131231251);
            } else {
                string = getResources().getString(2131231550);
            }
            betterButton.setText(string);
            ((Button) this.f1833t.a()).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactPickerListGroupItem f1811b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -22652618);
                    ListView listView = (ListView) this.getParent();
                    listView.performItemClick(this, listView.getPositionForView(this), (long) this.getId());
                    this.f1811b.f1836w.b(false);
                    ContactPickerListGroupItem.m1741a(this.f1811b);
                    Logger.a(2, EntryType.UI_INPUT_END, -1259035164, a);
                }
            });
            return;
        }
        this.f1833t.e();
    }

    private void m1746j() {
        Object obj;
        if ((this.f1836w.i && !StringUtil.a(this.f1836w.l)) || this.f1836w.j || this.f1836w.b == GroupRowSectionType.ONGOING_GROUP_CALL) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f1832s.e();
            return;
        }
        int i;
        this.f1832s.f();
        ImageView imageView = (ImageView) a(2131564759);
        ImageView imageView2 = (ImageView) a(2131564760);
        FbTextView fbTextView = (FbTextView) a(2131564777);
        if (!this.f1836w.i || StringUtil.a(this.f1836w.l)) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(this.f1819f.a());
            imageView.setVisibility(0);
        }
        if (this.f1836w.j) {
            imageView2.setImageDrawable(this.f1819f.f());
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new C02985(this));
        } else {
            imageView2.setVisibility(8);
        }
        if (this.f1836w.b == GroupRowSectionType.ONGOING_GROUP_CALL) {
            i = 0;
        } else {
            i = 8;
        }
        fbTextView.setVisibility(i);
    }
}

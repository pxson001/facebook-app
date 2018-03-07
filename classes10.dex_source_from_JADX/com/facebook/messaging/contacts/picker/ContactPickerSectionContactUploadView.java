package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.contacts.upload.ContactUploadUpsellController;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.contacts.upload.ContactsUploadState;
import com.facebook.contacts.upload.ContactsUploadState.Status;
import com.facebook.contacts.upload.ContactsUploadVisibility;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.contactsync.learn.ContactsLearnMoreLinkHelper;
import com.facebook.messaging.sms.migration.SMSContactsMigratorFlow;
import com.facebook.messaging.sms.migration.SMSMigrationAnalyticsLogger;
import com.facebook.messaging.sms.migration.SMSMigratorGatekeepers;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_recent_videos */
public class ContactPickerSectionContactUploadView extends CustomFrameLayout {
    @Inject
    public ContactsUploadRunner f1954a;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f1955b;
    @Inject
    AnalyticsLogger f1956c;
    @Inject
    public Lazy<NavigationLogger> f1957d;
    @Inject
    public ContactUploadUpsellController f1958e;
    @Inject
    public ContactsLearnMoreLinkHelper f1959f;
    @Inject
    RuntimePermissionsUtil f1960g;
    @Inject
    Lazy<SecureContextHelper> f1961h;
    @Inject
    Lazy<SMSMigrationAnalyticsLogger> f1962i;
    @Inject
    SMSMigratorGatekeepers f1963j;
    @Nullable
    Status f1964k;
    private final SelfRegistrableReceiverImpl f1965l;
    public final ContactPickerSectionUpsellView f1966m;
    private final LinearLayout f1967n;
    private final ProgressBar f1968o;
    private final RelativeLayout f1969p;
    private final BetterTextView f1970q;
    private final Button f1971r;
    private final BetterTextView f1972s;
    @Nullable
    public Listener f1973t;
    private final String f1974u;

    /* compiled from: tap_recent_videos */
    /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] f1943a = new int[Status.values().length];

        static {
            try {
                f1943a[Status.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1943a[Status.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1943a[Status.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1943a[Status.SUCCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: tap_recent_videos */
    class C03251 implements ActionReceiver {
        final /* synthetic */ ContactPickerSectionContactUploadView f1944a;

        C03251(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1944a = contactPickerSectionContactUploadView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 654548611);
            Map map = (Map) intent.getSerializableExtra("extra_permission_results");
            ContactPickerSectionContactUploadView contactPickerSectionContactUploadView = this.f1944a;
            Integer num = (Integer) map.get("android.permission.READ_CONTACTS");
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        contactPickerSectionContactUploadView.f1966m.m1827a(false);
                        ContactPickerSectionContactUploadView.m1818g(contactPickerSectionContactUploadView);
                        break;
                    case 2:
                        contactPickerSectionContactUploadView.f1966m.m1827a(true);
                        break;
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 408403182, a);
        }
    }

    /* compiled from: tap_recent_videos */
    class C03262 implements ActionReceiver {
        final /* synthetic */ ContactPickerSectionContactUploadView f1945a;

        C03262(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1945a = contactPickerSectionContactUploadView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -205836215);
            ContactPickerSectionContactUploadView.m1811a(this.f1945a, (ContactsUploadState) intent.getParcelableExtra("state"));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1153388727, a);
        }
    }

    /* compiled from: tap_recent_videos */
    class C03284 implements OnClickListener {
        final /* synthetic */ ContactPickerSectionContactUploadView f1948a;

        C03284(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1948a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1196330802);
            ContactPickerSectionContactUploadView.m1812a(this.f1948a, "contact_upload_upsell_not_now");
            ContactPickerSectionContactUploadView contactPickerSectionContactUploadView = this.f1948a;
            ContactUploadUpsellController contactUploadUpsellController = contactPickerSectionContactUploadView.f1958e;
            int a2 = contactUploadUpsellController.a.a(ContactsUploadPrefKeys.m, 0) + 1;
            Editor a3 = contactUploadUpsellController.a.edit().a(ContactsUploadPrefKeys.l, contactUploadUpsellController.b.a()).a(ContactsUploadPrefKeys.m, a2);
            if (a2 >= 2) {
                a3.a(ContactsUploadPrefKeys.n, 1);
            }
            a3.commit();
            ContactPickerSectionContactUploadView.m1820m(contactPickerSectionContactUploadView);
            Logger.a(2, EntryType.UI_INPUT_END, 1385496362, a);
        }
    }

    /* compiled from: tap_recent_videos */
    class C03295 implements OnClickListener {
        final /* synthetic */ ContactPickerSectionContactUploadView f1949a;

        C03295(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1949a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 794985754);
            ContactPickerSectionContactUploadView.m1812a(this.f1949a, "contact_upload_failed_retry");
            if (this.f1949a.f1960g.a("android.permission.READ_CONTACTS")) {
                ContactPickerSectionContactUploadView.m1818g(this.f1949a);
            }
            LogUtils.a(769076091, a);
        }
    }

    /* compiled from: tap_recent_videos */
    class C03306 extends ClickableSpan {
        final /* synthetic */ ContactPickerSectionContactUploadView f1950a;

        C03306(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1950a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            ContactPickerSectionContactUploadView.m1812a(this.f1950a, "contact_upload_upsell_learn_more");
            this.f1950a.f1959f.m1896a();
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f1950a.getResources().getColor(2131362241));
        }
    }

    /* compiled from: tap_recent_videos */
    class C03317 extends ClickableSpan {
        final /* synthetic */ ContactPickerSectionContactUploadView f1951a;

        C03317(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1951a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            ContactPickerSectionContactUploadView.m1812a(this.f1951a, "contact_upload_failed_not_now");
            ContactPickerSectionContactUploadView.m1820m(this.f1951a);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f1951a.getResources().getColor(2131362241));
        }
    }

    /* compiled from: tap_recent_videos */
    public class C03328 extends ClickableSpan {
        final /* synthetic */ ContactPickerSectionContactUploadView f1952a;

        public C03328(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1952a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            ContactPickerSectionContactUploadView.m1812a(this.f1952a, "picker_contact_upload_success_no_contacts");
            ContactPickerSectionContactUploadView.m1820m(this.f1952a);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f1952a.getResources().getColor(2131362241));
        }
    }

    /* compiled from: tap_recent_videos */
    public class C03339 extends ClickableSpan {
        final /* synthetic */ ContactPickerSectionContactUploadView f1953a;

        public C03339(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
            this.f1953a = contactPickerSectionContactUploadView;
        }

        public void onClick(View view) {
            ContactPickerSectionContactUploadView.m1812a(this.f1953a, "picker_contact_upload_success");
            ContactPickerSectionContactUploadView contactPickerSectionContactUploadView = this.f1953a;
            if (contactPickerSectionContactUploadView.f1973t != null) {
                contactPickerSectionContactUploadView.f1954a.b();
            }
            ContactPickerSectionContactUploadView.m1820m(contactPickerSectionContactUploadView);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f1953a.getResources().getColor(2131362241));
        }
    }

    /* compiled from: tap_recent_videos */
    public interface Listener {
        boolean m1808a();
    }

    public static void m1815a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactPickerSectionContactUploadView) obj).m1810a(ContactsUploadRunner.a(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), ContactUploadUpsellController.b(fbInjector), ContactsLearnMoreLinkHelper.m1895b(fbInjector), RuntimePermissionsUtil.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 8476), SMSMigratorGatekeepers.m3843b(fbInjector));
    }

    public static void m1811a(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView, ContactsUploadState contactsUploadState) {
        int i = contactsUploadState.b;
        int i2 = contactsUploadState.d;
        if (i <= 0) {
            contactPickerSectionContactUploadView.f1968o.setIndeterminate(true);
        } else {
            contactPickerSectionContactUploadView.f1968o.setIndeterminate(false);
            contactPickerSectionContactUploadView.f1968o.setProgress(i);
            contactPickerSectionContactUploadView.f1968o.setMax(i2);
        }
        contactPickerSectionContactUploadView.m1819i();
    }

    private void m1810a(ContactsUploadRunner contactsUploadRunner, FbBroadcastManager fbBroadcastManager, AnalyticsLogger analyticsLogger, Lazy<NavigationLogger> lazy, ContactUploadUpsellController contactUploadUpsellController, ContactsLearnMoreLinkHelper contactsLearnMoreLinkHelper, RuntimePermissionsUtil runtimePermissionsUtil, Lazy<SecureContextHelper> lazy2, Lazy<SMSMigrationAnalyticsLogger> lazy3, SMSMigratorGatekeepers sMSMigratorGatekeepers) {
        this.f1954a = contactsUploadRunner;
        this.f1955b = fbBroadcastManager;
        this.f1956c = analyticsLogger;
        this.f1957d = lazy;
        this.f1958e = contactUploadUpsellController;
        this.f1959f = contactsLearnMoreLinkHelper;
        this.f1960g = runtimePermissionsUtil;
        this.f1961h = lazy2;
        this.f1962i = lazy3;
        this.f1963j = sMSMigratorGatekeepers;
    }

    public ContactPickerSectionContactUploadView(Context context) {
        this(context, null, 0);
    }

    private ContactPickerSectionContactUploadView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1974u = "people_tab_upload_upsell";
        Class cls = ContactPickerSectionContactUploadView.class;
        m1815a((Object) this, getContext());
        this.f1965l = this.f1955b.a().a("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED", new C03262(this)).a("contacts_upload_permissions_results_received", new C03251(this)).a();
        setPadding(0, getResources().getDimensionPixelOffset(2131428543), 0, 0);
        setContentView(2130905666);
        this.f1966m = (ContactPickerSectionUpsellView) findViewById(2131564780);
        this.f1966m.setNegativeButtonContentDescription(getResources().getString(2131240850));
        this.f1966m.setTitle(getResources().getString(2131240847));
        this.f1966m.setTextContentDescription(getResources().getString(2131240849));
        this.f1966m.setPositiveButtonText(getResources().getString(2131240852));
        this.f1966m.setPositiveButtonOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactPickerSectionContactUploadView f1947b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2060177222);
                ContactPickerSectionContactUploadView.m1812a(this.f1947b, "contact_upload_upsell_start");
                if (this.f1947b.f1963j.m3844a()) {
                    ((SMSMigrationAnalyticsLogger) this.f1947b.f1962i.get()).m3842a("people_tab_upload_upsell");
                    ((SecureContextHelper) this.f1947b.f1961h.get()).a(SMSContactsMigratorFlow.NUX_UPLOAD_FLOW.generateIntent(context), context);
                }
                LogUtils.a(-1364567417, a);
            }
        });
        this.f1966m.setNegativeButtonOnClickListener(new C03284(this));
        this.f1967n = (LinearLayout) findViewById(2131564781);
        this.f1968o = (ProgressBar) findViewById(2131564783);
        this.f1968o.setIndeterminate(true);
        this.f1969p = (RelativeLayout) findViewById(2131564784);
        this.f1970q = (BetterTextView) findViewById(2131564786);
        this.f1971r = (Button) findViewById(2131564787);
        this.f1971r.setOnClickListener(new C03295(this));
        this.f1972s = (BetterTextView) findViewById(2131564788);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -231694270);
        super.onAttachedToWindow();
        m1809a();
        m1816b();
        if (this.f1973t != null) {
            this.f1966m.m1827a(this.f1973t.m1808a());
        }
        this.f1965l.b();
        m1811a(this, this.f1954a.b());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -247455102, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1584949817);
        super.onDetachedFromWindow();
        this.f1965l.c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1963070030, a);
    }

    private void m1809a() {
        m1817b(this.f1966m.f1993b, new C03306(this));
    }

    private void m1816b() {
        m1813a(this.f1970q, new C03317(this));
    }

    private void m1813a(BetterTextView betterTextView, ClickableSpan clickableSpan) {
        m1814a(betterTextView, clickableSpan, 2131240855, 2131240857, "[[not_now_link]]");
    }

    private void m1817b(BetterTextView betterTextView, ClickableSpan clickableSpan) {
        m1814a(betterTextView, clickableSpan, 2131240848, 2131240851, "[[learn_more_link]]");
    }

    private void m1814a(BetterTextView betterTextView, ClickableSpan clickableSpan, int i, int i2, String str) {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(i);
        styledStringBuilder.a(str, getContext().getString(i2), clickableSpan, 33);
        betterTextView.setMovementMethod(LinkMovementMethod.getInstance());
        betterTextView.setText(styledStringBuilder.b());
    }

    public static void m1818g(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
        contactPickerSectionContactUploadView.f1954a.a(ContactsUploadVisibility.SHOW);
        contactPickerSectionContactUploadView.m1819i();
    }

    private void m1819i() {
        int i = 8;
        ContactsUploadState b = this.f1954a.b();
        Status status = b.a;
        if (status != this.f1964k) {
            int i2;
            int i3;
            int i4;
            Builder builder = ImmutableMap.builder();
            if (this.f1964k != null) {
                builder.b("source_module", this.f1964k.toString());
            }
            builder.b("dest_module", status.toString());
            String str = null;
            ((NavigationLogger) this.f1957d.get()).a(null, "neue_nux", str, "neue", builder.b());
            this.f1964k = status;
            switch (AnonymousClass10.f1943a[status.ordinal()]) {
                case 1:
                    i2 = 8;
                    i3 = 8;
                    i4 = 0;
                    break;
                case 2:
                    i2 = 8;
                    i3 = 0;
                    i4 = 8;
                    break;
                case 3:
                    i2 = 0;
                    i3 = 8;
                    i4 = 8;
                    break;
                case 4:
                    setupUploadSuccessText(b.c);
                    i2 = 8;
                    i3 = 8;
                    i4 = 8;
                    i = 0;
                    break;
                default:
                    i2 = 8;
                    i3 = 8;
                    i4 = 8;
                    break;
            }
            setVisibility(0);
            this.f1966m.setVisibility(i4);
            this.f1967n.setVisibility(i3);
            this.f1969p.setVisibility(i2);
            this.f1972s.setVisibility(i);
        }
    }

    private void setupUploadSuccessText(int i) {
        CharSequence b;
        CharSequence string;
        String string2;
        StyledStringBuilder styledStringBuilder;
        if (i == 0) {
            C03328 c03328 = new C03328(this);
            string = getResources().getString(2131240873);
            string2 = getResources().getString(2131240874);
            styledStringBuilder = new StyledStringBuilder(getResources());
            styledStringBuilder.a(string);
            styledStringBuilder.a("[[okay]]", string2, c03328, 33);
            b = styledStringBuilder.b();
        } else {
            C03339 c03339 = new C03339(this);
            string = getResources().getQuantityString(2131689775, i, new Object[]{Integer.valueOf(i)});
            string2 = getResources().getString(2131240872);
            styledStringBuilder = new StyledStringBuilder(getResources());
            styledStringBuilder.a(string);
            styledStringBuilder.a("[[view]]", string2, c03339, 33);
            b = styledStringBuilder.b();
        }
        this.f1972s.setMovementMethod(LinkMovementMethod.getInstance());
        this.f1972s.setText(b);
    }

    public static void m1820m(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView) {
        contactPickerSectionContactUploadView.f1954a.a();
        contactPickerSectionContactUploadView.setVisibility(8);
    }

    public static void m1812a(ContactPickerSectionContactUploadView contactPickerSectionContactUploadView, String str) {
        HoneyClientEventFast a = contactPickerSectionContactUploadView.f1956c.a(str, false);
        if (a.a()) {
            a.b();
        }
    }
}

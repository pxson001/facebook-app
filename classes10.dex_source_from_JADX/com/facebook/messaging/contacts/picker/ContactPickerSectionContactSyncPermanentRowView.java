package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.contacts.upload.ContactsUploadState;
import com.facebook.contacts.upload.ContactsUploadState.Status;
import com.facebook.contacts.upload.ContactsUploadVisibility;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
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
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.CustomRelativeLayout;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_search_button */
public class ContactPickerSectionContactSyncPermanentRowView extends CustomRelativeLayout {
    @Inject
    ContactsLearnMoreLinkHelper f1927a;
    @Inject
    public ContactsUploadRunner f1928b;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager f1929c;
    @Inject
    AnalyticsLogger f1930d;
    @Inject
    NavigationLogger f1931e;
    @Inject
    RuntimePermissionsUtil f1932f;
    @Inject
    Lazy<SecureContextHelper> f1933g;
    @Inject
    Lazy<SMSMigrationAnalyticsLogger> f1934h;
    @Inject
    SMSMigratorGatekeepers f1935i;
    @Nullable
    Status f1936j;
    private final ContactPickerSectionTopRowView f1937k;
    private final ProgressBar f1938l;
    @Nullable
    public Listener f1939m;
    private SelfRegistrableReceiverImpl f1940n;
    private final String f1941o;

    /* compiled from: tap_search_button */
    class C03161 implements OnClickListener {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1918a;

        C03161(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1918a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1573454635);
            this.f1918a.m1800b();
            Logger.a(2, EntryType.UI_INPUT_END, 53570027, a);
        }
    }

    /* compiled from: tap_search_button */
    class C03172 implements ActionReceiver {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1919a;

        C03172(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1919a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 60473420);
            this.f1919a.m1806a((Map) intent.getSerializableExtra("extra_permission_results"));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 816341864, a);
        }
    }

    /* compiled from: tap_search_button */
    class C03183 implements ActionReceiver {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1920a;

        C03183(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1920a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1770413704);
            this.f1920a.m1794a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -954037678, a);
        }
    }

    /* compiled from: tap_search_button */
    class C03194 extends ClickableSpan {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1921a;

        C03194(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1921a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(View view) {
            this.f1921a.f1927a.m1896a();
        }
    }

    /* compiled from: tap_search_button */
    class C03205 implements DialogInterface.OnClickListener {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1922a;

        C03205(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1922a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ContactPickerSectionContactSyncPermanentRowView.m1796a(this.f1922a, "contact_sync_permanent_row_conf_dialog_cancel");
            dialogInterface.dismiss();
        }
    }

    /* compiled from: tap_search_button */
    class C03216 implements DialogInterface.OnClickListener {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1923a;

        C03216(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1923a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ContactPickerSectionContactSyncPermanentRowView.m1796a(this.f1923a, "contact_sync_permanent_row_conf_dialog_accept");
            dialogInterface.dismiss();
            ContactPickerSectionContactSyncPermanentRowView.m1804f(this.f1923a);
        }
    }

    /* compiled from: tap_search_button */
    class C03227 implements DialogInterface.OnClickListener {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1924a;

        C03227(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1924a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ContactPickerSectionContactSyncPermanentRowView.m1796a(this.f1924a, "contact_sync_permanent_row_try_again_dialog_cancel");
            dialogInterface.dismiss();
            ContactPickerSectionContactSyncPermanentRowView.m1805g(this.f1924a);
        }
    }

    /* compiled from: tap_search_button */
    class C03238 implements DialogInterface.OnClickListener {
        final /* synthetic */ ContactPickerSectionContactSyncPermanentRowView f1925a;

        C03238(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
            this.f1925a = contactPickerSectionContactSyncPermanentRowView;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ContactPickerSectionContactSyncPermanentRowView.m1796a(this.f1925a, "contact_sync_permanent_row_try_again_dialog_accept");
            dialogInterface.dismiss();
            ContactPickerSectionContactSyncPermanentRowView.m1804f(this.f1925a);
        }
    }

    /* compiled from: tap_search_button */
    /* synthetic */ class C03249 {
        static final /* synthetic */ int[] f1926a = new int[Status.values().length];

        static {
            try {
                f1926a[Status.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1926a[Status.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1926a[Status.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1926a[Status.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: tap_search_button */
    public interface Listener {
    }

    public static void m1798a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactPickerSectionContactSyncPermanentRowView) obj).m1797a(ContactsLearnMoreLinkHelper.m1895b(fbInjector), ContactsUploadRunner.a(fbInjector), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), NavigationLogger.a(fbInjector), RuntimePermissionsUtil.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 8476), SMSMigratorGatekeepers.m3843b(fbInjector));
    }

    private void m1797a(ContactsLearnMoreLinkHelper contactsLearnMoreLinkHelper, ContactsUploadRunner contactsUploadRunner, FbBroadcastManager fbBroadcastManager, AnalyticsLogger analyticsLogger, NavigationLogger navigationLogger, RuntimePermissionsUtil runtimePermissionsUtil, Lazy<SecureContextHelper> lazy, Lazy<SMSMigrationAnalyticsLogger> lazy2, SMSMigratorGatekeepers sMSMigratorGatekeepers) {
        this.f1927a = contactsLearnMoreLinkHelper;
        this.f1928b = contactsUploadRunner;
        this.f1929c = fbBroadcastManager;
        this.f1930d = analyticsLogger;
        this.f1931e = navigationLogger;
        this.f1932f = runtimePermissionsUtil;
        this.f1933g = lazy;
        this.f1934h = lazy2;
        this.f1935i = sMSMigratorGatekeepers;
    }

    public ContactPickerSectionContactSyncPermanentRowView(Context context) {
        this(context, null, 0);
    }

    private ContactPickerSectionContactSyncPermanentRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1941o = "people_tab_permanent_row";
        Class cls = ContactPickerSectionContactSyncPermanentRowView.class;
        m1798a((Object) this, getContext());
        setContentView(2130905665);
        this.f1937k = (ContactPickerSectionTopRowView) findViewById(2131564779);
        this.f1937k.setIconResource(2130841985);
        this.f1937k.setOnClickListener(new C03161(this));
        this.f1938l = (ProgressBar) findViewById(2131564778);
        this.f1940n = this.f1929c.a().a("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED", new C03183(this)).a("contacts_upload_permissions_results_received", new C03172(this)).a();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1432861320);
        super.onAttachedToWindow();
        this.f1940n.b();
        m1794a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1782056163, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1527017063);
        super.onDetachedFromWindow();
        this.f1940n.c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1735243278, a);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        }
    }

    public final void m1806a(Map<String, Integer> map) {
        Integer num = (Integer) map.get("android.permission.READ_CONTACTS");
        if (num != null) {
            switch (num.intValue()) {
                case 0:
                    m1802c();
                    return;
                default:
                    return;
            }
        }
    }

    private void m1794a() {
        ContactsUploadState b = this.f1928b.b();
        Status status = b.a;
        if (status != this.f1936j) {
            this.f1936j = status;
            switch (C03249.f1926a[status.ordinal()]) {
                case 1:
                    this.f1937k.setTextResource(2131240859);
                    this.f1938l.setVisibility(4);
                    this.f1937k.setEnabled(true);
                    return;
                case 2:
                    this.f1937k.setTextResource(2131240860);
                    this.f1938l.setVisibility(0);
                    this.f1937k.setEnabled(false);
                    return;
                case 3:
                    int i = b.c;
                    if (i == 0) {
                        this.f1937k.setTextResource(2131240861);
                    } else {
                        this.f1937k.setText(getResources().getQuantityString(2131689776, i, new Object[]{Integer.valueOf(i)}));
                    }
                    this.f1938l.setVisibility(4);
                    this.f1937k.setEnabled(true);
                    return;
                case 4:
                    this.f1937k.setTextResource(2131240862);
                    this.f1938l.setVisibility(4);
                    this.f1937k.setEnabled(true);
                    return;
                default:
                    return;
            }
        }
    }

    private void m1800b() {
        if (this.f1936j != null) {
            switch (C03249.f1926a[this.f1936j.ordinal()]) {
                case 1:
                    if (this.f1932f.a("android.permission.READ_CONTACTS")) {
                        m1802c();
                        return;
                    } else if (this.f1939m == null) {
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (this.f1928b.b().c > 0 && this.f1939m != null) {
                        this.f1928b.b();
                    }
                    m1796a(this, "contact_sync_permanent_row_view_synced_contacts_click");
                    m1805g(this);
                    return;
                case 4:
                    m1803e();
                    return;
                default:
                    return;
            }
        }
    }

    private void m1802c() {
        m1796a(this, "contact_sync_permanent_row_click");
        if (this.f1935i.m3844a()) {
            ((SMSMigrationAnalyticsLogger) this.f1934h.get()).m3842a("people_tab_permanent_row");
            ((SecureContextHelper) this.f1933g.get()).a(SMSContactsMigratorFlow.NUX_UPLOAD_FLOW.generateIntent(getContext()), getContext());
            return;
        }
        SpannableString spannableString = new SpannableString(getResources().getString(2131240864));
        Spannable spannableString2 = new SpannableString(" " + getResources().getString(2131240865));
        spannableString2.setSpan(new C03194(this), 0, spannableString2.length(), 33);
        AlertDialog b = new FbAlertDialogBuilder(getContext()).a(2131240863).b(TextUtils.concat(new CharSequence[]{spannableString, " ", spannableString2})).a(2131230726, new C03216(this)).b(2131230727, new C03205(this)).b();
        m1799a("SyncContactsPermanentRowConfDialog", "people");
        ((TextView) b.findViewById(2131559674)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m1803e() {
        m1796a(this, "contact_sync_permanent_row_failed_click");
        new FbAlertDialogBuilder(getContext()).a(2131240866).b(2131240867).a(2131230726, new C03238(this)).b(2131230737, new C03227(this)).b();
        m1799a("SyncContactsPermanentRowTryAgainDialog", "people");
    }

    public static void m1804f(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
        contactPickerSectionContactSyncPermanentRowView.f1928b.a(ContactsUploadVisibility.SHOW);
        contactPickerSectionContactSyncPermanentRowView.m1794a();
    }

    public static void m1805g(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView) {
        contactPickerSectionContactSyncPermanentRowView.f1928b.a();
        contactPickerSectionContactSyncPermanentRowView.setVisibility(8);
    }

    public static void m1796a(ContactPickerSectionContactSyncPermanentRowView contactPickerSectionContactSyncPermanentRowView, String str) {
        HoneyClientEventFast a = contactPickerSectionContactSyncPermanentRowView.f1930d.a(str, false);
        if (a.a()) {
            a.b();
        }
    }

    private void m1799a(String str, String str2) {
        this.f1931e.a(null, str2, str, null, null);
    }
}

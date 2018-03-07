package com.facebook.katana;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.logging.DBLLoggerHelper;
import com.facebook.devicebasedlogin.ui.DBLProfilePhotoView;
import com.facebook.inject.FbInjector;
import com.facebook.katana.dbl.DBLRequestHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.login.ComponentName_LoginActivityComponentMethodAutoProvider;
import com.facebook.katana.login.LoginActivityComponent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.IFbResourcesNotRequired;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

/* compiled from: SEND_FAILED_THRIFT_EXCEPTION */
public class DBLAccountSettingsActivity extends FbFragmentActivity implements OnClickListener, IAuthNotRequired, IFbResourcesNotRequired {
    private View f24070A;
    private View f24071B;
    private boolean f24072C = false;
    @Inject
    DBLStorageAndRetrievalHelper f24073p;
    @Inject
    SecureContextHelper f24074q;
    @Inject
    DBLLoggerHelper f24075r;
    @LoginActivityComponent
    @Inject
    ComponentName f24076s;
    @Inject
    DBLRequestHelper f24077t;
    private DBLFacebookCredentials f24078u;
    private View f24079v;
    private TextView f24080w;
    private TextView f24081x;
    private View f24082y;
    private View f24083z;

    private static <T extends Context> void m25375a(Class<T> cls, T t) {
        m25376a((Object) t, (Context) t);
    }

    public static void m25376a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DBLAccountSettingsActivity) obj).m25374a(DBLStorageAndRetrievalHelper.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), DBLLoggerHelper.b(fbInjector), ComponentName_LoginActivityComponentMethodAutoProvider.b(fbInjector), DBLRequestHelper.m918b(fbInjector));
    }

    public final void m25382b(Bundle bundle) {
        super.b(bundle);
        Class cls = DBLAccountSettingsActivity.class;
        m25376a((Object) this, (Context) this);
        setContentView(2130903845);
        m25377i();
    }

    private void m25377i() {
        this.f24078u = (DBLFacebookCredentials) getIntent().getExtras().getParcelable("dbl_account_details");
        ((DBLProfilePhotoView) findViewById(2131559671)).setImage(this.f24078u.mPicUrl);
        if (this.f24078u.mNonce.equals("password_account")) {
            this.f24072C = true;
        }
        ((TextView) findViewById(2131560890)).setText(this.f24078u.mName);
        this.f24079v = findViewById(2131560891);
        this.f24079v.setOnClickListener(this);
        this.f24080w = (TextView) findViewById(2131560893);
        this.f24080w.setOnClickListener(this);
        this.f24081x = (TextView) findViewById(2131560894);
        this.f24081x.setOnClickListener(this);
        ((TextView) findViewById(2131559592)).setText(2131236263);
        this.f24082y = findViewById(2131560895);
        this.f24082y.setOnClickListener(this);
        this.f24083z = findViewById(2131560898);
        this.f24083z.setOnClickListener(this);
        this.f24071B = findViewById(2131560897);
        this.f24071B.setOnClickListener(this);
        this.f24070A = findViewById(2131560899);
        this.f24070A.setOnClickListener(this);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1652770808);
        int id = view.getId();
        if (id == 2131560899) {
            m25380l();
        } else if (id == 2131560895) {
            m25381m();
        } else {
            Intent intent = new Intent(this, DBLPinSettingsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("dbl_account_details", this.f24078u);
            if (id == 2131560891) {
                bundle.putString("operation_type", "add_pin");
            } else if (id == 2131560893) {
                bundle.putString("operation_type", "change_pin");
            } else if (id == 2131560894) {
                bundle.putString("operation_type", "remove_pin");
            } else if (id == 2131560898) {
                bundle.putString("operation_type", "switch_to_dbl_with_pin");
            } else if (id == 2131560897) {
                bundle.putString("operation_type", "switch_to_dbl");
            }
            intent.putExtras(bundle);
            this.f24074q.a(intent, this);
            overridePendingTransition(2130968625, 2130968631);
        }
        LogUtils.a(2097656948, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1474743080);
        super.onResume();
        m25378j();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -887406168, a);
    }

    private void m25378j() {
        this.f24078u = this.f24073p.c(this.f24078u.mUserId);
        if (this.f24078u == null) {
            finish();
            return;
        }
        if (this.f24078u.mNonce.equals("password_account")) {
            this.f24072C = true;
        } else {
            this.f24072C = false;
        }
        if (this.f24072C) {
            this.f24079v.setVisibility(8);
            this.f24080w.setVisibility(8);
            this.f24081x.setVisibility(8);
            this.f24082y.setVisibility(8);
            this.f24083z.setVisibility(0);
            this.f24071B.setVisibility(0);
        } else {
            this.f24083z.setVisibility(8);
            this.f24071B.setVisibility(8);
            if (this.f24078u.mIsPinSet.booleanValue()) {
                this.f24079v.setVisibility(8);
                this.f24080w.setVisibility(0);
                this.f24081x.setVisibility(0);
            } else {
                this.f24079v.setVisibility(0);
                this.f24080w.setVisibility(8);
                this.f24081x.setVisibility(8);
            }
            if (m25379k()) {
                this.f24082y.setVisibility(0);
            }
        }
        if (m25379k()) {
            ((TextView) findViewById(2131560900)).setText(2131236294);
            ((TextView) findViewById(2131560901)).setText(2131236295);
            findViewById(2131560892).setVisibility(0);
        }
    }

    private boolean m25379k() {
        return this.f24073p.d(this.f24078u.mUserId);
    }

    private void m25380l() {
        this.f24077t.m919a(this.f24078u, "logged_out_settings");
        Toast.makeText(getApplicationContext(), 2131236283, 0).show();
        if (this.f24073p.c().booleanValue()) {
            finish();
            return;
        }
        Intent component = new Intent().setComponent(this.f24076s);
        component.setFlags(268468224);
        this.f24074q.a(component, this);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f24073p.d() > 1) {
            overridePendingTransition(2130968625, 2130968631);
        }
    }

    private void m25381m() {
        this.f24077t.m921b(this.f24078u, "logged_out_settings");
        Toast.makeText(getApplicationContext(), 2131236282, 0).show();
        m25378j();
    }

    private void m25374a(DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, SecureContextHelper secureContextHelper, DBLLoggerHelper dBLLoggerHelper, ComponentName componentName, DBLRequestHelper dBLRequestHelper) {
        this.f24073p = dBLStorageAndRetrievalHelper;
        this.f24074q = secureContextHelper;
        this.f24075r = dBLLoggerHelper;
        this.f24076s = componentName;
        this.f24077t = dBLRequestHelper;
    }
}

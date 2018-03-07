package com.facebook.katana;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.content.SecureContextHelper;
import com.facebook.devicebasedlogin.settings.DBLLoggedInAccountSettingsController;
import com.facebook.devicebasedlogin.settings.DBLSettingsCategoryViewHolder;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem.ItemViewType;
import com.facebook.devicebasedlogin.settings.DBLSettingsItem.SettingCategory;
import com.facebook.devicebasedlogin.settings.DBLSettingsPreferenceViewHolder;
import com.facebook.devicebasedlogin.settings.DBLSettingsViewHolder;
import com.facebook.graphql.calls.DeviceBasedLoginRemoveRemoteDeviceInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.katana.dbl.DBLRemoveRemoteDeviceMutation.DeviceBasedLoginRemoveRemoteDeviceMutationString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import java.util.List;
import javax.inject.Inject;

/* compiled from: SENDER_NAME */
public class DBLSettingsAdapter extends Adapter<DBLSettingsViewHolder> implements OnClickListener {
    private List<DBLSettingsItem> f24132a;
    private final Context f24133b;
    private final DBLLoggedInAccountSettingsController f24134c;
    private final SecureContextHelper f24135d;

    /* compiled from: SENDER_NAME */
    /* synthetic */ class C34681 {
        static final /* synthetic */ int[] f24131a = new int[SettingCategory.values().length];

        static {
            try {
                f24131a[SettingCategory.REMOVE_ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24131a[SettingCategory.RESET_SETTINGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f24131a[SettingCategory.USE_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f24131a[SettingCategory.ADD_PASSCODE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f24131a[SettingCategory.CHANGE_PASSCODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f24131a[SettingCategory.REMOVE_PASSCODE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f24131a[SettingCategory.REMEMBER_PASSWORD.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f24131a[SettingCategory.USE_PASSCODE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f24131a[SettingCategory.OTHER_SESSION.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public final ViewHolder m25460a(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new DBLSettingsCategoryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130903858, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903860, viewGroup, false);
        inflate.setOnClickListener(this);
        return new DBLSettingsPreferenceViewHolder(inflate, viewGroup.getContext());
    }

    public final void m25461a(ViewHolder viewHolder, int i) {
        DBLSettingsViewHolder dBLSettingsViewHolder = (DBLSettingsViewHolder) viewHolder;
        dBLSettingsViewHolder.a((DBLSettingsItem) this.f24132a.get(i));
        dBLSettingsViewHolder.c(i);
    }

    @Inject
    public DBLSettingsAdapter(@Assisted List<DBLSettingsItem> list, @Assisted Context context, DBLLoggedInAccountSettingsController dBLLoggedInAccountSettingsController, SecureContextHelper secureContextHelper) {
        this.f24132a = list;
        this.f24133b = context;
        this.f24134c = dBLLoggedInAccountSettingsController;
        this.f24135d = secureContextHelper;
    }

    public int getItemViewType(int i) {
        return ((DBLSettingsItem) this.f24132a.get(i)).f == ItemViewType.CATEGORY ? 0 : 1;
    }

    public final int aZ_() {
        return this.f24132a.size();
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 39180024);
        int intValue = ((Integer) view.getTag()).intValue();
        DBLSettingsItem dBLSettingsItem = (DBLSettingsItem) this.f24132a.get(intValue);
        DBLLoggedInAccountSettingsController dBLLoggedInAccountSettingsController = this.f24134c;
        DBLFacebookCredentials c = dBLLoggedInAccountSettingsController.a.c(((User) dBLLoggedInAccountSettingsController.b.get()).a);
        switch (C34681.f24131a[dBLSettingsItem.e.ordinal()]) {
            case 1:
            case 2:
                this.f24134c.j.m919a(c, "logged_in_settings");
                Toast.makeText(this.f24133b.getApplicationContext(), 2131236253, 0).show();
                ((Activity) this.f24133b).onBackPressed();
                break;
            case 3:
                this.f24134c.j.m921b(c, "logged_in_settings");
                break;
            case 4:
                m25459a(c, "add_pin");
                break;
            case 5:
                m25459a(c, "change_pin");
                break;
            case 6:
                m25459a(c, "remove_pin");
                break;
            case 7:
                m25459a(c, "switch_to_dbl");
                break;
            case 8:
                m25459a(c, "switch_to_dbl_with_pin");
                break;
            case 9:
                break;
        }
        dBLLoggedInAccountSettingsController = this.f24134c;
        String str = dBLSettingsItem.g;
        DeviceBasedLoginRemoveRemoteDeviceInputData deviceBasedLoginRemoveRemoteDeviceInputData = new DeviceBasedLoginRemoveRemoteDeviceInputData();
        deviceBasedLoginRemoveRemoteDeviceInputData.a("datr", str);
        GraphQlCallInput graphQlCallInput = deviceBasedLoginRemoveRemoteDeviceInputData;
        GraphQlQueryString deviceBasedLoginRemoveRemoteDeviceMutationString = new DeviceBasedLoginRemoveRemoteDeviceMutationString();
        deviceBasedLoginRemoveRemoteDeviceMutationString.a("input", graphQlCallInput);
        dBLLoggedInAccountSettingsController.h.a(GraphQLRequest.a(deviceBasedLoginRemoveRemoteDeviceMutationString));
        this.f24132a.remove(dBLSettingsItem);
        l_(intValue);
        a(intValue, aZ_());
        LogUtils.a(385157533, a);
    }

    private Intent m25459a(DBLFacebookCredentials dBLFacebookCredentials, String str) {
        Intent intent = new Intent(this.f24133b, DBLPinSettingsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("dbl_account_details", dBLFacebookCredentials);
        bundle.putString("operation_type", str);
        bundle.putString("source", "logged_in_settings");
        intent.putExtras(bundle);
        this.f24135d.a(intent, 12, (Activity) this.f24133b);
        ((Activity) this.f24133b).overridePendingTransition(2130968625, 2130968631);
        return intent;
    }
}

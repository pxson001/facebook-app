package com.facebook.katana.dbl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;

/* compiled from: upload_flow */
public class DBLPinOperationTypes {

    /* compiled from: upload_flow */
    public class AddPinOperation implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce";
        }

        public final Type mo37b() {
            return Type.ADD_PIN;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLSetNewPinFragment dBLSetNewPinFragment = new DBLSetNewPinFragment();
            dBLSetNewPinFragment.f901a = dBLPinSettingsListener;
            if (i2 == 0) {
                i2 = 2131236265;
            }
            dBLSetNewPinFragment.m929h(i2);
            if (i == 0) {
                i = 2131236237;
            }
            dBLSetNewPinFragment.m928g(i);
            return dBLSetNewPinFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m907b(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class ChangePasscodeAfterIncorrectPasscodeOperation implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce_using_password";
        }

        public final Type mo37b() {
            return Type.CHANGE_PASSCODE_AFTER_INCORRECT_PASSCODE;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLSetNewPinFragment dBLSetNewPinFragment = new DBLSetNewPinFragment();
            dBLSetNewPinFragment.f901a = dBLPinSettingsListener;
            if (i2 == 0) {
                i2 = 2131236267;
            }
            dBLSetNewPinFragment.m929h(i2);
            if (i == 0) {
                i = 2131236250;
            }
            dBLSetNewPinFragment.m928g(i);
            return dBLSetNewPinFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m906a(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class ChangePasscodeFromLoginFlow implements DBLPinOperation {
        public final String mo36a() {
            return "set_nonce";
        }

        public final Type mo37b() {
            return Type.CHANGE_PASSCODE_FROM_LOGIN_FLOW;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLChangePasscodeAfterIncorrectPasscodeFragment dBLChangePasscodeAfterIncorrectPasscodeFragment = new DBLChangePasscodeAfterIncorrectPasscodeFragment();
            dBLChangePasscodeAfterIncorrectPasscodeFragment.f872a = dBLPinSettingsListener;
            if (i2 == 0) {
                i2 = 2131236268;
            }
            dBLChangePasscodeAfterIncorrectPasscodeFragment.f876e = i2;
            if (dBLChangePasscodeAfterIncorrectPasscodeFragment.f880i != null) {
                dBLChangePasscodeAfterIncorrectPasscodeFragment.f880i.setText(dBLChangePasscodeAfterIncorrectPasscodeFragment.f876e);
            }
            if (i == 0) {
                i = 2131236250;
            }
            dBLChangePasscodeAfterIncorrectPasscodeFragment.f875d = i;
            if (dBLChangePasscodeAfterIncorrectPasscodeFragment.T != null) {
                ((TextView) dBLChangePasscodeAfterIncorrectPasscodeFragment.T.findViewById(2131559592)).setText(dBLChangePasscodeAfterIncorrectPasscodeFragment.f875d);
            }
            return dBLChangePasscodeAfterIncorrectPasscodeFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            Bundle bundle = new Bundle();
            bundle.putString("pin", str2);
            bundle.putString("nonce_to_keep", "");
            return bundle;
        }
    }

    /* compiled from: upload_flow */
    public class ChangePinOperation implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce";
        }

        public final Type mo37b() {
            return Type.CHANGE_PIN;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLVerifyCurrentPinFragment dBLVerifyCurrentPinFragment = new DBLVerifyCurrentPinFragment();
            dBLVerifyCurrentPinFragment.f907b = dBLPinSettingsListener;
            if (i2 == 0) {
                i2 = 2131236266;
            }
            dBLVerifyCurrentPinFragment.m937h(i2);
            if (i == 0) {
                i = 2131236250;
            }
            dBLVerifyCurrentPinFragment.m936g(i);
            return dBLVerifyCurrentPinFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m907b(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class ChangePinUsingPassword implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce_using_password";
        }

        public final Type mo37b() {
            return Type.CHANGE_PIN_USING_PASSWORD;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLPasswordVerificationFragment dBLPasswordVerificationFragment = new DBLPasswordVerificationFragment();
            dBLPasswordVerificationFragment.f883b = dBLPinSettingsListener;
            if (i == 0) {
                i = 2131236250;
            }
            dBLPasswordVerificationFragment.m868g(i);
            if (i2 == 0) {
                i2 = 2131236245;
            }
            dBLPasswordVerificationFragment.m869h(i2);
            return dBLPasswordVerificationFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m906a(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class RemovePinOperation implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce";
        }

        public final Type mo37b() {
            return Type.REMOVE_PIN;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLVerifyCurrentPinFragment dBLVerifyCurrentPinFragment = new DBLVerifyCurrentPinFragment();
            dBLVerifyCurrentPinFragment.f907b = dBLPinSettingsListener;
            if (i == 0) {
                i = 2131236252;
            }
            dBLVerifyCurrentPinFragment.m936g(i);
            if (i2 == 0) {
                i2 = 2131236242;
            }
            dBLVerifyCurrentPinFragment.m937h(i2);
            return dBLVerifyCurrentPinFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m907b(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class RemovePinUsingPassword implements DBLPinOperation {
        public final String mo36a() {
            return "change_nonce_using_password";
        }

        public final Type mo37b() {
            return Type.REMOVE_PIN_USING_PASSWORD;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLPasswordVerificationFragment dBLPasswordVerificationFragment = new DBLPasswordVerificationFragment();
            dBLPasswordVerificationFragment.f883b = dBLPinSettingsListener;
            if (i == 0) {
                i = 2131236252;
            }
            dBLPasswordVerificationFragment.m868g(i);
            if (i2 == 0) {
                i2 = 2131236245;
            }
            dBLPasswordVerificationFragment.m869h(i2);
            return dBLPasswordVerificationFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return DBLPinOperationTypes.m906a(str, str2, dBLFacebookCredentials);
        }
    }

    /* compiled from: upload_flow */
    public class SwitchToDBL implements DBLPinOperation {
        public final String mo36a() {
            return "logged_out_set_nonce";
        }

        public final Type mo37b() {
            return Type.SWITCH_TO_DBL;
        }

        public final Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2) {
            DBLPasswordVerificationFragment dBLPasswordVerificationFragment = new DBLPasswordVerificationFragment();
            dBLPasswordVerificationFragment.f883b = dBLPinSettingsListener;
            if (i2 == 0) {
                i2 = 2131236262;
            }
            dBLPasswordVerificationFragment.m869h(i2);
            if (i == 0) {
                i = 2131236255;
            }
            dBLPasswordVerificationFragment.m868g(i);
            return dBLPasswordVerificationFragment;
        }

        public final Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
            return null;
        }
    }

    /* compiled from: upload_flow */
    public enum Type {
        CHANGE_PIN,
        ADD_PIN,
        REMOVE_PIN,
        CHANGE_PIN_USING_PASSWORD,
        REMOVE_PIN_USING_PASSWORD,
        CHANGE_PASSCODE_AFTER_INCORRECT_PASSCODE,
        CHANGE_PASSCODE_FROM_LOGIN_FLOW,
        SWITCH_TO_DBL
    }

    static Bundle m906a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
        Bundle bundle = new Bundle();
        bundle.putString("account_id", dBLFacebookCredentials.mUserId);
        bundle.putString("password", str);
        bundle.putString("new_pin", str2);
        return bundle;
    }

    static Bundle m907b(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials) {
        Bundle bundle = new Bundle();
        bundle.putString("account_id", dBLFacebookCredentials.mUserId);
        bundle.putString("nonce", dBLFacebookCredentials.mNonce);
        bundle.putString("old_pin", str);
        bundle.putString("new_pin", str2);
        return bundle;
    }
}

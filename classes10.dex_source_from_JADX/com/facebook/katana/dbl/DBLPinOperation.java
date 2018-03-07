package com.facebook.katana.dbl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.katana.dbl.DBLPinOperationTypes.Type;

/* compiled from: upload_group_docs_or_files */
public interface DBLPinOperation {
    Bundle mo34a(String str, String str2, DBLFacebookCredentials dBLFacebookCredentials);

    Fragment mo35a(DBLPinSettingsListener dBLPinSettingsListener, int i, int i2);

    String mo36a();

    Type mo37b();
}

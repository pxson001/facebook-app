package com.facebook.groups.fb4a.create;

import android.os.Bundle;
import com.facebook.fbreact.fragment.ReactActivity;

/* compiled from: payments_fetch_payment_option_failed */
public class GroupsCreateReactActivity extends ReactActivity {
    protected final Bundle m7172c(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        bundle.putString("suggestionIds", extras.getString("suggestion_identifier"));
        bundle.putString("suggestionName", extras.getString("group_name"));
        return bundle;
    }
}

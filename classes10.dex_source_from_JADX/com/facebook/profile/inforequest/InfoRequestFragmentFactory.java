package com.facebook.profile.inforequest;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;

/* compiled from: localhost */
public class InfoRequestFragmentFactory implements IFragmentFactory {
    public final Fragment m8473a(Intent intent) {
        String stringExtra = intent.getStringExtra("com.facebook.katana.profile.id");
        String stringExtra2 = intent.getStringExtra("profile_name");
        GraphQLInfoRequestFieldType valueOf = GraphQLInfoRequestFieldType.valueOf(intent.getStringExtra("request_field_type"));
        ParcelUuid parcelUuid = (ParcelUuid) intent.getParcelableExtra("fragment_id");
        InfoRequestFragment infoRequestFragment = new InfoRequestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("profile_id", stringExtra);
        bundle.putString("profile_name", stringExtra2);
        bundle.putSerializable("info_request_type", valueOf);
        bundle.putParcelable("arg_parent_fragment_id", parcelUuid);
        infoRequestFragment.g(bundle);
        return infoRequestFragment;
    }
}

package com.facebook.identitygrowth.typeahead.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.typeahead.TypeaheadInteractionsEventBuilder;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import java.util.ArrayList;

/* compiled from: mContactProfileType */
public class ProfileInfoTypeaheadActivity extends FbFragmentActivity {
    public static Intent m18092a(Context context, String str, String str2, ArrayList<Bundle> arrayList, boolean z, String str3) {
        Intent intent = new Intent(context, ProfileInfoTypeaheadActivity.class);
        intent.putExtra("typeahead_title_bar_text", str);
        intent.putExtra("profile_section", str2);
        intent.putParcelableArrayListExtra("typeahead_existing_fields", arrayList);
        intent.putExtra("typeahead_use_current_city_inference", z);
        intent.putExtra("logging_surfaces", str3);
        return intent;
    }

    public final void m18093b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906441);
        FbTitleBarUtil.m8799b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setHasFbLogo(true);
        String stringExtra = getIntent().getStringExtra("typeahead_title_bar_text");
        if (stringExtra != null) {
            fbTitleBar.setTitle(stringExtra);
        }
        if (((ProfileInfoTypeaheadFragment) kO_().a(2131558429)) == null) {
            ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment = new ProfileInfoTypeaheadFragment();
            stringExtra = getIntent().getStringExtra("profile_section");
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("typeahead_existing_fields");
            boolean booleanExtra = getIntent().getBooleanExtra("typeahead_use_current_city_inference", false);
            String stringExtra2 = getIntent().getStringExtra("logging_surfaces");
            Bundle bundle2 = new Bundle();
            bundle2.putString("profile_section", stringExtra);
            bundle2.putParcelableArrayList("typeahead_existing_fields", parcelableArrayListExtra);
            bundle2.putBoolean("typeahead_use_current_city_inference", booleanExtra);
            bundle2.putString("logging_surfaces", stringExtra2);
            profileInfoTypeaheadFragment.g(bundle2);
            kO_().a().a(2131558429, profileInfoTypeaheadFragment).b();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment = (ProfileInfoTypeaheadFragment) kO_().a(2131558429);
        if (profileInfoTypeaheadFragment != null) {
            profileInfoTypeaheadFragment.al.a(new TypeaheadInteractionsEventBuilder("profile_question_tapped_cancel", "profile_experience_picker").m11075h(profileInfoTypeaheadFragment.aq).m11065a(profileInfoTypeaheadFragment.f11212f.m18096a()).m11070c(profileInfoTypeaheadFragment.f11209c.getText().toString()).m11071d(String.valueOf(profileInfoTypeaheadFragment.ar)).f7751a);
        }
    }
}

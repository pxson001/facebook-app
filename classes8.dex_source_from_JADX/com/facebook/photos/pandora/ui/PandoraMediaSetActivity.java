package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.annotation.Nullable;

/* compiled from: com.facebook.nearby.ui.FractionalRatingBar */
public class PandoraMediaSetActivity extends FbFragmentActivity {
    public static String f17658p = "media_set_display_activity_selected_photo_fb_id_extra";
    public static String f17659q = "media_set_display_activity_selected_photo_uri_extra";

    /* compiled from: com.facebook.nearby.ui.FractionalRatingBar */
    class C18831 implements OnClickListener {
        final /* synthetic */ PandoraMediaSetActivity f17657a;

        C18831(PandoraMediaSetActivity pandoraMediaSetActivity) {
            this.f17657a = pandoraMediaSetActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 872262339);
            this.f17657a.setResult(0);
            this.f17657a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, -217615549, a);
        }
    }

    public static Intent m21631a(Context context, String str, String str2, String str3, CallerContext callerContext) {
        Intent intent = new Intent(context, PandoraMediaSetActivity.class);
        intent.putExtra("media_set_display_activity_profile_id_extra", str);
        intent.putExtra("media_set_display_activity_mediaset_extra", str2);
        intent.putExtra("media_set_display_activity_titlebard_label", str3);
        intent.putExtra("media_set_display_activity_titlebard_label_resource_id_extra", callerContext);
        return intent;
    }

    protected final void m21633b(@Nullable Bundle bundle) {
        super.b(bundle);
        setContentView(2130905187);
        m21632i();
        Bundle extras = getIntent().getExtras();
        FragmentTransaction a = kO_().a();
        String string = extras.getString("media_set_display_activity_profile_id_extra");
        String string2 = extras.getString("media_set_display_activity_mediaset_extra");
        CallerContext callerContext = (CallerContext) extras.get("media_set_display_activity_titlebard_label_resource_id_extra");
        PandoraMediasetFragment pandoraMediasetFragment = new PandoraMediasetFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("mediasetId", string2);
        bundle2.putParcelable("callerContext", callerContext);
        bundle2.putParcelable("pandora_instance_id", new SimplePandoraInstanceId(string, "ms"));
        pandoraMediasetFragment.g(bundle2);
        a.a(2131558429, pandoraMediasetFragment).b();
    }

    private void m21632i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(getIntent().getExtras().getString("media_set_display_activity_titlebard_label"));
        fbTitleBar.a(new C18831(this));
    }
}

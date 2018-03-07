package com.facebook.friendsharing.meme.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: SAVE */
public class MemePickerActivity extends FbFragmentActivity {
    private MemePickerFragment f23931p;

    public static Intent m26063a(@Nullable String str, Context context, ComposerConfiguration composerConfiguration, ImmutableList<String> immutableList, @Nullable PromptAnalytics promptAnalytics, @Nullable String str2) {
        return new Intent(context, MemePickerActivity.class).putExtra("extra_meme_picker_session_id", str).putExtra("extra_meme_picker_composer_config", composerConfiguration).putExtra("extra_meme_urls", immutableList).putExtra("extra_prompt_analytics", promptAnalytics).putExtra("extra_selected_meme", str2);
    }

    public final void m26064b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130905208);
        this.f23931p = (MemePickerFragment) kO_().a(MemePickerFragment.f23932a);
        if (this.f23931p == null) {
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            if (!(intent == null || intent.getExtras() == null)) {
                bundle2.putAll(intent.getExtras());
            }
            this.f23931p = new MemePickerFragment();
            this.f23931p.g(bundle2);
            kO_().a().a(2131558429, this.f23931p, MemePickerFragment.f23932a).b();
        }
    }

    public void onBackPressed() {
        MemePickerFragment memePickerFragment = this.f23931p;
        Activity ao = memePickerFragment.ao();
        Intent intent = new Intent();
        if (memePickerFragment.f23940i != null) {
            intent.putExtras(PromptPublishIntentHelper.a(memePickerFragment.f23940i, ProductionPromptObject.class, Boolean.valueOf(false)));
        }
        ao.setResult(0, intent);
        memePickerFragment.f23935d.a.a(MemePickerAnalyticsLogger.b("back_press", memePickerFragment.f23937f));
        super.onBackPressed();
    }
}

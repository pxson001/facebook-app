package com.facebook.feedplugins.prompts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SKIP */
public class SocialPromptFeedEntryPointPartDefinition$2 implements OnClickListener {
    final /* synthetic */ Context f23776a;
    final /* synthetic */ String f23777b;
    final /* synthetic */ SocialPromptFeedEntryPointPartDefinition f23778c;

    public SocialPromptFeedEntryPointPartDefinition$2(SocialPromptFeedEntryPointPartDefinition socialPromptFeedEntryPointPartDefinition, Context context, String str) {
        this.f23778c = socialPromptFeedEntryPointPartDefinition;
        this.f23776a = context;
        this.f23777b = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 288222541);
        SocialPromptFeedActionHandler socialPromptFeedActionHandler = (SocialPromptFeedActionHandler) this.f23778c.c.get();
        Context context = this.f23776a;
        String str = this.f23777b;
        Intent a2 = socialPromptFeedActionHandler.f23770c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.gg, str));
        a2.putExtra(SocialPromptConstants.f23762a, str);
        Intent intent = a2;
        if (intent != null) {
            socialPromptFeedActionHandler.f23769b.a(intent, SocialPromptConstants.f23763b, (Activity) ContextUtils.a(context, Activity.class));
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1422500938, a);
    }
}

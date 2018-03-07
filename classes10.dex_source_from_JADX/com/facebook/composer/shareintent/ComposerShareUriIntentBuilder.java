package com.facebook.composer.shareintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: conversation_starter */
public class ComposerShareUriIntentBuilder extends UriIntentBuilder {

    /* compiled from: conversation_starter */
    class C22001 implements IUriTemplateIntentBuilder {
        final /* synthetic */ ComposerShareUriIntentBuilder f15846a;

        C22001(ComposerShareUriIntentBuilder composerShareUriIntentBuilder) {
            this.f15846a = composerShareUriIntentBuilder;
        }

        public final Intent m16293a(Context context, Bundle bundle) {
            String string = bundle.getString("link_for_share");
            String string2 = bundle.getString("com.facebook.platform.extra.APPLICATION_ID");
            String string3 = bundle.getString("name");
            String string4 = bundle.getString("caption");
            String string5 = bundle.getString("description");
            String string6 = bundle.getString("picture");
            String string7 = bundle.getString("quote");
            boolean z = bundle.getBoolean("is_web_share");
            boolean z2 = bundle.getBoolean("is_in_app_web_share");
            Intent intent = new Intent(context, ImplicitShareIntentHandler.class);
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", string);
            if (!(StringUtil.a(string2) || StringUtil.a("0", string2))) {
                intent.putExtra("com.facebook.platform.extra.APPLICATION_ID", string2);
            }
            intent.putExtra("com.facebook.platform.extra.TITLE", ComposerShareUriIntentBuilder.m16297b(string3));
            intent.putExtra("com.facebook.platform.extra.SUBTITLE", ComposerShareUriIntentBuilder.m16297b(string4));
            intent.putExtra("com.facebook.platform.extra.DESCRIPTION", ComposerShareUriIntentBuilder.m16297b(string5));
            intent.putExtra("com.facebook.platform.extra.IMAGE", ComposerShareUriIntentBuilder.m16297b(string6));
            intent.putExtra("com.facebook.platform.extra.QUOTE", ComposerShareUriIntentBuilder.m16297b(string7));
            intent.putExtra("com.facebook.platform.extra.WEB_SHARE_NATIVE_TREATMENT", z);
            intent.putExtra("com.facebook.platform.extra.IN_APP_WEB_SHARE", z2);
            return intent;
        }
    }

    /* compiled from: conversation_starter */
    class C22012 implements IUriTemplateIntentBuilder {
        final /* synthetic */ ComposerShareUriIntentBuilder f15847a;

        C22012(ComposerShareUriIntentBuilder composerShareUriIntentBuilder) {
            this.f15847a = composerShareUriIntentBuilder;
        }

        public final Intent m16294a(Context context, Bundle bundle) {
            Intent intent = new Intent(context, ImplicitShareIntentHandler.class);
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", bundle.getString("link_for_share"));
            return intent;
        }
    }

    /* compiled from: conversation_starter */
    class C22023 implements IUriTemplateIntentBuilder {
        final /* synthetic */ ComposerShareUriIntentBuilder f15848a;

        C22023(ComposerShareUriIntentBuilder composerShareUriIntentBuilder) {
            this.f15848a = composerShareUriIntentBuilder;
        }

        public final Intent m16295a(Context context, Bundle bundle) {
            Intent intent = new Intent(context, ImplicitShareIntentHandler.class);
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("is_draft", true);
            intent.putExtra("story_id", bundle.getString("story_id"));
            return intent;
        }
    }

    public static ComposerShareUriIntentBuilder m16296a(InjectorLike injectorLike) {
        return new ComposerShareUriIntentBuilder();
    }

    @Inject
    public ComposerShareUriIntentBuilder() {
        a(StringFormatUtil.a(FBLinks.a("composer/?link={%s}&app_id={%s}&name={%s}&caption={%s}&description={%s}&picture={%s}&quote={%s}&%s={!%s false}&%s={!%s false}"), new Object[]{"link_for_share", "com.facebook.platform.extra.APPLICATION_ID", "name", "caption", "description", "picture", "quote", "is_web_share", "is_web_share", "is_in_app_web_share", "is_in_app_web_share"}), new C22001(this));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("composer/?link={%s}"), "link_for_share"), new C22012(this));
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("composer/draft/?story_id={%s}"), "story_id"), new C22023(this));
    }

    @Nullable
    public static String m16297b(@Nullable String str) {
        return (str == null || str.equals("null")) ? null : str;
    }
}

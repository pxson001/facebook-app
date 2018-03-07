package com.facebook.instantarticles;

import android.content.ComponentName;
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
import javax.inject.Inject;

@UriMapPattern
/* compiled from: videochannel */
public class RichDocumentUriIntentBuilder extends UriIntentBuilder {

    /* compiled from: videochannel */
    class RichDocumentIntentBuilder implements IUriTemplateIntentBuilder {
        public final Intent m586a(Context context, Bundle bundle) {
            Intent intent = new Intent();
            String string = bundle.getString("article");
            intent.putExtra("extra_instant_articles_id", string.substring(1, string.length() - 1));
            string = bundle.getString("canonical");
            if (!StringUtil.c(string)) {
                intent.putExtra("extra_instant_articles_canonical_url", string.substring(1, string.length() - 1));
            }
            string = bundle.getString("saved");
            if (!StringUtil.c(string)) {
                intent.putExtra("extra_instant_articles_saved", Boolean.valueOf(string.substring(1, string.length() - 1)));
            }
            intent.setComponent(new ComponentName(context, InstantArticlesActivity.class));
            intent.putExtra("force_external_activity", true);
            return intent;
        }
    }

    public static RichDocumentUriIntentBuilder m587a(InjectorLike injectorLike) {
        return new RichDocumentUriIntentBuilder();
    }

    @Inject
    public RichDocumentUriIntentBuilder() {
        a(StringFormatUtil.a(FBLinks.a("native_article?article={%s}&canonical={%s}&saved={%s}"), new Object[]{"article", "canonical", "saved"}), new RichDocumentIntentBuilder());
        a(StringFormatUtil.a(FBLinks.a("native_article?article={%s}&canonical={%s}"), new Object[]{"article", "canonical"}), new RichDocumentIntentBuilder());
        a(StringFormatUtil.a(FBLinks.a("native_article?article={%s}"), new Object[]{"article"}), new RichDocumentIntentBuilder());
    }
}

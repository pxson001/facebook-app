package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.nux.NuxBubbleManager.Nux;
import com.facebook.nux.interstitial.MusicPreviewNuxBubbleDelegate;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: composer_tag_expansion_pill_clicked */
public class MusicPreviewNuxManager {
    public final FeedNuxBubbleManager f8061a;
    private final MusicPreviewNuxBubbleDelegate f8062b;

    public static MusicPreviewNuxManager m9106b(InjectorLike injectorLike) {
        return new MusicPreviewNuxManager(FeedNuxBubbleManager.a(injectorLike), new MusicPreviewNuxBubbleDelegate((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InterstitialManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public MusicPreviewNuxManager(FeedNuxBubbleManager feedNuxBubbleManager, MusicPreviewNuxBubbleDelegate musicPreviewNuxBubbleDelegate) {
        this.f8061a = feedNuxBubbleManager;
        this.f8062b = musicPreviewNuxBubbleDelegate;
    }

    public final void m9107a(Context context, View view, String str) {
        String string = context.getResources().getString(2131235574);
        View view2 = view;
        this.f8061a.a(new Nux(2130905363, StringFormatUtil.a(string, new Object[]{str}), view2, this.f8062b, true, 0));
    }
}

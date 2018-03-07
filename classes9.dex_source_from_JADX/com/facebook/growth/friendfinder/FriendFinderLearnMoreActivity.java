package com.facebook.growth.friendfinder;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.common.util.TriState;
import com.facebook.contactlogs.annotation.IsContactLogsUploadEnabled;
import com.facebook.contacts.upload.annotation.IsContactsUploadBackgroundTaskEnabled;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterLinkMovementMethod;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: participants_flat_buffer */
public class FriendFinderLearnMoreActivity extends FbFragmentActivity implements IAuthNotRequired {
    @Inject
    BetterLinkMovementMethod f7255p;
    @Inject
    FbUriIntentHandler f7256q;
    @Inject
    FriendFinderAnalyticsLogger f7257r;
    @Inject
    @IsContactsUploadBackgroundTaskEnabled
    Provider<TriState> f7258s;
    @Inject
    @IsContactLogsUploadEnabled
    Provider<TriState> f7259t;
    @Inject
    @LoggedInUserId
    Provider<String> f7260u;
    public boolean f7261v;
    public boolean f7262w;

    /* compiled from: participants_flat_buffer */
    class C07881 implements OnClickListener {
        final /* synthetic */ FriendFinderLearnMoreActivity f7253a;

        C07881(FriendFinderLearnMoreActivity friendFinderLearnMoreActivity) {
            this.f7253a = friendFinderLearnMoreActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1090767458);
            this.f7253a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 861557922, a);
        }
    }

    /* compiled from: participants_flat_buffer */
    class FriendFinderLearnMoreClickableSpan extends ClickableSpan {
        final /* synthetic */ FriendFinderLearnMoreActivity f7254a;

        public FriendFinderLearnMoreClickableSpan(FriendFinderLearnMoreActivity friendFinderLearnMoreActivity) {
            this.f7254a = friendFinderLearnMoreActivity;
        }

        public void onClick(View view) {
            this.f7254a.f7257r.c();
            Bundle bundle = new Bundle();
            bundle.putBoolean("titlebar_with_modal_done", true);
            this.f7254a.f7256q.a(this.f7254a, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "/invite/history"), bundle);
        }

        public void updateDrawState(TextPaint textPaint) {
            if (this.f7254a.f7261v || this.f7254a.f7262w) {
                TypedArray obtainStyledAttributes = this.f7254a.obtainStyledAttributes(new int[]{16842907});
                textPaint.setColor(obtainStyledAttributes.getColor(0, textPaint.linkColor));
                obtainStyledAttributes.recycle();
                textPaint.setUnderlineText(false);
                return;
            }
            super.updateDrawState(textPaint);
        }
    }

    private static <T extends Context> void m7538a(Class<T> cls, T t) {
        m7539a((Object) t, (Context) t);
    }

    public static void m7539a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendFinderLearnMoreActivity) obj).m7537a(BetterLinkMovementMethod.a(fbInjector), FbUriIntentHandler.a(fbInjector), FriendFinderAnalyticsLogger.a(fbInjector), IdBasedProvider.a(fbInjector, 659), IdBasedProvider.a(fbInjector, 654), IdBasedProvider.a(fbInjector, 4442));
    }

    private void m7537a(BetterLinkMovementMethod betterLinkMovementMethod, FbUriIntentHandler fbUriIntentHandler, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, Provider<TriState> provider, Provider<TriState> provider2, Provider<String> provider3) {
        this.f7255p = betterLinkMovementMethod;
        this.f7256q = fbUriIntentHandler;
        this.f7257r = friendFinderAnalyticsLogger;
        this.f7258s = provider;
        this.f7259t = provider2;
        this.f7260u = provider3;
    }

    protected final void m7543b(Bundle bundle) {
        super.b(bundle);
        Class cls = FriendFinderLearnMoreActivity.class;
        m7539a((Object) this, (Context) this);
        this.f7261v = ((TriState) this.f7258s.get()).asBoolean(false);
        this.f7262w = ((TriState) this.f7259t.get()).asBoolean(false);
        overridePendingTransition(2130968649, 2130968714);
        setContentView(2130904475);
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(2131233242);
        fbTitleBar.a(new C07881(this));
        TextView textView = (TextView) a(2131562257);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        styledStringBuilder.a(m7542i());
        if (StringUtil.a((CharSequence) this.f7260u.get())) {
            styledStringBuilder.a("{MANAGE_OR_DELETE_TOKEN}", getString(2131236402));
        } else {
            styledStringBuilder.a("{MANAGE_OR_DELETE_TOKEN}", getString(2131236402), new FriendFinderLearnMoreClickableSpan(this), 33);
            textView.setMovementMethod(this.f7255p);
        }
        textView.setText(styledStringBuilder.b());
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968711, 2130968695);
    }

    private String m7542i() {
        int i;
        if (this.f7261v || this.f7262w || StringUtil.a((CharSequence) this.f7260u.get())) {
            i = 2131236421;
            if (!this.f7262w) {
                i = 2131236422;
            }
        } else {
            i = 2131236420;
        }
        return StringFormatUtil.formatStrLocaleSafe(getString(i), "{MANAGE_OR_DELETE_TOKEN}");
    }
}

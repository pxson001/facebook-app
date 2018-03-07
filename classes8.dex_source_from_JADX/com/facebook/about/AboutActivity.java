package com.facebook.about;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.logger.AnalyticsEventNames.ContentFragmentType;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.auth.module.TriState_IsMeUserAnEmployeeMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.manifest.AppBuildInfo;
import com.facebook.common.manifest.AppBuildInfoMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.titlebar.GraphSearchTitleBarController;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: location_latlong */
public class AboutActivity extends FbFragmentActivity {
    @Inject
    Lazy<GraphSearchTitleBarController> f10198p;
    @Inject
    AppVersionInfo f10199q;
    @Inject
    AppBuildInfo f10200r;
    @Inject
    SecureContextHelper f10201s;
    @Inject
    @IsMeUserAnEmployee
    TriState f10202t;
    @Inject
    Product f10203u;
    @Inject
    UriIntentMapper f10204v;
    private FbTitleBar f10205w;
    private String f10206x;

    /* compiled from: location_latlong */
    class C10581 implements OnClickListener {
        final /* synthetic */ AboutActivity f10193a;

        C10581(AboutActivity aboutActivity) {
            this.f10193a = aboutActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 262482598);
            this.f10193a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 135626000, a);
        }
    }

    /* compiled from: location_latlong */
    class C10592 extends OnToolbarButtonListener {
        final /* synthetic */ AboutActivity f10194a;

        C10592(AboutActivity aboutActivity) {
            this.f10194a = aboutActivity;
        }

        public final void m11977a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ((GraphSearchTitleBarController) this.f10194a.f10198p.get()).a(null, ContentFragmentType.MAINTAB);
        }
    }

    /* compiled from: location_latlong */
    class WhiteClickableSpan extends ClickableSpan {
        final /* synthetic */ AboutActivity f10195a;
        private String f10196b;

        public WhiteClickableSpan(AboutActivity aboutActivity, String str) {
            this.f10195a = aboutActivity;
            this.f10196b = str;
        }

        public void onClick(View view) {
            this.f10195a.m11978a((Context) this.f10195a, this.f10196b);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            if (this.f10195a != null) {
                textPaint.setColor(this.f10195a.getResources().getColor(2131361920));
            }
        }
    }

    /* compiled from: location_latlong */
    class WhiteForegroundSpan extends ForegroundColorSpan {
        final /* synthetic */ AboutActivity f10197a;

        public WhiteForegroundSpan(AboutActivity aboutActivity) {
            this.f10197a = aboutActivity;
            super(aboutActivity.getResources().getColor(2131361920));
        }
    }

    private static <T extends Context> void m11981a(Class<T> cls, T t) {
        m11982a((Object) t, (Context) t);
    }

    public static void m11982a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AboutActivity) obj).m11980a(IdBasedLazy.a(fbInjector, 10889), AppVersionInfoMethodAutoProvider.a(fbInjector), AppBuildInfoMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TriState_IsMeUserAnEmployeeMethodAutoProvider.b(fbInjector), ProductMethodAutoProvider.b(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector));
    }

    public final void m11990b(Bundle bundle) {
        super.b(bundle);
        Class cls = AboutActivity.class;
        m11982a((Object) this, (Context) this);
        setContentView(2130903063);
        m11985k();
        m11983i();
        m11986l();
        m11984j();
    }

    private void m11983i() {
        FbTitleBarUtil.b(this);
        this.f10205w = (FbTitleBar) a(2131558563);
        if (this.f10203u != Product.PAA) {
            this.f10205w.a(new C10581(this));
            Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = getResources().getString(2131237616);
            a = a;
            a.i = 2130838000;
            this.f10205w.setButtonSpecs(ImmutableList.of(a.a()));
            this.f10205w.setOnToolbarButtonListener(new C10592(this));
        }
        this.f10205w.setTitle(getResources().getString(2131237617));
    }

    private void m11984j() {
        m11989o();
        m11988n();
        m11987m();
    }

    private void m11985k() {
        this.f10206x = getResources().getString(2131237612);
        if (BuildConstants.j) {
            this.f10206x = getResources().getString(2131237613);
        }
        if (this.f10203u == Product.PAA) {
            this.f10206x = getResources().getString(2131237614);
        }
    }

    private void m11986l() {
        TextView textView = (TextView) findViewById(2131559145);
        TextView textView2 = (TextView) findViewById(2131559146);
        ((TextView) findViewById(2131559144)).setText(this.f10206x);
        if (BuildConstants.i || TriState.YES.equals(this.f10202t)) {
            textView.setText(this.f10199q.a() + "/" + String.valueOf(this.f10199q.b()));
            CharSequence charSequence = this.f10200r.a;
            if (StringLengthHelper.a(charSequence) > 0) {
                textView2.setVisibility(0);
                textView2.setText(charSequence);
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        textView.setText(this.f10199q.a());
        textView2.setVisibility(8);
    }

    private void m11978a(Context context, String str) {
        this.f10201s.a(this.f10204v.a(context, FBLinks.cr.concat(str)), context);
    }

    private void m11987m() {
        Object string = getResources().getString(2131237623);
        TextView textView = (TextView) findViewById(2131559149);
        CharSequence spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new WhiteClickableSpan(this, "/terms.php"), 0, StringLengthHelper.a(string), 33);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m11988n() {
        int i = 0;
        TextView textView = (TextView) findViewById(2131559148);
        String string = getResources().getString(2131237621);
        String string2 = getResources().getString(2131237622, new Object[]{this.f10206x, string});
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        while (i != -1 && i2 < StringLengthHelper.a(string2)) {
            i = string2.indexOf(string, i2);
            if (i != -1) {
                spannableStringBuilder.append(string2.substring(i2, i));
                spannableStringBuilder.append(string);
                spannableStringBuilder.setSpan(new WhiteClickableSpan(this, "/legal/thirdpartynotices"), i, StringLengthHelper.a(string) + i, 33);
                i2 = StringLengthHelper.a(string) + i;
            }
        }
        if (i2 < StringLengthHelper.a(string2)) {
            spannableStringBuilder.append(string2.substring(i2));
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m11989o() {
        int i = 0;
        TextView textView = (TextView) findViewById(2131559147);
        String string = getResources().getString(2131237618);
        String string2 = getResources().getString(2131237619);
        String string3 = getResources().getString(2131237620, new Object[]{string, string2});
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!(i2 == -1 && r1 == -1) && i3 < StringLengthHelper.a(string3)) {
                i2 = string3.indexOf(string2, i3);
                i = string3.indexOf(string, i3);
                if ((i2 <= i || i == -1) && i2 != -1) {
                    spannableStringBuilder.append(string3.substring(i3, i2));
                    spannableStringBuilder.append(string2);
                    spannableStringBuilder.setSpan(new WhiteForegroundSpan(this), i2, StringLengthHelper.a(string2) + i2, 33);
                    i3 = StringLengthHelper.a(string2) + i2;
                } else if (i != -1) {
                    spannableStringBuilder.append(string3.substring(i3, i));
                    spannableStringBuilder.append(string);
                    spannableStringBuilder.setSpan(new WhiteForegroundSpan(this), i, StringLengthHelper.a(string) + i, 33);
                    i3 = StringLengthHelper.a(string) + i;
                }
            }
        }
        if (i3 < StringLengthHelper.a(string3)) {
            spannableStringBuilder.append(string3.substring(i3));
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m11980a(Lazy<GraphSearchTitleBarController> lazy, AppVersionInfo appVersionInfo, AppBuildInfo appBuildInfo, SecureContextHelper secureContextHelper, TriState triState, Product product, UriIntentMapper uriIntentMapper) {
        this.f10198p = lazy;
        this.f10199q = appVersionInfo;
        this.f10200r = appBuildInfo;
        this.f10201s = secureContextHelper;
        this.f10202t = triState;
        this.f10203u = product;
        this.f10204v = uriIntentMapper;
    }
}

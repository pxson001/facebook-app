package com.facebook.groups.editsettings.util;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLGroupCategory;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel;
import com.facebook.groups.editsettings.protocol.FetchGroupSettingsModels.FetchGroupSettingsModel.PossibleVisibilitySettingsModel.EdgesModel;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Unable to encrypt notification */
public class GroupPrivacyDescriptionUtil {
    private Resources f21763a;
    public SecureContextHelper f21764b;
    public UriIntentMapper f21765c;
    private Locales f21766d;
    private MonotonicClock f21767e;
    public Product f21768f;

    /* compiled from: Unable to encrypt notification */
    class C31041 extends ClickableSpan {
        final /* synthetic */ GroupPrivacyDescriptionUtil f21762a;

        C31041(GroupPrivacyDescriptionUtil groupPrivacyDescriptionUtil) {
            this.f21762a = groupPrivacyDescriptionUtil;
        }

        public void onClick(View view) {
            String str;
            if (this.f21762a.f21768f == Product.GROUPS) {
                str = "https://m.facebook.com/help/groups-app/565766570190970";
            } else {
                str = "https://m.facebook.com/help/286027304749263";
            }
            this.f21762a.f21764b.a(this.f21762a.f21765c.a(view.getContext(), str), view.getContext());
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public static GroupPrivacyDescriptionUtil m22873b(InjectorLike injectorLike) {
        return new GroupPrivacyDescriptionUtil(ResourcesMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), Locales.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public GroupPrivacyDescriptionUtil(Resources resources, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, Locales locales, MonotonicClock monotonicClock, Product product) {
        this.f21763a = resources;
        this.f21764b = secureContextHelper;
        this.f21765c = uriIntentMapper;
        this.f21766d = locales;
        this.f21767e = monotonicClock;
        this.f21768f = product;
    }

    public final String m22877a(FetchGroupSettingsModel fetchGroupSettingsModel, GraphQLGroupVisibility graphQLGroupVisibility) {
        if (!(fetchGroupSettingsModel == null || fetchGroupSettingsModel.m22813x() == null || fetchGroupSettingsModel.m22813x().m22782a() == null)) {
            ImmutableList a = fetchGroupSettingsModel.m22813x().m22782a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel != null && edgesModel.m22777j() != null && edgesModel.m22778k() == graphQLGroupVisibility) {
                    return edgesModel.m22777j().toLowerCase(this.f21766d.a());
                }
            }
        }
        return null;
    }

    public final SpannableString m22875a(String str) {
        return m22876a(str, new C31041(this));
    }

    public final SpannableString m22876a(String str, ClickableSpan clickableSpan) {
        String str2 = str + " ";
        String str3 = str2 + this.f21763a.getString(2131242169);
        int a = StringLengthHelper.a(str2);
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(clickableSpan, a, StringLengthHelper.a(str3), 33);
        spannableString.setSpan(new ForegroundColorSpan(this.f21763a.getColor(2131363506)), a, StringLengthHelper.a(str3), 33);
        return spannableString;
    }

    public final boolean m22878a(FetchGroupSettingsModel fetchGroupSettingsModel) {
        if (fetchGroupSettingsModel == null || fetchGroupSettingsModel.m22803n() * 1000 <= this.f21767e.now()) {
            return false;
        }
        return true;
    }

    public static boolean m22874b(FetchGroupSettingsModel fetchGroupSettingsModel) {
        if (fetchGroupSettingsModel == null || fetchGroupSettingsModel.m22810u() == null || fetchGroupSettingsModel.m22810u().m22743j() != GraphQLGroupCategory.COMPANY) {
            return false;
        }
        return true;
    }
}

package com.facebook.feedplugins.pyml;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import javax.inject.Inject;

/* compiled from: onInfo MEDIA_INFO_METADATA_UPDATE */
public class EgoUnitUtil {
    private final LinkifyUtil f6180a;

    public static EgoUnitUtil m6652b(InjectorLike injectorLike) {
        return new EgoUnitUtil(LinkifyUtil.a(injectorLike));
    }

    @Inject
    public EgoUnitUtil(LinkifyUtil linkifyUtil) {
        this.f6180a = linkifyUtil;
    }

    public static String m6651a(Context context, SuggestedPageUnitItem suggestedPageUnitItem) {
        int c = GraphQLHelper.c(suggestedPageUnitItem.mo548m());
        if (c > 0) {
            return ResourceUtils.a(context.getResources(), 2131233554, 2131233555, c);
        }
        return null;
    }

    public final CharSequence m6655a(ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
        CharSequence b = m6656b(scrollableItemListFeedUnit, suggestedPageUnitItem);
        if (b != null) {
            return b;
        }
        GraphQLTextWithEntities w = suggestedPageUnitItem.mo554w();
        if (w != null) {
            return w.a();
        }
        return null;
    }

    public final Spannable m6656b(ScrollableItemListFeedUnit scrollableItemListFeedUnit, SuggestedPageUnitItem suggestedPageUnitItem) {
        if (suggestedPageUnitItem == null) {
            return null;
        }
        GraphQLTextWithEntities z = suggestedPageUnitItem.mo555z();
        if (z == null || z.a() == null) {
            return null;
        }
        Spannable valueOf = SpannableString.valueOf(z.a());
        this.f6180a.a(LinkifyUtilConverter.c(z), FlyoutClickSource.SUBTITLE, valueOf, GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit));
        this.f6180a.a(LinkifyUtilConverter.d(z), valueOf, GraphQLHelper.a(suggestedPageUnitItem, scrollableItemListFeedUnit));
        return valueOf;
    }

    public static CharSequence m6650a(SuggestedPageUnitItem suggestedPageUnitItem) {
        String n = suggestedPageUnitItem.mo549n();
        return n != null ? n.replaceAll("\\n", "") : null;
    }

    public static CharSequence m6649a(Context context, Spannable spannable, SuggestedPageUnitItem suggestedPageUnitItem) {
        String str;
        if (suggestedPageUnitItem.mo548m().F() == null || suggestedPageUnitItem.mo548m().F().isEmpty()) {
            str = null;
        } else {
            str = TextUtils.join("/", suggestedPageUnitItem.mo548m().F());
        }
        String str2 = str;
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (spannable != null) {
            spannableStringBuilder.append(spannable);
            spannableStringBuilder.setSpan(new TextAppearanceSpan(context, 2131625275), 0, spannable.length(), 17);
        }
        if (str2 != null) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(str2);
        }
        return spannableStringBuilder.length() > 0 ? spannableStringBuilder : null;
    }

    public static String m6654b(Context context, SuggestedPageUnitItem suggestedPageUnitItem) {
        GraphQLSponsoredData A = suggestedPageUnitItem.mo546A();
        if (A == null) {
            return null;
        }
        String string = A == null ? null : !A.n() ? "" : A.b() ? context.getString(2131233387) : context.getString(2131233386);
        return string;
    }

    public static GraphQLImage m6653b(SuggestedPageUnitItem suggestedPageUnitItem) {
        if (suggestedPageUnitItem == null || suggestedPageUnitItem.mo548m() == null || !GraphQLHelper.d(suggestedPageUnitItem.mo548m())) {
            return null;
        }
        return suggestedPageUnitItem.mo548m().bs();
    }
}

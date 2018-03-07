package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.pages.common.messaging.ui.TagItemViewHolder;
import com.facebook.pages.common.messaging.ui.TagItemViewHolderProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.user.model.UserCustomTag;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.FlowLayout;
import com.facebook.widget.ViewStubHolder;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: search_latitude */
public class PageMessageBlockComponentView extends CustomLinearLayout {
    private static final CallerContext f2178i = CallerContext.a(PageMessageBlockComponentView.class, "page_reaction_fragment");
    private static final Pattern f2179j = Pattern.compile("\\n+");
    @Inject
    public TagItemViewHolderProvider f2180a;
    @Inject
    public EmojiUtil f2181b;
    @Inject
    public MessagingDateUtil f2182c;
    private final FbTextView f2183d = ((FbTextView) a(2131563877));
    private final FbDraweeView f2184e = ((FbDraweeView) a(2131564465));
    private final FbTextView f2185f = ((FbTextView) a(2131565205));
    private final FbTextView f2186g = ((FbTextView) a(2131565204));
    private final ViewStubHolder<FlowLayout> f2187h = ViewStubHolder.a((ViewStubCompat) a(2131565624));

    public static void m3172a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageMessageBlockComponentView pageMessageBlockComponentView = (PageMessageBlockComponentView) obj;
        TagItemViewHolderProvider tagItemViewHolderProvider = (TagItemViewHolderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TagItemViewHolderProvider.class);
        EmojiUtil a = EmojiUtil.a(fbInjector);
        MessagingDateUtil a2 = MessagingDateUtil.a(fbInjector);
        pageMessageBlockComponentView.f2180a = tagItemViewHolderProvider;
        pageMessageBlockComponentView.f2181b = a;
        pageMessageBlockComponentView.f2182c = a2;
    }

    public PageMessageBlockComponentView(Context context) {
        super(context);
        Class cls = PageMessageBlockComponentView.class;
        m3172a(this, getContext());
        setContentView(2130906068);
        setOrientation(0);
        CustomViewUtils.b(this, ContextCompat.a(context, 2130842491));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131429798);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(2131429797);
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    public final void m3173a(String str, String str2, String str3, long j, @Nullable ImmutableList<UserCustomTag> immutableList) {
        this.f2185f.setText(m3171a(str));
        this.f2183d.setText(str2);
        this.f2184e.a(Uri.parse(str3), f2178i);
        this.f2186g.setText(this.f2182c.a(j));
        Object obj = (immutableList == null || immutableList.isEmpty()) ? 1 : null;
        if (obj != null) {
            this.f2187h.e();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f2187h.a();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                UserCustomTag userCustomTag = (UserCustomTag) immutableList.get(i);
                TagItemViewHolderProvider tagItemViewHolderProvider = this.f2180a;
                TagItemViewHolder tagItemViewHolder = new TagItemViewHolder(ResourcesMethodAutoProvider.a(tagItemViewHolderProvider), LayoutInflaterMethodAutoProvider.b(tagItemViewHolderProvider), viewGroup);
                tagItemViewHolder.m2469a(userCustomTag);
                viewGroup.addView(tagItemViewHolder.m2468a());
            }
        }
    }

    private Editable m3171a(String str) {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(getResources());
        Matcher matcher = f2179j.matcher(str);
        if (matcher.find()) {
            str = matcher.replaceAll(" ");
        }
        styledStringBuilder.a(str);
        Editable spannableStringBuilder = new SpannableStringBuilder(styledStringBuilder.b());
        this.f2181b.a(spannableStringBuilder, (int) this.f2185f.getTextSize());
        return spannableStringBuilder;
    }
}

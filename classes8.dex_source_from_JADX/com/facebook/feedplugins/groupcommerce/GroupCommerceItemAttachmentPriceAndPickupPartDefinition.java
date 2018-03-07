package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.WriteOnceInt;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.groupcommerce.GroupCommerceItemAttachmentPartDefinition.ItemStatus;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.model.GraphQLCurrencyQuantity;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.groupcommerce.util.GroupCommercePriceFormatter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fundraiser_title */
public class GroupCommerceItemAttachmentPriceAndPickupPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, BetterTextView> {
    public static final ViewType f12727a = new C13251();
    private static GroupCommerceItemAttachmentPriceAndPickupPartDefinition f12728h;
    private static final Object f12729i = new Object();
    public final Context f12730b;
    private final BackgroundPartDefinition f12731c;
    private final TextPartDefinition f12732d;
    public final GroupCommercePriceFormatter f12733e;
    public final WriteOnceInt f12734f = new WriteOnceInt();
    private final WriteOnceInt f12735g = new WriteOnceInt();

    /* compiled from: fundraiser_title */
    final class C13251 extends ViewType {
        C13251() {
        }

        public final View m14527a(Context context) {
            return new BetterTextView(context);
        }
    }

    private static GroupCommerceItemAttachmentPriceAndPickupPartDefinition m14531b(InjectorLike injectorLike) {
        return new GroupCommerceItemAttachmentPriceAndPickupPartDefinition(BackgroundPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), TextPartDefinition.a(injectorLike), GroupCommercePriceFormatter.a(injectorLike));
    }

    public final Object m14535a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLNode z = ((GraphQLStoryAttachment) feedProps.a).z();
        ItemStatus a = GroupCommerceItemAttachmentPartDefinition.m14520a(z);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        m14529a(z, a, spannableStringBuilder);
        subParts.a(this.f12732d, spannableStringBuilder);
        subParts.a(this.f12731c, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.o));
        return null;
    }

    public static GroupCommerceItemAttachmentPriceAndPickupPartDefinition m14528a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceItemAttachmentPriceAndPickupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12729i) {
                GroupCommerceItemAttachmentPriceAndPickupPartDefinition groupCommerceItemAttachmentPriceAndPickupPartDefinition;
                if (a2 != null) {
                    groupCommerceItemAttachmentPriceAndPickupPartDefinition = (GroupCommerceItemAttachmentPriceAndPickupPartDefinition) a2.a(f12729i);
                } else {
                    groupCommerceItemAttachmentPriceAndPickupPartDefinition = f12728h;
                }
                if (groupCommerceItemAttachmentPriceAndPickupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14531b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12729i, b3);
                        } else {
                            f12728h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceItemAttachmentPriceAndPickupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GroupCommerceItemAttachmentPriceAndPickupPartDefinition(BackgroundPartDefinition backgroundPartDefinition, Context context, TextPartDefinition textPartDefinition, GroupCommercePriceFormatter groupCommercePriceFormatter) {
        this.f12731c = backgroundPartDefinition;
        this.f12730b = context;
        this.f12732d = textPartDefinition;
        this.f12733e = groupCommercePriceFormatter;
    }

    public final ViewType m14534a() {
        return f12727a;
    }

    public final boolean m14536a(Object obj) {
        return true;
    }

    private void m14529a(GraphQLNode graphQLNode, ItemStatus itemStatus, SpannableStringBuilder spannableStringBuilder) {
        boolean z;
        String str;
        GroupCommercePriceFormatter groupCommercePriceFormatter = this.f12733e;
        GraphQLCurrencyQuantity ec = graphQLNode.ec();
        if (graphQLNode.fW() == GraphQLGroupCommercePriceType.NEGOTIABLE) {
            z = true;
        } else {
            z = false;
        }
        CharSequence a = groupCommercePriceFormatter.a(ec, z);
        if (!this.f12734f.a) {
            this.f12734f.a(this.f12730b.getResources().getColor(2131361919));
        }
        m14530a(a, new ForegroundColorSpan(this.f12734f.b()), spannableStringBuilder);
        GraphQLTextWithEntities fs = graphQLNode.fs();
        if (fs == null || StringUtil.a(fs.a())) {
            str = null;
        } else {
            str = fs.a();
        }
        String str2 = str;
        if (str2 != null) {
            m14532b(str2, spannableStringBuilder);
        }
    }

    private void m14532b(String str, SpannableStringBuilder spannableStringBuilder) {
        CharSequence string = this.f12730b.getResources().getString(2131237867);
        m14530a((CharSequence) " ", new ForegroundColorSpan(m14533e()), spannableStringBuilder);
        m14530a(string, new ForegroundColorSpan(m14533e()), spannableStringBuilder);
        m14530a((CharSequence) " ", new ForegroundColorSpan(m14533e()), spannableStringBuilder);
        Drawable drawable = this.f12730b.getResources().getDrawable(2130842660);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        m14530a((CharSequence) " ", (Object) new ImageSpan(drawable, 1), spannableStringBuilder);
        m14530a((CharSequence) str, new ForegroundColorSpan(m14533e()), spannableStringBuilder);
    }

    public static void m14530a(CharSequence charSequence, Object obj, SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        int length2 = charSequence.length() + length;
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, length2, 33);
    }

    private int m14533e() {
        if (!this.f12735g.a) {
            this.f12735g.a(this.f12730b.getResources().getColor(2131361974));
        }
        return this.f12735g.b();
    }
}

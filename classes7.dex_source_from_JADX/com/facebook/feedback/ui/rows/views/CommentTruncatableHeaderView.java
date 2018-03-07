package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.translation.data.CommentTranslationLoader;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: responsible_id */
public class CommentTruncatableHeaderView extends CommentHeaderBaseView {
    public static final ViewType f5203m = new C05121();
    public static final OnClickListener f5204n = new C05132();
    @Inject
    public CommentTranslationLoader f5205o;
    public final FbTextView f5206p;
    private CharSequence f5207q;
    private CharSequence f5208r;
    public boolean f5209s;

    /* compiled from: responsible_id */
    final class C05121 extends ViewType {
        C05121() {
        }

        public final View m5650a(Context context) {
            return new CommentTruncatableHeaderView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: responsible_id */
    final class C05132 implements OnClickListener {
        C05132() {
        }

        public final void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 1154591998, Logger.a(2, EntryType.UI_INPUT_START, -1261086230));
        }
    }

    /* compiled from: responsible_id */
    class C05143 implements OnClickListener {
        final /* synthetic */ CommentTruncatableHeaderView f5201a;

        C05143(CommentTruncatableHeaderView commentTruncatableHeaderView) {
            this.f5201a = commentTruncatableHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1764939994);
            if (!CommentTruncatableHeaderView.m5653j(this.f5201a)) {
                CommentTruncatableHeaderView.m5654k(this.f5201a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -716222123, a);
        }
    }

    /* compiled from: responsible_id */
    class C05154 implements OnClickListener {
        final /* synthetic */ CommentTruncatableHeaderView f5202a;

        C05154(CommentTruncatableHeaderView commentTruncatableHeaderView) {
            this.f5202a = commentTruncatableHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -642104972);
            this.f5202a.mo280h();
            Logger.a(2, EntryType.UI_INPUT_END, -1072482878, a);
        }
    }

    public static void m5652a(Object obj, Context context) {
        ((CommentTruncatableHeaderView) obj).f5205o = CommentTranslationLoader.b(FbInjector.get(context));
    }

    public CommentTruncatableHeaderView(Context context) {
        this(context, null);
    }

    private CommentTruncatableHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommentTruncatableHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentTruncatableHeaderView.class;
        m5652a((Object) this, getContext());
        setContentView(2130903638);
        setThumbnailPaddingAndBackgroundDrawable(context);
        getViews();
        this.f5167j.setOnClickListener(new C05143(this));
        this.f5206p = (FbTextView) getView(2131560459);
        this.f5206p.setOnClickListener(new C05154(this));
    }

    public void setBody(@Nullable CharSequence charSequence) {
        m5656a(charSequence, null, null, GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
    }

    public final void m5656a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable String str, GraphQLTranslatabilityType graphQLTranslatabilityType) {
        m5651a(charSequence, charSequence2);
        this.f5168k = str;
        this.f5169l = graphQLTranslatabilityType;
        boolean z = this.f5168k != null && (graphQLTranslatabilityType == GraphQLTranslatabilityType.SEE_TRANSLATION || graphQLTranslatabilityType == GraphQLTranslatabilityType.SEE_CONVERSION);
        this.f5209s = z;
        if (this.f5209s) {
            this.f5206p.setText(this.f5169l == GraphQLTranslatabilityType.SEE_CONVERSION ? getContext().getString(2131233617) : getContext().getString(2131233419));
            this.f5206p.setVisibility(0);
            return;
        }
        this.f5206p.setVisibility(8);
    }

    public final void m5655a(DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        CharSequence b = m5625b(defaultTextWithEntitiesLongFieldsModel);
        if (b != null) {
            this.f5206p.setVisibility(this.f5167j.b(b, this.f5169l) ? 8 : 0);
        }
    }

    public final void mo280h() {
        if (!this.f5167j.d()) {
            m5653j(this);
            m5654k(this);
        }
    }

    public final boolean m5658i() {
        return this.f5208r == null;
    }

    public static boolean m5653j(CommentTruncatableHeaderView commentTruncatableHeaderView) {
        if (commentTruncatableHeaderView.m5658i()) {
            return false;
        }
        commentTruncatableHeaderView.f5167j.setUntranslatedText(commentTruncatableHeaderView.f5207q);
        commentTruncatableHeaderView.f5208r = null;
        return true;
    }

    public static void m5654k(CommentTruncatableHeaderView commentTruncatableHeaderView) {
        if (commentTruncatableHeaderView.f5209s) {
            commentTruncatableHeaderView.f5205o.a(commentTruncatableHeaderView.f5168k, commentTruncatableHeaderView);
        }
    }

    private void m5651a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.f5207q = charSequence;
        this.f5208r = charSequence2;
        if (charSequence == null || TextUtils.getTrimmedLength(charSequence) == 0) {
            this.f5167j.setVisibility(8);
            return;
        }
        if (charSequence2 == null) {
            charSequence2 = charSequence;
        }
        CharSequence a = m5620a(charSequence2);
        this.f5167j.setVisibility(0);
        this.f5167j.setUntranslatedText(a);
        this.f5167j.setContentDescription(a);
        this.f5167j.c();
    }
}

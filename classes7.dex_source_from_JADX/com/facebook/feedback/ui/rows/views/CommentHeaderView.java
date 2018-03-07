package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.text.SpannableStringBuilder;
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
import com.facebook.translation.data.CommentTranslationLoader;
import javax.inject.Inject;

/* compiled from: result_size */
public class CommentHeaderView extends CommentHeaderBaseView {
    public static final ViewType f5181m = new C05101();
    @Inject
    public CommentTranslationLoader f5182n;

    /* compiled from: result_size */
    final class C05101 extends ViewType {
        C05101() {
        }

        public final View m5627a(Context context) {
            return new CommentHeaderView(new ContextThemeWrapper(context, 2131625248));
        }
    }

    /* compiled from: result_size */
    class C05112 implements OnClickListener {
        final /* synthetic */ CommentHeaderView f5180a;

        C05112(CommentHeaderView commentHeaderView) {
            this.f5180a = commentHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -40109970);
            CommentHeaderView.m5632i(this.f5180a);
            Logger.a(2, EntryType.UI_INPUT_END, 1576985010, a);
        }
    }

    private static <T extends View> void m5630a(Class<T> cls, T t) {
        m5631a((Object) t, t.getContext());
    }

    private static void m5631a(Object obj, Context context) {
        ((CommentHeaderView) obj).f5182n = CommentTranslationLoader.b(FbInjector.get(context));
    }

    public CommentHeaderView(Context context) {
        this(context, null);
    }

    public CommentHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5630a(CommentHeaderView.class, (View) this);
        setContentView(2130903625);
        setThumbnailPaddingAndBackgroundDrawable(context);
        getViews();
        this.f5167j.setOnClickListener(new C05112(this));
    }

    public void setBody(CharSequence charSequence) {
        this.k = null;
        this.l = GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        if (charSequence == null || TextUtils.getTrimmedLength(charSequence) == 0) {
            this.f5167j.setVisibility(8);
            return;
        }
        this.f5167j.setVisibility(0);
        CharSequence a = m5620a(charSequence);
        this.f5167j.setUntranslatedText(a);
        this.f5167j.c();
        this.f5167j.setContentDescription(a);
    }

    private void m5629a(CommentTranslationLoader commentTranslationLoader) {
        this.f5182n = commentTranslationLoader;
    }

    public final void m5634a(CharSequence charSequence, String str, GraphQLTranslatabilityType graphQLTranslatabilityType) {
        setBody(this.f5165h.a(new SpannableStringBuilder(charSequence), graphQLTranslatabilityType));
        this.k = str;
        this.l = graphQLTranslatabilityType;
    }

    public final void m5633a(DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        CharSequence b = m5625b(defaultTextWithEntitiesLongFieldsModel);
        if (b != null) {
            this.f5167j.b(b, this.f5169l);
        }
    }

    public final void mo280h() {
        if (!this.f5167j.d()) {
            m5632i(this);
        }
    }

    public static void m5632i(CommentHeaderView commentHeaderView) {
        if (commentHeaderView.f5168k != null) {
            commentHeaderView.f5182n.a(commentHeaderView.f5168k, commentHeaderView);
        }
    }
}

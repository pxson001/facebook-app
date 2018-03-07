package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLPostTranslatability;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.translation.TranslationMenuHelper;
import com.facebook.translation.TranslationPreferencesModifier;
import com.facebook.translation.TranslationRatingView;
import com.facebook.ufiservices.util.SeeTranslationSpan;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: download */
public class TranslationView extends CustomLinearLayout {
    @Inject
    public FbUriIntentHandler f13697a;
    public ContentTextView f13698b = ((ContentTextView) a(2131568096));
    public ProgressBar f13699c = ((ProgressBar) a(2131559418));
    public View f13700d;
    private ContentTextView f13701e;
    public ContentTextView f13702f;
    public Context f13703g;
    private ViewStub f13704h = ((ViewStub) a(2131568097));
    public TranslationRatingView f13705i;
    public String f13706j = getResources().getString(2131233616);
    public String f13707k = getResources().getString(2131233617);

    /* compiled from: download */
    class C06431 implements OnClickListener {
        final /* synthetic */ TranslationView f13708a;

        C06431(TranslationView translationView) {
            this.f13708a = translationView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1342968345);
            this.f13708a.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, 1466924268, a);
        }
    }

    public static void m14460a(Object obj, Context context) {
        ((TranslationView) obj).f13697a = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public TranslationView(Context context) {
        super(context);
        Class cls = TranslationView.class;
        m14460a((Object) this, getContext());
        this.f13703g = context;
        setContentView(2130907535);
        this.f13698b.setOnClickListener(new C06431(this));
    }

    public final void m14462a(GraphQLTranslatabilityType graphQLTranslatabilityType) {
        this.f13698b.setText(m14459a(graphQLTranslatabilityType, this.f13703g, this.f13707k, this.f13706j));
        this.f13698b.setVisibility(0);
        this.f13699c.setVisibility(8);
        if (this.f13700d != null) {
            this.f13700d.setVisibility(8);
        }
    }

    public final void m14464a(CharSequence charSequence, CharSequence charSequence2) {
        m14461b(charSequence, charSequence2);
        this.f13702f.setOnClickListener(null);
    }

    public final void m14463a(CharSequence charSequence, GraphQLPostTranslatability graphQLPostTranslatability, TranslationPreferencesModifier translationPreferencesModifier, CharSequence charSequence2) {
        m14461b(charSequence, charSequence2);
        TranslationMenuHelper translationMenuHelper = new TranslationMenuHelper(graphQLPostTranslatability, this.f13703g, translationPreferencesModifier, Boolean.valueOf(false), this.f13697a);
        this.f13705i = translationMenuHelper.b;
        this.f13702f.setOnClickListener(new 2(this, translationMenuHelper));
    }

    private void m14461b(CharSequence charSequence, CharSequence charSequence2) {
        if (this.f13700d == null) {
            this.f13700d = this.f13704h.inflate();
            this.f13701e = (ContentTextView) a(2131559755);
        } else {
            this.f13700d.setVisibility(0);
        }
        if (this.f13702f == null) {
            this.f13702f = (ContentTextView) a(2131559756);
        }
        this.f13702f.setText(charSequence2);
        this.f13698b.setVisibility(8);
        this.f13699c.setVisibility(8);
        this.f13701e.setText(charSequence);
        this.f13701e.setVisibility(0);
    }

    public float getTextSize() {
        if (this.f13700d == null) {
            this.f13700d = this.f13704h.inflate();
            this.f13701e = (ContentTextView) a(2131559755);
        }
        return this.f13701e.getTextSize();
    }

    public void setMenuButtonActive(boolean z) {
        this.f13702f.setVisibility(z ? 0 : 8);
    }

    public static Spannable m14459a(GraphQLTranslatabilityType graphQLTranslatabilityType, Context context, String str, String str2) {
        SeeTranslationSpan seeTranslationSpan = new SeeTranslationSpan(context);
        if (graphQLTranslatabilityType != GraphQLTranslatabilityType.SEE_CONVERSION) {
            str = str2;
        }
        Spannable valueOf = SpannableString.valueOf(str);
        valueOf.setSpan(seeTranslationSpan, 0, str.length(), 33);
        return valueOf;
    }

    public ContentTextView getTranslatedTextView() {
        return this.f13701e;
    }
}

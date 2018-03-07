package com.facebook.translation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.api.graphql.translations.FetchTranslationPreferencesGraphQL.NeverTranslateLanguageCoreMutationString;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.NeverTranslateLanguageInputData;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLPostTranslatability;
import com.facebook.graphql.query.GraphQlQueryString;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: data8 */
public class TranslationMenuHelper {
    public Context f17928a;
    public TranslationRatingView f17929b = new TranslationRatingView(this.f17928a);
    public GraphQLPostTranslatability f17930c;
    public Resources f17931d;
    public TranslationPreferencesModifier f17932e;
    public SeeOriginalListener f17933f;
    public Boolean f17934g;
    public Boolean f17935h;
    public FbUriIntentHandler f17936i;

    /* compiled from: data8 */
    public class C12921 implements OnMenuItemClickListener {
        final /* synthetic */ TranslationMenuHelper f17923a;

        public C12921(TranslationMenuHelper translationMenuHelper) {
            this.f17923a = translationMenuHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            TranslationMenuHelper translationMenuHelper = this.f17923a;
            OnClickListener c12954 = new C12954(translationMenuHelper);
            Builder a = new Builder(translationMenuHelper.f17928a).a(2131233187, c12954).b(2131233188, new C12965(translationMenuHelper)).a(true);
            TranslationMenuHelper translationMenuHelper2 = this.f17923a;
            a.b(StringFormatUtil.formatStrLocaleSafe(translationMenuHelper2.f17931d.getString(2131233189), translationMenuHelper2.f17930c.k()));
            a.b();
            return true;
        }
    }

    /* compiled from: data8 */
    public class C12932 implements OnMenuItemClickListener {
        final /* synthetic */ TranslationMenuHelper f17924a;

        public C12932(TranslationMenuHelper translationMenuHelper) {
            this.f17924a = translationMenuHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f17924a.f17936i.a(this.f17924a.f17928a, "https://m.facebook.com/settings/language/");
            return true;
        }
    }

    /* compiled from: data8 */
    public class C12943 implements OnMenuItemClickListener {
        final /* synthetic */ TranslationMenuHelper f17925a;

        public C12943(TranslationMenuHelper translationMenuHelper) {
            this.f17925a = translationMenuHelper;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            boolean z;
            boolean z2 = false;
            if (this.f17925a.f17934g.booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            SeeOriginalListener seeOriginalListener = this.f17925a.f17933f;
            if (!z) {
                z2 = true;
            }
            seeOriginalListener.m26461a(z2);
            this.f17925a.m26463a(z);
            return true;
        }
    }

    /* compiled from: data8 */
    public class C12954 implements OnClickListener {
        final /* synthetic */ TranslationMenuHelper f17926a;

        public C12954(TranslationMenuHelper translationMenuHelper) {
            this.f17926a = translationMenuHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            TranslationPreferencesModifier translationPreferencesModifier = this.f17926a.f17932e;
            String j = this.f17926a.f17930c.j();
            NeverTranslateLanguageInputData neverTranslateLanguageInputData = new NeverTranslateLanguageInputData();
            neverTranslateLanguageInputData.a("language_dialect", j);
            GraphQlCallInput graphQlCallInput = neverTranslateLanguageInputData;
            GraphQlQueryString neverTranslateLanguageCoreMutationString = new NeverTranslateLanguageCoreMutationString();
            neverTranslateLanguageCoreMutationString.a("input", graphQlCallInput);
            ListenableFuture a = translationPreferencesModifier.a.a(GraphQLRequest.a(neverTranslateLanguageCoreMutationString));
        }
    }

    /* compiled from: data8 */
    public class C12965 implements OnClickListener {
        final /* synthetic */ TranslationMenuHelper f17927a;

        public C12965(TranslationMenuHelper translationMenuHelper) {
            this.f17927a = translationMenuHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* compiled from: data8 */
    public interface SeeOriginalListener {
        void m26461a(boolean z);
    }

    public TranslationMenuHelper(GraphQLPostTranslatability graphQLPostTranslatability, Context context, TranslationPreferencesModifier translationPreferencesModifier, Boolean bool, FbUriIntentHandler fbUriIntentHandler) {
        this.f17928a = context;
        this.f17930c = graphQLPostTranslatability;
        this.f17932e = translationPreferencesModifier;
        this.f17934g = Boolean.valueOf(true);
        this.f17935h = bool;
        this.f17936i = fbUriIntentHandler;
    }

    public final void m26462a(View view) {
        GraphQLTranslatabilityType graphQLTranslatabilityType;
        this.f17931d = this.f17928a.getResources();
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(this.f17928a);
        PopoverMenu c = popoverMenuWindow.c();
        if (this.f17930c == null) {
            graphQLTranslatabilityType = null;
        } else {
            graphQLTranslatabilityType = this.f17930c.o();
        }
        if (graphQLTranslatabilityType == GraphQLTranslatabilityType.AUTO_TRANSLATION && this.f17935h.booleanValue()) {
            MenuItemImpl a = this.f17934g.booleanValue() ? c.a(2131233183) : c.a(2131233184);
            a.setIcon(2130840086);
            a.a(StringFormatUtil.formatStrLocaleSafe(this.f17931d.getString(2131233185), this.f17930c.k(), this.f17930c.m()));
            a.setOnMenuItemClickListener(new C12943(this));
        }
        MenuItemImpl a2 = c.a(StringFormatUtil.formatStrLocaleSafe(this.f17931d.getString(2131233186), this.f17930c.k()));
        a2.setIcon(2130840246);
        a2.setOnMenuItemClickListener(new C12921(this));
        a2 = c.a(StringFormatUtil.formatStrLocaleSafe(this.f17931d.getString(2131233179), this.f17930c.k()));
        a2.setIcon(2130843342);
        a2.setOnMenuItemClickListener(new C12932(this));
        popoverMenuWindow.a(c);
        popoverMenuWindow.o = this.f17929b;
        PopoverWindow popoverWindow = popoverMenuWindow;
        popoverWindow.e = true;
        popoverWindow.c(true);
        popoverWindow.c(view);
        popoverWindow.d();
    }

    public final void m26463a(boolean z) {
        this.f17934g = Boolean.valueOf(z);
    }
}

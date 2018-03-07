package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.search.model.TypeaheadSnippetModel;
import com.facebook.widget.text.BetterTextView;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: valueSubBody cannot be null */
public class SearchTypeaheadSnippetPartDefinition extends BaseSinglePartDefinition<List<TypeaheadSnippetModel>, CharSequence, AnyEnvironment, BetterTextView> {
    private static SearchTypeaheadSnippetPartDefinition f628c;
    private static final Object f629d = new Object();
    private final Context f630a;
    private final Resources f631b;

    private static SearchTypeaheadSnippetPartDefinition m724b(InjectorLike injectorLike) {
        return new SearchTypeaheadSnippetPartDefinition((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m725a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        List<TypeaheadSnippetModel> list = (List) obj;
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(this.f631b.getString(2131236534));
        for (TypeaheadSnippetModel typeaheadSnippetModel : list) {
            separatedSpannableStringBuilder.a(typeaheadSnippetModel.a, new TextAppearanceSpan(this.f630a, typeaheadSnippetModel.b), 17);
        }
        return separatedSpannableStringBuilder;
    }

    public final /* bridge */ /* synthetic */ void m726a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 273678461);
        ((BetterTextView) view).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, 284548010, a);
    }

    @Inject
    public SearchTypeaheadSnippetPartDefinition(Context context, Resources resources) {
        this.f630a = context;
        this.f631b = resources;
    }

    public static SearchTypeaheadSnippetPartDefinition m723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadSnippetPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f629d) {
                SearchTypeaheadSnippetPartDefinition searchTypeaheadSnippetPartDefinition;
                if (a2 != null) {
                    searchTypeaheadSnippetPartDefinition = (SearchTypeaheadSnippetPartDefinition) a2.a(f629d);
                } else {
                    searchTypeaheadSnippetPartDefinition = f628c;
                }
                if (searchTypeaheadSnippetPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m724b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f629d, b3);
                        } else {
                            f628c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadSnippetPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

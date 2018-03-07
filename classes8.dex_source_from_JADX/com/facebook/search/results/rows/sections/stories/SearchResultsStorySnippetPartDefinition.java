package com.facebook.search.results.rows.sections.stories;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsStoryUnit;
import com.facebook.search.widget.simplepopoverwindow.SimplePopoverWindow;
import com.facebook.text.linkify.SafeLinkifier;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Optional;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POSTGAME */
public class SearchResultsStorySnippetPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsStoryUnit>, Void, HasPositionInformation, BetterTextView> {
    public static final ViewType f25088a = new C26381();
    private static SearchResultsStorySnippetPartDefinition f25089f;
    private static final Object f25090g = new Object();
    private final BackgroundPartDefinition f25091b;
    private final TextPartDefinition f25092c;
    private final ClickListenerPartDefinition f25093d;
    public final Resources f25094e;

    /* compiled from: POSTGAME */
    final class C26381 extends ViewType {
        C26381() {
        }

        public final View m28389a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTextAppearance(betterTextView.getContext(), 2131624226);
            return betterTextView;
        }
    }

    private static SearchResultsStorySnippetPartDefinition m28392b(InjectorLike injectorLike) {
        return new SearchResultsStorySnippetPartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m28394a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final SearchResultsStoryUnit searchResultsStoryUnit = (SearchResultsStoryUnit) feedProps.a;
        subParts.a(this.f25091b, new StylingData(feedProps.a(searchResultsStoryUnit.mo1333f()), PaddingStyle.e, Position.TOP));
        subParts.a(this.f25092c, searchResultsStoryUnit.f23546c.get());
        if (m28391a(searchResultsStoryUnit.f23547d)) {
            subParts.a(this.f25093d, new OnClickListener(this) {
                final /* synthetic */ SearchResultsStorySnippetPartDefinition f25087b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 425083141);
                    SimplePopoverWindow simplePopoverWindow = new SimplePopoverWindow(view.getContext());
                    simplePopoverWindow.a.setText((CharSequence) searchResultsStoryUnit.f23546c.get());
                    SearchResultsStorySnippetPartDefinition searchResultsStorySnippetPartDefinition = this.f25087b;
                    SearchResultsStoryUnit searchResultsStoryUnit = searchResultsStoryUnit;
                    SpannableStringBuilder append = new SpannableStringBuilder((CharSequence) searchResultsStoryUnit.f23546c.get()).append("\n");
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(searchResultsStorySnippetPartDefinition.f25094e.getString(2131239053));
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 33);
                    Spannable append2 = append.append(spannableStringBuilder).append(" ").append((CharSequence) searchResultsStoryUnit.f23547d.get());
                    SafeLinkifier.a(append2, 1);
                    simplePopoverWindow.l.setText(append2);
                    simplePopoverWindow.a(view);
                    Logger.a(2, EntryType.UI_INPUT_END, 766920092, a);
                }
            });
        }
        return null;
    }

    public final boolean m28395a(Object obj) {
        return m28391a(((SearchResultsStoryUnit) ((FeedProps) obj).a).f23546c);
    }

    @Inject
    public SearchResultsStorySnippetPartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, Resources resources) {
        this.f25091b = backgroundPartDefinition;
        this.f25092c = textPartDefinition;
        this.f25093d = clickListenerPartDefinition;
        this.f25094e = resources;
    }

    public static SearchResultsStorySnippetPartDefinition m28390a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsStorySnippetPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25090g) {
                SearchResultsStorySnippetPartDefinition searchResultsStorySnippetPartDefinition;
                if (a2 != null) {
                    searchResultsStorySnippetPartDefinition = (SearchResultsStorySnippetPartDefinition) a2.a(f25090g);
                } else {
                    searchResultsStorySnippetPartDefinition = f25089f;
                }
                if (searchResultsStorySnippetPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28392b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25090g, b3);
                        } else {
                            f25089f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsStorySnippetPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m28393a() {
        return f25088a;
    }

    private static boolean m28391a(Optional<String> optional) {
        return optional.isPresent() && !((String) optional.get()).isEmpty();
    }
}

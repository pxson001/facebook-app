package com.facebook.search.suggestions.nullstate;

import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: load_contacts */
public interface RecentSearchesMutator {
    void mo738a(EntityTypeaheadUnit entityTypeaheadUnit);

    void mo739a(KeywordTypeaheadUnit keywordTypeaheadUnit);

    void mo740a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit);

    void mo741a(SeeMoreResultPageUnit seeMoreResultPageUnit);

    void mo742a(ShortcutTypeaheadUnit shortcutTypeaheadUnit);

    void mo743d();

    ListenableFuture<Void> mo744e();
}

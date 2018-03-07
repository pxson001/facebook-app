package com.facebook.search.results.model.unit;

import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Remote Media Player failed with  */
public class SearchResultsResultsNoUnit extends SearchResultsBaseFeedUnit {
    public final String f23507a;
    private final boolean f23508b;

    public SearchResultsResultsNoUnit(String str, boolean z) {
        this.f23507a = (String) Optional.fromNullable(str).or("");
        this.f23508b = z;
    }
}

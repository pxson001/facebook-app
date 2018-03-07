package com.facebook.search.results.model.unit.answer;

import android.net.Uri;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import java.util.TimeZone;

/* compiled from: RedSpaceBatchResult3{mResult3= */
public class SearchResultsTimeUnit extends SearchResultsBaseFeedUnit {
    public final String f23554a;
    public final TimeZone f23555b;
    public final Uri f23556c;

    public SearchResultsTimeUnit(String str, TimeZone timeZone, Uri uri) {
        this.f23554a = str;
        this.f23555b = timeZone;
        this.f23556c = uri;
    }
}

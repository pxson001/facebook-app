package com.facebook.ui.typeahead;

import com.facebook.contextual.ContextualResolverImpl;
import com.facebook.contextual.ContextualResolverMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: start_call */
public class SearchTypeaheadConfig extends XConfig {
    public static final XConfigSetting f1903c = new XConfigSetting(f1905g, "typeahead_delay");
    public static final XConfigSetting f1904d = new XConfigSetting(f1905g, "is_using_contextual");
    private static final XConfigName f1905g = new XConfigName("SearchTypeaheadParams");
    private static final ImmutableSet<XConfigSetting> f1906h = ImmutableSet.of(f1903c, f1904d);
    public ContextualResolverImpl f1907e;
    public XConfigReader f1908f;

    public static SearchTypeaheadConfig m1954b(InjectorLike injectorLike) {
        return new SearchTypeaheadConfig(ContextualResolverMethodAutoProvider.m1955a(injectorLike), XConfigReader.a(injectorLike));
    }

    @Inject
    public SearchTypeaheadConfig(ContextualResolverImpl contextualResolverImpl, XConfigReader xConfigReader) {
        super(f1905g, f1906h);
        this.f1907e = contextualResolverImpl;
        this.f1908f = xConfigReader;
    }
}

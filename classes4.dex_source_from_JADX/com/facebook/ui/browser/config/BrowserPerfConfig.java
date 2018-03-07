package com.facebook.ui.browser.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: start_internal_webview_from_url */
public class BrowserPerfConfig extends XConfig {
    public static final XConfigSetting f1894c = new XConfigSetting(f1898g, "cdn_safe_resource_base_url");
    public static final XConfigSetting f1895d = new XConfigSetting(f1898g, "intercept_domain_whitelist");
    public static final XConfigSetting f1896e = new XConfigSetting(f1898g, "intercept_url_extension_blacklist");
    public static final XConfigSetting f1897f = new XConfigSetting(f1898g, "js_css_minification_version");
    private static final XConfigName f1898g = new XConfigName("android_browser_perf_config");

    @Inject
    public BrowserPerfConfig() {
        super(f1898g, ImmutableSet.of(f1894c, f1895d, f1896e, f1897f));
    }
}

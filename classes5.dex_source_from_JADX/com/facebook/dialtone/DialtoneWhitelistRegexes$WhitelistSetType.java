package com.facebook.dialtone;

import com.facebook.xconfig.core.XConfigSetting;
import java.util.List;

/* compiled from: \\n */
public enum DialtoneWhitelistRegexes$WhitelistSetType {
    FACEWEB(DialtoneWhitelistXConfig.f, DialtoneWhitelistRegexes.i),
    PHOTO(DialtoneWhitelistXConfig.c, DialtoneWhitelistRegexes.g),
    URI(DialtoneWhitelistXConfig.d, DialtoneWhitelistRegexes.j),
    VIDEO(DialtoneWhitelistXConfig.e, DialtoneWhitelistRegexes.h);
    
    private List<String> mWhitePatternList;
    private XConfigSetting mXConfigSetting;

    public final XConfigSetting getXConfigSetting() {
        return this.mXConfigSetting;
    }

    final List<String> getWhitePatternList() {
        return this.mWhitePatternList;
    }

    private DialtoneWhitelistRegexes$WhitelistSetType(XConfigSetting xConfigSetting, List<String> list) {
        this.mXConfigSetting = xConfigSetting;
        this.mWhitePatternList = list;
    }
}

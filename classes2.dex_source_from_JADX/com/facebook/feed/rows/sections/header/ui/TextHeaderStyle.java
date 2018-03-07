package com.facebook.feed.rows.sections.header.ui;

import android.content.res.Resources;
import com.facebook.common.util.SizeUtil;

/* compiled from: is_app_link */
public enum TextHeaderStyle {
    SUGGESTED_CONTENT(2131362052, 1, 2131427402),
    SOCIAL_CONTEXT(2131361972, 0, 2131427401),
    STORY_HEADER(2131361972, 0, 2131427402);
    
    private int mColor;
    private final int mColorResource;
    private boolean mColorSet;
    private int mFontSize;
    private final int mFontSizeResource;
    private boolean mFontSizeSet;
    private int mFontStyle;

    private TextHeaderStyle(int i, int i2, int i3) {
        this.mColorSet = false;
        this.mFontSizeSet = false;
        this.mColorResource = i;
        this.mFontStyle = i2;
        this.mFontSizeResource = i3;
    }

    public final int getColor(Resources resources) {
        if (!this.mColorSet) {
            this.mColor = resources.getColor(this.mColorResource);
            this.mColorSet = true;
        }
        return this.mColor;
    }

    public final int getColorResource() {
        return this.mColorResource;
    }

    public final int getFontStyle() {
        return this.mFontStyle;
    }

    public final int getFontSize(Resources resources) {
        if (!this.mFontSizeSet) {
            this.mFontSize = SizeUtil.m19199c(resources, this.mFontSizeResource);
            this.mFontSizeSet = true;
        }
        return this.mFontSize;
    }

    public final int getFontSizeResource() {
        return this.mFontSizeResource;
    }
}

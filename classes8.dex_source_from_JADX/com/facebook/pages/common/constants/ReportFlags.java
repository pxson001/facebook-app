package com.facebook.pages.common.constants;

/* compiled from: task_key_load_menu_info */
public enum ReportFlags {
    OFFENSIVE("offensive"),
    NOT_PUBLIC("not_public"),
    NOT_CLOSED("not_closed"),
    CLOSED("closed");
    
    public final String mArgVal;

    private ReportFlags(String str) {
        this.mArgVal = str;
    }
}

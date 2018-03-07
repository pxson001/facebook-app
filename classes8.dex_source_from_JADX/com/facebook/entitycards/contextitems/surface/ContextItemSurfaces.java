package com.facebook.entitycards.contextitems.surface;

/* compiled from: in method deletePostAndRemoveMember */
public enum ContextItemSurfaces {
    PAGE_HEADER("page_header"),
    PAGE_INFO_CARD("page_info_card"),
    STORE_LOCATOR("store_locator"),
    PLACE_TIPS("place_tips");
    
    public final String name;

    private ContextItemSurfaces(String str) {
        this.name = str;
    }
}

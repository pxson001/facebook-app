package com.facebook.saved2.model;

/* compiled from: north_latitude */
public interface Saved2ItemTable_Setup {
    public static final String[] f7846a = new String[]{"CREATE INDEX item_section_name ON item(section_name)", "CREATE UNIQUE INDEX item_node_id_section_name ON item(node_id, section_name)"};
}

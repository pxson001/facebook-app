package com.facebook.messaging.model.folders;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;

/* compiled from: user_accept_place_suggestion */
public enum FolderName {
    NONE("none"),
    INBOX("inbox"),
    PENDING("pending"),
    OTHER("other"),
    ARCHIVED("archived"),
    SPAM("spam"),
    MONTAGE("montage");
    
    private static final ImmutableMap<String, FolderName> ALL_FOLDERS_BY_DB_NAME = null;
    public static final ImmutableSet<FolderName> CONVERSATION_REQUEST_FOLDERS = null;
    public final String dbName;

    static {
        CONVERSATION_REQUEST_FOLDERS = ImmutableSet.of(PENDING, OTHER);
        Builder builder = ImmutableMap.builder();
        FolderName[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            FolderName folderName = values[i];
            builder.b(folderName.dbName, folderName);
            i++;
        }
        ALL_FOLDERS_BY_DB_NAME = builder.b();
    }

    private FolderName(String str) {
        this.dbName = str;
    }

    public static FolderName fromDbName(String str) {
        FolderName folderName = (FolderName) ALL_FOLDERS_BY_DB_NAME.get(str);
        if (folderName != null) {
            return folderName;
        }
        throw new IllegalArgumentException("Invalid name " + str);
    }

    public final String toString() {
        return this.dbName;
    }

    public final boolean isMessageRequestFolders() {
        return this == PENDING || this == OTHER;
    }

    public final boolean isSpamOrArchivedFolder() {
        return this == SPAM || this == ARCHIVED;
    }
}

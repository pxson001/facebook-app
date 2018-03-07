package com.facebook.messaging.database.threads;

import com.facebook.messaging.model.folders.FolderName;

/* compiled from: me/message_files */
public class DbFolders {
    public static String m11102a(FolderName folderName) {
        return "first_" + folderName.dbName;
    }
}

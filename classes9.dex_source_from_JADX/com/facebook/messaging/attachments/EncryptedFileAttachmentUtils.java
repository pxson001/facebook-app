package com.facebook.messaging.attachments;

import android.content.Context;
import java.io.File;

/* compiled from: p2p_confirm_card_details */
public class EncryptedFileAttachmentUtils {
    public static File m8022a(Context context, String str) {
        File file = new File(context.getFilesDir(), "encrypted_attachments");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, str);
    }
}

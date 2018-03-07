package com.facebook.friendsharing.souvenirs.manager;

import android.content.ContentValues;
import com.facebook.common.util.StringUtil;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirsDbSchemaPart.PromptsTable.Columns;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: RUN_JS_BUNDLE_END */
class SouvenirPromptManager$2 implements Callable<Void> {
    final /* synthetic */ String f24055a;
    final /* synthetic */ SouvenirPromptManager f24056b;

    SouvenirPromptManager$2(SouvenirPromptManager souvenirPromptManager, String str) {
        this.f24056b = souvenirPromptManager;
        this.f24055a = str;
    }

    public Object call() {
        SouvenirPromptsDataAccessLayer souvenirPromptsDataAccessLayer = this.f24056b.b;
        Object obj = this.f24055a;
        long a = this.f24056b.d.a();
        boolean z = true;
        souvenirPromptsDataAccessLayer.b.b();
        Preconditions.checkArgument(!StringUtil.a(obj), "Give us a valid, non-empty ID");
        if (a < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Please give us a valid UNIX timestamp");
        ContentValues contentValues = new ContentValues();
        contentValues.put(Columns.a.toString(), obj);
        contentValues.put(Columns.b.toString(), Long.valueOf(a));
        SQLiteDetour.a(1904108057);
        souvenirPromptsDataAccessLayer.a.a().replaceOrThrow("prompted_models", "", contentValues);
        SQLiteDetour.a(39895251);
        return null;
    }
}

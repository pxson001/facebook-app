package com.facebook.friendsharing.souvenirs.prompt.model;

import android.net.Uri;
import com.facebook.friendsharing.souvenirs.models.SouvenirBurstItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirPhotoItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.productionprompts.model.PromptObject.PromptSurface;

/* compiled from: REMOTE_CONTACT_IDS */
public class SouvenirPromptObject implements PromptObject {
    public final SouvenirModel f24127a;
    public boolean f24128b = false;

    public SouvenirPromptObject(SouvenirModel souvenirModel) {
        this.f24127a = souvenirModel;
    }

    public final String m26253b() {
        return "647619478700283:" + this.f24127a.a().m26169a();
    }

    public final String m26254c() {
        return GraphQLPromptType.SOUVENIR.toString();
    }

    public final PromptSurface m26255d() {
        return PromptSurface.INLINE_COMPOSER;
    }

    public final Uri m26256e() {
        SouvenirItem souvenirItem = (SouvenirItem) this.f24127a.b().get(0);
        return souvenirItem instanceof SouvenirUriItem ? ((SouvenirUriItem) souvenirItem).b().mUri : ((SouvenirPhotoItem) ((SouvenirBurstItem) souvenirItem).m26157b().get(0)).m26188b().mUri;
    }
}

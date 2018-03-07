package com.facebook.pages.identity.cards.photos;

import android.content.res.Resources;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLPhoto;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* compiled from: privacy_checkup_app_delete_dialog_cancel */
public class PageIdentityPhotosCardController {
    public static final String f3571a = PageIdentityPhotosCardController.class.getSimpleName();
    public final Resources f3572b;
    public TabbedPhotosetData f3573c;
    public long f3574d;

    /* compiled from: privacy_checkup_app_delete_dialog_cancel */
    public enum PhotoCollectionType {
        PAGE_PHOTOS_BY,
        PAGE_PHOTOS_OF,
        PHOTOS_TAKEN_HERE
    }

    /* compiled from: privacy_checkup_app_delete_dialog_cancel */
    public class TabbedPhotosetData {
        public List<GraphQLPhoto> f3569a;
        public PhotoCollectionType f3570b;

        public TabbedPhotosetData(Collection<GraphQLPhoto> collection, PhotoCollectionType photoCollectionType) {
            this.f3570b = photoCollectionType;
            this.f3569a = ImmutableList.copyOf(collection);
        }

        public final boolean m4624b() {
            return this.f3569a == null || this.f3569a.isEmpty();
        }
    }

    public PageIdentityPhotosCardController(Resources resources) {
        this.f3572b = resources;
    }

    public final String m4625b() {
        switch (this.f3573c.f3570b) {
            case PHOTOS_TAKEN_HERE:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.aM, Long.valueOf(this.f3574d));
            case PAGE_PHOTOS_BY:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.aO, Long.valueOf(this.f3574d));
            case PAGE_PHOTOS_OF:
                return StringFormatUtil.formatStrLocaleSafe(FBLinks.aN, Long.valueOf(this.f3574d));
            default:
                BLog.b(f3571a, "Unknown collection type in getMediaSetURL()");
                return null;
        }
    }
}

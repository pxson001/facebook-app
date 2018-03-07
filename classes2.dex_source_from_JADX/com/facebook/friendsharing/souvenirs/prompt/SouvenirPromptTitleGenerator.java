package com.facebook.friendsharing.souvenirs.prompt;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.inlinecomposer.v2attachment.V2PromptUtil;
import com.facebook.friendsharing.souvenirs.attachment.SouvenirPlaceholderTitleGenerator;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.friendsharing.souvenirs.util.SouvenirModelHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.BitSet;
import javax.inject.Inject;

/* compiled from: mount */
public class SouvenirPromptTitleGenerator {
    private final Resources f13312a;
    private final SouvenirPlaceholderTitleGenerator f13313b;
    private final V2PromptUtil f13314c;

    public static SouvenirPromptTitleGenerator m19604b(InjectorLike injectorLike) {
        return new SouvenirPromptTitleGenerator(ResourcesMethodAutoProvider.m6510a(injectorLike), SouvenirPlaceholderTitleGenerator.m19610b(injectorLike), V2PromptUtil.m18713b(injectorLike));
    }

    @Inject
    public SouvenirPromptTitleGenerator(Resources resources, SouvenirPlaceholderTitleGenerator souvenirPlaceholderTitleGenerator, V2PromptUtil v2PromptUtil) {
        this.f13312a = resources;
        this.f13313b = souvenirPlaceholderTitleGenerator;
        this.f13314c = v2PromptUtil;
    }

    public final String m19606a(SouvenirPromptObject souvenirPromptObject) {
        int i;
        boolean z = (souvenirPromptObject == null || souvenirPromptObject.a == null) ? false : true;
        Preconditions.checkArgument(z);
        BitSet a = m19603a(souvenirPromptObject.a);
        if (a.get(0) || a.get(1)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "How can you have a collage without photos or videos?");
        if (a.get(0) && !a.get(1)) {
            i = 2131238463;
        } else if (a.get(0) || !a.get(1)) {
            i = 2131238465;
        } else {
            i = 2131238464;
        }
        SouvenirMetadata a2 = souvenirPromptObject.a.a();
        return this.f13312a.getString(i, new Object[]{this.f13313b.m19612a(a2.c(), a2.d())});
    }

    public final SpannableStringBuilder m19605a(Resources resources, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str);
        Rect rect = new Rect(0, resources.getDimensionPixelSize(2131430503), resources.getDimensionPixelSize(2131430502), resources.getDimensionPixelSize(2131430501));
        Drawable a = this.f13314c.m18714a();
        a.setBounds(rect);
        ImageSpan imageSpan = new ImageSpan(a, 1);
        spannableStringBuilder.append(" ");
        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    private static BitSet m19603a(SouvenirModel souvenirModel) {
        BitSet bitSet = new BitSet(2);
        UnmodifiableIterator a = SouvenirModelHelper.a(souvenirModel);
        while (true) {
            if (!(bitSet.get(0) && bitSet.get(1)) && a.hasNext()) {
                SouvenirUriItem souvenirUriItem = (SouvenirUriItem) a.next();
                if (souvenirUriItem.hw_() == Type.Photo) {
                    bitSet.set(0);
                } else if (souvenirUriItem.hw_() == Type.Video) {
                    bitSet.set(1);
                } else {
                    throw new IllegalStateException("Unknown Uri item type " + souvenirUriItem.hw_());
                }
            }
        }
        return bitSet;
    }
}

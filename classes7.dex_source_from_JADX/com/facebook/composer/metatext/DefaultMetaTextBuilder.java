package com.facebook.composer.metatext;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.composer.metatext.MetaTextBuilder.Params;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParams;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: transliteration_dictionary */
public class DefaultMetaTextBuilder implements MetaTextBuilder {
    public final Resources f1282a;

    /* compiled from: transliteration_dictionary */
    enum TagType {
        PERSON,
        PEOPLE,
        PLACE,
        MINUTIAE
    }

    @Inject
    public DefaultMetaTextBuilder(Resources resources) {
        this.f1282a = resources;
    }

    public final SpannableStringBuilder mo56a(Params params) {
        return m1368a(params, new StyleParamsBuilder(this.f1282a).m1374a());
    }

    public final SpannableStringBuilder m1368a(Params params, StyleParams styleParams) {
        Preconditions.checkArgument(params.f1283a == null, "Minutiae object parameter is not supported");
        SpannableStringBuilder spannableStringBuilder = params.f1290h != null ? new SpannableStringBuilder(params.f1290h) : new SpannableStringBuilder();
        CheckinPlaceModel checkinPlaceModel = params.f1284b;
        String str = params.f1285c;
        if (params.m1370b(this.f1282a) == null) {
            if (checkinPlaceModel == null && str == null) {
                str = null;
            } else {
                if (checkinPlaceModel != null) {
                    str = checkinPlaceModel.j();
                }
                str = this.f1282a.getString(2131234661, new Object[]{str});
            }
        } else if (checkinPlaceModel == null && str == null) {
            str = this.f1282a.getString(2131234660, new Object[]{r6});
        } else {
            if (checkinPlaceModel != null) {
                str = checkinPlaceModel.j();
            }
            str = this.f1282a.getString(2131234662, new Object[]{r6, str});
        }
        String str2 = str;
        if (str2 != null) {
            if (params.f1288f) {
                Object obj = " — " + str2;
                spannableStringBuilder.append(obj);
                m1365a(spannableStringBuilder, obj, params, styleParams);
            } else {
                spannableStringBuilder.append(str2);
            }
        }
        return spannableStringBuilder;
    }

    private void m1365a(SpannableStringBuilder spannableStringBuilder, String str, Params params, StyleParams styleParams) {
        CheckinPlaceModel checkinPlaceModel = params.f1284b;
        String b = params.m1370b(this.f1282a);
        MinutiaeObject minutiaeObject = params.f1283a;
        TagClickListener tagClickListener = params.f1291i;
        int length = spannableStringBuilder.length() - str.length();
        spannableStringBuilder.setSpan(styleParams.f1301a, length, spannableStringBuilder.length(), 33);
        if (minutiaeObject != null) {
            String c = minutiaeObject.object.c();
            int indexOf = str.indexOf(c) + length;
            int length2 = indexOf + c.length();
            spannableStringBuilder.setSpan(CharacterStyle.wrap(styleParams.f1302b), indexOf, length2, 33);
            int indexOf2 = str.indexOf(8204) + length;
            m1364a(spannableStringBuilder, tagClickListener, TagType.MINUTIAE, indexOf2, length2, -1);
            spannableStringBuilder.setSpan(minutiaeObject.a(), indexOf2, indexOf2 + 1, 33);
        }
        if (b != null) {
            indexOf = str.indexOf(b) + length;
            if (!params.f1286d.isEmpty()) {
                for (int i = 0; i < params.f1286d.size(); i++) {
                    c = (String) params.f1286d.get(i);
                    length2 = indexOf + b.indexOf(c);
                    m1363a(spannableStringBuilder, length2, length2 + c.length(), styleParams.f1302b, tagClickListener, TagType.PERSON, i);
                }
            }
            c = params.m1369a(this.f1282a);
            if (c != null) {
                length2 = indexOf + b.indexOf(c);
                m1363a(spannableStringBuilder, length2, length2 + c.length(), styleParams.f1302b, tagClickListener, TagType.PEOPLE, -1);
            }
        }
        if (checkinPlaceModel != null && checkinPlaceModel.j() != null) {
            indexOf2 = str.indexOf(checkinPlaceModel.j()) + length;
            length2 = indexOf2 + checkinPlaceModel.j().length();
            spannableStringBuilder.setSpan(CharacterStyle.wrap(styleParams.f1302b), indexOf2, length2, 33);
            m1364a(spannableStringBuilder, tagClickListener, TagType.PLACE, indexOf2, length2, -1);
        }
    }

    private void m1364a(SpannableStringBuilder spannableStringBuilder, final TagClickListener tagClickListener, final TagType tagType, int i, int i2, final int i3) {
        if (tagClickListener != null) {
            spannableStringBuilder.setSpan(new ClickableSpan(this) {
                final /* synthetic */ DefaultMetaTextBuilder f1280d;

                public void onClick(View view) {
                    DefaultMetaTextBuilder defaultMetaTextBuilder = this.f1280d;
                    DefaultMetaTextBuilder.m1366a(tagType, tagClickListener, i3);
                }

                public void updateDrawState(TextPaint textPaint) {
                }
            }, i, i2, 33);
        }
    }

    public static void m1366a(TagType tagType, TagClickListener tagClickListener, int i) {
        switch (tagType) {
            case PEOPLE:
                tagClickListener.m1375a();
                return;
            case PERSON:
                tagClickListener.m1376a(i);
                return;
            case PLACE:
                tagClickListener.m1377b();
                return;
            case MINUTIAE:
                tagClickListener.m1378c();
                return;
            default:
                throw new RuntimeException("Unknown tag type: " + tagType);
        }
    }

    private void m1363a(SpannableStringBuilder spannableStringBuilder, int i, int i2, CharacterStyle characterStyle, TagClickListener tagClickListener, TagType tagType, int i3) {
        spannableStringBuilder.setSpan(CharacterStyle.wrap(characterStyle), i, i2, 33);
        m1364a(spannableStringBuilder, tagClickListener, tagType, i, i2, i3);
    }
}

package com.facebook.composer.metatext;

import android.content.res.Resources;
import android.support.v4.text.TextUtilsCompat;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.metatext.MetaTextBuilder.Params;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParams;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaePreviewTemplate;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaePreviewTemplate.TemplateTokens;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel.TemplateTokensModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.facebook.inject.InjectorLike;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: translateX */
public class MinutiaeTemplateMetaTextBuilder implements MetaTextBuilder {
    private final Resources f1325a;

    /* compiled from: translateX */
    class C01172 implements Comparator<TemplateTokens> {
        final /* synthetic */ MinutiaeTemplateMetaTextBuilder f1323a;

        C01172(MinutiaeTemplateMetaTextBuilder minutiaeTemplateMetaTextBuilder) {
            this.f1323a = minutiaeTemplateMetaTextBuilder;
        }

        public int compare(Object obj, Object obj2) {
            return ((TemplateTokensModel) obj).a() - ((TemplateTokensModel) obj2).a();
        }
    }

    /* compiled from: translateX */
    /* synthetic */ class C01183 {
        static final /* synthetic */ int[] f1324a = new int[GraphQLActivityTemplateTokenType.values().length];

        static {
            try {
                f1324a[GraphQLActivityTemplateTokenType.PEOPLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1324a[GraphQLActivityTemplateTokenType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1324a[GraphQLActivityTemplateTokenType.PLACE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1324a[GraphQLActivityTemplateTokenType.OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1324a[GraphQLActivityTemplateTokenType.ICON.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static MinutiaeTemplateMetaTextBuilder m1391b(InjectorLike injectorLike) {
        return new MinutiaeTemplateMetaTextBuilder(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MinutiaeTemplateMetaTextBuilder(Resources resources) {
        this.f1325a = resources;
    }

    public final SpannableStringBuilder mo56a(Params params) {
        return m1394a(params, new StyleParamsBuilder(this.f1325a).m1374a());
    }

    public final SpannableStringBuilder m1394a(Params params, StyleParams styleParams) {
        SpannableStringBuilder spannableStringBuilder;
        MinutiaePreviewTemplateModel F;
        MinutiaeObject minutiaeObject = (MinutiaeObject) Preconditions.checkNotNull(params.f1283a);
        CheckinPlaceModel checkinPlaceModel = params.f1284b;
        String b = params.m1370b(this.f1325a);
        int i = params.f1287e;
        if (params.f1290h != null) {
            spannableStringBuilder = new SpannableStringBuilder(params.f1290h);
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        if (checkinPlaceModel == null && b == null) {
            F = minutiaeObject.verb.F();
        } else if (checkinPlaceModel == null || b == null) {
            if (checkinPlaceModel != null) {
                F = minutiaeObject.verb.E();
            } else if (i > 1) {
                F = minutiaeObject.verb.G();
            } else {
                F = minutiaeObject.verb.I();
            }
        } else if (i > 1) {
            F = minutiaeObject.verb.H();
        } else {
            F = minutiaeObject.verb.J();
        }
        MinutiaePreviewTemplateModel minutiaePreviewTemplateModel = F;
        Map b2 = m1392b(params);
        Map c = Maps.c();
        CharSequence a = m1387a(minutiaePreviewTemplateModel, b2, c);
        if (params.f1288f) {
            String str = " — " + a;
            spannableStringBuilder.append(str);
            m1389a(params, styleParams, spannableStringBuilder, str, c, b2, minutiaePreviewTemplateModel);
        } else {
            spannableStringBuilder.append(a);
        }
        if (params.f1289g) {
            minutiaeObject = params.f1283a;
            if (b2.containsKey(GraphQLActivityTemplateTokenType.ICON)) {
                int indexOf = spannableStringBuilder.toString().indexOf(8204);
                if (indexOf >= 0) {
                    spannableStringBuilder.setSpan(minutiaeObject.a(), indexOf, indexOf + 1, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    private void m1389a(Params params, StyleParams styleParams, SpannableStringBuilder spannableStringBuilder, String str, Map<TemplateTokens, Integer> map, Map<GraphQLActivityTemplateTokenType, CharSequence> map2, MinutiaePreviewTemplate minutiaePreviewTemplate) {
        int length = spannableStringBuilder.length() - str.length();
        spannableStringBuilder.setSpan(styleParams.f1301a, length, spannableStringBuilder.length(), 33);
        ImmutableList b = minutiaePreviewTemplate.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            TemplateTokensModel templateTokensModel = (TemplateTokensModel) b.get(i);
            if (map.containsKey(templateTokensModel)) {
                int intValue = (((Integer) map.get(templateTokensModel)).intValue() + length) + 3;
                int length2 = intValue + ((CharSequence) map2.get(templateTokensModel.b())).length();
                if (templateTokensModel.b() == GraphQLActivityTemplateTokenType.PEOPLE || templateTokensModel.b() == GraphQLActivityTemplateTokenType.PERSON) {
                    String str2;
                    String b2 = params.m1370b(this.f1325a);
                    if (!params.f1286d.isEmpty()) {
                        for (int i2 = 0; i2 < params.f1286d.size(); i2++) {
                            str2 = (String) params.f1286d.get(i2);
                            int indexOf = intValue + b2.indexOf(str2);
                            m1388a(spannableStringBuilder, GraphQLActivityTemplateTokenType.PERSON, params.f1291i, styleParams.f1302b, indexOf, indexOf + str2.length(), i2);
                        }
                    }
                    str2 = params.m1369a(this.f1325a);
                    if (str2 != null) {
                        intValue += b2.indexOf(str2);
                        m1388a(spannableStringBuilder, GraphQLActivityTemplateTokenType.PEOPLE, params.f1291i, styleParams.f1302b, intValue, intValue + str2.length(), -1);
                    }
                } else {
                    m1388a(spannableStringBuilder, templateTokensModel.b(), params.f1291i, styleParams.f1302b, intValue, length2, -1);
                }
            }
        }
    }

    private void m1388a(SpannableStringBuilder spannableStringBuilder, final GraphQLActivityTemplateTokenType graphQLActivityTemplateTokenType, final TagClickListener tagClickListener, CharacterStyle characterStyle, int i, int i2, final int i3) {
        spannableStringBuilder.setSpan(CharacterStyle.wrap(characterStyle), i, i2, 33);
        if (tagClickListener != null) {
            spannableStringBuilder.setSpan(new ClickableSpan(this) {
                final /* synthetic */ MinutiaeTemplateMetaTextBuilder f1322d;

                public void onClick(View view) {
                    MinutiaeTemplateMetaTextBuilder.m1390a(graphQLActivityTemplateTokenType, tagClickListener, i3);
                }

                public void updateDrawState(TextPaint textPaint) {
                }
            }, i, i2, 33);
        }
    }

    @VisibleForTesting
    protected static void m1390a(GraphQLActivityTemplateTokenType graphQLActivityTemplateTokenType, TagClickListener tagClickListener, int i) {
        Preconditions.checkNotNull(graphQLActivityTemplateTokenType);
        Preconditions.checkNotNull(tagClickListener);
        switch (C01183.f1324a[graphQLActivityTemplateTokenType.ordinal()]) {
            case 1:
                tagClickListener.m1375a();
                return;
            case 2:
                tagClickListener.m1376a(i);
                return;
            case 3:
                tagClickListener.m1377b();
                return;
            case 4:
                tagClickListener.m1378c();
                return;
            case 5:
                tagClickListener.m1379d();
                return;
            default:
                return;
        }
    }

    @VisibleForTesting
    private Map<GraphQLActivityTemplateTokenType, CharSequence> m1392b(Params params) {
        MinutiaeObject minutiaeObject = params.f1283a;
        String b = params.m1370b(this.f1325a);
        CheckinPlaceModel checkinPlaceModel = params.f1284b;
        Preconditions.checkNotNull(minutiaeObject.object);
        Map<GraphQLActivityTemplateTokenType, CharSequence> c = Maps.c();
        c.put(GraphQLActivityTemplateTokenType.OBJECT, minutiaeObject.object.c());
        if (checkinPlaceModel != null) {
            c.put(GraphQLActivityTemplateTokenType.PLACE, checkinPlaceModel.j());
        }
        if (b != null) {
            if (params.f1287e > 1) {
                c.put(GraphQLActivityTemplateTokenType.PEOPLE, b);
            } else {
                c.put(GraphQLActivityTemplateTokenType.PERSON, b);
            }
        }
        if (!(minutiaeObject.object.j() == null || minutiaeObject.object.j().b() == null || !params.f1289g)) {
            Object obj;
            if (1 == TextUtilsCompat.a(Locale.getDefault())) {
                obj = " ‌";
            } else {
                obj = "‌ ";
            }
            c.put(GraphQLActivityTemplateTokenType.ICON, obj);
        }
        return c;
    }

    @VisibleForTesting
    private String m1387a(MinutiaePreviewTemplate minutiaePreviewTemplate, Map<GraphQLActivityTemplateTokenType, CharSequence> map, Map<TemplateTokens, Integer> map2) {
        StringBuilder stringBuilder = new StringBuilder(minutiaePreviewTemplate.a());
        List<TemplateTokensModel> a = Lists.a(minutiaePreviewTemplate.b());
        Collections.sort(a, new C01172(this));
        int i = 0;
        for (TemplateTokensModel templateTokensModel : a) {
            int length;
            CharSequence charSequence = (CharSequence) map.get(templateTokensModel.b());
            if (charSequence != null) {
                stringBuilder.insert(templateTokensModel.a() + i, charSequence);
                map2.put(templateTokensModel, Integer.valueOf(templateTokensModel.a() + i));
                length = charSequence.length() + i;
            } else {
                length = i;
            }
            i = length;
        }
        return stringBuilder.toString();
    }
}

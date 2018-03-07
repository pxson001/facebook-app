package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.customrender.CustomRenderType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = QuickPromotionDefinitionDeserializer.class)
@Immutable
/* compiled from: request_ids */
public class QuickPromotionDefinition implements Parcelable {
    public static final Creator<QuickPromotionDefinition> CREATOR = new 1();
    @JsonIgnore
    private ImmutableList<Creative> f3443a;
    @JsonProperty("animated_image")
    public final ImageParameters animatedImageParams;
    private ImmutableSet<Attribute> f3444b;
    @JsonProperty("boolean_filter_root")
    public final BooleanFilter booleanFilter;
    @JsonProperty("branding_image")
    public final ImageParameters brandingImageParams;
    @JsonProperty("client_ttl_seconds")
    public final long clientTtlSeconds;
    @JsonProperty("content")
    public final String content;
    @JsonProperty("creatives")
    final ImmutableList<Creative> creatives;
    @JsonProperty("custom_renderer_type")
    public final CustomRenderType customRenderType;
    @JsonProperty("dismiss_action")
    public final Action dismissAction;
    @JsonProperty("end_time")
    public final long endTime;
    @JsonProperty("contextual_filters")
    private final List<ContextualFilter> filters;
    @JsonProperty("footer")
    public final String footer;
    @JsonProperty("image")
    public final ImageParameters imageParams;
    @JsonProperty("instance_log_data")
    public final ImmutableMap<String, String> instanceLogData;
    @JsonProperty("is_exposure_holdout")
    public final boolean isExposureHoldout;
    @JsonProperty("log_eligibility_waterfall")
    public final boolean logEligibilityWaterfall;
    @JsonProperty("max_impressions")
    public final int maxImpressions;
    @JsonProperty("primary_action")
    public final Action primaryAction;
    @JsonProperty("priority")
    public final long priority;
    @JsonProperty("promotion_id")
    public final String promotionId;
    @JsonProperty("secondary_action")
    public final Action secondaryAction;
    @JsonProperty("social_context")
    public final SocialContext socialContext;
    @JsonProperty("start_time")
    public final long startTime;
    @JsonProperty("template")
    private final TemplateType template;
    @JsonProperty("template_parameters")
    public final ImmutableMap<String, String> templateParameters;
    @JsonProperty("title")
    public final String title;
    @JsonProperty("triggers")
    private final List<InterstitialTrigger> triggers;
    @JsonProperty("viewer_impressions")
    public final int viewerImpressions;

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = QuickPromotionDefinition_CreativeDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public class Creative implements Parcelable {
        public static final Creator<Creative> CREATOR = new 1();
        @JsonProperty("animated_image")
        @Nullable
        public final ImageParameters animatedImageParams;
        @JsonProperty("branding_image")
        @Nullable
        public final ImageParameters brandingImageParams;
        @JsonProperty("content")
        public final String content;
        @JsonProperty("dismiss_action")
        @Nullable
        public final Action dismissAction;
        @JsonProperty("footer")
        @Nullable
        public final String footer;
        @JsonProperty("image")
        @Nullable
        public final ImageParameters imageParams;
        @JsonProperty("primary_action")
        public final Action primaryAction;
        @JsonProperty("secondary_action")
        public final Action secondaryAction;
        @JsonProperty("social_context")
        public final SocialContext socialContext;
        @JsonProperty("template")
        public final TemplateType template;
        @JsonProperty("template_parameters")
        public final ImmutableMap<String, String> templateParameters;
        @JsonProperty("title")
        public final String title;

        public Creative() {
            this.title = null;
            this.content = null;
            this.imageParams = null;
            this.animatedImageParams = null;
            this.primaryAction = null;
            this.secondaryAction = null;
            this.dismissAction = null;
            this.socialContext = null;
            this.footer = null;
            this.template = TemplateType.UNKNOWN;
            this.templateParameters = RegularImmutableBiMap.a;
            this.brandingImageParams = null;
        }

        public Creative(Parcel parcel) {
            this.title = parcel.readString();
            this.content = parcel.readString();
            this.imageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
            this.animatedImageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
            this.primaryAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
            this.secondaryAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
            this.dismissAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
            this.socialContext = (SocialContext) parcel.readParcelable(SocialContext.class.getClassLoader());
            this.footer = parcel.readString();
            this.template = TemplateType.fromString(parcel.readString());
            this.templateParameters = ImmutableMap.copyOf(parcel.readHashMap(null));
            this.brandingImageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
        }

        public Creative(String str, String str2, @Nullable ImageParameters imageParameters, @Nullable ImageParameters imageParameters2, Action action, Action action2, @Nullable Action action3, SocialContext socialContext, @Nullable String str3, TemplateType templateType, ImmutableMap<String, String> immutableMap, @Nullable ImageParameters imageParameters3) {
            this.title = str;
            this.content = str2;
            this.imageParams = imageParameters;
            this.animatedImageParams = imageParameters2;
            this.primaryAction = action;
            this.secondaryAction = action2;
            this.dismissAction = action3;
            this.socialContext = socialContext;
            this.footer = str3;
            this.template = templateType;
            this.templateParameters = immutableMap;
            this.brandingImageParams = imageParameters3;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.title);
            parcel.writeString(this.content);
            parcel.writeParcelable(this.imageParams, i);
            parcel.writeParcelable(this.animatedImageParams, i);
            parcel.writeParcelable(this.primaryAction, i);
            parcel.writeParcelable(this.secondaryAction, i);
            parcel.writeParcelable(this.dismissAction, i);
            parcel.writeParcelable(this.socialContext, i);
            parcel.writeString(this.footer);
            parcel.writeString(this.template != null ? this.template.name() : TemplateType.UNKNOWN.name());
            parcel.writeMap(this.templateParameters);
            parcel.writeParcelable(this.brandingImageParams, i);
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = QuickPromotionDefinition_ContextualFilterDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public class ContextualFilter implements Parcelable {
        public static final Creator<ContextualFilter> CREATOR = new 1();
        @JsonProperty("extra_data")
        private final Map<String, String> extraData;
        @JsonProperty("passes_if_not_client_supported")
        public final boolean passIfNotSupported;
        @JsonProperty("type")
        private final Type type;
        @JsonProperty("value")
        public final String value;

        public ContextualFilter() {
            this.type = Type.UNKNOWN;
            this.passIfNotSupported = false;
            this.value = null;
            this.extraData = RegularImmutableBiMap.a;
        }

        public ContextualFilter(Parcel parcel) {
            boolean z = true;
            this.type = Type.valueOf(parcel.readString());
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.passIfNotSupported = z;
            this.value = parcel.readString();
            Map c = Maps.c();
            parcel.readMap(c, Map.class.getClassLoader());
            this.extraData = ImmutableMap.copyOf(c);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(m3677a().name());
            parcel.writeByte((byte) (this.passIfNotSupported ? 1 : 0));
            parcel.writeString(this.value);
            parcel.writeMap(m3678b());
        }

        public final Type m3677a() {
            return this.type != null ? this.type : Type.UNKNOWN;
        }

        public final Map<String, String> m3678b() {
            return this.extraData != null ? this.extraData : RegularImmutableBiMap.a;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @Immutable
    @JsonSerialize(using = Serializer.class)
    /* compiled from: request_ids */
    public class BooleanFilter implements Parcelable {
        public static final Creator<BooleanFilter> CREATOR = new 1();
        public final FilterClause f3446a;

        public BooleanFilter(FilterClause filterClause) {
            this.f3446a = filterClause;
        }

        public BooleanFilter(Parcel parcel) {
            this.f3446a = (FilterClause) parcel.readParcelable(FilterClause.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3446a, i);
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = QuickPromotionDefinition_ImageParametersDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public class ImageParameters implements Parcelable {
        public static final Creator<ImageParameters> CREATOR = new 1();
        @JsonProperty("height")
        public final int height;
        @JsonProperty("name")
        public final String name;
        @JsonProperty("scale")
        public final float scale;
        @JsonProperty("uri")
        public final String uri;
        @JsonProperty("width")
        public final int width;

        public ImageParameters() {
            this.uri = null;
            this.width = 0;
            this.height = 0;
            this.scale = 0.0f;
            this.name = null;
        }

        public ImageParameters(Parcel parcel) {
            this.uri = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            this.scale = parcel.readFloat();
            this.name = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uri);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeFloat(this.scale);
            parcel.writeString(this.name);
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = QuickPromotionDefinition_ActionDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public class Action implements Parcelable {
        public static final Creator<Action> CREATOR = new 1();
        @JsonProperty("dismiss_promotion")
        public final boolean dismissPromotion;
        @JsonProperty("limit")
        public final int limit;
        @JsonProperty("style")
        private final Style style;
        @JsonProperty("title")
        public final String title;
        @JsonProperty("url")
        public final String url;

        public Action() {
            this.style = Style.UNKNOWN;
            this.title = null;
            this.url = null;
            this.limit = 0;
            this.dismissPromotion = true;
        }

        public Action(Parcel parcel) {
            this.style = Style.fromString(parcel.readString());
            this.title = parcel.readString();
            this.url = parcel.readString();
            this.limit = parcel.readInt();
            this.dismissPromotion = parcel.readInt() != 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(m3679a().name());
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            parcel.writeInt(this.limit);
            parcel.writeInt(this.dismissPromotion ? 1 : 0);
        }

        public final Style m3679a() {
            return this.style != null ? this.style : Style.UNKNOWN;
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = QuickPromotionDefinition_SocialContextDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public class SocialContext implements Parcelable {
        public static final Creator<SocialContext> CREATOR = new 1();
        @JsonProperty("friend_ids")
        public final ImmutableList<String> friendIds;
        @JsonProperty("text")
        public final String text;

        public SocialContext() {
            this.text = null;
            this.friendIds = RegularImmutableList.a;
        }

        SocialContext(Parcel parcel) {
            this.text = parcel.readString();
            this.friendIds = ImmutableList.copyOf(parcel.createStringArrayList());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.text);
            parcel.writeStringList(this.friendIds);
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = QuickPromotionDefinition_TemplateTypeDeserializer.class)
    /* compiled from: request_ids */
    public enum TemplateType {
        ANDROID_FOOTER,
        TOAST_FOOTER,
        FEED_PYMK,
        INTERSTITIAL_1_BUTTON_X,
        INTERSTITIAL_2_BUTTON,
        ANDROID_MESSAGES_INTERSTITIAL_2_BUTTON,
        CARD,
        CARD_WITH_HEADER,
        FIG_DIALOG,
        MESSENGER_CARD,
        MESSENGER_CARD_NO_BADGE,
        STANDARD_MEGAPHONE,
        SEARCH_NULL_STATE_MEGAPHONE,
        SEARCH_BAR_TOOLTIP,
        DIVEBAR_HEADER_MEDIUM,
        MESSENGER_NEUE_NUX_INTERSTITIAL,
        ANDROID_MESSENGER_THREAD_LIST_HEADER_BANNER,
        ANDROID_MESSENGER_THREAD_LIST_HEADER_BUTTONLESS_BANNER,
        ANDROID_MESSENGER_THREAD_VIEW_HEADER_BANNER,
        ANDROID_MESSENGER_THREAD_VIEW_HEADER_BUTTONLESS_BANNER,
        ANDROID_MESSENGER_THREAD_VIEW_COMPOSER_BANNER,
        ANDROID_MESSENGER_THREAD_VIEW_COMPOSER_BUTTONLESS_BANNER,
        ANDROID_PAGER,
        MESSAGES_EMBEDDED_INTERSTITIAL,
        BRANDED_MEGAPHONE,
        SURVEY_MEGAPHONE,
        CUSTOM_RENDERED,
        UNKNOWN;

        @JsonCreator
        public static TemplateType fromString(String str) {
            if (str != null) {
                return valueOf(str.toUpperCase(Locale.US));
            }
            try {
                return UNKNOWN;
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = QuickPromotionDefinition_AttributeDeserializer.class)
    @Immutable
    /* compiled from: request_ids */
    public enum Attribute {
        IS_UNCANCELABLE,
        UNKNOWN;

        @JsonCreator
        public static Attribute fromString(String str) {
            if (str == null) {
                return UNKNOWN;
            }
            try {
                return valueOf(str.toUpperCase(Locale.US));
            } catch (IllegalArgumentException e) {
                return UNKNOWN;
            }
        }
    }

    public QuickPromotionDefinition() {
        this.promotionId = null;
        this.triggers = RegularImmutableList.a;
        this.creatives = RegularImmutableList.a;
        this.filters = RegularImmutableList.a;
        this.booleanFilter = null;
        this.title = null;
        this.content = null;
        this.imageParams = null;
        this.animatedImageParams = null;
        this.primaryAction = null;
        this.secondaryAction = null;
        this.dismissAction = null;
        this.socialContext = null;
        this.footer = null;
        this.template = TemplateType.UNKNOWN;
        this.templateParameters = RegularImmutableBiMap.a;
        this.priority = 0;
        this.maxImpressions = 0;
        this.viewerImpressions = -1;
        this.f3444b = RegularImmutableSet.a;
        this.startTime = 0;
        this.endTime = 0;
        this.clientTtlSeconds = 0;
        this.instanceLogData = RegularImmutableBiMap.a;
        this.isExposureHoldout = false;
        this.logEligibilityWaterfall = false;
        this.brandingImageParams = null;
        this.customRenderType = CustomRenderType.UNKNOWN;
    }

    public QuickPromotionDefinition(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.promotionId = parcel.readString();
        this.triggers = ImmutableList.copyOf(parcel.readArrayList(InterstitialTrigger.class.getClassLoader()));
        Collection a = Lists.a();
        parcel.readTypedList(a, Creative.CREATOR);
        this.creatives = ImmutableList.copyOf(a);
        a = Lists.a();
        parcel.readTypedList(a, ContextualFilter.CREATOR);
        this.filters = ImmutableList.copyOf(a);
        this.booleanFilter = (BooleanFilter) parcel.readParcelable(BooleanFilter.class.getClassLoader());
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.imageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
        this.animatedImageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
        this.primaryAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
        this.secondaryAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
        this.dismissAction = (Action) parcel.readParcelable(Action.class.getClassLoader());
        this.socialContext = (SocialContext) parcel.readParcelable(SocialContext.class.getClassLoader());
        this.footer = parcel.readString();
        this.template = TemplateType.fromString(parcel.readString());
        this.templateParameters = ImmutableMap.copyOf(parcel.readHashMap(null));
        this.priority = parcel.readLong();
        this.maxImpressions = parcel.readInt();
        this.viewerImpressions = parcel.readInt();
        this.f3444b = Sets.a(parcel.readArrayList(Attribute.class.getClassLoader()));
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.clientTtlSeconds = parcel.readLong();
        this.instanceLogData = ImmutableMap.copyOf(parcel.readHashMap(null));
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.isExposureHoldout = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.logEligibilityWaterfall = z2;
        this.brandingImageParams = (ImageParameters) parcel.readParcelable(ImageParameters.class.getClassLoader());
        this.customRenderType = CustomRenderType.fromString(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        List list;
        int i2 = 1;
        parcel.writeString(this.promotionId);
        parcel.writeList(m3668a());
        if (this.creatives != null) {
            list = this.creatives;
        } else {
            list = RegularImmutableList.a;
        }
        parcel.writeTypedList(list);
        parcel.writeTypedList(m3671d());
        parcel.writeParcelable(this.booleanFilter, i);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeParcelable(this.imageParams, i);
        parcel.writeParcelable(this.animatedImageParams, i);
        parcel.writeParcelable(this.primaryAction, i);
        parcel.writeParcelable(this.secondaryAction, i);
        parcel.writeParcelable(this.dismissAction, i);
        parcel.writeParcelable(this.socialContext, i);
        parcel.writeString(this.footer);
        parcel.writeString(m3672e().name());
        parcel.writeMap(this.templateParameters);
        parcel.writeLong(this.priority);
        parcel.writeInt(this.maxImpressions);
        parcel.writeInt(this.viewerImpressions);
        parcel.writeList(this.f3444b.asList());
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.clientTtlSeconds);
        parcel.writeMap(this.instanceLogData);
        parcel.writeByte((byte) (this.isExposureHoldout ? 1 : 0));
        if (!this.logEligibilityWaterfall) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeParcelable(this.brandingImageParams, i);
        parcel.writeString(m3674g().name());
    }

    @JsonProperty("attributes")
    public void readAttributes(List<Attribute> list) {
        this.f3444b = Sets.a(list);
    }

    @JsonProperty("attributes")
    ImmutableList<Attribute> getAttributesList() {
        return this.f3444b.asList();
    }

    public final List<InterstitialTrigger> m3668a() {
        return this.triggers != null ? this.triggers : RegularImmutableList.a;
    }

    @JsonIgnore
    public final ImmutableList<Creative> m3669b() {
        if (!this.creatives.isEmpty()) {
            return ImmutableList.copyOf(this.creatives);
        }
        if (this.f3443a == null) {
            this.f3443a = ImmutableList.of(new Creative(this.title, this.content, this.imageParams, this.animatedImageParams, this.primaryAction, this.secondaryAction, this.dismissAction, this.socialContext, this.footer, this.template, this.templateParameters, this.brandingImageParams));
        }
        return this.f3443a;
    }

    public final Creative m3670c() {
        return (Creative) m3669b().get(0);
    }

    public final List<ContextualFilter> m3671d() {
        return this.filters != null ? this.filters : RegularImmutableList.a;
    }

    public final TemplateType m3672e() {
        return this.template != null ? this.template : TemplateType.UNKNOWN;
    }

    public final ImmutableSet<Attribute> m3673f() {
        return this.f3444b != null ? this.f3444b : RegularImmutableSet.a;
    }

    public final CustomRenderType m3674g() {
        return this.customRenderType != null ? this.customRenderType : CustomRenderType.UNKNOWN;
    }

    public static boolean m3665a(QuickPromotionDefinition quickPromotionDefinition) {
        return TemplateType.ANDROID_MESSENGER_THREAD_LIST_HEADER_BUTTONLESS_BANNER.equals(quickPromotionDefinition.m3672e()) || TemplateType.ANDROID_MESSENGER_THREAD_VIEW_HEADER_BUTTONLESS_BANNER.equals(quickPromotionDefinition.m3672e()) || TemplateType.ANDROID_MESSENGER_THREAD_VIEW_COMPOSER_BUTTONLESS_BANNER.equals(quickPromotionDefinition.m3672e()) || TemplateType.SEARCH_BAR_TOOLTIP.equals(quickPromotionDefinition.m3672e());
    }

    public static boolean m3666b(QuickPromotionDefinition quickPromotionDefinition) {
        return TemplateType.SEARCH_BAR_TOOLTIP.equals(quickPromotionDefinition.m3672e());
    }

    public static boolean m3667c(QuickPromotionDefinition quickPromotionDefinition) {
        return TemplateType.SEARCH_BAR_TOOLTIP.equals(quickPromotionDefinition.m3672e());
    }
}

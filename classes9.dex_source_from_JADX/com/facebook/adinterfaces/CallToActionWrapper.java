package com.facebook.adinterfaces;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.graphql.enums.GraphQLCallToActionType;

/* compiled from: account_nux */
public enum CallToActionWrapper implements AdInterfacesCallToAction {
    GET_DIRECTIONS_WRAPPER(2131233923, 2131233930) {
        private String locationToUri(GeoLocationModel geoLocationModel) {
            String str = "fbgeo://" + geoLocationModel.m23442g() + "," + geoLocationModel.mN_();
            return geoLocationModel.m23437a() == null ? str : str + ", \"" + geoLocationModel.m23437a() + "\"";
        }

        public final boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21810d.contains(GraphQLCallToActionType.GET_DIRECTIONS);
        }

        public final String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            GeoLocationModel geoLocationModel = adInterfacesLocalAwarenessDataModel.f21807a;
            if (geoLocationModel != null) {
                return locationToUri(geoLocationModel);
            }
            geoLocationModel = adInterfacesLocalAwarenessDataModel.f21803h;
            if (geoLocationModel == null) {
                return null;
            }
            return locationToUri(geoLocationModel);
        }
    },
    CALL_NOW_WRAPPER(2131233926, 2131233931) {
        public final String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return "tel:" + adInterfacesLocalAwarenessDataModel.f21809c;
        }

        public final boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21810d.contains(GraphQLCallToActionType.CALL_NOW);
        }
    },
    SEND_MESSAGE_WRAPPER(2131233927, 2131233932) {
        public final String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21808b;
        }

        public final boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21810d.contains(GraphQLCallToActionType.MESSAGE_PAGE) && adInterfacesLocalAwarenessDataModel.f21811e;
        }
    },
    LEARN_MORE_WRAPPER(2131233928, 2131233934) {
        public final String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.mI_();
        }

        public final boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21810d.contains(GraphQLCallToActionType.LEARN_MORE);
        }
    },
    NO_BUTTON_WRAPPER(2131233925, 2131233933) {
        public final String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return null;
        }

        public final boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
            return adInterfacesLocalAwarenessDataModel.f21810d.contains(GraphQLCallToActionType.LIKE_PAGE);
        }
    };
    
    private Spanned mDescriptionText;
    private final int mDescriptionTextResourceId;
    private String mText;
    private final int mTextResourceId;

    /* compiled from: account_nux */
    /* synthetic */ class C24946 {
        static final /* synthetic */ int[] f21544a = null;

        static {
            f21544a = new int[GraphQLCallToActionType.values().length];
            try {
                f21544a[GraphQLCallToActionType.NO_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21544a[GraphQLCallToActionType.GET_DIRECTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21544a[GraphQLCallToActionType.CALL_NOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21544a[GraphQLCallToActionType.MESSAGE_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21544a[GraphQLCallToActionType.LEARN_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public CallToActionWrapper(int i, int i2) {
        this.mTextResourceId = i;
        this.mDescriptionTextResourceId = i2;
    }

    public static CallToActionWrapper fromGraphQLTypeCallToAction(GraphQLCallToActionType graphQLCallToActionType) {
        switch (C24946.f21544a[graphQLCallToActionType.ordinal()]) {
            case 1:
                return NO_BUTTON_WRAPPER;
            case 2:
                return GET_DIRECTIONS_WRAPPER;
            case 3:
                return CALL_NOW_WRAPPER;
            case 4:
                return SEND_MESSAGE_WRAPPER;
            case 5:
                return LEARN_MORE_WRAPPER;
            default:
                return NO_BUTTON_WRAPPER;
        }
    }

    public Spanned getDescriptionText(Context context) {
        Spanned spanned = null;
        if (this.mDescriptionTextResourceId == 0 || context == null) {
            return null;
        }
        if (this.mDescriptionText == null) {
            String string = context.getString(this.mDescriptionTextResourceId);
            if (string != null) {
                spanned = Html.fromHtml(string);
            }
            this.mDescriptionText = spanned;
        }
        return this.mDescriptionText;
    }

    public String getText(Context context) {
        if (this.mTextResourceId == 0 || context == null) {
            return null;
        }
        if (this.mText == null) {
            this.mText = context.getString(this.mTextResourceId);
        }
        return this.mText;
    }
}

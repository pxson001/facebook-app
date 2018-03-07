package com.facebook.groups.editing;

import android.os.Parcelable;
import com.facebook.graphql.enums.GraphQLGroupVisibility;

/* compiled from: failure getting picker button photo preview */
public interface GroupEditFragmentInterface<S extends Parcelable> {
    public static final GraphQLGroupVisibility c_ = GraphQLGroupVisibility.SECRET;

    /* compiled from: failure getting picker button photo preview */
    public interface GroupEditListener<S extends Parcelable> {
    }

    /* compiled from: failure getting picker button photo preview */
    public enum Stage {
        CHOOSE_PURPOSE,
        GROUP_SETUP,
        SELECT_PRIVACY,
        PHOTO_FLOW_CAMERA,
        PHOTO_FLOW_GALLERY,
        PHOTO_FLOW_SEARCH,
        ADD_MEMBERS,
        REVIEW,
        COMPLETE,
        UNKNOWN
    }

    /* compiled from: failure getting picker button photo preview */
    public enum Type {
        TYPE_EXISTING_GROUP,
        TYPE_CREATE_FLOW
    }
}

package com.facebook.friends.constants;

import javax.annotation.Nullable;

/* compiled from: me/friendrequests */
public enum FriendingLocation {
    EVENT_GYMK(FriendRequestHowFound.PROFILE_BROWSER_EVENTS, FriendRequestCancelRef.PROFILE_BROWSER_EVENTS, FriendRequestResponseRef.PROFILE_BROWSER_EVENTS, null, null),
    FEED_FRIENDABLE_HEADER(FriendRequestHowFound.FEED_FRIENDABLE_HEADER, FriendRequestCancelRef.FEED_FRIENDABLE_HEADER, FriendRequestResponseRef.FEED_FRIENDABLE_HEADER, null, null),
    FRIEND_FINDER(FriendRequestHowFound.CONTACT_IMPORTER, FriendRequestCancelRef.CONTACT_IMPORTER, null, null, null),
    FRIENDING_CARD(FriendRequestHowFound.FRIENDING_CARD, FriendRequestCancelRef.FRIENDING_CARD, FriendRequestResponseRef.FRIENDING_CARD, null, null),
    FRIENDING_RADAR(FriendRequestHowFound.FRIENDING_RADAR, FriendRequestCancelRef.FRIENDING_RADAR, FriendRequestResponseRef.FRIENDING_RADAR, null, RemoveFriendRef.FRIENDING_RADAR),
    FRIENDS_CENTER_FRIENDS(FriendRequestHowFound.FRIENDS_CENTER_FRIENDS, FriendRequestCancelRef.FRIENDS_CENTER_FRIENDS, FriendRequestResponseRef.FRIENDS_CENTER_FRIENDS, null, RemoveFriendRef.FRIENDS_CENTER_FRIENDS),
    FRIENDS_CENTER_OUTGOING_REQUESTS(FriendRequestHowFound.FRIENDS_CENTER_OUTGOING_REQUESTS_TAB, FriendRequestCancelRef.FRIENDS_CENTER_OUTGOING_REQUESTS_TAB, null, null, null),
    FRIENDS_CENTER_REQUESTS(FriendRequestHowFound.FRIENDS_CENTER_REQUESTS, FriendRequestCancelRef.FRIENDS_CENTER_REQUESTS, FriendRequestResponseRef.FRIENDS_CENTER_REQUESTS, null, RemoveFriendRef.FRIENDS_CENTER_REQUESTS),
    FRIENDS_CENTER_REQUESTS_PYMK(FriendRequestHowFound.FRIENDS_CENTER_SUGGESTIONS, FriendRequestCancelRef.FRIENDS_CENTER_SUGGESTIONS, null, PeopleYouMayKnowLocation.FRIENDS_CENTER, RemoveFriendRef.FRIENDS_CENTER_REQUESTS_PYMK),
    FRIENDS_CENTER_SEARCH(FriendRequestHowFound.FRIENDS_CENTER_SEARCH, FriendRequestCancelRef.FRIENDS_CENTER_SEARCH, FriendRequestResponseRef.FRIENDS_CENTER_SEARCH, null, RemoveFriendRef.FRIENDS_CENTER_SEARCH),
    FRIENDS_CENTER_SUGGESTIONS(FriendRequestHowFound.FRIENDS_CENTER_SUGGESTIONS, FriendRequestCancelRef.FRIENDS_CENTER_SUGGESTIONS, null, PeopleYouMayKnowLocation.FRIENDS_CENTER, RemoveFriendRef.FRIENDS_CENTER_SUGGESTIONS),
    JEWEL(FriendRequestHowFound.PYMK, FriendRequestCancelRef.PYMK_JEWEL, FriendRequestResponseRef.MOBILE_JEWEL, PeopleYouMayKnowLocation.JEWEL, null),
    NEARBY_FRIENDS(FriendRequestHowFound.NEARBY_FRIENDS, FriendRequestCancelRef.NEARBY_FRIENDS, FriendRequestResponseRef.NEARBY_FRIENDS, null, RemoveFriendRef.NEARBY_FRIENDS),
    NUX(FriendRequestHowFound.PYMK_NUX, FriendRequestCancelRef.PYMK_NUX, FriendRequestResponseRef.NUX, PeopleYouMayKnowLocation.NUX, null),
    PROFILE_BROWSER(FriendRequestHowFound.PROFILE_BROWSER, FriendRequestCancelRef.PROFILE_BROWSER_LIKES, FriendRequestResponseRef.PROFILE_BROWSER, null, RemoveFriendRef.PROFILE_BROWSER),
    PYMK_FEED(FriendRequestHowFound.NETEGO_PYMK, FriendRequestCancelRef.PYMK_FEED, FriendRequestResponseRef.PYMK_FEED, PeopleYouMayKnowLocation.FEED, RemoveFriendRef.PYMK_FEED),
    PYMK_TIMELINE(FriendRequestHowFound.PYMK, FriendRequestCancelRef.TIMELINE_FRIENDS_COLLECTION, null, PeopleYouMayKnowLocation.SELF_PROFILE, RemoveFriendRef.TIMELINE_FRIENDS_COLLECTION),
    PYMK_FRIEND_FINDER(FriendRequestHowFound.CI_PYMK, FriendRequestCancelRef.PYMK_CI, null, null, null),
    QR_CODE(FriendRequestHowFound.ENTITY_CARDS, FriendRequestCancelRef.QR_CODE, FriendRequestResponseRef.QR_CODE, null, RemoveFriendRef.QR_CODE),
    QUICK_PROMOTION(FriendRequestHowFound.PYMK, FriendRequestCancelRef.PYMK_QUICK_PROMOTION, FriendRequestResponseRef.QUICK_PROMOTION, PeopleYouMayKnowLocation.QUICK_PROMOTION, null),
    SEARCH(FriendRequestHowFound.SEARCH, FriendRequestCancelRef.SEARCH, FriendRequestResponseRef.SEARCH, null, null),
    FRIENDS_TAB(FriendRequestHowFound.FRIENDS_TAB, FriendRequestCancelRef.FRIENDS_TAB, FriendRequestResponseRef.FRIENDS_TAB, null, RemoveFriendRef.FRIENDS_TAB),
    PROTILES(FriendRequestHowFound.PROFILE_FRIENDS_BOX, FriendRequestCancelRef.FRIEND_LIST_PROFILE, FriendRequestResponseRef.FRIEND_LIST_PROFILE, null, null);
    
    public final FriendRequestCancelRef friendRequestCancelRef;
    public final FriendRequestHowFound friendRequestHowFound;
    public final FriendRequestResponseRef friendRequestResponseRef;
    public final PeopleYouMayKnowLocation peopleYouMayKnowLocation;
    public final RemoveFriendRef removeFriendRef;

    private FriendingLocation(FriendRequestHowFound friendRequestHowFound, FriendRequestCancelRef friendRequestCancelRef, FriendRequestResponseRef friendRequestResponseRef, PeopleYouMayKnowLocation peopleYouMayKnowLocation, @Nullable RemoveFriendRef removeFriendRef) {
        this.friendRequestHowFound = friendRequestHowFound;
        this.friendRequestCancelRef = friendRequestCancelRef;
        this.friendRequestResponseRef = friendRequestResponseRef;
        this.peopleYouMayKnowLocation = peopleYouMayKnowLocation;
        this.removeFriendRef = removeFriendRef;
    }
}

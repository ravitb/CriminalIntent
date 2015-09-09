package com.ravit.android.criminalintent;

import java.util.UUID;

/**
 * Created by ravit on 08/09/15.
 */
public class Crime {

    public UUID getId() {
        return mId;
    }

    private UUID mId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    private String mTitle;

    public Crime() {
        // Generate unique identifier
        mId = UUID.randomUUID();
    }
}

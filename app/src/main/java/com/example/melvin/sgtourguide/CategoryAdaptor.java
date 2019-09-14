package com.example.melvin.sgtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Melvin on 5/11/2017.
 */

public class CategoryAdaptor extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdaptor} object.
     *@param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdaptor(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalFragment();
        } else if (position == 1) {
            return new EventsFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new CulturalFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_historical);
        } else if (position == 1) {
            return mContext.getString(R.string.category_events);
        } else if (position == 2) {
            return mContext.getString(R.string.category_food);
        } else {
                return mContext.getString(R.string.category_culture);
        }
    }
}

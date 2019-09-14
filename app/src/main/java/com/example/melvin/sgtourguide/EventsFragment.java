package com.example.melvin.sgtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        //Create a list of attractions
        ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.Chingay,R.string.Chingay_Desc));
        attractions.add(new Attraction(R.string.Thaipusam,R.string.Thaipusam_Desc));
        attractions.add(new Attraction(R.string.Zoukout,R.string.Zoukout_Desc));

        // Create an {@link AttractionsAdapter}, whose data source is a list of {@link Attractions}s. The
        // adapter knows how to create list items for each item in the list.
        AttractionsAdaptor adaptor = new AttractionsAdaptor (getActivity(), attractions, R.color.category_events);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attractions_list.xml layout file.
        ListView listView = (ListView)rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adaptor);

        return rootView;
    }

}

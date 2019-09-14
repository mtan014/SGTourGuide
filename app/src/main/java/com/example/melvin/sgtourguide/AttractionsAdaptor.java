package com.example.melvin.sgtourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Melvin on 29/10/2017.
 */

public class AttractionsAdaptor extends ArrayAdapter<Attraction> {

    /** Resource ID for the background color for this list of attractions */
    private int mColorResourceId;

    /**
     * Create a new {@link AttractionsAdaptor} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param attractions is the list of {@link Attraction}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of attractions
     */
    public AttractionsAdaptor(Context context, ArrayList<Attraction> attractions, int colorResourceId) {
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        // Get the {@link String} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID attractions_view.
        TextView attractionTextView = (TextView)listItemView.findViewById(R.id.attractions_view);
        // Get the attraction name from the currentAttraction object and set this text on
        // the attraction view.
        attractionTextView.setText(currentAttraction.getAttractionName());

        // Find the TextView in the list_item.xml layout with the ID description_view.
        TextView descriptionTextView = (TextView)listItemView.findViewById(R.id.description_view);
        // Get the attraction description from the currentAttraction object and set this text on
        // the description view.
        descriptionTextView.setText(currentAttraction.getAttractionDescription());

        // Find the ImageView in the list.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this attraction or not
        if (currentAttraction.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentAttraction.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else  {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing TextView) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

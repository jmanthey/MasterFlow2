package com.example.android.masterflow2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.android.masterflow2.listData.SiteList;

/**
 * A fragment representing a single Website detail screen.
 * This fragment is either contained in a {@link WebsiteListActivity}
 * in two-pane mode (on tablets) or a {@link WebsiteDetailActivity}
 * on handsets.
 */
public class WebsiteDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy website_name this fragment is presenting.
     */
    private SiteList.SiteItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WebsiteDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy website_name specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load website_name from a website_name provider.
            mItem = SiteList.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.website_name);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.website_detail, container, false);

        // Show the dummy website_name as text in a TextView.
        if (mItem != null) {
//            ((TextView) rootView.findViewById(R.id.website_detail)).setText(mItem.website_url);
            ((WebView) rootView.findViewById(R.id.website_detail)).loadUrl(mItem.website_url);
        }

        return rootView;
    }
}

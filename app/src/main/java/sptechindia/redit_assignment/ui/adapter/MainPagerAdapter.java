package sptechindia.redit_assignment.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import sptechindia.redit_assignment.ui.home.profile.about.AboutFragment;
import sptechindia.redit_assignment.ui.home.profile.comment.CommentFragment;
import sptechindia.redit_assignment.ui.home.profile.post.PostFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

	CharSequence Titles[];
	int          NumbOfTabs;

	public MainPagerAdapter( FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb ) {
		super( fm );
		this.Titles = mTitles;
		this.NumbOfTabs = mNumbOfTabsumb;
	}

	@Override
	public Fragment getItem( int position ) {

		Fragment fragment = null;

		switch ( position ) {
			case 0:
				fragment = PostFragment.newInstance();
				break;
			case 1:
				fragment = CommentFragment.newInstance();
				break;
			case 2:
				fragment = AboutFragment.newInstance();
				break;
		}
		return fragment;
	}

	// This method return the titles for the Tabs in the Tab Strip

	@Override
	public CharSequence getPageTitle( int position ) {
		return Titles[position];
	}

	// This method return the Number of tabs for the tabs Strip

	@Override
	public int getCount() {
		return NumbOfTabs;
	}
}
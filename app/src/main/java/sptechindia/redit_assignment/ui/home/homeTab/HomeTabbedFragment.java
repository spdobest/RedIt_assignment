package sptechindia.redit_assignment.ui.home.homeTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;


/**
 * Created by sibaprasad on 22/12/16.
 */

public class HomeTabbedFragment extends BaseFragment {
	public static final String TAG = "HomeTabbedFragment";
	private RecyclerView rootRecycler;

	public static HomeTabbedFragment newInstance(  ) {

		Bundle args = new Bundle();

		HomeTabbedFragment fragment = new HomeTabbedFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
		rootRecycler = ( RecyclerView ) inflater.inflate(
				R.layout.fragment_hometabbed, container, false );
		setupRecyclerView( rootRecycler );
		setLayout( R.layout.fragment_hometabbed );
		return rootRecycler;
	}

	@Override
	public void initView( View rootView ) {

	}

	@Override
	public void setClickListener() {

	}

	private void setupRecyclerView( RecyclerView recyclerView ) {
		recyclerView.setLayoutManager( new LinearLayoutManager( recyclerView.getContext() ) );
		 	}

	private List< String > getRandomSublist( String[] array, int amount ) {
		ArrayList< String > list   = new ArrayList<>( amount );
		Random              random = new Random();
		while ( list.size() < amount ) {
			list.add( array[random.nextInt( array.length )] );
		}
		return list;
	}

}
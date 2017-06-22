package sptechindia.redit_assignment.ui.home.popular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class PopularTabbedFragment extends BaseFragment {

	//
	View rootView;

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_popular, container, false );
		setLayout( R.layout.fragment_popular );
		initView( rootView );
		setClickListener();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {

	}

	@Override
	public void setClickListener() {

	}
}

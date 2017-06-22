package sptechindia.redit_assignment.ui.home.profile.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.ui.adapter.CommonRecycleAdapter;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class PostFragment extends BaseFragment {
	private static final String TAG = "PostFragment";

	View rootView;
	RecyclerView recycler_view;

	public static PostFragment newInstance() {

		Bundle args = new Bundle();

		PostFragment fragment = new PostFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_recyclerview, container, false );
		setLayout( R.layout.fragment_recyclerview );
		initView( rootView );
		setClickListener();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {
		recycler_view = ( RecyclerView ) rootView.findViewById( R.id.recycler_view );

		setUPList();
	}

	@Override
	public void setClickListener() {

	}

	void setUPList(){
		recycler_view.setLayoutManager(new LinearLayoutManager( getActivity()));
		CommonRecycleAdapter adapter = new CommonRecycleAdapter( createItemList());
		recycler_view.setAdapter(adapter);
	}

	private List<String> createItemList() {
		List<String> itemList = new ArrayList<>();
		for(int i=0;i<30;i++) {
			itemList.add("Item "+i);
		}
		return itemList;
	}

}

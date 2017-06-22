package sptechindia.redit_assignment.ui.home.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.ui.adapter.CommonRecycleAdapter;
import sptechindia.redit_assignment.ui.adapter.SortListAdapter;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class EmailFragment extends BaseFragment implements View.OnClickListener {

	private static final String TAG = "EmailFragment";

	Toolbar            toolbarCommunities;
	SortListAdapter    sortListAdapter;
	String[]           sortNames;
	//
	View               rootView;
	int                sortListPosition;
	AppCompatImageView imageViewSort;
	RecyclerView       recycler_view;
	private BottomSheetDialog bottomSheetDialog;

	public static EmailFragment newInstance() {

		Bundle args = new Bundle();

		EmailFragment fragment = new EmailFragment();
		fragment.setArguments( args );
		return fragment;
	}

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );

		sortNames = getResources().getStringArray( R.array.profileTabnemes );
	}

	@Nullable
	@Override
	public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
		rootView = inflater.inflate( R.layout.fragment_communities, container, false );
		setLayout( R.layout.fragment_popular );
		initView( rootView );
		setClickListener();
		return rootView;
	}

	@Override
	public void initView( View rootView ) {
		toolbarCommunities = ( Toolbar ) rootView.findViewById( R.id.toolbarCommunities );
		toolbarCommunities.setTitle( getActivity().getResources().getString( R.string.communities ) );
		imageViewSort = ( AppCompatImageView ) rootView.findViewById( R.id.imageViewSort );
		( ( AppCompatTextView ) rootView.findViewById( R.id.textViewToolbar ) ).setText( "Emails" );
		recycler_view = ( RecyclerView ) rootView.findViewById( R.id.recycler_view );

		setUPList();
	}

	@Override
	public void setClickListener() {
		imageViewSort.setOnClickListener( this );
	}

	protected void openSortBottomSheetDialog() {
		ListView       listviewSort;
		List< String > stringList = new ArrayList< String >( Arrays.asList( sortNames ) );

		if ( bottomSheetDialog == null ) {
			bottomSheetDialog = new BottomSheetDialog( getActivity() );
		}

		bottomSheetDialog.setContentView( R.layout.bottomsheet_sort );
		listviewSort = ( ListView ) bottomSheetDialog.findViewById( R.id.listviewSort );

		sortListAdapter = new SortListAdapter( getActivity(), stringList );
		sortListAdapter.setSelectedRow( sortListPosition );
		listviewSort.setAdapter( sortListAdapter );
		listviewSort.setOnItemClickListener( new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick( AdapterView< ? > adapterView, View view, int i, long l ) {
				sortListPosition = i;
				sortListAdapter.setSelectedRow( sortListPosition );
				bottomSheetDialog.dismiss();
			}
		} );
		Log.i( TAG, "openSortBottomSheetDialog: " );

		bottomSheetDialog.show();

	}

	@Override
	public void onClick( View view ) {
		switch ( view.getId() ) {
			case R.id.imageViewSort:
				openSortBottomSheetDialog();
				break;
		}
	}

	void setUPList() {
		recycler_view.setLayoutManager( new LinearLayoutManager( getActivity() ) );
		CommonRecycleAdapter adapter = new CommonRecycleAdapter( createItemList() );
		recycler_view.setAdapter( adapter );
	}

	private List< String > createItemList() {
		List< String > itemList = new ArrayList<>();
		for ( int i = 0; i < 30; i++ ) {
			itemList.add( "Item " + i );
		}
		return itemList;
	}
}

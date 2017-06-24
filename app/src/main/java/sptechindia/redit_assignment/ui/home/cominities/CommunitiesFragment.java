package sptechindia.redit_assignment.ui.home.cominities;

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
import sptechindia.redit_assignment.adapter.CommonRecyclerAdapter;
import sptechindia.redit_assignment.adapter.SortListAdapter;
import sptechindia.redit_assignment.base.BaseFragment;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.ModelText;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 22/06/17.
 */

public class CommunitiesFragment extends BaseFragment implements View.OnClickListener,OnRecyclerItemClickListener {

	public static final String TAG = "CommunitiesFragment";
	Toolbar               toolbarCommunities;
	// widgut declaration
	SortListAdapter       sortListAdapter;
	String[]              sortNames;
	//
	View                  rootView;
	int                   sortListPosition;
	AppCompatImageView    imageViewSort;
	AppCompatImageView    imageViewBackToolbar;
	AppCompatTextView     textViewTitleToolbarWithBack;
	AppCompatImageView    imageViewShare;
	RecyclerView          recycler_view;
	CommonRecyclerAdapter commonRecyclerAdapter;
	private List< Object > listData = new ArrayList<>();
	private BottomSheetDialog bottomSheetDialog;

	public static CommunitiesFragment newInstance() {

		Bundle args = new Bundle();

		CommunitiesFragment fragment = new CommunitiesFragment();
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
		toolbarCommunities = ( Toolbar ) rootView.findViewById( R.id.toolbarWithTitleAndBack );
		imageViewBackToolbar = ( AppCompatImageView ) rootView.findViewById( R.id.imageViewBackToolbar );
		textViewTitleToolbarWithBack = ( AppCompatTextView ) rootView.findViewById( R.id.textViewTitleToolbarWithBack );
		imageViewShare = ( AppCompatImageView ) rootView.findViewById( R.id.imageViewShare );
		textViewTitleToolbarWithBack.setText( getActivity().getResources().getString( R.string.communities ) );
		imageViewSort = ( AppCompatImageView ) rootView.findViewById( R.id.imageViewSort );
		recycler_view = ( RecyclerView ) rootView.findViewById( R.id.recycler_view );
		imageViewBackToolbar.setVisibility( View.GONE );
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
		createItemList();
//		CommonRecycleAdapter adapter = new CommonRecycleAdapter( createItemList());
//		recycler_view.setAdapter(adapter);
	}

	private void createItemList() {

		listData.add( new ModelText( "All", Constants.ROW_TEXT ) );
		listData.add( new ModelText( "MULTIS", Constants.ROW_TEXT ) );
		listData.add( new ModelText( "FOLLOWING", Constants.ROW_TEXT ) );
		listData.add( new ModelText( "SUBSCRIPTION", Constants.ROW_TEXT ) );
		listData.add( new ModelText( "MODERATING", Constants.ROW_TEXT ) );


		commonRecyclerAdapter = new CommonRecyclerAdapter( listData, Constants.ROW_TEXT,true ,this);
		recycler_view.setAdapter( commonRecyclerAdapter );
	}

	@Override
	public void onCommentClick( Child child ) {

	}

	@Override
	public void onFeedClick( Child child ) {

	}

	@Override
	public void onShareClick( Child child ) {

	}

	@Override
	public void onUpClick( Child child ) {

	}

	@Override
	public void onDownClick( Child child ) {

	}
}

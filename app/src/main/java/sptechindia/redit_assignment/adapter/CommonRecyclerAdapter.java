package sptechindia.redit_assignment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderDefault;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderFooter;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderHeader;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderImage;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderImageWithText;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderManager;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderMessage;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderPopularGif;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderPopularImage;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderPopularImageWithText;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderPopularText;
import sptechindia.redit_assignment.adapter.viewholder.ViewHolderVideo;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.ModelHeader;
import sptechindia.redit_assignment.model.ModelText;
import sptechindia.redit_assignment.model.ModelVideo;
import sptechindia.redit_assignment.model.home.Child;
import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class CommonRecyclerAdapter extends RecyclerView.Adapter< RecyclerView.ViewHolder > {

	private static final String TAG = "CommonRecyclerViewAdapt";

	int rowType = -1;
	List< Object > objectList;
	boolean        isRowPreFixed;

	OnRecyclerItemClickListener onRecyclerItemClickListener;
	int visiblePosition = -1;


	public CommonRecyclerAdapter( List< Object > objectList, int rowType, boolean isRowPreFixed, OnRecyclerItemClickListener onRecyclerItemClickListener ) {
		super();
		this.objectList = objectList;
		this.rowType = rowType;
		this.isRowPreFixed = isRowPreFixed;
		this.onRecyclerItemClickListener = onRecyclerItemClickListener;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		RecyclerView.ViewHolder holder = null;

		View           view;
		LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
		switch ( viewType ) {

			case Constants.ROW_HEADER:

				view = inflater
						.inflate( R.layout.row_item_header, parent, false );
				holder = new ViewHolderHeader( view );

				break;

			case Constants.ROW_FOOTER:
				view = inflater
						.inflate( R.layout.row_item_footer, parent, false );
				holder = new ViewHolderFooter( view );

				break;
			case Constants.ROW_POPULAR_IMAGE:

				view = inflater
						.inflate( R.layout.row_item_popular_image, parent, false );
				holder = new ViewHolderPopularImage( view );

				break;

			case Constants.ROW_POPULAR_IMAGE_WITH_TEXT:

				view = inflater
						.inflate( R.layout.row_item_popular_image_with_text, parent, false );
				holder = new ViewHolderPopularImageWithText( view );

				break;

			case Constants.ROW_POPULAR_GIF:

				view = inflater
						.inflate( R.layout.row_item_popular_gif, parent, false );
				holder = new ViewHolderPopularGif( view );

				break;

			case Constants.ROW_POPULAR_TEXT:

				view = inflater
						.inflate( R.layout.row_item_popular_messge, parent, false );
				holder = new ViewHolderPopularText( view );

				break;
			case Constants.ROW_MESSAGE:
				view = inflater
						.inflate( R.layout.row_item_message, parent, false );
				holder = new ViewHolderMessage( view );

				break;
			case Constants.ROW_TEXT:
				view = inflater
						.inflate( R.layout.row_item_text, parent, false );
				holder = new ViewHolderText( view );

				break;
			case Constants.ROW_IMAGE_WITH_TEXT:
				view = inflater
						.inflate( R.layout.row_item_image_text, parent, false );
				holder = new ViewHolderImageWithText( view );
				break;
			case Constants.ROW_VIDEO:
				view = inflater
						.inflate( R.layout.row_item_video, parent, false );
				holder = new ViewHolderVideo( view );
				break;

			case Constants.ROW_IMAGE:
				view = inflater
						.inflate( R.layout.row_item_image, parent, false );
				holder = new ViewHolderImage( view );
				break;

			default:
				view = inflater
						.inflate( R.layout.row_item_default, parent, false );

				holder = new ViewHolderDefault( view );
		}

		return holder;
	}

	@Override
	public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ) {

		Object object = objectList.get( position );

		switch ( holder.getItemViewType() ) {
			case Constants.ROW_HEADER:
				final ViewHolderHeader viewHolderHeader = ( ViewHolderHeader ) holder;
				ModelHeader modelHeader = ( ModelHeader ) object;
				viewHolderHeader.setData( modelHeader );

				break;
			case Constants.ROW_FOOTER:
				final ViewHolderFooter viewHolderFooter = ( ViewHolderFooter ) holder;

				break;
			case Constants.ROW_POPULAR_IMAGE_WITH_TEXT:
				final ViewHolderPopularImageWithText viewHolderPopularImageWithText = ( ViewHolderPopularImageWithText ) holder;

				final Child child = ( Child ) object;


				viewHolderPopularImageWithText.textViewComments.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onCommentClick( child );
					}
				} );

				viewHolderPopularImageWithText.textViewShare.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child );
					}
				} );

				viewHolderPopularImageWithText.imageViewDown.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child );
					}
				} );

				viewHolderPopularImageWithText.itemView.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onFeedClick( child );
					}
				} );

				break;
			case Constants.ROW_POPULAR_GIF:
				final ViewHolderPopularGif viewHolderPopularGif = ( ViewHolderPopularGif ) holder;
				final Child childDataVideo = ( Child ) object;
				viewHolderPopularGif.setData( childDataVideo );

				viewHolderPopularGif.textViewComments.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onCommentClick( childDataVideo );
					}
				} );

				viewHolderPopularGif.textViewShare.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( childDataVideo );
					}
				} );

				viewHolderPopularGif.imageViewDown.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( childDataVideo );
					}
				} );

				viewHolderPopularGif.itemView.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onFeedClick( childDataVideo );
					}
				} );

				break;
			case Constants.ROW_POPULAR_IMAGE:
				final ViewHolderPopularImage viewHolderPopularImage = ( ViewHolderPopularImage ) holder;

				final Child childData = ( Child ) object;

				viewHolderPopularImage.setData( childData );

				viewHolderPopularImage.textViewComments.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onCommentClick( childData );
					}
				} );

				viewHolderPopularImage.textViewShare.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( childData );
					}
				} );

				viewHolderPopularImage.imageViewDown.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( childData );
					}
				} );

				viewHolderPopularImage.itemView.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onFeedClick( childData );
					}
				} );

				break;
			case Constants.ROW_POPULAR_TEXT:
				final ViewHolderPopularText viewHolderPopularText = ( ViewHolderPopularText ) holder;

				break;
			case Constants.ROW_MESSAGE:
				final ViewHolderMessage viewHolderMessage = ( ViewHolderMessage ) holder;
				viewHolderMessage.layoutFooterToolbar.setVisibility( View.GONE );
				break;
			case Constants.ROW_TEXT:
				final ViewHolderText viewHolderText = ( ViewHolderText ) holder;

				ModelText modelText = ( ModelText ) object;
				viewHolderText.textViewMessageItem.setText( modelText.textTitle );

				break;
			case Constants.ROW_IMAGE_WITH_TEXT:
				final ViewHolderImageWithText viewHolderImageWithText = ( ViewHolderImageWithText ) holder;

				break;
			case Constants.ROW_IMAGE:
				final ViewHolderImage viewHolderImage = ( ViewHolderImage ) holder;
				viewHolderImage.setData( object );

				break;
			case Constants.ROW_VIDEO:
				final ViewHolderVideo viewHolderVideo = ( ViewHolderVideo ) holder;
				ModelVideo modelVideo = ( ModelVideo ) object;
				viewHolderVideo.setData( modelVideo );
				if ( position == visiblePosition ) {
					viewHolderVideo.setupVideoView();
				}

				break;
			case Constants.ROW_DEFAULT:
				final ViewHolderDefault viewHolderDefault = ( ViewHolderDefault ) holder;
				break;
		}

	}

	@Override
	public int getItemViewType( int position ) {
		int TYPE = 0;
		if ( isRowPreFixed ) {
			return rowType;
		}
		else {
			rowType = ViewHolderManager.getRowType( objectList.get( position ) );
		}
		return rowType;
	}

	@Override
	public int getItemCount() {
		return objectList.size();
	}

	public void setVisiblePosition( int completelyVisibleposition ) {
		this.visiblePosition = completelyVisibleposition;
		notifyDataSetChanged();
	}
}

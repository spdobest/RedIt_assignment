package sptechindia.redit_assignment.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.controllers.OnRecyclerItemClickListener;
import sptechindia.redit_assignment.model.ModelHeader;
import sptechindia.redit_assignment.model.ModelImage;
import sptechindia.redit_assignment.model.ModelImageText;
import sptechindia.redit_assignment.model.ModelMessage;
import sptechindia.redit_assignment.model.ModelText;
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

			case Constants.ROW_POPULAR_VIDEO:

				view = inflater
						.inflate( R.layout.row_item_popular_gif, parent, false );
				holder = new ViewHolderVideo( view );

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

				viewHolderHeader.textViewNameHeader.setText( modelHeader.textTitle );
				viewHolderHeader.textViewCommentHeader.setText( modelHeader.comment );
				break;
			case Constants.ROW_FOOTER:
				final ViewHolderFooter viewHolderFooter = ( ViewHolderFooter ) holder;

				break;
			case Constants.ROW_POPULAR_IMAGE_WITH_TEXT:
				final ViewHolderPopularImageWithText viewHolderPopularImageWithText = ( ViewHolderPopularImageWithText ) holder;

				final Child child = ( Child ) object;

				viewHolderPopularImageWithText.textViewTitleImageWithText.setText( child.getData().getTitle() );
				viewHolderPopularImageWithText.textViewUpDownCount.setText( "" + child.getData().getViewCount() );
				viewHolderPopularImageWithText.textViewPopularFeedName.setText( child.getData().getName() );

				if ( child != null && child.getData() != null && child.getData().getPreview() != null && child.getData().getPreview().getImages() != null && child.getData().getPreview().getImages().size() > 0 ) {

					Glide.with( viewHolderPopularImageWithText.imageViewImageWithText.getContext() ).load( child.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderPopularImageWithText.imageViewImageWithText );
				}
				else {
					Glide.with( viewHolderPopularImageWithText.imageViewImageWithText.getContext() ).load( child.getData().getThumbnail() )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderPopularImageWithText.imageViewImageWithText );
				}

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
			case Constants.ROW_POPULAR_VIDEO:
				final ViewHolderVideo viewHolderVideo = ( ViewHolderVideo ) holder;
				final Child child3 = ( Child ) object;

				viewHolderVideo.textViewPopularTitle.setText( child3.getData().getTitle() );
				viewHolderVideo.textViewUpDownCount.setText( "" + child3.getData().getViewCount() );
				viewHolderVideo.textViewPopularFeedName.setText( child3.getData().getName() );

				if ( child3 != null && child3.getData() != null && child3.getData().getPreview() != null && child3.getData().getPreview().getImages() != null && child3.getData().getPreview().getImages().size() > 0 ) {

					Glide.with( viewHolderVideo.imageViewPopular.getContext() ).load( child3.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderVideo.imageViewPopular );
				}
				else {
					Glide.with( viewHolderVideo.imageViewPopular.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderVideo.imageViewPopular );
				}


				viewHolderVideo.textViewComments.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onCommentClick( child3 );
					}
				} );

				viewHolderVideo.textViewShare.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child3 );
					}
				} );

				viewHolderVideo.imageViewDown.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child3 );
					}
				} );

				viewHolderVideo.itemView.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onFeedClick( child3 );
					}
				} );

				break;
			case Constants.ROW_POPULAR_IMAGE:
				final ViewHolderPopularImage viewHolderPopularImage = ( ViewHolderPopularImage ) holder;

				final Child child1 = ( Child ) object;

				viewHolderPopularImage.textViewPopularTitle.setText( child1.getData().getName() );
				viewHolderPopularImage.textViewUpDownCount.setText( "" + child1.getData().getViewCount() );
				viewHolderPopularImage.textViewPopularFeedName.setText( child1.getData().getTitle() );

				if ( child1 != null && child1.getData() != null && child1.getData().getPreview() != null && child1.getData().getPreview().getImages() != null && child1.getData().getPreview().getImages().size() > 0 ) {

					Glide.with( viewHolderPopularImage.imageViewPopular.getContext() ).load( child1.getData().getPreview().getImages().get( 0 ).getSource().getUrl() )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderPopularImage.imageViewPopular );
				}
				else {
					Glide.with( viewHolderPopularImage.imageViewPopular.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
							.thumbnail( 0.5f )
							.crossFade()
							.diskCacheStrategy( DiskCacheStrategy.ALL )
							.into( viewHolderPopularImage.imageViewPopular );
				}


				viewHolderPopularImage.textViewComments.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onCommentClick( child1 );
					}
				} );

				viewHolderPopularImage.textViewShare.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child1 );
					}
				} );

				viewHolderPopularImage.imageViewDown.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onShareClick( child1 );
					}
				} );

				viewHolderPopularImage.itemView.setOnClickListener( new View.OnClickListener() {
					@Override
					public void onClick( View view ) {
						onRecyclerItemClickListener.onFeedClick( child1 );
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
				Glide.with( viewHolderImage.imageViewItem.getContext() ).load( "http://www.gstatic.com/webp/gallery/1.jpg" )
						.thumbnail( 0.5f )
						.crossFade()
						.diskCacheStrategy( DiskCacheStrategy.ALL )
						.into( viewHolderImage.imageViewItem );

				break;
			case Constants.ROW_VIDEO:
				final ViewHolderVideo viewHolderVideo1 = ( ViewHolderVideo ) holder;

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
			Object object = objectList.get( position );

			if ( object instanceof ModelText ) {
				rowType = Constants.ROW_TEXT;
			}
			else if ( object instanceof ModelImageText ) {
				rowType = Constants.ROW_IMAGE_WITH_TEXT;
			}
			else if ( object instanceof ModelMessage ) {
				rowType = Constants.ROW_MESSAGE;
			}
			else if ( object instanceof ModelImage ) {
				rowType = Constants.ROW_IMAGE;
			}
			else if ( object instanceof Child ) {
				Child feedData = ( Child ) object;

				if ( feedData != null && feedData.getData() != null && feedData.getData().getPreview() != null && feedData.getData().getPreview().getImages() != null && feedData.getData().getPreview().getImages().size() > 0 ) {
					rowType = Constants.ROW_POPULAR_VIDEO;
				}
				else {
					rowType = Constants.ROW_POPULAR_IMAGE_WITH_TEXT;
				}
			}
			else if ( object instanceof ModelImage ) {
				rowType = 3;
			}
			else if ( object instanceof ModelImage ) {
				rowType = 3;
			}

		}
		return rowType;
	}

	@Override
	public int getItemCount() {
		return objectList.size();
	}


	public class ViewHolderHeader extends RecyclerView.ViewHolder {
		@Bind( R.id.textViewName_header )
		AppCompatTextView textViewNameHeader;
		@Bind( R.id.textViewComment_header )
		AppCompatTextView textViewCommentHeader;

		public ViewHolderHeader( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderPopularImageWithText extends RecyclerView.ViewHolder {
		@Bind( R.id.profile_image )
		CircleImageView    profileImage;
		@Bind( R.id.textViewPopularFeedName )
		AppCompatTextView  textViewPopularFeedName;
		@Bind( R.id.textViewPopularTime )
		AppCompatTextView  textViewPopularTime;
		@Bind( R.id.textViewTitleImageWithText )
		AppCompatTextView  textViewTitleImageWithText;
		@Bind( R.id.imageViewImageWithText )
		AppCompatImageView imageViewImageWithText;
		@Bind( R.id.imageViewUp )
		AppCompatImageView imageViewUp;
		@Bind( R.id.textViewUpDownCount )
		AppCompatTextView  textViewUpDownCount;
		@Bind( R.id.imageViewDown )
		AppCompatImageView imageViewDown;
		@Bind( R.id.textViewComments )
		AppCompatTextView  textViewComments;
		@Bind( R.id.textViewShare )
		AppCompatTextView  textViewShare;

		public ViewHolderPopularImageWithText( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderFooter extends RecyclerView.ViewHolder {

		public ViewHolderFooter( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderPopularImage extends RecyclerView.ViewHolder {
		@Bind( R.id.profile_image )
		CircleImageView    profileImage;
		@Bind( R.id.textViewPopularFeedName )
		AppCompatTextView  textViewPopularFeedName;
		@Bind( R.id.textViewPopularTime )
		AppCompatTextView  textViewPopularTime;
		@Bind( R.id.textViewPopularTitle )
		AppCompatTextView  textViewPopularTitle;
		@Bind( R.id.imageViewPopular )
		AppCompatImageView imageViewPopular;
		@Bind( R.id.imageViewUp )
		AppCompatImageView imageViewUp;
		@Bind( R.id.textViewUpDownCount )
		AppCompatTextView  textViewUpDownCount;
		@Bind( R.id.imageViewDown )
		AppCompatImageView imageViewDown;
		@Bind( R.id.textViewComments )
		AppCompatTextView  textViewComments;
		@Bind( R.id.textViewShare )
		AppCompatTextView  textViewShare;

		public ViewHolderPopularImage( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}


	public class ViewHolderPopularText extends RecyclerView.ViewHolder {
		@Bind( R.id.profile_image )
		CircleImageView    profileImage;
		@Bind( R.id.textViewPopularFeedName )
		AppCompatTextView  textViewPopularFeedName;
		@Bind( R.id.textViewPopularTime )
		AppCompatTextView  textViewPopularTime;
		@Bind( R.id.textViewPopularTitle )
		AppCompatTextView  textViewPopularTitle;
		@Bind( R.id.imageViewUp )
		AppCompatImageView imageViewUp;
		@Bind( R.id.textViewUpDownCount )
		AppCompatTextView  textViewUpDownCount;
		@Bind( R.id.imageViewDown )
		AppCompatImageView imageViewDown;
		@Bind( R.id.textViewComments )
		AppCompatTextView  textViewComments;
		@Bind( R.id.textViewShare )
		AppCompatTextView  textViewShare;

		public ViewHolderPopularText( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderMessage extends RecyclerView.ViewHolder {
		@Bind( R.id.textViewTitleMessage )
		AppCompatTextView  textViewTitleMessage;
		@Bind( R.id.textViewDescMessage )
		AppCompatTextView  textViewDescMessage;
		@Bind( R.id.imageViewUp )
		AppCompatImageView imageViewUp;
		@Bind( R.id.textViewUpDownCount )
		AppCompatTextView  textViewUpDownCount;
		@Bind( R.id.imageViewDown )
		AppCompatImageView imageViewDown;
		@Bind( R.id.textViewComments )
		AppCompatTextView  textViewComments;
		@Bind( R.id.textViewShare )
		AppCompatTextView  textViewShare;
		@Bind( R.id.layoutInc )
		LinearLayout       layoutFooterToolbar;

		public ViewHolderMessage( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderText extends RecyclerView.ViewHolder {

		@Bind( R.id.textViewMessageItem )
		AppCompatTextView textViewMessageItem;

		public ViewHolderText( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderImageWithText extends RecyclerView.ViewHolder {
		@Bind( R.id.imageViewProfileItem )
		CircleImageView   imageViewProfileItem;
		@Bind( R.id.textViewMessageItem )
		AppCompatTextView textViewMessageItem;
		@Bind( R.id.textViewDescItem )
		AppCompatTextView textViewDescItem;

		public ViewHolderImageWithText( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderImage extends RecyclerView.ViewHolder {
		@Bind( R.id.imageViewItem )
		AppCompatImageView imageViewItem;
		@Bind( R.id.tvImageTitle )
		AppCompatTextView  tvImageTitle;

		public ViewHolderImage( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderVideo extends RecyclerView.ViewHolder {
		@Bind( R.id.profile_image )
		CircleImageView    profileImage;
		@Bind( R.id.textViewPopularFeedName )
		AppCompatTextView  textViewPopularFeedName;
		@Bind( R.id.textViewPopularTime )
		AppCompatTextView  textViewPopularTime;
		@Bind( R.id.textViewPopularTitle )
		AppCompatTextView  textViewPopularTitle;
		@Bind( R.id.imageViewPopular )
		AppCompatImageView imageViewPopular;
		@Bind( R.id.imageViewUp )
		AppCompatImageView imageViewUp;
		@Bind( R.id.textViewUpDownCount )
		AppCompatTextView  textViewUpDownCount;
		@Bind( R.id.imageViewDown )
		AppCompatImageView imageViewDown;
		@Bind( R.id.textViewComments )
		AppCompatTextView  textViewComments;
		@Bind( R.id.textViewShare )
		AppCompatTextView  textViewShare;

		public ViewHolderVideo( View itemView ) {
			super( itemView );
			ButterKnife.bind( this, itemView );
		}
	}

	public class ViewHolderDefault extends RecyclerView.ViewHolder {

		public ViewHolderDefault( View itemView ) {
			super( itemView );
		}
	}


}

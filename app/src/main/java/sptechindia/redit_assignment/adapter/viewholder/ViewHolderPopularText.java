package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sptechindia.redit_assignment.R;

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
	public void setData(Object object) {
		updateUi();
	}

	private void updateUi(){

	}
}
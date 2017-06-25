package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;

public class ViewHolderMessage extends RecyclerView.ViewHolder {
	@Bind( R.id.textViewTitleMessage )
	public AppCompatTextView  textViewTitleMessage;
	@Bind( R.id.textViewDescMessage )
	public AppCompatTextView  textViewDescMessage;
	@Bind( R.id.imageViewUp )
	public AppCompatImageView imageViewUp;
	@Bind( R.id.textViewUpDownCount )
	public AppCompatTextView  textViewUpDownCount;
	@Bind( R.id.imageViewDown )
	public AppCompatImageView imageViewDown;
	@Bind( R.id.textViewComments )
	public AppCompatTextView  textViewComments;
	@Bind( R.id.textViewShare )
	public AppCompatTextView  textViewShare;
	@Bind( R.id.layoutInc )
	public LinearLayout       layoutFooterToolbar;

	public ViewHolderMessage( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}
	public void setData(Object object) {
		updateUi();
	}

	private void updateUi(){

	}
}
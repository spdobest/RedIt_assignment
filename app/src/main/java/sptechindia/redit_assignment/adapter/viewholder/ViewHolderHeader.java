package sptechindia.redit_assignment.adapter.viewholder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import sptechindia.redit_assignment.R;
import sptechindia.redit_assignment.model.ModelHeader;

public class ViewHolderHeader extends RecyclerView.ViewHolder {
	private static final String TAG = "ViewHolderHeader";
	@Bind( R.id.textViewName_header )
	AppCompatTextView textViewNameHeader;
	@Bind( R.id.textViewComment_header )
	AppCompatTextView textViewCommentHeader;
	private ModelHeader modelHeaderData;

	public ViewHolderHeader( View itemView ) {
		super( itemView );
		ButterKnife.bind( this, itemView );
	}

	public void setData( ModelHeader data ) {
		this.modelHeaderData = data;
		updateUi();
	}

	private void updateUi() {
		textViewNameHeader.setText( modelHeaderData.textTitle );
		textViewCommentHeader.setText( modelHeaderData.comment );
	}
}

	
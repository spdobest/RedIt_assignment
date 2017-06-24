package sptechindia.redit_assignment.controllers;

import sptechindia.redit_assignment.model.home.Child;

/**
 * Created by sibaprasad on 24/06/17.
 */

public interface OnRecyclerItemClickListener {
	public void onCommentClick( Child child );

	public void onFeedClick( Child child );

	public void onShareClick( Child child );

	public void onUpClick( Child child );

	public void onDownClick( Child child );
}

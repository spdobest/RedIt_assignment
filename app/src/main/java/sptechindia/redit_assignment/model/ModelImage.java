package sptechindia.redit_assignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class ModelImage implements Parcelable {
	public static final Creator< ModelImage > CREATOR = new Creator< ModelImage >() {
		@Override
		public ModelImage createFromParcel( Parcel source ) {
			return new ModelImage( source );
		}

		@Override
		public ModelImage[] newArray( int size ) {
			return new ModelImage[size];
		}
	};
	public              int                   rowType = Constants.ROW_IMAGE;
	String imageUrl;

	public ModelImage() {

	}


	public ModelImage( String imageUrl, int rowType ) {
		this.imageUrl = imageUrl;
		this.rowType = rowType;
	}

	protected ModelImage( Parcel in ) {
		this.imageUrl = in.readString();
		this.rowType = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel( Parcel dest, int flags ) {
		dest.writeString( this.imageUrl );
		dest.writeInt( this.rowType );
	}
}

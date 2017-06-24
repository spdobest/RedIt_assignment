package sptechindia.redit_assignment.model;

import android.os.Parcel;
import android.os.Parcelable;

import sptechindia.redit_assignment.utility.Constants;

/**
 * Created by sibaprasad on 23/06/17.
 */

public class ModelImageText implements Parcelable {
	public static final Creator< ModelImageText > CREATOR = new Creator< ModelImageText >() {
		@Override
		public ModelImageText createFromParcel( Parcel source ) {
			return new ModelImageText( source );
		}

		@Override
		public ModelImageText[] newArray( int size ) {
			return new ModelImageText[size];
		}
	};
	public              int                       rowType = Constants.ROW_IMAGE;
	String imageUrl;
	String title;

	public ModelImageText() {

	}


	public ModelImageText( String title, String imageUrl, int rowType ) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.rowType = rowType;

	}

	protected ModelImageText( Parcel in ) {
		this.title = in.readString();
		this.imageUrl = in.readString();
		this.rowType = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel( Parcel dest, int flags ) {
		dest.writeString( this.title );
		dest.writeString( this.imageUrl );
		dest.writeInt( this.rowType );
	}
}

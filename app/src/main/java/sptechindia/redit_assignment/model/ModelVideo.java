package sptechindia.redit_assignment.model;

/**
 * Created by sibaprasad on 25/06/17.
 */

public class ModelVideo {
	public String videoName;
	public String videoDesc;
	public String videoUrl;
	public String thumbNailUrl;

	public ModelVideo( String videoName, String videoDesc, String videoUrl, String thumbNailUrl ) {
		this.videoName = videoName;
		this.videoDesc = videoDesc;
		this.videoUrl = videoUrl;
		this.thumbNailUrl = thumbNailUrl;
	}
}

package movie4u.models;

import java.util.List;

public class Comments {
		private List<String> comments;
		private String mediaName;
		public Comments(List<String> comments,String MN) {
			super();
			this.comments = comments;
			this.setMediaName(MN);
		} 
		
		public void AddComment(String comment) {
			this.comments.add(comment);
		}

		public String getMediaName() {
			return mediaName;
		}

		public void setMediaName(String mediaName) {
			this.mediaName = mediaName;
		}

		public List<String> getComments() {
			return comments;
		}
		
		
		
		
}

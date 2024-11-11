package Files;

public class GetCourse {
	
	
	
	private String URL;
	private String Services;
	private String expertise;
	private String instructor;
	private coursespojo courses ;
	private String linkedIn;
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getServices() {
		return Services;
	}
	public void setServices(String services) {
		Services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public coursespojo getCourses() {
		return courses;
	}
	public void setCourses(coursespojo courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedin(String linkedIn) {
		this.linkedIn = linkedIn;
	}


}

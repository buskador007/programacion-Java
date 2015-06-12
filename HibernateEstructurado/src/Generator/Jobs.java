package Generator;
// default package
// Generated 11-jun-2015 16:11:55 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Jobs generated by hbm2java
 */
public class Jobs implements java.io.Serializable {

	private String jobId;
	private String jobTitle;
	private Integer minSalary;
	private Integer maxSalary;
	private Set employeeses = new HashSet(0);
	private Set jobHistories = new HashSet(0);

	public Jobs() {
	}

	public Jobs(String jobId, String jobTitle) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
	}

	public Jobs(String jobId, String jobTitle, Integer minSalary,
			Integer maxSalary, Set employeeses, Set jobHistories) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employeeses = employeeses;
		this.jobHistories = jobHistories;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Set getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set employeeses) {
		this.employeeses = employeeses;
	}

	public Set getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set jobHistories) {
		this.jobHistories = jobHistories;
	}

}

package Generator;
// default package
// Generated 11-jun-2015 16:11:55 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * JobHistory generated by hbm2java
 */
public class JobHistory implements java.io.Serializable {

	private JobHistoryId id;
	private Employees employees;
	private Departments departments;
	private Jobs jobs;
	private Date endDate;

	public JobHistory() {
	}

	public JobHistory(JobHistoryId id, Employees employees, Jobs jobs,
			Date endDate) {
		this.id = id;
		this.employees = employees;
		this.jobs = jobs;
		this.endDate = endDate;
	}

	public JobHistory(JobHistoryId id, Employees employees,
			Departments departments, Jobs jobs, Date endDate) {
		this.id = id;
		this.employees = employees;
		this.departments = departments;
		this.jobs = jobs;
		this.endDate = endDate;
	}

	public JobHistoryId getId() {
		return this.id;
	}

	public void setId(JobHistoryId id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Jobs getJobs() {
		return this.jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}

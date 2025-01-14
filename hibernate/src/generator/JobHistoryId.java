package generator;
// default package
// Generated 09-jun-2015 15:27:50 by Hibernate Tools 4.3.1

import java.util.Date;

/**
 * JobHistoryId generated by hbm2java
 */
public class JobHistoryId implements java.io.Serializable {

	private int employeeId;
	private Date startDate;

	public JobHistoryId() {
	}

	public JobHistoryId(int employeeId, Date startDate) {
		this.employeeId = employeeId;
		this.startDate = startDate;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JobHistoryId))
			return false;
		JobHistoryId castOther = (JobHistoryId) other;

		return (this.getEmployeeId() == castOther.getEmployeeId())
				&& ((this.getStartDate() == castOther.getStartDate()) || (this
						.getStartDate() != null
						&& castOther.getStartDate() != null && this
						.getStartDate().equals(castOther.getStartDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getEmployeeId();
		result = 37 * result
				+ (getStartDate() == null ? 0 : this.getStartDate().hashCode());
		return result;
	}

}

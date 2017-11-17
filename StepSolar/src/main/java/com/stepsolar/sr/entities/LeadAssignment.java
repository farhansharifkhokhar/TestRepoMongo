package com.stepsolar.sr.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;


@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeadAssignment {
	
	@Id
	private String id;

	@Column
    private String clientId;

	@Column
	private String assignedBy;

	@Column
	private String assignedTo;

	@Column (name = "_created_at")
	private Date createdAt;

	@Column (name = "_updated_at")
	private Date updatedAt;

    public LeadAssignment() {
    }

    public LeadAssignment(String clientId, String assignedBy, String assignedTo) {
        this.clientId   = clientId;
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.createdAt  = Date.from(Instant.now());
        this.updatedAt  = Date.from(Instant.now());
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    @Override
    public String toString() {
        return "LeadAssignment{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", assignedBy='" + assignedBy + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

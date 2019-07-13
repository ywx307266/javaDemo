package com.fox.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="node")
public class NodeInfo
{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="nodeId")
	@SequenceGenerator(name="nodeId",sequenceName="seq_id")
	private String nodeId;
	
	@Column(name="node_name",length=90,nullable=false)
	private String nodeName;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="isValid")
	private boolean isValid;
	
	@Column(name="delete_date")
	private Date delDate;

	public String getNodeId()
	{
		return nodeId;
	}

	public void setNodeId(String nodeId)
	{
		this.nodeId = nodeId;
	}

	public String getNodeName()
	{
		return nodeName;
	}

	public void setNodeName(String nodeName)
	{
		this.nodeName = nodeName;
	}

	public Date getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}

	public boolean isValid()
	{
		return isValid;
	}

	public void setValid(boolean isValid)
	{
		this.isValid = isValid;
	}

	public Date getDelDate()
	{
		return delDate;
	}

	public void setDelDate(Date delDate)
	{
		this.delDate = delDate;
	}

	public NodeInfo() {
		super();
	}
	
}

package xyz.casualcookie.ponyslayer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity class for adventure
 * @author mpinto
 *
 */
@Entity
@Table(name="ADVENTURE")
public class Adventure extends DomainObjectEntity{
	private static final long serialVersionUID = 1L;

	@Column(name="event_id")
	private Long eventId;
	
//	@NotBlank
//	@Column(name="time_start")
//	private Instant timeStart;
//	
//	@Column(name="time_end")
//	private Instant timeEnd;
	
	@Min(value=1)
	@Max(value=99)
	@NotBlank
	@Column(name="slot_min")
	private int slotMin;
	
	@Min(value=1)
	@Max(value=99)
	@NotBlank
	@Column(name="slot_max")
	private int slotMax;

	@NotBlank(message="{validation.empty}")
	@Column(name="dmName")
	private String dmName;
	
	@NotBlank
	@Column(name="title")
	private String title;
	
	@NotBlank
	@Column(name="system")
	private String system;

	/*
	@Column(name="subtitle")
	private String subtitle;*/
	
	@Column(name="synopsis")
	private String synopsis;
	
	@Column(name="image")
	private String image;
	
	public Adventure(){}
	
	
	/* Getters and Setters */
//	public Instant getTimeStart() {
//		return timeStart;
//	}
//
//	public void setTimeStart(Instant timeStart) {
//		this.timeStart = timeStart;
//	}

//	public String getSubtitle() {
//		return subtitle;
//	}
//
//
//	public void setSubtitle(String subtitle) {
//		this.subtitle = subtitle;
//	}


	public Long getEventID() {
		return eventId;
	}


	public void setEventID(long eventId) {
		this.eventId = eventId;
	}

//	public Instant getTimeEnd() {
//		return timeEnd;
//	}
//
//	public void setTimeEnd(Instant timeEnd) {
//		this.timeEnd = timeEnd;
//	}

	public String getDmName() {
		return dmName;
	}

	public void setDmName(String dmName) {
		this.dmName = dmName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSlotMin() {
		return slotMin;
	}

	public void setSlotMin(int slotMin) {
		this.slotMin = slotMin;
	}

	public int getSlotMax() {
		return slotMax;
	}

	public void setSlotMax(int slotMax) {
		this.slotMax = slotMax;
	}

//	public String getAdventureSubTitle() {
//		return subtitle;
//	}

	
}

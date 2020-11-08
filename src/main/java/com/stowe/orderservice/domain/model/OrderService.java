package com.stowe.orderservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class OrderService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Client client;
	
	@NotNull
	private BigDecimal price;
	
	@NotBlank
	private String description;
	
	@Enumerated(EnumType.STRING)
	private StatusOrderService status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime openingDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime endingDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StatusOrderService getStatus() {
		return status;
	}
	public void setStatus(StatusOrderService status) {
		this.status = status;
	}
	public LocalDateTime getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	public LocalDateTime getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(LocalDateTime endingDate) {
		this.endingDate = endingDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderService other = (OrderService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
